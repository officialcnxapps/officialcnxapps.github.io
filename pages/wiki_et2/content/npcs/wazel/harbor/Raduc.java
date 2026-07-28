package com.cnx.endlesstalestwo.data.npcs.wazel.harbor;

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

public class Raduc extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Raduc");
        npc.age = 22;
        npc.job = Enums.NPCJobs.LONGSHOREMAN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "An agile and proactive young man.\nHe is seeking opportunities to show his work and grow.\nDue to his age, he still has many fears.\n\nHis physical traits: Tanned skin, thin face. Deep brown eyes. Frizzy hair.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um jovem ágil e proativo.\nEstá buscando oportunidades de mostrar trabalho e crescer.\nDevido a idade, ainda tem muitos temores.\n\nSeus traços físicos: Pele bronzeada, rosto fino. Olhos profundos e castanhos. Cabelos crespos.");
        npc.addDescriptionTranslation(SPANISH, "Un joven ágil y proactivo.\nBusca oportunidades para demostrar su trabajo y crecer.\nDebido a su edad, todavía tiene muchos temores.\n\nSus rasgos físicos: Piel bronceada, rostro fino. Ojos profundos y castaños. Cabello crespo.");
        npc.canBePickpocketed = true;

        npc.hasRandomizedConversations = true;

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What is life like at Wazel's harbor?", "Busy and dusty. Ships bring spices, fabrics, tools, and rumors from every coast. We unload under the sun, work fast, and drink even faster when the day is done.");
        cv1.addOptionText(PORTUGUESE, "Como é a vida no porto de Wazel?", "Movimentada e empoeirada. Navios trazem especiarias, tecidos, ferramentas e rumores de toda costa. Descarregamos sob o sol, trabalhamos rápido e bebemos ainda mais rápido quando o dia termina.");
        cv1.addOptionText(SPANISH, "¿Cómo es la vida en el puerto de Wazel?", "Agitada y polvorienta. Los barcos traen especias, telas, herramientas y rumores de todas las costas. Descargamos bajo el sol, trabajamos rápido y bebemos aún más rápido cuando termina el día.");
        npc.conversationOptions.add(cv1);

        // ========================================
        // QUEST: NIGHTMARE TO REALITY
        // ========================================

        // Start Quest (group 0 -> 1)
        ConversationOption cvNightmareStart = new ConversationOption(0, 1);
        cvNightmareStart.addOptionText(ENGLISH, "You look like you haven't slept in days.", "*He jumps slightly, his eyes wide and bloodshot*\nSleep? How can I sleep when they are waiting? Every time I close my eyes, the fog rolls in. The ghostly pirates... they are calling to me from the desert shores. But the most terrifying part was talking to him... Jerome. That old bandit from Wazel who was hauled off to Havarus years ago. He was there, in my dream, telling me they are coming. I fear it's no longer just a dream.");
        cvNightmareStart.addOptionText(PORTUGUESE, "Você parece que não dorme há dias.", "*Ele pula levemente, seus olhos arregalados e vermelhos*\nDormir? Como posso dormir quando eles estão esperando? Toda vez que fecho os olhos, a névoa surge. Os piratas fantasmas... eles estão me chamando das margens do deserto. Mas a parte mais aterrorizante foi falar com ele... Jerome. Aquele antigo bandido de Wazel que foi levado para Havarus anos atrás. Ele estava lá, no meu sonho, me dizendo que eles estão vindo. Temo que não sejam mais apenas sonhos.");
        cvNightmareStart.addOptionText(SPANISH, "Parece que no has dormido en días.", "*Da un pequeño salto, con los ojos muy abiertos y ensangrentados*\n¿Dormir? ¿Cómo voy a dormir cuando están esperando? Cada vez que cierro los ojos, aparece la niebla. Los piratas fantasmales... me llaman desde las orillas del desierto. Pero lo más aterrador fue hablar con él... Jerome. Aquel viejo bandido de Wazel al que se llevaron a Havarus hace años. Estaba allí, en mi sueño, diciéndome que ya vienen. Temo que ya no sejam sólo sueños.");
        cvNightmareStart.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.A_RUMOR_SPREADING) && !LibQuest.charHasQuest(QuestsIds.NIGHTMARE_TO_REALITY, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvNightmareStart);

        // Accept (group 1 -> 0)
        ConversationOption cvNightmareAccept = new ConversationOption(1, 0);
        cvNightmareAccept.addOptionText(ENGLISH, "I'll find Jerome and check his words.", "*He shudders, gripping his arms tightly*\nI still can't shake the feeling... it was too real, the cold, the smell of salt and old bones. If Jerome is truly wandering through dreams as he claimed, he's the only one who knows if this is a warning or just madness. He used to be a bandit here in Wazel before they dragged him off to Havarus Prison. Please, traveler... find him. Ask him if the pirates are truly coming.");
        cvNightmareAccept.addOptionText(PORTUGUESE, "Vou achar Jerome e checar suas palavras.", "*Ele estremece, segurando os braços com força*\nAinda não consigo afastar a sensação... foi real demais, o frio, o cheiro de sal e ossos velhos. Se Jerome está realmente vagando pelos sonhos como ele alegou, ele é o único que sabe se isso é um aviso ou apenas loucura. Ele costumava ser um bandido aqui em Wazel antes de o levarem para a Prisão de Havarus. Por favor, viajante... encontre-o. Pergunte se os piratas estão realmente vindo.");
        cvNightmareAccept.addOptionText(SPANISH, "Buscaré a Jerome para ver se diz a verdade.", "*Se estremece, sujetándose os brazos com fuerza*\nTodavía no consigo quitarme la sensación... fue demasiado real, el frío, el olor a sal y a huesos viejos. Se Jerome está realmente vagando por los sueños como afirmó, es el único que sabe se esto es una advertencia o simplemente locura. Antes era un bandido aquí en Wazel antes de que se lo llevaran a la Prisión de Havarus. Por favor, viajero... encuéntralo. Pregúntale se los piratas vienen de verdad.");
        cvNightmareAccept.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(App.DataManager.getQuest(QuestsIds.NIGHTMARE_TO_REALITY), App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvNightmareAccept);

        // Progress check after Jerome (group 0 -> 0)
        ConversationOption cvNightmareAfterJerome = new ConversationOption(0, 0);
        cvNightmareAfterJerome.addOptionText(ENGLISH, "Jerome confirmed the attack. He spoke about it in a very... unique way.", "*He shudders*\nUnique? He's mad! But if he knows, the dream is real. He told me more details in my sleep... they will land at the Desert Shores. Go there, quickly!");
        cvNightmareAfterJerome.addOptionText(PORTUGUESE, "Jerome confirmou o ataque. Ele falou sobre isso de uma forma bem... única.", "*Ele estremece*\nÚnica? Ele é louco! Mas se ele sabe, o sonho é real. Ele me contou mais detalhes no meu sono... eles vão desembarcar na Praia do Deserto. Vá lá, rápido!");
        cvNightmareAfterJerome.addOptionText(SPANISH, "Jerome confirmó el ataque. Habló de ello de una forma muy... única.", "*Se estremece*\n¿Única? ¡Está loco! Pero si lo sabe, el sueño es real. Me dio más detalles mientras dormía... desembarcarán en las Orillas del Desierto. ¡Ve allí, rápido!");
        cvNightmareAfterJerome.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.NIGHTMARE_TO_REALITY, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvNightmareAfterJerome.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.NIGHTMARE_TO_REALITY, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvNightmareAfterJerome);

        // Progress check after battle 1 (group 0 -> 0)
        ConversationOption cvNightmareAfterBattle1 = new ConversationOption(0, 0);
        cvNightmareAfterBattle1.addOptionText(ENGLISH, "I controlled the attack at the shores. The ghosts are banished.", "*His face pales instead of brightening*\nControlled? No... it was only the beginning! The nightmare continues! I saw them in my sleep again... they are planning to raid the city from the south, coming through the Oasis! You must stop them!");
        cvNightmareAfterBattle1.addOptionText(PORTUGUESE, "Eu controlei o ataque nas margens. Os fantasmas foram banidos.", "*O rosto dele empalidece em vez de brilhar*\nControlado? No... era apenas o começo! O pesadelo continua! Eu os vi no meu sono de novo... eles estão planejando saquear a cidade pelo sul, vindo pelo Oásis! Você deve detê-los!");
        cvNightmareAfterBattle1.addOptionText(SPANISH, "He controlado el ataque en las costas. Los fantasmas han sido desterrados.", "*Su rostro palidece en lugar de iluminarse*\n¿Controlado? No... ¡sólo era el principio! ¡La pesadilla continúa! Los he vuelto a ver en sueños... ¡planean saquear la ciudad desde el sur, por el Oasis! ¡Debes detenerlos!");
        cvNightmareAfterBattle1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.NIGHTMARE_TO_REALITY, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvNightmareAfterBattle1.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.NIGHTMARE_TO_REALITY, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvNightmareAfterBattle1);

        // Complete Quest (group 0 -> 0)
        ConversationOption cvNightmareComplete = new ConversationOption(0, 0);
        cvNightmareComplete.addOptionText(ENGLISH, "The pirates at the Oasis are gone. The threat is over.", "*He breathes a massive sigh of relief*\nIt's quiet. The fog in my mind... it's finally gone. The nightmare is over. Thank you, traveler. You've done what I thought impossible.");
        cvNightmareComplete.addOptionText(PORTUGUESE, "Os piratas no Oásis se foram. A ameaça acabou.", "*Ele solta um enorme suspiro de alívio*\nEstá calmo. A névoa na minha mente... finalmente sumiu. O pesadelo acabou. Obrigado, viajante. Você fez o que eu achei impossível.");
        cvNightmareComplete.addOptionText(SPANISH, "Los piratas del Oasis se han ido. La amenaza ha terminado.", "*Lanza un enorme suspiro de alivio*\nTodo está en calma. La niebla de mi mente... por fin ha desaparecido. La pesadilla ha terminado. Gracias, viajero. Has hecho lo que creía imposible.");
        cvNightmareComplete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.NIGHTMARE_TO_REALITY, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvNightmareComplete.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.NIGHTMARE_TO_REALITY, App.getPlayerChar(), 7, ctx);
        };
        npc.conversationOptions.add(cvNightmareComplete);

        return npc;
    }
}
