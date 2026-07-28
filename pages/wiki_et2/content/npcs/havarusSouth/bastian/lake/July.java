package com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian.lake;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class July extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("July");
        npc.age = 12;
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A curious and clever child.\nShe enjoys being in nature.\nHer parents live in Apenna.\n\nHer physical characteristics: Short brown hair. An innocent and playful smile. Honey-colored eyes.");
        npc.addDescriptionTranslation(ENGLISH, "A curious and clever child.\nShe enjoys being in nature.\nHer parents live in Apenna.\n\nHer physical characteristics: Short brown hair. An innocent and playful smile. Honey-colored eyes.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma criança curiosa e esperta.\nSe diverte na natureza.\nSeus pais moram em Apenna.\n\nSeus traços físicos: Cabelos castanhos e curtos. Sorriso inocente e divertido. Olhos cor de mel.");
        npc.addDescriptionTranslation(SPANISH, "Una niña curiosa e inteligente.\nLe encanta estar en contacto con la naturaleza.\nSus padres viven en Apenna.\n\nCaracterísticas físicas: Cabello castaño corto. Sonrisa inocente y juguetona. Ojos color miel.");

        npc.generateRandomByes();
        npc.generateRandomGreetings();

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What do you like to do here?", "I like watching the water and guessing where the fish are. Sometimes I throw little stones and pretend they're tiny boats going to faraway kingdoms.");
        cv1.addOptionText(PORTUGUESE, "Do que você gosta de fazer aqui?", "Gosto de olhar a água e adivinhar onde os peixes estão. Às vezes jogo pedrinhas e finjo que são barquinhos indo para reinos distantes.");
        cv1.addOptionText(SPANISH, "¿Qué te gusta hacer aquí?", "Me gusta mirar el agua y adivinar dónde están los peces. A veces lanzo piedritas y finjo que son barquitos yendo a reinos lejanos.");
        npc.conversationOptions.add(cv1);

        return npc;
    }
}