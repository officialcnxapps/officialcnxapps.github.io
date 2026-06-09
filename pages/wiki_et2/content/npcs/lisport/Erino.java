package com.cnx.endlesstalestwo.data.npcs.lisport;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.enums.Enums.RequirementVerification.OK;

import android.content.Context;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.Character;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.GameplayCoreEntity;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Erino extends DataHelper {

    Npc erino() {
        Npc npc = new Npc("Erino");
        npc.age = 29;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");
        npc.cantSayBye = true;
        npc.allowTraitsAnalysis = false;

        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(QuestsIds.LETTER_FROM_ERINO, chara)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return OK;
        };

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Oh, Lord, finally I found someone..."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Oh, Senhor, finalmente encontrei alguém..."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Oh, Señor, finalmente encontré a alguien..."));
        npc.byeMessages.put(ENGLISH, Collections.singletonList("th... thanks..."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Oobri... obrigado..."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Grr... gracias..."));

        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "Are you feeling well, sir?", "No... But I have no time to explain... Argh! We are being attacked, please [GENDER_SIMPLE_CALL], deliver this letter to the king... fast!");
        cv1.addOptionText(PORTUGUESE, "Estás a sentir-se bem, senhor?", "Não... Mas não tenho tempo para explicar... Argh! Estamos sendo atacados, por favor [GENDER_SIMPLE_CALL], entregue esta carta ao rei... rápido!");
        cv1.addOptionText(SPANISH, "¿Se siente bien, señor?", "No... Pero no tengo tiempo para explicar... ¡Argh! Estamos siendo atacados, por favor [GENDER_SIMPLE_CALL], entrega esta carta al rey... ¡rápido!");
        cv1.listeners = (ctx, fragment) -> {
            LibInventory.addToInventory(ItemsIds.LETTER_FROM_ERINO, 1, App.getPlayerChar());
            Quest firstQuest = App.DataManager.getQuest(QuestsIds.LETTER_FROM_ERINO);
            LibQuest.includeQuestToQuestbook(firstQuest, App.getPlayerChar(), ctx);
        };

        ConversationOption cv2 = new ConversationOption(1, 999);
        cv2.addOptionText(ENGLISH, "Right! But who are you?", "I am [NPC_NAME], a soldier...");
        cv2.addOptionText(PORTUGUESE, "Certo, mas quem é você?", "Sou [NPC_NAME], um soldado...");
        cv2.addOptionText(SPANISH, "¡Bien! ¿Pero quien eres tú?", "Soy [NPC_NAME], un soldado...");

        npc.conversationOptions.add(cv1);
        npc.conversationOptions.add(cv2);

        return npc;
    }

    Npc erinoAtLisport() {
        Npc npc = new Npc("Erino");
        npc.resetId("ERINO_AT_LISPORT");
        npc.imgFile = "npc_erino_at_lisport";
        npc.age = 29;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");
        npc.cantSayBye = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hey, you again... thank you for delivering the letter."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá, você de novo... obrigado por entregar a carta."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Oye tú de nuevo... gracias por entregar la carta."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("See you in the battlegrounds."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Vejo vocês nos campos de batalha."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Nos vemos en los campos de batalla."));

        npc.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.UNDER_ATTACK);
            Quest requiredQuest2 = App.getPlayerChar().getQuest(QuestsIds.I_WANT_TO_READ);

            if (requiredQuest == null && requiredQuest2 != null && requiredQuest2.isComplete()) {
                return Enums.RequirementVerification.OK;
            }

            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "Hello, are you feeling better?", "I can't say yes, and again we are in a hurry.");
        cv1.addOptionText(PORTUGUESE, "Olá, você está se sentindo melhor?", "Não posso dizer que sim, e novamente estamos com pressa.");
        cv1.addOptionText(SPANISH, "Hola, ¿te sientes mejor?", "No puedo decir que sí, y otra vez tenemos prisa.");

        ConversationOption cv2 = new ConversationOption(1, 2);
        cv2.addOptionText(ENGLISH, "We? In a hurry?", "Yes! All men and women must help, the orcs are laying siege to our city! Arm yourself and help us.");
        cv2.addOptionText(PORTUGUESE, "Nós? Com pressa?", "Sim! Todos os homens e mulheres devem ajudar, os orcs estão sitiando nossa cidade! Arme-se e ajude-nos.");
        cv2.addOptionText(SPANISH, "¿Tenemos prisa?", "¡Sí! Todos los hombres y mujeres deben ayudar. ¡Los orcos están sitiando nuestra ciudad! ¡Ármense y ayúdennos!");

        ConversationOption cv3 = new ConversationOption(2, 3);
        cv3.addOptionText(ENGLISH, "How can I arm myself?", "The army is distributing weapons to the citizens at the forge. Go there, fast.");
        cv3.addOptionText(PORTUGUESE, "Como posso me armar?", "O exército está distribuindo armas para os cidadãos na forja. Vá lá, rápido.");
        cv3.addOptionText(SPANISH, "¿Cómo puedo armarme?", "El ejército está distribuyendo armas a los ciudadanos en la fragua. ¡Vayan allí, rápido!");
        cv3.listeners = (ctx, fragment) -> {
            Quest newQuest = App.DataManager.getQuest(QuestsIds.UNDER_ATTACK);
            LibQuest.includeQuestToQuestbook(newQuest, App.getPlayerChar(), ctx);
        };

        ConversationOption cv4 = new ConversationOption(3, 999);
        cv4.addOptionText(ENGLISH, "Alright!", "See you in the battlegrounds.");
        cv4.addOptionText(PORTUGUESE, "Tudo bem!", "Vejo vocês nos campos de batalha.");
        cv4.addOptionText(SPANISH, "¡Está bien!", "Nos vemos en los campos de batalla.");

        npc.conversationOptions.add(cv1);
        npc.conversationOptions.add(cv2);
        npc.conversationOptions.add(cv3);
        npc.conversationOptions.add(cv4);
        return npc;
    }

    Npc erinoAtLisport2() {
        Npc npc = new Npc("Erino");
        npc.resetId("ERINO_AT_LISPORT_2");
        npc.imgFile = "npc_erino_at_lisport";
        npc.age = 29;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hello, [PLAYERNAME]."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá, [PLAYERNAME]."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola, [NOMBRE DEL JUGADOR]."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("See you in the battlegrounds."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Vejo vocês nos campos de batalha."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Nos vemos en los campos de batalla."));

        npc.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.COUNTER_ATTACK);

            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 1) {
                return Enums.RequirementVerification.OK;
            }

            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv1 = new ConversationOption(0, 4);
        cv1.addOptionText(ENGLISH, "Are we ready to attack the Orcs?", "Yes, we were really fast creating an strategy, that is very simple to be honest:\nWe have more soldiers and are better equipped, so we will march there and smash them all.\nThe soldiers are ready, are you too?");
        cv1.addOptionText(PORTUGUESE, "Estamos prontos para atacar os Orcs?", "Sim, fomos muito rápidos criando uma estratégia, que é muito simples para ser honesto:\nTemos mais soldados e estamos mais bem equipados, então marcharemos até lá e esmagaremos todos eles.\nOs soldados estão prontos, você também?");
        cv1.addOptionText(SPANISH, "¿Estamos listos para atacar a los orcos?", "Sí, fuimos muy rápidos creando una estrategia, que es muy simple para ser honestos:\nTenemos más soldados y estamos mejor equipados, así que marcharemos allí y los aplastaremos a todos.\nLos soldados están listos, ¿y tú también?");
        cv1.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.COUNTER_ATTACK);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 1) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv2 = new ConversationOption(4, 999);
        cv2.addOptionText(ENGLISH, "Yes, let's do it!", "Very well, soldier! C'mon!");
        cv2.addOptionText(PORTUGUESE, "Sim, vamos fazer isso!", "Muito bem, soldado! Vamos lá!");
        cv2.addOptionText(SPANISH, "¡Sí, hagámoslo!", "¡Muy bien, soldado! ¡Vamos!");
        cv2.listeners = (ctx, fragment) -> {
            Quest quest = App.DataManager.getQuest(QuestsIds.COUNTER_ATTACK);
            LibQuest.updateQuest(quest, 2, App.getPlayerChar(), ctx);
        };

        ConversationOption cv3 = new ConversationOption(4, 0);
        cv3.addOptionText(ENGLISH, "Give me more time.", "Don't be late, you don't want to miss the show, right?");
        cv3.addOptionText(PORTUGUESE, "Me dê mais tempo.", "Não se atrase, você não vai querer perder o show, certo?");
        cv3.addOptionText(SPANISH, "Dame más tiempo", "No llegues tarde, no querrás perderte el espectáculo, ¿verdad?");

        npc.conversationOptions.add(cv1);
        npc.conversationOptions.add(cv2);
        npc.conversationOptions.add(cv3);

        return npc;
    }

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, erino());
        App.DataManager.add(Enums.DataTypes.NPC, erinoAtLisport());
        App.DataManager.add(Enums.DataTypes.NPC, erinoAtLisport2());
    }
}
