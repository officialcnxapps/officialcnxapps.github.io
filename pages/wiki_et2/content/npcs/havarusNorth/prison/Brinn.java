package com.cnx.endlesstalestwo.data.npcs.havarusNorth.prison;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import android.os.Handler;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.events.EventsIds;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;


public class Brinn extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Brinn");
        npc.age = 43;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "He's not the most reliable type, but he knows how to make a good impression.\nHe does his job decently, but for a few coins he might make mistakes.\nStrong and clever, he likes to be in charge.\n\nHis physical traits: Dark skin, grayish beard. Brown eyes and cheeks as prominent as his chin.");
        npc.addDescriptionTranslation(PORTUGUESE, "Não é do tipo mais confiável, mas sabe passar uma boa impressão.\nFaz o seu trabalho decentemente, mas por umas moedas pode cometer deslizes.\nForte e esperto, gosta de mandar.\n\nSeus traços físicos: Pele morena, barba acinzentada. Olhos castanhos e bochechas tão marcadas quanto o queixo.");
        npc.addDescriptionTranslation(SPANISH, "No es el más confiable, pero sabe cómo causar una buena impresión.\nCumple con su trabajo decentemente, pero por unas monedas podría cometer errores.\nFuerte e inteligente, le gusta tener el control.\n\nSus rasgos físicos: piel oscura, barba grisácea, ojos marrones y mejillas tan prominentes como su barbilla.");

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What's it like working here?", "Dull. Mostly just the stench and the occasional rat for company. The inmates are the least of my worries.");
        cv1.addOptionText(PORTUGUESE, "Como é trabalhar aqui?", "Monótono. Principalmente o fedor e um rato ocasional para companhia. Os prisioneiros são a menor das minhas preocupações.");
        cv1.addOptionText(SPANISH, "¿Cómo es trabajar aquí?", "Aburrido. Sobre todo el hedor y alguna que otra rata para hacer compañía. Los reclusos son la menor de mis preocupaciones.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Any dangerous criminals down here?", "Some. But they're all locked up tight. Nothing to worry about... unless you're one of them.");
        cv2.addOptionText(PORTUGUESE, "Algum criminoso perigoso aqui em baixo?", "Alguns. Mas estão todos bem trancados. Nada com que se preocupar... a menos que sejas um deles.");
        cv2.addOptionText(SPANISH, "¿Hay algún criminal peligroso aquí abajo?", "Algunos. Pero están todos bien encerrados. No hay de qué preocuparse... a no ser que seas uno de ellos.");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(0, 0);
        cv3.addOptionText(ENGLISH, "Seen anything unusual lately?", "Just the usual moans and groans. This place has a way of wearing you down. Now, move along.");
        cv3.addOptionText(PORTUGUESE, "Viu algo incomum ultimamente?", "Apenas os gemidos e lamentos de sempre. Este lugar tem um jeito de te desgastar. Agora, circule.");
        cv3.addOptionText(SPANISH, "¿Has visto algo inusual últimamente?", "Solo los quejidos y lamentos de siempre. Este lugar tiene una forma de desgastarte. Ahora, circula.");
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(0, 1);
        cv4.addOptionText(ENGLISH, "Guzar sent me to learn more about the dead creature.", "Dead creature? Ah, you mean that strange thing we killed and locked in a cell as a precaution.\nWhat do you want to know?");
        cv4.addOptionText(PORTUGUESE, "Guzar me mandou para saber mais sobre a criatura morta.", "Criatura morta? Ah, você quer dizer aquela coisa estranha que abatemos e prendemos numa cela por precaução.\nO que quer saber?");
        cv4.addOptionText(SPANISH, "Guzar me envió a saber más sobre la criatura muerta.", "Criatura muerta? Ah, te refieres a esa cosa extraña que matamos y encerramos en una celda por precaución.\n¿Qué quieres saber?");
        cv4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.WHO_IS_THE_ENEMY, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(1, 2);
        cv5.addOptionText(ENGLISH, "How was it to take down this creature?", "I wasn't in the fight, but I was told 2 soldiers were injured. That thing has dark powers, for sure. I've read about it in books and I guarantee you that this creature doesn't normally exist in our world, it was brought from beyond or something like that.\nA dark invocation perhaps?");
        cv5.addOptionText(PORTUGUESE, "Como foi para abater essa criatura?", "Não estive na luta, mas me disseram que 2 soldados ficaram feridos. Aquela coisa tem poderes das trevas, com certeza. Já li sobre isso em livros e te garanto que essa criatura não existe normalmente no nosso mundo, ela foi trazida do além ou coisa assim.\nUma invocação das trevas talvez?");
        cv5.addOptionText(SPANISH, "¿Cómo fue abatir a esta criatura?", "No estuve en la lucha, pero me dijeron que 2 soldados resultaron heridos. Esa cosa tiene poderes oscuros, seguro. He leído sobre ello en libros y te garantizo que esta criatura no existe normalmente en nuestro mundo, fue traída del más allá o algo así.\n¿Una invocación oscura quizás?");
        npc.conversationOptions.add(cv5);

        ConversationOption cv6 = new ConversationOption(2, 0);
        cv6.addOptionText(ENGLISH, "Any other important details?", "Hmm... I don't think so, I just really assure you, if there are more of these out there, we'll have a lot of trouble, black magic and demonic creatures are always a great danger. It would be good to know where this monster came from.");
        cv6.addOptionText(PORTUGUESE, "Mais algum detalhe importante?", "Huumm... acho que não, só realmente lhe garanto, se houver mais desses por aí, teremos muitos problemas, magia negra e criaturas demoníacas são sempre um grande perigo. Seria bom saber de onde esse monstro veio.");
        cv6.addOptionText(SPANISH, "¿Algún otro detalle importante?", "Hmm... creo que no, solo te aseguro que, si hay más de estos por ahí, tendremos muchos problemas, la magia negra y las criaturas demoníacas son siempre un gran peligro. Sería bueno saber de dónde vino este monstruo.");
        cv6.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.WHO_IS_THE_ENEMY, 2, App.getPlayerChar(), ctx);
            App.Shell.saveGame(ctx);
        };
        npc.conversationOptions.add(cv6);

        // ========================================
        // QUEST: FALKER_FAMILY — PART 2
        // ========================================

        ConversationOption cvFF2 = new ConversationOption(0, 5);
        cvFF2.addOptionText(ENGLISH, "Lord Den sent me. I need access to the old Brant-Falker records.", "[He narrows his eyes]\n\nDen, huh? Those records are... restricted. Not supposed to let anyone see them without official approval.\n\n[He scratches his chin thoughtfully]\n\nThen again, I've been on duty for ten hours straight. Hungry. Thirsty. If someone were to, say, bring me something nice to eat and drink... maybe I could step out for a few minutes. Just long enough for you to... browse.");
        cvFF2.addOptionText(PORTUGUESE, "Lorde Den me enviou. Preciso de acesso aos registros antigos dos Brant-Falker.", "[Ele estreita os olhos]\n\nDen, é? Esses registros são... restritos. Não deveria deixar ninguém vê-los sem aprovação oficial.\n\n[Ele coça o queixo pensativamente]\n\nPor outro lado, estou de serviço há dez horas seguidas. Com fome. Com sede. Se alguém me trouxesse algo bom para comer e beber... talvez eu pudesse sair por alguns minutos. Só o suficiente para você... dar uma olhada.");
        cvFF2.addOptionText(SPANISH, "Lord Den me envió. Necesito acceso a los registros antiguos de los Brant-Falker.", "[Entrecierra los ojos]\n\n¿Den, eh? Esos registros son... restringidos. No se supone que deba dejar que nadie los vea sin aprobación oficial.\n\n[Se rasca la barbilla pensativamente]\n\nPor otro lado, he estado de servicio durante diez horas seguidas. Hambriento. Sediento. Si alguien me trajera algo bueno para comer y beber... tal vez podría salir unos minutos. Solo lo suficiente para que tú... eches un vistazo.");
        cvFF2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FALKER_FAMILY, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvFF2);

        ConversationOption cvFF2b = new ConversationOption(5, 0);
        cvFF2b.addOptionText(ENGLISH, "What do you want?", "Let's say... one Beer, one Wine, and one Seasoned Meat. Bring me those, and I'll give you five minutes alone with the records. Deal?");
        cvFF2b.addOptionText(PORTUGUESE, "O que você quer?", "Digamos... uma Cerveja, um Vinho e uma Carne Temperada. Me traga isso e darei cinco minutos sozinho com os registros. Fechado?");
        cvFF2b.addOptionText(SPANISH, "¿Qué quieres?", "Digamos... una Cerveza, un Vino y una Carne Sazonada. Tráeme eso y te daré cinco minutos a solas con los registros. ¿Trato?");
        cvFF2b.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.FALKER_FAMILY, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFF2b);

        // ========================================
        // QUEST: FALKER_FAMILY — PART 3
        // ========================================

        ConversationOption cvFF3 = new ConversationOption(0, 0);
        cvFF3.addOptionText(ENGLISH, "I have the Beer, Wine, and Seasoned Meat you wanted.", "[He takes the items eagerly]\n\nAh, perfect. You know what? You're all right. Go ahead — five minutes. I'll be just outside. Don't make me regret this.");
        cvFF3.addOptionText(PORTUGUESE, "Tenho a Cerveja, o Vinho e a Carne Temperada que você queria.", "[Ele pega os itens avidamente]\n\nAh, perfeito. Sabe de uma coisa? Você é legal. Pode ir — cinco minutos. Estarei logo ali fora. Não me faça me arrepender disso.");
        cvFF3.addOptionText(SPANISH, "Tengo la Cerveza, el Vino y la Carne Sazonada que querías.", "[Toma los artículos con entusiasmo]\n\nAh, perfecto. ¿Sabes qué? Eres buena gente. Adelante — cinco minutos. Estaré justo afuera. No me hagas arrepentirme de esto.");
        cvFF3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FALKER_FAMILY, 3)
                    && LibInventory.checkHasItem(ItemsIds.BEER, chara)
                    && LibInventory.checkHasItem(ItemsIds.WINE, chara)
                    && LibInventory.checkHasItem(ItemsIds.SEASONED_MEAT, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvFF3.listeners = (ctx, currentFragment) -> {
            if (App.getPlayerChar() != null) {
                LibInventory.removeFromInventory(ItemsIds.BEER, 1, App.getPlayerChar());
                LibInventory.removeFromInventory(ItemsIds.WINE, 1, App.getPlayerChar());
                LibInventory.removeFromInventory(ItemsIds.SEASONED_MEAT, 1, App.getPlayerChar());
                App.Shell.flowManager.currentLocation.checkedEventsAndBattles = false;
                new Handler().postDelayed(() -> {
                    App.Shell.flowManager.addEventToQueue(App.DataManager.getEvent(EventsIds.PRISON_RECORDS));
                }, 1);
            }

        };
        npc.conversationOptions.add(cvFF3);

        // ========================================
        // QUEST: CRAFTER HELPER — PART 2
        // ========================================

        ConversationOption cvCH2 = new ConversationOption(0, 0);
        cvCH2.addOptionText(ENGLISH, "Perseus sent me with a Crate of Tools for the prison.",
                "*He checks the crate carefully*\nGood. We've been waiting for these. The old tools were wearing down.\n*Signs a receipt*\nTell Perseus it's appreciated. Good delivery.");
        cvCH2.addOptionText(PORTUGUESE, "Perseus me enviou com um Caixote de Ferramentas para a prisão.",
                "*Ele verifica o caixote cuidadosamente*\nBom. Estávamos esperando por isso. As ferramentas antigas estavam se desgastando.\n*Assina um recibo*\nDiga para Perseus que é apreciado. Boa entrega.");
        cvCH2.addOptionText(SPANISH, "Perseus me envió con un Cajón de Herramientas para la prisión.",
                "*Revisa el cajón cuidadosamente*\nBien. Estábamos esperando estos. Las herramientas viejas se estaban desgastando.\n*Firma un recibo*\nDile a Perseus que se lo agradece. Buena entrega.");
        cvCH2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CRAFTER_HELPER, 2)
                    && LibInventory.checkHasItem(ItemsIds.CRATE_OF_TOOLS, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvCH2.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.CRATE_OF_TOOLS, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.CRAFTER_HELPER, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvCH2);

        // ========================================
        // QUEST: CONTRABAND — PART 33
        // ========================================

        ConversationOption cvCB33 = new ConversationOption(0, 0);
        cvCB33.addOptionText(ENGLISH, "A special delivery... you know who sent it.",
                "*He looks around nervously, then takes the package quickly*\nI see.\n*Tucks it under his desk*\nYou never spoke to me about this. Now leave, before someone notices.");
        cvCB33.addOptionText(PORTUGUESE, "Uma entrega especial... você sabe quem enviou.",
                "*Ele olha ao redor nervosamente, depois pega o pacote rapidamente*\nEntendo.\n*Coloca embaixo da mesa*\nVocê nunca falou comigo sobre isso. Agora vá embora, antes que alguém note.");
        cvCB33.addOptionText(SPANISH, "Una entrega especial... sabes quién lo envió.",
                "*Mira alrededor nerviosamente, luego toma el paquete rápidamente*\nYa veo.\n*Lo mete bajo su escritorio*\nNunca me hablaste de esto. Ahora vete, antes de que alguien lo note.");
        cvCB33.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CONTRABAND, 33)
                    && LibInventory.checkHasItem(ItemsIds.CONTRABAND_PACKAGE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvCB33.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.CONTRABAND_PACKAGE, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.CONTRABAND, 40, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvCB33);

        return npc;
    }
}