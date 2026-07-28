package com.cnx.endlesstalestwo.data.npcs.havarusSouth.apenna.woodcuttersWarehouse;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.enums.Enums.AttributeName.CHARISMA;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibNpc;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class RenneHardwood extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Renne Hardwood");
        npc.age = 42;
        npc.job = Enums.NPCJobs.WOODCUTTER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A man consistent in his words and firm in his work.\nHe values justice and honor.\nHe enjoys his profession and the village where he lives.\n\nHis physical features: Square face. Gray hair, beard, and mustache. Pointed nose and serious brown eyes. He wears a leather beret.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um homem coerente no que diz e firme no seu trabalho.\nValoriza a justiça e a honra.\nGosta do seu ofício e da vila onde reside.\n\nSeus traços físicos: Rosto quadrado. Cabelos, barba e bigode grisalhos. Nariz pontudo e olhos castanhos e sérios. Usa uma boina de couro.");
        npc.addDescriptionTranslation(SPANISH, "Un hombre coherente en sus palabras y firme en su trabajo.\nValora la justicia y el honor.\nDisfruta de su profesión y del pueblo donde vive.\nSus rasgos físicos: Rostro cuadrado. Cabello, barba y bigote grises. Nariz puntiaguda y ojos marrones serios. Lleva una boina de cuero.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hey, welcome."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Hei, bem-vindo."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola, bienvenido."));

        npc.generateRandomByes();

        ConversationOption cv3 = new ConversationOption(0, 1);
        cv3.addOptionText(ENGLISH, "I am here to listen about the riot.", "What a shame, I was expecting some important person of the kingdom to come, not a simple soldier.\n...\nOk, the thing is we work a lot and receive too little. One of our men died yesterday during the work and nobody gave a shit. We will stop the production of planks and logs until the queen do something.");
        cv3.addOptionText(PORTUGUESE, "Estou aqui para ouvir sobre o motim.", "Que pena, eu esperava que alguém importante do reino viesse, não um simples soldado.\n...\nOk, a questão é que trabalhamos muito e recebemos muito pouco. Um dos nossos homens morreu ontem durante o trabalho e ninguém deu a mínima. Vamos parar a produção de tábuas e toras até que a rainha faça algo.");
        cv3.addOptionText(SPANISH, "Estoy aquí para escuchar sobre el motín.", "Qué lástima, esperaba que viniera alguien importante del reino, no un simple soldado.\n...\nBueno, la cosa es que trabajamos mucho y recibimos muy poco. Uno de nuestros hombres murió ayer durante el trabajo y a nadie le importó. Pararemos la producción de tablones y troncos hasta que la reina haga algo.");
        cv3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RIOT_CONTROL, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(1, 0);
        cv4.addOptionText(ENGLISH, "I will let the kingdom leaders know about this.", "Good, take this letter to our majesty, our demands are fair and well written in this piece of paper. We will only work again when someone return with good news for us.");
        cv4.addOptionText(PORTUGUESE, "Vou informar os líderes do reino sobre isso.", "Bom, leve esta carta à vossa majestade. Nossas demandas são justas e bem escritas neste pedaço de papel. Só voltaremos a trabalhar quando alguém voltar com boas notícias para nós.");
        cv4.addOptionText(SPANISH, "Informaré a los líderes del reino sobre esto.", "Bien, lleva esta carta a nuestra majestad, nuestras demandas son justas y están bien escritas en este papel. Solo volveremos a trabajar cuando alguien regrese con buenas noticias para nosotros.");
        cv4.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.WOODCUTTERS_LETTER, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.RIOT_CONTROL, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv4);

        ConversationOption cvRiotControlPart3 = new ConversationOption(0, 50);
        cvRiotControlPart3.addOptionText(ENGLISH, "I bring answers from the Queen.", "Very well, feel free, show us the benevolence of her majesty...\n*Gives a small sarcastic smile*");
        cvRiotControlPart3.addOptionText(PORTUGUESE, "Trago respostas da rainha.", "Muito bem, fique a vontade, nos mostre a benevolência de vossa majestade...\n*Dá um pequeno sorriso sarcástico*");
        cvRiotControlPart3.addOptionText(SPANISH, "Traigo respuestas de la reina.", "Muy bien, siéntete libre, muéstranos la benevolencia de su majestad...\n*Esboza una pequeña sonrisa sarcástica*");
        cvRiotControlPart3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RIOT_CONTROL, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRiotControlPart3);

        ConversationOption cv5 = new ConversationOption(50, 0);
        cv5.addOptionText(ENGLISH, "Her majesty sent condolences and a payment of 20 coins.", "So you resolved the situation for us...\n20 gold coins seems like an acceptable bonus. We will return to work tomorrow.\nWe hope this recognition continues, or we will stop again.");
        cv5.addOptionText(PORTUGUESE, "Vossa majestade enviou condolências e um pagamento de 20 moedas.", "Então você resolveu a situação para nós...\n20 moedas de ouro parece ser um valor aceitável de bônus. Voltaremos aos trabalhos amanhã.\nEsperamos que esse reconhecimento continue ou iremos parar novamente.");
        cv5.addOptionText(SPANISH, "Su majestad envió condolencias y un pago de 20 monedas.", "Así que resolviste la situación por nosotros...\n20 monedas de oro parece un bono aceptable. Volveremos al trabajo mañana.\nEsperamos que este reconocimiento continúe, o nos detendremos nuevamente.");
        cv5.showEvenWhenNotValid = true;
        cv5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RIOT_CONTROL, 3) && chara.checkHasGold(20)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv5.listeners = (ctx, currentFragment) -> {
            App.getPlayerChar().removeGold(20);
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.RIOT_CONTROL);
            LibQuest.updateQuest(quest, 24, App.getPlayerChar(), ctx);
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);
        };
        npc.conversationOptions.add(cv5);

        ConversationOption cv6 = new ConversationOption(50, 0);
        cv6.addOptionText(ENGLISH, "Our majesty sent a payment of 10 coins. [Charisma]", "What?! 10 gold coins?\nWhat a pittance, that barely covers Jarlo's coffin...\nHer majesty is making us furious. We will return to work, but next time things will be much worse.");
        cv6.addOptionText(PORTUGUESE, "Vossa majestade enviou um pagamento de 10 moedas. [Carisma]", "O que?! 10 moedas de ouro?\nQue miséria, isso mal paga o caixão do Jarlo...\nVossa majestade está nos deixando irados, iremos voltar ao trabalho, mas na próxima as coisas serão bem piores.");
        cv6.addOptionText(SPANISH, "Su majestad envió un pago de 10 monedas. [Carisma]", "¿Qué?! ¿10 monedas de oro?\nQué miseria, eso apenas cubre el ataúd de Jarlo...\nSu majestad nos está enfureciendo. Volveremos al trabajo, pero la próxima vez las cosas serán mucho peores.");
        cv6.showEvenWhenNotValid = true;
        cv6.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RIOT_CONTROL, 3)
                    && chara.checkHasGold(10)
                    && chara.attributesManager.checkAttribute(CHARISMA, 13)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv6.listeners = (ctx, currentFragment) -> {
            App.getPlayerChar().removeGold(10);
            App.getPlayerChar().attributesManager.decrease(Enums.AttributeName.ALIGNMENT, 8);
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.RIOT_CONTROL);
            LibQuest.updateQuest(quest, 14, App.getPlayerChar(), ctx);
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);
        };
        npc.conversationOptions.add(cv6);

        // ===== GETTING_RESOURCES QUEST CONVERSATIONS =====
        ConversationOption cv7 = new ConversationOption(0, 0);
        cv7.addOptionText(ENGLISH, "Guzar sent me. We need wooden logs for barriers.", "Wooden logs for barriers? That's an excellent cause, protecting our kingdom is everyone's duty. Don't worry, I'll take care of everything. I'll prepare the necessary logs and personally arrange their delivery to the kingdom for the protection of villages and cities. Consider it done,but I will wait for the payment later!");
        cv7.addOptionText(PORTUGUESE, "Guzar me enviou. Precisamos de toras de madeira para barreiras.", "Toras de madeira para barreiras? Essa é uma causa excelente, proteger nosso reino é dever de todos. Não se preocupe, vou me encarregar de tudo. Vou preparar as toras necessárias e pessoalmente vou providenciar a entrega para o reino usar na proteção das vilas e cidades. Considere feito, mas vou aguardar o pagamento depois!");
        cv7.addOptionText(SPANISH, "Guzar me envió. Necesitamos troncos de madera para barreras.", "¿Troncos de madera para barreras? Es una causa excelente, proteger nuestro reino es deber de todos. No te preocupes, me encargaré de todo. Prepararé los troncos necesarios y personalmente organizaré la entrega al reino para la protección de pueblos y ciudades. ¡Considera que está hecho, pero esperaré el pago más tarde.!");
        cv7.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GETTING_RESOURCES, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv7.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.GETTING_RESOURCES, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv7);

        ConversationOption cv8 = new ConversationOption(0, 0);
        cv8.addOptionText(ENGLISH, "The preparations are well underway.", "Good to hear! We will continue producing logs for the kingdom. Let me know if you need more in the future. Strength and protection to all!");
        cv8.addOptionText(PORTUGUESE, "Os preparativos estão bem adiantados.", "Ótimo ouvir isso! Continuaremos produzindo toras para o reino. Me avise se precisar mais no futuro. Força e proteção a todos!");
        cv8.addOptionText(SPANISH, "Los preparativos avanzan bien.", "¡Excelente! Continuaremos produciendo troncos para el reino. Avísame si necesitas más en el futuro. ¡Fuerza y protección a todos!");
        cv8.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.GETTING_RESOURCES, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv8);


        ConversationOption cv0 = new ConversationOption(0, 0);
        cv0.addOptionText(ENGLISH, "What you do for living?", LibNpc.getAboutJobMsg(npc));
        cv0.addOptionText(PORTUGUESE, "O que você faz para viver?", LibNpc.getAboutJobMsg(npc));
        cv0.addOptionText(SPANISH, "¿A qué te dedicas?", LibNpc.getAboutJobMsg(npc));
        npc.conversationOptions.add(cv0);

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What does it take to be a woodcutter here?",
                "It takes strength, patience, and a deep respect for the forest. We provide timber for Apenna and for the kingdom, but we must also ensure the forest thrives for generations.");
        cv1.addOptionText(PORTUGUESE, "O que é preciso para ser um lenhador aqui?",
                "É preciso força, paciência e um profundo respeito pela floresta. Fornecemos madeira para Apenna e para o reino todo, mas também devemos garantir que a floresta prospere por gerações.");
        cv1.addOptionText(SPANISH, "¿Qué se necesita para ser un leñador aquí?",
                "Se necesita fuerza, paciencia y un profundo respeto por el bosque. Proveemos madera para Apenna y todo el reino, pero también debemos asegurarnos de que el bosque prospere por generaciones.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "What are the biggest challenges you face?",
                "The weather can be harsh, and the work is physically demanding. But the greatest challenge is balancing our needs with the forest's health. Overcutting would doom us all.");
        cv2.addOptionText(PORTUGUESE, "Quais são os maiores desafios que você enfrenta?",
                "O clima pode ser rigoroso, e o trabalho é fisicamente exigente. Mas o maior desafio é equilibrar nossas necessidades com a saúde da floresta. O corte excessivo nos condenaria a todos.");
        cv2.addOptionText(SPANISH, "¿Cuáles son los mayores desafíos que enfrentas?",
                "El clima puede ser duro, y el trabajo es físicamente exigente. Pero el mayor desafío es equilibrar nuestras necesidades con la salud del bosque. La tala excesiva nos condenaría a todos.");
        npc.conversationOptions.add(cv2);

        // ========================================
        // QUEST: FISHES DELIVERY — PART 2 (Apenna)
        // ========================================

        ConversationOption cvFishPart2 = new ConversationOption(0, 0);
        cvFishPart2.addOptionText(ENGLISH, "Jack the fisherman sent this bucket of fresh fish for you.",
                "*He wipes sawdust from his hands and takes the bucket*\nFresh fish! The men will be happy tonight. Tell Jack he can count on us — lumberjacks eat a lot and his fish are always welcome here.\nThank you for the delivery.");
        cvFishPart2.addOptionText(PORTUGUESE, "Jack o pescador enviou este balde de peixe fresco para você.",
                "*Ele limpa a serragem das mãos e pega o balde*\nPeixe fresco! Os homens vão ficar felizes hoje à noite. Diga ao Jack que pode contar conosco — lenhadores comem muito e os peixes dele são sempre bem-vindos aqui.\nObrigado pela entrega.");
        cvFishPart2.addOptionText(SPANISH, "Jack el pescador envió este cubo de pescado fresco para ti.",
                "*Se limpia el serrín de las manos y toma el cubo*\n¡Pescado fresco! Los hombres estarán contentos esta noche. Dile a Jack que puede contar con nosotros: los leñadores comen mucho y su pescado siempre es bienvenido aquí.\nGracias por la entrega.");
        cvFishPart2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FISHES_DELIVERY, 2)
                    && LibInventory.checkHasItem(ItemsIds.BUCKET_OF_FISHES, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvFishPart2.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.BUCKET_OF_FISHES, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.FISHES_DELIVERY, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFishPart2);

        return npc;
    }
}