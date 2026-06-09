package com.cnx.endlesstalestwo.data.npcs.wazel.kitchen;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.WAZEL_BATTLE;
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
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Knowledge is the key to understanding our world."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("O conhecimento é a chave para entender nosso mundo."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("El conocimiento es la clave para entender nuestro mundo."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("May wisdom guide your path."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Que a sabedoria guie seu caminho."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Que la sabiduría guíe tu camino."));

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

        return npc;
    }
}