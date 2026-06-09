package com.cnx.endlesstalestwo.data.npcs.ayalon;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;
import com.cnx.endlesstalestwo.libs.Utils;

import java.util.Collections;

public class StatueOfAelindra extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Statue of Aelindra");
        npc.addNameTranslation(PORTUGUESE, "Estátua de Aelindra");
        npc.addNameTranslation(SPANISH, "Estatua de Aelindra");
        npc.age = 0;
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.FEMALE;
        npc.allowTraitsAnalysis = false;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("The portal shimmers with ancient elven magic, ready to return you to the tunnel."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("O portal brilha com magia élfica ancestral, pronto para levá-lo de volta ao túnel."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("El portal brilla con magia élfica ancestral, listo para llevarte de regreso al túnel."));

        // ===== Return to Gybralar Tunnel (Brown Room) =====
        ConversationOption cvReturn = new ConversationOption(0, 0);
        cvReturn.addOptionText(ENGLISH, "Use the portal to return.", "*The portal glows brighter*\nStepping through...");
        cvReturn.addOptionText(PORTUGUESE, "Usar o portal para retornarl.", "*O portal brilha mais intensamente*\nAtravessando...");
        cvReturn.addOptionText(SPANISH, "Usar el portal para regresar.", "*El portal brilla más intensamente*\nAtravesando...");
        cvReturn.requirementValidations = (chara, ctx) -> {
            // Can use portal if player has access (completed part 3 of Elf Knowledge or higher)
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELF_KNOWLEDGE, 3) ||
                    LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELF_KNOWLEDGE, 4) ||
                    LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELF_KNOWLEDGE, 5) ||
                    LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELF_KNOWLEDGE, 6) ||
                    LibQuest.isQuestComplete(chara, QuestsIds.ELF_KNOWLEDGE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvReturn.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.BROWN_ROOM_OF_ELF_GODDESS, 0, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvReturn);

        return npc;
    }
}

