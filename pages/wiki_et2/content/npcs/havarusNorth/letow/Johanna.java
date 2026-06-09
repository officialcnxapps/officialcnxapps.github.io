package com.cnx.endlesstalestwo.data.npcs.havarusNorth.letow;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import android.os.Looper;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.shops.ShopsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibNpc;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Johanna extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, johanna());
    }

    Npc johanna() {
        Npc npc = new Npc("Johanna");
        npc.age = 46;
        npc.job = Enums.NPCJobs.NEEDLEWOMAN;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hello to you."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá para você."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola a ti."));

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What you do for living?", LibNpc.getAboutJobMsg(npc));
        cv1.addOptionText(PORTUGUESE, "O que você faz para viver?", LibNpc.getAboutJobMsg(npc));
        cv1.addOptionText(SPANISH, "¿A qué te dedicas?", LibNpc.getAboutJobMsg(npc));

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "I have a letter for you.", "For me? hum... thanks, I guess.");
        cv2.addOptionText(PORTUGUESE, "Tenho uma carta para você.", "Para mim? Hum... obrigado, eu acho.");
        cv2.addOptionText(SPANISH, "Tengo una carta para ti.", "¿Para mí? hum... gracias, supongo.");
        cv2.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.MEDICAL_SUPPORT);

            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 5) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv2.listeners = (ctx, fragment) -> {
            Quest quest = App.DataManager.getQuest(QuestsIds.MEDICAL_SUPPORT);
            LibInventory.removeFromInventory(ItemsIds.RAWER_LOVE_LETTER, 1, App.getPlayerChar());
            LibQuest.updateQuest(quest, 6, App.getPlayerChar(), ctx);
        };

        ConversationOption cv3 = new ConversationOption(0, 1);
        cv3.addOptionText(ENGLISH, "Do you sell something?", "If you mean, clothes, no. I only sew clothes and armors to fix.\nBut I sell supplies related with my profession.");
        cv3.addOptionText(PORTUGUESE, "Você vende alguma coisa?", "Se você quer dizer roupas, não. Eu só costuro roupas e armaduras para consertar.\nMas eu vendo suprimentos relacionados à minha profissão.");
        cv3.addOptionText(SPANISH, "¿Vendes algo?", "Si te refieres a ropa, no. Solo coso ropa y armaduras para arreglar.\nPero vendo suministros relacionados con mi profesión.");

        ConversationOption cv4 = new ConversationOption(1, 0);
        cv4.addOptionText(ENGLISH, "Great, show me the goods.", "Sure, feel free to look.");
        cv4.addOptionText(PORTUGUESE, "Ótimo, mostre-me os produtos.", "Claro, fique à vontade para dar uma olhada.");
        cv4.addOptionText(SPANISH, "Genial, enséñame la mercancía.", "Por supuesto, siéntete libre de mirar.");
        cv4.listeners = (ctx, fragment) -> {
            fragment.setScreenTouchable(false);
            new android.os.Handler(Looper.getMainLooper()).postDelayed(() -> {
                        if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                            gPlayActivity.lockScreenTouches(true);
                            gPlayActivity.goToViewShop(ShopsIds.JOHANNA_GOODS);
                        }
                    }
                    , 1600);
        };

        npc.conversationOptions.add(cv1);
        npc.conversationOptions.add(cv2);
        npc.conversationOptions.add(cv3);
        npc.conversationOptions.add(cv4);

        return npc;
    }
}

