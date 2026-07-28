package com.cnx.endlesstalestwo.data.npcs.havarusSouth.fishermanVille;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.STUDYING_FISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.FishesDelivery;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Jack extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Jack");
        npc.age = 41;
        npc.job = Enums.NPCJobs.MALE_FISHERMAN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A strong and hardworking man.\nHe seeks the best for the village and for his family. He is Dalia's son.\n\nHis physical traits: Sparse beard. Focused gaze with deep eyes. He uses a cloth to cover the top of his head.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um homem forte e trabalhador.\nBusca o melhor para a vila e para sua família. É filho de Dalia.\n\nSeus traços físicos: Barba rala. Olhar compenetrado com olhos profundos. Utiliza um tecido para cobrir o topo da cabeça.");
        npc.addDescriptionTranslation(SPANISH, "Un hombre fuerte y trabajador.\nBusca lo mejor para la aldea y para su familia. Es hijo de Dalia.\n\nSus rasgos físicos: Barba rala. Mirada concentrada con ojos profundos. Utiliza una tela para cubrir la parte superior de su cabeza.");
        npc.canBePickpocketed = true;

        npc.hasRandomizedConversations = true;

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Do you prefer fishing at dawn or at night?", "Dawn for work, night for thought. In the first light, the sea rewards discipline. After dark, it rewards experience - and punishes fools.");
        cv1.addOptionText(PORTUGUESE, "Você prefere pescar ao amanhecer ou à noite?", "Amanhecer para trabalhar, noite para pensar. Na primeira luz, o mar recompensa disciplina. Depois do escuro, recompensa experiência - e pune tolos.");
        cv1.addOptionText(SPANISH, "¿Prefieres pescar al amanecer o de noche?", "Amanecer para trabajar, noche para pensar. Con la primera luz, el mar recompensa la disciplina. Después de oscurecer, recompensa la experiencia... y castiga a los tontos.");
        npc.conversationOptions.add(cv1);

        // ========================================
        // QUEST: FISHES DELIVERY
        // ========================================

        // Start quest offer
        ConversationOption cvQuestOffer = new ConversationOption(0, 1);
        cvQuestOffer.addOptionText(ENGLISH, "Need some help with your fishing business?",
                "Ha! Actually, yes. I have more deliveries than I can handle alone. I need bread for bait — good bread brings the fish up quick.\nBring me 5 loaves and I'll fill 4 buckets with fresh catch. You deliver them across the cities. I'll make it worth your while.");
        cvQuestOffer.addOptionText(PORTUGUESE, "Precisa de ajuda com o seu negócio de pesca?",
                "Ha! Na verdade, sim. Tenho mais entregas do que consigo fazer sozinho. Preciso de pão para isca — pão bom atrai os peixes rápido.\nTraga-me 5 pães e vou encher 4 baldes com captura fresca. Você os entrega pelas cidades. Vou compensar sua ajuda.");
        cvQuestOffer.addOptionText(SPANISH, "¿Necesitas ayuda con tu negocio de pesca?",
                "¡Ha! En realidad, sí. Tengo más entregas de las que puedo manejar solo. Necesito pan para carnada — el buen pan atrae rápido a los peces.\nTráeme 5 panes y llenaré 4 cubos con captura fresca. Tú los entregas por las ciudades. Haré que valga la pena.");
        cvQuestOffer.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.FISHES_DELIVERY, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestOffer);

        // Accept
        ConversationOption cvQuestAccept = new ConversationOption(1, 0);
        cvQuestAccept.addOptionText(ENGLISH, "Sure, I'll bring the bread and help with deliveries.",
                "Good! Bring me the 5 loaves whenever you are ready and I will get started on the catch right away.");
        cvQuestAccept.addOptionText(PORTUGUESE, "Claro, vou trazer o pão e ajudar com as entregas.",
                "Ótimo! Traga os 5 pães quando estiver pronto e eu começo a captura imediatamente.");
        cvQuestAccept.addOptionText(SPANISH, "Claro, traeré el pan y ayudaré con las entregas.",
                "¡Bien! Tráeme los 5 panes cuando estés listo y empezaré con la captura enseguida.");
        cvQuestAccept.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(FishesDelivery.get(), App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuestAccept);

        // Decline
        ConversationOption cvQuestDecline = new ConversationOption(1, 0);
        cvQuestDecline.addOptionText(ENGLISH, "Not now, maybe another time.", "No worries. The sea will still be here when you change your mind.");
        cvQuestDecline.addOptionText(PORTUGUESE, "Não agora, talvez outra hora.", "Sem problemas. O mar ainda vai estar aqui quando você mudar de ideia.");
        cvQuestDecline.addOptionText(SPANISH, "Ahora no, quizás otra vez.", "No hay problema. El mar seguirá aquí cuando cambies de opinión.");
        npc.conversationOptions.add(cvQuestDecline);

        // Part 1: Player brings 5 bread → Jack gives 4 buckets of fish
        ConversationOption cvPart1 = new ConversationOption(0, 0);
        cvPart1.addOptionText(ENGLISH, "I have the 5 loaves of bread for you.",
                "*He takes them eagerly and starts setting up his lines with the bread as bait*\nPerfect! Give me a moment...\n\n*After a while, he returns with four heavy buckets*\n\nHere you go — four buckets, nice and fresh. Take them to Apenna, Umera, Bastian and Letow. They are expecting them.");
        cvPart1.addOptionText(PORTUGUESE, "Tenho os 5 pães para você.",
                "*Ele os pega ansiosamente e começa a preparar as linhas com o pão como isca*\nPerfeito! Me dê um momento...\n\n*Depois de um tempo, ele volta com quatro baldes pesados*\n\nPronto — quatro baldes, bem frescos. Leve para Apenna, Umera, Bastian e Letow. Eles estão esperando.");
        cvPart1.addOptionText(SPANISH, "Tengo los 5 panes para ti.",
                "*Los toma con entusiasmo y empieza a preparar sus líneas con el pan como carnada*\n¡Perfecto! Dame un momento...\n\n*Tras un rato, regresa con cuatro cubos pesados*\n\nAquí tienes — cuatro cubos, bien frescos. Llévalos a Apenna, Umera, Bastian y Letow. Están esperándolos.");
        cvPart1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FISHES_DELIVERY, 1)
                    && LibInventory.checkHasItemAmount(ItemsIds.BREAD, 5, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPart1.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.BREAD, 5, App.getPlayerChar());
            LibInventory.addToInventory(ItemsIds.BUCKET_OF_FISHES, 4, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.FISHES_DELIVERY, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPart1);

        // Part 6: Return to Jack with todas as entregas feitas
        ConversationOption cvPart6 = new ConversationOption(0, 0);
        cvPart6.addOptionText(ENGLISH, "All deliveries done, Jack!",
                "*He claps you on the back with a wide grin*\nExcellent work! Every city will be eating fresh fish tonight. You did better than I expected.\nHere — your share of the profits. And a few things from my own collection.\n*He gives a nod toward the sea*\nFish don't stop, and neither do orders. Whenever you want to help again, you know where to find me.");
        cvPart6.addOptionText(PORTUGUESE, "Todas as entregas foram feitas, Jack!",
                "*Ele bate nas suas costas com um largo sorriso*\nExcelente trabalho! Cada cidade vai comer peixe fresco esta noite. Você se saiu melhor do que eu esperava.\nAqui — sua parte dos lucros. E algumas coisas da minha própria coleção.\n*Ele acena em direção ao mar*\nOs peixes não param, e os pedidos também não. Sempre que quiser ajudar de novo, sabe onde me encontrar.");
        cvPart6.addOptionText(SPANISH, "¡Todas las entregas hechas, Jack!",
                "*Te palmea la espalda con una amplia sonrisa*\n¡Excelente trabajo! Cada ciudad comerá pescado fresco esta noche. Lo hiciste mejor de lo que esperaba.\nAquí — tu parte de las ganancias. Y algunas cosas de mi propia colección.\n*Señala hacia el mar con un gesto*\nLos peces no paran, y los pedidos tampoco. Cuando quieras ayudar de nuevo, ya sabes dónde encontrarme.");
        cvPart6.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FISHES_DELIVERY, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPart6.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.FISHES_DELIVERY, App.getPlayerChar(), 7, ctx);
        };
        npc.conversationOptions.add(cvPart6);

        // Part 1 (restartable continuation): Quest was completed and restarted — player can help again
        ConversationOption cvRestart = new ConversationOption(0, 0);
        cvRestart.addOptionText(ENGLISH, "Jack, I can help with another delivery run.",
                "Ha! I was thinking you might come back. Same deal as before — bring me 5 loaves of bread and I'll fill the buckets. Ready when you are.");
        cvRestart.addOptionText(PORTUGUESE, "Jack, posso ajudar com mais uma rodada de entregas.",
                "Ha! Estava pensando que você poderia voltar. Mesmo acordo de antes — traga 5 pães e eu enchaço os baldes. Pronto quando você estiver.");
        cvRestart.addOptionText(SPANISH, "Jack, puedo ayudar con otra ronda de entregas.",
                "¡Ha! Pensaba que podrías volver. Mismo trato que antes — tráeme 5 panes y llenaré los cubos. Listo cuando tú lo estés.");
        cvRestart.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(QuestsIds.FISHES_DELIVERY, chara)
                    && LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FISHES_DELIVERY, 1)
                    && !LibInventory.checkHasItemAmount(ItemsIds.BREAD, 5, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRestart);

        // ========================================
        // QUEST: STUDYING FISH
        // ========================================

        // Part 1: Talk to Jack
        ConversationOption cvFishPart1 = new ConversationOption(0, 0);
        cvFishPart1.addOptionText(ENGLISH, "I'm helping an elven student. He needs a sample of Havarus fish for his research.",
                "Elf? From Ayalon? Studying the waters, is he? That's a noble pursuit. \n\nI just pulled in a particularly fine specimen from the bay. Here, take this Havarus fish. It's as fresh as they come and should give him plenty to look at. One less fish will not be a be problem.");
        cvFishPart1.addOptionText(PORTUGUESE, "Estou ajudando um estudante elfo. Ele precisa de uma amostra de peixe de Havarus para sua pesquisa.",
                "Elfo? De Ayalon? Estudando as águas, não é? É uma busca nobre. \n\nAcabei de pescar um espécime particularmente bom na baía. Aqui, leve este peixe de Havarus. Está o mais fresco possível e deve dar muito o que pesquisar. Um peixe a menos não me trará problema algum.");
        cvFishPart1.addOptionText(SPANISH, "Estoy ajudando a un estudiante elfo. Necesita una muestra de pez de Havarus para su investigación.",
                "¿Elfo? ¿De Ayalon? ¿Estudiando las aguas, verdad? Es una noble búsqueda. \n\nAcabo de sacar un espécimen particularmente fino de la bahía. Toma, llévate este pez de Havarus. Está tan fresco como puede estarlo y debería darle mucho que investigar.");
        cvFishPart1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, STUDYING_FISH, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvFishPart1.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.HAVARUS_FISH, 1, App.getPlayerChar());
            LibQuest.updateQuest(STUDYING_FISH, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFishPart1);

        return npc;
    }
}