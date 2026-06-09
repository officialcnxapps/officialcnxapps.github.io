package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.barracks;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.items.ItemsIds.HUNTING_TRAP;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.A_QUEEN_MESSAGE;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.A_RUMOR_SPREADING;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.DESTROY_THE_LAIR;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.GETTING_RESOURCES;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.INVESTIGATE_THE_BEAST;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.KILL_OCTUMAN;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REINFORCE_FARMLAND;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REINFORCE_HELERA;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.RIOT_CONTROL;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.SEA_VERIFICATION;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.WHO_IS_THE_ENEMY;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Guzar extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    //TRADUZIR
    Npc npc() {
        Npc npc = new Npc("Guzar");
        npc.age = 37;
        npc.job = Enums.NPCJobs.GUILD_LEADER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Greetins, [GENDER_FORMAL_CALL]."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Saudações, [GENDER_FORMAL_CALL]."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Saludos, [GENDER_FORMAL_CALL]."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Be careful."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Cuide-se."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Cuídate."));

        npc.requirementValidations = (chara, ctx) -> {
            // Condition 1: Player is at Sea Verification Part 4 but doesn't have Investigate the Beast quest
            boolean condition1_seaVerificationBlockade = LibQuest.isCharacterAtQuestPart(chara, SEA_VERIFICATION, 4)
                    && !LibQuest.charHasQuest(INVESTIGATE_THE_BEAST, chara);

            // Condition 2: Player completed a Reinforce quest but A_QUEEN_MESSAGE is missing or incomplete
            boolean hasCompletedReinforce = LibQuest.isQuestComplete(chara, REINFORCE_FARMLAND)
                    || LibQuest.isQuestComplete(chara, REINFORCE_HELERA);
            boolean queenMessageMissingOrIncomplete = !LibQuest.charHasQuest(A_QUEEN_MESSAGE, chara)
                    || !LibQuest.isQuestComplete(chara, A_QUEEN_MESSAGE);
            boolean condition2_reinforceWithoutQueen = hasCompletedReinforce && queenMessageMissingOrIncomplete;

            // NPC should NOT appear if any condition is true
            if (condition1_seaVerificationBlockade || condition2_reinforceWithoutQueen) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        // ========================================
        // QUEST: Overseas Recognition
        // ========================================
        ConversationOption cv3 = new ConversationOption(0, 1);
        cv3.addOptionText(ENGLISH, "The queen sent me here to talk to you.", "Ah, so you are [PLAYERNAME]?\nGood, I was aware of your incoming. You have potential to become one of our soldiers. But just having potential is not enough right now, since we have many men, we now are selecting just the best ones.");
        cv3.addOptionText(PORTUGUESE, "A rainha me enviou aqui para falar com você.", "Ah, então você é [PLAYERNAME]. A rainha me falou sobre você. Ela me disse que você está procurando por respostas. Talvez eu possa ajudar.");
        cv3.addOptionText(SPANISH, "La reina me envió aquí para hablar contigo.", "Ah, así que tú eres [PLAYERNAME]?\nBien, estaba al tanto de tu llegada. Tienes potencial para convertirte en uno de nuestros soldados. Pero solo tener potencial no es suficiente en este momento, ya que tenemos muchos hombres, ahora estamos seleccionando solo a los mejores.");
        cv3.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null && LibQuest.isCharacterAtQuestPart(App.getPlayerChar(), QuestsIds.OVERSEAS_RECOGNITION, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(1, 2);
        cv4.addOptionText(ENGLISH, "So, what you expect from me?", "You seems to be a dedicated person... Our army wants strong and honorable people. If you prove me that you remove at least 4 bandits from the streets, I could accept you in Havarus army. Deal?");
        cv4.addOptionText(PORTUGUESE, "Então, o que você espera de mim?", "Você parece ser uma pessoa dedicada, então vou te dar uma chance. Temos alguns problemas com bandidos nas estradas. Ajude a limpar as estradas e você terá um lugar aqui.");
        cv4.addOptionText(SPANISH, "Entonces, ¿qué esperas de mí?", "Pareces ser una persona dedicada, así que te daré una oportunidad. Tenemos algunos problemas con bandidos en los caminos. Ayuda a limpiar los caminos y tendrás un lugar aquí.");
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(2, 0);
        cv5.addOptionText(ENGLISH, "Deal, I do that.", "Alright, good. Bandits, thiefs... catch, kill or do whatever you want to clean our streets and roads from those pests.");
        cv5.addOptionText(PORTUGUESE, "Feito, eu farei isso.", "Certo, ótimo. Bandidos, ladrões... capture, mate ou faça o que quiser para limpar nossas ruas e estradas desses parasitas.");
        cv5.addOptionText(SPANISH, "Trato hecho, lo haré.", "Bien, excelente. Bandidos, ladrones... atrapa, mata o haz lo que quieras para limpiar nuestras calles y caminos de esas plagas.");
        cv5.listeners = (ctx, currentFragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.OVERSEAS_RECOGNITION);
            LibQuest.updateQuest(quest, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv5);

        ConversationOption cv6 = new ConversationOption(2, 0);
        cv6.addOptionText(ENGLISH, "Not right now.", "Ok, your life, your choice...");
        cv6.addOptionText(PORTUGUESE, "Agora não.", "Ok, sua vida, sua escolha...");
        cv6.addOptionText(SPANISH, "Ahora no.", "Bien, tu vida, tu elección...");
        npc.conversationOptions.add(cv6);

        ConversationOption cv7 = new ConversationOption(0, 0);
        cv7.addOptionText(ENGLISH, "I dealt with the bandits.", "Good, good!\nSo, you proved your power to me.\nI officially accept you as a member of the Havarus royal army. Welcome.");
        cv7.addOptionText(PORTUGUESE, "Eu lidei com os bandidos.", "Bom, bom!\nEntão, você provou seu poder para mim.\nEu oficialmente aceito você como membro do exército real de Havarus. Bem-vindo.");
        cv7.addOptionText(SPANISH, "Me encargué de los bandidos.", "¡Bien, bien!\nAsí que me has demostrado tu poder.\nOficialmente te acepto como miembro del ejército real de Havarus. Bienvenido.");
        cv7.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.OVERSEAS_RECOGNITION, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv7.listeners = (ctx, currentFragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.OVERSEAS_RECOGNITION);
            LibQuest.updateQuest(quest, 5, App.getPlayerChar(), ctx);
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);
        };
        npc.conversationOptions.add(cv7);

        ConversationOption cv8 = new ConversationOption(0, 3);
        cv8.addOptionText(ENGLISH, "Can I be helpful?", "Yes, great timing!\nThere is a situation happening in Apenna, a village in the south. The woodcutters are making a riot and are not supplying the kingdom with trees and logs. Can you go there and verify what is the problem with those bums?");
        cv8.addOptionText(PORTUGUESE, "Posso ser útil?", "Sim, ótimo, bem em tempo!\nHá uma situação ocorrendo em Apenna, uma vila ao sul. Os lenhadores estão fazendo um motim e não estão fornecendo madeira e toras para o reino. Você pode ir lá e verificar qual é o problema com esses vagabundos?");
        cv8.addOptionText(SPANISH, "¿Puedo ser útil?", "¡Sí, justo a tiempo!\nHay una situación ocurriendo en Apenna, un pueblo al sur. Los leñadores están haciendo un motín y no están suministrando madera y troncos al reino. ¿Puedes ir allí y verificar cuál es el problema con esos holgazanes?");
        cv8.requirementValidations = (chara, ctx) -> {
            if (chara != null && !LibQuest.charHasQuest(RIOT_CONTROL, chara) && LibQuest.isQuestComplete(chara, QuestsIds.OVERSEAS_RECOGNITION)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv8);

        // ========================================
        // QUEST: Riot Control
        // ========================================
        ConversationOption cv9 = new ConversationOption(3, 0);
        cv9.addOptionText(ENGLISH, "Yes, I will go there, sir.", "Good. Just return here when the situation is solved and over.");
        cv9.addOptionText(PORTUGUESE, "Sim, eu irei lá, senhor.", "Bom. Apenas volte aqui quando a situação estiver resolvida e terminada.");
        cv9.addOptionText(SPANISH, "Sí, iré allí, señor.", "Bien. Solo regresa aquí cuando la situación esté resuelta y terminada.");
        cv9.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(RIOT_CONTROL, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv9);

        // ========================================
        // QUEST: Sea Verification
        // ========================================
        ConversationOption cv10 = new ConversationOption(0, 4);
        cv10.addOptionText(ENGLISH, "How are things in the kingdom?", "Honestly, not very well, at least not on land.\nThere are reports of some of our ships being attacked or even sunk during trips between the continent and the islands.");
        cv10.addOptionText(PORTUGUESE, "Como estão as coisas pelo reino?", "Honestamente, não muito bem, ao menos não em terra.\nHá relatos de alguns dos nossos navios sendo atacados ou até afundados durante viagens entre o continente e as ilhas.");
        cv10.addOptionText(SPANISH, "¿Cómo están las cosas en el reino?", "Honestamente, no muy bien, al menos no en tierra.\nHay informes de que algunos de nuestros barcos han sido atacados o incluso hundidos durante los viajes entre el continente e las islas.");
        cv10.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, RIOT_CONTROL) && !LibQuest.charHasQuest(SEA_VERIFICATION, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv10);

        ConversationOption cv11 = new ConversationOption(4, 5);
        cv11.addOptionText(ENGLISH, "What else do we know about this?", "Not much, the reports have increased in recent days.\nSince you handled and resolved the situation with the woodcutters well, I will direct you to talk to the ship captains. Then report back to me.\nGo to the port of our city and then to the port of Helera.");
        cv11.addOptionText(PORTUGUESE, "O que mais sabemos sobre isso?", "Não muito, os relatos aumentaram nos últimos dias.\nVisto que você lidou e resolveu bem a situação dos lenhadores, vou encaminhar você para conversas com os capitães dos navios. Depois reporte de volta para mim.\nVá até o porto de nossa cidade e depois até o porto de Helera.");
        cv11.addOptionText(SPANISH, "¿Qué más sabemos sobre esto?", "No mucho, los informes han aumentado en los últimos días.\nDado que manejaste y resolviste bien la situación con los leñadores, te dirigiré a hablar con los capitanes de los barcos. Luego repórtame.\nVe al puerto de nuestra ciudad y luego al puerto de Helera.");
        npc.conversationOptions.add(cv11);

        ConversationOption cv12 = new ConversationOption(5, 0);
        cv12.addOptionText(ENGLISH, "Alright, I will do that.", "Thank you, [PLAYERNAME]. I await your report to take action.");
        cv12.addOptionText(PORTUGUESE, "Certo, farei isso.", "Obrigado, [PLAYERNAME]. Aguardo seu relatório para tomar uma atitude.");
        cv12.addOptionText(SPANISH, "Bien, lo haré.", "Gracias, [PLAYERNAME]. Espero tu informe para tomar medidas.");
        cv12.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(SEA_VERIFICATION, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv12);

        ConversationOption cv13 = new ConversationOption(0, 0);
        cv13.addOptionText(ENGLISH, "[Report on the ship attacks]", "Thank you, [PLAYERNAME]. We already know that the situation is serious. We now need to learn more about this creature and where it lives. I will speak with the kingdom's advisors. Take a payment for your mission and meet me again in Helera, I will be at the port. Let's investigate further.");
        cv13.addOptionText(PORTUGUESE, "[Reportar sobre os ataques aos navios]", "Obrigado, [PLAYERNAME]. Já sabemos que a situação é grave. Temos agora que conhecer mais sobre essa criatura e onde ela vive. Vou falar com os conselheiros do reino. Pegue um pagamento pela sua missão e me encontre novamente em Helera, estarei no porto. Vamos investigar mais.");
        cv13.addOptionText(SPANISH, "[Informar sobre los ataques a los barcos]", "Gracias, [PLAYERNAME]. Ya sabemos que la situación es grave. Ahora necesitamos saber más sobre esta criatura y dónde vive. Hablaré con los consejeros del reino. Toma un pago por tu misión y reúnete conmigo nuevamente en Helera, estaré en el puerto. Investiguemos más.");
        cv13.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, SEA_VERIFICATION, 3) && !LibQuest.isQuestComplete(chara, SEA_VERIFICATION)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv13.listeners = (ctx, currentFragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.SEA_VERIFICATION);
            LibQuest.updateQuest(quest, 4, App.getPlayerChar(), ctx);
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);
        };
        npc.conversationOptions.add(cv13);

        ///ABOUT QUEST: DESTROY THE LAIR AND/OR KILL OCTUMAN
        ConversationOption cv14 = new ConversationOption(0, 6);
        cv14.addOptionText(ENGLISH, "I found out things about the ship attacks.", "That's good, [PLAYERNAME]. Tell me, what can we do?");
        cv14.addOptionText(PORTUGUESE, "Descobri coisas sobre os ataques aos navios.", "Isso é bom, [PLAYERNAME]. Conte-me, o que podemos fazer?");
        cv14.addOptionText(SPANISH, "Descubrí cosas sobre los ataques a los barcos.", "Eso es bueno, [PLAYERNAME]. Dime, ¿qué podemos hacer?");
        cv14.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, INVESTIGATE_THE_BEAST) &&
                    !(LibQuest.charHasQuest(DESTROY_THE_LAIR, chara) || LibQuest.charHasQuest(KILL_OCTUMAN, chara))) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv14);

        ConversationOption cv15 = new ConversationOption(6, 7);
        cv15.addOptionText(ENGLISH, "<Tell about Octuman>", "Thank you for the information. I'm thinking of two possibilities, you can choose what you think is best for your mission:\nKill the beast Octuman - this could be a great challenge, a tough fight.\nOr you can destroy its lair and make it go away - this may take longer, but you should suffer less.");
        cv15.addOptionText(PORTUGUESE, "<Contar sobre Octuman>", "Obrigado pelas informações. Penso em duas possibilidades, pode escolher o que acha melhor para sua missão:\nMatar a besta Octuman - isso pode ser um grande desafio, um luta difícil.\nOu pode destruir o covil dele e fazer com que vá embora - isso pode ser mais demorado, mas deve sofrer menos.");
        cv15.addOptionText(SPANISH, "<Contar sobre Octuman>", "Gracias por la información. Estoy pensando en dos posibilidades, puedes elegir la que creas que es mejor para tu misión:\nMatar a la bestia Octuman - esto podría ser un gran desafío, una pelea difícil.\nO puedes destruir su guarida y hacer que se vaya - esto puede llevar más tiempo, pero deberías sufrir menos.");
        npc.conversationOptions.add(cv15);

        ConversationOption cv16 = new ConversationOption(7, 0);
        cv16.addOptionText(ENGLISH, "I'm going to kill Octuman!", "Alright, the decision is yours, prepare yourself well, the fight should be arduous.\nThis is your new mission then. You will have a good payment when you return. Besides, the navigators will be grateful.");
        cv16.addOptionText(PORTUGUESE, "Vou matar Octuman!", "Certo, a decisão é sua, prepare-se bem, a luta deve ser árdua.\nEssa então é sua nova missão. Terá um bom pagamento quando retornar. Além de que, os navegadores irão ficar gratos.");
        cv16.addOptionText(SPANISH, "¡Voy a matar a Octuman!", "De acuerdo, la decisión es tuya, prepárate bien, la lucha debe ser ardua.\nEsta es tu nueva misión entonces. Tendrás un buen pago cuando regreses. Además, los navegantes estarán agradecidos.");
        cv16.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(KILL_OCTUMAN, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv16);

        ConversationOption cv17 = new ConversationOption(7, 0);
        cv17.addOptionText(ENGLISH, "I'm going to destroy the lair.", "Alright, good decision to ensure your life.\nThis is your new mission then. You will have a good payment when you return. Besides, the navigators will be grateful.");
        cv17.addOptionText(PORTUGUESE, "Vou destruir o covil.", "Certo, boa decisão para garantir sua vida.\nEssa então é sua nova missão. Terá um bom pagamento quando retornar. Além de que, os navegadores irão ficar gratos.");
        cv17.addOptionText(SPANISH, "Voy a destruir la guarida.", "De acuerdo, buena decisión para asegurar tu vida.\nEsta es tu nueva misión entonces. Tendrás un buen pago cuando regreses. Además, los navegantes estarán agradecidos.");
        cv17.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(DESTROY_THE_LAIR, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv17);

        // ========================================
        // QUEST: Destroy The Lair
        // ========================================
        ConversationOption cv18 = new ConversationOption(0, 0);
        cv18.addOptionText(ENGLISH, "I'll need something to destroy the lair", "Well, that's complicated, maybe something that can cause an explosion... Who should be able to help you is Hingus, he works in the clock tower, he does everything, he should know how to do something like that.");
        cv18.addOptionText(PORTUGUESE, "Vou precisar algo para destruir o covil", "Bem, isso é complicado, talvez algum objeto que possa causar uma explosão... Quem deve conseguir lhe ajudar é o Hingus, ele trabalha na torre do relógio, ele faz de tudo, deve saber fazer algo assim.");
        cv18.addOptionText(SPANISH, "Necesitaré algo para destruir la guarida", "Bueno, eso es complicado, tal vez algo que pueda causar una explosión... Quien debería poder ayudarte es Hingus, trabaja en la torre del reloj, lo hace todo, debería saber cómo hacer algo así.");
        cv18.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, DESTROY_THE_LAIR, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv18.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(DESTROY_THE_LAIR, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv18);

        // ========================================
        // QUEST: Kill Octuman
        // ========================================
        ConversationOption cvKilledOctuman = new ConversationOption(0, 0);
        cvKilledOctuman.addOptionText(ENGLISH, "I killed Octuman.", "Very good, good to know. Our seas should be safer now and navigation can return to normal. It's good to count on your work.\nYour payment is here.");
        cvKilledOctuman.addOptionText(PORTUGUESE, "Eu matei Octuman.", "Muito bem, bom saber disso. Nossos mares devem estar mais seguros agora e as navegações podem voltar ao normal. É bom contar com seu trabalho.\nSeu pagamento está aqui.");
        cvKilledOctuman.addOptionText(SPANISH, "Maté a Octuman.", "Muy bien, bueno saberlo. Nuestros mares deberían estar más seguros ahora y la navegación puede volver a la normalidad. Es bueno contar con tu trabajo.\nTu pago está aquí.");
        cvKilledOctuman.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, KILL_OCTUMAN, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvKilledOctuman.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(KILL_OCTUMAN, App.getPlayerChar(), 4, ctx);
        };
        npc.conversationOptions.add(cvKilledOctuman);

        // ========================================
        // QUEST: A Rumor Spreading
        // ========================================
        ConversationOption cv19 = new ConversationOption(0, 8);
        cv19.addOptionText(ENGLISH, "How are things in the kingdom?", "I'm glad you asked, [PLAYERNAME]. You've shown yourself to be a great soldier, very loyal and efficient. I'll make sure you get important missions with good pay, of course.\nBut about your question, something strange is happening.");
        cv19.addOptionText(PORTUGUESE, "Como estão as coisas pelo reino?", "Fico feliz que perguntou, [PLAYERNAME]. Você tem se mostrado um ótimo soldado, muito leal e eficiente. Vou garantir missões importantes para você e com bons pagamentos, é claro.\nMas sobre a sua pergunta, tem algo estranho acontecendo.");
        cv19.addOptionText(SPANISH, "¿Cómo están las cosas en el reino?", "Me alegra que preguntes, [PLAYERNAME]. Has demostrado ser un gran soldado, muy leal y eficiente. Me aseguraré de que consigas misiones importantes con buena paga, por supuesto.\nPero sobre tu pregunta, algo extraño está sucediendo.");
        cv19.requirementValidations = (chara, ctx) -> {
            if (
                    (LibQuest.isQuestComplete(chara, KILL_OCTUMAN) || LibQuest.isQuestComplete(chara, DESTROY_THE_LAIR))
                            && !LibQuest.charHasQuest(A_RUMOR_SPREADING, chara)
            ) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv19);

        ConversationOption cv20 = new ConversationOption(8, 0);
        cv20.addOptionText(ENGLISH, "Thank you. But what would that be?", "That's what I expect you to find out. A letter arrived from Umera, indicating that there have been some incidents of people being attacked by 'strange' creatures... We don't know what it is for sure.\nSo talk to Gruwald there in Umera and try to find out more about it.");
        cv20.addOptionText(PORTUGUESE, "Obrigado. Mas e o que seria?", "É isso que eu espero que você descubra. Chegou uma carta de Umera, indicando que houve alguns incidentes de pessoas sendo atacadas por criaturas 'estranhas'... Não sabemos o que é ao certo.\nEntão fale com Gruwald lá em Umera e tente descobrir mais sobre isso.");
        cv20.addOptionText(SPANISH, "Gracias. ¿Pero qué sería?", "Eso es lo que espero que descubras. Llegó una carta de Umera, indicando que ha habido algunos incidentes de personas atacadas por criaturas 'extrañas'... No sabemos qué es con certeza.\nAsí que habla con Gruwald allí en Umera y intenta averiguar más al respecto.");
        cv20.listeners = (ctx, currentFragment) -> LibQuest.includeQuestToQuestbook(A_RUMOR_SPREADING, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cv20);

        // ========================================
        // QUEST: Who Is The Enemy
        // ========================================
        ConversationOption cv21 = new ConversationOption(0, 9);
        cv21.addOptionText(ENGLISH, "About the people attacked by creatures...", "Ah yes, what else did you find out?");
        cv21.addOptionText(PORTUGUESE, "Sobre as pessoas atacadas por criaturas...", "Ah sim, o que mais descobriu?");
        cv21.addOptionText(SPANISH, "Sobre la gente atacada por criaturas...", "Ah sí, ¿qué más has descubierto?");
        cv21.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, WHO_IS_THE_ENEMY, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv21);

        ConversationOption cv22 = new ConversationOption(9, 10);
        cv22.addOptionText(ENGLISH, "[Explain everything you discovered]", "So people were attacked by this dark creature, but we don't know how it got here or if there are more of them. We need to understand how this dark magic came to our world.");
        cv22.addOptionText(PORTUGUESE, "[Explicar tudo que descobriu]", "Então as pessoas foram atacadas por essa criatura das trevas, porém não sabemos como ela está aqui e nem se há mais dela. Precisamos entender como essa magia das trevas veio até nosso mundo.");
        cv22.addOptionText(SPANISH, "[Explicar todo lo que descubriste]", "Así que la gente fue atacada por esta criatura oscura, pero no sabemos cómo llegó aquí ni si hay más de ellas. Necesitamos entender cómo esta magia oscura llegó a nuestro mundo.");
        npc.conversationOptions.add(cv22);

        ConversationOption cv23 = new ConversationOption(10, 0);
        cv23.addOptionText(ENGLISH, "And how are we going to do that?", "I have an idea...\nIf this was dark magic, maybe we can go against it using light magic, I don't know, who knows, it's an idea...\nYou should go to Esperand, it's a long journey, but in the monastery there are very wise priests who can probably teach us something.");
        cv23.addOptionText(PORTUGUESE, "E como vamos fazer isso?", "Tenho uma ideia...\nSe isso foi magia negra, talvez possamos ir contra ela usando magia de luz, não sei, quem sabe, é uma ideia...\nDevias ir até Esperand, é uma longa jornada, mas no monastério de lá há sacerdotes muito sábios que provavelmente podem nos ensinar algo.");
        cv23.addOptionText(SPANISH, "¿Y cómo vamos a hacer eso?", "Tengo una idea...\nSi esto fue magia oscura, quizás podamos contrarrestarla usando magia de luz, no lo sé, quién sabe, es una idea...\nDeberías ir a Esperand, es un largo viaje, pero en el monasterio de allí hay sacerdotes muy sabios que probablemente puedan enseñarnos algo.");
        cv23.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(WHO_IS_THE_ENEMY, 3, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cv23);

        // ========================================
        // QUEST: Getting Resources
        // ========================================
        ConversationOption cv24 = new ConversationOption(0, 11);
        cv24.addOptionText(ENGLISH, "We have a big problem.", "Is this about the dark creature?\nSo you spoke with the priests, what did you find out?");
        cv24.addOptionText(PORTUGUESE, "Temos um grande problema.", "Isso é sobre a criatura das trevas?\nEntão falou com os sacerdotes, o que descobriu?");
        cv24.addOptionText(SPANISH, "Tenemos un gran problema.", "¿Es sobre la criatura oscura?\nAsí que hablaste con los sacerdotes, ¿qué descubriste?");
        cv24.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, WHO_IS_THE_ENEMY, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv24);

        ConversationOption cv25 = new ConversationOption(11, 0);
        cv25.addOptionText(ENGLISH, "They were invocations, that creature is just one of many.", "Shit! This is a huge problem for the kingdom. We have to prepare for the worst.\nInitially what we will do is this:\nI will report to the queen and we will recruit more soldiers to guard the kingdom's cities. For that we will need weapons and equipment. I will leave you responsible for this last part.\nIt seems we have tough battles ahead.");
        cv25.addOptionText(PORTUGUESE, "Foram invocações, aquela criatura é apenas uma de várias.", "Merda! Isso é um problema enorme para o reino. Temos que nos preparar para o pior.\nInicialmente o que faremos é o seguinte:\nVou reportar a rainha e vamos recrutar mais soldados para guardar as cidades do reino. Para tal vamos precisar de armas e equipamentos. Vou lhe deixar responsável por esta última parte.\nParece que teremos duras batalhas pela frente.");
        cv25.addOptionText(SPANISH, "Fueron invocaciones, esa criatura es solo una de muchas.", "¡Mierda! Esto es un problema enorme para el reino. Tenemos que prepararnos para lo peor.\nInicialmente lo que haremos es lo siguiente:\nInformaré a la reina y reclutaremos más soldados para proteger las ciudades del reino. Para eso necesitaremos armas y equipo. Te dejaré a cargo de esta última parte.\nParece que tenemos duras batallas por delante.");
        cv25.listeners = (ctx, currentFragment) -> {
            Quest quest = App.getPlayerChar().getQuest(WHO_IS_THE_ENEMY);
            LibQuest.updateQuest(quest, 6, App.getPlayerChar(), ctx);
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);
            LibQuest.includeQuestToQuestbook(GETTING_RESOURCES, App.getPlayerChar(), ctx);
            App.Shell.saveGame(ctx);
        };
        npc.conversationOptions.add(cv25);

        ///ABOUT QUEST: GETTING_RESOURCES - PART 3
        ConversationOption cvGetResources1 = new ConversationOption(0, 12);
        cvGetResources1.addOptionText(ENGLISH, "What about the barriers and traps?", "Good question. We need multiple layers of defense. First, we need strong wooden barriers for the walls. For that, I'll send you to speak with Renne, the lumberjack in Apenna. Second, we need hunting traps spread around to catch any creatures trying to approach. Can you handle both?");
        cvGetResources1.addOptionText(PORTUGUESE, "E sobre as barreiras e armadilhas?", "Boa pergunta. Precisamos de múltiplas camadas de defesa. Primeiro, precisamos de fortes barreiras de madeira para os muros. Para isso, vou enviar você falar com Renne, o lenhador em Apenna. Segundo, precisamos de armadilhas de caça espalhadas para pegar qualquer criatura tentando se aproximar. Você consegue lidar com ambas?");
        cvGetResources1.addOptionText(SPANISH, "¿Qué hay de las barreras y trampas?", "Buena pregunta. Necesitamos múltiples capas de defensa. Primero, necesitamos fuertes barreras de madera para los muros. Para eso, te enviaré a hablar con Renne, el leñador en Apenna. Segundo, necesitamos trampas de caza esparcidas para atrapar cualquier criatura que intente acercarse. ¿Puedes encargarte de ambas?");
        cvGetResources1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, GETTING_RESOURCES, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvGetResources1.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(GETTING_RESOURCES, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvGetResources1);

        ConversationOption cvGetResources2 = new ConversationOption(12, 0);
        cvGetResources2.addOptionText(ENGLISH, "I will handle it.", "Excellent. Then go speak with Renne about the wooden barriers, and gather the hunting traps. When you have arranged everything, return to me.");
        cvGetResources2.addOptionText(PORTUGUESE, "Vou cuidar disso.", "Excelente. Então vá falar com Renne sobre as barreiras de madeira e reúna as armadilhas de caça. Quando você tiver arranjado tudo, volte para mim.");
        cvGetResources2.addOptionText(SPANISH, "Me encargaré.", "Excelente. Entonces ve a hablar con Renne sobre las barreras de madera y reúne las trampas de caza. Cuando hayas arreglado todo, vuelve a mí.");
        npc.conversationOptions.add(cvGetResources2);

        ///ABOUT QUEST: GETTING_RESOURCES - PART 5
        ConversationOption cvGetResources3 = new ConversationOption(0, 13);
        cvGetResources3.addOptionText(ENGLISH, "I have arranged the hunting traps.", "Let me check... excellent! You have brought 6 hunting traps. These will be very useful for our defense. I will spread them around the kingdom's perimeter. The creatures won't know what hit them.");
        cvGetResources3.addOptionText(PORTUGUESE, "Arranjei as armadilhas de caça.", "Deixe-me verificar... excelente! Você trouxe 6 armadilhas de caça. Elas serão muito úteis para nossa defesa. Vou Espalha-las ao redor do perímetro do reino. As criaturas não saberão o que as atingiu.");
        cvGetResources3.addOptionText(SPANISH, "He arreglado las trampas de caza.", "Déjame verificar... ¡excelente! Has traído 6 trampas de caza. Serán muy útiles para nuestra defensa. Los esparciré por el perímetro del reino. Las criaturas no sabrán qué les golpeó.");
        cvGetResources3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, GETTING_RESOURCES, 5)) {
                if (LibInventory.checkHasItemAmount(HUNTING_TRAP, 6, chara)) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvGetResources3);

        ConversationOption cvGetResources4 = new ConversationOption(13, 0);
        cvGetResources4.addOptionText(ENGLISH, "So, the defenses are set for now?", "Yes! With the weapons from Morkus, the wooden barriers from Renne, and these traps, we should have a solid defense against threats. The kingdom is now better prepared. Your efforts have been invaluable, [PLAYERNAME].");
        cvGetResources4.addOptionText(PORTUGUESE, "As defesas estão prontas agora?", "Sim! Com as armas de Morkus, as barreiras de madeira de Renne e essas armadilhas, devemos ter uma defesa sólida contra ameaças. O reino está mais preparado. Seus esforços foram inestimáveis, [PLAYERNAME].");
        cvGetResources4.addOptionText(SPANISH, "Las defensas están listas ahora?", "¡Si! Con las armas de Morkus, las barreras de madera de Renne y estas trampas, deberíamos tener una defensa sólida contra amenazas. El reino está mejor preparado. Tus esfuerzos han sido invaluables, [PLAYERNAME].");
        cvGetResources4.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(HUNTING_TRAP, 6, App.getPlayerChar());
            LibQuest.completeQuest(GETTING_RESOURCES, App.getPlayerChar(), 6, ctx);
        };
        npc.conversationOptions.add(cvGetResources4);

        // ========================================
        // QUEST: Giving Orders
        // ========================================
        ConversationOption cvGivingOrders1 = new ConversationOption(0, 14);
        cvGivingOrders1.addOptionText(ENGLISH, "What's next for the kingdom's defense?", "Good question, [PLAYERNAME]. With the resources secured, we now need to strategically position our forces. I've identified two critical locations that need immediate attention: Farmland and Helera. Both are vital to the kingdom, but we don't have enough manpower to fully reinforce both at once.");
        cvGivingOrders1.addOptionText(PORTUGUESE, "Qual é o próximo passo para a defesa do reino?", "Boa pergunta, [PLAYERNAME]. Com os recursos garantidos, agora precisamos posicionar estrategicamente nossas forças. Identifiquei dois locais críticos que precisam de atenção imediata: Farmland e Helera. Ambos são vitais para o reino, mas não temos mão de obra suficiente para reforçar ambos completamente de uma vez.");
        cvGivingOrders1.addOptionText(SPANISH, "¿Cuál es el siguiente paso para la defensa del reino?", "Buena pregunta, [PLAYERNAME]. Con los recursos asegurados, ahora necesitamos posicionar estratégicamente nuestras fuerzas. He identificado dos ubicaciones críticas que necesitan atención inmediata: Farmland y Helera. Ambas son vitales para el reino, pero no tenemos suficiente mano de obra para reforzar ambas completamente a la vez.");
        cvGivingOrders1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, GETTING_RESOURCES) &&
                    !LibQuest.charHasQuest(QuestsIds.GIVING_ORDERS, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvGivingOrders1);

        ConversationOption cvGivingOrders2 = new ConversationOption(14, 15);
        cvGivingOrders2.addOptionText(ENGLISH, "I understand. What do you need me to do?", "I need you to assess the situation at both locations. Go to Farmland and speak with Larien - she's the head farmer there and knows exactly what defenses they need. Then travel to Helera and talk to Yandov, he is one of the guards stationed on the city walls. Get a clear picture of what each place requires, then report back to me. Based on your findings, we'll make our decision.");
        cvGivingOrders2.addOptionText(PORTUGUESE, "Entendo. O que você precisa que eu faça?", "Preciso que você avalie a situação em ambos os locais. Vá a Farmland e fale com Larien - ela é a chefe dos fazendeiros lá e sabe exatamente quais defesas eles precisam. Depois viaje para Helera e fale com Yandov, ele é um dos guardas responsáveis estacionados nas muralhas da cidade. Tenha uma visão clara do que cada lugar precisa, e depois reporte para mim. Com base em suas descobertas, tomaremos nossa decisão.");
        cvGivingOrders2.addOptionText(SPANISH, "Entiendo. ¿Qué necesitas que haga?", "Necesito que evalúes la situación en ambas ubicaciones. Ve a Farmland y habla con Larien - ella es la jefa de los granjeros allí y sabe exactamente qué defensas necesitan. Luego viaja a Helera y habla con Yandov, es uno de los guardias apostados en las murallas de la ciudad. Obtén una imagen clara de lo que cada lugar requiere, luego repórtame. Basándonos en tus hallazgos, tomaremos nuestra decisión.");
        npc.conversationOptions.add(cvGivingOrders2);

        ConversationOption cvGivingOrders3 = new ConversationOption(15, 0);
        cvGivingOrders3.addOptionText(ENGLISH, "I'll assess both locations and return.", "Excellent. Time is of the essence. The sooner we can deploy our forces, the better chance we have of preventing catastrophe.");
        cvGivingOrders3.addOptionText(PORTUGUESE, "Vou avaliar ambos os locais e retornar.", "Excelente. O tempo é essencial. Quanto mais cedo pudermos mobilizar nossas forças, maior a chance de prevenir uma catástrofe.");
        cvGivingOrders3.addOptionText(SPANISH, "Evaluaré ambas ubicaciones y regresaré.", "Excelente. El tiempo es esencial. Cuanto antes podamos desplegar nuestras fuerzas, mejor oportunidad tendremos de prevenir una catástrofe.");
        cvGivingOrders3.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.GIVING_ORDERS, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvGivingOrders3);

        ///ABOUT QUEST: GIVING_ORDERS - PART 3 (Final Report)
        ConversationOption cvGivingOrders4 = new ConversationOption(0, 16);
        cvGivingOrders4.addOptionText(ENGLISH, "I've assessed both Farmland and Helera.", "Good work. So, what did you find? What are their needs?");
        cvGivingOrders4.addOptionText(PORTUGUESE, "Avaliei tanto Farmland quanto Helera.", "Bom trabalho. Então, o que você descobriu? Quais são as necessidades deles?");
        cvGivingOrders4.addOptionText(SPANISH, "He evaluado tanto Farmland como Helera.", "Buen trabajo. Entonces, ¿qué encontraste? ¿Cuáles son sus necesidades?");
        cvGivingOrders4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GIVING_ORDERS, 3)
                    && !LibQuest.isQuestComplete(chara, QuestsIds.GIVING_ORDERS)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvGivingOrders4);

        ConversationOption cvGivingOrders5 = new ConversationOption(16, 17);
        cvGivingOrders5.addOptionText(ENGLISH, "[Explain the situation at both locations]", "I see... This is difficult. Both locations are critical, and both are vulnerable.\nFarmland produces our food - without them, we face starvation within months. But Helera controls our trade and maritime defenses - losing the port would cripple our economy and cut off vital supply routes.\nWe simply don't have enough trained soldiers to adequately protect both simultaneously. We must prioritize.");
        cvGivingOrders5.addOptionText(PORTUGUESE, "[Explicar a situação em ambos os locais]", "Entendo... Isso é difícil. Ambos os locais são críticos, e ambos estão vulneráveis.\nFarmland produz nossa comida - sem eles, enfrentaríamos fome em meses. Mas Helera controla nosso comércio e defesas marítimas - perder o porto paralisaria nossa economia e cortaria rotas de suprimento vitais.\nSimplesmente não temos soldados treinados suficientes para proteger ambos adequadamente simultaneamente. Devemos priorizar.");
        cvGivingOrders5.addOptionText(SPANISH, "[Explicar la situación en ambas ubicaciones]", "Entiendo... Esto es difícil. Ambas ubicaciones son críticas, y ambas son vulnerables.\nFarmland produce nuestra comida - sin ellos, enfrentaremos hambruna en meses. Pero Helera controla nuestro comercio y defensas marítimas - perder el puerto paralizaría nuestra economía y cortaría rutas de suministro vitales.\nSimplemente no tenemos suficientes soldados entrenados para proteger adecuadamente a ambos simultáneamente. Debemos priorizar.");
        npc.conversationOptions.add(cvGivingOrders5);

        ConversationOption cvGivingOrders6 = new ConversationOption(17, 0);
        cvGivingOrders6.addOptionText(ENGLISH, "This is a tough decision.", "Indeed. [PLAYERNAME], you've proven yourself capable and trustworthy. I want you to think carefully about this choice. Come back when you're ready to tell me which location we should reinforce first. Your decision will shape the kingdom's immediate future.");
        cvGivingOrders6.addOptionText(PORTUGUESE, "Esta é uma decisão difícil.", "De fato. [PLAYERNAME], você provou ser capaz e confiável. Quero que pense cuidadosamente sobre essa escolha. Volte quando estiver pronto para me dizer qual local devemos reforçar primeiro. Sua decisão moldará o futuro imediato do reino.");
        cvGivingOrders6.addOptionText(SPANISH, "Esta es una decisión difícil.", "De hecho. [PLAYERNAME], has demostrado ser capaz y confiable. Quiero que pienses cuidadosamente sobre esta elección. Regresa cuando estés listo para decirme qué ubicación debemos reforzar primero. Tu decisión dará forma al futuro inmediato del reino.");
        cvGivingOrders6.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.GIVING_ORDERS, App.getPlayerChar(), 3, ctx);
        };
        npc.conversationOptions.add(cvGivingOrders6);

        ///ABOUT QUEST: GIVING_ORDERS - POST COMPLETION (Choice for next quest)
        ConversationOption cvGivingOrdersChoice = new ConversationOption(0, 18);
        cvGivingOrdersChoice.addOptionText(ENGLISH, "I've made my decision about the reinforcements.", "Good. This is a crucial moment. Which location do you believe we should prioritize?");
        cvGivingOrdersChoice.addOptionText(PORTUGUESE, "Tomei minha decisão sobre os reforços.", "Bom. Este é um momento crucial. Qual local você acredita que devemos priorizar?");
        cvGivingOrdersChoice.addOptionText(SPANISH, "He tomado mi decisión sobre los refuerzos.", "Bien. Este es un momento crucial. ¿Qué ubicación crees que deberíamos priorizar?");
        cvGivingOrdersChoice.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.GIVING_ORDERS) &&
                    !LibQuest.charHasQuest(QuestsIds.REINFORCE_HELERA, chara) &&
                    !LibQuest.charHasQuest(QuestsIds.REINFORCE_FARMLAND, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvGivingOrdersChoice);

        ConversationOption cvChoiceHelera = new ConversationOption(18, 0);
        cvChoiceHelera.addOptionText(ENGLISH, "We should reinforce Helera first.", "A strategic choice. The port and trade are vital. I'll prepare the orders immediately. You'll oversee the reinforcement of Helera while securing Farmland's supplies.");
        cvChoiceHelera.addOptionText(PORTUGUESE, "Devemos reforçar Helera primeiro.", "Uma escolha estratégica. O porto e comércio são vitais. Vou preparar as ordens imediatamente. Você vai supervisionar o reforço de Helera enquanto garante os suprimentos de Farmland.");
        cvChoiceHelera.addOptionText(SPANISH, "Deberíamos reforzar Helera primero.", "Una elección estratégica. El puerto y el comercio son vitales. Prepararé las órdenes de inmediato. Tú supervisarás el refuerzo de Helera mientras aseguras los suministros de Farmland.");
        cvChoiceHelera.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.REINFORCE_HELERA, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvChoiceHelera);

        ConversationOption cvChoiceFarmland = new ConversationOption(18, 0);
        cvChoiceFarmland.addOptionText(ENGLISH, "We should reinforce Farmland first.", "Protecting our food supply is wise. I'll prepare the orders immediately. You'll oversee the reinforcement of Farmland with defensive structures and support.");
        cvChoiceFarmland.addOptionText(PORTUGUESE, "Devemos reforçar Farmland primeiro.", "Proteger nosso suprimento de comida é sábio. Vou preparar as ordens imediatamente. Você vai supervisionar o reforço de Farmland com estruturas defensivas e apoio.");
        cvChoiceFarmland.addOptionText(SPANISH, "Deberíamos reforzar Farmland primero.", "Proteger nuestro suministro de alimentos es sabio. Prepararé las órdenes de inmediato. Tú supervisarás el refuerzo de Farmland con estructuras defensivas y apoyo.");
        cvChoiceFarmland.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.REINFORCE_FARMLAND, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvChoiceFarmland);

        // ========================================
        // QUEST: Rebuild Helera
        // ========================================
        ConversationOption cvRebuildHeleraComplete = new ConversationOption(0, 0);
        cvRebuildHeleraComplete.addOptionText(ENGLISH, "Helera's reconstruction is progressing well.", "Excellent work, [PLAYERNAME]. Thanks to your leadership, Helera is recovering. The people have hope again, and the city is being rebuilt stronger. Your efforts haven't gone unnoticed. However, we're not safe yet - the threat still looms over the kingdom. We must stay vigilant and prepare for what's to come.");
        cvRebuildHeleraComplete.addOptionText(PORTUGUESE, "A reconstrução de Helera está progredindo bem.", "Excelente trabalho, [PLAYERNAME]. Graças à sua liderança, Helera está se recuperando. As pessoas têm esperança novamente e a cidade está sendo reconstruída mais forte. Seus esforços não passaram despercebidos. No entanto, ainda não estamos a salvo - a ameaça ainda paira sobre o reino. Devemos permanecer vigilantes e nos preparar para o que está por vir.");
        cvRebuildHeleraComplete.addOptionText(SPANISH, "La reconstrucción de Helera está progresando bien.", "Excelente trabajo, [PLAYERNAME]. Gracias a tu liderazgo, Helera se está recuperando. La gente tiene esperanza nuevamente y la ciudad se está reconstruyendo más fuerte. Tus esfuerzos no han pasado desapercibidos. Sin embargo, aún no estamos a salvo - la amenaza aún se cierne sobre el reino. Debemos permanecer vigilantes y prepararnos para lo que viene.");
        cvRebuildHeleraComplete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.REBUILD_HELERA, 6) && !LibQuest.isQuestComplete(chara, QuestsIds.REBUILD_HELERA)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvRebuildHeleraComplete.listeners = (ctx, currentFragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.REBUILD_HELERA);
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);
        };
        npc.conversationOptions.add(cvRebuildHeleraComplete);

        // ========================================
        // QUEST: Rebuild Farmland
        // ========================================
        ConversationOption cvRebuildFarmland3 = new ConversationOption(0, 0);
        cvRebuildFarmland3.addOptionText(ENGLISH, "The Queen authorized soldiers to rebuild Farmland.", "Farmland... Yes, I heard about the devastation. It's a tragedy. Very well, I'll organize a group of soldiers to go there immediately. They'll help with heavy construction, security, and whatever else is needed. Tell Larien that Captain Ferros will lead the contingent - he's experienced in both combat and construction work. They should arrive within two days.");
        cvRebuildFarmland3.addOptionText(PORTUGUESE, "A Rainha autorizou soldados para reconstruir Farmland.", "Farmland... Sim, ouvi sobre a devastação. É uma tragédia. Muito bem, vou organizar um grupo de soldados para ir lá imediatamente. Eles ajudarão com construção pesada, segurança e o que mais for necessário. Diga a Larien que o Capitão Ferros liderará o contingente - ele é experiente tanto em combate quanto em trabalho de construção. Eles devem chegar em dois dias.");
        cvRebuildFarmland3.addOptionText(SPANISH, "La Reina autorizó soldados para reconstruir Farmland.", "Farmland... Sí, escuché sobre la devastación. Es una tragedia. Muy bien, organizaré un grupo de soldados para ir allí de inmediato. Ayudarán con construcción pesada, seguridad y lo que sea necesario. Dile a Larien que el Capitán Ferros liderará el contingente - tiene experiencia tanto en combate como en trabajo de construcción. Deberían llegar en dos días.");
        cvRebuildFarmland3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.REBUILD_FARMLAND, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvRebuildFarmland3.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.REBUILD_FARMLAND, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvRebuildFarmland3);

        // ===== QUEST: REBUILD_FARMLAND - PART 7 (Quest Completion) =====
        ConversationOption cvRebuildFarmlandComplete = new ConversationOption(0, 0);
        cvRebuildFarmlandComplete.addOptionText(ENGLISH, "Farmland's reconstruction is organized.", "Excellent work, [PLAYERNAME]. Farmland is the breadbasket of our kingdom - without it, we'd face famine within months. Thanks to your efforts, the people have hope, and food production will resume soon. The soldiers and workers you organized will make all the difference. However, we're still not safe. The creatures that attacked may return, and we must be prepared. Rest for now, but stay alert. Greater challenges lie ahead.");
        cvRebuildFarmlandComplete.addOptionText(PORTUGUESE, "A reconstrução de Farmland está organizada.", "Excelente trabalho, [PLAYERNAME]. Farmland é o celeiro do nosso reino - sem ela, enfrentaríamos fome em poucos meses. Graças aos seus esforços, o povo tem esperança, e a produção de alimentos será retomada em breve. Os soldados e trabalhadores que você organizou farão toda a diferença. No entanto, ainda não estamos a salvo. As criaturas que atacaram podem retornar, e devemos estar preparados. Descanse por agora, mas fique alerta. Desafios maiores estão por vir.");
        cvRebuildFarmlandComplete.addOptionText(SPANISH, "La reconstrucción de Farmland está organizada", "Excelente trabajo, [PLAYERNAME]. Farmland es el granero de nuestro reino - sin ella, enfrentaríamos hambruna en pocos meses. Gracias a tus esfuerzos, la gente tiene esperanza, y la producción de alimentos se reanudará pronto. Los soldados y trabajadores que organizaste marcarán la diferencia. Sin embargo, aún no estamos a salvo. Las criaturas que atacaron pueden regresar, y debemos estar preparados. Descansa por ahora, pero mantente alerta. Mayores desafíos nos esperan.");
        cvRebuildFarmlandComplete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.REBUILD_FARMLAND, 7) && !LibQuest.isQuestComplete(chara, QuestsIds.REBUILD_FARMLAND)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvRebuildFarmlandComplete.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.REBUILD_FARMLAND, App.getPlayerChar(), 7, ctx);
        };
        npc.conversationOptions.add(cvRebuildFarmlandComplete);

        // ========================================
        // QUEST: Wazel Battle
        // ========================================
        ConversationOption cvWazelBattleStart = new ConversationOption(0, 30);
        cvWazelBattleStart.addOptionText(ENGLISH, "What's our next move?", "Our scouts have been watching the eastern seas. Wazel - our key eastern ally - is now under threat from the same dark forces. Our alliance demands we respond. They cannot face this alone, and frankly, we need them standing. If Wazel falls, we lose a vital eastern ally and a critical trade route. You must go there immediately.");
        cvWazelBattleStart.addOptionText(PORTUGUESE, "Qual é nosso próximo passo?", "Nossos batedores têm observado os mares orientais. Wazel - nossa principal aliada oriental - agora está sob ameaça das mesmas forças das trevas. Nossa aliança exige que respondamos. Eles não podem enfrentar isso sozinhos, e francamente, precisamos deles de pé. Se Wazel cair, perdemos um aliado oriental vital e uma rota comercial crítica. Você deve ir até lá imediatamente.");
        cvWazelBattleStart.addOptionText(SPANISH, "¿Cuál es nuestro próximo movimiento?", "Nuestros exploradores han estado vigilando los mares orientales. Wazel - nuestra principal aliada oriental - ahora está bajo amenaza de las mismas fuerzas oscuras. Nuestra alianza exige que respondamos. No pueden enfrentar esto solos, y francamente, los necesitamos en pie. Si Wazel cae, perdemos un aliado oriental vital y una ruta comercial crítica. Debes ir allí de inmediato.");
        cvWazelBattleStart.requirementValidations = (chara, ctx) -> {
            boolean rebuildDone = LibQuest.isQuestComplete(chara, QuestsIds.REBUILD_HELERA)
                    || LibQuest.isQuestComplete(chara, QuestsIds.REBUILD_FARMLAND);
            if (rebuildDone && !LibQuest.charHasQuest(QuestsIds.WAZEL_BATTLE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvWazelBattleStart);

        // ========================================
        // ROLEPLAY: After Rebuild (before Wazel Battle)
        // ========================================
        ConversationOption cvRoleplayRebuild = new ConversationOption(0, 0);
        cvRoleplayRebuild.addOptionText(ENGLISH, "How are the reconstructions going?", "*Nods with satisfaction*\nThe reconstructions are proceeding well, [PLAYERNAME]. Our engineers and workers have been doing excellent work. The damaged structures are being rebuilt, and the people are regaining their confidence. \n*crosses arms*\nIt takes time to fully recover from such attacks, but the progress is encouraging. We're establishing better watchtowers for early warning. We're ahead of schedule.");
        cvRoleplayRebuild.addOptionText(PORTUGUESE, "Como estão as reconstruções?", "*Acena com satisfação*\nAs reconstruções estão decorrendo bem, [PLAYERNAME]. Nossos engenheiros e trabalhadores têm feito um excelente trabalho. As estruturas danificadas estão sendo reconstruídas, e o povo está recuperando sua confiança. \n*cruza os braços*\nLeva tempo para se recuperar totalmente de tais ataques, mas o progresso é encorajador. Estamos estabelecendo melhores torres de vigia para alerta precoce. Estamos adiantados no cronograma.");
        cvRoleplayRebuild.addOptionText(SPANISH, "¿Cómo van las reconstrucciones?", "*Asiente con satisfacción*\nLas reconstrucciones están procediendo bien, [PLAYERNAME]. Nuestros ingenieros y trabajadores han estado haciendo un excelente trabajo. Las estructuras dañadas están siendo reconstruidas, y la gente está recuperando su confianza. \n*cruza los brazos*\nLleva tiempo recuperarse completamente de tales ataques, pero el progreso es alentador. Estamos estableciendo mejores torres de vigilancia para alerta temprana. Estamos adelantados en el cronograma.");
        cvRoleplayRebuild.requirementValidations = (chara, ctx) -> {
            boolean rebuildDone = LibQuest.isQuestComplete(chara, QuestsIds.REBUILD_HELERA)
                    || LibQuest.isQuestComplete(chara, QuestsIds.REBUILD_FARMLAND);
            boolean wazelNotCompleted = !LibQuest.isQuestComplete(chara, QuestsIds.WAZEL_BATTLE);
            if (rebuildDone && wazelNotCompleted) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplayRebuild);

        ConversationOption cvWazelBattleStartResponse = new ConversationOption(30, 0);
        cvWazelBattleStartResponse.addOptionText(ENGLISH, "I'll go to Wazel.", "Good. Travel to Wazel and find Katiusca - she's their sentinel commander, she'll have the full picture of the threat. Then coordinate with whoever is leading their defense. Wazel warriors are fierce, but they'll need your experience against these dark creatures. Go, and may fortune favor you.");
        cvWazelBattleStartResponse.addOptionText(PORTUGUESE, "Vou para Wazel.", "Bem. Viaje para Wazel e encontre Katiusca - ela é a comandante sentinela deles, ela terá o quadro completo da ameaça. Depois coordene com quem está liderando a defesa deles. Os guerreiros de Wazel são ferozes, mas precisarão da sua experiência contra essas criaturas das trevas. Vá, e que a fortuna te favoreça.");
        cvWazelBattleStartResponse.addOptionText(SPANISH, "Iré a Wazel.", "Bien. Viaja a Wazel y encuentra a Katiusca - es su comandante centinela, tendrá el panorama completo de la amenaza. Luego coordina con quien esté liderando su defensa. Los guerreros de Wazel son feroces, pero necesitarán tu experiencia contra estas criaturas oscuras. Ve, y que la fortuna te favorezca.");
        cvWazelBattleStartResponse.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.WAZEL_BATTLE, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvWazelBattleStartResponse);

        // ========================================
        // QUEST: Strategy
        // ========================================
        ConversationOption cvWazelComplete = new ConversationOption(0, 19);
        cvWazelComplete.addOptionText(ENGLISH, "I've returned from Wazel.", "Ah, [PLAYERNAME]! I was hoping you'd survive. \n*looks at you with a mixture of relief and concern*\nTell me, what happened there? The reports we received were... disturbing.");
        cvWazelComplete.addOptionText(PORTUGUESE, "Voltei de Wazel.", "Ah, [PLAYERNAME]! Eu esperava que você sobrevivesse. \n*olha para você com uma mistura de alívio e preocupação*\nMe diga, o que aconteceu lá? Os relatórios que recebemos foram... perturbadores.");
        cvWazelComplete.addOptionText(SPANISH, "He regresado de Wazel.", "¡Ah, [PLAYERNAME]! Esperaba que sobrevivieras. \n*te mira con una mezcla de alivio y preocupación*\nDime, ¿qué sucedió allí? Los informes que recibimos fueron... inquietantes.");
        cvWazelComplete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.WAZEL_BATTLE) &&
                    !LibQuest.charHasQuest(QuestsIds.STRATEGY, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvWazelComplete);

        ConversationOption cvWazel2 = new ConversationOption(19, 20);
        cvWazel2.addOptionText(ENGLISH, "Wazel is in ruins. The attacks were devastating.", "*clenches fist*\nDamn it. I feared as much. Multiple waves of dark creatures, correct? This confirms what I suspected - these attacks are coordinated. Someone or something is orchestrating this assault on our kingdoms. This isn't random chaos. This is war.");
        cvWazel2.addOptionText(PORTUGUESE, "Wazel está em ruínas. Os ataques foram devastadores.", "*fecha o punho*\nDroga. Eu temia isso. Múltiplas ondas de criaturas das trevas, correto? Isso confirma o que eu suspeitava - esses ataques são coordenados. Alguém ou algo está orquestrando este ataque aos nossos reinos. Isso não é caos aleatório. Isso é guerra.");
        cvWazel2.addOptionText(SPANISH, "Wazel está en ruinas. Los ataques fueron devastadores.", "*cierra el puño*\nMaldición. Temía eso. Múltiples oleadas de criaturas oscuras, ¿correcto? Esto confirma lo que sospechaba: estos ataques están coordinados. Alguien o algo está orquestando este asalto a nuestros reinos. Esto no es caos aleatorio. Esto es guerra.");
        npc.conversationOptions.add(cvWazel2);

        ConversationOption cvWazel3 = new ConversationOption(20, 21);
        cvWazel3.addOptionText(ENGLISH, "We barely held them off. Our forces aren't enough.", "*paces back and forth*\nYou're right. I've been analyzing our battles. Conventional warfare won't win this. Our swords and shields, brave as our soldiers are, can't match the raw power of these creatures. We're fighting enemies that shouldn't exist - creatures born of dark magic.");
        cvWazel3.addOptionText(PORTUGUESE, "Mal conseguimos detê-los. Nossas forças não são suficientes.", "*anda de um lado para o outro*\nVocê está certo. Venho analisando nossas batalhas. A guerra convencional não vencerá isso. Nossas espadas e escudos, por mais corajosos que nossos soldados sejam, não podem igualar o poder bruto dessas criaturas. Estamos lutando contra inimigos que não deveriam existir - criaturas nascidas de magia negra.");
        cvWazel3.addOptionText(SPANISH, "Apenas los contuvimos. Nuestras fuerzas no son suficientes.", "*camina de un lado a otro*\nTienes razón. He estado analizando nuestras batallas. La guerra convencional no ganará esto. Nuestras espadas y escudos, por valientes que sean nuestros soldados, no pueden igualar el poder bruto de estas criaturas. Estamos luchando contra enemigos que no deberían existir: criaturas nacidas de magia oscura.");
        npc.conversationOptions.add(cvWazel3);

        ConversationOption cvWazel4 = new ConversationOption(21, 22);
        cvWazel4.addOptionText(ENGLISH, "What do you suggest we do?", "*stops pacing, looks directly at you*\nWe need to fight magic with magic. But humans... we've lost most of our ancient magical knowledge. It died with the old mages generations ago. However, there's one people who never lost that knowledge - the elves of Ayalon.");
        cvWazel4.addOptionText(PORTUGUESE, "O que você sugere que façamos?", "*para de andar, olha diretamente para você*\nPrecisamos lutar contra magia com magia. Mas nós humanos... perdemos a maior parte de nosso conhecimento mágico ancestral. Morreu com os velhos magos há gerações. No entanto, há um povo que nunca perdeu esse conhecimento - os elfos de Ayalon.");
        cvWazel4.addOptionText(SPANISH, "¿Qué sugieres que hagamos?", "*deja de caminar, te mira directamente*\nNecesitamos luchar contra la magia con magia. Pero los humanos... hemos perdido la mayor parte de nuestro conocimiento mágico ancestral. Murió con los viejos magos hace generaciones. Sin embargo, hay un pueblo que nunca perdió ese conocimiento: los elfos de Ayalon.");
        npc.conversationOptions.add(cvWazel4);

        ConversationOption cvWazel5 = new ConversationOption(22, 0);
        cvWazel5.addOptionText(ENGLISH, "The elves? They haven't spoken to humans in decades.", "Exactly. And that's the problem. But desperate times call for desperate measures. I need to speak with Queen Enola about this. [PLAYERNAME], this is beyond my authority alone. Go to the castle and speak with the Queen. Explain what we've discussed. If anyone can convince the elves to help us, it will require royal diplomacy. Tell her I sent you and that I believe seeking elven aid is our best - perhaps our only - strategy against this threat.");
        cvWazel5.addOptionText(PORTUGUESE, "Os elfos? Eles não falam com humanos há décadas.", "Exatamente. E esse é o problema. Mas tempos desesperadores exigem medidas desesperadas. Preciso falar com a Rainha Enola sobre isso. [PLAYERNAME], isso está além da minha autoridade sozinho. Vá ao castelo e fale com a Rainha. Explique o que discutimos. Se alguém pode convencer os elfos a nos ajudarem, será necessária diplomacia real. Diga a ela que eu te enviei e que acredito que buscar ajuda élfica é nossa melhor - talvez nossa única - estratégia contra essa ameaça.");
        cvWazel5.addOptionText(SPANISH, "¿Los elfos? No han hablado con humanos en décadas.", "Exactamente. Y ese es el problema. Pero tiempos desesperados requieren medidas desesperadas. Necesito hablar con la Reina Enola sobre esto. [PLAYERNAME], esto está más allá de mi autoridad sola. Ve al castillo y habla con la Reina. Explica lo que hemos discutido. Si alguien puede convencer a los elfos de ayudarnos, requerirá diplomacia real. Dile que te envié y que creo que buscar ayuda élfica es nuestra mejor - quizás nuestra única - estrategia contra esta amenaza.");
        cvWazel5.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.STRATEGY, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvWazel5);

        // ========================================
        // QUEST: Magical Supplies
        // ========================================
        ConversationOption cvMagicalSupplies1 = new ConversationOption(0, 23);
        cvMagicalSupplies1.addOptionText(ENGLISH, "Guzar, Nelera is making progress translating the elven texts. What news do you have?", "*Expression darkens*\nThe news isn't good, [PLAYERNAME]. My scouts have been gathering intelligence from across the kingdom and beyond. What they've discovered... it's worse than we feared. The attacks we've been facing aren't random - they're coordinated. Preparation for something far more terrible.");
        cvMagicalSupplies1.addOptionText(PORTUGUESE, "Guzar, Nelera está progredindo na tradução dos textos élficos. Que notícias você tem?", "*Expressão escurece*\nAs notícias não são boas, [PLAYERNAME]. Meus batedores têm reunido informações de todo o reino e além. O que descobriram... é pior do que temíamos. Os ataques que enfrentamos não são aleatórios - são coordenados. Preparação para algo muito mais terrível.");
        cvMagicalSupplies1.addOptionText(SPANISH, "Guzar, Nelera está progresando en la traducción de los textos élficos. ¿Qué noticias tienes?", "*La expresión se oscurece*\nLas noticias no son buenas, [PLAYERNAME]. Mis exploradores han estado reuniendo inteligencia de todo el reino y más allá. Lo que han descubierto... es peor de lo que temíamos. Los ataques que hemos enfrentado no son aleatorios - están coordinados. Preparación para algo mucho más terrible.");
        cvMagicalSupplies1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.MAGICAL_SUPPLIES, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvMagicalSupplies1);

        ConversationOption cvMagicalSupplies2 = new ConversationOption(23, 24);
        cvMagicalSupplies2.addOptionText(ENGLISH, "What have you discovered?", "We captured one of the dark cultists during a raid near Bastian. Before he... expired... he revealed something chilling. These attacks are summoning rituals. Each dark creature that crosses into our world weakens the barrier between realms. They're preparing to summon their leader.");
        cvMagicalSupplies2.addOptionText(PORTUGUESE, "O que você descobriu?", "Capturamos um dos cultistas das trevas durante uma invasão perto de Bastian. Antes dele... expirar... revelou algo arrepiante. Esses ataques são rituais de invocação. Cada criatura das trevas que cruza para nosso mundo enfraquece a barreira entre os reinos. Estão se preparando para invocar seu líder.");
        cvMagicalSupplies2.addOptionText(SPANISH, "¿Qué has descubierto?", "Capturamos a uno de los cultistas oscuros durante una redada cerca de Bastian. Antes de que... expirara... reveló algo escalofriante. Estos ataques son rituales de invocación. Cada criatura oscura que cruza a nuestro mundo debilita la barrera entre reinos. Están preparándose para invocar a su líder.");
        npc.conversationOptions.add(cvMagicalSupplies2);

        ConversationOption cvMagicalSupplies3 = new ConversationOption(24, 0);
        cvMagicalSupplies3.addOptionText(ENGLISH, "Their leader? Who is this being?", "*Leans in, voice low*\nThe cultist called him Targon - the Dark Lord. A demon of immense power from the underworld. If they succeed in fully summoning him to our realm... \n*shakes head*\nOur armies, our weapons, even our courage won't be enough. We need magical knowledge to combat magical threats. You must return to Nelera immediately. Tell her what we've learned. Perhaps the elven texts contain information about how to stop such a summoning - or at least how to send this demon back to where it came from.");
        cvMagicalSupplies3.addOptionText(PORTUGUESE, "Seu líder? Quem é esse ser?", "*Inclina-se, voz baixa*\nO cultista o chamou de Targon - o Senhor das Trevas. Um demônio de imenso poder do submundo. Se conseguirem invocá-lo completamente para nosso reino... \n*balança a cabeça*\nNossos exércitos, nossas armas, até nossa coragem não serão suficientes. Precisamos de conhecimento mágico para combater ameaças mágicas. Você deve retornar para Nelera imediatamente. Diga a ela o que descobrimos. Talvez os textos élficos contenham informações sobre como parar tal invocação - ou pelo menos como mandar esse demônio de volta para onde veio.");
        cvMagicalSupplies3.addOptionText(SPANISH, "¿Su líder? ¿Quién es este ser?", "*Se inclina, voz baja*\nEl cultista lo llamó Targon - el Señor Oscuro. Un demonio de inmenso poder del inframundo. Si logran invocarlo completamente a nuestro reino... \n*sacude la cabeza*\nNuestros ejércitos, nuestras armas, incluso nuestro coraje no serán suficientes. Necesitamos conocimiento mágico para combatir amenazas mágicas. Debes volver con Nelera inmediatamente. Dile lo que hemos descubierto. Quizás los textos élficos contengan información sobre cómo detener tal invocación - o al menos cómo enviar a este demonio de vuelta de donde vino.");
        cvMagicalSupplies3.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.MAGICAL_SUPPLIES, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvMagicalSupplies3);

        // ========================================
        // QUEST: One Last Ingredient
        // ========================================
        ConversationOption cvOneLastIngredient1 = new ConversationOption(0, 25);
        cvOneLastIngredient1.addOptionText(ENGLISH, "Guzar, I need to find a dark cultist. Casiel requires their blood for the counter-portal.", "*Expression hardens*\nA dark cultist's blood... \n*pauses thoughtfully*\nThat's grim business, but if the elven mage says it's necessary, then we have no choice. Let me think... \n*walks to a map on the wall*\n");
        cvOneLastIngredient1.addOptionText(PORTUGUESE, "Guzar, preciso encontrar um cultista das trevas. Casiel precisa do sangue deles para o contra-portal.", "*Expressão endurece*\nSangue de um cultista das trevas... \n*pausa pensativo*\nÉ um negócio sombrio, mas se o mago élfico diz que é necessário, então não temos escolha. Deixe-me pensar... \n*caminha até um mapa na parede*\n");
        cvOneLastIngredient1.addOptionText(SPANISH, "Guzar, necesito encontrar a un cultista oscuro. Casiel requiere su sangre para el contraportal.", "*La expresión se endurece*\nSangre de un cultista oscuro... \n*pausa pensativo*\nEs un asunto sombrío, pero si el mago élfico dice que es necesario, entonces no tenemos elección. Déjame pensar... \n*camina hacia un mapa en la pared*\n");
        cvOneLastIngredient1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ONE_LAST_INGREDIENT, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvOneLastIngredient1);

        ConversationOption cvOneLastIngredient2 = new ConversationOption(25, 0);
        cvOneLastIngredient2.addOptionText(ENGLISH, "Do you have any leads?", "*Points at the map*\nThe cultist we captured mentioned Esperand. Remember where this all started? The first portal, the first dark creatures - they appeared in the frozen cave there. \n*taps the location*\nThat wasn't random, [PLAYERNAME]. The cultists chose that location deliberately - the dimensional barrier is thinnest in places of extreme cold or heat.\n\nIf I were a dark mage trying to complete Targon's summoning, I'd return to ground zero - the frozen cave in Esperand. It's isolated, powerful, and they've already established rituals there. Start your search at the frozen cave. With luck, you'll find a cultist still performing ceremonies. Be careful - these fanatics won't surrender easily.");
        cvOneLastIngredient2.addOptionText(PORTUGUESE, "Você tem alguma pista?", "*Aponta para o mapa*\nO cultista que capturamos mencionou Esperand. Lembra onde tudo começou? O primeiro portal, as primeiras criaturas das trevas - apareceram na caverna congelada lá. \n*toca o local*\nIsso não foi aleatório, [PLAYERNAME]. Os cultistas escolheram esse local deliberadamente - a barreira dimensional é mais fina em lugares de frio ou calor extremos.\n\nSe eu fosse um mago das trevas tentando completar a invocação de Targon, retornaria ao marco zero - a caverna congelada em Esperand. É isolada, poderosa, e eles já estabeleceram rituais lá. Comece sua busca na caverna congelada. Com sorte, encontrará um cultista ainda realizando cerimônias. Cuidado - esses fanáticos não se renderão facilmente.");
        cvOneLastIngredient2.addOptionText(SPANISH, "¿Tienes alguna pista?", "*Señala el mapa*\nEl cultista que capturamos mencionó Esperand. ¿Recuerdas dónde comenzó todo? El primer portal, las primeras criaturas oscuras - aparecieron en la cueva helada allí. \n*toca la ubicación*\nEso no fue aleatorio, [PLAYERNAME]. Los cultistas eligieron ese lugar deliberadamente - la barrera dimensional es más delgada en lugares de frío o calor extremos.\n\nSi yo fuera un mago oscuro tratando de completar la invocación de Targon, volvería al punto cero - la cueva helada en Esperand. Es aislada, poderosa, y ya han establecido rituales allí. Comienza tu búsqueda en la cueva helada. Con suerte, encontrarás un cultista aún realizando ceremonias. Ten cuidado - estos fanáticos no se rendirán fácilmente.");
        cvOneLastIngredient2.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.ONE_LAST_INGREDIENT, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvOneLastIngredient2);

        // ========================================
        // QUEST: Traitor
        // ========================================
        ConversationOption cvTraitor1 = new ConversationOption(0, 26);
        cvTraitor1.addOptionText(ENGLISH, "Guzar! It's Casiel - he's the traitor behind everything!", "*Face turns grave*\nCasiel? The elven mage? Are you certain? \n*sees the urgency in your eyes*\nTell me everything, quickly!");
        cvTraitor1.addOptionText(PORTUGUESE, "Guzar! É Casiel - ele é o traidor por trás de tudo!", "*Rosto fica sério*\nCasiel? O mago élfico? Tem certeza? \n*vê a urgência em seus olhos*\nMe conte tudo, rapidamente!");
        cvTraitor1.addOptionText(SPANISH, "¡Guzar! Es Casiel - ¡él es el traidor detrás de todo!", "*El rostro se pone serio*\n¿Casiel? ¿El mago élfico? ¿Estás seguro? \n*ve la urgencia en tus ojos*\n¡Cuéntame todo, rápidamente!");
        cvTraitor1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.TRAITOR, 5)
                    && !LibQuest.isQuestComplete(chara, QuestsIds.TRAITOR)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvTraitor1);

        ConversationOption cvTraitor2 = new ConversationOption(26, 27);
        cvTraitor2.addOptionText(ENGLISH, "He confessed everything at Great Rock Peak!", "*Listens intently*\nBy the gods... He forged the book, gave us a false spell, orchestrated Targon's death... all to claim the Death King position. \n*slams fist on table*\nThis is worse than we feared!");
        cvTraitor2.addOptionText(PORTUGUESE, "Ele confessou tudo no pico da Grande Rocha!", "*Escuta atentamente*\nPelos deuses... Ele forjou o livro, nos deu um feitiço falso, orquestrou a morte de Targon... tudo para reivindicar a posição de Rei da Morte. \n*bate o punho na mesa*\nIsso é pior do que temíamos!");
        cvTraitor2.addOptionText(SPANISH, "¡Lo confesó todo en la cima de la Gran Roca!", "*Escucha atentamente*\nPor los dioses... Falsificó el libro, nos dio un hechizo falso, orquestó la muerte de Targon... todo para reclamar la posición de Rey de la Muerte. \n*golpea el puño en la mesa*\n¡Esto es peor de lo que temíamos!");
        npc.conversationOptions.add(cvTraitor2);

        ConversationOption cvTraitor3 = new ConversationOption(27, 0);
        cvTraitor3.addOptionText(ENGLISH, "He's absorbing power from magical sources now.", "*Stands urgently*\nThen we have little time. Wait - \n*a messenger runs in*\nEmperor Arilas just sent word. Casiel was spotted in the Elven Gardens of Ayalon - where the Nature Tree grows. If he absorbs that power... [PLAYERNAME], you must go there NOW! This is our last chance to stop him!");
        cvTraitor3.addOptionText(PORTUGUESE, "Ele está absorvendo poder de fontes mágicas agora.", "*Levanta-se urgentemente*\nEntão temos pouco tempo. Espere - \n*um mensageiro corre*\nO Imperador Arilas acabou de enviar aviso. Casiel foi avistado nos Jardins Élficos de Ayalon - onde cresce a Árvore da Natureza. Se ele absorver esse poder... [PLAYERNAME], você deve ir lá AGORA! Esta é nossa última chance de detê-lo!");
        cvTraitor3.addOptionText(SPANISH, "Está absorbiendo poder de fuentes mágicas ahora.", "*Se levanta urgentemente*\nEntonces tenemos poco tiempo. Espera - \n*un mensajero entra corriendo*\nEl Emperador Arilas acaba de enviar aviso. Casiel fue avistado en los Jardines Élficos de Ayalon - donde crece el Árbol de la Naturaleza. Si absorbe ese poder... [PLAYERNAME], ¡debes ir allí AHORA! ¡Esta es nuestra última oportunidad para detenerlo!");
        cvTraitor3.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.TRAITOR, App.getPlayerChar(), 6, ctx);
            LibQuest.includeQuestToQuestbook(QuestsIds.ELFS_ALERT, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvTraitor3);

        // ========================================
        // ROLEPLAY: After Elfs Alert (before The Final Battle)
        // ========================================
        ConversationOption cvRoleplayAfterElfsAlert = new ConversationOption(0, 0);
        cvRoleplayAfterElfsAlert.addOptionText(ENGLISH, "I need advice on how to prepare to face a powerful mage.", "*Crosses arms thoughtfully*\nFacing a mage of Casiel's caliber... this isn't like fighting beasts or cultists. \n*looks at you seriously*\nYou'll need the best equipment you can find - strong armor, a powerful weapon. But most importantly, stock up on health and mana potions. Lots of them. In magical combat, whoever runs out of resources first loses. Don't skimp on preparation, [PLAYERNAME]. Visit the blacksmith, the alchemist, buy everything you need. Your life depends on it.");
        cvRoleplayAfterElfsAlert.addOptionText(PORTUGUESE, "Preciso de conselhos sobre como me preparar para enfrentar um mago poderoso.", "*Cruza os braços pensativo*\nEnfrentar um mago do calibre de Casiel... isso não é como lutar contra bestas ou cultistas. \n*olha para você seriamente*\nVocê vai precisar do melhor equipamento que puder encontrar - armadura forte, uma arma poderosa. Mas o mais importante, estoque poções de vida e mana. Muitas delas. Em combate mágico, quem ficar sem recursos primeiro perde. Não economize na preparação, [PLAYERNAME]. Visite o ferreiro, o alquimista, compre tudo que precisar. Sua vida depende disso.");
        cvRoleplayAfterElfsAlert.addOptionText(SPANISH, "Necesito consejos sobre cómo prepararme para enfrentar a un mago poderoso.", "*Cruza los brazos pensativo*\nEnfrentar a un mago del calibre de Casiel... esto no es como luchar contra bestias o cultistas. \n*te mira seriamente*\nNecesitarás el mejor equipo que puedas encontrar - armadura fuerte, un arma poderosa. Pero lo más importante, abastécete de pociones de vida y maná. Muchas de ellas. En combate mágico, quien se queda sin recursos primero pierde. No escatimes en preparación, [PLAYERNAME]. Visita al herrero, al alquimista, compra todo lo que necesites. Tu vida depende de ello.");
        cvRoleplayAfterElfsAlert.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.ELFS_ALERT)
                    && !LibQuest.isQuestComplete(chara, QuestsIds.THE_FINAL_BATTLE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplayAfterElfsAlert);

        // ========================================
        // ROLEPLAY: After The Final Battle
        // ========================================
        ConversationOption cvRoleplayAfterFinalBattle = new ConversationOption(0, 0);
        cvRoleplayAfterFinalBattle.addOptionText(ENGLISH, "The threat is over.", "*Smiles with visible relief*\n[PLAYERNAME], you did the impossible! When word arrived that Casiel had fallen and the portals were sealed, I could barely believe it. You saved not just Havarus, but all of our allied kingdoms. \n*extends hand firmly*\nHistory will remember you as the hero who defeated the Death King. The army of Havarus salutes you with the highest honor!");
        cvRoleplayAfterFinalBattle.addOptionText(PORTUGUESE, "A ameaça acabou.", "*Sorri com alívio visível*\n[PLAYERNAME], você fez o impossível! Quando a notícia chegou de que Casiel havia caído e os portais foram selados, mal pude acreditar. Você salvou não apenas Havarus, mas todos os nossos reinos aliados. \n*estende a mão firmemente*\nA história se lembrará de você como o herói que derrotou o Rei da Morte. O exército de Havarus te saúda com a mais alta honra!");
        cvRoleplayAfterFinalBattle.addOptionText(SPANISH, "La amenaza ha terminado.", "*Sonríe con alivio visible*\n[PLAYERNAME], ¡hiciste lo imposible! Cuando llegó la noticia de que Casiel había caído y los portales fueron sellados, apenas pude creerlo. Salvaste no solo a Havarus, sino a todos nuestros reinos aliados. \n*extiende la mano firmemente*\nLa historia te recordará como el héroe que derrotó al Rey de la Muerte. ¡El ejército de Havarus te saluda con el más alto honor!");
        cvRoleplayAfterFinalBattle.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.THE_FINAL_BATTLE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplayAfterFinalBattle);

        // ========================================
        // ROLEPLAY: General conversations (early game)
        // ========================================
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What can you tell about you?", "Well, my name is Guzar Strongarm, I am a soldier of the royal army since when I was 17. Now I am the leader of the army. Toghether with the queen I elaborate strategies for defenses and battles.");
        cv1.addOptionText(PORTUGUESE, "O que você pode me dizer sobre você?", "Bem, meu nome é Guzar Strongarm, sou um soldado do exército real desde os 17 anos. Agora sou o líder do exército. Junto com a rainha, elaboro estratégias para defesas e batalhas.");
        cv1.addOptionText(SPANISH, "¿Qué puedes contarme sobre ti?", "Bueno, mi nombre es Guzar Strongarm, soy un soldado al servicio de la Reina Enola de Havarus desde que tenía 17 años. Ahora soy el líder del ejército. Junto con la reina elaboro estrategias para defensas y batallas.");
        cv1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, WHO_IS_THE_ENEMY)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "What can you say about the army?", "The royal army of Havarus is probably the most powerful army. We have men enough to fight every battle against other armies. Also, our weapons and armors are made with very good materials that are durable and sharp.");
        cv2.addOptionText(PORTUGUESE, "O que você pode dizer sobre o exército?", "O exército real de Havarus é um dos mais fortes da região. Temos soldados bem treinados e leais que defendem nosso reino com honra e coragem.");
        cv2.addOptionText(SPANISH, "¿Qué puedes decirme sobre el ejército?", "El ejército real de Havarus es probablemente el más poderoso. Tenemos suficientes hombres para luchar en cada batalla contra otros ejércitos. Además, nuestras armas y armaduras están hechas con muy buenos materiales que son duraderos e afilados.");
        cv2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, WHO_IS_THE_ENEMY)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cv2);

        ConversationOption cvRoleplayGeneral = new ConversationOption(0, 0);
        cvRoleplayGeneral.addOptionText(ENGLISH, "What's it like being the general of the royal guard?", "*Pauses thoughtfully*\nIt's a serious and gratifying work, but carries immense responsibility. Every decision I make affects the entire kingdom. \n*looks at you directly*\nWhen I send men into battle, some may not return. When I plan defenses, I'm protecting thousands of lives. It's a weight that never leaves, but knowing my strategies keep our people safe drives me every day.");
        cvRoleplayGeneral.addOptionText(PORTUGUESE, "Como é ser o general da guarda real?", "*Pausa pensativo*\nÉ um trabalho sério e gratificante, mas carrega imensa responsabilidade. Cada decisão que tomo afeta todo o reino. \n*olha diretamente para você*\nQuando envio homens para a batalha, alguns podem não retornar. Quando planejo defesas, estou protegendo milhares de vidas. É um peso constante, mas saber que minhas estratégias mantêm nosso povo seguro me motiva todos os dias.");
        cvRoleplayGeneral.addOptionText(SPANISH, "¿Cómo es ser el general de la guardia real?", "*Pausa pensativo*\nEs un trabajo serio y gratificante, pero conlleva inmensa responsabilidad. Cada decisión que tomo afecta a todo el reino. \n*te mira directamente*\nCuando envío hombres a la batalla, algunos pueden no regresar. Cuando planeo defensas, estoy protegiendo miles de vidas. Es un peso constante, pero saber que mis estrategias mantienen a nuestra gente segura me impulsa cada día.");
        npc.conversationOptions.add(cvRoleplayGeneral);

        return npc;
    }
}
