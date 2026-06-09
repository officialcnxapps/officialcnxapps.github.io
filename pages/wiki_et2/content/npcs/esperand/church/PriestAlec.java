package com.cnx.endlesstalestwo.data.npcs.esperand.church;

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

public class PriestAlec extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Priest Alec");
        npc.addNameTranslation(PORTUGUESE, "Padre Alec");
        npc.addNameTranslation(SPANISH, "Sacerdote Alec");
        npc.age = 57;
        npc.job = Enums.NPCJobs.PRIEST;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A typical priest, calm and devoted to his faith.\nHe seems kind and helpful. He listens more than he speaks.\nHe has a twin brother.\n\nHis physical traits: Almost bald, with a thin gray beard. Light eyes and bright fair skin.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um típico padre, calmo e adepto a sua fé.\nParece bondoso e prestativo. Ouve mais do que fala.\nTem um irmão gêmeo.\n\nSeus traços físicos: Quase careca, barba rala e grisalha. Olhos claros e pele clara brilhosa.");
        npc.addDescriptionTranslation(SPANISH, "Un sacerdote típico, calmado y devoto de su fe.\nParece bondadoso y servicial. Escucha más de lo que habla.\nTiene un hermano gemelo.\n\nSus rasgos físicos: Casi calvo, barba fina y canosa. Ojos claros y piel clara brillante.");

        // ===== ROLEPLAY CONVERSATION =====
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "How is life at the church?", "Peaceful, mostly. We serve the faithful, tend to the sick, and guide lost souls. It's humble work, but deeply rewarding.");
        cv1.addOptionText(PORTUGUESE, "Como é a vida na igreja?", "Pacífica, na maior parte. Servimos os fiéis, cuidamos dos doentes e guiamos almas perdidas. É um trabalho humilde, mas profundamente recompensador.");
        cv1.addOptionText(SPANISH, "¿Cómo es la vida en la iglesia?", "Pacífica, en su mayoría. Servimos a los fieles, cuidamos a los enfermos y guiamos almas perdidas. Es un trabajo humilde, pero profundamente gratificante.");
        npc.conversationOptions.add(cv1);

        // ===== QUEST: Free Spirit - Part 1 =====
        ConversationOption cvFreeSpirit1 = new ConversationOption(0, 1);
        cvFreeSpirit1.addOptionText(ENGLISH, "Father, I need help freeing a trapped spirit.", "*The priest's expression becomes grave*\n\nA trapped spirit? That is a serious matter indeed. Such souls are bound by strong forces - unfinished business, powerful emotions, or tragic ends.\n\n*He strokes his beard thoughtfully*\n\nI am but a simple priest of this small church. Such knowledge... ancient texts and forbidden lore about spirit liberation... these would be found in great libraries, not here.\n\n*He pauses*\n\nYou should travel to Monelix Library. They have vast collections of ancient texts, including rare books on spiritual matters. Seek out the librarians there - they guard knowledge that could help you.\n\nBut be warned: some knowledge is restricted. You may need to convince them of your noble intent.");
        cvFreeSpirit1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FREE_SPIRIT, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvFreeSpirit1);

        ConversationOption cvFreeSpirit1Complete = new ConversationOption(1, 0);
        cvFreeSpirit1Complete.addOptionText(ENGLISH, "Thank you for your guidance, Father.", "May the divine light guide your path, child. Helping a trapped soul find peace is holy work. Go to Monelix Library and seek the knowledge you need.");
        cvFreeSpirit1Complete.addOptionText(PORTUGUESE, "Obrigado pela sua orientação, Padre.", "Que a luz divina guie seu caminho, filho. Ajudar uma alma presa a encontrar paz é trabalho sagrado. Vá à Biblioteca de Monelix e busque o conhecimento que precisa.");
        cvFreeSpirit1Complete.addOptionText(SPANISH, "Gracias por su guía, Padre.", "Que la luz divina guíe tu camino, hijo. Ayudar a un alma atrapada a encontrar paz es trabajo sagrado. Ve a la Biblioteca de Monelix y busca el conocimiento que necesitas.");
        cvFreeSpirit1Complete.listeners = (ctx, fragment) -> {
            LibQuest.updateQuest(QuestsIds.FREE_SPIRIT, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFreeSpirit1Complete);

        return npc;
    }
}