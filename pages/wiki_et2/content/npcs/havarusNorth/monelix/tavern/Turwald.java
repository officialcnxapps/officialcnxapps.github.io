package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.tavern;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.events.QuestBrantsFalkersEvents.BRANT_FALKER_BAR_FIGHT_EVENT_SWITCH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.BRANTS_FALKERS;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Variable;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Turwald extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, turwald());
    }

    Npc turwald() {
        Npc npc = new Npc("Turwald");
        npc.age = 45;
        npc.job = Enums.NPCJobs.MALE_COOK;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Fun-loving, he doesn't usually take many things seriously.\nHe knows many stories and enjoys gossip.\nHe never turns down a moment of rest and drinks.\n\nHis physical traits: Bald, eccentric mustache. Mischievous smile. Large nose and ears. Dark eyes.");
        npc.addDescriptionTranslation(PORTUGUESE, "Divertido, não costuma levar muitas coisas a sério.\nConhece diversas histórias, gosta de fofocas.\nNão recusa um momento de descanso e bebidas.\n\nSeus traços físicos: Careca, bigode excêntrico. Sorriso maroto. Nariz e orelhas avantajados. Olhos escuros.");
        npc.addDescriptionTranslation(SPANISH, "Divertido, no suele tomarse muchas cosas en serio.\nConoce diversas historias y le gustan los chismes.\nNunca rechaza un momento de descanso y bebidas.\n\nSus rasgos físicos: Calvo, bigote excéntrico. Sonrisa pilla. Nariz y orejas grandes. Ojos oscuros.");

        // Greetings messages
        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Ah, [GENDER_SIMPLE_CALL]! Greetings!"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Ah, [GENDER_SIMPLE_CALL]! Olá!"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("¡Ah, [GENDER_SIMPLE_CALL]! Hola!"));

        // Bye messages
        npc.byeMessages.put(ENGLISH, Collections.singletonList("Cheers, [GENDER_SIMPLE_CALL]! Don’t forget to come back for more drinks and stories!"));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Saúde, [GENDER_SIMPLE_CALL]! Não se esqueça de voltar para mais bebidas e histórias!"));
        npc.byeMessages.put(SPANISH, Collections.singletonList("¡Salud, [GENDER_SIMPLE_CALL]! ¡No olvides volver por más bebidas e historias!"));

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What’s your favorite drink?", "Ah, nothing beats a cold Monelix Stout! It’s rich, dark, and perfect after a long day. I’ve been drinking it for years!");
        cv1.addOptionText(PORTUGUESE, "Qual é a sua bebida favorita?", "Ah, nada supera um Monelix Stout gelado! É rico, escuro e perfeito depois de um longo dia. Eu bebo isso há anos!");
        cv1.addOptionText(SPANISH, "¿Cuál es tu bebida favorita?", "¡Ah, nada supera una Monelix Stout fría! Es rica, oscura y perfecta después de un largo día. ¡La he estado bebiendo durante años!");
        npc.conversationOptions.add(cv1);

        ConversationOption cv3 = new ConversationOption(0, 0);
        cv3.addOptionText(ENGLISH, "Why do you love beer so much?", "Beer? It's the lifeblood of the tavern! It brings people together, warms the soul, and makes even the dullest stories sound interesting. Plus, it's delicious!");
        cv3.addOptionText(PORTUGUESE, "Por que você ama tanto cerveja?", "Cerveja? É a alma da taverna! Ela une as pessoas, aquece a alma e faz até as histórias mais chatas parecerem interessantes. Além disso, é deliciosa!");
        cv3.addOptionText(SPANISH, "¿Por qué amas tanto la cerveza?", "¿Cerveza? ¡Es el alma de la taberna! Une a las personas, calienta el alma y hace que incluso las historias más aburridas suenen interesantes. ¡Además, es deliciosa!");
        npc.conversationOptions.add(cv3);

        ConversationOption cv0 = new ConversationOption(0, 0);
        cv0.addOptionText(ENGLISH, "Someone interesting passed here?", "My friend, [GENDER_SIMPLE_CALL], every day people come and go in this tavern. But, recently, that traveling and adventurous citizen, who would say, almost crazy, Martin, was drinking here.\nWell, he really likes climbing, and is good at what he does! I heard he teaches whoever wants to climb anything that is like a mountain. I don't want, imagine the danger!\nHe is now over at Great Rock.");
        cv0.addOptionText(PORTUGUESE, "Alguém interessante passou por aqui?", "Meu caro, [GENDER_SIMPLE_CALL], todos os dias pessoas vem e vão nesta taberna. Mas, recentemente, aquele cidadão viajante e aventureiro, diria até meio louco, o tal de Martin, esteve bebendo aqui.\nSabe, ele gosta mesmo de escalar, e é bom no que faz! Ouvi dizer que ele ensina quem quiser a escalar tudo que é tipo de montanha. Eu não quero, imagina o perigo!\nEle está lá pros lados de Great Rock agora.");
        cv0.addOptionText(SPANISH, "¿Ha pasado por aquí alguien interesante?", "Mi amigo, [GENDER_SIMPLE_CALL], todos los días las personas vienen y van en esta taberna. Pero, recientemente, ese ciudadano viajante y aventurero, diría hasta medio loco, Martin, estaba bebiendo aquí.\nBueno, él realmente le gusta escalar, y es bueno en lo que hace. Oí que enseña a quien quiera escalar todo lo que es tipo de montaña. No quiero, imagina el peligro.\nAhora está en el lado grande de Great Rock.");
        npc.conversationOptions.add(cv0);

        // ===== ROLEPLAY: Brigas de bar — Famílias nobres (sem quest) =====
        ConversationOption cvBarBrawl = new ConversationOption(0, 0);
        cvBarBrawl.addOptionText(ENGLISH,
                "Do fights break out in taverns around here often?",
                "*chuckles and polishes a mug*\nMore often than I'd like. It's not unusual at all — especially when members of two powerful noble families happen to be drinking under the same roof. I won't name names, but their grudge goes back a long way. If you come here frequently enough... there's a fair chance you'll see the tension boil over right in front of you.");
        cvBarBrawl.addOptionText(PORTUGUESE,
                "As brigas de bar acontecem com frequência por aqui?",
                "*ri e limpa uma caneca*\nMais do que eu gostaria. Não é nada incomum — especialmente quando membros de duas famílias nobres poderosas se encontram bebendo sob o mesmo teto. Não vou citar nomes, mas a rixa entre eles vem de longa data. Se você vier aqui com frequência... tem uma boa chance de ver a tensão explodir bem na sua frente.");
        cvBarBrawl.addOptionText(SPANISH,
                "¿Las peleas de taberna son frecuentes por aquí?",
                "*ríe y pule un vaso*\nMás de lo que me gustaría. No es nada inusual — especialmente cuando miembros de dos poderosas familias nobles se encuentran bebiendo bajo el mismo techo. No voy a mencionar nombres, pero su rencor viene de lejos. Si vienes por aquí con frecuencia... hay bastantes posibilidades de ver la tensión estallar justo delante de ti.");
        cvBarBrawl.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(BRANTS_FALKERS, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvBarBrawl);

        ConversationOption cv2 = new ConversationOption(0, 1);
        cv2.addOptionText(ENGLISH, "What happened here? that bar fight...", "Well, Brants and Falkers, you know... those two families have problems for years.");
        cv2.addOptionText(PORTUGUESE, "O que aconteceu aqui? Aquela briga de bar...", "Bem, Brants e Falkers, você sabe... essas duas famílias têm problemas há anos.");
        cv2.addOptionText(SPANISH, "¿Qué pasó aquí? Esa pelea de taberna...", "Bueno, Brants y Falkers, ya sabes... esas dos familias tienen problemas desde hace años.");
        cv2.requirementValidations = (chara, ctx) -> {
            Variable eventVar = App.getPlayerCharVariable(Enums.GameplayVariables.EVENTS);
            Boolean switchActive = eventVar.getSwitchValue(BRANT_FALKER_BAR_FIGHT_EVENT_SWITCH);

            if (chara != null && (switchActive != null && switchActive) && !LibQuest.charHasQuest(BRANTS_FALKERS, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv2);

        ConversationOption cv4 = new ConversationOption(1, 2);
        cv4.addOptionText(ENGLISH, "Brants and Falkers? Tell me more.", "So, you are not from here, right? Because everybody knows them.\nTwo powerful families, the Brants and the Falkers, have long been at odds. It all began when Sir Martyn Brant, advisor to King Oriun, ordered the construction of a prison on lands that belonged to Lord Den Falker. An affront, don't you think?\nBut in return, Lord Den was given lands in the north, where he founded a village. Many say it was a fair deal, despite those lands being terrible for planting. But... some say it was revenge for something much more personal.\n<He leans closer and lowers his voice>\nThey say that Lord Den had promised his daughter, Lady Lara, to Sir Martyn's son, Sir Jard Brant. But the girl didn't want to marry. She didn't like Jard, she thought he was arrogant, a womanizer... and she asked her father to cancel the marriage. And what happened next? Ah... Well, it depends on what you want to know first.");
        cv4.addOptionText(PORTUGUESE, "Brants e Falkers? Conte-me mais.", "Então, você não é daqui, certo? Porque todo mundo os conhece.\nDuas famílias poderosas, os Brant e os Falker, há muito tempo vivem em desavença. Tudo começou quando Sir Martyn Brant, conselheiro do rei Oriun, ordenou a construção de uma prisão em terras que pertenciam a Lorde Den Falker. Uma afronta, não acha?\nMas, como compensação, Lorde Den recebeu terras no norte, onde fundou um vilarejo. Muitos dizem que foi um acordo justo, apesar daquelas terras serem péssimas para plantio. Mas... há quem diga que foi vingança por algo bem mais pessoal.\n<Ele se inclina para mais perto e baixa a voz>\nDizem que Lorde Den havia prometido sua filha, Lady Lara, ao filho de Sir Martyn, Sir Jard Brant. Mas a moça não queria se casar. Não gostava de Jard, o achava arrogante, um mulherengo... e pediu ao pai que cancelasse o casamento. E o que aconteceu depois? Ah... Bem, depende do que deseja saber primeiro.");
        cv4.addOptionText(SPANISH, "¿Brants y Falkers? Cuéntame más.", "Entonces, no eres de aquí, ¿verdad? Porque todo el mundo los conoce.\nDos familias poderosas, los Brant y los Falker, han estado en desacuerdo durante mucho tiempo. Todo comenzó cuando Sir Martyn Brant, asesor del rey Oriun, ordenó la construcción de una prisión en tierras que pertenecían a Lord Den Falker. Una afrenta, ¿no crees?\nPero, a cambio, Lord Den recibió tierras en el norte, donde fundó un pueblo. Muchos dicen que fue un trato justo, a pesar de que esas tierras eran terribles para la siembra. Pero... algunos dicen que fue una venganza por algo mucho más personal.\n<Se inclina más cerca y baja la voz>\nDicen que Lord Den había prometido a su hija, Lady Lara, al hijo de Sir Martyn, Sir Jard Brant. Pero la chica no quería casarse. No le gustaba Jard, lo consideraba arrogante, un mujeriego... y le pidió a su padre que cancelara el matrimonio. ¿Y qué pasó después? Ah... Bueno, depende de lo que quieras saber primero.");
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(2, 2);
        cv5.addOptionText(ENGLISH, "I want to know more about Lady Lara Falker.", "Ah, Lady Lara... A determined young woman, that's for sure. She refused to marry Sir Jard, even knowing it could put her family at risk. They say her father, Lord Den, loved her too much to force her into an unhappy marriage. He preferred to face the wrath of the Brants than to see his daughter suffer. But that decision came at a high cost... a very high cost.\nIf you want to know what happened next, you need to ask Lord Den Falker... if he's still alive.");
        cv5.addOptionText(PORTUGUESE, "Quero saber mais sobre Lady Lara Falker.", "Ah, Lady Lara... Uma jovem determinada, isso é certo. Ela se recusou a casar com Sir Jard, mesmo sabendo que poderia colocar sua família em risco. Dizem que seu pai, Lorde Den, a amava demais para forçá-la a um casamento infeliz. Ele preferiu enfrentar a ira dos Brant do que ver sua filha sofrer. Mas essa decisão custou caro... muito caro.\nSe quiser saber o que aconteceu depois, precisa perguntar a Lorde Den Falker... se ele ainda estiver vivo.");
        cv5.addOptionText(SPANISH, "Quiero saber más sobre Lady Lara Falker.", "Ah, Lady Lara... Una joven decidida, eso es seguro. Se negó a casarse con Sir Jard, a sabiendas de que podría poner a su familia en riesgo. Dicen que su padre, Lord Den, la amaba demasiado como para obligarla a un matrimonio infeliz. Prefirió enfrentar la ira de los Brant que ver a su hija sufrir. Pero esa decisión costó cara... muy cara.\nSi quieres saber qué pasó después, necesitas preguntarle a Lord Den Falker... si todavía está vivo.");
        npc.conversationOptions.add(cv5);

        ConversationOption cv6 = new ConversationOption(2, 2);
        cv6.addOptionText(ENGLISH, "And Sir Jard Brant? Did he really love her?", "Sir Jard Brant always claimed that he loved Lady Lara. But was it love or just a desire to fulfill his father's plan? After all, if the marriage had taken place, the two families would have become powerful, and perhaps the war would never have happened. When Lady Lara refused the marriage, Sir Jard felt betrayed. His father died in battle, and he never forgave the Falkers for that.\nIf you want to hear his side of the story, you might find him in Monelix. But be careful... the Brants don't forget easily.");
        cv6.addOptionText(PORTUGUESE, "E Sir Jard Brant? Ele realmente a amava?", "Sir Jard Brant sempre afirmou que amava Lady Lara. Mas será que era amor ou apenas um desejo de cumprir o plano de seu pai? Afinal, se o casamento ocorresse, as duas famílias se tornariam poderosas, e talvez a guerra nunca tivesse acontecido. Quando Lady Lara recusou o matrimônio, Sir Jard sentiu-se traído. Seu pai morreu em batalha, e ele nunca perdoou os Falker por isso.\nSe quiser ouvir o lado dele da história, talvez o encontre em Monelix. Mas tome cuidado... os Brant não esquecem facilmente.");
        cv6.addOptionText(SPANISH, "¿Y Sir Jard Brant? ¿Realmente la amaba?", "Sir Jard Brant siempre afirmó que amaba a Lady Lara. Pero, ¿era amor o solo un deseo de cumplir el plan de su padre? Después de todo, si el matrimonio hubiera tenido lugar, las dos familias se habrían vuelto poderosas, y tal vez la guerra nunca habría ocurrido. Cuando Lady Lara rechazó el matrimonio, Sir Jard se sintió traicionado. Su padre murió en batalla, y nunca perdonó a los Falker por eso.\nSi quieres escuchar su versión de la historia, tal vez lo encuentres en Monelix. Pero ten cuidado... los Brant no olvidan fácilmente.");
        npc.conversationOptions.add(cv6);

        ConversationOption cv7 = new ConversationOption(2, 3);
        cv7.addOptionText(ENGLISH, "What happened to the two families?", "Ah... this story didn't end well for anyone. With the marriage called off, Helera became enraged and started a war against Monelix. It was a short but bloody conflict. In the end, they reached an agreement: Helera accepted peace but demanded a larger share of the taxes. However, the resentment between the families never disappeared. The Brants still blame the Falkers for the death of Sir Martyn, and the Falkers believe the Brants are manipulative and cruel.\nIf you want to get involved in this fight... well, choose your side wisely. In stories like this, there are no heroes. Only survivors.");
        cv7.addOptionText(PORTUGUESE, "O que aconteceu com as duas famílias?", "Ah... essa história não terminou bem para ninguém. Com o casamento desfeito, Helera se enfureceu e iniciou uma guerra contra Monelix. Foi um conflito curto, mas sangrento. No fim, chegaram a um acordo: Helera aceitou a paz, mas exigiu uma fatia maior dos impostos. Porém, o rancor entre as famílias nunca desapareceu. Os Brant ainda culpam os Falker pela morte de Sir Martyn, e os Falker acreditam que os Brant são manipuladores e cruéis.\nSe quiser se envolver nessa briga... bem, escolha seu lado com sabedoria. Em histórias como essa, não há heróis. Apenas sobreviventes.");
        cv7.addOptionText(SPANISH, "¿Qué pasó con las dos familias?", "Ah... esta historia no terminó bien para nadie. Con el matrimonio cancelado, Helera se enfureció y comenzó una guerra contra Monelix. Fue un conflicto corto pero sangriento. Al final, llegaron a un acuerdo: Helera aceptó la paz, pero exigió una mayor parte de los impuestos. Sin embargo, el resentimiento entre las familias nunca desapareció. Los Brant todavía culpan a los Falker por la muerte de Sir Martyn, y los Falker creen que los Brant son manipuladores y crueles.\nSi quieres involucrarte en esta pelea... bueno, elige tu lado con sabiduría. En historias como esta, no hay héroes. Solo sobrevivientes.");
        npc.conversationOptions.add(cv7);

        ConversationOption cv8 = new ConversationOption(3, 0);
        cv8.addOptionText(ENGLISH, "Very interesting, I think I'll get involved in this.", "It doesn't seem like a wise decision, this story has been going on for years... But if you want to, then talk to them. Lady Lara lives in Helera today. Lord Den is on his lands, Letow. As for Sir Jard, he lives well in Monelix.");
        cv8.addOptionText(PORTUGUESE, "Muito interessante, acho que vou me envolver nisso.", "Não parece uma decisão sábia, essa história está aí fazem anos... Mas, se quiser, fale então com eles, Lady Lara vive hoje em Helera. Lorde Den está em suas terras, Letow. Já Sir Jard vive bem em Monelix.");
        cv8.addOptionText(SPANISH, "Muy interesante, creo que me involucraré en esto.", "No parece una decisión sabia, esta historia lleva años... Pero si quieres, entonces habla con ellos. Lady Lara vive hoy en Helera. Lord Den está en sus tierras, Letow. En cuanto a Sir Jard, vive bien en Monelix.");
        npc.conversationOptions.add(cv8);
        cv8.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(BRANTS_FALKERS, App.getPlayerChar(), ctx);
        };

        return npc;
    }
}
