package com.cnx.endlesstalestwo.data.npcs.growrocks.oreFortress;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class ElliotShinefingers extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Elliot Shinefingers");
        npc.age = 33;
        npc.job = Enums.NPCJobs.MINER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "He neither loves nor hates his work, but he is good at it.\nHe loves his family; he has two siblings, Traus and Kamala. He is loyal and has faith in his culture's deities.\nBrave, but aware of his limits.\n\nHis physical traits: Black hair, beard and mustache, brown eyes, fair bright skin, and large ears.");
        npc.addDescriptionTranslation(PORTUGUESE, "Não ama nem odeia seu trabalho, mas é bom no que faz.\nAma sua família, tem 2 irmãos, Traus e Kamala. É leal e tem fé nas divindades da sua cultura\nCorajoso, mas sabe o limite de suas capacidades.\n\nSeus traços físicos: Cabelo, barba e bigode pretos. Olhos castanhos e pele clara e brilhosa. Orelhas grandes.");
        npc.addDescriptionTranslation(SPANISH, "No ama ni odia su trabajo, pero es bueno en lo que hace.\nAma a su familia; tiene 2 hermanos, Traus y Kamala. Es leal y tiene fe en las divinidades de su cultura.\nValiente, pero conoce el límite de sus capacidades.\n\nSus rasgos físicos: Cabello, barba y bigote negros, ojos castaños, piel clara y brillante, y orejas grandes.");

        //this NPC is brother of NPCs KamalaShinefingers and TrausShinefingers

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hello, friend."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá, amigo."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola, amigo."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Safe travels."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Viagem segura."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Viaje seguro."));

        // ===== ROLEPLAY: About mining =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "How is the mining work?", "Ore Fortress is the finest mine in all the kingdoms - rich veins of rare crystals and precious metals. But it's also dangerous. The deeper you go, the more aggressive the creatures become. We dwarves know how to handle ourselves, but... not everyone comes back.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Como está o trabalho de mineração?", "O forte do minério é a melhor mina em todos os reinos - veios ricos de cristais raros e metais preciosos. Mas também é perigosa. Quanto mais fundo você vai, mais agressivas as criaturas se tornam. Nós anões sabemos como nos cuidar, mas... nem todos voltam.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cómo va el trabajo de minería?", "Ore Fortress es la mejor mina en todos los reinos: vetas ricas de cristales raros y metales preciosos. Pero también es peligrosa. Cuanto más profundo vas, más agresivas se vuelven las criaturas. Los enanos sabemos cómo cuidarnos, pero... no todos regresan.");
        cvRoleplay1.requirementValidations = (chara, ctx) -> {
            // Only show before quest starts
            if (!LibQuest.charHasQuest(QuestsIds.LOST_BROTHER, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY: About life as a miner at Ore Fortress =====
        ConversationOption cvRoleplayMiner = new ConversationOption(0, 0);
        cvRoleplayMiner.addOptionText(ENGLISH, "What is it like to be a miner here at Ore Fortress?",
                "It's hard to put into words. Every morning you grab your pickaxe, descend into the dark, and leave the world above behind. The air smells of dust and iron. Your lantern is your only companion most of the time.\n*pauses, looking at his hands*\nBut when you strike a vein and the crystals catch the light... there's no feeling quite like it. We dwarves say: the stone gives to those who respect it. I believe that.");
        cvRoleplayMiner.addOptionText(PORTUGUESE, "Como é ser minerador aqui no Forte do Minério?",
                "É difícil colocar em palavras. Todo dia de manhã você pega seu picareta, desce para o escuro e deixa o mundo lá em cima para trás. O ar cheira a poeira e ferro. Sua lanterna é sua única companheira na maior parte do tempo.\n*pausa, olhando para as mãos*\nMas quando você acerta um veio e os cristais captam a luz... não existe sensação igual. Nós anões dizemos: a pedra dá para aqueles que a respeitam. Eu acredito nisso.");
        cvRoleplayMiner.addOptionText(SPANISH, "¿Cómo es ser minero aquí en la Fortaleza del Mineral?",
                "Es difícil de expresar con palabras. Cada mañana tomas tu pico, bajas a la oscuridad y dejas el mundo de arriba atrás. El aire huele a polvo y hierro. Tu linterna es tu única compañera la mayor parte del tiempo.\n*pausa, mirando sus manos*\nPero cuando golpeas una veta y los cristales atrapan la luz... no hay sensación igual. Los enanos decimos: la piedra da a quienes la respetan. Yo lo creo.");
        npc.conversationOptions.add(cvRoleplayMiner);

        // ===== ROLEPLAY: About his family =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Do you have family?", "Aye, I have two siblings - Kamala, my sister, and Traus, my older brother. We're all Shinefingers - a proud mining family. Been working these mines for three generations. Mining is in our blood.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Você tem família?", "Sim, tenho dois irmãos - Kamala, minha irmã, e Traus, meu irmão mais velho. Somos todos Shinefingers - uma orgulhosa família de mineradores. Trabalhamos nestas minas há três gerações. Minerar está em nosso sangue.");
        cvRoleplay2.addOptionText(SPANISH, "¿Tienes familia?", "Sí, tengo dos hermanos: Kamala, mi hermana, y Traus, mi hermano mayor. Todos somos Shinefingers, una orgullosa familia de mineros. Hemos trabajado en estas minas durante tres generaciones. La minería está en nuestra sangre.");
        cvRoleplay2.requirementValidations = (chara, ctx) -> {
            // Only show before quest starts
            if (!LibQuest.charHasQuest(QuestsIds.LOST_BROTHER, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay2);

        // ===== QUEST: Lost Brother - Introduction =====
        ConversationOption cvQuest1 = new ConversationOption(0, 1);
        cvQuest1.addOptionText(ENGLISH, "You look worried. Is something wrong?", "*Looks up with desperate eyes*\nMy brother... Traus... he went down to the second floor three days ago to mine rare blue crystals. He should have been back the same day, but... \n*voice trembles*\nHe hasn't returned. I've tried to go after him, but the creatures on that level are too strong for me alone.");
        cvQuest1.addOptionText(PORTUGUESE, "Você parece preocupado. Há algo errado?", "*Olha para cima com olhos desesperados*\nMeu irmão... Traus... ele foi até o segundo andar há três dias para minerar cristais azuis raros. Ele deveria ter voltado no mesmo dia, mas... \n*voz tremula*\nEle não retornou. Tentei ir atrás dele, mas as criaturas naquele nível são fortes demais para mim sozinho.");
        cvQuest1.addOptionText(SPANISH, "Pareces preocupado. ¿Pasa algo?", "*Levanta la vista con ojos desesperados*\nMi hermano... Traus... bajó al segundo piso hace tres días para minar cristales azules raros. Debería haber regresado el mismo día, pero... \n*voz temblorosa*\nNo ha vuelto. Intenté ir tras él, pero las criaturas en ese nivel son demasiado fuertes para mí solo.");
        cvQuest1.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.LOST_BROTHER, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuest1);

        ConversationOption cvQuest2 = new ConversationOption(1, 2);
        cvQuest2.addOptionText(ENGLISH, "I can help you find him.", "*Grabs your hands gratefully*\nYou would? By the stone gods, thank you! Traus is stubborn and experienced, but the second floor... it's a death trap. Ore beetles, stone golems, cave serpents - all vicious. Please, search the deepest parts of floor two. If he's alive, he'll be hiding somewhere safe. Bring him back to me... please.");
        cvQuest2.addOptionText(PORTUGUESE, "Posso ajudá-lo a encontrá-lo.", "*Segura suas mãos gratamente*\nVocê faria isso? Pelos deuses da pedra, obrigado! Traus é teimoso e experiente, mas o segundo andar... é uma armadilha mortal. Besouros de minério, golems de pedra, serpentes de caverna - todos cruéis. Por favor, procure nas partes mais profundas do andar dois. Se ele estiver vivo, estará se escondendo em algum lugar seguro. Traga-o de volta para mim... por favor.");
        cvQuest2.addOptionText(SPANISH, "Puedo ayudarte a encontrarlo.", "*Agarra tus manos agradecido*\n¿Lo harías? ¡Por los dioses de la piedra, gracias! Traus es terco y experimentado, pero el segundo piso... es una trampa mortal. Escarabajos de mineral, gólems de piedra, serpientes de caverna, todos viciosos. Por favor, busca en las partes más profundas del piso dos. Si está vivo, estará escondido en algún lugar seguro. Tráemelo de vuelta... por favor.");
        npc.conversationOptions.add(cvQuest2);

        ConversationOption cvQuest3 = new ConversationOption(2, 0);
        cvQuest3.addOptionText(ENGLISH, "I'll find your brother.", "Thank you... thank you so much. Be careful down there. Those creatures show no mercy. And... if you find Traus hurt, just... get him out alive. That's all I ask.");
        cvQuest3.addOptionText(PORTUGUESE, "Vou encontrar seu irmão.", "Obrigado... muito obrigado. Tenha cuidado lá embaixo. Essas criaturas não mostram misericórdia. E... se você encontrar Traus ferido, apenas... tire-o de lá vivo. É tudo que peço.");
        cvQuest3.addOptionText(SPANISH, "Encontraré a tu hermano.", "Gracias... muchas gracias. Ten cuidado allí abajo. Esas criaturas no muestran piedad. Y... si encuentras a Traus herido, solo... sácalo vivo. Es todo lo que pido.");
        cvQuest3.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.LOST_BROTHER, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuest3);

        // ===== QUEST: Lost Brother - Part 2 (Return with Traus) =====
        ConversationOption cvReturn = new ConversationOption(0, 3);
        cvReturn.addOptionText(ENGLISH, "I found Traus! He's alive!", "*Eyes widen with shock and joy*\nALIVE?! You... you found him?! \n*tears stream down his face*\nThank the stone gods! Is he hurt? Where is he? Can he walk?");
        cvReturn.addOptionText(PORTUGUESE, "Encontrei Traus! Ele está vivo!", "*Olhos se arregalam com choque e alegria*\nVIVO?! Você... você o encontrou?! \n*lágrimas escorrem por seu rosto*\nGraças aos deuses da pedra! Ele está ferido? Onde ele está? Ele pode andar?");
        cvReturn.addOptionText(SPANISH, "¡Encontré a Traus! ¡Está vivo!", "*Los ojos se abren con sorpresa y alegría*\n¿VIVO?! ¿Lo... lo encontraste?! \n*lágrimas corren por su rostro*\n¡Gracias a los dioses de la piedra! ¿Está herido? ¿Dónde está? ¿Puede caminar?");
        cvReturn.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.LOST_BROTHER, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvReturn);

        ConversationOption cvReunion = new ConversationOption(3, 0);
        cvReunion.addOptionText(ENGLISH, "He's injured but alive. He can walk with help.", "*Embraces you tightly*\nYou saved my brother's life! The Shinefingers family owes you a debt we can never fully repay. Traus is all the family I have left besides Kamala. You've given me back my brother. \n*wipes tears*\nTake this reward - it's all I can offer, but know that you'll always have a friend in Elliot Shinefingers. May the stone gods bless your path, hero.");
        cvReunion.addOptionText(PORTUGUESE, "Ele está ferido mas vivo. Ele pode andar com ajuda.", "*Te abraça fortemente*\nVocê salvou a vida do meu irmão! A família Shinefingers te deve uma dívida que nunca poderemos pagar completamente. Traus é toda a família que me resta além de Kamala. Você me devolveu meu irmão. \n*enxuga as lágrimas*\nPegue esta recompensa - é tudo que posso oferecer, mas saiba que você sempre terá um amigo em Elliot Shinefingers. Que os deuses da pedra abençoem seu caminho, herói.");
        cvReunion.addOptionText(SPANISH, "Está herido pero vivo. Puede caminar con ayuda.", "*Te abraza fuertemente*\n¡Salvaste la vida de mi hermano! La familia Shinefingers te debe una deuda que nunca podremos pagar completamente. Traus es toda la familia que me queda además de Kamala. Me devolviste a mi hermano. \n*se limpia las lágrimas*\nToma esta recompensa: es todo lo que puedo ofrecer, pero sabe que siempre tendrás un amigo en Elliot Shinefingers. Que los dioses de la piedra bendigan tu camino, héroe.");
        cvReunion.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.LOST_BROTHER, App.getPlayerChar(), 3, ctx);
        };
        npc.conversationOptions.add(cvReunion);

        // ===== ROLEPLAY: After quest completion =====
        ConversationOption cvAfterQuest = new ConversationOption(0, 0);
        cvAfterQuest.addOptionText(ENGLISH, "How is Traus doing?", "He's recovering well, thank you. The temple priests have been treating his wounds. He's resting now, grateful to be alive. He swears he'll never mine alone in the deep levels again. And neither will I - we learned our lesson. Thank you again, friend. The Shinefingers family will never forget what you did.");
        cvAfterQuest.addOptionText(PORTUGUESE, "Como Traus está?", "Ele está se recuperando bem, obrigado. Os sacerdotes do templo estão tratando seus ferimentos. Ele está descansando agora, grato por estar vivo. Ele jura que nunca mais minerará sozinho nos níveis profundos. E nem eu - aprendemos nossa lição. Obrigado novamente, amigo. A família Shinefingers nunca esquecerá o que você fez.");
        cvAfterQuest.addOptionText(SPANISH, "¿Cómo está Traus?", "Se está recuperando bien, gracias. Los sacerdotes del templo han estado tratando sus heridas. Está descansando ahora, agradecido de estar vivo. Jura que nunca más minará solo en los niveles profundos. Y yo tampoco - aprendimos la lección. Gracias de nuevo, amigo. La familia Shinefingers nunca olvidará lo que hiciste.");
        cvAfterQuest.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.LOST_BROTHER)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAfterQuest);

        return npc;
    }
}


