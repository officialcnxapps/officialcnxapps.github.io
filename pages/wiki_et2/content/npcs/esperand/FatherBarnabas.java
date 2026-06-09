package com.cnx.endlesstalestwo.data.npcs.esperand;

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

import java.util.Collections;

public class FatherBarnabas extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Father Barnabas");
        npc.addNameTranslation(PORTUGUESE, "Padre Barnabás");
        npc.addNameTranslation(SPANISH, "Padre Bernabé");
        npc.age = 44;
        npc.job = Enums.NPCJobs.PRIEST;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A man strong in faith and generous. He performs acts of kindness out of empathy and love.\nHe is not naive; he knows how to defend himself as he walks through the lands.\nHis brother is a priest in Esperand.\n\nHis physical traits: Almost bald, with a thin gray beard. Light eyes and bright fair skin. He wears a tunic over his head.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um homem forte na fé, generoso. Realiza atos de bondade por empatia e amor.\nNão é ingênuo, sabe se defender pois vaga pelas terras.\nSeu irmão é padre em Esperand.\n\nSeus traços físicos: Quase careca, barba rala e grisalha. Olhos claros e pele clara brilhosa. Usa uma túnica sobre a cabeça.");
        npc.addDescriptionTranslation(SPANISH, "Un hombre fuerte en la fe y generoso. Realiza actos de bondad por empatía y amor.\nNo es ingenuo; sabe defenderse porque recorre las tierras.\nSu hermano es sacerdote en Esperand.\n\nSus rasgos físicos: Casi calvo, con barba fina y canosa. Ojos claros y piel clara brillante. Lleva una túnica sobre la cabeza.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Blessings upon you, child."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bênçãos sobre você, filho."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Bendiciones sobre ti, hijo."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("May the light guide your path."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Que a luz guie seu caminho."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Que la luz guíe tu camino."));

        // NPC only appears if player has alignment >= 85 OR quest already started
        npc.requirementValidations = (chara, ctx) -> {
            // If quest is already started, always show NPC
            if (LibQuest.charHasQuest(QuestsIds.GOOD_SAMARITAN, chara)) {
                return Enums.RequirementVerification.OK;
            }

            // Otherwise, check alignment
            int alignment = chara.attributesManager.getCurrent(Enums.AttributeName.ALIGNMENT);
            if (alignment >= 85) {
                return Enums.RequirementVerification.OK;
            }

            return Enums.RequirementVerification.NOT_OK;
        };

        // ===== ROLEPLAY: About his mission (always available) =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "What brings you to these lands?", "I am a humble servant of the gods, traveling from village to village, helping those in need. So many suffer in these remote places - the poor, the sick, the forgotten. It is my calling to bring them comfort, food, and hope. The path of charity is not easy, but it fills my heart with joy.");
        cvRoleplay1.addOptionText(PORTUGUESE, "O que o traz a estas terras?", "Sou um humilde servo dos deuses, viajando de vila em vila, ajudando os necessitados. Tantos sofrem nestes lugares remotos - os pobres, os doentes, os esquecidos. É meu chamado trazer-lhes conforto, comida e esperança. O caminho da caridade não é fácil, mas enche meu coração de alegria.");
        cvRoleplay1.addOptionText(SPANISH, "¿Qué te trae a estas tierras?", "Soy un humilde servidor de los dioses, viajando de aldea en aldea, ayudando a los necesitados. Tantos sufren en estos lugares remotos: los pobres, los enfermos, los olvidados. Es mi llamado traerles consuelo, comida y esperanza. El camino de la caridad no es fácil, pero llena mi corazón de alegría.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY: About goodness =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "How do you stay so kind in a harsh world?", "Ah, my child, the world is only as harsh as we make it. Every small act of kindness creates ripples of light in the darkness. When you help one person, you inspire others to do the same. True goodness is not about grand gestures - it's about the daily choice to be compassionate, generous, and caring. I see goodness in your heart. That is a precious gift.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Como você permanece tão bondoso em um mundo cruel?", "Ah, meu filho, o mundo é apenas tão cruel quanto o fazemos. Cada pequeno ato de bondade cria ondas de luz na escuridão. Quando você ajuda uma pessoa, inspira outros a fazer o mesmo. A verdadeira bondade não é sobre grandes gestos - é sobre a escolha diária de ser compassivo, generoso e cuidadoso. Vejo bondade em seu coração. Isso é um dom precioso.");
        cvRoleplay2.addOptionText(SPANISH, "¿Cómo te mantienes tan bondadoso en un mundo cruel?", "Ah, hijo mío, el mundo es solo tan cruel como lo hacemos. Cada pequeño acto de bondad crea ondas de luz en la oscuridad. Cuando ayudas a una persona, inspiras a otros a hacer lo mismo. La verdadera bondad no se trata de grandes gestos, sino de la elección diaria de ser compasivo, generoso y cariñoso. Veo bondad en tu corazón. Eso es un regalo precioso.");
        cvRoleplay2.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.GOOD_SAMARITAN, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay2);

        // ===== QUEST: Good Samaritan - Introduction =====
        ConversationOption cvQuest1 = new ConversationOption(0, 1);
        cvQuest1.addOptionText(ENGLISH, "Can I help with your charitable work?", "*Eyes light up with joy*\nBless you, child! I can see the goodness radiating from your soul. Yes, I could use help! I collect supplies - food, medicine, blankets - and distribute them to the poor in remote villages. The journey is long, and my old bones tire easily. Would you be willing to help deliver supplies to those in need?");
        cvQuest1.addOptionText(PORTUGUESE, "Posso ajudar com seu trabalho de caridade?", "*Olhos se iluminam de alegria*\nAbençoo você, filho! Posso ver a bondade radiando de sua alma. Sim, eu poderia usar ajuda! Coleto suprimentos - comida, remédios, cobertores - e os distribuo aos pobres em vilas remotas. A jornada é longa, e meus velhos ossos se cansam facilmente. Você estaria disposto a ajudar a entregar suprimentos aos necessitados?");
        cvQuest1.addOptionText(SPANISH, "¿Puedo ayudar con tu trabajo caritativo?", "*Los ojos se iluminan de alegría*\n¡Bendito seas, hijo! Puedo ver la bondad radiando de tu alma. ¡Sí, podría usar ayuda! Recolecto suministros (comida, medicinas, mantas) y los distribuyo a los pobres en aldeas remotas. El viaje es largo y mis viejos huesos se cansan fácilmente. ¿Estarías dispuesto a ayudar a entregar suministros a los necesitados?");
        cvQuest1.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.GOOD_SAMARITAN, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuest1);

        ConversationOption cvQuest2 = new ConversationOption(1, 2);
        cvQuest2.addOptionText(ENGLISH, "I will help those in need.", "Your kindness warms my heart! The villages that need help most are Letow, Umera, and the Monastery. The people there struggle with poverty and hardship. I have prepared supply packages for each location. Take them and distribute them to those who need them most. The gratitude you'll see in their eyes will be your greatest reward. May the gods bless your journey!");
        cvQuest2.addOptionText(PORTUGUESE, "Vou ajudar os necessitados.", "Sua bondade aquece meu coração! As vilas que mais precisam de ajuda são Letow, Umera e o Monastério. As pessoas lá lutam com pobreza e dificuldades. Preparei pacotes de suprimentos para cada local. Leve-os e distribua-os para aqueles que mais precisam. A gratidão que verá em seus olhos será sua maior recompensa. Que os deuses abençoem sua jornada!");
        cvQuest2.addOptionText(SPANISH, "Ayudaré a los necesitados.", "¡Tu bondad calienta mi corazón! Las aldeas que más necesitan ayuda son Letow, Umera y el Monasterio. La gente allí lucha contra la pobreza y las dificultades. He preparado paquetes de suministros para cada ubicación. Llévalos y distribúyelos a quienes más los necesiten. La gratitud que verás en sus ojos será tu mayor recompensa. ¡Que los dioses bendigan tu viaje!");
        npc.conversationOptions.add(cvQuest2);

        ConversationOption cvQuest3 = new ConversationOption(2, 0);
        cvQuest3.addOptionText(ENGLISH, "[Accept the supply packages]", "*Hands you three carefully wrapped packages*\nHere they are. First, visit Letow - the people there face constant struggles. Then Umera, where many families have fallen on hard times. Finally, the Monastery, where the brothers care for the sick and homeless. Go with my blessing, and may your generosity be returned tenfold!");
        cvQuest3.addOptionText(PORTUGUESE, "[Aceitar os pacotes de suprimentos]", "*Entrega três pacotes cuidadosamente embrulhados*\nAqui estão. Primeiro, visite Letow - as pessoas lá enfrentam lutas constantes. Depois Umera, onde muitas famílias passam por tempos difíceis. Finalmente, o Monastério, onde os irmãos cuidam dos doentes e desabrigados. Vá com minha bênção, e que sua generosidade seja retornada dez vezes mais!");
        cvQuest3.addOptionText(SPANISH, "[Aceptar los paquetes de suministros]", "*Te entrega tres paquetes cuidadosamente envueltos*\nAquí están. Primero, visita Letow: la gente allí enfrenta luchas constantes. Luego Umera, donde muchas familias han caído en tiempos difíciles. Finalmente, el Monasterio, donde los hermanos cuidan de los enfermos y desamparados. ¡Ve con mi bendición, y que tu generosidad sea devuelta diez veces más!");
        cvQuest3.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.GOOD_SAMARITAN, App.getPlayerChar(), ctx);
            LibInventory.addToInventory(ItemsIds.CHARITY_PACKAGE, 3, App.getPlayerChar());
        };
        npc.conversationOptions.add(cvQuest3);

        // ===== QUEST: Good Samaritan - During deliveries =====
        ConversationOption cvDuring = new ConversationOption(0, 0);
        cvDuring.addOptionText(ENGLISH, "I'm still delivering the supplies.", "Bless you for your dedication! The people you're helping will remember your kindness forever. Continue your good work, my child.");
        cvDuring.addOptionText(PORTUGUESE, "Ainda estou entregando os suprimentos.", "Abençoo você por sua dedicação! As pessoas que você está ajudando lembrarão de sua bondade para sempre. Continue seu bom trabalho, meu filho.");
        cvDuring.addOptionText(SPANISH, "Todavía estoy entregando los suministros.", "¡Bendito seas por tu dedicación! La gente que estás ayudando recordará tu bondad para siempre. Continúa tu buen trabajo, hijo mío.");
        cvDuring.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GOOD_SAMARITAN, 1) ||
                    LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GOOD_SAMARITAN, 2) ||
                    LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GOOD_SAMARITAN, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvDuring);

        // ===== QUEST: Good Samaritan - Return after deliveries =====
        ConversationOption cvReturn = new ConversationOption(0, 3);
        cvReturn.addOptionText(ENGLISH, "I've delivered all the supplies.", "*Clasps your hands warmly*\nYou have done a wonderful thing today, my child! The people you helped will never forget your kindness. You have brought light into dark places, hope to the hopeless, food to the hungry. This is what true goodness looks like - not seeking glory or reward, but simply helping those in need.");
        cvReturn.addOptionText(PORTUGUESE, "Entreguei todos os suprimentos.", "*Aperta suas mãos calorosamente*\nVocê fez algo maravilhoso hoje, meu filho! As pessoas que você ajudou nunca esquecerão sua bondade. Você trouxe luz para lugares escuros, esperança para os desesperançados, comida para os famintos. Isso é o que a verdadeira bondade parece - não buscar glória ou recompensa, mas simplesmente ajudar os necessitados.");
        cvReturn.addOptionText(SPANISH, "He entregado todos los suministros.", "*Te estrecha las manos calurosamente*\n¡Has hecho algo maravilloso hoy, hijo mío! La gente que ayudaste nunca olvidará tu bondad. Has traído luz a lugares oscuros, esperanza a los desesperanzados, comida a los hambrientos. Esto es lo que parece la verdadera bondad: no buscar gloria o recompensa, sino simplemente ayudar a los necesitados.");
        cvReturn.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GOOD_SAMARITAN, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvReturn);

        ConversationOption cvComplete = new ConversationOption(3, 0);
        cvComplete.addOptionText(ENGLISH, "[Receive blessing]", "*Places hands on your head*\nMay the gods bless you abundantly for your selfless actions. You have proven yourself to be truly good-hearted. The world needs more souls like yours. Remember - every act of kindness, no matter how small, makes the world a better place. Go forth and continue to spread goodness wherever you travel!");
        cvComplete.addOptionText(PORTUGUESE, "[Receber bênção]", "*Coloca as mãos em sua cabeça*\nQue os deuses abençoem você abundantemente por suas ações altruístas. Você provou ser verdadeiramente bondoso. O mundo precisa de mais almas como a sua. Lembre-se - cada ato de bondade, não importa quão pequeno, torna o mundo um lugar melhor. Vá em frente e continue a espalhar bondade onde quer que viaje!");
        cvComplete.addOptionText(SPANISH, "[Recibir bendición]", "*Coloca las manos sobre tu cabeza*\nQue los dioses te bendigan abundantemente por tus acciones desinteresadas. Has demostrado ser verdaderamente bondadoso. El mundo necesita más almas como la tuya. Recuerda: cada acto de bondad, por pequeño que sea, hace del mundo un lugar mejor. ¡Ve y continúa esparciendo bondad dondequiera que viajes!");
        cvComplete.listeners = (ctx, currentFragment) -> {
            App.getPlayerChar().attributesManager.increase(Enums.AttributeName.ALIGNMENT, 8);
            LibQuest.completeQuest(QuestsIds.GOOD_SAMARITAN, App.getPlayerChar(), 5, ctx);
        };
        npc.conversationOptions.add(cvComplete);

        // ===== ROLEPLAY: After quest completion =====
        ConversationOption cvAfterQuest = new ConversationOption(0, 0);
        cvAfterQuest.addOptionText(ENGLISH, "How are the villages doing?", "Thanks to your help, they are doing much better! The supplies you delivered have made a real difference. The children in Letow have food, the families in Umera have medicine, and the Monastery can continue its work. You have my eternal gratitude, my child. Your goodness shines like a beacon in this world.");
        cvAfterQuest.addOptionText(PORTUGUESE, "Como estão as vilas?", "Graças à sua ajuda, estão muito melhor! Os suprimentos que você entregou fizeram uma diferença real. As crianças em Letow têm comida, as famílias em Umera têm remédios, e o Monastério pode continuar seu trabalho. Você tem minha eterna gratidão, meu filho. Sua bondade brilha como um farol neste mundo.");
        cvAfterQuest.addOptionText(SPANISH, "¿Cómo están las aldeas?", "¡Gracias a tu ayuda, están mucho mejor! Los suministros que entregaste han marcado una diferencia real. Los niños en Letow tienen comida, las familias en Umera tienen medicinas, y el Monasterio puede continuar su trabajo. Tienes mi eterna gratitud, hijo mío. Tu bondad brilla como un faro en este mundo.");
        cvAfterQuest.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.GOOD_SAMARITAN)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAfterQuest);

        // ===== ROLEPLAY: After quest completion — Mention Captain Vinny =====
        ConversationOption cvMoreHelp = new ConversationOption(0, 0);
        cvMoreHelp.addOptionText(ENGLISH,
                "Is there anything else I can do to help?",
                "*smiles warmly*\nYour heart never tires of doing good — that alone speaks volumes. I am but a humble priest, so I cannot offer formal work. But... I know that Captain Vinny, who watches over Esperand from his watchtower, tends to look favorably upon those who have proven themselves to this city's people. A good samaritan such as yourself might find a warm reception there.");
        cvMoreHelp.addOptionText(PORTUGUESE,
                "Há mais alguma coisa que eu possa fazer para ajudar?",
                "*sorri calorosamente*\nSeu coração nunca se cansa de fazer o bem — isso por si só diz muito. Sou apenas um humilde padre, então não tenho trabalho formal para oferecer. Mas... sei que o Capitão Vinny, que vela por Esperand em sua torre de vigia, costuma olhar com bons olhos para aqueles que demonstraram seu valor ao povo desta cidade. Um bom samaritano como você talvez encontre uma recepção calorosa por lá.");
        cvMoreHelp.addOptionText(SPANISH,
                "¿Hay algo más que pueda hacer para ayudar?",
                "*sonríe cálidamente*\nTu corazón nunca se cansa de hacer el bien — eso ya dice mucho. Soy apenas un humilde sacerdote, así que no tengo trabajo formal que ofrecer. Pero... sé que el Capitán Vinny, que vela por Esperand desde su torre de vigilancia, suele ver con buenos ojos a quienes han demostrado su valor para la gente de esta ciudad. Un buen samaritano como tú quizás encuentre una cálida bienvenida allí.");
        cvMoreHelp.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.GOOD_SAMARITAN)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvMoreHelp);

        npc.hasRandomizedConversations = true;
        return npc;
    }
}
