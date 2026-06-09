package com.cnx.endlesstalestwo.data.npcs.havarusSouth.griwalshFarmhouse;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.DESTROY_THE_LAIR;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.INVESTIGATE_THE_BEAST;

import android.os.Looper;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.GameEngine;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.knowledges.KnowledgesIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.shops.ShopsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Griwalsh extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Griwalsh");
        npc.age = 66;
        npc.job = Enums.NPCJobs.ALCHEMIST;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.generateRandomByes();

        // Conversation options
        // /ABOUT QUEST: INVESTIGATE THE BEAST
        ConversationOption cv5 = new ConversationOption(0, 2);
        cv5.addOptionText(ENGLISH, "I need your help, Verona sent me here.", "Verona?\nAh, yes, Helera's advisor. She studied a few things with me a few years ago. What do you need?");
        cv5.addOptionText(PORTUGUESE, "Preciso de sua ajuda, Verona me mandou aqui.", "Verona?\nAh, sim, a conselheira de Helera. Ela estudou algumas coisas comigo há poucos anos atrás. O que precisas?");
        cv5.addOptionText(SPANISH, "Necesito tu ayuda, Verona me envió aquí.", "¿Verona?\nAh, sí, la consejera de Helera. Estudió algunas cosas conmigo hace unos años. ¿Qué necesitas?");
        cv5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, INVESTIGATE_THE_BEAST, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv5);

        ConversationOption cv6 = new ConversationOption(2, 0);
        cv6.addOptionText(ENGLISH, "Do you know any magic for underwater submersion?", "So you want to breathe underwater like a fish? Right, I think I have a potion for you, but I don't have it ready. You'll need to bring me things. I don't mind helping, it's fun for a lonely old man.\nLet's see...\nWe'll need three algae, one red herb, and one antidote. I have the rest here.");
        cv6.addOptionText(PORTUGUESE, "Sabe alguma magia para submersão em água?", "Então queres respirar na água como um peixe? Certo, acho que tenho uma poção para si, mas não tenho pronta. Vais precisar trazer coisas para mim. Não me importo em ajudar, é uma diversão para um velho solitário.\nVamos ver...\nPrecisaremos de três algas, uma erva vermelha e um antídoto. O restante tenho aqui.");
        cv6.addOptionText(SPANISH, "¿Conoces alguna magia para la inmersión bajo el agua?", "¿Así que quieres respirar bajo el agua como un pez? Bien, creo que tengo una poción para ti, pero no la tengo lista. Tendrás que traerme cosas. No me importa ayudar, es divertido para un viejo solitario.\nVeamos...\nNecesitaremos tres algas, una hierba roja y un antídoto. El resto lo tengo aquí.");
        cv6.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(INVESTIGATE_THE_BEAST, 5, App.getPlayerChar(), ctx);

        };
        npc.conversationOptions.add(cv6);

        ConversationOption cv7 = new ConversationOption(0, 0);
        cv7.addOptionText(ENGLISH, "Here are the ingredients.", "Very well, [GENDER_FORMAL_CALL]. Let's go to the cauldron.\n<Mixes the ingredients>\nGood! Here is the potion, use it with caution, just in case, use it seconds before diving, the effect is not endless");
        cv7.addOptionText(PORTUGUESE, "Aqui estão os ingredientes.", "Muito bem, [GENDER_FORMAL_CALL]. Vamos ao caldeirão.\n<Mistura os ingredientes>\nBom! Aqui está a poção, use com cautela, por garantia, use segundos antes de mergulhar, o efeito não é eterno.");
        cv7.addOptionText(SPANISH, "Aquí están los ingredientes.", "Muy bien, [GENDER_FORMAL_CALL]. Vamos al caldero.\n<Mezcla los ingredientes>\n¡Bien! Aquí está la poción, úsala com precaución, por si acaso, úsala segundos antes de sumergirte, el efecto no es eterno.");
        cv7.requirementValidations = (chara, ctx) -> {
            ItemReference[] neededItems = new ItemReference[]{
                    new ItemReference(ItemsIds.ALGAE, 3),
                    new ItemReference(ItemsIds.RED_HERB, 1),
                    new ItemReference(ItemsIds.ANTIDOTE, 1)
            };
            if (chara != null && LibInventory.checkHasItems(neededItems, chara) && LibQuest.isCharacterAtQuestPart(chara, INVESTIGATE_THE_BEAST, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv7.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.ALGAE, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.RED_HERB, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.ANTIDOTE, 1, App.getPlayerChar());
            LibInventory.addToInventory(ItemsIds.POTION_OF_WATER_BREATHING, 1, App.getPlayerChar());
            LibQuest.updateQuest(INVESTIGATE_THE_BEAST, 6, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv7);

        ///ABOUT QUEST: DESTROY THE LAIR
        ConversationOption cv8 = new ConversationOption(0, 3);
        cv8.addOptionText(ENGLISH, "I'm going to need more of that submersion potion.", "Look, I like to help, but sometimes I might want some kind of reward too...");
        cv8.addOptionText(PORTUGUESE, "Vou precisar mais daquela poção de submersão.", "Veja bem, tenho gosto em ajudar, mas as vezes pode ser que eu também queira algum tipo de recompensa...");
        cv8.addOptionText(SPANISH, "Voy a necesitar más de esa poción de inmersión.", "Mira, me gusta ayudar, pero a veces también puedo querer algún tipo de recompensa...");
        cv8.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, DESTROY_THE_LAIR, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv8);

        ConversationOption cv9 = new ConversationOption(3, 0);
        cv9.addOptionText(ENGLISH, "What would you like, Griwalsh?", "Ah, he he, so you're going to give me a little help. Of course, I'll get the potion for you again.\nAll I need are some herbs from the swamp. I sometimes go get them myself, but I'm getting a bit old. Go to the swamp to the north and talk to Galdor, he knows about my herbs.");
        cv9.addOptionText(PORTUGUESE, "O que gostaria, Griwalsh?", "Ah, he he, vai então me dar uma ajudinha. Claro, vou conseguir a poção para você novamente.\nTudo que preciso são algumas ervas do pântano. Eu mesmo as vezes vou buscar, mas ando meio velho. Vá até o pântano ao norte e fale com Galdor, ele sabe das minhas ervas.");
        cv9.addOptionText(SPANISH, "¿Qué te gustaría, Griwalsh?", "Ah, je je, así que me vas a echar una manita. Por supuesto, te conseguiré la poción de nuevo.\nTodo lo que necesito son algunas hierbas del pantano. A veces voy a buscarlas yo mismo, pero me estoy haciendo un poco viejo. Ve al pantano del norte y habla con Galdor, él sabe de mis hierbas.");
        cv9.requirementValidations = (chara, ctx) -> {
            if (chara.attributesManager.checkAttribute(Enums.AttributeName.ALIGNMENT, 50)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv9.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(DESTROY_THE_LAIR, 2, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cv9);

        ConversationOption cv10 = new ConversationOption(3, 0);
        cv10.addOptionText(ENGLISH, "You old manipulator! What do you want?", "Relax, everyone needs something. I'll get the potion for you again.\nI'm getting a bit old to walk much, but I need a bag of swamp herbs. Go to the swamp to the north and talk to Galdor, he knows about my herbs.\n...If that's not too much for a rude person like you...");
        cv10.addOptionText(PORTUGUESE, "Seu velho manipulador! O que você quer?", "Relaxe, todos precisam de alguma coisa. Eu vou conseguir a poção para você novamente.\nAndo meio velho para caminhar muito, mas preciso de uma bolsa de ervas do pântano. Vá até o pântano ao norte e fale com Galdor, ele sabe das minhas ervas.\n...Se isso não for demais para um grosseiro como você...");
        cv10.addOptionText(SPANISH, "¡Viejo manipulador! ¿Qué quieres?", "Tranquilo, todo el mundo necesita algo. Te conseguiré la poción de nuevo.\nMe estoy haciendo un poco viejo para caminar mucho, pero necesito una bolsa de hierbas del pantano. Ve al pantano del norte y habla con Galdor, él sabe de mis hierbas.\n...Si no es mucho pedir para un maleducado como tú...");
        cv10.requirementValidations = (chara, ctx) -> {
            if (!chara.attributesManager.checkAttribute(Enums.AttributeName.ALIGNMENT, 50)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv10.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(DESTROY_THE_LAIR, 2, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cv10);

        ConversationOption cv11 = new ConversationOption(0, 0);
        cv11.addOptionText(ENGLISH, "Here are your herbs.", "I thank you very much. While you were away, I was already making the potion for you, here it is.");
        cv11.addOptionText(PORTUGUESE, "Aqui estão suas ervas.", "Lhe agradeço muito. Enquanto estava fora, já estive a fazer a poção para você, aqui está.");
        cv11.addOptionText(SPANISH, "Aquí están tus hierbas.", "Te lo agradezco mucho. Mientras estabas fuera, ya estaba haciendo la poción para ti, aquí la tienes.");
        cv11.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, DESTROY_THE_LAIR, 3) && LibInventory.checkHasItem(ItemsIds.BAG_OF_SWAMP_HERBS, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv11.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.BAG_OF_SWAMP_HERBS, 1, App.getPlayerChar());
            LibInventory.addToInventory(ItemsIds.POTION_OF_WATER_BREATHING, 1, App.getPlayerChar());
            LibQuest.updateQuest(DESTROY_THE_LAIR, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv11);

        // ===== ELF KNOWLEDGE QUEST: Part 4 - Get black oak seeds =====
        ConversationOption cvElfKnowledge1 = new ConversationOption(0, 10);
        cvElfKnowledge1.addOptionText(ENGLISH, "Griwalsh, I need black oak seeds. The elves requested them.", "*Eyes light up*\nBlack oak seeds? For the elves of Ayalon? My word, I never thought I'd see the day when humans and elves would trade again! This is... this is wonderful news!");
        cvElfKnowledge1.addOptionText(PORTUGUESE, "Griwalsh, preciso de sementes de carvalho negro. Os elfos as solicitaram.", "*Olhos se iluminam*\nSementes de carvalho negro? Para os elfos de Ayalon? Minha nossa, nunca pensei que veria o dia em que humanos e elfos comercializariam novamente! Isso é... são notícias maravilhosas!");
        cvElfKnowledge1.addOptionText(SPANISH, "Griwalsh, necesito semillas de roble negro. Los elfos las solicitaron.", "*Los ojos se iluminan*\n¿Semillas de roble negro? ¿Para los elfos de Ayalon? ¡Dios mío, nunca pensé que vería el día en que humanos y elfos comerciarían nuevamente! ¡Esto es... son noticias maravillosas!");
        cvElfKnowledge1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, com.cnx.endlesstalestwo.data.quests.QuestsIds.ELF_KNOWLEDGE, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfKnowledge1);

        ConversationOption cvElfKnowledge2 = new ConversationOption(10, 0);
        cvElfKnowledge2.addOptionText(ENGLISH, "Can you help me?", "Of course! I have a small grove of black oaks here on my land. Beautiful trees - strong, resilient, and their wood is prized for many purposes. The elves value them for their longevity and connection to ancient magic. \n*Goes to a storage room and returns with a bag*\nHere, take these seeds. They're freshly harvested and should germinate well in elven soil. Tell the elves that Griwalsh sends his regards and hopes this marks the beginning of renewed friendship between our peoples.");
        cvElfKnowledge2.addOptionText(PORTUGUESE, "Você pode me ajudar?", "Claro! Tenho um pequeno bosque de carvalhos negros aqui em minhas terras. Árvores lindas - fortes, resistentes, e sua madeira é valorizada para muitos propósitos. Os elfos as valorizam por sua longevidade e conexão com a magia antiga. \n*Vai a um depósito e retorna com um saco*\nAqui, pegue estas sementes. São recém-colhidas e devem germinar bem no solo élfico. Diga aos elfos que Griwalsh envia seus cumprimentos e espera que isso marque o início de uma amizade renovada entre nossos povos.");
        cvElfKnowledge2.addOptionText(SPANISH, "¿Puedes ayudarme?", "¡Por supuesto! Tengo un pequeño bosque de robles negros aquí en mis tierras. Árboles hermosos - fuertes, resistentes, y su madera es valorada para muchos propósitos. Los elfos los valoran por su longevidad y conexión con la magia antigua. \n*Va a un almacén y regresa con una bolsa*\nAquí, toma estas semillas. Son recién cosechadas y deberían germinar bien en suelo élfico. Dile a los elfos que Griwalsh envía sus saludos y espera que esto marque el comienzo de una amistad renovada entre nuestros pueblos.");
        cvElfKnowledge2.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.BLACK_OAK_SEEDS, 1, App.getPlayerChar());
            LibQuest.updateQuest(com.cnx.endlesstalestwo.data.quests.QuestsIds.ELF_KNOWLEDGE, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvElfKnowledge2);

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "As an alchemist, what secrets do the plains whisper to you?", "The earth here is rich, not just in soil, but in potent ingredients. Many a remedy and concoction can be found if one knows where to look... and how to listen.");
        cv1.addOptionText(PORTUGUESE, "Como alquimista, que segredos te sussurram as planícies?", "A terra aqui é rica, não só em solo, mas em ingredientes potentes. Muitos remédios e misturas podem ser encontrados se soubermos onde procurar... e como ouvir.");
        cv1.addOptionText(SPANISH, "Como alquimista, ¿qué secretos te susurran las llanuras?", "La tierra aquí es rica, no solo en suelo, sino en ingredientes potentes. Se pueden encontrar muchos remedios y brebajes si uno sabe dónde buscar... y cómo escuchar.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 1);
        cv2.addOptionText(ENGLISH, "What strange brews are you concocting today?", "Ah, just a little something to keep the chill out of these old bones. And perhaps a potion to ward off troublesome goblins, one never knows in these plains.");
        cv2.addOptionText(PORTUGUESE, "Que misturas estranhas estás a preparar hoje?", "Ah, apenas algo para espantar o frio destes ossos velhos. E talvez uma poção para afastar goblins problemáticos, nunca se sabe nestas planícies.");
        cv2.addOptionText(SPANISH, "¿Qué extraños brebajes estás preparando hoy?", "Ah, solo algo para quitar el frío de estos viejos huesos. Y quizás una poción para ahuyentar a los duendes problemáticos, nunca se sabe en estas llanuras.");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(1, 0);
        cv3.addOptionText(ENGLISH, "I've noticed you cultivate some red herbs. Are they difficult to grow?", "Ah, yes, I call the red herbs as crimsonleaf. They require a specific balance of sun and shade, and the soil must be just so. Not for the impatient gardener, but their restorative properties are well worth the effort.");
        cv3.addOptionText(PORTUGUESE, "Notei que cultivas umas ervas vermelhas. São difíceis de cultivar?", "Ah, eu chamo as ervas vermelhas de folha-carmesim. Requerem um equilíbrio específico de sol e sombra, e o solo tem de estar no ponto certo. Não é para o jardineiro impaciente, mas as suas propriedades restauradoras valem bem o esforço.");
        cv3.addOptionText(SPANISH, "He notado que cultivas unas hierbas rojas. ¿Son difíciles de cultivar?", "Ah, sí, a las hierbas rojas las llamo hoja carmesí. Requieren un equilibrio específico de sol y sombra, y el suelo debe estar perfecto. No es para el jardinero impaciente, pero sus propiedades restauradoras bien valen el esfuerzo.");
        npc.conversationOptions.add(cv3);

        ConversationOption cvUseAlchemy = new ConversationOption(1, 999);
        cvUseAlchemy.addOptionText(ENGLISH, "Can I use your alchemy table?", "Ah, so rare for someone to take an interest in that. Feel free.");
        cvUseAlchemy.addOptionText(PORTUGUESE, "Posso usar sua mesa de alquimia?", "Ah, tão raro alguém se interessar por isso. Fique a vontade.");
        cvUseAlchemy.addOptionText(SPANISH, "¿Puedo usar tu mesa de alquimia?", "Ah, tan raro que alguien se interese en eso. Siéntete libre.");
        cvUseAlchemy.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(INVESTIGATE_THE_BEAST, chara) && chara.hasKnowledge(KnowledgesIds.ALCHEMY)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvUseAlchemy.listeners = (ctx, currentFragment) -> {
            if (App.getPlayerChar() != null) {
                App.getPlayerChar().removeGold(1);
                if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                    gPlayActivity.lockScreenTouches(true);
                    new android.os.Handler(Looper.getMainLooper()).postDelayed(() -> {
                        GameEngine.saveGame(ctx);
                        gPlayActivity.goToCraft(Enums.CraftTypes.ALCHEMY);
                    }, 2200);
                }
            }
        };
        npc.conversationOptions.add(cvUseAlchemy);

        ConversationOption cvShop = new ConversationOption(0, 0);
        cvShop.addOptionText(ENGLISH, "And you sell your productions?", "Ah, yes! Take a look...");
        cvShop.addOptionText(PORTUGUESE, "E você vende suas produções?", "Ah, sim, veja o que tenho...");
        cvShop.addOptionText(SPANISH, "¿Y vendes su productos?", "Ah, sí, mira lo que tengo...");
        cvShop.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, INVESTIGATE_THE_BEAST, 5)
                    || LibQuest.isCharacterAtQuestPart(chara, INVESTIGATE_THE_BEAST, 6)
                    || LibQuest.isCharacterAtQuestPart(chara, INVESTIGATE_THE_BEAST, 7)
                    || LibQuest.isQuestComplete(chara, INVESTIGATE_THE_BEAST)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvShop.listeners = (ctx, fragment) -> {
            fragment.setScreenTouchable(false);
            new android.os.Handler(Looper.getMainLooper()).postDelayed(() -> {
                        if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                            gPlayActivity.lockScreenTouches(true);
                            gPlayActivity.goToViewShop(ShopsIds.GRIWALSH_PRODUCTS);
                        }
                    }
                    , 1600);
        };
        npc.conversationOptions.add(cvShop);

        ConversationOption cv4 = new ConversationOption(0, 0);
        cv4.addOptionText(ENGLISH, "Why live so far away?", "Peace and quiet, my friend. And the soil here... it's just right for my herbs. The city's hustle is no good for growing delicate things, or for an old man's peace of mind.");
        cv4.addOptionText(PORTUGUESE, "Porque viver tão longe?", "Paz e sossego, meu amigo. E o solo aqui... é perfeito para as minhas ervas. A agitação da cidade não é boa para cultivar coisas delicadas, nem para a paz de espírito de um velho.");
        cv4.addOptionText(SPANISH, "¿Por qué vivir tan lejos?", "Paz y tranquilidad, amigo mío. Y la tierra aquí... es perfecta para mis hierbas. El ajetreo de la ciudad no es bueno para cultivar cosas delicadas, ni para la paz mental de un anciano.");
        npc.conversationOptions.add(cv4);

        // ========================================
        // QUEST: POTIONS FROM EXTERIOR — PART 1
        // ========================================

        ConversationOption cvPFE1 = new ConversationOption(0, 0);
        cvPFE1.addOptionText(ENGLISH, "I'm looking for unusual potions — anything you might have found or that doesn't seem local.",
                "*He scratches his head*\nUnusual potions, eh? As a matter of fact... I found something washed up near the road a while back. Doesn't smell like anything I make around here — strange color, different kind of stopper.\n*rummages through a shelf*\nHere, take it. I have no use for it and would rather it go to someone who knows what to do with it.");
        cvPFE1.addOptionText(PORTUGUESE, "Estou procurando poções incomuns — algo que você possa ter encontrado ou que não pareça local.",
                "*Ele coça a cabeça*\nPoções incomuns, hein? Na verdade... encontrei algo perto da estrada há um tempo. Não cheira nada como o que faço por aqui — cor estranha, tipo de rolha diferente.\n*faz buscas em uma prateleira*\nAqui, pegue. Não tenho uso para isso e prefiro que vá para alguém que saiba o que fazer com ela.");
        cvPFE1.addOptionText(SPANISH, "Estoy buscando pociones inusuales — algo que hayas encontrado o que no parezca local.",
                "*Se rasca la cabeza*\n¿Pociones inusuales? De hecho... encontré algo arrastrado cerca del camino hace un tiempo. No huele como nada de lo que hago por aquí — color extraño, tipo de tapón diferente.\n*busca en un estante*\nToma, llévatela. No le veo utilidad y prefiero que vaya a alguien que sepa qué hacer con ella.");
        cvPFE1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.POTIONS_FROM_EXTERIOR, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPFE1.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.UNIDENTIFIED_POTION, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.POTIONS_FROM_EXTERIOR, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPFE1);

        return npc;
    }
}