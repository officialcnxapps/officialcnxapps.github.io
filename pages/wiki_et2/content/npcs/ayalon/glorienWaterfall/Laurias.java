package com.cnx.endlesstalestwo.data.npcs.ayalon.glorienWaterfall;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class Laurias extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Laurias");
        npc.age = 47;
        npc.job = Enums.NPCJobs.STUDENT;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A young elf with a peaceful aura.\nNature scholar and likely a future druid.\nPeaceful, calm, and intelligent.\n\nHis physical traits: Straight, almost white blonde hair. Light gray eyes, square face without a beard.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um jovem elfo com uma aura tranquila.\nEstudioso da natureza e provavelmente um futuro druida.\nPacífico, calmo e inteligente.\n\nSeus traços físicos: Cabelo loiro quase branco, liso. Olhos cinzas claros, rosto quadrado sem barba.");
        npc.addDescriptionTranslation(SPANISH, "Un joven elfo con un aura tranquila.\nEstudioso de la naturaleza y probablemente un futuro druida.\nPacífico, tranquilo e inteligente.\n\nSus rasgos físicos: Cabello rubio casi blanco, liso. Ojos grises claros, rostro cuadrado sin barba.");
        npc.canBePickpocketed = true;

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Why do you spend time near the waterfall?", "The sound helps me think. Lessons in Ayalon can be demanding, and this place quiets the mind. Here, even difficult thoughts seem to settle.");
        cv1.addOptionText(PORTUGUESE, "Por que você passa tempo perto da cachoeira?", "O som me ajuda a pensar. As lições em Ayalon podem ser exigentes, e este lugar acalma a mente. Aqui, até pensamentos difíceis parecem se organizar.");
        cv1.addOptionText(SPANISH, "¿Por qué pasas tiempo cerca de la cascada?", "El sonido me ayuda a pensar. Las lecciones en Ayalon pueden ser exigentes, y este lugar calma la mente. Aquí, incluso los pensamientos difíciles parecen ordenarse.");
        npc.conversationOptions.add(cv1);

        return npc;
    }
}
