package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.lake;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.libs.Utils.isInsideAvailableHours;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class William extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("William");
        npc.age = 51;
        npc.job = Enums.NPCJobs.MALE_FISHERMAN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.generateRandomByes();

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Is lake fishing very different from sea fishing?", "Very. The sea is loud and proud. A lake is patient. You must watch the surface, the reeds, and the shadows beneath the water.");
        cv1.addOptionText(PORTUGUESE, "Pescar no lago é muito diferente de pescar no mar?", "Muito. O mar é barulhento e orgulhoso. Um lago é paciente. É preciso observar a superfície, os juncos e as sombras sob a água.");
        cv1.addOptionText(SPANISH, "¿Pescar en el lago es muy diferente de pescar en el mar?", "Mucho. El mar es ruidoso y orgulloso. Un lago es paciente. Debes observar la superficie, los juncos y las sombras bajo el agua.");
        npc.conversationOptions.add(cv1);

        npc.requirementValidations = (chara, ctx) -> {
            if (isInsideAvailableHours(9, 17)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;

        };

        return npc;
    }
}