package com.cnx.endlesstalestwo.data.npcs.ayalon;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class ElvenCitadelGuard extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Elven Citadel Guard");
        npc.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Guarda da Cidadela Élfica");
        npc.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Guardia de la Ciudadela Élfica");
        npc.age = 100;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A brave young man who loves serving Ayalon.\nHe is ambitious and certainly wants to become a captain or general of the elven army.\n\nHis physical traits: Light green eyes contrast with his short brown hair. A youthful and masculine face.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um jovem corajoso que ama servir à Ayalon.\nÉ ambicioso, com certeza quer se tornar um capitão ou general da armada dos elfos.\n\nSeus traços físicos: Os olhos verdes claros contrastam com o cabelo castanho e curto. Rosto jovial e másculo.");
        npc.addDescriptionTranslation(SPANISH, "Un joven valiente que ama servir a Ayalon.\nEs ambicioso, sin duda quiere convertirse en capitán o general de la armada de los elfos.\n\nSus rasgos físicos: Los ojos de color verde claro contrastan con su cabello castaño y corto. Rostro juvenil y masculino.");

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(CoreEnums.AvailableLanguages.ENGLISH, "What is it like guarding this citadel?", "Peaceful to outsiders, but never truly simple. We guard not only walls, but old knowledge, sacred places, and the trust of our people.");
        cv1.addOptionText(CoreEnums.AvailableLanguages.PORTUGUESE, "Como é guardar esta cidadela?", "Parece pacífico para quem vê de fora, mas nunca é simples. Nós guardamos não apenas muros, mas conhecimentos antigos, lugares sagrados e a confiança do nosso povo.");
        cv1.addOptionText(CoreEnums.AvailableLanguages.SPANISH, "¿Cómo es proteger esta ciudadela?", "Parece pacífica para quienes la ven desde fuera, pero nunca es simple. No protegemos solo muros, sino conocimientos antiguos, lugares sagrados y la confianza de nuestro pueblo.");
        npc.conversationOptions.add(cv1);

        // ========================================
        // QUEST: Traitor
        // ========================================

        // Pergunta sobre Casiel (apenas na parte 1 da quest Traitor)
        ConversationOption cvTraitorCasiel = new ConversationOption(0, 0);
        cvTraitorCasiel.addOptionText(CoreEnums.AvailableLanguages.ENGLISH, "Have you seen Casiel around here lately?", "Not recently, no. I last saw him a few days ago, passing through the gate... He seemed different somehow. Restless, perhaps. His eyes kept wandering, as if he feared being watched. Strange behavior for someone of his standing.");
        cvTraitorCasiel.addOptionText(CoreEnums.AvailableLanguages.PORTUGUESE, "Você viu Casiel por aqui recentemente?", "Não, não recentemente. A última vez que o vi foi há alguns dias, passando pelo portão... Ele parecia diferente. Inquieto, talvez. Seus olhos ficavam vagando, como se temesse ser observado. Comportamento estranho para alguém de sua posição.");
        cvTraitorCasiel.addOptionText(CoreEnums.AvailableLanguages.SPANISH, "¿Has visto a Casiel por aquí últimamente?", "No, no recientemente. La última vez que lo vi fue hace unos días, cruzando el portón... Parecía diferente. Inquieto, quizás. Sus ojos no dejaban de moverse, como si temiera ser observado. Comportamiento extraño para alguien de su posición.");
        cvTraitorCasiel.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.isCharacterAtQuestPart(chara, QuestsIds.TRAITOR, 1)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cvTraitorCasiel);

        return npc;
    }
}