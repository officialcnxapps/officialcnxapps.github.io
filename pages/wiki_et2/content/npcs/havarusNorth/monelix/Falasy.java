package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class Falasy extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Falasy");
        npc.age = 40;
        npc.job = Enums.NPCJobs.NEEDLEWOMAN;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.hasRandomizedConversations = true;

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What kind of clothes do people ask you to make?", "In Monelix? A bit of everything. Nobles want elegance, soldiers want durability, and common folk want something that survives hard work and bad weather. Good stitching serves all of them.");
        cv1.addOptionText(PORTUGUESE, "Que tipo de roupa as pessoas pedem para você fazer?", "Em Monelix? Um pouco de tudo. Nobres querem elegância, soldados querem durabilidade, e o povo comum quer algo que sobreviva ao trabalho duro e ao mau tempo. Boa costura serve a todos.");
        cv1.addOptionText(SPANISH, "¿Qué tipo de ropa te piden hacer?", "¿En Monelix? Un poco de todo. Los nobles quieren elegancia, los soldados quieren durabilidad y la gente común quiere algo que sobreviva al trabajo duro y al mal tiempo. Una buena costura sirve a todos.");
        npc.conversationOptions.add(cv1);

        return npc;
    }
}