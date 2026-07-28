package com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian.market;

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

public class Wella extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Wella");
        npc.age = 46;
        npc.job = Enums.NPCJobs.FEMALE_COOK;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A woman who seems to have suffered a lot in life.\nToday she does her job but without a sparkle in her eyes.\nShe seems to have no living relatives.\n\nHer physical features: Dry, weathered skin. Light green eyes. Short, straight black hair. Wide mouth.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma mulher que parece ter sofrido muito na vida.\nHoje faz seu trabalho mas sem brilho nos olhos.\nParece não ter familiares vivos.\n\nSeus traços físicos: Pele seca, sofrida. Olhos verdes claros. Cabelos pretos, lisos e curtos. Boca larga.");
        npc.addDescriptionTranslation(SPANISH, "Una mujer que parece haber sufrido mucho en la vida.\nHoy trabaja, pero sin brillo en los ojos.\nParece no tener familiares vivos.\n\nSus rasgos físicos: piel seca y curtida, ojos verde claro, cabello negro corto y liso, boca ancha.");
        npc.canBePickpocketed = true;

        npc.hasRandomizedConversations = true;

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What do you cook for the market folk?", "Simple food that fills the belly and can be eaten between one errand and the next. Stews, flatbread, roasted meat - whatever keeps traders calm before noon.");
        cv1.addOptionText(PORTUGUESE, "O que você cozinha para o pessoal do mercado?", "Comida simples que enche a barriga e pode ser comida entre uma tarefa e outra. Ensopados, pão achatado, carne assada - o que mantiver os comerciantes calmos antes do meio-dia.");
        cv1.addOptionText(SPANISH, "¿Qué cocinas para la gente del mercado?", "Comida sencilla que llena el vientre y puede comerse entre un recado y otro. Guisos, pan plano, carne asada: lo que mantenga calmados a los comerciantes antes del mediodía.");
        npc.conversationOptions.add(cv1);

        // ========================================
        // QUEST: FISHES DELIVERY — PART 4 (Bastian)
        // ========================================

        ConversationOption cvFishPart4 = new ConversationOption(0, 0);
        cvFishPart4.addOptionText(ENGLISH, "Jack the fisherman sent this bucket of fresh fish for you.",
                "*She peeks into the bucket and nods approvingly*\nFresh fish! Perfect timing — the midday crowd will love this. Jack always delivers the good stuff.\nThank you, traveler. Here, take a moment to rest if you need it. The market gets busy this time of day.");
        cvFishPart4.addOptionText(PORTUGUESE, "Jack o pescador enviou este balde de peixe fresco para você.",
                "*Ela espia dentro do balde e acena com aprovação*\nPeixe fresco! Na hora certa — a multidão do meio-dia vai adorar isso. Jack sempre entrega o melhor.\nObrigada, viajante. Aqui, descanse um momento se precisar. O mercado fica agitado nessa hora do dia.");
        cvFishPart4.addOptionText(SPANISH, "Jack el pescador envió este cubo de pescado fresco para ti.",
                "*Echa un vistazo al cubo y asiente con aprobación*\n¡Pescado fresco! En el momento perfecto — a la gente del mediodía le encantará esto. Jack siempre entrega lo mejor.\nGracias, viajero. Aquí, descansa un momento si lo necesitas. El mercado se pone animado a esta hora.");
        cvFishPart4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FISHES_DELIVERY, 4)
                    && LibInventory.checkHasItem(ItemsIds.BUCKET_OF_FISHES, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvFishPart4.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.BUCKET_OF_FISHES, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.FISHES_DELIVERY, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFishPart4);

        return npc;
    }
}