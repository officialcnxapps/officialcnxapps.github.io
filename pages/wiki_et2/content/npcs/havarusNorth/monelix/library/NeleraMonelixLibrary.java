package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.library;

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

public class NeleraMonelixLibrary extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Nelera");
        npc.resetId("NELERA_MONELIX_LIBRARY");
        npc.age = 36;
        npc.job = Enums.NPCJobs.STUDENT;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Ah, [PLAYERNAME]! Welcome to the Royal Library!"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Ah, [PLAYERNAME]! Seja bem-vindo à Biblioteca Real!"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("¡Ah, [PLAYERNAME]! ¡Bienvenido a la Biblioteca Real!"));

        // NPC only appears after TRAITOR quest is complete
        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.TRAITOR)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // ========================================
        // ROLEPLAY
        // ========================================

        // Roleplay 1: Studies about elves
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "How are the studies about elven culture going here?", "*Smiles warmly, gesturing toward a desk covered in open books and translated notes*\nBetter than I ever dared hope! The Royal Library here in Monelix has extensive collections about the ancient history between humans and elves — texts I never had access to in Bastian.\n*runs her fingers along a row of spines*\nI have been cross-referencing elven manuscripts I translated in Ayalon with the human historical records kept here. The connections are fascinating. The elves wrote about us too, [PLAYERNAME]. With admiration, with curiosity, with genuine fondness. We were never strangers to each other — we chose to become so, slowly, over centuries.\nEvery page I translate feels like recovering something that was lost.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Como estão os estudos sobre a cultura élfica por aqui?", "*Sorri calorosamente, gesticulando para uma mesa coberta de livros abertos e notas traduzidas*\nMelhor do que jamais ousara esperar! A Biblioteca Real aqui em Monelix tem extensas coleções sobre a história antiga entre humanos e elfos — textos aos quais nunca tive acesso em Bastian.\n*desliza os dedos ao longo de uma fileira de lombadas*\nTenho cruzado os manuscritos élficos que traduzi em Ayalon com os registros históricos humanos guardados aqui. As conexões são fascinantes. Os elfos escreveram sobre nós também, [PLAYERNAME]. Com admiração, com curiosidade, com genuína afeição. Nunca fomos estranhos uns aos outros — escolhemos nos tornar assim, lentamente, ao longo de séculos.\nCada página que traduzo parece recuperar algo que foi perdido.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cómo van los estudios sobre la cultura élfica por aquí?", "*Sonríe cálidamente, gesticulando hacia un escritorio cubierto de libros abiertos y notas traducidas*\n¡Mejor de lo que jamás me había atrevido a esperar! La Biblioteca Real aquí en Monelix tiene extensas colecciones sobre la historia antigua entre humanos y elfos — textos a los que nunca tuve acceso en Bastian.\n*desliza los dedos a lo largo de una fila de lomos*\nHe estado cruzando los manuscritos élficos que traduje en Ayalon con los registros históricos humanos guardados aquí. Las conexiones son fascinantes. Los elfos también escribieron sobre nosotros, [PLAYERNAME]. Con admiración, con curiosidad, con genuino cariño. Nunca fuimos extraños los unos a los otros — elegimos convertirnos en eso, lentamente, a lo largo de siglos.\nCada página que traduzco se siente como recuperar algo que se perdió.");
        npc.conversationOptions.add(cvRoleplay1);

        // Roleplay 2: Working at the Royal Library
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "What is it like working at the Royal Library?", "*Pauses and looks around the grand hall with a quiet pride*\nHonestly? It still feels like a dream. For years the library rejected me — too specialized, they said. Too focused on elven culture. As if depth of knowledge were a flaw.\n*chuckles softly*\nNow those very texts they dismissed are the ones the scholars here are desperate to understand. The threat we all faced... it changed perspectives. People no longer see the study of elven lore as idle curiosity. They see it as essential.\nI am given full access to every archive, every sealed tome, every correspondence between human kings and elven lords dating back centuries. It is... overwhelming, in the best possible way.\n*looks at you with genuine gratitude*\nI owe much of this to you, [PLAYERNAME]. You spoke for me when no one else would.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Como é trabalhar na Biblioteca Real?", "*Pausa e olha ao redor do grande salão com um silencioso orgulho*\nHonestamente? Ainda parece um sonho. Por anos a biblioteca me rejeitou — muito especializada, diziam. Muito focada na cultura élfica. Como se a profundidade do conhecimento fosse uma falha.\n*ri suavemente*\nAgora esses mesmos textos que eles descartaram são os que os estudiosos aqui estão desesperados para entender. A ameaça que todos enfrentamos... mudou perspectivas. As pessoas não veem mais o estudo do lore élfico como curiosidade ociosa. Elas o veem como essencial.\nTenho acesso total a cada arquivo, cada tomo lacrado, cada correspondência entre reis humanos e lordes élficos que remonta a séculos. É... avassalador, da melhor maneira possível.\n*olha para você com gratidão genuína*\nDevo muito disso a você, [PLAYERNAME]. Você falou por mim quando ninguém mais falaria.");
        cvRoleplay2.addOptionText(SPANISH, "¿Cómo es trabajar en la Biblioteca Real?", "*Hace una pausa y mira alrededor del gran salón con un silencioso orgullo*\n¿Honestamente? Todavía se siente como un sueño. Por años la biblioteca me rechazó — demasiado especializada, decían. Demasiado enfocada en la cultura élfica. Como si la profundidad del conocimiento fuera un defecto.\n*ríe suavemente*\nAhora esos mismos textos que descartaron son los que los eruditos aquí están desesperados por entender. La amenaza que todos enfrentamos... cambió perspectivas. La gente ya no ve el estudio del lore élfico como curiosidad ociosa. Lo ven como esencial.\nTengo acceso completo a cada archivo, cada tomo sellado, cada correspondencia entre reyes humanos y señores élficos que se remonta a siglos. Es... abrumador, de la mejor manera posible.\n*te mira con genuina gratitud*\nTe debo mucho de esto, [PLAYERNAME]. Hablaste por mí cuando nadie más lo haría.");
        npc.conversationOptions.add(cvRoleplay2);

        // ========================================
        // ELFS AND HUMANS QUEST
        // ========================================

        // Part 2: Eldrin's message received
        ConversationOption cvElfsHumans1 = new ConversationOption(0, 10);
        cvElfsHumans1.addOptionText(ENGLISH, "Eldrin seeks knowledge about the history between elves and humans.", "*Face lights up*\nEldrin! The half-elf blacksmith from Umera. I remember reading about him in historical texts - such unions between our peoples were once common and celebrated. \n*thinks thoughtfully*\nHe wants to understand the bond between elves and humans? That's a beautiful quest for understanding. I have just the text for him!");
        cvElfsHumans1.addOptionText(PORTUGUESE, "Eldrin busca conhecimento sobre a história entre elfos e humanos.", "*Rosto se ilumina*\nEldrin! O ferreiro meio-elfo de Umera. Lembro-me de ler sobre ele em textos históricos - tais uniões entre nossos povos já foram comuns e celebradas. \n*pensa pensativa*\nEle quer entender o laço entre elfos e humanos? É uma busca linda por compreensão. Tenho o texto perfeito para ele!");
        cvElfsHumans1.addOptionText(SPANISH, "Eldrin busca conocimiento sobre la historia entre elfos y humanos.", "*El rostro se ilumina*\n¡Eldrin! El herrero mitad elfo de Umera. Recuerdo haber leído sobre él en textos históricos - tales uniones entre nuestros pueblos una vez fueron comunes y celebradas. \n*piensa pensativa*\n¿Quiere entender el vínculo entre elfos y humanos? Es una hermosa búsqueda de comprensión. ¡Tengo el texto perfecto para él!");
        cvElfsHumans1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELFS_AND_HUMANS, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfsHumans1);

        ConversationOption cvElfsHumans2 = new ConversationOption(10, 0);
        cvElfsHumans2.addOptionText(ENGLISH, "What can you tell him?", "During my research in both human and elven archives, I came across a remarkable chronicle written by a human historian named Marcus Thorne. He documented the Golden Age from a human perspective - a period three centuries ago when elves and humans lived and worked side by side in true harmony.\n\n*retrieves a carefully preserved book*\nThis Chronicle of the Golden Age is written in your common tongue, so Eldrin can read it directly. It tells of a time when building cities together, sharing knowledge, and celebrating festivals as one people was normal. When his parents' love story would have been commonplace, not extraordinary.\n\nTake this to him. Let him see what once was possible - from the words of his father's people speaking about his mother's people with admiration and respect.");
        cvElfsHumans2.addOptionText(PORTUGUESE, "O que você pode dizer a ele?", "Durante minha pesquisa em arquivos tanto humanos quanto élficos, encontrei uma crônica notável escrita por um historiador humano chamado Marcus Thorne. Ele documentou a Era Dourada de uma perspectiva humana - um período há três séculos quando elfos e humanos viviam e trabalhavam lado a lado em verdadeira harmonia.\n\n*recupera um livro cuidadosamente preservado*\nEsta Crônica da Era Dourada está escrita em sua língua comum, então Eldrin pode lê-la diretamente. Conta sobre um tempo em que construir cidades juntos, compartilhar conhecimento e celebrar festivais como um só povo era normal. Quando a história de amor de seus pais teria sido comum, não extraordinária.\n\nLeve isto a ele. Deixe-o ver o que uma vez foi possível - das palavras do povo de seu pai falando sobre o povo de sua mãe com admiração e respeito.");
        cvElfsHumans2.addOptionText(SPANISH, "¿Qué puedes decirle?", "Durante mi investigación en archivos tanto humanos como élficos, encontré una crónica notable escrita por un historiador humano llamado Marcus Thorne. Documentó la Edad de Oro desde una perspectiva humana - un período hace tres siglos cuando elfos y humanos vivían y trabajaban lado a lado en verdadera armonía.\n\n*recupera un libro cuidadosamente preservado*\nEsta Crónica de la Edad de Oro está escrita en su lengua común, así que Eldrin puede leerla directamente. Cuenta sobre un tiempo en que construir ciudades juntos, compartir conocimiento y celebrar festivales como un solo pueblo era normal. Cuando la historia de amor de sus padres habría sido común, no extraordinaria.\n\nLlévale esto. Déjalo ver lo que una vez fue posible - de las palabras del pueblo de su padre hablando sobre el pueblo de su madre con admiración y respeto.");
        cvElfsHumans2.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.CHRONICLE_OF_THE_GOLDEN_AGE, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.ELFS_AND_HUMANS, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvElfsHumans2);

        // Part 5: Translate untranslated scroll
        ConversationOption cvElfsHumans3 = new ConversationOption(0, 11);
        cvElfsHumans3.addOptionText(ENGLISH, "I have an ancient scroll that needs translation.", "*Takes the scroll carefully*\nAh, this is from the Sacred Temple! I recognize the seal of Elder Aelrindel - she was renowned for her love of humanity and her work building bridges between our peoples. \n*examines the elegant elven script*\nGive me a moment to translate this properly...\n\n*works carefully for several minutes*\n\nDone! This is beautiful, [PLAYERNAME]. Elder Aelrindel's observations about humanity are profound - she truly understood the human spirit. Take this to Eldrin. I think it will move him deeply.");
        cvElfsHumans3.addOptionText(PORTUGUESE, "Tenho um pergaminho ancestral que precisa de tradução.", "*Pega o pergaminho cuidadosamente*\nAh, este é do Templo Sagrado! Reconheço o selo da Anciã Aelrindel - ela era renomada por seu amor pela humanidade e seu trabalho construindo pontes entre nossos povos. \n*examina a elegante escrita élfica*\nDê-me um momento para traduzir isto adequadamente...\n\n*trabalha cuidadosamente por vários minutos*\n\nPronto! Isto é lindo, [PLAYERNAME]. As observações da Anciã Aelrindel sobre a humanidade são profundas - ela verdadeiramente entendia o espírito humano. Leve isto para Eldrin. Acho que o emocionará profundamente.");
        cvElfsHumans3.addOptionText(SPANISH, "Tengo un pergamino ancestral que necesita traducción.", "*Toma el pergamino cuidadosamente*\n¡Ah, este es del Templo Sagrado! Reconozco el sello de la Anciana Aelrindel - era renombrada por su amor por la humanidad y su trabajo construyendo puentes entre nuestros pueblos. \n*examina la elegante escritura élfica*\nDame un momento para traducir esto adecuadamente...\n\n*trabaja cuidadosamente durante varios minutos*\n\n¡Listo! Esto es hermoso, [PLAYERNAME]. Las observaciones de la Anciana Aelrindel sobre la humanidad son profundas - ella verdaderamente entendía el espíritu humano. Llévale esto a Eldrin. Creo que lo conmoverá profundamente.");
        cvElfsHumans3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELFS_AND_HUMANS, 5) &&
                    LibInventory.checkHasItem(ItemsIds.ANCIENT_ELVEN_SCROLL, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfsHumans3);

        ConversationOption cvElfsHumans4 = new ConversationOption(11, 0);
        cvElfsHumans4.addOptionText(ENGLISH, "[Take the translated scroll]", "I hope this helps Eldrin understand not just the history, but how much mutual respect existed between our peoples. Elder Aelrindel's words show that elves didn't just tolerate humans - we admired them, learned from them, and saw them as equals. That spirit of unity... it's something I hope we can rediscover. I will return the original scroll to Gisela in the temple.");
        cvElfsHumans4.addOptionText(PORTUGUESE, "[Pegar o pergaminho traduzido]", "Espero que isso ajude Eldrin a entender não apenas a história, mas quanto respeito mútuo existia entre nossos povos. As palavras da Anciã Aelrindel mostram que os elfos não apenas toleravam os humanos - nós os admirávamos, aprendíamos com eles e os víamos como iguais. Esse espírito de unidade... é algo que espero que possamos redescobrir. Eu voltarei o pergaminho original para Gisela no templo.");
        cvElfsHumans4.addOptionText(SPANISH, "[Tomar el pergamino traducido]", "Espero que esto ayude a Eldrin a entender no solo la historia, sino cuánto respeto mutuo existía entre nuestros pueblos. Las palabras de la Anciana Aelrindel muestran que los elfos no solo toleraban a los humanos - los admirábamos, aprendíamos de ellos y los veíamos como iguales. Ese espíritu de unidad... es algo que espero que podamos redescubrir. Yo devolveré el pergamino original a Gisela en el templo.");
        cvElfsHumans4.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.ANCIENT_ELVEN_SCROLL, 1, App.getPlayerChar());
            LibInventory.addToInventory(ItemsIds.ANCIENT_SCROLL_TRANSLATED, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.ELFS_AND_HUMANS, 6, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvElfsHumans4);

        // Part 7: Explain the separation
        ConversationOption cvElfsHumans5 = new ConversationOption(0, 12);
        cvElfsHumans5.addOptionText(ENGLISH, "Eldrin wants to understand what caused the separation between our peoples.", "*Sighs softly*\nThe inevitable question. Everyone wants to find a dramatic answer - a great betrayal, a terrible war, some tragic event that tore us apart. But the truth is both simpler and sadder than that.\n\n*pulls out historical records*\nLet me explain what really happened...");
        cvElfsHumans5.addOptionText(PORTUGUESE, "Eldrin quer entender o que causou a separação entre nossos povos.", "*Suspira suavemente*\nA pergunta inevitável. Todos querem encontrar uma resposta dramática - uma grande traição, uma guerra terrível, algum evento trágico que nos separou. Mas a verdade é tanto mais simples quanto mais triste que isso.\n\n*puxa registros históricos*\nDeixe-me explicar o que realmente aconteceu...");
        cvElfsHumans5.addOptionText(SPANISH, "Eldrin quiere entender qué causó la separación entre nuestros pueblos.", "*Suspira suavemente*\nLa pregunta inevitable. Todos quieren encontrar una respuesta dramática - una gran traición, una guerra terrible, algún evento trágico que nos separó. Pero la verdad es tanto más simple como más triste que eso.\n\n*saca registros históricos*\nDéjame explicar lo que realmente pasó...");
        cvElfsHumans5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELFS_AND_HUMANS, 7)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfsHumans5);

        ConversationOption cvElfsHumans6 = new ConversationOption(12, 0);
        cvElfsHumans6.addOptionText(ENGLISH, "What really happened?", "Time and geography, [PLAYERNAME]. As human kingdoms expanded rapidly across the continent, they focused inward - building their own cities, solving their own problems, dealing with their own conflicts. The elven lands, always more isolated by nature and magic, became even more so. \n\nTravel between our lands became difficult, then rare, then almost nonexistent. Magical barriers were raised not out of hatred, but for protection as the world grew more dangerous. Generations passed. Old friendships faded into legends. Different priorities, different concerns, different ways of life.\n\nWe simply... drifted apart. Like old friends who move to different lands and lose touch over the years. No great war, no terrible betrayal - just the natural drift of peoples with different needs and different paths.\n\n*looks at you earnestly*\nTell Eldrin this truth. The separation wasn't born of hatred - it was born of distance and time. And what time and distance created, perhaps understanding and effort can heal.");
        cvElfsHumans6.addOptionText(PORTUGUESE, "O que realmente aconteceu?", "Tempo e geografia, [PLAYERNAME]. À medida que os reinos humanos se expandiram rapidamente pelo continente, focaram-se internamente - construindo suas próprias cidades, resolvendo seus próprios problemas, lidando com seus próprios conflitos. As terras élficas, sempre mais isoladas por natureza e magia, tornaram-se ainda mais. \n\nViajar entre nossas terras tornou-se difícil, depois raro, depois quase inexistente. Barreiras mágicas foram erguidas não por ódio, mas por proteção conforme o mundo se tornava mais perigoso. Gerações passaram. Velhas amizades desvaneceram em lendas. Prioridades diferentes, preocupações diferentes, modos de vida diferentes.\n\nSimplesmente... nos afastamos. Como velhos amigos que se mudam para terras diferentes e perdem contato ao longo dos anos. Nenhuma grande guerra, nenhuma traição terrível - apenas o afastamento natural de povos com diferentes necessidades e diferentes caminhos.\n\n*olha para você seriamente*\nDiga a Eldrin esta verdade. A separação não nasceu do ódio - nasceu da distância e do tempo. E o que tempo e distância criaram, talvez compreensão e esforço possam curar.");
        cvElfsHumans6.addOptionText(SPANISH, "¿Qué pasó realmente?", "Tiempo y geografía, [PLAYERNAME]. A medida que los reinos humanos se expandieron rápidamente por el continente, se enfocaron internamente - construyendo sus propias ciudades, resolviendo sus propios problemas, lidiando con sus propios conflictos. Las tierras élficas, siempre más aisladas por naturaleza y magia, se volvieron aún más. \n\nViajar entre nuestras tierras se volvió difícil, luego raro, luego casi inexistente. Se levantaron barreras mágicas no por odio, sino por protección conforme el mundo se volvía más peligroso. Las generaciones pasaron. Viejas amistades se desvanecieron en leyendas. Diferentes prioridades, diferentes preocupaciones, diferentes formas de vida.\n\nSimplemente... nos alejamos. Como viejos amigos que se mudan a tierras diferentes y pierden contacto con los años. Ninguna gran guerra, ninguna traición terrible - solo el alejamiento natural de pueblos con diferentes necesidades y diferentes caminos.\n\n*te mira seriamente*\nDile a Eldrin esta verdad. La separación no nació del odio - nació de la distancia y el tiempo. Y lo que el tiempo y la distancia crearon, quizás el entendimiento y el esfuerzo puedan sanar.");
        cvElfsHumans6.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.ELFS_AND_HUMANS, 8, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvElfsHumans6);

        // Roleplay after quest completion
        ConversationOption cvElfsHumansAfter = new ConversationOption(0, 0);
        cvElfsHumansAfter.addOptionText(ENGLISH, "The knowledge you shared helped Eldrin find peace.", "I'm glad to hear that. Understanding our past is the first step toward building a better future. Perhaps one day, through people like Eldrin and scholars like me, elves and humans will walk side by side again - not just in isolated alliances born of crisis, but in true friendship once more.");
        cvElfsHumansAfter.addOptionText(PORTUGUESE, "O conhecimento que você compartilhou ajudou Eldrin a encontrar paz.", "Fico feliz em saber disso. Compreender nosso passado é o primeiro passo para construir um futuro melhor. Talvez um dia, através de pessoas como Eldrin e estudiosos como eu, elfos e humanos caminharão lado a lado novamente - não apenas em alianças isoladas nascidas de crises, mas em verdadeira amizade mais uma vez.");
        cvElfsHumansAfter.addOptionText(SPANISH, "El conocimiento que compartiste ayudó a Eldrin a encontrar paz.", "Me alegra escuchar eso. Comprender nuestro pasado es el primer paso para construir un mejor futuro. Quizás algún día, a través de personas como Eldrin y eruditos como yo, elfos y humanos caminarán lado a lado nuevamente - no solo en alianzas aisladas nacidas de crisis, sino en verdadera amistad una vez más.");
        cvElfsHumansAfter.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.ELFS_AND_HUMANS)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfsHumansAfter);

        return npc;
    }
}

