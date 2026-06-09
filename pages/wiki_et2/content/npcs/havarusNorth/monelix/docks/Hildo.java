package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.docks;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class Hildo extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Hildo");
        npc.age = 26;
        npc.job = Enums.NPCJobs.LONGSHOREMAN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.hasRandomizedConversations = true;

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What arrives at Monelix docks?", "Everything the capital needs - grain, timber, tools, wine, and trouble. The docks never truly rest. If trade stops for a day, half the city feels it by nightfall.");
        cv1.addOptionText(PORTUGUESE, "O que chega às docas de Monelix?", "Tudo de que a capital precisa - grãos, madeira, ferramentas, vinho e encrenca. As docas nunca param de verdade. Se o comércio para por um dia, metade da cidade sente isso antes do anoitecer.");
        cv1.addOptionText(SPANISH, "¿Qué llega a los muelles de Monelix?", "Todo lo que la capital necesita: grano, madera, herramientas, vino y problemas. Los muelles nunca descansan de verdad. Si el comercio se detiene un día, media ciudad lo siente antes del anochecer.");
        npc.conversationOptions.add(cv1);

        return npc;
    }
}