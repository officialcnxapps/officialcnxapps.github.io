package com.cnx.endlesstalestwo.data.npcs.havarusNorth.farmland;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REINFORCE_FARMLAND;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class HingusAtFarmland extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Hingus");
        npc.resetId("HINGUS_AT_FARMLAND");
        npc.age = 49;
        npc.job = Enums.NPCJobs.HANDYMAN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REINFORCE_FARMLAND, 4)
                    || LibQuest.isCharacterAtQuestPart(chara, REINFORCE_FARMLAND, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "How are the defenses coming along?", "We're making good progress. I brought some folks from the capital who were willing to lend a hand. We've hauled logs, raised a few walls, and set up defenses in key spots. I think next we'll raise a watchtower.");
        cv1.addOptionText(PORTUGUESE, "Como estão as defesas?", "Estamos trabalhando bem, trouxe um pessoal da capital que estava disposto a ajudar. Já pegamos algumas toras, erguemos alguns muros e posicionamos algumas defesas em pontos estratégicos. Acho que agora vamos construir uma torre de vigia.");
        cv1.addOptionText(SPANISH, "¿Cómo van las defensas?", "Estamos avanzando bien. Traje a unos compañeros de la capital que querían ayudar. Ya cargamos troncos, levantamos algunos muros y colocamos defensas en puntos estratégicos. Creo que ahora construiremos una torre de vigilancia.");
        npc.conversationOptions.add(cv1);

        return npc;
    }
}