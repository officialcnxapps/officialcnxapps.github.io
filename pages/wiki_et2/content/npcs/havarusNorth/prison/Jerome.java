package com.cnx.endlesstalestwo.data.npcs.havarusNorth.prison;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.entities.Npc;

public class Jerome extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Jerome");
        npc.age = 52;
        npc.job = Enums.NPCJobs.PRISONER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "What are you staring at?", "The walls! They breathe, you know. In... and out... In... and out. If you listen closely, they tell you secrets. Terrible, wonderful secrets.");
        cv1.addOptionText(PORTUGUESE, "Para que você está olhando?", "As paredes! Elas respiram, sabia? Inspiram... e expiram... Inspiram... e expiram. Se você escutar com atenção, elas te contam segredos. Segredos terríveis e maravilhosos.");
        cv1.addOptionText(SPANISH, "¿Qué estás mirando?", "¡Las paredes! Respiran, ¿sabes? Inhalan... y exhalan... Inhalan... y exhalan. Si escuchas con atención, te cuentan secretos. Secretos terribles y maravillosos.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Are you alright?", "Hah! Alright? I've never been better! The king himself serves me my meals. Sometimes he looks like a rat, sometimes like a guard... he's a master of disguise, you see!");
        cv2.addOptionText(PORTUGUESE, "Você está bem?", "Hah! Bem? Nunca estive melhor! O próprio rei me serve as refeições. Às vezes ele parece um rato, às vezes um guarda... ele é um mestre dos disfarces, entende!");
        cv2.addOptionText(SPANISH, "¿Estás bien?", "¡Ja! ¿Bien? ¡Nunca he estado mejor! El mismísimo rey me sirve la comida. A veces parece una rata, a veces un guardia... ¡es un maestro del disfraz, ya ves!");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(1, 0);
        cv3.addOptionText(ENGLISH, "What kind of secrets?", "They whisper of a hidden key, a door that isn't there. They say it opens a path to the sky, but only for those who can hear the stones sing.");
        cv3.addOptionText(PORTUGUESE, "Que tipo de segredos?", "Elas sussurram sobre uma chave escondida, uma porta que não está lá. Dizem que abre um caminho para o céu, mas apenas para aqueles que conseguem ouvir as pedras cantarem.");
        cv3.addOptionText(SPANISH, "¿Qué clase de secretos?", "Susurran sobre una llave oculta, una puerta que no está ahí. Dicen que abre un camino al cielo, pero solo para aquellos que pueden oír cantar a las piedras.");
        npc.conversationOptions.add(cv3);

        return npc;
    }
}