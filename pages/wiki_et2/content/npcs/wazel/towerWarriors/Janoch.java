package com.cnx.endlesstalestwo.data.npcs.wazel.towerWarriors;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import android.os.Looper;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.GameEngine;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.shops.ShopsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Janoch extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Janoch");
        npc.age = 62;
        npc.job = Enums.NPCJobs.ALCHEMIST;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Greetings, traveler. What brings you to my workshop?"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Saudações, viajante. O que te traz à minha oficina?"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Saludos, viajero. ¿Qué te trae a mi taller?"));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("May your path be safe."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Que seu caminho seja seguro."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Que tu camino sea seguro."));

        // ===== ROLEPLAY: About his work =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 100);
        cvRoleplay1.addOptionText(ENGLISH, "What do you do here?", "I am an alchemist - I craft elixirs, potions, and various remedies. My specialty is creating powerful restorative concoctions from simple ingredients. Each formula requires precision, patience, and the right catalysts.");
        cvRoleplay1.addOptionText(PORTUGUESE, "O que você faz aqui?", "Sou um alquimista - crio elixires, poções e vários remédios. Minha especialidade é criar poderosas misturas restaurativas a partir de ingredientes simples. Cada fórmula requer precisão, paciência e os catalisadores certos.");
        cvRoleplay1.addOptionText(SPANISH, "¿Qué haces aquí?", "Soy un alquimista: elaboro elixires, pociones y varios remedios. Mi especialidad es crear poderosos brebajes restaurativos a partir de ingredientes simples. Cada fórmula requiere precisión, paciencia y los catalizadores adecuados.");
        npc.conversationOptions.add(cvRoleplay1);

        ConversationOption cvOpenShop = new ConversationOption(100, 0);
        cvOpenShop.addOptionText(ENGLISH, "And do you sell these potions?", "Ah, but of course. Take a look...");
        cvOpenShop.addOptionText(PORTUGUESE, "E você vende essas poções?", "Ah, mas é claro que sim, veja...");
        cvOpenShop.addOptionText(SPANISH, "¿Y vendes esas pociones?", "Ah, claro que sí, mira...");
        cvOpenShop.listeners = (ctx, currentFragment) -> {
            currentFragment.setScreenTouchable(false);
            new android.os.Handler(Looper.getMainLooper()).postDelayed(() -> {
                        if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                            gPlayActivity.lockScreenTouches(true);
                            gPlayActivity.goToViewShop(ShopsIds.POTIONS_MARKET);
                        }
                    }
                    , 1600);
        };
        npc.conversationOptions.add(cvOpenShop);

        // ===== ROLEPLAY: About Wazel =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "How is life in Wazel?", "Wazel is a harsh land, but it produces hardy people. The warriors here are fierce, and they often require my services - battle wounds, poisons, exhaustion. My work keeps me busy and purposeful.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Como é a vida em Wazel?", "Wazel é uma terra dura, mas produz pessoas resistentes. Os guerreiros daqui são ferozes, e frequentemente requerem meus serviços - ferimentos de batalha, venenos, exaustão. Meu trabalho me mantém ocupado e com propósito.");
        cvRoleplay2.addOptionText(SPANISH, "¿Cómo es la vida en Wazel?", "Wazel es una tierra dura, pero produce gente resistente. Los guerreros aquí son feroces, y a menudo requieren mis servicios: heridas de batalla, venenos, agotamiento. Mi trabajo me mantiene ocupado y con propósito.");
        npc.conversationOptions.add(cvRoleplay2);

        // ===== ROLEPLAY: About his craft =====
        ConversationOption cvRoleplay3 = new ConversationOption(0, 0);
        cvRoleplay3.addOptionText(ENGLISH, "How did you learn alchemy?", "I apprenticed under the great alchemist Morwen in my youth. She taught me that alchemy is not just mixing ingredients - it's understanding the essence of each component, the harmony between elements. That knowledge has served me for decades.");
        cvRoleplay3.addOptionText(PORTUGUESE, "Como você aprendeu alquimia?", "Fui aprendiz da grande alquimista Morwen em minha juventude. Ela me ensinou que alquimia não é apenas misturar ingredientes - é entender a essência de cada componente, a harmonia entre os elementos. Esse conhecimento me serviu por décadas.");
        cvRoleplay3.addOptionText(SPANISH, "¿Cómo aprendiste alquimia?", "Fui aprendiz de la gran alquimista Morwen en mi juventud. Ella me enseñó que la alquimia no es solo mezclar ingredientes: es comprender la esencia de cada componente, la armonía entre los elementos. Ese conocimiento me ha servido durante décadas.");
        npc.conversationOptions.add(cvRoleplay3);

        // ===== QUEST: Fresh Liquid - Introduction =====
        ConversationOption cvQuest1 = new ConversationOption(0, 1);
        cvQuest1.addOptionText(ENGLISH, "Do you need any help?", "Actually, yes. I'm constantly in need of fresh liquid ingredients to maintain my elixir production. Adventurers rely on these elixirs for survival in dangerous situations, so I try to keep a steady supply.");
        cvQuest1.addOptionText(PORTUGUESE, "Você precisa de alguma ajuda?", "Na verdade, sim. Estou constantemente precisando de ingredientes líquidos frescos para manter minha produção de elixires. Aventureiros dependem desses elixires para sobreviver em situações perigosas, então tento manter um suprimento constante.");
        cvQuest1.addOptionText(SPANISH, "¿Necesitas alguna ayuda?", "De hecho, sí. Constantemente necesito ingredientes líquidos frescos para mantener mi producción de elixires. Los aventureros dependen de estos elixires para sobrevivir en situaciones peligrosas, así que intento mantener un suministro constante.");
        cvQuest1.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.FRESH_LIQUID, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuest1);

        ConversationOption cvQuest2 = new ConversationOption(1, 2);
        cvQuest2.addOptionText(ENGLISH, "What ingredients do you need?", "For a basic elixir, I need Mead and Water - the liquids provide the base. I also require 2 gold coins to purchase rare catalysts from traveling merchants. If you bring me these, I can craft an elixir for you.");
        cvQuest2.addOptionText(PORTUGUESE, "Que ingredientes você precisa?", "Para um elixir básico, preciso de Hidromel e Água - os líquidos fornecem a base. Também preciso de 2 moedas de ouro para comprar catalisadores raros de mercadores viajantes. Se você me trouxer isso, posso criar um elixir para você.");
        cvQuest2.addOptionText(SPANISH, "¿Qué ingredientes necesitas?", "Para un elixir básico, necesito Hidromiel y Agua: los líquidos proporcionan la base. También requiero 2 monedas de oro para comprar catalizadores raros de comerciantes viajeros. Si me traes esto, puedo crear un elixir para ti.");
        npc.conversationOptions.add(cvQuest2);

        ConversationOption cvQuest3 = new ConversationOption(2, 0);
        cvQuest3.addOptionText(ENGLISH, "I'll bring you those ingredients.", "Excellent! The ingredients must be fresh - Mead and Water lose their potency over time. Return when you have: Mead, Water, and 2 gold coins. I'll craft the elixir immediately.");
        cvQuest3.addOptionText(PORTUGUESE, "Vou trazer esses ingredientes para você.", "Excelente! Os ingredientes devem estar frescos - Hidromel e Água perdem sua potência com o tempo. Retorne quando tiver: Hidromel, Água e 2 moedas de ouro. Vou criar o elixir imediatamente.");
        cvQuest3.addOptionText(SPANISH, "Te traeré esos ingredientes.", "¡Excelente! Los ingredientes deben estar frescos: Hidromiel y Agua pierden su potencia con el tiempo. Regresa cuando tengas: Hidromiel, Agua y 2 monedas de oro. Crearé el elixir de inmediato.");
        cvQuest3.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.FRESH_LIQUID, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuest3);

        // ===== QUEST: Fresh Liquid - Delivery =====
        ConversationOption cvDelivery = new ConversationOption(0, 3);
        cvDelivery.addOptionText(ENGLISH, "I have the ingredients you requested.", "*Examines the items carefully*\nPerfect! The mead is fresh, the water is pure, and... \n*counts the coins*\n...the payment covers my catalyst costs. Let me work my craft.");
        cvDelivery.addOptionText(PORTUGUESE, "Tenho os ingredientes que você pediu.", "*Examina os itens cuidadosamente*\nPerfeito! O hidromel está fresco, a água está pura, e... \n*conta as moedas*\n...o pagamento cobre meus custos de catalisadores. Deixe-me trabalhar meu ofício.");
        cvDelivery.addOptionText(SPANISH, "Tengo los ingredientes que solicitaste.", "*Examina los objetos cuidadosamente*\n¡Perfecto! El hidromiel está fresco, el agua es pura, y... \n*cuenta las monedas*\n...el pago cubre mis costos de catalizadores. Déjame trabajar mi oficio.");
        cvDelivery.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FRESH_LIQUID, 1)) {
                // Check if player has all required items
                boolean hasMead = LibInventory.checkHasItemAmount(ItemsIds.MEAD_POTION, 1, chara);
                boolean hasWater = LibInventory.checkHasItemAmount(ItemsIds.WATER, 1, chara);
                boolean hasGold = chara.checkHasGold(2);

                if (hasMead && hasWater && hasGold) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvDelivery);

        ConversationOption cvCrafting = new ConversationOption(3, 0);
        cvCrafting.addOptionText(ENGLISH, "[Wait while he works]", "*Mixes liquids in glass vials, adds powders, heats the mixture*\nThe catalysts bind the essence... the heat activates the properties... \n*A glowing blue liquid forms*\nDone! Here's your elixir - one of my finest restorative concoctions. It will serve you well in your travels. Come back anytime you need another - I always need fresh ingredients.");
        cvCrafting.addOptionText(PORTUGUESE, "[Aguarde enquanto ele trabalha]", "*Mistura líquidos em frascos de vidro, adiciona pós, aquece a mistura*\nOs catalisadores ligam a essência... o calor ativa as propriedades... \n*Um líquido azul brilhante se forma*\nPronto! Aqui está seu elixir - uma das minhas melhores misturas restaurativas. Vai te servir bem em suas viagens. Volte sempre que precisar de outro - sempre preciso de ingredientes frescos.");
        cvCrafting.addOptionText(SPANISH, "[Espera mientras trabaja]", "*Mezcla líquidos en viales de vidrio, añade polvos, calienta la mezcla*\nLos catalizadores unen la esencia... el calor activa las propiedades... \n*Se forma un líquido azul brillante*\n¡Listo! Aquí está tu elixir: una de mis mejores mezclas restaurativas. Te servirá bien en tus viajes. Vuelve siempre que necesites otro: siempre necesito ingredientes frescos.");
        cvCrafting.listeners = (ctx, currentFragment) -> {
            // Remove items from inventory
            LibInventory.removeFromInventory(ItemsIds.MEAD_POTION, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.WATER, 1, App.getPlayerChar());
            App.getPlayerChar().removeGold(2);

            // Complete quest (rewards given automatically by Quest.complete())
            LibQuest.completeQuest(QuestsIds.FRESH_LIQUID, App.getPlayerChar(), 2, ctx);
            GameEngine.updateTopToolbar(currentFragment.getView(), false);
        };
        npc.conversationOptions.add(cvCrafting);

        return npc;
    }
}




