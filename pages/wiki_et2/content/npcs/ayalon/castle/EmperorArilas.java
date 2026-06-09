package com.cnx.endlesstalestwo.data.npcs.ayalon.castle;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class EmperorArilas extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Emperor Arilas");
        npc.addNameTranslation(PORTUGUESE, "Imperador Arilas");
        npc.addNameTranslation(SPANISH, "Emperador Arilas");
        npc.age = 297;
        npc.job = Enums.NPCJobs.GOVERNOR;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "An experienced and wise elf. He is usually serious, partly due to his status as emperor.\nHe always thinks with conviction and for the good of his people.\nHe has clearly ruled Ayalon for years.\n\nHis physical traits: Long, straight, grayish hair; a square face with well-defined lines. Pale skin and thin cheeks.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um  elfo experiente e sábio. Costuma ser sempre sério, até devido ao seu patamar de imperador.\nPensa sempre com convicção e em prol do seu povo.\nClaramente governa Ayalon há anos.\n\nSeus taços físicos: Cabelos lisos, longos e acinzentados, rosto quadrado e com linhas bem definidas. Pele pálida e bochechas magras.");
        npc.addDescriptionTranslation(SPANISH, "Un elfo experimentado y sabio. Suele ser serio, debido a su posición como emperador.\nSiempre piensa con convicción y en el bienestar de su pueblo.\nHa gobernado Ayalon durante años.\n\nSus rasgos físicos: cabello largo, liso y gris, rostro cuadrado con facciones bien definidas, piel pálida y mejillas delgadas.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Welcome to Ayalon, human."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bem-vindo a Ayalon, humano."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Bienvenido a Ayalon, humano."));

        // ===== ELF KNOWLEDGE QUEST: Part 3 - First meeting with Arilas =====
        ConversationOption cvElfKnowledge1 = new ConversationOption(0, 1);
        cvElfKnowledge1.addOptionText(ENGLISH, "Emperor Arilas, I come bearing a letter from Queen Enola of Havarus.", "*Studies you with ancient eyes*\nA human in Ayalon bearing a royal seal. This is... unprecedented in recent times. \n*Takes the letter and reads*\nQueen Enola speaks of dark forces threatening all realms.");
        cvElfKnowledge1.addOptionText(PORTUGUESE, "Imperador Arilas, venho portando uma carta da Rainha Enola de Havarus.", "*Estuda você com olhos ancestrais*\nUm humano em Ayalon portando um selo real. Isso é... sem precedentes nos últimos tempos. \n*Pega a carta e lê*\nA Rainha Enola fala de forças das trevas ameaçando todos os reinos.");
        cvElfKnowledge1.addOptionText(SPANISH, "Emperador Arilas, vengo portando una carta de la Reina Enola de Havarus.", "*Te estudia con ojos ancestrales*\nUn humano en Ayalon portando un sello real. Esto es... sin precedentes en los últimos tiempos. \n*Toma la carta y lee*\nLa Reina Enola habla de fuerzas oscuras amenazando todos los reinos.");
        cvElfKnowledge1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELF_KNOWLEDGE, 3) &&
                    LibInventory.checkHasItem(ItemsIds.QUEENS_REQUISITION_LETTER, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfKnowledge1);

        ConversationOption cvElfKnowledge2 = new ConversationOption(1, 2);
        cvElfKnowledge2.addOptionText(ENGLISH, "The threat is real. We need elven knowledge to fight them.", "*Nods slowly*\nI do not doubt the threat exists. Dark magic has been stirring - even we have felt disturbances in the natural order. However, you must understand... elves and humans have walked separate paths for many years. Trust is not easily restored.");
        cvElfKnowledge2.addOptionText(PORTUGUESE, "A ameaça é real. Precisamos do conhecimento élfico para combatê-los.", "*Acena lentamente*\nNão duvido que a ameaça existe. Magia negra tem se agitado - até nós sentimos perturbações na ordem natural. No entanto, você deve entender... elfos e humanos caminharam por caminhos separados por muitos anos. A confiança não é facilmente restaurada.");
        cvElfKnowledge2.addOptionText(SPANISH, "La amenaza es real. Necesitamos el conocimiento élfico para combatirlos.", "*Asiente lentamente*\nNo dudo que la amenaza exista. La magia oscura se ha estado agitando - incluso nosotros hemos sentido perturbaciones en el orden natural. Sin embargo, debes entender... elfos y humanos han caminado por caminos separados durante muchos años. La confianza no se restaura fácilmente.");
        npc.conversationOptions.add(cvElfKnowledge2);

        ConversationOption cvElfKnowledge3 = new ConversationOption(2, 3);
        cvElfKnowledge3.addOptionText(ENGLISH, "What would it take to earn your trust?", "A gesture of goodwill. A proof of loyalty and respect for our ways. We elves value nature and the old trees greatly. There is a tree that grows in Havarus - the black oak. Its seeds are precious to us for cultivation here in Ayalon, yet difficult to obtain from your lands.");
        cvElfKnowledge3.addOptionText(PORTUGUESE, "O que seria necessário para ganhar sua confiança?", "Um gesto de boa vontade. Uma prova de lealdade e respeito por nossos costumes. Nós elfos valorizamos muito a natureza e as árvores antigas. Há uma árvore que cresce em Havarus - o carvalho negro. Suas sementes são preciosas para nós para cultivo aqui em Ayalon, mas difíceis de obter de suas terras.");
        cvElfKnowledge3.addOptionText(SPANISH, "¿Qué se necesitaría para ganar tu confianza?", "Un gesto de buena voluntad. Una prueba de lealtad y respeto por nuestras costumbres. Los elfos valoramos mucho la naturaleza y los árboles antiguos. Hay un árbol que crece en Havarus - el roble negro. Sus semillas son preciosas para nosotros para cultivar aquí en Ayalon, pero difíciles de obtener de vuestras tierras.");
        npc.conversationOptions.add(cvElfKnowledge3);

        // ===== ELF KNOWLEDGE QUEST: Alternative responses after hearing about the seeds =====
        ConversationOption cvElfKnowledge3Accept = new ConversationOption(3, 0);
        cvElfKnowledge3Accept.addOptionText(ENGLISH, "I understand. I will find the black oak seeds.", "Good. I am pleased by your willingness to respect our traditions. Seek out those who know the forests of Havarus well - they may help you obtain what we need. Once you have the seeds, bring them to Salilas in our garden. Return to me after he confirms their delivery.");
        cvElfKnowledge3Accept.addOptionText(PORTUGUESE, "Entendo. Vou encontrar as sementes de carvalho negro.", "Bom. Fico satisfeito com sua disposição em respeitar nossas tradições. Procure aqueles que conhecem bem as florestas de Havarus - eles podem ajudá-lo a obter o que precisamos. Assim que tiver as sementes, leve-as para Salilas em nosso jardim. Retorne a mim depois que ele confirmar a entrega.");
        cvElfKnowledge3Accept.addOptionText(SPANISH, "Entiendo. Encontraré las semillas de roble negro.", "Bien. Me complace tu disposición a respetar nuestras tradiciones. Busca a quienes conocen bien los bosques de Havarus - pueden ayudarte a obtener lo que necesitamos. Una vez que tengas las semillas, llévalas a Salilas en nuestro jardín. Regresa a mí después de que él confirme la entrega.");
        cvElfKnowledge3Accept.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.QUEENS_REQUISITION_LETTER, 3, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.ELF_KNOWLEDGE, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvElfKnowledge3Accept);

        ConversationOption cvElfKnowledge3ThinkAbout = new ConversationOption(3, 0);
        cvElfKnowledge3ThinkAbout.addOptionText(ENGLISH, "I need to think about this.", "*Nods slowly*\nI understand. This is not a small request. Take your time to consider. When you are ready to prove your commitment to our alliance, you know where to find me.");
        cvElfKnowledge3ThinkAbout.addOptionText(PORTUGUESE, "Preciso pensar sobre isso.", "*Acena lentamente*\nEntendo. Não é um pedido pequeno. Tome seu tempo para considerar. Quando estiver pronto para provar seu compromisso com nossa aliança, você sabe onde me encontrar.");
        cvElfKnowledge3ThinkAbout.addOptionText(SPANISH, "Necesito pensar en esto.", "*Asiente lentamente*\nEntiendo. No es una solicitud pequeña. Tómate tu tiempo para considerar. Cuando estés listo para demostrar tu compromiso con nuestra alianza, sabes dónde encontrarme.");
        npc.conversationOptions.add(cvElfKnowledge3ThinkAbout);

        // ===== ELF KNOWLEDGE QUEST: Alternative path with high Charisma =====
        ConversationOption cvElfKnowledge3Alternative = new ConversationOption(2, 0);
        cvElfKnowledge3Alternative.addOptionText(ENGLISH, "[Persuade]\n(Charisma 23)", "*Observes you intently, surprised by your eloquence*\nYou speak with wisdom beyond what I expected from a human envoy. Your words carry weight and sincerity... I sense genuine commitment in you.\n*Pauses thoughtfully*\nVery well. Your presence here, your words, and the courage to enter our realm - these are proof enough of your intentions. The old bonds between our peoples were forged in mutual respect, not servitude. Perhaps it is time to honor that tradition once more.\n*Nods with resolve*\nYou have earned my trust through your conviction. I grant you access to our great library. May the knowledge there serve you well in the battles ahead.");
        cvElfKnowledge3Alternative.addOptionText(PORTUGUESE, "[Persuadir]\n(Carisma 23)", "*Observa você atentamente, surpreso com sua eloquência*\nVocê fala com uma sabedoria além do que eu esperava de um enviado humano. Suas palavras carregam peso e sinceridade... sinto um compromisso genuíno em você.\n*Pausa pensativo*\nMuito bem. Sua presença aqui, suas palavras e a coragem de entrar em nosso reino - estas são provas suficientes de suas intenções. Os antigos laços entre nossos povos foram forjados em respeito mútuo, não em servidão. Talvez seja hora de honrar essa tradição mais uma vez.\n*Acena com determinação*\nVocê conquistou minha confiança através de sua convicção. Concedo-lhe acesso à nossa grande biblioteca. Que o conhecimento lá o sirva bem nas batalhas que virão.");
        cvElfKnowledge3Alternative.addOptionText(SPANISH, "[Persuadir]\n(Carisma 23)", "*Te observa atentamente, sorprendido por tu elocuencia*\nHablas con una sabiduría más allá de lo que esperaba de un enviado humano. Tus palabras tienen peso y sinceridad... siento un compromiso genuino en ti.\n*Pausa pensativo*\nMuy bien. Tu presencia aquí, tus palabras y el coraje de entrar en nuestro reino - estas son pruebas suficientes de tus intenciones. Los antiguos lazos entre nuestros pueblos se forjaron en respeto mutuo, no en servidumbre. Quizás sea hora de honrar esa tradición una vez más.\n*Asiente con determinación*\nHas ganado mi confianza a través de tu convicción. Te concedo acceso a nuestra gran biblioteca. Que el conocimiento allí te sirva bien en las batallas venideras.");
        cvElfKnowledge3Alternative.requirementValidations = (chara, ctx) -> {
            if (chara.attributesManager.getCurrent(Enums.AttributeName.CHARISMA) >= 23) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvElfKnowledge3Alternative.showEvenWhenNotValid = true;
        cvElfKnowledge3Alternative.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.QUEENS_REQUISITION_LETTER, 3, App.getPlayerChar());
            LibQuest.completeQuest(QuestsIds.ELF_KNOWLEDGE, App.getPlayerChar(), 7, ctx);
            LibQuest.includeQuestToQuestbook(QuestsIds.THE_ELF_LIBRARY, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvElfKnowledge3Alternative);

        // ===== ELF KNOWLEDGE QUEST: Part 6 - Return after delivering seeds =====
        ConversationOption cvElfKnowledge5 = new ConversationOption(0, 0);
        cvElfKnowledge5.addOptionText(ENGLISH, "I have delivered the black oak seeds to Salilas.", "*Stands and approaches*\nSalilas has informed me. You have kept your word and shown respect for our ways. This is encouraging. Perhaps the old bonds between our peoples can be rekindled after all. As promised, you now have access to our great library. May the knowledge you find there aid you in your fight against darkness.");
        cvElfKnowledge5.addOptionText(PORTUGUESE, "Entreguei as sementes de carvalho negro para Salilas.", "*Levanta e se aproxima*\nSalilas me informou. Você manteve sua palavra e mostrou respeito por nossos costumes. Isso é encorajador. Talvez os antigos laços entre nossos povos possam ser reacendidos afinal. Como prometido, você agora tem acesso à nossa grande biblioteca. Que o conhecimento que encontrar lá o ajude em sua luta contra as trevas.");
        cvElfKnowledge5.addOptionText(SPANISH, "He entregado las semillas de roble negro a Salilas.", "*Se levanta y se acerca*\nSalilas me ha informado. Has mantenido tu palabra y mostrado respeto por nuestras costumbres. Esto es alentador. Quizás los antiguos lazos entre nuestros pueblos puedan reavivarse después de todo. Como prometido, ahora tienes acceso a nuestra gran biblioteca. Que el conocimiento que encuentres allí te ayude en tu lucha contra la oscuridad.");
        cvElfKnowledge5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELF_KNOWLEDGE, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvElfKnowledge5.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.ELF_KNOWLEDGE, App.getPlayerChar(), 7, ctx);
            LibQuest.includeQuestToQuestbook(QuestsIds.THE_ELF_LIBRARY, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvElfKnowledge5);

        // ========================================
        // ROLEPLAY
        // ========================================
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "What is it like to lead the elven people?", "*Pauses, gazing toward the tall windows of the hall*\nIt is not a burden I chose lightly. To lead the elves is to carry the weight of thousands of years of history, of wars won and alliances lost, of forests that once stretched endlessly and now stand diminished.\n*Turns back to you*\nWe are a long-lived people. What a human king sees in a lifetime, I have seen repeated many times over. Each generation of men rises, full of fire and ambition, and then fades. We remain. And with that comes a deep, quiet loneliness — and an immense responsibility to preserve what others might carelessly destroy.\nI do not rule with iron will. I guide. I remind my people of who we are, and what we must protect.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Como é liderar o povo élfico?", "*Faz uma pausa, olhando para as altas janelas do salão*\nNão é um fardo que assumi levianamente. Liderar os elfos é carregar o peso de milhares de anos de história, de guerras vencidas e alianças perdidas, de florestas que outrora se estendiam infinitamente e agora estão diminuídas.\n*Vira-se de volta para você*\nSomos um povo de longa vida. O que um rei humano vê em toda uma existência, eu vi repetir-se muitas vezes. Cada geração de homens surge, cheia de fogo e ambição, e então desvanece. Nós permanecemos. E com isso vem uma solidão profunda e silenciosa — e uma responsabilidade imensa de preservar o que outros poderiam destruir descuidadamente.\nNão governo com vontade de ferro. Oriento. Lembro ao meu povo quem somos, e o que devemos proteger.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cómo es liderar al pueblo élfico?", "*Hace una pausa, mirando hacia las altas ventanas del salón*\nNo es una carga que asumí a la ligera. Liderar a los elfos es cargar el peso de miles de años de historia, de guerras ganadas y alianzas perdidas, de bosques que alguna vez se extendían infinitamente y ahora están disminuidos.\n*Se vuelve hacia ti*\nSomos un pueblo de larga vida. Lo que un rey humano ve en toda una existencia, yo lo he visto repetirse muchas veces. Cada generación de hombres surge, llena de fuego y ambición, y luego se desvanece. Nosotros permanecemos. Y con eso viene una profunda y silenciosa soledad — y una inmensa responsabilidad de preservar lo que otros podrían destruir descuidadamente.\nNo gobierno con voluntad de hierro. Guío. Recuerdo a mi pueblo quiénes somos, y qué debemos proteger.");
        npc.conversationOptions.add(cvRoleplay1);

        // ========================================
        // ROLEPLAY: After THE_FINAL_BATTLE - Casiel and the Mother Tree
        // ========================================
        ConversationOption cvCasielMotherTree = new ConversationOption(0, 0);
        cvCasielMotherTree.addOptionText(ENGLISH, "Casiel is gone. What happens to Ayalon and the Mother Tree from here?",
                "*Arilas lowers his gaze for a moment.*\nCasiel is gone, yes. Thanks to you. But I will not pretend that victory came without cost.\n*Walks slowly toward the window, voice measured*\nThe nature tree... we destroyed it ourselves. There was no other choice. It was the last portal remaining, and had we left it open, everything we fought for would have meant nothing. So we made the decision. Humans and elves, side by side, for the first time in centuries — united by the same sacrifice.\n*Pauses, pressing a hand briefly to the glass*\nAyalon will endure. But she will be quieter now. That tree was ancient beyond reckoning — her roots remembered times even I have only read about. Without her, something irreplaceable is gone from this world.\n*Turns back, composing himself*\nAs for what comes next... I expect my people will choose to close these walls further. Not out of hatred, but out of grief. We will need time. Perhaps generations. But I do not forget what you did here. Nor will Ayalon.");
        cvCasielMotherTree.addOptionText(PORTUGUESE, "Casiel foi derrotado. O que acontece com Ayalon e com a Árvore Mãe a partir de agora?",
                "*Arilas baixa o olhar por um momento.*\nCasiel se foi, sim. Graças a você. Mas não vou fingir que a vitória veio sem custo.\n*Caminha lentamente em direção à janela, com a voz controlada*\nA árvore da natureza... fomos nós mesmos que a destruímos. Não havia outra escolha. Era o último portal que restava, e se o tivéssemos deixado aberto, tudo pelo que lutamos não teria significado nada. Então tomamos a decisão. Humanos e elfos, lado a lado, pela primeira vez em séculos — unidos pelo mesmo sacrifício.\n*Faz uma pausa, apoiando brevemente a mão no vidro*\nAyalon vai persistir. Mas será mais silenciosa agora. Aquela árvore era antiga além do que se pode medir — suas raízes lembravam tempos que até eu apenas li sobre. Sem ela, algo insubstituível se foi deste mundo.\n*Vira-se, recompondo-se*\nQuanto ao que vem a seguir... espero que meu povo escolha fechar ainda mais estas muralhas. Não por ódio, mas por luto. Vamos precisar de tempo. Talvez gerações. Mas não esqueço o que você fez aqui. E Ayalon tampouco.");
        cvCasielMotherTree.addOptionText(SPANISH, "Casiel ha sido derrotado. ¿Qué ocurrirá con Ayalon y el Árbol Madre a partir de ahora?",
                "*Arilas baja la mirada por un momento.*\nCasiel se ha ido, sí. Gracias a ti. Pero no fingiré que la victoria llegó sin un precio.\n*Camina lentamente hacia la ventana, con voz serena*\nEl árbol de la naturaleza... lo destruimos nosotros mismos. No había otra opción. Era el último portal que quedaba, y de haberlo dejado abierto, todo por lo que luchamos no habría significado nada. Así que tomamos la decisión. Humanos y elfos, juntos, por primera vez en siglos — unidos por el mismo sacrificio.\n*Hace una pausa, apoyando brevemente la mano en el cristal*\nAyalon perdurará. Pero será más silenciosa ahora. Ese árbol era antiguo más allá de lo que puede medirse — sus raíces recordaban tiempos sobre los que incluso yo solo he leído. Sin él, algo irremplazable ha dejado este mundo.\n*Se vuelve, recomponiéndose*\nEn cuanto a lo que viene después... espero que mi pueblo elija cerrar aún más estas murallas. No por odio, sino por duelo. Necesitaremos tiempo. Quizás generaciones. Pero no olvido lo que hiciste aquí. Ni Ayalon lo olvidará.");
        cvCasielMotherTree.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.isQuestComplete(chara, QuestsIds.THE_FINAL_BATTLE)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cvCasielMotherTree);

        return npc;
    }
}

