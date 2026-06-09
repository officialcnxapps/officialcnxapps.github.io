package com.cnx.endlesstalestwo.data.npcs.havarusNorth.plainsOfNorth;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class Phil extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Phil");
        npc.age = 38;
        npc.job = Enums.NPCJobs.MALE_HUNTER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.hasRandomizedConversations = true;

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "How is hunting in these plains?", "The plains look open and gentle, but game here is clever. You must read tracks, wind, and silence. A careless hunter comes home empty-handed - or does not come home at all.");
        cv1.addOptionText(PORTUGUESE, "Como é caçar nestas planícies?", "As planícies parecem abertas e tranquilas, mas a caça aqui é esperta. É preciso ler pegadas, vento e silêncio. Um caçador descuidado volta para casa sem nada - ou nem volta.");
        cv1.addOptionText(SPANISH, "¿Cómo es cazar en estas llanuras?", "Las llanuras parecen abiertas y tranquilas, pero la caza aquí es astuta. Debes leer huellas, viento y silencio. Un cazador descuidado vuelve a casa con las manos vacías... o no vuelve en absoluto.");
        npc.conversationOptions.add(cv1);

        return npc;
    }
}