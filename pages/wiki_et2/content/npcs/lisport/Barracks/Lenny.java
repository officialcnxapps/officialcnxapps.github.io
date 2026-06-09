package com.cnx.endlesstalestwo.data.npcs.lisport.Barracks;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.ArmyNoviceTasks.ARMY_NOVICE_QUEST_SWITCH_PART_2_HARBOR_SOLDIERS;
import static com.cnx.endlesstalestwo.data.quests.ArmyNoviceTasks.ARMY_NOVICE_QUEST_SWITCH_PART_2_PLAINS_SOLDIERS;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.ARMY_HONORED_TASKS;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.COUNTER_ATTACK;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.LOOKING_FOR_A_GUILD;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.RAIDING_THE_ORCS;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.UNDER_ATTACK;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.GameEngine;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.entities.Switch;
import com.cnx.endlesstalestwo.entities.Variable;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Lenny extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, lenny());
    }

    Npc lenny() {
        Npc npc = new Npc("Lenny");
        npc.age = 28;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "An honorable man, concerned for his comrades and friends.\nKnows how to follow orders and give them. Devoted to Lisport.\nWhen not on guard duty, he is caring for his home and chatting with neighbors, charisma is his strong point.\n\nPhysical traits: Blonde hair, straight and combed back. Well-groomed beard and blue eyes. Cut scar on his left cheek.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um homem honrado, preocupado com seus companheiros e amigos.\nSabe seguir ordens e dar ordens. Devoto a Lisport.\nQuando não está em guarda, está cuidando da sua casa e conversando com a vizinhança, carisma é seu ponto forte.\n\nSeus taços físicos: Cabelo loiro, liso e penteado para trás. Barba bem feita e olhos azuis. Cicatriz de corte na bocheca esquerda.");
        npc.addDescriptionTranslation(SPANISH, "Un hombre honorable, preocupado por sus compañeros y amigos.\nSabe cómo seguir órdenes y darlas. Devoto a Lisport.\nCuando no está de guardia, cuida su hogar y conversa con sus vecinos, el carisma es su punto fuerte.\n\nTrasos físicos: Cabello rubio, liso y peinado hacia atrás. Barba bien cuidada y ojos azules. Cicatriz de corte en mejilla izquierda.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Greetings, can I be helpful?"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá, posso ajudar?"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Saludos, ¿puedo ser útil?"));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Bye, [GENDER_FORMAL_CALL]"));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Tchau,  [GENDER_FORMAL_CALL]"));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Adios,  [GENDER_FORMAL_CALL]"));

        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, COUNTER_ATTACK, 2) || LibQuest.isCharacterAtQuestPart(chara, COUNTER_ATTACK, 3)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "May I ask about you?", "Yes, [GENDER_SIMPLE_CALL]. I am [NPC_NAME], I work for the royal army of the king as a general of troops.");
        cv1.addOptionText(PORTUGUESE, "Posso perguntar sobre você?", "Sim, [GENDER_SIMPLE_CALL]. Eu sou [NPC_NAME], trabalho para o exército real do rei como general de tropas.");
        cv1.addOptionText(SPANISH, "¿Puedo preguntar por usted?", "Sí, [GENDER_SIMPLE_CALL]. Soy [NPC_NAME], trabajo para el ejército real de rey como general de tropas.");

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Are Lisport troops ready to face the orcs?", "I can assert that we have men and weapons that are sufficient to win all battles, we just need an strategy.");
        cv2.addOptionText(PORTUGUESE, "As tropas de Lisport estão prontas para enfrentar os orcs?", "Posso afirmar que temos homens e armas suficientes para vencer todas as batalhas, só precisamos de uma estratégia.");
        cv2.addOptionText(SPANISH, "¿Están las tropas de Lisport preparadas para enfrentarse a los orcos?", "Puedo afirmar que tenemos hombres y armas suficientes para ganar todas las batallas, sólo necesitamos una estrategia.");
        cv2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, COUNTER_ATTACK) || LibQuest.isQuestComplete(chara, RAIDING_THE_ORCS) || !LibQuest.charHasQuest(UNDER_ATTACK, chara)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        ConversationOption cv3 = new ConversationOption(0, 1);
        cv3.addOptionText(ENGLISH, "Sir, I want to join the army.", "Really, [GENDER_FORMAL_CALL]?\nIt is good to see people interested in the army, people who trully wants to work are always welcome.");
        cv3.addOptionText(PORTUGUESE, "Senhor, quero me alistar no exército.", "Sério, [GENDER_FORMAL_CALL]?\nÉ bom ver pessoas interessadas no exército, pessoas que realmente querem trabalhar são sempre bem-vindas.");
        cv3.addOptionText(SPANISH, "Señor, quiero unirme al ejército.", "En serio, [GENDER_FORMAL_CALL]?\nEs bueno ver gente interesada en el ejército, las personas que realmente quieren trabajar siempre son bienvenidas.");
        cv3.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(LOOKING_FOR_A_GUILD);
            if (requiredQuest != null && (requiredQuest.getCurrentPartOrder() == 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv4 = new ConversationOption(1, 2);
        cv4.addOptionText(ENGLISH, "I should ask what is needed to join.", "Yes. I see will on your eyes. All I need to know is if you can handle simple tasks to start. Are you ready?");
        cv4.addOptionText(PORTUGUESE, "Eu devo perguntar o que é necessário para participar.", "Sim. Vejo vontade em seus olhos. Tudo o que preciso saber é se você consegue lidar com tarefas simples para começar. Você está pronto?");
        cv4.addOptionText(SPANISH, "Debería preguntar qué se necesita para unirse.", "Sí, veo voluntad en tus ojos. Todo lo que necesito saber es si puedes realizar tareas sencillas para empezar. ¿Estás listo?");

        ConversationOption cv5 = new ConversationOption(2, 0);
        cv5.addOptionText(ENGLISH, "Yes, I am.", "Good. [GENDER_SIMPLE_CALL], to be accepted as a novice I want you to help our priest Edward. Some days ago he asked an aid for us. Talk to him.");
        cv5.addOptionText(PORTUGUESE, "Sim, consigo.", "Bom. [GENDER_SIMPLE_CALL], para ser aceito como um noviço, quero que você ajude nosso padre Edward. Alguns dias atrás, ele pediu uma ajuda para nós. Fale com ele.");
        cv5.addOptionText(SPANISH, "Sí, puedo.", "Bueno. [GENDER_SIMPLE_CALL], para ser aceptado como novicio quiero que ayudes a nuestro sacerdote Edward. Hace unos días pidió una ayuda para nosotros. Habla con él.");
        cv5.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(LOOKING_FOR_A_GUILD);
            LibQuest.updateQuest(quest, 12, App.getPlayerChar(), ctx);
        };

        ConversationOption cv6 = new ConversationOption(2, 0);
        cv6.addOptionText(ENGLISH, "No, not yet.", "Right, tell me if you change your mind.");
        cv6.addOptionText(PORTUGUESE, "Não, ainda não.", "Certo, me avise se mudar de ideia.");
        cv6.addOptionText(SPANISH, "No, todavía no.", "Bien, dime si cambias de opinión.");

        ConversationOption cv7 = new ConversationOption(0, 0);
        cv7.addOptionText(ENGLISH, "Sir, I did the job for priest Edward.", "Very good!\nSo, you can handle easy tasks without complain.\nIt is now a pleasure to say that you are the new novice member of Lisport Army. When ready, we can give you some more tasks.");
        cv7.addOptionText(PORTUGUESE, "Senhor, eu fiz o trabalho para o padre Edward.", "Muito bom!\nEntão, você pode lidar com tarefas fáceis sem reclamar.\nAgora é um prazer dizer que você é o novo membro novato do Exército Lisport. Quando estiver pronto, podemos lhe dar mais algumas tarefas.");
        cv7.addOptionText(SPANISH, "Señor, hice el trabajo para el sacerdote Edward.", "¡Muy bien!\nAsí que puedes realizar tareas sencillas sin quejarte.\nEs un placer decirte que eres el nuevo miembro novato del ejército de Lisport. Cuando estés listo, podremos darte más tareas.");
        cv7.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(LOOKING_FOR_A_GUILD);
            if (requiredQuest != null && (requiredQuest.getCurrentPartOrder() == 14)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv7.listeners = (ctx, fragment) -> {
            LibQuest.completeQuest(LOOKING_FOR_A_GUILD, App.getPlayerChar(), 15, ctx);
        };

        ConversationOption cv8 = new ConversationOption(0, 3);
        cv8.addOptionText(ENGLISH, "Could I get more jobs?", "That's the spirit! For a true soldier, no task is beneath his duty.\nWe have a banquet approaching, in honor of the nobles and army commanders. The kitchens require provisions — pomegranates, nuts and fresh meat. Simple supplies, aye, but the cook insists on quality, and an army marches on its stomach. I know it may seem unworthy of a warrior, but discipline means doing what must be done. Can you gather these for us?");
        cv8.addOptionText(PORTUGUESE, "Teria mais tarefas?", "Esse é o espírito! Para um verdadeiro soldado, nenhuma tarefa está abaixo de seu dever.\nTemos um banquete se aproximando, em honra dos nobres e comandantes do exército. As cozinhas precisam de provisões — romãs, nozes e carne fresca. Suprimentos simples, é verdade, mas o cozinheiro insiste na qualidade, e um exército marcha com seu estômago. Sei que pode parecer indigno de um guerreiro, mas disciplina é fazer o que precisa ser feito. Pode reunir essas provisões para nós?");
        cv8.addOptionText(SPANISH, "¿Podría conseguir más trabajos?", "¡Ese es el espíritu! Para un verdadero soldado, ninguna tarea está por debajo de su deber.\nTenemos un banquete próximo, en honor de los nobles y comandantes del ejército. Las cocinas necesitan provisiones — granadas, nueces y carne fresca. Suministros simples, sí, pero el cocinero insiste en la calidad, y un ejército marcha con su estómago. Sé que puede parecer indigno de un guerrero, pero la disciplina es hacer lo que debe hacerse. ¿Puedes reunir estas provisiones para nosotros?");
        cv8.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.ARMY_NOVICE_TASKS, App.getPlayerChar())
                    && LibQuest.isCharacterAtQuestPart(chara, LOOKING_FOR_A_GUILD, 15)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv9 = new ConversationOption(3, 0);
        cv9.addOptionText(ENGLISH, "I can handle that.", "Great. I will be here waiting for 4 pomegranates, 3 nuts and 2 meats.");
        cv9.addOptionText(PORTUGUESE, "Eu posso lidar com isso.", "Ótimo. Estarei aqui esperando por 4 romãs, 3 nozes e 2 carnes.");
        cv9.addOptionText(SPANISH, "Puedo manejar eso.", "Genial. Estaré aquí esperando 4 granadas, 3 nueces y 2 carnes.");
        cv9.listeners = (ctx, fragment) -> {
            Quest newQuest = App.DataManager.getQuest(QuestsIds.ARMY_NOVICE_TASKS);
            LibQuest.includeQuestToQuestbook(newQuest, App.getPlayerChar(), ctx);
        };

        ConversationOption cv10 = new ConversationOption(3, 0);
        cv10.addOptionText(ENGLISH, "Not now, sorry.", "Ok... Then tell me when you are ready.");
        cv10.addOptionText(PORTUGUESE, "Agora não, desculpe.", "Ok... Então me diga quando estiver pronto.");
        cv10.addOptionText(SPANISH, "Ahora no, lo siento.", "Ok... entonces dime cuando estés listo.");

        ConversationOption cv11 = new ConversationOption(0, 0);
        cv11.addOptionText(ENGLISH, "I have brought the provisions for the banquet.", "Oh, [PLAYERNAME], this is good. Thanks.\nBut I must ask for more help. We need more soldiers protecting the city during the banquet. You should go to the Harbor and to the plains and call our soldiers back.");
        cv11.addOptionText(PORTUGUESE, "Trouxe as provisões para o banquete.", "Oh, [PLAYERNAME], isso é bom. Obrigado. Mas eu devo pedir mais ajuda. Precisamos de mais soldados protegendo a cidade durante o banquete. Você deveria ir ao Porto e às planícies e chamar nossos soldados de volta.");
        cv11.addOptionText(SPANISH, "He traído las provisiones para el banquete.", "Oh, [PLAYERNAME], esto es bueno. Gracias. Pero debo pedir más ayuda. Necesitamos más soldados que protejan la ciudad durante el banquete. Deberías ir al puerto y a las llanuras y llamar a nuestros soldados.");
        cv11.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = chara.getQuest(QuestsIds.ARMY_NOVICE_TASKS);
            boolean haveItems = LibInventory.checkHasItemAmount(ItemsIds.POMEGRANATE, 4, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.NUTS, 3, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.RAW_MEAT, 2, chara);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 1 && haveItems) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv11.listeners = (ctx, fragment) -> {
            LibInventory.removeFromInventory(ItemsIds.POMEGRANATE, 4, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.NUTS, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.RAW_MEAT, 2, App.getPlayerChar());
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.ARMY_NOVICE_TASKS);

            Variable questsVar = App.getPlayerCharVariable(Enums.GameplayVariables.QUESTS);
            questsVar.addOrUpdateSwitch(new Switch(ARMY_NOVICE_QUEST_SWITCH_PART_2_HARBOR_SOLDIERS, false));
            questsVar.addOrUpdateSwitch(new Switch(ARMY_NOVICE_QUEST_SWITCH_PART_2_PLAINS_SOLDIERS, false));

            LibQuest.updateQuest(quest, 2, App.getPlayerChar(), ctx);
        };

        ConversationOption cv12 = new ConversationOption(0, 0);
        cv12.addOptionText(ENGLISH, "I called the soldiers as you asked for.", "Very well, thanks.\nFor now, you can rest or see if some other soldier needs some help.");
        cv12.addOptionText(PORTUGUESE, "Chamei os soldados como você pediu.", "Muito bem, obrigado.\nPor enquanto, você pode descansar ou ver se algum outro soldado precisa de ajuda.");
        cv12.addOptionText(SPANISH, "Llamé a los soldados como me pediste.", "Muy bien, gracias.\nPor ahora, puedes descansar o ver si algún otro soldado necesita ayuda.");
        cv12.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.ARMY_NOVICE_TASKS);
            Variable questsVar = App.getPlayerCharVariable(Enums.GameplayVariables.QUESTS);
            Switch calledSoldiers1 = GameEngine.getSwitchFromVariable(questsVar, ARMY_NOVICE_QUEST_SWITCH_PART_2_HARBOR_SOLDIERS);
            Switch calledSoldiers2 = GameEngine.getSwitchFromVariable(questsVar, ARMY_NOVICE_QUEST_SWITCH_PART_2_PLAINS_SOLDIERS);
            boolean hasCalledSoldier = calledSoldiers1 != null
                    && calledSoldiers2 != null
                    && ((Boolean) calledSoldiers1.getValue()) && ((Boolean) calledSoldiers2.getValue());

            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 2 && hasCalledSoldier) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv12.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.ARMY_NOVICE_TASKS);
            LibQuest.updateQuest(quest, 3, App.getPlayerChar(), ctx);
        };

        ConversationOption cv13 = new ConversationOption(0, 4);
        cv13.addOptionText(ENGLISH, "I would like more action.", "You are working well until now and also shows a desire of work. I think you may have the necessary attributes to help with a nice mission we have.\nWhat about a reconnaissance mission?");
        cv13.addOptionText(PORTUGUESE, "Eu gostaria de mais ação.", "Você está trabalhando bem até agora e também demonstra desejo de trabalhar. Acho que você pode ter os atributos necessários para ajudar em uma boa missão que temos.\nQue tal uma missão de reconhecimento?");
        cv13.addOptionText(SPANISH, "Me gustaría más acción.", "Hasta ahora estás trabajando bien y además demuestras ganas de trabajar. Creo que puedes tener los atributos necesarios para ayudarnos en una buena misión que tenemos.\n¿Qué tal una misión de reconocimiento?");
        cv13.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest2 = App.getPlayerChar().getQuest(QuestsIds.ORC_OBSERVATION);

            if (LibQuest.isCharacterAtQuestPart(App.getPlayerChar(), QuestsIds.ARMY_NOVICE_TASKS, 5)
                    && !LibQuest.isQuestComplete(App.getPlayerChar(), QuestsIds.ARMY_NOVICE_TASKS)
                    && requiredQuest2 == null) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv13.listeners = (ctx, currentFragment) -> LibQuest.completeQuest(QuestsIds.ARMY_NOVICE_TASKS, App.getPlayerChar(), null, ctx);

        ConversationOption cv24 = new ConversationOption(0, 4);
        cv24.addOptionText(ENGLISH, "I am ready for a new task.", "I think you may have the necessary attributes to help with a nice mission we have.\nWhat about a reconnaissance mission?");
        cv24.addOptionText(PORTUGUESE, "Estou pronto para uma nova tarefa.", "Acho que você pode ter os atributos necessários para ajudar em uma boa missão que temos.\nQue tal uma missão de reconhecimento?");
        cv24.addOptionText(SPANISH, "Estoy listo para una nueva tarea.", "Creo que puedes tener los atributos necesarios para ayudarnos en una buena misión que tenemos.\n¿Qué tal una misión de reconocimiento?");
        cv24.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest2 = App.getPlayerChar().getQuest(QuestsIds.ORC_OBSERVATION);
            if (LibQuest.isQuestComplete(App.getPlayerChar(), QuestsIds.ARMY_NOVICE_TASKS) && requiredQuest2 == null) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv15 = new ConversationOption(4, 0);
        cv15.addOptionText(ENGLISH, "This is not what I look for now.", "And this is not what I wanted to hear.");
        cv15.addOptionText(PORTUGUESE, "Não é isso que procuro agora.", "E não era isso que eu queria ouvir.");
        cv15.addOptionText(SPANISH, "Esto no es lo que busco ahora.", "Y esto no es lo que quería oír.");

        ConversationOption cv14 = new ConversationOption(4, 5);
        cv14.addOptionText(ENGLISH, "Great, I do it.", "Well, [PLAYERNAME], here is the brief:\nAll we need from you is to go near the Orc Hamlet and stay there observating for some hours. Take notes, we need to know how many orcs, the size of the walls and any other important thing that can be useful to make a strategy.");
        cv14.addOptionText(PORTUGUESE, "Ótimo, eu faço isso.", "Bem, [PLAYERNAME], aqui estão as instruções:\nTudo o que precisamos que você faça é ir até próximo a Aldeia Orc e ficar lá observando por algumas horas. Tome notas, precisamos saber quantos orcs, o tamanho dos muros e qualquer outra coisa importante que possa ser útil para fazer uma estratégia.");
        cv14.addOptionText(SPANISH, "Genial, lo hago.", "Bueno, [PLAYERNAME], aquí tienes las instrucciones:\nTodo lo que necesitamos de ti es que vayas a la Fortaleza de los Orcos y te quedes allí observando durante algunas horas. Toma notas, necesitamos saber cuántos orcos hay, el tamaño de las murallas y cualquier otra cosa importante que pueda ser útil para elaborar una estrategia.");
        cv14.listeners = (ctx, fragment) -> {
            Quest newQuest = App.DataManager.getQuest(QuestsIds.ORC_OBSERVATION);
            LibQuest.includeQuestToQuestbook(newQuest, App.getPlayerChar(), ctx);
        };

        ConversationOption cv17 = new ConversationOption(5, 0);
        cv17.addOptionText(ENGLISH, "Any advice on how to do it?", "Good, don't be shy to ask questions. I suggest to use a spyglass, to observe from far. I know that the old man that lives in the shores sell some handmade spyglasses.");
        cv17.addOptionText(PORTUGUESE, "Alguma dica de como fazer isso?", "Bom, não tenha vergonha de fazer perguntas. Eu sugiro usar uma luneta, para observar de longe. Eu sei que o velho que mora na costa vende algumas lunetas artesanais.");
        cv17.addOptionText(SPANISH, "¿Algún consejo sobre cómo hacerlo?", "Bueno, no tengas vergüenza de hacer preguntas. Te sugiero que utilices un catalejo para observar desde lejos. Sé que el anciano que vive en la orilla vende catalejos hechos a mano.");

        ConversationOption cv16 = new ConversationOption(0, 0);
        cv16.addOptionText(ENGLISH, "I observed the orcs.", "Very good, let's use your information to elaborate an strategy, thanks [PLAYERNAME].\nThe next time you talk to Erino, he will already be prepared for our attack.");
        cv16.addOptionText(PORTUGUESE, "Observei os orcs.", "Muito bem, vamos usar suas informações para elaborar uma estratégia, obrigado [PLAYERNAME].\nNa próxima vez que você falar com Erino, ele já estará preparado para o nosso ataque.");
        cv16.addOptionText(SPANISH, "Observé a los orcos.", "Muy bien, usemos tu información para elaborar una estrategia, gracias [PLAYERNAME].\nLa próxima vez que hables con Erino, él ya estará preparado para nuestro ataque.");
        cv16.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.ORC_OBSERVATION);

            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv16.listeners = (ctx, fragment) -> {
            Quest newQuest = App.DataManager.getQuest(QuestsIds.COUNTER_ATTACK);
            LibQuest.includeQuestToQuestbook(newQuest, App.getPlayerChar(), ctx);

            Quest quest = App.getPlayerChar().getQuest(QuestsIds.ORC_OBSERVATION);
            LibQuest.updateQuest(quest, 4, App.getPlayerChar(), ctx);
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);
        };

        ConversationOption cv18 = new ConversationOption(0, 6);
        cv18.addOptionText(ENGLISH, "Are we safe now?", "I think so. Orcs and their lair were destroyed, we now will have a peaceful time I guess.");
        cv18.addOptionText(PORTUGUESE, "Estamos seguros agora?", "Acho que sim. Os orcs e seu covil foram destruídos, agora teremos um tempo de paz, eu acho.");
        cv18.addOptionText(SPANISH, "¿Estamos seguros ahora?", "Creo que sí. Los orcos y su guarida fueron destruidos. Supongo que ahora tendremos un período de paz.");
        cv18.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, COUNTER_ATTACK, 4)
                    && !LibQuest.isQuestComplete(chara, COUNTER_ATTACK)
                    && !LibQuest.charHasQuest(ARMY_HONORED_TASKS, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv19 = new ConversationOption(6, 7);
        cv19.addOptionText(ENGLISH, "And me, what can I do?", "Ah, yes, you...\nYou were very important in the mission and we recognize your effort. I would like to give you more importance from now on.");
        cv19.addOptionText(PORTUGUESE, "E eu, o que posso fazer?", "Ah, sim, você...\nVocê foi muito importante na missão e reconhecemos seu esforço. Gostaria de lhe dar mais importância de agora em diante.");
        cv19.addOptionText(SPANISH, "Y yo ¿qué puedo hacer?", "Ah, sí, tú...\nFuiste muy importante en la misión y reconocemos tu esfuerzo. Me gustaría darte más importancia a partir de ahora.");

        ConversationOption cv20 = new ConversationOption(7, 8);
        cv20.addOptionText(ENGLISH, "Thanks, but the dead ones were important also.", "For sure. Are you thinking something?");
        cv20.addOptionText(PORTUGUESE, "Obrigado, mas os mortos também eram importantes.", "Com certeza. Você está pensando em algo?");
        cv20.addOptionText(SPANISH, "Gracias, pero los muertos también eran importantes.", "Seguro. ¿Estás pensando algo?");

        ConversationOption cv21 = new ConversationOption(8, 0);
        cv21.addOptionText(ENGLISH, "What about a ceremony in honor of the soldiers?", "Seems a great attitude. But for such a thing we need the king's approval. Be free to talk to him, he is very receptive now.");
        cv21.addOptionText(PORTUGUESE, "Que tal uma cerimônia em homenagem aos soldados?", "Parece uma ótima atitude. Mas para tal coisa precisamos da aprovação do rei. Fique à vontade para falar com ele, ele está muito receptivo agora.");
        cv21.addOptionText(SPANISH, "¿Qué tal una ceremonia en honor a los soldados?", "Parece una actitud estupenda, pero para algo así necesitamos la aprobación del rey. Siéntete libre de hablar con él, ahora está muy receptivo.");
        cv21.listeners = (ctx, fragment) -> {
            Quest newQuest = App.DataManager.getQuest(QuestsIds.ARMY_HONORED_TASKS);
            LibQuest.includeQuestToQuestbook(newQuest, App.getPlayerChar(), ctx);
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.COUNTER_ATTACK);
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);
        };

        ConversationOption cv22 = new ConversationOption(0, 9);
        cv22.addOptionText(ENGLISH, "Hey, do we have something to do?", "We don't have for now, but you have. Your ceremony was great and the king really liked. He asked me to tell you that he wants to see you as soon as possible, because he has a job for you.");
        cv22.addOptionText(PORTUGUESE, "Ei, temos algo para fazer?", "Não temos por enquanto, mas você tem. Sua cerimônia foi ótima e o rei realmente gostou. Ele me pediu para lhe dizer que quer vê-lo o mais breve possível, porque ele tem um trabalho para você.");
        cv22.addOptionText(SPANISH, "Oye, ¿tenemos algo que hacer?", "Nosotros no tenemos por ahora, pero tú sí. Tu ceremonia fue genial y le gustó mucho al rey. Me pidió que te dijera que quiere verte lo antes posible, porque tiene un trabajo para ti.");
        cv22.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.ARMY_HONORED_TASKS);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 4) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv23 = new ConversationOption(9, 0);
        cv23.addOptionText(ENGLISH, "Do you know what is the job?", "Apparently, the king think you are loyal and since you were a good soldier during the battle he thinks you are a good choice to be a bodyguard during a travel to Havarus.");
        cv23.addOptionText(PORTUGUESE, "Você sabe qual é o trabalho?", "Aparentemente, o rei acha que você é leal e, como você foi um bom soldado durante a batalha, ele acha que você é uma boa escolha para ser guarda-costas durante uma viagem a Havarus.");
        cv23.addOptionText(SPANISH, "¿Sabes cuál es el trabajo?", "Al parecer, el rey piensa que eres leal y como fuiste un buen soldado durante la batalla, piensa que eres una buena opción para ser su guardaespaldas durante un viaje a Havarus.");
        cv23.listeners = (ctx, fragment) -> {
            Quest quest = App.DataManager.getQuest(QuestsIds.ARMY_HONORED_TASKS);
            LibQuest.updateQuest(quest.getUId(), 5, App.getPlayerChar(), ctx);
        };

        // Roleplay: Após Overseas Recognition (Quest 9) - Jogador voltou a Lisport após ganhar reconhecimento
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "How have you been, Lenny?", "Me? I am doing well, thank you for asking, [PLAYERNAME]. But the real question is: how are YOU doing? I heard you gained recognition from the Queen of Havarus herself! That is impressive.\nYou left Lisport as a simple novice and now you are serving the kingdom. We are proud of you here.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Como você está, Lenny?", "Eu? Estou bem, obrigado por perguntar, [PLAYERNAME]. Mas a verdadeira pergunta é: como VOCÊ está? Ouvi dizer que você ganhou reconhecimento da própria Rainha de Havarus! Isso é impressionante.\nVocê deixou Lisport como um simples novato e agora está servindo o reino. Estamos orgulhosos de você aqui.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cómo has estado, Lenny?", "¿Yo? Estoy bien, gracias por preguntar, [PLAYERNAME]. Pero la verdadera pregunta es: ¿cómo estás TÚ? ¡Escuché que ganaste el reconocimiento de la mismísima Reina de Havarus! Eso es impresionante.\nDejaste Lisport como un simple novato y ahora estás sirviendo al reino. Estamos orgullosos de ti aquí.");
        cvRoleplay1.requirementValidations = (chara, ctx) -> {
            if ((LibQuest.isQuestComplete(chara, QuestsIds.COUNTER_ATTACK) || LibQuest.isQuestComplete(chara, QuestsIds.ARMY_HONORED_TASKS))
                    && LibQuest.isQuestComplete(chara, QuestsIds.OVERSEAS_RECOGNITION)
                    && !(LibQuest.isQuestComplete(chara, QuestsIds.KILL_OCTUMAN) || LibQuest.isQuestComplete(chara, QuestsIds.DESTROY_THE_LAIR))) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // Roleplay: Após Destroy the Lair/Kill Octuman (Quest 13) - Maior reconhecimento
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Good to see familiar faces.", "And it is good to see you too, [PLAYERNAME]! News travels fast, even to our small island. They say you are becoming quite the hero in Havarus.\nLisport is peaceful these days, thanks in part to what we did against the orcs. Life here continues as always, quiet and simple.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Que bom ver rostos familiares.", "E é bom ver você também, [PLAYERNAME]! As notícias viajam rápido, até para nossa pequena ilha. Dizem que você está se tornando um verdadeiro herói em Havarus.\nLisport está pacífico hoje em dia, graças em parte ao que fizemos contra os orcs. A vida aqui continua como sempre, tranquila e simples.");
        cvRoleplay2.addOptionText(SPANISH, "Qué bueno ver caras conocidas.", "¡Y es bueno verte también, [PLAYERNAME]! Las noticias viajan rápido, incluso a nuestra pequeña isla. Dicen que te estás convirtiendo en todo un héroe en Havarus.\nLisport está tranquilo estos días, gracias en parte a lo que hicimos contra los orcos. La vida aquí continúa como siempre, tranquila y sencilla.");
        cvRoleplay2.requirementValidations = (chara, ctx) -> {
            if ((LibQuest.isQuestComplete(chara, QuestsIds.COUNTER_ATTACK) || LibQuest.isQuestComplete(chara, QuestsIds.ARMY_HONORED_TASKS))
                    && (LibQuest.isQuestComplete(chara, QuestsIds.DESTROY_THE_LAIR) || LibQuest.isQuestComplete(chara, QuestsIds.KILL_OCTUMAN))) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // Roleplay: Após Giving Orders (Quest 17) - Sobre as criaturas das trevas
        ConversationOption cvRoleplay3 = new ConversationOption(0, 0);
        cvRoleplay3.addOptionText(ENGLISH, "Have you heard about the dark creatures?", "Yes, troubling news reach us even here in Lisport. Dark creatures emerging from portals, attacking villages in Havarus... It sounds like something from old legends.\nThank the gods that Lisport has been spared so far. We are isolated here, which has its advantages. But I worry about the mainland. Stay safe out there, [PLAYERNAME].");
        cvRoleplay3.addOptionText(PORTUGUESE, "Você ouviu falar sobre as criaturas das trevas?", "Sim, notícias preocupantes chegam até nós aqui em Lisport. Criaturas das trevas emergindo de portais, atacando vilas em Havarus... Parece algo saído de velhas lendas.\nGraças aos deuses que Lisport foi poupado até agora. Estamos isolados aqui, o que tem suas vantagens. Mas me preocupo com o continente. Fique seguro por lá, [PLAYERNAME].");
        cvRoleplay3.addOptionText(SPANISH, "¿Has oído hablar de las criaturas oscuras?", "Sí, noticias inquietantes llegan incluso aquí a Lisport. Criaturas oscuras emergiendo de portales, atacando aldeas en Havarus... Suena como algo de viejas leyendas.\nGracias a los dioses que Lisport se ha salvado hasta ahora. Estamos aislados aquí, lo cual tiene sus ventajas. Pero me preocupa el continente. Cuídate por ahí, [PLAYERNAME].");
        cvRoleplay3.requirementValidations = (chara, ctx) -> {
            if ((LibQuest.isQuestComplete(chara, QuestsIds.COUNTER_ATTACK) || LibQuest.isQuestComplete(chara, QuestsIds.ARMY_HONORED_TASKS))
                    && LibQuest.isQuestComplete(chara, QuestsIds.GIVING_ORDERS)
                    && !LibQuest.isQuestComplete(chara, QuestsIds.ELFS_ALERT)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

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
        npc.conversationOptions.add(cv13);
        npc.conversationOptions.add(cv14);
        npc.conversationOptions.add(cv15);
        npc.conversationOptions.add(cv16);
        npc.conversationOptions.add(cv17);
        npc.conversationOptions.add(cv18);
        npc.conversationOptions.add(cv19);
        npc.conversationOptions.add(cv20);
        npc.conversationOptions.add(cv21);
        npc.conversationOptions.add(cv22);
        npc.conversationOptions.add(cv23);
        npc.conversationOptions.add(cv24);
        npc.conversationOptions.add(cvRoleplay1);
        npc.conversationOptions.add(cvRoleplay2);
        npc.conversationOptions.add(cvRoleplay3);
        npc.conversationOptions.add(cv1);
        npc.conversationOptions.add(cv2);

        return npc;
    }
}

