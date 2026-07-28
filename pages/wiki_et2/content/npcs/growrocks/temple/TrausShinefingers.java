package com.cnx.endlesstalestwo.data.npcs.growrocks.temple;

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

import java.util.Collections;

public class TrausShinefingers extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Traus Shinefingers");
        npc.age = 39;
        npc.job = Enums.NPCJobs.MINER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A natural worker, very hardworking, perhaps even to excess.\nA grateful dwarf, faithful both to his deities and to those who help him.\nLoyal to his two siblings, Elliot and Kamala.\n\nHis physical traits: A full beard as black as his messy hair, and wide light-brown eyes.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um trabalhador nato. Muito esforçado, talvez até com certos exageros.\nUm anão agradecido, tanto a suas divindades tanto aqueles que o ajudam.\nFiel a seus 2 irmãos, Elliot e Kamala.\n\nSeus traços físicos: Barba preenchida, tão preta quanto seu cabelo despenteado. Olhos arregalados de cor marrom claro.");
        npc.addDescriptionTranslation(SPANISH, "Un trabajador nato, muy esforzado, quizás incluso con ciertos excesos.\nUn enano agradecido, tanto a sus divinidades como a quienes lo ayudan.\nFiel a sus 2 hermanos, Elliot y Kamala.\n\nSus rasgos físicos: Barba poblada, tan negra como su cabello despeinado, y ojos muy abiertos de color marrón claro.");
        npc.canBePickpocketed = true;

        // Unique uID to avoid conflict with Traus in oreFortress
        npc.resetId("TRAUS_AT_TEMPLE");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hello, my savior."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá, meu salvador."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola, mi salvador."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Stay safe, friend."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Fique seguro, amigo."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Mantente a salvo, amigo."));

        // NPC only appears at temple after quest is complete
        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.LOST_BROTHER)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // ===== ROLEPLAY: Grateful and recovering =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "How are you feeling?", "Much better, thanks to you. The priests here have healed my wounds - my leg is almost fully recovered. I was so close to death down there in the darkness. Those creatures... I'll never forget the terror. But you came for me. You saved my life when I had given up hope.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Como você está se sentindo?", "Muito melhor, graças a você. Os sacerdotes aqui curaram meus ferimentos - minha perna está quase totalmente recuperada. Eu estive tão perto da morte lá embaixo na escuridão. Aquelas criaturas... nunca esquecerei o terror. Mas você veio por mim. Você salvou minha vida quando eu havia perdido a esperança.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cómo te sientes?", "Mucho mejor, gracias a ti. Los sacerdotes aquí han curado mis heridas: mi pierna está casi completamente recuperada. Estuve tan cerca de la muerte allí abajo en la oscuridad. Esas criaturas... nunca olvidaré el terror. Pero viniste por mí. Salvaste mi vida cuando había perdido la esperanza.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY: Lesson learned =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Will you return to mining?", "Eventually, yes. Mining is in my blood - I'm a Shinefingers, after all. But I've learned my lesson. Never again will I venture into the deep levels alone. Greed for those blue crystals nearly killed me. From now on, I mine with partners, and I stay in the safer upper levels. Family is more important than any treasure.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Você vai voltar a minerar?", "Eventualmente, sim. Minerar está em meu sangue - sou um Shinefingers, afinal. Mas aprendi minha lição. Nunca mais me aventurarei nos níveis profundos sozinho. A ganância por aqueles cristais azuis quase me matou. De agora em diante, minero com parceiros, e fico nos níveis superiores mais seguros. Família é mais importante que qualquer tesouro.");
        cvRoleplay2.addOptionText(SPANISH, "¿Volverás a la minería?", "Eventualmente, sí. La minería está en mi sangre: soy un Shinefingers, después de todo. Pero he aprendido la lección. Nunca más me aventuraré solo en los niveles profundos. La codicia por esos cristales azules casi me mata. De ahora en adelante, mino con compañeros, y me quedo en los niveles superiores más seguros. La familia es más importante que cualquier tesoro.");
        npc.conversationOptions.add(cvRoleplay2);

        // ===== ROLEPLAY: Gratitude (GOOD alignment ≥70) =====
        ConversationOption cvRoleplayGood = new ConversationOption(0, 0);
        cvRoleplayGood.addOptionText(ENGLISH, "I'm glad you're safe.", "As am I, friend. As am I. Elliot was devastated when I didn't return - I could see it in his eyes when you brought me back. The Shinefingers family owes you everything. You risked your life in those dangerous depths for a stranger. That kind of courage... that kind of heart... it's rare. Thank you, hero. Truly.");
        cvRoleplayGood.addOptionText(PORTUGUESE, "Fico feliz que você esteja seguro.", "Eu também, amigo. Eu também. Elliot ficou devastado quando não retornei - pude ver em seus olhos quando você me trouxe de volta. A família Shinefingers te deve tudo. Você arriscou sua vida naquelas profundezas perigosas por um estranho. Esse tipo de coragem... esse tipo de coração... é raro. Obrigado, herói. De verdade.");
        cvRoleplayGood.addOptionText(SPANISH, "Me alegro de que estés a salvo.", "Yo también, amigo. Yo también. Elliot estaba devastado cuando no regresé - pude verlo en sus ojos cuando me trajiste de vuelta. La familia Shinefingers te debe todo. Arriesgaste tu vida en esas profundidades peligrosas por un extraño. Ese tipo de coraje... ese tipo de corazón... es raro. Gracias, héroe. De verdad.");
        cvRoleplayGood.requirementValidations = (chara, ctx) -> {
            // Only for GOOD characters (alignment ≥70)
            if (chara.attributesManager.getCurrent(Enums.AttributeName.ALIGNMENT) >= 70) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplayGood);

        // ===== ROLEPLAY: Mockery (EVIL alignment ≤30) =====
        ConversationOption cvRoleplayEvil = new ConversationOption(0, 0);
        cvRoleplayEvil.addOptionText(ENGLISH, "How did you manage to get lost down there?", "*Looks embarrassed and defensive*\nLost? I wasn't lost! I was... strategically repositioning to avoid the creatures! \n*crosses arms*\nThose tunnels all look the same in the dark. Anyone could have gotten turned around. Even you, with all your... smugness. I'm a skilled miner - I just had bad luck, that's all. \n*mumbles*\nCould happen to anyone...");
        cvRoleplayEvil.addOptionText(PORTUGUESE, "Como você conseguiu se perder lá embaixo?", "*Parece envergonhado e defensivo*\nPerdido? Eu não estava perdido! Eu estava... me reposicionando estrategicamente para evitar as criaturas! \n*cruza os braços*\nAqueles túneis todos parecem iguais no escuro. Qualquer um poderia ter se desorientado. Até você, com toda sua... presunção. Sou um minerador habilidoso - só tive má sorte, só isso. \n*murmura*\nPoderia acontecer com qualquer um...");
        cvRoleplayEvil.addOptionText(SPANISH, "¿Cómo lograste perderte allí abajo?", "*Se ve avergonzado y defensivo*\n¿Perdido? ¡No estaba perdido! Estaba... reposicionándome estratégicamente para evitar las criaturas! \n*cruza los brazos*\nEsos túneles se ven todos iguales en la oscuridad. Cualquiera podría haberse desorientado. Incluso tú, con toda tu... arrogancia. Soy un minero hábil - solo tuve mala suerte, eso es todo. \n*murmura*\nLe podría pasar a cualquiera...");
        cvRoleplayEvil.requirementValidations = (chara, ctx) -> {
            // Only for EVIL characters (alignment ≤30)
            if (chara.attributesManager.getCurrent(Enums.AttributeName.ALIGNMENT) <= 30) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplayEvil);

        return npc;
    }
}
