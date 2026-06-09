package com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian;

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

public class Nelera extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Nelera");
        npc.age = 36;
        npc.job = Enums.NPCJobs.STUDENT;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Greetings, fellow seeker of knowledge."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Saudações, companheiro buscador de conhecimento."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Saludos, compañero buscador de conocimiento."));

        // NPC only appears in Bastian until part 6, then moves to Ayalon
        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_ELF_LIBRARY, 6) ||
                    LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_ELF_LIBRARY, 7) ||
                    LibQuest.isQuestComplete(chara, QuestsIds.THE_ELF_LIBRARY)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        // ===== GENERAL ROLEPLAY CONVERSATIONS =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "What do you do here in Bastian?", "I am a scholar of elven culture. I've spent most of my adult life studying their language, their history, their art and philosophy. It's a passion that began when I was young and found an ancient elven text. Ever since, I've been captivated by their wisdom.");
        cvRoleplay1.addOptionText(PORTUGUESE, "O que você faz aqui em Bastian?", "Sou uma estudiosa da cultura élfica. Passei a maior parte da minha vida adulta estudando sua língua, sua história, sua arte e filosofia. É uma paixão que começou quando eu era jovem e encontrei um texto élfico ancestral. Desde então, fiquei cativada por sua sabedoria.");
        cvRoleplay1.addOptionText(SPANISH, "¿Qué haces aquí en Bastian?", "Soy una erudita de la cultura élfica. He pasado la mayor parte de mi vida adulta estudiando su idioma, su historia, su arte y filosofía. Es una pasión que comenzó cuando era joven y encontré un texto élfico ancestral. Desde entonces, he estado cautivada por su sabiduría.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== THE ELF LIBRARY QUEST: Part 3 - First meeting, request for job =====
        ConversationOption cvLibrary1 = new ConversationOption(0, 1);
        cvLibrary1.addOptionText(ENGLISH, "Eldrin sent me. I need help translating elven texts from the library of Ayalon.", "*Eyes widen with excitement*\nThe library of Ayalon?! You... you have access to the Great Library? \n*takes a deep breath to calm herself*\nI apologize for my excitement, but this is extraordinary! I've dreamed of seeing that library my entire life. Yes, yes, I can help translate!");
        cvLibrary1.addOptionText(PORTUGUESE, "Eldrin me enviou. Preciso de ajuda para traduzir textos élficos da biblioteca de Ayalon.", "*Olhos se arregalam de excitação*\nA biblioteca de Ayalon?! Você... você tem acesso à Grande Biblioteca? \n*respira fundo para se acalmar*\nPeço desculpas pela minha excitação, mas isso é extraordinário! Sonhei em ver essa biblioteca minha vida inteira. Sim, sim, posso ajudar a traduzir!");
        cvLibrary1.addOptionText(SPANISH, "Eldrin me envió. Necesito ayuda para traducir textos élficos de la biblioteca de Ayalon.", "*Los ojos se abren con emoción*\n¿¡La biblioteca de Ayalon!? Tú... ¿tienes acceso a la Gran Biblioteca? \n*respira hondo para calmarse*\nDisculpa mi emoción, pero esto es extraordinario! He soñado con ver esa biblioteca toda mi vida. ¡Sí, sí, puedo ayudar a traducir!");
        cvLibrary1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_ELF_LIBRARY, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvLibrary1);

        ConversationOption cvLibrary2 = new ConversationOption(1, 2);
        cvLibrary2.addOptionText(ENGLISH, "Excellent! When can you start?", "*Hesitates*\nI... I want nothing more than to help you and to see that library. But I must be honest with you. This would be an enormous opportunity for me - not just to help Havarus, but to advance my life's work. If I do this, if I help translate those ancient texts... I would like something in return.");
        cvLibrary2.addOptionText(PORTUGUESE, "Excelente! Quando pode começar?", "*Hesita*\nEu... não quero nada mais do que ajudá-lo e ver aquela biblioteca. Mas devo ser honesta com você. Esta seria uma oportunidade enorme para mim - não apenas para ajudar Havarus, mas para avançar o trabalho da minha vida. Se eu fizer isso, se eu ajudar a traduzir esses textos ancestrais... gostaria de algo em troca.");
        cvLibrary2.addOptionText(SPANISH, "¡Excelente! ¿Cuándo puedes empezar?", "*Duda*\nYo... no quiero nada más que ayudarte y ver esa biblioteca. Pero debo ser honesta contigo. Esta sería una oportunidad enorme para mí, no solo para ayudar a Havarus, sino para avanzar en el trabajo de mi vida. Si hago esto, si ayudo a traducir esos textos ancestrales... me gustaría algo a cambio.");
        npc.conversationOptions.add(cvLibrary2);

        ConversationOption cvLibrary3 = new ConversationOption(2, 0);
        cvLibrary3.addOptionText(ENGLISH, "What do you want?", "I want a position at the Royal Library of Monelix. It has always been my dream to work there, surrounded by the kingdom's finest texts and scholars. But they've never accepted me - they say my focus on elven culture is too narrow, too... unconventional. If Queen Enola herself recommended me, they would have to accept. Could you speak to the Queen on my behalf?");
        cvLibrary3.addOptionText(PORTUGUESE, "O que você quer?", "Quero um cargo na Biblioteca Real de Monelix. Sempre foi meu sonho trabalhar lá, cercada pelos melhores textos e estudiosos do reino. Mas nunca me aceitaram - dizem que meu foco na cultura élfica é muito restrito, muito... não convencional. Se a própria Rainha Enola me recomendasse, teriam que aceitar. Você poderia falar com a Rainha em meu nome?");
        cvLibrary3.addOptionText(SPANISH, "¿Qué quieres?", "Quiero un puesto en la Biblioteca Real de Monelix. Siempre ha sido mi sueño trabajar allí, rodeada de los mejores textos y eruditos del reino. Pero nunca me han aceptado: dicen que mi enfoque en la cultura élfica es demasiado estrecho, demasiado... poco convencional. Si la propia Reina Enola me recomendara, tendrían que aceptar. ¿Podrías hablar con la Reina en mi nombre?");
        cvLibrary3.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.THE_ELF_LIBRARY, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvLibrary3);

        // ===== THE ELF LIBRARY QUEST: Part 5 - After Queen approval =====
        ConversationOption cvLibrary4 = new ConversationOption(0, 3);
        cvLibrary4.addOptionText(ENGLISH, "Queen Enola has approved your position at the Royal Library.", "*Gasps, hands covering her mouth*\nShe... she did? Queen Enola herself? \n*tears of joy forming*\nI... I don't know what to say. Thank you! Thank you so much! This is a dream come true!");
        cvLibrary4.addOptionText(PORTUGUESE, "A Rainha Enola aprovou seu cargo na Biblioteca Real.", "*Ofega, mãos cobrindo a boca*\nEla... ela aprovou? A própria Rainha Enola? \n*lágrimas de alegria se formando*\nEu... não sei o que dizer. Obrigada! Muito obrigada! Este é um sonho realizado!");
        cvLibrary4.addOptionText(SPANISH, "La Reina Enola ha aprobado tu puesto en la Biblioteca Real.", "*Jadea, manos cubriendo su boca*\n¿Ella... ella lo hizo? ¿La propia Reina Enola? \n*lágrimas de alegría formándose*\nYo... no sé qué decir. ¡Gracias! ¡Muchas gracias! ¡Este es un sueño hecho realidad!");
        cvLibrary4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_ELF_LIBRARY, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvLibrary4);

        ConversationOption cvLibrary5 = new ConversationOption(3, 4);
        cvLibrary5.addOptionText(ENGLISH, "You'll need to travel to Ayalon immediately to begin studying.", "*Nods eagerly*\nYes, yes, of course! But... I've never been to Ayalon. I've studied their language and culture from books, but I've never actually traveled there. How do I get there? The naval routes have been closed for so long...");
        cvLibrary5.addOptionText(PORTUGUESE, "Você precisará viajar para Ayalon imediatamente para começar a estudar.", "*Acena ansiosamente*\nSim, sim, claro! Mas... nunca estive em Ayalon. Estudei sua língua e cultura através de livros, mas nunca realmente viajei para lá. Como chego lá? As rotas navais estão fechadas há tanto tempo...");
        cvLibrary5.addOptionText(SPANISH, "Necesitarás viajar a Ayalon inmediatamente para comenzar a estudiar.", "*Asiente ansiosamente*\n¡Sí, sí, por supuesto! Pero... nunca he estado en Ayalon. He estudiado su idioma y cultura a través de libros, pero nunca he viajado allí realmente. ¿Cómo llego allí? Las rutas navales han estado cerradas durante tanto tiempo...");
        npc.conversationOptions.add(cvLibrary5);

        ConversationOption cvLibrary6 = new ConversationOption(4, 0);
        cvLibrary6.addOptionText(ENGLISH, "*Explains the portal in Gybralar forest tunnel*", "A portal! Of course, the ancient gateways! \n*takes notes frantically*\nThrough the central forest of Gybralar, a hidden tunnel, statue of Aelindra... Yes, yes, I remember reading about this! The portal can only be used by those who have earned passage. Since you've already activated it, it should remain open. \n*gathers her belongings*\nI'll head there immediately. Meet me at the elven library when you're ready to begin our work!");
        cvLibrary6.addOptionText(PORTUGUESE, "*Explica sobre o portal no túnel da floresta de Gybralar*", "Um portal! Claro, os portais ancestrais! \n*anota freneticamente*\nAtravés da floresta central de Gybralar, um túnel escondido, estátua de Aelindra... Sim, sim, me lembro de ter lido sobre isso! O portal só pode ser usado por aqueles que ganharam passagem. Como você já o ativou, ele deve permanecer aberto. \n*reúne seus pertences*\nVou para lá imediatamente. Encontre-me na biblioteca élfica quando estiver pronto para começarmos nosso trabalho!");
        cvLibrary6.addOptionText(SPANISH, "*Explica sobre el portal en el túnel del bosque de Gybralar*", "¡Un portal! ¡Por supuesto, las puertas ancestrales! \n*toma notas frenéticamente*\nA través del bosque central de Gybralar, un túnel escondido, estatua de Aelindra... ¡Sí, sí, recuerdo haber leído sobre esto! El portal solo puede ser usado por aquellos que han ganado el paso. Como ya lo has activado, debería permanecer abierto. \n*reúne sus pertenencias*\n¡Iré allí inmediatamente! ¡Encuéntrame en la biblioteca élfica cuando estés listo para comenzar nuestro trabajo!");
        cvLibrary6.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.THE_ELF_LIBRARY, 6, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvLibrary6);

        return npc;
    }
}

