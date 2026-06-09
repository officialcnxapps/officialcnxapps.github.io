package com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.KINGDOMS_CUP;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Freddy extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Freddy");
        npc.age = 16;
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hey! Nice to see you!"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Ei! Que bom te ver!"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("¡Eh! ¡Qué bueno verte!"));

        // ===== ROLEPLAY: Initial conversation =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 1);
        cvRoleplay1.addOptionText(ENGLISH, "What do you like to do?", "Oh, I LOVE sports! There's nothing better than a good game with people from all walks of life. I'm always full of energy when it comes to competition!");
        cvRoleplay1.addOptionText(PORTUGUESE, "O que você gosta de fazer?", "Ah, eu AMO esportes! Não há nada melhor do que um bom jogo com pessoas de todos os lugares. Estou sempre cheio de energia quando se trata de competição!");
        cvRoleplay1.addOptionText(SPANISH, "¿Qué te gusta hacer?", "¡Ah, AMO los deportes! No hay nada mejor que un buen juego con gente de todos los ámbitos. ¡Siempre estoy lleno de energía cuando se trata de competición!");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY: About Mob Ball =====
        ConversationOption cvRoleplay2 = new ConversationOption(1, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Tell me more about sports.", "Ever heard of Mob Ball? It's the greatest sport in the kingdom! Two teams of players, a round leather ball, and a field marked with two goal lines. The team that carries the ball across the opponent's goal line wins the round. You can run with the ball, pass it to teammates, but the other team can tackle you to stop your advance. Three rounds, most goals wins. Simple, but incredibly intense!");
        cvRoleplay2.addOptionText(PORTUGUESE, "Me fale mais sobre esportes.", "Já ouviu falar de Mob Ball? É o maior esporte do reino! Duas equipes de jogadores, uma bola de couro redonda e um campo marcado com duas linhas de gol. A equipe que leva a bola pela linha de gol adversária vence a rodada. Você pode correr com a bola, passá-la para companheiros, mas a outra equipe pode te derrubar para impedir seu avanço. Três rodadas, quem fizer mais gols vence. Simples, mas incrivelmente intenso!");
        cvRoleplay2.addOptionText(SPANISH, "Cuéntame más sobre deportes.", "¿Has oído hablar del Mob Ball? ¡Es el mejor deporte del reino! Dos equipos de jugadores, una pelota de cuero redonda y un campo marcado con dos líneas de gol. El equipo que lleva la pelota a la línea de gol del contrario gana la ronda. Puedes correr con la pelota, pasársela a tus compañeros, pero el otro equipo puede placarte para detener tu avance. Tres rondas, el que más goles haga gana. ¡Simple, pero increíblemente intenso!");
        npc.conversationOptions.add(cvRoleplay2);

        // ===== QUEST: Kingdoms Cup - Quest Start =====
        ConversationOption cvQuestStart = new ConversationOption(0, 2);
        cvQuestStart.addOptionText(ENGLISH, "What are you planning these days?", "I've been dreaming of something BIG! Imagine - a grand tournament between ALL the kingdoms! Mob Ball teams from Bastian, Monelix, Helera, Lisport and Esperand all competing together. A true Kingdoms Cup! It would unite the people like never before.\n\nBut I need your help. I'm just seventeen, and alone, no leader would take me seriously. Would you help me invite the leaders?");
        cvQuestStart.addOptionText(PORTUGUESE, "O que você está planejando esses dias?", "Tenho sonhado com algo GRANDE! Imagina - um grande torneio entre TODOS os reinos! Times de Mob Ball de Bastian, Monelix, Helera, Lisport e Esperand competindo juntos. Uma verdadeira Copa dos Reinos! Uniria as pessoas como nunca antes.\n\nMas preciso da sua ajuda. Tenho apenas dezessete anos, e sozinho, nenhum líder me levaria a sério. Você me ajudaria a convidar os líderes?");
        cvQuestStart.addOptionText(SPANISH, "¿Qué estás planeando estos días?", "¡He estado soñando con algo GRANDE! Imagina: ¡un gran torneo entre TODOS los reinos! Equipos de Mob Ball de Bastian, Monelix, Helera, Lisport y Esperand compitiendo juntos. ¡Una verdadera Copa de los Reinos! Uniría a la gente como nunca antes.\n\nPero necesito tu ayuda. Solo tengo diecisiete años y, solo, ningún líder me tomaría en serio. ¿Me ayudarías a invitar a los líderes?");
        cvQuestStart.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(KINGDOMS_CUP, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestStart);

        ConversationOption cvQuestAccept = new ConversationOption(2, 0);
        cvQuestAccept.addOptionText(ENGLISH, "I'll help you invite the leaders.", "Really?! Thank you so much! Start with Lord Markus here in Bastian - he's the closest and should be easiest to convince. Once he accepts, the others will be more willing. Go talk to him at the City Hall!");
        cvQuestAccept.addOptionText(PORTUGUESE, "Vou ajudá-lo a convidar os líderes.", "Sério?! Muito obrigado! Comece com Lorde Markus aqui em Bastian - ele é o mais próximo e deve ser o mais fácil de convencer. Uma vez que ele aceitar, os outros estarão mais dispostos. Vá falar com ele no Salão Municipal!");
        cvQuestAccept.addOptionText(SPANISH, "Te ayudaré a invitar a los líderes.", "¿En serio?! ¡Muchas gracias! Empieza con Lord Markus aquí en Bastian, es el más cercano y debería ser el más fácil de convencer. Una vez que él acepte, los demás estarán más dispuestos. ¡Ve a hablar con él en el Ayuntamiento!");
        cvQuestAccept.listeners = (ctx, fragment) -> {
            LibQuest.includeQuestToQuestbook(KINGDOMS_CUP, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuestAccept);

        ConversationOption cvQuestDecline = new ConversationOption(2, 0);
        cvQuestDecline.addOptionText(ENGLISH, "That sounds difficult. I'll think about it.", "I understand... it IS a big dream. But I believe it can happen! Come back if you change your mind. The Cup needs a champion like you!");
        cvQuestDecline.addOptionText(PORTUGUESE, "Isso parece difícil. Vou pensar sobre isso.", "Entendo... É um grande sonho mesmo. Mas acredito que pode acontecer! Volte se mudar de ideia. A Copa precisa de um campeão como você!");
        cvQuestDecline.addOptionText(SPANISH, "Eso parece difícil. Lo pensaré.", "Entiendo... ES un gran sueño. ¡Pero creo que puede suceder! Vuelve si cambias de opinión. ¡La Copa necesita un campeón como tú!");
        npc.conversationOptions.add(cvQuestDecline);

        // ===== QUEST: Kingdoms Cup - In Progress check =====
        ConversationOption cvQuestProgress = new ConversationOption(0, 0);
        cvQuestProgress.addOptionText(ENGLISH, "I'm still working on gathering the leaders.", "Take your time! But don't forget - every kingdom matters. Bastian, Monelix, Helera, Lisport and Esperand. All of them need to agree for the Kingdoms Cup to be truly grand!");
        cvQuestProgress.addOptionText(PORTUGUESE, "Ainda estou trabalhando para reunir os líderes.", "Pode ir com calma! Mas não esqueça - cada reino importa. Bastian, Monelix, Helera, Lisport e Esperand. Todos eles precisam concordar para a Copa dos Reinos ser verdadeiramente grandiosa!");
        cvQuestProgress.addOptionText(SPANISH, "Todavía estoy trabajando para reunir a los líderes.", "¡Tómate tu tiempo! Pero no olvides: cada reino importa. Bastian, Monelix, Helera, Lisport y Esperand. ¡Todos ellos necesitan estar de acuerdo para que la Copa de los Reinos sea verdaderamente grandiosa!");
        cvQuestProgress.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(KINGDOMS_CUP, chara)
                    && !LibQuest.isQuestComplete(chara, KINGDOMS_CUP)
                    && !LibQuest.isCharacterAtQuestPart(chara, KINGDOMS_CUP, 6)
                    && !LibQuest.isCharacterAtQuestPart(chara, KINGDOMS_CUP, 7)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestProgress);

        // ===== QUEST: Kingdoms Cup - Part 6: Return to Freddy =====
        ConversationOption cvQuestComplete = new ConversationOption(0, 0);
        cvQuestComplete.addOptionText(ENGLISH, "All the leaders have accepted the invitation!", "ALL of them?! This is incredible! The Kingdoms Cup will happen! Bastian, Monelix, Helera, Lisport, Esperand... all competing together! This is going to be the greatest event in the history of the kingdoms! I can't thank you enough - you made this dream a reality!");
        cvQuestComplete.addOptionText(PORTUGUESE, "Todos os líderes aceitaram o convite!", "TODOS eles?! Incrível! A Copa dos Reinos vai acontecer! Bastian, Monelix, Helera, Lisport, Esperand... todos competindo juntos! Este vai ser o maior evento da história dos reinos! Não tenho palavras para agradecer - você tornou esse sonho realidade!");
        cvQuestComplete.addOptionText(SPANISH, "¡Todos los líderes han aceptado la invitación!", "¿¡TODOS ellos?! ¡Es increíble! ¡La Copa de los Reinos va a ocurrir! ¡Bastian, Monelix, Helera, Lisport, Esperand... todos compitiendo juntos! ¡Este va a ser el mayor evento en la historia de los reinos! ¡No puedo agradecerte lo suficiente - has hecho realidad este sueño!");
        cvQuestComplete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, KINGDOMS_CUP, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvQuestComplete.listeners = (ctx, fragment) -> {
            LibQuest.updateQuest(KINGDOMS_CUP, 7, App.getPlayerChar(), ctx);
            App.Shell.flowManager.addCompletedQuestToQueue(App.getPlayerChar().getQuest(KINGDOMS_CUP), ctx);
        };
        npc.conversationOptions.add(cvQuestComplete);

        // ===== ROLEPLAY AFTER QUEST: About the tournament =====
        ConversationOption cvAfterQuest = new ConversationOption(0, 0);
        cvAfterQuest.addOptionText(ENGLISH, "How are the preparations for the Kingdoms Cup going?", "Amazing! Every kingdom is sending their best Mob Ball team. I've been working with the lords' messengers to organize the field and the schedule. The whole city of Bastian is buzzing with excitement. It's going to be legendary!");
        cvAfterQuest.addOptionText(PORTUGUESE, "Como estão os preparativos para a Copa dos Reinos?", "Incrível! Cada reino está enviando seu melhor time de Mob Ball. Tenho trabalhado com os mensageiros dos lordes para organizar o campo e o cronograma. A cidade toda de Bastian está em alvoroço. Vai ser lendário!");
        cvAfterQuest.addOptionText(SPANISH, "¿Cómo van los preparativos para la Copa de los Reinos?", "¡Increíble! Cada reino está enviando su mejor equipo de Mob Ball. He estado trabajando con los mensajeros de los señores para organizar el campo y el programa. ¡Toda la ciudad de Bastian está llena de emoción! ¡Va a ser legendario!");
        cvAfterQuest.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, KINGDOMS_CUP)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAfterQuest);

        return npc;
    }
}

