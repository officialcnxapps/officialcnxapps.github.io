package com.cnx.endlesstalestwo.data.npcs.growrocks;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.Utils;

import java.util.Collections;

public class MysticRock extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Mystic Rock");
        npc.addNameTranslation(PORTUGUESE, "Pedra Mística");
        npc.addNameTranslation(SPANISH, "Roca Mística");
        npc.age = 900;
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.UNKNOWN;
       npc.allowTraitsAnalysis = false;
        npc.resetId("MYSTIC_ROCK_AT_TRAIL");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("A mortal..."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Um mortal..."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Un mortal..."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("..."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("..."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("..."));


        // ===== RECURRING TRAVEL: After completing transport once =====
        ConversationOption cvRecurringTravel = new ConversationOption(0, 3);
        cvRecurringTravel.addOptionText(ENGLISH, "I wish to leave Growrocks.", "...Return... to surface... \n*The rock pulses with recognition*\n...prepare... good journey...");
        cvRecurringTravel.addOptionText(PORTUGUESE, "Desejo deixar Growrocks.", "...Retornar... à superfície... \n*A pedra pulsa com reconhecimento*\n...preparar... boa jornada...");
        cvRecurringTravel.addOptionText(SPANISH, "Deseo abandonar Growrocks.", "...Regresar... a la superficie... \n*La roca pulsa con reconocimiento*\n...preparar... buen viaje...");
        cvRecurringTravel.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.DEEP_CRATER_CAVE, 0, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvRecurringTravel);


        return npc;
    }
}

