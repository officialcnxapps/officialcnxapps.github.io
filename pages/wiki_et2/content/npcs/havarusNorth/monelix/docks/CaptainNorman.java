package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.docks;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.KILL_OCTUMAN;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.SEA_VERIFICATION;

import android.content.Context;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.Character;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.LocationTravelReference;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;
import com.cnx.endlesstalestwo.libs.Utils;

import java.util.ArrayList;

public class CaptainNorman extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Captain Norman");
        npc.addNameTranslation(PORTUGUESE, "Capitão Norman");
        npc.addNameTranslation(SPANISH, "Capitán Norman");
        npc.age = 42;
        npc.job = Enums.NPCJobs.SHIP_CAPTAIN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A ship captain who knows the sea and his craft well. He doesn't like to stay still, he likes movement.\nGood leadership, but with some moments of hesitation in his decisions.\n\nHis physical traits: Golden hair combed to the side. Thin, well-kept beard. Piercing blue eyes. Sun-tanned skin.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um capitão de navio que conhece bem o mar e o ofício. Não gosta muito de estar parado, gosta de movimento.\nBoa liderança, mas com alguns momentos de medo nas decisões.\n\nSeus traços físicos: Cabelos dourados penteados para o lado. Barba fina e bem cuidada. Olhos azuis penetrantes. Pele bronzeada pelo sol.");
        npc.addDescriptionTranslation(SPANISH, "Un capitán de barco que conoce bien el mar y su oficio. No le gusta estar quieto, le gusta el movimiento.\nBuena liderazgo, pero con algunos momentos de duda en sus decisiones.\n\nSus rasgos físicos: Cabello dorado peinado hacia un lado. Barba fina y bien cuidada. Ojos azules penetrantes. Piel bronceada por el sol.");

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
        ConversationOption cvTravel = new ConversationOption(0, 0);
        cvTravel.addOptionText(ENGLISH, "I want to travel.", "Aye! Where to?");
        cvTravel.addOptionText(PORTUGUESE, "Quero viajar.", "Sim! Para onde?");
        cvTravel.addOptionText(SPANISH, "Quiero viajar.", "¡Sí! ¿A dónde?");
        cvTravel.listeners = (ctx, currentFragment) -> openTravelDialog(ctx);
        npc.conversationOptions.add(cvTravel);

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
        // Removed Ayalon direct option, will be in dialog
        // npc.conversationOptions.add(cvTravelAyalon);

        ConversationOption cvTravelNo = new ConversationOption(2, 0);
        cvTravelNo.addOptionText(ENGLISH, "Changed my mind...", "Ok...");
        cvTravelNo.addOptionText(PORTUGUESE, "Mudei de ideia...", "Ok...");
        cvTravelNo.addOptionText(SPANISH, "Cambié de opinión...", "Ok...");
        // npc.conversationOptions.add(cvTravelNo);

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What is it like to be a ship captain?", "I would say it's challenging. You need to love life at sea, understand the tides, and know how to lead a crew. The oceans hide dangers, secrets, and good stories.");
        cv1.addOptionText(PORTUGUESE, "Como é ser um capitão de navio?", "Eu diria que é desafiador. É preciso gostar da vida no mar, conhecer as marés e saber liderar uma tripulação. Os oceanos escondem perigos, segredos e boas histórias.");
        cv1.addOptionText(SPANISH, "¿Cómo es ser un capitán de barco?", "Diría que es desafiante. Necesitas amar la vida en el mar, entender las mareas y saber liderar una tripulación. Los océanos esconden peligros, secretos y buenas historias.");
        npc.conversationOptions.add(cv1);

        npc.hasRandomizedConversations = true;

        // ========================================
        // QUEST: DRAGONLAND
        // ========================================

        // Part 6: Propose route
        ConversationOption cvDragonland6 = new ConversationOption(0, 0);
        cvDragonland6.addOptionText(ENGLISH, "I've been in Dragonland. Lady Jade thinks we should establish a route.",
                "*His eyes widen as he lets out a long whistle*\nDragonland? So the myths were true... and you actually came back from there? That's a feat worth a dozen bags of gold. \n\nIf Lady Jade says so, then mapping a route there is a business opportunity I can't ignore. I'll speak with the other captains — Palmer and Bradoch. If we coordinate, we can make this a standard run. It won't be cheap, mind you — the waters are treacherous — but we'll make it happen. Thank you, [PLAYERNAME]. You've opened a new path for us. Who knows what resources a land so mystical might have?");
        cvDragonland6.addOptionText(PORTUGUESE, "Estive em Dragonland. Lady Jade acha que devemos estabelecer uma rota.",
                "*Os olhos dele se arregalam enquanto ele solta um assobio longo*\nDragonland? Então os mitos eram verdadeiros... e você realmente voltou de lá? Esse é um feito que vale uma dúzia de sacos de ouro. \n\nSe lady Jade diz, então mapear uma rota para lá é uma oportunidade de negócio que não posso ignorar. Vou falar com os outros capitães — Palmer e Bradoch. Se nos coordenarmos, podemos tornar isso uma rota padrão. Não será barato, veja bem — as águas são traiçoeiras — mas faremos acontecer. Obrigado, [PLAYERNAME]. Você abriu uma nova para nós. Quem sabe o que poderá ter de recursos em uma terra tão mística?");
        cvDragonland6.addOptionText(SPANISH, "He estado en Dragonland. Lady Jade cree que deberíamos establecer una ruta.",
                "*Sus ojos se agrandan mientras deja escapar un largo silbido*\n¿Dragonland? Así que los mitos eran ciertos... ¿y realmente regresaste de allí? Esa es una hazaña que vale una docena de sacos de oro. \n\nSi Lady Jade lo dice, entonces trazar una ruta hacia allí es una oportunidad de negocio que no puedo ignorar. Hablaré con los otros capitanes: Palmer y Bradoch. Si nos coordinamos, podemos convertir esto en una ruta estándar. No será barato, fíjate —as aguas son traicioneras— pero lo haremos realidad. Gracias, [PLAYERNAME]. Has abierto un nuevo camino para nosotros. ¿Quién sabe qué recursos podría tener una tierra tan mística?");
        cvDragonland6.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 6)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvDragonland6.listeners = (ctx, currentFragment) -> LibQuest.completeQuest(QuestsIds.DRAGONLAND, App.getPlayerChar(), 7, ctx);
        npc.conversationOptions.add(cvDragonland6);

        // PERMANENT ROUTE
        ConversationOption cvTravelDragonland = new ConversationOption(2, 999);
        cvTravelDragonland.addOptionText(ENGLISH, "Travel to Dragonland [16 gold]", "Aye! To the land of dragons.");
        cvTravelDragonland.addOptionText(PORTUGUESE, "Viagem para Dragonland [16 ouro]", "Sim! Para a terra dos dragões.");
        cvTravelDragonland.addOptionText(SPANISH, "Viaje a Dragonland [16 de oro]", "¡Sí! A la tierra de los dragones.");
        cvTravelDragonland.showEvenWhenNotValid = false;
        cvTravelDragonland.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.isQuestComplete(chara, QuestsIds.DRAGONLAND)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(16)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cvTravelDragonland.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                com.cnx.endlesstalestwo.libs.Utils.getCharToLocation(LocationsIds.PLAINS_OF_DRAGONLAND, 16, gPlayActivity, App.getPlayerChar());
            }
        };
        // Removed Dragonland direct option, will be in dialog
        // npc.conversationOptions.add(cvTravelDragonland);

        return npc;
    }

    private void openTravelDialog(Context ctx) {
        ArrayList<LocationTravelReference> destinations = new ArrayList<>();

        LocationTravelReference helera = new LocationTravelReference(null, LocationsIds.HELERA_HARBOR, 120);
        helera.destinationName = "Helera";
        helera.travelCost = 5;
        destinations.add(helera);

        LocationTravelReference lisport = new LocationTravelReference(null, LocationsIds.LISPORT_HARBOR, 300);
        lisport.destinationName = "Lisport";
        lisport.travelCost = 12;
        destinations.add(lisport);

        if (LibQuest.isQuestComplete(App.getPlayerChar(), QuestsIds.ELFS_AND_HUMANS)) {
            LocationTravelReference ayalon = new LocationTravelReference(null, LocationsIds.AYALON_DOCKS, 180);
            ayalon.destinationName = "Ayalon";
            ayalon.travelCost = 6;
            destinations.add(ayalon);
        }

        if (LibQuest.isQuestComplete(App.getPlayerChar(), QuestsIds.DRAGONLAND)) {
            LocationTravelReference dragonland = new LocationTravelReference(null, LocationsIds.PLAINS_OF_DRAGONLAND, 480);
            dragonland.destinationName = "Dragonland";
            dragonland.travelCost = 16;
            destinations.add(dragonland);
        }

        Utils.showTravelSelectionDialog(ctx, destinations);
    }
}
