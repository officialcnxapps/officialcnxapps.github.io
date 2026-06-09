package com.cnx.endlesstalestwo.data.npcs.havarusNorth.cemetery;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.libs.Utils.isInsideAvailableHours;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class Brianne extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Brianne");
        npc.age = 68;
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Do you come here often?", "Often enough. Some come to mourn, others to remember. I come for both. A graveyard is quieter than the city, and in quiet places the dead seem less distant.");
        cv1.addOptionText(PORTUGUESE, "Você vem aqui com frequência?", "Com frequência suficiente. Alguns vêm para lamentar, outros para lembrar. Eu venho pelos dois motivos. Um cemitério é mais silencioso que a cidade, e em lugares silenciosos os mortos parecem menos distantes.");
        cv1.addOptionText(SPANISH, "¿Vienes aquí a menudo?", "Con suficiente frecuencia. Algunos vienen a llorar, otros a recordar. Yo vengo por ambas cosas. Un cementerio es más silencioso que la ciudad, y en los lugares silenciosos los muertos parecen menos lejanos.");
        npc.conversationOptions.add(cv1);


        npc.requirementValidations = (chara, ctx) -> {
            if (isInsideAvailableHours(10, 17)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        return npc;
    }
}