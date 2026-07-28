package com.cnx.endlesstalestwo.data.npcs.lisport.BreedersUnion;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.knowledges.KnowledgesIds.ALCHEMY;

import android.os.Handler;
import android.os.Looper;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.GameEngine;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.knowledges.KnowledgesIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.shops.ShopsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibNpc;
import com.cnx.endlesstalestwo.libs.LibQuest;

//TRADUZIR
public class Alden extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Alden");
        npc.age = 60;
        npc.job = Enums.NPCJobs.ALCHEMIST;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A wise man who never stops working.\nRaised his daughter and now lives alone but is not unhappy.\nLoves to teach, is seriously curious and tends to be kind.\n\nPhysical traits: White beard and medium-length hair. Clear blue eyes and wrinkled skin from age.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um sábio homem que não para de trabalhar nunca.\nCriou sua filha e hoje vive sozinho mas não é infeliz.\nGosta de ensinar, é curioso sério e costuma ser bondoso.\n\nSeus taços físicos: Barba e cabelos brancos de comprimento médio. Olhos azuis claros e pele enrugada pela idade.");
        npc.addDescriptionTranslation(SPANISH, "Un hombre sabio que nunca deja de trabajar.\nCrió a su hija y ahora vive solo pero no es infeliz.\nAma enseñar, es seriamente curioso y tiende a ser amable.\n\nTrasos físicos: Barba y cabello blanco de mediano largo. Ojos azul claros y piel arrugada por la edad.");
        npc.canBePickpocketed = true;

        ConversationOption cv1 = new ConversationOption(0, 3);
        cv1.addOptionText(ENGLISH, "What do you do here?", LibNpc.getAboutJobMsg(npc));
        cv1.addOptionText(PORTUGUESE, "O que você faz aqui?", LibNpc.getAboutJobMsg(npc));
        cv1.addOptionText(SPANISH, "¿Qué haces aquí?", LibNpc.getAboutJobMsg(npc));
        npc.conversationOptions.add(cv1);

        ConversationOption cvAlchemySpecial = new ConversationOption(3, 0);
        cvAlchemySpecial.addOptionText(ENGLISH, "What special things can be done with alchemy?", "Ah, now that's a question worth answering!\n\nWell, the most common use is brewing potions — healing elixirs, stamina restorers, antidotes, poisons... the list is long.\n\nBut the truly fascinating part is enchanted liquids. These are rare compounds that, when properly sealed against an object, bind a magical property to it permanently. Imagine a shield treated with a fire-ward liquid, it will resist flames as if forged in cold iron. Most alchemists never master it. But those who do... they can create items of remarkable power.");
        cvAlchemySpecial.addOptionText(PORTUGUESE, "O que de especial pode ser feito com alquimia?", "Ah, agora essa é uma pergunta que vale a pena responder!\n\nBem, o uso mais comum é preparar poções — elixires de cura, restauradores de vigor, antídotos, venenos... a lista é longa.\n\nMas a parte verdadeiramente fascinante são os líquidos encantados. São compostos raros que, quando devidamente selados contra um objeto, ligam a ele uma propriedade mágica de forma permanente. Imagine um escudo tratado com um líquido de proteção contra fogo, ele resistirá às chamas como se forjado em ferro gelado. A maioria dos alquimistas nunca a domina. Mas aqueles que o fazem... podem criar itens de poder notável.");
        cvAlchemySpecial.addOptionText(SPANISH, "¿Qué cosas especiales se pueden hacer con la alquimia?", "¡Ah, ahora esa es una pregunta que vale la pena responder!\n\nBueno, el uso más común es preparar pociones — elixires curativos, restauradores de energía, antídotos, venenos... la lista es larga.\n\nPero la parte verdaderamente fascinante son los líquidos encantados. Son compuestos raros que, cuando se sellan correctamente contra un objeto, le unen una propiedad mágica de forma permanente. Imagina un escudo tratado con un líquido de protección contra el fuego, resistirá las llamas como si estuviera forjado en hierro frío. La mayoría de los alquimistas nunca lo dominan. Pero los que lo hacen... pueden crear objetos de notable poder.");
        npc.conversationOptions.add(cvAlchemySpecial);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Tell me about this place.", "Well, a curious person. So, [CURRENT_LOCATION] was founded 76 years ago. Lisport region was a deserted place, but some men discovered rare and abundant herbs in the caves and mountains. The alchemy productions became famous. So they decided to create a union of producers and strengthen trade. This helped a lot for Lisport to grow.");
        cv2.addOptionText(PORTUGUESE, "Me fale sobre este lugar.", "Bem, uma pessoa curiosa. Então, [CURRENT_LOCATION] é o local onde produzimos poções e estudamos alquimia.");
        cv2.addOptionText(SPANISH, "Háblame de este lugar.", "Bueno, una persona curiosa. Entonces, [CURRENT_LOCATION] es el lugar donde producimos pociones y estudiamos alquimia.");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(0, 1);
        cv3.addOptionText(ENGLISH, "Do you teach alchemy?", "Yes, I do.\nWe charge a small amount of gold, 5 pieces. I promise that in one lesson you learn the basics.");
        cv3.addOptionText(PORTUGUESE, "Você ensina alquimia?", "Sim, eu ensino.\nCobramos uma pequena quantia de ouro, 5 moedas. Prometo que em uma aula você aprende o básico.");
        cv3.addOptionText(SPANISH, "¿Enseñas alquimia?", "Sí, lo hago.\nCobramos una pequeña cantidad de oro, 5 piezas. Te prometo que en una lección aprenderás lo básico.");
        cv3.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.LEARNING_ALCHEMY, App.getPlayerChar())
                    && LibQuest.isQuestComplete(App.getPlayerChar(), QuestsIds.LETTER_FROM_ERINO)
                    && !chara.hasKnowledge(ALCHEMY)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(1, 0);
        cv4.addOptionText(ENGLISH, "I want to learn. [5 Gold]", "Alright. Here, take some time to read this little book about basic alchemy.\nAfter the reading, you will need to bring me some herbs.");
        cv4.addOptionText(PORTUGUESE, "Eu quero aprender. [5 de Ouro]", "Certo. Aqui, tire um tempo para ler este livro. Depois volte quando tiver os ingredientes necessários para elaborar uma poção básica.");
        cv4.addOptionText(SPANISH, "Quiero aprender. [5 de Oro]", "Muy bien. Aquí, tómate un tiempo para leer este libro. Después regresa cuando tengas los ingredientes necesarios para elaborar una poción básica.");
        cv4.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null) {
                if (App.getPlayerChar().checkHasGold(5)) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cv4.listeners = (ctx, currentFragment) -> {
            App.getPlayerChar().removeGold(5);
            LibInventory.addToInventory(ItemsIds.ALCHEMY_FOR_DUMMIES, 1, App.getPlayerChar());
            LibQuest.includeQuestToQuestbook(QuestsIds.LEARNING_ALCHEMY, App.getPlayerChar(), ctx);
            GameEngine.updateTopToolbar(currentFragment.getView(), currentFragment.isShowingBackButton);
        };
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(1, 0);
        cv5.addOptionText(ENGLISH, "Right, but not now.", "Sure, no problem.");
        cv5.addOptionText(PORTUGUESE, "Certo, mas não agora.", "Claro, sem problema.");
        cv5.addOptionText(SPANISH, "Bien, pero no ahora.", "Claro, sin problema.");
        npc.conversationOptions.add(cv5);

        ConversationOption cv6 = new ConversationOption(0, 0);
        cv6.addOptionText(ENGLISH, "I read the book and have the ingredients.", "Very well, [GENDER_SIMPLE_CALL]. Now, we will mix a potion togheter and you will learn.");
        cv6.addOptionText(PORTUGUESE, "Eu li o livro e tenho os ingredientes.", "Muito bem, [GENDER_SIMPLE_CALL]. Agora, vamos misturar uma poção juntos e você vai aprender.");
        cv6.addOptionText(SPANISH, "Leí el libro y tengo los ingredientes.", "Muy bien, [GENDER_SIMPLE_CALL]. Ahora, vamos a mezclar una poción juntos y aprenderás.");
        cv6.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null) {
                boolean hasItems = LibInventory.checkHasItemAmount(ItemsIds.GREEN_HERB, 2, App.getPlayerChar())
                        && LibInventory.checkHasItemAmount(ItemsIds.RED_HERB, 1, App.getPlayerChar())
                        && LibInventory.checkHasItemAmount(ItemsIds.WATER, 1, App.getPlayerChar());
                Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.LEARNING_ALCHEMY);

                if (hasItems
                        && LibQuest.isCharacterAtQuestPart(App.getPlayerChar(), QuestsIds.LEARNING_ALCHEMY, 2)
                        && requiredQuest.status != Enums.QuestStatus.COMPLETED) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv6.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.GREEN_HERB, 2, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.RED_HERB, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.WATER, 1, App.getPlayerChar());

            App.getPlayerChar().addKnowledge(App.DataManager.getKnowledge(KnowledgesIds.ALCHEMY));

            LibQuest.completeQuest(QuestsIds.LEARNING_ALCHEMY, App.getPlayerChar(), 2, ctx);

            String knowledgeTanslate = LibUtils.translate(ALCHEMY.name(), ctx);
            new Handler().postDelayed(() -> LibUtils.showToast(LibUtils.getString("YouLearnedKnowledge", knowledgeTanslate, ctx), 0, CoreEnums.MessageType.INFO, ctx), 400);
        };
        npc.conversationOptions.add(cv6);

        ConversationOption cv7 = new ConversationOption(0, 0);
        cv7.addOptionText(ENGLISH, "I want to negotiate potions.", "You come to the right place, [GENDER_SIMPLE_CALL].");
        cv7.addOptionText(PORTUGUESE, "Eu quero negociar poções.", "Você veio ao lugar certo, [GENDER_SIMPLE_CALL].");
        cv7.addOptionText(SPANISH, "Quiero negociar pociones.", "Has venido al lugar correcto, [GENDER_SIMPLE_CALL].");
        cv7.requirementValidations = (chara, ctx) -> {
            Shop shop = App.DataManager.getShop(ShopsIds.POTION_BREEDERS_UNION);
            if (shop.isClosed(App.Shell.flowManager.minutes / 60)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        cv7.listeners = (ctx, currentFragment) -> {
            new android.os.Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                    gPlayActivity.lockScreenTouches(true);
                    gPlayActivity.goToViewShop(ShopsIds.POTION_BREEDERS_UNION);
                }
            }, 1200);
        };
        npc.conversationOptions.add(cv7);

        // ===== QUEST: Like a Landlord - Deliver letter from daughter =====
        ConversationOption cvLetterFromDaughter = new ConversationOption(0, 5);
        cvLetterFromDaughter.addOptionText(ENGLISH, "I have a letter from your daughter Elena.", "*Takes the letter with trembling hands*\n\nFrom Elena? Let me read it...\n\n*Opens and reads the letter, his expression shifting from surprise to understanding*\n\nShe's moving to Havarus to continue her studies. Of course she is. I always knew that girl had big dreams. This small island couldn't contain her thirst for knowledge forever.\n\n*Folds the letter carefully*");
        cvLetterFromDaughter.addOptionText(PORTUGUESE, "Tenho uma carta de sua filha Elena.", "*Pega a carta com mãos trêmulas*\n\nDe Elena? Deixe-me ler...\n\n*Abre e lê a carta, sua expressão mudando de surpresa para compreensão*\n\nEla está se mudando para Havarus para continuar seus estudos. Claro que está. Sempre soube que aquela menina tinha grandes sonhos. Esta pequena ilha não poderia conter sua sede de conhecimento para sempre.\n\n*Dobra a carta cuidadosamente*");
        cvLetterFromDaughter.addOptionText(SPANISH, "Tengo una carta de tu hija Elena.", "*Toma la carta con manos temblorosas*\n\n¿De Elena? Déjame leerla...\n\n*Abre y lee la carta, su expresión cambiando de sorpresa a comprensión*\n\nSe está mudando a Havarus para continuar sus estudios. Por supuesto que sí. Siempre supe que esa chica tenía grandes sueños. Esta pequeña isla no podría contener su sed de conocimiento para siempre.\n\n*Dobla la carta cuidadosamente*");
        cvLetterFromDaughter.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.LIKE_A_LANDLORD, 3)
                    && LibInventory.checkHasItem(ItemsIds.STUDENT_LETTER, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvLetterFromDaughter);

        ConversationOption cvLetterResponse = new ConversationOption(5, 0);
        cvLetterResponse.addOptionText(ENGLISH, "[Continue]", "I'm proud of her, truly. Tell her... tell her I support her decision completely. She should follow her dreams. I'll visit her in Havarus once she's settled.\n\n*Smiles warmly*\n\nThank you for delivering this, [GENDER_FORMAL_CALL]. It means a lot to know she's taking this step with confidence.");
        cvLetterResponse.addOptionText(PORTUGUESE, "[Continuar]", "Estou orgulhoso dela, de verdade. Diga a ela... diga a ela que apoio completamente sua decisão. Ela deve seguir seus sonhos. Vou visitá-la em Havarus assim que ela se estabelecer.\n\n*Sorri calorosamente*\n\nObrigado por entregar isto, [GENDER_FORMAL_CALL]. Significa muito saber que ela está dando esse passo com confiança.");
        cvLetterResponse.addOptionText(SPANISH, "[Continuar]", "Estoy orgulloso de ella, de verdad. Dile... dile que apoyo completamente su decisión. Debe seguir sus sueños. La visitaré en Havarus una vez que se establezca.\n\n*Sonríe calurosamente*\n\nGracias por entregar esto, [GENDER_FORMAL_CALL]. Significa mucho saber que está dando este paso con confianza.");
        cvLetterResponse.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.LIKE_A_LANDLORD);
            LibInventory.removeFromInventory(ItemsIds.STUDENT_LETTER, 1, App.getPlayerChar());
            LibQuest.updateQuest(quest, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvLetterResponse);

        // ========================================
        // QUEST: POTIONS FROM EXTERIOR — PART 3
        // ========================================

        ConversationOption cvPFE3 = new ConversationOption(0, 0);
        cvPFE3.addOptionText(ENGLISH, "I'm looking for rare or unidentified potions. Do you happen to have anything unusual?",
                "*He pauses and strokes his chin*\nActually, yes. I came across a strange bottle recently — not from local stock. Unusual coloration and seal, nothing I can place in my catalogue.\nI have been meaning to look into it, but the union keeps me busy.\n*Searches through a case*\nHere. If you find out what it is, I would genuinely like to know. Curious thing, that bottle.");
        cvPFE3.addOptionText(PORTUGUESE, "Estou procurando por poções raras ou não identificadas. Você tem algo incomum?",
                "*Ele pausa e esfrega o queixo*\nNa verdade, sim. Encontrei um frasco estranho recentemente — não é do estoque local. Coloração e selo incomuns, nada que eu consiga catalogar.\nEstava pretendendo investigar, mas a união me mantém ocupado.\n*Busca em um estojo*\nAqui. Se você descobrir o que é, eu realmente gostaria de saber. Coisa curiosa, esse frasco.");
        cvPFE3.addOptionText(SPANISH, "Estoy buscando pociones raras o sin identificar. ¿Tienes algo inusual?",
                "*Se detiene y se frota la barbilla*\nEn realidad, sí. Encontré un frasco extraño recientemente — no es del stock local. Coloración y sello inusuales, nada que pueda catalogar.\nTenía pensado investigarlo, pero el gremio me mantiene ocupado.\n*Busca en un estuche*\nAquí. Si descubres qué es, me gustaría saberlo de verdad. Cosa curiosa, ese frasco.");
        cvPFE3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.POTIONS_FROM_EXTERIOR, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPFE3.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.UNIDENTIFIED_POTION, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.POTIONS_FROM_EXTERIOR, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPFE3);

        return npc;
    }
}