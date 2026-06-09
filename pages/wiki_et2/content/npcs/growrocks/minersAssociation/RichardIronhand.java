package com.cnx.endlesstalestwo.data.npcs.growrocks.minersAssociation;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class RichardIronhand extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Richard Ironhand");
        npc.age = 53;
        npc.job = Enums.NPCJobs.GUILD_LEADER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A defender of the dwarves. He seems to hold some prejudice against other peoples, but never disrespects them.\nSkilled and efficient in his work.\nLugag's older brother.\n\nHis physical traits: Very large nose and ears, long light-colored beard, brown eyes, and thick eyebrows.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um defensor dos anões. Parece ter um pouco de preconceito com outros povos, mas nunca desrespeita.\nPerito no seu trabalho, eficiente.\nIrmão mais velho de Lugag\n\nSeus traços físicos: Nariz e orelhas bem grandes. Barba comprida de cor clara. Olhos castanhos e sobrancelhas grossas.");
        npc.addDescriptionTranslation(SPANISH, "Un defensor de los enanos. Parece tener un poco de prejuicio hacia otros pueblos, pero nunca falta al respeto.\nExperto en su trabajo, eficiente.\nHermano mayor de Lugag.\n\nSus rasgos físicos: Nariz y orejas muy grandes, barba larga de color claro, ojos castaños y cejas gruesas.");

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // ===== ROLEPLAY 1: About the Miners Association =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "What is the Miners Association?", "We are the voice of the miners. When disputes arise - over territory, over shares, over safety - the association settles them. We ensure fair treatment, proper equipment, reasonable working hours. Mining is dangerous work. Without organization, without rules, dwarves die needlessly. I have seen too many cave-ins, too many accidents from carelessness or greed. The association prevents that. We protect our miners so they can safely extract what the earth provides.");
        cvRoleplay1.addOptionText(PORTUGUESE, "O que é a Associação de Mineradores?", "Somos a voz dos mineradores. Quando disputas surgem - sobre território, sobre compartilhamentos, sobre segurança - a associação as resolve. Garantimos tratamento justo, equipamento adequado, horas de trabalho razoáveis. Mineração é trabalho perigoso. Sem organização, sem regras, anões morrem desnecessariamente. Vi muitos desmoronamentos, muitos acidentes por descuido ou ganância. A associação previne isso. Protegemos nossos mineradores para que possam extrair com segurança o que a terra fornece.");
        cvRoleplay1.addOptionText(SPANISH, "¿Qué es la Asociación de Mineros?", "Somos la voz de los mineros. Cuando surgen disputas - sobre territorio, sobre participaciones, sobre seguridad - la asociación las resuelve. Garantizamos trato justo, equipo adecuado, horas de trabajo razonables. Minería es trabajo peligroso. Sin organización, sin reglas, enanos mueren innecesariamente. He visto muchos derrumbes, muchos accidentes por descuido o codicia. La asociación previene eso. Protegemos a nuestros mineros para que puedan extraer con seguridad lo que la tierra proporciona.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY 2: About mining techniques =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Can you teach me about mining?", "Surface dwellers often mine poorly - hack at walls, cause collapses, waste good ore. Proper mining requires knowledge. You must read the stone - see the veins, understand the structure, know which supports to place and where. A good miner extracts maximum ore with minimum danger. A poor miner brings the mountain down on everyone. If you wish to learn properly, work alongside our miners. Watch, listen, practice. The stone will teach you, if you respect it.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Você pode me ensinar sobre mineração?", "Habitantes da superfície frequentemente mineram mal - atacam paredes, causam colapsos, desperdiçam bom minério. Mineração adequada requer conhecimento. Você deve ler a pedra - ver os veios, entender a estrutura, saber quais suportes colocar e onde. Um bom minerador extrai máximo minério com perigo mínimo. Um minerador pobre derruba a montanha sobre todos. Se deseja aprender adequadamente, trabalhe ao lado de nossos mineradores. Observe, escute, pratique. A pedra o ensinará, se você a respeitar.");
        cvRoleplay2.addOptionText(SPANISH, "¿Puedes enseñarme sobre minería?", "Habitantes de la superficie a menudo minan mal - atacan paredes, causan colapsos, desperdician buen mineral. Minería adecuada requiere conocimiento. Debes leer la piedra - ver las vetas, entender la estructura, saber qué soportes colocar y dónde. Un buen minero extrae máximo mineral con peligro mínimo. Un minero pobre derriba la montaña sobre todos. Si deseas aprender adecuadamente, trabaja junto a nuestros mineros. Observa, escucha, practica. La piedra te enseñará, si la respetas.");


        return npc;
    }
}