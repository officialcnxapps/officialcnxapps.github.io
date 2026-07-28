package com.cnx.endlesstalestwo.data.npcs.esperand;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class Malina extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Malina");
        npc.age = 20;
        npc.job = Enums.NPCJobs.FEMALE_COOK;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A young woman with an innocent yet focused expression, always moving efficiently in the kitchen.\nShe seems deeply devoted to her craft, but also dreamy about a more exciting future.\n\nHer physical traits: Light hair tied back. Honey-colored eyes and pale skin. Hands that show the marks of hard work.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma jovem mulher com uma expressão focada e inocente, sempre se movendo com eficiência na cozinha.\nEla parece profundamente dedicada ao seu ofício, mas também sonhadora com um futuro mais emocionante.\n\nSeus traços físicos: Cabelos claros presos. OIlhos cor de mel e pele pálida. Mãos que mostram as marcas do trabalho duro.");
        npc.addDescriptionTranslation(SPANISH, "Una joven con una expresión enfocada e inocente, que siempre se mueve con eficiencia en la cocina.\nParece profundamente dedicada a su oficio, pero también soñadora con un futuro más emocionante.\n\nSus rasgos físicos: Cabello claro recogido. Ojos color miel y piel pálida. Manos que muestran las marcas del trabajo duro.");
        npc.canBePickpocketed = true;

        npc.hasRandomizedConversations = true;

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What do you cook in a place this cold?", "Whatever keeps hands warm and spirits steady - thick stews, roasted fish, hot bread, and herbal broths. In Esperand, a good meal is how people endure winter.");
        cv1.addOptionText(PORTUGUESE, "O que você cozinha num lugar tão frio?", "Tudo que mantenha as mãos quentes e o ânimo firme - ensopados grossos, peixe assado, pão quente e caldos de ervas. Em Esperand, uma boa refeição é como as pessoas suportam o inverno.");
        cv1.addOptionText(SPANISH, "¿Qué cocinas en un lugar tan frío?", "Todo lo que mantenga las manos calientes y el ánimo firme: guisos espesos, pescado asado, pan caliente y caldos de hierbas. En Esperand, una buena comida es como la gente soporta el invierno.");
        npc.conversationOptions.add(cv1);

        return npc;
    }
}
