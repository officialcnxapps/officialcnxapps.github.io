package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.castle;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class Priany extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Priany");
        npc.age = 50;
        npc.job = Enums.NPCJobs.FEMALE_COOK;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "Experienced in the work she does, but slightly naive about life.\nDedicated and loyal to the nobility, who has always treated her well.\n\nHer physical traits: Slightly graying hair, prominent rosy cheeks. Warm smile and green eyes.");
        npc.addDescriptionTranslation(PORTUGUESE, "Experiente no trabalho que realiza, mas levemente inocente na vida.\nDedicada e leal a nobreza, que sempre lhe tratou bem.\n\nSeus traços físicos: Cabelos levemente grisalhos, bochechas salientes e rosadas. Sorriso caloroso e olhos verdes.");
        npc.addDescriptionTranslation(SPANISH, "Experimentada en el trabajo que realiza, pero levemente inocente en la vida.\nDedicada y leal a la nobleza, que siempre la ha tratado bien.\n\nSus rasgos físicos: Cabello levemente canoso, mejillas prominentes y rosadas. Sonrisa cálida y ojos verdes.");
        npc.canBePickpocketed = true;

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What is it like cooking in the castle?", "Demanding. A castle kitchen feeds guards, servants, guests, and nobles, all with different expectations. The food must arrive warm, on time, and worthy of the crown.");
        cv1.addOptionText(PORTUGUESE, "Como é cozinhar no castelo?", "Exigente. A cozinha do castelo alimenta guardas, servos, convidados e nobres, todos com expectativas diferentes. A comida deve chegar quente, no tempo certo e digna da coroa.");
        cv1.addOptionText(SPANISH, "¿Cómo es cocinar en el castillo?", "Exigente. La cocina del castillo alimenta a guardias, sirvientes, invitados y nobles, todos con expectativas distintas. La comida debe llegar caliente, a tiempo y digna de la corona.");
        npc.conversationOptions.add(cv1);

        return npc;
    }
}