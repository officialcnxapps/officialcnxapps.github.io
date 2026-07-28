package com.cnx.endlesstalestwo.data.npcs.wazel.kitchen;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.DRAGONS;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.WAZEL_BATTLE;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Whalika extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Whalika");
        npc.age = 30;
        npc.job = Enums.NPCJobs.STUDENT;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A woman endowed with wisdom and curiosity.\nTeradoch's daughter, she loves her father.\nImpressionable and enthusiastic.\n\nHer physical traits: Dark braided hair. Black skin and slender face. Full lips.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma mulher dotada de sabedoria e curiosidade.\nFilha de Teradoch, ama o pai.\nImpressionável e entusiasmada.\n\nSeus traços físicos: Cabelos trançados e escuros. Pele negra e rosto esbelto. Lábios carnudos.");
        npc.addDescriptionTranslation(SPANISH, "Una mujer dotada de sabiduría y curiosidad.\nHija de Teradoch, ama a su padre.\nImpresionable y entusiasta.\n\nSus rasgos físicos: Cabello trenzado y oscuro. Piel negra y rostro esbelto. Labios carnosos.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Knowledge is the key to understanding our world."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("O conhecimento é a chave para entender nosso mundo."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("El conocimiento es la clave para entender nuestro mundo."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("May wisdom guide your path."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Que a sabedoria guie seu caminho."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Que la sabiduría guíe tu camino."));

        // ===== QUEST INTRO: Dwarven rumors =====
        ConversationOption cvQuestIntro = new ConversationOption(0, 1);
        cvQuestIntro.addOptionText(ENGLISH, "Have you heard any interesting stories lately?", "*Eyes light up with excitement*\nActually, yes! I've been hearing fascinating rumors from desert traders - whispers about dwarves. Not just any dwarves, but an entire underground civilization! They supposedly live deep beneath the desert in a city carved from stone. \n\nThe traders speak of master craftsmen, incredible metalwork, mines that go deeper than anyone imagined. But no one knows exactly where this city is, or if it even truly exists. It could just be desert tales... but what if it's real?");
        cvQuestIntro.addOptionText(PORTUGUESE, "Você ouviu alguma história interessante recentemente?", "*Olhos brilham de empolgação*\nNa verdade, sim! Tenho ouvido rumores fascinantes de comerciantes do deserto - sussurros sobre anões. Não apenas qualquer anão, mas uma civilização subterrânea inteira! Eles supostamente vivem nas profundezas sob o deserto em uma cidade esculpida em pedra. \n\nOs comerciantes falam de mestres artesãos, trabalho em metal incrível, minas que vão mais fundo do que qualquer um imaginava. Mas ninguém sabe exatamente onde fica essa cidade, ou se ela realmente existe. Pode ser apenas contos do deserto... mas e se for real?");
        cvQuestIntro.addOptionText(SPANISH, "¿Has escuchado alguna historia interesante últimamente?", "*Los ojos brillan de emoción*\n¡En realidad, sí! He estado escuchando rumores fascinantes de comerciantes del desierto - susurros sobre enanos. No cualquier enano, ¡sino una civilización subterránea entera! Supuestamente viven en las profundidades bajo el desierto en una ciudad tallada en piedra. \n\nLos comerciantes hablan de maestros artesanos, trabajo en metal increíble, minas que van más profundas de lo que nadie imaginaba. Pero nadie sabe exactamente dónde está esta ciudad, o si realmente existe. Podría ser solo cuentos del desierto... ¿pero qué pasa si es real?");
        cvQuestIntro.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.PEOPLE_OF_THE_DEPTHS, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestIntro);

        // ===== QUEST ACCEPT: Investigate for her =====
        ConversationOption cvQuestAccept = new ConversationOption(1, 0);
        cvQuestAccept.addOptionText(ENGLISH, "I could investigate these rumors for you.", "*Clasps hands together eagerly*\nWould you? That would be incredible! As a scholar, discovering a lost civilization would be... it would be the find of a lifetime! \n\nI wish I could go myself, but my studies keep me here, and honestly, I'm not much of an adventurer. But you - you have the skills and experience to explore where I cannot.\n\nStart by seeking out Mystic Rock in the Deep Crater Cave. It's an ancient entity - some say it's been there for centuries, perhaps millennia. If anyone knows about hidden places beneath the desert, it would be that mysterious being. Please, discover what you can about these dwarves - their culture, their city, everything!");
        cvQuestAccept.addOptionText(PORTUGUESE, "Eu poderia investigar esses rumores para você.", "*Junta as mãos ansiosamente*\nVocê faria isso? Isso seria incrível! Como estudiosa, descobrir uma civilização perdida seria... seria a descoberta de uma vida inteira! \n\nGostaria de poder ir eu mesma, mas meus estudos me mantêm aqui, e honestamente, não sou muito aventureira. Mas você - você tem as habilidades e experiência para explorar onde eu não posso.\n\nComece procurando pela Pedra Mística na Caverna da Cratera Profunda. É uma entidade ancestral - alguns dizem que está lá há séculos, talvez milênios. Se alguém sabe sobre lugares ocultos sob o deserto, seria esse ser misterioso. Por favor, descubra o que puder sobre esses anões - sua cultura, sua cidade, tudo!");
        cvQuestAccept.addOptionText(SPANISH, "Podría investigar esos rumores para ti.", "*Junta las manos ansiosamente*\n¿Lo harías? ¡Eso sería increíble! Como erudita, descubrir una civilización perdida sería... ¡sería el hallazgo de toda una vida! \n\nDesearía poder ir yo misma, pero mis estudios me mantienen aquí, y honestamente, no soy muy aventurera. Pero tú - tienes las habilidades y experiencia para explorar donde yo no puedo.\n\nComienza buscando a la Roca Mística en la Cueva del Cráter Profundo. Es una entidad ancestral - algunos dicen que ha estado allí durante siglos, quizás milenios. Si alguien sabe sobre lugares ocultos bajo el desierto, sería ese ser misterioso. Por favor, descubre lo que puedas sobre estos enanos - su cultura, su ciudad, ¡todo!");
        cvQuestAccept.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.PEOPLE_OF_THE_DEPTHS, App.getPlayerChar(), ctx);
            LibQuest.updateQuest(QuestsIds.PEOPLE_OF_THE_DEPTHS, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuestAccept);

        // ===== QUEST PART 3: Magic word discovery =====
        ConversationOption cvQuestMagicWord = new ConversationOption(0, 2);
        cvQuestMagicWord.addOptionText(ENGLISH, "Mystic Rock says I need a magic word to reach the dwarves.", "*Eyes widen with excitement*\nA magic word! Of course! Many ancient civilizations used sacred words as keys to their domains. \n\n*Rushes to her research materials, flipping through scrolls and books*\nLet me check my notes on dwarven linguistics... Yes! Here it is! In the oldest dwarven texts I've studied, there's a word that appears repeatedly in contexts of gates, passages, and mountain homes...");
        cvQuestMagicWord.addOptionText(PORTUGUESE, "A Pedra Mística diz que preciso de uma palavra mágica para alcançar os anões.", "*Olhos se arregalam de empolgação*\nUma palavra mágica! Claro! Muitas civilizações ancestrais usavam palavras sagradas como chaves para seus domínios. \n\n*Corre para seus materiais de pesquisa, folheando pergaminhos e livros*\nDeixe-me verificar minhas anotações sobre linguística anã... Sim! Aqui está! Nos textos anões mais antigos que estudei, há uma palavra que aparece repetidamente em contextos de portões, passagens e lares das montanhas...");
        cvQuestMagicWord.addOptionText(SPANISH, "La Roca Mística dice que necesito una palabra mágica para alcanzar a los enanos.", "*Los ojos se agrandan de emoción*\n¡Una palabra mágica! ¡Por supuesto! Muchas civilizaciones ancestrales usaban palabras sagradas como llaves para sus dominios. \n\n*Corre a sus materiales de investigación, hojeando pergaminos y libros*\nDéjame revisar mis notas sobre lingüística enana... ¡Sí! ¡Aquí está! En los textos enanos más antiguos que he estudiado, hay una palabra que aparece repetidamente en contextos de puertas, pasajes y hogares de las montañas...");
        cvQuestMagicWord.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestMagicWord);

        ConversationOption cvQuestRevealWord = new ConversationOption(2, 0);
        cvQuestRevealWord.addOptionText(ENGLISH, "What is the word?", "*Looks up triumphantly*\nKhazad-dûm! It's an ancient dwarven phrase meaning 'Dwarven Mountain' or 'Mountain Home'. The dwarves use it as a sacred word of passage - a key to their deepest halls. \n\nSpeak this word to Mystic Rock, and it should recognize you as one who respects dwarven tradition. But remember - you'll also need iron ore. Mystic Rock mentioned that, yes? One piece should suffice. It's symbolic - iron from the earth, returning to the deep places. \n\nGood luck, my friend. You're about to make contact with a civilization few humans have ever seen!");
        cvQuestRevealWord.addOptionText(PORTUGUESE, "Qual é a palavra?", "*Levanta os olhos triunfante*\nKhazad-dûm! É uma frase anã ancestral que significa 'Montanha Anã' ou 'Lar da Montanha'. Os anões a usam como palavra sagrada de passagem - uma chave para seus salões mais profundos. \n\nPronuncie esta palavra para a Pedra Mística, e ela deve reconhecê-lo como alguém que respeita a tradição anã. Mas lembre-se - você também precisará de minério de ferro. A Pedra Mística mencionou isso, sim? Uma peça deve ser suficiente. É simbólico - ferro da terra, retornando aos lugares profundos. \n\nBoa sorte, meu amigo. Você está prestes a fazer contato com uma civilização que poucos humanos já viram!");
        cvQuestRevealWord.addOptionText(SPANISH, "¿Cuál es la palabra?", "*Levanta la vista triunfante*\n¡Khazad-dûm! Es una frase enana ancestral que significa 'Montaña Enana' u 'Hogar de la Montaña'. Los enanos la usan como palabra sagrada de paso - una llave para sus salones más profundos. \n\nPronuncia esta palabra a la Roca Mística, y debería reconocerte como alguien que respeta la tradición enana. Pero recuerda - también necesitarás mineral de hierro. La Roca Mística mencionó eso, ¿sí? Una pieza debería ser suficiente. Es simbólico - hierro de la tierra, regresando a los lugares profundos. \n\n¡Buena suerte, mi amigo! ¡Estás a punto de hacer contacto con una civilización que pocos humanos han visto!");
        cvQuestRevealWord.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.PEOPLE_OF_THE_DEPTHS, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuestRevealWord);

        // ===== QUEST COMPLETE: Return with findings =====
        ConversationOption cvQuestComplete = new ConversationOption(0, 3);
        cvQuestComplete.addOptionText(ENGLISH, "I found the dwarven city! It's called Growrocks.", "*Gasps in amazement*\nYou actually found it! A real dwarven city! \n\n*Pulls out a journal and starts scribbling notes furiously*\nGrowrocks... please, tell me everything! What are they like? Their architecture? Their customs? How do they view humans?");
        cvQuestComplete.addOptionText(PORTUGUESE, "Encontrei a cidade anã! Chama-se Growrocks.", "*Suspira admirada*\nVocê realmente encontrou! Uma cidade anã de verdade! \n\n*Pega um diário e começa a anotar freneticamente*\nGrowrocks... por favor, me conte tudo! Como eles são? Sua arquitetura? Seus costumes? Como eles veem os humanos?");
        cvQuestComplete.addOptionText(SPANISH, "¡Encontré la ciudad enana! Se llama Growrocks.", "*Jadea asombrada*\n¡Realmente la encontraste! ¡Una ciudad enana real! \n\n*Saca un diario y comienza a escribir notas frenéticamente*\nGrowrocks... ¡por favor, cuéntame todo! ¿Cómo son? ¿Su arquitectura? ¿Sus costumbres? ¿Cómo ven a los humanos?");
        cvQuestComplete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestComplete);

        ConversationOption cvQuestFinish = new ConversationOption(3, 0);
        cvQuestFinish.addOptionText(ENGLISH, "They're master craftsmen who value mining and isolation.", "*Writes excitedly*\nFascinating! A civilization that chose isolation not from hostility, but for focus on their craft. The dwarves sound like remarkable people - skilled, honorable, deeply connected to the earth itself. \n\nThis discovery will revolutionize our understanding of the peoples of this world! Thank you, my friend. You've given me material for years of study. The world is so much richer than we knew. Who knows what other hidden peoples might be out there, waiting to be discovered?");
        cvQuestFinish.addOptionText(PORTUGUESE, "São mestres artesãos que valorizam mineração e isolamento.", "*Escreve empolgada*\nFascinante! Uma civilização que escolheu o isolamento não por hostilidade, mas por foco em seu ofício. Os anões parecem ser pessoas notáveis - habilidosos, honrados, profundamente conectados à própria terra. \n\nEsta descoberta revolucionará nossa compreensão dos povos deste mundo! Obrigada, meu amigo. Você me deu material para anos de estudo. O mundo é muito mais rico do que sabíamos. Quem sabe que outros povos ocultos podem estar lá fora, esperando para serem descobertos?");
        cvQuestFinish.addOptionText(SPANISH, "Son maestros artesanos que valoran la minería y el aislamiento.", "*Escribe emocionada*\n¡Fascinante! Una civilización que eligió el aislamiento no por hostilidad, sino por enfoque en su oficio. Los enanos parecen ser personas notables - hábiles, honorables, profundamente conectados con la tierra misma. \n\n¡Este descubrimiento revolucionará nuestra comprensión de los pueblos de este mundo! Gracias, mi amigo. Me has dado material para años de estudio. El mundo es mucho más rico de lo que sabíamos. ¿Quién sabe qué otros pueblos ocultos pueden estar ahí fuera, esperando ser descubiertos?");
        cvQuestFinish.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.PEOPLE_OF_THE_DEPTHS, App.getPlayerChar(), 7, ctx);
        };
        npc.conversationOptions.add(cvQuestFinish);

        // ========================================
        // QUEST: DRAGONS?
        // ========================================

        // Part 2: Talk to Whalika
        ConversationOption cvDragonsPart2 = new ConversationOption(0, 0);
        cvDragonsPart2.addOptionText(ENGLISH, "I'm investigating rumors of dragon migration. I've heard that ancient cycles might be shifting.",
                "Dragon migration? Fascinating! I've read accounts of such things in the ancient texts, but they were always treated as legends from a forgotten era. If there is concern about this, then the danger must be real. \n\nI will research this immediately and contact other historians. In the meantime, you should seek out those who know the high places. I've heard of a famous climber who scales peaks all over the world. He was recently at Great Rock and might have seen something from his high vantage point. Go, find him, and ask what he saw.");
        cvDragonsPart2.addOptionText(PORTUGUESE, "Estou investigando rumores de migração de dragões. Ouvi dizer que os ciclos antigos podem estar mudando.",
                "Migração de dragões? Fascinante! Li relatos de tais coisas nos textos antigos, mas sempre foram tratados como lendas de uma era esquecida. Se há preocupação com isso, então o perigo deve ser real. \n\nVou pesquisar isso imediatamente e contatar outros historiadores. Enquanto isso, você deve procurar aqueles que conhecem os lugares altos. Ouvi falar de um escalador famoso que escala picos em todo o mundo. Ele esteve recentemente na Grande Rocha e pode ter visto algo de seu ponto de vantagem elevado. Vá, encontre-o e pergunte o que ele viu.");
        cvDragonsPart2.addOptionText(SPANISH, "Estoy investigando rumores de migración de dragones. He oído que los ciclos antiguos podrían estar cambiando.",
                "¿Migración de dragones? ¡Fascinante! He leído relatos de tales cosas en los textos antiguos, pero siempre se trataron como leyendas de una era olvidada. Si hay preocupación por esto, entonces el peligro debe ser real. \n\nInvestigaré esto de inmediato y contactaré a otros historiadores. Mientras tanto, deberías buscar a quienes conocen las alturas. He oído de un escalador famoso que escala cimas en todo el mundo. Recientemente estuvo en la Gran Roca y podría haber visto algo desde su elevada posición. Ve, búscale y pregúntale qué vio.");
        cvDragonsPart2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, DRAGONS, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvDragonsPart2.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(DRAGONS, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvDragonsPart2);

        // Part 4: Return to Whalika
        ConversationOption cvDragonsPart4 = new ConversationOption(0, 0);
        cvDragonsPart4.addOptionText(ENGLISH, "The climber confirmed he saw a dragon over the mountains in Esperand.",
                "He did? Then my research is matching the sightings. I've discovered that dragons can migrate to new lands if they feel the climate and environment suit them better, even after centuries of stability. \n\nIf they are indeed moving towards Esperand, we need absolute confirmation. You must investigate the Ice Mountains Peak yourself. It is a dangerous climb, but we must know for certain if they have begun to nest there. Be extremely careful, traveler.");
        cvDragonsPart4.addOptionText(PORTUGUESE, "O escalador confirmou que viu um dragão sobre as montanhas em Esperand.",
                "Ele viu? Então minha pesquisa está batendo com os avistamentos. Descobri que os dragões podem migrar para novas terras se sentirem que o clima e o ambiente lhes convêm melhor, mesmo após séculos de estabilidade. \n\nSe eles estão de fato se movendo para Esperand, precisamos de confirmação absoluta. Você deve investigar o Pico das Montanhas de Gelo você mesmo. É uma escalada perigosa, mas precisamos saber com certeza se eles começaram a fazer ninhos lá. Seja extremamente cuidadoso, viajante.");
        cvDragonsPart4.addOptionText(SPANISH, "El escalador confirmó que vio un dragón sobre las montañas en Esperand.",
                "¿Lo hizo? Entonces mi investigación coincide con los avistamientos. He descubierto que los dragones pueden migrar a nuevas tierras si sienten que el clima y el entorno les convienen mejor, incluso tras siglos de estabilidad. \n\nSi de hecho se están moviendo hacia Esperand, necesitamos una confirmación absoluta. Debes investigar el Pico de las Montañas de Hielo tú mismo. Es una escalada peligrosa, pero debemos saber con certeza si han comenzado a anidar allí. Ten mucho cuidado, viajero.");
        cvDragonsPart4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, DRAGONS, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvDragonsPart4.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(DRAGONS, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvDragonsPart4);

        // Part 6: Report sighting back to Whalika
        ConversationOption cvDragonsPart6 = new ConversationOption(0, 0);
        cvDragonsPart6.addOptionText(ENGLISH, "I saw it. A dragon at the Ice Mountains Peak.",
                "Then it is true. The migration to Havarus and the islands has begun. This is terrifying news. We are not prepared for such a threat. \n\nYou must inform those who are concerned with these ancient threats. If the dwarves have experience with these creatures, you should seek their wisdom immediately. Tell their leaders what you saw. They must know that the danger is no longer a legend — it is at our very doorstep.");
        cvDragonsPart6.addOptionText(PORTUGUESE, "Eu vi. Um dragão no Pico das Montanhas de Gelo.",
                "Então é verdade. A migração para Havarus e as ilhas começou. Estas são notícias terríveis. Não estamos preparados para tal ameaça. \n\nVocê deve informar aqueles que se preocupam com essas ameaças antigas. Se os anões têm experiência com essas criaturas, você deve procurar a sabedoria deles imediatamente. Diga aos seus líderes o que você viu. Eles devem saber que o perigo não é mais uma lenda — está à nossa porta.");
        cvDragonsPart6.addOptionText(SPANISH, "Lo vi. Un dragón en el Pico de las Montañas de Hielo.",
                "Entonces es cierto. La migración a Havarus y las islas ha comenzado. Son noticias terribles. No estamos preparados para tal amenaza. \n\nDebes informar a quienes se preocupan por estas amenazas antiguas. Si los enanos tienen experiencia con estas criaturas, deberías buscar su sabiduría de inmediato. Dile a sus líderes lo que viste. Deben saber que el peligro ya no es una leyenda: está a nuestra misma puerta.");
        cvDragonsPart6.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, DRAGONS, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvDragonsPart6.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(DRAGONS, 7, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvDragonsPart6);

        // ========================================
        // QUEST: TOO POWERFUL
        // ========================================

        // Part 1: Talk to Whalika
        ConversationOption cvTooPowerful1 = new ConversationOption(0, 0);
        cvTooPowerful1.addOptionText(ENGLISH, "Whalika, the dragons have attacked. The watches weren't enough.",
                "*She drops her quill, her hands trembling as she looks at her notes*\nEverywhere? Even Great Rock and the lower peaks? I... I was afraid of this. My research showed they were migrating, but I never imagined they would strike with such coordinated force. \n\nI'm a scholar of history, [PLAYERNAME], not a tactician. I don't know how to expel them once they've claimed a territory. But there are those who do. The dwarves of Growrocks have lived with these creatures for centuries. If anyone knows how to make a dragon feel unwelcome without an army of thousands, it's them. Talk to their Governor. He must have ancient records of how his people defended their halls.");
        cvTooPowerful1.addOptionText(PORTUGUESE, "Whalika, os dragões atacaram. As vigias não foram suficientes.",
                "*Ela solta a pena, as mãos tremendo enquanto olha para suas notas*\nEm toda parte? Até Great Rock e os picos menores? Eu... eu temia isso. Minha pesquisa mostrou que estavam migrando, mas nunca imaginei que atacariam com uma força tão coordenada. \n\nSou uma estudiosa de história, [PLAYERNAME], não uma estrategista. Não sei como expulsá-los uma vez que reivindicaram um território. Mas existem aqueles que sabem. Os anões de Growrocks vivem com essas criaturas há séculos. Se alguém sabe como fazer um dragão se sentir indesejado sem um exército de milhares, são eles. Fale com o Governador dos anões. Ele deve ter registros antigos de como seu povo defendeu seus salões.");
        cvTooPowerful1.addOptionText(SPANISH, "Whalika, los dragones han atacado. Las guardias no fueron suficientes.",
                "*Deja caer su pluma, sus manos tiemblan mientras mira sus notas*\n¿En todas partes? ¿Incluso en Great Rock y las cimas más bajas? Yo... me temía esto. Mi investigación mostró que estaban migrando, pero nunca imaginé que atacarían con una fuerza tan coordinada. \n\nSoy una estudiosa de la historia, [PLAYERNAME], no una estratega. No sé cómo expulsarlos una vez que han reclamado un territorio. Pero hay quienes sí lo saben. Los enanos de Growrocks han vivido con estas criaturas durante siglos. Si alguien sabe cómo hacer que un dragón se sienta incómodo sin un ejército de miles, son ellos. Habla con el Gobernador de los enanos. Debe tener registros antiguos de cómo su pueblo defendió sus salones.");
        cvTooPowerful1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.TOO_POWERFUL, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvTooPowerful1.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(QuestsIds.TOO_POWERFUL, 2, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvTooPowerful1);

        // Part 4: Talk to Whalika again
        ConversationOption cvTooPowerful4 = new ConversationOption(0, 110);
        cvTooPowerful4.addOptionText(ENGLISH, "We can use blood to create a repellent.",
                "*She immediately pulls out a clean scroll and begins to write*\nBlood and scales? A psychological deterrent... it's brilliant. If they smell the death of their own kind, they might retreat. \n\nBut you must be specific. My research confirms there are at least three distinct types of dragons, plus their leader. You need to know what you may be up against.");
        cvTooPowerful4.addOptionText(PORTUGUESE, "Podemos usar sangue de dragão para criar um repelente.",
                "*Ela imediatamente puxa um pergaminho limpo e começa a escrever*\nSangue e escamas? Um impedimento psicológico... é brilhante. Se sentirem o cheiro da morte de sua própria espécie, podem recuar. \n\nMas você deve ser específico. Minha pesquisa confirma que existem pelo menos três tipos distintos de dragões atualmente, além de seu líder. Você precisa saber o que poderá enfrentar.");
        cvTooPowerful4.addOptionText(SPANISH, "Podemos usar sangre de dragón para crear un repelente.",
                "*Inmediatamente saca un pergamino limpio y comienza a escribir*\n¿Sangre y escamas? Un elemento disuasorio psicológico... es brillante. Si huelen la muerte de los suyos, podrían retirarse. \n\nPero debes ser específico. Mi investigación confirma que hay al menos tres tipos distintos de dragones, además de su líder. Necesitas saber a qué te enfrentas.");
        cvTooPowerful4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.TOO_POWERFUL, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvTooPowerful4.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.TOO_POWERFUL, App.getPlayerChar(), 5, ctx);
            LibQuest.includeQuestToQuestbook(QuestsIds.BLOOD_WITH_BLOOD, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvTooPowerful4);

        // Individual Dragon Types Info
        ConversationOption cvTypeFire = new ConversationOption(110, 110);
        cvTypeFire.addOptionText(ENGLISH, "Tell me about the Fire Dragons.",
                "The Fire Dragon is a beast of pure heat. Their scales are like cooled lava, and their breath can melt solid stone. They are aggressive and territorial, likely the first to strike when a migration begins.");
        cvTypeFire.addOptionText(PORTUGUESE, "Conte-me sobre os Dragões de Fogo.",
                "O Dragão de Fogo é uma fera de puro calor. Suas escamas são como lava resfriada, e seu sopro pode derreter pedra sólida. Eles são agressivos e territoriais, provavelmente os primeiros a atacar quando uma migração começa.");
        cvTypeFire.addOptionText(SPANISH, "Cuéntame sobre los Dragones de Fuego.",
                "El Dragón de Fuego es una bestia de puro calor. Sus escamas son como lava enfriada, y su aliento puede derretir la piedra sólida. Son agresivos y territoriales, probablemente los primeros en atacar cuando comienza una migración.");
        npc.conversationOptions.add(cvTypeFire);

        ConversationOption cvTypeIce = new ConversationOption(110, 110);
        cvTypeIce.addOptionText(ENGLISH, "Tell me about the Ice Dragons.",
                "The Ice Dragon thrives in freezing conditions. They don't breathe fire, but a sub-zero mist that shatters everything it touches. Their presence alone can turn a mountain peak into a permanent winter wasteland.");
        cvTypeIce.addOptionText(PORTUGUESE, "Conte-me sobre os Dragões de Gelo.",
                "O Dragão de Gelo prospera em condições de congelamento. Eles não cospem fogo, mas uma névoa abaixo de zero que estraçalha tudo o que toca. Sua presença sozinha pode transformar o pico de uma montanha em um deserto invernal permanente.");
        cvTypeIce.addOptionText(SPANISH, "Cuéntame sobre los Dragones de Hielo.",
                "El Dragón de Hielo prospera en condiciones de congelación. No escupen fuego, sino una niebla bajo cero que destroza todo lo que toca. Su sola presencia puede convertir la cima de una montaña en un páramo invernal permanente.");
        npc.conversationOptions.add(cvTypeIce);

        ConversationOption cvTypeWyvern = new ConversationOption(110, 110);
        cvTypeWyvern.addOptionText(ENGLISH, "Tell me about the Wyverns.",
                "The Wyvern is smaller than the true dragons but no less deadly. They are incredibly agile in the air and possess an acidic blood that burns through armor. They tend to travel in groups, making them a nightmare for mountain patrols.");
        cvTypeWyvern.addOptionText(PORTUGUESE, "Conte-me sobre os Wyverns.",
                "O Wyvern é menor que os dragões verdadeiros, mas não menos mortal. Eles são incrivelmente ágeis no ar e possuem um sangue ácido que corrói armaduras. Eles tendem a viajar em grupos, tornando-os um pesadelo para as patrulhas das montanhas.");
        cvTypeWyvern.addOptionText(SPANISH, "Cuéntame sobre los Wyverns.",
                "El Wyvern es más pequeño que los dragones verdaderos, pero no menos mortal. Son increíblemente ágiles en el aire y poseen una sangre ácida que corroe las armaduras. Suelen viajar en grupos, lo que los convierte en una pesadilla para las patrullas de montaña.");
        npc.conversationOptions.add(cvTypeWyvern);

        ConversationOption cvTypeKing = new ConversationOption(110, 110);
        cvTypeKing.addOptionText(ENGLISH, "Tell me about the leader of the Dragons.",
                "The Dragon King is the stuff of nightmares. Ancient, massive, and powerful enough to command the others. If this migration is as coordinated as it seems, it's because a King is leading it. This dragon has no weakness, facing one would be... well, let's focus on the repellent first.");
        cvTypeKing.addOptionText(PORTUGUESE, "Me fale do líder dos dragões.",
                "O Dragão Rei é o material dos pesadelos. Antigo, massivo e poderoso o suficiente para comandar os outros. Se esta migração for tão coordenada quanto parece, é porque um Rei a está liderando. Esse dragão não tem fraquezas, enfrentar um seria... bem, vamos focar no repelente primeiro.");
        cvTypeKing.addOptionText(SPANISH, "Cuéntame sobre el líder de los dragones.",
                "El Dragón Rey es materia de pesadillas. Antiguo, masivo y lo suficientemente poderoso como para comandar a los demás. Si esta migración es tan coordinada como parece, es porque un Rey la está liderando. Este dragón no tiene debilidades, enfrentarse a uno sería... bueno, concentrémonos primero en el repelente.");
        npc.conversationOptions.add(cvTypeKing);

        ConversationOption cvTooPowerfulFinish = new ConversationOption(110, 0);
        cvTooPowerfulFinish.addOptionText(ENGLISH, "I have the information I need.",
                "Excellent. If you are to make this repellent, you will need samples from these creatures. Go now, [PLAYERNAME]. The kingdom's fate rests on this plan.");
        cvTooPowerfulFinish.addOptionText(PORTUGUESE, "Eu tenho a informação que preciso.",
                "Excelente. Se você for fazer este repelente, precisará de amostras dessas criaturas. Vá agora, [PLAYERNAME]. O destino do reino depende deste plano.");
        cvTooPowerfulFinish.addOptionText(SPANISH, "Tengo la información que necesito.",
                "Excelente. Si vas a fabricar este repelente, necesitarás muestras de estas criaturas. Ve ahora, [PLAYERNAME]. El destino del reino depende de este plan.");
        npc.conversationOptions.add(cvTooPowerfulFinish);

        // ===== AFTER QUEST: Continued research =====
        ConversationOption cvAfterQuest = new ConversationOption(0, 0);
        cvAfterQuest.addOptionText(ENGLISH, "How's your research on the dwarves going?", "Wonderfully! I've been organizing all the information you brought me. I'm planning to write a comprehensive treatise on dwarven culture and their relationship with the underground. Perhaps one day I'll even visit Growrocks myself - though I'd need to overcome my fear of deep, dark places first! Your discovery has opened up a whole new field of study. Thank you again for helping me.");
        cvAfterQuest.addOptionText(PORTUGUESE, "Como está indo sua pesquisa sobre os anões?", "Maravilhosamente! Tenho organizado todas as informações que você me trouxe. Estou planejando escrever um tratado abrangente sobre a cultura anã e sua relação com o subterrâneo. Talvez um dia eu até visite Growrocks - embora precise superar meu medo de lugares profundos e escuros primeiro! Sua descoberta abriu todo um novo campo de estudo. Obrigada novamente por me ajudar.");
        cvAfterQuest.addOptionText(SPANISH, "¿Cómo va tu investigación sobre los enanos?", "¡Maravillosamente! He estado organizando toda la información que me trajiste. Estoy planeando escribir un tratado completo sobre la cultura enana y su relación con el subterráneo. Quizás algún día incluso visite Growrocks - ¡aunque necesitaría superar mi miedo a lugares profundos y oscuros primero! Tu descubrimiento ha abierto todo un nuevo campo de estudio. Gracias de nuevo por ayudarme.");
        cvAfterQuest.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAfterQuest);

        // ===== ROLEPLAY 1: What she does =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "What do you study here in Wazel?", "I'm a scholar of cultures and civilizations. I study the peoples of this world - their histories, customs, languages, and beliefs. Wazel is perfect for my work - traders come here from distant lands, bringing stories and artifacts. I've documented the traditions of the Esperand barbarians, the ceremonies of Lisport's nobility, even some elven customs from travelers who've been to Ayalon. Every culture has something unique to teach us.");
        cvRoleplay1.addOptionText(PORTUGUESE, "O que você estuda aqui em Wazel?", "Sou uma estudiosa de culturas e civilizações. Estudo os povos deste mundo - suas histórias, costumes, idiomas e crenças. Wazel é perfeito para meu trabalho - comerciantes vêm aqui de terras distantes, trazendo histórias e artefatos. Documentei as tradições dos bárbaros de Esperand, as cerimônias da nobreza de Lisport, até alguns costumes élficos de viajantes que estiveram em Ayalon. Cada cultura tem algo único para nos ensinar.");
        cvRoleplay1.addOptionText(SPANISH, "¿Qué estudias aquí en Wazel?", "Soy una erudita de culturas y civilizaciones. Estudio los pueblos de este mundo - sus historias, costumbres, idiomas y creencias. Wazel es perfecto para mi trabajo - comerciantes vienen aquí de tierras lejanas, trayendo historias y artefactos. He documentado las tradiciones de los bárbaros de Esperand, las ceremonias de la nobleza de Lisport, incluso algunas costumbres élficas de viajeros que han estado en Ayalon. Cada cultura tiene algo único que enseñarnos.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY 2: Why cultures matter =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Why is studying cultures important?", "Because understanding leads to respect, and respect leads to peace. When we know why people do what they do - their festivals, their taboos, their values - we see they're not so different from us. We all want safety, prosperity, connection. Many conflicts come from misunderstanding. If more people studied cultures as I do, perhaps we'd have fewer wars and more cooperation.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Por que estudar culturas é importante?", "Porque compreensão leva ao respeito, e respeito leva à paz. Quando sabemos por que as pessoas fazem o que fazem - seus festivais, seus tabus, seus valores - vemos que não são tão diferentes de nós. Todos queremos segurança, prosperidade, conexão. Muitos conflitos surgem de mal-entendidos. Se mais pessoas estudassem culturas como eu faço, talvez tivéssemos menos guerras e mais cooperação.");
        cvRoleplay2.addOptionText(SPANISH, "¿Por qué es importante estudiar culturas?", "Porque la comprensión lleva al respeto, y el respeto lleva a la paz. Cuando sabemos por qué la gente hace lo que hace - sus festivales, sus tabúes, sus valores - vemos que no son tan diferentes de nosotros. Todos queremos seguridad, prosperidad, conexión. Muchos conflictos surgen de malentendidos. Si más personas estudiaran culturas como yo, quizás tendríamos menos guerras y más cooperación.");
        npc.conversationOptions.add(cvRoleplay2);

        // ===== ROLEPLAY: City in ruins - AFTER Wazel Battle =====
        ConversationOption cvRoleplayRuins = new ConversationOption(0, 0);
        cvRoleplayRuins.addOptionText(ENGLISH, "Do you think Wazel will ever be the same again?", "*Pauses, looking down at her books and notes*\nI ask myself that every morning. As a scholar, I document the fall of civilizations... I never thought I'd be living through one.\n\nThe traders stopped coming. The voices in the streets are gone. The knowledge exchange that made this place so special — it all feels so distant now.\n\n*Takes a slow breath*\nBut history also teaches us this: people endure. Settlements are rebuilt. Cultures survive. I must believe that, or what is the point of carrying on? So I keep writing, keep studying.");
        cvRoleplayRuins.addOptionText(PORTUGUESE, "Você acha que Wazel vai voltar a ser como era?", "*Pausa, olhando para seus livros e anotações*\nEu me pergunto isso toda manhã. Como estudiosa, documento a queda de civilizações... nunca pensei que viveria dentro de uma.\n\nOs comerciantes pararam de vir. As vozes nas ruas foram embora. A troca de conhecimento que tornava esse lugar tão especial — tudo parece tão distante agora.\n\n*Respira fundo*\nMas a história também nos ensina isso: as pessoas resistem. Assentamentos são reconstruídos. Culturas sobrevivem. Preciso acreditar nisso, senão qual o sentido de continuar? Então sigo escrevendo, sigo estudando.");
        cvRoleplayRuins.addOptionText(SPANISH, "¿Crees que Wazel volverá a ser como antes?", "*Se detiene, mirando sus libros y notas*\nMe lo pregunto cada mañana. Como erudita, documento la caída de civilizaciones... nunca pensé que viviría dentro de una.\n\nLos comerciantes dejaron de venir. Las voces en las calles desaparecieron. El intercambio de conocimiento que hacía este lugar tan especial — todo se siente tan lejano ahora.\n\n*Respira despacio*\nPero la historia también nos enseña esto: la gente resiste. Los asentamientos se reconstruyen. Las culturas sobreviven. Debo creer eso, o ¿cuál es el sentido de seguir? Así que sigo escribiendo, sigo estudiando.");
        cvRoleplayRuins.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, WAZEL_BATTLE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplayRuins);

        return npc;
    }
}
