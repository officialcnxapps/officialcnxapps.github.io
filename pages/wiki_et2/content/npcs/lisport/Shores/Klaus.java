package com.cnx.endlesstalestwo.data.npcs.lisport.Shores;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import android.os.Looper;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.GameEngine;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.events.EventsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.shops.ShopsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Event;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibNpc;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Klaus extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, klaus());
    }

    Npc klaus() {
        Npc npc = new Npc("Klaus");
        npc.age = 56;
        npc.job = Enums.NPCJobs.MALE_FISHERMAN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A peaceful, calm and shrewd man.\nKnows various trades, from fishing to hunting. Self-taught, learned everything living on the streets of Lisport.\nSolitary, without family, but seems to truly enjoy his life this way.\n\nPhysical traits: His dark skin hides his age a bit, but the black beard with grey strands does not. Dark brown eyes.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um homem pacífico, tranquilo e astuto.\nConhece diversos ofícios, da pesca à caça. Autodidata, aprendeu tudo vivendo nas ruas da Lisport.\nSolitário, sem família, mas parece mesmo gostar da sua vida assim.\n\nSeus taços físicos: Sua pele negra esconde um pouco sua idade, mas a barba preta com fios grisalhos não. Olhos castanhos escuros.");
        npc.addDescriptionTranslation(SPANISH, "Un hombre pacífico, tranquilo y astuto.\nConoce varios oficios, desde la pesca hasta la caza. Autodidacta, aprendió todo viviendo en las calles de Lisport.\nSolitario, sin familia, pero parece disfrutar realmente de su vida así.\n\nTrasos físicos: Su piel negra oculta un poco su edad, pero la barba negra con canas no. Ojos marrón oscuro.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hi, [PLAYERNAME]"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Oi, [PLAYERNAME]"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola, [PLAYERNAME]"));

        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "So, what do you do?", LibNpc.getAboutJobMsg(npc));
        cv1.addOptionText(PORTUGUESE, "Então, o que mesmo você faz?", LibNpc.getAboutJobMsg(npc));
        cv1.addOptionText(SPANISH, "Entonces, ¿qué haces?", LibNpc.getAboutJobMsg(npc));


        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "How are you, [NPC_NAME]?", "I'm well. Living by the ocean is very relaxing.");
        cv2.addOptionText(PORTUGUESE, "Como você está, [NPC_NAME]?", "Estou tranquilo. Viver a beira do oceano é muito relaxante.");
        cv2.addOptionText(SPANISH, "¿Cómo estás , [NPC_NAME]?", "Estoy tranquilo. Vivir junto al mar es muy relajante.");

        ConversationOption cv3 = new ConversationOption(1, 0);
        cv3.addOptionText(ENGLISH, "And you sell fishes?", "Yes, and some other things that I produce. Here, take a look...");
        cv3.addOptionText(PORTUGUESE, "E você vende peixes?", "Sim, e algumas outras coisas que produzo. Aqui, dê uma olhada...");
        cv3.addOptionText(SPANISH, "¿Y vendes pescado?", "Sí, y algunas otras cosas que produzco. Aquí, echa un vistazo...");
        cv3.listeners = (ctx, fragment) -> {
            fragment.setScreenTouchable(false);
            new android.os.Handler(Looper.getMainLooper()).postDelayed(() -> {
                        if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                            gPlayActivity.lockScreenTouches(true);
                            gPlayActivity.goToViewShop(ShopsIds.KLAUS_THINGS);
                        }
                    }
                    , 1600);
        };

        ConversationOption cv4 = new ConversationOption(0, 2);
        cv4.addOptionText(ENGLISH, "[NPC_NAME], may I ask if you know how to read?", "Yes, my grandmother teached me many years ago.\nDo you want me to read something for you?");
        cv4.addOptionText(PORTUGUESE, "[NPC_NAME], posso perguntar se você sabe ler?", "Sim, minha avó me ensinou muitos anos atrás.\nVocê quer que eu leia algo para você?");
        cv4.addOptionText(SPANISH, "[NPC_NAME], ¿puedo preguntarte si sabes leer?", "Sí, mi abuela me enseñó hace muchos años. ¿Quieres que te lea algo?");
        cv4.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.I_WANT_TO_READ);
            if (requiredQuest != null && (requiredQuest.getCurrentPartOrder() == 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv5 = new ConversationOption(2, 3);
        cv5.addOptionText(ENGLISH, "Actually, I want to learn, can you teach me?", "Well, I have free time... this demands many hours, maybe days. But I need to say, I will need some payment. ");
        cv5.addOptionText(PORTUGUESE, "Na verdade, eu quero aprender, você pode me ensinar?", "Bem, eu tenho tempo livre... isso demanda muitas horas, talvez dias. Mas preciso dizer, vou precisar de algum pagamento.");
        cv5.addOptionText(SPANISH, "En realidad quiero aprender ¿puedes enseñarme?", "Bueno, tengo tiempo libre... esto demanda muchas horas, tal vez días. Pero debo decir que necesitaré algún pago.");

        ConversationOption cv6 = new ConversationOption(3, 0);
        cv6.addOptionText(ENGLISH, "Makes sense. How much?", "I think that 5 gold coins would pay this service.");
        cv6.addOptionText(PORTUGUESE, "Faz sentido. Quanto?", "Acredito que 5 moedas de ouro pagariam esse serviço.");
        cv6.addOptionText(SPANISH, "Tiene sentido. ¿Cuánto?", "Creo que 5 monedas de oro pagarían este servicio.");
        cv6.listeners = (ctx, fragment) -> LibQuest.updateQuest(QuestsIds.I_WANT_TO_READ, 3, App.getPlayerChar(), ctx);

        ConversationOption cv7 = new ConversationOption(0, 4);
        cv7.addOptionText(ENGLISH, "I have the gold, let's start?", "Sure, I am available now, I have a lot of free time. Let's learn how to read and write.");
        cv7.addOptionText(PORTUGUESE, "Eu tenho o ouro, vamos começar?", "Claro, estou disponível agora, tenho muito tempo livre. Vamos aprender a ler e escrever.");
        cv7.addOptionText(SPANISH, "Tengo el oro ¿empezamos?", "Claro, ahora estoy disponible, tengo mucho tiempo libre. Aprendamos a leer y escribir.");
        cv7.listeners = (ctx, fragment) -> {
            App.getPlayerChar().removeGold(5);
            LibQuest.completeQuest(QuestsIds.I_WANT_TO_READ, App.getPlayerChar(), 4, ctx);
            if (fragment != null) {
                GameEngine.updateTopToolbar(fragment.getView(), fragment.isShowingBackButton);
                Event event = App.DataManager.getEvent(EventsIds.QUEST_I_WANT_TO_READ_PART_3);
                if (event != null) {
                    fragment.executeEvent(event);
                }
            }
        };
        cv7.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.I_WANT_TO_READ);
            if (requiredQuest != null && (requiredQuest.getCurrentPartOrder() == 3) && App.getPlayerChar().checkHasGold(5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv8 = new ConversationOption(4, 0);
        cv8.addOptionText(ENGLISH, "I think I learned.", "Yes, you did very well. You can keep practicing to improve, but I think this was the last class.");
        cv8.addOptionText(PORTUGUESE, "Acho que aprendi.", "Sim, você foi muito bem. Você pode continuar praticando para melhorar, mas acho que essa foi a última aula.");
        cv8.addOptionText(SPANISH, "Creo que aprendí.", "Sí, lo hiciste muy bien. Puedes seguir practicando para mejorar, pero creo que esta fue la última clase.");

        npc.conversationOptions.add(cv1);
        npc.conversationOptions.add(cv2);
        npc.conversationOptions.add(cv3);
        npc.conversationOptions.add(cv4);
        npc.conversationOptions.add(cv5);
        npc.conversationOptions.add(cv6);
        npc.conversationOptions.add(cv7);
        npc.conversationOptions.add(cv8);

        // ===== QUEST: Like a Landlord - Refuse house offer =====
        ConversationOption cvRefuseHouse = new ConversationOption(0, 0);
        cvRefuseHouse.addOptionText(ENGLISH, "Would you be interested in buying land in Havarus?", "Havarus? Leave the ocean? Never! I've been a fisherman here all my life, just like my father and his father before him. The sea is in my blood. I could never live inland, away from the waves and salt air. This is my home, and it always will be.");
        cvRefuseHouse.addOptionText(PORTUGUESE, "Você estaria interessado em comprar terra em Havarus?", "Havarus? Deixar o oceano? Nunca! Fui pescador aqui toda a minha vida, assim como meu pai e o pai dele antes dele. O mar está no meu sangue. Eu nunca poderia viver no interior, longe das ondas e do ar salgado. Esta é minha casa, e sempre será.");
        cvRefuseHouse.addOptionText(SPANISH, "¿Estarías interesado en comprar tierra en Havarus?", "¿Havarus? ¿Dejar el océano? ¡Nunca! He sido pescador aquí toda mi vida, al igual que mi padre y el padre de él antes que él. El mar está en mi sangre. Nunca podría vivir tierra adentro, lejos de las olas y el aire salado. Este es mi hogar, y siempre lo será.");
        cvRefuseHouse.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.LIKE_A_LANDLORD, 1)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.LIKE_A_LANDLORD, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRefuseHouse);

        return npc;
    }
}

