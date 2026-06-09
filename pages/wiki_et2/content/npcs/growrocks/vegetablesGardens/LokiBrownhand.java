package com.cnx.endlesstalestwo.data.npcs.growrocks.vegetablesGardens;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class LokiBrownhand extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Loki Brownhand");
        npc.age = 11;
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A dreamy young boy. Respectful and intelligent.\nWell raised, and likely to have a good future if he stays this way.\n\nHis physical traits: Round face, clear eyes, straight blond hair, and ears as large as his cheeks.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um jovem garoto sonhador. Respeitoso e inteligente.\nÉ bem criado e deve ter um bom futuro se seguir assim.\n\nSeus traços físicos: Rosto redondo, olhos claros e cabelo liso e loiro. Orelhas grandes como as bochechas.");
        npc.addDescriptionTranslation(SPANISH, "Un joven muchacho soñador. Respetuoso e inteligente.\nEstá bien criado y debe tener un buen futuro si sigue así.\n\nSus rasgos físicos: Rostro redondo, ojos claros, cabello lacio y rubio, y orejas grandes como sus mejillas.");

        //this npc is son of NPC FiolaBrowhand

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // ===== ROLEPLAY 1: About helping his mother =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "What do you do here?", "I help my mother in the gardens! I water the plants, pull weeds, carry tools. It's hard work but mother says I'm getting strong. Someday I want to join the guard like the big warriors, but mother says I need to learn discipline first. So I work hard, do what she asks, practice with my wooden sword when chores are done. I'll be the best guard Growrocks ever had!");
        cvRoleplay1.addOptionText(PORTUGUESE, "O que você faz aqui?", "Ajudo minha mãe nos jardins! Rego as plantas, arranco ervas daninhas, carrego ferramentas. É trabalho duro mas mãe diz que estou ficando forte. Um dia quero me juntar à guarda como os grandes guerreiros, mas mãe diz que preciso aprender disciplina primeiro. Então trabalho duro, faço o que ela pede, pratico com minha espada de madeira quando as tarefas terminam. Serei o melhor guarda que Growrocks já teve!");
        cvRoleplay1.addOptionText(SPANISH, "¿Qué haces aquí?", "¡Ayudo a mi madre en los jardines! Riego las plantas, arranco malas hierbas, cargo herramientas. Es trabajo duro pero madre dice que me estoy poniendo fuerte. Algún día quiero unirme a la guardia como los grandes guerreros, pero madre dice que necesito aprender disciplina primero. Así que trabajo duro, hago lo que ella pide, practico con mi espada de madera cuando las tareas terminan. ¡Seré el mejor guardia que Growrocks jamás haya tenido!");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY 2: About his father =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Tell me about your family.", "Mother says my father was a brave miner. He died in an accident before I could really know him. I don't remember much, but mother says he would be proud of how hard I work. She works so hard too - growing food for everyone, never complaining. I want to make her proud, maybe join the guard and protect our home. That way I can honor both my parents - father's bravery and mother's dedication.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Conte-me sobre sua família.", "Mãe diz que meu pai era um minerador corajoso. Ele morreu em um acidente antes que eu pudesse realmente conhecê-lo. Não me lembro muito, mas mãe diz que ele ficaria orgulhoso de quanto eu trabalho. Ela trabalha tão duro também - cultivando comida para todos, nunca reclamando. Quero deixá-la orgulhosa, talvez me juntar à guarda e proteger nosso lar. Assim posso honrar ambos meus pais - a bravura do pai e a dedicação da mãe.");
        cvRoleplay2.addOptionText(SPANISH, "Cuéntame sobre tu familia.", "Madre dice que mi padre era un minero valiente. Murió en un accidente antes de que pudiera conocerlo realmente. No recuerdo mucho, pero madre dice que estaría orgulloso de cuánto trabajo. Ella también trabaja tan duro - cultivando comida para todos, nunca quejándose. Quiero hacerla sentir orgullosa, tal vez unirme a la guardia y proteger nuestro hogar. Así puedo honrar a ambos mis padres - la valentía del padre y la dedicación de la madre.");
        npc.conversationOptions.add(cvRoleplay2);


        return npc;
    }
}