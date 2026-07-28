package com.cnx.endlesstalestwo.data.npcs.lisport.Castle;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.NOBLES_BALL;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.CattleBusiness;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class KingOliver extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, kingOliver());
    }

    Npc kingOliver() {
        Npc npc = new Npc("King Oliver");
        npc.addNameTranslation(PORTUGUESE, "Rei Oliver");
        npc.addNameTranslation(SPANISH, "Rey Oliver");
        npc.age = 63;
        npc.job = Enums.NPCJobs.KING;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Shrewd, imposing and serious. He fights for Lisport's ideals but still needs more time to become a great king.\nSome of his methods can be more rustic, he needs to better accept the changes of the ages.\n\nPhysical traits: Striking blue eyes. Grey hair and beard. Slender physique with light age-related wrinkles.");
        npc.addDescriptionTranslation(PORTUGUESE, "Astuto, imponente e sério. Luta pelos ideais de Lisport mas ainda precisa mais tempo para se tornar um grande rei.\nAlguns de seus métodos podem ser mais rústicos, precisa aceitar melhor as mudanças das eras.\n\nSeus taços físicos: Olhos azuis marcantes. Cabelo e barba grisalhos. físico esbelto e rugas leves da idade.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("What brings you here, citizen?"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("O que o traz aqui, cidadão?"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("¿Qué te trae por aquí, ciudadano?"));

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Hail my king. I would like to thank you for the government.", "I appreciate your loyalty, I do the best for the citizens.");
        cv1.addOptionText(PORTUGUESE, "Salve meu rei. Gostaria de agradecer pelo governo.", "Agradeço sua lealdade, faço o melhor pelos cidadãos.");
        cv1.addOptionText(SPANISH, "Salve mi rey. Quisiera agradecerte por el gobierno.", "Aprecio su lealtad, hago lo mejor para los ciudadanos.");

        ConversationOption cv2 = new ConversationOption(0, 1);
        cv2.addOptionText(ENGLISH, "My lord, I have an important letter to you.", "Alright.\nBut, from who?");
        cv2.addOptionText(PORTUGUESE, "Meu senhor, tenho uma carta importante para você.", "Tudo bem.\nMas de quem?");
        cv2.addOptionText(SPANISH, "Señor mío, tengo una carta importante para usted.", "Está bien.\nPero, ¿de quién?");
        cv2.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.LETTER_FROM_ERINO);
            if (requiredQuest != null && (requiredQuest.getCurrentPartOrder() == 1) && LibInventory.checkHasItem(ItemsIds.LETTER_FROM_ERINO, App.getPlayerChar())) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv3 = new ConversationOption(1, 2);
        cv3.addOptionText(ENGLISH, "Not from me, I don't know how to write. It's from Erino.", "Erino? If I am not wrong he is an important soldier of the army. Please, give me the letter.");
        cv3.addOptionText(PORTUGUESE, "Não de mim, não sei escrever. É do Erino.", "Erino? Se não me engano, ele é um soldado importante do exército. Por favor, me dê a carta.");
        cv3.addOptionText(SPANISH, "No es de mí, no sé escribir. Es de Erino.", "¿Erino? Si no me equivoco es un soldado importante del ejército. Por favor, dame la carta.");

        ConversationOption cv4 = new ConversationOption(2, 0);
        cv4.addOptionText(ENGLISH, "(Give the letter)", "Thank you, citizen. I will read it now.");
        cv4.addOptionText(PORTUGUESE, "(Dê a carta)", "Obrigado, cidadão. Vou ler agora.");
        cv4.addOptionText(SPANISH, "(entrega la carta)", "Gracias, ciudadano. Lo leeré ahora.");
        cv4.listeners = (ctx, fragment) -> {
            LibInventory.removeFromInventory(ItemsIds.LETTER_FROM_ERINO, 1, App.getPlayerChar());
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.LETTER_FROM_ERINO);
            LibQuest.updateQuest(quest, 2, App.getPlayerChar(), ctx);
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);
        };

        ConversationOption cv5 = new ConversationOption(0, 3);
        cv5.addOptionText(ENGLISH, "My lord, I want to ask something.", "Right, go ahead, tell me, what do you need my citizen?");
        cv5.addOptionText(PORTUGUESE, "Meu senhor, quero perguntar uma coisa.", "Certo, vá em frente, me diga, o que você precisa meu cidadão?");
        cv5.addOptionText(SPANISH, "Señor mío, quiero preguntarle algo.", "Bien, adelante, dime, ¿qué necesitas a mi ciudadano?");
        cv5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ARMY_HONORED_TASKS, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv6 = new ConversationOption(3, 4);
        cv6.addOptionText(ENGLISH, "[Talk about the ceremony]", "Very well, your idea is commendable, I approve and allow the organization. The workers of my court will organize the ceremony. I would like you to give a remarkable speech during the ceremony.");
        cv6.addOptionText(PORTUGUESE, "[Fale sobre a cerimônia] ", "Muito bem, sua ideia é louvável, eu aprovo e permito a organização. Os trabalhadores da minha corte organizarão a cerimônia. Gostaria que você fizesse um discurso notável durante a cerimônia.");
        cv6.addOptionText(SPANISH, "[Hablemos de la ceremonia]", "Muy bien, tu idea es loable, la apruebo y permito la organización. Los trabajadores de mi corte organizarán la ceremonia. Me gustaría que dieras un discurso notable durante la ceremonia.");

        ConversationOption cv7 = new ConversationOption(4, 5);
        cv7.addOptionText(ENGLISH, "Very well, I will do it.", "Thanks, citizen...\nActually, I would like to know your name, you seem to be a loyal soldier and member of Lisport community.");
        cv7.addOptionText(PORTUGUESE, "Muito bem, farei isso.", "Obrigado, cidadão...\nNa verdade, eu gostaria de saber seu nome, você parece ser um soldado leal e membro da comunidade de Lisport.");
        cv7.addOptionText(SPANISH, "Muy bien, lo haré.", "Gracias, ciudadano...\nEn realidad, me gustaría saber tu nombre. Pareces ser un soldado leal y miembro de la comunidad de Lisport.");
        cv7.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.ARMY_HONORED_TASKS);
            LibQuest.updateQuest(quest, 2, App.getPlayerChar(), ctx);
        };

        ConversationOption cv8 = new ConversationOption(5, 0);
        cv8.addOptionText(ENGLISH, "My name is [PLAYERNAME].", "Very well, [PLAYERNAME]. The ceremony will be great. Thanks and keep being an important citizen to us.");
        cv8.addOptionText(PORTUGUESE, "Meu nome é [PLAYERNAME].", "Muito bem, [PLAYERNAME]. A cerimônia será ótima. Obrigado e continue sendo um cidadão importante para nós.");
        cv8.addOptionText(SPANISH, "Mi nombre es [NOMBRE DEL JUGADOR].", "Muy bien, [PLAYERNAME]. La ceremonia será genial. Gracias y sigue siendo un ciudadano importante para nosotros.");

        ConversationOption cv9 = new ConversationOption(0, 6);
        cv9.addOptionText(ENGLISH, "My lord, you need my help?", "Ah, [PLAYERNAME], good to see you here.\nYes, I think you can help me. I want you to be my bodyguard during my travel to Havarus. I have a meeting there with queen Enola. Are you able to do this work?");
        cv9.addOptionText(PORTUGUESE, "Meu senhor, você precisa da minha ajuda?", "Ah, [PLAYERNAME], bom ver você aqui.\nSim, acho que você pode me ajudar. Quero que você seja meu guarda-costas durante minha viagem para Havarus. Tenho uma reunião lá com a rainha Enola. Você consegue fazer esse trabalho?");
        cv9.addOptionText(SPANISH, "Señor mío, ¿necesita mi ayuda?", "Ah, [PLAYERNAME], me alegra verte aquí.\nSí, creo que puedes ayudarme. Quiero que seas mi guardaespaldas durante mi viaje a Havarus. Tengo una reunión allí con la reina Enola. ¿Eres capaz de hacer este trabajo?");
        cv9.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ARMY_HONORED_TASKS, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv10 = new ConversationOption(6, 0);
        cv10.addOptionText(ENGLISH, "Of course, I am able.", "Great. My entourage is ready, you came in the perfect time, we can go right now.");
        cv10.addOptionText(PORTUGUESE, "Claro que sou capaz.", "Ótimo. Minha comitiva está pronta, vocês chegaram na hora certa, podemos ir agora mesmo.");
        cv10.addOptionText(SPANISH, "Por supuesto que puedo.", "Genial. Mi séquito está listo, llegaste en el momento perfecto, podemos irnos ahora mismo.");
        cv10.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.ARMY_HONORED_TASKS);
            LibQuest.updateQuest(quest, 6, App.getPlayerChar(), ctx);
        };

        ConversationOption cv11 = new ConversationOption(6, 0);
        cv11.addOptionText(ENGLISH, "I am not able right now.", "I can wait a little longer, but I can find another person if you don't want.");
        cv11.addOptionText(PORTUGUESE, "Não posso agora.", "Posso esperar um pouco mais, mas posso encontrar outra pessoa se você não quiser.");
        cv11.addOptionText(SPANISH, "No puedo ahora mismo.", "Puedo esperar un poco más, pero puedo buscar a otra persona si no quieres.");

        ConversationOption cv12 = new ConversationOption(0, 0);
        cv12.addOptionText(ENGLISH, "So, we are back in safe.", "Yes, things ran pretty well during the travel. Thanks for your duty, [PLAYERNAME].\nI will recommend you as an honorable member of our army.");
        cv12.addOptionText(PORTUGUESE, "Então, estamos de volta em segurança.", "Sim, as coisas correram muito bem durante a viagem. Obrigado pelo seu dever, [PLAYERNAME].\nEu o recomendarei como um membro honrado do nosso exército.");
        cv12.addOptionText(SPANISH, "Así que volvemos a estar a salvo.", "Sí, todo salió bastante bien durante el viaje. Gracias por tu deber, [PLAYERNAME].\nTe recomendaré como miembro honorable de nuestro ejército.");
        cv12.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.ARMY_HONORED_TASKS);
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ARMY_HONORED_TASKS, 7)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv12.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.ARMY_HONORED_TASKS);
            LibQuest.updateQuest(quest, 8, App.getPlayerChar(), ctx);
        };

        npc.conversationOptions.add(cv2);
        npc.conversationOptions.add(cv3);
        npc.conversationOptions.add(cv4);
        npc.conversationOptions.add(cv5);
        npc.conversationOptions.add(cv6);
        npc.conversationOptions.add(cv7);
        npc.conversationOptions.add(cv8);
        npc.conversationOptions.add(cv9);
        npc.conversationOptions.add(cv10);
        npc.conversationOptions.add(cv11);
        npc.conversationOptions.add(cv12);
        npc.conversationOptions.add(cv1);

        // ===== QUEST: Kingdoms Cup - Part 3 =====
        ConversationOption cvKingdomsCup1 = new ConversationOption(0, 50);
        cvKingdomsCup1.addOptionText(ENGLISH, "A young man is organizing a tournament between all cities and kingdoms.", "A tournament? Across all cities and kingdoms?\n\n*Looks skeptical*\n\nThat's a grand vision indeed. What manner of tournament is this? A test of arms? Archery? And what cities are involved?");
        cvKingdomsCup1.addOptionText(PORTUGUESE, "Um jovem está organizando um torneio entre todas as cidades e reinos.", "Um torneio? Entre todas as cidades e reinos?\n\n*Parece cético*\n\nEssa é de fato uma grande visão. Que tipo de torneio é este? Teste de armas? Arco e flecha? E quais cidades estão envolvidas?");
        cvKingdomsCup1.addOptionText(SPANISH, "Un joven está organizando un torneo entre todas las ciudades y reinos.", "¿Un torneo? ¿Entre todas las ciudades y reinos?\n\n*Parece escéptico*\n\nEsa es una gran visión. ¿Qué tipo de torneo es este? ¿Prueba de armas? ¿Tiro con arco? ¿Y qué ciudades están involucradas?");
        cvKingdomsCup1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.KINGDOMS_CUP, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvKingdomsCup1);

        ConversationOption cvKingdomsCup2 = new ConversationOption(50, 51);
        cvKingdomsCup2.addOptionText(ENGLISH, "Mob Ball. Lord Markus and Lady Jade have already accepted.", "*Raises eyebrows*\n\nMob Ball! Now that's interesting - a true people's sport, intense and thrilling. And Markus and Jade both agreed?\n\n*Pauses, then frowns*\n\nHowever... Lisport is quite distant from Havarus. The cost of traveling there, transporting our athletes, accommodation for the team... It would be quite expensive for our kingdom. I'm not certain we can justify such an expense, despite the diplomatic benefits.");
        cvKingdomsCup2.addOptionText(PORTUGUESE, "Mob Ball. Lorde Markus e Lady Jade já aceitaram.", "*Ergue as sobrancelhas*\n\nMob Ball! Agora isso é interessante - um verdadeiro esporte do povo, intenso e emocionante. E Markus e Jade concordaram?\n\n*Pausa, depois franze a testa*\n\nNo entanto... Lisport fica bem distante de Havarus. O custo de viajar até lá, transportar nossos atletas, acomodação para o time... Seria bastante caro para nosso reino. Não tenho certeza se podemos justificar tal despesa, apesar dos benefícios diplomáticos.");
        cvKingdomsCup2.addOptionText(SPANISH, "Mob Ball. Lord Markus y Lady Jade ya han aceptado.", "*Levanta las cejas*\n\n¡Mob Ball! Eso es interesante: un verdadero deporte del pueblo, intenso y emocionante. ¿Y Markus y Jade están de acuerdo?\n\n*Pausa, luego frunce el ceño*\n\nSin embargo... Lisport está bastante lejos de Havarus. El costo de viajar allí, transportar a nuestros atletas, alojamiento para el equipo... Sería bastante caro para nuestro reino. No estoy seguro de que podamos justificar tal gasto, a pesar de los beneficios diplomáticos.");
        npc.conversationOptions.add(cvKingdomsCup2);

        // Option 1: Persuade with Charisma
        ConversationOption cvKingdomsCupPersuade = new ConversationOption(51, 0);
        cvKingdomsCupPersuade.addOptionText(ENGLISH, "[Persuade]\n(Charisma 18)", "*Listens carefully*\n\nYou make compelling arguments about unity and diplomatic ties. This tournament could foster goodwill for years to come...\n\n*Nods slowly*\n\nVery well, you've convinced me. Lisport will participate in this Kingdoms Cup. Tell the young organizer that King Oliver accepts!");
        cvKingdomsCupPersuade.addOptionText(PORTUGUESE, "[Persuadir]\n(Carisma 18)", "*Ouve atentamente*\n\nVocê faz argumentos convincentes sobre unidade e laços diplomáticos. Este torneio poderia fomentar boa vontade por anos...\n\n*Acena lentamente*\n\nMuito bem, você me convenceu. Lisport participará dessa Copa dos Reinos. Diga ao jovem organizador que o Rei Oliver aceita!");
        cvKingdomsCupPersuade.addOptionText(SPANISH, "[Persuadir]\n(Carisma 18)", "*Escucha atentamente*\n\nHaces argumentos convincentes sobre unidad y lazos diplomáticos. Este torneo podría fomentar buena voluntad durante años...\n\n*Asiente lentamente*\n\nMuy bien, me has convencido. Lisport participará en esta Copa de los Reinos. ¡Dile al joven organizador que el Rey Oliver acepta!");
        cvKingdomsCupPersuade.requirementValidations = (chara, ctx) -> {
            int charisma = chara.attributesManager.getCurrent(Enums.AttributeName.CHARISMA);
            if (charisma >= 18) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_ATTRIBUTES;
        };
        cvKingdomsCupPersuade.showEvenWhenNotValid = true;
        cvKingdomsCupPersuade.listeners = (ctx, currentFragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.KINGDOMS_CUP);
            LibQuest.updateQuest(quest, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvKingdomsCupPersuade);

        // Option 2: Pay 10 gold
        ConversationOption cvKingdomsCupPay = new ConversationOption(51, 0);
        cvKingdomsCupPay.addOptionText(ENGLISH, "I can help with the costs - here are 10 gold coins.", "*Eyes widen with surprise*\n\nYou would contribute your own gold? That's remarkably generous.\n\n*Accepts the coins*\n\nWith this contribution, the burden becomes manageable. Very well, Lisport will participate. Tell the young organizer that King Oliver accepts!");
        cvKingdomsCupPay.addOptionText(PORTUGUESE, "Posso ajudar com os custos - aqui estão 10 moedas de ouro.", "*Os olhos se arregalam*\n\nVocê contribuiria com seu próprio ouro? Isso é notavelmente generoso.\n\n*Aceita as moedas*\n\nCom essa contribuição, o fardo se torna gerenciável. Muito bem, Lisport participará. Diga ao jovem organizador que o Rei Oliver aceita!");
        cvKingdomsCupPay.addOptionText(SPANISH, "Puedo ayudar con los costos - aquí están 10 monedas de oro.", "*Los ojos se agrandan*\n\n¿Contribuirías con tu propio oro? Eso es notablemente generoso.\n\n*Acepta las monedas*\n\nCon esta contribución, la carga se vuelve manejable. Muy bien, Lisport participará. ¡Dile al joven organizador que el Rey Oliver acepta!");
        cvKingdomsCupPay.requirementValidations = (chara, ctx) -> {
            if (chara.checkHasGold(10)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cvKingdomsCupPay.showEvenWhenNotValid = true;
        cvKingdomsCupPay.listeners = (ctx, currentFragment) -> {
            App.getPlayerChar().removeGold(10);
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.KINGDOMS_CUP);
            LibQuest.updateQuest(quest, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvKingdomsCupPay);

        // Option 3: Decline for now
        ConversationOption cvKingdomsCupDecline = new ConversationOption(51, 0);
        cvKingdomsCupDecline.addOptionText(ENGLISH, "I'll think about it.", "Take your time. Come back when you're ready.");
        cvKingdomsCupDecline.addOptionText(PORTUGUESE, "Vou pensar sobre isso.", "Pode ir com calma. Volte quando estiver pronto.");
        cvKingdomsCupDecline.addOptionText(SPANISH, "Lo pensaré.", "Tómate tu tiempo. Vuelve cuando estés listo.");
        npc.conversationOptions.add(cvKingdomsCupDecline);

        // ========================================
        // QUEST: CATTLE BUSINESS
        // ========================================

        // Start path (King Oliver introduces the quest)
        ConversationOption cvCattleStart = new ConversationOption(0, 30);
        cvCattleStart.addOptionText(ENGLISH, "Your Majesty, the people seems hungry.", "Yes, [PLAYERNAME], I know. Also, the kingdom needs reliable people to ensure our food supply. Lisport has plenty of grain, but our cattle herds are dwindling. I need you to assist Murdag in negotiating trade with our neighbors. Go speak with him in the counselor's hall.");
        cvCattleStart.addOptionText(PORTUGUESE, "Vossa Majestade, o povo parece ter fome.", "Sim, [PLAYERNAME], eu sei. Sei também que o reino precisa de pessoas confiáveis para garantir nosso suprimento de comida. Lisport tem muito grão, mas nossos rebanhos de gado estão diminuindo. Preciso que você ajude Murdag a negociar o comércio com nossos vizinhos. Vá falar com ele no salão do conselheiro.");
        cvCattleStart.addOptionText(SPANISH, "Su Majestad, el pueblo tiene hambre.", "El reino necesita gente confiable para asegurar nuestro suministro de alimentos. Lisport tiene abundancia de grano, pero nuestros rebaños de ganado están disminuyendo. Necesito que ayudes a Murdag a negociar el comercio con nuestros vecinos. Ve a hablar con ele en el salón del consejero.");
        cvCattleStart.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.OVERSEAS_RECOGNITION) && !LibQuest.charHasQuest(QuestsIds.CATTLE_BUSINESS, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvCattleStart);

        ConversationOption cvCattleAccept = new ConversationOption(30, 0);
        cvCattleAccept.addOptionText(ENGLISH, "I will speak with Murdag immediately.", "Excellent. Efficiency is key to Lisport's prosperity. Do not keep him waiting.");
        cvCattleAccept.addOptionText(PORTUGUESE, "Falarei com Murdag imediatamente.", "Excelente. A eficiência é a chave para a prosperidade de Lisport. Não o faça esperar.");
        cvCattleAccept.addOptionText(SPANISH, "Hablaré con Murdag de inmediato.", "Excelente. A eficiencia es la clave para la prosperidad de Lisport. No lo haga esperar.");
        cvCattleAccept.listeners = (ctx, currentFragment) -> LibQuest.includeQuestToQuestbook(CattleBusiness.get(), App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvCattleAccept);

        // ========================================
        // QUEST: NOBLE'S BALL
        // ========================================

        // Part 5: Invite King Oliver
        ConversationOption cvBallPart5 = new ConversationOption(0, 0);
        cvBallPart5.addOptionText(ENGLISH, "Your Majesty, I have an invitation for the Noble's Ball at Monelix.",
                "*He takes the invitation and examines it carefully*\nAh, Queen Enola is hosting a ball. A fine gesture. Lisport values its alliance with Havarus, and such gatherings are important for maintaining our ties. \n\nI shall attend. It will be a welcome change from the day-to-day affairs of the castle. Inform the Queen that King Oliver of Lisport accepts her invitation with pleasure.");
        cvBallPart5.addOptionText(PORTUGUESE, "Vossa Majestade, tenho um convite para o Baile de Nobres de Monelix.",
                "*Ele pega o convite e o examina cuidadosamente*\nAh, a Rainha Enola está organizando um baile. Um belo gesto. Lisport valoriza sua aliança com Havarus, e tais reuniões são importantes para manter nossos laços. \n\nEu comparecerei. Será uma mudança bem-vinda nos assuntos cotidianos do castelo. Informe à Rainha que o Rei Oliver de Lisport aceita seu convite com prazer.");
        cvBallPart5.addOptionText(SPANISH, "Su Majestad, tengo una invitación para el Baile de Nobles de Monelix.",
                "*Toma la invitación y la examina cuidadosamente*\nAh, la Reina Enola organiza un baile. Un buen gesto. Lisport valora su alianza con Havarus, y tales reuniones son importantes para mantener nuestros lazos. \n\nAsistiré. Será un cambio bienvenido de los asuntos cotidianos del castillo. Informa a la Reina que el Rey Oliver de Lisport acepta su invitación con mucho gusto.");
        cvBallPart5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, NOBLES_BALL, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvBallPart5.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(NOBLES_BALL, 6, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBallPart5);

        npc.byeMessages.put(ENGLISH, Collections.singletonList("God bless you, citizen."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Deus o abençoe, cidadão."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Dios te bendiga, ciudadano."));

        return npc;
    }
}
