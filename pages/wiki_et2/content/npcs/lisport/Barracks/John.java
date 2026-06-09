package com.cnx.endlesstalestwo.data.npcs.lisport.Barracks;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.COUNTER_ATTACK;

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

public class John extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, john());
    }

    Npc john() {
        Npc npc = new Npc("John");
        npc.age = 26;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.MALE;

        npc.addDescriptionTranslation(ENGLISH, "A calm man, somewhat innocent, but does not hesitate when duty calls.\nLoves his family and his work.\nA hardworking young soldier.\n\nPhysical traits: Dark skin with a warm demeanor, short and curly hair. Prominent mouth.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um homem tranquilo, levemente inocente, mas que não hesita se o dever chamar.\nAma sua família e seu trabalho.\nUm jovem soldado esforçado.\n\nSeus taços físicos: Pele escura e jovial, cabelos curtos e encaracolados. Boca proeminente.");
        npc.addDescriptionTranslation(SPANISH, "Un hombre tranquilo, algo inocente, pero que no duda cuando el deber lo llama.\nAma a su familia y su trabajo.\nUn joven soldado trabajador.\n\nTrasos físicos: Piel oscura con un carácter cálido, cabello corto y rizado. Boca prominente.");

        LibNpc.generateRandomConversations(npc);

        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, COUNTER_ATTACK, 2) || LibQuest.isCharacterAtQuestPart(chara, COUNTER_ATTACK, 3)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH,
                "Can I be helpful to you, [NPC_NAME]?",
                "Hmmm... I think so. My wife needs my help with our child but Lenny asked me to get some rocks to reinforce the city walls, I can't do both at same time.");
        cv1.addOptionText(PORTUGUESE,
                "Posso ajudar você, [NPC_NAME]?",
                "Hmmm... Acho que sim. Minha esposa precisa da minha ajuda com nosso filho, mas Lenny me pediu para pegar algumas pedras para reforçar os muros da cidade, não posso fazer as duas coisas ao mesmo tempo.");
        cv1.addOptionText(
                SPANISH,
                "¿Puedo serte útil, [NPC_NAME]?",
                "Hmmm... Creo que sí. Mi esposa necesita mi ayuda con nuestro hijo, pero Lenny me pidió que consiguiera algunas rocas para reforzar las murallas de la ciudad. No puedo hacer ambas cosas al mismo tiempo.");
        cv1.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.ARMY_NOVICE_TASKS);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv2 = new ConversationOption(1, 0);
        cv2.addOptionText(ENGLISH,
                "I get the rocks for you.",
                "Really?\nGreat, thank you, [PLAYERNAME]. When you get 7 rocks, just bring to me, alright?");
        cv2.addOptionText(PORTUGUESE,
                "Eu pego as pedras para você.",
                "Sério?\"Ótimo, obrigado, [PLAYERNAME]. Quando você tiver 7 pedras, traga para mim, ok?");
        cv2.addOptionText(
                SPANISH,
                "Yo te traigo las piedras.",
                "¿En serio?\nGenial, gracias, [PLAYERNAME]. Cuando consigas 7 rocas, tráemelas, ¿de acuerdo?");
        cv2.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.ARMY_NOVICE_TASKS);
            LibQuest.updateQuest(quest, 4, App.getPlayerChar(), ctx);
        };

        ConversationOption cv3 = new ConversationOption(1, 0);
        cv3.addOptionText(ENGLISH,
                "Sorry, but I can't help you now.",
                "Not a problem, those are my compromises.\nBut, if you change your mind, I am here.");
        cv3.addOptionText(PORTUGUESE,
                "Desculpe, mas não posso ajudar você agora.",
                "Não tem problema, esses são meus compromissos.\nMas, se mudar de ideia, estou aqui.");
        cv3.addOptionText(
                SPANISH,
                "Lo siento, pero no puedo ayudarte ahora.",
                "No hay problema, esos son mis compromisos.\nPero, si cambias de opinión, aquí estoy.");

        ConversationOption cv4 = new ConversationOption(0, 0);
        cv4.addOptionText(ENGLISH,
                "I got the rocks for you.",
                "Many thanks, [PLAYERNAME]! Your help was very important to me.");
        cv4.addOptionText(PORTUGUESE,
                "Eu tenho as pedras para você.",
                "Muito obrigado, [PLAYERNAME]! Sua ajuda foi muito importante para mim.");
        cv4.addOptionText(
                SPANISH,
                "Tengo las rocas para ti.",
                "¡Muchas gracias, [PLAYERNAME]! Tu ayuda fue muy importante para mí.");
        cv4.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = chara.getQuest(QuestsIds.ARMY_NOVICE_TASKS);
            boolean haveItems = LibInventory.checkHasItemAmount(ItemsIds.ROCK, 7, chara);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 4 && haveItems) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv4.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.ARMY_NOVICE_TASKS);
            LibInventory.removeFromInventory(ItemsIds.ROCK, 7, App.getPlayerChar());
            LibQuest.updateQuest(quest, 5, App.getPlayerChar(), ctx);
        };

        ConversationOption cv5 = new ConversationOption(0, 2);
        cv5.addOptionText(ENGLISH,
                "Can I help you with something else?",
                "I don't want to bother you, but if you can, I have something to you...");
        cv5.addOptionText(PORTUGUESE,
                "Posso ajudar você com mais alguma coisa?",
                "Não quero te incomodar, mas se puder, tenho algo para lhe dizer...");
        cv5.addOptionText(
                SPANISH,
                "¿Puedo ayudarte con algo más?",
                "No quiero molestarte, pero si puedes, tengo algo que decirte...");
        cv5.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.ARMY_NOVICE_TASKS);
            Quest notHaveQuest = App.getPlayerChar().getQuest(QuestsIds.A_SHINNING_DECISION);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() >= 5 && notHaveQuest == null) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv6 = new ConversationOption(2, 0);
        cv6.addOptionText(ENGLISH,
                "Yes, I help, what should I do?",
                "Earlier I went home to help my wife and now I noticed that I forgot my ring there. I have a lot of things to do here in the barracks, so go there and bring to me, please.");
        cv6.addOptionText(PORTUGUESE,
                "Sim, eu ajudo, o que devo fazer?",
                "Mais cedo fui para casa ajudar minha esposa e agora percebi que esqueci meu anel lá. Tenho muitas coisas para fazer aqui no quartel, então vá lá e traga para mim, por favor.");
        cv6.addOptionText(
                SPANISH,
                "Si, ayudo ¿que debo hacer?",
                "Antes fui a casa para ayudar a mi esposa y ahora me di cuenta de que olvidé mi anillo allí. Tengo muchas cosas que hacer aquí en el cuartel, así que ve allí y tráemelo, por favor.");
        cv6.listeners = (ctx, fragment) -> {
            Quest newQuest = App.DataManager.getQuest(QuestsIds.A_SHINNING_DECISION);
            LibQuest.includeQuestToQuestbook(newQuest, App.getPlayerChar(), ctx);
        };

        ConversationOption cv7 = new ConversationOption(2, 0);
        cv7.addOptionText(ENGLISH,
                "Sorry. [NPC_NAME], I can't be helpful now.",
                "Ok, I will get it later, let's pray to my wife don't find the ring before me.");
        cv7.addOptionText(PORTUGUESE,
                "Desculpe. [NPC_NAME], não posso ajudar agora.",
                "Ok, vou buscá-lo mais tarde, vamos rezar para que minha esposa não encontre o anel antes de mim.");
        cv7.addOptionText(
                SPANISH,
                "Lo siento. [NPC_NAME], no puedo ayudarte ahora.",
                "Bueno, lo conseguiré más tarde, recemos para que mi esposa no encuentre el anillo antes que yo.");

        ConversationOption cv8 = new ConversationOption(0, 0);
        cv8.addOptionText(ENGLISH,
                "Here, I have your ring.",
                "Good, thank you so much! You are a good friend. I must give you some coins as thanks.");
        cv8.addOptionText(PORTUGUESE,
                "Aqui está o seu anel.",
                "Bom, muito obrigado! Você é um bom amigo. Devo lhe dar algumas moedas como agradecimento.");
        cv8.addOptionText(
                SPANISH,
                "Toma, tengo tu anillo.",
                "Bien, muchas gracias, eres un buen amigo. Debo darte algunas monedas como agradecimiento.");
        cv8.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.A_SHINNING_DECISION);
            boolean haveItem = LibInventory.checkHasItem(ItemsIds.SILVER_RING, App.getPlayerChar());
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 2 && haveItem) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv8.listeners = (ctx, fragment) -> {
            LibInventory.removeFromInventory(ItemsIds.SILVER_RING, 1, App.getPlayerChar());
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.A_SHINNING_DECISION);
            LibQuest.updateQuest(quest, 4, App.getPlayerChar(), ctx);
            App.getPlayerChar().addGold(4);
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);
        };

        ConversationOption cv9 = new ConversationOption(0, 0);
        cv9.addOptionText(ENGLISH,
                "Sorry, I could not find your ring...",
                "Oh no, where should it be!? I need to find it.\nBut, anyway, thanks for your attempt to find.");
        cv9.addOptionText(PORTUGUESE,
                "Desculpe, não consegui encontrar seu anel...",
                "Ah, não, onde deve estar!? Preciso encontrá-lo.\nMas, de qualquer forma, obrigado por sua tentativa de encontrá-lo.");
        cv9.addOptionText(
                SPANISH,
                "Lo siento, no pude encontrar tu anillo...",
                "¡Oh, no! ¿Dónde debería estar? Necesito encontrarlo.\nPero, de todos modos, gracias por intentar encontrarlo.");
        cv9.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.A_SHINNING_DECISION);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv9.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.A_SHINNING_DECISION);
            LibQuest.updateQuest(quest, 5, App.getPlayerChar(), ctx);
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);
        };

        npc.conversationOptions.add(cv1);
        npc.conversationOptions.add(cv2);
        npc.conversationOptions.add(cv3);
        npc.conversationOptions.add(cv4);
        npc.conversationOptions.add(cv5);
        npc.conversationOptions.add(cv6);
        npc.conversationOptions.add(cv7);
        npc.conversationOptions.add(cv8);
        npc.conversationOptions.add(cv9);

        // ===== QUEST: Like a Landlord - Refuse house offer =====
        ConversationOption cvRefuseHouse = new ConversationOption(0, 0);
        cvRefuseHouse.addOptionText(ENGLISH, "Would you be interested in buying land in Havarus?", "Buy land in Havarus? Are you serious? I'm a soldier in the army! My duty is here in Lisport, protecting our kingdom. I can't just leave my post and move to another realm. That would be desertion! Absolutely not.");
        cvRefuseHouse.addOptionText(PORTUGUESE, "Você estaria interessado em comprar terra em Havarus?", "Comprar terra em Havarus? Você está falando sério? Sou um soldado do exército! Meu dever é aqui em Lisport, protegendo nosso reino. Não posso simplesmente deixar meu posto e me mudar para outro reino. Isso seria deserção! Absolutamente não.");
        cvRefuseHouse.addOptionText(SPANISH, "¿Estarías interesado en comprar tierra en Havarus?", "¿Comprar tierra en Havarus? ¿Hablas en serio? ¡Soy un soldado del ejército! Mi deber está aquí en Lisport, protegiendo nuestro reino. No puedo simplemente abandonar mi puesto y mudarme a otro reino. ¡Eso sería deserción! Absolutamente no.");
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
