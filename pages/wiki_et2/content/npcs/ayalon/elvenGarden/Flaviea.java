package com.cnx.endlesstalestwo.data.npcs.ayalon.elvenGarden;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.ELFS_ALERT;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.THE_FINAL_BATTLE;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Flaviea extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Flaviea");
        npc.age = 82;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.FEMALE;

        npc.addDescriptionTranslation(ENGLISH, "This elf, despite being young, shows courage and experience.\nShe works in all parts of Ayalon. She loves her culture and protects her people without a second thought.\nShe knows every citizen living in the city well, especially her husband, Aslatan.\n\nHer physical traits: Green skin, short, straight dark hair parted in the middle. Thin and prominent nose and cheeks.");
        npc.addDescriptionTranslation(PORTUGUESE, "Esta elfa, apesar de jovem demonstra coragem e experiência.\nTrabalha em todos os lados de Ayalon. Ama sua cultura e protege seu povo sem pensar.\nConhece bem cada cidadão que vive na cidade, principalmente seu marido, Aslatan.\n\nSeus taços físicos: Pele verde, cabelos escuros, curtos e lisos divididos ao meio. nariz e bochechas finos e salientes.");
        npc.addDescriptionTranslation(SPANISH, "Esta elfa, a pesar de ser joven, demuestra valentía y experiencia.\nTrabaja en todos los rincones de Ayalon. Ama su cultura y protege a su pueblo sin pensarlo.\nConoce bien a cada ciudadano que vive en la ciudad, especialmente a su marido, Aslatan.\n\nSus rasgos físicos: Piel verde, cabello oscuro, corto y liso dividido al medio. Nariz y mejillas finas y prominentes.");

        // Flaviea should only be present before the ElfsAlert quest begins,
        // OR after The Final Battle is complete.
        npc.requirementValidations = (chara, ctx) -> {
            boolean elfsAlertActive = LibQuest.charHasQuest(ELFS_ALERT, chara)
                    && !LibQuest.isQuestComplete(chara, ELFS_ALERT);
            boolean finalBattleComplete = LibQuest.isQuestComplete(chara, THE_FINAL_BATTLE);

            if (elfsAlertActive && !finalBattleComplete) {
                return Enums.RequirementVerification.NOT_OK;
            }

            // Not available while The Final Battle is active and not yet complete
            if (LibQuest.charHasQuest(THE_FINAL_BATTLE, chara) && !finalBattleComplete) {
                return Enums.RequirementVerification.NOT_OK;
            }

            return Enums.RequirementVerification.OK;
        };

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Why guard a garden?", "Because this is no ordinary garden. Many plants here are rare, sacred, or used in delicate rituals. A careless hand can do more harm here than a sword.");
        cv1.addOptionText(PORTUGUESE, "Por que guardar um jardim?", "Porque este não é um jardim comum. Muitas plantas daqui são raras, sagradas ou usadas em rituais delicados. Uma mão descuidada pode causar mais dano aqui do que uma espada.");
        cv1.addOptionText(SPANISH, "¿Por qué vigilar un jardín?", "Porque este no es un jardín común. Muchas plantas de aquí son raras, sagradas o usadas en rituales delicados. Una mano descuidada puede causar más daño aquí que una espada.");
        npc.conversationOptions.add(cv1);

        // ===== ROLEPLAY: The sacred tree =====
        ConversationOption cvSacredTree = new ConversationOption(0, 0);
        cvSacredTree.addOptionText(ENGLISH, "What is that ancient tree at the center of the garden?", "That tree is sacred to the elves. They say it is older than the kingdom itself and that its roots reach into every living thing in these lands. No one may touch it or take from it without the blessing of the Elder Council. To harm it would be to harm Ayalon itself.");
        cvSacredTree.addOptionText(PORTUGUESE, "O que é aquela árvore ancestral no centro do jardim?", "Aquela árvore é sagrada para os elfos. Dizem que ela é mais antiga do que o próprio reino e que suas raízes alcançam cada ser vivo nestas terras. Ninguém pode tocá-la ou retirar algo dela sem a bênção do Conselho dos Anciões. Prejudicá-la seria prejudicar a própria Ayalon.");
        cvSacredTree.addOptionText(SPANISH, "¿Qué es ese árbol ancestral en el centro del jardín?", "Ese árbol es sagrado para los elfos. Dicen que es más antiguo que el propio reino y que sus raíces alcanzan a cada ser vivo en estas tierras. Nadie puede tocarlo ni tomar nada de él sin la bendición del Consejo de Ancianos. Dañarlo sería dañar a Ayalon misma.");
        npc.conversationOptions.add(cvSacredTree);

        return npc;
    }
}
