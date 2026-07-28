package com.cnx.endlesstalestwo.data.npcs.lisport.Tavern;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.R;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Frily extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Frily");
        npc.age = 52;
        npc.job = Enums.NPCJobs.FEMALE_COOK;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A kind lady. Always willing to work and care for those who frequent the tavern.\nAgile in everyday tasks. Focused on what she does.\n\nPhysical traits: Dark and smooth skin. Large brown eyes. Black hair, mouth and nose are prominent.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma bondosa senhora. Sempre disponível para trabalhar e cuidar dos que frequentam a taberna.\nÁgil nas tarefas do dia-a-dia. Focada no que faz.\n\nSeus taços físicos: Pele escura e lisa. Olhos grandes e castanhos. Cabelo negro, boca e nariz proeminentes.");
        npc.addDescriptionTranslation(SPANISH, "Una mujer amable. Siempre dispuesta a trabajar y cuidar a los que frecuentan la taberna.\nÁgil en tareas cotidianas. Enfocada en lo que hace.\n\nTrasos físicos: Piel oscura y suave. Ojos grandes y castaños. Cabello negro, boca y nariz prominentes.");
        npc.canBePickpocketed = true;

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What's cooking today?", "Ah, the usual. Soup, bread, and if you're lucky, some roasted boar.");
        cv1.addOptionText(PORTUGUESE, "O que está a cozinhar hoje?", "Ah, o habitual. Sopa, pão e, se tiveres sorte, algum javali assado.");
        cv1.addOptionText(SPANISH, "¿Qué se cocina hoy?", "Ah, lo de siempre. Sopa, pan y, si tienes suerte, algo de jabalí asado.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Any kitchen tips for a novice?", "Keep your knives sharp and your fire steady. And never be afraid to experiment with herbs.");
        cv2.addOptionText(PORTUGUESE, "Alguma dica de cozinha para um novato?", "Mantenha as facas afiadas e o fogo constante. E nunca tenha medo de experimentar com ervas.");
        cv2.addOptionText(SPANISH, "¿Algún consejo de cocina para un novato?", "Mantén tus cuchillos afilados y tu fuego constante. Y nunca tengas miedo de experimentar con hierbas.");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(0, 1);
        cv3.addOptionText(ENGLISH, "Do you have a cook book I could look at?", "A cook book? Ha! My recipes are all up here, on my head, [GENDER_SIMPLE_CALL]. But I could share a few if you've got the coin.");
        cv3.addOptionText(PORTUGUESE, "Você tem um livro de receitas que eu possa ver?", "Um livro de receitas? Ha! Minhas receitas estão todas na cabeça, [GENDER_SIMPLE_CALL]. Mas não vou mentir, tenho um livro velho que não uso mais, eu usava quando ainda estava aprendendo muitos anos atrás. Se tiveres dinheiro, pode ser seu.");
        cv3.addOptionText(SPANISH, "¿Tiene un libro de cocina que pueda ver?", "Un libro de cocina? ¡Ja! Mis recetas están todas aquí arriba, [GENDER_SIMPLE_CALL]. Pero podría compartir algunas si tienes monedas.");
        cv3.requirementValidations = (chara, ctx) -> {
            if (LibInventory.checkHasItem(ItemsIds.THE_COOK_BOOK, App.getPlayerChar())) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(1, 2);
        cv4.addOptionText(ENGLISH, "I'd like that book, how much do you want?", "It's a really complete book, so 6 gold coins and it's yours.");
        cv4.addOptionText(PORTUGUESE, "Eu gostaria desse livro, quanto quer?", "É realmente um livro completo, então 6 moedas de ouro e ele é seu.");
        cv4.addOptionText(SPANISH, "Me gustaría ese libro, ¿cuánto quieres?", "Es un libro realmente completo, así que 6 monedas de oro y es tuyo.");
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(2, 0);
        cv5.addOptionText(ENGLISH, "I'll take it. [6 Gold]", "Alright! Make good use of it, [GENDER_SIMPLE_CALL].");
        cv5.addOptionText(PORTUGUESE, "Vou Querer. [6 Ouro]", "Certo! Faça bom uso, [GENDER_SIMPLE_CALL].");
        cv5.addOptionText(SPANISH, "Lo tomaré. [6 Oro]", "¡De acuerdo! Haz buen uso de él, [GENDER_SIMPLE_CALL].");
        cv5.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar().checkHasGold(6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv5.listeners = (ctx, currentFragment) -> {
            App.getPlayerChar().removeGold(6);
            LibInventory.addToInventory(ItemsIds.THE_COOK_BOOK, 1, App.getPlayerChar());
            App.Shell.saveGame(ctx);
            String itemName = App.DataManager.getItem(ItemsIds.THE_COOK_BOOK).getName(App.CURRENT_LANGUAGE);
            LibUtils.showToast(LibUtils.getString(R.string.receivedItem, ctx) + itemName, 0, CoreEnums.MessageType.INFO, ctx);
        };
        npc.conversationOptions.add(cv5);

        ConversationOption cv7 = new ConversationOption(2, 0);
        cv7.addOptionText(ENGLISH, "No, thanks...", "Alright, but you're missing out on knowing many amazing recipes.");
        cv7.addOptionText(PORTUGUESE, "Não, obrigado...", "Tudo bem, mas você está perdendo de saber muitas receitas incríveis.");
        cv7.addOptionText(SPANISH, "No, gracias...", "Está bien, pero te estás perdiendo de conocer muchas recetas increíbles.");
        npc.conversationOptions.add(cv7);

        // Roleplay: Após Overseas Recognition (Quest 9) - Reconhecimento do jogador
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "How's the tavern business, Frily?", "Busy as ever, dear. People always need food and drink.\nBut look at you! I heard you are working for the Queen now. From a simple [GENDER_SIMPLE_CALL] to a royal soldier! Next time you come, the meal is on the house.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Como está o negócio da taverna, Frily?", "Ocupado como sempre, querido. As pessoas sempre precisam de comida e bebida.\nMas olhe para você! Ouvi dizer que está trabalhando para a Rainha agora. De um simples [GENDER_SIMPLE_CALL] para um soldado real! Na próxima vez que vier, a refeição é por minha conta.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cómo va el negocio de la taberna, Frily?", "Ocupado como siempre, querido. La gente siempre necesita comida y bebida.\n¡Pero mírate! Escuché que estás trabajando para la Reina ahora. ¡De un simple [GENDER_SIMPLE_CALL] a un soldado real! La próxima vez que vengas, la comida corre por mi cuenta.");
        cvRoleplay1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.OVERSEAS_RECOGNITION)
                    && !LibQuest.isQuestComplete(chara, QuestsIds.KILL_OCTUMAN)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay1);

        // Roleplay: Após Destroy the Lair/Kill Octuman (Quest 13)
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Frily, still making the best food?", "Always, dear! And you... you are becoming quite the legend. Travelers from Havarus come through and tell stories about your deeds.\nIt makes this old cook proud. You started here in Lisport and now the whole kingdom knows your name.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Frily, ainda fazendo a melhor comida?", "Sempre, querido! E você... você está se tornando uma verdadeira lenda. Viajantes de Havarus passam por aqui e contam histórias sobre seus feitos.\nIsso deixa essa velha cozinheira orgulhosa. Você começou aqui em Lisport e agora todo o reino conhece seu nome.");
        cvRoleplay2.addOptionText(SPANISH, "Frily, ¿sigues haciendo la mejor comida?", "¡Siempre, querido! Y tú... te estás convirtiendo en toda una leyenda. Viajeros de Havarus pasan por aquí y cuentan historias sobre tus hazañas.\nHace que esta vieja cocinera se sienta orgullosa. Empezaste aquí en Lisport y ahora todo el reino conoce tu nombre.");
        cvRoleplay2.requirementValidations = (chara, ctx) -> {
            if ((LibQuest.isQuestComplete(chara, QuestsIds.DESTROY_THE_LAIR) || LibQuest.isQuestComplete(chara, QuestsIds.KILL_OCTUMAN))
                    && !LibQuest.isQuestComplete(chara, QuestsIds.GIVING_ORDERS)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay2);

        // Roleplay: Após Giving Orders (Quest 17) - Sobre criaturas das trevas
        ConversationOption cvRoleplay3 = new ConversationOption(0, 0);
        cvRoleplay3.addOptionText(ENGLISH, "Have travelers mentioned the dark creatures?", "Oh yes, terrible stories. Monsters from shadows, villages burning... It frightens the customers.\nBut we are far from the mainland here. Lisport feels safe for now. Though I do keep a sharp knife close, just in case. You never know these days.");
        cvRoleplay3.addOptionText(PORTUGUESE, "Os viajantes mencionaram as criaturas das trevas?", "Ah sim, histórias terríveis. Monstros das sombras, aldeias queimando... Isso assusta os clientes.\nMas estamos longe do continente aqui. Lisport se sente segura por enquanto. Embora eu mantenha uma faca afiada por perto, só por precaução. Nunca se sabe nos dias de hoje.");
        cvRoleplay3.addOptionText(SPANISH, "¿Los viajeros han mencionado las criaturas oscuras?", "Oh sí, historias terribles. Monstruos de las sombras, aldeas ardiendo... Asusta a los clientes.\nPero estamos lejos del continente aquí. Lisport se siente seguro por ahora. Aunque mantengo un cuchillo afilado cerca, por si acaso. Nunca se sabe en estos días.");
        cvRoleplay3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.GIVING_ORDERS)
                    && !LibQuest.isQuestComplete(chara, QuestsIds.THE_FINAL_BATTLE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay3);

        // ===== QUEST: Soup & Meat =====

        // Quest Intro: Offer to help with ingredients
        ConversationOption cvQuestIntro = new ConversationOption(0, 10);
        cvQuestIntro.addOptionText(ENGLISH, "Can I help with something?", "Actually, yes! I'm always in need of fresh ingredients for my special soup. It's the tavern's signature dish, you see.\n\nThe sailors and travelers love it. Keeps them warm and fills their bellies before they head back to sea or continue their journeys.");
        cvQuestIntro.addOptionText(PORTUGUESE, "Posso ajudar com algo?", "Na verdade, sim! Estou sempre precisando de ingredientes frescos para minha sopa especial. É o prato típico da taverna, sabe.\n\nOs marinheiros e viajantes adoram. Mantém eles aquecidos e enche suas barrigas antes de voltarem ao mar ou continuarem suas jornadas.");
        cvQuestIntro.addOptionText(SPANISH, "¿Puedo ayudar con algo?", "¡De hecho, sí! Siempre necesito ingredientes frescos para mi sopa especial. Es el plato característico de la taberna, ¿sabes?\n\nLos marineros y viajeros la adoran. Los mantiene calientes y llena sus barrigas antes de regresar al mar o continuar sus viajes.");
        cvQuestIntro.requirementValidations = (chara, ctx) -> {
            // Only show if quest is not active and not on cooldown
            if (!LibQuest.charHasQuest(QuestsIds.SOUP_MEAT, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestIntro);

        // Quest Accept
        ConversationOption cvQuestAccept = new ConversationOption(10, 11);
        cvQuestAccept.addOptionText(ENGLISH, "What ingredients do you need?", "Just the basics, dear: a White Mushroom, some Raw Meat, and a Carrot. Simple, but when combined with the right herbs and my grandmother's secret technique, it becomes magic in a bowl!\n\nBring me those three ingredients and I'll make you a bowl of the special soup. Plus a gold coin for your trouble. Fair deal?");
        cvQuestAccept.addOptionText(PORTUGUESE, "Que ingredientes você precisa?", "Apenas o básico, querido: um Cogumelo Branco, um pouco de Carne Crua e uma Cenoura. Simples, mas quando combinados com as ervas certas e a técnica secreta da minha avó, torna-se mágica numa tigela!\n\nMe traga esses três ingredientes e farei uma tigela da sopa especial para você. Mais uma moeda de ouro pelo seu trabalho. Trato justo?");
        cvQuestAccept.addOptionText(SPANISH, "¿Qué ingredientes necesitas?", "Solo lo básico, querido: un Champiñón Blanco, algo de Carne Cruda y una Zanahoria. Simple, pero cuando se combina con las hierbas correctas y la técnica secreta de mi abuela, ¡se convierte en magia en un tazón!\n\nTráeme esos tres ingredientes y te haré un tazón de la sopa especial. Más una moneda de oro por tu esfuerzo. ¿Trato justo?");
        npc.conversationOptions.add(cvQuestAccept);

        // Start Quest
        ConversationOption cvQuestStart = new ConversationOption(11, 0);
        cvQuestStart.addOptionText(ENGLISH, "I'll get those ingredients for you.", "Wonderful! The tavern always needs more soup, especially during busy nights. Come back when you have everything.");
        cvQuestStart.addOptionText(PORTUGUESE, "Vou buscar esses ingredientes para você.", "Maravilhoso! A taverna sempre precisa de mais sopa, especialmente durante as noites movimentadas. Volte quando tiver tudo.");
        cvQuestStart.addOptionText(SPANISH, "Conseguiré esos ingredientes para ti.", "¡Maravilloso! La taberna siempre necesita más sopa, especialmente durante las noches ocupadas. Vuelve cuando tengas todo.");
        cvQuestStart.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.SOUP_MEAT, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuestStart);

        // Decline Quest
        ConversationOption cvQuestDecline = new ConversationOption(11, 0);
        cvQuestDecline.addOptionText(ENGLISH, "Maybe another time.", "No worries, dear. The offer stands whenever you're ready.");
        cvQuestDecline.addOptionText(PORTUGUESE, "Talvez outra hora.", "Sem problemas, querido. A oferta continua de pé quando você estiver pronto.");
        cvQuestDecline.addOptionText(SPANISH, "Quizás en otro momento.", "No hay problema, querido. La oferta sigue en pie cuando estés listo.");
        npc.conversationOptions.add(cvQuestDecline);

        // Quest Active: Deliver Ingredients
        ConversationOption cvQuestDeliver = new ConversationOption(0, 12);
        cvQuestDeliver.addOptionText(ENGLISH, "I have the ingredients.", "Excellent! Let me see... White Mushroom, Raw Meat, Carrot. Perfect!\n\n*She takes the ingredients and starts preparing*\n\nGive me just a moment... *stirs the pot* ...and there we go! Fresh Special Soup, just for you. And here's your gold coin as promised.");
        cvQuestDeliver.addOptionText(PORTUGUESE, "Tenho os ingredientes.", "Excelente! Deixe-me ver... Cogumelo Branco, Carne Crua, Cenoura. Perfeito!\n\n*Ela pega os ingredientes e começa a preparar*\n\nMe dê só um momento... *mexe a panela* ...e pronto! Sopa Especial fresquinha, só para você. E aqui está sua moeda de ouro como prometido.");
        cvQuestDeliver.addOptionText(SPANISH, "Tengo los ingredientes.", "¡Excelente! Déjame ver... Champiñón Blanco, Carne Cruda, Zanahoria. ¡Perfecto!\n\n*Ella toma los ingredientes y comienza a preparar*\n\nDame solo un momento... *revuelve la olla* ...¡y listo! Sopa Especial fresca, solo para ti. Y aquí está tu moneda de oro como prometí.");
        cvQuestDeliver.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SOUP_MEAT, 1)
                    && LibInventory.checkHasItem(ItemsIds.WHITE_MUSHROOM, chara)
                    && LibInventory.checkHasItem(ItemsIds.RAW_MEAT, chara)
                    && LibInventory.checkHasItem(ItemsIds.CARROT, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestDeliver);

        // Complete Quest
        ConversationOption cvQuestComplete = new ConversationOption(12, 0);
        cvQuestComplete.addOptionText(ENGLISH, "Thank you, Frily!", "You're welcome, dear! Feel free to bring me more ingredients anytime. The tavern always needs good soup!");
        cvQuestComplete.addOptionText(PORTUGUESE, "Obrigado, Frily!", "De nada, querido! Sinta-se livre para me trazer mais ingredientes quando quiser. A taverna sempre precisa de boa sopa!");
        cvQuestComplete.addOptionText(SPANISH, "¡Gracias, Frily!", "¡De nada, querido! Siéntete libre de traerme más ingredientes cuando quieras. ¡La taberna siempre necesita buena sopa!");
        cvQuestComplete.listeners = (ctx, currentFragment) -> {
            // Remove ingredients from player inventory
            LibInventory.removeFromInventory(ItemsIds.WHITE_MUSHROOM, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.RAW_MEAT, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.CARROT, 1, App.getPlayerChar());

            // Complete quest (rewards are given automatically by Quest.complete() method)
            // Quest will auto-restart due to isRestartable status
            LibQuest.completeQuest(QuestsIds.SOUP_MEAT, App.getPlayerChar(), 2, ctx);
        };
        npc.conversationOptions.add(cvQuestComplete);

        // Quest Active: Still need ingredients
        ConversationOption cvQuestReminder = new ConversationOption(0, 0);
        cvQuestReminder.addOptionText(ENGLISH, "About those ingredients...", "Ah yes! I'm waiting for: White Mushroom, Raw Meat, and Carrot. Come back when you have all three, dear.");
        cvQuestReminder.addOptionText(PORTUGUESE, "Sobre aqueles ingredientes...", "Ah sim! Estou esperando por: Cogumelo Branco, Carne Crua e Cenoura. Volte quando tiver os três, querido.");
        cvQuestReminder.addOptionText(SPANISH, "Sobre esos ingredientes...", "¡Ah sí! Estoy esperando: Champiñón Blanco, Carne Cruda y Zanahoria. Vuelve cuando tengas los tres, querido.");
        cvQuestReminder.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SOUP_MEAT, 1)
                    && !(LibInventory.checkHasItem(ItemsIds.WHITE_MUSHROOM, chara)
                    && LibInventory.checkHasItem(ItemsIds.RAW_MEAT, chara)
                    && LibInventory.checkHasItem(ItemsIds.CARROT, chara))) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestReminder);

        return npc;
    }
}