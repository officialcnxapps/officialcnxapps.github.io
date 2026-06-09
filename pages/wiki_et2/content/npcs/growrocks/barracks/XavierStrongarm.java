package com.cnx.endlesstalestwo.data.npcs.growrocks.barracks;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class XavierStrongarm extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Xavier Strongarm");
        npc.age = 42;
        npc.job = Enums.NPCJobs.GUILD_LEADER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Extremely loyal to his people, he works hard.\nAnxious and cautious, yet with good levels of attention and courage.\nA single dwarf who wants a family.\n\nHis physical traits: Broad face with prominent cheeks, and a thick dark beard matching his hair and eyebrows.");
        npc.addDescriptionTranslation(PORTUGUESE, "Extremamente leal ao seu povo, trabalha árduo.\nAnsioso e precavido, porém com bons níveis de atenção e coragem.\nSolteiro que quer uma família.\n\nSeus traços físicos: Rosto largo com bochechas proeminentes. Barba grossa e escura como o cabelo e a sobrancelha.");
        npc.addDescriptionTranslation(SPANISH, "Extremadamente leal a su pueblo, trabaja duro.\nAnsioso y precavido, pero con buenos niveles de atención y coraje.\nUn soltero que desea formar una familia.\n\nSus rasgos físicos: Rostro ancho con mejillas prominentes y barba espesa y oscura como su cabello y sus cejas.");

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // ===== ROLEPLAY 1: About the guard =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "Tell me about the dwarven guard.", "I command the guard of Growrocks. Not as large as surface armies, but every dwarf here is worth ten of your soldiers. We train from youth - axe, hammer, shield. We know these tunnels like we know our own beards. Any enemy who enters uninvited will find only death in the dark. We protect our home, our families, our way of life. That is our duty, and we fulfill it with pride.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Conte-me sobre a guarda anã.", "Comando a guarda de Growrocks. Não tão grande quanto exércitos da superfície, mas cada anão aqui vale dez dos seus soldados. Treinamos desde jovens - machado, martelo, escudo. Conhecemos estes túneis como conhecemos nossas próprias barbas. Qualquer inimigo que entre sem convite encontrará apenas morte no escuro. Protegemos nosso lar, nossas famílias, nosso modo de vida. Este é nosso dever, e o cumprimos com orgulho.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY 2: About training =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "How do you train your warriors?", "Hard. Constant. Dwarven warriors must be strong, disciplined, reliable. We drill in formation, practice with heavy weapons, run the tunnels in full armor. No shortcuts, no weakness tolerated. A weak link in the guard means danger for everyone. Those who cannot meet the standards return to other work - mining, smithing, farming. No shame in that. Better a good miner than a poor warrior. But those who stay become the finest defenders in the realm.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Como você treina seus guerreiros?", "Duramente. Constantemente. Guerreiros anões devem ser fortes, disciplinados, confiáveis. Praticamos em formação, treinamos com armas pesadas, corremos os túneis em armadura completa. Sem atalhos, nenhuma fraqueza tolerada. Um elo fraco na guarda significa perigo para todos. Aqueles que não conseguem atingir os padrões retornam a outros trabalhos - mineração, ferraria, agricultura. Não há vergonha nisso. Melhor um bom minerador que um guerreiro pobre. Mas aqueles que ficam se tornam os melhores defensores do reino.");
        cvRoleplay2.addOptionText(SPANISH, "¿Cómo entrenas a tus guerreros?", "Duramente. Constantemente. Guerreros enanos deben ser fuertes, disciplinados, confiables. Practicamos en formación, entrenamos con armas pesadas, corremos los túneles en armadura completa. Sin atajos, ninguna debilidad tolerada. Un eslabón débil en la guardia significa peligro para todos. Aquellos que no pueden cumplir los estándares regresan a otros trabajos - minería, herrería, agricultura. No hay vergüenza en eso. Mejor un buen minero que un guerrero pobre. Pero aquellos que se quedan se convierten en los mejores defensores del reino.");
        npc.conversationOptions.add(cvRoleplay2);


        return npc;
    }
}