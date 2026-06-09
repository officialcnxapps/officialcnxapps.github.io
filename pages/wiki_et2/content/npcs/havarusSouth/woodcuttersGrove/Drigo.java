package com.cnx.endlesstalestwo.data.npcs.havarusSouth.woodcuttersGrove;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class Drigo extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Drigo");
        npc.age = 26;
        npc.job = Enums.NPCJobs.WOODCUTTER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.generateRandomByes();
        npc.generateRandomGreetings();

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "How do you know which trees to cut?", "By age, by health, by space. A fool sees only timber. A good woodcutter sees which trees must stay so the grove can breathe and grow again.");
        cv1.addOptionText(PORTUGUESE, "Como você sabe quais árvores cortar?", "Pela idade, pela saúde e pelo espaço. Um tolo vê apenas madeira. Um bom lenhador enxerga quais árvores devem ficar para que o bosque respire e cresça de novo.");
        cv1.addOptionText(SPANISH, "¿Cómo sabes qué árboles cortar?", "Por la edad, la salud y el espacio. Un tonto solo ve madera. Un buen leñador ve qué árboles deben quedarse para que el bosque respire y vuelva a crecer.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Do you enjoy working in this grove?", "I do. The work is hard, but this grove speaks if you pay attention. In the morning you hear birds. By noon, only axes and falling wood. It keeps a man honest.");
        cv2.addOptionText(PORTUGUESE, "Você gosta de trabalhar neste bosque?", "Gosto, sim. O trabalho é pesado, mas este bosque fala com quem presta atenção. De manhã se ouvem os pássaros. Ao meio-dia, só machados e madeira caindo. Isso mantém um homem honesto.");
        cv2.addOptionText(SPANISH, "¿Te gusta trabajar en este bosque?", "Sí. El trabajo es duro, pero este bosque le habla a quien presta atención. Por la mañana se oyen los pájaros. Al mediodía, solo hachas e madera cayendo. Eso mantiene honesto a un hombre.");
        npc.conversationOptions.add(cv2);

        return npc;
    }
}