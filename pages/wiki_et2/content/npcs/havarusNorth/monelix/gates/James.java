package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.gates;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REINFORCE_FARMLAND;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REINFORCE_HELERA;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REBUILD_HELERA;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.NOBLES_BALL;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REBUILD_FARMLAND;

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

public class James extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("James");
        npc.age = 34;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A skilled soldier. Loyal to the kingdom and his duties.\nAgile and reactive. He shows the capacity to become an army captain.\nCalm, yet firm when necessary.\n\nHis physical traits: Fair skin and light eyes. Blonde mustache slightly curled upward. Metal helmet with flaps covering the top of his head.");
        npc.addDescriptionTranslation(PORTUGUESE, "Habilidoso soldado. Fiel ao reino e aos seus deveres.\nÁgil e reativo. Demonstra ter capacidade para se tornar um capitão do exército.\nCalmo, porém firme quando necessário.\n\nSeus traços físicos: Pele e olhos claros. Bigode loiro levemente curvado para cima. Elmo metálico com abas que cobre o topo da cabeça.");
        npc.addDescriptionTranslation(SPANISH, "Un soldado habilidoso. Leal al reino y a sus deberes.\nÁgil y reactivo. Demuestra capacidad para convertirse en capitán del ejército.\nCalmado, pero firme cuando es necesario.\n\nSus rasgos físicos: Piel clara y ojos claros. Bigote rubio levemente curvado hacia arriba. Yelmo metálico con alas que cubre la parte superior de la cabeza.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hail, soldier. What brings you here?"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Saudações, soldado. O que o traz aqui?"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Saludos, soldado. ¿Qué te trae aquí?"));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Dismissed."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Dispensado."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Dispensado."));

        // ===== QUEST 19.A & 19.B: Reinforce - Send Troops =====
        ConversationOption cvReinforce = new ConversationOption(0, 1);
        cvReinforce.addOptionText(ENGLISH, "Guzar sent me. We need to send reinforcement troops.", "Ah yes, Guzar informed me. I'll mobilize a full batallion immediately. They'll be ready to march within the hour. One batallion is a significant force - with proper strategy, they should make a difference. Where exactly do they need to be deployed?");
        cvReinforce.addOptionText(PORTUGUESE, "Guzar me enviou. Precisamos enviar tropas de reforço.", "Ah sim, Guzar me informou. Vou mobilizar um batalhão completo imediatamente. Estarão prontos para marchar em uma hora. Um batalhão é uma força significativa - com a estratégia certa, devem fazer diferença. Para onde exatamente eles precisam ser destacados?");
        cvReinforce.addOptionText(SPANISH, "Guzar me envió. Necesitamos enviar tropas de refuerzo.", "Ah sí, Guzar me informó. Movilizaré un batallón completo de inmediato. Estarán listos para marchar dentro de una hora. Un batallón es una fuerza significativa - con la estrategia correcta, deberían hacer diferencia. ¿Exactamente dónde necesitan desplegarse?");
        cvReinforce.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REINFORCE_HELERA, 1) ||
                    LibQuest.isCharacterAtQuestPart(chara, REINFORCE_FARMLAND, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvReinforce);

        // ===== REINFORCE HELERA: Response - Send troops to Helera =====
        ConversationOption cvReinforceHelera = new ConversationOption(1, 0);
        cvReinforceHelera.addOptionText(ENGLISH, "Send the troops to Helera.", "Helera, understood. The trading city needs to be secured - it's vital for our supply lines. I'll dispatch the batallion immediately. They'll march through the main road and arrive by nightfall. The city's defenses will be significantly strengthened. Consider it done.");
        cvReinforceHelera.addOptionText(PORTUGUESE, "Envie as tropas para Helera.", "Helera, entendido. A cidade comercial precisa ser protegida - é vital para nossas linhas de suprimento. Vou despachar o batalhão imediatamente. Eles marcharão pela estrada principal e chegarão ao anoitecer. As defesas da cidade serão significativamente fortalecidas. Considere feito.");
        cvReinforceHelera.addOptionText(SPANISH, "Envía las tropas a Helera.", "Helera, entendido. La ciudad comercial necesita ser asegurada - es vital para nuestras líneas de suministro. Despacharé el batallón de inmediato. Marcharán por el camino principal y llegarán al anochecer. Las defensas de la ciudad se fortalecerán significativamente. Considéralo hecho.");
        cvReinforceHelera.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REINFORCE_HELERA, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvReinforceHelera.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(REINFORCE_HELERA, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvReinforceHelera);

        // ===== REINFORCE FARMLAND: Response - Send troops to Farmland =====
        ConversationOption cvReinforceFarmland = new ConversationOption(1, 0);
        cvReinforceFarmland.addOptionText(ENGLISH, "Send the troops to Farmland.", "Farmland, understood. Protecting our agricultural heart is crucial - without it, the entire kingdom starves. I'll dispatch the batallion immediately. They'll take the rural route and secure the farmlands. The crops and villagers will be well-defended. Consider it done.");
        cvReinforceFarmland.addOptionText(PORTUGUESE, "Envie as tropas para Farmland.", "Farmland, entendido. Proteger nosso coração agrícola é crucial - sem ele, todo o reino passa fome. Vou despachar o batalhão imediatamente. Eles tomarão a rota rural e protegerão as terras agrícolas. As colheitas e aldeões estarão bem defendidos. Considere feito.");
        cvReinforceFarmland.addOptionText(SPANISH, "Envía las tropas a Farmland.", "Farmland, entendido. Proteger nuestro corazón agrícola es crucial - sin él, todo el reino pasa hambre. Despacharé el batallón de inmediato. Tomarán la ruta rural y asegurarán las tierras de cultivo. Los cultivos y aldeanos estarán bien defendidos. Considéralo hecho.");
        cvReinforceFarmland.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REINFORCE_FARMLAND, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvReinforceFarmland.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(REINFORCE_FARMLAND, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvReinforceFarmland);

        // ===== REBUILD_HELERA: Part 4 - Provide carts =====
        ConversationOption cvCarts = new ConversationOption(0, 0);
        cvCarts.addOptionText(ENGLISH, "The Queen arranged carts to help Helera.", "Ah, for the reconstruction effort. Good timing - we have several heavy carts available at the stables. They can transport debris out and bring building materials in. I'll coordinate with the stable master and have them prepared. The carts will be ready for transport to Helera immediately.");
        cvCarts.addOptionText(PORTUGUESE, "A Rainha providenciou carroças para ajudar Helera.", "Ah, para o esforço de reconstrução. Bom momento - temos várias carroças pesadas disponíveis nos estábulos. Elas podem transportar escombros para fora e trazer materiais de construção. Vou coordenar com o mestre dos estábulos e tê-las preparadas. As carroças estarão prontas para transporte para Helera imediatamente.");
        cvCarts.addOptionText(SPANISH, "La Reina organizó carretas para ayudar a Helera.", "Ah, para el esfuerzo de reconstrucción. Buen momento - tenemos varias carretas pesadas disponibles en los establos. Pueden transportar escombros hacia afuera y traer materiales de construcción. Coordinaré con el maestro de establos y haré que estén preparadas. Las carretas estarán listas para el transporte a Helera de inmediato.");
        cvCarts.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REBUILD_HELERA, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvCarts.listeners = (ctx, currentFragment) -> {
            if (LibQuest.isCharacterAtQuestPart(App.getPlayerChar(), REBUILD_HELERA, 4)) {
                LibQuest.updateQuest(REBUILD_HELERA, 5, App.getPlayerChar(), ctx);
            }
        };
        npc.conversationOptions.add(cvCarts);

        // ===== QUEST: REBUILD_FARMLAND - PART 6 (Deliver food request letters) =====
        ConversationOption cvFoodLetters = new ConversationOption(0, 0);
        cvFoodLetters.addOptionText(ENGLISH, "I have urgent letters from Farmland.", "Farmland? Let me see... <He reads the letters carefully> By the gods, this is serious. Farmland can't produce enough food for the kingdom right now. These letters request food donations from all farming communities - Bastian, Umera, smaller villages... I'll organize the distribution immediately. I'll send riders to every city and settlement with farmland. They'll collect whatever surplus can be spared and coordinate shipments to Monelix for redistribution. This will take time, but we'll manage. Tell Larien that help is coming - the kingdom won't let Farmland struggle alone.");
        cvFoodLetters.addOptionText(PORTUGUESE, "Tenho cartas urgentes de Farmland.", "Farmland? Deixe-me ver... <Ele lê as cartas cuidadosamente> Pelos deuses, isso é sério. Farmland não pode produzir comida suficiente para o reino agora. Essas cartas solicitam doações de alimentos de todas as comunidades agrícolas - Bastian, Umera, aldeias menores... Vou organizar a distribuição imediatamente. Enviarei cavaleiros para cada cidade e assentamento com terras agrícolas. Eles coletarão qualquer excedente que possa ser poupado e coordenarão remessas para Monelix para redistribuição. Isso levará tempo, mas vamos conseguir. Diga a Larien que ajuda está a caminho - o reino não deixará Farmland lutar sozinha.");
        cvFoodLetters.addOptionText(SPANISH, "Tengo cartas urgentes de Farmland.", "¿Farmland? Déjame ver... <Lee las cartas cuidadosamente> Por los dioses, esto es serio. Farmland no puede producir suficiente comida para el reino ahora. Estas cartas solicitan donaciones de alimentos de todas las comunidades agrícolas - Bastian, Umera, aldeas más pequeñas... Organizaré la distribución de inmediato. Enviaré jinetes a cada ciudad y asentamiento con tierras de cultivo. Recogerán cualquier excedente que se pueda ahorrar y coordinarán envíos a Monelix para redistribución. Esto llevará tiempo, pero lo lograremos. Dile a Larien que la ayuda está en camino - el reino no dejará que Farmland luche solo.");
        cvFoodLetters.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REBUILD_FARMLAND, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvFoodLetters.listeners = (ctx, currentFragment) -> {
            if (LibQuest.isCharacterAtQuestPart(App.getPlayerChar(), REBUILD_FARMLAND, 6)) {
                LibQuest.updateQuest(REBUILD_FARMLAND, 7, App.getPlayerChar(), ctx);
            }
        };
        npc.conversationOptions.add(cvFoodLetters);

        // ===== GENERAL CONVERSATION =====
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What do you do here?", "I command the gates and manage troop movements. I ensure soldiers and supplies move efficiently through here. Every soldier that passes through these gates is accounted for.");
        cv1.addOptionText(PORTUGUESE, "O que você faz aqui?", "Comando os portões e gerencio movimentos de tropas. Garanto que soldados e suprimentos se movam eficientemente por aqui. Cada soldado que passa por esses portões é contabilizado.");
        cv1.addOptionText(SPANISH, "¿Qué haces aquí?", "Comando las puertas y gestiono los movimientos de tropas. Aseguro que los soldados y suministros se muevan de manera eficiente por aquí. Cada soldado que pasa por estas puertas es contabilizado.");
        npc.conversationOptions.add(cv1);

        // ===== ROLEPLAY CONVERSATION: About the gates =====
        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "The gates seem well-protected.", "Indeed. These gates are the first line of defense for Monelix. We maintain constant vigilance - checking every wagon, counting every soldier. During times of conflict, these gates have held against sieges. It's a responsibility I take very seriously.");
        cv2.addOptionText(PORTUGUESE, "Os portões parecem bem protegidos.", "De fato. Esses portões são a primeira linha de defesa de Monelix. Mantemos vigilância constante - verificando cada carroça, contando cada soldado. Durante tempos de conflito, esses portões resistiram a cercos. É uma responsabilidade que levo muito a sério.");
        cv2.addOptionText(SPANISH, "Las puertas parecen bien protegidas.", "De hecho. Estas puertas son la primera línea de defensa de Monelix. Mantenemos vigilancia constante - revisando cada carreta, contando cada soldado. Durante tiempos de conflicto, estas puertas han resistido asedios. Es una responsabilidad que tomo muy en serio.");
        npc.conversationOptions.add(cv2);

        // ===== ROLEPLAY CONVERSATION: About his work =====
        ConversationOption cv3 = new ConversationOption(0, 0);
        cv3.addOptionText(ENGLISH, "How long have you been stationed here?", "Three years now. Started as a regular gate guard, worked my way up. Guzar saw my organizational skills and put me in charge of logistics. It's demanding work - coordinating supply caravans, troop rotations, equipment requisitions - but it's crucial for the kingdom's defense. Every arrow, every ration, every replacement sword passes through my records.");
        cv3.addOptionText(PORTUGUESE, "Há quanto tempo você está patrulhando aqui?", "Três anos agora. Comecei como guarda regular dos portões, trabalhei para subir. Guzar viu minhas habilidades organizacionais e me colocou no comando da logística. É trabalho exigente - coordenar caravanas de suprimentos, rotações de tropas, requisições de equipamento - mas é crucial para a defesa do reino. Cada flecha, cada ração, cada espada substituta passa pelos meus registros.");
        cv3.addOptionText(SPANISH, "¿Cuánto tiempo llevas estacionado aquí?", "Tres años ahora. Empecé como guardia regular de las puertas, trabajé para ascender. Guzar vio mis habilidades organizativas y me puso a cargo de la logística. Es trabajo exigente - coordinar caravanas de suministros, rotaciones de tropas, requisiciones de equipo - pero es crucial para la defensa del reino. Cada flecha, cada ración, cada espada de reemplazo pasa por mis registros.");
        npc.conversationOptions.add(cv3);

        // ===== ROLEPLAY CONVERSATION: About the stables =====
        ConversationOption cv4 = new ConversationOption(0, 0);
        cv4.addOptionText(ENGLISH, "You manage the stables too?", "Not directly, but I coordinate with the stable master. Horses are as important as soldiers in warfare - cavalry charges, scouts, supply transport. We keep about fifty horses here at the gates, ready for deployment. The stable master handles their care, I handle their deployment orders.");
        cv4.addOptionText(PORTUGUESE, "Você gerencia os estábulos também?", "Não diretamente, mas coordeno com o mestre dos estábulos. Cavalos são tão importantes quanto soldados na guerra - cargas de cavalaria, batedores, transporte de suprimentos. Mantemos cerca de cinquenta cavalos aqui nos portões, prontos para destacamento. O mestre dos estábulos cuida deles, eu cuido das ordens de destacamento.");
        cv4.addOptionText(SPANISH, "¿Gestionas los establos también?", "No directamente, pero coordino com el maestro de establos. Los caballos son tan importantes como los soldados en la guerra - cargas de caballería, exploradores, transporte de suministros. Mantenemos unos cincuenta caballos aquí en las puertas, listos para despliegue. El maestro de establos se encarga de su cuidado, yo me encargo de las órdenes de despliegue.");
        npc.conversationOptions.add(cv4);

        // ========================================
        // QUEST: NOBLE'S BALL
        // ========================================

        // Part 7: Talk to James
        ConversationOption cvBallPart7 = new ConversationOption(0, 10);
        cvBallPart7.addOptionText(ENGLISH, "Lady Jade sent me. I heard some carriages were damaged.",
                "Hail! Yes, several of the royal carriages suffered damage during the recent transport from the outer provinces. The wheels and frames need urgent repair if they are to be ready for the ball. \n\nI have the workers ready, but we are short on materials. I need 8 high-quality planks to reinforce the frames. Can you procure them for us?");
        cvBallPart7.addOptionText(PORTUGUESE, "Lady Jade me enviou. Ouvi dizer que algumas carruagens foram danificadas.",
                "Saudações! Sim, várias das carruagens reais sofreram danos durante o transporte recente das províncias externas. As rodas e estruturas precisam de reparo urgente se quisermos que estejam prontas para o baile. \n\nTenho os trabalhadores prontos, mas estamos com falta de materiais. Preciso de 8 tábuas de alta qualidade para reforçar as estruturas. Você pode consegui-las para nós?");
        cvBallPart7.addOptionText(SPANISH, "Lady Jade me envió. He oído que algunos carruajes resultaron dañados.",
                "¡Salve! Sí, varios de los carruajes reales sufrieron daños durante el reciente transporte desde las provincias exteriores. Las ruedas y estructuras necesitan reparación urgente si queremos que estén listos para el baile. \n\nTengo a los trabajadores listos, pero nos faltan materiales. Necesito 8 tablones de alta calidad para reforzar las estructuras. ¿Puedes conseguirlos para nosotros?");
        cvBallPart7.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, NOBLES_BALL, 7)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvBallPart7);

        ConversationOption cvBallAccept = new ConversationOption(10, 0);
        cvBallAccept.addOptionText(ENGLISH, "I'll get the planks for you.",
                "Good. Time is of the essence. The guests will be arriving soon, and we cannot have them traveling in unstable carriages. Return as soon as you have the 8 planks.");
        cvBallAccept.addOptionText(PORTUGUESE, "Vou conseguir as tábuas para você.",
                "Bom. O tempo é essencial. Os convidados chegarão em breve, e não podemos deixá-los viajando em carruagens instáveis. Volte assim que tiver as 8 tábuas.");
        cvBallAccept.addOptionText(SPANISH, "Conseguiré los tablones para ti.",
                "Bien. El tiempo apremia. Los invitados llegará pronto y no podemos permitir que viajen en carruajes inestables. Regresa tan pronto como tengas los 8 tablones.");
        cvBallAccept.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(NOBLES_BALL, 8, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBallAccept);

        // Part 8: Deliver 8 Planks
        ConversationOption cvBallPart8 = new ConversationOption(0, 0);
        cvBallPart8.addOptionText(ENGLISH, "I have the 8 planks for the carriage repairs.",
                "Excellent work! These planks are perfect. My men will start the reinforcements immediately. \n\nYou've done your part, and just in time. Please, report back to Lady Jade. She will want to know that the transport is secured.");
        cvBallPart8.addOptionText(PORTUGUESE, "Tenho as 8 tábuas para os reparos das carruagens.",
                "Excelente trabalho! Estas tábuas são perfeitas. Meus homens começarão os reforços imediatamente. \n\nVocê fez sua parte, e bem na hora. Por favor, avise Lady Jade. Ela vai querer saber que o transporte está garantido.");
        cvBallPart8.addOptionText(SPANISH, "Tengo los 8 tablones para las reparaciones de los carruajes.",
                "¡Excelente trabajo! Estos tablones son perfectos. Mis hombres comenzarán los refuerzos de inmediato. \n\nHas hecho tu parte, y justo a tiempo. Por favor, informa a Lady Jade. Querrá saber que el transporte está asegurado.");
        cvBallPart8.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, NOBLES_BALL, 8) && LibInventory.checkHasItemAmount(ItemsIds.PLANK, 8, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvBallPart8.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.PLANK, 8, App.getPlayerChar());
            LibQuest.updateQuest(NOBLES_BALL, 9, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBallPart8);

        return npc;
    }
}
