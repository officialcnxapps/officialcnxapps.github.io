package com.cnx.endlesstalestwo.data.npcs.growrocks.tavern;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.entities.Npc;

public class ErinBarkskin extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Erin Barkskin");
        npc.age = 41;
        npc.job = Enums.NPCJobs.FEMALE_TAVERN_KEEPER;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A subtle and pleasant woman.\nVery experienced both in work and in life; she knows what she is doing.\nShe loves her husband, Pourin.\n\nHer physical traits: Long reddish hair, large rosy cheeks, clear eyes, and a friendly smile.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma mulher sútil e agradável.\nÉ muito experiente, tanto no seu trabalho quanto na vida, sabe o que faz.\nAma seu marido, Pourin.\n\nSeus traços físicos: Cabelos avermelhados e compridos. Bochechas rosadas e grandes. Olhos claros e sorriso amigável.");
        npc.addDescriptionTranslation(SPANISH, "Una mujer sutil y agradable.\nEs muy experimentada, tanto en su trabajo como en la vida; sabe lo que hace.\nAma a su esposo, Pourin.\n\nSus rasgos físicos: Cabello rojizo y largo, mejillas grandes y rosadas, ojos claros y sonrisa amigable.");

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // ===== ROLEPLAY 1: About working at the tavern =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "Do you enjoy working here?", "I do. It's hard work - cooking, serving, cleaning - but I like meeting people, hearing their stories. Miners come in exhausted and leave laughing. Warriors share tales of training. Even Oliman stops by sometimes for a quiet ale. This tavern is the heart of Growrocks in a way - where everyone gathers, where community happens. My husband Pourin handles the drinks, I handle the food. We make a good team.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Você gosta de trabalhar aqui?", "Gosto. É trabalho duro - cozinhar, servir, limpar - mas gosto de conhecer pessoas, ouvir suas histórias. Mineradores chegam exaustos e saem rindo. Guerreiros compartilham histórias de treinamento. Até Oliman aparece às vezes para uma cerveja tranquila. Esta taverna é o coração de Growrocks de certa forma - onde todos se reúnem, onde a comunidade acontece. Meu marido Pourin cuida das bebidas, eu cuido da comida. Fazemos uma boa equipe.");
        cvRoleplay1.addOptionText(SPANISH, "¿Disfrutas trabajando aquí?", "Sí. Es trabajo duro - cocinar, servir, limpiar - pero me gusta conocer gente, escuchar sus historias. Los mineros llegan exhaustos y se van riendo. Los guerreros comparten historias de entrenamiento. Incluso Oliman aparece a veces para una cerveza tranquila. Esta taberna es el corazón de Growrocks de cierta manera - donde todos se reúnen, donde sucede la comunidad. Mi esposo Pourin maneja las bebidas, yo manejo la comida. Hacemos un buen equipo.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY 2: About dwarven cooking =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "What do dwarves like to eat?", "Hearty food. After a day of hard labor, dwarves need substance. Roasted meats, thick stews, mushroom pies, root vegetable soups, dark bread with butter. Nothing fancy, but filling and flavorful. We can't grow everything underground - some meat comes from trade with the surface - but we make do. My mushroom stew is famous in Growrocks. Three generations of family recipe. The secret? Good mushrooms, patience, and a pinch of cave salt.");
        cvRoleplay2.addOptionText(PORTUGUESE, "O que os anões gostam de comer?", "Comida farta. Depois de um dia de trabalho árduo, anões precisam de substância. Carnes assadas, ensopados grossos, tortas de cogumelos, sopas de vegetais de raiz, pão escuro com manteiga. Nada sofisticado, mas saciante e saboroso. Não podemos cultivar tudo subterraneamente - alguma carne vem do comércio com a superfície - mas nos viramos. Meu ensopado de cogumelos é famoso em Growrocks. Três gerações de receita de família. O segredo? Bons cogumelos, paciência e uma pitada de sal de caverna.");
        npc.conversationOptions.add(cvRoleplay2);

        // ===== ROLEPLAY 3: About her marriage =====
        ConversationOption cvRoleplay3 = new ConversationOption(0, 0);
        cvRoleplay3.addOptionText(ENGLISH, "How long have you been married?", "Eighteen wonderful years. Pourin and I worked together in another tavern before we married - that's where we fell in love, actually. He was always so kind, so hardworking. Never complained, always had a smile for the customers. I knew he was the one. After we married, we dreamed of having our own place. Took years of saving, but we did it. Now we run this tavern together, just as we always planned. Some days are hard, but I wouldn't trade this life for anything. Working alongside the person you love - that's true happiness.");
        npc.conversationOptions.add(cvRoleplay3);

        return npc;
    }
}