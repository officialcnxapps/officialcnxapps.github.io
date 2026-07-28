package com.cnx.endlesstalestwo.data.npcs.wazel.kitchen;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.THE_TALE_OF_A_GHOST_SHIP;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.WAZEL_BATTLE;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Teradoch extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Teradoch");
        npc.age = 60;
        npc.job = Enums.NPCJobs.MALE_TAVERN_KEEPER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "He lives his life serving meals in the kitchen with agility.\nVery calm, he never loses his composure.\nWhalika's father.\n\nHis physical traits: Bloated appearance, large nose, and prominent eyes. Black skin and graying beard. He wears a kind of turban.");
        npc.addDescriptionTranslation(PORTUGUESE, "Vive sua vida servindo refeições na cozinha com agilidade.\nMuito calmo, não perde a compostura.\nPai de Whalika.\n\nSeus traços físicos: Aprência inchada, nariz grande e olhos proeminentes. Pele negra e barba grisalha. Utiliza uma espécie de turbante.");
        npc.addDescriptionTranslation(SPANISH, "Vive su vida sirviendo comidas en la cocina con agilidad.\nMuy tranquilo, nunca pierde la compostura.\nPadre de Whalika.\n\nSus rasgos físicos: Apariencia hinchada, nariz grande y ojos prominentes. Piel negra y barba entrecana. Utiliza una especie de turbante.");
        npc.canBePickpocketed = true;

        // ===== ROLEPLAY: About the tavern - BEFORE Wazel Battle =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "How's business at the tavern?", "Busy as always! Sailors and travelers pass through Wazel constantly. They bring stories from distant lands, rumors of treasures, and tales of the sea. I've heard enough stories to fill a hundred books!");
        cvRoleplay1.addOptionText(PORTUGUESE, "Como vão os negócios na taverna?", "Movimentados como sempre! Marinheiros e viajantes passam por Wazel constantemente. Eles trazem histórias de terras distantes, rumores de tesouros e contos do mar. Já ouvi histórias suficientes para encher cem livros!");
        cvRoleplay1.addOptionText(SPANISH, "¿Cómo van los negocios en la taberna?", "¡Ocupados como siempre! Marineros y viajeros pasan por Wazel constantemente. Traen historias de tierras lejanas, rumores de tesoros y cuentos del mar. ¡He escuchado suficientes historias para llenar cien libros!");
        cvRoleplay1.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.isQuestComplete(chara, WAZEL_BATTLE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY: About the tavern - AFTER Wazel Battle =====
        ConversationOption cvRoleplayAfterBattle = new ConversationOption(0, 0);
        cvRoleplayAfterBattle.addOptionText(ENGLISH, "How's business after the attack?", "*Sighs heavily*\nNot like it used to be... The attack destroyed so much of Wazel. Many people left, fearful of another assault. Business is slow now. But we're rebuilding, slowly. Those of us who stayed are determined to bring Wazel back to what it was. It'll take time, though.");
        cvRoleplayAfterBattle.addOptionText(PORTUGUESE, "Como estão os negócios após o ataque?", "*Suspira pesadamente*\nNão como costumava ser... O ataque destruiu tanto de Wazel. Muitas pessoas partiram, com medo de outro assalto. Os negócios estão lentos agora. Mas estamos reconstruindo, lentamente. Aqueles de nós que ficaram estão determinados a trazer Wazel de volta ao que era. Vai levar tempo, porém.");
        cvRoleplayAfterBattle.addOptionText(SPANISH, "¿Cómo van los negocios después del ataque?", "*Suspira pesadamente*\nNo como solía ser... El ataque destruyó tanto de Wazel. Muchas personas se fueron, temerosas de otro asalto. Los negocios están lentos ahora. Pero estamos reconstruyendo, lentamente. Aquellos de nosotros que nos quedamos estamos decididos a traer a Wazel de vuelta a lo que era. Tomará tiempo, sin embargo.");
        cvRoleplayAfterBattle.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, WAZEL_BATTLE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplayAfterBattle);

        // ===== ROLEPLAY: About desert cuisine =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "What kind of food do you serve here?", "Desert cuisine! Spiced meats, roasted vegetables, flatbread fresh from the oven. We get caravans bringing exotic spices from distant lands. I also serve the coldest drinks in all of Wazel, essential in this heat! Try our special desert stew, it's my grandmother's recipe.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Que tipo de comida você serve aqui?", "Culinária do deserto! Carnes temperadas, vegetais assados, pão achatado fresco do forno. Recebemos caravanas trazendo especiarias exóticas de terras distantes. Também sirvo as bebidas mais geladas de todo Waze, essencial neste calor! Experimente nosso ensopado especial do deserto, é a receita da minha avó.");
        cvRoleplay2.addOptionText(SPANISH, "¿Qué tipo de comida sirves aquí?", "¡Cocina del desierto! Carnes especiadas, verduras asadas, pan plano fresco del horno. Recibimos caravanas trayendo especias exóticas de tierras lejanas. ¡También sirvo las bebidas más frías de todo Wazel, esencial en este calor! Prueba nuestro estofado especial del desierto, es la receta de mi abuela.");
        npc.conversationOptions.add(cvRoleplay2);

        // ===== GHOST SHIP QUEST: Start =====
        ConversationOption cvQuestAsk = new ConversationOption(0, 1);
        cvQuestAsk.addOptionText(ENGLISH, "I heard Captain Bradoch mention a ghost ship. Do you know anything about it?", "*Eyes light up with interest*\nAh, the phantom vessel! Yes, I've heard that tale many times from sailors and pirates who drink here. It's one of the most persistent legends of these waters.\n\n*Leans in closer*\nThey say it's a pirate ship cursed by dark magic. The crew plundered sacred treasures and were damned for their greed. Now they're doomed to sail forever, neither alive nor dead, bound to their ship by an ancient curse.");
        cvQuestAsk.addOptionText(PORTUGUESE, "Ouvi o Capitão Bradoch mencionar um navio fantasma. Você sabe algo sobre isso?", "*Olhos brilham de interesse*\nAh, o navio fantasma! Sim, ouvi esse conto muitas vezes de marinheiros e piratas que bebem aqui. É uma das lendas mais persistentes destas águas.\n\n*Inclina-se mais perto*\nDizem que é um navio pirata amaldiçoado por magia negra. A tripulação saqueou tesouros sagrados e foi condenada por sua ganância. Agora estão condenados a navegar para sempre, nem vivos nem mortos, presos ao seu navio por uma maldição ancestral.");
        cvQuestAsk.addOptionText(SPANISH, "Escuché al Capitán Bradoch mencionar un barco fantasma. ¿Sabes algo sobre eso?", "*Los ojos brillan de interés*\n¡Ah, el barco fantasma! Sí, he escuchado ese cuento muchas veces de marineros y piratas que beben aquí. Es una de las leyendas más persistentes de estas aguas.\n\n*Se inclina más cerca*\nDicen que es un barco pirata maldito por magia oscura. La tripulación saqueó tesoros sagrados y fue condenada por su codicia. Ahora están condenados a navegar para siempre, ni vivos ni muertos, atados a su barco por una maldición ancestral.");
        cvQuestAsk.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, THE_TALE_OF_A_GHOST_SHIP, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestAsk);

        ConversationOption cvQuestHow = new ConversationOption(1, 0);
        cvQuestHow.addOptionText(ENGLISH, "How can I find this ghost ship?", "*Strokes his beard thoughtfully*\nThat's the tricky part. The phantom ship doesn't appear during the day - only on the darkest nights, when the moon is hidden. Sailors say it emerges from the mist between the hours of 1 a.m and 5 a.m.\n\n*His voice drops to a whisper*\nIf you want to find it, you'll need to sail with Captain Bradoch during those night hours. But be warned - those who've encountered the ghost ship speak of spectral pirates and cursed treasure. If you do find it, there might be a map showing where their cursed hoard is buried.");
        cvQuestHow.addOptionText(PORTUGUESE, "Como posso encontrar este navio fantasma?", "*Acaricia a barba pensativamente*\nEssa é a parte complicada. O navio fantasma não aparece durante o dia - apenas nas noites mais escuras, quando a lua está escondida. Marinheiros dizem que emerge da névoa entre 01:00 e 05:00.\n\n*Sua voz cai para um sussurro*\nSe quer encontrá-lo, precisará navegar com o Capitão Bradoch durante essas horas noturnas. Mas cuidado - aqueles que encontraram o navio fantasma falam de piratas espectrais e tesouro amaldiçoado. Se o encontrar, pode haver um mapa mostrando onde seu tesouro maldito está enterrado.");
        cvQuestHow.addOptionText(SPANISH, "¿Cómo puedo encontrar este barco fantasma?", "*Acaricia su barba pensativamente*\nEsa es la parte complicada. El barco fantasma no aparece durante el día - solo en las noches más oscuras, cuando la luna está escondida. Los marineros dicen que emerge de la niebla entre las 01:00 y las 05:00.\n\n*Su voz baja a un susurro*\nSi quieres encontrarlo, necesitarás navegar con el Capitán Bradoch durante esas horas nocturnas. Pero ten cuidado - aquellos que han encontrado el barco fantasma hablan de piratas espectrales y tesoro maldito. Si lo encuentras, puede haber un mapa mostrando dónde está enterrado su tesoro maldito.");
        cvQuestHow.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(THE_TALE_OF_A_GHOST_SHIP, 2, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvQuestHow);

        // ===== AFTER QUEST: Different responses based on ending =====
        ConversationOption cvAfterGood = new ConversationOption(0, 0);
        cvAfterGood.addOptionText(ENGLISH, "I found the ghost ship and broke the curse.", "*Eyes widen in amazement*\nYou actually did it? By the gods! Sailors will speak of your deed for generations. You've made these waters safer for everyone. The phantom ship was the source of many disappearances... Now those poor souls can finally rest.");
        cvAfterGood.addOptionText(PORTUGUESE, "Encontrei o navio fantasma e quebrei a maldição.", "*Olhos se arregalam admirados*\nVocê realmente fez isso? Pelos deuses! Marinheiros falarão do seu feito por gerações. Você tornou estas águas mais seguras para todos. O navio fantasma era a fonte de muitos desaparecimentos... Agora essas pobres almas finalmente podem descansar.");
        cvAfterGood.addOptionText(SPANISH, "Encontré el barco fantasma y rompí la maldición.", "*Los ojos se agrandan asombrados*\n¿Realmente lo hiciste? ¡Por los dioses! Los marineros hablarán de tu hazaña por generaciones. Has hecho estas aguas más seguras para todos. El barco fantasma era la fuente de muchas desapariciones... Ahora esas pobres almas finalmente pueden descansar.");
        cvAfterGood.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, THE_TALE_OF_A_GHOST_SHIP) &&
                    LibQuest.isCharacterAtQuestPart(chara, THE_TALE_OF_A_GHOST_SHIP, 66)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAfterGood);

        ConversationOption cvAfterEvil = new ConversationOption(0, 0);
        cvAfterEvil.addOptionText(ENGLISH, "I found the cursed treasure and kept it.", "*Steps back with a worried expression*\nYou... you kept it? That's a dangerous decision, friend. Cursed gold brings nothing but misfortune. I hope you know what you've done. Those pirate souls will haunt these waters forever now...");
        cvAfterEvil.addOptionText(PORTUGUESE, "Encontrei o tesouro amaldiçoado e fiquei com ele.", "*Recua com expressão preocupada*\nVocê... você ficou com ele? Essa é uma decisão perigosa, amigo. Ouro amaldiçoado não traz nada além de infortúnio. Espero que saiba o que fez. Essas almas piratas assombrarão estas águas para sempre agora...");
        cvAfterEvil.addOptionText(SPANISH, "Encontré el tesoro maldito y me lo quedé.", "*Retrocede con expresión preocupada*\nTú... ¿te lo quedaste? Esa es una decisión peligrosa, amigo. El oro maldito no trae nada más que infortunio. Espero que sepas lo que has hecho. Esas almas piratas acecharán estas aguas para siempre ahora...");
        cvAfterEvil.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, THE_TALE_OF_A_GHOST_SHIP) &&
                    LibQuest.isCharacterAtQuestPart(chara, THE_TALE_OF_A_GHOST_SHIP, 77)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAfterEvil);

        // ===== ROLEPLAY: City in ruins - AFTER Wazel Battle =====
        ConversationOption cvRoleplayRuins = new ConversationOption(0, 0);
        cvRoleplayRuins.addOptionText(ENGLISH, "How are you holding up with the city like this?", "*Looks around the ruined surroundings with weary eyes*\nSome days... some days I don't know. I've lived in Wazel my whole life. These streets, these people, they were everything to me. Seeing it all broken down like this... it breaks something inside you too.\n\nI'm afraid we'll never truly recover. That the Wazel I knew is gone forever. But what else can you do? You wake up, you light the fire, you serve what little you have. Life doesn't wait for you to stop grieving.");
        cvRoleplayRuins.addOptionText(PORTUGUESE, "Como você está aguentando com a cidade assim?", "*Olha ao redor das ruínas com olhos cansados*\nAlguns dias... alguns dias eu não sei. Vivi em Wazel a vida inteira. Essas ruas, essas pessoas, eram tudo para mim. Ver tudo destroçado assim... quebra algo dentro de você também.\n\nTenho medo de que jamais nos recuperemos de verdade. Que o Wazel que eu conhecia se foi para sempre. Mas o que mais você pode fazer? Você acorda, acende o fogo, serve o pouco que tem. A vida não espera você parar de se lamentar.");
        cvRoleplayRuins.addOptionText(SPANISH, "¿Cómo estás llevando todo esto con la ciudad así?", "*Mira los alrededores en ruinas con ojos cansados*\nAlgunos días... algunos días no lo sé. He vivido en Wazel toda mi vida. Estas calles, esta gente, eran todo para mí. Ver todo destrozado así... también rompe algo dentro de ti.\n\nTemo que nunca nos recuperemos de verdad. Que el Wazel que conocía se ha ido para siempre. Pero, ¿qué más puedes hacer? Te levantas, enciendes el fuego, sirves lo poco que tienes. La vida no espera a que dejes de lamentarte.");
        cvRoleplayRuins.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, WAZEL_BATTLE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplayRuins);


        return npc;
    }
}