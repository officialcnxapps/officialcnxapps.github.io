package com.cnx.endlesstalestwo.data.npcs.esperand.watchTower;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.GameEngine;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.Patrolman;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.Character;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Switch;
import com.cnx.endlesstalestwo.entities.Variable;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Vinny extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    private static final String SWITCH_PATROLMAN_QUEST_ACTIVE = "PATROLMAN_QUEST_ACTIVE";

    Npc npc() {
        Npc npc = new Npc("Vinny");
        npc.age = 32;
        npc.job = Enums.NPCJobs.GUILD_LEADER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "An honorable and helpful soldier. He does his duty with precision.\nSerious, steady, and attentive, he keeps order when needed.\nCertainty loyal to his comrades and friends.\n\nHis physical traits: Wavy black hair down to his shoulders, a masculine face with light beard, and deep light-colored eyes.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um soldado honrado e prestativo. Faz seu trabalho com precisão.\nSério, firme e atento, mantém a ordem quando necessário.\nCertamente fiel a seus companheiros e amigos.\n\nSeus traços físicos: Cabelos negros ondulados até os ombros. Rosto másculo com barba rala. Olhos profundos e claros.");
        npc.addDescriptionTranslation(SPANISH, "Un soldado honorable y servicial. Hace su trabajo con precisión.\nSerio, firme y atento, mantiene el orden cuando es necesario.\nSin duda es leal a sus compañeros y amigos.\n\nSus rasgos físicos: Cabello negro ondulado hasta los hombros, rostro masculino con barba rala y ojos profundos y claros.");

        npc.generateRandomByes();

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What does a guild leader do here?", "In Esperand, titles matter less than reliability. I organize watches, send capable hands where they're needed, and make sure panic never reaches the walls before danger does.");
        cv1.addOptionText(PORTUGUESE, "O que um líder de guilda faz aqui?", "Em Esperand, títulos importam menos do que confiança. Eu organizo vigias, envio mãos capazes para onde são necessárias e garanto que o pânico nunca chegue aos muros antes do perigo.");
        cv1.addOptionText(SPANISH, "¿Qué hace aquí un líder de gremio?", "En Esperand, los títulos importan menos que la confiabilidad. Organizo guardias, envío personas capaces a donde se las necesita y me aseguro de que el pánico no llegue a los muros antes que el peligro.");
        npc.conversationOptions.add(cv1);

        // ========================================
        // QUEST: PATROLMAN
        // ========================================

        // Start quest (after Good Samaritan + level >= 8)
        ConversationOption cvPatrolOffer = new ConversationOption(0, 5);
        cvPatrolOffer.addOptionText(ENGLISH, "I heard you're looking for help for Esperand's patrol.",
                "You heard right. I've heard things about you — good things. Esperand is not as safe as it looks. There are threats out there.\nI need someone to speak with Lord Mukas Wintar at the City Hall first. He knows the full picture of what surrounds this island. Are you willing?");
        cvPatrolOffer.addOptionText(PORTUGUESE, "Estás procurando ajuda para a patrulha de Esperand?",
                "Estou sim. E ouvi coisas sobre você — coisas boas. Esperand não é tão segura quanto parece. Há ameaças por aí.\nPreciso que alguém fale com Lorde Mukas Wintar no City Hall primeiro. Ele conhece o panorama completo do que cerca esta ilha. Você está disposto?");
        cvPatrolOffer.addOptionText(SPANISH, "Escuché que buscas ayuda para la patrulla de Esperand.",
                "Lo escuchaste bien. He escuchado cosas sobre ti — cosas buenas. Esperand no es tan segura como parece. Hay amenazas ahí afuera.\nNecesito que alguien hable primero con Lord Mukas Wintar en el Ayuntamiento. Él conoce el panorama completo de lo que rodea esta isla. ¿Estás dispuesto?");
        cvPatrolOffer.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.PATROLMAN, chara)
                    && LibQuest.isQuestComplete(chara, QuestsIds.GOOD_SAMARITAN)
                    && chara.level >= 8) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPatrolOffer);

        ConversationOption cvPatrolAccept = new ConversationOption(5, 0);
        cvPatrolAccept.addOptionText(ENGLISH, "Alright. I'll speak with Lord Mukas.",
                "Good. He will tell you where the threats are. Come back after you've spoken with him.");
        cvPatrolAccept.addOptionText(PORTUGUESE, "Certo. Vou falar com Lorde Mukas.",
                "Bom. Ele vai te dizer onde estão as ameaças. Volte depois de falar com ele.");
        cvPatrolAccept.addOptionText(SPANISH, "De acuerdo. Hablaré con Lord Mukas.",
                "Bien. Él te dirá dónde están las amenazas. Regresa después de hablar con él.");
        cvPatrolAccept.listeners = (ctx, currentFragment) -> {
            Character chara = App.getPlayerChar();
            LibQuest.includeQuestToQuestbook(Patrolman.get(), chara, ctx);
            Variable questsVar = chara.getVariables().get(Enums.GameplayVariables.QUESTS);
            questsVar.addOrUpdateSwitch(new Switch(SWITCH_PATROLMAN_QUEST_ACTIVE, true));
        };
        npc.conversationOptions.add(cvPatrolAccept);

        ConversationOption cvPatrolDecline = new ConversationOption(5, 0);
        cvPatrolDecline.addOptionText(ENGLISH, "Not now.", "Esperand needs trustworthy hands. Come back when you are ready.");
        cvPatrolDecline.addOptionText(PORTUGUESE, "Agora não.", "Esperand precisa de mãos confiáveis. Volte quando estiver pronto.");
        cvPatrolDecline.addOptionText(SPANISH, "Ahora no.", "Esperand necesita manos confiables. Regresa cuando estés listo.");
        npc.conversationOptions.add(cvPatrolDecline);

        // Part 3: Return after defeating threat
        ConversationOption cvPatrolPart3 = new ConversationOption(0, 0);
        cvPatrolPart3.addOptionText(ENGLISH, "The threat has been dealt with.",
                "*He clasps your arm in acknowledgment*\nWell done. Esperand breathes a little easier tonight because of you.\nNow I need one more thing from you — there is a weapons shipment arriving at Esperand Harbor. We need those weapons for the watch posts. Collect the Crate of Weapons from the harbor and bring it here to the Watch Tower. But be careful on the road back — there have been reports of ambushes near the Watch Tower entrance.");
        cvPatrolPart3.addOptionText(PORTUGUESE, "A ameaça foi resolvida.",
                "*Ele aperta seu braço em reconhecimento*\nMuito bem. Esperand respira um pouco mais aliviada esta noite por causa de você.\nAgora preciso de mais uma coisa — há um carregamento de armas chegando no Porto de Esperand. Precisamos dessas armas para os postos de vigia. Colete o Caixote de Armas no porto e traga aqui para a Torre de Guarda. Mas cuidado no caminho de volta — há relatos de emboscadas perto da entrada da Torre de Guarda.");
        cvPatrolPart3.addOptionText(SPANISH, "La amenaza ha sido resuelta.",
                "*Te aprieta el brazo en reconocimiento*\nBien hecho. Esperand respira un poco más tranquila esta noche gracias a ti.\nAhora necesito una cosa más — hay un cargamento de armas llegando al Puerto de Esperand. Necesitamos esas armas para los puestos de vigilancia. Recoge el Cajón de Armas del puerto y tráelo aquí a la Torre de Guardia. Pero ten cuidado en el camino de regreso — hay informes de emboscadas cerca de la entrada a la Torre de Guardia.");
        cvPatrolPart3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PATROLMAN, 30)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPatrolPart3.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.PATROLMAN, 40, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPatrolPart3);

        // Part 1 (restartable continuation): Quest was completed and restarted — remind player to go back to Mukas
        ConversationOption cvPatrolRestart = new ConversationOption(0, 0);
        cvPatrolRestart.addOptionText(ENGLISH, "Ready to help with patrol again.",
                "Good to hear it. Esperand always has something going on.\nHead back to Lord Mukas at the City Hall. He keeps track of the current threats on the island. Let him know you are available and see what he says.");
        cvPatrolRestart.addOptionText(PORTUGUESE, "Pronto para ajudar com a patrulha novamente.",
                "Fico feliz em ouvir isso. Esperand sempre tem algo acontecendo.\nVá novamente falar com Lord Mukas no City Hall. Ele acompanha as ameaças atuais da ilha. Diga a ele que você está disponível e veja o que ele diz.");
        cvPatrolRestart.addOptionText(SPANISH, "Listo para ayudar con la patrulla de nuevo.",
                "Qué bueno escuchar eso. Esperand siempre tiene algo pasando.\nVuelve a hablar con Lord Mukas en el Ayuntamiento. Él lleva el registro de las amenazas actuales en la isla. Dile que estás disponible y escucha lo que dice.");
        cvPatrolRestart.requirementValidations = (chara, ctx) -> {
            Variable questsVar = chara.getVariables().get(Enums.GameplayVariables.QUESTS);
            Switch swt = GameEngine.getSwitchFromVariable(questsVar, SWITCH_PATROLMAN_QUEST_ACTIVE);
            if (LibQuest.charHasQuest(QuestsIds.PATROLMAN, chara)
                    && swt != null && ((Boolean) (swt.getValue())) == false
                    && LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PATROLMAN, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPatrolRestart);

        // Part 6: Player delivers Crate of Weapons after surviving ambush
        ConversationOption cvPatrolPart5 = new ConversationOption(0, 0);
        cvPatrolPart5.addOptionText(ENGLISH, "I made it through. Here are the weapons.",
                "*He takes the crate and sets it down with a nod of respect*\nYou fought through an ambush carrying a heavy crate and still made it here. That is the kind of reliability Esperand needs.\nYou have proven yourself as a true Patrolman of Esperand. Take this — you have earned it.");
        cvPatrolPart5.addOptionText(PORTUGUESE, "Consegui passar. Aqui estão as armas.",
                "*Ele pega o caixote e o coloca com um aceno de respeito*\nVocê lutou através de uma emboscada carregando um caixote pesado e ainda chegou aqui. Esse é o tipo de confiabilidade que Esperand precisa.\nVocê provou ser um verdadeiro Patrulheiro de Esperand. Leve isso — você mereceu.");
        cvPatrolPart5.addOptionText(SPANISH, "Lo logré. Aquí están las armas.",
                "*Toma el cajón y lo deja con un gesto de respeto*\nLuchaste a través de una emboscada cargando un pesado cajón y aun así llegaste aquí. Eso es el tipo de confiabilidad que Esperand necesita.\nTe has demostrado como un verdadero Patrullero de Esperand. Toma esto — te lo has ganado.");
        cvPatrolPart5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PATROLMAN, 60)
                    && LibInventory.checkHasItem(ItemsIds.CRATE_OF_WEAPONS, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPatrolPart5.listeners = (ctx, currentFragment) -> {
            Variable questsVar = App.getPlayerChar().getVariables().get(Enums.GameplayVariables.QUESTS);
            questsVar.addOrUpdateSwitch(new Switch(SWITCH_PATROLMAN_QUEST_ACTIVE, false));

            LibInventory.removeFromInventory(ItemsIds.CRATE_OF_WEAPONS, 1, App.getPlayerChar());
            App.getPlayerChar().attributesManager.increase(Enums.AttributeName.ALIGNMENT, 3);
            LibQuest.completeQuest(QuestsIds.PATROLMAN, App.getPlayerChar(), 70, ctx);
        };
        npc.conversationOptions.add(cvPatrolPart5);

        return npc;
    }
}