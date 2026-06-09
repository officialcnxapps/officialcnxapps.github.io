package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.castle;

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

public class LadyJade extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Lady Jade");
        npc.age = 68;
        npc.job = Enums.NPCJobs.COUNSELOR;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Greetins, [GENDER_FORMAL_CALL], be welcome."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Saudações, [GENDER_FORMAL_CALL], seja bem-vindo."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Saludos, [GENDER_FORMAL_CALL]."));

        npc.generateRandomByes();

        // Conversation options
        ConversationOption cv3 = new ConversationOption(0, 1);
        cv3.addOptionText(ENGLISH, "I need your help with a riot situation.", "Are you talking about the woodcutters in Apenna? I heard about. Tell me more.");
        cv3.addOptionText(PORTUGUESE, "Preciso da sua ajuda com uma situação de motim.", "Você está falando dos lenhadores em Apenna? Eu ouvi falar. Conte-me mais.");
        cv3.addOptionText(SPANISH, "Necesito su ayuda con una situación de motín.", "¿Estás hablando de los leñadores en Apenna? He oído al respecto. Cuéntame más.");
        cv3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RIOT_CONTROL, 2) && LibInventory.checkHasItem(ItemsIds.WOODCUTTERS_LETTER, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(1, 0);
        cv4.addOptionText(ENGLISH, "They are demanding some things, I have a letter here.", "[Reads the letter]\nWhat a terrible situation. In any other time, we should send the royal army there and force them to work. However, we are expanding, and timber is essential. We cannot lose manpower.\nTell them the kingdom sends condolences to the deceased.\nTake these 20 gold coins as well; they should be enough for the woodcutters to share as extra payment.");
        cv4.addOptionText(PORTUGUESE, "Eles exigem algumas coisas, tenho uma carta aqui.", "[Lê a carta]\nQue situação péssima. Em qualquer outra época deveríamos mandar o exército real até lá e obriga-los a trabalhar. Porém estamos a expandir e a madeira é essencial. Não podemos perder mão de obra.\nDiga que o reino manda condolências ao falecido.\npegue também estas 20 moedas de ouro, devem bastar para os lenhadores dividirem como pagamento extra.");
        cv4.addOptionText(SPANISH, "Están exigiendo algunas cosas, tengo una carta aquí.", "[Lee la carta]\nQué situación terrible. En cualquier otro momento, deberíamos enviar al ejército real allí y obligarlos a trabajar. Sin embargo, estamos en expansión, y la madera es esencial. No podemos perder mano de obra.\nDiles que el reino envía condolencias al fallecido.\nToma también estas 20 monedas de oro; deberían ser suficientes para que los leñadores las compartan como pago extra.");
        cv4.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.RIOT_CONTROL, 3, App.getPlayerChar(), ctx);
            App.getPlayerChar().addGold(20);
            LibInventory.removeFromInventory(ItemsIds.WOODCUTTERS_LETTER, 1, App.getPlayerChar());
        };
        npc.conversationOptions.add(cv4);

        // ===== QUEST: Kingdoms Cup - Part 2 =====
        ConversationOption cvKingdomsCup1 = new ConversationOption(0, 11);
        cvKingdomsCup1.addOptionText(ENGLISH, "A young man wants to organize a tournament between all cities and kingdoms.", "A tournament? Between all cities and kingdoms?\n\n*Looks curious but cautious*\n\nThat's quite an ambitious undertaking. What kind of tournament are we talking about? And who is backing this proposal?");
        cvKingdomsCup1.addOptionText(PORTUGUESE, "Um jovem quer organizar um torneio entre todas as cidades e reinos.", "Um torneio? Entre todas as cidades e reinos?\n\n*Parece curiosa mas cautelosa*\n\nIsso é um empreendimento bastante ambicioso. Que tipo de torneio estamos falando? E quem está apoiando essa proposta?");
        cvKingdomsCup1.addOptionText(SPANISH, "Un joven quiere organizar un torneo entre todas las ciudades y reinos.", "¿Un torneo? ¿Entre todas las ciudades y reinos?\n\n*Parece curiosa pero cautelosa*\n\nEse es un emprendimiento bastante ambicioso. ¿De qué tipo de torneo estamos hablando? ¿Y quién respalda esta propuesta?");
        cvKingdomsCup1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.KINGDOMS_CUP, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvKingdomsCup1);

        ConversationOption cvKingdomsCup2 = new ConversationOption(11, 0);
        cvKingdomsCup2.addOptionText(ENGLISH, "A Mob Ball competition. Lord Markus has already accepted.", "*Eyes light up with interest*\n\nMob Ball! A sporting competition between all kingdoms... and my brother Markus accepted? Well then, this changes things considerably!\n\n*Nods thoughtfully*\n\nMob Ball is intense and exciting - perfect for bringing people together. If Markus sees merit in this, then there must be real potential. A competition like this could strengthen diplomatic bonds and give the people something joyful to celebrate.\n\nYou can count on Monelix's participation. Tell the organizer that Lady Jade accepts!");
        cvKingdomsCup2.addOptionText(PORTUGUESE, "Uma competição de Mob Ball. Lorde Markus já aceitou.", "*Os olhos se iluminam de interesse*\n\nMob Ball! Uma competição esportiva entre todos os reinos... e meu irmão Markus aceitou? Bem, isso muda as coisas consideravelmente!\n\n*Acena pensativamente*\n\nMob Ball é intenso e emocionante - perfeito para unir as pessoas. Se Markus vê mérito nisso, então deve haver potencial real. Uma competição assim poderia fortalecer laços diplomáticos e dar ao povo algo alegre para celebrar.\n\nPode contar com a participação de Monelix. Diga ao organizador que Lady Jade aceita!");
        cvKingdomsCup2.addOptionText(SPANISH, "Una competición de Mob Ball. Lord Markus ya ha aceptado.", "*Los ojos se iluminan de interés*\n\n¡Mob Ball! Una competición deportiva entre todos los reinos... ¿y mi hermano Markus aceptó? Bueno, eso cambia las cosas considerablemente.\n\n*Asiente pensativamente*\n\nMob Ball es intenso y emocionante, perfecto para unir a la gente. Si Markus ve mérito en esto, entonces debe haber potencial real. Una competición así podría fortalecer lazos diplomáticos y dar a la gente algo alegre que celebrar.\n\n¡Pueden contar con la participación de Monelix! Dile al organizador que Lady Jade acepta!");
        cvKingdomsCup2.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.KINGDOMS_CUP, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvKingdomsCup2);

        // ========================================
        // QUEST: FALKER_FAMILY — PART 6
        // ========================================

        ConversationOption cvFF7 = new ConversationOption(0, 12);
        cvFF7.addOptionText(ENGLISH, "Lady Jade, I bring an old contract regarding the Brant-Falker land dispute.", "*She looks up with interest*\n\nThe Brant-Falker dispute? That conflict has plagued this region for decades. Show me what you've found.");
        cvFF7.addOptionText(PORTUGUESE, "Lady Jade, trago um contrato antigo sobre a disputa de terras Brant-Falker.", "*Ela olha com interesse*\n\nA disputa Brant-Falker? Esse conflito assola esta região há décadas. Mostre-me o que encontrou.");
        cvFF7.addOptionText(SPANISH, "Lady Jade, traigo un contrato antiguo sobre la disputa de tierras Brant-Falker.", "*Ella mira com interés*\n\n¿La disputa Brant-Falker? Ese conflicto ha plagado esta región durante décadas. Muéstrame lo que has encontrado.");
        cvFF7.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FALKER_FAMILY, 6)
                    && LibInventory.checkHasItem(ItemsIds.OLD_BRANT_CONTRACT, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvFF7);

        ConversationOption cvFF7b = new ConversationOption(12, 0);
        cvFF7b.addOptionText(ENGLISH, "Here is the original contract.", "[She reads carefully]\n\nThis is deeply troubling. Look at clause seven — the ink is visibly different from the rest of the document, and the handwriting does not match. This clause was not part of the original agreement. It was added after Lord Den had already signed.\n\nThis is forgery. Sir Martyn Brant falsified a royal land agreement.\n\nBy the authority vested in me as counselor of this kingdom, I rule as follows: The Brant family shall provide 20 heads of cattle to Letow as reparation. This does not undo decades of injustice, but it is what the law allows me to enforce today.\n\nReturn to Lady Lara and inform her of my decision.");
        cvFF7b.addOptionText(PORTUGUESE, "Aqui está o contrato original.", "[Ela lê com atenção]\n\nIsso é profundamente perturbador. Veja a cláusula sete — a tinta é visivelmente diferente do restante do documento, e a caligrafia não corresponde. Essa cláusula não fazia parte do acordo original. Foi adicionada depois que Lorde Den já havia assinado.\n\nIsso é uma falsificação. Sir Martyn Brant falsificou um acordo real de terras.\n\nPela autoridade que me é investida como conselheira deste reino, determino o seguinte: A família Brant fornecerá 20 cabeças de gado a Letow como reparação. Isso não desfaz décadas de injustiça, mas é o que a lei me permite aplicar hoje.\n\nRetorne a Lady Lara e informe-a da minha decisão.");
        cvFF7b.addOptionText(SPANISH, "Aquí está el contrato original.", "[Ella lee con atención]\n\nEsto es profundamente perturbador. Mira la cláusula siete: la tinta es visiblemente diferente del resto del documento, y la letra no coincide. Esta cláusula no formaba parte del acuerdo original. Fue añadida después de que Lord Den ya había firmado.\n\nEsto es una falsificación. Sir Martyn Brant falsificó un acuerdo real de tierras.\n\nPor la autoridad que me es otorgada como consejera de este reino, dictamino lo siguiente: La familia Brant proporcionará 20 cabezas de ganado a Letow como reparación. Esto no deshace décadas de injusticia, pero es lo que la ley me permite aplicar hoy.\n\nRegresa a Lady Lara e infórmala de mi decisión.");
        cvFF7b.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.OLD_BRANT_CONTRACT, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.FALKER_FAMILY, 7, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFF7b);

        // ========================================
        // QUEST: BRANT_FAMILY — PART 6
        // ========================================

        ConversationOption cvBrF6 = new ConversationOption(0, 130);
        cvBrF6.addOptionText(ENGLISH, "Lady Jade, I bring evidence of Lord Den Falker's illegal dealings.", "*She looks at you in shock*\nLord Den involved in illegal dealings? What are you talking about, [GENDER_FORMAL_CALL]? This is very serious.");
        cvBrF6.addOptionText(PORTUGUESE, "Lady Jade, trago evidências dos negócios ilegais de Lorde Den Falker.", "*Ela te olha com espanto*\nLord Den com negócios ilegais? Do que está falando [GENDER_FORMAL_CALL]? Isso é muito sério.");
        cvBrF6.addOptionText(SPANISH, "Lady Jade, traigo evidencia de los tratos ilegales de Lord Den Falker.", "*Ella te mira con asombro*\n¿Lord Den involucrado en negocios ilegales? ¿De qué estás hablando, [GENDER_FORMAL_CALL]? Esto es muy serio.");
        cvBrF6.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANT_FAMILY, 6)
                    && LibInventory.checkHasItem(ItemsIds.FALKER_APOLOGY_LETTER, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvBrF6);

        ConversationOption cvBrF6a = new ConversationOption(130, 131);
        cvBrF6a.addOptionText(ENGLISH, "[Tell what you know]", "[She looks even more shocked]\n\nBandits from Swamp Island... illegal commercial operations... This is unbelievable, a great disappointment.\n\nLord Den has been operating in the shadows for far too long. Show me what you have.");
        cvBrF6a.addOptionText(PORTUGUESE, "[Contar o que sabe]", "[Ela fica ainda mais espantada]\n\nBandidos da Ilha do Pântano... operações comerciais ilegais... Isso é inacreditável, uma decepção.\n\nLorde Den tem operado nas sombras por tempo demais. Mostre-me o que tem.");
        cvBrF6a.addOptionText(SPANISH, "[Contar lo que sabes]", "[Ella se queda aún más conmocionada]\n\nBandidos de la Isla del Pantano... operaciones comerciales ilegales... Esto es increíble, una gran decepción.\n\nLord Den ha estado operando en las sombras por demasiado tiempo. Muéstrame lo que tienes.");
        npc.conversationOptions.add(cvBrF6a);

        ConversationOption cvBrF6b = new ConversationOption(131, 0);
        cvBrF6b.addOptionText(ENGLISH, "Lord Den has written an apology letter. He confesses to the dealings.", "[She reads the apology letter]\n\nA confession. That simplifies matters.\n\n[She sets the letter down]\n\nBy the authority vested in me as counselor of this kingdom, I rule as follows: Lord Den Falker must immediately cease all illegal operations with the Swamp Island bandits. Any further violations will result in imprisonment and seizure of his lands.\n\nHowever, in light of his confession and willingness to cooperate, I will not pursue harsher punishment at this time. The Falker family has suffered enough already.\nHe will be notified by a messenger shortly.");
        cvBrF6b.addOptionText(PORTUGUESE, "Lorde Den escreveu uma carta de desculpas. Ele confessa os negócios.", "[Ela lê a carta de desculpas]\n\nUma confissão. Isso simplifica as coisas.\n\n[Ela coloca a carta na mesa]\n\nPela autoridade que me é investida como conselheira deste reino, determino o seguinte: Lorde Den Falker deve cessar imediatamente todas as operações ilegais com os bandidos da Ilha do Pântano. Quaisquer violações adicionais resultarão em prisão e apreensão de suas terras.\n\nNo entanto, à luz de sua confissão e disposição para cooperar, não buscarei punição mais severa no momento. A família Falker já sofreu o suficiente.\nEle será notificado por um mensageiro em breve.");
        cvBrF6b.addOptionText(SPANISH, "Lord Den ha escrito una carta de disculpa. Confiesa los tratos.", "[Ella lee la carta de disculpa]\n\nUna confesión. Eso simplifica las cosas.\n\n[Deja la carta sobre la mesa]\n\nPor la autoridad que me es otorgada como consejera de este reino, dictamino lo siguiente: Lord Den Falker debe cesar inmediatamente todas las operaciones ilegales con los bandidos de la Isla del Pantano. Cualquier violación adicional resultará en encarcelamiento y confiscación de sus tierras.\n\nSin embargo, a la luz de su confesión y disposición para cooperar, no buscaré un castigo más severo en este momento. La familia Falker ya ha sufrido suficiente.\nEn breve recibirá una notificación por medio de un mensajero.");
        cvBrF6b.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.FALKER_APOLOGY_LETTER, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.BRANT_FAMILY, 7, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBrF6b);

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Who are you?", "I am Jade Wintar, counselor of the kingdom, sister of the honorable lords Markus, Mukas and Mathew Wintar.");
        cv1.addOptionText(PORTUGUESE, "Quem é você?", "Eu sou Jade Wintar, conselheira do reino, irmã dos honoráveis senhores Markus, Mukas e Mathew Wintar.");
        cv1.addOptionText(SPANISH, "¿Quién es usted?", "Soy Jade Wintar, consejera del reino, hermana de los honorables señores Markus, Mukas y Mathew Wintar.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv0 = new ConversationOption(0, 0);
        cv0.addOptionText(ENGLISH, "What is your relationship with the queen?", "My husband was Oriun Lysnes, the king. Therefore, you should know that I am the mother of Enola, the queen. Enola assumed the throne after her father's death. By order, I should have taken over, but I did not feel comfortable nor young enough for such a task, so I renounced and let my daughter rule, given her immense competence.");
        cv0.addOptionText(PORTUGUESE, "Qual sua relação com a rainha?", "Meu marido foi Oriun Lysnes, o rei. Portanto deves de saber que sou mãe de Enola, a rainha. Enola assumiu o reinado após a morte do pai. Pela ordem eu quem deveria assumir, mas não me senti a vontade e nem mais com idade para tal, por isso renunciei e deixei que minha filha governasse, dada a sua enorme competência.");
        cv0.addOptionText(SPANISH, "¿Cuál es su relación con la reina?", "Mi esposo fue Oriun Lysnes, el rey. Por lo tanto, debes saber que soy la madre de Enola, la reina. Enola asumió el trono después de la muerte de su padre. Por orden, yo debería haber tomado el mando, pero no me sentí cómoda ni lo suficientemente joven para tal tarea, así que renuncié y dejé que mi hija gobernara, dada su inmensa competencia.");
        npc.conversationOptions.add(cv0);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "What is your job?", "I am counselor to our Majesty, Queen Enola. I listen to the people and to the queen, and from that, I think and advise the best solutions for our kingdom.");
        cv2.addOptionText(PORTUGUESE, "Qual é o seu trabalho?", "Sou conselheira de vossa majestade, rainha Enola. Escuto o povo e escuto a rainha, a partir disso penso e aconselho as melhores soluções para nosso reino.");
        cv2.addOptionText(SPANISH, "¿Cuál es su trabajo?", "Soy consejera de Su Majestad, la reina Enola. Escucho al pueblo y a la reina, y a partir de eso, pienso y aconsejo las mejores soluciones para nuestro reino.");
        npc.conversationOptions.add(cv2);

        return npc;
    }
}

