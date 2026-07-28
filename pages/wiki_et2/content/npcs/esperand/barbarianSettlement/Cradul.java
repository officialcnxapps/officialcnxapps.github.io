package com.cnx.endlesstalestwo.data.npcs.esperand.barbarianSettlement;

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
import com.cnx.endlesstalestwo.data.battles.BattlesIds;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.dialogs._CnxContentDialog;
import com.cnx.endlesstalestwo.displayers.RecompenseDisplay;
import com.cnx.endlesstalestwo.entities.Arena;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Recompense;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibNpc;
import com.cnx.endlesstalestwo.libs.LibQuest;
import com.cnx.endlesstalestwo.managers.AssetsManager;

import java.util.Collections;

public class Cradul extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Cradul");
        npc.age = 40;
        npc.job = Enums.NPCJobs.GUILD_LEADER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A man of few words, serious.\nLeader of the barbarians who commands fear and respect.\nEasily angered and clearly dislikes weak and simplistic people.\n\nHis physical traits: Muscular. Large face, long hair, large beard. Brown eyes with an angry expression.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma pessoa de poucas palavras, sério.\nLíder dos bárbaros que impõe medo e respeito.\nFacilmente raivoso e claramente desgosta de pessoas fracas e simplórias.\n\nSeus traços físicos: Musculoso. Rosto grande, cabelos compridos, barba grande. Olhos castanhos com expressão brava.");
        npc.addDescriptionTranslation(SPANISH, "Una persona de pocas palabras, seria.\nLíder de los bárbaros que impone miedo y respeto.\nSe enfurece con facilidad y claramente detesta a las personas débiles y simplonas.\n\nSus rasgos físicos: Musculoso. Rostro grande, cabello largo, barba grande. Ojos castaños con expresión brava.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("What you want?"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("O que você quer?"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("¿Qué quieres?"));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Go."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Vá."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Ve."));

        // ===== ROLEPLAY: Barbarian leader =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "You're the barbarian leader?", "Cradul lead warriors. Strong fighters. We not need soft city people. You have business or you go.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Você é o líder bárbaro?", "Cradul lidera guerreiros. Lutadores fortes. Nós não precisar de gente fraca da cidade. Você tem negócio ou você vai.");
        cvRoleplay1.addOptionText(SPANISH, "¿Eres el líder bárbaro?", "Cradul lidera guerreros. Luchadores fuertes. No necesitamos gente débil de ciudad. Tienes negocio o te vas.");
        cvRoleplay1.requirementValidations = (chara, ctx) -> {
            // Only show before or after quest
            if (!LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SMUGGLER, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay1);

        // ===== QUEST: Smuggler - Delivery (Part 2→3) =====
        ConversationOption cvDelivery = new ConversationOption(0, 1);
        cvDelivery.addOptionText(ENGLISH, "I have a delivery from the priest.", "*Eyes narrow suspiciously, hand moves to weapon*\nPriest? What priest? Many people claim things. \n*Steps closer, intimidating*\nWhy I trust you?");
        cvDelivery.addOptionText(PORTUGUESE, "Tenho uma entrega do sacerdote.", "*Olhos se estreitam com desconfiança, mão se move para a arma*\nSacerdote? Que sacerdote? Muitas pessoas alegam coisas. \n*Se aproxima, intimidador*\nPor que eu confiaria em você?");
        cvDelivery.addOptionText(SPANISH, "Tengo una entrega del sacerdote.", "*Los ojos se estrechan con desconfianza, la mano se mueve hacia el arma*\n¿Sacerdote? ¿Qué sacerdote? Mucha gente dice cosas. \n*Se acerca, intimidante*\n¿Por qué confiar en ti?");
        cvDelivery.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SMUGGLER, 2)) {
                // Check if player has the contraband package
                boolean hasPackage = LibInventory.checkHasItemAmount(ItemsIds.CONTRABAND_PACKAGE, 1, chara);
                if (hasPackage) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvDelivery);

        ConversationOption cvShowToken = new ConversationOption(1, 0);
        cvShowToken.addOptionText(ENGLISH, "[Show Mordius's token and the package]", "*You show the marked token. Cradul's expression changes immediately*\n\n*Grunts in recognition*\nAh. The priest runner. \n*Takes package without opening it, inspects the token*\nGood. \n*Tosses you a heavy coin purse*\nPayment. More gold than expected, yes? We pay well for... discretion. \n*Puts token in his belt*\nGive priest his share. Tell him... good business continues. \n*Turns away dismissively*\nWe done. Go.");
        cvShowToken.addOptionText(PORTUGUESE, "[Mostrar ficha de Mordius e o pacote]", "*Você mostra a ficha marcada. A expressão de Cradul muda imediatamente*\n\n*Grunhe em reconhecimento*\nAh. O mensageiro do sacerdote. \n*Pega o pacote sem abrir, inspeciona a ficha*\nBom. \n*Joga para você uma pesada bolsa de moedas*\nPagamento. Mais ouro do que esperava, sim? Pagamos bem por... discrição. \n*Coloca a ficha em seu cinto*\nDar ao sacerdote a parte dele. Dizer a ele... bons negócios continuam. \n*Se vira desdenhosamente*\nTerminamos. Ir.");
        cvShowToken.addOptionText(SPANISH, "[Mostrar ficha de Mordius y el paquete]", "*Muestras la ficha marcada. La expresión de Cradul cambia inmediatamente*\n\n*Gruñe en reconocimiento*\nAh. El mensajero del sacerdote. \n*Toma el paquete sin abrirlo, inspecciona la ficha*\nBien. \n*Te arroja una pesada bolsa de monedas*\nPago. Más oro de lo esperado, ¿sí? Pagamos bien por... discreción. \n*Pone la ficha en su cinturón*\nDale al sacerdote su parte. Dile... buenos negocios continúan. \n*Se da la vuelta desdeñosamente*\nTerminamos. Vete.");
        cvShowToken.listeners = (ctx, currentFragment) -> {
            // Remove contraband package from inventory
            LibInventory.removeFromInventory(ItemsIds.CONTRABAND_PACKAGE, 1, App.getPlayerChar());
            // Update quest to part 3 (return to Mordius)
            LibQuest.updateQuest(QuestsIds.SMUGGLER, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvShowToken);

        // ========================================
        // QUEST: CONTRABAND
        // ========================================

        // Part 1: Player asks Cradul for the package (group 0 → 0)
        ConversationOption cvContrabandPart1 = new ConversationOption(0, 0);
        cvContrabandPart1.addOptionText(ENGLISH,
                "Mordius sent me. He needs the package.",
                "*Cradul stares at you for a long moment, then grunts in recognition*\nAh. Priest runner again. \n*Disappears briefly and returns with a wrapped bundle*\nHere. Tell priest this batch is... special. Handle carefully. \n*Shoves the package into your hands*\nNow go. Not stay here with that.");
        cvContrabandPart1.addOptionText(PORTUGUESE,
                "Mordius me enviou. Ele precisa do pacote.",
                "*Cradul te encarou por um longo momento, depois grunhe em reconhecimento*\nAh. O mensageiro do sacerdote de novo. \n*Desaparece brevemente e volta com um embrulho*\nAqui. Diga ao sacerdote que este lote é... especial. Manuseie com cuidado. \n*Empurra o pacote para as suas mãos*\nAgora vá. Não ficar aqui com isso.");
        cvContrabandPart1.addOptionText(SPANISH,
                "Mordius me envió. Necesita el paquete.",
                "*Cradul te mira fijamente durante un largo momento, luego gruñe en reconocimiento*\nAh. El mensajero del sacerdote otra vez. \n*Desaparece brevemente y vuelve con un bulto envuelto*\nAquí. Dile al sacerdote que este lote es... especial. Maneja con cuidado. \n*Te empuja el paquete en las manos*\nAhora vete. No quedarse aquí con eso.");
        cvContrabandPart1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CONTRABAND, 1)
                    && !LibInventory.checkHasItem(ItemsIds.CONTRABAND_PACKAGE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvContrabandPart1.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.CONTRABAND_PACKAGE, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.CONTRABAND, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvContrabandPart1);

        // Part 1 (already has package - reminder to go to Mordius)
        ConversationOption cvContrabandPart1Reminder = new ConversationOption(0, 0);
        cvContrabandPart1Reminder.addOptionText(ENGLISH,
                "About the package...",
                "*Cradul narrows his eyes and crosses his arms*\nYou already have what you need. Take it to priest. Not come back here until done.");
        cvContrabandPart1Reminder.addOptionText(PORTUGUESE,
                "Sobre o pacote...",
                "*Cradul entrecerra os olhos e cruza os braços*\nVocê já tem o que precisa. Leve ao sacerdote. Não voltar aqui até terminar.");
        cvContrabandPart1Reminder.addOptionText(SPANISH,
                "Sobre el paquete...",
                "*Cradul entrecierra los ojos y cruza los brazos*\nYa tienes lo que necesitas. Llévalo al sacerdote. No volver aquí hasta terminar.");
        cvContrabandPart1Reminder.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CONTRABAND, 1)
                    && LibInventory.checkHasItem(ItemsIds.CONTRABAND_PACKAGE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvContrabandPart1Reminder);

        // ========================================
        // ARENA: FROZEN ARENA MANAGEMENT
        // ========================================

        ConversationOption cvRules = new ConversationOption(0, 2);
        cvRules.addOptionText(ENGLISH, "Tell me about the Frozen Arena.",
                "Frozen Arena for real warriors. You face 5 battles. Each time, random enemy from stage list. You win all 5, you get Ruby Goblet. Very valuable. Very rare.\n*grins*\nBut if you fall once, you lose. Pay again, start from first stage. No weaklings allowed.");
        cvRules.addOptionText(PORTUGUESE, "Me fale sobre a Arena Congelada.",
                "Arena Congelada para guerreiros de verdade. Você enfrenta 5 batalhas. Cada vez, um inimigo aleatório da lista da fase. Se vencer as 5, ganha a Taça de Rubi. Muito valiosa. Muito rara.\n*sorri*\nMas se cair uma vez, perdeu. Pague de novo, comece da primeira fase. Fracos não entram.");
        cvRules.addOptionText(SPANISH, "Háblame de la Arena Helada.",
                "Arena Helada para guerreros de verdad. Te enfrentas a 5 batallas. Cada vez, un enemigo aleatorio de la lista de la etapa. Ganas las 5 y te llevas la Copa de Rubí. Muy valiosa. Muy rara.\n*sonríe*\nPero si caes una vez, pierdes. Paga de nuevo, empieza desde la primera etapa. No se admiten debiluchos.");
        cvRules.requirementValidations = (chara, ctx) -> {
            Arena arena = chara.storyInfo.arenaProgress.get(ArenasIds.FROZEN_ARENA);
            if (arena != null) return Enums.RequirementVerification.NOT_OK;
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cvRules);

        ConversationOption cvPrizes = new ConversationOption(2, 2);
        cvPrizes.addOptionText(ENGLISH, "What are the prizes for winning?", "Check yourself...");
        cvPrizes.addOptionText(PORTUGUESE, "Quais são os prêmios por vencer?", "Veja você mesmo...");
        cvPrizes.addOptionText(SPANISH, "¿Cuáles son los premios por ganar?", "Compruébalo tú mismo...");
        cvPrizes.npcAnswerProvider = LibNpc.buildArenaPrizesAnswerProvider(
                ArenasIds.FROZEN_ARENA,
                "Win and it's yours.",
                "Vença e será seu.",
                "Gana y será tuyo."
        );
        npc.conversationOptions.add(cvPrizes);

        ConversationOption cvEnter = new ConversationOption(2, 3);
        cvEnter.addOptionText(ENGLISH, "I want to enter the arena.",
                "Thirty gold to enter. High price for high glory. You have gold, or you waste Cradul time?");
        cvEnter.addOptionText(PORTUGUESE, "Quero entrar na arena.",
                "Trinta ouros para entrar. Preço alto para glória alta. Tem o ouro ou está perdendo o tempo de Cradul?");
        cvEnter.addOptionText(SPANISH, "Quiero entrar a la arena.",
                "Treinta de oro para entrar. Precio alto para gran gloria. ¿Tienes el oro o estás perdiendo el tiempo de Cradul?");
        cvEnter.showEvenWhenNotValid = true;
        cvEnter.requirementValidations = (chara, ctx) -> {
            Arena arena = chara.storyInfo.arenaProgress.get(ArenasIds.FROZEN_ARENA);
            if (arena != null) return Enums.RequirementVerification.NOT_OK;
            if (chara.checkHasGold(30)) return Enums.RequirementVerification.OK;
            return Enums.RequirementVerification.NEED_GOLD;
        };
        npc.conversationOptions.add(cvEnter);

        ConversationOption cvEnterConfirm = new ConversationOption(3, 0);
        cvEnterConfirm.addOptionText(ENGLISH, "[Pay 30 gold and enter]",
                "Good. Arena is open. Tell me when ready for first fight. Don't freeze.");
        cvEnterConfirm.addOptionText(PORTUGUESE, "[Pagar 30 ouros e entrar]",
                "Bom. Arena está aberta. Me diga quando estiver pronto para a primeira luta. Não congele.");
        cvEnterConfirm.addOptionText(SPANISH, "[Pagar 30 de oro y entrar]",
                "Bien. La arena está abierta. Dime cuando estés listo para la primera pelea. No te congeles.");
        cvEnterConfirm.listeners = (ctx, currentFragment) -> {
            App.getPlayerChar().removeGold(30);
            Arena arena = App.Shell.flowManager.getActiveArena(ArenasIds.FROZEN_ARENA);
            if (arena != null) {
                arena.currentStage = 1;
                arena.isCompleted = false;
            }
            App.getPlayerChar().storyInfo.arenaProgress.put(ArenasIds.FROZEN_ARENA, arena);
            GameEngine.saveGame(ctx);
        };
        npc.conversationOptions.add(cvEnterConfirm);

        ConversationOption cvStartBattle = new ConversationOption(0, 0);
        cvStartBattle.addOptionText(ENGLISH, "I'm ready for my next fight in the Frozen Arena.",
                "Fight begins now! *blows a frozen horn*");
        cvStartBattle.addOptionText(PORTUGUESE, "Estou pronto para minha próxima luta na Arena Congelada.",
                "A luta começa agora! *toca um berrante congelado*");
        cvStartBattle.addOptionText(SPANISH, "Estoy listo para mi próxima pelea en la Arena Helada.",
                "¡La lucha empieza ahora! *toca un cuerno helado*");
        cvStartBattle.requirementValidations = (chara, ctx) -> {
            Arena progress = chara.storyInfo.arenaProgress.get(ArenasIds.FROZEN_ARENA);
            if (progress == null) return Enums.RequirementVerification.NOT_OK;
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.FROZEN_ARENA);
            if (a != null && !a.isCompleted) return Enums.RequirementVerification.OK;
            return Enums.RequirementVerification.NOT_OK;
        };
        cvStartBattle.listeners = (ctx, currentFragment) -> {
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.FROZEN_ARENA);
            if (a != null) {
                a.defineNextBattle();
                if (a.nextBattle != null && ctx instanceof GameplayActivity gameplayActivity) {
                    if (currentFragment != null) currentFragment.setScreenTouchable(false);
                    new Handler(Looper.getMainLooper()).postDelayed(() -> gameplayActivity.StartBattleScreen(a.nextBattle.uId), 2000);
                }
            }
        };
        npc.conversationOptions.add(cvStartBattle);

        ConversationOption cvArenaProgress = new ConversationOption(0, 0);
        cvArenaProgress.addOptionText(ENGLISH, "What stage of the Frozen Arena am I in?", "I check...");
        cvArenaProgress.addOptionText(PORTUGUESE, "Em qual fase da Arena Congelada eu estou?", "Vou ver...");
        cvArenaProgress.addOptionText(SPANISH, "¿En qué etapa de la Arena Helada estoy?", "Compruebo...");
        cvArenaProgress.requirementValidations = (chara, ctx) -> {
            Arena progress = chara.storyInfo.arenaProgress.get(ArenasIds.FROZEN_ARENA);
            if (progress == null) return Enums.RequirementVerification.NOT_OK;
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.FROZEN_ARENA);
            if (a != null && !a.isCompleted) return Enums.RequirementVerification.OK;
            return Enums.RequirementVerification.NOT_OK;
        };
        cvArenaProgress.npcAnswerProvider = LibNpc.buildArenaProgressAnswerProvider(ArenasIds.FROZEN_ARENA);
        npc.conversationOptions.add(cvArenaProgress);

        ConversationOption cvCollectPrize = new ConversationOption(0, 0);
        cvCollectPrize.addOptionText(ENGLISH, "I've won! Give me the Ruby Goblet.",
                "*grunts with rare respect*\nYou survived the ice. You are warrior. Take prize. Go now.");
        cvCollectPrize.addOptionText(PORTUGUESE, "Eu venci! Me dê a Taça de Rubi.",
                "*grunhe com um raro respeito*\nVocê sobreviveu ao gelo. Você é guerreiro. Pegue o prêmio. Vá agora.");
        cvCollectPrize.addOptionText(SPANISH, "¡He ganado! Dame la Copa de Rubí.",
                "*gruñe con un respeto poco común*\nSobreviviste al hielo. Eres un guerrero. Toma tu premio. Vete ya.");
        cvCollectPrize.requirementValidations = (chara, ctx) -> {
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.FROZEN_ARENA);
            if (a != null && a.isCompleted) return Enums.RequirementVerification.OK;
            return Enums.RequirementVerification.NOT_OK;
        };
        cvCollectPrize.listeners = (ctx, currentFragment) -> {
            App.Shell.playSound(AssetsManager.getSoundAsPlayableFile(SFX_QUEST_COMPLETED, ctx), ctx);
            Arena a = App.Shell.flowManager.getActiveArena(ArenasIds.FROZEN_ARENA);
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
            App.getPlayerChar().storyInfo.arenaProgress.remove(ArenasIds.FROZEN_ARENA);
            GameEngine.saveGame(ctx);
        };
        npc.conversationOptions.add(cvCollectPrize);

        return npc;
    }
}
