package com.cnx.endlesstalestwo.data.npcs.growrocks.temple;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.DRAGONS;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.THE_DWARVEN_CITY;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.WAZEL_BATTLE;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.Dragons;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class JanusaGodhead extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Janusa Godhead");
        npc.age = 58;
        npc.job = Enums.NPCJobs.PRIEST;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "Nothing matters more to her than her deities.\nAn older woman guided by her belief, and she could be easily influenced through it.\nGenerous and wise, she knows much about her culture.\n\nHer physical traits: Short, fine hair almost gray, green eyes, large ears, and a pleasant smile.");
        npc.addDescriptionTranslation(PORTUGUESE, "Nada para ela tem mais valor que suas divindades.\nUma senhora levada pela sua crença, poderia ser facilmente influenciada com isso.\nGenerosa e sábia, conhece muito da sua cultura..\n\nSeus traços físicos: Cabelo curto e fino, quase grisalha. Olhos verdes, orelhas grandes e sorriso agradável.");
        npc.addDescriptionTranslation(SPANISH, "Nada tiene más valor para ella que sus divinidades.\nUna mujer mayor guiada por su creencia; podría ser fácilmente influenciada por eso.\nGenerosa y sabia, conoce mucho de su cultura.\n\nSus rasgos físicos: Cabello corto y fino, casi canoso, ojos verdes, orejas grandes y sonrisa agradable.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Stone guide you, child. Welcome to our sacred hall."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Que a pedra guie você, criança. Bem-vindo ao nosso salão sagrado."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Que la piedra te guíe, hijo. Bienvenido a nuestro salón sagrado."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("May the ancestors watch over you."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Que os ancestrais vigiem você."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Que los ancestros velen por ti."));

        // ===== ROLEPLAY: About dwarven gods =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "Tell me about the dwarven gods.", "We worship the Stone Father and the ancestors. The Stone Father gave us the mountains, taught us to mine, to forge, to build. He is eternal as stone itself. The ancestors - our forefathers who came before - watch over us from the deep halls beneath. We honor them through our work, our craftsmanship, our traditions. Every hammer strike, every carved stone continues their legacy.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Conte-me sobre os deuses anões.", "Adoramos o Pai de Pedra e os ancestrais. O Pai de Pedra nos deu as montanhas, nos ensinou a minerar, a forjar, a construir. Ele é eterno como a própria pedra. Os ancestrais - nossos antepassados que vieram antes - nos vigiam dos salões profundos abaixo. Nós os honramos através de nosso trabalho, nosso artesanato, nossas tradições. Cada golpe de martelo, cada pedra esculpida continua seu legado.");
        cvRoleplay1.addOptionText(SPANISH, "Cuéntame sobre los dioses enanos.", "Adoramos al Padre de Piedra y a los ancestros. El Padre de Piedra nos dio las montañas, nos enseñó a minar, a forjar, a construir. Es eterno como la piedra misma. Los ancestros - nuestros antepasados que vinieron antes - nos vigilan desde los salones profundos abajo. Los honramos a través de nuestro trabajo, nuestra artesanía, nuestras tradiciones. Cada golpe de martillo, cada piedra tallada continúa su legado.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY 2: About dwarven traditions =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "What are the main dwarven traditions?", "We have many. The Forging Ceremony when a dwarf crafts their first true work. The Deep Oath when miners descend to new depths. The Stone Marriage when families unite. But all share common thread - connection to earth, to craft, to family. We believe work itself is sacred. A well-made tool, a properly mined vein, a sturdy wall - these honor the Stone Father. Laziness, waste, dishonor - these offend him. That is why dwarves work with such dedication. It is prayer in action.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Quais são as principais tradições anãs?", "Temos muitas. A Cerimônia de Forjamento quando um anão cria seu primeiro trabalho verdadeiro. O Juramento Profundo quando mineradores descem a novas profundezas. O Casamento de Pedra quando famílias se unem. Mas todas compartilham fio comum - conexão com a terra, com o ofício, com a família. Acreditamos que o trabalho em si é sagrado. Uma ferramenta bem feita, um veio adequadamente minerado, um muro resistente - estes honram o Pai de Pedra. Preguiça, desperdício, desonra - estes o ofendem. É por isso que anões trabalham com tanta dedicação. É oração em ação.");
        cvRoleplay2.addOptionText(SPANISH, "¿Cuáles son las principales tradiciones enanas?", "Tenemos muchas. La Ceremonia de Forja cuando un enano crea su primer trabajo verdadero. El Juramento Profundo cuando mineros descienden a nuevas profundidades. El Matrimonio de Piedra cuando familias se unen. Pero todas comparten hilo común - conexión con la tierra, con el oficio, con la familia. Creemos que el trabajo mismo es sagrado. Una herramienta bien hecha, una veta adecuadamente minada, un muro resistente - estos honran al Padre de Piedra. Pereza, desperdicio, deshonra - estos lo ofenden. Por eso los enanos trabajan con tanta dedicación. Es oración en acción.");
        npc.conversationOptions.add(cvRoleplay2);

        ConversationOption cv0 = new ConversationOption(0, 2);
        cv0.addOptionText(ENGLISH, "Tell me a curiosity about your people.", "Interesting that you ask that.\n*She stops what she's doing and focuses on you*\nWe've lived in the depths for years; here our people found greater prosperity in ore, although it was harder to grow our food.\nBut, know that before we came here, we lived in more distant lands and on the surface. It was the sense of self-preservation that brought us down here.");
        cv0.addOptionText(PORTUGUESE, "Me conte alguma curiosidade sobre seu povo.", "Interessante perguntar isso.\n*Ela para o que está fazendo e foca em você*\nHá anos que vivemos nas profundezas, aqui nosso povo encontrou maior prosperidade no minério, apesar que foi mais difícil cultivar nossos alimentos.\nMas, saiba que antes de virmos para cá, viviamos em terras mais distantes e na superfície. Foi o senso de auto preservação que nos trouxe aqui para baixo.");
        cv0.addOptionText(SPANISH, "Cuéntame alguna curiosidad sobre tu pueblo.", "Es interesante que preguntes eso.\n*Deja lo que está haciendo y se enfoca en ti*\nHace años que vivimos en las profundidades; aquí nuestro pueblo encontró mayor prosperidad en el mineral, a pesar de que fue más difícil cultivar nuestros alimentos.\nPero, debes saber que antes de venir aquí, vivíamos en tierras más distantes y en la superficie. Fue el sentido de autopreservación lo que nos trajo aquí abajo.");
        cv0.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(DRAGONS, chara)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cv0);

        ConversationOption cvAboutDragons = new ConversationOption(2, 0);
        cvAboutDragons.addOptionText(ENGLISH, "What do you mean by that?", "I believe that was a divine sign... Our workers extracted ore from the mountains, but danger was always lurking... dragons!\n*She shows fear in her eyes*\nOne day, it was very rainy, and our miners didn't climb the mountain. Just on that day, two enormous dragons flew over the mountain and fought each other. Everything there was destroyed.\nIt was always dangerous; we had incidents where we had to flee. It was then that the leader of the dwarves at the time chose to guide the people into the depths...\nThanks to the gods, everything worked out. I believe the dragons still fly over some mountains.");
        cvAboutDragons.addOptionText(PORTUGUESE, "O que quer dizer com isso?", "Creio que isso foi um sinal divino... Nossos trabalhadores extraíam minério das montanhas, mas o perigo rondava sempre... os dragões!\n*Ela demonstra medo no olhar*\nCerto dia, estava muito chuvoso, nossos mineradores não subiram a montanha. Justamente nesse dia, dois enormes dragões sobrevoaram a montanha e lutaram entre sí. Tudo ficou destruído por lá.\nSempre foi perigoso, tivemos incidentes que foi preciso fugir. Foi então que o líder dos anões na época optou por guiar o povo para as profundezas...\nGraças aos deuses, tudo deu certo. Acredito que os dragões ainda sobrevoam algumas montanhas.");
        cvAboutDragons.addOptionText(SPANISH, "¿Qué quieres decir con eso?", "Creo que eso fue una señal divina... Nuestros trabajadores extraían mineral de las montañas, pero el peligro acechaba siempre... ¡los dragones!\n*Ella demuestra miedo en su mirada*\nCierto día, estaba muy lluvioso, nuestros mineros no subieron a la montaña. Justamente ese día, dos enormes dragones sobrevolaron la montaña y lucharon entre sí. Todo quedó destruido por allá.\nSiempre fue peligroso, tuvimos incidentes en los que fue necesario huir. Fue entonces cuando el líder de los enanos de la época optó por guiar al pueblo a las profundidades...\nGracias a los dioses, todo salió bien. Creo que los dragones aún sobrevuelan algunas montañas.");
        npc.conversationOptions.add(cvAboutDragons);

        // ===== QUEST PART 4: Learn about culture =====
        ConversationOption cvQuest = new ConversationOption(0, 1);
        cvQuest.addOptionText(ENGLISH, "Fiola sent me to learn about dwarven beliefs.", "*Looks at you with wise, measuring eyes*\nDid she? Then Oliman truly considers accepting you. Very well, surface dweller. Sit. Listen.\n\n*Gestures to a stone bench*\n\nI will teach you what every dwarven child learns from birth.");
        cvQuest.addOptionText(PORTUGUESE, "Fiola me enviou para aprender sobre as crenças anãs.", "*Olha para você com olhos sábios e avaliadores*\nEla enviou? Então Oliman realmente considera aceitá-lo. Muito bem, habitante da superfície. Sente-se. Escute.\n\n*Gesticula para um banco de pedra*\n\nVou lhe ensinar o que toda criança anã aprende desde o nascimento.");
        cvQuest.addOptionText(SPANISH, "Fiola me envió para aprender sobre las creencias enanas.", "*Te mira con ojos sabios y evaluadores*\n¿La hizo? Entonces Oliman realmente considera aceptarte. Muy bien, habitante de la superficie. Siéntate. Escucha.\n\n*Gesticula hacia un banco de piedra*\n\nTe enseñaré lo que todo niño enano aprende desde el nacimiento.");
        cvQuest.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_DWARVEN_CITY, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuest);

        ConversationOption cvQuestTeach = new ConversationOption(1, 0);
        cvQuestTeach.addOptionText(ENGLISH, "[Sit and listen]", "*Speaks in a rhythmic, teaching tone*\n\nFirst, know the Stone Father. He is foundation of all. Before time, before light, there was stone. From stone came the world. From stone came us. The Stone Father shaped the first dwarves from mountain heart. Gave us strength of rock, endurance of earth, love of deep places.\n\nSecond, honor the ancestors. They walked before. They mined the first veins, forged the first tools, carved the first halls. Their wisdom flows through our blood. Their skill lives in our hands. When you craft well, they guide your hammer. When you mine true, they steady your pick.\n\nThird, understand the sacred work. Labor is prayer. Creation is worship. A lazy dwarf insults the Stone Father. A shoddy craftsman shames the ancestors. But honest work, skilled hands, quality goods - these please the gods and honor our people.\n\nFourth, respect the deep earth. It provides all we need - ore for forging, stone for building, gems for beauty. But it demands respect. Mine carefully. Waste nothing. Thank the earth for its gifts. The greedy and careless die in cave-ins. The respectful prosper.\n\nFifth and final - family and community. No dwarf stands alone. We are links in an ancient chain, stretching from the first ancestors to the last dwarf yet unborn. We work for the community. We preserve traditions. We teach the young. This is what makes us dwarves.\n\n*Studies you intently*\n\nDo you understand? This is the foundation of dwarven life. Work, honor, community, tradition. Live by these, and you honor us. Ignore them, and you are merely... tolerated.\n\nGo now. Tell Oliman you have learned. He will know if you truly listened.");
        cvQuestTeach.addOptionText(SPANISH, "[Sentarse y escuchar]", "*Habla en tono rítmico de enseñanza*\n\nPrimero, conoce al Padre de Piedra. Es fundamento de todo. Antes del tiempo, antes de la luz, había piedra. De la piedra vino el mundo. De la piedra vinimos nosotros. El Padre de Piedra moldeó a los primeros enanos del corazón de la montaña. Nos dio fuerza de roca, resistencia de tierra, amor por lugares profundos.\n\nSegundo, honra a los ancestros. Caminaron antes. Minaron las primeras vetas, forjaron las primeras herramientas, tallaron los primeros salones. Su sabiduría fluye por nuestra sangre. Su habilidad vive en nuestras manos. Cuando creas bien, guían tu martillo. Cuando minas correctamente, firman tu pico.\n\nTercero, entiende el trabajo sagrado. Trabajo es oración. Creación es adoración. Un enano perezoso insulta al Padre de Piedra. Un artesano descuidado avergüenza a los ancestros. Pero trabajo honesto, manos hábiles, bienes de calidad - estos agradan a los dioses y honran a nuestro pueblo.\n\nCuarto, respeta la tierra profunda. Proporciona todo lo que necesitamos - mineral para forjar, piedra para construir, gemas para belleza. Pero exige respeto. Mina cuidadosamente. No desperdicies nada. Agradece a la tierra por sus regalos. Los codiciosos y descuidados mueren en derrumbes. Los respetuosos prosperan.\n\nQuinto y final - familia y comunidad. Ningún enano está solo. Somos eslabones en una cadena ancestral, extendiéndose desde los primeros ancestros hasta el último enano aún no nacido. Trabajamos por la comunidad. Preservamos tradiciones. Enseñamos a los jóvenes. Esto es lo que nos hace enanos.\n\n*Te estudia intensamente*\n\n¿Entiendes? Esta es la fundación de la vida enana. Trabajo, honor, comunidad, tradición. Vive por estos, y nos honras. Ignóralos, y eres meramente... tolerado.\n\nVe ahora. Dile a Oliman que has aprendido. Él sabrá si realmente escuchaste.");
        cvQuestTeach.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.THE_DWARVEN_CITY, 7, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuestTeach);

        // ========================================
        // QUEST: DRAGONS?
        // ========================================

        // Start branch from curiosity talk (Group 2 -> 10)
        ConversationOption cvDragonsCuriosity = new ConversationOption(2, 10);
        cvDragonsCuriosity.addOptionText(ENGLISH, "You mentioned dragons flying over mountains. Have there been any recent reports?",
                "I've heard stories... ancient cycles shifting, migrations of old, and dragons seeking new nests in lands they haven't touched for centuries. \n\nIf you have curiosity and some fear of this, you should investigate more. If the dragons are moving, no mountain peak will be safe.");
        cvDragonsCuriosity.addOptionText(PORTUGUESE, "Você mencionou dragões sobrevoando as montanhas. Houve algum relato recente?",
                "Eu já ouvi falar de migrações e dragões procurando novos ninhos... ciclos antigos mudando em terras que eles não tocavam há séculos. \n\nSe você tem curiosidade e algum medo disso, deveria investigar mais... Se os dragões estão se movendo, nenhum pico de montanha estará seguro.");
        cvDragonsCuriosity.addOptionText(SPANISH, "Mencionaste dragones sobrevolando las montañas. ¿Ha habido informes recientes?",
                "He oído historias... ciclos antiguos cambiando, migraciones de antaño y dragones buscando nuevos nidos en tierras que no han tocado en siglos. \n\nSi tienes curiosidad y algún miedo de esto, deberías investigar más. Si los dragones se están moviendo, ninguna cima estará a salvo.");
        cvDragonsCuriosity.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, THE_DWARVEN_CITY)
                    && LibQuest.isQuestComplete(chara, WAZEL_BATTLE)
                    && !LibQuest.charHasQuest(DRAGONS, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvDragonsCuriosity);

        ConversationOption cvDragonsOffer = new ConversationOption(10, 11);
        cvDragonsOffer.addOptionText(ENGLISH, "I'm ready to investigate. Where should I start?",
                "Speak with Oliman Wisehead. As our governor, he coordinates with the scouts and guards. He knows the history of our migration better than anyone and might have more specific information on where these creatures were last seen. \n\nGo, child. May the Stone Father protect you from the fire of the skies.");
        cvDragonsOffer.addOptionText(PORTUGUESE, "Estou pronto para investigar. Por onde devo começar?",
                "Fale com Oliman Wisehead. Como nosso governador, ele coordena os batedores e guardas. Ele conhece a história de nossa migração melhor do que ninguém e pode ter informações mais específicas sobre onde essas criaturas foram vistas pela última vez. \n\nVá, jovem. Que o Pai de Pedra proteja você do fogo dos céus.");
        cvDragonsOffer.addOptionText(SPANISH, "Estoy listo para investigar. ¿Por dónde debo empezar?",
                "Habla con Oliman Wisehead. Como nuestro gobernador, él coordina a los exploradores y guardias. Él conoce la historia de nuestra migración mejor que nadie y podría tener información más específica sobre dónde se vieron estas criaturas por última vez. \n\nVe, hijo. Que el Padre de Piedra te proteja del fuego de los cielos.");
        npc.conversationOptions.add(cvDragonsOffer);

        ConversationOption cvDragonsAccept = new ConversationOption(11, 0);
        cvDragonsAccept.addOptionText(ENGLISH, "I will find Oliman and learn what I can.",
                "Stone be with you.");
        cvDragonsAccept.addOptionText(PORTUGUESE, "Vou encontrar Oliman e aprender o que puder.",
                "Que a pedra esteja com você.");
        cvDragonsAccept.addOptionText(SPANISH, "Buscaré a Oliman y aprenderé lo que pueda.",
                "Que la piedra esté contigo.");
        cvDragonsAccept.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(Dragons.get(), App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvDragonsAccept);

        ConversationOption cvDragonsDecline = new ConversationOption(11, 0);
        cvDragonsDecline.addOptionText(ENGLISH, "I'm not ready for such a dangerous task yet.", "I understand. The fire of the dragons is not to be faced lightly. Return if your resolve strengthens.");
        cvDragonsDecline.addOptionText(PORTUGUESE, "Ainda não estou pronto para uma tarefa tão perigosa.", "Eu entendo. O fogo dos dragões não deve ser enfrentado levianamente. Volte se sua determinação se fortalecer.");
        cvDragonsDecline.addOptionText(SPANISH, "Aún no estoy listo para una tarea tan peligrosa.", "Entiendo. El fuego de los dragones no debe enfrentarse a la ligera. Regresa si tu determinación se fortalece.");
        npc.conversationOptions.add(cvDragonsDecline);

        return npc;
    }
}

