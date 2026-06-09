package com.cnx.endlesstalestwo.data.npcs.lisport.Harbor;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.LikeADetective;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Olga extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Olga");
        npc.age = 43;
        npc.job = Enums.NPCJobs.MILITIAWOMAN;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A woman with as much bravery as any man. Firm and strong in what she does.\nMilitiawoman, raised by her father and with apparent passion for Joggard.\nWary, dedicated and serious.\n\nPhysical traits: Nordic features. Very light eyes, long hair, blonde and braided. Some wrinkles beginning to show on her face.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma mulher com tanta bravura quanto qualquer homem. Firme e forte no que faz.\nMiliciana, criada pelo pai e com aparente paixão por Joggard.\nDesconfiada, dedicada e séria.\n\nSeus taços físicos: Traços nórdicos. Olhos bem claros, cabelos comprido, loiro e trançado. Algumas rugas começam a se notar no rosto.");
        npc.addDescriptionTranslation(SPANISH, "Una mujer con tanta valentía como cualquier hombre. Firme y fuerte en lo que hace.\nMujer miliciana, criada por su padre con aparente pasión por Joggard.\nDesconfiada, dedicada y seria.\n\nTrasos físicos: Características nórdicas. Ojos muy claros, cabello largo, rubio y trenzado. Algunas arrugas comienzan a notarse en su rostro.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hello to you."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá para você"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola a ti."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Bye bye, [GENDER_SIMPLE_CALL]"));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Tchau, [GENDER_SIMPLE_CALL]"));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Adiós, [GENDER_SIMPLE_CALL]"));

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "May I know you better?", "would you be trying to court me?\nBut anyway, I am Olga, I have been working in the harbor for the last 18 years, my dad got this job for me. I like it because I can see the sea everyday, it is great.");
        cv1.addOptionText(PORTUGUESE, "Posso conhecê-la melhor?", "Você estaria tentando me cortejar?\nMas de qualquer forma, eu sou Olga, trabalho no porto há 18 anos, meu pai conseguiu esse emprego para mim. Eu gosto porque posso ver o mar todos os dias, é ótimo.");
        cv1.addOptionText(SPANISH, "¿Puedo conocerte mejor?", "¿Estarías tratando de cortejarme?\nPero bueno, soy Olga, trabajo en el puerto desde hace 18 años, mi padre me consiguió este trabajo. Me gusta porque puedo ver el mar todos los días, es genial.");

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Are you the militia leader?", "Militia? No, you are crazy?");
        cv2.addOptionText(PORTUGUESE, "Você é o líder da milícia?", "Milícia? Não, você é louco?");
        cv2.addOptionText(SPANISH, "¿Eres el líder de la milicia?", "¿Milicia? ¿No, estás loca?");
        cv2.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.LOOKING_FOR_A_GUILD);
            if (requiredQuest != null && (requiredQuest.getCurrentPartOrder() == 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv3 = new ConversationOption(0, 0);
        cv3.addOptionText(ENGLISH, "I know, you work for the militia. Joggard told me that you can help me.", "Well, well, my dirty little secret. I believe he wants me to give you your first tasks, right?\nSo, we are an independent group, nobody gives us money, so we get our things ourselves. You will help me with this. Start by fishing, we need food.\nJoggard can give you a fishing rod, if he approves.");
        cv3.addOptionText(PORTUGUESE, "Eu sei, você trabalha para a milícia. Joggard me disse que você pode me ajudar.", "Bem, bem, meu segredinho sujo. Acredito que ele quer que eu lhe dê suas primeiras tarefas, certo?\nEntão, somos um grupo independente, ninguém nos dá dinheiro, então pegamos nossas coisas nós mesmos. Você vai me ajudar com isso. Comece pescando, precisamos de comida.\nJoggard pode lhe dar uma vara de pescar, se ele aprovar.");
        cv3.addOptionText(SPANISH, "Ya lo sé, trabajas para la milicia. Joggard me dijo que puedes ayudarme.", "Bueno, bueno, mi pequeño secreto sucio. Creo que quiere que te dé tus primeras tareas, ¿no?\nEntonces, somos un grupo independiente, nadie nos da dinero, así que conseguimos nuestras cosas nosotros mismos. Me ayudarás con esto. Comienza pescando, necesitamos comida.\nJoggard puede darte una caña de pescar, si lo aprueba.");
        cv3.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.MILITIA_TASKS);
            if (requiredQuest != null && (requiredQuest.getCurrentPartOrder() == 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv3.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.MILITIA_TASKS);
            LibQuest.updateQuest(quest, 2, App.getPlayerChar(), ctx);
        };

        ConversationOption cv4 = new ConversationOption(0, 1);
        cv4.addOptionText(ENGLISH, "Why you choose the militia?", "My dad, Olgson, started the militia many years ago. He did not approve the taxes and the laws of Lisport, but he never fought with weapons against them, my father always preferred peace. So, he came to the harbor to work and recruited some like-minded people. Yes, They did some sabotages, but they also lived well and free.\nJoggard is now our leader, I manage our routine.");
        cv4.addOptionText(PORTUGUESE, "Por que você escolheu a milícia?", "Meu pai, Olgson, começou a milícia há muitos anos. Ele não aprovava os impostos e as leis de Lisport, mas nunca lutou com armas contra eles, meu pai sempre preferiu a paz. Então, ele veio ao porto para trabalhar e recrutou algumas pessoas com ideias semelhantes. Sim, eles fizeram algumas sabotagens, mas também viveram bem e livres.\nJoggard agora é nosso líder, eu administro nossa rotina.");
        cv4.addOptionText(SPANISH, "¿Por qué elegiste la milicia?", "Mi padre, Olgson, fundó la milicia hace muchos años. No aprobaba los impuestos ni las leyes de Lisport, pero nunca luchó con armas contra ellos; mi padre siempre prefirió la paz. Así que vino al puerto a trabajar y reclutó a algunas personas con ideas afines. Sí, hicieron algunos sabotajes, pero también vivieron bien y en libertad.\nJoggard es ahora nuestro líder, yo gestiono nuestra rutina.");
        cv4.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.MILITIA_TASKS);
            if (requiredQuest != null && (requiredQuest.getCurrentPartOrder() >= 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv5 = new ConversationOption(1, 0);
        cv5.addOptionText(ENGLISH, "And the orcs?", "Argh, they are a danger to us. The establish their hamlet a lot of years ago and since then they attack and steal our goods and ships. We are preparing to attack they because they are weak now, after the attack they did in Lisport.");
        cv5.addOptionText(PORTUGUESE, "E os orcs?", "Argh, eles são um perigo para nós. Eles estabeleceram seu vilarejo há muitos anos e desde então eles atacam e roubam nossos bens e navios. Estamos nos preparando para atacá-los porque eles estão fracos agora, depois do ataque que fizeram em Lisport.");
        cv5.addOptionText(SPANISH, "¿Y los orcos?", "Argh, son un peligro para nosotros. Establecieron su aldea hace muchos años y desde entonces atacan y roban nuestros bienes y barcos. Nos estamos preparando para atacarlos porque ahora están débiles, después del ataque que realizaron en Lisport.");

        ConversationOption cv6 = new ConversationOption(0, 0);
        cv6.addOptionText(ENGLISH, "I have the fishes.", "Good, good. Now, [GENDER_SIMPLE_CALL], I expect that you don't think we are finished. We need weapons, we forge ourselves, but we need ore. To be exactly, 4 iron ores will be enough.");
        cv6.addOptionText(PORTUGUESE, "Eu tenho os peixes.", "Bom, bom. Agora, [GENDER_SIMPLE_CALL], imagino que você não pense que terminamos. Precisamos de armas, nós nos forjamos, mas precisamos de minério. Para ser exato, 4 minérios de ferro serão o suficiente.");
        cv6.addOptionText(SPANISH, "Yo tengo los peces.", "Bien, bien. Ahora, [GENDER_SIMPLE_CALL], supongo que no crees que hemos terminado. Necesitamos armas, las forjamos nosotros mismos, pero necesitamos minerales. Para ser exactos, 4 minerales de hierro serán suficientes.");
        cv6.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.MILITIA_TASKS);
            int itemAmount1 = LibInventory.howMuchItemHave(ItemsIds.TUNA, App.getPlayerChar());
            int itemAmount2 = LibInventory.howMuchItemHave(ItemsIds.SARDINE, App.getPlayerChar());
            boolean hasItems = itemAmount1 + itemAmount2 >= 5;

            if (requiredQuest == null || requiredQuest.getCurrentPartOrder() != 2) {
                return Enums.RequirementVerification.NOT_OK;
            } else if (!hasItems) {
                return Enums.RequirementVerification.NEED_ITEMS;
            }
            return Enums.RequirementVerification.OK;
        };
        cv6.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.MILITIA_TASKS);
            int removed = LibInventory.removeManyFromInventory(ItemsIds.SARDINE, 5, App.getPlayerChar());
            if (removed < 5) {
                LibInventory.removeFromInventory(ItemsIds.TUNA, 5 - removed, App.getPlayerChar());
            }
            LibQuest.updateQuest(quest, 3, App.getPlayerChar(), ctx);
        };

        ConversationOption cv7 = new ConversationOption(0, 0);
        cv7.addOptionText(ENGLISH, "I have the iron ores.", "Great, I am starting to like you, [PLAYERNAME].\nThe last thing I want your help is with wood. We need to craft spears, weapons and shields, so, please, get to us, 5 logs.");
        cv7.addOptionText(PORTUGUESE, "Eu tenho os minérios de ferro.", "Ótimo, estou começando a gostar de você, [PLAYERNAME].\nA última coisa que quero da sua ajuda é com madeira. Precisamos criar lanças, armas e escudos, então, por favor, traga até nós, 5 troncos.");
        cv7.addOptionText(SPANISH, "Tengo los minerales de hierro.", "Genial, me estás empezando a caer bien, [PLAYERNAME].\nLo último que quiero es que me ayudes con la madera. Necesitamos fabricar lanzas, armas y escudos, así que, por favor, tráenos 5 troncos.");
        cv7.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = chara.getQuest(QuestsIds.MILITIA_TASKS);
            boolean hasItems = LibInventory.checkHasItemAmount(ItemsIds.IRON_ORE, 4, chara);

            if (requiredQuest == null || requiredQuest.getCurrentPartOrder() != 3) {
                return Enums.RequirementVerification.NOT_OK;
            } else if (!hasItems) {
                return Enums.RequirementVerification.NEED_ITEMS;
            }
            return Enums.RequirementVerification.OK;
        };
        cv7.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.MILITIA_TASKS);
            LibInventory.removeFromInventory(ItemsIds.IRON_ORE, 4, App.getPlayerChar());
            LibQuest.updateQuest(quest, 4, App.getPlayerChar(), ctx);
        };

        ConversationOption cv8 = new ConversationOption(0, 0);
        cv8.addOptionText(ENGLISH, "The wooden logs are here.", "Thank you, [PLAYERNAME].\nYou helped a lot. I think we have everything for now. Please, go tell Joggard about this.");
        cv8.addOptionText(PORTUGUESE, "Os troncos de madeira estão aqui.", "Obrigado, [PLAYERNAME].\nVocê ajudou muito. Acho que temos tudo por enquanto. Por favor, vá contar isso ao Joggard.");
        cv8.addOptionText(SPANISH, "Los troncos de madera están aquí.", "Gracias, [PLAYERNAME].\nMe ayudaste mucho. Creo que lo tenemos todo por ahora. Por favor, ve a contarle esto a Joggard.");
        cv8.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = chara.getQuest(QuestsIds.MILITIA_TASKS);
            boolean hasItems = LibInventory.checkHasItemAmount(ItemsIds.LOG, 4, chara);

            if (requiredQuest == null || requiredQuest.getCurrentPartOrder() != 4) {
                return Enums.RequirementVerification.NOT_OK;
            } else if (!hasItems) {
                return Enums.RequirementVerification.NEED_ITEMS;
            }
            return Enums.RequirementVerification.OK;
        };
        cv8.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.MILITIA_TASKS);
            LibInventory.removeFromInventory(ItemsIds.LOG, 4, App.getPlayerChar());
            LibQuest.updateQuest(quest, 5, App.getPlayerChar(), ctx);
        };

        ConversationOption cv9 = new ConversationOption(0, 0);
        cv9.addOptionText(ENGLISH, "We made it, orcs will never bother anymore.", "Yes, finally we are free from their danger. But the militia will still here, we have our 'jobs' to do.");
        cv9.addOptionText(PORTUGUESE, "Conseguimos, os orcs nunca mais nos incomodarão.", "Sim, finalmente estamos livres do perigo deles. Mas a milícia ainda estará aqui, temos nossos \"trabalhos\" a fazer.");
        cv9.addOptionText(SPANISH, "Lo logramos, los orcos nunca volverán a molestarnos.", "Sí, finalmente nos hemos librado de su peligro. Pero la milicia seguirá aquí, nosotros tenemos nuestro \"trabajo\" que hacer.");
        cv9.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.RAIDING_THE_ORCS);
            if (requiredQuest != null && requiredQuest.isComplete()) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv10 = new ConversationOption(0, 0);
        cv10.addOptionText(ENGLISH, "Do you think we can defeat the orcs?", "Yes, I have this conviction. Paulson watched them a lot, he knows how to deal with them. The strategy is good and now we also have you to help, the more the merrier.");
        cv10.addOptionText(PORTUGUESE, "Acha que vamos conseguir vencer os orcs?", "Sim, tenho essa convicção. Paulson os observou bastante, sabe como lidar com eles. A estratégia é boa e agora também temos você para ajudar, quanto mais melhor.");
        cv10.addOptionText(SPANISH, "¿Crees que podemos vencer a los orcos?", "Sí, tengo esa convicción. Paulson los observó mucho, sabe cómo lidiar con ellos. La estrategia es buena y ahora también te tenemos a ti para ayudar, cuantos más, mejor.");
        cv10.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.RAIDING_THE_ORCS, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv11 = new ConversationOption(0, 0);
        cv11.addOptionText(ENGLISH, "What can you tell me about Rawer?", "Rawer, the doctor?\nWell, he lives in a beautiful house in Lisport, he has been helping our people for some years now, just in exchange for some favors. He will be very useful to save our wounded friend.");
        cv11.addOptionText(PORTUGUESE, "O que pode me dizer sobre Rawer?", "Rawer, o médico?\nBom ele vive numa bela casa em Lisport, já há alguns anos que ele ajuda nosso pessoal em troca apenas de alguns favores. Ele vai ser muito útil para salvar nosso amigo ferido.");
        cv11.addOptionText(SPANISH, "¿Qué puedes decirme sobre Rawer?", "Rawer, ¿el médico?\nBueno, vive en una hermosa casa en Lisport, lleva algunos años ayudando a nuestra gente, solo a cambio de algunos favores. Será muy útil para salvar a nuestro amigo herido.");
        cv11.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.MEDICAL_SUPPORT, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // Roleplay: Após Overseas Recognition (Quest 9) - Apenas se jogador fez Militia Tasks
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "How have things been, Olga?", "Oh, [PLAYERNAME]! Things here are the same as always. The harbor, the sea, the routine.\nI heard you joined the royal army now. Working for the Queen herself... That's quite different from our ways here in the militia. We prefer our independence, you know. But I hope you're doing well.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Como têm sido as coisas, Olga?", "Oh, [PLAYERNAME]! As coisas aqui são as mesmas de sempre. O porto, o mar, a rotina.\nOuvi dizer que você se juntou ao exército real agora. Trabalhando para a própria Rainha... Isso é bem diferente dos nossos jeitos aqui na milícia. Nós preferimos nossa independência, sabe. Mas espero que você esteja bem.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cómo han estado las cosas, Olga?", "¡Oh, [PLAYERNAME]! Las cosas aquí son las mismas de siempre. El puerto, el mar, la rutina.\nEscuché que te uniste al ejército real ahora. Trabajando para la propia Reina... Eso es bastante diferente de nuestras costumbres aquí en la milicia. Preferimos nuestra independencia, ¿sabes? Pero espero que estés bien.");
        cvRoleplay1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.MILITIA_TASKS)
                    && LibQuest.isQuestComplete(chara, QuestsIds.OVERSEAS_RECOGNITION)
                    && !LibQuest.isQuestComplete(chara, QuestsIds.KILL_OCTUMAN)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // Roleplay: Após Destroy the Lair/Kill Octuman (Quest 13) - Apenas se fez Militia Tasks
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Good to see you again, Olga.", "And you too, [PLAYERNAME]. Even here in our little island we hear stories about you. Working for the kingdom now...\nThe militia is doing well. We keep the harbor safe and trade flowing, our own way. It's a quiet life, but we answer to no one. I hope the royal army treats you better than they treat us independent folk.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Que bom ver você de novo, Olga.", "E você também, [PLAYERNAME]. Até aqui em nossa pequena ilha ouvimos histórias sobre você. Trabalhando para o reino agora...\nA milícia está indo bem. Mantemos o porto seguro e o comércio fluindo, do nosso jeito. É uma vida tranquila, mas não respondemos a ninguém. Espero que o exército real te trate melhor do que tratam nós, gente independente.");
        cvRoleplay2.addOptionText(SPANISH, "Qué bueno verte de nuevo, Olga.", "Y a ti también, [PLAYERNAME]. Incluso aquí en nuestra pequeña isla escuchamos historias sobre ti. Trabajando para el reino ahora...\nLa milicia va bien. Mantenemos el puerto seguro y el comercio fluyendo, a nuestra manera. Es una vida tranquila, pero no respondemos ante nadie. Espero que el ejército real te trate mejor de lo que nos trata a nosotros, gente independiente.");
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
        cvRoleplay3.addOptionText(ENGLISH, "Have you heard the news from Havarus?", "About the dark creatures? Yes, sailors bring disturbing tales. Monsters emerging from shadows, villages under attack...\nIt makes me grateful for our simple life here. The worst we face are thieves and drunk sailors. You're dealing with the kingdom's problems now. Stay careful out there, [PLAYERNAME]. Those creatures sound truly dangerous.");
        cvRoleplay3.addOptionText(PORTUGUESE, "Você ouviu as notícias de Havarus?", "Sobre as criaturas das trevas? Sim, marinheiros trazem contos perturbadores. Monstros emergindo das sombras, vilas sob ataque...\nIsso me faz ser grata pela nossa vida simples aqui. O pior que enfrentamos são ladrões e marinheiros bêbados. Você está lidando com os problemas do reino agora. Tome cuidado por lá, [PLAYERNAME]. Essas criaturas parecem verdadeiramente perigosas.");
        cvRoleplay3.addOptionText(SPANISH, "¿Has oído las noticias de Havarus?", "¿Sobre las criaturas oscuras? Sí, los marineros traen historias inquietantes. Monstruos emergiendo de las sombras, aldeas bajo ataque...\nMe hace agradecer nuestra vida sencilla aquí. Lo peor que enfrentamos son ladrones y marineros borrachos. Estás lidiando con los problemas del reino ahora. Ten cuidado por ahí, [PLAYERNAME]. Esas criaturas suenan verdaderamente peligrosas.");
        cvRoleplay3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.MILITIA_TASKS)
                    && LibQuest.isQuestComplete(chara, QuestsIds.GIVING_ORDERS)
                    && !LibQuest.isQuestComplete(chara, QuestsIds.THE_FINAL_BATTLE)) {
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
        npc.conversationOptions.add(cvRoleplay1);
        npc.conversationOptions.add(cvRoleplay2);
        npc.conversationOptions.add(cvRoleplay3);

        // ===== QUEST: New Route - Part 4 (Wealth and Legacy) =====
        ConversationOption cvNewRoute4 = new ConversationOption(0, 12);
        cvNewRoute4.addOptionText(ENGLISH, "A wise elf named Aslatan seeks wisdom about life's meaning.", "*Leans against cargo crates, considering*\nLife's meaning? Hmm, interesting question for a dock worker like me.\n\n*Gestures to the busy harbor*\n\nLook around - ships arriving with goods, merchants trading, families fed because cargo moves through these docks. I've worked here 18 years, and I'll tell you what I've learned: a meaningful life is one that creates prosperity and security for those you love.\n\nMoney isn't everything, but it's not nothing either. When you trade fairly, when you provide for your family, when you build something that lasts - that's legacy. My father got me this job, and someday I'll help my children find their way too. That's meaning - creating opportunity and leaving those after you better off than you found them.\n\nTell Aslatan: meaning comes from building, from trading fairly, from providing. We're not all warriors or priests - some of us make the world work by moving its goods and feeding its people. That's noble too.");
        cvNewRoute4.addOptionText(PORTUGUESE, "Um elfo sábio chamado Aslatan busca sabedoria sobre o significado da vida.", "*Se apoia em caixotes de carga, considerando*\nO significado da vida? Hmm, pergunta interessante para uma trabalhadora de docas como eu.\n\n*Aponta para o porto movimentado*\n\nOlhe ao redor - navios chegando com mercadorias, mercadores comerciando, famílias alimentadas porque a carga se move por essas docas. Trabalho aqui há 18 anos, e vou lhe dizer o que aprendi: uma vida significativa é aquela que cria prosperidade e segurança para aqueles que você ama.\n\nDinheiro não é tudo, mas também não é nada. Quando você comercia justamente, quando provê para sua família, quando constrói algo que dura - isso é legado. Meu pai conseguiu esse emprego para mim, e um dia vou ajudar meus filhos a encontrar seu caminho também. Isso é significado - criar oportunidade e deixar aqueles depois de você em melhor situação do que você os encontrou.\n\nDiga a Aslatan: o significado vem de construir, de comerciar justamente, de prover. Nem todos somos guerreiros ou sacerdotes - alguns de nós fazemos o mundo funcionar movendo suas mercadorias e alimentando seu povo. Isso também é nobre.");
        cvNewRoute4.addOptionText(SPANISH, "Un elfo sabio llamado Aslatan busca sabiduría sobre el significado de la vida.", "*Se apoya en cajas de carga, considerando*\n¿El significado de la vida? Hmm, pregunta interesante para una trabajadora de muelles como yo.\n\n*Señala al puerto ocupado*\n\nMira alrededor - barcos llegando con mercancías, comerciantes negociando, familias alimentadas porque la carga se mueve por estos muelles. He trabajado aquí 18 años, y te diré lo que he aprendido: una vida significativa es aquella que crea prosperidad y seguridad para aquellos que amas.\n\nEl dinero no lo es todo, pero tampoco es nada. Cuando comercias justamente, cuando provees para tu familia, cuando construyes algo que perdura - eso es legado. Mi padre me consiguió este trabajo, y algún día ayudaré a mis hijos a encontrar su camino también. Eso es significado - crear oportunidad y dejar a los que vienen después mejor de lo que los encontraste.\n\nDile a Aslatan: el significado viene de construir, de comerciar justamente, de proveer. No todos somos guerreros o sacerdotes - algunos hacemos que el mundo funcione moviendo sus mercancías y alimentando a su gente. Eso también es noble.");
        cvNewRoute4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SEEKING_WISDOM, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvNewRoute4);

        ConversationOption cvNewRoute4Complete = new ConversationOption(12, 0);
        cvNewRoute4Complete.addOptionText(ENGLISH, "Thank you, Olga.", "No problem! You've gathered wisdom from all corners of the kingdoms now. Return to that wise elf you mentioned - Aslatan, wasn't it? I'm sure he's eager to hear what you've learned. Safe travels!");
        cvNewRoute4Complete.addOptionText(PORTUGUESE, "Obrigado, Olga.", "Sem problemas! Você reuniu sabedoria de todos os cantos dos reinos agora. Retorne para aquele elfo sábio que você mencionou - Aslatan, não era? Tenho certeza que ele está ansioso para ouvir o que você aprendeu. Boa viagem!");
        cvNewRoute4Complete.addOptionText(SPANISH, "Gracias, Olga.", "¡No hay problema! Has reunido sabiduría de todos los rincones de los reinos ahora. Regresa a ese elfo sabio que mencionaste - Aslatan, ¿no era así? Estoy segura de que está ansioso por escuchar lo que aprendiste. ¡Buen viaje!");
        cvNewRoute4Complete.listeners = (ctx, fragment) -> LibQuest.updateQuest(QuestsIds.SEEKING_WISDOM, 5, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvNewRoute4Complete);

        // ========================================
        // QUEST: LIKE A DETECTIVE
        // ========================================

        // Start quest
        ConversationOption cvDetectiveOffer = new ConversationOption(0, 20);
        cvDetectiveOffer.addOptionText(ENGLISH, "You look bothered by something.",
                "*She leans in and lowers her voice*\nI... I have this feeling. There are some people in the kingdom who are up to no good. I can not prove it, but I know it.\nPriest Edward at the church — he always seems nervous. Doctor Rawer... too comfortable with shady individuals. And that man Klaus who fishes at night — who fishes ALL night?\nI need someone to investigate. Discreetly. Would you help me?");
        cvDetectiveOffer.addOptionText(PORTUGUESE, "Algo está lhe incomodando.",
                "*Ela se aproxima e abaixa a voz*\nEu... tenho esse pressentimento. Há algumas pessoas no reino que não estão se comportando direito. Não consigo provar, mas sei que é assim.\nO Padre Edward na igreja — ele sempre parece nervoso. O Médico Rawer... muito confortável com indivíduos duvidosos. E aquele homem Klaus que pesca de noite — quem pesca a NOITE TODA?\nPreciso de alguém para investigar. Discretamente. Você me ajudaria?");
        cvDetectiveOffer.addOptionText(SPANISH, "Algo te está molestando.",
                "*Se inclina y baja la voz*\nYo... tengo esta sensación. Hay algunas personas en el reino que no están haciendo nada bueno. No puedo probarlo, pero lo sé.\nEl Padre Edward en la iglesia — siempre parece nervioso. El Doctor Rawer... demasiado cómodo con individuos sospechosos. Y ese hombre Klaus que pesca de noche — ¿quién pesca TODA la noche?\nNecesito a alguien para investigar. Discretamente. ¿Me ayudarías?");
        cvDetectiveOffer.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.LIKE_A_DETECTIVE, chara)
                    && (LibQuest.isQuestComplete(chara, QuestsIds.MEDICAL_SUPPORT)
                    || LibQuest.isQuestComplete(chara, QuestsIds.COUNTER_ATTACK))) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvDetectiveOffer);

        ConversationOption cvDetectiveAccept = new ConversationOption(20, 0);
        cvDetectiveAccept.addOptionText(ENGLISH, "Sure, I'll investigate. Who first?",
                "Start with Priest Edward at the Lisport Church. Ask him some pointed questions — see if he gives anything away. Report back to me when you are done.");
        cvDetectiveAccept.addOptionText(PORTUGUESE, "Claro, vou investigar. Quem primeiro?",
                "Comece com o Padre Edward na Igreja de Lisport. Faça a ele algumas perguntas diretas — veja se ele revela algo. Me reporte quando terminar.");
        cvDetectiveAccept.addOptionText(SPANISH, "Claro, investigaré. ¿Quién primero?",
                "Empieza con el Padre Edward en la Iglesia de Lisport. Hazle algunas preguntas directas — mira si revela algo. Infórmame cuando hayas terminado.");
        cvDetectiveAccept.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(LikeADetective.get(), App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvDetectiveAccept);

        ConversationOption cvDetectiveDecline = new ConversationOption(20, 0);
        cvDetectiveDecline.addOptionText(ENGLISH, "Not right now.", "Fine... but keep your eyes open. Something is off, I am sure of it.");
        cvDetectiveDecline.addOptionText(PORTUGUESE, "Agora não.", "Tudo bem... mas mantenha os olhos abertos. Algo está errado, tenho certeza disso.");
        cvDetectiveDecline.addOptionText(SPANISH, "Ahora no.", "Bien... pero mantén los ojos abiertos. Algo está mal, estoy segura.");
        npc.conversationOptions.add(cvDetectiveDecline);

        // Part 2: Report about Edward
        ConversationOption cvDetectivePart2 = new ConversationOption(0, 0);
        cvDetectivePart2.addOptionText(ENGLISH, "I questioned Priest Edward.",
                "*She frowns*\nHmm. Suspicious behavior does not always mean guilt, true. But it is enough to keep him on the list.\n\nNext, Doctor Rawer. His house is always busy at odd hours. Patients at midnight? I do not think so. Question him and report back.");
        cvDetectivePart2.addOptionText(PORTUGUESE, "Questionei o Padre Edward.",
                "*Ela franze o cenho*\nHmm. Comportamento suspeito nem sempre significa culpa, é verdade. Mas é o suficiente para mantê-lo na lista.\n\nAgora, o Médico Rawer. A casa dele fica sempre movimentada em horas estranhas. Pacientes à meia-noite? Não acredito nisso. Questioná-lo e me reporte.");
        cvDetectivePart2.addOptionText(SPANISH, "Interrogué al Padre Edward.",
                "*Frunce el ceño*\nHmm. El comportamiento sospechoso no siempre significa culpa, es verdad. Pero es suficiente para mantenerlo en la lista.\n\nAhora, el Doctor Rawer. Su casa siempre está ocupada a horas extrañas. ¿Pacientes a medianoche? No lo creo. Interrógalo e infórmame.");
        cvDetectivePart2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.LIKE_A_DETECTIVE, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvDetectivePart2.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.LIKE_A_DETECTIVE, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvDetectivePart2);

        // Part 4: Report about Rawer
        ConversationOption cvDetectivePart4 = new ConversationOption(0, 0);
        cvDetectivePart4.addOptionText(ENGLISH, "I questioned Doctor Rawer.",
                "*She sighs*\nNeither of them? Maybe I really am imagining things...\n\nBut there is still Klaus. I have seen him leave toward Lisport Shores late at night, every night this week. Travel there at night and observe what he does. Maybe it is nothing. Maybe it is something.");
        cvDetectivePart4.addOptionText(PORTUGUESE, "Questionei o Médico Rawer.",
                "*Ela suspira*\nNenhum dos dois? Talvez eu esteja realmente imaginando coisas...\n\nMas ainda há Klaus. Eu o vi sair em direção às Praias de Lisport tarde da noite, toda noite desta semana. Vá lá à noite e observe o que ele faz. Pode ser nada. Pode ser algo.");
        cvDetectivePart4.addOptionText(SPANISH, "Interrogué al Doctor Rawer.",
                "*Suspira*\n¿Ninguno de los dos? Quizás realmente estoy imaginando cosas...\n\nPero todavía está Klaus. Lo he visto salir hacia las Orillas de Lisport tarde por la noche, cada noche esta semana. Ve allí por la noche y observa qué hace. Tal vez no es nada. Tal vez sí es algo.");
        cvDetectivePart4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.LIKE_A_DETECTIVE, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvDetectivePart4.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.LIKE_A_DETECTIVE, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvDetectivePart4);

        // Part 6: Final report — Olga gives up, gives Traits Analysis knowledge
        ConversationOption cvDetectivePart6 = new ConversationOption(0, 0);
        cvDetectivePart6.addOptionText(ENGLISH, "I watched Klaus all night. He just fished. Nothing suspicious.",
                "*She stares for a moment, then laughs softly and shakes her head*\nSo... nobody. Nobody is doing anything wrong. It was all in my head.\n\n*She rubs her tired eyes*\n\nI think I have been working too hard. My mind started seeing shadows where there are none. You know, spending all night watching a harmless fisherman is not how I planned my week.\n\nBut... you know something? Even though nobody was guilty, watching, asking, analyzing — you learn things. You learn to read people better. I can feel it. Here — take this. Something useful for someone who just spent days analyzing people for me.");
        cvDetectivePart6.addOptionText(PORTUGUESE, "Observei Klaus a noite toda. Ele só pescou. Nada suspeito.",
                "*Ela olha por um momento, depois ri baixinho e balança a cabeça*\nEntão... ninguém. Ninguém está fazendo nada errado. Foi tudo na minha cabeça.\n\n*Ela esfrega os olhos cansados*\n\nAcho que estive trabalhando demais. Minha mente começou a ver sombras onde não há nenhuma. Sabe, passar a noite toda observando um pescador inofensivo não era como eu planejei minha semana.\n\nMas... sabe de uma coisa? Mesmo que ninguém fosse culpado, observar, perguntar, analisar — você aprende coisas. Aprende a ler as pessoas melhor. Consigo sentir isso. Aqui — leva isso. Algo útil para alguém que acabou de passar dias analisando pessoas por mim.");
        cvDetectivePart6.addOptionText(SPANISH, "Observé a Klaus toda la noche. Solo pescó. Nada sospechoso.",
                "*Mira por un momento, luego ríe suavemente y sacude la cabeza*\nEntonces... nadie. Nadie está haciendo nada malo. Todo estaba en mi cabeza.\n\n*Se frota los ojos cansados*\n\nCreo que he estado trabajando demasiado. Mi mente empezó a ver sombras donde no las hay. Sabes, pasar toda la noche observando a un pescador inofensivo no era como planeé mi semana.\n\nPero... ¿sabes qué? Aunque nadie era culpable, observar, preguntar, analizar — aprendes cosas. Aprendes a leer mejor a las personas. Lo siento. Aquí — toma esto. Algo útil para alguien que acaba de pasar días analizando personas por mí.");
        cvDetectivePart6.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.LIKE_A_DETECTIVE, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvDetectivePart6.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.LIKE_A_DETECTIVE, App.getPlayerChar(), 7, ctx);
        };
        npc.conversationOptions.add(cvDetectivePart6);

        return npc;
    }
}

