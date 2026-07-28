package com.cnx.endlesstalestwo.data.npcs.wazel;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.WAZEL_BATTLE;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Puca extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Puca");
        npc.age = 19;
        npc.job = Enums.NPCJobs.FEMALE_HUNTER;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A young woman enthusiastic about life.\nFriendly and talkative.\nShe learned her craft early from her father.\n\nHer physical traits: Large blue eyes. Wide mouth. Fair skin and a reddish, pointed nose. Blonde hair.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma jovem estusiasmada com a vida.\nSimpática e conversadora.\nAprendeu seu ofício cedo, com seu pai.\n\nSeus traços físicos: Grandes olhos azuis. Boca larga. Pele clara e nariz avermelhado e pontudo. Cabelos loiros.");
        npc.addDescriptionTranslation(SPANISH, "Una joven entusiasta de la vida.\nSimpática y conversadora.\nAprendió su oficio pronto con su padre.\n\nSus rasgos físicos: Grandes ojos azules. Boca ancha. Piel clara y nariz rojiza y puntiaguda. Cabello rubio.");

        if (App.getPlayerChar() != null && LibQuest.isQuestComplete(App.getPlayerChar(), WAZEL_BATTLE)) {
            npc.imgFile = "npc_puca_sad";
        }

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Welcome to Wazel! There is no place like this in the world."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bem-vindo a Wazel! Não há lugar igual no mundo."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("¡Bienvenido a Wazel! No hay lugar igual en el mundo."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Take care out there."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Cuide-se por aí."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Cuídate por ahí."));

        // ===== ROLEPLAY 1 - Before Part 5: Life in Wazel =====
        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "What's it like living in Wazel?", "It's unlike anything else. The desert heat, the colorful tents, the smell of spices from the market... I grew up hunting in the sands east of the city. People think the desert is harsh, but once you learn to read it, it's beautiful. The sunsets here are breathtaking - the sky turns shades of orange and red you wouldn't believe.");
        cv1.addOptionText(PORTUGUESE, "Como é viver em Wazel?", "É diferente de qualquer outra coisa. O calor do deserto, as tendas coloridas, o cheiro de especiarias do mercado... Cresci caçando nas areias ao leste da cidade. As pessoas acham que o deserto é severo, mas quando você aprende a lê-lo, é lindo. Os pores do sol aqui são deslumbrantes - o céu fica em tons de laranja e vermelho que você não vai acreditar.");
        cv1.addOptionText(SPANISH, "¿Cómo es vivir en Wazel?", "Es diferente a cualquier otra cosa. El calor del desierto, las tiendas coloridas, el olor a especias del mercado... Crecí cazando en las arenas al este de la ciudad. La gente cree que el desierto es duro, pero una vez que aprendes a leerlo, es hermoso. Los atardeceres aquí son impresionantes - el cielo se torna en tonos de naranja y rojo que no creerías.");
        cv1.requirementValidations = (chara, ctx) -> {
            // Só mostra antes da part 5 da quest (cidade ainda intacta)
            if (LibQuest.charHasQuest(WAZEL_BATTLE, chara) &&
                    (LibQuest.isCharacterAtQuestPart(chara, WAZEL_BATTLE, 5)
                            || LibQuest.isCharacterAtQuestPart(chara, WAZEL_BATTLE, 6)
                            || LibQuest.isQuestComplete(chara, WAZEL_BATTLE))) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cv1);

        ConversationOption cv1Response = new ConversationOption(1, 0);
        cv1Response.addOptionText(ENGLISH, "It sounds incredible.", "It is! And the people here are strong, not just in body but in spirit. We've survived pirates, sandstorms, droughts... Wazel endures. Our warriors are the best in the world, but what truly makes this city great is the community. Everyone looks out for each other here. That's something the mainland can't understand - we live together, fight together, survive together.");
        cv1Response.addOptionText(PORTUGUESE, "Parece incrível.", "É mesmo! E as pessoas aqui são fortes, não só no corpo mas no espírito. Sobrevivemos a piratas, tempestades de areia, secas... Wazel resiste. Nossos guerreiros são os melhores do mundo, mas o que realmente torna essa cidade grandiosa é a comunidade. Todos cuidam uns dos outros aqui. Isso é algo que o continente não consegue entender - vivemos juntos, lutamos juntos, sobrevivemos juntos.");
        cv1Response.addOptionText(SPANISH, "Suena increíble.", "¡Lo es! Y la gente aquí es fuerte, no solo en cuerpo sino en espíritu. Hemos sobrevivido piratas, tormentas de arena, sequías... Wazel perdura. Nuestros guerreros son los mejores del mundo, pero lo que realmente hace grande a esta ciudad es la comunidad. Todos se cuidan aquí. Eso es algo que el continente no puede entender - vivimos juntos, luchamos juntos, sobrevivimos juntos.");
        npc.conversationOptions.add(cv1Response);

        // ===== ROLEPLAY 2 - Before Part 5: Puca's daily life =====
        ConversationOption cv2 = new ConversationOption(0, 2);
        cv2.addOptionText(ENGLISH, "What do you do here in Wazel?", "I'm a hunter. I track desert prey - sand rabbits, lizards, sometimes larger things if they come too close to the city. I also guide travelers through the desert paths. Visitors always underestimate the desert - one wrong turn and you're lost in the sands. I've pulled three people out of deep sinkholes this season alone. I love it though. Every day out there is a new challenge.");
        cv2.addOptionText(PORTUGUESE, "O que você faz aqui em Wazel?", "Sou caçadora. Rastreio presas do deserto - coelhos de areia, lagartos, às vezes coisas maiores se se aproximam demais da cidade. Também guio viajantes pelos caminhos do deserto. Os visitantes sempre subestimam o deserto - uma virada errada e você está perdido nas areias. Tirei três pessoas de pântanos de areia profundos só nessa temporada. Mas eu amo isso. Cada dia lá fora é um novo desafio.");
        cv2.addOptionText(SPANISH, "¿Qué haces aquí en Wazel?", "Soy cazadora. Rastro presas del desierto - conejos de arena, lagartos, a veces cosas más grandes si se acercan demasiado a la ciudad. También guío viajeros por los senderos del desierto. Los visitantes siempre subestiman el desierto - un giro equivocado y estás perdido en las arenas. Saqué a tres personas de arenas movedizas profundas solo esta temporada. Pero me encanta. Cada día allá afuera es un nuevo desafío.");
        cv2.requirementValidations = (chara, ctx) -> {
            // Só mostra antes da part 5 da quest (cidade ainda intacta)
            if (LibQuest.charHasQuest(WAZEL_BATTLE, chara) &&
                    (LibQuest.isCharacterAtQuestPart(chara, WAZEL_BATTLE, 5)
                            || LibQuest.isCharacterAtQuestPart(chara, WAZEL_BATTLE, 6)
                            || LibQuest.isQuestComplete(chara, WAZEL_BATTLE))) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cv2);

        ConversationOption cv2Response = new ConversationOption(2, 0);
        cv2Response.addOptionText(ENGLISH, "Sounds dangerous.", "Everything worthwhile is. But it's also my home - I'll protect these sands and this city with my life if I have to. Wazel took me in when I had nothing. It's not just a city to me, it's everything.");
        cv2Response.addOptionText(PORTUGUESE, "Parece perigoso.", "Tudo que vale a pena é. Mas também é meu lar - vou proteger essas areias e essa cidade com minha vida se precisar. Wazel me acolheu quando eu não tinha nada. Não é apenas uma cidade para mim, é tudo.");
        cv2Response.addOptionText(SPANISH, "Suena peligroso.", "Todo lo que vale la pena lo es. Pero también es mi hogar - protegeré estas arenas y esta ciudad con mi vida si es necesario. Wazel me acogió cuando no tenía nada. No es solo una ciudad para mí, es todo.");
        npc.conversationOptions.add(cv2Response);

        // ===== ROLEPLAY 3 - From Part 5 onward: Grief over the destruction =====
        ConversationOption cv3 = new ConversationOption(0, 3);
        cv3.addOptionText(ENGLISH, "How are you holding up?", "*stares at the rubble in silence for a moment*\nI keep thinking I'll wake up and the city will be whole again. The market, the tents, the sounds of children playing in the streets... all gone. I walked through what used to be my favorite street yesterday. I couldn't even tell it was the same place. Just ash and broken stones.");
        cv3.addOptionText(PORTUGUESE, "Como você está se saindo?", "*olha para os escombros em silêncio por um momento*\nFico pensando que vou acordar e a cidade estará inteira novamente. O mercado, as tendas, os sons de crianças brincando nas ruas... tudo desapareceu. Passei pelo que costumava ser minha rua favorita ontem. Não conseguia nem reconhecer que era o mesmo lugar. Só cinzas e pedras quebradas.");
        cv3.addOptionText(SPANISH, "¿Cómo estás sobrellevando esto?", "*mira los escombros en silencio por un momento*\nSigo pensando que voy a despertar y la ciudad estará entera de nuevo. El mercado, las tiendas, los sonidos de niños jugando en las calles... todo se ha ido. Ayer caminé por lo que solía ser mi calle favorita. Ni siquiera podía reconocer que era el mismo lugar. Solo cenizas y piedras rotas.");
        cv3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(WAZEL_BATTLE, chara) &&
                    (LibQuest.isCharacterAtQuestPart(chara, WAZEL_BATTLE, 5)
                            || LibQuest.isCharacterAtQuestPart(chara, WAZEL_BATTLE, 6)
                            || LibQuest.isQuestComplete(chara, WAZEL_BATTLE))) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv3);

        ConversationOption cv3Response = new ConversationOption(3, 0);
        cv3Response.addOptionText(ENGLISH, "I'm sorry. We did everything we could.", "I know. And I'm grateful. If you hadn't been here... there might not even be ruins to mourn. But knowing that doesn't make it hurt any less. Wazel was alive. Noisy, hot, full of sand and laughter and arguments and music. Now it's... quiet. I hate the quiet.");
        cv3Response.addOptionText(PORTUGUESE, "Sinto muito. Fizemos tudo que pudemos.", "Eu sei. E sou grata. Se você não estivesse aqui... talvez nem ruínas restassem para chorar. Mas saber disso não diminui a dor. Wazel estava viva. Barulhenta, quente, cheia de areia e risos e brigas e música. Agora está... quieta. Eu odeio o silêncio.");
        cv3Response.addOptionText(SPANISH, "Lo siento. Hicimos todo lo que pudimos.", "Lo sé. Y estoy agradecida. Si no hubieras estado aquí... quizás ni siquiera habría ruinas que llorar. Pero saber eso no hace que duela menos. Wazel estaba viva. Ruidosa, caliente, llena de arena y risas y peleas y música. Ahora está... silenciosa. Odio el silencio.");
        npc.conversationOptions.add(cv3Response);

        // ===== ROLEPLAY 4 - From Part 5 onward: What comes next =====
        ConversationOption cv4 = new ConversationOption(0, 4);
        cv4.addOptionText(ENGLISH, "Will Wazel rebuild?", "*long pause*\nIt has to. This is our home. We've survived worse - or... maybe not worse, but we've survived. Danjor is already organizing work crews. Some of the merchants are pooling resources. Katiusca hasn't left her tower - she says she'll watch until she's sure nothing else is coming. That's just who we are. We don't give up. But it won't ever be the same. Some things you can't rebuild.");
        cv4.addOptionText(PORTUGUESE, "Wazel vai se reconstruir?", "*longa pausa*\nTem que ser. Esse é nosso lar. Sobrevivemos coisas piores - ou... talvez não piores, mas sobrevivemos. Danjor já está organizando equipes de trabalho. Alguns mercadores estão juntando recursos. Katiusca não saiu da sua torre - ela diz que vai vigiar até ter certeza que nada mais está vindo. É simplesmente quem nós somos. Não desistimos. Mas nunca será o mesmo. Algumas coisas você não pode reconstruir.");
        cv4.addOptionText(SPANISH, "¿Wazel se reconstruirá?", "*larga pausa*\nTiene que hacerlo. Este es nuestro hogar. Hemos sobrevivido cosas peores - o... quizás no peores, pero hemos sobrevivido. Danjor ya está organizando equipos de trabajo. Algunos comerciantes están juntando recursos. Katiusca no ha abandonado su torre - dice que vigilará hasta estar segura de que no viene nada más. Así somos nosotros. No nos rendimos. Pero nunca será lo mismo. Algunas cosas no puedes reconstruir.");
        cv4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(WAZEL_BATTLE, chara) &&
                    (LibQuest.isCharacterAtQuestPart(chara, WAZEL_BATTLE, 5)
                            || LibQuest.isCharacterAtQuestPart(chara, WAZEL_BATTLE, 6)
                            || LibQuest.isQuestComplete(chara, WAZEL_BATTLE))) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv4);

        ConversationOption cv4Response = new ConversationOption(4, 0);
        cv4Response.addOptionText(ENGLISH, "You'll get through this.", "Maybe. But thank you - for fighting for us, for people you barely knew. That means more than you realize. Wazel won't forget you. I won't forget you.");
        cv4Response.addOptionText(PORTUGUESE, "Vocês vão superar isso.", "Talvez. Mas obrigada - por lutar por nós, por pessoas que você mal conhecia. Isso significa mais do que você percebe. Wazel não vai esquecer você. Eu não vou esquecer você.");
        cv4Response.addOptionText(SPANISH, "Saldrán adelante.", "Quizás. Pero gracias - por luchar por nosotros, por personas que apenas conocías. Eso significa más de lo que crees. Wazel no te olvidará. Yo no te olvidaré.");
        npc.conversationOptions.add(cv4Response);

        return npc;
    }
}