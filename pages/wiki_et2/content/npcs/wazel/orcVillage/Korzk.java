package com.cnx.endlesstalestwo.data.npcs.wazel.orcVillage;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Korzk extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Korzk");
        npc.age = 38;
        npc.job = Enums.NPCJobs.TRADER;
        npc.gender = Enums.Gender.MALE;
        npc.allowTraitsAnalysis = false;

        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CONTRABAND, 32)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // Roleplay
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Who are you?", "Korzk. Trader. Not fighter. Orcs here trade — different from others.");
        cv1.addOptionText(PORTUGUESE, "Quem é você?", "Korzk. Comerciante. Não lutador. Orcs aqui comerciam — diferente dos outros.");
        cv1.addOptionText(SPANISH, "¿Quién eres?", "Korzk. Comerciante. No guerrero. Los orcos aquí comercian — diferente a los demás.");
        npc.conversationOptions.add(cv1);

        // ========================================
        // QUEST: CONTRABAND — PART 32
        // ========================================

        ConversationOption cvQ32 = new ConversationOption(0, 0);
        cvQ32.addOptionText(ENGLISH, "Mordius sent me. I have the sealed package.",
                "*He glances around cautiously, then grabs the package quickly*\nGood. Korzk was waiting. Mordius keeps his word. Here — payment as agreed.\n*Presses coins into your hand*\nYou never come here. Korzk never see you. Understand?");
        cvQ32.addOptionText(PORTUGUESE, "Mordius me enviou. Tenho o pacote selado.",
                "*Ele olha ao redor com cautela e depois pega o pacote rapidamente*\nBom. Korzk estava esperando. Mordius cumpre sua palavra. Aqui — pagamento como combinado.\n*Empurra moedas para sua mão*\nVocê nunca veio aqui. Korzk nunca te viu. Entendeu?");
        cvQ32.addOptionText(SPANISH, "Mordius me envió. Tengo el paquete sellado.",
                "*Mira alrededor con cautela, luego agarra el paquete rápidamente*\nBien. Korzk estaba esperando. Mordius cumple su palabra. Aquí — pago como acordado.\n*Te presiona monedas en la mano*\nTú nunca viniste aquí. Korzk nunca te vio. ¿Entendido?");
        cvQ32.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CONTRABAND, 32)
                    && LibInventory.checkHasItem(ItemsIds.CONTRABAND_PACKAGE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvQ32.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.CONTRABAND_PACKAGE, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.CONTRABAND, 40, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQ32);

        return npc;
    }
}

