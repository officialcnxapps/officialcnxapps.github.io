package com.cnx.endlesstalestwo.data.npcs.ayalon.citySquare;

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

public class Nariv extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Nariv");
        npc.age = 30;
        npc.job = Enums.NPCJobs.STUDENT;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A young elven girl. Still seeking to know more about life, almost too innocent.\nStudious and passionate about freedom.\n\nHer physical traits: Beautiful medium-length golden hair, fair skin, and well-defined lips.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma jovem garota elfa. Ainda em busca de saber mais sobre a vida, quase inocente demais.\nEstudiosa e apaixonada pela liberdade.\n\nSeus taços físicos: Belos cabelos dourados de comprimento médio, pele clara e boca bem marcada no rosto.");
        npc.addDescriptionTranslation(SPANISH, "Una joven chica elfa. Todavía busca saber más sobre la vida, casi demasiado inocente.\nEstudiosa y apasionada por la libertad.\n\nSus rasgos físicos: Hermoso cabello dorado de longitud media, piel clara y labios bien definidos.");
        npc.canBePickpocketed = true;

        npc.generateRandomByes();
        npc.generateRandomGreetings();

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What do you study here?", "Languages, history, and a little starlore when my tutors are patient. In Ayalon, even a walk through the square can become a lesson.");
        cv1.addOptionText(PORTUGUESE, "O que você estuda aqui?", "Idiomas, história e um pouco de saber das estrelas quando meus tutores estão pacientes. Em Ayalon, até uma caminhada pela praça pode virar uma lição.");
        cv1.addOptionText(SPANISH, "¿Qué estudias aquí?", "Idiomas, historia y un poco de saber de las estrellas cuando mis tutores están pacientes. En Ayalon, incluso un paseo por la plaza puede convertirse en una lección.");
        npc.conversationOptions.add(cv1);

        // ========================================
        // QUEST: Traitor
        // ========================================

        ConversationOption cvTraitorCasiel = new ConversationOption(0, 0);
        cvTraitorCasiel.addOptionText(ENGLISH, "Have you seen Casiel anywhere today?", "Casiel? No, I haven't seen him today. He is usually around the city square or the main streets... but I haven't noticed him. Is something wrong?");
        cvTraitorCasiel.addOptionText(PORTUGUESE, "Você viu Casiel em algum lugar hoje?", "Casiel? Não, não o vi hoje. Ele normalmente fica pela praça da cidade ou pelas ruas principais... mas não o percebi por aqui. Aconteceu algo?");
        cvTraitorCasiel.addOptionText(SPANISH, "¿Has visto a Casiel en algún lugar hoy?", "¿Casiel? No, no lo he visto hoy. Normalmente suele estar por la plaza de la ciudad o las calles principales... pero no lo he notado por aquí. ¿Ocurre algo?");
        cvTraitorCasiel.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.isCharacterAtQuestPart(chara, QuestsIds.TRAITOR, 1)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cvTraitorCasiel);

        return npc;
    }
}
