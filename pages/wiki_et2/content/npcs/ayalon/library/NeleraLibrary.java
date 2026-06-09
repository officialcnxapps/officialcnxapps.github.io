package com.cnx.endlesstalestwo.data.npcs.ayalon.library;

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

import java.util.Collections;

public class NeleraLibrary extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Nelera");
        npc.resetId("NELERA_LIBRARY");
        npc.age = 36;
        npc.job = Enums.NPCJobs.STUDENT;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "Dreamy, dedicated and lively.\nA young spirit, ambitious and intelligent, very proactive. Sometimes she can also be innocent about life.\n\nHer physical traits: fair skin and a youthful face. light brown, curly hair. Brown eyes with a bright gaze.");
        npc.addDescriptionTranslation(PORTUGUESE, "Sonhadora, dedicada e animada.\nEspírito jovem, ambiciosa e inteligente, muito proativa. As vezes pode ser também inocente em relação a vida.\n\nSeus traços físicos: pele clara e um rosto jovial. cabelo castanho claro, cacheado. Olhos castanhos com olhar brilhante.");
        npc.addDescriptionTranslation(SPANISH, "Soñadora, dedicada y animada.\nEspíritu joven, ambiciosa e inteligente, muy proactiva. A veces también puede ser inocente respecto a la vida.\n\nSus rasgos físicos: piel clara y un rostro juvenil. cabello castaño claro, rizado. Ojos marrones con una mirada brillante.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Ah, [PLAYERNAME]! I'm so glad you're here!"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Ah, [PLAYERNAME]! Estou tão feliz que você esteja aqui!"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("¡Ah, [PLAYERNAME]! ¡Estoy tan feliz de que estés aquí!"));

        // NPC only appears in Ayalon Library from part 6 onwards
        npc.requirementValidations = (chara, ctx) -> {
            if ((LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_ELF_LIBRARY, 6) ||
                    LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_ELF_LIBRARY, 7) ||
                    LibQuest.isQuestComplete(chara, QuestsIds.THE_ELF_LIBRARY))
                    && !LibQuest.isQuestComplete(chara, QuestsIds.TRAITOR)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // ===== THE ELF LIBRARY QUEST: Part 6 & 7 - Meeting in library and completion =====
        ConversationOption cvLibrary1 = new ConversationOption(0, 1);
        cvLibrary1.addOptionText(ENGLISH, "Nelera! You made it to Ayalon. How are the studies going?", "*Eyes shining with excitement*\nThis place is beyond anything I imagined! The texts, the knowledge... centuries of wisdom preserved in these walls! I've already begun translating several key documents about dark magic and its counters.");
        cvLibrary1.addOptionText(PORTUGUESE, "Nelera! Você chegou a Ayalon. Como estão os estudos?", "*Olhos brilhando de excitação*\nEste lugar é além de qualquer coisa que imaginei! Os textos, o conhecimento... séculos de sabedoria preservados nestas paredes! Já comecei a traduzir vários documentos-chave sobre magia negra e seus contadores.");
        cvLibrary1.addOptionText(SPANISH, "¡Nelera! Llegaste a Ayalon. ¿Cómo van los estudios?", "*Ojos brillando de emoción*\n¡Este lugar está más allá de cualquier cosa que imaginara! Los textos, el conocimiento... ¡siglos de sabiduría preservados en estas paredes! Ya he comenzado a traducir varios documentos clave sobre magia oscura y sus contadores.");
        cvLibrary1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_ELF_LIBRARY, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvLibrary1);

        ConversationOption cvLibrary2 = new ConversationOption(1, 0);
        cvLibrary2.addOptionText(ENGLISH, "Have you discovered anything useful?", "*Nods enthusiastically*\nYes! The elves have extensive knowledge about dark forces and how to combat them. I've learned about ancient spells that can weaken dark creatures, protective wards, and even ways to disrupt dark magic rituals. But there's something particularly important I discovered...\n\n*picks up translated notes*\nThere are references to specific magical supplies we'll need - rare herbs, mystical components. These will be essential for the spells we need to defend the kingdom. I'm compiling a list of everything we'll require.");
        cvLibrary2.addOptionText(PORTUGUESE, "Você descobriu algo útil?", "*Acena entusiasticamente*\nSim! Os elfos têm conhecimento extenso sobre forças das trevas e como combatê-las. Aprendi sobre feitiços ancestrais que podem enfraquecer criaturas das trevas, proteções, e até maneiras de interromper rituais de magia negra. Mas há algo particularmente importante que descobri...\n\n*pega notas traduzidas*\nHá referências a suprimentos mágicos específicos que precisaremos - ervas raras, componentes místicos. Estes serão essenciais para os feitiços que precisamos para defender o reino. Estou compilando uma lista de tudo que precisaremos.");
        cvLibrary2.addOptionText(SPANISH, "¿Has descubierto algo útil?", "*Asiente con entusiasmo*\n¡Sí! Los elfos tienen conocimiento extenso sobre fuerzas oscuras y cómo combatirlas. He aprendido sobre hechizos ancestrales que pueden debilitar criaturas oscuras, protecciones, e incluso formas de interrumpir rituales de magia oscura. Pero hay algo particularmente importante que descubrí...\n\n*toma notas traducidas*\nHay referencias a suministros mágicos específicos que necesitaremos: hierbas raras, componentes místicos. Estos serán esenciales para los hechizos que necesitamos para defender el reino. Estoy compilando una lista de todo lo que necesitaremos.");
        cvLibrary2.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.THE_ELF_LIBRARY, App.getPlayerChar(), 7, ctx);
            LibQuest.includeQuestToQuestbook(QuestsIds.MAGICAL_SUPPLIES, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvLibrary2);

        // ===== MAGICAL SUPPLIES QUEST: Part 2 - Targon discovery =====
        ConversationOption cvMagicalSupplies1 = new ConversationOption(0, 2);
        cvMagicalSupplies1.addOptionText(ENGLISH, "Nelera, Guzar has urgent news. The enemy is summoning a demon lord.", "*Eyes widen in alarm*\nA demon lord? That's... that's grave news indeed. \n*immediately starts pulling books from shelves*\nGive me the details - everything Guzar told you.");
        cvMagicalSupplies1.addOptionText(PORTUGUESE, "Nelera, Guzar tem notícias urgentes. O inimigo está invocando um senhor demônio.", "*Olhos se arregalam em alarme*\nUm senhor demônio? Isso é... são notícias graves de fato. \n*imediatamente começa a puxar livros das prateleiras*\nMe dê os detalhes - tudo que Guzar te disse.");
        cvMagicalSupplies1.addOptionText(SPANISH, "Nelera, Guzar tiene noticias urgentes. El enemigo está invocando a un señor demonio.", "*Los ojos se abren en alarma*\n¿Un señor demonio? Eso es... son noticias graves de hecho. \n*inmediatamente comienza a sacar libros de los estantes*\nDame los detalles - todo lo que Guzar te dijo.");
        cvMagicalSupplies1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.MAGICAL_SUPPLIES, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvMagicalSupplies1);

        ConversationOption cvMagicalSupplies2 = new ConversationOption(2, 0);
        cvMagicalSupplies2.addOptionText(ENGLISH, "[Explain about Targon and the summoning]", "*Frantically flips through pages*\nTargon... Targon... Yes! Here! \n*points to an ancient text*\n'Targon the Voidbringer, Lord of the Dark Abyss.' He's mentioned in several elven texts about the great wars of old. A powerful demon that can only manifest in our world through extended dark rituals. [PLAYERNAME], this is catastrophic. If he fully crosses over...\n\n*Takes a deep breath to calm herself*\nBut wait - there's hope. The texts say defeating Targon in combat is nearly impossible, but there's another way. We can create a counter-portal - a reversal spell to send him back to the underworld before he fully manifests. You need to speak with Casiel immediately. He's the elven magical leader - if anyone can perform such powerful magic, it's him.");
        cvMagicalSupplies2.addOptionText(PORTUGUESE, "[Explicar sobre Targon e a invocação]", "*Folheia páginas freneticamente*\nTargon... Targon... Sim! Aqui! \n*aponta para um texto ancestral*\n'Targon o Portador do Vazio, Senhor do Abismo Sombrio.' Ele é mencionado em vários textos élficos sobre as grandes guerras antigas. Um demônio poderoso que só pode se manifestar em nosso mundo através de rituais negros prolongados. [PLAYERNAME], isso é catastrófico. Se ele cruzar completamente...\n\n*Respira fundo para se acalmar*\nMas espere - há esperança. Os textos dizem que derrotar Targon em combate é quase impossível, mas há outro caminho. Podemos criar um contra-portal - um feitiço de reversão para mandá-lo de volta ao submundo antes que ele se manifeste completamente. Você precisa falar com Casiel imediatamente. Ele é o líder mágico élfico - se alguém pode realizar uma magia tão poderosa, é ele.");
        cvMagicalSupplies2.addOptionText(SPANISH, "[Explicar sobre Targon y la invocación]", "*Hoyea páginas frenéticamente*\nTargon... Targon... ¡Sí! ¡Aquí! \n*señala un texto ancestral*\n'Targon el Portador del Vacío, Señor del Abismo Oscuro.' Es mencionado en varios textos élficos sobre las grandes guerras antiguas. Un demonio poderoso que solo puede manifestarse en nuestro mundo a través de rituales oscuros prolongados. [PLAYERNAME], esto es catastrófico. Si cruza completamente...\n\n*Respira hondo para calmarse*\nPero espera - hay esperanza. Los textos dicen que derrotar a Targon en combate es casi imposible, pero hay otro camino. Podemos crear un contraportal - un hechizo de reversión para enviarlo de vuelta al inframundo antes de que se manifieste completamente. Necesitas hablar con Casiel inmediatamente. Él es el líder mágico élfico - si alguien puede realizar una magia tan poderosa, es él.");
        cvMagicalSupplies2.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.MAGICAL_SUPPLIES, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvMagicalSupplies2);

        // ===== THE PORTAL QUEST: Part 5 → 6 - Casiel's betrayal discovered =====
        ConversationOption cvPortal1 = new ConversationOption(0, 3);
        cvPortal1.addOptionText(ENGLISH, "Nelera, something went terribly wrong. The portal Casiel created didn't work!", "*Looks up sharply from her books*\nWhat?! The counter-portal failed? But Casiel assured us the ritual was sound... Wait, [PLAYERNAME], tell me exactly what happened.");
        cvPortal1.addOptionText(PORTUGUESE, "Nelera, algo deu terrivelmente errado. O portal que Casiel criou não funcionou!", "*Levanta os olhos abruptamente de seus livros*\nO quê?! O contra-portal falhou? Mas Casiel nos assegurou que o ritual era sólido... Espere, [PLAYERNAME], me diga exatamente o que aconteceu.");
        cvPortal1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_PORTAL, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPortal1);

        ConversationOption cvPortal2 = new ConversationOption(3, 4);
        cvPortal2.addOptionText(ENGLISH, "[Explain the failed portal and the battle with Targon]", "*Face grows pale as you speak*\nPurple and black smoke... no portal opened... \n*suddenly rushes to a bookshelf*\nWait! Let me check something! \n*frantically pulls out books*\n\nThe spell Casiel showed us, where did it come from? Which book exactly?");
        cvPortal2.addOptionText(PORTUGUESE, "[Explicar o portal falho e a batalha com Targon]", "*Rosto empalidece enquanto você fala*\nFumaça roxa e negra... nenhum portal se abriu... \n*de repente corre para uma estante*\nEspere! Deixe-me verificar algo! \n*puxa livros freneticamente*\n\nO feitiço que Casiel nos mostrou, de onde veio? De qual livro exatamente?");
        cvPortal2.addOptionText(SPANISH, "[Explicar el portal fallido y la batalla con Targon]", "*El rostro palidece mientras hablas*\nHumo púrpura y negro... ningún portal se abrió... \n*de repente corre hacia un estante*\n¡Espera! ¡Déjame verificar algo! \n*saca libros frenéticamente*\n\n¿El hechizo que Casiel nos mostró, de dónde vino? ¿De qué libro exactamente?");
        npc.conversationOptions.add(cvPortal2);

        ConversationOption cvPortal3 = new ConversationOption(4, 5);
        cvPortal3.addOptionText(ENGLISH, "He said it was from a tome on counter-spells against demons.", "*Examines several books, then picks up one specific tome*\nThis one? \n*studies it intensely*\n[PLAYERNAME]... this book... \n*voice trembling*\nThe binding, the ink, even the parchment - they're all wrong. This isn't an ancient elvish text. This book is... recent. Very recent. Weeks old at most.\n\n*Looks at you with horror*\nSomeone placed this fake book in our library. And the spell written in it... it's not a counter-portal. It's useless smoke and light. A deception.");
        cvPortal3.addOptionText(PORTUGUESE, "Ele disse que era de um tomo sobre contra-feitiços contra demônios.", "*Examina vários livros, então pega um tomo específico*\nEste aqui? \n*estuda intensamente*\n[PLAYERNAME]... este livro... \n*voz tremendo*\nA encadernação, a tinta, até o pergaminho - estão todos errados. Este não é um texto élfico ancestral. Este livro é... recente. Muito recente. No máximo poucas semanas.\n\n*Olha para você com horror*\nAlguém colocou este livro falso em nossa biblioteca. E o feitiço escrito nele... não é um contra-portal. É fumaça e luz inúteis. Um engano.");
        cvPortal3.addOptionText(SPANISH, "Dijo que era de un tomo sobre contrahechizos contra demonios.", "*Examina varios libros, luego toma un tomo específico*\n¿Este? \n*estudia intensamente*\n[PLAYERNAME]... este libro... \n*voz temblando*\nLa encuadernación, la tinta, incluso el pergamino - todos están mal. Este no es un texto élfico ancestral. Este libro es... reciente. Muy reciente. Unas pocas semanas como máximo.\n\n*Te mira con horror*\nAlguien colocó este libro falso en nuestra biblioteca. Y el hechizo escrito en él... no es un contraportal. Es humo y luz inútiles. Un engaño.");
        npc.conversationOptions.add(cvPortal3);

        ConversationOption cvPortal4 = new ConversationOption(5, 0);
        cvPortal4.addOptionText(ENGLISH, "But that means... Casiel lied to us?", "*Nods slowly, tears forming*\nYes. Casiel... betrayed us all. He deliberately gave you a false spell, knowing you would face Targon with useless magic. He wanted the portal to fail. He wanted Targon to succeed.\n\n*Voice breaks*\nWhy? Why would he do this? He's the High Mage of Ayalon! He's supposed to protect us! \n*Composes herself*\n[PLAYERNAME], Casiel has fled. He's not in the city square, not anywhere in Ayalon. He knew what would happen and ran. You must find him and discover why he committed this treachery. Check with the other elves - someone must have seen where he went!");
        cvPortal4.addOptionText(PORTUGUESE, "Mas isso significa... Casiel mentiu para nós?", "*Acena lentamente, lágrimas se formando*\nSim. Casiel... traiu a todos nós. Ele deliberadamente te deu um feitiço falso, sabendo que você enfrentaria Targon com magia inútil. Ele queria que o portal falhasse. Ele queria que Targon tivesse sucesso.\n\n*Voz quebra*\nPor quê? Por que ele faria isso? Ele é o Alto Mago de Ayalon! Ele deveria nos proteger! \n*Se recompõe*\n[PLAYERNAME], Casiel fugiu. Ele não está na praça da cidade, não está em lugar nenhum de Ayalon. Ele sabia o que aconteceria e fugiu. Você deve encontrá-lo e descobrir por que cometeu esta traição. Verifique com os outros elfos - alguém deve ter visto para onde ele foi!");
        cvPortal4.addOptionText(SPANISH, "Pero eso significa... ¿Casiel nos mintió?", "*Asiente lentamente, lágrimas formándose*\nSí. Casiel... nos traicionó a todos. Deliberadamente te dio un hechizo falso, sabiendo que enfrentarías a Targon con magia inútil. Quería que el portal fallara. Quería que Targon tuviera éxito.\n\n*La voz se quiebra*\n¿Por qué? ¿Por qué haría esto? ¡Es el Alto Mago de Ayalon! ¡Se supone que debe protegernos! \n*Se recompone*\n[PLAYERNAME], Casiel huyó. No está en la plaza de la ciudad, no está en ningún lugar de Ayalon. Sabía lo que pasaría y huyó. ¡Debes encontrarlo y descubrir por qué cometió esta traición! ¡Verifica con los otros elfos - alguien debe haber visto adónde fue!");
        cvPortal4.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.THE_PORTAL, App.getPlayerChar(), 6, ctx);
            LibQuest.includeQuestToQuestbook(QuestsIds.TRAITOR, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPortal4);

        // ===== TRAITOR QUEST: Give Ancient Elven Prophecies book =====
        ConversationOption cvAncientBook = new ConversationOption(0, 0);
        cvAncientBook.addOptionText(ENGLISH, "Any information about what Casiel might be seeking?", "*Searches through her translated notes*\nAfter discovering his betrayal, I've been researching everything I could find about dark magic and the motivations behind such treachery. \n\n*pulls out a compiled tome*\nI've translated and compiled information from multiple ancient texts - prophecies, warnings, knowledge about the Death King and the powers that corrupt even good souls. Take this, [PLAYERNAME]. It may help you understand what drove Casiel to such darkness, and more importantly, what he's truly capable of achieving.\n\n*hands you the book with a grave expression*\nKnowledge is our greatest weapon against the shadows ahead.");
        cvAncientBook.addOptionText(PORTUGUESE, "Alguma informação sobre o que Casiel pode estar buscando?", "*Procura através de suas notas traduzidas*\nApós descobrir sua traição, tenho pesquisado tudo que pude encontrar sobre magia negra e as motivações por trás de tal traição. \n\n*puxa um tomo compilado*\nTraduzi e compilei informações de múltiplos textos ancestrais - profecias, avisos, conhecimento sobre o Rei da Morte e os poderes que corrompem até almas boas. Pegue isto, [PLAYERNAME]. Pode ajudá-lo a entender o que levou Casiel a tal escuridão, e mais importante, do que ele é verdadeiramente capaz de alcançar.\n\n*entrega o livro com expressão grave*\nConhecimento é nossa maior arma contra as sombras à frente.");
        cvAncientBook.addOptionText(SPANISH, "Alguna información sobre lo que Casiel podría estar buscando?", "*Busca entre sus notas traducidas*\nDespués de descubrir su traición, he estado investigando todo lo que pude encontrar sobre magia oscura y las motivaciones detrás de tal traición. \n\n*saca un tomo compilado*\nHe traducido y compilado información de múltiples textos ancestrales - profecías, advertencias, conocimiento sobre el Rey de la Muerte y los poderes que corrompen incluso a las almas buenas. Toma esto, [PLAYERNAME]. Puede ayudarte a entender qué llevó a Casiel a tal oscuridad, y más importante, de lo que es verdaderamente capaz de lograr.\n\n*te entrega el libro con expresión grave*\nEl conocimiento es nuestra mayor arma contra las sombras que se avecinan.");
        cvAncientBook.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(QuestsIds.TRAITOR, chara) &&
                    !LibInventory.checkHasItemAmount(ItemsIds.ANCIENT_ELVEN_PROPHECIES, 1, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvAncientBook.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.ANCIENT_ELVEN_PROPHECIES, 1, App.getPlayerChar());
            String itemName = App.DataManager.getItem(ItemsIds.ANCIENT_ELVEN_PROPHECIES).getName(App.CURRENT_LANGUAGE);
            LibUtils.showToast(LibUtils.getString(R.string.receivedItem, ctx) + itemName, 0, CoreEnums.MessageType.INFO, ctx);
        };
        npc.conversationOptions.add(cvAncientBook);

        // ===== ELFS AND HUMANS QUEST =====

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
        cvElfsHumans4.addOptionText(PORTUGUESE, "[Pegar o pergaminho traduzido]", "Espero que isso ajude Eldrin a entender não apenas a história, mas quanto respeito mútuo existia entre nossos povos. As palavras da Anciã Aelrindel mostram que os elfos não apenas toleravam os humanos - nós os admirávamos, aprendíamos com eles e os víamos como iguais. Esse espírito de unidade... é algo que espero que possamos redescobrir. Eu voultarei o pergaminho original para Gisela no templo.");
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
        cvElfsHumansAfter.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.ELFS_AND_HUMANS)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfsHumansAfter);

        ConversationOption cvRoleplay = new ConversationOption(0, 0);
        cvRoleplay.addOptionText(ENGLISH, "What do you think of studying here?", "*Her eyes light up*\nIt is literally magical! I am fascinated by all these books and scrolls. Barolas has been incredibly kind.\nEverything I have studied until now finally makes complete sense, now that I am experiencing it firsthand and still being able to help protect our kingdoms.");
        cvRoleplay.addOptionText(PORTUGUESE, "O que está achando de estudar aqui?", "*Seus olhos brilham*\nÉ literalmente mágico! Estou fascinada com todos estes livros e pergaminhos. Barolas está sendo muito gentil.\nTudo que estudei até hoje finalmente faz todo sentido agora que estou vivenciando isso e ainda podendo ajudar a proteger nossos reinos.");
        cvRoleplay.addOptionText(SPANISH, "¿Qué te parece estudiar aquí?", "*Sus ojos brillan*\n¡Es literalmente mágico! Estoy fascinada con todos estos libros y pergaminos. Barolas está siendo muy amable.\nTodo lo que estudié hasta ahora finalmente tiene pleno sentido ahora que lo estoy viviendo de primera mano y aun pudiendo ayudar a proteger nuestros reinos.");
        npc.conversationOptions.add(cvRoleplay);

        return npc;
    }
}
