package com.cnx.endlesstalestwo.data.npcs.ayalon.elvenGarden;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.ELFS_ALERT;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.SEEDS_AND_HERBS;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.THE_FINAL_BATTLE;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Flaviea extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Flaviea");
        npc.age = 82;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.FEMALE;

        npc.addDescriptionTranslation(ENGLISH, "This elf, despite being young, shows courage and experience.\nShe works in all parts of Ayalon. She loves her culture and protects her people without a second thought.\nShe knows every citizen living in the city well, especially her husband, Aslatan.\n\nHer physical traits: Green skin, short, straight dark hair parted in the middle. Thin and prominent nose and cheeks.");
        npc.addDescriptionTranslation(PORTUGUESE, "Esta elfa, apesar de jovem demonstra coragem e experiência.\nTrabalha em todos os lados de Ayalon. Ama sua cultura e protege seu povo sem pensar.\nConhece bem cada cidadão que vive na cidade, principalmente seu marido, Aslatan.\n\nSeus taços físicos: Pele verde, cabelos escuros, curtos e lisos divididos ao meio. nariz e bochechas finos e salientes.");
        npc.addDescriptionTranslation(SPANISH, "Esta elfa, a pesar de ser joven, demuestra valentía y experiencia.\nTrabaja en todos los rincones de Ayalon. Ama su cultura y protege a su pueblo sin pensarlo.\nConoce bien a cada ciudadano que vive en la ciudad, especialmente a su marido, Aslatan.\n\nSus rasgos físicos: Piel verde, cabello oscuro, corto y liso dividido al medio. Nariz y mejillas finas y prominentes.");
        npc.canBePickpocketed = true;

        // Flaviea should only be present before the ElfsAlert quest begins,
        // OR after The Final Battle is complete.
        npc.requirementValidations = (chara, ctx) -> {
            boolean elfsAlertActive = LibQuest.charHasQuest(ELFS_ALERT, chara)
                    && !LibQuest.isQuestComplete(chara, ELFS_ALERT);
            boolean finalBattleComplete = LibQuest.isQuestComplete(chara, THE_FINAL_BATTLE);

            if (elfsAlertActive && !finalBattleComplete) {
                return Enums.RequirementVerification.NOT_OK;
            }

            // Not available while The Final Battle is active and not yet complete
            if (LibQuest.charHasQuest(THE_FINAL_BATTLE, chara) && !finalBattleComplete) {
                return Enums.RequirementVerification.NOT_OK;
            }

            return Enums.RequirementVerification.OK;
        };

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Why guard a garden?", "Because this is no ordinary garden. Many plants here are rare, sacred, or used in delicate rituals. A careless hand can do more harm here than a sword.");
        cv1.addOptionText(PORTUGUESE, "Por que guardar um jardim?", "Porque este não é um jardim comum. Muitas plantas daqui são raras, sagradas ou usadas em rituais delicados. Uma mão descuidada pode causar mais dano aqui do que uma espada.");
        cv1.addOptionText(SPANISH, "¿Por qué vigilar un jardín?", "Porque este no es un jardín común. Muchas plantas de aquí son raras, sagradas o usadas en rituales delicados. Una mano descuidada puede causar más daño aquí que una espada.");
        npc.conversationOptions.add(cv1);

        // ===== ROLEPLAY: The sacred tree =====
        ConversationOption cvSacredTree = new ConversationOption(0, 0);
        cvSacredTree.addOptionText(ENGLISH, "What is that ancient tree at the center of the garden?", "That tree is sacred to the elves. They say it is older than the kingdom itself and that its roots reach into every living thing in these lands. No one may touch it or take from it without the blessing of the Elder Council. To harm it would be to harm Ayalon itself.");
        cvSacredTree.addOptionText(PORTUGUESE, "O que é aquela árvore ancestral no centro do jardim?", "Aquela árvore é sagrada para os elfos. Dizem que ela é mais antiga do que o próprio reino e que suas raízes alcançam cada ser vivo nestas terras. Ninguém pode tocá-la ou retirar algo dela sem a bênção do Conselho dos Anciões. Prejudicá-la seria prejudicar a própria Ayalon.");
        cvSacredTree.addOptionText(SPANISH, "¿Qué es ese árbol ancestral en el centro del jardín?", "Ese árbol es sagrado para los elfos. Dicen que es más antiguo que el propio reino y que sus raíces alcanzan a cada ser vivo en estas tierras. Nadie puede tocarlo ni tomar nada de él sin la bendición del Consejo de Ancianos. Dañarlo sería dañar a Ayalon misma.");
        npc.conversationOptions.add(cvSacredTree);

        // ========================================
        // QUEST: SEEDS AND HERBS
        // ========================================

        // Start quest
        ConversationOption cvSeedsStart = new ConversationOption(0, 1);
        cvSeedsStart.addOptionText(ENGLISH, "You look busy. Do you need help with the garden?",
                "Indeed! Ayalon's garden is vast and requires special care. I'm looking for some rare seeds and herbs that don't grow easily here. Would you be willing to travel to gather them?");
        cvSeedsStart.addOptionText(PORTUGUESE, "Você parece ocupada. Precisa de ajuda com o jardim?",
                "De fato! O jardim de Ayalon é vasto e requer cuidados especiais. Estou procurando algumas sementes e ervas raras que não crescem facilmente aqui. Você estaria disposto a viajar para coletá-las?");
        cvSeedsStart.addOptionText(SPANISH, "¿Pareces ocupada. ¿Necesitas ayuda con el jardín?",
                "¡De hecho! El jardín de Ayalon es vasto y requiere cuidados especiales. Estoy buscando algunas semillas y hierbas raras que no crecen fácilmente aquí. ¿Estarías dispuesto a viajar para recolectarlas?");
        cvSeedsStart.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(SEEDS_AND_HERBS, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvSeedsStart);

        ConversationOption cvSeedsAccept = new ConversationOption(1, 0);
        cvSeedsAccept.addOptionText(ENGLISH, "I can help. What do you need?",
                "Wonderful. First, I need some Black Oak Seeds. An old friend, Griwalsh, lives in a farmhouse in Havarus South. He always has some available. Go talk to him first.");
        cvSeedsAccept.addOptionText(PORTUGUESE, "Eu posso ajudar. Do que você precisa?",
                "Maravilhoso. Primeiro, preciso de Sementes de Carvalho Negro. Um velho amigo, Griwalsh, vive em uma fazenda em Havarus Sul. Ele sempre tem algumas disponíveis. Vá falar com ele primeiro.");
        cvSeedsAccept.addOptionText(SPANISH, "Puedo ayudar. ¿Qué necesitas?",
                "Maravilloso. Primero, necesito algunas Semillas de Roble Negro. Un viejo amigo, Griwalsh, vive en una granja en Havarus Sur. Siempre tiene algunas disponibles. Ve a hablar con ele primero.");
        cvSeedsAccept.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(SEEDS_AND_HERBS, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvSeedsAccept);

        ConversationOption cvSeedsDecline = new ConversationOption(1, 0);
        cvSeedsDecline.addOptionText(ENGLISH, "I have other things to do right now.", "I understand. The garden will still be here if you change your mind.");
        cvSeedsDecline.addOptionText(PORTUGUESE, "Tenho outras coisas para fazer agora.", "Eu entendo. O jardim ainda estará aqui se você mudar de ideia.");
        cvSeedsDecline.addOptionText(SPANISH, "Tengo otras cosas que hacer ahora.", "Entiendo. El jardín seguirá aquí si cambias de opinión.");
        npc.conversationOptions.add(cvSeedsDecline);

        // Part 2: Deliver Black Oak Seeds + 3 White Herbs
        ConversationOption cvSeedsPart2 = new ConversationOption(0, 0);
        cvSeedsPart2.addOptionText(ENGLISH, "I have the seeds and the white herbs you asked for.",
                "Thank you! These seeds look perfect. And these white herbs are exactly what I needed for the next batch.\nWait... I just realized I'm also short on one more ingredient. I noted down in this paper for you.");
        cvSeedsPart2.addOptionText(PORTUGUESE, "Tenho as sementes e as ervas brancas que você pediu.",
                "Obrigada! Estas sementes parecem perfeitas. E estas ervas brancas são exatamente o que eu precisava para o próximo lote.\nEspere... acabei de perceber que também estou sem mais um ingrediente. Eu anotei aqui neste papel para você.");
        cvSeedsPart2.addOptionText(SPANISH, "Tengo las semillas y las hierbas blancas que pediste.",
                "¡Gracias! Estas semillas se ven perfectas. Y estas hierbas blancas son exactamente lo que necesitaba para el próximo lote.\nEspera... me acabo de dar cuenta de que también me falta un ingrediente más. Yo escribí aquí en este trozo de papel para ti.");
        cvSeedsPart2.requirementValidations = (chara, ctx) -> {
            ItemReference[] items = {
                    new ItemReference(ItemsIds.BLACK_OAK_SEEDS, 1),
                    new ItemReference(ItemsIds.WHITE_HERB, 3)
            };
            if (LibQuest.isCharacterAtQuestPart(chara, SEEDS_AND_HERBS, 2) && LibInventory.checkHasItems(items, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvSeedsPart2.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.BLACK_OAK_SEEDS, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.WHITE_HERB, 3, App.getPlayerChar());
            int roll = LibUtils.getRandom(1, 3);
            int nextPart = (roll == 1) ? 31 : (roll == 2) ? 32 : 33;
            LibQuest.updateQuest(SEEDS_AND_HERBS, nextPart, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvSeedsPart2);

        // Part 31: Deliver Living Mosswood
        ConversationOption cvSeedsPart31 = new ConversationOption(0, 0);
        cvSeedsPart31.addOptionText(ENGLISH, "Here is the Living Mosswood.",
                "Excellent! This will provide the vitality the mixture needs. Give me a moment to prepare the potion...\n\nHere, take this Potion of Nature and deliver it to my husband, Aslatan. He's at the docks, preparing for his next voyage.");
        cvSeedsPart31.addOptionText(PORTUGUESE, "Aqui está a Madeira de Musgo Vivo.",
                "Excelente! Isso dará a vitalidade que a mistura precisa. Me dê um momento para preparar a poção...\n\nAqui, pegue esta Poção da Natureza e entregue ao meu marido, Aslatan. Ele está nas docas, se preparando para sua próxima viagem.");
        cvSeedsPart31.addOptionText(SPANISH, "Aquí está la Madera de Musgo Vivo.",
                "¡Excelente! Esto le dará la vitalidad que la mezcla necesita. Dame un momento para preparar la poción...\n\nAquí, toma esta Poción de la Naturaleza y entrégasela a mi marido, Aslatan. Está en los muelles, preparándose para su próximo viaje.");
        cvSeedsPart31.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, SEEDS_AND_HERBS, 31) && LibInventory.checkHasItem(ItemsIds.LIVING_MOSSWOOD, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvSeedsPart31.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.LIVING_MOSSWOOD, 1, App.getPlayerChar());
            LibInventory.addToInventory(ItemsIds.POTION_OF_NATURE, 1, App.getPlayerChar());
            LibQuest.updateQuest(SEEDS_AND_HERBS, 40, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvSeedsPart31);

        // Part 32: Deliver Algae
        ConversationOption cvSeedsPart32 = new ConversationOption(0, 0);
        cvSeedsPart32.addOptionText(ENGLISH, "Here are the algae you needed.",
                "Perfect, these are fresh. Give me a moment to prepare the potion...\n\nHere, take this Potion of Nature and deliver it to my husband, Aslatan. He's at the docks, preparing for his next voyage.");
        cvSeedsPart32.addOptionText(PORTUGUESE, "Aqui estão as algas que você precisava.",
                "Perfeito, estas estão frescas. Me dê um momento para preparar a poção...\n\nAqui, pegue esta Poção da Natureza e entregue ao meu marido, Aslatan. Ele está nas docas, se preparando para sua próxima viagem.");
        cvSeedsPart32.addOptionText(SPANISH, "Aquí están las algas que necesitabas.",
                "Perfecto, estas están frescas. Dame un momento para preparar la poción...\n\nAquí, toma esta Poción de la Naturaleza y entrégasela a mi marido, Aslatan. Está en los muelles, preparándose para su próximo viaje.");
        cvSeedsPart32.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, SEEDS_AND_HERBS, 32) && LibInventory.checkHasItemAmount(ItemsIds.ALGAE, 5, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvSeedsPart32.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.ALGAE, 5, App.getPlayerChar());
            LibInventory.addToInventory(ItemsIds.POTION_OF_NATURE, 1, App.getPlayerChar());
            LibQuest.updateQuest(SEEDS_AND_HERBS, 40, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvSeedsPart32);

        // Part 33: Deliver Orc Tooth
        ConversationOption cvSeedsPart33 = new ConversationOption(0, 0);
        cvSeedsPart33.addOptionText(ENGLISH, "I found an orc tooth for you.",
                "A bit unusual, I know, but it contains minerals essential for certain elven brews. Give me a moment...\n\nHere, take this Potion of Nature and deliver it to my husband, Aslatan. He's at the docks, preparing for his next voyage.");
        cvSeedsPart33.addOptionText(PORTUGUESE, "Encontrei um dente de orc para você.",
                "Um pouco incomum, eu sei, mas contém minerais essenciais para certas misturas élficas. Me dê um momento...\n\nAqui, pegue esta Poção da Natureza e entregue ao meu marido, Aslatan. Ele está nas docas, se preparando para sua próxima viagem.");
        cvSeedsPart33.addOptionText(SPANISH, "Encontré un diente de orco para ti.",
                "Un poco inusual, lo sé, pero contiene minerales esenciales para ciertas mezclas élficas. Dame un momento...\n\nAquí, toma esta Poción de la Naturaleza y entrégasela a mi marido, Aslatan. Está en los muelles, preparándose para su próximo viaje.");
        cvSeedsPart33.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, SEEDS_AND_HERBS, 33) && LibInventory.checkHasItem(ItemsIds.ORC_TOOTH, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvSeedsPart33.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.ORC_TOOTH, 1, App.getPlayerChar());
            LibInventory.addToInventory(ItemsIds.POTION_OF_NATURE, 1, App.getPlayerChar());
            LibQuest.updateQuest(SEEDS_AND_HERBS, 40, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvSeedsPart33);

        // Part 50: Complete quest
        ConversationOption cvSeedsPart50 = new ConversationOption(0, 0);
        cvSeedsPart50.addOptionText(ENGLISH, "Aslatan received the potion.",
                "Thank you so much. It's important he stays healthy on his voyages. The garden is also thriving with the new seeds and herbs. Please, take this as a token of my gratitude.");
        cvSeedsPart50.addOptionText(PORTUGUESE, "Aslatan recebeu a poção.",
                "Muito obrigada. É importante que ele se mantenha saudável em suas viagens. O jardim também está florescendo com as novas sementes e ervas. Por favor, aceite isso como um símbolo da minha gratidão.");
        cvSeedsPart50.addOptionText(SPANISH, "Aslatan recibió la poción.",
                "Muchas gracias. Es importante que se mantenga sano en sus viajes. El jardín también está floreciendo con las nuevas semillas y hierbas. Por favor, acepta esto como una muestra de mi gratitud.");
        cvSeedsPart50.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, SEEDS_AND_HERBS, 50)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvSeedsPart50.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(SEEDS_AND_HERBS, App.getPlayerChar(), 60, ctx);
        };
        npc.conversationOptions.add(cvSeedsPart50);

        // Part 1 (Restartable): Reminder
        ConversationOption cvSeedsRestart = new ConversationOption(0, 0);
        cvSeedsRestart.addOptionText(ENGLISH, "Keep needing help with the garden?",
                "Always! If you're heading out, I could use another batch of those Black Oak Seeds from Griwalsh. He knows the drill.");
        cvSeedsRestart.addOptionText(PORTUGUESE, "Continua precisando ajuda com o jardim?",
                "Sempre! Se você estiver saindo, eu poderia usar outro lote daquelas Sementes de Carvalho Negro do Griwalsh. Ele já sabe como funciona.");
        cvSeedsRestart.addOptionText(SPANISH, "¿Todavía necesitas ayuda con el jardín?",
                "¡Siempre! Si vas a salir, me vendría bien otro lote de esas Semillas de Roble Negro de Griwalsh. Él ya sabe cómo funciona.");
        cvSeedsRestart.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(SEEDS_AND_HERBS, chara) && LibQuest.isCharacterAtQuestPart(chara, SEEDS_AND_HERBS, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvSeedsRestart);

        return npc;
    }
}
