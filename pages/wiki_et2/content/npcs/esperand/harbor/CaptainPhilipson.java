package com.cnx.endlesstalestwo.data.npcs.esperand.harbor;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.INVESTIGATE_THE_BEAST;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;
import com.cnx.endlesstalestwo.libs.Utils;

public class CaptainPhilipson extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Captain Philipson");
        npc.addNameTranslation(PORTUGUESE, "Capitão Philipson");
        npc.addNameTranslation(SPANISH, "Capitán Philipson");
        npc.age = 44;
        npc.job = Enums.NPCJobs.SHIP_CAPTAIN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Despite his serious demeanor, he is a calm man.\nHe does not talk much, weighs his words, and speaks with wisdom. A good captain.\n\nHis physical traits: Dark skin, a broad face, and a serious expression. Black hair and beard with thick, slightly graying strands.");
        npc.addDescriptionTranslation(PORTUGUESE, "Apesar da seriedade, é um homem tranquilo.\nNão conversa muito, mede suas palavras e as coloca com sabedoria. Um bom capitão.\n\nSeus traços físicos: Pele negra, rosto grande e expressão séria. Cabelos e barba negros com fios grossos e levemente grisalhos.");
        npc.addDescriptionTranslation(SPANISH, "A pesar de su seriedad, es un hombre tranquilo.\nNo habla mucho, mide sus palabras y las expresa con sabiduría. Un buen capitán.\n\nSus rasgos físicos: Piel negra, rostro grande y expresión seria. Cabello y barba negros con mechones gruesos y ligeramente canosos.");

        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, INVESTIGATE_THE_BEAST, 2)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "How is the sea these days?", "Hah! Treacherous as ever. The ice floes are shiftin' earlier this season. Makes navigatin' a real test of skill. Keeps the blood warm, though, eh?");
        cv1.addOptionText(PORTUGUESE, "Como está o mar estes dias?", "Hah! Traiçoeiro como sempre. As placas de gelo estão a mover-se mais cedo esta estação. Torna a navegação um verdadeiro teste de habilidade. Mas mantém o sangue quente, não é?");
        cv1.addOptionText(SPANISH, "¿Cómo está el mar estos días?", "¡Ja! Traicionero como siempre. Los témpanos de hielo se están moviendo antes esta temporada. Hace que navegar sea una verdadera prueba de habilidad. Pero mantiene la sangre caliente, ¿eh?");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Heard any interesting rumors from other ports?", "Aye, plenty. Sailors love to spin a yarn. Most of it's just tall tales from drunk men. But it makes for good entertainment by the fire.");
        cv2.addOptionText(PORTUGUESE, "Ouviu algum rumor interessante de outros portos?", "Sim, muitos. Marinheiros adoram contar uma história. A maioria são apenas histórias exageradas de homens bêbados. Mas dá uma boa diversão junto à lareira.");
        cv2.addOptionText(SPANISH, "¿Has oído algún rumor interesante de otros puertos?", "Sí, muchísimos. A los marineros les encanta inventar historias. La mayoría son solo cuentos exagerados de hombres borrachos. Pero es un buen entretenimiento junto al fuego.");
        npc.conversationOptions.add(cv2);

        // ========================================
        // QUEST: PATROLMAN — PART 4
        // ========================================

        // Part 4: Player arrives to pick up the Crate of Weapons for Vinny
        ConversationOption cvPatrolmanPart4 = new ConversationOption(0, 0);
        cvPatrolmanPart4.addOptionText(ENGLISH, "Vinny sent me. I'm here to pick up the weapons shipment.",
                "*He nods and heads to the back of the dock*\nAh, yes! Vinny's guard order. Been waiting for someone to come pick this up.\n*Returns with a heavy crate*\nHere — one Crate of Weapons, sealed and ready. Tell Vinny the next shipment will arrive next season. And... watch yourself on the road back.");
        cvPatrolmanPart4.addOptionText(PORTUGUESE, "Vinny me enviou. Estou aqui para buscar o carregamento de armas.",
                "*Ele acena e vai para o fundo do cais*\nAh, sim! O pedido de Vinny. Estava esperando alguém vir buscar isso.\n*Retorna com um caixote pesado*\nAqui — um Caixote de Armas, selado e pronto. Diga a Vinny que o próximo carregamento chegará na próxima estação. E... tome cuidado no caminho de volta.");
        cvPatrolmanPart4.addOptionText(SPANISH, "Vinny me envió. Estoy aquí para recoger el cargamento de armas.",
                "*Asiente y va al fondo del muelle*\n¡Ah, sí! El pedido de Vinny. Estaba esperando que alguien viniera a recoger esto.\n*Regresa con un cajón pesado*\nAquí — un Cajón de Armas, sellado y listo. Dile a Vinny que el próximo cargamento llegará la próxima temporada. Y... ten cuidado en el camino de vuelta.");
        cvPatrolmanPart4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PATROLMAN, 40)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPatrolmanPart4.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.CRATE_OF_WEAPONS, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.PATROLMAN, 50, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPatrolmanPart4);

        ///TRAVEL OPTIONS
        ConversationOption cvTravel = new ConversationOption(0, 100);
        cvTravel.addOptionText(ENGLISH, "I need to sail.", "That's what I'm here for. We can go to Helera and Wazel");
        cvTravel.addOptionText(PORTUGUESE, "Preciso velejar.", "É para isso que estou aqui. Podemos ir para Helera e Wazel.");
        cvTravel.addOptionText(SPANISH, "Necesito navegar.", "Para eso estoy aquí. Podemos ir a Helera e Wazel.");
        npc.conversationOptions.add(cvTravel);

        ConversationOption cvTravel1 = new ConversationOption(100, 999);
        cvTravel1.addOptionText(ENGLISH, "Travel to Helera [10 gold]", "Ya! Let the winds of the sea take us!");
        cvTravel1.addOptionText(PORTUGUESE, "Viagem para Helera [10 ouro]", "Ya! Deixe que os ventos do mar nos leve!");
        cvTravel1.addOptionText(SPANISH, "Viaje a Helera [10 de oro]", "¡Ya! ¡Que los vientos del mar nos lleven!");
        cvTravel1.showEvenWhenNotValid = true;
        cvTravel1.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(10)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cvTravel1.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.HELERA_HARBOR, 10, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvTravel1);

        ConversationOption cvTravel2 = new ConversationOption(100, 999);
        cvTravel2.addOptionText(ENGLISH, "Travel to Wazel [13 gold]", "Ya! Let the winds of the sea take us!");
        cvTravel2.addOptionText(PORTUGUESE, "Viagem para Wazel [13 ouro]", "Ya! Deixe que os ventos do mar nos leve!");
        cvTravel2.addOptionText(SPANISH, "Viaje a Wazel [13 de oro]", "¡Ya! ¡Que los vientos del mar nos lleven!");
        cvTravel2.showEvenWhenNotValid = true;
        cvTravel2.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null && App.getPlayerChar().checkHasGold(13)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_GOLD;
        };
        cvTravel2.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.WAZEL_DOCKS, 13, gPlayActivity, App.getPlayerChar());
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
