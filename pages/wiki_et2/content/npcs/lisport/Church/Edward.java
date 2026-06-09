package com.cnx.endlesstalestwo.data.npcs.lisport.Church;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Edward extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, edward());
    }

    Npc edward() {
        Npc npc = new Npc("Priest Edward");
        npc.addNameTranslation(PORTUGUESE, "Padre Edward");
        npc.addNameTranslation(SPANISH, "Sacerdote Edward");
        npc.age = 48;
        npc.job = Enums.NPCJobs.PRIEST;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Serious, with a steady gaze. Not easily shaken and sometimes can even seem persuasive.\nLives by faith but seems to do so more out of work than love.\n\nPhysical traits: Grey hair combed to the side. Clear eyes with some dark circles. Well-groomed beard and mustache.");
        npc.addDescriptionTranslation(PORTUGUESE, "Sério, com olhor firme. Não se abala facilmente e por vezes pode até parecer persuasor.\nVive pela fé mas parece o fazer mais por trabalho do que por amor.\n\nSeus taços físicos: Cabelo grisalho penteado para o lado. Olhos claros com algumas olheiras. Barba e bigodes bem feitos.");
        npc.addDescriptionTranslation(SPANISH, "Serio, con una mirada fija. No se asusta fácilmente y a veces puede parecer persuasivo.\nVive por la fe pero parece hacerlo más por trabajo que por amor.\n\nTrasos físicos: Cabello gris peinado hacia un lado. Ojos claros con ojeras. Barba y bigote bien cuidados.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Welcome to the house of our divinity, citizen."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bem-vindo à casa da nossa divindade."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Bienvenido a la casa de nuestra divinidad."));

        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "I want to purge my sins.", "Of course, you came to the right place. Our god can do it for you through my priest powers for just 5 gold coins.");
        cv1.addOptionText(PORTUGUESE, "Eu quero expurgar meus pecados", "Claro, você veio ao lugar certo. Nosso deus pode fazer isso por você através dos meus poderes de sacerdote por apenas 5 moedas de ouro.");
        cv1.addOptionText(SPANISH, "Quiero purgar mis pecados.", "Por supuesto, has llegado al lugar correcto. Nuestro dios puede hacerlo por ti a través de mis poderes sacerdotales por solo 5 monedas de oro.");

        ConversationOption cv2 = new ConversationOption(1, 0);
        cv2.addOptionText(ENGLISH, "Yes, purify me. [5 gold]", "God, cleanse the soul of this sinner. Purify his sins and make this sinner follow your path and your teachings. Amen.");
        cv2.addOptionText(PORTUGUESE, "Sim, purifica-me. [5 ouro]", "Deus, limpa a alma deste pecador. Purifica os pecados e faça com que este pecador siga o teu caminho e teus ensinamentos. Amém.");
        cv2.addOptionText(SPANISH, "Sí, purifícame. [5 oro]", "Dios, limpia el alma de este pecador. Purifica los pecados y haz que este pecador siga tu camino y tus enseñanzas. Amén.");
        cv2.showEvenWhenNotValid = true;
        cv2.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cv2.listeners = (ctx, currentFragment) -> {
            if (App.getPlayerChar() != null) {
                App.getPlayerChar().removeGold(5);
                App.getPlayerChar().attributesManager.increase(Enums.AttributeName.ALIGNMENT, 5);
                LibUtils.showToast(LibUtils.translate("YourAlignmentIncreased", ctx), 0, CoreEnums.MessageType.INFO, ctx);
            }
        };

        ConversationOption cv3 = new ConversationOption(1, 0);
        cv3.addOptionText(ENGLISH, "I changed my mind.", "Remember, only the pures will have a place in heaven.");
        cv3.addOptionText(PORTUGUESE, "Mudei de ideia.", "Lembre-se, somente os puros terão um lugar no céu.");
        cv3.addOptionText(SPANISH, "Cambié de opinión.", "Recuerda, sólo los puros tendrán un lugar en el cielo.");

        ConversationOption cv4 = new ConversationOption(0, 2);
        cv4.addOptionText(ENGLISH, "General Lenny send me to help you.", "Oh, very well. The church have some donations to be delivered, but I fear that can be stolen so I asked the help of the army.\nSo, you are the one that will help me?");
        cv4.addOptionText(PORTUGUESE, "O General Lenny me enviou para ajudar você.", "Ah, muito bem. A igreja tem algumas doações para serem entregues, mas temo que possam ser roubadas, então pedi a ajuda do exército.\nEntão, você é quem vai me ajudar?");
        cv4.addOptionText(SPANISH, "El General Lenny me envió para ayudarte.", "Oh, muy bien. La iglesia tiene algunas donaciones para entregar, pero temo que puedan ser robadas, así que pedí la ayuda del ejército.\n¿Entonces, tú eres quien me ayudará?");
        cv4.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.LOOKING_FOR_A_GUILD);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 12) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv5 = new ConversationOption(2, 0);
        cv5.addOptionText(ENGLISH, "Yes, I handle it.", "Very good. It is just some crates, you can deliver to Captain Palmer in the harbor, he knows what to do with the donation goods.");
        cv5.addOptionText(PORTUGUESE, "Sim, eu cuido disso.", "Muito bom. São apenas algumas caixas, você pode entregar ao Capitão Palmer no porto, ele sabe o que fazer com os bens de doação.");
        cv5.addOptionText(SPANISH, "Sí, me encargo de ello.", "Muy bien. Son solo algunas cajas, puedes entregarlas al Capitán Palmer en el puerto, él sabe qué hacer con los bienes de donación.");
        cv5.listeners = (ctx, currentFragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.LOOKING_FOR_A_GUILD);
            LibInventory.addToInventory(ItemsIds.DONATION_GOODS, 1, App.getPlayerChar());
            LibQuest.updateQuest(quest, 13, App.getPlayerChar(), ctx);
        };

        ConversationOption cv6 = new ConversationOption(2, 0);
        cv6.addOptionText(ENGLISH, "Not now.", "Then I wait, but remember, the poors are in need.");
        cv6.addOptionText(PORTUGUESE, "Agora não.", "Então eu espero, mas lembre-se, os pobres estão necessitados.");
        cv6.addOptionText(SPANISH, "Ahora no.", "Entonces esperaré, pero recuerda, los pobres están necesitados.");

        npc.conversationOptions.add(cv1);
        npc.conversationOptions.add(cv2);
        npc.conversationOptions.add(cv3);
        npc.conversationOptions.add(cv4);
        npc.conversationOptions.add(cv5);
        npc.conversationOptions.add(cv6);

        // ========================================
        // QUEST: LIKE A DETECTIVE — PART 1
        // ========================================

        // Investigation first question
        ConversationOption cvInv1 = new ConversationOption(0, 30);
        cvInv1.addOptionText(ENGLISH, "Father Edward, I have a few questions for you.",
                "*He straightens slightly, a flicker of unease crossing his face*\nOf course, of course... ask whatever you need. I have nothing to hide. I am a man of the church, after all.\n*He laughs a little too quickly*");
        cvInv1.addOptionText(PORTUGUESE, "Padre Edward, tenho algumas perguntas para você.",
                "*Ele se endireita levemente, um tremor de desconforto cruzando seu rosto*\nClaro, claro... pergunte o que precisar. Não tenho nada a esconder. Sou um homem da igreja, afinal.\n*Ele ri um pouco rápido demais*");
        cvInv1.addOptionText(SPANISH, "Padre Edward, tengo algunas preguntas para usted.",
                "*Se endereza ligeramente, un destello de inquietud cruzando su rostro*\nPor supuesto, por supuesto... pregunta lo que necesites. No tengo nada que ocultar. Soy un hombre de la iglesia, al fin y al cabo.\n*Ríe un poco demasiado rápido*");
        cvInv1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.LIKE_A_DETECTIVE, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvInv1);

        // Second question
        ConversationOption cvInv2 = new ConversationOption(30, 31);
        cvInv2.addOptionText(ENGLISH, "Where were you last night?",
                "*A visible pause*\nI... I was here. In the church. Praying, as a priest should be.\n*His hands clasp together a little too tightly*\nWhy do you ask?");
        cvInv2.addOptionText(PORTUGUESE, "Onde você estava ontem à noite?",
                "*Uma pausa visível*\nEu... eu estava aqui. Na igreja. Orando, como um padre deve estar.\n*Suas mãos se unem um pouco muito rígidas*\nPor que você pergunta?");
        cvInv2.addOptionText(SPANISH, "¿Dónde estaba usted anoche?",
                "*Una pausa visible*\nYo... yo estaba aquí. En la iglesia. Rezando, como debe estar un pároco.\n*Sus manos se unen un poco demasiado rígidas*\n¿Por qué preguntas?");
        npc.conversationOptions.add(cvInv2);

        // Third question
        ConversationOption cvInv3 = new ConversationOption(31, 32);
        cvInv3.addOptionText(ENGLISH, "Do you know anyone suspicious in Lisport?",
                "*He shifts uncomfortably*\nSuspicious? I... I would not say that. Everyone in Lisport is a good soul, more or less. I — I am sure you can find no wrongdoing here.\n*His voice rises slightly*\nWas that all?");
        cvInv3.addOptionText(PORTUGUESE, "Você conhece alguma pessoa suspeita em Lisport?",
                "*Ele se move desconfortavelmente*\nSuspeita? Eu... eu não diria isso. Todos em Lisport são boas almas, mais ou menos. Eu — tenho certeza de que você não pode encontrar nenhuma transgressão aqui.\n*Sua voz sobe ligeiramente*\nIsso foi tudo?");
        cvInv3.addOptionText(SPANISH, "¿Conoce a alguien sospechoso en Lisport?",
                "*Se mueve incómodo*\n¿Sospechoso? Yo... yo no diría eso. Todos en Lisport son buenas almas, más o menos. Yo — estoy seguro de que no puedes encontrar ninguna transgresión aquí.\n*Su voz sube ligeramente*\n¿Eso fue todo?");
        npc.conversationOptions.add(cvInv3);

        // Final investigation question → update to part 2
        ConversationOption cvInv4 = new ConversationOption(32, 0);
        cvInv4.addOptionText(ENGLISH, "One last thing — have you been receiving unusual visitors lately?",
                "*He blinks several times, then forces a calm smile*\nUnusual visitors? No, no. The usual flock. Pilgrims, the sick, those seeking guidance.\n*He waves a hand dismissively*\nI really must prepare for evening prayer now. Good day.");
        cvInv4.addOptionText(PORTUGUESE, "Última coisa — você tem recebido visitantes incomuns ultimamente?",
                "*Ele pisca várias vezes, depois força um sorriso calmo*\nVisitantes incomuns? Não, não. O rebanho habitual. Peregrinos, doentes, aqueles que buscam orientação.\n*Ele acena com a mão dismissivamente*\nRealmente devo me preparar para a oração da noite agora. Bom dia.");
        cvInv4.addOptionText(SPANISH, "Una última cosa — ¿ha recibido visitantes inusuales últimamente?",
                "*Pestañea varias veces, luego fuerza una sonrisa tranquila*\n¿Visitantes inusuales? No, no. El rebaño habitual. Peregrinos, enfermos, los que buscan orientación.\n*Hace un gesto desdeñoso con la mano*\nRealmente debo prepararme para la oración vespertina ahora. Buenos días.");
        cvInv4.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.LIKE_A_DETECTIVE, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvInv4);

        npc.byeMessages.put(ENGLISH, Collections.singletonList("God bless you, citizen."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Deus o abençoe, cidadão."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Dios te bendiga, ciudadano."));

        return npc;
    }
}

