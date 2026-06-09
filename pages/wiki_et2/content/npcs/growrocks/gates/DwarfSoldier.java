package com.cnx.endlesstalestwo.data.npcs.growrocks.gates;

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

public class DwarfSoldier extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Dwarf Soldier");
        npc.addNameTranslation(PORTUGUESE, "Soldado Anão");
        npc.addNameTranslation(SPANISH, "Soldado Enano");
        npc.age = 26;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Serious, cautious, and attentive.\nPerceptive, able to read personalities and assess dangers.\n\nHis physical traits: Distant and serious gaze, with a beard and brown hair, as well as brown eyes. Long face.");
        npc.addDescriptionTranslation(PORTUGUESE, "Sério, cauteloso e atento.\nPerspicaz, sabe ler personalidades e avaliar perigos.\n\nSeus traços físicos: Olhar distante e sério, com barba e cabelos castanhos assim como a cor dos olhos. Rosto comprido.");
        npc.addDescriptionTranslation(SPANISH, "Serio, cauto y atento.\nPerspicaz, capaz de comprender las personalidades y evaluar los peligros.\n\nSus rasgos físicos: Mirada distante y seria, barba, cabello castaño y ojos marrones. Rostro alargado.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Halt! State your business at the gates of Growrocks."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Alto! Declare seu propósito nos portões de Growrocks."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("¡Alto! Declara tu propósito en las puertas de Growrocks."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Stone and steel."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Pedra e aço."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Piedra y acero."));

        // ===== ROLEPLAY: About guarding =====
        ConversationOption cvRoleplay = new ConversationOption(0, 0);
        cvRoleplay.addOptionText(ENGLISH, "How long have you guarded these gates?", "Five years now. It's an honor to protect our city, though it can be lonely. Few surface dwellers ever make it this far, and most who do turn back when they see our gates. We dwarves value our privacy - these gates keep our people safe and our secrets secure. But we're not unfriendly, just... cautious.");
        cvRoleplay.addOptionText(PORTUGUESE, "Há quanto tempo você guarda estes portões?", "Cinco anos agora. É uma honra proteger nossa cidade, embora possa ser solitário. Poucos habitantes da superfície chegam tão longe, e a maioria que chega volta quando vê nossos portões. Nós anões valorizamos nossa privacidade - estes portões mantêm nosso povo seguro e nossos segredos protegidos. Mas não somos hostis, apenas... cautelosos.");
        cvRoleplay.addOptionText(SPANISH, "¿Cuánto tiempo has custodiado estas puertas?", "Cinco años ahora. Es un honor proteger nuestra ciudad, aunque puede ser solitario. Pocos habitantes de la superficie llegan tan lejos, y la mayoría que lo hace retrocede cuando ve nuestras puertas. Los enanos valoramos nuestra privacidad - estas puertas mantienen a nuestro pueblo seguro y nuestros secretos protegidos. Pero no somos hostiles, solo... cautelosos.");
        cvRoleplay.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay);

        // ===== QUEST: Request entry =====
        ConversationOption cvQuestEntry = new ConversationOption(0, 1);
        cvQuestEntry.addOptionText(ENGLISH, "I seek to learn about dwarven culture.", "*Studies you carefully, hand on axe*\nA surface dweller seeking knowledge, not treasure? \n*Narrows eyes suspiciously*\nThat's... unusual. Most humans who come here want our gold or our steel. Some want to steal our mining secrets. \n\nBut you... your eyes show curiosity, not greed. You've traveled far and faced dangers to reach these gates. That takes courage.");
        cvQuestEntry.addOptionText(PORTUGUESE, "Busco aprender sobre a cultura anã.", "*Estuda você cuidadosamente, mão no machado*\nUm habitante da superfície buscando conhecimento, não tesouro? \n*Estreita os olhos desconfiado*\nIsso é... incomum. A maioria dos humanos que vem aqui quer nosso ouro ou nosso aço. Alguns querem roubar nossos segredos de mineração. \n\nMas você... seus olhos mostram curiosidade, não ganância. Você viajou longe e enfrentou perigos para chegar a estes portões. Isso exige coragem.");
        cvQuestEntry.addOptionText(SPANISH, "Busco aprender sobre la cultura enana.", "*Te estudia cuidadosamente, mano en el hacha*\n¿Un habitante de la superficie buscando conocimiento, no tesoro? \n*Entrecierra los ojos con sospecha*\nEso es... inusual. La mayoría de los humanos que vienen aquí quieren nuestro oro o nuestro acero. Algunos quieren robar nuestros secretos de minería. \n\nPero tú... tus ojos muestran curiosidad, no codicia. Has viajado lejos y enfrentado peligros para llegar a estas puertas. Eso requiere coraje.");
        cvQuestEntry.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestEntry);

        ConversationOption cvQuestPermit = new ConversationOption(1, 0);
        cvQuestPermit.addOptionText(ENGLISH, "I mean no harm to your people.", "*Relaxes slightly, lowers axe*\nAye, I can see that. Very well. I'll grant you entry - but know this: Growrocks is our home, our sanctuary. Treat it with respect. Treat our people with respect. We are master craftsmen, proud miners, keepers of ancient traditions. \n\nExplore our city, speak with our citizens, learn what you came to learn. But remember - we allowed you in. Don't make us regret that choice. \n\n*Steps aside and pushes the heavy gates open*\nWelcome to Growrocks, surface dweller. May you find the knowledge you seek.");
        cvQuestPermit.addOptionText(PORTUGUESE, "Não pretendo causar mal ao seu povo.", "*Relaxa levemente, abaixa o machado*\nSim, posso ver isso. Muito bem. Vou conceder sua entrada - mas saiba isto: Growrocks é nosso lar, nosso santuário. Trate-o com respeito. Trate nosso povo com respeito. Somos mestres artesãos, mineradores orgulhosos, guardiões de tradições ancestrais. \n\nExplore nossa cidade, fale com nossos cidadãos, aprenda o que veio aprender. Mas lembre-se - nós permitimos sua entrada. Não nos faça lamentar essa escolha. \n\n*Afasta-se e empurra os pesados portões*\nBem-vindo a Growrocks, habitante da superfície. Que encontre o conhecimento que busca.");
        cvQuestPermit.addOptionText(SPANISH, "No pretendo causar daño a tu pueblo.", "*Se relaja ligeramente, baja el hacha*\nSí, puedo ver eso. Muy bien. Te concederé entrada - pero sabe esto: Growrocks es nuestro hogar, nuestro santuario. Trátalo con respeto. Trata a nuestro pueblo con respeto. Somos maestros artesanos, mineros orgullosos, guardianes de tradiciones ancestrales. \n\nExplora nuestra ciudad, habla con nuestros ciudadanos, aprende lo que viniste a aprender. Pero recuerda - te permitimos entrar. No nos hagas lamentar esa elección. \n\n*Se hace a un lado y empuja las pesadas puertas*\nBienvenido a Growrocks, habitante de la superficie. Que encuentres el conocimiento que buscas.");
        cvQuestPermit.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.PEOPLE_OF_THE_DEPTHS, 6, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuestPermit);

        return npc;
    }
}