package com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.harbor;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.INVESTIGATE_THE_BEAST;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.SEA_VERIFICATION;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class GuzarAtHeleraHarbor extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Guzar");
        npc.resetId("GUZAR_AT_HELERA_HARBOR");
        npc.age = 37;
        npc.job = Enums.NPCJobs.GUILD_LEADER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");
        npc.imgFile = "npc_guzar";

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Greetins, [PLAYERNAME]."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Saudações, [PLAYERNAME]."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Saludos, [PLAYERNAME]."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Be careful."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Cuide-se."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Cuídate."));

        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, SEA_VERIFICATION, 4) && !LibQuest.charHasQuest(INVESTIGATE_THE_BEAST, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ///ABOUT QUEST: INVESTIGATE THE BEAST
        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "So, what are we going to do about these attacks?", "I've been talking to the captain here, the best thing is to find out which creature is attacking and then understand its habits. With that we'll attack back. Talk to the captain in charge here at the docks.");
        cv1.addOptionText(PORTUGUESE, "Então, o que faremos sobre esses ataques?", "Estive a falar com o capitão aqui, o melhor é descobrir qual criatura está atacando e então entender seus hábitos. Com isso vamos atacar de volta. Fale com o capitão responsável aqui nas docas.");
        cv1.addOptionText(SPANISH, "¿Entonces, qué vamos a hacer con estos ataques?", "He estado hablando con el capitán aquí, lo mejor es averiguar qué criatura está atacando y luego entender sus hábitos. Con eso contraatacaremos. Habla con el capitán a cargo aquí en los muelles.");
        cv1.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(INVESTIGATE_THE_BEAST, App.getPlayerChar(), ctx);
        };
        cv1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, SEA_VERIFICATION, 4) && !LibQuest.charHasQuest(INVESTIGATE_THE_BEAST, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(1, 999);
        cv2.addOptionText(ENGLISH, "Who is the captain?", "Captain Lukas, he's over there.\nI have to go, I have to go back to Monelix.");
        cv2.addOptionText(PORTUGUESE, "Quem é o capitão?", "Capitão Lukas, está ali.\nEu preciso ir, tenho que voltar para Monelix.");
        cv2.addOptionText(SPANISH, "¿Quién es el capitán?", "Capitán Lukas, está allí.\nTengo que irme, tengo que volver a Monelix.");
        npc.conversationOptions.add(cv2);

        return npc;
    }
}