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
        npc.addDescriptionTranslation(ENGLISH, "She appears sad, longing for times gone by. Her life is nearing its end and she seems not to care.\nCalm, she no longer fears or worries about anything.\n\nHer physical traits: Short, graying hair. An aged face, sad expression and tired brown eyes.");
        npc.addDescriptionTranslation(PORTUGUESE, "Aparenta tristeza, saudade de tempos antigos. Sua vida já está perto do fim e ela parece não se importar.\nCalma, não teme nem se preocupa mais com nada.\n\nSeus traços físicos: Cabelo curto, grisalho. Rosto envelhecido, expressão triste e olhos castanhos com visão cansada.");
        npc.addDescriptionTranslation(SPANISH, "Aparenta tristeza, añorando tiempos pasados. Su vida está cerca del final y parece no importarle.\nCalmada, ya no teme ni se preocupa por nada.\n\nSus rasgos físicos: Cabello corto y canoso. Rostro envejecido, expresión triste y ojos marrones con mirada cansada.");
        npc.canBePickpocketed = true;

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