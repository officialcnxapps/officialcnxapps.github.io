package com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.smithersClan;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.knowledges.KnowledgesIds;
import com.cnx.endlesstalestwo.data.quests.CrafterHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Perseus extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Perseus");
        npc.age = 47;
        npc.job = Enums.NPCJobs.MALE_BLACKSMITH;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Works with precision. Prefers quality over quantity.\nHe is highly renowned within the blacksmiths' guild.\n\nHis physical traits: Mustache parted in the middle and a white beard. Light-colored eyes. He wears a large beret.");
        npc.addDescriptionTranslation(PORTUGUESE, "Trabalha com precisão. Prefere qualidade do que quantidade.\nTem grande renome entre a guilda dos ferreiros.\n\nSeus traços físicos: Bigode dividido ao meio e barba branca. Olhos claros. Utiliza uma grande boina.");
        npc.addDescriptionTranslation(SPANISH, "Trabaja con precisión. Prefiere la calidad a la cantidad.\nTiene gran renombre entre el gremio de herreros.\n\nSus rasgos físicos: Bigote dividido al medio y barba blanca. Ojos claros. Utiliza una gran boina.");
        npc.canBePickpocketed = true;

        npc.generateRandomByes();
        npc.generateRandomGreetings();

        // Roleplay conversation
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What do you forge most often?", "Tools first, always. Cities stand on nails, hinges, axes, and horseshoes before they stand on swords. Honest ironwork keeps a place alive.");
        cv1.addOptionText(PORTUGUESE, "O que você forja com mais frequência?", "Ferramentas primeiro, sempre. Cidades se sustentam com pregos, dobradiças, machados e ferraduras antes de se sustentarem com espadas. Ferro honesto mantém um lugar vivo.");
        cv1.addOptionText(SPANISH, "¿Qué forjas con más frecuencia?", "Herramientas primero, siempre. Las ciudades se sostienen con clavos, bisagras, hachas y herraduras antes que con espadas. El hierro honesto mantiene vivo un lugar.");
        npc.conversationOptions.add(cv1);

        // ========================================
        // QUEST: CRAFTER HELPER
        // ========================================

        ConversationOption cvQStart = new ConversationOption(0, 1);
        cvQStart.addOptionText(ENGLISH, "Need a hand with anything, Perseus?",
                "Actually... yes. The prison guards put in an order for new tools — bars, locks, hinges. More than I can forge alone before the deadline.\nI hear you know a thing or two about crafting. Interested in helping?");
        cvQStart.addOptionText(PORTUGUESE, "Precisando de uma ajuda em algo, Perseus?",
                "Na verdade... sim. Os guardas da prisão fizeram um pedido de novas ferramentas — barras, fechaduras, dobradiças. Mais do que posso forjar sozinho antes do prazo.\nOuvi dizer que você sabe um pouco sobre artesanato. Interessado em ajudar?");
        cvQStart.addOptionText(SPANISH, "¿Necesitas una mano con algo, Perseus?",
                "En realidad... sí. Los guardias de la prisión hicieron un pedido de nuevas herramientas — barras, cerraduras, bisagras. Más de lo que puedo forjar solo antes del plazo.\nEscuché que sabes algo sobre artesanía. ¿Interesado en ayudar?");
        cvQStart.requirementValidations = (chara, ctx) -> {
            if (chara.hasKnowledge(KnowledgesIds.CRAFTING)
                    && !LibQuest.charHasQuest(QuestsIds.CRAFTER_HELPER, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQStart);

        ConversationOption cvQAccept = new ConversationOption(1, 0);
        cvQAccept.addOptionText(ENGLISH, "I'll help you. What do you need?",
                "Start by bringing me 3 Coal and 3 Iron Ore. I'll forge everything here and pack it into a crate. Then you'll deliver it to Brinn at the Prison. Simple enough?");
        cvQAccept.addOptionText(PORTUGUESE, "Vou te ajudar. O que você precisa?",
                "Comece trazendo 3 Carvão e 3 Minério de Ferro. Vou forjar tudo aqui e embalar em um caixote. Depois você entrega para Brinn na Prisão. Simples o suficiente?");
        cvQAccept.addOptionText(SPANISH, "Te ayudaré. ¿Qué necesitas?",
                "Empieza trayéndome 3 Carbón y 3 Mineral de Hierro. Forjaré todo aquí y lo empacaré en un cajón. Luego lo entregas a Brinn en la Prisión. ¿Sencillo?");
        cvQAccept.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(CrafterHelper.get(), App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQAccept);

        ConversationOption cvQDecline = new ConversationOption(1, 0);
        cvQDecline.addOptionText(ENGLISH, "Not right now, Perseus.", "Fair enough. Come back when you have time.");
        cvQDecline.addOptionText(PORTUGUESE, "Agora não, Perseus.", "Tudo bem. Volte quando tiver tempo.");
        cvQDecline.addOptionText(SPANISH, "Ahora no, Perseus.", "De acuerdo. Vuelve cuando tengas tiempo.");
        npc.conversationOptions.add(cvQDecline);

        ConversationOption cvQPart1 = new ConversationOption(0, 0);
        cvQPart1.addOptionText(ENGLISH, "Here's the Coal and Iron Ore you needed.",
                "Good, good — quality ore.\n*He takes the materials*\nSo, get this Crate of Tools that is ready for you to take to Brinn while I craft some more for a future batch.");
        cvQPart1.addOptionText(PORTUGUESE, "Aqui está o Carvão e o Minério de Ferro que você precisava.",
                "Bom, bom — minério de qualidade.\n*Ele pega os materiais*\nEntão, pegue este Caixote de Ferramentas que está pronto para levar a Brinn enquanto eu forjo mais para um lote futuro.");
        cvQPart1.addOptionText(SPANISH, "Aquí está el Carbón y el Mineral de Hierro que necesitabas.",
                "Bien, bien — mineral de calidad.\n*Toma los materiales*\nEntonces, llévate este Cajón de Herramientas que está listo para llevar a Brinn mientras yo forjo más para un lote futuro.");
        cvQPart1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CRAFTER_HELPER, 1)
                    && LibInventory.checkHasItemAmount(ItemsIds.COAL, 3, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.IRON_ORE, 3, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvQPart1.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.COAL, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.IRON_ORE, 3, App.getPlayerChar());
            LibInventory.addToInventory(ItemsIds.CRATE_OF_TOOLS, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.CRAFTER_HELPER, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQPart1);

        ConversationOption cvQPart3 = new ConversationOption(0, 0);
        cvQPart3.addOptionText(ENGLISH, "Tools delivered to Brinn. Job's done.",
                "*He nods with satisfaction*\nExcellent work. Brinn will be pleased.\n*Hands you some molds*\nFor your trouble — I had these molds sitting around anyway. You earned them.");
        cvQPart3.addOptionText(PORTUGUESE, "Ferramentas entregues para Brinn. Trabalho feito.",
                "*Ele acena com satisfação*\nExcelente trabalho. Brinn vai ficar satisfeito.\n*Entrega alguns moldes*\nPelo seu esforço — eu tinha esses moldes por aí de qualquer forma. Você os ganhou.");
        cvQPart3.addOptionText(SPANISH, "Herramientas entregadas a Brinn. Trabajo hecho.",
                "*Asiente con satisfacción*\nExcelente trabajo. Brinn estará complacido.\n*Te entrega unos moldes*\nPor tu esfuerzo — tenía estos moldes por ahí de todos modos. Te los ganaste.");
        cvQPart3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CRAFTER_HELPER, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvQPart3.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.CRAFTER_HELPER, App.getPlayerChar(), 4, ctx);
        };
        npc.conversationOptions.add(cvQPart3);

        // Part 1 (restartable continuation): Quest was completed and restarted
        ConversationOption cvQRestart = new ConversationOption(0, 0);
        cvQRestart.addOptionText(ENGLISH, "What do you need for the tools batch?",
                "3 Coal and 3 Iron Ore — same as before. The guards sent a new order, so I need to forge another batch. Bring them to me when you can.");
        cvQRestart.addOptionText(PORTUGUESE, "Do que mesmo você precisa para o lote de ferramentas?",
                "3 Carvão e 3 Minério de Ferro — igual da última vez. Os guardas mandaram um novo pedido, então preciso forjar outro lote. Me traga quando puder.");
        cvQRestart.addOptionText(SPANISH, "¿Qué necesitas para el lote de herramientas?",
                "3 Carbón y 3 Mineral de Hierro — igual que antes. Los guardias enviaron un nuevo pedido, así que necesito forjar otro lote. Tráelos cuando puedas.");
        cvQRestart.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(QuestsIds.CRAFTER_HELPER, chara)
                    && LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CRAFTER_HELPER, 1)
                    && !(LibInventory.checkHasItemAmount(ItemsIds.COAL, 3, chara) && LibInventory.checkHasItemAmount(ItemsIds.IRON_ORE, 3, chara))) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQRestart);

        return npc;
    }
}