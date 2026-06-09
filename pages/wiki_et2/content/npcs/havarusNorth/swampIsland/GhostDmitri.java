package com.cnx.endlesstalestwo.data.npcs.havarusNorth.swampIsland;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.libs.Utils.isInsideAvailableHours;
import static com.cnx.endlesstalestwo.libs.Utils.isInsideNightHoursForQuests;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class GhostDmitri extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Ghost Dmitri");
        npc.addNameTranslation(PORTUGUESE, "Fantasma Dmitri");
        npc.addNameTranslation(SPANISH, "Fantasma Dmitri");
        npc.age = 0; // Ghost - ageless
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("*A translucent figure appears in the mist*"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("*Uma figura translúcida aparece na névoa*"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("*Una figura translúcida aparece en la niebla*"));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("*The spirit fades into the mist*"));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("*O espírito desaparece na névoa*"));
        npc.byeMessages.put(SPANISH, Collections.singletonList("*El espíritu se desvanece en la niebla*"));

        // Only appears at night (21:00 - 05:00) and only if player has the quest
        npc.requirementValidations = (chara, ctx) -> {
            // Must have the quest and not be completed
            if (!LibQuest.charHasQuest(QuestsIds.GHOST_BONES, chara) ||
                LibQuest.isQuestComplete(chara, QuestsIds.GHOST_BONES)) {
                return Enums.RequirementVerification.NOT_OK;
            }

            // After part 6 (bones burned), ghost no longer exists
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GHOST_BONES, 6) ||
                LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GHOST_BONES, 8)) {
                return Enums.RequirementVerification.NOT_OK;
            }

            // Check time - only appears between 21:00 and 05:00
            if (isInsideNightHoursForQuests(5, 21)) {
                return Enums.RequirementVerification.OK;
            }

            return Enums.RequirementVerification.NOT_OK;
        };

        // ===== QUEST PART 1: First encounter =====
        ConversationOption cvPart1 = new ConversationOption(0, 1);
        cvPart1.addOptionText(ENGLISH, "Who... who are you?", "*The ghost's voice echoes softly, filled with sorrow*\n\nI am... Dmitri. Or what remains of him. Eight years I have wandered these cursed swamps, unable to rest, unable to move on.\n\n*His translucent form flickers like a candle in the wind*\n\nI see you come from Letow. Does... does Mirjana still live there? The woman I loved? I must know...");
        cvPart1.addOptionText(PORTUGUESE, "Quem... quem é você?", "*A voz do fantasma ecoa suavemente, cheia de tristeza*\n\nEu sou... Dmitri. Ou o que resta dele. Oito anos vaguei por esses pântanos amaldiçoados, incapaz de descansar, incapaz de seguir em frente.\n\n*Sua forma translúcida pisca como uma vela ao vento*\n\nVejo que você vem de Letow. Mirjana... ainda vive lá? A mulher que amei? Preciso saber...");
        cvPart1.addOptionText(SPANISH, "¿Quién... quién eres?", "*La voz del fantasma resuena suavemente, llena de tristeza*\n\nSoy... Dmitri. O lo que queda de él. Ocho años he vagado por estos pantanos malditos, incapaz de descansar, incapaz de seguir adelante.\n\n*Su forma translúcida parpadea como una vela al viento*\n\nVeo que vienes de Letow. ¿Mirjana... todavía vive allí? ¿La mujer que amé? Debo saberlo...");
        cvPart1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GHOST_BONES, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPart1);

        ConversationOption cvPart1Response = new ConversationOption(1, 0);
        cvPart1Response.addOptionText(ENGLISH, "Yes, she lives. She sent me to find you.", "*His eyes, hollow yet somehow filled with desperate hope*\n\nShe... she still remembers me? After all these years?\n\n*His voice breaks with emotion*\n\nI was murdered here, traveler. I came to these swamps to gather herbs and hunt for food. Bandits found me alone and... they killed me. Threw my body into the sea. The waves carried me to the shore near Letow, where they found me and buried me in the Cemetery. But my spirit... it stayed here, where I died. I never got to say goodbye... never got to tell her how much she meant to me. Please, tell her I'm sorry. Tell her I never stopped loving her.");
        cvPart1Response.addOptionText(PORTUGUESE, "Sim, ela vive. Ela me enviou para encontrá-lo.", "*Seus olhos, vazios mas de alguma forma cheios de esperança desesperada*\n\nEla... ela ainda se lembra de mim? Depois de todos esses anos?\n\n*Sua voz se quebra de emoção*\n\nFui assassinado aqui, viajante. Vim a esses pântanos para coletar ervas e caçar comida. Bandidos me encontraram sozinho e... me mataram. Jogaram meu corpo no mar. As ondas me levaram até a praia perto de Letow, onde me encontraram e me enterraram no Cemitério. Mas meu espírito... ficou aqui, onde morri. Nunca consegui me despedir... nunca consegui dizer o quanto ela significava para mim. Por favor, diga a ela que sinto muito. Diga que nunca parei de amá-la.");
        cvPart1Response.addOptionText(SPANISH, "Sí, ella vive. Me envió a encontrarte.", "*Sus ojos, vacíos pero de alguna manera llenos de esperanza desesperada*\n\n¿Ella... todavía me recuerda? ¿Después de todos estos años?\n\n*Su voz se quiebra con emoción*\n\nFui asesinado aquí, viajero. Vine a estos pantanos a recolectar hierbas y cazar comida. Los bandidos me encontraron solo y... me mataron. Arrojaron mi cuerpo al mar. Las olas me llevaron a la orilla cerca de Letow, donde me encontraron y me enterraron en el Cementerio. Pero mi espíritu... se quedó aquí, donde morí. Nunca pude despedirme... nunca pude decirle cuánto significaba para mí. Por favor, dile que lo siento. Dile que nunca dejé de amarla.");
        cvPart1Response.listeners = (ctx, fragment) -> LibQuest.updateQuest(QuestsIds.GHOST_BONES, 2, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvPart1Response);

        // ===== QUEST PART 3: Player comes to tell about burning bones =====
        ConversationOption cvPart3 = new ConversationOption(0, 2);
        cvPart3.addOptionText(ENGLISH, "Mirjana wants me to burn your bones.", "*The ghost recoils in horror, his form flickering violently*\n\nNo! Please, traveler! I beg you! I mean her no harm - I only haunt her because I cannot rest without her forgiveness!\n\n*He reaches out desperately with translucent hands*\n\nEight years I have waited. Eight long years of torment, unable to move on, unable to tell her how sorry I am. I came to these swamps to gather herbs and hunt - simple tasks to provide for our future together. I was going to propose when I returned... but the bandits found me. They killed me and threw my body into the sea.\n\n*His voice trembles*\n\nIf you burn my bones, I will be gone forever, and she will never know how much I loved her. Please... convince her to speak with me one last time. Just once. Then I swear I will find peace and never trouble her again.");
        cvPart3.addOptionText(PORTUGUESE, "Mirjana quer que eu queime seus ossos.", "*O fantasma recua horrorizado, sua forma piscando violentamente*\n\nNão! Por favor, viajante! Eu imploro! Não quero fazer mal a ela - só a assombro porque não consigo descansar sem seu perdão!\n\n*Ele estende as mãos desesperadamente, translúcidas*\n\nOito anos esperei. Oito longos anos de tormento, incapaz de seguir em frente, incapaz de dizer o quanto sinto. Vim a esses pântanos para coletar ervas e caçar - tarefas simples para prover nosso futuro juntos. Eu ia pedi-la em casamento quando voltasse... mas os bandidos me encontraram. Eles me mataram e jogaram meu corpo no mar.\n\n*Sua voz treme*\n\nSe você queimar meus ossos, desaparecerei para sempre, e ela nunca saberá o quanto a amei. Por favor... convença-a a falar comigo uma última vez. Apenas uma vez. Então juro que encontrarei paz e nunca mais a incomodarei.");
        cvPart3.addOptionText(SPANISH, "Mirjana quiere que queme tus huesos.", "*El fantasma retrocede horrorizado, su forma parpadeando violentamente*\n\n¡No! ¡Por favor, viajero! ¡Te lo ruego! No quiero hacerle daño - solo la acecho porque no puedo descansar sin su perdón!\n\n*Extiende sus manos desesperadamente, translúcidas*\n\nOcho años he esperado. Ocho largos años de tormento, incapaz de seguir adelante, incapaz de decirle cuánto lo siento. Vine a estos pantanos a recolectar hierbas y cazar - tareas simples para proveer nuestro futuro juntos. Iba a proponerle matrimonio cuando regresara... pero los bandidos me encontraron. Me mataron y arrojaron mi cuerpo al mar.\n\n*Su voz tiembla*\n\nSi quemas mis huesos, desapareceré para siempre, y ella nunca sabrá cuánto la amé. Por favor... convéncela de hablar conmigo una última vez. Solo una vez. Entonces juro que encontraré paz y nunca la molestaré de nuevo.");
        cvPart3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GHOST_BONES, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPart3);

        ConversationOption cvPart3Response = new ConversationOption(2, 0);
        cvPart3Response.addOptionText(ENGLISH, "I will speak with her on your behalf.", "*Relief floods his spectral features*\n\nThank you... thank you, kind soul. Tell her that Dmitri still waits. Tell her I understand if she has moved on, if she has found happiness elsewhere. I only ask for one moment to apologize, to free us both from this curse of unfinished love.\n\nPlease... hurry. Each night I fade a little more.");
        cvPart3Response.addOptionText(PORTUGUESE, "Vou falar com ela em seu nome.", "*Alívio inunda suas feições espectrais*\n\nObrigado... obrigado, alma bondosa. Diga a ela que Dmitri ainda espera. Diga que entendo se ela seguiu em frente, se encontrou felicidade em outro lugar. Só peço um momento para me desculpar, para libertar a ambos desta maldição de amor inacabado.\n\nPor favor... apresse-se. Cada noite desapareço um pouco mais.");
        cvPart3Response.addOptionText(SPANISH, "Hablaré con ella en tu nombre.", "*El alivio inunda sus rasgos espectrales*\n\nGracias... gracias, alma bondadosa. Dile que Dmitri aún espera. Dile que entiendo si ha seguido adelante, si ha encontrado felicidad en otro lugar. Solo pido un momento para disculparme, para liberarnos a ambos de esta maldición de amor inacabado.\n\nPor favor... date prisa. Cada noche me desvanezco un poco más.");
        cvPart3Response.listeners = (ctx, fragment) -> LibQuest.updateQuest(QuestsIds.GHOST_BONES, 4, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvPart3Response);

        // ===== QUEST PART 7: After Mirjana agrees to meet =====
        ConversationOption cvPart7 = new ConversationOption(0, 3);
        cvPart7.addOptionText(ENGLISH, "Mirjana has agreed to speak with you.", "*The ghost's form brightens, becoming almost solid for a moment*\n\nShe... she will? After everything? After eight years of haunting her nightmares?\n\n*Tears that cannot fall shimmer in his ethereal eyes*\n\nYou have given me a gift beyond measure, traveler. Tomorrow night, when darkness falls, I will go to her. I will finally tell her everything - my love, my regret, my eternal apology.\n\n*He bows deeply, his form already beginning to stabilize*\n\nWhen I have spoken with her, when she has heard my heart... I will finally be free. Thank you. Thank you for believing that even ghosts deserve forgiveness.");
        cvPart7.addOptionText(PORTUGUESE, "Mirjana concordou em falar com você.", "*A forma do fantasma brilha, tornando-se quase sólida por um momento*\n\nEla... ela vai? Depois de tudo? Depois de oito anos assombrando seus pesadelos?\n\n*Lágrimas que não podem cair brilham em seus olhos etéreos*\n\nVocê me deu um presente inestimável, viajante. Amanhã à noite, quando a escuridão cair, irei até ela. Finalmente direi tudo - meu amor, meu arrependimento, minhas eternas desculpas.\n\n*Ele se curva profundamente, sua forma já começando a se estabilizar*\n\nQuando eu tiver falado com ela, quando ela tiver ouvido meu coração... finalmente serei livre. Obrigado. Obrigado por acreditar que até fantasmas merecem perdão.");
        cvPart7.addOptionText(SPANISH, "Mirjana ha aceptado hablar contigo.", "*La forma del fantasma se ilumina, volviéndose casi sólida por un momento*\n\n¿Ella... lo hará? ¿Después de todo? ¿Después de ocho años atormentando sus pesadillas?\n\n*Lágrimas que no pueden caer brillan en sus ojos etéreos*\n\nMe has dado un regalo inestimable, viajero. Mañana por la noche, cuando caiga la oscuridad, iré a ella. Finalmente le diré todo - mi amor, mi arrepentimiento, mis eternas disculpas.\n\n*Se inclina profundamente, su forma ya comenzando a estabilizarse*\n\nCuando haya hablado con ella, cuando haya escuchado mi corazón... finalmente seré libre. Gracias. Gracias por creer que incluso los fantasmas merecen perdón.");
        cvPart7.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GHOST_BONES, 7)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPart7);

        ConversationOption cvPart7Response = new ConversationOption(3, 0);
        cvPart7Response.addOptionText(ENGLISH, "May you find peace, Dmitri.", "*The ghost smiles - the first genuine smile in eight years*\n\nPeace... yes. At last, I can see it on the horizon. When dawn breaks tomorrow, after I have spoken with my beloved Mirjana, I will finally cross over.\n\n*His form begins to fade, but peacefully this time*\n\nFarewell, kind traveler. You have done what no priest or mage could - you gave hope to the hopeless. May your journey be blessed.");
        cvPart7Response.addOptionText(PORTUGUESE, "Que você encontre paz, Dmitri.", "*O fantasma sorri - o primeiro sorriso genuíno em oito anos*\n\nPaz... sim. Finalmente, posso vê-la no horizonte. Quando o amanhecer chegar amanhã, depois de ter falado com minha amada Mirjana, finalmente cruzarei para o outro lado.\n\n*Sua forma começa a desaparecer, mas pacificamente desta vez*\n\nAdeus, gentil viajante. Você fez o que nenhum sacerdote ou mago pôde - deu esperança aos desesperançados. Que sua jornada seja abençoada.");
        cvPart7Response.addOptionText(SPANISH, "Que encuentres paz, Dmitri.", "*El fantasma sonríe - la primera sonrisa genuina en ocho años*\n\nPaz... sí. Por fin, puedo verla en el horizonte. Cuando amanezca mañana, después de haber hablado con mi amada Mirjana, finalmente cruzaré al otro lado.\n\n*Su forma comienza a desvanecerse, pero pacíficamente esta vez*\n\nAdiós, amable viajero. Has hecho lo que ningún sacerdote o mago pudo - diste esperanza a los desesperanzados. Que tu viaje sea bendecido.");
        cvPart7Response.listeners = (ctx, fragment) -> {
            LibQuest.updateQuest(QuestsIds.GHOST_BONES, 8, App.getPlayerChar(), ctx);
            LibQuest.completeQuest(QuestsIds.GHOST_BONES, App.getPlayerChar(), 8, ctx);
        };
        npc.conversationOptions.add(cvPart7Response);

        return npc;
    }
}







