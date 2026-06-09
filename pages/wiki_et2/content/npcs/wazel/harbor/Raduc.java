package com.cnx.endlesstalestwo.data.npcs.wazel.harbor;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class Raduc extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Raduc");
        npc.age = 22;
        npc.job = Enums.NPCJobs.LONGSHOREMAN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.hasRandomizedConversations = true;

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What is life like at Wazel's harbor?", "Busy and dusty. Ships bring spices, fabrics, tools, and rumors from every coast. We unload under the sun, work fast, and drink even faster when the day is done.");
        cv1.addOptionText(PORTUGUESE, "Como é a vida no porto de Wazel?", "Movimentada e empoeirada. Navios trazem especiarias, tecidos, ferramentas e rumores de toda costa. Descarregamos sob o sol, trabalhamos rápido e bebemos ainda mais rápido quando o dia termina.");
        cv1.addOptionText(SPANISH, "¿Cómo es la vida en el puerto de Wazel?", "Agitada y polvorienta. Los barcos traen especias, telas, herramientas y rumores de todas las costas. Descargamos bajo el sol, trabajamos rápido y bebemos aún más rápido cuando termina el día.");
        npc.conversationOptions.add(cv1);

        return npc;
    }
}