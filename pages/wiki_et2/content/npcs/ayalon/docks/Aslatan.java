package com.cnx.endlesstalestwo.data.npcs.ayalon.docks;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Aslatan extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Aslatan");
        npc.age = 129;
        npc.job = Enums.NPCJobs.LONGSHOREMAN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "This middle-aged elf conveys calm and precision in his movements, and for good reason: he is a lead sailor.\nHe reflects a lot on life and work.\nHe is married to Flaviae, and they seem to have a strong lasting relationship.\n\nHis physical traits: He looks older than he is, with graying hair and beard, deep eyes, and leather clothes with a leather beret.");
        npc.addDescriptionTranslation(PORTUGUESE, "Este elfo de meia idade transparece calma e precisão em seus movimentos, não pra menos que é um líder marinheiro.\nPensa muito na vida e no trabalho.\nÉ casado com Flaviae, parecem ter uma boa relação duradoura.\n\nSeus taços físicos: Parece mais velho do que é, cabelos e barbas grisalhas, Olhos profundos. Roupas e boina de couro.");
        npc.addDescriptionTranslation(SPANISH, "Este elfo de mediana edad transmite calma y precisión en sus movimientos; no es de extrañar, ya que es un líder marinero.\nPiensa mucho en la vida y en el trabajo.\nEstá casado con Flaviea, y parecen tener una buena relación duradera.\n\nSus rasgos físicos: Parece mayor de lo que es, con cabello y barba canosos, y ojos profundos. Ropa y boina de cuero.");

        //Description:
        /*
         * Este elfo de meia idade transparece calma e precisão em seus movimentos,
         * não pra menos que é um líder marinheiro. Pensa muito na vida e no trabalho.
         * É casado com Flaviae, parecem ter uma boa relação duradoura.
         * Seus traços físicos: Parece mais velho do que é, cabelos e barbas grisalhas, Olhos profundos. Roupas e boina de couro.
         * */

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // ===== ROLEPLAY: About his life at the docks =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "How long have you worked at the docks?", "*Gazes at the horizon*\nFifty-six years, traveler. I've seen countless ships come and go, carrying dreams and fortunes across the seas. My hands have loaded and unloaded more cargo than I can remember. These docks... they've been my entire life.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Há quanto tempo você trabalha nas docas?", "*Olha para o horizonte*\nCinquenta e seis anos, viajante. Vi incontáveis navios irem e virem, carregando sonhos e fortunas através dos mares. Minhas mãos carregaram e descarregaram mais carga do que posso lembrar. Essas docas... elas foram minha vida inteira.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cuánto tiempo has trabajado en los muelles?", "*Mira el horizonte*\nCincuenta y seis años, viajero. He visto innumerables barcos ir y venir, llevando sueños y fortunas a través de los mares. Mis manos han cargado y descargado más mercancía de la que puedo recordar. Estos muelles... han sido toda mi vida.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== QUEST START: New Route (only after The Final Battle) =====
        ConversationOption cvQuestStart = new ConversationOption(0, 1);
        cvQuestStart.addOptionText(ENGLISH, "You seem troubled. What's on your mind?", "*Sighs deeply*\nAh, perceptive one. At my age, one begins to ponder... what was it all for? A lifetime of labor, sun to sun, and now winter approaches. I've built no monuments, written no books, left no legacy. Was my life... meaningful? \n\nI've heard tales of wise souls across different kingdoms - scholars in Monelix, warriors in Helera, holy men in Esperand, merchants in Lisport. Perhaps they hold answers I seek. Different kingdoms, different lives, different wisdom...");
        cvQuestStart.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.isQuestComplete(chara, QuestsIds.THE_FINAL_BATTLE)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            if (!LibQuest.charHasQuest(QuestsIds.SEEKING_WISDOM, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestStart);

        ConversationOption cvQuestAccept = new ConversationOption(1, 0);
        cvQuestAccept.listeners = (ctx, fragment) -> LibQuest.includeQuestToQuestbook(QuestsIds.SEEKING_WISDOM, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvQuestAccept);

        // ===== DURING QUEST: Waiting for answers =====
        ConversationOption cvWaiting = new ConversationOption(0, 0);
        cvWaiting.addOptionText(ENGLISH, "I'm still gathering wisdom for you.", "Take your time, friend. These questions have waited a lifetime - they can wait a little longer. Speak with those who have lived differently than I. Their perspectives... they matter.");
        cvWaiting.addOptionText(PORTUGUESE, "Ainda estou reunindo sabedoria para você.", "Sem pressa, amigo. Essas questões esperaram uma vida toda - podem esperar um pouco mais. Fale com aqueles que viveram diferente de mim. Suas perspectivas... elas importam.");
        cvWaiting.addOptionText(SPANISH, "Todavía estoy reuniendo sabiduría para ti.", "Tómate tu tiempo, amigo. Estas preguntas han esperado toda una vida - pueden esperar un poco más. Habla con aquellos que han vivido diferente a mí. Sus perspectivas... importan.");
        cvWaiting.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(QuestsIds.SEEKING_WISDOM, chara) && !LibQuest.isQuestComplete(chara, QuestsIds.SEEKING_WISDOM)) {
                if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SEEKING_WISDOM, 1) ||
                        LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SEEKING_WISDOM, 2) ||
                        LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SEEKING_WISDOM, 3) ||
                        LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SEEKING_WISDOM, 4)) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvWaiting);

        // ===== TEMPORARY TRAVEL: Part 1 - To Monelix =====
        ConversationOption cvTravelPart1 = new ConversationOption(0, 999);
        cvTravelPart1.addOptionText(ENGLISH, "Can you take me to Monelix?", "Of course, for your journey. The ship leaves immediately. Safe travels, friend!");
        cvTravelPart1.addOptionText(PORTUGUESE, "Pode me levar até Monelix?", "Claro, para sua jornada. O navio parte imediatamente. Boa viagem, amigo!");
        cvTravelPart1.addOptionText(SPANISH, "¿Puedes llevarme a Monelix?", "¡Por supuesto, para tu viaje. El barco parte inmediatamente. Buen viaje, amigo!");
        cvTravelPart1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SEEKING_WISDOM, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvTravelPart1.listeners = (ctx, fragment) -> {
            App.Shell.flowManager.updateGameplayFlow(LocationsIds.MONELIX_DOCKS, ctx);
        };
        npc.conversationOptions.add(cvTravelPart1);

        // ===== TEMPORARY TRAVEL: Part 2 - To Helera Harbor =====
        ConversationOption cvTravelPart2 = new ConversationOption(0, 999);
        cvTravelPart2.addOptionText(ENGLISH, "Can you take me to Helera?", "Of course, for your journey. The ship leaves immediately. Safe travels, friend!");
        cvTravelPart2.addOptionText(PORTUGUESE, "Pode me levar até Helera?", "Claro, para sua jornada. O navio parte imediatamente. Boa viagem, amigo!");
        cvTravelPart2.addOptionText(SPANISH, "¿Puedes llevarme a Helera?", "¡Por supuesto, para tu viaje. El barco parte inmediatamente. Buen viaje, amigo!");
        cvTravelPart2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SEEKING_WISDOM, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvTravelPart2.listeners = (ctx, fragment) -> {
            App.Shell.flowManager.updateGameplayFlow(LocationsIds.HELERA_HARBOR, ctx);
        };
        npc.conversationOptions.add(cvTravelPart2);

        // ===== TEMPORARY TRAVEL: Part 3 - To Esperand Harbor =====
        ConversationOption cvTravelPart3 = new ConversationOption(0, 999);
        cvTravelPart3.addOptionText(ENGLISH, "Can you take me to Esperand?", "Of course, for your journey. The ship leaves immediately. Safe travels, friend!");
        cvTravelPart3.addOptionText(PORTUGUESE, "Pode me levar até Esperand?", "Claro, para sua jornada. O navio parte imediatamente. Boa viagem, amigo!");
        cvTravelPart3.addOptionText(SPANISH, "¿Puedes llevarme a Esperand?", "¡Por supuesto, para tu viaje. El barco parte inmediatamente. Buen viaje, amigo!");
        cvTravelPart3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SEEKING_WISDOM, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvTravelPart3.listeners = (ctx, fragment) -> {
            App.Shell.flowManager.updateGameplayFlow(LocationsIds.ESPERAND_HARBOR, ctx);
        };
        npc.conversationOptions.add(cvTravelPart3);

        // ===== TEMPORARY TRAVEL: Part 4 - To Lisport Harbor =====
        ConversationOption cvTravelPart4 = new ConversationOption(0, 999);
        cvTravelPart4.addOptionText(ENGLISH, "Can you take me to Lisport?", "Of course, for your journey. The ship leaves immediately. Safe travels, friend!");
        cvTravelPart4.addOptionText(PORTUGUESE, "Pode me levar até Lisport?", "Claro, para sua jornada. O navio parte imediatamente. Boa viagem, amigo!");
        cvTravelPart4.addOptionText(SPANISH, "¿Puedes llevarme a Lisport?", "¡Por supuesto, para tu viaje. El barco parte inmediatamente. Buen viaje, amigo!");
        cvTravelPart4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SEEKING_WISDOM, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvTravelPart4.listeners = (ctx, fragment) -> {
            App.Shell.flowManager.updateGameplayFlow(LocationsIds.LISPORT_HARBOR, ctx);
        };
        npc.conversationOptions.add(cvTravelPart4);

        // ===== QUEST PART 5: Return with wisdom =====
        ConversationOption cvReturn = new ConversationOption(0, 2);
        cvReturn.addOptionText(ENGLISH, "I've spoken with them all. Here's what I learned...", "*Listens intently as you share each perspective*\n\nHafanne spoke of knowledge and teaching...\nYandov of honor and protecting others...\nBrother Sariseus of faith and compassion...\nOlga of prosperity and providing...\n\n*A long silence follows*");
        cvReturn.addOptionText(PORTUGUESE, "Falei com todos eles. Aqui está o que aprendi...", "*Escuta atentamente enquanto você compartilha cada perspectiva*\n\nHafanne falou de conhecimento e ensino...\nYandov de honra e proteger os outros...\nIrmão Sariseus de fé e compaixão...\nOlga de prosperidade e prover...\n\n*Um longo silêncio segue*");
        cvReturn.addOptionText(SPANISH, "He hablado con todos ellos. Esto es lo que aprendí...", "*Escucha atentamente mientras compartes cada perspectiva*\n\nHafanne habló de conocimiento y enseñanza...\nYandov de honor y proteger a otros...\nHermano Sariseus de fe y compasión...\nOlga de prosperidad y proveer...\n\n*Sigue un largo silencio*");
        cvReturn.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SEEKING_WISDOM, 5)
                    && !LibQuest.isQuestComplete(chara, QuestsIds.SEEKING_WISDOM)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvReturn);

        ConversationOption cvConclusion = new ConversationOption(2, 0);
        cvConclusion.addOptionText(ENGLISH, "What do you think?", "*Smiles warmly, tears in eyes*\nI understand now. They all spoke of service - teaching, protecting, healing, providing. My life... these hands carried goods that fed families, materials that built homes, treasures that brought joy. I served, in my own way.\n\nThank you, friend. You've given a wise elf peace. And as thanks... whenever you need passage to Monelix, find me. I'll arrange it for just a few coins - consider it my new purpose, helping travelers like you.");
        cvConclusion.listeners = (ctx, fragment) -> LibQuest.completeQuest(QuestsIds.SEEKING_WISDOM, App.getPlayerChar(), 5, ctx);
        npc.conversationOptions.add(cvConclusion);

        // ===== TRAVEL OPTION: After quest completion (cheap travel to Monelix) =====
        ConversationOption cvTravel = new ConversationOption(0, 0);
        cvTravel.addOptionText(ENGLISH, "Let's travel to Monelix (5 gold)", "*Nods with a knowing smile*\nOf course, friend. I'll arrange your passage right away. Safe travels!");
        cvTravel.addOptionText(PORTUGUESE, "Vamos viajar para Monelix (5 ouros)", "*Acena com um sorriso conhecedor*\nClaro, amigo. Vou arranjar sua passagem agora mesmo. Boa viagem!");
        cvTravel.addOptionText(SPANISH, "Vamos viajar a Monelix (5 oros)", "*Asiente con una sonrisa conocedora*\n¡Por supuesto, amigo! Arreglaré tu pasaje de inmediato. ¡Buen viaje!");
        cvTravel.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.SEEKING_WISDOM) && chara.checkHasGold(5)) {
                return Enums.RequirementVerification.OK;
            } else if (LibQuest.isQuestComplete(chara, QuestsIds.SEEKING_WISDOM)) {
                return Enums.RequirementVerification.NEED_GOLD;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvTravel.listeners = (ctx, fragment) -> {
            App.getPlayerChar().removeGold(5);
            App.Shell.flowManager.updateGameplayFlow(LocationsIds.MONELIX_DOCKS, ctx);
        };
        npc.conversationOptions.add(cvTravel);

        return npc;
    }
}


