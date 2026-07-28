package com.cnx.endlesstalestwo.data.npcs.lisport.Harbor;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.items.ItemsIds.REPAIR_SUPPLIES;
import static com.cnx.endlesstalestwo.data.knowledges.KnowledgesIds.FISHING;

import android.os.Handler;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.GameEngine;
import com.cnx.endlesstalestwo.R;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.knowledges.KnowledgesIds;
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

public class Joggard extends DataHelper {

    public static final String MILITIA_QUEST_SWITCH_PART_1_FISHING = "MILITIA_QUEST_SWITCH_PART_1_FISHING";

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Joggard");
        npc.age = 39;
        npc.job = Enums.NPCJobs.MILITIAMAN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Hard to tell, but he is the leader of the militia.\nA good man, coherent, clever and decisive. Doesn't leave loose ends in his actions.\nEven as a militiaman, he knows the value of honor.\n\nPhysical traits: Nordic features. Clear and deep eyes. Light-colored hair and beard that are long.");
        npc.addDescriptionTranslation(PORTUGUESE, "Difícil perceber, mas é o líder da milícia.\nUm bom homem, coerente, esperto e decisivo. Não deixa pontas soltas nos seus atos.\nMesmo miliciano, sabe o valor da honra.\n\nSeus taços físicos: Traços nórdicos. Olhos claros e profundos. Cabelos e barba claros e longos.");
        npc.addDescriptionTranslation(SPANISH, "Difícil de decir, pero es el líder de la milicia.\nUn buen hombre, coherente, inteligente y decisivo. No deja cabos sueltos en sus acciones.\nIncluso como miliciano, sabe el valor de la honra.\n\nTrasos físicos: Características nórdicas. Ojos claros y profundos. Cabello y barba claros y largos.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hey."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Ei."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Ey."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("See ya, [GENDER_SIMPLE_CALL]."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Até mais, [GENDER_SIMPLE_CALL]."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Nos vemos, [GENDER_SIMPLE_CALL]."));

