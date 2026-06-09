package com.cnx.endlesstalestwo.data.npcs.lisport.Farms;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Madelaine extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, madelaine());
    }

    Npc madelaine() {
        Npc npc = new Npc("Madelaine");
        npc.age = 42;
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");
        npc.allowTraitsAnalysis = false;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hi, [PLAYERNAME]..."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Oi, [PLAYERNAME]..."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola, [PLAYERNAME]..."));

        npc.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.UNDER_ATTACK);
            if (requiredQuest != null && (requiredQuest.getCurrentPartOrder() == 3 || requiredQuest.getCurrentPartOrder() == 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "So, Madelaine, why are you here? Where is Herald?", "I am devastated, [PLAYERNAME]...\nIt is Herald...(Sobs and cry)\nHe died during the battle!");
        cv1.addOptionText(PORTUGUESE, "Então, Madelaine, por que você está aqui? Onde está Herald?", "Estou devastado, [PLAYERNAME]...\nÉ o Herald...(Soluços e choro)\nEle morreu durante a batalha!");
        cv1.addOptionText(SPANISH, "Entonces, Madelaine, ¿por qué estás aquí? ¿Dónde está Herald?", "Estoy devastado, [PLAYERNAME]...\nEs Herald... (solloza y llora)\n¡Murió durante la batalla!");

        ConversationOption cv2 = new ConversationOption(1, 2);
        cv2.addOptionText(ENGLISH, "No! Herald is dead?", "Yes... he killed 2 orcs, but then another one got him from behind... I can't believe, I lost my husband!");
        cv2.addOptionText(PORTUGUESE, "Não! Herald está morto?", "Sim... ele matou 2 orcs, mas então outro o atacou por trás... Não acredito, perdi meu marido!");
        cv2.addOptionText(SPANISH, "¡No! ¿Herald está muerto?", "Sí... mató a 2 orcos, pero luego otro lo atacó por detrás... ¡No puedo creerlo, perdí a mi marido!");

        ConversationOption cv3 = new ConversationOption(2, 999);
        cv3.addOptionText(ENGLISH, "Herald, my friend... I am so sorry.", "I need to go... (She leaves crying)");
        cv3.addOptionText(PORTUGUESE, "Herald, meu amigo... sinto muito.", "Preciso ir... (Ela sai chorando)");
        cv3.addOptionText(SPANISH, "Herald, mi amigo ... lo siento", "Necesito irme... (Se va llorando)");
        cv3.listeners = (ctx, fragment) -> LibQuest.updateQuest(QuestsIds.UNDER_ATTACK, 5, App.getPlayerChar(), ctx);

        npc.conversationOptions.add(cv1);
        npc.conversationOptions.add(cv2);
        npc.conversationOptions.add(cv3);

        return npc;
    }
}

