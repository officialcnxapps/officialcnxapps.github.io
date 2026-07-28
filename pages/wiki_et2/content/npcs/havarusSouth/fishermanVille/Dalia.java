package com.cnx.endlesstalestwo.data.npcs.havarusSouth.fishermanVille;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.A_RUMOR_SPREADING;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.WHO_IS_THE_ENEMY;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.Character;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Dalia extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Dalia");
        npc.age = 56;
        npc.job = Enums.NPCJobs.FEMALE_FISHERMAN;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A patient and calm lady.\nShe does her work with efficiency and tranquility.\nShe has lived her entire life in the same place.\n\nHer physical traits: Straight gray hair in a braid. Face slightly wrinkled with age. Light brown eyes.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma senhora paciente e calma.\nFaz seu trabalho com eficiência e tranquilidade.\nViveu sua vida toda no mesmo lugar.\n\nSeus traços físicos: Cabelos grisalhos e lisos com uma trança. Rosto levemente enrugado pela idade. Olhos castanhos claros.");
        npc.addDescriptionTranslation(SPANISH, "Una señora paciente y tranquila.\nHace su trabajo con eficiencia y tranquilidad.\nVivió toda su vida en el mismo lugar.\n\nSus rasgos físicos: Cabello grisáceo y liso con una trenza. Rostro ligeramente arrugado por la edad. Ojos castaños claros.");
        npc.canBePickpocketed = true;

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "How is the fishing today?", "The sea is generous today, young one. The nets are full, and the sun is warm. A good day indeed.");
        cv1.addOptionText(PORTUGUESE, "Como está a pesca hoje?", "O mar está generoso hoje, jovem. As redes estão cheias e o sol está quente. Um bom dia, de fato.");
        cv1.addOptionText(SPANISH, "¿Cómo va la pesca hoy?", "El mar está generoso hoy, joven. Las redes están llenas y el sol calienta. Un buen día, ciertamente.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Do you have any advice on how to fish well?", "Patience, young one, patience is key. And learn to read the waters, the tides, the way the birds fly. The sea speaks to those who listen.");
        cv2.addOptionText(PORTUGUESE, "Você tem algum conselho sobre como pescar bem?", "Paciência, jovem, paciência é a chave. E aprenda a ler as águas, as marés, o jeito que os pássaros voam. O mar fala com quem escuta.");
        cv2.addOptionText(SPANISH, "¿Tiene algún consejo sobre cómo pescar bien?", "Paciencia, joven, la paciencia es la clave. Y aprende a leer las aguas, las mareas, la forma en que vuelan los pájaros. El mar habla a quienes escuchan.");
        npc.conversationOptions.add(cv2);

        ///ABOUT QUEST: A RUMOR SPREADING
        ConversationOption cv3 = new ConversationOption(0, 1);
        cv3.addOptionText(ENGLISH, "What can you tell me about the girl who was killed?", "Oh, I didn't want to have to remember that...\nOwina... a good girl. She was a cook, made good food for the people of our village. The grilled fish was divine.");
        cv3.addOptionText(PORTUGUESE, "O que pode me dizer sobre a moça que foi morta?", "Oh, não queria ter que lembrar disso...\nOwina... uma boa moça. Ela era cozinheira, fazia boas comidas para o povo da nossa vila. O peixe na brasa era divino.");
        cv3.addOptionText(SPANISH, "¿Qué puedes decirme sobre la chica que fue asesinada?", "Oh, no quería tener que recordar eso...\nOwina... una buena chica. Era cocinera, hacía buena comida para la gente de nuestro pueblo. El pescado a la parrilla era divino.");
        cv3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, A_RUMOR_SPREADING, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(1, 2);
        cv4.addOptionText(ENGLISH, "Who killed her?", "That demon! She had gone to Apenna, was killed when she was almost there. That beast fled to the forests here, but the guards were alert and managed to decapitate the creature.");
        cv4.addOptionText(PORTUGUESE, "Quem a matou?", "Aquele demônio! Ela tinha ido até Apenna, foi morta quando estava quase chegando. Aquela besta fugiu para as florestas daqui, mas os guardas estavam atentos e conseguiram decepar a cabeça da criatura.");
        cv4.addOptionText(SPANISH, "¿Quién la mató?", "¡Ese demonio! Había ido a Apenna, fue asesinada cuando casi llegaba. Esa bestia huyó a los bosques de aquí, pero los guardias estaban alerta y lograron decapitar a la criatura.");
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(2, 0);
        cv5.addOptionText(ENGLISH, "So they caught the creature?!", "Yes, yes! They took the body to the prison, I think they were going to study it to know better what it was.\nIf possible, I'd rather not talk about this anymore, Owina was my friend...");
        cv5.addOptionText(PORTUGUESE, "Então pegaram a criatura?!", "Sim, sim! Levaram o corpo para a prisão, acho que iam estudar ele pra saber melhor o que era.\nSe possível, prefiro não falar mais disso, Owina era minha amiga...");
        cv5.addOptionText(SPANISH, "¡¿Así que atraparon a la criatura?!", "¡Sí, sí! Llevaron el cuerpo a la prisión, creo que iban a estudiarlo para saber mejor qué era.\nSi es posible, prefiero no hablar más de esto, Owina era mi amiga...");
        cv5.listeners = (ctx, currentFragment) -> {
            Character chara = App.getPlayerChar();
            Quest quest = chara.getQuest(A_RUMOR_SPREADING);
            LibQuest.updateQuest(quest, 4, App.getPlayerChar(), ctx);
            App.Shell.flowManager.addCompletedQuestToQueue(quest,ctx);

            LibQuest.includeQuestToQuestbook(WHO_IS_THE_ENEMY, chara, ctx);
            App.Shell.saveGame(ctx);
        };
        npc.conversationOptions.add(cv5);

        return npc;
    }
}