        npc.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.RAIDING_THE_ORCS);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 6) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        ConversationOption cv3 = new ConversationOption(0, 1);
        cv3.addOptionText(ENGLISH, "Are you the militia leader?", "What kind of question is this? I know nothing about this.");
        cv3.addOptionText(PORTUGUESE, "Você é o líder da milícia?", "Que tipo de pergunta é essa? Não sei nada sobre isso.");
        cv3.addOptionText(SPANISH, "¿Eres el líder de la milicia?", "¿Qué clase de pregunta es ésta? No sé nada sobre esto.");
        cv3.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.LOOKING_FOR_A_GUILD);
            if (requiredQuest != null && (requiredQuest.getCurrentPartOrder() == 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv4 = new ConversationOption(1, 2);
        cv4.addOptionText(ENGLISH, "Be honest, all I want is to join the militia.", "[Look to you suspiciously]\nHmmmm... Maybe I should not tell you the truth, but for some reason you look honestly interested in the militia.\nWhy you want to join?");
        cv4.addOptionText(PORTUGUESE, "Seja honesto, tudo o que eu quero é entrar para a milícia.", "[Olha para você com desconfiança]\nHmmmm... Talvez eu não devesse te contar a verdade, mas por algum motivo você parece honestamente interessado na milícia.\nPor que você quer se juntar?");
        cv4.addOptionText(SPANISH, "Sé honesto, todo lo que quiero es unirme a la milicia.", "[Te mira con desconfianza]\nHmmmm... Tal vez no debería decirte la verdad, pero por alguna razón pareces estar sinceramente interesado en la milicia.\n¿Por qué quieres unirte?");

        ConversationOption cv5 = new ConversationOption(2, 3);
        cv5.addOptionText(ENGLISH, "Orcs. They attacked Lisport and the army is not the place for me.", "Good. Orcs are a real problem, they raid Lisport and also stole goods that we tarnsport from the harbor to the city.\nHere we fight the evil but without the rules from the kingdom.\nDo you really want to join us?");
        cv5.addOptionText(PORTUGUESE, "Orcs. Eles atacaram Lisport e o exército não é lugar para mim. ", "Bom. Orcs são um problema real, eles atacam Lisport e também roubam mercadorias que transportamos do porto para a cidade.\nAqui lutamos contra o mal, mas sem as regras do reino.\nVocê realmente quer se juntar a nós?");
        cv5.addOptionText(SPANISH, "Orcos. Atacaron Lisport y el ejército no es lugar para mí.", "Bien. Los orcos son un verdadero problema. Invaden Lisport y también roban bienes que transportamos desde el puerto hasta la ciudad.\nAquí luchamos contra el mal, pero sin las reglas del reino.\n¿De verdad quieres unirte a nosotros?");

        ConversationOption cv6 = new ConversationOption(3, 0);
        cv6.addOptionText(ENGLISH, "Yes. This is my place.", "Alright then. First of all, you can't simply join, we need to know if you are realiable.\nI have a simple trial to you: Bring me 3 pieces of leather, let's see if you know how to hunt.");
        cv6.addOptionText(PORTUGUESE, "Sim. Este é o meu lugar.", "Tudo bem então. Primeiro de tudo, você não pode simplesmente se juntar, precisamos saber se você é confiável.\nTenho um teste simples para você: Traga-me 3 pedaços de couro, vamos ver se você sabe caçar.");
        cv6.addOptionText(SPANISH, "Si, este es mi lugar.", "Muy bien. En primer lugar, no puedes unirte sin más, necesitamos saber si eres confiable.\nTengo una prueba sencilla para ti: tráeme 3 piezas de cuero, veamos si sabes cazar.");
        cv6.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.LOOKING_FOR_A_GUILD);
            LibQuest.updateQuest(quest, 22, App.getPlayerChar(), ctx);
        };

        ConversationOption cv7 = new ConversationOption(3, 0);
        cv7.addOptionText(ENGLISH, "No, not yet.", "Are you disturbed? You ask to join but then quit...");
        cv7.addOptionText(PORTUGUESE, "Não, ainda não.", "Você está perturbado? Você pede para participar, mas depois desiste...");
        cv7.addOptionText(SPANISH, "No, todavía no.", "¿Estás molesto? Solicitas unirte pero luego abandonas...");

        ConversationOption cv8 = new ConversationOption(0, 0);
        cv8.addOptionText(ENGLISH, "Here, the leathers you asked for.", "Good, good. I already know that you can hunt. But, can you fight? The last thing before I accept you in the militia is: bring me an orc tooth.");
        cv8.addOptionText(PORTUGUESE, "Aqui estão os couros que você pediu.", "Bom, bom. Eu já sei que você pode caçar. Mas, você pode lutar? A última coisa antes de eu aceitar você na milícia é: traga-me um dente de orc.");
        cv8.addOptionText(SPANISH, "Aquí tienes los cueros que me pediste.", "Bien, bien. Ya sé que puedes cazar. Pero, ¿sabes luchar? Lo último que debes hacer antes de aceptarte en la milicia es traerme un diente de orco. ");
        cv8.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.LOOKING_FOR_A_GUILD);
            boolean hasItems = LibInventory.checkHasItemAmount(ItemsIds.LEATHER, 3, App.getPlayerChar());
            if (requiredQuest == null || requiredQuest.getCurrentPartOrder() != 22) {
                return Enums.RequirementVerification.NOT_OK;
            } else if (!hasItems) {
                return Enums.RequirementVerification.NEED_ITEMS;
            }
            return Enums.RequirementVerification.OK;
        };
        cv8.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.LOOKING_FOR_A_GUILD);
            LibQuest.updateQuest(quest, 23, App.getPlayerChar(), ctx);
            LibInventory.removeFromInventory(ItemsIds.LEATHER, 3, App.getPlayerChar());
        };

        ConversationOption cv9 = new ConversationOption(0, 0);
        cv9.addOptionText(ENGLISH, "I bring to you the orc tooth.", "Very well. You have proven yourself capable of integrating the militia. Be welcome.\nThe first thing I want you to do as member of our band is to talk to Olga, she will introduce our routine.");
        cv9.addOptionText(PORTUGUESE, "Trago para vocês o dente de orc.", "Muito bem. Você provou ser capaz de integrar a milícia. Seja bem-vindo.\nA primeira coisa que quero que você faça como membro da nossa banda é falar com Olga, ela apresentará nossa rotina");
        cv9.addOptionText(SPANISH, "Os traigo el diente de orco.", "Muy bien, has demostrado ser capaz de integrar la milicia. Bienvenido.\nLo primero que quiero que hagas como miembro de nuestra banda es hablar con Olga, ella te presentará nuestra rutina.");
        cv9.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.LOOKING_FOR_A_GUILD);
            boolean hasItems = LibInventory.checkHasItemAmount(ItemsIds.ORC_TOOTH, 1, App.getPlayerChar());
            if (requiredQuest == null || requiredQuest.getCurrentPartOrder() != 23) {
                return Enums.RequirementVerification.NOT_OK;
            } else if (!hasItems) {
                return Enums.RequirementVerification.NEED_ITEMS;
            }
            return Enums.RequirementVerification.OK;
        };
        cv9.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.LOOKING_FOR_A_GUILD);
            LibQuest.updateQuest(quest, 24, App.getPlayerChar(), ctx);
            LibInventory.removeFromInventory(ItemsIds.ORC_TOOTH, 1, App.getPlayerChar());
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);

            Quest newQuest = App.DataManager.getQuest(QuestsIds.MILITIA_TASKS);
            LibQuest.includeQuestToQuestbook(newQuest, App.getPlayerChar(), ctx);
        };

        ConversationOption cv10 = new ConversationOption(0, 0);
        cv10.addOptionText(ENGLISH, "I need your approve to get a fishing rod from the militia stock.", "Yes, correct.\nBut it is ok, I approve.\nHere, take, it is yours now.");
        cv10.addOptionText(PORTUGUESE, "Preciso da sua aprovação para obter uma vara de pescar do estoque da milícia.", "Sim, correto.\nMas está tudo bem, eu aprovo.\nAqui, pegue, é seu agora.");
        cv10.addOptionText(SPANISH, "Necesito su aprobación para conseguir una caña de pescar del stock de la milicia.", "Sí, correcto.\nPero está bien, lo apruebo.\nToma, ahora es tuyo.");
        cv10.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.MILITIA_TASKS);
            Variable questsVar = App.getPlayerChar().getVariables().get(Enums.GameplayVariables.QUESTS);
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.MILITIA_TASKS, 2)
                    && questsVar != null
                    && requiredQuest != null) {
                Switch swt = GameEngine.getSwitchFromVariable(questsVar, MILITIA_QUEST_SWITCH_PART_1_FISHING);
                if (swt == null || ((Float) swt.getValue()) != 1f) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv10.listeners = (ctx, fragment) -> {
            Variable questsVar = App.getPlayerChar().getVariables().get(Enums.GameplayVariables.QUESTS);
            if (questsVar != null) {
                if (!questsVar.hasSwitchValue(MILITIA_QUEST_SWITCH_PART_1_FISHING, 1)) {
                    LibInventory.addToInventory(ItemsIds.FISHING_ROD, 1, App.getPlayerChar());
                    questsVar.addOrUpdateSwitch(new Switch(MILITIA_QUEST_SWITCH_PART_1_FISHING, 1));
                    try {
                        String itemName = App.DataManager.getItem(ItemsIds.FISHING_ROD).getName(App.CURRENT_LANGUAGE);
                        LibUtils.showToast(LibUtils.getString(R.string.receivedItem, ctx) + itemName, 0, CoreEnums.MessageType.INFO, ctx);
                    } catch (Exception ignored) {
                    }
                }
            }
        };

        ConversationOption cv11 = new ConversationOption(0, 0);
        cv11.addOptionText(ENGLISH, "Olga said that we have all the supplies", "Perfect. Things are running well then.\nWe are almost ready to smash the orcs. One more step, so I ask you to go talk to Paulson, he is hiding the the west grove, observing the orcs.");
        cv11.addOptionText(PORTUGUESE, "Olga disse que temos todos os suprimentos", "Perfeito. As coisas estão indo bem então.\nEstamos quase prontos para esmagar os orcs. Mais um passo, então peço que você vá falar com Paulson, ele está escondido no bosque oeste, observando os orcs.");
        cv11.addOptionText(SPANISH, "Olga dijo que tenemos todos los suministros.", "Perfecto. Todo va bien. \nEstamos casi listos para aplastar a los orcos. Un paso más, así que te pido que vayas a hablar con Paulson, él está escondido en el bosque del oeste, observando a los orcos.");
        cv11.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.MILITIA_TASKS);
            if (requiredQuest != null && (requiredQuest.getCurrentPartOrder() == 5 && !requiredQuest.isComplete())) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv11.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.MILITIA_TASKS);
            LibQuest.updateQuest(quest, 6, App.getPlayerChar(), ctx);
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);

            Quest newQuest = App.DataManager.getQuest(QuestsIds.RAIDING_THE_ORCS);
            LibQuest.includeQuestToQuestbook(newQuest, App.getPlayerChar(), ctx);
        };

        ConversationOption cv12 = new ConversationOption(0, 0);
        cv12.addOptionText(ENGLISH, "Why the militia is settled here in the harbor?", "It is a good place. Far enough from the city, good enough to observe the seas. Also, from here, working with the ship loads, we can understand which resources are entering and exiting our small kingdom.\nI always try to preserve our identity, I never tell anyone that we are the militia, we work quiet.");
        cv12.addOptionText(PORTUGUESE, "Por que a milícia está instalada aqui no porto?", "É um bom lugar. Longe o suficiente da cidade, bom o suficiente para observar os mares. Além disso, daqui, trabalhando com as cargas dos navios, podemos entender quais recursos estão entrando e saindo do nosso pequeno reino.\nEu sempre tento preservar nossa identidade, nunca conto a ninguém que somos a milícia, trabalhamos em silêncio.");
        cv12.addOptionText(SPANISH, "¿Por qué la milicia está establecida aquí en el puerto?", "Es un buen lugar. Lo suficientemente alejado de la ciudad, lo suficientemente bueno para observar los mares. Además, desde aquí, trabajando con las cargas de los barcos, podemos entender qué recursos entran y salen de nuestro pequeño reino.\nSiempre trato de preservar nuestra identidad, nunca le digo a nadie que somos la milicia, trabajamos en silencio.");
        cv12.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.LOOKING_FOR_A_GUILD);
            if (requiredQuest != null) {
                int currentPart = requiredQuest.getCurrentPartOrder();
                if ((currentPart == 22 || currentPart == 23 || currentPart == 24)) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv14 = new ConversationOption(0, 0);
        cv14.addOptionText(ENGLISH, "Paulson is done with the ship repair. Let's attack!", "Great! Let's move on. I will call everybody. The plan is to attack by ship and by land. I want you to attack from the front with some men and me and the others will go on the ship\nLets go!");
        cv14.addOptionText(PORTUGUESE, "Paulson terminou o reparo do navio. Vamos atacar!", "Ótimo! Vamos em frente. Vou chamar todo mundo. O plano é atacar por navio e por terra. Quero que você ataque pela frente com alguns homens e eu e os outros iremos no navio\nVamos!");
        cv14.addOptionText(SPANISH, "Paulson ha terminado con la reparación del barco. ¡Ataquemos!", "¡Genial! Sigamos adelante. Llamaré a todos. El plan es atacar por barco y por tierra. Quiero que ataques desde el frente con algunos hombres y yo y los demás iremos en el barco.\n¡Vamos!");
        cv14.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RAIDING_THE_ORCS, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv14.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.RAIDING_THE_ORCS);
            LibQuest.updateQuest(quest, 6, App.getPlayerChar(), ctx);
        };

        ConversationOption cv15 = new ConversationOption(0, 999);
        cv15.addOptionText(ENGLISH, "Ready?", "Sure, go ahead, let's smash them!");
        cv15.addOptionText(PORTUGUESE, "Preparado?", "Claro, vá em frente, vamos esmagá-los!");
        cv15.addOptionText(SPANISH, "¿Listo?", "Claro, adelante, ¡aplastémoslos!");
        cv15.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RAIDING_THE_ORCS, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cvRaidingOrcsQustPart2 = new ConversationOption(0, 0);
        cvRaidingOrcsQustPart2.addOptionText(ENGLISH, "Paulson needs some tools.", "Oh yes, he said he would need them, I already left a crate with the things separated inside. You can pick it up and take it to him. It's right there.");
        cvRaidingOrcsQustPart2.addOptionText(PORTUGUESE, "Paulson precisa de ferramentas.", "Ah sim, ele  havia dito que iria precisar, já deixei um caixote com as coisas separadas dentro. Pode pegar e levar para ele. Está logo ali.");
        cvRaidingOrcsQustPart2.addOptionText(SPANISH, "Paulson necesita algunas herramientas.", "Oh sí, dijo que las necesitaría, ya dejé una caja con las cosas separadas adentro. Puedes recogerla y llevársela. Está justo ahí.");
        cvRaidingOrcsQustPart2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RAIDING_THE_ORCS, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvRaidingOrcsQustPart2.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(REPAIR_SUPPLIES, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.RAIDING_THE_ORCS, 3, App.getPlayerChar(), ctx);
        };

        ConversationOption cv16 = new ConversationOption(0, 4);
        cv16.addOptionText(ENGLISH, "We won!", "Yes, but it is not time to celebrate yet. Many were injured. We need medical supplies to save them. Help us once again, [PLAYERNAME].");
        cv16.addOptionText(PORTUGUESE, "Nós vencemos!", "Sim, mas ainda não é hora de comemorar. Muitos ficaram feridos. Precisamos de suprimentos médicos para salvá-los. Ajude-nos mais uma vez, [PLAYERNAME].");
        cv16.addOptionText(SPANISH, "Nosotros ganamos!", "Sí, pero aún no es momento de celebrar. Muchos resultaron heridos. Necesitamos suministros médicos para salvarlos. Ayúdanos una vez más, [PLAYERNAME].");
        cv16.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RAIDING_THE_ORCS, 7)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv16.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.RAIDING_THE_ORCS);
            LibQuest.updateQuest(QuestsIds.RAIDING_THE_ORCS, 8, App.getPlayerChar(), ctx);
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);
        };

        ConversationOption cv17 = new ConversationOption(4, 0);
        cv17.addOptionText(ENGLISH, "I'll bring whatever is needed.", "Very well, please, hurry, bring me some herbs to make medicine, I think 3 red herbs and 5 green herbs will be enough. Also we need some bandages, bring me 4 pieces of tissue.");
        cv17.addOptionText(PORTUGUESE, "Trarei o que for necessário.", "Muito bem, por favor, rápido, traga-me algumas ervas para fazer remédio, acho que 3 ervas vermelhas e 5 ervas verdes serão o suficiente. Também precisamos de algumas ataduras, traga-me 4 pedaços de tecido.");
        cv17.addOptionText(SPANISH, "Traeré todo lo que sea necesario.", "Muy bien, por favor, date prisa, tráeme algunas hierbas para hacer la medicina, creo que 3 hierbas rojas y 5 hierbas verdes serán suficientes. También necesitamos algunas vendas, tráeme 4 pedazos de pañuelos.");
        cv17.listeners = (ctx, fragment) -> {
            Quest newQuest = App.getPlayerChar().getQuest(QuestsIds.MEDICAL_SUPPORT);
            LibQuest.includeQuestToQuestbook(newQuest, App.getPlayerChar(), ctx);
        };

        ConversationOption cv18 = new ConversationOption(4, 0);
        cv18.addOptionText(ENGLISH, "I have no time now.", "Maybe you are not the person I thought you are.");
        cv18.addOptionText(PORTUGUESE, "Não tenho tempo agora.", "Talvez você não seja a pessoa que eu pensava.");
        cv18.addOptionText(SPANISH, "No tengo tiempo ahora", "Quizás no seas la persona que pensé que eras.");

        ConversationOption cv25 = new ConversationOption(0, 0);
        cv25.addOptionText(ENGLISH, "So, our militia needs my help?", "Yes, hurry, no time for further explanations. Bring me some herbs to make medicine, I think 3 red herbs and 5 green herbs will be enough. Also we need some bandages, bring me 4 pieces of tissue.");
        cv25.addOptionText(PORTUGUESE, "Então, nossa milícia precisa da minha ajuda?", "Sim, apresse-se, não há tempo para mais explicações. Traga-me algumas ervas para fazer remédio, acho que 3 ervas vermelhas e 5 ervas verdes serão suficientes. Também precisamos de algumas ataduras, traga-me 4 pedaços de tecido.");
        cv25.addOptionText(SPANISH, "Entonces, ¿nuestra milicia necesita mi ayuda?", "Sí, date prisa, no hay tiempo para más explicaciones. Tráeme algunas hierbas para hacer medicinas, creo que 3 hierbas rojas y 5 hierbas verdes serán suficientes. También necesitamos algunas vendas, tráeme 4 pedazos de pañuelos.");
        cv25.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.MEDICAL_SUPPORT, chara)
                    && LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RAIDING_THE_ORCS, 8)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv25.listeners = (ctx, currentFragment) -> LibQuest.includeQuestToQuestbook(QuestsIds.MEDICAL_SUPPORT, App.getPlayerChar(), ctx);

        ConversationOption cv13 = new ConversationOption(0, 0);
        cv13.addOptionText(ENGLISH, "Here, I have the medicine stuff.", "Thank you very much.\nBut Olga said that one of our men will not survive with just some medicines, he needs a specialist.\n[PLAYERNAME] go to Lisport, find a doctor, I think his name is Rawer. He once already helped us. Olga knew him well, if you have any questions, you can talk to her. Convince him to come here.");
        cv13.addOptionText(PORTUGUESE, "Aqui, eu tenho o material de medicina.", "Muito obrigado.\nMas Olga disse que um dos nossos homens não sobreviverá apenas com alguns remédios, ele precisa de um especialista.\n[PLAYERNAME] vá para Lisport, encontre um médico, acho que o nome dele é Rawer. Ele uma vez já nos ajudou. Olga o conhecia bem, se tiver alguma dúvida, pode falar com ela. Convença-o a vir aqui.");
        cv13.addOptionText(SPANISH, "Aquí tengo el material medicinal.", "Muchas gracias.\nPero Olga dijo que uno de nuestros hombres no sobrevivirá solo con algunas medicinas, necesita un especialista.\n[PLAYERNAME] ve a Lisport, busca un médico, creo que se llama Rawer. Una vez ya nos ayudó. Olga lo conocía bien, si tienes alguna pregunta, puedes hablar con ella. Convéncelo para que venga aquí.");
        cv13.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.MEDICAL_SUPPORT);
            boolean hasItems = LibInventory.checkHasItemAmount(ItemsIds.RED_HERB, 3, App.getPlayerChar())
                    && LibInventory.checkHasItemAmount(ItemsIds.GREEN_HERB, 5, App.getPlayerChar())
                    && LibInventory.checkHasItemAmount(ItemsIds.TISSUE, 4, App.getPlayerChar());

            if (requiredQuest == null || requiredQuest.getCurrentPartOrder() != 1) {
                return Enums.RequirementVerification.NOT_OK;
            } else if (!hasItems) {
                return Enums.RequirementVerification.NEED_ITEMS;
            }
            return Enums.RequirementVerification.OK;
        };
        cv13.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.MEDICAL_SUPPORT);
            LibInventory.removeFromInventory(ItemsIds.RED_HERB, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.GREEN_HERB, 5, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.TISSUE, 4, App.getPlayerChar());
            LibQuest.updateQuest(quest, 2, App.getPlayerChar(), ctx);
        };

        ConversationOption cv19 = new ConversationOption(0, 0);
        cv19.addOptionText(ENGLISH, "How is the things going here?", "Things are running pretty well now. No more orcs, just normal work to do. Our people are fine.");
        cv19.addOptionText(PORTUGUESE, "Como vão as coisas por aqui?", "As coisas estão indo muito bem agora. Não há mais orcs, apenas trabalho normal para fazer. Nosso povo está bem.");
        cv19.addOptionText(SPANISH, "¿Cómo van las cosas por aquí?", "Ahora todo va bastante bien. Ya no hay orcos, solo trabajo normal. Nuestra gente está bien.");
        cv19.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.MEDICAL_SUPPORT);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() >= 4) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv19.listeners = (ctx, currentFragment) -> {
            if (LibQuest.isCharacterAtQuestPart(App.getPlayerChar(), QuestsIds.MEDICAL_SUPPORT, 6)
                    && !LibQuest.isQuestComplete(App.getPlayerChar(), QuestsIds.MEDICAL_SUPPORT)) {
                LibQuest.completeQuest(QuestsIds.MEDICAL_SUPPORT, App.getPlayerChar(), 6, true, ctx);
            }
        };

        ConversationOption cv21 = new ConversationOption(0, 5);
        cv21.addOptionText(ENGLISH, "Anything else to work on?", "There is always something. Are you interested in helping us to restock our storages?");
        cv21.addOptionText(PORTUGUESE, "Mais alguma coisa para trabalhar?", "Sempre tem alguma coisa. Você tem interesse em nos ajudar a repor nossos estoques?");
        cv21.addOptionText(SPANISH, "¿Algo más en lo que trabajar?", "Siempre hay algo. ¿Te interesa ayudarnos a reponer nuestros almacenes?");
        cv21.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.REESTABLISHMENT, chara)
                    && LibQuest.isQuestComplete(chara, QuestsIds.MEDICAL_SUPPORT)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv22 = new ConversationOption(5, 0);
        cv22.addOptionText(ENGLISH, "Yes, I am here to help.", "Great [PLAYERNAME]! After the battle, we lost weapons and armors, we want to forge again. I will need 4 irons ores and 4 logs. Get it to me, please.");
        cv22.addOptionText(PORTUGUESE, "Sim, estou aqui para ajudar.", "Ótimo [PLAYERNAME]! Depois da batalha, perdemos armas e armaduras, queremos forjar novamente. Vou precisar de 4 minérios de ferro e 4 toras. Me traga, por favor.");
        cv22.addOptionText(SPANISH, "Sí, estoy aquí para ayudar.", "¡Genial, [PLAYERNAME]! Después de la batalla, perdimos armas y armaduras, queremos forjar de nuevo. Necesitaré 4 minerales de hierro y 4 troncos. Por favor, tráemelos.");
        cv22.listeners = (ctx, fragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.REESTABLISHMENT, App.getPlayerChar(), ctx);
        };

        ConversationOption cv23 = new ConversationOption(5, 0);
        cv23.addOptionText(ENGLISH, "I cannot help now.", "Sad... come back to me when you are free to help.");
        cv23.addOptionText(PORTUGUESE, "Não posso ajudar agora.", "Triste... volte para mim quando estiver livre para ajudar.");
        cv23.addOptionText(SPANISH, "No puedo ayudar ahora", "Triste... vuelve a mí cuando estés libre para ayudar.");

        ConversationOption cv24 = new ConversationOption(0, 0);
        cv24.addOptionText(ENGLISH, "Here, I have the stuff you asked for.", "Thanks a lot.\nOne more thing, our ship... The orcs danified it a lot during our landing. Talk to Paulson in the grove.");
        cv24.addOptionText(PORTUGUESE, "Aqui, tenho o que você pediu.", "Muito obrigado.\nMais uma coisa, nosso navio... Os orcs o danificaram muito durante nosso desembarque. Fale com Paulson no bosque.");
        cv24.addOptionText(SPANISH, "Aquí tengo lo que pediste.", "Muchas gracias.\nUna cosa más, nuestro barco... Los orcos lo han danificado mucho durante nuestro desembarco. Habla con Paulson en el bosque.");
        cv24.requirementValidations = (chara, ctx) -> {
            boolean hasItems = LibInventory.checkHasItemAmount(ItemsIds.LOG, 4, App.getPlayerChar())
                    && LibInventory.checkHasItemAmount(ItemsIds.IRON_ORE, 4, App.getPlayerChar());
            boolean isAtQuestPart = LibQuest.isCharacterAtQuestPart(chara, QuestsIds.REESTABLISHMENT, 1);

            if (isAtQuestPart && hasItems) {
                return Enums.RequirementVerification.OK;
            } else if (isAtQuestPart) {
                return Enums.RequirementVerification.NEED_ITEMS;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv24.listeners = (ctx, fragment) -> {
            LibInventory.removeFromInventory(ItemsIds.LOG, 4, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.IRON_ORE, 4, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.REESTABLISHMENT, 2, App.getPlayerChar(), ctx);
        };

        ConversationOption cv20 = new ConversationOption(0, 0);
        cv20.addOptionText(ENGLISH, "Do you want to talk to me?", "Yes. I must thank you. Me and the people of the militia are proud to have you with us and with thank you for all your effort.");
        cv20.addOptionText(PORTUGUESE, "Você quer falar comigo?", "Sim. Devo agradecer a você. Eu e o pessoal da milícia estamos orgulhosos de ter você conosco e agradecemos por todo seu esforço.");
        cv20.addOptionText(SPANISH, "¿Quieres hablar conmigo?", "Sí, tengo que darle las gracias. Tanto yo como la gente de la milicia estamos orgullosos de tenerlo con nosotros y le agradecemos todo su esfuerzo.");
        cv20.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.REESTABLISHMENT);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 4) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv20.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.REESTABLISHMENT);
            LibQuest.updateQuest(quest, 5, App.getPlayerChar(), ctx);
            App.Shell.flowManager.addCompletedQuestToQueue(quest, ctx);
        };

        // Roleplay: Após Overseas Recognition (Quest 9) - Apenas se jogador fez Militia Tasks
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "Joggard, how are things?", "Things are good here, [PLAYERNAME]. The militia keeps working, nothing too exciting.\nBut you... I heard about your new position in Havarus. Serving the Queen herself. That is quite a change from our small group here at the harbor. We work in the shadows, away from royal eyes. Different paths, I suppose.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Joggard, como vão as coisas?", "As coisas estão boas aqui, [PLAYERNAME]. A milícia continua trabalhando, nada muito emocionante.\nMas você... Ouvi sobre sua nova posição em Havarus. Servindo a própria Rainha. Isso é uma grande mudança do nosso pequeno grupo aqui no porto. Trabalhamos nas sombras, longe dos olhos reais. Caminhos diferentes, suponho.");
        cvRoleplay1.addOptionText(SPANISH, "Joggard, ¿cómo van las cosas?", "Todo va bien aquí, [PLAYERNAME]. La milicia sigue trabajando, nada demasiado emocionante.\nPero tú... He oído hablar de tu nueva posición en Havarus. Sirviendo a la propia Reina. Eso es un gran cambio de nuestro pequeño grupo aquí en el puerto. Trabajamos en las sombras, lejos de los ojos reales. Caminos diferentes, supongo.");
        cvRoleplay1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.MILITIA_TASKS)
                    && LibQuest.isQuestComplete(chara, QuestsIds.OVERSEAS_RECOGNITION)
                    && !(LibQuest.isQuestComplete(chara, QuestsIds.KILL_OCTUMAN) || LibQuest.isQuestComplete(chara, QuestsIds.DESTROY_THE_LAIR))) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // Roleplay: Após Destroy the Lair/Kill Octuman (Quest 13) - Apenas se fez Militia Tasks
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "It's been a while, Joggard.", "Indeed it has, [PLAYERNAME]. You have been busy with bigger things than our small militia affairs. Working for the crown now...\nI am glad to see you still remember where you started. Lisport remains safe and quiet, the way we like it. The militia still operates from the shadows, as always. We don't trust the royal guards much, you know that.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Faz um tempo, Joggard.", "De fato faz, [PLAYERNAME]. Você tem estado ocupado com coisas maiores do que os assuntos da nossa pequena milícia. Trabalhando para a coroa agora...\nFico feliz em ver que você ainda se lembra de onde começou. Lisport permanece segura e tranquila, do jeito que gostamos. A milícia ainda opera nas sombras, como sempre. Não confiamos muito nos guardas reais, você sabe disso.");
        cvRoleplay2.addOptionText(SPANISH, "Ha pasado un tiempo, Joggard.", "Así es, [PLAYERNAME]. Has estado ocupado con cosas más grandes que los asuntos de nuestra pequeña milicia. Trabajando para la corona ahora...\nMe alegra ver que todavía recuerdas dónde empezaste. Lisport permanece seguro y tranquilo, como nos gusta. La milicia sigue operando desde las sombras, como siempre. No confiamos mucho en los guardias reales, ya lo sabes.");
        cvRoleplay2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.MILITIA_TASKS)
                    && (LibQuest.isQuestComplete(chara, QuestsIds.DESTROY_THE_LAIR) || LibQuest.isQuestComplete(chara, QuestsIds.KILL_OCTUMAN))
                    && !LibQuest.isQuestComplete(chara, QuestsIds.GIVING_ORDERS)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // Roleplay: Após Giving Orders (Quest 17) - Apenas se fez Militia Tasks
        ConversationOption cvRoleplay3 = new ConversationOption(0, 0);
        cvRoleplay3.addOptionText(ENGLISH, "Have dark creatures reached Lisport?", "Not yet, thank the gods. We heard stories from sailors coming from the mainland. Dark portals, shadow beasts... sounds like the end times.\nLisport is isolated, which protects us for now. But if these creatures truly come from another realm, nowhere is truly safe. The militia remains vigilant. We don't rely on the royal army to protect us.");
        cvRoleplay3.addOptionText(PORTUGUESE, "As criaturas das trevas chegaram em Lisport?", "Ainda não, graças aos deuses. Ouvimos histórias de marinheiros vindos do continente. Portais escuros, bestas sombrias... parece o fim dos tempos.\nLisport está isolada, o que nos protege por enquanto. Mas se essas criaturas realmente vêm de outro reino, nenhum lugar está verdadeiramente seguro. A milícia permanece vigilante. Não dependemos do exército real para nos proteger.");
        cvRoleplay3.addOptionText(SPANISH, "¿Las criaturas oscuras han llegado a Lisport?", "Todavía no, gracias a los dioses. Hemos escuchado historias de marineros que vienen del continente. Portales oscuros, bestias sombrías... suena como el fin de los tiempos.\nLisport está aislado, lo que nos protege por ahora. Pero si estas criaturas realmente vienen de otro reino, ningún lugar está verdaderamente a salvo. La milicia permanece vigilante. No dependemos del ejército real para protegernos.");
        cvRoleplay3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.MILITIA_TASKS)
                    && LibQuest.isQuestComplete(chara, QuestsIds.GIVING_ORDERS)
                    && !LibQuest.isQuestComplete(chara, QuestsIds.THE_FINAL_BATTLE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cvFishing1 = new ConversationOption(0, 6);
        cvFishing1.addOptionText(ENGLISH, "Can I fish here in the harbor?", "You can try, but the harbor is bad for it. Too many ships, too much noise, too much movement in the water. The fish don't stay calm here for long. If I want a decent catch, I go closer to the coasts by the groves, where the sea is quieter and the fish bite better.");
        cvFishing1.addOptionText(PORTUGUESE, "Dá para pescar aqui no porto?", "Até dá para tentar, mas porto não é bom para isso. Tem navio demais, barulho demais e muita água se mexendo. Os peixes não ficam tranquilos aqui por muito tempo. Quando quero uma boa pescaria, vou mais para as costas perto dos bosques, onde o mar é mais calmo e os peixes mordem melhor.");
        cvFishing1.addOptionText(SPANISH, "¿Se puede pescar aquí en el puerto?", "Se puede intentar, pero el puerto no es bueno para eso. Hay demasiados barcos, demasiado ruido y mucha agitación en el agua. Los peces no se quedan tranquilos aquí por mucho tiempo. Cuando quiero una buena pesca, voy más hacia las costas junto a los bosques, donde el mar es más calmado y los peces pican mejor.");
        cvFishing1.requirementValidations = (chara, ctx) -> {
            if (!chara.hasKnowledge(KnowledgesIds.FISHING)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cvFishing2 = new ConversationOption(6, 7);
        cvFishing2.addOptionText(ENGLISH, "Is fishing difficult?", "Not exactly. Fishing is simple to understand, but not everyone has the patience for it. You need to watch the water, feel the pull, and know when to wait and when to move. A hasty fool comes back with an empty hook.");
        cvFishing2.addOptionText(PORTUGUESE, "Pescar é difícil?", "Não exatamente. Pescar é simples de entender, mas nem todo mundo tem paciência para isso. Você precisa observar a água, sentir o puxão e saber a hora de esperar e a hora de agir. Um apressado volta com o anzol vazio.");
        cvFishing2.addOptionText(SPANISH, "¿Pescar es difícil?", "No exactamente. Pescar es sencillo de entender, pero no todos tienen paciencia para ello. Hay que observar el agua, sentir el tirón y saber cuándo esperar y cuándo actuar. Un apresurado vuelve con el anzuelo vacío.");

        ConversationOption cvFishing3 = new ConversationOption(7, 8);
        cvFishing3.addOptionText(ENGLISH, "Can you teach me?", "I can, yes. I won't turn down someone willing to learn honest work. But I teach by practice, not by talk, so you'll need a fishing rod in your hands if you want me to show you properly.");
        cvFishing3.addOptionText(PORTUGUESE, "Pode me ensinar?", "Posso, sim. Não costumo negar ensino a quem quer aprender um trabalho honesto. Mas eu ensino na prática, não só na conversa, então você vai precisar ter uma vara de pesca nas mãos se quiser que eu mostre direito.");
        cvFishing3.addOptionText(SPANISH, "¿Puedes enseñarme?", "Sí, puedo. No suelo negarme a enseñar a quien quiere aprender un trabajo honrado. Pero yo enseño con práctica, no solo con palabras, así que necesitarás tener una caña de pescar en las manos si quieres que te lo muestre bien.");

        ConversationOption cvFishing4 = new ConversationOption(8, 0);
        cvFishing4.addOptionText(ENGLISH, "I have a fishing rod.", "Good. Then pay attention. Don't fight the water, read it. Watch the surface, keep the line steady, and don't yank too early when something bites. The sea rewards calm hands more than strong arms.\n<3 hour passes>\nThere. You have the basics now. The rest comes with quiet mornings and a little patience.");
        cvFishing4.addOptionText(PORTUGUESE, "Eu tenho uma vara de pesca.", "Ótimo. Então preste atenção. Não lute contra a água, aprenda a lê-la. Observe a superfície, mantenha a linha firme e não puxe cedo demais quando algo morder. O mar recompensa mais mãos calmas do que braços fortes.\n<Passam-se 3 horas>\nPronto. Agora você já sabe o básico. O resto vem com manhãs silenciosas e um pouco de paciência.");
        cvFishing4.addOptionText(SPANISH, "Tengo una caña de pescar.", "Bien. Entonces presta atención. No luches contra el agua, aprende a leerla. Observa la superficie, mantén la línea firme y no tires demasiado pronto cuando algo muerda. El mar recompensa más las manos tranquilas que los brazos fuertes.\n<Pasan 3 horas>\nListo. Ahora ya conoces lo básico. El resto llega con mañanas silenciosas y un poco de paciencia.");
        cvFishing4.requirementValidations = (chara, ctx) -> {
            if (!chara.hasKnowledge(KnowledgesIds.FISHING)
                    && LibInventory.checkHasItemAmount(ItemsIds.FISHING_ROD, 1, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvFishing4.listeners = (ctx, currentFragment) -> {
            App.Shell.flowManager.updateInGameTime(180, false, ctx);
            App.getPlayerChar().addKnowledge(App.DataManager.getKnowledge(KnowledgesIds.FISHING));
            GameEngine.saveGame(ctx);
            String knowledgeTanslate = LibUtils.translate(FISHING.name(), ctx);
            new Handler().postDelayed(() -> LibUtils.showToast(LibUtils.getString("YouLearnedKnowledge", knowledgeTanslate, ctx), 0, CoreEnums.MessageType.INFO, ctx), 400);
        };

        ConversationOption cvFishing5 = new ConversationOption(8, 0);
        cvFishing5.addOptionText(ENGLISH, "I'll come back later to learn.", "Fine. Come back when you have a fishing rod. Without one, all I can give you is talk, and talk won't catch you a single fish.");
        cvFishing5.addOptionText(PORTUGUESE, "Volto mais tarde para aprender.", "Tudo bem. Volte quando tiver uma vara de pesca. Sem isso, tudo o que posso te dar é conversa, e conversa nenhuma põe peixe no anzol.");
        cvFishing5.addOptionText(SPANISH, "Volveré más tarde para aprender.", "Está bien. Vuelve quando tengas uma caña de pescar. Sin eso, lo único que puedo darte es charla, y la charla no pone ningún pez en el anzuelo.");
        cvFishing5.requirementValidations = (chara, ctx) -> {
            if (!chara.hasKnowledge(KnowledgesIds.FISHING)
                    && !LibInventory.checkHasItemAmount(ItemsIds.FISHING_ROD, 1, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What can you tell about you?", "I can say only that you can call me Joggard, I work here in the harbor, carrying crates and goods, that is all for now.");
        cv1.addOptionText(PORTUGUESE, "O que você pode contar sobre você?", "Só posso dizer que podem me chamar de Joggard, eu trabalho aqui no porto, carregando caixas e mercadorias, isso é tudo por enquanto.");
        cv1.addOptionText(SPANISH, "¿Qué puedes contar de ti?", "Solo puedo decir que podéis llamarme Joggard, trabajo aquí en el puerto, transportando cajas y mercancías, eso es todo por ahora.");

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Where do you live?", "Why it is important to you? I live somewhere.");
        cv2.addOptionText(PORTUGUESE, "Onde você mora?", "Por que é importante para você? Eu moro em algum lugar.");
        cv2.addOptionText(SPANISH, "¿Dónde vive?", "¿Por qué es importante para ti? Vivo en algún lugar.");
        cv2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.MILITIA_TASKS)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
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
        npc.conversationOptions.add(cvRaidingOrcsQustPart2);
        npc.conversationOptions.add(cv16);
        npc.conversationOptions.add(cv17);
        npc.conversationOptions.add(cv18);
        npc.conversationOptions.add(cv19);
        npc.conversationOptions.add(cv20);
        npc.conversationOptions.add(cv21);
        npc.conversationOptions.add(cv22);
        npc.conversationOptions.add(cv23);
        npc.conversationOptions.add(cv24);
        npc.conversationOptions.add(cv25);
        npc.conversationOptions.add(cvRoleplay1);
        npc.conversationOptions.add(cvRoleplay2);
        npc.conversationOptions.add(cvRoleplay3);
        npc.conversationOptions.add(cv1);
        npc.conversationOptions.add(cv2);
        npc.conversationOptions.add(cvFishing1);
        npc.conversationOptions.add(cvFishing2);
        npc.conversationOptions.add(cvFishing3);
        npc.conversationOptions.add(cvFishing4);
        npc.conversationOptions.add(cvFishing5);

        // ========================================
        // QUEST: AWAITING THE DRAGONS
        // ========================================

        // Part 5: Talk to Joggard
        ConversationOption cvAwaitingDragons5 = new ConversationOption(0, 0);
        cvAwaitingDragons5.addOptionText(ENGLISH, "Murdag sent me to pick up a weapon shipment.",
                "Ah, right. The counselor's message arrived just ahead of you. We've been holding this crate for the barracks. It's heavy, so watch your back. \n\n*He signals to his men to bring out a sturdy wooden crate*\n\nHere it is. Take this to Lenny at the barracks. He's expecting it.");
        cvAwaitingDragons5.addOptionText(PORTUGUESE, "Murdag me enviou para buscar uma remessa de armas.",
                "Ah, certo. A mensagem do conselheiro chegou logo antes de você. Estávamos guardando esta caixa para o quartel. É pesada, então cuidado com as costas. \n\n*Ele sinaliza para seus homens trazerem uma caixa de madeira resistente*\n\nAqui está. Leve isso para Lenny no quartel. Ele está esperando.");
        cvAwaitingDragons5.addOptionText(SPANISH, "Murdag me envió a recoger un cargamento de armas.",
                "Ah, cierto. El mensaje del consejero llegó justo antes que tú. Hemos estado guardando esta caja para el cuartel. Es pesada, así que cuida tu espalda. \n\n*Hace una señal a sus hombres para que saquen una robusta caja de madera*\n\nAquí tienes. Llévale esto a Lenny al cuartel. Él lo está esperando.");
        cvAwaitingDragons5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.AWAITING_THE_DRAGONS, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvAwaitingDragons5.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.CRATE_OF_WEAPONS, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.AWAITING_THE_DRAGONS, 6, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvAwaitingDragons5);

        return npc;
    }
}

