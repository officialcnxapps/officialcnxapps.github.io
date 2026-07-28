package com.cnx.endlesstalestwo.data.npcs.havarusSouth.apenna;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.A_RUMOR_SPREADING;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.R;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.houses.HousesIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Terry extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Terry");
        npc.age = 46;
        npc.job = Enums.NPCJobs.LANDLORD;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "He knows the value of his work and how to manage it.\nDirect in business and in his attitude.\nHe seems to have family living in the area.\n\nHis physical traits: Straight black hair, as well as his beard and mustache. A focused look with light brown eyes.");
        npc.addDescriptionTranslation(PORTUGUESE, "Sabe o valor do seu trabalho e como gerenciar isso.\nDireto nos negócios e nas suas atitudes.\nParece ter família morando pela região.\n\nSeus traços físicos: Cabelo liso e preto, assim como sua barba e bigode. Olhar compenetrado com seus olhos castanhos claros.");
        npc.addDescriptionTranslation(SPANISH, "He knows the value of his work and how to manage it.\nDirect in business and in his attitude.\nHe seems to have family living in the area.\n\nHis physical traits: Straight black hair, as well as his beard and mustache. A focused look with light brown eyes.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hey ya. I am Terry, greetings to you."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá. Eu sou o Terry, saudações a você."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola. Soy Terry, saludos."));
        npc.generateRandomByes();

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "You seem to be an important around here. What do you do?", "Important? One could say that. I am the landlord of many lands here, you see? A respectable position, I assure you. Good gold, calm work... what's not to like? Besides, someone has to keep this village in line.");
        cv1.addOptionText(PORTUGUESE, "Você parece ser importante por aqui. O que você faz?", "Importante? Poder-se-ia dizer que sim. Eu sou senhorio de muitas terras aqui, sabe? Uma posição respeitável, garanto-lhe. Bom ouro, trabalho calmo... o que há para não gostar? Além disso, alguém tem que manter essa vila na linha.");
        cv1.addOptionText(SPANISH, "Pareces ser importante por aquí. ¿A qué te dedicas?", "¿Importante? Se podría decir que sí. Soy el propietario de muchas tierras aquí, ¿sabes? Un puesto respetable, te lo aseguro. Buen oro, trabajo tranquilo... ¿qué es lo que no gusta? Además, alguien tiene que mantener esta aldea a raya.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Apenna is a fine village?", "It's a pleasure to see new faces. Apenna is the calm and quiet jewel of the kingdom's lands, and I intend to keep it that way.");
        cv2.addOptionText(PORTUGUESE, "Apenna é uma bela vila? ", "É um prazer ver caras novas. Apenna é a joia calma e tranquila das terras do reino, e pretendo mantê-la assim.");
        cv2.addOptionText(SPANISH, "¿Apenna es una buena aldea?", "Es un placer ver caras nuevas. Apenna es la joya tranquila e silenciosa de las tierras del reino, y pretendo mantenerla así.");
        npc.conversationOptions.add(cv2);

        ///ABOUT QUEST: A RUMOR SPREADING
        ConversationOption cv3 = new ConversationOption(0, 1);
        cv3.addOptionText(ENGLISH, "What do you know about the attack of dark creatures?", "Hmm... It was something sad, the girl was still young, she was engaged to a boy from Helera, if I'm not mistaken.\nIt happened next door, on the road, so close.");
        cv3.addOptionText(PORTUGUESE, "O que sabe sobre o ataque de criaturas sombrias?", "Huum... Foi algo triste, a moça ainda era jovem, estava com casamento marcado com um rapaz de Helera, se não estou enganado.\nAconteceu aqui ao lado, na estrada, tão perto.");
        cv3.addOptionText(SPANISH, "¿Qué sabes sobre el ataque de criaturas oscuras?", "Hmm... Fue algo triste, la chica aún era joven, estaba comprometida con un chico de Helera, si no me equivoco.\nSucedió aquí al lado, en la carretera, tan cerca.");
        cv3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, A_RUMOR_SPREADING, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv3.listeners = (ctx, currentFragment) -> {
        };
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(1, 2);
        cv4.addOptionText(ENGLISH, "Did she live in one of the houses here?", "Oh no, no. She was from the fisherman ville over there, she came here to buy meat for dinner, she never arrived...");
        cv4.addOptionText(PORTUGUESE, "Ela morava numa das casas aqui?", "Ah não, não. Ela era ali da vila dos pescadores, veio até aqui para comprar carne para a janta, nunca chegou...");
        cv4.addOptionText(SPANISH, "¿Vivía en una de las casas de aquí?", "Oh no, no. Era del pueblo de pescadores de allí, vino hasta aquí para comprar carne para la cena, nunca llegó...");
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(2, 0);
        cv5.addOptionText(ENGLISH, "Did they see who attacked her?", "They say it was a demon, but nobody knows for sure, it was getting dark and it was near the woods. Don't the fishermen in the village know better?");
        cv5.addOptionText(PORTUGUESE, "Viram quem a atacou?", "Dizem ter sido um demônio, mas ninguém sabo ao certo, estava anoitecendo e foi perto da mata. Será que os pescadores da vila não sabem melhor?");
        cv5.addOptionText(SPANISH, "¿Vieron quién la atacó?", "Dicen que fue un demonio, pero nadie lo sabe con certeza, estaba anocheciendo y fue cerca del bosque. ¿No lo sabrán mejor los pescadores del pueblo?");
        cv5.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(A_RUMOR_SPREADING, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv5);

        // ===== HOUSING: Sell old Fisherman Ville house =====
        ConversationOption cvHouseStart = new ConversationOption(0, 10);
        cvHouseStart.addOptionText(ENGLISH, "Do you know any house for sale?", "As a matter of fact, yes. Long ago I used to live in Fisherman Ville, and that old hut is still mine to sell. It is a simple place, but honest and useful for anyone who likes the coast. If you want it, I will sell it for 25 gold coins.");
        cvHouseStart.addOptionText(PORTUGUESE, "Você conhece alguma casa à venda?", "Na verdade, sim. Há muito tempo eu morava em Fisherman Ville, e aquela velha cabana ainda é minha para vender. É um lugar simples, mas honesto e útil para quem gosta da costa. Se a quiser, vendo por 25 moedas de ouro.");
        cvHouseStart.addOptionText(SPANISH, "¿Conoces alguna casa en venta?", "De hecho, sí. Hace mucho tiempo yo vivía en Fisherman Ville, y esa vieja cabaña todavía es mía para vender. Es un lugar sencillo, pero honesto y útil para quien aprecia la costa. Si la quieres, la vendo por 25 monedas de oro.");
        cvHouseStart.requirementValidations = (chara, ctx) -> {
            if (chara.ownsHouse(HousesIds.FISHERMAN_HUT_HOME)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cvHouseStart);

        ConversationOption cvHouseBuy = new ConversationOption(10, 0);
        cvHouseBuy.addOptionText(ENGLISH, "I will buy the hut. [25 gold]", "Done, then. The place is yours. It may be humble, but it has sheltered me well in the past.");
        cvHouseBuy.addOptionText(PORTUGUESE, "Vou comprar a cabana. (25 ouro)", "Então está feito. O lugar é seu. Pode ser humilde, mas já me abrigou muito bem no passado.");
        cvHouseBuy.addOptionText(SPANISH, "Compraré la cabaña. (25 oro)", "Entonces está hecho. El lugar es tuyo. Puede ser humilde, pero me resguardó muy bien en el pasado.");
        cvHouseBuy.requirementValidations = (chara, ctx) -> {
            if (!chara.ownsHouse(HousesIds.FISHERMAN_HUT_HOME) && chara.checkHasGold(25)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvHouseBuy.listeners = (ctx, currentFragment) -> {
            if (!App.getPlayerChar().ownsHouse(HousesIds.FISHERMAN_HUT_HOME)) {
                App.getPlayerChar().removeGold(25);
                App.getPlayerChar().addOwnedHouse(HousesIds.FISHERMAN_HUT_HOME);
                LibUtils.showToast(LibUtils.getString(R.string.houseBought, ctx), 1, CoreEnums.MessageType.SUCCESS, ctx);
                currentFragment.updateTopDisplay();
                App.Shell.saveGame(ctx);
            }
        };
        npc.conversationOptions.add(cvHouseBuy);

        ConversationOption cvHouseNoMoney = new ConversationOption(10, 0);
        cvHouseNoMoney.addOptionText(ENGLISH, "I do not have enough gold yet.", "No rush. Come back when your purse is heavier.");
        cvHouseNoMoney.addOptionText(PORTUGUESE, "Ainda não tenho ouro suficiente.", "Sem pressa. Volte quando sua bolsa estiver mais pesada.");
        cvHouseNoMoney.addOptionText(SPANISH, "Aún no tengo suficiente oro.", "Sin prisa. Vuelve cuando tu bolsa esté más pesada.");
        cvHouseNoMoney.requirementValidations = (chara, ctx) -> {
            if (!chara.ownsHouse(HousesIds.FISHERMAN_HUT_HOME) && !chara.checkHasGold(25)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvHouseNoMoney);

        ConversationOption cvHouseDecline = new ConversationOption(10, 0);
        cvHouseDecline.addOptionText(ENGLISH, "Maybe later.", "Fair enough. The hut will still be there when you decide.");
        cvHouseDecline.addOptionText(PORTUGUESE, "Talvez depois.", "Justo. A cabana ainda estará lá quando decidir.");
        cvHouseDecline.addOptionText(SPANISH, "Tal vez después.", "Justo. La cabaña seguirá allí cuando lo decidas.");
        npc.conversationOptions.add(cvHouseDecline);

        return npc;
    }
}