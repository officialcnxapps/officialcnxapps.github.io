package com.cnx.endlesstalestwo.data.npcs.havarusSouth.umera;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import android.os.Looper;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.GameEngine;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.shops.ShopsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Eldrin extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, eldrin());
    }

    Npc eldrin() {
        Npc npc = new Npc("Eldrin");
        npc.age = 56;
        npc.job = Enums.NPCJobs.MALE_BLACKSMITH;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A skilled and dedicated craftsman.\nHe works for the village and by the village.\nHe is nostalgic, yet knows how to live well in the present.\n\nHis physical traits: Green eyes, dark hair. Well-groomed beard. Pointed ears. Defined and square face.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um artesão habilidoso e dedicado.\nTrabalha para a vila e pela vila.\nÉ nostálgico, porém sabe viver bem o presente.\n\nSeus traços físicos: Olhos verdes, cabelos escuros. Barba bem feita. Orelhas pontiagudas. Rosto definido e quadrado.");
        npc.addDescriptionTranslation(SPANISH, "Un artesano habilidoso y dedicado.\nTrabaja por la aldea y para la aldea.\nEs nostálgico, pero sabe vivir bien el presente.\n\nSus rasgos físicos: Ojos verdes, cabello oscuro. Barba bien cuidada. Orejas puntiagudas. Rostro definido y cuadrado.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Ah, greetings traveler!"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Ah, saudações, viajante!"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Ah, saludos, viajero!"));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Safe travels!"));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Boa viagem!"));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Viaje seguro!"));

        ConversationOption cv5 = new ConversationOption(0, 1);
        cv5.addOptionText(ENGLISH, "Are you an elf? Your ears are quite pointy.", "Ah, a keen observation. I am half-elf, half-human. I inherited my mother's ears and my father's craftsmanship.");
        cv5.addOptionText(PORTUGUESE, "Você é um elfo? Suas orelhas são bem pontudas.", "Ah, uma observação perspicaz. Sou meio-elfo, meio-humano. Herdei as orelhas de minha mãe e a habilidade de meu pai.");
        cv5.addOptionText(SPANISH, "¿Eres un elfo? Tus orejas son bastante puntiagudas.", "Ah, una observación aguda. Soy mitad elfo, mitad humano. Heredé las orejas de mi madre y la artesanía de mi padre.");
        cv5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.STRATEGY)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.STRATEGY, 2)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.STRATEGY, 3)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cv5);

        ConversationOption cv6 = new ConversationOption(1, 0);
        cv6.addOptionText(ENGLISH, "How did your parents meet?", "Ah, that takes me back. Fifty years ago, things were different. Humans and elves shared a closer bond, a friendship that has unfortunately faded a bit with time. My mother, an elven healer, was tending to the wounded in a human village after a harsh winter. My father, a young blacksmith at the time, was impressed by her skill and compassion. They started talking, sharing stories and laughter. It wasn't a dramatic meeting, just two souls finding solace in each other during a time of shared hardship and burgeoning friendship between our peoples.");
        cv6.addOptionText(PORTUGUESE, "Como seus pais se conheceram?", "Ah, isso me traz recordações. Cinquenta anos atrás, as coisas eram diferentes. Humanos e elfos compartilhavam um laço mais próximo, uma amizade que infelizmente se desgastou um pouco com o tempo. Minha mãe, uma curandeira élfica, estava cuidando dos feridos em uma vila humana após um inverno rigoroso. Meu pai, um jovem ferreiro na época, ficou impressionado com a habilidade e compaixão dela. Começaram a conversar, compartilhando histórias e risadas. Não foi um encontro dramático, apenas duas almas encontrando consolo uma na outra durante um tempo de dificuldades compartilhadas e amizade crescente entre nossos povos.");
        cv6.addOptionText(SPANISH, "¿Cómo se conocieron tus padres?", "Ah, eso me trae recuerdos. Hace cincuenta años, las cosas eran diferentes. Los humanos y los elfos compartían un vínculo más estrecho, una amistad que lamentablemente se ha desvanecido un poco con el tiempo. Mi madre, una sanadora elfa, estaba atendiendo a los heridos en una aldea humana después de un duro invierno. Mi padre, un joven herrero en ese entonces, quedó impresionado por su habilidad y compasión. Empezaron a hablar, compartiendo historias y risas. No fue un encuentro dramático, solo dos almas encontrando consuelo la una en la otra durante una época de dificultades compartidas y amistad floreciente entre nuestros pueblos.");
        npc.conversationOptions.add(cv6);

        // ===== STRATEGY QUEST: Part 2 - Route to elves =====
        ConversationOption cvStrategy1 = new ConversationOption(0, 2);
        cvStrategy1.addOptionText(ENGLISH, "Queen Enola sent me. I need to reach the elves.", "*looks up sharply from his work*\nThe elves? That's... unexpected. Few humans even remember Ayalon exists, let alone seek to go there. Why would Queen Enola send you to the elven kingdom?");
        cvStrategy1.addOptionText(PORTUGUESE, "A Rainha Enola me enviou. Preciso chegar aos elfos.", "*levanta a cabeça bruscamente de seu trabalho*\nOs elfos? Isso é... inesperado. Poucos humanos sequer lembram que Ayalon existe, quanto mais procuram ir para lá. Por que a Rainha Enola te enviaria ao reino élfico?");
        cvStrategy1.addOptionText(SPANISH, "La Reina Enola me envió. Necesito llegar a los elfos.", "*levanta la mirada bruscamente de su trabajo*\n¿Los elfos? Eso es... inesperado. Pocos humanos siquiera recuerdan que Ayalon existe, mucho menos buscan ir allí. ¿Por qué la Reina Enola te enviaría al reino élfico?");
        cvStrategy1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.STRATEGY, 2) &&
                    LibInventory.checkHasItem(ItemsIds.QUEENS_REQUISITION_LETTER, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvStrategy1);

        ConversationOption cvStrategy2 = new ConversationOption(2, 3);
        cvStrategy2.addOptionText(ENGLISH, "We need their help against dark forces.", "*sets down his hammer, expression grave*\nDark forces... I've heard whispers. Attacks on villages, creatures that shouldn't exist. My elven blood allows me to sense disturbances in the natural order, and lately... something feels deeply wrong. If the Queen seeks elven aid, things must be truly dire. Do you have proof of your mission?");
        cvStrategy2.addOptionText(PORTUGUESE, "Precisamos da ajuda deles contra forças das trevas.", "*coloca seu martelo no chão, expressão grave*\nForças das trevas... Ouvi rumores. Ataques a vilas, criaturas que não deveriam existir. Meu sangue élfico me permite sentir distúrbios na ordem natural e, ultimamente... algo parece profundamente errado. Se a Rainha busca ajuda élfica, as coisas devem estar realmente terríveis. Você tem prova de sua missão?");
        cvStrategy2.addOptionText(SPANISH, "Necesitamos su ayuda contra fuerzas oscuras.", "*deja su martillo, expresión grave*\nFuerzas oscuras... He oído rumores. Ataques a aldeas, criaturas que no deberían existir. Mi sangre élfica me permite sentir perturbaciones en el orden natural, y últimamente... algo se siente profundamente mal. Si la Reina busca ayuda élfica, las cosas deben estar realmente graves. ¿Tienes prueba de tu misión?");
        npc.conversationOptions.add(cvStrategy2);

        ConversationOption cvStrategy3 = new ConversationOption(3, 4);
        cvStrategy3.addOptionText(ENGLISH, "[Show the Queen's letter]", "*takes the letter reverently, examining the royal seal*\nThis is genuine. The royal seal of Havarus... I never thought I'd see such a document. \n*reads carefully*\nA formal requisition for alliance and magical aid. This is historic - if the elves accept, it could reunite our peoples after decades of separation.");
        cvStrategy3.addOptionText(PORTUGUESE, "[Mostrar a carta da Rainha]", "*pega a carta com reverência, examinando o selo real*\nIsso é genuíno. O selo real de Havarus... Nunca pensei que veria tal documento. \n*lê cuidadosamente*\nUma requisição formal de aliança e ajuda mágica. Isso é histórico - se os elfos aceitarem, pode reunir nossos povos após décadas de separação.");
        cvStrategy3.addOptionText(SPANISH, "[Muestra la carta de la Reina]", "*toma la carta con reverencia, examinando el sello real*\nEsto es genuino. El sello real de Havarus... Nunca pensé que vería tal documento. \n*lee cuidadosamente*\nUna requisición formal de alianza y ayuda mágica. Esto es histórico: si los elfos aceptan, podría reunir a nuestros pueblos después de décadas de separación.");
        npc.conversationOptions.add(cvStrategy3);

        ConversationOption cvStrategy4 = new ConversationOption(4, 5);
        cvStrategy4.addOptionText(ENGLISH, "Can you tell me how to reach them?", "I can, but it's not a simple journey. Naval routes to Ayalon were closed generations ago when the elves raised magical barriers around their waters. The only remaining path is through the ancient portal of Gybralar - a magical gateway created long ago when humans and elves were true allies.");
        cvStrategy4.addOptionText(PORTUGUESE, "Você pode me dizer como alcançá-los?", "Posso, mas não é uma jornada simples. As rotas navais para Ayalon foram fechadas há gerações, quando os elfos ergueram barreiras mágicas em torno de suas águas. O único caminho restante é através do portal antigo de Gybralar - um portal mágico criado há muito tempo, quando humanos e elfos eram verdadeiros aliados.");
        cvStrategy4.addOptionText(SPANISH, "¿Puedes decirme cómo llegar a ellos?", "Puedo, pero no es un viaje simple. Las rutas navales a Ayalon se cerraron hace generaciones cuando los elfos levantaron barreras mágicas alrededor de sus aguas. El único camino restante es a través del portal antiguo de Gybralar: una puerta mágica creada hace mucho tiempo cuando humanos y elfos eran verdaderos aliados.");
        npc.conversationOptions.add(cvStrategy4);

        ConversationOption cvStrategy5 = new ConversationOption(5, 0);
        cvStrategy5.addOptionText(ENGLISH, "Where is this portal?", "Deep within the central forest of Gybralar. There's a tunnel - overgrown and forgotten by most. Inside, you'll find a statue of Aelindra, the elven goddess of passage. The portal lies beyond.\n\nBut I must warn you... I don't know exactly what's required to activate it. The statue guards ancient magic - it may test you, or demand something. My mother spoke of it only in fragments before she passed. What I can tell you is that Aelindra values respect for nature and old ways. Beyond that... you'll have to discover for yourself.");
        cvStrategy5.addOptionText(PORTUGUESE, "Onde fica esse portal?", "No fundo da floresta central de Gybralar. Há um túnel - coberto de vegetação e esquecido pela maioria. Dentro, você encontrará uma estátua de Aelindra, a deusa élfica da passagem. O portal fica além.\n\nMas devo avisá-lo... não sei exatamente o que é necessário para ativá-lo. A estátua guarda magia antiga - pode testá-lo ou exigir algo. Minha mãe falava sobre isso apenas em fragmentos antes de falecer. O que posso dizer é que Aelindra valoriza o respeito pela natureza e pelos caminhos antigos. Além disso... você terá que descobrir por si mesmo.");
        cvStrategy5.addOptionText(SPANISH, "¿Dónde está ese portal?", "En lo profundo del bosque central de Gybralar. Hay un túnel: cubierto de vegetación y olvidado por la mayoría. Dentro, encontrarás una estatua de Aelindra, la diosa élfica del pasaje. El portal está más allá.\n\nPero debo advertirte... no sé exactamente qué se requiere para activarlo. La estatua guarda magia antigua: puede ponerte a prueba o exigir algo. Mi madre hablaba de ello solo en fragmentos antes de fallecer. Lo que puedo decirte es que Aelindra valora el respeto por la naturaleza y los caminos antiguos. Más allá de eso... tendrás que descubrirlo por ti mismo.");
        cvStrategy5.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.STRATEGY, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvStrategy5);

        // ===== ELF KNOWLEDGE QUEST: Part 1 - Where to find White Herbs =====
        ConversationOption cvElfKnowledge1 = new ConversationOption(0, 7);
        cvElfKnowledge1.addOptionText(ENGLISH, "I need rare herbs for the elven goddess.", "*thinks carefully*\nWhite herbs... Yes, I've heard of them. My mother used to speak of sacred herbs that grow in the coldest places, where ice meets stone. If such herbs exist anywhere, it would be in Esperand - the frozen island.");
        cvElfKnowledge1.addOptionText(PORTUGUESE, "Preciso de ervas raras para a deusa élfica.", "*pensa cuidadosamente*\nErvas brancas... Sim, já ouvi falar delas. Minha mãe costumava falar de ervas sagradas que crescem nos lugares mais frios, onde o gelo encontra a pedra. Se tais ervas existem em algum lugar, seria em Esperand - a ilha congelada.");
        cvElfKnowledge1.addOptionText(SPANISH, "Necesito hierbas raras para la diosa élfica.", "*piensa cuidadosamente*\nHierbas blancas... Sí, he oído hablar de ellas. Mi madre solía hablar de hierbas sagradas que crecen en los lugares más fríos, donde el hielo se encuentra con la piedra. Si tales hierbas existen en algún lugar, sería en Esperand - la isla congelada.");
        cvElfKnowledge1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELF_KNOWLEDGE, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfKnowledge1);

        ConversationOption cvElfKnowledge2 = new ConversationOption(7, 0);
        cvElfKnowledge2.addOptionText(ENGLISH, "In Esperand? Where exactly?", "The icy caves, deep within the frozen mountains. White herbs are said to grow in the darkest corners of those caves, drawing power from the ancient ice itself. They're rare - you'll need to search carefully. The caves can be dangerous, so be prepared. Take what you need and return to the goddess statue with your offering.");
        cvElfKnowledge2.addOptionText(PORTUGUESE, "Em Esperand? Onde exatamente?", "As cavernas geladas, nas profundezas das montanhas congeladas. Diz-se que as ervas brancas crescem nos cantos mais escuros dessas cavernas, extraindo poder do gelo ancestral. São raras - você precisará procurar com cuidado. As cavernas podem ser perigosas, então esteja preparado. Pegue o que precisa e retorne à estátua da deusa com sua oferenda.");
        cvElfKnowledge2.addOptionText(SPANISH, "¿En Esperand? ¿Dónde exactamente?", "Las cuevas heladas, en lo profundo de las montañas congeladas. Se dice que las hierbas blancas crecen en los rincones más oscuros de esas cuevas, extrayendo poder del hielo ancestral. Son raras - necesitarás buscar cuidadosamente. Las cuevas pueden ser peligrosas, así que prepárate. Toma lo que necesites y regresa a la estatua de la diosa con tu ofrenda.");
        cvElfKnowledge2.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.ELF_KNOWLEDGE, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvElfKnowledge2);

        // ===== ELFS AND HUMANS QUEST =====

        // Part 1: Quest Introduction
        ConversationOption cvElfsHumans1 = new ConversationOption(0, 10);
        cvElfsHumans1.addOptionText(ENGLISH, "You seem thoughtful today, Eldrin.", "*Sets down hammer and sighs*\nI've been thinking about my heritage. Being half-elf, half-human... I've always felt caught between two worlds. My mother's people and my father's people were once close allies, but now there's distance between them. I want to understand what happened, why they drifted apart.");
        cvElfsHumans1.addOptionText(PORTUGUESE, "Você parece pensativo hoje, Eldrin.", "*Coloca o martelo no chão e suspira*\nTenho pensado sobre minha herança. Sendo meio-elfo, meio-humano... sempre me senti preso entre dois mundos. O povo de minha mãe e o povo de meu pai já foram aliados próximos, mas agora há distância entre eles. Quero entender o que aconteceu, por que se afastaram.");
        cvElfsHumans1.addOptionText(SPANISH, "Pareces pensativo hoy, Eldrin.", "*Deja el martillo y suspira*\nHe estado pensando en mi herencia. Siendo mitad elfo, mitad humano... siempre me he sentido atrapado entre dos mundos. El pueblo de mi madre y el pueblo de mi padre una vez fueron aliados cercanos, pero ahora hay distancia entre ellos. Quiero entender qué pasó, por qué se distanciaron.");
        cvElfsHumans1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.THE_ELF_LIBRARY) &&
                    !LibQuest.charHasQuest(QuestsIds.ELFS_AND_HUMANS, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfsHumans1);

        ConversationOption cvElfsHumans2 = new ConversationOption(10, 11);
        cvElfsHumans2.addOptionText(ENGLISH, "Perhaps I can help you understand.", "Would you? \n*eyes light up*\nI've heard that Nelera, the scholar who helped with the elven library. She knows more about the history between our peoples than anyone. Could you speak with her? Ask if she has texts about the ancient alliance?");
        cvElfsHumans2.addOptionText(PORTUGUESE, "Talvez eu possa ajudá-lo a entender.", "Você faria isso? \n*olhos se iluminam*\nOuvi dizer que Nelera, a estudiosa que ajudou com a biblioteca élfica. Ela sabe mais sobre a história entre nossos povos do que qualquer um. Você poderia falar com ela? Perguntar se ela tem textos sobre a antiga aliança?");
        cvElfsHumans2.addOptionText(SPANISH, "Quizás pueda ayudarte a entender.", "¿Lo harías? \n*los ojos se iluminan*\nHe oído que Nelera, la erudita que ayudó con la biblioteca élfica. Ella sabe más sobre la historia entre nuestros pueblos que nadie. ¿Podrías hablar con ella? ¿Preguntarle si tiene textos sobre la antigua alianza?");
        npc.conversationOptions.add(cvElfsHumans2);

        ConversationOption cvElfsHumans3 = new ConversationOption(11, 0);
        cvElfsHumans3.addOptionText(ENGLISH, "I'll find Nelera for you.", "Thank you, my friend. This means more to me than you know. Understanding the past might help me understand myself better. Please, tell Nelera that I seek knowledge about our shared history.");
        cvElfsHumans3.addOptionText(PORTUGUESE, "Vou encontrar Nelera por você.", "Obrigado, meu amigo. Isso significa mais para mim do que você imagina. Entender o passado pode me ajudar a me entender melhor. Por favor, diga a Nelera que busco conhecimento sobre nossa história compartilhada.");
        cvElfsHumans3.addOptionText(SPANISH, "Encontraré a Nelera por ti.", "Gracias, amigo mío. Esto significa más para mí de lo que sabes. Entender el pasado podría ayudarme a entenderme mejor a mí mismo. Por favor, dile a Nelera que busco conocimiento sobre nuestra historia compartida.");
        cvElfsHumans3.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.ELFS_AND_HUMANS, App.getPlayerChar(), ctx);
            LibQuest.updateQuest(QuestsIds.ELFS_AND_HUMANS, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvElfsHumans3);

        // Part 3: Received Golden Age Chronicle
        ConversationOption cvElfsHumans4 = new ConversationOption(0, 12);
        cvElfsHumans4.addOptionText(ENGLISH, "Nelera sent this chronicle about the Golden Age.", "*takes the book reverently*\nThe Chronicle of the Golden Age... \n*opens the book carefully*\nLook at this! Elves and humans building together, sharing knowledge of magic and craft. This was when my parents' love story would have been common, not exceptional. How beautiful it must have been.\n\n*reads for a moment, then looks up thoughtfully*\nThis shows the glory, but I need to understand more. I want to see how the elves viewed us humans in their own words.");
        cvElfsHumans4.addOptionText(PORTUGUESE, "Nelera enviou esta crônica sobre a Era Dourada.", "*pega o livro com reverência*\nA Crônica da Era Dourada... \n*abre o livro cuidadosamente*\nOlhe para isso! Elfos e humanos construindo juntos, compartilhando conhecimento de magia e artesanato. Foi quando a história de amor dos meus pais teria sido comum, não excepcional. Como deve ter sido lindo.\n\n*lê por um momento, então ergue os olhos pensativo*\nIsso mostra a glória, mas preciso entender mais. Quero ver como os elfos nos viam, a nós humanos, em suas próprias palavras.");
        cvElfsHumans4.addOptionText(SPANISH, "Nelera envió esta crónica sobre la Edad de Oro.", "*toma el libro con reverencia*\nLa Crónica de la Edad de Oro... \n*abre el libro cuidadosamente*\n¡Mira esto! Elfos y humanos construyendo juntos, compartiendo conocimiento de magia y artesanía. Fue cuando la historia de amor de mis padres habría sido común, no excepcional. Qué hermoso debe haber sido.\n\n*lee por un momento, luego levanta la vista pensativo*\nEsto muestra la gloria, pero necesito entender más. Quiero ver cómo los elfos nos veían a nosotros los humanos en sus propias palabras.");
        cvElfsHumans4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELFS_AND_HUMANS, 3) &&
                    LibInventory.checkHasItem(ItemsIds.CHRONICLE_OF_THE_GOLDEN_AGE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfsHumans4);

        ConversationOption cvElfsHumans5 = new ConversationOption(12, 0);
        cvElfsHumans5.addOptionText(ENGLISH, "Where can we find such a text?", "My mother once told me about a sacred scroll preserved in Ayalon's Temple. It was written by an elven elder who lived among humans and documented her observations. If anyone can help you find it, it would be Gisela, the temple keeper. \n*hands you a note*\nTake this to her - it explains what we seek. The temple is in Ayalon, not far from the library.");
        cvElfsHumans5.addOptionText(PORTUGUESE, "Onde podemos encontrar tal texto?", "Minha mãe uma vez me contou sobre um pergaminho sagrado preservado no Templo de Ayalon. Foi escrito por uma anciã élfica que viveu entre humanos e documentou suas observações. Se alguém pode ajudá-lo a encontrá-lo, seria Gisela, a guardiã do templo. \n*entrega uma nota*\nLeve isto a ela - explica o que buscamos. O templo fica em Ayalon, não muito longe da biblioteca.");
        cvElfsHumans5.addOptionText(SPANISH, "¿Dónde podemos encontrar tal texto?", "Mi madre una vez me contó sobre un pergamino sagrado preservado en el Templo de Ayalon. Fue escrito por una anciana élfica que vivió entre humanos y documentó sus observaciones. Si alguien puede ayudarte a encontrarlo, sería Gisela, la guardiana del templo. \n*te entrega una nota*\nLlévale esto - explica lo que buscamos. El templo está en Ayalon, no muy lejos de la biblioteca.");
        cvElfsHumans5.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.CHRONICLE_OF_THE_GOLDEN_AGE, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.ELFS_AND_HUMANS, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvElfsHumans5);

        // Part 6: Received translated scroll
        ConversationOption cvElfsHumans6 = new ConversationOption(0, 13);
        cvElfsHumans6.addOptionText(ENGLISH, "I have the translated scroll from the temple.", "*takes the scroll eagerly*\nLet me read... \n*reads quietly, eyes moving across the page*\n\n*voice soft with emotion*\n'Humans burn with intensity born of brevity... They love fiercely because they have so little time...'\n\nThis elven elder understood us so well. She saw our urgency not as weakness but as strength. The way she describes human passion and innovation... it's beautiful.");
        cvElfsHumans6.addOptionText(PORTUGUESE, "Tenho o pergaminho traduzido do templo.", "*pega o pergaminho ansiosamente*\nDeixe-me ler... \n*lê silenciosamente, olhos movendo pela página*\n\n*voz suave com emoção*\n'Humanos queimam com intensidade nascida da brevidade... Eles amam ferozmente porque têm tão pouco tempo...'\n\nEsta anciã élfica nos entendia tão bem. Ela viu nossa urgência não como fraqueza mas como força. A forma como ela descreve a paixão e inovação humana... é linda.");
        cvElfsHumans6.addOptionText(SPANISH, "Tengo el pergamino traducido del templo.", "*toma el pergamino ansiosamente*\nDéjame leer... \n*lee en silencio, ojos moviéndose por la página*\n\n*voz suave con emoción*\n'Los humanos arden con intensidad nacida de la brevedad... Aman ferozmente porque tienen tan poco tiempo...'\n\nEsta anciana élfica nos entendía tan bien. Vio nuestra urgencia no como debilidad sino como fortaleza. La forma en que describe la pasión e innovación humana... es hermosa.");
        cvElfsHumans6.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELFS_AND_HUMANS, 6) &&
                    LibInventory.checkHasItem(ItemsIds.ANCIENT_SCROLL_TRANSLATED, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfsHumans6);

        ConversationOption cvElfsHumans7 = new ConversationOption(13, 0);
        cvElfsHumans7.addOptionText(ENGLISH, "Now you understand how elves saw humanity.", "Yes, and it gives me such hope! They understood us - truly understood us. Our different approaches to life weren't seen as flaws but as complements. \n\n*sets down scroll carefully*\nBut one question still troubles me. If there was such mutual understanding and respect, what happened? Why did we drift apart? Please, return to Nelera one more time. Ask her about the separation itself.");
        cvElfsHumans7.addOptionText(PORTUGUESE, "Agora você entende como os elfos viam a humanidade.", "Sim, e isso me dá tanta esperança! Eles nos entendiam - verdadeiramente nos entendiam. Nossas diferentes abordagens à vida não eram vistas como falhas mas como complementos. \n\n*coloca o pergaminho cuidadosamente*\nMas uma pergunta ainda me perturba. Se havia tal compreensão e respeito mútuos, o que aconteceu? Por que nos afastamos? Por favor, retorne a Nelera mais uma vez. Pergunte a ela sobre a separação em si.");
        cvElfsHumans7.addOptionText(SPANISH, "Ahora entiendes cómo los elfos veían a la humanidad.", "Sí, ¡y me da tanta esperanza! Nos entendían - verdaderamente nos entendían. Nuestros diferentes enfoques de la vida no se veían como fallas sino como complementos. \n\n*deja el pergamino cuidadosamente*\nPero una pregunta aún me perturba. Si había tal entendimiento y respeto mutuos, ¿qué pasó? ¿Por qué nos alejamos? Por favor, regresa a Nelera una vez más. Pregúntale sobre la separación misma.");
        cvElfsHumans7.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.ANCIENT_SCROLL_TRANSLATED, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.ELFS_AND_HUMANS, 7, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvElfsHumans7);

        // Part 8: Final understanding and completion
        ConversationOption cvElfsHumans8 = new ConversationOption(0, 14);
        cvElfsHumans8.addOptionText(ENGLISH, "Nelera explained what caused the separation.", "*listens intently*\nSo it wasn't hatred... not betrayal... just time and distance? \n\n*takes a deep breath*\nThat's... actually comforting. We didn't tear ourselves apart through conflict. We simply drifted like old friends who move to different lands and lose touch over the years.");
        cvElfsHumans8.addOptionText(PORTUGUESE, "Nelera explicou o que causou a separação.", "*escuta atentamente*\nEntão não foi ódio... nem traição... apenas tempo e distância? \n\n*respira fundo*\nIsso é... na verdade reconfortante. Não nos despedaçamos através de conflito. Simplesmente nos afastamos como velhos amigos que se mudam para terras diferentes e perdem contato ao longo dos anos.");
        cvElfsHumans8.addOptionText(SPANISH, "Nelera explicó qué causó la separación.", "*escucha atentamente*\n¿Entonces no fue odio... ni traición... solo tiempo y distancia? \n\n*respira hondo*\nEso es... reconfortante en realidad. No nos destrozamos a través del conflicto. Simplemente nos alejamos como viejos amigos que se mudan a tierras diferentes y pierden contacto con los años.");
        cvElfsHumans8.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELFS_AND_HUMANS, 8)
                    && !LibQuest.isQuestComplete(chara, QuestsIds.ELFS_AND_HUMANS)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfsHumans8);

        ConversationOption cvElfsHumans9 = new ConversationOption(14, 15);
        cvElfsHumans9.addOptionText(ENGLISH, "Does this help you find peace with your heritage?", "*smiles genuinely*\nIt does. More than you know. I spent so long thinking I was torn between two worlds at war, but they were never at war. My existence isn't a bridge over a chasm of conflict - it's a connection between two peoples who simply lost touch.\n\nPerhaps people like me, children of both worlds, can help bring them closer again. Not through grand gestures, but simply by existing and remembering what once was.");
        cvElfsHumans9.addOptionText(PORTUGUESE, "Isso ajuda você a encontrar paz com sua herança?", "*sorri genuinamente*\nAjuda. Mais do que você imagina. Passei tanto tempo pensando que estava dividido entre dois mundos em guerra, mas eles nunca estiveram em guerra. Minha existência não é uma ponte sobre um abismo de conflito - é uma conexão entre dois povos que simplesmente perderam contato.\n\nTalvez pessoas como eu, filhos de ambos os mundos, possam ajudar a aproximá-los novamente. Não através de grandes gestos, mas simplesmente por existir e lembrar do que uma vez foi.");
        cvElfsHumans9.addOptionText(SPANISH, "¿Esto te ayuda a encontrar paz con tu herencia?", "*sonríe genuinamente*\nLo hace. Más de lo que sabes. Pasé tanto tiempo pensando que estaba dividido entre dos mundos en guerra, pero nunca estuvieron en guerra. Mi existencia no es un puente sobre un abismo de conflicto - es una conexión entre dos pueblos que simplemente perdieron contacto.\n\nQuizás personas como yo, hijos de ambos mundos, puedan ayudar a acercarlos de nuevo. No a través de grandes gestos, sino simplemente existiendo y recordando lo que una vez fue.");
        npc.conversationOptions.add(cvElfsHumans9);

        ConversationOption cvElfsHumans10 = new ConversationOption(15, 0);
        cvElfsHumans10.addOptionText(ENGLISH, "I'm glad I could help.", "You've given me something precious, [PLAYERNAME] - understanding and peace. I spent so long feeling torn between two worlds, but now I see I'm not torn at all. I'm whole - a living bridge between peoples who once stood together.\n\n*extends hand with genuine warmth*\nThank you, my friend. You've helped me find peace I didn't know I needed. This knowledge will stay with me forever.");
        cvElfsHumans10.addOptionText(PORTUGUESE, "Fico feliz por poder ajudar.", "Você me deu algo precioso, [PLAYERNAME] - compreensão e paz. Passei tanto tempo me sentindo dividido entre dois mundos, mas agora vejo que não estou dividido. Estou completo - uma ponte viva entre povos que já estiveram juntos.\n\n*estende a mão com calor genuíno*\nObrigado, meu amigo. Você me ajudou a encontrar uma paz que eu não sabia que precisava. Este conhecimento ficará comigo para sempre.");
        cvElfsHumans10.addOptionText(SPANISH, "Me alegra haber podido ayudar.", "Me has dado algo precioso, [PLAYERNAME] - comprensión y paz. Pasé tanto tiempo sintiéndome dividido entre dos mundos, pero ahora veo que no estoy dividido. Estoy completo - un puente viviente entre pueblos que una vez estuvieron juntos.\n\n*extiende la mano con genuino calor*\nGracias, amigo mío. Me has ayudado a encontrar una paz que no sabía que necesitaba. Este conocimiento permanecerá conmigo para siempre.");
        cvElfsHumans10.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.ELFS_AND_HUMANS, App.getPlayerChar(), null, ctx);
        };
        npc.conversationOptions.add(cvElfsHumans10);

        // Roleplay after quest completion
        ConversationOption cvElfsHumansAfter = new ConversationOption(0, 0);
        cvElfsHumansAfter.addOptionText(ENGLISH, "How are you feeling about your heritage now?", "Much better, my friend. I've made peace with who I am. Being half-elf and half-human isn't a burden - it's a gift. A living reminder that our peoples once stood together and could again. Every blade I forge, every tool I craft, carries both traditions within it. That's something to be proud of.");
        cvElfsHumansAfter.addOptionText(PORTUGUESE, "Como você se sente sobre sua herança agora?", "Muito melhor, meu amigo. Fiz as pazes com quem eu sou. Ser meio-elfo e meio-humano não é um fardo - é um presente. Um lembrete vivo de que nossos povos já estiveram juntos e podem estar novamente. Cada lâmina que forjo, cada ferramenta que crio, carrega ambas as tradições dentro de si. Isso é motivo de orgulho.");
        cvElfsHumansAfter.addOptionText(SPANISH, "¿Cómo te sientes acerca de tu herencia ahora?", "Mucho mejor, amigo mío. He hecho las paces con quien soy. Ser mitad elfo y mitad humano no es una carga - es un regalo. Un recordatorio viviente de que nuestros pueblos una vez estuvieron juntos y podrían estarlo de nuevo. Cada hoja que forjo, cada herramienta que creo, lleva ambas tradiciones dentro de sí. Eso es algo de lo que estar orgulloso.");
        cvElfsHumansAfter.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.ELFS_AND_HUMANS)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfsHumansAfter);

        // ===== THE ELF LIBRARY QUEST: Part 2 - Need for translator =====
        ConversationOption cvLibrary1 = new ConversationOption(0, 8);
        cvLibrary1.addOptionText(ENGLISH, "Do you know someone who could translate elf language?", "*Pauses thoughtfully*\nAh, yes... the ancient elven scripts. I know a bit of the elven tongue from my mother, but not enough to translate complex magical texts. However, I do know someone who might help.");
        cvLibrary1.addOptionText(PORTUGUESE, "Conhece alguém que possa traduzir linguagem élfica?", "*Pausa pensativamente*\nAh, sim... a escrita ancestral élfica. Conheço um pouco da língua élfica por minha mãe, mas não o suficiente para traduzir textos mágicos complexos. No entanto, conheço alguém que poderia ajudar.");
        cvLibrary1.addOptionText(SPANISH, "¿Conoces a alguien que pueda traducir idioma elfico?", "*Pausa pensativo*\nAh, sí... la escritura ancestral. Conozco un poco del idioma élfico por mi madre, pero no lo suficiente para traducir textos mágicos complejos. Sin embargo, conozco a alguien que podría ayudar.");
        cvLibrary1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_ELF_LIBRARY, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvLibrary1);

        ConversationOption cvLibrary2 = new ConversationOption(8, 0);
        cvLibrary2.addOptionText(ENGLISH, "Who?", "Her name is Nelera. She lives in Bastian and has dedicated her life to studying elven culture - their language, their history, their ways. She's perhaps the most knowledgeable human scholar on elven matters outside of the elven lands themselves. If anyone can help you translate those texts, it's her.");
        cvLibrary2.addOptionText(PORTUGUESE, "Quem?", "Seu nome é Nelera. Ela mora em Bastian e dedicou sua vida ao estudo da cultura élfica - sua língua, sua história, seus costumes. É talvez a estudiosa humana mais conhecedora em assuntos élficos fora das terras élficas. Se alguém pode ajudá-lo a traduzir esses textos, é ela.");
        cvLibrary2.addOptionText(SPANISH, "¿Quién?", "Su nombre es Nelera. Vive en Bastian y ha dedicado su vida a estudiar la cultura élfica: su idioma, su historia, sus costumbres. Es quizás la erudita humana más conocedora en asuntos élficos fuera de las tierras élficas. Si alguien puede ayudarte a traducir esos textos, es ella.");
        cvLibrary2.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.THE_ELF_LIBRARY, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvLibrary2);

        // ===== USE THE FORGE =====
        ConversationOption cvForge1 = new ConversationOption(0, 20);
        cvForge1.addOptionText(ENGLISH, "Can I use your forge?", "Of course! This forge has served my family for generations. I ask only 1 gold to cover the coal and maintenance. A small price for the craft it enables.");
        cvForge1.addOptionText(PORTUGUESE, "Posso usar sua forja?", "Claro! Esta forja serve à minha família há gerações. Peço apenas 1 ouro para cobrir o carvão e a manutenção. Um preço pequeno para o que ela permite criar.");
        cvForge1.addOptionText(SPANISH, "¿Puedo usar tu forja?", "¡Por supuesto! Esta forja ha servido a mi familia por generaciones. Solo pido 1 de oro para cubrir el carbón y el mantenimiento. Un precio pequeño por lo que permite crear.");
        npc.conversationOptions.add(cvForge1);

        ConversationOption cvForgeAccept = new ConversationOption(20, 0);
        cvForgeAccept.addOptionText(ENGLISH, "Here, 1 gold. [Use the forge]", "Excellent! Take your time. The forge is yours for as long as you need it.");
        cvForgeAccept.addOptionText(PORTUGUESE, "Aqui, 1 ouro. [Usar a forja]", "Excelente! Fique à vontade. A forja é sua pelo tempo que precisar.");
        cvForgeAccept.addOptionText(SPANISH, "Aquí, 1 de oro. [Usar la forja]", "¡Excelente! Tómate tu tiempo. La forja es tuya por el tiempo que necesites.");
        cvForgeAccept.showEvenWhenNotValid = true;
        cvForgeAccept.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cvForgeAccept.listeners = (ctx, currentFragment) -> {
            if (App.getPlayerChar() != null) {
                App.getPlayerChar().removeGold(1);
                if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                    gPlayActivity.lockScreenTouches(true);
                    new android.os.Handler(Looper.getMainLooper()).postDelayed(() -> {
                        GameEngine.saveGame(ctx);
                        gPlayActivity.goToCraft(Enums.CraftTypes.GENERAL);
                    }, 2200);
                }
            }
        };
        npc.conversationOptions.add(cvForgeAccept);

        ConversationOption cvForgeDecline = new ConversationOption(20, 0);
        cvForgeDecline.addOptionText(ENGLISH, "Not now, thank you.", "As you wish. The forge will be here when you need it.");
        cvForgeDecline.addOptionText(PORTUGUESE, "Agora não, obrigado.", "Como quiser. A forja estará aqui quando precisar.");
        cvForgeDecline.addOptionText(SPANISH, "Ahora no, gracias.", "Como quieras. La forja estará aquí cuando la necesites.");
        npc.conversationOptions.add(cvForgeDecline);

        ConversationOption cv4 = new ConversationOption(0, 0);
        cv4.addOptionText(ENGLISH, "Do you sell weapons?", "Of course! We can do business.");
        cv4.addOptionText(PORTUGUESE, "Você vende armas?", "Claro! Podemos fazer negócios.");
        cv4.addOptionText(SPANISH, "¿Vendes armas?", "¡Por supuesto! Podemos hacer negocios.");
        cv4.listeners = (ctx, fragment) -> {
            fragment.setScreenTouchable(false);
            new android.os.Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                    gPlayActivity.goToViewShop(ShopsIds.ELDRINS_FORGE);
                }
            }, 1800);
        };
        npc.conversationOptions.add(cv4);

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Tell me about yourself.", "I am Eldrin, the blacksmith of this village. I've been forging weapons and armor for over 30 years.");
        cv1.addOptionText(PORTUGUESE, "Fale sobre você.", "Eu sou Eldrin, o ferreiro desta vila. Forjo armas e armaduras há mais de 30 anos.");
        cv1.addOptionText(SPANISH, "Háblame de ti.", "Soy Eldrin, el herrero de esta aldea. He estado forjando armas y armaduras durante más de 30 años.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Do you have a family?", "Yes, my wife and son help me at the forge. My son is learning the craft, but he dreams of becoming an adventurer.");
        cv2.addOptionText(PORTUGUESE, "Você tem família?", "Sim, minha esposa e meu filho me ajudam na forja. Meu filho está aprendendo o ofício, mas sonha em se tornar um aventureiro.");
        cv2.addOptionText(SPANISH, "¿Tienes familia?", "Sí, mi esposa y mi hijo me ayudan en la forja. Mi hijo está aprendiendo el oficio, pero sueña con convertirse en aventurero.");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(0, 0);
        cv3.addOptionText(ENGLISH, "How is the village life?", "Peaceful, for the most part. But there have been rumors of bandits nearby, and that worries me.");
        cv3.addOptionText(PORTUGUESE, "Como é a vida na vila?", "Pacífica, na maior parte do tempo. Mas há rumores de bandidos por perto, e isso me preocupa.");
        cv3.addOptionText(SPANISH, "¿Cómo es la vida en la aldea?", "Tranquila, en su mayoría. Pero hay rumores de bandidos cerca, y eso me preocupa.");
        npc.conversationOptions.add(cv3);

        return npc;
    }
}
