package com.cnx.endlesstalestwo.data.npcs.esperand;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.libs.Utils.isInsideAvailableHours;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class ASpirit extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("A Spirit");
        npc.age = 137;
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.FEMALE;
        npc.allowTraitsAnalysis = false;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("*A translucent figure appears before you, emanating a soft, melancholic glow*"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("*Uma figura translúcida aparece diante de você, emanando um brilho suave e melancólico*"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("*Una figura translúcida aparece ante ti, emanando un brillo suave y melancólico*"));

        // ===== QUEST: Free Spirit =====

        // Quest Start - Part 1
        ConversationOption cvQuestStart = new ConversationOption(0, 1);
        cvQuestStart.addOptionText(ENGLISH, "Who... or what are you?", "*The spirit's voice echoes softly, filled with sorrow*\n\nI am... was... someone who lived long ago. My name has faded with time, as has the memory of how I died. But my essence remains trapped here, unable to move forward.\n\n*The figure seems to grow dimmer*\n\nI wander endlessly, seeking release from this world. Something holds me here against my will, and I cannot find peace.\n\n*A desperate plea fills her voice*\n\nIf you possess kindness in your heart, please... help me find liberation from this earthly prison.");
        cvQuestStart.addOptionText(PORTUGUESE, "Quem... ou o que você é?", "*A voz do espírito ecoa suavemente, repleta de tristeza*\n\nEu sou... era... alguém que viveu há muito tempo. Meu nome desapareceu com o tempo, assim como a memória de como morri. Mas minha essência permanece presa aqui, incapaz de seguir adiante.\n\n*A figura parece ficar mais fraca*\n\nVago sem fim, buscando libertação deste mundo. Algo me mantém aqui contra minha vontade, e não consigo encontrar paz.\n\n*Um apelo desesperado preenche sua voz*\n\nSe você possui bondade em seu coração, por favor... ajude-me a encontrar libertação desta prisão terrena.");
        cvQuestStart.addOptionText(SPANISH, "¿Quién... o qué eres?", "*La voz del espíritu resuena suavemente, llena de tristeza*\n\nYo soy... era... alguien que vivió hace mucho tiempo. Mi nombre se desvaneció con el tiempo, al igual que el recuerdo de cómo morí. Pero mi esencia permanece atrapada aquí, incapaz de seguir adelante.\n\n*La figura parece volverse más tenue*\n\nVago sin cesar, buscando liberación de este mundo. Algo me retiene aquí contra mi voluntad, y no puedo encontrar paz.\n\n*Un ruego desesperado llena su voz*\n\nSi posees bondad en tu corazón, por favor... ayúdame a encontrar liberación de esta prisión terrenal.");
        cvQuestStart.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.FREE_SPIRIT, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestStart);

        // Accept Quest
        ConversationOption cvAccept = new ConversationOption(1, 0);
        cvAccept.addOptionText(ENGLISH, "I will help you find peace.", "*The spirit's form brightens slightly, hope flickering in her ethereal eyes*\n\nOh, thank you! Thank you, kind soul! I have waited so long for someone to offer help.\n\n*She floats closer*\n\nBut I must confess - I do not know how to achieve my liberation. The knowledge has been lost to me. You must seek those who understand the mysteries of life and death... wise scholars, priests, or spiritual guides.\n\nSeek them out, learn what must be done, and return to me when you have the answer.\n\n*Her voice grows faint, as if carried by the wind*\n\nRemember... I can only wander these lands for a few hours past midnight. Seek me in the dead of night, or you may not find me at all.");
        cvAccept.addOptionText(PORTUGUESE, "Eu vou ajudá-la a encontrar paz.", "*A forma do espírito brilha levemente, esperança cintilando em seus olhos etéreos*\n\nOh, obrigada! Obrigada, alma bondosa! Esperei tanto tempo por alguém que oferecesse ajuda.\n\n*Ela flutua mais perto*\n\nMas devo confessar - não sei como alcançar minha libertação. O conhecimento foi perdido para mim. Você deve procurar aqueles que entendem os mistérios da vida e da morte... sábios estudiosos, sacerdotes ou guias espirituais.\n\nProcure-os, aprenda o que deve ser feito e retorne para mim quando tiver a resposta.\n\n*Sua voz se torna fraca, como carregada pelo vento*\n\nLembre-se... só consigo vagar por estas terras por poucas horas da madrugada. Busque-me no silêncio da noite, ou pode ser que não me encontre.");
        cvAccept.addOptionText(SPANISH, "Te ayudaré a encontrar paz.", "*La forma del espíritu se ilumina ligeramente, esperanza destellando en sus ojos etéreos*\n\n¡Oh, gracias! ¡Gracias, alma bondadosa! He esperado tanto tiempo a que alguien ofreciera ayuda.\n\n*Flota más cerca*\n\nPero debo confesar - no sé cómo lograr mi liberación. El conocimiento se ha perdido para mí. Debes buscar a aquellos que comprenden los misterios de la vida y la muerte... sabios eruditos, sacerdotes o guías espirituales.\n\nBúscalos, aprende lo que debe hacerse y regresa a mí cuando tengas la respuesta.\n\n*Su voz se vuelve tenue, como llevada por el viento*\n\nRecuerda... solo puedo vagar por estas tierras durante pocas horas de la madrugada. Búscame en el silencio de la noche, o puede que no me encuentres.");
        cvAccept.listeners = (ctx, fragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.FREE_SPIRIT, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvAccept);

        // Decline Quest
        ConversationOption cvDecline = new ConversationOption(1, 0);
        cvDecline.addOptionText(ENGLISH, "I cannot help you with this.", "*The spirit's light dims considerably, sadness washing over her ethereal form*\n\nI... understand. Not everyone can bear the burden of helping the restless dead. I will continue my endless wandering.\n\n*She begins to fade*\n\nIf you change your mind, I will be here... as I always am.");
        cvDecline.addOptionText(PORTUGUESE, "Não posso ajudá-la com isso.", "*A luz do espírito diminui consideravelmente, tristeza inundando sua forma etérea*\n\nEu... entendo. Nem todos podem carregar o fardo de ajudar os mortos inquietos. Continuarei minha vagância sem fim.\n\n*Ela começa a desaparecer*\n\nSe mudar de ideia, estarei aqui... como sempre estou.");
        cvDecline.addOptionText(SPANISH, "No puedo ayudarte con esto.", "*La luz del espíritu se atenúa considerablemente, tristeza inundando su forma etérea*\n\nYo... entiendo. No todos pueden soportar la carga de ayudar a los muertos inquietos. Continuaré mi deambular sin fin.\n\n*Comienza a desvanecerse*\n\nSi cambias de opinión, estaré aquí... como siempre estoy.");
        npc.conversationOptions.add(cvDecline);

        // During Quest (Parts 2-4) - Still searching
        ConversationOption cvDuringQuest = new ConversationOption(0, 0);
        cvDuringQuest.addOptionText(ENGLISH, "I am still seeking the knowledge to help you.", "*The spirit nods understandingly*\n\nI am grateful that you have not abandoned me. Continue your search, kind soul. Seek those who understand the mysteries of death and spiritual liberation.\n\nI will wait here, as I always do.\n\n*Her glow flickers, as if warning you*\n\nDo not forget... my time in this world is brief. I can only wander for a few hours past midnight. Come find me then, before the first light of dawn.");
        cvDuringQuest.addOptionText(PORTUGUESE, "Ainda estou buscando o conhecimento para ajudá-la.", "*O espírito acena compreensivamente*\n\nSou grata por você não ter me abandonado. Continue sua busca, alma bondosa. Procure aqueles que entendem os mistérios da morte e libertação espiritual.\n\nEstarei esperando aqui, como sempre faço.\n\n*Seu brilho vacila, como se te alertasse*\n\nNão se esqueça... meu tempo neste mundo é breve. Só consigo vagar por poucas horas da madrugada. Venha me encontrar então, antes dos primeiros raios do amanhecer.");
        cvDuringQuest.addOptionText(SPANISH, "Todavía estoy buscando el conocimiento para ayudarte.", "*El espíritu asiente comprensivamente*\n\nEstoy agradecida de que no me hayas abandonado. Continúa tu búsqueda, alma bondadosa. Busca a aquellos que comprenden los misterios de la muerte y la liberación espiritual.\n\nEsperaré aquí, como siempre lo hago.\n\n*Su brillo parpadea, como si te advirtiera*\n\nNo olvides... mi tiempo en este mundo es breve. Solo puedo vagar durante pocas horas de la madrugada. Ven a buscarme entonces, antes de los primeros rayos del amanecer.");
        cvDuringQuest.requirementValidations = (chara, ctx) -> {
            if ((LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FREE_SPIRIT, 1)
                || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FREE_SPIRIT, 2)
                || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FREE_SPIRIT, 3)
                || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FREE_SPIRIT, 4))
                && !LibQuest.isQuestComplete(chara, QuestsIds.FREE_SPIRIT)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvDuringQuest);

        // Part 5 - Player returns with knowledge of ritual
        ConversationOption cvExplainRitual = new ConversationOption(0, 2);
        cvExplainRitual.addOptionText(ENGLISH, "I learned how to free you from a wise priest.", "*The spirit's eyes widen with hope and disbelief*\n\nYou... you truly found a way? After all this time?\n\n*Her voice trembles with emotion*\n\nPlease, tell me what must be done. I am ready to be free from this endless wandering.");
        cvExplainRitual.addOptionText(PORTUGUESE, "Aprendi como libertá-la de um sábio sacerdote.", "*Os olhos do espírito se arregalam com esperança e descrença*\n\nVocê... realmente encontrou uma maneira? Depois de todo esse tempo?\n\n*Sua voz treme de emoção*\n\nPor favor, diga-me o que deve ser feito. Estou pronta para ser livre dessa vagância sem fim.");
        cvExplainRitual.addOptionText(SPANISH, "Aprendí cómo liberarte de un sabio sacerdote.", "*Los ojos del espíritu se ensanchan con esperanza e incredulidad*\n\n¿Tú... realmente encontraste una manera? ¿Después de todo este tiempo?\n\n*Su voz tiembla de emoción*\n\nPor favor, dime lo que debe hacerse. Estoy lista para ser libre de este deambular sin fin.");
        cvExplainRitual.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FREE_SPIRIT, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvExplainRitual);

        // Explain ritual
        ConversationOption cvRitualExplanation = new ConversationOption(2, 3);
        cvRitualExplanation.addOptionText(ENGLISH, "[Explain]", "*The spirit listens intently*\n\nThe priest says the ritual is simple. You must return to the place where you passed from this world. There, with a heart open to peace, you must allow the divine gods to purify and calm your soul. Through acceptance and letting go of this world, you can ascend to eternal rest.\n\n*The spirit's form begins to glow brighter*\n\nIt requires no items, no elaborate ceremony. Only willingness and faith.");
        cvRitualExplanation.addOptionText(PORTUGUESE, "[Explicar]", "*O espírito escuta atentamente*\n\nO sacerdote diz que o ritual é simples. Você deve retornar ao lugar onde passou deste mundo. Lá, com o coração aberto à paz, você deve permitir que os deuses divinos purifiquem e acalmem sua alma. Através da aceitação e do desapego deste mundo, você pode ascender ao descanso eterno.\n\n*A forma do espírito começa a brilhar mais intensamente*\n\nNão requer itens, nenhuma cerimônia elaborada. Apenas disposição e fé.");
        cvRitualExplanation.addOptionText(SPANISH, "[Explicar]", "*El espíritu escucha atentamente*\n\nEl sacerdote dice que el ritual es simple. Debes regresar al lugar donde pasaste de este mundo. Allí, con el corazón abierto a la paz, debes permitir que los dioses divinos purifiquen y calmen tu alma. A través de la aceptación y el desapego de este mundo, puedes ascender al descanso eterno.\n\n*La forma del espíritu comienza a brillar más intensamente*\n\nNo requiere objetos, ninguna ceremonia elaborada. Solo disposición y fe.");
        npc.conversationOptions.add(cvRitualExplanation);

        // Final farewell and gift
        ConversationOption cvFinalFarewell = new ConversationOption(3, 0);
        cvFinalFarewell.addOptionText(ENGLISH, "Are you ready to be free?", "*The spirit's form radiates with newfound peace*\n\nYes... yes, I am ready. Thank you, merciful soul. Your kindness has given me hope after centuries of despair.\n\n*She reaches into the folds of her ethereal robes*\n\nBefore I go, please accept this. In life, I guarded a small treasure - gems I collected over many years. I buried them in Esperand Grove, beneath an ancient oak. This document will guide you there.\n\n*She hands you an old, weathered parchment*\n\nConsider it payment for your compassion. May it serve you better than it served me.\n\n*Her form begins to ascend, growing brighter*\n\nI go now to my rest. Peace be with you always, kind traveler...\n\n*With a final, radiant flash of light, the spirit ascends and disappears, finally free*");
        cvFinalFarewell.addOptionText(PORTUGUESE, "Você está pronta para ser livre?", "*A forma do espírito irradia com nova paz*\n\nSim... sim, estou pronta. Obrigada, alma misericordiosa. Sua bondade me deu esperança após séculos de desespero.\n\n*Ela alcança as dobras de suas vestes etéreas*\n\nAntes de partir, por favor aceite isto. Em vida, guardei um pequeno tesouro - gemas que colecionei ao longo de muitos anos. Enterrei-as no Bosque de Esperand, sob um carvalho antigo. Este documento irá guiá-lo até lá.\n\n*Ela lhe entrega um pergaminho velho e desgastado*\n\nConsidere-o pagamento por sua compaixão. Que te sirva melhor do que me serviu.\n\n*Sua forma começa a ascender, brilhando mais intensamente*\n\nVou agora para meu descanso. Que a paz esteja sempre com você, gentil viajante...\n\n*Com um último clarão radiante de luz, o espírito ascende e desaparece, finalmente livre*");
        cvFinalFarewell.addOptionText(SPANISH, "¿Estás lista para ser libre?", "*La forma del espíritu irradia con nueva paz*\n\nSí... sí, estoy lista. Gracias, alma misericordiosa. Tu bondad me ha dado esperanza después de siglos de desesperación.\n\n*Alcanza los pliegues de sus túnicas etéreas*\n\nAntes de partir, por favor acepta esto. En vida, guardé un pequeño tesoro - gemas que coleccioné durante muchos años. Las enterré en el Bosque de Esperand, bajo un roble antiguo. Este documento te guiará hasta allí.\n\n*Te entrega un pergamino viejo y desgastado*\n\nConsidéralo pago por tu compasión. Que te sirva mejor de lo que me sirvió a mí.\n\n*Su forma comienza a ascender, brillando más intensamente*\n\nVoy ahora a mi descanso. Que la paz esté siempre contigo, gentil viajero...\n\n*Con un último destello radiante de luz, el espíritu asciende y desaparece, finalmente libre*");
        cvFinalFarewell.listeners = (ctx, fragment) -> {

            // Complete quest
            LibQuest.completeQuest(QuestsIds.FREE_SPIRIT, App.getPlayerChar(), 6, ctx);
        };
        npc.conversationOptions.add(cvFinalFarewell);

        npc.requirementValidations = (chara, ctx) -> {
            // Spirit only appears between 3 AM and 4 AM
            // And disappears after quest is complete
            if (isInsideAvailableHours(3, 4) && !LibQuest.isQuestComplete(chara, QuestsIds.FREE_SPIRIT)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        return npc;
    }
}
