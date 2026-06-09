package com.cnx.endlesstalestwo.data.npcs.esperand.cityHall;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.KINGDOMS_CUP;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.R;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.houses.HousesIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class LordMukasWintar extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Lord Mukas Wintar");
        npc.age = 43;
        npc.job = Enums.NPCJobs.GOVERNOR;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A natural leader, he has governed Esperand with precision for a long time.\nHe has affinity with all his people. Very creative in dealing with problems. Enthusiastic about change.\n\nHis physical traits: Short blond hair combed to the side. Blue eyes. Thin beard and a well-defined face.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um líder nato, comanda Esperand há tempo com precisão.\nTem afinidade com todo o povo. Muito criativo para lidar com problemas. Entusiasmado com mudanças.\n\nSeus traços físicos: Cabelo loiro, curto penteado para o lado. Olhos azuis. Barba rala e rosto bem definido.");
        npc.addDescriptionTranslation(SPANISH, "Un líder nato, gobierna Esperand desde hace tiempo con precisión.\nTiene afinidad con todo su pueblo. Muy creativo para lidiar con problemas. Entusiasmado con los cambios.\n\nSus rasgos físicos: Cabello rubio, corto y peinado de lado. Ojos azules. Barba fina y rostro bien definido.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Welcome to Esperand. How may I assist you?"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bem-vindo a Esperand. Como posso ajudá-lo?"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Bienvenido a Esperand. ¿Cómo puedo ayudarte?"));

        npc.generateRandomByes();

        // ===== ROLEPLAY: About his work =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "What is it like governing Esperand?", "Governing Esperand is unique. We maintain semi-independence while respecting Havarus's sovereignty - it's a delicate balance. Our people are hardy, adapted to the cold, and fiercely proud of our identity. The monastery adds a spiritual dimension to our culture that I deeply value. It's challenging work, but rewarding.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Como é governar Esperand?", "Governar Esperand é único. Mantemos semi-independência enquanto respeitamos a soberania de Havarus - é um equilíbrio delicado. Nosso povo é resistente, adaptado ao frio e ferozmente orgulhoso de nossa identidade. O monastério adiciona uma dimensão espiritual à nossa cultura que valorizo profundamente. É um trabalho desafiador, mas gratificante.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cómo es gobernar Esperand?", "Gobernar Esperand es único. Mantenemos semi-independencia mientras respetamos la soberanía de Havarus: es un equilibrio delicado. Nuestra gente es resistente, adaptada al frío y ferozmente orgullosa de nuestra identidad. El monasterio añade una dimensión espiritual a nuestra cultura que valoro profundamente. Es un trabajo desafiante, pero gratificante.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY: About the Wintar family =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Tell me about your family.", "The Wintars serve throughout the kingdom. My siblings Markus, Mathew, and Jade each hold important positions. Markus governs Bastian, Mathew leads Helera, and our sister Jade is royal advisor to Queen Enola - her own daughter. We're a family dedicated to service and unity across the realm.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Fale sobre sua família.", "Os Wintar servem por todo o reino. Meus irmãos Markus, Mathew e Jade ocupam posições importantes. Markus governa Bastian, Mathew lidera Helera, e nossa irmã Jade é conselheira real da Rainha Enola - sua própria filha. Somos uma família dedicada ao serviço e à unidade em todo o reino.");
        cvRoleplay2.addOptionText(SPANISH, "Háblame de tu familia.", "Los Wintar sirven en todo el reino. Mis hermanos Markus, Mathew y Jade ocupan posiciones importantes. Markus gobierna Bastian, Mathew lidera Helera, y nuestra hermana Jade es asesora real de la Reina Enola, su propia hija. Somos una familia dedicada al servicio y la unidad en todo el reino.");
        npc.conversationOptions.add(cvRoleplay2);

        // ===== QUEST: Patrolman - Part 1 =====
        ConversationOption cvPatrolmanPart1 = new ConversationOption(0, 30);
        cvPatrolmanPart1.addOptionText(ENGLISH, "Vinny asked me to report to you about threats around Esperand.", "Vinny was wise to send you. Esperand looks calm, but patrol duty has increased because there are dangers around the region.\nIf you are interested, we can assign you where patrol is needed.");
        cvPatrolmanPart1.addOptionText(PORTUGUESE, "Vinny pediu para eu me apresentar a você sobre as ameaças ao redor de Esperand.", "Vinny foi sábio em te enviar. Esperand parece calma, mas o trabalho de patrulha aumentou porque há perigos pela região.\nSe você tiver interesse, podemos te designar para onde a patrulha é necessária.");
        cvPatrolmanPart1.addOptionText(SPANISH, "Vinny me pidió que hablara contigo sobre las amenazas alrededor de Esperand.", "Vinny fue sabio al enviarte. Esperand parece tranquila, pero el trabajo de patrulla ha aumentado porque hay peligros en la región.\nSi te interesa, podemos asignarte donde se necesita patrulla.");
        cvPatrolmanPart1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PATROLMAN, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPatrolmanPart1);

        ConversationOption cvPatrolmanPart1Assign = new ConversationOption(30, 0);
        cvPatrolmanPart1Assign.addOptionText(ENGLISH, "Understood. Give me the patrol assignment.", "Good. I will write the destination in your quest journal. Check it to know where patrol is needed. Good work, and good luck.");
        cvPatrolmanPart1Assign.addOptionText(PORTUGUESE, "Entendido. Me dê a missão de patrulha.", "Ótimo. Vou escrever o destino no seu diário de missões. Verifique-o para saber onde a patrulha é necessária. Bom trabalho e boa sorte.");
        cvPatrolmanPart1Assign.addOptionText(SPANISH, "Entendido. Dame la asignación de patrulla.", "Bien. Escribiré el destino en tu diario de misiones. Revísalo para saber dónde se necesita patrulla. Buen trabajo y buena suerte.");
        cvPatrolmanPart1Assign.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PATROLMAN, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPatrolmanPart1Assign.listeners = (ctx, currentFragment) -> {
            int roll = LibUtils.getRandom(1, 2);
            int nextPart = (roll == 1) ? 21 : 22;
            LibQuest.updateQuest(QuestsIds.PATROLMAN, nextPart, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPatrolmanPart1Assign);

        ConversationOption cvPatrolmanPart1Decline = new ConversationOption(30, 0);
        cvPatrolmanPart1Decline.addOptionText(ENGLISH, "I need a moment before heading out.", "Take only a short moment. Every delay gives danger more room to spread through our roads.");
        cvPatrolmanPart1Decline.addOptionText(PORTUGUESE, "Preciso de um momento antes de sair.", "Tome apenas um breve momento. Cada atraso dá mais espaço para o perigo se espalhar por nossas estradas.");
        cvPatrolmanPart1Decline.addOptionText(SPANISH, "Necesito un momento antes de salir.", "Tómate solo un momento breve. Cada retraso le da más espacio al peligro para propagarse por nuestros caminos.");
        cvPatrolmanPart1Decline.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PATROLMAN, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPatrolmanPart1Decline);

        // ===== QUEST: Kingdoms Cup - Part 5 =====
        ConversationOption cvKingdomsCup1 = new ConversationOption(0, 1);
        cvKingdomsCup1.addOptionText(ENGLISH, "A young man is organizing a sporting tournament between all cities and kingdoms.", "A sporting tournament?\n\n*Looks intrigued*\n\nThat's an interesting proposition. What sport, specifically? And which cities and kingdoms have shown interest?");
        cvKingdomsCup1.addOptionText(PORTUGUESE, "Um jovem está organizando um torneio esportivo entre todas as cidades e reinos.", "Um torneio esportivo?\n\n*Parece intrigado*\n\nEssa é uma proposta interessante. Qual esporte, especificamente? E quais cidades e reinos demonstraram interesse?");
        cvKingdomsCup1.addOptionText(SPANISH, "Un joven está organizando un torneo deportivo entre todas las ciudades y reinos.", "¿Un torneo deportivo?\n\n*Parece intrigado*\n\nEsa es una propuesta interesante. ¿Qué deporte, específicamente? ¿Y qué ciudades y reinos han mostrado interés?");
        cvKingdomsCup1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, KINGDOMS_CUP, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvKingdomsCup1);

        ConversationOption cvKingdomsCup2 = new ConversationOption(1, 0);
        cvKingdomsCup2.addOptionText(ENGLISH, "Mob Ball! Markus, Jade, Oliver, and Mathew have all accepted.", "*Smiles warmly*\n\nMob Ball! An excellent choice - it's thrilling and brings out the best competitive spirit in people. And all my siblings plus King Oliver have agreed? This is remarkable!\n\n*Stands and extends his hand*\n\nA tournament uniting all our cities and kingdoms in friendly sport - Bastian, Monelix, Helera, Lisport, and Esperand competing together. This will strengthen bonds and give our people joy. Esperand proudly accepts! Tell the organizer that Lord Mukas Wintar and all of Esperand stand with this Kingdoms Cup!");
        cvKingdomsCup2.addOptionText(PORTUGUESE, "Mob Ball! Markus, Jade, Oliver e Mathew aceitaram.", "*Sorri calorosamente*\n\nMob Ball! Uma excelente escolha - é emocionante e traz o melhor espírito competitivo nas pessoas. E todos meus irmãos mais o Rei Oliver concordaram? Isso é notável!\n\n*Levanta-se e estende a mão*\n\nUm torneio unindo todas nossas cidades e reinos em esporte amigável - Bastian, Monelix, Helera, Lisport e Esperand compitiendo juntos. Isso fortalecerá laços e dará alegria ao nosso povo. Esperand aceita com orgulho! Diga ao organizador que Lorde Mukas Wintar e toda Esperand apoiam esta Copa dos Reinos!");
        cvKingdomsCup2.addOptionText(SPANISH, "¡Mob Ball! Markus, Jade, Oliver y Mathew han aceptado.", "*Sonríe calurosamente*\n\n¡Mob Ball! Una excelente elección: es emocionante y saca el mejor espíritu competitivo de la gente. ¿Y todos mis hermanos más el Rey Oliver han aceptado? ¡Esto es notable!\n\n*Se levanta y extiende la mano*\n\nUn torneo que une todas nuestras ciudades y reinos en deporte amistoso: Bastian, Monelix, Helera, Lisport y Esperand compitiendo juntos. Esto fortalecerá lazos y dará alegría a nuestro pueblo. ¡Esperand acepta con orgullo! ¡Dile al organizador que Lord Mukas Wintar y toda Esperand apoyan esta Copa de los Reinos!");
        cvKingdomsCup2.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(KINGDOMS_CUP, 6, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvKingdomsCup2);

        // ===== HOUSING: Buy house in Esperand =====
        ConversationOption cvHouseStart = new ConversationOption(0, 20);
        cvHouseStart.addOptionText(ENGLISH, "I would like to live in Esperand.", "That would be an honor. You have already proven yourself to the Crown, and Esperand always welcomes people of worth. As fortune would have it, there is a fine cozy house available in the city. The deed can be yours for 45 gold coins and 3 gems.");
        cvHouseStart.addOptionText(PORTUGUESE, "Eu gostaria de viver em Esperand.", "Isso seria uma honra. Você já provou seu valor à Coroa, e Esperand sempre acolhe pessoas de mérito. Por sorte, há uma boa moradia confortável disponível na cidade. A escritura pode ser sua por 45 moedas de ouro e 3 gemas.");
        cvHouseStart.addOptionText(SPANISH, "Me gustaria vivir en Esperand.", "Seria un honor. Ya has demostrado tu valor ante la Corona, y Esperand siempre recibe a personas de merito. Por fortuna, hay una buena vivienda acogedora disponível en la ciudad. La escritura puede ser tuya por 45 moedas de oro y 3 gemas.");
        cvHouseStart.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.isQuestComplete(chara, QuestsIds.RIOT_CONTROL) || chara.ownsHouse(HousesIds.COZY_HOME)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cvHouseStart);

        ConversationOption cvHouseBuy = new ConversationOption(20, 0);
        cvHouseBuy.addOptionText(ENGLISH, "I will buy it. [45 gold & 3 Gems]", "Excellent. I will have the deed prepared at once. May this home serve you well through many winters in Esperand.");
        cvHouseBuy.addOptionText(PORTUGUESE, "Eu vou compra-la. [45 ouro & 3 Gemas]", "Excelente. Providenciarei a escritura imediatamente. Que esse lar lhe sirva bem por muitos invernos em Esperand.");
        cvHouseBuy.addOptionText(SPANISH, "La comprare. [45 oro & 3 Gemas]", "Excelente. Hare preparar la escritura de inmediato. Que este hogar te sirva bien durante muitos inviernos em Esperand.");
        cvHouseBuy.requirementValidations = (chara, ctx) -> {
            if (!chara.ownsHouse(HousesIds.COZY_HOME) && chara.checkHasGold(45) && App.Shell.getAccount().getGems() >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvHouseBuy.listeners = (ctx, currentFragment) -> {
            if (!App.getPlayerChar().ownsHouse(HousesIds.COZY_HOME)) {
                App.getPlayerChar().removeGold(45);
                App.Shell.getAccount().removeGems(3);
                App.getPlayerChar().addOwnedHouse(HousesIds.COZY_HOME);
                LibUtils.showToast(LibUtils.getString(R.string.houseBought, ctx), 1, CoreEnums.MessageType.SUCCESS, ctx);
                currentFragment.updateTopDisplay();
                App.Shell.saveGame(ctx);
            }
        };
        npc.conversationOptions.add(cvHouseBuy);

        ConversationOption cvHouseNoMoney = new ConversationOption(20, 0);
        cvHouseNoMoney.addOptionText(ENGLISH, "I do not have enough yet.", "Then return when you are ready. A proper home in Esperand is worth waiting for.");
        cvHouseNoMoney.addOptionText(PORTUGUESE, "Ainda nao tenho o bastante.", "Entao retorne quando estiver pronto. Um bom lar em Esperand vale a espera.");
        cvHouseNoMoney.addOptionText(SPANISH, "Aun no tengo lo suficiente.", "Entonces regresa cuando estes listo. Un buen hogar en Esperand vale la espera.");
        cvHouseNoMoney.requirementValidations = (chara, ctx) -> {
            if (!chara.ownsHouse(HousesIds.COZY_HOME) && (!chara.checkHasGold(45) || App.Shell.getAccount().getGems() < 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvHouseNoMoney);

        ConversationOption cvHouseDecline = new ConversationOption(20, 0);
        cvHouseDecline.addOptionText(ENGLISH, "Not now.", "Very well. If you change your mind, the offer remains open.");
        cvHouseDecline.addOptionText(PORTUGUESE, "Agora nao.", "Muito bem. Se mudar de ideia, a oferta continuara aberta.");
        cvHouseDecline.addOptionText(SPANISH, "Ahora no.", "Muy bien. Si cambias de idea, la oferta seguira aberta.");
        npc.conversationOptions.add(cvHouseDecline);

        return npc;
    }
}
