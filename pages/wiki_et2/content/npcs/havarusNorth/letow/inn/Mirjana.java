package com.cnx.endlesstalestwo.data.npcs.havarusNorth.letow.inn;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Mirjana extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Mirjana");
        npc.age = 26;
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // ===== ROLEPLAY: About her life =====
        ConversationOption cvRoleplay = new ConversationOption(0, 0);
        cvRoleplay.addOptionText(ENGLISH, "How is life in Letow?", "Quiet, mostly. It's a small village, nothing like the grand cities. We have our fields, our inn, and each other. Sometimes that's all you need.");
        cvRoleplay.addOptionText(PORTUGUESE, "Como é a vida em Letow?", "Tranquila, na maior parte. É uma vila pequena, nada como as grandes cidades. Temos nossos campos, nossa taverna, e uns aos outros. Às vezes é tudo que precisamos.");
        cvRoleplay.addOptionText(SPANISH, "¿Cómo es la vida en Letow?", "Tranquila, mayormente. Es una aldea pequeña, nada como las grandes ciudades. Tenemos nuestros campos, nuestra posada, y el uno al otro. A veces eso es todo lo que necesitas.");
        npc.conversationOptions.add(cvRoleplay);

        // ===== QUEST START: Ghost & Bones =====
        ConversationOption cvQuestStart = new ConversationOption(0, 1);
        cvQuestStart.addOptionText(ENGLISH, "You look troubled. What's wrong?", "*She glances nervously at the shadows*\nI... I haven't slept properly in weeks. Every night, when darkness falls, I feel... watched. Sometimes I see him in my dreams - a figure in the mist, calling my name.\n\n*Her hands tremble slightly*\n\nThe old women in the village say it's a ghost. They say spirits haunt the swamps near here. I'm terrified, traveler. What if it's real? What if something from the dead world wants... me?");
        cvQuestStart.addOptionText(PORTUGUESE, "Você parece perturbada. O que há de errado?", "*Ela olha nervosamente para as sombras*\nEu... não durmo direito há semanas. Toda noite, quando a escuridão cai, eu me sinto... observada. Às vezes o vejo em meus sonhos - uma figura na névoa, chamando meu nome.\n\n*Suas mãos tremem levemente*\n\nAs velhas da vila dizem que é um fantasma. Dizem que espíritos assombram os pântanos perto daqui. Estou aterrorizada, viajante. E se for real? E se algo do mundo dos mortos quiser... eu?");
        cvQuestStart.addOptionText(SPANISH, "Pareces perturbada. ¿Qué pasa?", "*Mira nerviosamente hacia las sombras*\nYo... no he dormido bien en semanas. Cada noche, cuando cae la oscuriddd, me siento... observada. A veces lo veo en mis sueños - una figura en la niebla, llamando mi nombre.\n\n*Sus manos tiemblan ligeramente*\n\nLas ancianas del pueblo dicen que es un fantasma. Dicen que los espíritus acechan los pantanos cerca de aquí. Estoy aterrorizada, viajero. ¿Y si es real? ¿Y si algo del mundo de los muertos me quiere... a mí?");
        cvQuestStart.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.GHOST_BONES, chara) && LibQuest.charHasQuest(QuestsIds.OVERSEAS_RECOGNITION, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestStart);

        ConversationOption cvQuestAccept = new ConversationOption(1, 0);
        cvQuestAccept.addOptionText(ENGLISH, "I'll investigate these swamps for you.", "*Hope flickers in her frightened eyes*\nYou would? Truly? I... I would be so grateful. The swamps are dangerous at night, but they say ghosts only appear in darkness, between the late evening and dawn. If you could just... find out what's haunting me. Please.");
        cvQuestAccept.addOptionText(PORTUGUESE, "Vou investigar esses pântanos para você.", "*Esperança brilha em seus olhos assustados*\nVocê faria isso? De verdade? Eu... seria tão grata. Os pântanos são perigosos à noite, mas dizem que fantasmas só aparecem na escuridão, entre o fim da noite e a madrugada. Se você pudesse apenas... descobrir o que está me assombrando. Por favor.");
        cvQuestAccept.addOptionText(SPANISH, "Investigaré esos pantanos para ti.", "*La esperanza brilla en sus ojos asustados*\n¿Lo harías? ¿De verdad? Yo... estaría tan agradecida. Los pantanos son peligrosos por la noche, pero dicen que los fantasmas solo aparecen en la oscuridad, entre el final de la tarde y el amanecer. Si pudieras simplemente... descubrir qué me está atormentando. Por favor.");
        cvQuestAccept.listeners = (ctx, fragment) -> LibQuest.includeQuestToQuestbook(QuestsIds.GHOST_BONES, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvQuestAccept);

        // ===== QUEST PART 2: Player returns after finding the ghost =====
        ConversationOption cvPart2 = new ConversationOption(0, 2);
        cvPart2.addOptionText(ENGLISH, "I found the ghost. His name is Dmitri.", "*All color drains from her face*\n\nDmitri? No... no, it can't be...\n\n*She staggers backward, gripping the table for support*\n\nDmitri was... he was my love. Eight years ago. He went to the swamps to gather herbs and hunt. He never came back. Days later, his body washed up on the shore near here. We buried him in the Cemetery.\n\n*Tears stream down her face*\n\nWhy? Why does he haunt me? I mourned him! I wept for months! What more does his spirit want from me?");
        cvPart2.addOptionText(PORTUGUESE, "Encontrei o fantasma. Seu nome é Dmitri.", "*Toda cor desaparece de seu rosto*\n\nDmitri? Não... não, não pode ser...\n\n*Ela cambaleia para trás, segurando a mesa para se apoiar*\n\nDmitri era... ele era meu amor. Oito anos atrás. Ele foi aos pântanos para coletar ervas e caçar. Ele nunca voltou. Dias depois, seu corpo apareceu na praia perto daqui. Nós o enterramos no Cemitério.\n\n*Lágrimas escorrem por seu rosto*\n\nPor quê? Por que ele me assombra? Eu o chorei! Chorei por meses! O que mais o espírito dele quer de mim?");
        cvPart2.addOptionText(SPANISH, "Encontré al fantasma. Su nombre es Dmitri.", "*Todo el color desaparece de su rostro*\n\n¿Dmitri? No... no, no puede ser...\n\n*Se tambalea hacia atrás, agarrándose a la mesa para apoyarse*\n\nDmitri era... era mi amor. Hace ocho años. Fue a los pantanos a recolectar hierbas y cazar. Nunca regresó. Días después, su cuerpo apareció en la orilla cerca de aquí. Lo enterramos en el Cementerio.\n\n*Las lágrimas corren por su rostro*\n\n¿Por qué? ¿Por qué me atormenta? ¡Lo lloré! ¡Lloré durante meses! ¿Qué más quiere su espíritu de mí?");
        cvPart2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GHOST_BONES, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPart2);

        ConversationOption cvPart2Response = new ConversationOption(2, 0);
        cvPart2Response.addOptionText(ENGLISH, "What would you like me to do?", "*She wipes her tears with shaking hands*\nI... I can't face him. I can't see his ghost. It's too much.\n\n*Her voice becomes desperate*\n\nPlease, traveler. Go to the Cemetery. Burn his bones. It's the only way to release a spirit - destroy what binds them to this world. Once his bones are ash, his ghost will be gone forever and I... Dmitri and I can finally have peace.\n\nPlease. Do this for me.");
        cvPart2Response.addOptionText(PORTUGUESE, "O que você gostaria que eu fizesse?", "*Ela enxuga as lágrimas com mãos trêmulas*\nEu... não posso encará-lo. Não posso ver seu fantasma. É demais.\n\n*Sua voz se torna desesperada*\n\nPor favor, viajante. Vá ao Cemitério. Queime seus ossos. É a única maneira de libertar um espírito - destruir o que os prende a este mundo. Uma vez que seus ossos sejam cinzas, seu fantasma desaparecerá para sempre e eu... Dmitri e eu finalmente poderemos ter paz.\n\nPor favor. Faça isso por mim.");
        cvPart2Response.addOptionText(SPANISH, "¿Qué te gustaría que hiciera?", "*Se seca las lágrimas con manos temblorosas*\nYo... no puedo enfrentarlo. No puedo ver su fantasma. Es demasiado.\n\n*Su voz se vuelve desesperada*\n\nPor favor, viajero. Ve al Cementerio. Quema sus huesos. Es la única manera de liberar un espíritu - destruir lo que los ata a este mundo. Una vez que sus huesos sean cenizas, su fantasma desaparecerá para siempre y yo... Dmitri y yo finalmente podremos tener paz.\n\nPor favor. Haz esto por mí.");
        cvPart2Response.listeners = (ctx, fragment) -> LibQuest.updateQuest(QuestsIds.GHOST_BONES, 3, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvPart2Response);

        // ===== QUEST PART 4: Return after speaking with Dmitri =====
        ConversationOption cvPart4Start = new ConversationOption(0, 3);
        cvPart4Start.addOptionText(ENGLISH, "I spoke with Dmitri again...", "*She looks up, fear mixed with curiosity*\nYou... you spoke with him? What did he say?");
        cvPart4Start.addOptionText(PORTUGUESE, "Falei com Dmitri novamente...", "*Ela olha para cima, medo misturado com curiosidade*\nVocê... você falou com ele? O que ele disse?");
        cvPart4Start.addOptionText(SPANISH, "Hablé con Dmitri otra vez...", "*Levanta la mirada, miedo mezclado con curiosidad*\n¿Tú... hablaste con él? ¿Qué dijo?");
        cvPart4Start.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GHOST_BONES, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPart4Start);

        // CHOICE 1: Convince her (Charisma 16+)
        ConversationOption cvPart4Convince = new ConversationOption(3, 4);
        cvPart4Convince.addOptionText(ENGLISH, "[Persuade] He only wants to say goodbye (Charisma 16)", "*She listens quietly, her eyes filling with tears*\nHe... he went there for us? And bandits killed him?\n\n*She covers her mouth, trembling*\n\nAll this time I thought he abandoned me. I was angry for so long... but he never chose to leave. He was taken from me.\n\n*Her voice breaks*\n\nAnd he's been trapped here for eight years, unable to rest, because of words left unsaid. Because of a farewell we never had.");
        cvPart4Convince.addOptionText(PORTUGUESE, "[Persuadir] Ele só quer se despedir (Carisma 16)", "*Ela ouve em silêncio, os olhos enchendo de lágrimas*\nEle... ele foi lá por nós? E bandidos o mataram?\n\n*Ela cobre a boca, tremendo*\n\nO tempo todo pensei que ele tinha me abandonado. Fiquei com raiva por tanto tempo... mas ele nunca escolheu partir. Ele foi tirado de mim.\n\n*Sua voz falha*\n\nE ele ficou preso aqui por oito anos, sem poder descansar, por causa de palavras não ditas. Por causa de uma despedida que nunca aconteceu.");
        cvPart4Convince.addOptionText(SPANISH, "[Persuadir] Solo quiere despedirse (Carisma 16)", "*Escucha en silencio, sus ojos llenándose de lágrimas*\n¿Él... fue allí por nosotros? ¿Y los bandidos lo mataron?\n\n*Se cubre la boca, temblando*\n\nTodo este tiempo pensé que me había abandonado. Estuve enojada tanto tiempo... pero él nunca eligió irse. Me lo arrebataron.\n\n*Su voz se quiebra*\n\nY ha estado atrapado aquí durante ocho años, sin poder descansar, por palabras no dichas. Por una despedida que nunca ocurrió.");
        cvPart4Convince.requirementValidations = (chara, ctx) -> {
            int charisma = chara.attributesManager.getCurrent(Enums.AttributeName.CHARISMA);
            if (charisma >= 16) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_ATTRIBUTES;
        };
        cvPart4Convince.showEvenWhenNotValid = true;
        npc.conversationOptions.add(cvPart4Convince);

        ConversationOption cvPart4ConvinceSuccess = new ConversationOption(4, 0);
        cvPart4ConvinceSuccess.addOptionText(ENGLISH, "*Wait for her response*", "*Long silence. Tears continue to fall*\n\nI... I was so angry. Angry that he left. Angry that he died. Angry that I was left alone. But you're right... he never chose this. The bandits took him from me.\n\n*She takes a deep, shaking breath*\n\nTell him... tell him I'll meet him. Tomorrow night. I'll face his ghost and... and we'll both say our goodbyes properly. It's time to let go of the past.");
        cvPart4ConvinceSuccess.addOptionText(PORTUGUESE, "*Aguardar sua resposta*", "*Longo silêncio. Lágrimas continuam a cair*\n\nEu... eu estava tão irritada. Irritada porque ele partiu. Irritada porque ele morreu. Irritada por ter ficado sozinha. Mas você está certo... ele nunca escolheu isso. Os bandidos o tiraram de mim.\n\n*Ela respira fundo, tremendo*\n\nDiga a ele... diga que vou encontrá-lo. Amanhã à noite. Vou enfrentar seu fantasma e... e nós dois vamos nos despedir adequadamente. É hora de deixar o passado para trás.");
        cvPart4ConvinceSuccess.addOptionText(SPANISH, "*Esperar su respuesta*", "*Largo silencio. Las lágrimas continúan cayendo*\n\nYo... estaba tan enojada. Enojada porque se fue. Enojada porque murió. Enojada por quedarme sola. Pero tienes razón... él nunca eligió esto. Los bandidos me lo quitaron.\n\n*Respira profundamente, temblando*\n\nDile... dile que me reuniré con él. Mañana por la noche. Enfrentaré su fantasma y... y ambos nos despediremos adecuadamente. Es hora de dejar ir el pasado.");
        cvPart4ConvinceSuccess.listeners = (ctx, fragment) -> LibQuest.updateQuest(QuestsIds.GHOST_BONES, 7, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvPart4ConvinceSuccess);

        // CHOICE 2: Agree to burn bones
        ConversationOption cvPart4Burn = new ConversationOption(3, 0);
        cvPart4Burn.addOptionText(ENGLISH, "I'll burn his bones as you wish.", "*Relief washes over her face*\nThank you. I know it seems cruel, but I can't... I just can't face him. The Cemetery is just outside the village. Please, end this nightmare.");
        cvPart4Burn.addOptionText(PORTUGUESE, "Vou queimar seus ossos como você deseja.", "*Alívio toma conta de seu rosto*\nObrigada. Sei que parece cruel, mas eu não posso... simplesmente não posso encará-lo. O Cemitério fica logo fora da vila. Por favor, acabe com esse pesadelo.");
        cvPart4Burn.addOptionText(SPANISH, "Quemaré sus huesos como deseas.", "*El alivio inunda su rostro*\nGracias. Sé que parece cruel, pero no puedo... simplemente no puedo enfrentarlo. El Cementerio está justo afuera del pueblo. Por favor, termina con esta pesadilla.");
        cvPart4Burn.listeners = (ctx, fragment) -> LibQuest.updateQuest(QuestsIds.GHOST_BONES, 5, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvPart4Burn);

        // CHOICE 3: Wait/Think about it
        ConversationOption cvPart4Wait = new ConversationOption(3, 0);
        cvPart4Wait.addOptionText(ENGLISH, "I'll think about what to do.", "*She nods, understanding but still frightened*\nPlease... don't take too long. Every night he haunts me is another night I can't sleep.");
        cvPart4Wait.addOptionText(PORTUGUESE, "Vou pensar sobre o que fazer.", "*Ela acena, compreendendo mas ainda assustada*\nPor favor... não demore muito. Cada noite que ele me assombra é outra noite que não consigo dormir.");
        cvPart4Wait.addOptionText(SPANISH, "Pensaré qué hacer.", "*Asiente, comprendiendo pero aún asustada*\nPor favor... no tardes mucho. Cada noche que me atormenta es otra noche que no puedo dormir.");
        npc.conversationOptions.add(cvPart4Wait);

        // ===== QUEST PART 6: After burning bones =====
        ConversationOption cvPart6 = new ConversationOption(0, 0);
        cvPart6.addOptionText(ENGLISH, "It's done. I burned Dmitri's bones.", "*She closes her eyes, a mix of relief and sadness*\n\nIt's... it's over then. He's truly gone. Forever.\n\n*She sits down heavily*\n\nI know this was necessary, but part of me... part of me wanted to face him one more time. To say I'm sorry too. But fear won.\n\n*She hands you a pouch of gold*\n\nThank you for freeing me from this torment. I hope... I hope he found peace in the end.");
        cvPart6.addOptionText(PORTUGUESE, "Está feito. Queimei os ossos de Dmitri.", "*Ela fecha os olhos, uma mistura de alívio e tristeza*\n\nAcabou... acabou então. Ele realmente se foi. Para sempre.\n\n*Ela se senta pesadamente*\n\nSei que isso era necessário, mas parte de mim... parte de mim queria encará-lo mais uma vez. Para dizer que também sinto muito. Mas o medo venceu.\n\n*Ela lhe entrega uma bolsa de ouro*\n\nObrigada por me libertar desse tormento. Espero... espero que ele tenha encontrado paz no final.");
        cvPart6.addOptionText(SPANISH, "Está hecho. Quemé los huesos de Dmitri.", "*Cierra los ojos, una mezcla de alivio y tristeza*\n\nSe... se acabó entonces. Realmente se ha ido. Para siempre.\n\n*Se sienta pesadamente*\n\nSé que esto era necesario, pero parte de mí... parte de mí quería enfrentarlo una vez más. Para decir que también lo siento. Pero el miedo ganó.\n\n*Te entrega una bolsa de oro*\n\nGracias por liberarme de este tormento. Espero... espero que haya encontrado paz al final.");
        cvPart6.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GHOST_BONES, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPart6.listeners = (ctx, fragment) -> {
            LibQuest.updateQuest(QuestsIds.GHOST_BONES, 8, App.getPlayerChar(), ctx);
            LibQuest.completeQuest(QuestsIds.GHOST_BONES, App.getPlayerChar(), 8, ctx);
        };
        npc.conversationOptions.add(cvPart6);

        // ===== AFTER QUEST: Burned bones ending =====
        // ===== AFTER QUEST: Generic conversation after quest completion =====
        ConversationOption cvAfterQuest = new ConversationOption(0, 0);
        cvAfterQuest.addOptionText(ENGLISH, "How are you feeling now?", "Better. Much better. I can finally sleep peacefully at night. The spirit situation is resolved, and I feel... at peace. Thank you for everything you did for me.");
        cvAfterQuest.addOptionText(PORTUGUESE, "Como você está se sentindo agora?", "Melhor. Muito melhor. Finalmente consigo dormir tranquila à noite. A situação com o espírito está resolvida, e me sinto... em paz. Obrigada por tudo que fez por mim.");
        cvAfterQuest.addOptionText(SPANISH, "¿Cómo te sientes ahora?", "Mejor. Mucho mejor. Finalmente puedo dormir tranquila por la noche. La situación con el espíritu está resuelta, y me siento... en paz. Gracias por todo lo que hiciste por mí.");
        cvAfterQuest.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.GHOST_BONES)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAfterQuest);

        // ========================================
        // QUEST: FISHES DELIVERY — PART 5 (Letow)
        // ========================================

        ConversationOption cvFishPart5 = new ConversationOption(0, 0);
        cvFishPart5.addOptionText(ENGLISH, "Jack the fisherman sent this bucket of fresh fish for you.",
                "*Her eyes light up*\nOh! Jack remembered us! We do not get fresh fish very often here in Letow — we mostly eat salted stock. This is a real treat for the inn guests.\nThank you so much for making the trip here. Please pass on my warmest regards to Jack.");
        cvFishPart5.addOptionText(PORTUGUESE, "Jack o pescador enviou este balde de peixe fresco para você.",
                "*Os olhos dela brilham*\nOh! Jack se lembrou de nós! Não recebemos peixe fresco com muita frequência aqui em Letow — na maioria das vezes comemos estoque salgado. Isso é uma verdadeira surpresa para os hóspedes da pousada.\nMuito obrigada por fazer a viagem até aqui. Por favor, passe meus mais calorosos cumprimentos para Jack.");
        cvFishPart5.addOptionText(SPANISH, "Jack el pescador envió este cubo de pescado fresco para ti.",
                "*Sus ojos se iluminan*\n¡Oh! ¡Jack nos recordó! No recibimos pescado fresco muy a menudo aquí en Letow — principalmente comemos provisiones en salazón. Esto es un verdadero regalo para los huéspedes de la posada.\nMuchas gracias por hacer el viaje aquí. Por favor, transmítele mis más cálidos saludos a Jack.");
        cvFishPart5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FISHES_DELIVERY, 5)
                    && LibInventory.checkHasItem(ItemsIds.BUCKET_OF_FISHES, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvFishPart5.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.BUCKET_OF_FISHES, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.FISHES_DELIVERY, 6, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFishPart5);

        return npc;
    }
}