package com.cnx.endlesstalestwo.data.npcs.lisport.WestGrove;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

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

public class Paulson extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Paulson");
        npc.age = 24;
        npc.job = Enums.NPCJobs.MILITIAMAN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A young man with apparent intelligence. Performs his tasks efficiently.\nWary and sarcastic when necessary.\n\nPhysical traits: Nordic features. Long hair, blonde and braided back. Full beard. Light blue eyes.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um jovem homem com aparente inteligência. Faz suas tarefas com eficiência.\nDesconfiado e sarcástico quando ncessário.\n\nSeus taços físicos: traços nórdicos. Cabelo comprido, loiro e trançado para trás. Barba preenchida. Olhos azuis claros.");
        npc.addDescriptionTranslation(SPANISH, "Un joven hombre con inteligencia aparente. Realiza sus tareas con eficiencia.\nDesconfiado y sarcástico cuando es necesario.\n\nTrasos físicos: Características nórdicas. Cabello largo, rubio y trenzado hacia atrás. Barba llena. Ojos azul claro.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hi, you."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá, você."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola tú."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Goodbye, [GENDER_SIMPLE_CALL]"));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Adeus, [GENDER_SIMPLE_CALL]"));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Adios, [GENDER_SIMPLE_CALL]"));

        npc.requirementValidations = (chara, ctx) -> {
            Quest militiaTasksQuest = App.getPlayerChar().getQuest(QuestsIds.MILITIA_TASKS);
            Quest raindingTheOrcsQuest = App.getPlayerChar().getQuest(QuestsIds.RAIDING_THE_ORCS);
            Quest reestablishmentQuest = App.getPlayerChar().getQuest(QuestsIds.REESTABLISHMENT);

            if (reestablishmentQuest != null && reestablishmentQuest.getCurrentPartOrder() > 1) {
                return Enums.RequirementVerification.OK;
            } else if (militiaTasksQuest == null || militiaTasksQuest.getCurrentPartOrder() < 6) {
                return Enums.RequirementVerification.NOT_OK;
            } else if (raindingTheOrcsQuest == null || raindingTheOrcsQuest.getCurrentPartOrder() > 4) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "Are you Paulson?", "Maybe, who is asking?");
        cv1.addOptionText(PORTUGUESE, "Você é Paulson?", "Talvez, quem está perguntando?");
        cv1.addOptionText(SPANISH, "¿Eres Paulson?", "Quizás, ¿quién pregunta?");
        cv1.requirementValidations = (chara, ctx) -> {
            Quest notRequiredQuest = App.getPlayerChar().getQuest(QuestsIds.RAIDING_THE_ORCS);
            if (notRequiredQuest == null || notRequiredQuest.getCurrentPartOrder() == 1) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv2 = new ConversationOption(1, 2);
        cv2.addOptionText(ENGLISH, "I am [PLAYERNAME], I am new member of the militia.", "Ah, I think Joggard told me something. Yes, I am Paulson. You came to help with the plan to attack the orcs.");
        cv2.addOptionText(PORTUGUESE, "Eu sou [PLAYERNAME], sou um novo membro da milícia.", "Ah, acho que Joggard me disse algo. Sim, eu sou Paulson. Você veio ajudar com o plano de atacar os orcs.");
        cv2.addOptionText(SPANISH, "Soy [PLAYERNAME], soy un nuevo miembro de la milicia.", "Ah, creo que Joggard me dijo algo. Sí, soy Paulson. Viniste a ayudar con el plan para atacar a los orcos.");

        ConversationOption cv3 = new ConversationOption(2, 0);
        cv3.addOptionText(ENGLISH, "Yes, correct.", "So, the idea is to attack from a surprising point, from the sea.\nFor that we will need to fix our ship. Joggard already asked some people to get the resources, all need from you is to get the resource with Joggard and bring to me.");
        cv3.addOptionText(PORTUGUESE, "Sim, correto.", "Então, a ideia é atacar de um ponto surpreendente, do mar.\nPara isso, precisaremos consertar nosso navio. Joggard já pediu para algumas pessoas pegarem os recursos, tudo o que preciso de vocês é pegar o recurso com Joggard e trazer para mim.");
        cv3.addOptionText(SPANISH, "Si correcto", "Entonces, la idea es atacar desde un punto sorprendente, desde el mar. Para eso necesitaremos reparar nuestro barco. Joggard ya le pidió a algunas personas que consiguieran los recursos, lo único que necesito de ti es que consigas el recurso con Joggard y me lo traigas.");
        cv3.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.MILITIA_TASKS);
            if (requiredQuest != null && requiredQuest.isComplete()) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv3.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.RAIDING_THE_ORCS);
            LibQuest.updateQuest(quest, 2, App.getPlayerChar(), ctx);
        };

        ConversationOption cv4 = new ConversationOption(0, 3);
        cv4.addOptionText(ENGLISH, "I have the supplies here.", "Alright. Thanks. Now we have hammers and nails, but we need the planks to fix the holes. Can you get 5 for us?");
        cv4.addOptionText(PORTUGUESE, "Eu tenho os suprimentos aqui.", "Certo. Obrigado. Agora temos martelos e pregos, mas precisamos das tábuas para consertar os buracos. Você pode conseguir 5 para nós?");
        cv4.addOptionText(SPANISH, "Tengo los suministros aquí.", "Está bien. Gracias. Ahora tenemos martillos y clavos, pero necesitamos las tablas para cerrar los agujeros. ¿Puedes conseguirnos 5?");
        cv4.requirementValidations = (chara, ctx) -> {
            boolean hasItems = LibInventory.checkHasItemAmount(ItemsIds.REPAIR_SUPPLIES, 1, App.getPlayerChar());
            if (!LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RAIDING_THE_ORCS, 3)) {
                return Enums.RequirementVerification.NOT_OK;
            } else if (!hasItems) {
                return Enums.RequirementVerification.NEED_ITEMS;
            }
            return Enums.RequirementVerification.OK;
        };

        ConversationOption cv5 = new ConversationOption(3, 0);
        cv5.addOptionText(ENGLISH, "For sure.", "Good, I will be right here, fixing the ship and waiting for the planks.");
        cv5.addOptionText(PORTUGUESE, "Claro que sim.", "Ótimo, estarei aqui, consertando o navio e esperando as tábuas.");
        cv5.addOptionText(SPANISH, "Con seguridad.", "Bueno, estaré aquí, arreglando el barco y esperando las tablas.");
        cv5.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.RAIDING_THE_ORCS);
            LibInventory.removeFromInventory(ItemsIds.REPAIR_SUPPLIES, 1, App.getPlayerChar());
            LibQuest.updateQuest(quest, 4, App.getPlayerChar(), ctx);
        };

        ConversationOption cv6 = new ConversationOption(3, 0);
        cv6.addOptionText(ENGLISH, "Not now.", "We need some hurry here...");
        cv6.addOptionText(PORTUGUESE, "Agora não.", "Precisamos nos apressar aqui...");
        cv6.addOptionText(SPANISH, "Ahora no.", "Necesitamos algo de prisa aquí...");

        ConversationOption cv7 = new ConversationOption(0, 0);
        cv7.addOptionText(ENGLISH, "I brought the planks.", "Very good. I have everything. I will finish the fix soon. Go tell Joggard to call the militiamen to the battle.");
        cv7.addOptionText(PORTUGUESE, "Eu trouxe as tábuas.", "Muito bem. Tenho tudo. Vou terminar o conserto em breve. Vá dizer a Joggard para chamar os milicianos para a batalha.");
        cv7.addOptionText(SPANISH, "Traje las tablas.", "Muy bien. Ya lo tengo todo. Terminaré de arreglarlo pronto. Ve y dile a Joggard que llame a los milicianos a la batalla.");
        cv7.requirementValidations = (chara, ctx) -> {
            boolean isAtQuestPart = LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RAIDING_THE_ORCS, 4);
            boolean hasItems = LibInventory.checkHasItemAmount(ItemsIds.PLANK, 5, App.getPlayerChar());

            if (isAtQuestPart && hasItems) {
                return Enums.RequirementVerification.OK;
            } else if (isAtQuestPart) {
                return Enums.RequirementVerification.NEED_ITEMS;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv7.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.RAIDING_THE_ORCS);
            LibInventory.removeFromInventory(ItemsIds.PLANK, 5, App.getPlayerChar());
            LibQuest.updateQuest(quest, 5, App.getPlayerChar(), ctx);
        };

        ConversationOption cv8 = new ConversationOption(0, 0);
        cv8.addOptionText(ENGLISH, "How you doing?", "[GENDER_SIMPLE_CALL], please, I need to work in the ship preparation.");
        cv8.addOptionText(PORTUGUESE, "Como você está?", "[GENDER_SIMPLE_CALL], por favor, preciso trabalhar na preparação do navio.");
        cv8.addOptionText(SPANISH, "¿Cómo estás?", "[GENDER_SIMPLE_CALL], por favor, necesito trabajar en la preparación do barco.");
        cv8.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RAIDING_THE_ORCS, 2)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RAIDING_THE_ORCS, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv9 = new ConversationOption(0, 0);
        cv9.addOptionText(ENGLISH, "So, the ship is damaged again?", "Yes, Joggard sent you to help, right?\nSo, the main problem is our ship's sail, we need to rebuild it entirely. I wrote a list of needed things, take it. I will be here waiting and fixing other things.");
        cv9.addOptionText(PORTUGUESE, "Então, o navio está danificado novamente?", "Sim, Joggard te enviou para ajudar, certo?\nEntão, o problema principal é a vela do nosso navio, precisamos reconstruí-la completamente. Eu escrevi uma lista de coisas necessárias, pegue. Eu estarei aqui esperando e consertando outras coisas.");
        cv9.addOptionText(SPANISH, "Entonces ¿el barco está dañado?", "Sí, Joggard te envió para ayudar, ¿verdad?\nEntonces, el problema principal es la vela de nuestro barco, necesitamos reconstruirla por completo. Escribí una lista de cosas necesarias, tómala. Estaré aquí esperando y arreglando otras cosas.");
        cv9.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.REESTABLISHMENT);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 2) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv9.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.REESTABLISHMENT);
            LibQuest.updateQuest(quest, 3, App.getPlayerChar(), ctx);
        };

        ConversationOption cv10 = new ConversationOption(0, 0);
        cv10.addOptionText(ENGLISH, "Here, the goods for the ship's sail.", "Perfect! [PLAYERNAME] you are such a good person.\nThanks!\nAh, Joggard wants to talk to you.");
        cv10.addOptionText(PORTUGUESE, "Aqui, as mercadorias para a vela do navio.", "Perfeito! [PLAYERNAME] você é uma pessoa tão boa.\nObrigado!\nAh, Joggard quer falar com você.");
        cv10.addOptionText(SPANISH, "Aquí, la mercancía para las velas del barco.", "¡Perfecto! [PLAYERNAME] eres una muy buena persona.\n¡Gracias!\nAh, Joggard quiere hablar contigo.");
        cv10.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.REESTABLISHMENT);
            boolean hasItems = LibInventory.checkHasItemAmount(ItemsIds.LOG, 3, App.getPlayerChar())
                    && LibInventory.checkHasItemAmount(ItemsIds.TISSUE, 3, App.getPlayerChar())
                    && LibInventory.checkHasItemAmount(ItemsIds.ROPE, 3, App.getPlayerChar());

            if (requiredQuest == null || requiredQuest.getCurrentPartOrder() != 3) {
                return Enums.RequirementVerification.NOT_OK;
            } else if (!hasItems) {
                return Enums.RequirementVerification.NEED_ITEMS;
            }
            return Enums.RequirementVerification.OK;
        };
        cv10.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.REESTABLISHMENT);
            LibInventory.removeFromInventory(ItemsIds.LOG, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.TISSUE, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.ROPE, 3, App.getPlayerChar());
            LibQuest.updateQuest(quest, 4, App.getPlayerChar(), ctx);
        };

        ConversationOption cv11 = new ConversationOption(0, 0);
        cv11.addOptionText(ENGLISH, "Hey, how is the things going?", "Very well, to be honest. I fixed the ship and there is no orcs to bother us. Sometimes I even have free time to sail around.");
        cv11.addOptionText(PORTUGUESE, "Olá, como vão as coisas?", "Muito bem, para ser honesto. Eu consertei o navio e não há orcs para nos incomodar. Às vezes, até tenho tempo livre para navegar por aí.");
        cv11.addOptionText(SPANISH, "Hola, ¿cómo va todo?", "Muy bien, para ser sincero. He arreglado el barco y no hay orcos que nos molesten. A veces incluso tengo tiempo libre para navegar.");
        cv11.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.REESTABLISHMENT);
            if (requiredQuest != null && requiredQuest.isComplete()) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv12 = new ConversationOption(0, 0);
        cv12.addOptionText(ENGLISH, "How can I get planks?", "Well, it's kind of logical, isn't it? You can buy or make them. Get logs from the trees and make planks. If you don't know how, maybe someone can help you. In Lisport, someone should be able to help you with that.");
        cv12.addOptionText(PORTUGUESE, "Como eu consigo tábuas?", "Ora, é meio lógico não? Você pode comprar ou fazer. Pegue toras de madeira das árvores e faça tábuas. Se não sabe fazer, talvez alguem possa te ajudar. Em Lisport alguém deve te ajudar com isso.");
        cv12.addOptionText(SPANISH, "¿Cómo consigo tablones?", "Bueno, es algo lógico, ¿no? Puedes comprarlos o hacerlos. Consigue troncos de los árboles y haz tablones. Si no sabes cómo, quizás alguien pueda ayudarte. En Lisport, alguien debería poder ayudarte con eso.");
        cv12.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RAIDING_THE_ORCS, 4)
                    && !LibInventory.checkHasItem(ItemsIds.PLANK, App.getPlayerChar())) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
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
        npc.conversationOptions.add(cv10);
        npc.conversationOptions.add(cv11);
        npc.conversationOptions.add(cv12);

        return npc;
    }
}

