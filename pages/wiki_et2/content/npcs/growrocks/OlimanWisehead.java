package com.cnx.endlesstalestwo.data.npcs.growrocks;

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

import java.util.Collections;

public class OlimanWisehead extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Oliman Wisehead");
        npc.age = 68;
        npc.job = Enums.NPCJobs.GOVERNOR;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A born leader with a strong, direct presence.\nHe knows his people precisely and commands everything with seriousness.\nHe values honor and loyalty.\n\nHis physical traits: Small blue eyes, a large nose, messy hair and beard almost entirely gray, and a broad fair face with signs of age.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um líder nato, de presença forte e direta.\nConhece o seu povo com precisão e comanda tudo com seriedade.\nValoriza a honra e a lealdade.\n\nSeus traços físicos: Pequenos olhos azuis. Nariz grande. Cabelo e barba despenteados e quase totalmente grisalhos. Rosto largo com pele clara e um pouco envelhecida.");
        npc.addDescriptionTranslation(SPANISH, "Un líder nato, de presencia fuerte y directa.\nConoce a su pueblo con precisión y lo comanda todo con seriedad.\nValora el honor y la lealtad.\n\nSus rasgos físicos: Ojos azules pequeños, nariz grande, cabello y barba despeinados y casi totalmente canosos, y rostro ancho de piel clara algo envejecida.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Welcome to Growrocks, surface dweller. Speak your business."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bem-vindo a Growrocks, habitante da superfície. Diga seu propósito."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Bienvenido a Growrocks, habitante de la superficie. Di tu propósito."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Stone and steel guide you."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Pedra e aço guiem você."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Piedra y acero te guíen."));

        // ===== QUEST PART 1: Automatic quest start =====
        ConversationOption cvQuestStart = new ConversationOption(0, 1);
        cvQuestStart.addOptionText(ENGLISH, "Tell me about Growrocks.", "Growrocks is our ancestral home, carved from living stone over generations. We dwarves are miners, blacksmiths, craftsmen - masters of earth and metal. This city represents centuries of labor, tradition, and pride.\nYou arrived here with respect, that is... rare among your kind.\n\nI am Oliman Wisehead, leader of Growrocks. You stand in our ancestral home - a place few outsiders ever see. But entry alone does not earn trust. Trust must be proven through actions.");
        cvQuestStart.addOptionText(PORTUGUESE, "Conte-me sobre Growrocks.", "Growrocks é nosso lar ancestral, esculpido da pedra viva ao longo de gerações. Nós anões somos mineradores, ferreiros, artesãos - mestres da terra e do metal. Esta cidade representa séculos de trabalho, tradição e orgulho.\nVocê chegar até aqui com respeito, isso é... raro entre os de sua espécie.\n\nSou Oliman Wisehead, líder de Growrocks. Você está em nosso lar ancestral - um lugar que poucos forasteiros veem. Mas a entrada sozinha não ganha confiança. Confiança deve ser provada através de ações.");
        cvQuestStart.addOptionText(SPANISH, "Cuéntame sobre Growrocks.", "Growrocks es nuestro hogar ancestral, tallado en piedra viva a lo largo de generaciones. Nosotros los enanos somos mineros, herreros, artesanos - maestros de la tierra y el metal. Esta ciudad representa siglos de trabajo, tradición y orgullo.\nLlegaste aquí con respeto, eso es... raro entre los de tu especie.\n\nSoy Oliman Wisehead, líder de Growrocks. Estás en nuestro hogar ancestral - un lugar que pocos forasteros ven. Pero la entrada sola no gana confianza. La confianza debe ser probada a través de acciones.");
        cvQuestStart.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.THE_DWARVEN_CITY, chara) &&
                    LibQuest.isQuestComplete(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestStart);

        ConversationOption cvQuestAccept = new ConversationOption(1, 0);
        cvQuestAccept.addOptionText(ENGLISH, "How can I prove myself?", "*Strokes his braided beard thoughtfully*\nYou ask the right question. Very well - I will test you. If you pass, you may become a friend to Growrocks. If you fail, you remain merely... tolerated.\n\nFirst test: prove you understand mining and smithing - the foundations of dwarven life. Bring me ores and ingots. Three iron ore, two iron ingots. Three copper ore, two copper ingots. Show me you know stone and metal.");
        cvQuestAccept.addOptionText(PORTUGUESE, "Como posso me provar?", "*Acaricia sua barba trançada pensativamente*\nVocê faz a pergunta certa. Muito bem - vou testá-lo. Se passar, pode se tornar amigo de Growrocks. Se falhar, permanece apenas... tolerado.\n\nPrimeiro teste: prove que entende mineração e ferraria - as fundações da vida anã. Traga-me minérios e barras. Três minérios de ferro, duas barras de ferro. Três minérios de cobre, duas barras de cobre. Mostre-me que conhece pedra e metal.");
        cvQuestAccept.addOptionText(SPANISH, "¿Cómo puedo probarme?", "*Acaricia su barba trenzada pensativamente*\nHaces la pregunta correcta. Muy bien - te probaré. Si pasas, puedes convertirte en amigo de Growrocks. Si fallas, permaneces solo... tolerado.\n\nPrimera prueba: demuestra que entiendes minería y herrería - los fundamentos de la vida enana. Tráeme minerales y lingotes. Tres minerales de hierro, dos lingotes de hierro. Tres minerales de cobre, dos lingotes de cobre. Muéstrame que conoces piedra y metal.");
        cvQuestAccept.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.THE_DWARVEN_CITY, App.getPlayerChar(), ctx);
            LibQuest.updateQuest(QuestsIds.THE_DWARVEN_CITY, 1, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuestAccept);

        // ===== QUEST PART 1: Deliver ores and ingots =====
        ConversationOption cvQuest2 = new ConversationOption(0, 2);
        cvQuest2.addOptionText(ENGLISH, "I have the ores and ingots you requested.", "*Examines each piece carefully, testing weight and purity*\n\n*Nods slowly*\nGood. The ore is properly mined - no waste, clean extraction. The ingots are well-smelted - proper temperature, even consistency. You understand the basics of our craft. That is... acceptable.\n\nNext test: service to community. Our master smith Lugag Ironhand needs supplies. Deliver five wood and ten coal to him at the forge. Prove you will work for Growrocks, not just yourself.");
        cvQuest2.addOptionText(PORTUGUESE, "Tenho os minérios e barras que solicitou.", "*Examina cada peça cuidadosamente, testando peso e pureza*\n\n*Acena lentamente*\nBom. O minério foi adequadamente extraído - sem desperdício, extração limpa. As barras foram bem fundidas - temperatura adequada, consistência uniforme. Você entende o básico de nosso ofício. Isso é... aceitável.\n\nPróximo teste: serviço à comunidade. Nosso mestre ferreiro Lugag Ironhand precisa de suprimentos. Entregue cinco madeiras e dez carvões a ele na forja. Prove que trabalhará para Growrocks, não apenas para si mesmo.");
        cvQuest2.addOptionText(SPANISH, "Tengo los minerales y lingotes que solicitaste.", "*Examina cada pieza cuidadosamente, probando peso y pureza*\n\n*Asiente lentamente*\nBien. El mineral fue adecuadamente extraído - sin desperdicio, extracción limpia. Los lingotes fueron bien fundidos - temperatura adecuada, consistencia uniforme. Entiendes lo básico de nuestro oficio. Eso es... aceptable.\n\nSiguiente prueba: servicio a la comunidad. Nuestro maestro herrero Lugag Ironhand necesita suministros. Entrega cinco maderas y diez carbones a él en la forja. Demuestra que trabajarás para Growrocks, no solo para ti mismo.");
        cvQuest2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_DWARVEN_CITY, 1) &&
                    LibInventory.checkHasItemAmount(ItemsIds.IRON_ORE, 3, chara) &&
                    LibInventory.checkHasItemAmount(ItemsIds.IRON_INGOT, 2, chara) &&
                    LibInventory.checkHasItemAmount(ItemsIds.COPPER_ORE, 3, chara) &&
                    LibInventory.checkHasItemAmount(ItemsIds.COPPER_INGOT, 2, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuest2);

        ConversationOption cvQuest2Deliver = new ConversationOption(2, 0);
        cvQuest2Deliver.addOptionText(ENGLISH, "*Deliver the materials*", "*Takes the materials with a firm nod*\nGo. Find Lugag.");
        cvQuest2Deliver.addOptionText(PORTUGUESE, "*Entregar os materiais*", "*Pega os materiais com um aceno firme*\nVá. Encontre Lugag.");
        cvQuest2Deliver.addOptionText(SPANISH, "*Entregar los materiales*", "*Toma los materiales con un gesto firme*\nVe. Encuentra a Lugag.");
        cvQuest2Deliver.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.IRON_ORE, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.IRON_INGOT, 2, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.COPPER_ORE, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.COPPER_INGOT, 2, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.THE_DWARVEN_CITY, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuest2Deliver);

        // ===== QUEST PART 3: After Lugag, food task =====
        ConversationOption cvQuest3 = new ConversationOption(0, 3);
        cvQuest3.addOptionText(ENGLISH, "Lugag has received the wood and coal.", "*Nods*\nGood. The forge fires will burn bright. Now, another matter - our people need food. Find Fiola Brownhand at the Vegetables Gardens. She needs carrots and meat. Five carrots, three pieces of raw meat. Help her, then return to me.");
        cvQuest3.addOptionText(PORTUGUESE, "Lugag recebeu a madeira e o carvão.", "*Acena*\nBom. As chamas da forja arderão fortes. Agora, outro assunto - nosso povo precisa de comida. Encontre Fiola Brownhand nos Jardins de Vegetais. Ela precisa de cenouras e carne. Cinco cenouras, três peças de carne crua. Ajude-a, depois retorne para mim.");
        cvQuest3.addOptionText(SPANISH, "Lugag ha recibido la madera y el carbón.", "*Asiente*\nBien. Los fuegos de la forja arderán brillantes. Ahora, otro asunto - nuestro pueblo necesita comida. Encuentra a Fiola Brownhand en los Jardines de Vegetales. Necesita zanahorias y carne. Cinco zanahorias, tres piezas de carne cruda. Ayúdala, luego regresa a mí.");
        cvQuest3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_DWARVEN_CITY, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuest3);

        ConversationOption cvQuest3Accept = new ConversationOption(3, 0);
        cvQuest3Accept.addOptionText(ENGLISH, "I will help Fiola.", "Go then.");
        cvQuest3Accept.addOptionText(PORTUGUESE, "Vou ajudar Fiola.", "Vá então.");
        cvQuest3Accept.addOptionText(SPANISH, "Ayudaré a Fiola.", "Ve entonces.");
        npc.conversationOptions.add(cvQuest3Accept);

        // ===== QUEST PART 4: Cultural understanding =====
        ConversationOption cvQuest4 = new ConversationOption(0, 4);
        cvQuest4.addOptionText(ENGLISH, "Fiola has received the food supplies.", "*A rare hint of approval in his eyes*\nYou work well. You serve the community. But there is more to being accepted by dwarves than labor alone.\n\nYou must understand our culture - our beliefs, our gods, our traditions. Go to our temple. Speak with the priest there. Learn about the foundations of dwarven life. Then return to me.");
        cvQuest4.addOptionText(PORTUGUESE, "Fiola recebeu os suprimentos de comida.", "*Um raro lampejo de aprovação em seus olhos*\nVocê trabalha bem. Você serve a comunidade. Mas há mais para ser aceito pelos anões do que apenas trabalho.\n\nVocê deve entender nossa cultura - nossas crenças, nossos deuses, nossas tradições. Vá ao nosso templo. Fale com o sacerdote lá. Aprenda sobre as fundações da vida anã. Então retorne para mim.");
        cvQuest4.addOptionText(SPANISH, "Fiola ha recibido los suministros de comida.", "*Un raro destello de aprobación en sus ojos*\nTrabajas bien. Sirves a la comunidad. Pero hay más para ser aceptado por los enanos que solo trabajo.\n\nDebes entender nuestra cultura - nuestras creencias, nuestros dioses, nuestras tradiciones. Ve a nuestro templo. Habla con el sacerdote allí. Aprende sobre los fundamentos de la vida enana. Luego regresa a mí.");
        cvQuest4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_DWARVEN_CITY, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuest4);

        ConversationOption cvQuest4Accept = new ConversationOption(4, 0);
        cvQuest4Accept.addOptionText(ENGLISH, "I will visit the temple.", "Do so. Understanding our gods is understanding our people.");
        cvQuest4Accept.addOptionText(PORTUGUESE, "Vou visitar o templo.", "Faça isso. Entender nossos deuses é entender nosso povo.");
        cvQuest4Accept.addOptionText(SPANISH, "Visitaré el templo.", "Hazlo. Entender a nuestros dioses es entender a nuestro pueblo.");
        npc.conversationOptions.add(cvQuest4Accept);

        // ===== QUEST PART 5: Final task - Dwarven Pickaxe =====
        ConversationOption cvQuest5 = new ConversationOption(0, 5);
        cvQuest5.addOptionText(ENGLISH, "I have learned about dwarven culture and beliefs.", "*Studies you with penetrating eyes*\nYou have worked. You have served. You have learned. One final test remains - the test of mastery.\n\nObtain a Dwarven Pickaxe. Not borrowed - yours. Forge it yourself if you have the skill, or trade fairly for one. The pickaxe is our symbol - tool of mining, tool of survival, tool of our way of life. If you need guidance on crafting one, speak with Lugag at the forge. Return with it, and your trials are complete.");
        cvQuest5.addOptionText(PORTUGUESE, "Aprendi sobre a cultura e crenças anãs.", "*Estuda você com olhos penetrantes*\nVocê trabalhou. Você serviu. Você aprendeu. Um teste final permanece - o teste de maestria.\n\nObtenha uma Picareta dos Anões. Não emprestada - sua. Forje você mesmo se tiver habilidade, ou negocie justamente por uma. A picareta é nosso símbolo - ferramenta de mineração, ferramenta de sobrevivência, ferramenta de nosso modo de vida. Se precisar de orientação sobre como fabricar uma, fale com Lugag na forja. Retorne com ela, e seus testes estarão completos.");
        cvQuest5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_DWARVEN_CITY, 7)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuest5);

        ConversationOption cvQuest5Accept = new ConversationOption(5, 0);
        cvQuest5Accept.addOptionText(ENGLISH, "I will obtain a Dwarven Pickaxe.", "Then go. Prove your mastery.");
        cvQuest5Accept.addOptionText(PORTUGUESE, "Vou obter uma Picareta dos Anões.", "Então vá. Prove sua maestria.");
        cvQuest5Accept.addOptionText(SPANISH, "Obtendré un Pico Enano.", "Entonces ve. Demuestra tu maestría.");
        cvQuest5Accept.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.THE_DWARVEN_CITY, 8, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuest5Accept);

        // ===== QUEST COMPLETION =====
        ConversationOption cvQuestComplete = new ConversationOption(0, 6);
        cvQuestComplete.addOptionText(ENGLISH, "I have obtained the Dwarven Pickaxe.", "*Takes the pickaxe with both hands, examining every detail*\n\n*Tests the edge with his thumb, checks the balance, studies the craftsmanship*\n\n*Finally nods, a hint of respect in his weathered face*\n\nTrue dwarven work. You either forged this yourself with proper technique, or you valued it enough to trade fairly. Either shows understanding.\n\nYou have passed all tests. You are no longer tolerated - you are welcomed.");
        cvQuestComplete.addOptionText(PORTUGUESE, "Obtive a Picareta dos Anões.", "*Pega a picareta com ambas as mãos, examinando cada detalhe*\n\n*Testa o gume com o polegar, verifica o equilíbrio, estuda o artesanato*\n\n*Finalmente acena, um lampejo de respeito em seu rosto marcado*\n\nVerdadeiro trabalho anão. Você forjou isso com técnica adequada, ou valorizou o suficiente para negociar justamente. Ambos mostram compreensão.\n\nVocê passou em todos os testes. Você não é mais tolerado - você é bem-vindo.");
        cvQuestComplete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_DWARVEN_CITY, 8) &&
                    LibInventory.checkHasItem(ItemsIds.DWARVENS_PICKAXE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestComplete);

        ConversationOption cvQuestFinish = new ConversationOption(6, 0);
        cvQuestFinish.addOptionText(ENGLISH, "I am honored, Oliman.", "*Extends his hand in the dwarven greeting - firm, respectful*\n\nAs sign of our trust, I grant you access to the Ore Fortress. Our most valuable mine. Few outsiders ever receive this honor. The deepest veins hold the rarest treasures - and the greatest dangers.\n\nYou are friend to Growrocks now. May stone guide your path, may metal serve your hand, and may your labors always bear fruit. Welcome, friend.");
        cvQuestFinish.addOptionText(PORTUGUESE, "Estou honrado, Oliman.", "*Estende sua mão na saudação anã - firme, respeitosa*\n\nComo sinal de nossa confiança, concedo-lhe acesso à Fortaleza de Minério. Nossa mina mais valiosa. Poucos forasteiros recebem esta honra. As veias mais profundas guardam os tesouros mais raros - e os maiores perigos.\n\nVocê é amigo de Growrocks agora. Que a pedra guie seu caminho, que o metal sirva sua mão, e que seus trabalhos sempre deem frutos. Bem-vindo, amigo.");
        cvQuestFinish.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.THE_DWARVEN_CITY, App.getPlayerChar(), 9, ctx);
        };
        npc.conversationOptions.add(cvQuestFinish);

        // ===== ROLEPLAY 1: Greetings =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "Greetings.", "*Looks up from examining a stone tablet*\nAh, the surface dweller who gained entry. Our guard spoke of you. Welcome.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Saudações.", "*Levanta o olhar de examinar uma tabuleta de pedra*\nAh, o habitante da superfície que ganhou entrada. Nosso guarda falou de você. Bem-vindo.");
        cvRoleplay1.addOptionText(SPANISH, "Saludos.", "*Levanta la mirada de una tableta de piedra*\nAh, el habitante de la superficie que ganó la entrada. Nuestro guardia habló de ti. Bienvenido.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY 2: About leadership =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "What is it like leading the dwarves?", "It is an honor and a burden. I must balance tradition with progress, isolation with cooperation. The old ways teach us to be suspicious of outsiders, but I've learned that allies can be found even among surface dwellers. My duty is to keep our people safe, prosperous, and true to our heritage. Sometimes that means making difficult choices. But I serve my people gladly - they are family, all of them.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Como é liderar os anões?", "É uma honra e um fardo. Devo equilibrar tradição com progresso, isolamento com cooperação. Os caminhos antigos nos ensinam a desconfiar de forasteiros, mas aprendi que aliados podem ser encontrados mesmo entre os habitantes da superfície. Meu dever é manter nosso povo seguro, próspero e fiel à nossa herança. Às vezes isso significa fazer escolhas difíceis. Mas sirvo meu povo com prazer - eles são família, todos eles.");
        npc.conversationOptions.add(cvRoleplay2);


        // ===== AFTER QUEST =====
        ConversationOption cvAfterQuest = new ConversationOption(0, 0);
        cvAfterQuest.addOptionText(ENGLISH, "How are things in Growrocks?", "We prosper, thanks in part to your efforts. The forges burn, the people eat, the mines yield their treasures. Our way of life continues. You have shown that surface dwellers and dwarves can work together with mutual respect. That is a rare and valuable thing. You will always have a place here, friend.");
        cvAfterQuest.addOptionText(PORTUGUESE, "Como estão as coisas em Growrocks?", "Prosperamos, graças em parte aos seus esforços. As forjas ardem, o povo come, as minas rendem seus tesouros. Nosso modo de vida continua. Você mostrou que habitantes da superfície e anões podem trabalhar juntos com respeito mútuo. Isso é algo raro e valioso. Você sempre terá um lugar aqui, amigo.");
        cvAfterQuest.addOptionText(SPANISH, "¿Cómo están las cosas en Growrocks?", "Prosperamos, gracias en parte a tus esfuerzos. Las forjas arden, el pueblo come, las minas rinden sus tesoros. Nuestra forma de vida continúa. Has demostrado que habitantes de la superficie y enanos pueden trabajar juntos con respeto mutuo. Eso es algo raro y valioso. Siempre tendrás un lugar aquí, amigo.");
        cvAfterQuest.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.THE_DWARVEN_CITY)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAfterQuest);

        return npc;
    }
}



