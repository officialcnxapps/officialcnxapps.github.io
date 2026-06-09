package com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.harbor;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.events.EventsIds.DESTROY_THE_LAIR_PART_6;
import static com.cnx.endlesstalestwo.data.events.EventsIds.INVESTIGATE_THE_BEAST_PART_7;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.DESTROY_THE_LAIR;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.INVESTIGATE_THE_BEAST;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.KILL_OCTUMAN;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.SEA_VERIFICATION;

import android.os.Handler;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.entities.Character;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;
import com.cnx.endlesstalestwo.libs.Utils;

import java.util.Collections;

public class CaptainLukas extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Captain Lukas");
        npc.addNameTranslation(PORTUGUESE, "Capitão Lukas");
        npc.addNameTranslation(SPANISH, "Capitán Lukas");
        npc.age = 43;
        npc.job = Enums.NPCJobs.SHIP_CAPTAIN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, INVESTIGATE_THE_BEAST, 2)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hello to you."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá, para você."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola a ti."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Ya, see you around, [GENDER_SIMPLE_CALL]"));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Ya, nos vemos por aí, [GENDER_SIMPLE_CALL]"));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Ya, nos vemos por ahí, [GENDER_SIMPLE_CALL]"));

        // Conversation options
        ///ABOUT QUEST: SEA VERIFICATION
        ConversationOption cv2 = new ConversationOption(0, 1);
        cv2.addOptionText(ENGLISH, "Have you reported any attacks on your ships recently?", "Yes, things are dangerous. One of my ships was sunk. The attacks usually occur mainly on the route to Esperand.");
        cv2.addOptionText(PORTUGUESE, "Relatou algum ataque à seus navios recentemente?", "Sim, as coisas estão perigosas. Um dos meus navios foi afundado. Os ataques costumam ocorrer principalmente na rota para Esperand.");
        cv2.addOptionText(SPANISH, "¿Has reportado algún ataque a tus barcos recientemente?", "Sí, las cosas están peligrosas. Uno de mis barcos fue hundido. Los ataques suelen ocurrir principalmente en la ruta a Esperand.");
        cv2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, SEA_VERIFICATION, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(1, 0);
        cv3.addOptionText(ENGLISH, "Do you know what is attacking?", "Luckily, during the last attack, I was on the ship next to it, and through the spyglass, I could see: It looks like a human mixed with an octopus, it must be almost 14 feet tall, with arms that look like tentacles. This monster grabs men and pulls them into the depths of the sea. In this attack, it wrapped its arms around the sails and masts, and the ship was pulled down.");
        cv3.addOptionText(PORTUGUESE, "Sabe o que está atacando?", "Por sorte, no último ataque, eu estava no navio ao lado e pela luneta pude ver: Parece um humano misturado com polvo, deve ter quase 4 metros, uns braços que parecem tentáculos. Esse monstro agarra os homens e os puxa pro fundo do mar. Nesse ataque, enrolou os braços nas velas e mastros e o navio foi puxado para baixo.");
        cv3.addOptionText(SPANISH, "¿Sabes qué está atacando?", "Por suerte, durante el último ataque, estaba en el barco de al lado y, a través del catalejo, pude ver: Parece un humano mezclado con un pulpo, debe medir casi 4 metros, con brazos que parecen tentáculos. Este monstruo agarra a los hombres y los arrastra a las profundidades del mar. En este ataque, envolvió sus brazos alrededor de las velas y los mástiles, y el barco fue hundido.");
        cv3.listeners = (ctx, currentFragment) -> {
            if (App.getPlayerChar() != null) {
                LibQuest.updateQuest(SEA_VERIFICATION, 3, App.getPlayerChar(), ctx);
            }
        };
        npc.conversationOptions.add(cv3);

        ///ABOUT QUEST: INVESTIGATE THE BEAST
        ConversationOption cvQuestStart = new ConversationOption(0, 2);
        cvQuestStart.addOptionText(ENGLISH, "Guzar told me to talk to you.", "Yes, we have to investigate this beast better. The suggestion is to sail to Esperand and then come back, what do you think?");
        cvQuestStart.addOptionText(PORTUGUESE, "Guzar me disse para falar com você.", "Sim, temos que investigar melhor essa besta. A sugestão é navergarmos até Esperand e depois voltar, o que acha?");
        cvQuestStart.addOptionText(SPANISH, "Guzar me dijo que hablara contigo.", "Sí, tenemos que investigar mejor a esta bestia. La sugerencia es navegar a Esperand y luego regresar, ¿qué te parece?");
        cvQuestStart.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, INVESTIGATE_THE_BEAST, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestStart);

        ConversationOption cv4 = new ConversationOption(2, 999);
        cv4.addOptionText(ENGLISH, "Let's sail to investigate.", "It's dangerous, but let's go - better to cut this evil at the root.");
        cv4.addOptionText(PORTUGUESE, "Isso, vamos navegar para investigar.", "É perigoso, mas vamos lá, melhor cortarmos esse mal pela raíz logo.");
        cv4.addOptionText(SPANISH, "Vamos a navegar para investigar.", "Es peligroso, pero vamos - mejor cortar este mal de raíz.");
        cv4.listeners = (ctx, currentFragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                LibQuest.updateQuest(INVESTIGATE_THE_BEAST, 2, App.getPlayerChar(), ctx);
                Utils.getCharToLocation(LocationsIds.ESPERAND_HARBOR, 0, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(0, 0);
        cv5.addOptionText(ENGLISH, "I'll make sure this beast disappears soon.", "I hope so, [PLAYERNAME]. It's very dangerous to travel.\nI hope Verona can help you with something.");
        cv5.addOptionText(PORTUGUESE, "Vou garantir que essa besta desapareça logo.", "Assim espero, [PLAYERNAME]. Está muito perigoso viajar.\nEspero que Verona possa lhe ajudar com algo.");
        cv5.addOptionText(SPANISH, "Me aseguraré de que esta bestia desaparezca pronto.", "Eso espero, [PLAYERNAME]. Es muy peligroso viajar.\nEspero que Verona pueda ayudarte con algo.");
        cv5.requirementValidations = (chara, ctx) -> {
            if (                    (LibQuest.isCharacterAtQuestPart(chara, INVESTIGATE_THE_BEAST, 3) || LibQuest.isCharacterAtQuestPart(chara, SEA_VERIFICATION, 4))
                            && !LibQuest.isQuestComplete(chara, SEA_VERIFICATION)
            ) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv5);

        ConversationOption cv6 = new ConversationOption(0, 3);
        cv6.addOptionText(ENGLISH, "I have a potion, let's go investigate again.", "A potion? Like a repellent for the beast?");
        cv6.addOptionText(PORTUGUESE, "Tenho uma poção, vamos lá investigar novamente.", "Uma poção? Tipo um repelente para a besta?");
        cv6.addOptionText(SPANISH, "Tengo una poción, vamos a investigar de nuevo.", "¿Una poción? ¿Como un repelente para la bestia?");
        cv6.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, INVESTIGATE_THE_BEAST, 6)
                    && LibInventory.checkHasItem(ItemsIds.POTION_OF_WATER_BREATHING, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv6);

        ConversationOption cv7 = new ConversationOption(3, 999);
        cv7.addOptionText(ENGLISH, "To breathe underwater...", "Oh, of course, that makes much more sense. Let's go then!");
        cv7.addOptionText(PORTUGUESE, "Para respirar na água...", "Ah, é claro, faz muito mais sentido. Vamos então!");
        cv7.addOptionText(SPANISH, "Para respirar bajo el agua...", "Ah, claro, eso tiene mucho más sentido. ¡Vamos entonces!");
        cv7.listeners = (ctx, currentFragment) -> {
            Character chara = App.getPlayerChar();
            App.Shell.flowManager.currentLocation.checkedEventsAndBattles = false;
            if (chara != null) {
                new Handler().postDelayed(() -> {
                            LibQuest.updateQuest(INVESTIGATE_THE_BEAST, 7, chara, ctx);
                            App.Shell.flowManager.addEventToQueue(App.DataManager.getEvent(INVESTIGATE_THE_BEAST_PART_7));
                        },
                        1);
            }
        };
        npc.conversationOptions.add(cv7);

        ConversationOption cv8 = new ConversationOption(0, 4);
        cv8.addOptionText(ENGLISH, "I'm going to destroy the beast's lair.", "I like the idea. I imagine you want me to take you to the exact spot, right?");
        cv8.addOptionText(PORTUGUESE, "Vou destruir o covil da besta.", "Gosto da ideia. Imagino que quer que eu leve você até o ponto exato, certo?");
        cv8.addOptionText(SPANISH, "Voy a destruir la guarida de la bestia.", "Me gusta la idea. Imagino que quieres que te lleve al lugar exacto, ¿verdad?");
        cv8.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, DESTROY_THE_LAIR, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv8);

        ConversationOption cv9 = new ConversationOption(4, 999);
        cv9.addOptionText(ENGLISH, "That's right. There I'll go to the bottom and blow up the lair.", "Very well, then let's go!");
        cv9.addOptionText(PORTUGUESE, "Isso. Lá irei ao fundo e explodirei o covil.", "Muito bem, então vamos!");
        cv9.addOptionText(SPANISH, "Así es. Allí iré al fondo y volaré la guarida.", "Muy bien, ¡entonces vamos!");
        cv9.listeners = (ctx, currentFragment) -> {
            Character chara = App.getPlayerChar();
            if (chara != null) {
                LibInventory.removeFromInventory(ItemsIds.POTION_OF_WATER_BREATHING, 1, chara);
                App.Shell.flowManager.currentLocation.checkedEventsAndBattles = false;
                new Handler().postDelayed(() -> {
                            App.Shell.flowManager.addEventToQueue(App.DataManager.getEvent(DESTROY_THE_LAIR_PART_6));
                        },
                        1);
            }
        };
        npc.conversationOptions.add(cv9);

        ///ABOUT QUEST: INVESTIGATE THE BEAST
        ConversationOption cv10 = new ConversationOption(0, 0);
        cv10.addOptionText(ENGLISH, "Who should I talk to about magic?", "Verona, she's usually in the gardens, here in Helera. She always talked about some nature magics she learned, I guarantee she'll know something.");
        cv10.addOptionText(PORTUGUESE, "Com quem devo falar sobre a magia?", "Verona, ela costuma estar nos jardins, aqui em Helera. Ela sempre falou sobre algumas magias da natureza que ela aprendeu, garanto que saberá algo.");
        cv10.addOptionText(SPANISH, "¿Con quién debo hablar sobre magia?", "Verona, suele estar en los jardines, aquí en Helera. Siempre hablaba de algunas magias de la naturaleza que aprendió, te garantizo que sabrá algo.");
        cv10.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, INVESTIGATE_THE_BEAST, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv10);

        ///ABOUT QUEST: KILL OCTUMAN
        ConversationOption cv14 = new ConversationOption(0, 5);
        cv14.addOptionText(ENGLISH, "I'm trying to lure Octuman, but I couldn't from Monelix.", "Oh, so you're going to try to kill this beast?");
        cv14.addOptionText(PORTUGUESE, "Estou tentando atrair Octuman, partindo de Monelix não consegui.", "Ah, vai tentar matar essa besta então?");
        cv14.addOptionText(SPANISH, "Estoy tratando de atraer a Octuman, pero no pude desde Monelix.", "Oh, ¿entonces vas a intentar matar a esta bestia?");
        cv14.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, KILL_OCTUMAN, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv14);

        ConversationOption cv11 = new ConversationOption(5, 6);
        cv11.addOptionText(ENGLISH, "Yes, now I need you to take me to Esperand.", "Another navigation... I hope this works out, it's getting expensive, but still, better than losing my ship to this beast.");
        cv11.addOptionText(PORTUGUESE, "Sim, agora preciso que me leve até Esperand.", "Mais uma navegação... Espero que isso resulte, está ficando caro isso tudo, mas ainda assim, melhor que perder meu navio para essa besta.");
        cv11.addOptionText(SPANISH, "Sí, ahora necesito que me lleves a Esperand.", "Otra navegación... Espero que esto funcione, se está volviendo caro, pero aún así, mejor que perder mi barco por esta bestia.");
        npc.conversationOptions.add(cv11);

        ConversationOption cv12_kill = new ConversationOption(6, 999);
        cv12_kill.addOptionText(ENGLISH, "So, are we leaving now?", "Yes, the ship is loaded.");
        cv12_kill.addOptionText(PORTUGUESE, "Então, partimos agora?", "Sim, o navio está carregado.");
        cv12_kill.addOptionText(SPANISH, "Entonces, ¿nos vamos ahora?", "Sí, el barco está cargado.");
        cv12_kill.listeners = (ctx, currentFragment) -> {
            Character chara = App.getPlayerChar();
            if (chara != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.ESPERAND_HARBOR, 0, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cv12_kill);

        ConversationOption cv13 = new ConversationOption(0, 0);
        cv13.addOptionText(ENGLISH, "Did any other beasts disrupt your voyages?", "No, [PLAYERNAME]. After Octuman, the seas became calmer and safer, except for the occasional storms, but that's part of it.");
        cv13.addOptionText(PORTUGUESE, "Nenhuma outra besta atrapalhou suas navegações?", "Não, [PLAYERNAME]. Depois de Octuman, os mares ficaram mais calmos e seguros, exceto pelas tempestades de vez em quando, mas isso faz parte.");
        cv13.addOptionText(SPANISH, "¿Ninguna otra bestia interrumpió tus viajes?", "No, [PLAYERNAME]. Después de Octuman, los mares se volvieron más tranquilos y seguros, excepto por las tormentas ocasionales, pero eso es parte de ello.");
        cv13.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, KILL_OCTUMAN) || LibQuest.isQuestComplete(chara, DESTROY_THE_LAIR)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv13);

        ///TRAVEL OPTIONS
        ConversationOption cvTravel = new ConversationOption(0, 100);
        cvTravel.addOptionText(ENGLISH, "I need to sail.", "That's what I'm here for. We can go to Esperand, Wazel, and Monelix.");
        cvTravel.addOptionText(PORTUGUESE, "Preciso velejar.", "É para isso que estou aqui. Podemos ir para Esperand, Wazel e Monelix.");
        cvTravel.addOptionText(SPANISH, "Necesito navegar.", "Para eso estoy aquí. Podemos ir a Esperand, Wazel y Monelix.");
        npc.conversationOptions.add(cvTravel);

        ConversationOption cvTravel1 = new ConversationOption(100, 999);
        cvTravel1.addOptionText(ENGLISH, "Travel to Esperand [10 gold]", "Ya! Let the winds of the sea take us!");
        cvTravel1.addOptionText(PORTUGUESE, "Viagem para Esperand [10 ouro]", "Ya! Deixe que os ventos do mar nos leve!");
        cvTravel1.addOptionText(SPANISH, "Viaje a Esperand [10 de oro]", "¡Ya! ¡Que los vientos del mar nos lleven!");
        cvTravel1.showEvenWhenNotValid = true;
        cvTravel1.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(10)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cvTravel1.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.ESPERAND_HARBOR, 10, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvTravel1);

        ConversationOption cvTravel2 = new ConversationOption(100, 999);
        cvTravel2.addOptionText(ENGLISH, "Travel to Wazel [8 gold]", "Ya! Let the winds of the sea take us!");
        cvTravel2.addOptionText(PORTUGUESE, "Viagem para Wazel [8 ouro]", "Ya! Deixe que os ventos do mar nos leve!");
        cvTravel2.addOptionText(SPANISH, "Viaje a Wazel [8 de oro]", "¡Ya! ¡Que los vientos del mar nos lleven!");
        cvTravel2.showEvenWhenNotValid = true;
        cvTravel2.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(8)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cvTravel2.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.WAZEL_DOCKS, 8, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvTravel2);

        ConversationOption cvTravel3 = new ConversationOption(100, 999);
        cvTravel3.addOptionText(ENGLISH, "Travel to Monelix [5 gold]", "Ya! Let the winds of the sea take us!");
        cvTravel3.addOptionText(PORTUGUESE, "Viagem para Monelix [5 ouro]", "Ya! Deixe que os ventos do mar nos leve!");
        cvTravel3.addOptionText(SPANISH, "Viaje a Monelix [5 de oro]", "¡Ya! ¡Que los vientos del mar nos lleven!");
        cvTravel3.showEvenWhenNotValid = true;
        cvTravel3.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cvTravel3.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.MONELIX_DOCKS, 5, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvTravel3);

        ConversationOption cvTravelNo = new ConversationOption(100, 0);
        cvTravelNo.addOptionText(ENGLISH, "Changed my mind...", "Ok...");
        cvTravelNo.addOptionText(PORTUGUESE, "Mudei de ideia...", "Ok...");
        cvTravelNo.addOptionText(SPANISH, "Cambié de opinión...", "Ok...");
        npc.conversationOptions.add(cvTravelNo);

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Do you like life at sea?", "Yes, I really enjoy life at sea. I feel free, I go where the wind blows best, always accompanied by good sailors and good rum.");
        cv1.addOptionText(PORTUGUESE, "Gosta da vida no mar?", "Sim, eu gosto muito da vida no mar. Me sinto livre, vou aonde o vento sopra melhor, sempre acompanhado de bons marujos e de um bom rum.");
        cv1.addOptionText(SPANISH, "¿Te gusta la vida en el mar?", "Sí, disfruto mucho la vida en el mar. Me siento libre, voy donde el viento sopla mejor, siempre acompañado de buenos marineros y buen ron.");
        npc.conversationOptions.add(cv1);

        return npc;
    }
}