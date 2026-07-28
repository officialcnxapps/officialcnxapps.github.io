package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.docks;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.AWAITING_THE_DRAGONS;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.TOO_POWERFUL;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.TooPowerful;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Messenger extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Messenger");
        npc.age = 24;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.MALE;
        npc.cantSayBye = true;
        npc.addDescriptionTranslation(ENGLISH, "A weary royal messenger, covered in dust from a long journey. He looks urgent and out of breath.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um mensageiro real exausto, coberto de poeira de uma longa jornada. Ele parece apressado e sem fôlego.");
        npc.addDescriptionTranslation(SPANISH, "Un mensajero real agotado, cubierto de polvo de un largo viaje. Parece urgente y sin aliento.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("I have urgent news from the capital!"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Tenho notícias urgentes da capital!"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("¡Tengo noticias urgentes de la capital!"));

        npc.generateRandomByes();

        // ========================================
        // QUEST: TOO POWERFUL
        // ========================================

        // Start conversation (group 0 -> 1)
        ConversationOption cvStart = new ConversationOption(0, 1);
        cvStart.addOptionText(ENGLISH, "What has happened? Why such urgency?",
                "*He takes a moment to catch his breath, his eyes wide with alarm*\nIt's the dragons! They've come with a force no one anticipated. The watches you helped organize... they weren't enough. \n\nReports are coming in from all over the kingdom. Great Rock, the Ice Mountains, even the smaller peaks in Wazel and Farmland. They didn't just fly over — they attacked. Every mountain is under siege.");
        cvStart.addOptionText(PORTUGUESE, "O que aconteceu? Por que tanta urgência?",
                "*Ele para um momento para recuperar o fôlego, os olhos arregalados de alarme*\nSão os dragões! Eles vieram com uma força que ninguém previu. As vigias que você ajudou a organizar... não foram suficientes. \n\nRelatos estão chegando de todo o reino. Great Rock, as Montanhas de Gelo, até os picos menores em Wazel e Farmland. Eles não apenas sobrevoaram — eles atacaram. Cada montanha está sob cerco.");
        cvStart.addOptionText(SPANISH, "¿Qué ha pasado? ¿Por qué tanta urgencia?",
                "*Se toma un momento para recuperar el aliento, con los ojos muy abiertos por la alarma*\n¡Son los dragones! Han venido con una fuerza que nadie anticipó. Las guardias que ayudaste a organizar... no fueron suficientes. \n\nEstán llegando informes de todo el reino. Great Rock, las Montañas de Hielo, incluso las cimas más pequeñas en Wazel y Farmland. No solo sobrevolaron: atacaron. Cada montaña está bajo asedio.");
        cvStart.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, AWAITING_THE_DRAGONS) && !LibQuest.charHasQuest(TOO_POWERFUL, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvStart);

        // Accept conversation (group 1 -> 0)
        ConversationOption cvAccept = new ConversationOption(1, 2);
        cvAccept.addOptionText(ENGLISH, "We must find a way to drive them back.",
                "Lady Jade and the Queen are desperate for a solution. They sent me to find you immediately. We need to think of a way to expel them before they establish permanent nests. \n\nPlease, talk to those who might know how to deal with such powerful creatures. I must return to report that you've been informed.");
        cvAccept.addOptionText(PORTUGUESE, "Devemos encontrar um jeito de expulsá-los.",
                "Lady Jade e a Rainha estão desesperadas por uma solução. Elas me enviaram para encontrar você imediatamente. Precisamos pensar em um jeito de expulsá-los antes que estabeleçam ninhos permanentes. \n\nPor favor, fale com quem possa saber como lidar com criaturas tão poderosas. Devo voltar para relatar que você foi informado.");
        cvAccept.addOptionText(SPANISH, "Debemos encontrar una manera de hacerlos retroceder.",
                "Lady Jade y la Reina están desesperadas por una solución. Me enviaron a buscarte de inmediato. Necesitamos pensar en una forma de expulsarlos antes de que establezcan nidos permanentes. \n\nPor favor, habla con quienes puedan saber cómo lidiar con criaturas tan poderosas. Debo regresar para informar que has sido notificado.");
        cvAccept.listeners = (ctx, currentFragment) -> LibQuest.includeQuestToQuestbook(TooPowerful.get(), App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvAccept);

        ConversationOption cv0 = new ConversationOption(2, 999);
        cv0.addOptionText(ENGLISH, "I will, inform our majesty.", "For sure, [GENDER_FORMAL_CALL]");
        cv0.addOptionText(PORTUGUESE, "Eu irei, informe vossa majestade.", "Certamente, [GENDER_FORMAL_CALL]");
        cv0.addOptionText(SPANISH, "Lo haré, informe a su majestad.", "Ciertamente, [GENDER_FORMAL_CALL]");
        npc.conversationOptions.add(cv0);

        return npc;
    }
}
