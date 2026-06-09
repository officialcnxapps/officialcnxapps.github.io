package com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian.market;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import android.content.Context;
import android.os.Looper;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.GameEngine;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.knowledges.KnowledgesIds;
import com.cnx.endlesstalestwo.data.quests.PotionsFromExterior;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.Character;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.GameplayCoreEntity;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Zilays extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Zilays");
        npc.age = 31;
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        //This NPC lives in a narrow alley, she is kid of a bandit/smuggler, she may give player a quest if player has a bad alignment.
        //Also, she produces clandestine potions in a makeshift alchemy table.

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "You seem to know this alley well.", "Well enough to know who passes, who lies, and who suddenly has coins after dark. Bastian's narrow streets hear more truth than noble halls.");
        cv1.addOptionText(PORTUGUESE, "Você parece conhecer bem este beco.", "Bem o bastante para saber quem passa, quem mente e quem de repente aparece com moedas depois do anoitecer. As ruas estreitas de Bastian ouvem mais verdades do que os salões nobres.");
        cv1.addOptionText(SPANISH, "Parece que conoces bien este callejón.", "Lo bastante como para saber quién pasa, quién miente y quién aparece de repente con monedas después del anochecer. Las calles estrechas de Bastian oyen más verdades que los salones nobles.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 1);
        cv2.addOptionText(ENGLISH, "That alchemy table in the back, is it for alchemy?", "*Turns her head toward the table, then looks back at you with a serious expression*\nHow do you know? I run some experiments from time to time, and when I succeed I sell my products to certain... specific buyers. Looks like you know the trade.");
        cv2.addOptionText(PORTUGUESE, "Aquela mesa improvisada ali no fundo, é para alquimia?", "*Vira a cabeça para a mesa e volta o olhar para você com seriedade*\nComo você sabe? Eu as vezes faço alguns experimentos e quando tenho sucesso vendo meus produtos para alguns compradores 'específicos'. Você pelo jeito conhece o ofício.");
        cv2.addOptionText(SPANISH, "Esa mesa improvisada del fondo, ¿es para alquimia?", "*Gira la cabeza hacia la mesa y vuelve a mirarte con seriedad*\n¿Cómo lo sabes? A veces hago algunos experimentos y cuando tengo éxito vendo mis productos a ciertos compradores 'específicos'. Parece que conoces el oficio.");
        cv2.requirementValidations = new GameplayCoreEntity.RequirementsValidations() {
            @Override
            public Enums.RequirementVerification check(Character chara, Context ctx) {
                if (chara.hasKnowledge(KnowledgesIds.ALCHEMY)) {
                    return Enums.RequirementVerification.OK;
                }
                return Enums.RequirementVerification.NOT_OK;
            }
        };
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(1, 2);
        cv3.addOptionText(ENGLISH, "I know a bit about alchemy, can I use the table?", "*Looks at you with a hint of suspicion*\nHmmm... well, you really do seem to know your stuff. No one ever paid attention to that table before. Alright, you can use it, just don't break my flasks.");
        cv3.addOptionText(PORTUGUESE, "Conheço algo sobre alquimia, posso usar a mesa?", "*Lhe olha com um pouco de suspeita*\nHmmm... bom você parece conhecer mesmo, ninguém nunca tinha dado atenção a mesa. Então, pode usar sim, só não quebre meus frascos.");
        cv3.addOptionText(SPANISH, "Sé algo de alquimia, ¿puedo usar la mesa?", "*Te mira con un poco de desconfianza*\nHmmm... bueno, parece que realmente sabes del tema. Nadie nunca le había prestado atención a esa mesa. Bueno, puedes usarla, solo no rompas mis frascos.");
        npc.conversationOptions.add(cv3);

        ConversationOption cv0 = new ConversationOption(1, 0);
        cv0.addOptionText(ENGLISH, "Alchemy is quite interesting.", "It is, and also dangerous if you mix the wrong things. I almost lost my fingers once when I mixed mushrooms with some shiny rocks and wine.");
        cv0.addOptionText(PORTUGUESE, "Alquimia é interessante.", "Pois sim, é também um perigo se misturarmos as coisas erradas. Já quase perdi os dedos uma vez que misturei cogumelos com umas pedras brilhosas e vinho.");
        cv0.addOptionText(SPANISH, "La alquimia es interesante.", "Claro que sí, pero también es peligrosa si mezclas las cosas equivocadas. Casi pierdo los dedos una vez que mezclé hongos con unas piedras brillantes y vino.");
        npc.conversationOptions.add(cv0);

        ConversationOption cv4 = new ConversationOption(2, 999);
        cv4.addOptionText(ENGLISH, "Thank you.", "If you brew something good, show me...");
        cv4.addOptionText(PORTUGUESE, "Obrigado.", "Se produzir algo bom, me mostre...");
        cv4.addOptionText(SPANISH, "Gracias.", "Si preparas algo bueno, muéstramelo...");
        cv4.listeners = (ctx, currentFragment) -> {
            if (App.getPlayerChar() != null) {
                App.getPlayerChar().removeGold(1);
                if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                    gPlayActivity.lockScreenTouches(true);
                    new android.os.Handler(Looper.getMainLooper()).postDelayed(() -> {
                        GameEngine.saveGame(ctx);
                        gPlayActivity.goToCraft(Enums.CraftTypes.ALCHEMY);
                    }, 2200);
                }
            }
        };
        npc.conversationOptions.add(cv4);

        // ========================================
        // QUEST: POTIONS FROM EXTERIOR
        // ========================================

        ConversationOption cvPFEStart = new ConversationOption(0, 10);
        cvPFEStart.addOptionText(ENGLISH, "Do you need help with anything, Zilays?",
                "*She drums her fingers on the table*\nActually... there are some potions out there I've been trying to get my hands on. Unidentified ones — I want to study their composition.\nI heard Griwalsh has one at his farmhouse and another man named Alden in Lisport has another. Could you bring them to me?");
        cvPFEStart.addOptionText(PORTUGUESE, "Você precisa de ajuda com algo, Zilays?",
                "*Ela tambila os dedos na mesa*\nNa verdade... há algumas poções por aí que tenho tentado colocar as mãos. Não identificadas — quero estudar a composição delas.\nOuvi dizer que Griwalsh tem uma em sua fazenda e outro homem chamado Alden em Lisport tem outra. Você poderia trazê-las para mim?");
        cvPFEStart.addOptionText(SPANISH, "¿Necesitas ayuda con algo, Zilays?",
                "*Tamborilea los dedos sobre la mesa*\nEn realidad... hay algunas pociones por ahí que he intentado conseguir. No identificadas — quiero estudiar su composición.\nEscuché que Griwalsh tiene una en su granja y otra persona llamada Alden en Lisport tiene otra. ¿Podrías traérmelas?");
        cvPFEStart.requirementValidations = (chara, ctx) -> {
            if (chara.hasKnowledge(KnowledgesIds.ALCHEMY)
                    && !LibQuest.charHasQuest(QuestsIds.POTIONS_FROM_EXTERIOR, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPFEStart);

        ConversationOption cvPFEAccept = new ConversationOption(10, 0);
        cvPFEAccept.addOptionText(ENGLISH, "Sure, I'll find those potions for you.",
                "Excellent. Start with Griwalsh at his farmhouse south of Helera. He should have one. Come back with it and I'll tell you about the next one.");
        cvPFEAccept.addOptionText(PORTUGUESE, "Claro, vou encontrar essas poções para você.",
                "Excelente. Comece com Griwalsh em sua fazenda ao sul de Helera. Ele deve ter uma. Volte com ela e te digo sobre a próxima.");
        cvPFEAccept.addOptionText(SPANISH, "Claro, encontraré esas pociones para ti.",
                "Excelente. Empieza con Griwalsh en su granja al sur de Helera. Debería tener una. Regresa con ella y te cuento sobre la siguiente.");
        cvPFEAccept.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(PotionsFromExterior.get(), App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPFEAccept);

        ConversationOption cvPFEDecline = new ConversationOption(10, 0);
        cvPFEDecline.addOptionText(ENGLISH, "Not now, maybe later.", "Fine. Let me know when you have time.");
        cvPFEDecline.addOptionText(PORTUGUESE, "Não agora, talvez mais tarde.", "Tudo bem. Me avise quando tiver tempo.");
        cvPFEDecline.addOptionText(SPANISH, "Ahora no, quizás después.", "Bien. Avísame cuando tengas tiempo.");
        npc.conversationOptions.add(cvPFEDecline);

        // Part 2: Player returns with first potion from Griwalsh
        ConversationOption cvPFEPart2 = new ConversationOption(0, 0);
        cvPFEPart2.addOptionText(ENGLISH, "I have the Unidentified Potion from Griwalsh.",
                "*She grabs it eagerly and holds it up to the light*\nInteresting... look at that coloration. I'll need to study this carefully.\nNow, there's another one. Alden has it — he's a traveling merchant who passes through Lisport. Find him and get it.");
        cvPFEPart2.addOptionText(PORTUGUESE, "Tenho a Poção não Identificada de Griwalsh.",
                "*Ela a pega ansiosamente e levanta na luz*\nInteressante... veja essa coloração. Preciso estudar isso cuidadosamente.\nAgora há mais uma. Alden tem ela — é um mercador itinerante que passa por Lisport. Encontre-o e pegue.");
        cvPFEPart2.addOptionText(SPANISH, "Tengo la Poción sin Identificar de Griwalsh.",
                "*La agarra con entusiasmo y la sostiene contra la luz*\nInteresante... mira esa coloración. Necesito estudiarla detenidamente.\nAhora hay otra. Alden la tiene — es un mercader viajero que pasa por Lisport. Encuéntralo y consíguela.");
        cvPFEPart2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.POTIONS_FROM_EXTERIOR, 2)
                    && LibInventory.checkHasItem(ItemsIds.UNIDENTIFIED_POTION, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPFEPart2.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.UNIDENTIFIED_POTION, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.POTIONS_FROM_EXTERIOR, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPFEPart2);

        // Part 4: Player returns with second potion from Alden
        ConversationOption cvPFEPart4 = new ConversationOption(0, 0);
        cvPFEPart4.addOptionText(ENGLISH, "Here's the second Unidentified Potion, from Alden.",
                "*Eyes light up*\nPerfect. Two samples! Now I can compare them and identify what they really are.\n*She hands you some gold coins*\nYour alchemy knowledge must have grown just from handling these. Consider yourelf paid — and educated.");
        cvPFEPart4.addOptionText(PORTUGUESE, "Aqui está a segunda Poção não Identificada, de Alden.",
                "*Os olhos brilham*\nPerfeito. Duas amostras! Agora posso compará-las e identificar o que realmente são.\n*Entrega algumas moedas de ouro*\nSeu conhecimento de alquimia deve ter crescido só de manusear essas. Considerese pago — e educado.");
        cvPFEPart4.addOptionText(SPANISH, "Aquí está la segunda Poción sin Identificar, de Alden.",
                "*Los ojos se iluminan*\n¡Perfecto. ¡Dos muestras! Ahora puedo compararlas e identificar qué son realmente.\n*Te entrega unas monedas de oro*\nTu conocimiento de alquimia debe haber crecido solo con manejarlas. Considera que estás pagado — y educado.");
        cvPFEPart4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.POTIONS_FROM_EXTERIOR, 4)
                    && LibInventory.checkHasItem(ItemsIds.UNIDENTIFIED_POTION, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPFEPart4.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.UNIDENTIFIED_POTION, 1, App.getPlayerChar());
            LibQuest.completeQuest(QuestsIds.POTIONS_FROM_EXTERIOR, App.getPlayerChar(), 5, ctx);
        };
        npc.conversationOptions.add(cvPFEPart4);

        return npc;
    }
}