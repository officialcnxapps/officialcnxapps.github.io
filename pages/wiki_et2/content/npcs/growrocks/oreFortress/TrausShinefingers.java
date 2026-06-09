package com.cnx.endlesstalestwo.data.npcs.growrocks.oreFortress;

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
        npc.allowTraitsAnalysis = false;

        //this NPC is brother of NPCs KamalaShinefingers and ElliotShinefingers

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("...who's there?"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("...quem está aí?"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("...¿quién está ahí?"));

        // NPC only appears on oreFortressFloor2 during quest part 1
        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.LOST_BROTHER, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // ===== QUEST: Lost Brother - Found Traus =====
        ConversationOption cvFound = new ConversationOption(0, 1);
        cvFound.addOptionText(ENGLISH, "Traus? Are you Traus Shinefingers?", "*A weak voice from the shadows*\nYes... I'm Traus. Who... who are you? Did Elliot send you? \n*emerges from hiding, clearly injured*\nThank the stone gods... I thought I'd die down here. Those creatures... I barely escaped. Been hiding in this alcove for days.");
        cvFound.addOptionText(PORTUGUESE, "Traus? Você é Traus Shinefingers?", "*Uma voz fraca das sombras*\nSim... sou Traus. Quem... quem é você? Elliot te enviou? \n*emerge do esconderijo, claramente ferido*\nGraças aos deuses da pedra... pensei que morreria aqui. Essas criaturas... mal consegui escapar. Estive me escondendo neste nicho por dias.");
        cvFound.addOptionText(SPANISH, "¿Traus? ¿Eres Traus Shinefingers?", "*Una voz débil desde las sombras*\nSí... soy Traus. ¿Quién... quién eres? ¿Elliot te envió? \n*emerge del escondite, claramente herido*\nGracias a los dioses de la piedra... pensé que moriría aquí. Esas criaturas... apenas escapé. He estado escondido en este nicho durante días.");
        npc.conversationOptions.add(cvFound);

        ConversationOption cvRescue = new ConversationOption(1, 0);
        cvRescue.addOptionText(ENGLISH, "I'm here to rescue you. Can you walk?", "*Nods weakly*\nI... I think so. My leg is injured, but with your help... yes. \n*gathers his mining tools*\nI was a fool to come down here alone. I got greedy chasing those blue crystals. Nearly cost me my life. \n*limps toward you*\nLet's get out of here before those creatures return. Tell Elliot... tell him I'm sorry for worrying him.");
        cvRescue.addOptionText(PORTUGUESE, "Estou aqui para te resgatar. Você consegue andar?", "*Acena fracamente*\nEu... acho que sim. Minha perna está ferida, mas com sua ajuda... sim. \n*reúne suas ferramentas de mineração*\nFui um tolo em vir aqui sozinho. Fiquei ganancioso perseguindo aqueles cristais azuis. Quase me custou a vida. \n*manca em sua direção*\nVamos sair daqui antes que essas criaturas voltem. Diga a Elliot... diga que sinto muito por preocupá-lo.");
        cvRescue.addOptionText(SPANISH, "Estoy aquí para rescatarte. ¿Puedes caminar?", "*Asiente débilmente*\nYo... creo que sí. Mi pierna está herida, pero con tu ayuda... sí. \n*recoge sus herramientas de minería*\nFui un tonto al venir aquí solo. Me volví codicioso persiguiendo esos cristales azules. Casi me cuesta la vida. \n*cojea hacia ti*\nSalgamos de aquí antes de que esas criaturas regresen. Dile a Elliot... dile que lamento haberlo preocupado.");
        cvRescue.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.LOST_BROTHER, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvRescue);

        return npc;
    }
}

