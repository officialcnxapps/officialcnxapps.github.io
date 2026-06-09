package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.docks;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.KILL_OCTUMAN;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.SEA_VERIFICATION;
import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.Character;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;
import com.cnx.endlesstalestwo.libs.Utils;

public class CaptainNorman extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Captain Norman");
        npc.addNameTranslation(PORTUGUESE, "Capitão Norman");
        npc.addNameTranslation(SPANISH, "Capitán Norman");
        npc.age = 40;
        npc.job = Enums.NPCJobs.SHIP_CAPTAIN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // Conversation options

        ///ABOUT QUEST: SEA VERIFICATION
        ConversationOption cv2 = new ConversationOption(0, 1);
        cv2.addOptionText(ENGLISH, "Have you reported any attacks on your ships recently?", "Yes, I’ve already reported it to the authorities. It’s dangerous; I lost 5 of my crew members last week. I’ve never seen anything so terrifying.");
        cv2.addOptionText(PORTUGUESE, "Relatou algum ataque à seus navios recentemente?", "Sim, já reportei as autoridades. Está perigoso, perdi 5 homens da minha tripulação na última semana. Nunca vi algo tão aterrorizante.");
        cv2.addOptionText(SPANISH, "¿Has reportado algún ataque a tus barcos recientemente?", "Sí, ya lo he reportado a las autoridades. Es peligroso; perdí a 5 de mis tripulantes la semana pasada. Nunca he visto algo tan aterrador.");
        cv2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, SEA_VERIFICATION, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(1, 0);
        cv3.addOptionText(ENGLISH, "Do you know what is attacking?", "I’m not sure, it’s some creature from the depths, I’ve never seen it before. It attacks stealthily. By the time we notice, it’s already on board, dragging men into the depths of the sea.");
        cv3.addOptionText(PORTUGUESE, "Sabe o que está atacando?", "Não sei ao certo, é alguma criatura das profundezas, nunca vi antes. Ela ataca de forma sorrateira. Quando percebemos ela já está a bordo levando os homens para o fundo do mar.");
        cv3.addOptionText(SPANISH, "¿Sabes qué está atacando?", "No estoy seguro, es alguna criatura de las profundidades, nunca la había visto antes. Ataca sigilosamente. Para cuando nos damos cuenta, ya está a bordo, arrastrando a los hombres a las profundidades del mar.");
        cv3.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(SEA_VERIFICATION, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv3);

        ///ABOUT QUEST: KILL OCTUMAN
        ConversationOption cv4 = new ConversationOption(0, 3);
        cv4.addOptionText(ENGLISH, "I've discovered the creature that's attacking the ships.", "Really? That's good. What will you do to stop it?");
        cv4.addOptionText(PORTUGUESE, "Descobri a criatura que está atacando os navios.", "Verdade? isso é bom. O que farão para dete-la?");
        cv4.addOptionText(SPANISH, "He descubierto la criatura que está atacando los barcos.", "¿En serio? Eso es bueno. ¿Qué harás para detenerla?");
        cv4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, KILL_OCTUMAN, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(3, 4);
        cv5.addOptionText(ENGLISH, "I need to lure the creature to kill it.", "Sounds like a good idea, if you think you're strong enough for it. You're talking to me because you want my help, right?");
        cv5.addOptionText(PORTUGUESE, "Preciso atrair a criatura para matá-la.", "Parece uma boa ideia, se você se acha forte o suficiente para isso. Está falando comigo porque quer minha ajuda, isso?");
        cv5.addOptionText(SPANISH, "Necesito atraer a la criatura para matarla.", "Parece una buena idea, si crees que eres lo suficientemente fuerte para ello. Estás hablando conmigo porque quieres mi ayuda, ¿verdad?");
        npc.conversationOptions.add(cv5);

        ConversationOption cv6 = new ConversationOption(4, 999);
        cv6.addOptionText(ENGLISH, "Exactly. Let's sail to Helera, maybe that will attract it.", "Alright, I'll help, let's go!\nI want this creature dead.");
        cv6.addOptionText(PORTUGUESE, "Exato. Vamos navegar até Helera, talvez isso a atraia.", "Certo, eu ajuda, vamos lá!\nQuero essa criatura morta.");
        cv6.addOptionText(SPANISH, "Exacto. Naveguemos hasta Helera, tal vez eso la atraiga.", "¡De acuerdo, ayudaré, vamos!\nQuiero a esta criatura muerta.");
        cv6.listeners = (ctx, currentFragment) -> {
            Character chara = App.getPlayerChar();
            if (chara != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                LibQuest.updateQuest(KILL_OCTUMAN, 2, chara, ctx);
                Utils.getCharToLocation(LocationsIds.HELERA_HARBOR, 0, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cv6);


        ///TRAVEL OPTIONS
        ConversationOption cvTravel = new ConversationOption(0, 2);
        cvTravel.addOptionText(ENGLISH, "I want to travel.", "As you wish, to Lisport or to Helera?");
        cvTravel.addOptionText(PORTUGUESE, "Quero viajar.", "Como desejar, para Lisport ou para Helera?");
        cvTravel.addOptionText(SPANISH, "Quiero viajar.", "¿Como desees, a Lisport o a Helera?");
        npc.conversationOptions.add(cvTravel);

        ConversationOption cvTravel1 = new ConversationOption(2, 999);
        cvTravel1.addOptionText(ENGLISH, "Travel to Lisport [12 gold]", "Alright, let's set the sails!");
        cvTravel1.addOptionText(PORTUGUESE, "Viagem para Lisport [12 ouro]", "Certo, vamos içar as velas!");
        cvTravel1.addOptionText(SPANISH, "Viaje a Lisport [12 de oro]", "¡Muy bien, icemos las velas!");
        cvTravel1.showEvenWhenNotValid = true;
        cvTravel1.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(12)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cvTravel1.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.LISPORT_HARBOR, 12, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvTravel1);

        ConversationOption cvTravel2 = new ConversationOption(2, 999);
        cvTravel2.addOptionText(ENGLISH, "Travel to Helera [5 gold]", "Alright, let's set the sails!");
        cvTravel2.addOptionText(PORTUGUESE, "Viagem para Helera [5 ouro]", "Certo, vamos içar as velas!");
        cvTravel2.addOptionText(SPANISH, "Viaje a Helera [5 de oro]", "¡Muy bien, icemos las velas!");
        cvTravel2.showEvenWhenNotValid = true;
        cvTravel2.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cvTravel2.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.HELERA_HARBOR, 5, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvTravel2);

        // ===== QUEST: Swamp Club - Part 1 =====

        ConversationOption cvSwampClub = new ConversationOption(0, 301);
        cvSwampClub.addOptionText(ENGLISH, "I need information about merchant routes. Now.", "*Steps back defensively*\nWhat? Who are you? I don't just hand out route information to strangers. That's confidential business data!");
        cvSwampClub.addOptionText(PORTUGUESE, "Preciso de informações sobre rotas de mercadores. Agora.", "*Recua defensivamente*\nO quê? Quem é você? Não entrego informações de rotas para estranhos. Isso são dados confidenciais de negócios!");
        cvSwampClub.addOptionText(SPANISH, "Necesito información sobre rutas de mercaderes. Ahora.", "*Retrocede defensivamente*\n¿Qué? ¿Quién eres? ¡No entrego información de rutas a extraños! ¡Esos son datos comerciales confidenciales!");
        cvSwampClub.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SWAMP_CLUB, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvSwampClub);

        ConversationOption cvSwampThreat = new ConversationOption(301, 302);
        cvSwampThreat.addOptionText(ENGLISH, "[Grab him aggressively]", "*Terrified, voice shaking*\nAlright! Alright! Don't hurt me! The merchants... they travel through Havarus Main Road! Every week on the third day! Please, that's all I know!");
        cvSwampThreat.addOptionText(PORTUGUESE, "[Agarrar agressivamente]", "*Aterrorizado, voz tremendo*\nEstá bem! Está bem! Não me machuque! Os mercadores... eles viajam pela Estrada Principal de Havarus! Toda semana no terceiro dia! Por favor, é tudo que sei!");
        cvSwampThreat.addOptionText(SPANISH, "[Agarrar agresivamente]", "*Aterrorizado, voz temblorosa*\n¡Está bien! ¡Está bien! ¡No me lastimes! Los mercaderes... viajan por el Camino Principal de Havarus! ¡Cada semana el tercer día! ¡Por favor, es todo lo que sé!");
        npc.conversationOptions.add(cvSwampThreat);

        ConversationOption cvSwampLeave = new ConversationOption(302, 0);
        cvSwampLeave.addOptionText(ENGLISH, "[Release him]", "*Collapses to ground, breathing heavily*\nJust... just go. Please. I won't tell anyone about this. I swear!");
        cvSwampLeave.addOptionText(PORTUGUESE, "[Soltar ele]", "*Desaba no chão, respirando pesadamente*\nApenas... apenas vá. Por favor. Não vou contar a ninguém sobre isso. Eu juro!");
        cvSwampLeave.addOptionText(SPANISH, "[Soltarlo]", "*Se derrumba en el suelo, respirando pesadamente*\nSolo... solo vete. Por favor. ¡No le diré a nadie sobre esto! ¡Lo juro!");
        cvSwampLeave.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(QuestsIds.SWAMP_CLUB, 2, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvSwampLeave);

        // ===== ELFS AND HUMANS QUEST: Roleplay after completion =====
        ConversationOption cvElfsRoleplay = new ConversationOption(0, 0);
        cvElfsRoleplay.addOptionText(ENGLISH, "Eldrin told me you had quite a conversation at the tavern.", "Ha! That half-elf blacksmith found me a few nights ago and wouldn't stop talking about elves, Ayalon, and some ancient alliance. I'll admit, his stories lit something in me. I've been sailing the same routes for twenty years... maybe it's time to chart new waters.");
        cvElfsRoleplay.addOptionText(PORTUGUESE, "Eldrin me disse que vocês tiveram uma boa conversa na taverna.", "Há! Aquele ferreiro meio-elfo me encontrou há algumas noites e não parava de falar sobre elfos, Ayalon e alguma aliança antiga. Preciso admitir, as histórias dele acenderam algo em mim. Navego as mesmas rotas há vinte anos... talvez seja hora de traçar novos mares.");
        cvElfsRoleplay.addOptionText(SPANISH, "Eldrin me dijo que tuvieron una buena conversación en la taberna.", "¡Ja! Ese herrero mestizo me encontró hace unas noches y no paraba de hablar sobre elfos, Ayalon y alguna antigua alianza. Debo admitir que sus historias encendieron algo en mí. Llevo veinte años navegando las mismas rutas... quizás es hora de trazar nuevas aguas.");
        cvElfsRoleplay.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.ELFS_AND_HUMANS)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfsRoleplay);

        // ===== TRAVEL TO AYALON =====
        ConversationOption cvTravelAyalon = new ConversationOption(2, 999);
        cvTravelAyalon.addOptionText(ENGLISH, "Travel to Ayalon [6 gold]", "Aye! Eldrin's tales convinced me to open a route there. Let's set sail to the elven docks!");
        cvTravelAyalon.addOptionText(PORTUGUESE, "Viagem para Ayalon [6 ouro]", "Sim! As histórias de Eldrin me convenceram a abrir uma rota até lá. Içemos as velas rumo aos portos élficos!");
        cvTravelAyalon.addOptionText(SPANISH, "Viaje a Ayalon [6 de oro]", "¡Sí! Las historias de Eldrin me convencieron de abrir una ruta hasta allí. ¡Cojamos vela hacia los muelles élficos!");
        cvTravelAyalon.showEvenWhenNotValid = false;
        cvTravelAyalon.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.isQuestComplete(chara, QuestsIds.ELFS_AND_HUMANS)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cvTravelAyalon.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.AYALON_DOCKS, 6, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvTravelAyalon);

        ConversationOption cvTravelNo = new ConversationOption(2, 0);
        cvTravelNo.addOptionText(ENGLISH, "Changed my mind...", "Ok...");
        cvTravelNo.addOptionText(PORTUGUESE, "Mudei de ideia...", "Ok...");
        cvTravelNo.addOptionText(SPANISH, "Cambié de opinión...", "Ok...");
        npc.conversationOptions.add(cvTravelNo);

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What is it like to be a ship captain?", "I would say it's challenging. You need to love life at sea, understand the tides, and know how to lead a crew. The oceans hide dangers, secrets, and good stories.");
        cv1.addOptionText(PORTUGUESE, "Como é ser um capitão de navio?", "Eu diria que é desafiador. É preciso gostar da vida no mar, conhecer as marés e saber liderar uma tripulação. Os oceanos escondem perigos, segredos e boas histórias.");
        cv1.addOptionText(SPANISH, "¿Cómo es ser un capitán de barco?", "Diría que es desafiante. Necesitas amar la vida en el mar, entender las mareas y saber liderar una tripulación. Los océanos esconden peligros, secretos y buenas historias.");
        npc.conversationOptions.add(cv1);

        npc.hasRandomizedConversations = true;

        return npc;
    }
}
