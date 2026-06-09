package com.cnx.endlesstalestwo.data.npcs.wazel.harbor;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.events.EventsIds.GHOST_SHIP_ENCOUNTER;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.THE_TALE_OF_A_GHOST_SHIP;

import android.os.Handler;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.entities.Character;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;
import com.cnx.endlesstalestwo.libs.Utils;

public class CaptainBradoch extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Captain Bradoch");
        npc.addNameTranslation(PORTUGUESE, "Capitão Bradoch");
        npc.addNameTranslation(SPANISH, "Capitán Bradoch");
        npc.age = 47;
        npc.job = Enums.NPCJobs.SHIP_CAPTAIN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.generateRandomByes();

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "Heard any interesting rumors from other ports?", "Aye, plenty. Sailors love to spin a yarn. The latest is about a ghost ship sighted off these coasts, crewed by silent, glowing figures. Probably just too much rum, if you ask me. But it makes for a good story by the fire.");
        cv1.addOptionText(PORTUGUESE, "Ouviu algum rumor interessante de outros portos?", "Sim, muitos. Marinheiros adoram contar uma história. A mais recente é sobre um navio fantasma avistado nestas costas, tripulado por figuras silenciosas e brilhantes. Provavelmente só rum a mais, se me perguntar. Mas dá uma boa história junto à lareira.");
        cv1.addOptionText(SPANISH, "¿Has oído algún rumor interesante de otros puertos?", "Sí, muchísimos. A los marineros les encanta inventar historias. La última es sobre un barco fantasma avistado cerca de estas costas, tripulado por figuras silenciosas y brillantes. Probablemente solo sea demasiado ron, si me preguntas. Pero es una buena historia para contar junto al fuego.");
        cv1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(THE_TALE_OF_A_GHOST_SHIP, chara)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(1, 0);
        cv2.addOptionText(ENGLISH, "A ghost ship? Tell me more.", "Heh, caught your interest, did I? The tale goes that it sails only on moonless nights, gliding silently through the water without a ripple. Some say they're the souls of sailors lost in storms, forever bound to their vessel. Spooky, eh?");
        cv2.addOptionText(PORTUGUESE, "Um navio fantasma? Conte-me mais.", "Heh, despertou o seu interesse, não foi? A lenda diz que ele navega apenas em noites sem lua, deslizando silenciosamente pela água sem uma única onda. Alguns dizem que são as almas dos marinheiros perdidos em tempestades, para sempre ligados ao seu navio. Assustador, não é?");
        cv2.addOptionText(SPANISH, "¿Un barco fantasma? Cuéntame más.", "Je, capté tu interés, ¿verdad? La leyenda cuenta que solo navega en noches sin luna, deslizándose silenciosamente por el agua sin dejar estela. Algunos dicen que son las almas de los marineros perdidos en tormentas, atados para siempre a su barco. Espeluznante, ¿eh?");
        npc.conversationOptions.add(cv2);

        // ===== GHOST SHIP QUEST: Investigate =====
        ConversationOption cvQuestInvestigate = new ConversationOption(1, 2);
        cvQuestInvestigate.addOptionText(ENGLISH, "I want to investigate this ghost ship legend. Can you help?", "*Raises an eyebrow*\nInvestigate it? Most people just want to hear the story and move on. But if you're serious...\n\n*Scratches his beard*\nTalk to the folk at the tavern - Teradoch, the tavern keeper, knows every sailor's tale that passes through these waters. He might know more about when and where the phantom appears. I just sail the routes - I leave the ghost hunting to the brave... or the foolish.");
        cvQuestInvestigate.addOptionText(PORTUGUESE, "Quero investigar esta lenda do navio fantasma. Pode me ajudar?", "*Levanta uma sobrancelha*\nInvestigar? A maioria das pessoas só quer ouvir a história e seguir em frente. Mas se você é sério...\n\n*Coça a barba*\nFale com o pessoal da taverna - Teradoch, o taverneiro, conhece cada conto de marinheiro que passa por estas águas. Ele pode saber mais sobre quando e onde o fantasma aparece. Eu apenas navego as rotas - deixo a caça aos fantasmas para os corajosos... ou tolos.");
        cvQuestInvestigate.addOptionText(SPANISH, "Quiero investigar esta leyenda del barco fantasma. ¿Puedes ayudarme?", "*Levanta una ceja*\n¿Investigarlo? La mayoría de la gente solo quiere escuchar la historia y seguir adelante. Pero si eres serio...\n\n*Se rasca la barba*\nHabla con la gente de la taberna - Teradoch, el tabernero, conoce cada cuento de marinero que pasa por estas aguas. Puede saber más sobre cuándo y dónde aparece el fantasma. Yo solo navego las rutas - dejo la caza de fantasmas para los valientes... o los tontos.");
        cvQuestInvestigate.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(THE_TALE_OF_A_GHOST_SHIP, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestInvestigate);

        ConversationOption cvQuestAccept = new ConversationOption(2, 0);
        cvQuestAccept.addOptionText(ENGLISH, "I'll do that. Thank you, Captain.", "Aye, good luck with that. If you find anything real, let me know - I'd hate to think there's actual danger in my waters.");
        cvQuestAccept.addOptionText(PORTUGUESE, "Farei isso. Obrigado, Capitão.", "Sim, boa sorte com isso. Se encontrar algo real, me avise - eu odiaria pensar que há perigo real em minhas águas.");
        cvQuestAccept.addOptionText(SPANISH, "Lo haré. Gracias, Capitán.", "Sí, buena suerte con eso. Si encuentras algo real, avísame - odiaría pensar que hay peligro real en mis aguas.");
        cvQuestAccept.listeners = (ctx, currentFragment) -> LibQuest.includeQuestToQuestbook(THE_TALE_OF_A_GHOST_SHIP, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvQuestAccept);

        // ===== GHOST SHIP QUEST: Night sailing (triggers event) =====
        ConversationOption cvQuestNightSail = new ConversationOption(0, 10);
        cvQuestNightSail.addOptionText(ENGLISH, "I need to sail at night to find the ghost ship.", "*Nods grimly*\nSo Teradoch told you, eh? Aye, the phantom only appears in the dead of night. The darkness hides many things on these waters...\n\n*Looks at the sky*\nIt's night now. If you want to chase ghosts, I'll take you out. But don't say I didn't warn you - strange things happen on the sea when the moon is hidden. Are you sure about this?");
        cvQuestNightSail.addOptionText(PORTUGUESE, "Preciso navegar à noite para encontrar o navio fantasma.", "*Acena gravemente*\nEntão Teradoch te contou, eh? Sim, o fantasma só aparece no silêncio da noite. A escuridão esconde muitas coisas nestas águas...\n\n*Olha para o céu*\nÉ noite agora. Se quer perseguir fantasmas, vou levá-lo. Mas não diga que não avisei - coisas estranhas acontecem no mar quando a lua está escondida. Tem certeza disso?");
        cvQuestNightSail.addOptionText(SPANISH, "Necesito navegar de noche para encontrar el barco fantasma.", "*Asiente gravemente*\nAsí que Teradoch te lo dijo, ¿eh? Sí, el fantasma solo aparece en la oscuridad de la noche. La oscuridad esconde muchas cosas en estas aguas...\n\n*Mira al cielo*\nEs de noche ahora. Si quieres perseguir fantasmas, te llevaré. Pero no digas que no te avisé - cosas extrañas suceden en el mar cuando la luna está oculta. ¿Estás seguro de esto?");
        cvQuestNightSail.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, THE_TALE_OF_A_GHOST_SHIP, 2) &&
                    Utils.isInsideAvailableHours(1, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestNightSail);

        ConversationOption cvQuestNightConfirm = new ConversationOption(10, 999);
        cvQuestNightConfirm.addOptionText(ENGLISH, "Yes, let's sail now.", "Hold tight!\n\n*The ship sets sail*");
        cvQuestNightConfirm.addOptionText(PORTUGUESE, "Sim, vamos navegar agora.", "Segure firme!\n\n*O navio zarpa*");
        cvQuestNightConfirm.addOptionText(SPANISH, "Sí, naveguemos ahora.", "¡Agárrate fuerte!\n\n*El barco zarpa*");
        cvQuestNightConfirm.listeners = (ctx, currentFragment) -> {
            Character chara = App.getPlayerChar();
            App.Shell.flowManager.currentLocation.checkedEventsAndBattles = false;
            if (chara != null) {
                new Handler().postDelayed(() -> {
                            App.Shell.flowManager.addEventToQueue(App.DataManager.getEvent(GHOST_SHIP_ENCOUNTER));
                        },
                        1);
            }
        };
        npc.conversationOptions.add(cvQuestNightConfirm);

        ConversationOption cvQuestNightCancel = new ConversationOption(10, 0);
        cvQuestNightCancel.addOptionText(ENGLISH, "On second thought, maybe later.", "Smart. The sea at night isn't for everyone. Come back when you're ready.");
        cvQuestNightCancel.addOptionText(PORTUGUESE, "Pensando bem, talvez mais tarde.", "Inteligente. O mar à noite não é para todos. Volte quando estiver pronto.");
        cvQuestNightCancel.addOptionText(SPANISH, "Pensándolo mejor, quizás más tarde.", "Inteligente. El mar de noche no es para todos. Vuelve cuando estés listo.");
        npc.conversationOptions.add(cvQuestNightCancel);

        // ===== GHOST SHIP QUEST: Good Ending =====
        ConversationOption cvQuestGoodEnd = new ConversationOption(0, 11);
        cvQuestGoodEnd.addOptionText(ENGLISH, "I destroyed the cursed amulet. The ghost ship is gone.", "*Eyes widen in genuine amazement*\nYou... you actually did it? By all the gods!\n\n*Slaps you on the back*\nI've sailed these waters for twenty years, always wondering if that phantom was real. And you not only found it - you freed those poor souls! That takes real courage and compassion.\n\n*Grins widely*\nFrom this day forward, you sail with me for free. Helera, Esperand, anywhere I go - no charge. It's the least I can do for someone who made these waters safe again. The sailors will sing songs about you, friend!");
        cvQuestGoodEnd.addOptionText(PORTUGUESE, "Destruí o amuleto amaldiçoado. O navio fantasma se foi.", "*Olhos se arregalam em genuína admiração*\nVocê... você realmente fez isso? Por todos os deuses!\n\n*Bate em suas costas*\nNaveguei estas águas por vinte anos, sempre me perguntando se aquele fantasma era real. E você não apenas o encontrou - libertou aquelas pobres almas! Isso exige verdadeira coragem e compaixão.\n\n*Sorri amplamente*\nDeste dia em diante, você navega comigo de graça. Helera, Esperand, onde quer que eu vá - sem custo. É o mínimo que posso fazer por alguém que tornou estas águas seguras novamente. Os marinheiros cantarão canções sobre você, amigo!");
        cvQuestGoodEnd.addOptionText(SPANISH, "Destruí el amuleto maldito. El barco fantasma se ha ido.", "*Los ojos se agrandan en genuina admiración*\n¿Tú... realmente lo hiciste? ¡Por todos los dioses!\n\n*Te da una palmada en la espalda*\nHe navegado estas aguas durante veinte años, siempre preguntándome si ese fantasma era real. Y no solo lo encontraste - ¡liberaste esas pobres almas! Eso requiere verdadero coraje y compasión.\n\n*Sonríe ampliamente*\nDesde este día, navegas conmigo gratis. Helera, Esperand, donde sea que vaya - sin cargo. Es lo mínimo que puedo hacer por alguien que hizo estas aguas seguras nuevamente. ¡Los marineros cantarán canciones sobre ti, amigo!");
        cvQuestGoodEnd.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, THE_TALE_OF_A_GHOST_SHIP, 6) && !LibQuest.isQuestComplete(chara, THE_TALE_OF_A_GHOST_SHIP)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestGoodEnd);

        ConversationOption cvQuestGoodFinish = new ConversationOption(11, 0);
        cvQuestGoodFinish.addOptionText(ENGLISH, "Thank you, Captain. The seas are safer now.", "They are indeed. You're a hero, plain and simple.");
        cvQuestGoodFinish.addOptionText(PORTUGUESE, "Obrigado, Capitão. Os mares estão mais seguros agora.", "De fato estão. Você é um herói, puro e simples.");
        cvQuestGoodFinish.addOptionText(SPANISH, "Gracias, Capitán. Los mares son más seguros ahora.", "De hecho lo son. Eres un héroe, puro y simple.");
        cvQuestGoodFinish.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(THE_TALE_OF_A_GHOST_SHIP, App.getPlayerChar(), 66, ctx);
            if (App.getPlayerChar() != null) {
                App.getPlayerChar().attributesManager.increase(Enums.AttributeName.ALIGNMENT, 15);
            }
        };
        npc.conversationOptions.add(cvQuestGoodFinish);

        // ===== GHOST SHIP QUEST: Evil Ending =====
        ConversationOption cvQuestEvilEnd = new ConversationOption(0, 12);
        cvQuestEvilEnd.addOptionText(ENGLISH, "I found the cursed treasure and kept it for myself.", "*Face darkens with disgust*\nYou what?!\n\n*Steps back, voice filled with contempt*\nYou found the source of the curse and chose GOLD over freeing those damned souls?! You left them to suffer eternally just for some cursed trinket?!\n\n*Spits on the deck*\nYou disgust me. Those sailors will haunt these waters forever because of your greed. Get off my ship. And if you want to sail with me again, it'll cost you extra - 3 gold more per trip. Greed like yours doesn't sail for free.");
        cvQuestEvilEnd.addOptionText(PORTUGUESE, "Encontrei o tesouro amaldiçoado e fiquei com ele.", "*Rosto escurece com nojo*\nVocê o quê?!\n\n*Recua, voz cheia de desprezo*\nVocê encontrou a fonte da maldição e escolheu OURO em vez de libertar aquelas almas condenadas?! Você as deixou sofrer eternamente apenas por alguma bugiganga amaldiçoada?!\n\n*Cospe no convés*\nVocê me dá nojo. Aqueles marinheiros assombrarão estas águas para sempre por causa de sua ganância. Saia do meu navio. E se quiser navegar comigo novamente, custará 3 ouros a mais por viagem. Ganância como a sua não navega de graça.");
        cvQuestEvilEnd.addOptionText(SPANISH, "Encontré el tesoro maldito y me lo quedé.", "*El rostro se oscurece con disgusto*\n¡¿Qué hiciste?!\n\n*Retrocede, voz llena de desprecio*\n¡¿Encontraste la fuente de la maldición y elegiste ORO en lugar de liberar esas almas condenadas?! ¡Las dejaste sufrir eternamente solo por alguna baratija maldita!\n\n*Escupe en la cubierta*\nMe das asco. Esos marineros acecharán estas aguas para siempre por tu codicia. Bájate de mi barco. Y si quieres navegar conmigo otra vez, te costará 3 monedas de oro extra por viaje. La codicia como la tuya no navega gratis.");
        cvQuestEvilEnd.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, THE_TALE_OF_A_GHOST_SHIP, 7) && !LibQuest.isQuestComplete(chara, THE_TALE_OF_A_GHOST_SHIP)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestEvilEnd);

        ConversationOption cvQuestEvilFinish = new ConversationOption(12, 0);
        cvQuestEvilFinish.addOptionText(ENGLISH, "I did what I had to do.", "*Turns away in disgust*\nNo. You did what your greed told you. Now leave.");
        cvQuestEvilFinish.addOptionText(PORTUGUESE, "Fiz o que tinha que fazer.", "*Vira-se com nojo*\nNão. Você fez o que sua ganância mandou. Agora vá embora.");
        cvQuestEvilFinish.addOptionText(SPANISH, "Hice lo que tenía que hacer.", "*Se da la vuelta con disgusto*\nNo. Hiciste lo que tu codicia te dijo. Ahora vete.");
        cvQuestEvilFinish.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(THE_TALE_OF_A_GHOST_SHIP, App.getPlayerChar(), 77, ctx);
            if (App.getPlayerChar() != null) {
                App.getPlayerChar().attributesManager.decrease(Enums.AttributeName.ALIGNMENT, 15);
            }
        };
        npc.conversationOptions.add(cvQuestEvilFinish);

        ///TRAVEL OPTIONS
        ConversationOption cvTravel = new ConversationOption(0, 100);
        cvTravel.addOptionText(ENGLISH, "I need to sail.", "That's what I'm here for. We can go to Helera and Esperand");
        cvTravel.addOptionText(PORTUGUESE, "Preciso velejar.", "É para isso que estou aqui. Podemos ir para Helera e Esperand.");
        cvTravel.addOptionText(SPANISH, "Necesito navegar.", "Para eso estoy aquí. Podemos ir a Helera e Esperand.");
        npc.conversationOptions.add(cvTravel);

        // ===== TRAVEL OPTIONS: FREE (after good ending) =====
        ConversationOption cvTravelFree1 = new ConversationOption(100, 999);
        cvTravelFree1.addOptionText(ENGLISH, "Travel to Helera [FREE]", "For the hero who saved these waters? Always free! Let's go!");
        cvTravelFree1.addOptionText(PORTUGUESE, "Viagem para Helera [GRÁTIS]", "Para o herói que salvou estas águas? Sempre grátis! Vamos lá!");
        cvTravelFree1.addOptionText(SPANISH, "Viaje a Helera [GRATIS]", "¿Para el héroe que salvó estas aguas? ¡Siempre gratis! ¡Vamos!");
        cvTravelFree1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, THE_TALE_OF_A_GHOST_SHIP) &&
                    LibQuest.isCharacterAtQuestPart(chara, THE_TALE_OF_A_GHOST_SHIP, 66)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvTravelFree1.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.HELERA_HARBOR, 0, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvTravelFree1);

        ConversationOption cvTravelFree2 = new ConversationOption(100, 999);
        cvTravelFree2.addOptionText(ENGLISH, "Travel to Esperand [FREE]", "For the hero who saved these waters? Always free! Let's go!");
        cvTravelFree2.addOptionText(PORTUGUESE, "Viagem para Esperand [GRÁTIS]", "Para o herói que salvou estas águas? Sempre grátis! Vamos lá!");
        cvTravelFree2.addOptionText(SPANISH, "Viaje a Esperand [GRATIS]", "¿Para el héroe que salvó estas aguas? ¡Siempre gratis! ¡Vamos!");
        cvTravelFree2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, THE_TALE_OF_A_GHOST_SHIP) &&
                    LibQuest.isCharacterAtQuestPart(chara, THE_TALE_OF_A_GHOST_SHIP, 66)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvTravelFree2.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.ESPERAND_HARBOR, 0, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvTravelFree2);

        // ===== TRAVEL OPTIONS: EXPENSIVE (after evil ending) =====
        ConversationOption cvTravelExpensive1 = new ConversationOption(100, 999);
        cvTravelExpensive1.addOptionText(ENGLISH, "Travel to Helera [11 gold]", "*Grunts* Fine. Pay up.");
        cvTravelExpensive1.addOptionText(PORTUGUESE, "Viagem para Helera [11 ouro]", "*Resmunga* Tudo bem. Pague.");
        cvTravelExpensive1.addOptionText(SPANISH, "Viaje a Helera [11 de oro]", "*Gruñe* Bien. Paga.");
        cvTravelExpensive1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, THE_TALE_OF_A_GHOST_SHIP) &&
                    LibQuest.isCharacterAtQuestPart(chara, THE_TALE_OF_A_GHOST_SHIP, 77)) {
                if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(11)) {
                    return Enums.RequirementVerification.OK;
                }
                return Enums.RequirementVerification.NEED_GOLD;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvTravelExpensive1.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.HELERA_HARBOR, 11, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvTravelExpensive1);

        ConversationOption cvTravelExpensive2 = new ConversationOption(100, 999);
        cvTravelExpensive2.addOptionText(ENGLISH, "Travel to Esperand [16 gold]", "*Grunts* Fine. Pay up.");
        cvTravelExpensive2.addOptionText(PORTUGUESE, "Viagem para Esperand [16 ouro]", "*Resmunga* Tudo bem. Pague.");
        cvTravelExpensive2.addOptionText(SPANISH, "Viaje a Esperand [16 de oro]", "*Gruñe* Bien. Paga.");
        cvTravelExpensive2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, THE_TALE_OF_A_GHOST_SHIP) &&
                    LibQuest.isCharacterAtQuestPart(chara, THE_TALE_OF_A_GHOST_SHIP, 77)) {
                if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(16)) {
                    return Enums.RequirementVerification.OK;
                }
                return Enums.RequirementVerification.NEED_GOLD;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvTravelExpensive2.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.ESPERAND_HARBOR, 16, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvTravelExpensive2);

        // ===== TRAVEL OPTIONS: NORMAL (default, hidden after quest completion) =====
        ConversationOption cvTravel1 = new ConversationOption(100, 999);
        cvTravel1.addOptionText(ENGLISH, "Travel to Helera [8 gold]", "Ya! Let the winds of the sea take us!");
        cvTravel1.addOptionText(PORTUGUESE, "Viagem para Helera [8 ouro]", "Ya! Deixe que os ventos do mar nos leve!");
        cvTravel1.addOptionText(SPANISH, "Viaje a Helera [8 de oro]", "¡Ya! ¡Que los vientos del mar nos lleven!");
        cvTravel1.requirementValidations = (chara, ctx) -> {
            // Hidden after quest is completed
            if (LibQuest.isQuestComplete(chara, THE_TALE_OF_A_GHOST_SHIP)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(8)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cvTravel1.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.HELERA_HARBOR, 8, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvTravel1);

        ConversationOption cvTravel2 = new ConversationOption(100, 999);
        cvTravel2.addOptionText(ENGLISH, "Travel to Esperand [13 gold]", "Ya! Let the winds of the sea take us!");
        cvTravel2.addOptionText(PORTUGUESE, "Viagem para Esperand [13 ouro]", "Ya! Deixe que os ventos do mar nos leve!");
        cvTravel2.addOptionText(SPANISH, "Viaje a Esperand [13 de oro]", "¡Ya! ¡Que los vientos del mar nos lleven!");
        cvTravel2.requirementValidations = (chara, ctx) -> {
            // Hidden after quest is completed
            if (LibQuest.isQuestComplete(chara, THE_TALE_OF_A_GHOST_SHIP)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(13)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cvTravel2.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.ESPERAND_HARBOR, 13, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvTravel2);

        ConversationOption cvTravelNo = new ConversationOption(100, 0);
        cvTravelNo.addOptionText(ENGLISH, "Changed my mind...", "Ok...");
        cvTravelNo.addOptionText(PORTUGUESE, "Mudei de ideia...", "Ok...");
        cvTravelNo.addOptionText(SPANISH, "Cambié de opinión...", "Ok...");
        npc.conversationOptions.add(cvTravelNo);

        return npc;
    }
}

