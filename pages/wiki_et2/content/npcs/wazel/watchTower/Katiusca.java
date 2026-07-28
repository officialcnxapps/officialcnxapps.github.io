package com.cnx.endlesstalestwo.data.npcs.wazel.watchTower;

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

public class Katiusca extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Katiusca");
        npc.age = 34;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A determined woman with a strong pulse.\nShe never turns down a battle or an adventure.\nDeep down, she feels she's getting old and needs a family.\n\nHer physical traits: Wide, light-colored eyes. Hair covered by a metal helmet. Sun-dried face and fair skin.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma mulher determinada de pulso forte.\nNão nega uma batalha ou uma aventura.\nNo fundo, sente que está ficando velha e precisa de uma família.\n\nSeus traços físicos: Olhos arregalados e claros. Cabelos cobertos pelo capacete de metal. Rosto ressecado do sol e pele clara.");
        npc.addDescriptionTranslation(SPANISH, "Una mujer decidida de pulso firme.\nNo rehúye una batalla o una aventura.\nEn el fondo, siente que está envejeciendo y necesita una familia.\n\nSus rasgos físicos: Ojos grandes y claros. Cabello cubierto por el casco de metal. Rostro reseco por el sol y piel clara.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Eyes on the horizon, always."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olhos no horizonte, sempre."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Ojos en el horizonte, siempre."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Stay vigilant."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Permaneça vigilante."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Mantente vigilante."));

        // ===== QUEST 22: WAZEL BATTLE - PART 1 =====
        ConversationOption cvWazel1 = new ConversationOption(0, 7);
        cvWazel1.addOptionText(ENGLISH, "I'm here from Havarus. We heard Wazel might be under threat.", "You heard correctly. The same dark forces that have been attacking the mainland are now turning their attention to us. I've been watching the seas day and night - there's unnatural movement in the waters. Dark shapes, strange currents... something is coming. Danjor is coordinating our defense from the Warriors' Tower. You should speak with him immediately. He needs every capable fighter we can get.");
        cvWazel1.addOptionText(PORTUGUESE, "Estou aqui de Havarus. Ouvimos que Wazel pode estar sob ameaça.", "Você ouviu corretamente. As mesmas forças das trevas que têm atacado o continente agora estão voltando sua atenção para nós. Tenho observado os mares dia e noite - há movimento não natural nas águas. Formas escuras, correntes estranhas... algo está vindo. Danjor está coordenando nossa defesa da Torre dos Guerreiros. Você deve falar com ele imediatamente. Ele precisa de todo lutador capaz que pudermos conseguir.");
        cvWazel1.addOptionText(SPANISH, "Estoy aquí de Havarus. Oímos que Wazel podría estar bajo amenaza.", "Escuchaste correctamente. Las mismas fuerzas oscuras que han estado atacando el continente ahora están dirigiendo su atención hacia nosotros. He estado observando los mares día y noche - hay movimiento antinatural en las aguas. Formas oscuras, corrientes extrañas... algo está viniendo. Danjor está coordinando nuestra defensa desde la Torre de Guerreros. Deberías hablar con él inmediatamente. Necesita todo luchador capaz que podamos conseguir.");
        cvWazel1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, WAZEL_BATTLE, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvWazel1.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(WAZEL_BATTLE, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvWazel1);

        // ===== QUEST 22: WAZEL BATTLE - Additional quest context =====
        ConversationOption cvWazel1Extra = new ConversationOption(7, 3);
        cvWazel1Extra.addOptionText(ENGLISH, "What have you seen approaching?", "Dark shapes beneath the waves, moving in formations no natural creature would use. Unnatural currents pushing toward our shores. And the desert... scouts report strange movements from the caverns to the east. It's coordinated, planned. These aren't mindless beasts - there's intelligence behind this attack. That's what worries me most. An enemy that thinks, that strategizes... that's far more dangerous than any monster.");
        cvWazel1Extra.addOptionText(PORTUGUESE, "O que você viu se aproximando?", "Formas escuras sob as ondas, movendo-se em formações que nenhuma criatura natural usaria. Correntes não naturais empurrando para nossas costas. E o deserto... batedores relatam movimentos estranhos das cavernas ao leste. É coordenado, planejado. Não são bestas sem mente - há inteligência por trás deste ataque. É isso que mais me preocupa. Um inimigo que pensa, que estrategiza... é muito mais perigoso do que qualquer monstro.");
        cvWazel1Extra.addOptionText(SPANISH, "¿Qué has visto acercándose?", "Formas oscuras bajo las olas, moviéndose en formaciones que ninguna criatura natural usaría. Corrientes antinaturales empujando hacia nuestras costas. Y el desierto... exploradores reportan movimientos extraños desde las cavernas al este. Está coordinado, planeado. No son bestias sin mente - hay inteligencia detrás de este ataque. Eso es lo que más me preocupa. Un enemigo que piensa, que estrategiza... es mucho más peligroso que cualquier monstruo.");
        npc.conversationOptions.add(cvWazel1Extra);

        ConversationOption cvWazel1ExtraResponse = new ConversationOption(3, 0);
        cvWazel1ExtraResponse.addOptionText(ENGLISH, "We'll stop them.", "I believe you. Havarus sends its best, and you've proven yourself before. But be ready - this won't be like other battles you've fought. These creatures... they're different. Darker. More vicious. Stay sharp, trust Danjor's strategy, and don't take unnecessary risks. Wazel needs you alive, not a dead hero. Now go - time is against us.");
        cvWazel1ExtraResponse.addOptionText(PORTUGUESE, "Vamos pará-los.", "Eu acredito em você. Havarus envia seus melhores, e você já provou seu valor antes. Mas esteja pronto - isso não será como outras batalhas que você lutou. Essas criaturas... são diferentes. Mais escuras. Mais cruéis. Fique alerta, confie na estratégia de Danjor, e não corra riscos desnecessários. Wazel precisa de você vivo, não de um herói morto. Agora vá - o tempo está contra nós.");
        cvWazel1ExtraResponse.addOptionText(SPANISH, "Los detendremos.", "Te creo. Havarus envía a sus mejores, y ya has demostrado tu valor antes. Pero prepárate - esto no será como otras batallas que has peleado. Estas criaturas... son diferentes. Más oscuras. Más crueles. Mantente alerta, confía en la estrategia de Danjor, y no corras riesgos innecesarios. Wazel te necesita vivo, no un héroe muerto. Ahora ve - el tiempo está en nuestra contra.");
        npc.conversationOptions.add(cvWazel1ExtraResponse);

        // ===== AFTER QUEST COMPLETION =====
        ConversationOption cvAfterQuest = new ConversationOption(0, 0);
        cvAfterQuest.addOptionText(ENGLISH, "How are you holding up?", "I'm... managing. From up here, I saw everything. Every explosion, every fire, every moment where it looked like we might lose. And we almost did. The city... it's broken. So many good people gone. But we're alive. That has to count for something. Thank you for what you did. Without you, I'd be watching an empty, dead island right now. At least there's still hope.");
        cvAfterQuest.addOptionText(PORTUGUESE, "Como você está se aguentando?", "Estou... me virando. Daqui de cima, vi tudo. Cada explosão, cada incêndio, cada momento em que parecia que poderíamos perder. E quase perdemos. A cidade... está quebrada. Tantas pessoas boas se foram. Mas estamos vivos. Isso tem que valer alguma coisa. Obrigada pelo que você fez. Sem você, estaria observando uma ilha vazia e morta agora. Pelo menos ainda há esperança.");
        cvAfterQuest.addOptionText(SPANISH, "¿Cómo estás resistiendo?", "Estoy... manejándolo. Desde aquí arriba, vi todo. Cada explosión, cada fuego, cada momento en que parecía que podríamos perder. Y casi lo hicimos. La ciudad... está rota. Tanta gente buena se ha ido. Pero estamos vivos. Eso tiene que contar para algo. Gracias por lo que hiciste. Sin ti, estaría observando una isla vacía y muerta ahora. Al menos todavía hay esperanza.");
        cvAfterQuest.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(WAZEL_BATTLE, chara) && LibQuest.isQuestComplete(chara, WAZEL_BATTLE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAfterQuest);


        // ===== GENERAL CONVERSATION =====
        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "What do you do here?", "I'm a sentinel. I watch the seas from this tower, monitoring for threats approaching from the water. Wazel is an island - our greatest vulnerability and strength both come from the ocean. Pirates, sea monsters, enemy fleets... I've seen it all. My job is to spot danger before it reaches our shores and sound the alarm.");
        cv1.addOptionText(PORTUGUESE, "O que você faz aqui?", "Sou uma sentinela. Observo os mares desta torre, monitorando ameaças que se aproximam pela água. Wazel é uma ilha - nossa maior vulnerabilidade e força vêm do oceano. Piratas, monstros marinhos, frotas inimigas... já vi de tudo. Meu trabalho é detectar o perigo antes que chegue às nossas praias e soar o alarme.");
        cv1.addOptionText(SPANISH, "¿Qué haces aquí?", "Soy una centinela. Observo los mares desde esta torre, monitoreando amenazas que se acercan desde el agua. Wazel es una isla - nuestra mayor vulnerabilidad y fuerza provienen del océano. Piratas, monstruos marinos, flotas enemigas... lo he visto todo. Mi trabajo es detectar el peligro antes de que llegue a nuestras costas y dar la alarma.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv1Response = new ConversationOption(1, 0);
        cv1Response.addOptionText(ENGLISH, "How long have you been a sentinel?", "Seven years now. Started as a lookout on fishing boats, then joined the Watch. This tower has been my post for three years. Some find it boring - staring at the horizon day after day. But I find peace in it. The rhythm of the waves, the changing skies, the patterns of nature. And when danger does come, I'm the first to know. That responsibility keeps me sharp.");
        cv1Response.addOptionText(PORTUGUESE, "Há quanto tempo você é sentinela?", "Sete anos agora. Comecei como vigia em barcos de pesca, depois me juntei à Guarda. Esta torre é meu posto há três anos. Alguns acham entediante - olhar para o horizonte dia após dia. Mas eu encontro paz nisso. O ritmo das ondas, os céus em mudança, os padrões da natureza. E quando o perigo vem, sou a primeira a saber. Essa responsabilidade me mantém alerta.");
        cv1Response.addOptionText(SPANISH, "¿Cuánto tiempo has sido centinela?", "Siete años ahora. Comencé como vigía en barcos pesqueros, luego me uní a la Guardia. Esta torre ha sido mi puesto durante tres años. Algunos lo encuentran aburrido - mirando el horizonte día tras día. Pero yo encuentro paz en ello. El ritmo de las olas, los cielos cambiantes, los patrones de la naturaleza. Y cuando viene el peligro, soy la primera en saberlo. Esa responsabilidad me mantiene alerta.");
        npc.conversationOptions.add(cv1Response);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Tell me about Wazel.", "Wazel is... unique. We're an island nation, isolated from the mainland conflicts. That isolation made us strong, self-reliant. We're warriors and traders, fishermen and craftsmen. The desert provides challenges, but also opportunities - rare minerals, unique plants. Our alliance with Havarus is strategic, but also based on mutual respect. We value freedom and strength. Every Wazel citizen knows how to fight if needed. It's in our blood.");
        cv2.addOptionText(PORTUGUESE, "Conte-me sobre Wazel.", "Wazel é... única. Somos uma nação insular, isolada dos conflitos do continente. Esse isolamento nos tornou fortes, autossuficientes. Somos guerreiros e comerciantes, pescadores e artesãos. O deserto apresenta desafios, mas também oportunidades - minerais raros, plantas únicas. Nossa aliança com Havarus é estratégica, mas também baseada em respeito mútuo. Valorizamos liberdade e força. Todo cidadão de Wazel sabe lutar se necessário. Está no nosso sangue.");
        cv2.addOptionText(SPANISH, "Cuéntame sobre Wazel.", "Wazel es... única. Somos una nación isleña, aislada de los conflictos del continente. Ese aislamiento nos hizo fuertes, autosuficientes. Somos guerreros y comerciantes, pescadores y artesanos. El desierto presenta desafíos, pero también oportunidades - minerales raros, plantas únicas. Nuestra alianza con Havarus es estratégica, pero también basada en respeto mutuo. Valoramos la libertad y la fuerza. Todo ciudadano de Wazel sabe luchar si es necesario. Está en nuestra sangre.");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(0, 2);
        cv3.addOptionText(ENGLISH, "What's the worst thing you've seen from this tower?", "The worst? Three years ago, a pirate fleet tried to raid us. Three ships, coming in the night. I spotted them when they were still hours away. Raised the alarm, gave the city time to prepare. The battle was brutal - fires on the water, screams carrying on the wind. We drove them back, but... so many didn't make it home that night. Wazel warriors, good people I knew. That's when I truly understood the weight of my responsibility here.");
        cv3.addOptionText(PORTUGUESE, "Qual foi a pior coisa que você viu desta torre?", "A pior? Três anos atrás, uma frota pirata tentou nos atacar. Três navios, vindo à noite. Eu os avistei quando ainda estavam a horas de distância. Dei o alarme, dei tempo para a cidade se preparar. A batalha foi brutal - incêndios na água, gritos carregados pelo vento. Nós os expulsamos, mas... tantos não voltaram para casa naquela noite. Guerreiros de Wazel, boas pessoas que eu conhecia. Foi quando entendi verdadeiramente o peso da minha responsabilidade aqui.");
        cv3.addOptionText(SPANISH, "¿Qué es lo peor que has visto desde esta torre?", "¿Lo peor? Hace tres años, una flota pirata intentó asaltarnos. Tres barcos, viniendo en la noche. Los divisé cuando aún estaban a horas de distancia. Di la alarma, di tiempo a la ciudad para prepararse. La batalla fue brutal - fuegos en el agua, gritos llevados por el viento. Los expulsamos, pero... tantos no regresaron a casa esa noche. Guerreros de Wazel, buenas personas que conocía. Fue entonces cuando realmente entendí el peso de mi responsabilidad aquí.");
        npc.conversationOptions.add(cv3);

        ConversationOption cv3Response = new ConversationOption(2, 0);
        cv3Response.addOptionText(ENGLISH, "You saved the city that day.", "I did my job. But sometimes doing your job isn't enough. Sometimes people still die. I learned that night that being a sentinel isn't just about seeing danger - it's about living with what happens after you sound that alarm. Every battle, every life lost... part of it weighs on me. But I keep watching. Because if I miss something, if I'm not vigilant enough, it could be even worse.");
        cv3Response.addOptionText(PORTUGUESE, "Você salvou a cidade naquele dia.", "Fiz meu trabalho. Mas às vezes fazer seu trabalho não é suficiente. Às vezes as pessoas ainda morrem. Aprendi naquela noite que ser sentinela não é apenas ver o perigo - é viver com o que acontece depois que você soa o alarme. Cada batalha, cada vida perdida... parte disso pesa sobre mim. Mas continuo vigiando. Porque se eu perder algo, se não for vigilante o suficiente, pode ser ainda pior.");
        cv3Response.addOptionText(SPANISH, "Salvaste la ciudad ese día.", "Hice mi trabajo. Pero a veces hacer tu trabajo no es suficiente. A veces la gente aún muere. Aprendí esa noche que ser centinela no es solo ver el peligro - es vivir con lo que sucede después de que das la alarma. Cada batalla, cada vida perdida... parte de eso pesa sobre mí. Pero sigo vigilando. Porque si pierdo algo, si no soy lo suficientemente vigilante, podría ser aún peor.");
        npc.conversationOptions.add(cv3Response);

        return npc;
    }
}