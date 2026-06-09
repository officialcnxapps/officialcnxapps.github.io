package com.cnx.endlesstalestwo.data.npcs.lisport.Harbor;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;
import com.cnx.endlesstalestwo.libs.Utils;

import java.util.Collections;

public class CptPalmer extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, captainPalmer());
    }

    Npc captainPalmer() {
        Npc npc = new Npc("Captain Palmer");
        npc.addNameTranslation(PORTUGUESE, "Capitão Palmer");
        npc.addNameTranslation(SPANISH, "Capitán Palmer");
        npc.age = 45;
        npc.job = Enums.NPCJobs.SHIP_CAPTAIN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Some might say he's rude. Always speaks in a loud tone of voice, commands respect.\nHe is direct and firm in his work as a captain. Has no patience for idle chatter.\n\nPhysical traits: Long beard and mustache and, like his hair, are red. Blue eyes and always serious expression.");
        npc.addDescriptionTranslation(PORTUGUESE, "Alguns poderiam dizer que é grosseiro. Usa sempre um tom de voz alto, impõe respeito.\nÉ direto e firme no seu trabalho como capitão. Não tem muita paciência para conversas fiadas\n\nSeus taços físicos: Barba e bigode compridos e, assim como o cabelo, são ruivos. Olhos azuis e expressão sempre séria.");
        npc.addDescriptionTranslation(SPANISH, "Algunos dirían que es grosero. Siempre habla con un tono de voz fuerte, exige respeto.\nEs directo y firme en su trabajo como capitán. No tiene paciencia para charlas ociosas.\n\nTrasos físicos: Barba y bigote largos y, como su cabello, son rojos. Ojos azules y expresión siempre seria.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Greetings [GENDER_SIMPLE_CALL]."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Saudações [GENDER_SIMPLE_CALL]."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Saludos [GENDER_SIMPLE_CALL]."));

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What is your role here?", "I am a ship captain, my hat should let it very clear. I made the route between Monelix, in Havarus, to Lisport since I was 16.");
        cv1.addOptionText(PORTUGUESE, "Qual é o seu papel aqui?", "Sou capitão de navio, meu chapéu deve deixar bem claro. Fiz a rota entre Monelix, em Havarus, para Lisport desde os meus 16 anos.");
        cv1.addOptionText(SPANISH, "¿Cuál es tu papel aquí?", "Soy capitán de barco, mi sombrero debería dejarlo bien claro. Hice la ruta entre Monelix, en Havarus, y Lisport desde que tenía 16 años.");

        ConversationOption cv2 = new ConversationOption(0, 1);
        cv2.addOptionText(ENGLISH, "I need to sail.", "Alright, currently, I only can take you to Havarus. Obviously, it is not free, the fare is 12 pieces of gold.");
        cv2.addOptionText(PORTUGUESE, "Preciso navegar.", "Tudo bem, atualmente, só posso levá-lo para Havarus. Obviamente, não é de graça, a tarifa é de 12 peças de ouro.");
        cv2.addOptionText(SPANISH, "Necesito navegar.", "De acuerdo, por ahora solo puedo llevarte a Havarus. Obviamente, no es gratis, la tarifa son 12 monedas de oro.");

        ConversationOption cv4 = new ConversationOption(0, 0);
        cv4.addOptionText(ENGLISH, "Sir, I bring donations from the church.", "Ya! Priest Edward sent me a letter days ago telling that some donations would be delivered here to be transported. Thanks.");
        cv4.addOptionText(PORTUGUESE, "Senhor, trago doações da igreja.", "Ya! O padre Edward me enviou uma carta há alguns dias dizendo que algumas doações seriam entregues aqui para serem transportadas. Obrigado.");
        cv4.addOptionText(SPANISH, "Señor, traigo donaciones de la iglesia.", "¡Ya! El sacerdote Edward me envió una carta hace días diciéndome que algunas donaciones llegarían aquí para ser transportadas. Gracias.");
        cv4.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null) {
                Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.LOOKING_FOR_A_GUILD);
                boolean haveItems = LibInventory.checkHasItemAmount(ItemsIds.DONATION_GOODS, 1, App.getPlayerChar());
                if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 13 && haveItems) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv4.listeners = (ctx, currentFragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.LOOKING_FOR_A_GUILD);
            LibInventory.removeFromInventory(ItemsIds.DONATION_GOODS, 1, App.getPlayerChar());
            LibQuest.updateQuest(quest, 14, App.getPlayerChar(), ctx);
        };

        /// TRAVEL OPTIONS
        ConversationOption cvTravel1 = new ConversationOption(1, 999);
        cvTravel1.addOptionText(ENGLISH, "Travel to Havarus [12 gold]", "Ya! Let the sea lords guide us!");
        cvTravel1.addOptionText(PORTUGUESE, "Viagem para Havarus [12 ouro]", "Ya! Deixe os senhores do mar nos guiarem!");
        cvTravel1.addOptionText(SPANISH, "Viaje a Havarus [12 de oro]", "¡Ya! ¡Dejemos que los señores del mar nos guíen!");
        cvTravel1.showEvenWhenNotValid = true;
        cvTravel1.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(12)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cvTravel1.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.MONELIX_DOCKS, 12, gPlayActivity, App.getPlayerChar());
            }
        };

        ConversationOption cvTravelNo = new ConversationOption(1, 0);
        cvTravelNo.addOptionText(ENGLISH, "Changed my mind...", "Ok...");
        cvTravelNo.addOptionText(PORTUGUESE, "Mudei de ideia...", "Ok...");
        cvTravelNo.addOptionText(SPANISH, "Cambié de opinión...", "Ok...");

        npc.conversationOptions.add(cv1);
        npc.conversationOptions.add(cv2);
        npc.conversationOptions.add(cvTravel1);
        npc.conversationOptions.add(cv4);
        npc.conversationOptions.add(cvTravelNo);

        return npc;
    }
}
