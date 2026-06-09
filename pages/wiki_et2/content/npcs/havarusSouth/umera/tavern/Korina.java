package com.cnx.endlesstalestwo.data.npcs.havarusSouth.umera.tavern;

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

public class Korina extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Korina");
        npc.age = 30;
        npc.job = Enums.NPCJobs.NEEDLEWOMAN;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Why does a needlewoman work in a tavern?", "Because miners tear clothes faster than I can complain about it. Sleeves split, gloves wear through, boots come apart. They drink, eat, and hand me another ruined coat.");
        cv1.addOptionText(PORTUGUESE, "Por que uma costureira trabalha numa taverna?", "Porque mineradores rasgam roupa mais rápido do que eu consigo reclamar disso. Mangas se abrem, luvas se gastam, botas se desfazem. Eles bebem, comem e me entregam outro casaco arruinado.");
        cv1.addOptionText(SPANISH, "¿Por qué una costurera trabaja en una taberna?", "Porque los mineros rompen la ropa más rápido de lo que yo puedo quejarme. Las mangas se abren, los guantes se gastan, las botas se deshacen. Beben, comen y me entregan otro abrigo arruinado.");
        npc.conversationOptions.add(cv1);

        // ========================================
        // QUEST: FISHES DELIVERY — PART 3 (Umera)
        // ========================================

        ConversationOption cvFishPart3 = new ConversationOption(0, 0);
        cvFishPart3.addOptionText(ENGLISH, "Jack the fisherman sent this bucket of fresh fish for you.",
                "*She wipes her hands on her apron and takes the bucket with a smile*\nOh, wonderful! The tavern folk always look forward to Jack's fish. Fresh catch from Fisherman Ville is the best around.\nTell him thank you — and you are welcome back anytime too.");
        cvFishPart3.addOptionText(PORTUGUESE, "Jack o pescador enviou este balde de peixe fresco para você.",
                "*Ela limpa as mãos no avental e pega o balde com um sorriso*\nOh, maravilhoso! O pessoal da taverna sempre espera pelos peixes do Jack. Pesca fresca de Fisherman Ville é a melhor da região.\nDiga a ele obrigado — e você também é sempre bem-vindo.");
        cvFishPart3.addOptionText(SPANISH, "Jack el pescador envió este cubo de pescado fresco para ti.",
                "*Se limpia las manos en el delantal y toma el cubo con una sonrisa*\n¡Oh, maravilloso! La gente de la taberna siempre espera el pescado de Jack. La pesca fresca de Fisherman Ville es la mejor de la zona.\nDile que gracias — y tú también eres siempre bienvenido aquí.");
        cvFishPart3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FISHES_DELIVERY, 3)
                    && LibInventory.checkHasItem(ItemsIds.BUCKET_OF_FISHES, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvFishPart3.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.BUCKET_OF_FISHES, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.FISHES_DELIVERY, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFishPart3);

        return npc;
    }
}