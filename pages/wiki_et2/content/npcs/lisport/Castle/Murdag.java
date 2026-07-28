package com.cnx.endlesstalestwo.data.npcs.lisport.Castle;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.cnxgameengine.utils.LibUtils;
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

public class Murdag extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    final static String QUEST_CATTLE_BUSINESS_CURRENT_VILLAGE = "QUEST_CATTLE_BUSINESS_VILLAGE";
    
    Npc npc() {
        Npc npc = new Npc("Murdag");
        npc.age = 52;
        npc.job = Enums.NPCJobs.COUNSELOR;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A veteran administrator of the Lisport Castle. Murdag has seen many moments and many crises, always maintaining a cold, efficient demeanor\nproactive and serious.\n\nHis physical traits: Receding grey hair, sharp blue eyes behind small spectacles, and a neatly trimmed goatee. He wears fine but practical robes of navy blue.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um administrador veterano do Castelo de Lisport. Murdag viu muitos momentos e muitas crises, sempre mantendo um comportamento frio e eficiente.\nProativo e sério.\n\nSeus traços físicos: Cabelo grisalho ralo, olhos azuis penetrantes atrás de pequenos óculos e um cavanhaque bem aparado. Ele usa vestes finas, mas práticas, em azul marinho.");
        npc.addDescriptionTranslation(SPANISH, "Un administrador veterano del Castillo de Lisport. Murdag ha visto muchos momentos y muchas crisis, siempre manteniendo un comportamiento frío e eficiente.\n\nSus rasgos físicos: Cabello gris ralo, olhos azuis penetrantes tras unos pequeños anteojos y una perilla pulcramente recortada. Viste túnicas finas pero prácticas de color azul marino.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("The kingdom's logistics never rest. What is your business here?"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("A logística do reino nunca descansa. Qual é o seu assunto aqui?"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("La logística del reino nunca descansa. ¿Cuál es su asunto aquí?"));

        npc.generateRandomByes();

        // Roleplay 1
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "You look like someone who knows every corner of this castle.", "I know every record, every shipment, and every silver coin that enters these walls. Knowledge is the foundation of a stable kingdom, young one.");
        cv1.addOptionText(PORTUGUESE, "Você parece alguém que conhece cada canto deste castelo.", "Conheço cada registro, cada remessa e cada moeda de prata que entra nestas paredes. O conhecimento é a base de um reino estável, jovem.");
        cv1.addOptionText(SPANISH, "Parece alguien que conoce cada rincón de este castillo.", "Conozco cada registro, cada cargamento y cada moneda de plata que entra en estos muros. El conocimiento es la base de un reino estable, joven.");
        npc.conversationOptions.add(cv1);

        // Roleplay 2
        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Is Lisport currently facing any shortages?", "Trade is a delicate balance. With the recent tensions, we must be vigilant about our food supplies. Cattle, in particular, is a resource we cannot afford to lose.");
        cv2.addOptionText(PORTUGUESE, "Lisport está enfrentando alguma escassez no momento?", "O comércio é um equilíbrio delicado. Com as recentes tensões, devemos estar vigilantes sobre nossos suprimentos de comida. O gado, em particular, é um recurso que não podemos nos dar ao luxo de perder.");
        cv2.addOptionText(SPANISH, "¿Lisport se enfrenta actualmente a alguna escasez?", "El comercio es un equilibrio delicado. Con las tensiones recientes, debemos estar atentos a nuestros suministros de alimentos. El ganado, en particular, es un recurso que no podemos permitirnos perder.");
        npc.conversationOptions.add(cv2);

        // ========================================
        // QUEST: CATTLE BUSINESS
        // ========================================

        // Start path (after King Oliver's introduction, player is at part 1)
        ConversationOption cvQuestIntro = new ConversationOption(0, 1);
        cvQuestIntro.addOptionText(ENGLISH, "King Oliver told me to talk to you about the cattle shortage.", "Indeed. Lisport is facing a cattle shortage, and grains are in abundance here. I need to negotiate with other cities to get more cattle for the best price, in exchange for grains.");
        cvQuestIntro.addOptionText(PORTUGUESE, "O Rei Oliver me disse para falar com você sobre a escassez de gado.", "De fato. Lisport está com escassez de gado, e grãos estão em abundância aqui. Preciso negociar com outras cidades para conseguir mais gado pelo melhor preço, em troca de grãos.");
        cvQuestIntro.addOptionText(SPANISH, "El Rey Oliver me dijo que hablara con usted sobre la escasez de ganado.", "Así es. Lisport tem escasez de ganado, y aquí abundan los cereales. Necesito negociar con otras ciudades para conseguir más ganado al mejor precio, a cambio de granos.");
        cvQuestIntro.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CATTLE_BUSINESS, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestIntro);

        // Randomize Village 1 (Part 1 -> 21, 22, 23, 24)
        ConversationOption cvGetLead1 = new ConversationOption(1, 0);
        cvGetLead1.addOptionText(ENGLISH, "Where should I go first?", "I have several potential leads. Here is the first one. Go to the village and speak with the producer. I've updated your journal with the location.");
        cvGetLead1.addOptionText(PORTUGUESE, "Onde devo ir primeiro?", "Tenho várias pistas potenciais. Aqui está a primeira. Vá até a vila e fale com o produtor. Atualizei seu diário com a localização.");
        cvGetLead1.addOptionText(SPANISH, "¿A dónde debo ir primero?", "Tengo várias pistas potenciales. Aquí está la primera. Ve a la aldea y habla con el productor. He actualizado tu diario con la ubicación.");
        cvGetLead1.listeners = (ctx, currentFragment) -> {
            int roll = LibUtils.getRandom(1, 4);
            int nextPart = (roll == 1) ? 21 : (roll == 2) ? 22 : (roll == 3) ? 23 : 24;

            // Store the first village ID to avoid repeating it later
            App.getPlayerChar().storyInfo.addSwitch(Enums.GameplayVariables.QUESTS, QUEST_CATTLE_BUSINESS_CURRENT_VILLAGE, (float)roll);
            LibQuest.updateQuest(QuestsIds.CATTLE_BUSINESS, nextPart, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvGetLead1);

        // Report failure and randomize success village (Part 30 -> 31, 32, 33, 34)
        ConversationOption cvReportFail = new ConversationOption(0, 2);
        cvReportFail.addOptionText(ENGLISH, "The negotiation failed. The terms were not good enough.", "Disappointing. I'll authorize offering a bit more grain. But we should try another village to ensure success this time.");
        cvReportFail.addOptionText(PORTUGUESE, "A negociação falhou. Os termos não foram bons o suficiente.", "Decepcionante. Vou autorizar a oferta de um pouco mais de grãos. Mas devemos tentar outra vila para garantir o sucesso desta vez.");
        cvReportFail.addOptionText(SPANISH, "La negociación fracasó. Los términos no fueron lo suficientemente buenos.", "Decepcionante. Autorizaré ofrecer un poco más de grano. Pero deberíamos intentar en otra aldea para asegurar el éxito esta vez.");
        cvReportFail.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CATTLE_BUSINESS, 30)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvReportFail);

        ConversationOption cvGetLead2 = new ConversationOption(2, 0);
        cvGetLead2.addOptionText(ENGLISH, "Which village should I visit now?", "I've reviewed the records. This next location is a much better prospect. The details are in your journal. Do not fail Lisport again.");
        cvGetLead2.addOptionText(PORTUGUESE, "Qual vila devo visitar agora?", "Revisei os registros. Esta próxima localização é uma perspectiva muito melhor. Os detalhes estão no seu diário. Não falhe com Lisport novamente.");
        cvGetLead2.addOptionText(SPANISH, "¿Qué aldea debo visitar ahora?", "He revisado los registros. Esta próxima ubicación es um prospecto mucho mejor. Los detalles están en tu diario. No vuelvas a fallarle a Lisport.");
        cvGetLead2.listeners = (ctx, currentFragment) -> {
            Float firstVillageVal = App.getPlayerChar().storyInfo.variables.get(Enums.GameplayVariables.QUESTS).getSwitchValue(QUEST_CATTLE_BUSINESS_CURRENT_VILLAGE);
            int firstVillage = firstVillageVal != null ? Math.round(firstVillageVal) : 0;
            
            int roll = LibUtils.getRandom(1, 4);
            while (roll == firstVillage) {
                roll = LibUtils.getRandom(1, 4);
            }
            
            int nextPart = (roll == 1) ? 31 : (roll == 2) ? 32 : (roll == 3) ? 33 : 34;
            LibQuest.updateQuest(QuestsIds.CATTLE_BUSINESS, nextPart, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvGetLead2);

        // Final Delivery (Part 40 -> 50)
        ConversationOption cvComplete = new ConversationOption(0, 0);
        cvComplete.addOptionText(ENGLISH, "I have the signed contract, here.", "Excellent work! This will secure our food supply. Whenever you want, we can make good negotiations like this again.");
        cvComplete.addOptionText(PORTUGUESE, "Tenho o contrato assinado, aqui.", "Excelente trabalho! Isso garantirá nosso suprimento de comida. Sempre que quiser, podemos fazer boas negociações assim novamente.");
        cvComplete.addOptionText(SPANISH, "Tengo el contrato firmado, aquí.", "¡Excelente trabajo! Esto asegurará nuestro suministro de alimentos. Cuando quiera, podemos volver a entablar buenas negociaciones como ésta.");
        cvComplete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CATTLE_BUSINESS, 40) && LibInventory.checkHasItem(ItemsIds.CONTRACT_OF_CATTLE_NEGOTIATION, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvComplete.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.CONTRACT_OF_CATTLE_NEGOTIATION, 1, App.getPlayerChar());
            App.getPlayerChar().storyInfo.removeSwitch(Enums.GameplayVariables.QUESTS, QUEST_CATTLE_BUSINESS_CURRENT_VILLAGE);
            LibQuest.completeQuest(QuestsIds.CATTLE_BUSINESS, App.getPlayerChar(), 50, ctx);
        };
        npc.conversationOptions.add(cvComplete);

        // ========================================
        // QUEST: AWAITING THE DRAGONS
        // ========================================

        // Part 4: Talk to Murdag (Initial Warning)
        ConversationOption cvAwaitingDragons4Start = new ConversationOption(0, 100);
        cvAwaitingDragons4Start.addOptionText(ENGLISH, "I've come to warn you. Dragons have been spotted migrating towards Havarus.",
                "*He pushes his spectacles up his nose, peering at you with a sharp, calculating gaze as he processes the news*\nDragons? If the reports are true, then the risk to Lisport's trade routes and the surrounding mountains is undeniable. A single attack on a merchant ship could cripple our economy for months.");
        cvAwaitingDragons4Start.addOptionText(PORTUGUESE, "Vim avisá-lo. Dragões foram avistados migrando para Havarus.",
                "*Ele empurra os óculos no nariz, observando você com um olhar aguçado e calculista enquanto processa a notícia*\nDragões? Se os relatos forem verdadeiros, então o risco para as rotas comerciais de Lisport e as montanhas circundantes é inegável. Um único ataque a um navio mercante poderia paralisar nossa economia por meses.");
        cvAwaitingDragons4Start.addOptionText(SPANISH, "He venido a avisarle. Se han avistado dragones migrando hacia Havarus.",
                "*Se sube las gafas, mirándole con una mirada aguda y calculadora mientras procesa la noticia*\n¿Dragones? Si los informes son ciertos, entonces el riesgo para las rutas comerciales de Lisport y las montañas circundantes es innegable. Un solo ataque a un barco mercante podría paralizar nuestra economía durante meses.");
        cvAwaitingDragons4Start.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.AWAITING_THE_DRAGONS, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAwaitingDragons4Start);

        ConversationOption cvAwaitingDragons4Action = new ConversationOption(100, 10);
        cvAwaitingDragons4Action.addOptionText(ENGLISH, "What will you do?",
                "I will notify the King and ensure the harbor guards and mountain scouts are on high alert. We must prepare our defenses before the shadows reach our shores. \n\nSince you're here and seem capable, I could use your help with a related matter. We have a weapon shipment arriving at the harbor that needs to be delivered to the barracks urgently. If you assist us, I'll ensure you're compensated for your time and efforts. What say you?");
        cvAwaitingDragons4Action.addOptionText(PORTUGUESE, "O que você vai fazer?",
                "Notificarei o Rei e garantirei que os guardas do porto e os batedores das montanhas estejam em alerta máximo. Devemos preparar nossas defesas antes que as sombras cheguem às nossas costas. \n\nJá que você está aqui e parece capaz, eu poderia usar sua ajuda em um assunto relacionado. Temos uma remessa de armas chegando ao porto que precisa ser entregue ao quartel com urgência. Se você nos ajudar, garantirei que seja compensado pelo seu tempo e esforços. O que me diz?");
        cvAwaitingDragons4Action.addOptionText(SPANISH, "¿Qué va a hacer?",
                "Notificaré al Rey y me aseguraré de que los guardias del puerto y los exploradores de las montañas estén en alerta máxima. Debemos preparar nuestras defensas antes de que las sombras lleguen a nuestras costas. \n\nYa que está aquí y parece capaz, me vendría bien su ayuda en un asunto relacionado. Tenemos un cargamento de armas llegando al puerto que debe ser entregado al cuartel urgentemente. Si nos ayuda, me aseguraré de que sea compensado por su tiempo y sus esfuerzos. ¿Qué me dice?");
        npc.conversationOptions.add(cvAwaitingDragons4Action);

        ConversationOption cvAwaitingDragons4Accept = new ConversationOption(10, 0);
        cvAwaitingDragons4Accept.addOptionText(ENGLISH, "I'll help with the weapons.", "Good. Go to the harbor and speak with Joggard. He'll give you the crate. Take it to Lenny at the barracks. I'll be waiting for word of its arrival.");
        cvAwaitingDragons4Accept.addOptionText(PORTUGUESE, "Eu ajudo com as armas.", "Bom. Vá ao porto e fale com Joggard. Ele lhe entregará a caixa. Leve-a para Lenny no quartel. Estarei aguardando notícias de sua chegada.");
        cvAwaitingDragons4Accept.addOptionText(SPANISH, "Ayudaré con las armas.", "Bien. Ve al puerto y habla con Joggard. Él te entregará la caja. Llévala a Lenny al cuartel. Estaré esperando noticias de su llegada.");
        cvAwaitingDragons4Accept.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(QuestsIds.AWAITING_THE_DRAGONS, 5, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvAwaitingDragons4Accept);

        ConversationOption cvAwaitingDragons4Refuse = new ConversationOption(10, 0);
        cvAwaitingDragons4Refuse.addOptionText(ENGLISH, "I'm sorry, I must return to Havarus immediately.", "I understand. Your warnings have been valuable enough. I'll handle the logistics here. Safe travels, [GENDER_FORMAL_CALL].");
        cvAwaitingDragons4Refuse.addOptionText(PORTUGUESE, "Sinto muito, devo retornar a Havarus imediatamente.", "Eu entendo. Seus avisos já foram valiosos o suficiente. Cuidarei da logística aqui. Boa viagem, [GENDER_FORMAL_CALL].");
        cvAwaitingDragons4Refuse.addOptionText(SPANISH, "Lo siento, debo regresar a Havarus inmediatamente.", "Entiendo. Tus advertencias ya han sido lo suficientemente valiosas. Yo me encargaré de la logística aquí. Buen viaje, [GENDER_FORMAL_CALL].");
        cvAwaitingDragons4Refuse.listeners = (ctx, currentFragment) -> LibQuest.completeQuest(QuestsIds.AWAITING_THE_DRAGONS, App.getPlayerChar(), 7, ctx);
        npc.conversationOptions.add(cvAwaitingDragons4Refuse);

        return npc;
    }
}
