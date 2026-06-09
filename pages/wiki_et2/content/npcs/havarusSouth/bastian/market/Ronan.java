package com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian.market;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class Ronan extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Ronan");
        npc.age = 50;
        npc.job = Enums.NPCJobs.LANDLORD;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        //Can be used for the side-quest "Like a Landlord"

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What does a landlord do all day?", "More than people think. Roofs leak, tenants complain, merchants bargain, and everyone remembers me when taxes are due.");
        cv1.addOptionText(PORTUGUESE, "O que um senhorio faz o dia todo?", "Mais do que as pessoas pensam. Telhados vazam, inquilinos reclamam, mercadores negociam, e todo mundo se lembra de mim quando os impostos vencem.");
        cv1.addOptionText(SPANISH, "¿Qué hace un propietario todo el día?", "Más de lo que la gente cree. Los techos gotean, los inquilinos se quejan, los mercaderes negocian y todos se acuerdan de mí cuando vencen los impuestos.");
        npc.conversationOptions.add(cv1);

        return npc;
    }
}