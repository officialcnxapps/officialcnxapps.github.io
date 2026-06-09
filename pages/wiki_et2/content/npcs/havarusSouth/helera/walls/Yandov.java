package com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.walls;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.A_QUEEN_MESSAGE;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.DEFEND_HELERA;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.GIVING_ORDERS;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.SEEKING_WISDOM;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.WAZEL_BATTLE;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Yandov extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Yandov");
        npc.age = 23;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Greetings. I'm on watch duty."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Saudações. Estou de guarda."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Saludos. Estoy de guardia."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Stay safe out there."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Fique seguro por aí."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Mantente seguro ahí fuera."));

        // ===== CONVERSATION OPTION 1: General Information =====
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What do you do here?", "I'm part of the city guard. We patrol the walls and keep Helera safe. With the port and markets here, we're a prime target for attacks. Can't let our guard down for a second.");
        cv1.addOptionText(PORTUGUESE, "O que você faz aqui?", "Sou parte da guarda da cidade. Patrulhamos as muralhas e mantemos Helera segura. Com o porto e mercados aqui, somos um alvo principal para ataques. Não podemos baixar a guarda nem por um segundo.");
        cv1.addOptionText(SPANISH, "¿Qué haces aquí?", "Soy parte de la guardia de la ciudad. Patrullamos las murallas y mantenemos Helera a salvo. Con el puerto y los mercados aquí, somos un objetivo principal para ataques. No podemos bajar la guardia ni por un segundo.");
        cv1.requirementValidations = (chara, ctx) -> {
            // Não mostrar esta conversa durante part 2 de Defend Helera
            if (LibQuest.isCharacterAtQuestPart(chara, DEFEND_HELERA, 2)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cv1);

        // ===== CONVERSATION OPTION 2: About GIVING_ORDERS Quest Part 2 =====
        ConversationOption cv2 = new ConversationOption(0, 1);
        cv2.addOptionText(ENGLISH, "I need to know about Helera's defense situation.", "Ah, you must be from the capital. Good timing. Helera is critical to the kingdom's economy - we have the main port and the largest marketplace. But our defenses are stretched thin. With these dark creatures appearing, we're worried about coordinated attacks.");
        cv2.addOptionText(PORTUGUESE, "Preciso saber sobre a situação de defesa de Helera.", "Ah, você deve ser da capital. Boa hora. Helera é crítica para a economia do reino - temos o porto principal e o maior mercado. Mas nossas defesas estão esticadas. Com essas criaturas das trevas aparecendo, estamos preocupados com ataques coordenados.");
        cv2.addOptionText(SPANISH, "Necesito saber sobre la situación de defensa de Helera.", "Ah, debes ser de la capital. Buen momento. Helera es crítica para la economía del reino - tenemos el puerto principal y el mercado más grande. Pero nuestras defensas están al límite. Con estas criaturas oscuras apareciendo, estamos preocupados por ataques coordinados.");
        cv2.requirementValidations = (chara, ctx) -> {
            // Não mostrar durante part 2 de Defend Helera
            if (LibQuest.isCharacterAtQuestPart(chara, DEFEND_HELERA, 2)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            if (LibQuest.isCharacterAtQuestPart(chara, GIVING_ORDERS, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(1, 2);
        cv3.addOptionText(ENGLISH, "What reinforcements do you need?", "We need more trained soldiers - preferably archers for the walls and marines for the port. But there's more to it. If we're besieged, we'll need stockpiled supplies - food, water, ammunition. The merchants here are wealthy enough to fund equipment, but we need the kingdom's support for manpower and emergency provisions. If the port falls, the kingdom's trade collapses, and we could be cut off from vital supply routes. We also need better fortifications at the docks where ships unload.");
        cv3.addOptionText(PORTUGUESE, "Que reforços você precisa?", "Precisamos de mais soldados treinados - de preferência arqueiros para as muralhas e marinheiros para o porto. Mas há mais. Se formos cercados, precisaremos de mantimentos estocados - comida, água, munição. Os mercadores aqui são ricos o suficiente para financiar equipamentos, mas precisamos do apoio do reino para mão de obra e provisões de emergência. Se o porto cair, o comércio do reino entra em colapso, e podemos ser cortados de rotas de suprimento vitais. Também precisamos de melhores fortificações nas docas onde os navios descarregam.");
        cv3.addOptionText(SPANISH, "¿Qué refuerzos necesitas?", "Necesitamos más soldados entrenados - preferiblemente arqueros para las murallas y marines para el puerto. Pero hay más. Si somos asediados, necesitaremos suministros almacenados - comida, agua, munición. Los comerciantes aquí son lo suficientemente ricos como para financiar equipos, pero necesitamos el apoyo del reino para mano de obra y provisiones de emergencia. Si el puerto cae, el comercio del reino colapsa, y podríamos quedar aislados de rutas de suministro vitales. También necesitamos mejores fortificaciones en los muelles donde los barcos descargan.");
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(2, 0);
        cv4.addOptionText(ENGLISH, "I'll take this information to Guzar.", "Thank you. The merchants and the entire city are counting on proper defenses. We can't afford to lose Helera.");
        cv4.addOptionText(PORTUGUESE, "Vou levar essa informação para Guzar.", "Obrigado. Os mercadores e toda a cidade estão contando com defesas adequadas. Não podemos perder Helera.");
        cv4.addOptionText(SPANISH, "Llevaré esta información a Guzar.", "Gracias. Los comerciantes y toda la ciudad cuentan con defensas adecuadas. No podemos permitirnos perder Helera.");
        cv4.listeners = (ctx, currentFragment) -> {
            Quest quest = App.getPlayerChar().getQuest(GIVING_ORDERS);
            LibQuest.updateQuest(quest, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv4);

        // ===== CONVERSATION OPTION 5: Status after reporting =====
        ConversationOption cv5 = new ConversationOption(0, 0);
        cv5.addOptionText(ENGLISH, "How's the security here?", "We're keeping watch, but we need reinforcements. Every merchant ship that arrives could be carrying threats. We're doing our best with what we have.");
        cv5.addOptionText(PORTUGUESE, "Como está a segurança aqui?", "Estamos de vigia, mas precisamos de reforços. Cada navio mercante que chega pode estar carregando ameaças. Estamos fazendo o melhor com o que temos.");
        cv5.addOptionText(SPANISH, "¿Cómo está la seguridad aquí?", "Estamos vigilando, pero necesitamos refuerzos. Cada barco mercante que llega podría estar transportando amenazas. Estamos haciendo lo mejor que podemos con lo que tenemos.");
        cv5.requirementValidations = (chara, ctx) -> {
            // Não mostrar durante part 2 de Defend Helera
            if (LibQuest.isCharacterAtQuestPart(chara, DEFEND_HELERA, 2)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            if (LibQuest.isCharacterAtQuestPart(chara, GIVING_ORDERS, 3) && !LibQuest.isQuestComplete(chara, A_QUEEN_MESSAGE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv5);

        // ===== QUEST 19.A: Receive Provisions from Farmland =====
        ConversationOption cvReceiveProvisions = new ConversationOption(0, 6);
        cvReceiveProvisions.addOptionText(ENGLISH, "I've brought provisions from Farmland for Helera's defense.", "Excellent! Let me see what you have... ");
        cvReceiveProvisions.addOptionText(PORTUGUESE, "Trouxe suprimentos de Farmland para a defesa de Helera.", "Excelente! Deixe-me ver o que você tem... ");
        cvReceiveProvisions.addOptionText(SPANISH, "He traído suministros de Farmland para la defensa de Helera.", "¡Excelente! Dejame ver lo que tienes... ");
        cvReceiveProvisions.requirementValidations = (chara, ctx) -> {
            // Não mostrar durante part 2 de Defend Helera
            if (LibQuest.isCharacterAtQuestPart(chara, DEFEND_HELERA, 2)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.REINFORCE_HELERA, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvReceiveProvisions);

        // Response if player HAS the provisions
        ConversationOption cvReceiveProvisionsSuccess = new ConversationOption(6, 0);
        cvReceiveProvisionsSuccess.addOptionText(ENGLISH, "[Give provisions]", "Perfect! These supplies are vital to our survival. With food and water secured, we can focus entirely on defense without worrying about starvation. Our defenders will hold strong knowing they have what they need to endure. This shipment will sustain our garrison and civilians during the siege. Well done - Farmland came through. We won't forget this cooperation between our cities.");
        cvReceiveProvisionsSuccess.addOptionText(PORTUGUESE, "[Entregar mantimentos]", "Perfeito! Esses suprimentos são vitais para nossa sobrevivência. Com comida e água garantidas, podemos focar inteiramente na defesa sem nos preocupar com fome. Nossos defensores se manterão fortes sabendo que têm o que precisam para resistir. Este carregamento vai sustentar nossa guarnição e civis durante o cerco. Bem feito - Farmland se comprometeu. Não esqueceremos dessa cooperação entre nossas cidades.");
        cvReceiveProvisionsSuccess.addOptionText(SPANISH, "[Entregar provisiones]", "¡Perfecto! Estos suministros son vitales para nuestra supervivencia. Con comida y agua aseguradas, podemos enfocarnos completamente en la defensa sin preocuparnos por el hambre. Nuestros defensores se mantendrán fuertes sabiendo que tienen lo que necesitan para resistir. Este envío mantendrá nuestra guarnición y civiles durante el asedio. Bien hecho - Farmland se comprometió. No olvidaremos esta cooperación entre nuestras ciudades.");
        cvReceiveProvisionsSuccess.requirementValidations = (chara, ctx) -> {
            boolean hasProvisions = LibInventory.checkHasItemAmount(ItemsIds.HELERA_PROVISIONS, 1, chara);
            if (hasProvisions) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvReceiveProvisionsSuccess.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.HELERA_PROVISIONS, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.REINFORCE_HELERA, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvReceiveProvisionsSuccess);

        // Response if player DOES NOT have the provisions
        ConversationOption cvReceiveProvisionsFail = new ConversationOption(6, 0);
        cvReceiveProvisionsFail.addOptionText(ENGLISH, "[Check provisions]", "Hmm... Where are the provisions? You need to bring the supply crate from Farmland. Please return when you have them.");
        cvReceiveProvisionsFail.addOptionText(PORTUGUESE, "[Verificar mantimentos]", "Hmm... Onde estão os mantimentos? Você precisa trazer a caixa de suprimentos de Farmland. Por favor, retorne quando os tiver.");
        cvReceiveProvisionsFail.addOptionText(SPANISH, "[Verificar provisiones]", "Hmm... ¿Dónde están las provisiones? Necesitas traer el cajón de suministros de Farmland. Por favor, regresa cuando los tengas.");
        cvReceiveProvisionsFail.requirementValidations = (chara, ctx) -> {
            boolean hasProvisions = LibInventory.checkHasItemAmount(ItemsIds.HELERA_PROVISIONS, 1, chara);
            if (!hasProvisions) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvReceiveProvisionsFail);

        // ===== ROLEPLAY: After Defend Helera =====
        ConversationOption cvRoleplayAfterDefense = new ConversationOption(0, 0);
        cvRoleplayAfterDefense.addOptionText(ENGLISH, "How are things in Helera after the battle?", "Much better now, thanks to your help. The dark creatures have been pushed back, and our people can finally breathe easier. The port is operating again, and merchants are returning to the markets. But we cannot lower our guard - those creatures emerged from the shadows once, and they could strike again. We must stay vigilant and keep our defenses strong while we repair the damage they caused.");
        cvRoleplayAfterDefense.addOptionText(PORTUGUESE, "Como estão as coisas em Helera após a batalha?", "Muito melhor agora, graças à sua ajuda. As criaturas das trevas foram rechaçadas, e nosso povo finalmente pode respirar mais aliviado. O porto está operando novamente, e os mercadores estão retornando aos mercados. Mas não podemos baixar a guarda - essas criaturas emergiram das sombras uma vez, e podem atacar novamente. Devemos permanecer vigilantes e manter nossas defesas fortes enquanto reparamos os danos que causaram.");
        cvRoleplayAfterDefense.addOptionText(SPANISH, "¿Cómo están las cosas en Helera después de la batalla?", "Mucho mejor ahora, gracias a tu ayuda. Las criaturas oscuras han sido rechazadas, y nuestra gente finalmente puede respirar más tranquila. El puerto está operando nuevamente, y los comerciantes están regresando a los mercados. Pero no podemos bajar la guardia - esas criaturas surgieron de las sombras una vez, y podrían atacar de nuevo. Debemos permanecer vigilantes y mantener nuestras defensas fuertes mientras reparamos el daño que causaron.");
        cvRoleplayAfterDefense.requirementValidations = (chara, ctx) -> {
            boolean defendComplete = LibQuest.isQuestComplete(chara, DEFEND_HELERA);
            boolean hasWazelBattle = LibQuest.charHasQuest(WAZEL_BATTLE, chara);

            if (defendComplete && !hasWazelBattle) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplayAfterDefense);

        // ===== QUEST 21.B: Defend Helera - Roleplay após Part 1 (Batalha 1) =====
        ConversationOption cvDefendRoleplay = new ConversationOption(0, 0);
        cvDefendRoleplay.addOptionText(ENGLISH, "That battle was intense!", "Yes, but we held the walls! However, reports are coming in from the south - our harbor is under heavy attack. The merchants and dock workers need immediate help. You must get to the port quickly!");
        cvDefendRoleplay.addOptionText(PORTUGUESE, "Essa batalha foi intensa!", "Sim, mas mantivemos as muralhas! No entanto, relatórios estão chegando do sul - nosso porto está sob forte ataque. Os mercadores e trabalhadores do porto precisam de ajuda imediata. Você deve ir ao porto rapidamente!");
        cvDefendRoleplay.addOptionText(SPANISH, "¡Esa batalla fue intensa!", "¡Sí, pero mantuvimos los muros! Sin embargo, llegan informes del sur: nuestro puerto está bajo un fuerte ataque. Los comerciantes y trabajadores del puerto necesitan ayuda inmediata. ¡Debes llegar al puerto rápidamente!");
        cvDefendRoleplay.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, DEFEND_HELERA, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvDefendRoleplay);

        // ===== QUEST 21.B: Defend Helera - Part 3 =====
        ConversationOption cvDefend3 = new ConversationOption(0, 9);
        cvDefend3.addOptionText(ENGLISH, "The port is secure!", "Well done! But we're not finished yet. The creatures are regrouping north of the city. If we strike now while they're disorganized, we can break their assault completely. Are you ready for one final push?");
        cvDefend3.addOptionText(PORTUGUESE, "O porto está seguro!", "Muito bem! Mas ainda não terminamos. As criaturas estão se reagrupando ao norte da cidade. Se atacarmos agora enquanto estão desorganizadas, podemos quebrar completamente o assalto delas. Você está pronto para um último empurrão?");
        cvDefend3.addOptionText(SPANISH, "¡El puerto está seguro!", "¡Bien hecho! Pero no hemos terminado. Las criaturas se están reagrupando al norte de la ciudad. Si atacamos ahora mientras están desorganizadas, podemos romper completamente su asalto. ¿Estás listo para un último empujón?");
        cvDefend3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, DEFEND_HELERA, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvDefend3.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(DEFEND_HELERA, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvDefend3);

        ConversationOption cvDefend3Response = new ConversationOption(9, 0);
        cvDefend3Response.addOptionText(ENGLISH, "Let's finish this!", "Excellent! Head to Helera's North Trail and catch them before they can regroup. This will be the decisive blow!");
        cvDefend3Response.addOptionText(PORTUGUESE, "Vamos terminar isso!", "Excelente! Vá até a Trilha Norte de Helera e pegue-as antes que possam se reagrupar. Este será o golpe decisivo!");
        cvDefend3Response.addOptionText(SPANISH, "¡Terminemos con esto!", "¡Excelente! Dirígete al Sendero Norte de Helera y atrápalos antes de que puedan reagruparse. ¡Este será el golpe decisivo!");
        npc.conversationOptions.add(cvDefend3Response);

        // ===== QUEST: New Route - Part 2 (The Protector's Honor) =====
        ConversationOption cvNewRoute2 = new ConversationOption(0, 10);
        cvNewRoute2.addOptionText(ENGLISH, "A wise elf named Aslatan seeks wisdom about life's meaning.", "*Pauses mid-patrol, considering the question*\nLife's meaning? \n\n*Looks out over the city walls*\n\nI've spent my years defending these walls, training soldiers, protecting families who sleep safely because we stand watch. Every morning I wake knowing that my actions today might save a life tomorrow. \n\nA meaningful life is one lived in service to something greater than oneself. Honor comes not from glory, but from duty fulfilled - protecting those who cannot protect themselves. When darkness comes, we stand between it and the innocent. That is purpose.\n\nTell Aslatan: find what you must protect, and dedicate yourself to it. Purpose is forged in sacrifice and tempered in duty.");
        cvNewRoute2.addOptionText(PORTUGUESE, "Um elfo sábio chamado Aslatan busca sabedoria sobre o significado da vida.", "*Pausa durante a patrulha, considerando a questão*\nO significado da vida? \n\n*Olha sobre as muralhas da cidade*\n\nPassei meus anos defendendo essas muralhas, treinando soldados, protegendo famílias que dormem seguras porque ficamos de vigia. Toda manhã acordo sabendo que minhas ações hoje podem salvar uma vida amanhã. \n\nUma vida significativa é vivida a serviço de algo maior que si mesmo. A honra não vem da glória, mas do dever cumprido - proteger aqueles que não podem se proteger. Quando a escuridão vem, ficamos entre ela e os inocentes. Esse é o propósito.\n\nDiga a Aslatan: encontre o que você deve proteger e dedique-se a isso. O propósito é forjado no sacrifício e temperado no dever.");
        cvNewRoute2.addOptionText(SPANISH, "Un elfo sabio llamado Aslatan busca sabiduría sobre el significado de la vida.", "*Pausa durante la patrulla, considerando la pregunta*\n¿El significado de la vida? \n\n*Mira sobre las murallas de la ciudad*\n\nHe pasado mis años defendiendo estas murallas, entrenando soldados, protegiendo familias que duermen seguras porque montamos guardia. Cada mañana despierto sabiendo que mis acciones hoy podrían salvar una vida mañana. \n\nUna vida significativa se vive al servicio de algo más grande que uno mismo. El honor no viene de la gloria, sino del deber cumplido - proteger a aquellos que no pueden protegerse. Cuando llega la oscuridad, nos interponemos entre ella y los inocentes. Ese es el propósito.\n\nDile a Aslatan: encuentra lo que debes proteger y dedícate a ello. El propósito se forja en el sacrificio y se templa en el deber.");
        cvNewRoute2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, SEEKING_WISDOM, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvNewRoute2);

        ConversationOption cvNewRoute2Complete = new ConversationOption(10, 0);
        cvNewRoute2Complete.addOptionText(ENGLISH, "Thank you, Captain.", "May your path be honorable, traveler. Now, seek wisdom from those who serve the divine at the Monastery in Esperand - men of faith who dedicate their lives to spiritual service can offer profound insights on purpose and meaning.");
        cvNewRoute2Complete.addOptionText(PORTUGUESE, "Obrigado, Capitão.", "Que seu caminho seja honrado, viajante. Agora, busque sabedoria daqueles que servem o divino no Monastério em Esperand - homens de fé que dedicam suas vidas ao serviço espiritual podem oferecer insights profundos sobre propósito e significado.");
        cvNewRoute2Complete.addOptionText(SPANISH, "Gracias, Capitán.", "Que tu camino sea honorable, viajero. Ahora, busca sabiduría de aquellos que sirven a lo divino en el Monasterio en Esperand - hombres de fe que dedican sus vidas al servicio espiritual pueden ofrecer perspectivas profundas sobre propósito y significado.");
        cvNewRoute2Complete.listeners = (ctx, fragment) -> LibQuest.updateQuest(SEEKING_WISDOM, 3, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvNewRoute2Complete);

        return npc;
    }
}

