package com.cnx.endlesstalestwo.data.npcs.esperand.inn;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class Lauisy extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Lauisy");
        npc.age = 29;
        npc.job = Enums.NPCJobs.NEEDLEWOMAN;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "This girl is still learning about life. She only knows well what she does.\nShe is agile and very capable of learning new things. Curious.\n\nHer physical traits: Short hair, as black as her skin. Very beautiful light green eyes. Slightly rosy cheeks.");
        npc.addDescriptionTranslation(PORTUGUESE, "Essa garota ainda está aprendendo sobre a vida. Conhece bem apenas aquilo que faz.\nÉ ágil e muito capaz de aprender coisas novas. Curiosa.\n\nSeus traços físicos: Cabelos curtos e negros como sua pele. Olhos verdes claros muito bonitos. Bochechas levemente rosadas.");
        npc.addDescriptionTranslation(SPANISH, "Esta chica aún está aprendiendo sobre la vida. Solo conoce bien lo que hace.\nEs ágil y muy capaz de aprender cosas nuevas. Curiosa.\n\nSus rasgos físicos: Cabello corto y negro como su piel. Ojos verdes claros muy hermosos. Mejillas ligeramente sonrosadas.");

        npc.generateRandomByes();
        npc.generateRandomGreetings();

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Do travelers keep you busy?", "Constantly. In cold lands, torn gloves and worn cloaks do not stay small problems for long. I mend winter garments before the frost teaches harsher lessons.");
        cv1.addOptionText(PORTUGUESE, "Os viajantes mantêm você ocupada?", "Constantemente. Em terras frias, luvas rasgadas e mantos gastos não continuam sendo pequenos problemas por muito tempo. Eu conserto roupas de inverno antes que a geada ensine lições piores.");
        cv1.addOptionText(SPANISH, "¿Los viajeros te mantienen ocupada?", "Constantemente. En tierras frías, unos guantes rotos y unas capas gastadas no siguen siendo problemas pequeños por mucho tiempo. Remiendo ropa de invierno antes de que la escarcha enseñe lecciones más duras.");
        npc.conversationOptions.add(cv1);

        // ===== ROLEPLAY: Trabalhos disponíveis =====
        ConversationOption cvWork = new ConversationOption(0, 0);
        cvWork.addOptionText(ENGLISH,
                "Is there any work available around here?",
                "Work? *thinks for a moment*\nI'm not really the one to ask, but from what I've heard, the chief of the watchtower — Captain Vinny — is often looking for honest folk willing to help with patrol. He seems to prefer people who come recommended. Might be worth a visit.");
        cvWork.addOptionText(PORTUGUESE,
                "Tem algum trabalho disponível por aqui?",
                "Trabalho? *pensa por um momento*\nNão sou bem a pessoa certa para isso, mas pelo que ouvi, o chefe da torre de vigia — Capitão Vinny — costuma procurar gente honesta disposta a ajudar no patrulhamento. Ele parece preferir pessoas bem indicadas. Pode valer uma visita.");
        cvWork.addOptionText(SPANISH,
                "¿Hay algun trabajo por aqui?",
                "¿Trabajo? *piensa un momento*\nNo soy la persona más indicada para eso, pero según lo que he oído, el jefe de la torre de vigilancia — el Capitán Vinny — suele buscar gente honesta dispuesta a ayudar en el patrullaje. Parece preferir personas bien recomendadas. Podría valer la pena visitarlo.");
        npc.conversationOptions.add(cvWork);

        return npc;
    }
}
