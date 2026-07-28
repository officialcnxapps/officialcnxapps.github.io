package com.cnx.endlesstalestwo.data.npcs.esperand.monastery;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Godman extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Godman");
        npc.age = 33;
        npc.job = Enums.NPCJobs.STUDENT;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A calm and thoughtful young man.\nHe knows well how much he knows and how much he still needs to learn.\nDevoted to his faith and peaceful in his attitude.\n\nHis physical traits: Youthful appearance, well-kept brown hair and beard, and a friendly gaze.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um rapaz sereno, pensativo.\nSabe bem o quanto conhece e o quanto precisa conhecer.\nDevoto a sua fé e tranquilo nas suas atitudes.\n\nSeus traços físicos: Aspecto jovem. Cabelo e barba bem cuidados e de tom castanho. Olhar amigável.");
        npc.addDescriptionTranslation(SPANISH, "Un joven sereno y pensativo.\nSabe bien cuánto conoce y cuánto necesita conocer todavía.\nDevoto a su fe y tranquilo en sus actitudes.\n\nSus rasgos físicos: Aspecto juvenil, cabello y barba bien cuidados de tono castaño, y mirada amigable.");
        npc.canBePickpocketed = true;

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What are you studying so intently?", "The nature of the divine, of course! Trying to figure out if the gods get bored. I mean, eternity is a long time, right? Perhaps that's why they meddle with us mortals so much. It's the divine equivalent of reality television!");
        cv1.addOptionText(PORTUGUESE, "O que você está estudando com tanta atenção?", "A natureza do divino, é claro! Tentando descobrir se os deuses ficam entediados. Quero dizer, a eternidade é muito tempo, certo? Talvez seja por isso que eles se metem tanto conosco, mortais. É o equivalente divino de um reality show!");
        cv1.addOptionText(SPANISH, "¿Qué estudias con tanta atención?", "¡La naturaleza de lo divino, por supuesto! Intentando averiguar si los dioses se aburren. O sea, la eternidad es mucho tiempo, ¿no? Quizás por eso se entrometen tanto con nosotros los mortales. ¡Es el equivalente divino de un reality show!");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Any interesting theological discoveries lately?", "Oh, absolutely! I've just postulated that the creator might have a terrible sense of humor. Why else would giraffes exist? It's a divine practical joke, I tell you! A glorious, long-necked, spotty joke!");
        cv2.addOptionText(PORTUGUESE, "Alguma descoberta teológica interessante ultimamente?", "Oh, com certeza! Acabei de postular que o criador pode ter um péssimo senso de humor. Por que mais as girafas existiriam? É uma piada divina, eu lhe digo! Uma gloriosa piada de pescoço comprido e malhada!");
        cv2.addOptionText(SPANISH, "¿Algún descubrimiento teológico interesante últimamente?", "¡Oh, por supuesto! Acabo de postular que el creador podría tener un pésimo sentido del humor. ¿Por qué si no existirían las jirafas? ¡Es una broma divina, te lo aseguro! ¡Una gloriosa broma de cuello largo y manchas!");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(0, 0);
        cv3.addOptionText(ENGLISH, "What can you tell me about light and dark magic?", "I'm still learning more about it, I'm even looking forward to it! But Mr. Sariseus can tell you more about it.");
        cv3.addOptionText(PORTUGUESE, "O que pode me contar sobre magia de luz e trevas?", "Ainda estou aprendendo mais sobre isso, inclusive estou ansioso! Mas o senhor Sariseus pode lhe dizer mais sobre isso.");
        cv3.addOptionText(SPANISH, "¿Qué puede decirme sobre la magia de la luz y la oscuridad?", "Todavía estoy aprendiendo más sobre ello, ¡incluso estoy ansioso! Pero el señor Sariseus puede contarte más al respecto.");
        cv3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.WHO_IS_THE_ENEMY, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv3);

        return npc;
    }
}