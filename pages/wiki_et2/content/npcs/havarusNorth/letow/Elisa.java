package com.cnx.endlesstalestwo.data.npcs.havarusNorth.letow;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.cnxgameengine.utils.LibUtils.createList;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Elisa extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Elisa");
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");
        npc.age = 28;
        npc.job = Enums.NPCJobs.FEMALE_FARMER;

        // Add greetings
        npc.greetingsMessages.put(ENGLISH, createList("Welcome to Letow, traveler! This village may be small, but it has its own charm.", "Hello there! Nice to see a new face in our little village."));
        npc.greetingsMessages.put(PORTUGUESE, createList("Bem-vindo a Letow, viajante! Esta vila pode ser pequena, mas tem seu próprio charme.", "Olá! Bom ver um novo rosto na nossa pequena vila."));
        npc.greetingsMessages.put(SPANISH, createList("¡Bienvenido a Letow, viajero! Esta aldea puede ser pequeña, pero tiene su propio encanto.", "¡Hola! Es agradable ver una cara nueva en nuestra pequeña aldea."));

        // Add bye messages
        npc.byeMessages.put(ENGLISH, createList("Farewell! Hope you enjoy your time in Letow.", "Come back to visit soon. Our village is small, but we welcome all travelers."));
        npc.byeMessages.put(PORTUGUESE, createList("Adeus! Espero que aproveite seu tempo em Letow.", "Volte para visitar em breve. Nossa vila é pequena, mas recebemos todos os viajantes."));
        npc.byeMessages.put(SPANISH, createList("¡Adiós! Espero que disfrutes tu tiempo en Letow.", "Vuelve a visitarnos pronto. Nuestra aldea es pequeña, pero damos la bienvenida a todos los viajeros."));

        // Conversation about the weather
        ConversationOption cv5 = new ConversationOption();
        cv5.addOptionText(ENGLISH, "How's the weather in this region?", "We get mild seasons here. The spring brings plenty of rain, which makes it the only good season to plant in this soil. Summers aren't too hot, and winters aren't too harsh. It's one of the reasons many of us choose to remain in Letow despite it being such a small village.");
        cv5.addOptionText(PORTUGUESE, "Como é o clima nesta região?", "Temos estações moderadas aqui. A primavera traz muita chuva, o que faz com que seja a única estação boa para plantar nesse solo. Os verões não são muito quentes e os invernos não são muito rigorosos. É uma das razões pelas quais muitos de nós escolhemos permanecer em Letow, apesar de ser uma vila tão pequena.");
        cv5.addOptionText(SPANISH, "¿Cómo es el clima en esta región?", "Tenemos estaciones suaves aquí. La primavera trae mucha lluvia, lo que la convierte en la única buena estación para plantar en este suelo. Los veranos no son demasiado calurosos y los inviernos no son demasiado duros. Es una de las razones por las que muchos de nosotros elegimos quedarnos en Letow a pesar de ser un pueblo tan pequeño.");
        npc.conversationOptions.add(cv5);

        // ===== QUEST: Plague! - Part 3 (deliver ingredients and receive insecticide) =====
        ConversationOption cvPlague3 = new ConversationOption(0, 6);
        cvPlague3.addOptionText(ENGLISH, "I need help making insecticide. Larien sent me.", "*Nods knowingly*\nAh, so Larien sent you? Yes, I've been making insecticide for years - it's one of the things I learned from my grandmother. Pests can destroy an entire season's crops if you're not careful. Let me see... do you have the ingredients? I'll need 5 Seaweed, 5 Coal, 3 Yellow Herb, and 1 Water to prepare a strong batch.");
        cvPlague3.addOptionText(PORTUGUESE, "Preciso de ajuda para fazer inseticida. Larien me enviou.", "*Acena sabendo*\nAh, então Larien te enviou? Sim, faço inseticida há anos - é uma das coisas que aprendi com minha avó. Pragas podem destruir a colheita de uma temporada inteira se você não for cuidadoso. Deixe-me ver... você tem os ingredientes? Vou precisar de 5 Algas, 5 Carvões, 3 Ervas Amarelas e 1 Água para preparar um lote forte.");
        cvPlague3.addOptionText(SPANISH, "Necesito ayuda para hacer insecticida. Larien me envió.", "*Asiente sabiéndolo*\nAh, ¿así que Larien te envió? Sí, he estado haciendo insecticida durante años - es una de las cosas que aprendí de mi abuela. Las plagas pueden destruir toda la cosecha de una temporada si no tienes cuidado. Déjame ver... ¿tienes los ingredientes? Necesitaré 5 Algas, 5 Carbones, 3 Hierbas Amarillas y 1 Agua para preparar un lote fuerte.");
        cvPlague3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PLAGUE, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPlague3);

        // Option when player HAS the items
        ConversationOption cvPlague3HasItems = new ConversationOption(6, 7);
        cvPlague3HasItems.addOptionText(ENGLISH, "[Give ingredients]", "*Takes the ingredients and examines them carefully*\nPerfect! These are exactly what I need. Now, let me work on this... \n*Begins mixing the ingredients with practiced movements*\nThe key is getting the proportions just right. Too much seaweed and it won't be effective. Too little coal and it won't bind properly...\n*After a few minutes*\nThere! The insecticide is ready. Here, take it. But be careful when you use it - this mixture is potent. Spread it over the affected crops, but stay alert. Sometimes insects react violently when threatened.");
        cvPlague3HasItems.addOptionText(PORTUGUESE, "[Entregar ingredientes]", "*Pega os ingredientes e os examina cuidadosamente*\nPerfeito! Estes são exatamente o que eu preciso. Agora, deixe-me trabalhar nisso... \n*Começa a misturar os ingredientes com movimentos práticos*\nA chave é acertar as proporções. Muita alga e não será eficaz. Pouco carvão e não vai se ligar direito...\n*Depois de alguns minutos*\nPronto! O inseticida está pronto. Aqui, pegue. Mas tome cuidado quando usar - esta mistura é potente. Espalhe sobre as plantações afetadas, mas fique alerta. Às vezes os insetos reagem violentamente quando ameaçados.");
        cvPlague3HasItems.addOptionText(SPANISH, "[Entregar ingredientes]", "*Toma los ingredientes y los examina cuidadosamente*\n¡Perfecto! Estos son exactamente lo que necesito. Ahora, déjame trabajar en esto... \n*Comienza a mezclar los ingredientes con movimientos practicados*\nLa clave es obtener las proporciones correctas. Demasiada alga y no será efectivo. Poco carbón y no se unirá correctamente...\n*Después de unos minutos*\n¡Listo! El insecticida está listo. Aquí, tómalo. Pero ten cuidado cuando lo uses - esta mezcla es potente. Esparce sobre los cultivos afectados, pero mantente alerta. A veces los insectos reaccionan violentamente cuando están amenazados.");
        cvPlague3HasItems.requirementValidations = (chara, ctx) -> {
            boolean hasItems = LibInventory.checkHasItemAmount(ItemsIds.ALGAE, 5, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.COAL, 5, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.YELLOW_HERB, 3, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.WATER, 1, chara);

            if (hasItems) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPlague3HasItems);

        ConversationOption cvPlague3Complete = new ConversationOption(7, 0);
        cvPlague3Complete.addOptionText(ENGLISH, "Thank you! I'll head to Farmland right away.", "Good luck! I hope it works. Those farmers have been through enough already. If the insecticide solves their problem, tell Helinda to come see me if she needs more in the future!");
        cvPlague3Complete.addOptionText(PORTUGUESE, "Obrigado! Vou para Farmland imediatamente.", "Boa sorte! Espero que funcione. Esses fazendeiros já passaram por demais. Se o inseticida resolver o problema deles, diga a Helinda para vir me ver se precisar de mais no futuro!");
        cvPlague3Complete.addOptionText(SPANISH, "¡Gracias! Me dirigiré a Farmland de inmediato.", "¡Buena suerte! Espero que funcione. Esos granjeros ya han pasado por suficiente. Si el insecticida resuelve su problema, ¡dile a Helinda que venga a verme si necesita más en el futuro!");
        cvPlague3Complete.listeners = (ctx, fragment) -> {
            // Remove ingredients
            LibInventory.removeFromInventory(ItemsIds.ALGAE, 5, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.COAL, 5, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.YELLOW_HERB, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.WATER, 1, App.getPlayerChar());

            // Give insecticide
            LibInventory.addToInventory(ItemsIds.INSECTICIDE, 1, App.getPlayerChar());

            // Update quest to Part 4 (return to Farmland)
            LibQuest.updateQuest(QuestsIds.PLAGUE, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPlague3Complete);

        // Option when player DOES NOT have the items
        ConversationOption cvPlague3NoItems = new ConversationOption(6, 0);
        cvPlague3NoItems.addOptionText(ENGLISH, "[Check ingredients]", "*Looks at what you have*\nHmm, you don't have everything yet. Remember, I need 5 Seaweed, 5 Coal, 3 Yellow Herb, and 1 Water. Come back when you have all the ingredients!");
        cvPlague3NoItems.addOptionText(PORTUGUESE, "[Verificar ingredientes]", "*Olha o que você tem*\nHmm, você ainda não tem tudo. Lembre-se, preciso de 5 Algas, 5 Carvões, 3 Ervas Amarelas e 1 Água. Volte quando tiver todos os ingredientes!");
        cvPlague3NoItems.addOptionText(SPANISH, "[Verificar ingredientes]", "*Mira lo que tienes*\nHmm, aún no tienes todo. Recuerda, necesito 5 Algas, 5 Carbones, 3 Hierbas Amarillas y 1 Agua. ¡Vuelve cuando tengas todos los ingredientes!");
        cvPlague3NoItems.requirementValidations = (chara, ctx) -> {
            boolean hasItems = LibInventory.checkHasItemAmount(ItemsIds.ALGAE, 5, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.COAL, 5, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.YELLOW_HERB, 3, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.WATER, 1, chara);

            if (!hasItems) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPlague3NoItems);

        // Conversation about Letow village
        ConversationOption cv1 = new ConversationOption();
        cv1.addOptionText(ENGLISH, "Tell me about Letow village", "Letow is a humble village, not very big as you can see. Most of us here are farmers or crafters. We live a simple life, but it's peaceful. The river nearby provides us with fresh water and good fishing.");
        cv1.addOptionText(PORTUGUESE, "Conte-me sobre a vila de Letow", "Letow é uma vila humilde, não muito grande como você pode ver. A maioria de nós aqui são agricultores ou artesãos. Vivemos uma vida simples, mas é pacífica. O rio próximo nos fornece água fresca e boa pesca.");
        cv1.addOptionText(SPANISH, "Cuéntame sobre la aldea de Letow", "Letow es una aldea humilde, no muy grande como puedes ver. La mayoría de nosotros aquí somos granjeros o artesanos. Vivimos una vida simple, pero es pacífica. El río cercano nos proporciona agua fresca y buena pesca.");
        npc.conversationOptions.add(cv1);

        // Conversation about surrounding area
        ConversationOption cv2 = new ConversationOption();
        cv2.addOptionText(ENGLISH, "Is it safe around here?", "Mostly safe, yes. We occasionally have trouble with wild animals from the nearby woods, but nothing too dangerous. The real danger lies further out. I would avoid traveling alone if you plan to leave the village.");
        cv2.addOptionText(PORTUGUESE, "É seguro por aqui?", "Na maior parte sim. Ocasionalmente temos problemas com animais selvagens do bosque próximo, mas nada muito perigoso. O perigo real está mais longe. Eu evitaria viajar sozinho se você planeja deixar a vila.");
        cv2.addOptionText(SPANISH, "¿Es seguro por aquí?", "Mayormente seguro, sí. Ocasionalmente tenemos problemas con animales salvajes de los bosques cercanos, pero nada demasiado peligroso. El verdadero peligro está más lejos. Yo evitaría viajar solo si planeas salir de la aldea.");
        npc.conversationOptions.add(cv2);

        // Conversation about daily life
        ConversationOption cv3 = new ConversationOption();
        cv3.addOptionText(ENGLISH, "How is life as a farmer in Letow?", "It's honest work, tending to the fields and animals. The soil here isn't great, so we need a lot of fertilizer to grow enough to feed ourselves and trade a little with passing merchants. The people of Letow help each other, especially during harvest time. That's what makes this small village special - we're like a family.");
        cv3.addOptionText(PORTUGUESE, "Como é a vida como agricultora em Letow?", "É um trabalho honesto, cuidando dos campos e animais. O solo aqui não é bom, então precisamos muito adubo para poder cultivar o suficiente para nos alimentar e comercializar um pouco com mercadores que passam. As pessoas de Letow se ajudam, especialmente durante a época de colheita. É isso que torna esta pequena vila especial - somos como uma família.");
        cv3.addOptionText(SPANISH, "¿Cómo es la vida como granjera en Letow?", "Es un trabajo honesto, cuidando los campos y los animales. La tierra aquí no es muy buena, así que necesitamos mucho fertilizante para poder cultivar lo suficiente para alimentarnos y comerciar un poco con los comerciantes que pasan. La gente de Letow se ayuda mutuamente, especialmente durante la época de cosecha. Eso es lo que hace a esta pequeña aldea especial - somos como una familia.");
        npc.conversationOptions.add(cv3);

        // Conversation about Johanna
        ConversationOption cv4 = new ConversationOption();
        cv4.addOptionText(ENGLISH, "Do you know Johanna?", "Johanna? Yes, of course! She's my friend. We've known each other since childhood. She's been getting a lot of attention lately, since that man from Lisport started sending her letters. She's quite shy about it all!");
        cv4.addOptionText(PORTUGUESE, "Você conhece Johanna?", "Johanna? Sim, claro! Ela é minha amiga. Nos conhecemos desde a infância. Ela tem recebido muita atenção ultimamente, desde que aquele homem de Lisport começou a enviar cartas para ela. Ela é bastante tímida sobre tudo isso!");
        cv4.addOptionText(SPANISH, "¿Conoces a Johanna?", "¿Johanna? ¡Sí, por supuesto! Es mi amiga. Nos conocemos desde la infancia. Ha estado recibiendo mucha atención últimamente, desde que ese hombre de Lisport comenzó a enviarle cartas. ¡Ella es bastante tímida respecto a todo eso!");
        npc.conversationOptions.add(cv4);

        return npc;
    }
}