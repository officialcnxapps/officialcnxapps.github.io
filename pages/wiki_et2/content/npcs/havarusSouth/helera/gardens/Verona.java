package com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.gardens;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.INVESTIGATE_THE_BEAST;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.SEA_VERIFICATION;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Verona extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Verona");
        npc.age = 40;
        npc.job = Enums.NPCJobs.COUNSELOR;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.generateRandomByes();
        npc.generateRandomGreetings();

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "Greetings, ma'am.", "Oh, hello! All is well, [GENDER_CITIZEN_CALL]?");
        cv1.addOptionText(PORTUGUESE, "Saudações, senhora.", "Oh, olá! Tudo bem, [GENDER_CITIZEN_CALL]?");
        cv1.addOptionText(SPANISH, "Saludos, señora.", "¡Oh, hola! ¿Todo bien, [GENDER_CITIZEN_CALL]?");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(1, 2);
        cv2.addOptionText(ENGLISH, "What do you do?", "I am a [NPC_JOB]. The Lord asks for my advice to make decisions about the future of Helera. I am always among the people, I think it is easier to see what is needed and what makes sense for our city.\nAnd you?");
        cv2.addOptionText(PORTUGUESE, "O que você faz?", "Sou [NPC_JOB]. O Lorde pede meus conselhos para tomar decisões sobre o futuro de Helera. Estou sempre em meio ao povo, acho que é mais fácil de perceber o que é preciso e o que faz sentido para nossa cidade.\nE você?");
        cv2.addOptionText(SPANISH, "¿Qué haces?", "Soy [NPC_JOB]. El Señor me pide consejo para tomar decisiones sobre el futuro de Helera. Siempre estoy entre la gente, creo que es más fácil percibir lo que se necesita y lo que tiene sentido para nuestra ciudad.\n¿Y tú?");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(2, 0);
        cv3.addOptionText(ENGLISH, "My name is [PLAYERNAME], I'm a [PLAYERCLASS].", "Very honored to meet you, [PLAYERNAME].\nOh, also be aware, since we now know each other better, that I also study some nature magic, as a hobby. There is a lot of use in it, you should know.");
        cv3.addOptionText(PORTUGUESE, "Me chamo [PLAYERNAME], sou [PLAYERCLASS].", "Muito honrada em lhe conhecer, [PLAYERNAME].\nAh, fique também sabendo, já que agora nos conhecemos melhor, que também estudo algumas magias da natureza, como um passatempo. Há muita utilidade nisso, você deve saber.");
        cv3.addOptionText(SPANISH, "Mi nombre es [PLAYERNAME], soy [PLAYERCLASS].", "Muy honrada de conocerte, [PLAYERNAME].\nAh, y que sepas, ya que ahora nos conocemos mejor, que también estudio algunas magias de la naturaleza como pasatiempo. Hay mucha utilidad en ello, deberías saberlo.");
        npc.conversationOptions.add(cv3);

        ///ABOUT QUEST: SEA VERIFICATION
        ConversationOption cv4 = new ConversationOption(0, 3);
        cv4.addOptionText(ENGLISH, "Can you help me with magic?", "Of course, I think I can help you with some nature magic. What are you looking for?");
        cv4.addOptionText(PORTUGUESE, "Pode me ajudar com magias?", "Claro, acho que posso te ajudar com algumas magias da natureza. O que busca?");
        cv4.addOptionText(SPANISH, "¿Puedes ayudarme con magia?", "Claro, creo que puedo ayudarte con algo de magia de la naturaleza. ¿Qué buscas?");
        cv4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, INVESTIGATE_THE_BEAST, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(3, 0);
        cv5.addOptionText(ENGLISH, "I need to breathe in the depths of the sea.", "Oh, a rather rare and complex magic. Taming the waters is not easy. I've been trying to learn but I haven't succeeded yet. Do you want to know who can give you what you need? Griwalsh, the old herbalist and alchemist from the hut south of Havarus. He knows some rare things. Talk to him.");
        cv5.addOptionText(PORTUGUESE, "Preciso respirar nas profundezas do mar.", "Oh, uma magia um bocado rara e complexa. Dominar as águas não é fácil. Estive tentando aprendar mas ainda não consegui. Quer saber quem pode lhe dar o que precisa? Griwalsh, o velho herbalista e alquimista da cabana ao sul de Havarus. Ele sabe algumas coisas raras. Fale com ele.");
        cv5.addOptionText(SPANISH, "Necesito respirar en las profundidades del mar.", "Oh, una magia bastante rara y compleja. Dominar las aguas no es fácil. He estado intentando aprender pero aún no lo he conseguido. ¿Quieres saber quién puede darte lo que necesitas? Griwalsh, el viejo herbolario y alquimista de la cabaña al sur de Havarus. Él sabe algunas cosas raras. Habla con él.");
        npc.conversationOptions.add(cv5);
        cv5.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(INVESTIGATE_THE_BEAST, 4, App.getPlayerChar(), ctx);
        };

        return npc;
    }
}