package com.cnx.endlesstalestwo.data.npcs.havarusNorth.swampIsland.fortress;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.entities.Constants.SFX_QUEST_COMPLETED;

import android.os.Handler;
import android.os.Looper;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.GameEngine;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.arenas.ArenasIds;
import com.cnx.endlesstalestwo.dialogs._CnxContentDialog;
import com.cnx.endlesstalestwo.displayers.RecompenseDisplay;
import com.cnx.endlesstalestwo.entities.Arena;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Recompense;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibNpc;
import com.cnx.endlesstalestwo.managers.AssetsManager;

public class Fargus extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Fargus");
        npc.age = 52;
        npc.job = Enums.NPCJobs.GUARD;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A classic, unpleasant, and malicious bandit.\nHis intellect is weak, but he is nonetheless clever.\nCrude and sloppy.\n\nHis physical traits: Pale skin from lack of sun, thin cheeks, deep dark circles under his eyes. Light brown hair and a gray beard from dirt.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um bandido clássico, desagradável e malicioso.\nSeu intelecto é fraco, mas não deixa de ser esperto.\nGrosso e desleixado.\n\nSeus traços físicos: Pele pálida pela falta de sol, bochechas magras, olheiras profundas. Cabelo castanho claro e barba cinza de sujeira.");
        npc.addDescriptionTranslation(SPANISH, "Un bandido clásico, desagradable y malicioso.\nSu intelecto es débil, pero aun así es astuto.\nGrosero y desaliñado.\n\nSus rasgos físicos: piel pálida por falta de sol, mejillas delgadas, ojeras profundas. Cabello castaño claro y barba gris por la suciedad.");

        npc.generateRandomGreetings();
        npc.generateRandomByes();


        // ========================================
        // ROLEPLAY
        // ========================================

        ConversationOption cvRoleplay = new ConversationOption(0, 0);
        cvRoleplay.addOptionText(ENGLISH, "Who are you?",
                "Name's Fargus. I run the Swamp Fortress Arena — been doing it for fifteen years. You want a fight, you come to me. You want a fair fight, you still come to me.\n*grins*");
        cvRoleplay.addOptionText(PORTUGUESE, "Quem é você?",
                "Me chamo Fargus. Eu gerencio a Arena do Forte do Pântano — faço isso há quinze anos. Quer uma luta, vem até mim. Quer uma luta justa, ainda vem até mim.\n*sorri*");
        cvRoleplay.addOptionText(SPANISH, "¿Quién eres?",
                "Me llamo Fargus. Dirijo la Arena del Fuerte del Pantano — llevo quince años haciéndolo. Si quieres pelea, vienes a mí. Si quieres una pelea justa, también.\n*sonríe*");
        npc.conversationOptions.add(cvRoleplay);


        // ========================================
        // ARENA: RULES
        // ========================================

        ConversationOption cvRules = new ConversationOption(0, 1);
        cvRules.addOptionText(ENGLISH, "Tell me about the arena.",
                "Simple rules: you face 5 battles in sequence. Each stage, you fight a random challenger from that stage's roster. Win all 5 and you take the prize.\n*leans forward*\nBut if you lose even one — it's over. Pay the entry fee again and start from stage 1. No shortcuts.");
        cvRules.addOptionText(PORTUGUESE, "Me fale sobre a arena.",
                "Regras simples: você enfrenta 5 batalhas em sequência. Em cada fase, você luta contra um desafiante aleatório daquela fase. Vença todas as 5 e leve o prêmio.\n*se inclina para frente*\nMas se perder uma sequer — acabou. Pague a taxa de entrada novamente e comece da fase 1. Sem atalhos.");
        cvRules.addOptionText(SPANISH, "Háblame de la arena.",
                "Reglas simples: enfrentas 5 batallas seguidas. En cada fase, peleas contra un rival aleatorio de esa fase. Gana las 5 y te llevas el premio.\n*se inclina*\nPero si pierdes una sola — se acabó. Paga la entrada otra vez y empieza desde la fase 1. Sin atajos.");
        cvRules.requirementValidations = (chara, ctx) -> {
            Arena arena = chara.storyInfo.arenaProgress.get(ArenasIds.SWAMP_FORTRESS);
            if (arena != null) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cvRules);

        // ========================================
        // ARENA: PRIZES PREVIEW
        // ========================================

        ConversationOption cvPrizes = new ConversationOption(1, 1);
        cvPrizes.addOptionText(ENGLISH, "What are the prizes for winning?", "Let me check...");
        cvPrizes.addOptionText(PORTUGUESE, "Quais são os prêmios por vencer?", "Deixe-me verificar...");
        cvPrizes.addOptionText(SPANISH, "¿Cuáles son los premios por ganar?", "Déjame verificar...");
        cvPrizes.npcAnswerProvider = LibNpc.buildArenaPrizesAnswerProvider(
                ArenasIds.SWAMP_FORTRESS,
                "*nods confidently*\nAll locked in for you, champion.",
                "*acena com confiança*\nEstão reservados para você, campeão.",
                "*asiente con confianza*\nYa están reservados para ti, campeón."
        );
        npc.conversationOptions.add(cvPrizes);

        // ========================================
        // ARENA: ENTER (0 → 1 for confirmation)
        // ========================================

        ConversationOption cvEnter = new ConversationOption(1, 2);
        cvEnter.addOptionText(ENGLISH, "I want to enter the arena. ",
                "Eight gold to compete — fair enough for what you're getting. You sure you're ready? The creatures in this arena don't care about your reputation.");
        cvEnter.addOptionText(PORTUGUESE, "Quero entrar na arena. ",
                "Oito ouros para competir — justo pelo que você vai receber. Tem certeza que está pronto? As criaturas desta arena não ligam para sua reputação.");
        cvEnter.addOptionText(SPANISH, "Quiero entrar a la arena.",
                "Ocho monedas para competir — justo por lo que recibirás. ¿Seguro que estás listo? Las criaturas de esta arena no se preocupan por tu reputación.");
        cvEnter.showEvenWhenNotValid = true;
        cvEnter.requirementValidations = (chara, ctx) -> {
            Arena arena = chara.storyInfo.arenaProgress.get(ArenasIds.SWAMP_FORTRESS);
            if (arena != null) {
                return Enums.RequirementVerification.NOT_OK;
            }
            if (chara.checkHasGold(8)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        npc.conversationOptions.add(cvEnter);

        // Confirm entry
        ConversationOption cvEnterConfirm = new ConversationOption(2, 0);
        cvEnterConfirm.addOptionText(ENGLISH, "[Pay 8 gold and enter]",
                "Good. The arena is yours, champion. Go to stage 1 whenever you're ready — just tell me and I'll call your first opponent.");
        cvEnterConfirm.addOptionText(PORTUGUESE, "[Pagar 8 ouros e entrar]",
                "Ótimo. A arena é sua, campeão. Vá para a fase 1 quando estiver pronto — é só me avisar e eu chamarei seu primeiro oponente.");
        cvEnterConfirm.addOptionText(SPANISH, "[Pagar 8 de oro y entrar]",
                "Bien. La arena es tuya, campeón. Ve a la fase 1 cuando estés listo — solo dímelo y llamaré a tu primer oponente.");
        cvEnterConfirm.listeners = (ctx, currentFragment) -> {
            App.getPlayerChar().removeGold(8);
            Arena arena = App.Shell.flowManager.getActiveArena(ArenasIds.SWAMP_FORTRESS);
            if (arena != null) {
                arena.currentStage = 1;
                arena.isCompleted = false;
            }
            App.getPlayerChar().storyInfo.arenaProgress.put(ArenasIds.SWAMP_FORTRESS, arena);
            GameEngine.saveGame(ctx);
        };
        npc.conversationOptions.add(cvEnterConfirm);

        // Decline entry
        ConversationOption cvEnterDecline = new ConversationOption(2, 0);
        cvEnterDecline.addOptionText(ENGLISH, "Maybe next time.",
                "Come back when you're ready. The arena isn't going anywhere.");
        cvEnterDecline.addOptionText(PORTUGUESE, "Talvez na próxima vez.",
                "Volte quando estiver pronto. A arena não vai a lugar nenhum.");
        cvEnterDecline.addOptionText(SPANISH, "Quizás la próxima vez.",
                "Vuelve cuando estés listo. La arena no va a ningún lado.");
        npc.conversationOptions.add(cvEnterDecline);

        // ========================================
        // ARENA: START NEXT BATTLE
        // ========================================

        ConversationOption cvStartBattle = new ConversationOption(0, 0);
        cvStartBattle.addOptionText(ENGLISH, "I'm ready for my next fight.",
                "That's what I like to hear. *blows the horn*\nStep into the arena, champion. Your opponent is waiting.");
        cvStartBattle.addOptionText(PORTUGUESE, "Estou pronto para a minha próxima luta.",
                "É isso que gosto de ouvir. *toca o chifre*\nEntre na arena, campeão. Seu oponente está esperando.");
        cvStartBattle.addOptionText(SPANISH, "Estoy listo para mi próxima pelea.",
                "Eso es lo que me gusta escuchar. *toca el cuerno*\n¡Entra a la arena, campeón. Tu oponente te espera.");
        cvStartBattle.requirementValidations = (chara, ctx) -> {
            Arena progress = chara.storyInfo.arenaProgress.get(ArenasIds.SWAMP_FORTRESS);
            if (progress == null) return Enums.RequirementVerification.NOT_OK;
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.SWAMP_FORTRESS);
            if (a != null && !a.isCompleted) return Enums.RequirementVerification.OK;
            return Enums.RequirementVerification.NOT_OK;
        };
        cvStartBattle.listeners = (ctx, currentFragment) -> {
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.SWAMP_FORTRESS);
            if (a != null) {
                a.defineNextBattle();
                if (a.nextBattle != null && ctx instanceof GameplayActivity gameplayActivity) {
                    if (currentFragment != null) currentFragment.setScreenTouchable(false);
                    new Handler(Looper.getMainLooper()).postDelayed(() -> gameplayActivity.StartBattleScreen(a.nextBattle.uId), 2200);
                }
            }
        };
        npc.conversationOptions.add(cvStartBattle);

        ConversationOption cvArenaProgress = new ConversationOption(0, 0);
        cvArenaProgress.addOptionText(ENGLISH, "What stage of the arena am I in?",
                "Let me check your progress.");
        cvArenaProgress.addOptionText(PORTUGUESE, "Em qual fase da arena eu estou?",
                "Deixe-me verificar seu progresso.");
        cvArenaProgress.addOptionText(SPANISH, "¿En qué fase de la arena estoy?",
                "Déjame revisar tu progreso.");
        cvArenaProgress.requirementValidations = (chara, ctx) -> {
            Arena progress = chara.storyInfo.arenaProgress.get(ArenasIds.SWAMP_FORTRESS);
            if (progress == null) return Enums.RequirementVerification.NOT_OK;
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.SWAMP_FORTRESS);
            if (a != null && !a.isCompleted) return Enums.RequirementVerification.OK;
            return Enums.RequirementVerification.NOT_OK;
        };
        cvArenaProgress.npcAnswerProvider = LibNpc.buildArenaProgressAnswerProvider(ArenasIds.SWAMP_FORTRESS);
        npc.conversationOptions.add(cvArenaProgress);

        // ========================================
        // ARENA: COLLECT PRIZE (all 5 stages won)
        // ========================================

        ConversationOption cvCollectPrize = new ConversationOption(0, 0);
        cvCollectPrize.addOptionText(ENGLISH, "I've won all 5 stages! Here for my prize.",
                "*stands and applauds slowly*\nWell done, champion. Five stages, five victories. You've earned it.\n*hands over the prizes*\nThe arena is reset — come back whenever you want another shot at glory.");
        cvCollectPrize.addOptionText(PORTUGUESE, "Venci todas as 5 fases! Vim pegar meu prêmio.",
                "*levanta e aplaude lentamente*\nMuito bem, campeão. Cinco fases, cinco vitórias. Você merece.\n*entrega os prêmios*\nA arena foi reiniciada — volte quando quiser outra chance de glória.");
        cvCollectPrize.addOptionText(SPANISH, "¡Gané las 5 fases! Vine por mi premio.",
                "*se levanta y aplaude lentamente*\nMuy bien, campeón. Cinco fases, cinco victorias. Te lo has ganado.\n*entrega los premios*\nLa arena fue reiniciada — vuelve cuando quieras otra oportunidad de gloria.");
        cvCollectPrize.requirementValidations = (chara, ctx) -> {
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.SWAMP_FORTRESS);
            if (a != null && a.isCompleted) return Enums.RequirementVerification.OK;
            return Enums.RequirementVerification.NOT_OK;
        };
        cvCollectPrize.listeners = (ctx, currentFragment) -> {
            App.Shell.playSound(AssetsManager.getSoundAsPlayableFile(SFX_QUEST_COMPLETED, ctx), ctx);
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.SWAMP_FORTRESS);
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
            App.getPlayerChar().storyInfo.arenaProgress.remove(ArenasIds.SWAMP_FORTRESS);
            GameEngine.saveGame(ctx);
        };
        npc.conversationOptions.add(cvCollectPrize);

        return npc;
    }
}
