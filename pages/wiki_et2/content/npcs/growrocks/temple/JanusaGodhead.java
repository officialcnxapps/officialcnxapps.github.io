package com.cnx.endlesstalestwo.data.npcs.growrocks.temple;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
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

        return npc;
    }
}

