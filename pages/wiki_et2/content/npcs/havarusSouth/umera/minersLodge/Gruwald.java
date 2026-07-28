package com.cnx.endlesstalestwo.data.npcs.havarusSouth.umera.minersLodge;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.A_RUMOR_SPREADING;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Gruwald extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Gruwald");
        npc.age = 54;
        npc.job = Enums.NPCJobs.GUILD_LEADER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A leader who isn't very charismatic, but knows what he's doing and how to do it.\nHe worked as a miner before becoming the village leader.\nSerious and calm.\n\nHis physical traits: Messy blonde hair. Sparse stubble. Thin face and fair skin.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um líder não muito carismático, mas sabe o que faz e como fazer.\nTrabalhu como minerador antes de se tornar líder da vila.\nSério e calmo.\n\nSeus traços físicos: Cabelos loiros despenteados. Barba rala por fazer. Rosto magro e pele clara.");
        npc.addDescriptionTranslation(SPANISH, "Un líder no muy carismático, pero sabe lo que hace y cómo hacerlo.\nTrabajó como minero antes de convertirse en líder de la aldea.\nSerio y tranquilo.\n\nSus rasgos físicos: Cabello rubio despeinado. Barba rala por afeitar. Rostro delgado y piel clara.");
        npc.canBePickpocketed = true;

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Tell me about Umera.", "Umera is a humble village, but our spirit is as strong as the trees that surround us. We rely on the mines, they are the heart of our community, providing for us all. It's tough work, but it binds us together.");
        cv1.addOptionText(PORTUGUESE, "Fale-me sobre Umera.", "Umera é uma vila humilde, mas nosso espírito é tão forte quanto as árvores que nos cercam. Dependemos das minas, elas são o coração da nossa comunidade, provendo para todos nós. É um trabalho árduo, mas nos une.");
        cv1.addOptionText(SPANISH, "Háblame de Umera.", "Umera es una aldea humilde, pero nuestro espíritu es tan fuerte como los árboles que nos rodean. Dependemos de las minas, son el corazón de nuestra comunidad, proveyendo para todos nosotros. Es un trabajo duro, pero nos une.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Tell me about yourself.", "I've seen many seasons pass in Umera. As the leader here, I try my best to ensure our people are safe and our traditions are upheld. It's a responsibility I don't take lightly. The well-being of this village is my primary concern.");
        cv2.addOptionText(PORTUGUESE, "Fale-me sobre você.", "Já vi muitas estações passarem em Umera. Como líder aqui, faço o meu melhor para garantir que nosso povo esteja seguro e nossas tradições sejam mantidas. É uma responsabilidade que não encaro de ânimo leve. O bem-estar desta vila é minha principal preocupação.");
        cv2.addOptionText(SPANISH, "Háblame de ti.", "He visto pasar muchas estaciones en Umera. Como líder aquí, hago todo lo posible para asegurar que nuestra gente esté segura y nuestras tradiciones se mantengan. Es una responsabilidad que no me tomo a la ligera. El bienestar de esta aldea es mi principal preocupación.");
        npc.conversationOptions.add(cv2);

        ///ABOUT QUEST: A RUMOR SPREADING
        ConversationOption cv3 = new ConversationOption(0, 1);
        cv3.addOptionText(ENGLISH, "Monelix received a message about creature attacks.", "Ah, that's right. I sent the message.\nTwo of our villagers have been attacked in the last few nights by dark creatures. Luckily, they managed to escape with their lives, something that poor Apenna couldn't do...");
        cv3.addOptionText(PORTUGUESE, "Monelix recebeu um recado sobre ataques de criaturas.", "Ah, isso mesmo. Eu mandei a mensagem.\nDois de nossos aldeões foram atacados nas últimas noites por criaturas sombrias, por sorte conseguiram escapar com vida, coisa que aquela pobre coitada de Apenna não conseguiu...");
        cv3.addOptionText(SPANISH, "Monelix recibió un mensaje sobre ataques de criaturas.", "Ah, así es. Envié el mensaje.\nDos de nuestros aldeanos han sido atacados en las últimas noches por criaturas oscuras. Afortunadamente, lograron escapar con vida, algo que la pobre Apenna no pudo hacer...");
        cv3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara,A_RUMOR_SPREADING, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(1, 2);
        cv4.addOptionText(ENGLISH, "Poor Apenna?", "Exactly, may God rest her soul...\nI heard she went out at night to get a chicken to kill and prepare dinner. Shortly after, they heard screams and when they looked, some wicked creature ran off, leaving her lifeless body on the ground...");
        cv4.addOptionText(PORTUGUESE, "Pobre coitada de Apenna?", "Exatamente, que Deus a tenha...\nFiquei sabendo que ela saiu a noite para buscar uma galinha para matar e preparar o jantar. Pouco depois ouviram gritos e quando viram, alguma criatura maldosa correu, deixando o corpo dela desfalecido no chão...");
        cv4.addOptionText(SPANISH, "¿Pobre Apenna?", "Exactamente, que Dios la tenga en su gloria...\nEscuché que salió de noche a buscar una gallina para matarla y preparar la cena. Poco después, oyeron gritos y cuando miraron, alguna criatura malvada huyó, dejando su cuerpo sin vida en el suelo...");
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(2, 0);
        cv5.addOptionText(ENGLISH, "And did they see what creature it was?", "Our villagers couldn't identify it, it was night, they only know it wasn't human. Maybe Apenna's people can tell you more.");
        cv5.addOptionText(PORTUGUESE, "E viram que criatura era?", "Nossos aldeões não conseguiram identificar, era noite, só sabem que humano não era. Talvez o pessoal de Apenna saiba lhe dizer algo mais.");
        cv5.addOptionText(SPANISH, "¿Y vieron qué criatura era?", "Nuestros aldeanos no pudieron identificarla, era de noche, solo saben que no era humana. Quizás la gente de Apenna pueda decirte algo más.");
        cv5.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(A_RUMOR_SPREADING, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv5);

        return npc;
    }
}
