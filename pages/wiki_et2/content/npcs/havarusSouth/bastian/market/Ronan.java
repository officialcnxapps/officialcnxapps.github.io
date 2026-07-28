package com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian.market;

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

public class Ronan extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Ronan");
        npc.age = 54;
        npc.job = Enums.NPCJobs.LANDLORD;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Hardworking and serious.\nA man of few words.\nHe rarely speaks out and only does what needs to be done.\n\nHis physical characteristics: Bald on top of his head and white hair on the sides. Blue eyes. Sparse gray beard.");
        npc.addDescriptionTranslation(PORTUGUESE, "Trabalhador e sério.\nPessoa de poucas palavras.\nSe expõe pouco e faz apenas aquilo que precisa ser feito.\n\nSeus traços físicos: Careca no topo da cabeça e cabelos brancos nas laterais. Olhos azuis. Barba rala grisalha.");
        npc.addDescriptionTranslation(SPANISH, "Trabajador y serio.\nUn hombre de pocas palabras.\nRara vez habla y solo hace lo que hay que hacer.\n\nSus características físicas: Calvo en la parte superior de la cabeza y con canas a los lados. Ojos azules. Barba gris rala.");
        npc.canBePickpocketed = true;

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What does a landlord do all day?", "More than people think. Roofs leak, tenants complain, merchants bargain, and everyone remembers me when taxes are due.");
        cv1.addOptionText(PORTUGUESE, "O que um senhorio faz o dia todo?", "Mais do que as pessoas pensam. Telhados vazam, inquilinos reclamam, mercadores negociam, e todo mundo se lembra de mim quando os impostos vencem.");
        cv1.addOptionText(SPANISH, "¿Qué hace un propietario todo el día?", "Más de lo que la gente cree. Los techos gotean, los inquilinos se quejan, los mercaderes negocian y todos se acuerdan de mí cuando vencen los impuestos.");
        npc.conversationOptions.add(cv1);

        // ========================================
        // QUEST: CATTLE BUSINESS
        // ========================================

        // Success Path (Part 34 -> 40)
        ConversationOption cvCattleSuccess = new ConversationOption(0, 10);
        cvCattleSuccess.addOptionText(ENGLISH, "I represent Councilor Murdag of Lisport. I have a contract for cattle trade.", "Murdag? I've heard he pays his debts. The terms are fair. I've been looking for a buyer in the islands.");
        cvCattleSuccess.addOptionText(PORTUGUESE, "Eu represento o Conselheiro Murdag de Lisport. Tenho um contrato para o comércio de gado.", "Murdag? Ouvi dizer que ele paga suas dívidas. Os termos são justos. Tenho procurado um comprador nas ilhas.");
        cvCattleSuccess.addOptionText(SPANISH, "Represento al consejero Murdag de Lisport. Tengo un contrato para el comercio de ganado.", "¿Murdag? He oído que paga sus deudas. Los términos son justos. He estado buscando un comprador en las islas.");
        cvCattleSuccess.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CATTLE_BUSINESS, 34)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvCattleSuccess);

        ConversationOption cvCattleSign = new ConversationOption(10, 0);
        cvCattleSign.addOptionText(ENGLISH, "Excellent. Please sign here.", "Consider it done. Tell Murdag the first shipment will depart soon.");
        cvCattleSign.addOptionText(PORTUGUESE, "Excelente. Por favor, assine aqui.", "Considere feito. Diga a Murdag que a primeira remessa partirá em breve.");
        cvCattleSign.addOptionText(SPANISH, "Excelente. Por favor, firme aquí.", "Considérelo hecho. Dígale a Murdag que el primer cargamento saldrá pronto.");
        cvCattleSign.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.CONTRACT_OF_CATTLE_NEGOTIATION, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.CATTLE_BUSINESS, 40, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvCattleSign);

        // Failure Path (Part 24 -> 30)
        ConversationOption cvCattleFail = new ConversationOption(0, 0);
        cvCattleFail.addOptionText(ENGLISH, "I represent Councilor Murdag of Lisport. I have a contract for cattle trade.", "Lisport is too far and the seas are too dangerous. These terms don't cover the risk. No deal.");
        cvCattleFail.addOptionText(PORTUGUESE, "Eu represento o Conselheiro Murdag de Lisport. Tenho um contrato para o comércio de gado.", "Lisport é muito longe e os mares são muito perigosos. Estes termos não cobrem o risco. Sem negócio.");
        cvCattleFail.addOptionText(SPANISH, "Represento al consejero Murdag de Lisport. Tengo un contrato para el comercio de ganado.", "Lisport está demasiado lejos y los mares son demasiado peligrosos. Estos términos no cubren el riesgo. No hay trato.");
        cvCattleFail.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CATTLE_BUSINESS, 24)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvCattleFail.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.CATTLE_BUSINESS, 30, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvCattleFail);

        return npc;
    }
}
