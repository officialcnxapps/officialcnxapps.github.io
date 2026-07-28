package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.forge;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.items.ItemsIds.COPPER_ORE;
import static com.cnx.endlesstalestwo.data.items.ItemsIds.IRON_ORE;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.GETTING_RESOURCES;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Morkus extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Morkus");
        npc.age = 32;
        npc.job = Enums.NPCJobs.MALE_BLACKSMITH;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Proud and skilled in his work.\nHe never misses an opportunity to talk about his creations and his craft.\nA good member of the community. He wants to start a family.\n\nHis physical traits: Curly brown hair. Square face with a defined jaw. Fair skin and brown eyes.");
        npc.addDescriptionTranslation(PORTUGUESE, "Orgulhoso e ábil com seu trabalho.\nNão perde uma oportunidade de falar sobre suas criações e sobre trabalho.\nBom membro da comunidade. Quer montar uma família.\n\nSeus traços físicos: Cabelos castanhos encaracolados. Rosto quadrado com queixo marcado. Pele clara e colhos castanhos.");
        npc.addDescriptionTranslation(SPANISH, "Orgulloso y habilidoso en su trabajo.\nNo pierde una oportunidad de hablar sobre sus creaciones y su oficio.\nBuen miembro de la comunidad. Quiere formar una familia.\n\nSus rasgos físicos: Cabello castaño rizado. Rostro cuadrado con mandíbula marcada. Piel clara y ojos marrones.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hello, [GENDER_FORMAL_CALL]. What brings you to my forge?"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá, [GENDER_FORMAL_CALL]. O que o traz à minha forja?"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola, [GENDER_FORMAL_CALL]. ¿Qué te trae a mi forja?"));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Safe travels!"));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Viagens seguras!"));
        npc.byeMessages.put(SPANISH, Collections.singletonList("¡Viajes seguros!"));

        // ===== CONVERSATION OPTION 1: General Information =====
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What can you tell me about yourself?", "I'm Morkus, a skilled blacksmith. I've been crafting weapons and armor for the kingdom for many years. I take pride in my work - only the finest materials and techniques.");
        cv1.addOptionText(PORTUGUESE, "O que você pode me dizer sobre você?", "Sou Morkus, um ferreiro hábil. Tenho feito armas e armaduras para o reino por muitos anos. Tenho orgulho do meu trabalho - apenas os melhores materiais e técnicas.");
        cv1.addOptionText(SPANISH, "¿Qué puedes decirme sobre ti?", "Soy Morkus, un herrero hábil. He estado fabricando armas y armaduras para el reino durante muchos años. Estoy orgulloso de mi trabajo - solo los mejores materiales y técnicas.");
        npc.conversationOptions.add(cv1);

        // ===== CONVERSATION OPTION 2: About GETTING_RESOURCES Quest Part 1 =====
        ConversationOption cv2 = new ConversationOption(0, 1);
        cv2.addOptionText(ENGLISH, "Guzar sent me. He said you need resources for weapons.", "Ah yes! We're preparing for battle. I need ores to craft new weapons for our soldiers. Specifically, I need 5 iron ores and 3 copper ores. Can you bring them to me?");
        cv2.addOptionText(PORTUGUESE, "Guzar me enviou. Ele disse que você precisa de recursos para armas.", "Ah sim! Estamos nos preparando para a batalha. Preciso de minérios para forjar novas armas para nossos soldados. Especificamente, preciso de 5 minérios de ferro e 3 de cobre. Você pode trazer para mim?");
        cv2.addOptionText(SPANISH, "Guzar me envió. Dijo que necesitas recursos para armas.", "¡Ah sí! Nos estamos preparando para la batalla. Necesito minerales para forjar nuevas armas para nuestros soldados. Específicamente, necesito 5 minerales de hierro y 3 de cobre. ¿Puedes traerlos?");
        cv2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, GETTING_RESOURCES, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv2.listeners = (ctx, currentFragment) -> {
            Quest quest = App.getPlayerChar().getQuest(GETTING_RESOURCES);
            LibQuest.updateQuest(quest, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv2);

        ConversationOption cvConfirmQuest = new ConversationOption(1, 0);
        cvConfirmQuest.addOptionText(ENGLISH, "Yes, sure.", "Good, I'll be waiting for your return with the ores.");
        cvConfirmQuest.addOptionText(PORTUGUESE, "Sim, farei isso.", "Ótimo, estarei esperando seu retorno com os minérios.");
        cvConfirmQuest.addOptionText(SPANISH, "Si, si.", "Bueno, estaré esperando tu regreso con los minerales.");
        npc.conversationOptions.add(cvConfirmQuest);

        // ===== CONVERSATION OPTION 3: Delivery Check =====
        ConversationOption cv3 = new ConversationOption(0, 0);
        cv3.addOptionText(ENGLISH, "I have the ores you requested.", "Let me check... yes, you have what I need! Excellent work. With these materials, I'll be able to forge excellent weapons for our soldiers. The kingdom owes you a debt of gratitude.");
        cv3.addOptionText(PORTUGUESE, "Tenho os minérios que você solicitou.", "Deixe-me verificar... sim, você tem o que preciso! Excelente trabalho. Com esses materiais, poderei forjar excelentes armas para nossos soldados. O reino lhe deve uma dívida de gratidão.");
        cv3.addOptionText(SPANISH, "Tengo los minerales que solicitaste.", "Déjame verificar... ¡sí, tienes lo que necesito! Excelente trabajo. Con estos materiales, podré forjar excelentes armas para nuestros soldados. El reino te debe una deuda de gratitud.");
        cv3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, GETTING_RESOURCES, 2)) {
                // Check if player has the required items
                boolean hasIron = LibInventory.checkHasItemAmount(IRON_ORE, 5, chara);
                boolean hasCopper = LibInventory.checkHasItemAmount(COPPER_ORE, 3, chara);
                if (hasIron && hasCopper) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv3.listeners = (ctx, currentFragment) -> {
            if (App.getPlayerChar() != null) {
                // Remove items from inventory
                LibInventory.removeFromInventory(IRON_ORE, 5, App.getPlayerChar());
                LibInventory.removeFromInventory(COPPER_ORE, 3, App.getPlayerChar());

                // Update quest (already shows feedback)
                Quest quest = App.getPlayerChar().getQuest(GETTING_RESOURCES);
                LibQuest.updateQuest(quest, 3, App.getPlayerChar(), ctx);
            }
        };
        npc.conversationOptions.add(cv3);

        // ===== CONVERSATION OPTION 4: Ask about status =====
        ConversationOption cv4 = new ConversationOption(0, 0);
        cv4.addOptionText(ENGLISH, "How are the weapons coming along?", "Very well! With the ores you brought, I'm already working on new weapons for the soldiers. The craftsmanship is flawless. They will serve the kingdom well.");
        cv4.addOptionText(PORTUGUESE, "Como estão as armas?", "Muito bem! Com os minérios que você trouxe, já estou trabalhando em novas armas para os soldados. O artesanato é impecável. Elas servirão bem o reino.");
        cv4.addOptionText(SPANISH, "¿Cómo van las armas?", "¡Muy bien! Con los minerales que trajiste, ya estoy trabajando en nuevas armas para los soldados. El artesanato es impecable. Servirán bien al reino.");
        cv4.requirementValidations = (chara, ctx) -> {
            if ((LibQuest.isCharacterAtQuestPart(chara, GETTING_RESOURCES, 3) ||
                    LibQuest.isCharacterAtQuestPart(chara, GETTING_RESOURCES, 4) ||
                    LibQuest.isCharacterAtQuestPart(chara, GETTING_RESOURCES, 5) ||
                    LibQuest.isCharacterAtQuestPart(chara, GETTING_RESOURCES, 6))) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv4);

        return npc;
    }
}

