package com.cnx.endlesstalestwo.data.npcs.wazel.oasis;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.libs.Utils.isInsideAvailableHours;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Zanica extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Zanica");
        npc.age = 15;
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Why are you here so early?", "The oasis is best before the city fully wakes. The air is cooler, the birds come closer, and for a little while Wazel feels softer than the rest of the desert.");
        cv1.addOptionText(PORTUGUESE, "Por que você está aqui tão cedo?", "O oásis é melhor antes que a cidade desperte por completo. O ar é mais fresco, os pássaros chegam mais perto e por um momento Wazel parece mais gentil do que o resto do deserto.");
        cv1.addOptionText(SPANISH, "¿Por qué estás aquí tan temprano?", "El oasis es mejor antes de que la ciudad despierte por completo. El aire es más fresco, los pájaros se acercan más y por un momento Wazel parece más amable que el resto del desierto.");
        npc.conversationOptions.add(cv1);

        npc.requirementValidations = (chara, ctx) -> {
            // Not available during the WazelBattle quest (she takes refuge away from the oasis)
            if (LibQuest.charHasQuest(QuestsIds.WAZEL_BATTLE, chara) && !LibQuest.isQuestComplete(chara, QuestsIds.WAZEL_BATTLE)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            // Only available in the early morning hours
            if (isInsideAvailableHours(6, 10)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        return npc;
    }
}