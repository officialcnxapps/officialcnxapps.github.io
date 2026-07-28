package com.cnx.endlesstalestwo.data.npcs.wazel.towerWarriors;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REINFORCE_FARMLAND;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REINFORCE_HELERA;
import static com.cnx.endlesstalestwo.entities.Constants.SFX_QUEST_COMPLETED;

import android.os.Handler;
import android.os.Looper;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.GameEngine;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.arenas.ArenasIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.dialogs._CnxContentDialog;
import com.cnx.endlesstalestwo.displayers.RecompenseDisplay;
import com.cnx.endlesstalestwo.entities.Arena;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Recompense;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibNpc;
import com.cnx.endlesstalestwo.libs.LibQuest;
import com.cnx.endlesstalestwo.managers.AssetsManager;

import java.util.Collections;

public class Danjor extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Danjor");
        npc.age = 34;
        npc.job = Enums.NPCJobs.GUILD_LEADER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A man firm in his decisions and skilled in his tasks.\nA strong leader who even commands a certain fear.\nLoyal to his purpose.\n\nHis physical traits: Long dark hair. Full beard with gray hairs. Serious gaze in his dark eyes. Thin face.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um homem firme nas decisões e ábil nas tarefas.\nLíder forte e que passa até certo temor.\nLeal ao seu propósito.\n\nSeus traços físicos: Cabelos escuros e compridos. Barba completa com fios grisalhos. Olhar sério em seus olhos escuros. Rosto magro.");
        npc.addDescriptionTranslation(SPANISH, "Un hombre firme en sus decisiones y hábil en sus tareas.\nLíder fuerte que llega a infundir cierto temor.\nLeal a su propósito.\n\nSus rasgos físicos: Cabello oscuro y largo. Barba completa con canas. Mirada seria en sus ojos oscuros. Rostro delgado.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Welcome to the Tower of Warriors."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bem-vindo à Torre dos Guerreiros."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Bienvenido a la Torre de Guerreros."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Fight well."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Lute bem."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Lucha bien."));

        // ===== QUESTS 19.A & 19.B: Contract Warriors =====
        ConversationOption cvContract = new ConversationOption(0, 1);
        cvContract.addOptionText(ENGLISH, "Havarus Kingdom needs elite warriors for reinforcement.", "Ah, business from the capital! That's good to hear. The kingdom has always treated us fairly. Tell me - what's the situation? Are you defending against raiders, monsters, or something else? What kind of warriors do you need?");
        cvContract.addOptionText(PORTUGUESE, "O Reino Havarus precisa de guerreiros de elite para reforço.", "Ah, negócios da capital! Isso é bom de ouvir. O reino sempre nos tratou bem. Me diga - qual é a situação? Você está defendendo contra invasores, monstros, ou algo mais? Que tipo de guerreiros você precisa?");
        cvContract.addOptionText(SPANISH, "El Reino Havarus necesita guerreros de élite para refuerzo.", "Ah, ¡negocios de la capital! Eso es bueno de oír. El reino siempre nos ha tratado bien. Dime - ¿cuál es la situación? ¿Estás defendiendo contra invasores, monstruos, u otra cosa? ¿Qué tipo de guerreros necesitas?");
        cvContract.requirementValidations = (chara, ctx) -> {
            if ((LibQuest.isCharacterAtQuestPart(chara, REINFORCE_HELERA, 4)) ||
                    (LibQuest.isCharacterAtQuestPart(chara, REINFORCE_FARMLAND, 5))) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvContract);

        ConversationOption cvAccept = new ConversationOption(1, 2);
        cvAccept.addOptionText(ENGLISH, "We need soldiers prepared for any threat.", "Good answer. I'll send a contingent of our best fighters. Mix of swordsmen, archers, and tactical leaders. They're battle-hardened and loyal. They'll serve with honor and competence. When do you need them to arrive?");
        cvAccept.addOptionText(PORTUGUESE, "Precisamos de soldados preparados para qualquer ameaça.", "Boa resposta. Vou enviar um contingente de nossos melhores guerreiros. Mistura de espadachins, arqueiros e líderes táticos. Eles são bravos em batalha e leais. Eles servirão com honra e competência. Quando você precisa que eles cheguem?");
        cvAccept.addOptionText(SPANISH, "Necesitamos soldados preparados para cualquier amenaza.", "Buena respuesta. Enviaré un contingente de nuestros mejores guerreros. Mezcla de espadachines, arqueros y líderes tácticos. Son curtidos en batalla y leales. Servirán con honor y competencia. ¿Cuándo necesitas que lleguen?");
        npc.conversationOptions.add(cvAccept);

        // Response to timing question
        ConversationOption cvImmediately = new ConversationOption(2, 0);
        cvImmediately.addOptionText(ENGLISH, "Immediately! Dark forces are approaching.", "Understood. I'll mobilize them at once. As for payment - the cost will be negotiated directly with the royalty of Monelix. This won't be cheap, but for the kingdom's defense, we'll ensure our best warriors are deployed. They'll depart within the hour.");
        cvImmediately.addOptionText(PORTUGUESE, "Imediatamente! Forças sombrias se aproximam.", "Entendido. Vou mobilizá-los imediatamente. Quanto ao pagamento - o custo será negociado diretamente com a realeza de Monelix. Não será barato, mas para a defesa do reino, garantiremos que nossos melhores guerreiros sejam mobilizados. Eles partirão dentro de uma hora.");
        cvImmediately.addOptionText(SPANISH, "¡Inmediatamente! Fuerzas oscuras se acercan.", "Entendido. Los movilizaré de inmediato. En cuanto al pago - el costo se negociará directamente con la realeza de Monelix. No será barato, pero para la defensa del reino, aseguraremos que nuestros mejores guerreros sean desplegados. Partirán en una hora.");
        cvImmediately.listeners = (ctx, currentFragment) -> {
            if (LibQuest.isCharacterAtQuestPart(App.getPlayerChar(), REINFORCE_HELERA, 4)) {
                LibQuest.updateQuest(REINFORCE_HELERA, 5, App.getPlayerChar(), ctx);
            } else if (LibQuest.isCharacterAtQuestPart(App.getPlayerChar(), REINFORCE_FARMLAND, 5)) {
                LibQuest.updateQuest(REINFORCE_FARMLAND, 6, App.getPlayerChar(), ctx);
            }
        };
        npc.conversationOptions.add(cvImmediately);

        // ===== QUEST 22: WAZEL BATTLE - PART 2 =====
        ConversationOption cvWazel2 = new ConversationOption(0, 3);
        cvWazel2.addOptionText(ENGLISH, "Katiusca sent me. What's the situation?", "The situation is grim. Dark creatures are converging on Wazel from multiple directions. Katiusca has spotted activity from the sea, but intelligence suggests they're also approaching from the desert - specifically from the cave to the east. My scouts report a large horde gathering there. That's where we'll make our first stand.");
        cvWazel2.addOptionText(PORTUGUESE, "Katiusca me enviou. Qual é a situação?", "A situação é sombria. Criaturas das trevas estão convergindo para Wazel de múltiplas direções. Katiusca avistou atividade do mar, mas a inteligência sugere que também estão se aproximando do deserto - especificamente da caverna ao leste. Meus batedores relatam uma grande horda se reunindo lá. É onde faremos nossa primeira resistência.");
        cvWazel2.addOptionText(SPANISH, "Katiusca me envió. ¿Cuál es la situación?", "La situación es sombría. Criaturas oscuras están convergiendo en Wazel desde múltiples direcciones. Katiusca ha avistado actividad desde el mar, pero la inteligencia sugiere que también se están acercando desde el desierto - específicamente desde la cueva al este. Mis exploradores informan de una gran horda reuniéndose allí. Es donde haremos nuestra primera resistencia.");
        cvWazel2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.WAZEL_BATTLE, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvWazel2);

        ConversationOption cvWazel2Response = new ConversationOption(3, 0);
        cvWazel2Response.addOptionText(ENGLISH, "I'll go to the Desert Cave.", "Excellent. We need someone of your caliber there. My warriors will support from the flanks, but the cave entrance is narrow - perfect for a skilled fighter to hold the line. The oasis to the south is also vulnerable, but we'll deal with that after securing the cave. Move quickly - the attack could begin at any moment!");
        cvWazel2Response.addOptionText(PORTUGUESE, "Vou até a Caverna do Deserto.", "Excelente. Precisamos de alguém do seu calibre lá. Meus guerreiros apoiarão pelos flancos, mas a entrada da caverna é estreita - perfeita para um lutador habilidoso segurar a linha. O oásis ao sul também está vulnerável, mas lidaremos com isso depois de proteger a caverna. Mova-se rapidamente - o ataque pode começar a qualquer momento!");
        cvWazel2Response.addOptionText(SPANISH, "Iré a la Cueva del Desierto.", "Excelente. Necesitamos a alguien de tu calibre allí. Mis guerreros apoyarán desde los flancos, pero la entrada de la cueva es estrecha - perfecta para que un luchador hábil mantenga la línea. El oasis al sur también es vulnerable, pero nos ocuparemos de eso después de asegurar la cueva. ¡Muévete rápido - el ataque podría comenzar en cualquier momento!");
        cvWazel2Response.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(QuestsIds.WAZEL_BATTLE, 3, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvWazel2Response);

        // ===== QUEST 22: WAZEL BATTLE - PART 6 (After Battles) =====
        ConversationOption cvWazel6 = new ConversationOption(0, 0);
        cvWazel6.addOptionText(ENGLISH, "The battles are over. What now?", "You've done incredibly well. Three major engagements, and you held the line every time. Without you, Wazel would have fallen completely. But look around... the cost was immense. The city is in ruins, so many lives lost. This victory feels... hollow. Still, the people survived, and that's what matters. You should return to the city - see what remains. Wazel will rebuild, slowly, but it will never forget what you did here today.");
        cvWazel6.addOptionText(PORTUGUESE, "As batalhas acabaram. E agora?", "Você se saiu incrivelmente bem. Três grandes confrontos, e você segurou a linha todas as vezes. Sem você, Wazel teria caído completamente. Mas olhe ao redor... o custo foi imenso. A cidade está em ruínas, tantas vidas perdidas. Esta vitória parece... vazia. Ainda assim, o povo sobreviveu, e isso é o que importa. Você deveria voltar à cidade - ver o que resta. Wazel se reconstruirá, lentamente, mas nunca esquecerá o que você fez aqui hoje.");
        cvWazel6.addOptionText(SPANISH, "Las batallas han terminado. ¿Y ahora?", "Lo has hecho increíblemente bien. Tres grandes enfrentamientos, y mantuviste la línea cada vez. Sin ti, Wazel habría caído por completo. Pero mira alrededor... el costo fue inmenso. La ciudad está en ruinas, tantas vidas perdidas. Esta victoria se siente... vacía. Aún así, la gente sobrevivió, y eso es lo que importa. Deberías volver a la ciudad - ver lo que queda. Wazel se reconstruirá, lentamente, pero nunca olvidará lo que hiciste aquí hoy.");
        cvWazel6.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.WAZEL_BATTLE, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvWazel6);

        // ========================================
        // QUEST: AWAITING THE DRAGONS
        // ========================================

        // Part 1: Talk to Danjor
        ConversationOption cvAwaitingDragons1 = new ConversationOption(0, 0);
        cvAwaitingDragons1.addOptionText(ENGLISH, "Danjor, I've seen dragons migrating towards our lands. The threat is real.",
                "*He uncrosses his arms, his expression sharpening as he looks towards the distant horizon*\nDragons? So the rumors weren't just tavern talk after all. Wazel may not have the high peaks that those beasts prefer for their nests, but a shadow over the kingdom is a shadow over us all. \n\nI'll put my warriors on high alert. We'll watch the skies and ensure the local outposts are ready for anything. A dragon's presence doesn't just mean fire; it means ruined trade and mass panic. We must remain vigilant. You should continue and warn the others — the higher the mountain, the greater the danger.");
        cvAwaitingDragons1.addOptionText(PORTUGUESE, "Danjor, eu vi dragões migrando para nossas terras. A ameaça é real.",
                "*Ele descruza os braços, sua expressão ficando mais aguçada enquanto olha para o horizonte distante*\nDragões? Então os rumores não eram apenas conversa de taverna, afinal. Wazel pode não ter os picos altos que essas feras preferem para seus ninhos, mas uma sombra sobre o reino é uma sombra sobre todos nós. \n\nVou colocar meus guerreiros em alerta máximo. Vigiaremos os céus e garantiremos que os postos avançados locais estejam prontos para qualquer coisa. A presença de um dragão não significa apenas fogo; significa comércio arruinado e pânico em massa. Devemos permanecer vigilantes. Você deve continuar e avisar os outros — quanto mais alta a montanha, maior o perigo.");
        cvAwaitingDragons1.addOptionText(SPANISH, "Danjor, he visto dragones migrando hacia nuestras tierras. La amenaza es real.",
                "*Descruza los brazos, su expresión se agudiza mientras mira hacia el lejano horizonte*\n¿Dragones? Así que los rumores no eran solo charlas de taberna después de todo. Puede que Wazel no tenga las altas cimas que esas bestias prefieren para sus nidos, pero una sombra sobre el reino es una sombra sobre todos nosotros. \n\nPondré a mis guerreros en alerta máxima. Vigilaremos los cielos y nos aseguraremos de que los puestos locales estén listos para cualquier cosa. La presencia de un dragón no solo significa fuego; significa comercio arruinado y pánico masivo. Debemos permanecer vigilantes. Debes continuar y avisar a los demás: cuanto más alta sea la montaña, mayor será el peligro.");
        cvAwaitingDragons1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.AWAITING_THE_DRAGONS, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvAwaitingDragons1.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(QuestsIds.AWAITING_THE_DRAGONS, 2, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvAwaitingDragons1);


        // ===== GENERAL CONVERSATION =====
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Who are you?", "I'm Danjor Raujo, leader of the Wazel warriors. We're mercenaries and soldiers-for-hire. We specialize in combat and defense. If you need trained fighters, you've come to the right place.");
        cv1.addOptionText(PORTUGUESE, "Quem é você?", "Sou Danjor Raujo, líder dos guerreiros de Wazel. Somos mercenários e soldados de aluguel. Nos especializamos em combate e defesa. Se você precisa de lutadores treinados, veio ao lugar certo.");
        cv1.addOptionText(SPANISH, "¿Quién eres?", "Soy Danjor Raujo, líder de los guerreros de Wazel. Somos mercenarios y soldados de alquiler. Nos especializamos en combate y defensa. Si necesitas guerreros entrenados, has venido al lugar correcto.");
        npc.conversationOptions.add(cv1);

        // ===== ROLEPLAY: Soldiers sent to Monelix =====
        ConversationOption cvRoleplaySoldiers = new ConversationOption(0, 0);
        cvRoleplaySoldiers.addOptionText(ENGLISH, "Your soldiers were very useful in the defense.", "*Nods with satisfaction*\nI'm glad to hear that. My warriors are among the finest in the eastern lands - trained, disciplined, and battle-ready. They know how to follow orders and adapt to any situation. \n*crosses arms proudly*\nAnd I must say, the relations with Monelix continue strong. The gold coins have already arrived as payment - fair and prompt, as always. The kingdom honors its agreements, which is why we're always willing to answer their call.");
        cvRoleplaySoldiers.addOptionText(PORTUGUESE, "Seus soldados foram muito úteis na defesa.", "*Acena com satisfação*\nFico feliz em ouvir isso. Meus guerreiros estão entre os melhores das terras orientais - treinados, disciplinados e prontos para batalha. Eles sabem como seguir ordens e se adaptar a qualquer situação. \n*cruza os braços com orgulho*\nE devo dizer, as relações com Monelix continuam fortes. As moedas de ouro já chegaram como pagamento - justo e pontual, como sempre. O reino honra seus acordos, por isso estamos sempre dispostos a atender seu chamado.");
        cvRoleplaySoldiers.addOptionText(SPANISH, "Tus soldados fueron muy útiles en la defensa.", "*Asiente con satisfacción*\nMe alegra oír eso. Mis guerreros están entre los mejores de las tierras orientales - entrenados, disciplinados y listos para la batalla. Saben cómo seguir órdenes y adaptarse a cualquier situación. \n*cruza los brazos con orgullo*\nY debo decir, las relaciones con Monelix continúan fuertes. Las monedas de oro ya han llegado como pago - justo y puntual, como siempre. El reino honra sus acuerdos, por eso siempre estamos dispuestos a responder a su llamado.");
        cvRoleplaySoldiers.requirementValidations = (chara, ctx) -> {
            boolean soldiersSent = LibQuest.isQuestComplete(chara, REINFORCE_HELERA) || LibQuest.isQuestComplete(chara, REINFORCE_FARMLAND);
            boolean queenMessageStarted = LibQuest.charHasQuest(QuestsIds.A_QUEEN_MESSAGE, chara);
            boolean wazelNotComplete = !LibQuest.isQuestComplete(chara, QuestsIds.WAZEL_BATTLE);

            if (soldiersSent && queenMessageStarted && wazelNotComplete) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplaySoldiers);

        // ========================================
        // WAZEL TOWER ARENA
        // ========================================

        ConversationOption cvArenaRules = new ConversationOption(0, 100);
        cvArenaRules.addOptionText(ENGLISH, "Tell me about the Wazel Tower Arena.",
                "The Tower Arena is the finest combat trial. Five stages, each harder than the last. You face a random opponent from each stage's roster — could be a skeleton, a golem, a medusa... you never know.\n*crosses arms*\nWin all five and the prizes are yours. Lose once and it's over. Entry costs 15 gold.");
        cvArenaRules.addOptionText(PORTUGUESE, "Me fale sobre a Arena da Torre Wazel.",
                "A Arena da Torre é o melhor desafio de combate. Cinco fases, cada uma mais difícil que a anterior. Você enfrenta um oponente aleatório do elenco de cada fase — pode ser um esqueleto, um golem, uma medusa... nunca se sabe.\n*cruza os braços*\nVença todas as cinco e os prêmios são seus. Perca uma vez e acabou. A entrada custa 15 ouros.");
        cvArenaRules.addOptionText(SPANISH, "Háblame de la Arena de la Torre Wazel.",
                "La Arena de la Torre es la mejor prueba de combate. Cinco fases, cada una más difícil que la anterior. Te enfrentas a un oponente aleatorio del elenco de cada fase — puede ser un esqueleto, un golem, una medusa... nunca se sabe.\n*cruza los brazos*\nGana las cinco y los premios son tuyos. Pierde una vez y se acabó. La entrada cuesta 15 monedas.");
        cvArenaRules.requirementValidations = (chara, ctx) -> {
            Arena arena = chara.storyInfo.arenaProgress.get(ArenasIds.WAZEL_TOWER);
            if (arena != null) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cvArenaRules);

        ConversationOption cvArenaPrizes = new ConversationOption(100, 100);
        cvArenaPrizes.addOptionText(ENGLISH, "What are the prizes for winning the arena?", "Let me check...");
        cvArenaPrizes.addOptionText(PORTUGUESE, "Quais são os prêmios por vencer a arena?", "Deixe-me verificar...");
        cvArenaPrizes.addOptionText(SPANISH, "¿Cuáles son los premios por ganar la arena?", "Déjame verificar...");
        cvArenaPrizes.npcAnswerProvider = LibNpc.buildArenaPrizesAnswerProvider(
                ArenasIds.WAZEL_TOWER,
                "*smirks*\nWorth the fight, I'd say.",
                "*sorri*\nVale a luta, eu diria.",
                "*sonríe*\nVale la pelea, diría yo."
        );
        npc.conversationOptions.add(cvArenaPrizes);

        ConversationOption cvArenaEnter = new ConversationOption(100, 102);
        cvArenaEnter.addOptionText(ENGLISH, "I want to enter the arena.",
                "Fifteen gold. The Tower Arena demands respect — and preparation. You sure you're up for it?");
        cvArenaEnter.addOptionText(PORTUGUESE, "Quero entrar na arena.]",
                "Quinze ouros. A Arena da Torre exige respeito — e preparação. Tem certeza que está pronto?");
        cvArenaEnter.addOptionText(SPANISH, "Quiero entrar a la arena.",
                "Quince monedas. La Arena de la Torre exige respeto — y preparación. ¿Seguro que estás listo?");
        cvArenaEnter.showEvenWhenNotValid = true;
        cvArenaEnter.requirementValidations = (chara, ctx) -> {
            Arena progress = chara.storyInfo.arenaProgress.get(ArenasIds.WAZEL_TOWER);
            if (progress != null) return Enums.RequirementVerification.NOT_OK;
            if (chara.checkHasGold(15)) return Enums.RequirementVerification.OK;
            return Enums.RequirementVerification.NEED_GOLD;
        };
        npc.conversationOptions.add(cvArenaEnter);

        ConversationOption cvArenaEnterConfirm = new ConversationOption(102, 0);
        cvArenaEnterConfirm.addOptionText(ENGLISH, "[Pay 15 gold and enter]",
                "Good. Stage 1 awaits. Come back to me when you're ready to fight — I'll call your opponent.");
        cvArenaEnterConfirm.addOptionText(PORTUGUESE, "[Pagar 15 ouros e entrar]",
                "Ótimo. A fase 1 aguarda. Volte quando estiver pronto para lutar — eu chamo seu oponente.");
        cvArenaEnterConfirm.addOptionText(SPANISH, "[Pagar 15 de oro y entrar]",
                "Bien. La fase 1 te espera. Vuelve cuando estés listo para pelear — yo llamo a tu oponente.");
        cvArenaEnterConfirm.listeners = (ctx, currentFragment) -> {
            App.getPlayerChar().removeGold(15);
            Arena arena = App.Shell.flowManager.getActiveArena(ArenasIds.WAZEL_TOWER);
            if (arena != null) {
                arena.currentStage = 1;
                arena.isCompleted = false;
            }
            App.getPlayerChar().storyInfo.arenaProgress.put(ArenasIds.WAZEL_TOWER, arena);
            GameEngine.saveGame(ctx);
        };
        npc.conversationOptions.add(cvArenaEnterConfirm);

        ConversationOption cvArenaEnterDecline = new ConversationOption(102, 0);
        cvArenaEnterDecline.addOptionText(ENGLISH, "Maybe another time.", "The arena will be here. Come back when you're ready.");
        cvArenaEnterDecline.addOptionText(PORTUGUESE, "Talvez em outro momento.", "A arena estará aqui. Volte quando estiver pronto.");
        cvArenaEnterDecline.addOptionText(SPANISH, "Quizás en otro momento.", "La arena estará aquí. Vuelve cuando estés listo.");
        npc.conversationOptions.add(cvArenaEnterDecline);

        ConversationOption cvArenaFight = new ConversationOption(0, 0);
        cvArenaFight.addOptionText(ENGLISH, "I'm ready for my next arena fight.",
                "*Nods sharply*\nStep up, champion. The crowd is watching.\n*signals the gate*");
        cvArenaFight.addOptionText(PORTUGUESE, "Estou pronto para minha próxima luta na arena.",
                "*Acena firmemente*\nVá em frente, campeão. A multidão está assistindo.\n*sinaliza para o portão*");
        cvArenaFight.addOptionText(SPANISH, "Estoy listo para mi próxima pelea en la arena.",
                "*Asiente firmemente*\nAdelante, campeón. El público está mirando.\n*señala la puerta*");
        cvArenaFight.requirementValidations = (chara, ctx) -> {
            Arena progress = chara.storyInfo.arenaProgress.get(ArenasIds.WAZEL_TOWER);
            if (progress == null) return Enums.RequirementVerification.NOT_OK;
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.WAZEL_TOWER);
            if (a != null && !a.isCompleted) return Enums.RequirementVerification.OK;
            return Enums.RequirementVerification.NOT_OK;
        };
        cvArenaFight.listeners = (ctx, currentFragment) -> {
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.WAZEL_TOWER);
            if (a != null) {
                a.defineNextBattle();
                if (a.nextBattle != null && ctx instanceof GameplayActivity gameplayActivity) {
                    if (currentFragment != null) currentFragment.setScreenTouchable(false);
                    new Handler(Looper.getMainLooper()).postDelayed(
                            () -> gameplayActivity.StartBattleScreen(a.nextBattle.uId), 2200);
                }
            }
        };
        npc.conversationOptions.add(cvArenaFight);

        ConversationOption cvArenaProgress = new ConversationOption(0, 0);
        cvArenaProgress.addOptionText(ENGLISH, "What stage of the arena am I in?",
                "Let me check your progress.");
        cvArenaProgress.addOptionText(PORTUGUESE, "Em qual fase da arena eu estou?",
                "Deixe-me verificar seu progresso.");
        cvArenaProgress.addOptionText(SPANISH, "¿En qué fase de la arena estoy?",
                "Déjame revisar tu progreso.");
        cvArenaProgress.requirementValidations = (chara, ctx) -> {
            Arena progress = chara.storyInfo.arenaProgress.get(ArenasIds.WAZEL_TOWER);
            if (progress == null) return Enums.RequirementVerification.NOT_OK;
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.WAZEL_TOWER);
            if (a != null && !a.isCompleted) return Enums.RequirementVerification.OK;
            return Enums.RequirementVerification.NOT_OK;
        };
        cvArenaProgress.npcAnswerProvider = LibNpc.buildArenaProgressAnswerProvider(ArenasIds.WAZEL_TOWER);
        npc.conversationOptions.add(cvArenaProgress);

        ConversationOption cvArenaCollect = new ConversationOption(0, 0);
        cvArenaCollect.addOptionText(ENGLISH, "I've won all 5 stages! Here for my prize.",
                "*raises an eyebrow, then grins*\nSo you actually did it. Five stages, five victories in the Tower Arena. Not many can say that.\n*presents the prizes*\nWell earned, champion. The arena resets — the door is open again whenever you want another run.");
        cvArenaCollect.addOptionText(PORTUGUESE, "Venci todas as 5 fases! Vim pegar meu prêmio.",
                "*ergue uma sobrancelha, depois sorri*\nEntão você realmente conseguiu. Cinco fases, cinco vitórias na Arena da Torre. Poucos podem dizer isso.\n*apresenta os prêmios*\nBem conquistado, campeão. A arena reinicia — a porta está aberta novamente quando quiser.");
        cvArenaCollect.addOptionText(SPANISH, "¡Gané las 5 fases! Vine por mi premio.",
                "*arquea una ceja, luego sonríe*\nEntonces realmente lo lograste. Cinco fases, cinco victorias en la Arena de la Torre. Pocos pueden decir eso.\n*presenta los premios*\nBien ganado, campeón. La arena se reinicia — la puerta está abierta cuando quieras otra vuelta.");
        cvArenaCollect.requirementValidations = (chara, ctx) -> {
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.WAZEL_TOWER);
            if (a != null && a.isCompleted) return Enums.RequirementVerification.OK;
            return Enums.RequirementVerification.NOT_OK;
        };
        cvArenaCollect.listeners = (ctx, currentFragment) -> {
            App.Shell.playSound(AssetsManager.getSoundAsPlayableFile(SFX_QUEST_COMPLETED, ctx), ctx);
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.WAZEL_TOWER);
            if (a != null) {
                Recompense recompense = a.onVictory();
                if (recompense != null) {
                    RecompenseDisplay display = new RecompenseDisplay(ctx, recompense, v -> {
                        GameEngine.closeDialog();
                        if (currentFragment != null) currentFragment.setScreenTouchable(true);
                    });
                    GameEngine.showDialog(new _CnxContentDialog().newInstance(display, false));
                }
            }
            App.getPlayerChar().storyInfo.arenaProgress.remove(ArenasIds.WAZEL_TOWER);
            GameEngine.saveGame(ctx);
        };
        npc.conversationOptions.add(cvArenaCollect);


        return npc;
    }
}

