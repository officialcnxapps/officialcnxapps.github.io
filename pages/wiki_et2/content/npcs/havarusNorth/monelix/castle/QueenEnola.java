package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.castle;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.A_QUEEN_MESSAGE;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REBUILD_HELERA;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class QueenEnola extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    //TRADUZIR
    Npc npc() {
        Npc npc = new Npc("Queen Enola");
        npc.addNameTranslation(PORTUGUESE, "Rainha Enola");
        npc.addNameTranslation(SPANISH, "Reina Enola");
        npc.age = 30;
        npc.job = Enums.NPCJobs.QUEEN;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Be welcome. May I help you?"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Seja bem-vindo. Posso ajudá-lo?"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Bienvenido. ¿Puedo ayudarte?"));

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Hail, my queen. How are you?", "Thank you for asking, citizen. I am feeling good now and I expect you and every other people of Havarus are feeling good also, this is part of my job as queen.");
        cv1.addOptionText(PORTUGUESE, "Saudações, minha rainha. Como está?", "Obrigada por perguntar, cidadão. Estou me sentindo bem agora e espero que você e todas as outras pessoas de Havarus também estejam, isso faz parte do meu trabalho como rainha.");
        cv1.addOptionText(SPANISH, "Salve, mi reina. ¿Cómo estás?", "Gracias por preguntar, ciudadano. Me siento bien ahora y espero que tú y todas las demás personas de Havarus también se sientan bien, esto es parte de mi trabajo como reina.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 1);
        cv2.addOptionText(ENGLISH, "I received a letter from you.", "Oh, yes, [PLAYERNAME], right?\nDuring a conversation with the king of Lisport he mentioned Lenny, his army captain. Since I am looking for a new valuable member to our specialized army I tried to hire him, but he refused to leave Lisport. You, [PLAYERNAME] was the person indicated by him. So, I sent you the letter.");
        cv2.addOptionText(PORTUGUESE, "Eu recebi uma carta sua.", "Ah, sim, [PLAYERNAME], certo?\nDurante uma conversa com o rei de Lisport ele mencionou Lenny, seu capitão do exército. Como estou procurando um novo membro valioso para nosso exército especializado, tentei contratá-lo, mas ele se recusou a deixar Lisport. Você, [PLAYERNAME], foi a pessoa indicada por ele. Por isso, enviei-lhe a carta.");
        cv2.addOptionText(SPANISH, "Recibí una carta de ti.", "Oh, sí, [PLAYERNAME], ¿verdad?\nDurante una conversación con el rey de Lisport mencionó a Lenny, su capitán del ejército. Como estoy buscando un nuevo miembro valioso para nuestro ejército especializado, intenté contratarlo, pero él se negó a dejar Lisport. Tú, [PLAYERNAME], fuiste la persona que él indicó. Por eso, te envié la carta.");
        cv2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.OVERSEAS_RECOGNITION, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(1, 0);
        cv3.addOptionText(ENGLISH, "It is a pleasure.", "Good. I did my part, now it is time to speak with Guzar, the leader of my army. He is the one that can evaluate and accept new members. Talk to him at the barracks.");
        cv3.addOptionText(PORTUGUESE, "É um prazer.", "Bom. Eu fiz a minha parte, agora é hora de falar com Guzar, o líder do meu exército. Ele é quem pode avaliar e aceitar novos membros. Fale com ele no quartel.");
        cv3.addOptionText(SPANISH, "Es un placer.", "Bien. He hecho mi parte, ahora es hora de hablar con Guzar, el líder de mi ejército. Él es quien puede evaluar y aceptar nuevos miembros. Habla con él en el cuartel.");
        cv3.listeners = (ctx, currentFragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.OVERSEAS_RECOGNITION);
            LibQuest.updateQuest(quest, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv3);

        ///ABOUT QUEST: A_QUEEN_MESSAGE - PART 1
        ConversationOption cvQueenMessage1 = new ConversationOption(0, 2);
        cvQueenMessage1.addOptionText(ENGLISH, "Your Majesty, I received your urgent letter.", "Ah, [PLAYERNAME]! Thank the gods you came quickly. The situation is far worse than we anticipated. Multiple reports are coming in from across the kingdom - these dark creatures are attacking simultaneously in different locations.");
        cvQueenMessage1.addOptionText(PORTUGUESE, "Vossa Majestade, recebi sua carta urgente.", "Ah, [PLAYERNAME]! Graças aos deuses você veio rapidamente. A situação está muito pior do que prevíamos. Múltiplos relatórios estão chegando de todo o reino - essas criaturas das trevas estão atacando simultaneamente em diferentes locais.");
        cvQueenMessage1.addOptionText(SPANISH, "Su Majestad, recibí su carta urgente.", "¡Ah, [PLAYERNAME]! Gracias a los dioses que viniste rápidamente. La situación es mucho peor de lo que anticipábamos. Múltiples informes llegan de todo el reino - estas criaturas oscuras están atacando simultáneamente en diferentes ubicaciones.");
        cvQueenMessage1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, A_QUEEN_MESSAGE, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQueenMessage1);

        ConversationOption cvQueenMessage2 = new ConversationOption(2, 3);
        cvQueenMessage2.addOptionText(ENGLISH, "What's the current situation?", "Guzar left in haste for Bastian - they're under heavy assault. But Farmland and Helera are also reporting attacks. We don't have enough forces to defend all three locations adequately. I've sent reinforcements to assist Guzar in Bastian, but that means you must make a critical decision.");
        cvQueenMessage2.addOptionText(PORTUGUESE, "Qual é a situação atual?", "Guzar saiu às pressas para Bastian - eles estão sob forte ataque. Mas Farmland e Helera também estão reportando ataques. Não temos forças suficientes para defender adequadamente os três locais. Enviei reforços para ajudar Guzar em Bastian, mas isso significa que você deve tomar uma decisão crítica.");
        cvQueenMessage2.addOptionText(SPANISH, "¿Cuál es la situación actual?", "Guzar salió apresuradamente hacia Bastian - están bajo fuerte asalto. Pero Farmland y Helera también están reportando ataques. No tenemos suficientes fuerzas para defender adecuadamente las tres ubicaciones. He enviado refuerzos para ayudar a Guzar en Bastian, pero eso significa que debes tomar una decisión crítica.");
        npc.conversationOptions.add(cvQueenMessage2);

        ConversationOption cvQueenMessage3 = new ConversationOption(3, 4);
        cvQueenMessage3.addOptionText(ENGLISH, "What decision must I make?", "You know both locations well from your reconnaissance. Farmland provides our food supply - if we lose it, the kingdom will starve. Helera controls our trade routes and port defenses - without it, we're economically crippled and isolated.\nBoth have the reinforcements you helped arrange, but they need leadership on the ground. I need you to choose which city you will personally defend. Your presence and tactical skills could be the difference between survival and destruction.");
        cvQueenMessage3.addOptionText(PORTUGUESE, "Que decisão devo tomar?", "Você conhece bem ambos os locais pelo seu reconhecimento. Farmland fornece nosso suprimento de comida - se perdermos, o reino morrerá de fome. Helera controla nossas rotas comerciais e defesas portuárias - sem ela, estamos economicamente paralisados e isolados.\nAmbas têm os reforços que você ajudou a organizar, mas precisam de liderança no campo. Preciso que escolha qual cidade você irá defender pessoalmente. Sua presença e habilidades táticas podem ser a diferença entre sobrevivência e destruição.");
        cvQueenMessage3.addOptionText(SPANISH, "¿Qué decisión debo tomar?", "Conoces bien ambas ubicaciones por tu reconocimiento. Farmland proporciona nuestro suministro de alimentos - si lo perdemos, el reino morirá de hambre. Helera controla nuestras rutas comerciales y defensas portuarias - sin ella, estamos económicamente paralizados y aislados.\nAmbas tienen los refuerzos que ayudaste a organizar, pero necesitan liderazgo en el campo. Necesito que elijas qué ciudad defenderás personalmente. Tu presencia y habilidades tácticas podrían ser la diferencia entre supervivencia y destrucción.");
        npc.conversationOptions.add(cvQueenMessage3);

        ConversationOption cvQueenMessage4 = new ConversationOption(4, 0);
        cvQueenMessage4.addOptionText(ENGLISH, "I understand the weight of this decision.", "I know you do, [PLAYERNAME]. This is why I trust you with it. The reinforcements are in place, but they need a commander. Choose wisely - travel to either Farmland or Helera and lead their defense. The fate of that city, and perhaps the entire kingdom, rests on your shoulders.\nMay the gods guide your choice and strengthen your sword arm.");
        cvQueenMessage4.addOptionText(PORTUGUESE, "Entendo o peso desta decisão.", "Eu sei que entende, [PLAYERNAME]. É por isso que confio isso a você. Os reforços estão posicionados, mas precisam de um comandante. Escolha sabiamente - viaje para Farmland ou Helera e lidere sua defesa. O destino daquela cidade, e talvez de todo o reino, repousa sobre seus ombros.\nQue os deuses guiem sua escolha e fortaleçam seu braço de espada.");
        cvQueenMessage4.addOptionText(SPANISH, "Entiendo el peso de esta decisión.", "Sé que lo entiendes, [PLAYERNAME]. Por eso confío en ti con esto. Los refuerzos están en su lugar, pero necesitan un comandante. Elige sabiamente - viaja a Farmland o Helera y lidera su defensa. El destino de esa ciudad, y quizás de todo el reino, descansa sobre tus hombros.\nQue los dioses guíen tu elección y fortalezcan tu brazo de espada.");
        cvQueenMessage4.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(A_QUEEN_MESSAGE, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQueenMessage4);

        // ===== REBUILD_HELERA: Part 3 - Request for carts =====
        ConversationOption cvRebuildHelera1 = new ConversationOption(0, 5);
        cvRebuildHelera1.addOptionText(ENGLISH, "Your Majesty, Helera needs reconstruction. I came to ask for help.", "Helera... \n*sighs*\nYes, I've heard of the destruction. The kingdom's resources are stretched thin after all these attacks, but Helera is vital to our trade network. What specifically do you need?");
        cvRebuildHelera1.addOptionText(PORTUGUESE, "Vossa Majestade, Helera precisa de reconstrução. Vim pedir ajuda.", "Helera... \n*suspira*\nSim, ouvi falar da destruição. Os recursos do reino estão muito limitados após todos esses ataques, mas Helera é vital para nossa rede comercial. Do que especificamente você precisa?");
        cvRebuildHelera1.addOptionText(SPANISH, "Su Majestad, Helera necesita reconstrucción. Vine a pedir ayuda.", "Helera... \n*suspira*\nSí, he oído hablar de la destrucción. Los recursos del reino están muy limitados después de todos estos ataques, pero Helera es vital para nuestra red comercial. ¿Qué necesitas específicamente?");
        cvRebuildHelera1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(REBUILD_HELERA, chara) && LibQuest.isCharacterAtQuestPart(chara, REBUILD_HELERA, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRebuildHelera1);

        ConversationOption cvRebuildHelera2 = new ConversationOption(5, 6);
        cvRebuildHelera2.addOptionText(ENGLISH, "We need carts to transport debris and materials.", "Carts... that's reasonable. The debris must be cleared and materials brought in for rebuilding. The city cannot function with rubble blocking the streets and harbor. How many carts do you estimate are needed?");
        cvRebuildHelera2.addOptionText(PORTUGUESE, "Precisamos de carroças para transportar escombros e materiais.", "Carroças... isso é razoável. Os escombros devem ser removidos e materiais trazidos para a reconstrução. A cidade não pode funcionar com entulho bloqueando as ruas e o porto. Quantas carroças você estima que são necessárias?");
        cvRebuildHelera2.addOptionText(SPANISH, "Necesitamos carretas para transportar escombros y materiales.", "Carretas... eso es razonable. Los escombros deben limpiarse y los materiales traídos para la reconstrucción. La ciudad no puede funcionar con escombros bloqueando las calles y el puerto. ¿Cuántas carretas estimas que se necesitan?");
        npc.conversationOptions.add(cvRebuildHelera2);

        ConversationOption cvRebuildHelera3 = new ConversationOption(6, 0);
        cvRebuildHelera3.addOptionText(ENGLISH, "Lord Mathew believes we need several heavy carts.", "Very well. I understand the urgency. I will arrange for heavy carts from the royal stables to be made available for Helera's reconstruction. Speak with James at the city gates - he manages our logistics and troop movements. Tell him I've authorized the use of our carts for this purpose. He'll coordinate with the stable master to prepare them for transport.");
        cvRebuildHelera3.addOptionText(PORTUGUESE, "Lorde Mathew acredita que precisamos de várias carroças pesadas.", "Muito bem. Entendo a urgência. Vou providenciar que carroças pesadas dos estábulos reais sejam disponibilizadas para a reconstrução de Helera. Fale com James nos portões da cidade - ele gerencia nossa logística e movimentos de tropas. Diga a ele que autorizei o uso de nossas carroças para esse propósito. Ele coordenará com o mestre dos estábulos para prepará-las para transporte.");
        cvRebuildHelera3.addOptionText(SPANISH, "Lord Mathew cree que necesitamos varias carretas pesadas.", "Muy bien. Entiendo la urgencia. Arreglaré que carretas pesadas de los establos reales estén disponibles para la reconstrucción de Helera. Habla con James en las puertas de la ciudad - él gestiona nuestra logística y movimientos de tropas. Dile que autoricé el uso de nuestras carretas para este propósito. Él coordinará con el maestro de establos para prepararlas para el transporte.");
        cvRebuildHelera3.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(REBUILD_HELERA, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvRebuildHelera3);

        // ===== REBUILD_FARMLAND: Part 2 - Request for workers =====
        ConversationOption cvRebuildFarmland2 = new ConversationOption(0, 7);
        cvRebuildFarmland2.addOptionText(ENGLISH, "Your Majesty, Farmland needs help to rebuild.", "Farmland... Yes, I've received reports of the devastation. So many lives lost, so much destruction. Farmland is the heart of our kingdom's food production - without it, we all starve. What do you need?");
        cvRebuildFarmland2.addOptionText(PORTUGUESE, "Vossa Majestade, Farmland precisa de ajuda para reconstruir.", "Farmland... Sim, recebi relatórios da devastação. Tantas vidas perdidas, tanta destruição. Farmland é o coração da produção de alimentos do nosso reino - sem ela, todos passaremos fome. Do que você precisa?");
        cvRebuildFarmland2.addOptionText(SPANISH, "Su Majestad, Farmland necesita ayuda para reconstruir.", "Farmland... Sí, he recibido informes de la devastación. Tantas vidas perdidas, tanta destrucción. Farmland es el corazón de la producción de alimentos de nuestro reino - sin ella, todos pasaremos hambre. ¿Qué necesitas?");
        cvRebuildFarmland2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(QuestsIds.REBUILD_FARMLAND, chara) && LibQuest.isCharacterAtQuestPart(chara, QuestsIds.REBUILD_FARMLAND, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRebuildFarmland2);

        ConversationOption cvRebuildFarmland2Response = new ConversationOption(7, 0);
        cvRebuildFarmland2Response.addOptionText(ENGLISH, "We need workers and soldiers to help rebuild.", "Of course. I'll authorize soldiers from the barracks to assist with the reconstruction. They can help with heavy labor and security. Go to the barracks and speak with whoever is in command there. Tell them the Queen has ordered their assistance. And... you should also seek help from Lord Den in Letow. His people are skilled workers and farmers. Together, we can bring Farmland back to life.");
        cvRebuildFarmland2Response.addOptionText(PORTUGUESE, "Precisamos de trabalhadores e soldados para ajudar a reconstruir.", "Claro. Vou autorizar soldados do quartel a ajudarem na reconstrução. Eles podem ajudar com trabalho pesado e segurança. Vá ao quartel e fale com quem estiver no comando lá. Diga a eles que a Rainha ordenou a assistência. E... você também deve buscar ajuda de Lord Den em Letow. Seu povo são trabalhadores habilidosos e fazendeiros. Juntos, podemos trazer Farmland de volta à vida.");
        cvRebuildFarmland2Response.addOptionText(SPANISH, "Necesitamos trabajadores y soldados para ayudar a reconstruir.", "Por supuesto. Autorizaré a soldados del cuartel para ayudar con la reconstrucción. Pueden ayudar con trabajo pesado y seguridad. Ve al cuartel y habla con quien esté al mando allí. Diles que la Reina ha ordenado su asistencia. Y... también deberías buscar ayuda de Lord Den en Letow. Su gente son trabajadores y granjeros hábiles. Juntos, podemos devolver la vida a Farmland.");
        cvRebuildFarmland2Response.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.REBUILD_FARMLAND, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvRebuildFarmland2Response);

        // ===== STRATEGY QUEST: Part 1 - Seek ancestral help =====
        ConversationOption cvStrategy1 = new ConversationOption(0, 8);
        cvStrategy1.addOptionText(ENGLISH, "Your Majesty, the attacks continue. We need a new strategy.", "You're right, [PLAYERNAME]. These creatures are relentless and our conventional tactics aren't enough. Guzar came to me with a proposal - seeking help from ancestral magic. The kind of power that has been lost to humans for generations.");
        cvStrategy1.addOptionText(PORTUGUESE, "Vossa Majestade, os ataques continuam. Precisamos de uma nova estratégia.", "Você está certo, [PLAYERNAME]. Essas criaturas são implacáveis e nossas táticas convencionais não são suficientes. Guzar veio até mim com uma proposta - buscar ajuda da magia ancestral. O tipo de poder que foi perdido para os humanos por gerações.");
        cvStrategy1.addOptionText(SPANISH, "Su Majestad, los ataques continúan. Necesitamos una nueva estrategia.", "Tienes razón, [PLAYERNAME]. Estas criaturas son implacables y nuestras tácticas convencionales no son suficientes. Guzar vino a mí con una propuesta: buscar ayuda de la magia ancestral. El tipo de poder que se ha perdido para los humanos durante generaciones.");
        cvStrategy1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.STRATEGY, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvStrategy1);

        ConversationOption cvStrategy2 = new ConversationOption(8, 9);
        cvStrategy2.addOptionText(ENGLISH, "Ancestral magic? You mean the elves?", "Precisely. The elves possess knowledge and magical prowess that far surpasses our own. But there's a problem - they've distanced themselves from humanity for decades. The last real cooperation between our peoples was when my grandfather ruled. Since then, the elves have retreated to Ayalon, keeping to themselves.");
        cvStrategy2.addOptionText(PORTUGUESE, "Magia ancestral? Quer dizer os elfos?", "Precisamente. Os elfos possuem conhecimento e proeza mágica que superam em muito os nossos. Mas há um problema - eles se afastaram da humanidade por décadas. A última cooperação real entre nossos povos foi quando meu avô governava. Desde então, os elfos se retiraram para Ayalon, mantendo-se isolados.");
        cvStrategy2.addOptionText(SPANISH, "¿Magia ancestral? ¿Te refieres a los elfos?", "Precisamente. Los elfos poseen conocimiento y destreza mágica que supera con creces la nuestra. Pero hay un problema: se han distanciado de la humanidad durante décadas. La última cooperación real entre nuestros pueblos fue cuando mi abuelo gobernaba. Desde entonces, los elfos se han retirado a Ayalon, manteniéndose aislados.");
        npc.conversationOptions.add(cvStrategy2);

        ConversationOption cvStrategy3 = new ConversationOption(9, 10);
        cvStrategy3.addOptionText(ENGLISH, "Will they help us?", "That's the question. These dark forces threaten not just humans, but all living beings. If we can make the elves understand the gravity of the situation, they might set aside old differences. But reaching them won't be easy - Ayalon's location is known only to a few, and they guard their borders with powerful magic.");
        cvStrategy3.addOptionText(PORTUGUESE, "Eles nos ajudarão?", "Essa é a questão. Essas forças das trevas ameaçam não apenas humanos, mas todos os seres vivos. Se conseguirmos fazer os elfos entenderem a gravidade da situação, eles podem deixar de lado antigas diferenças. Mas alcançá-los não será fácil - a localização de Ayalon é conhecida apenas por poucos, e eles protegem suas fronteiras com magia poderosa.");
        cvStrategy3.addOptionText(SPANISH, "¿Nos ayudarán?", "Esa es la cuestión. Estas fuerzas oscuras amenazan no solo a los humanos, sino a todos los seres vivos. Si podemos hacer que los elfos comprendan la gravedad de la situación, podrían dejar de lado viejas diferencias. Pero llegar a ellos no será fácil: la ubicación de Ayalon solo la conocen unos pocos, y protegen sus fronteras con magia poderosa.");
        npc.conversationOptions.add(cvStrategy3);

        ConversationOption cvStrategy4 = new ConversationOption(10, 0);
        cvStrategy4.addOptionText(ENGLISH, "I'll find a way to reach them.", "I knew I could count on you. I'm drafting a formal letter of requisition - a diplomatic plea for aid signed with the royal seal. This will show the elves that we come seeking alliance, not conquest.\n\nIn Umera, there's a man named Eldrin. He's half-elf, half-human - one of the few who knows the routes to elven lands. Seek him out and show him this letter. He may be able to guide you. Take this letter and may fortune favor your journey.");
        cvStrategy4.addOptionText(PORTUGUESE, "Encontrarei uma forma de alcançá-los.", "Eu sabia que podia contar com você. Estou redigindo uma carta formal de requisição - um apelo diplomático por ajuda assinado com o selo real. Isso mostrará aos elfos que viemos buscando aliança, não conquista.\n\nEm Umera, há um homem chamado Eldrin. Ele é meio-elfo, meio-humano - um dos poucos que conhece as rotas para as terras élficas. Procure-o e mostre-lhe esta carta. Ele pode te guiar. Leve esta carta e que a fortuna favoreça sua jornada.");
        cvStrategy4.addOptionText(SPANISH, "Encontraré una forma de llegar a ellos.", "Sabía que podía contar contigo. Estoy redactando una carta formal de requisición: una súplica diplomática de ayuda firmada con el sello real. Esto mostrará a los elfos que venimos buscando alianza, no conquista.\n\nEn Umera, hay un hombre llamado Eldrin. Es mitad elfo, mitad humano, uno de los pocos que conoce las rutas a las tierras élficas. Búscalo y muéstrale esta carta. Puede guiarte. Toma esta carta y que la fortuna favorezca tu viaje.");
        cvStrategy4.listeners = (ctx, currentFragment) -> {
            // Add letter to inventory
            App.getPlayerChar().inventory.add(new ItemReference(ItemsIds.QUEENS_REQUISITION_LETTER, 1));
            LibQuest.updateQuest(QuestsIds.STRATEGY, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvStrategy4);

        // ===== THE ELF LIBRARY QUEST: Part 4 - Nelera's job request =====
        ConversationOption cvLibrary1 = new ConversationOption(0, 11);
        cvLibrary1.addOptionText(ENGLISH, "Your Majesty, I need to ask a favor regarding the elven library.", "*Looks up with interest*\nThe elven library? Have you gained access? Excellent progress. What favor do you require?");
        cvLibrary1.addOptionText(PORTUGUESE, "Vossa Majestade, preciso pedir um favor sobre a biblioteca élfica.", "*Olha com interesse*\nA biblioteca élfica? Conseguiu acesso? Excelente progresso. Que favor precisa?");
        cvLibrary1.addOptionText(SPANISH, "Su Majestad, necesito pedir un favor sobre la biblioteca élfica.", "*Mira com interés*\n¿La biblioteca élfica? ¿Has conseguido acceso? Excelente progresso. ¿Qué favor necesitas?");
        cvLibrary1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_ELF_LIBRARY, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvLibrary1);

        ConversationOption cvLibrary2 = new ConversationOption(11, 12);
        cvLibrary2.addOptionText(ENGLISH, "Nelera from Bastian. She requests a position at the Royal Library.", "*Frowns slightly*\nNelera... yes, I know of her. A scholar obsessed with elven culture. The Royal Library has refused her multiple times - they consider her too specialized, too unconventional. They prefer scholars of broader disciplines.");
        cvLibrary2.addOptionText(PORTUGUESE, "Nelera de Bastian. Ela solicita um cargo na Biblioteca Real.", "*Franze levemente o cenho*\nNelera... sim, conheço ela. Uma estudiosa obsecada pela cultura élfica. A Biblioteca Real a recusou múltiplas vezes - consideram-na muito especializada, muito não convencional. Preferem estudiosos de disciplinas mais amplas.");
        cvLibrary2.addOptionText(SPANISH, "Nelera de Bastian. Ella solicita un puesto en la Biblioteca Real.", "*Frunce ligeramente el ceño*\nNelera... sí, la conozco. Una erudita obsesionada con la cultura élfica. La Biblioteca Real la ha rechazado múltiples veces: la consideran demasiado especializada, demasiado poco convencional. Prefieren eruditos de disciplinas más amplias.");
        npc.conversationOptions.add(cvLibrary2);

        ConversationOption cvLibrary3 = new ConversationOption(12, 0);
        cvLibrary3.addOptionText(ENGLISH, "Her specialization is exactly what we need. She can translate elven language.", "*Considers for a long moment*\nYou make a valid point. In normal times, her narrow focus would be a weakness. But these are not normal times. If elven knowledge is our only hope against these dark forces... \n*sighs*\nVery well. I will issue a royal decree granting Nelera a position at the Royal Library. However, she must prove her worth immediately - she is to travel to Ayalon and begin translating critical texts for the defense of our kingdom. Inform her of my decision.");
        cvLibrary3.addOptionText(PORTUGUESE, "Sua especialização é o que precisamos agora. Ela sabe traduzir linguagem élfica.", "*Considera por um longo momento*\nVocê tem um ponto válido. Em tempos normais, seu foco restrito seria uma fraqueza. Mas estes não são tempos normais. Se o conhecimento élfico é nossa única esperança contra essas forças das trevas... \n*suspira*\nMuito bem. Emitirei um decreto real concedendo a Nelera um cargo na Biblioteca Real. No entanto, ela deve provar seu valor imediatamente - ela deve viajar para Ayalon e começar a traduzir textos críticos para a defesa de nosso reino. Informe-a de minha decisão.");
        cvLibrary3.addOptionText(SPANISH, "Su especialización es justo lo que necesitamos. Sabe traducir el idioma élfico.", "*Considera por un largo momento*\nTienes un punto válido. En tiempos normales, su enfoque limitado sería una debilidad. Pero estos no son tiempos normales. Si el conocimiento élfico es nuestra única esperanza contra estas fuerzas oscuras... \n*suspira*\nMuy bien. Emitiré un decreto real otorgando a Nelera un puesto en la Biblioteca Real. Sin embargo, debe demostrar su valía de inmediato: debe viajar a Ayalon y comenzar a traducir textos críticos para la defensa de nuestro reino. Infórmale de mi decisión.");
        cvLibrary3.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.THE_ELF_LIBRARY, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvLibrary3);

        return npc;
    }
}

