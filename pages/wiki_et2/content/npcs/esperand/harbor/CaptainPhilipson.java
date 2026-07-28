package com.cnx.endlesstalestwo.data.npcs.esperand.harbor;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.INVESTIGATE_THE_BEAST;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.STUDYING_FISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.LocationTravelReference;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;
import com.cnx.endlesstalestwo.libs.Utils;

import java.util.ArrayList;

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
        ConversationOption cvTravel = new ConversationOption(0, 0);
        cvTravel.addOptionText(ENGLISH, "I need to sail.", "That's what I'm here for. Where to?");
        cvTravel.addOptionText(PORTUGUESE, "Preciso velejar.", "É para isso que estou aqui. Para onde?");
        cvTravel.addOptionText(SPANISH, "Necesito navegar.", "Para eso estoy aquí. ¿A dónde?");
        cvTravel.listeners = (ctx, currentFragment) -> openTravelDialog(ctx);
        npc.conversationOptions.add(cvTravel);

        // ========================================
        // QUEST: STUDYING FISH
        // ========================================

        // Part 3: Talk to Captain Philipson
        ConversationOption cvFishPart3 = new ConversationOption(0, 0);
        cvFishPart3.addOptionText(ENGLISH, "An elven student in Ayalon is studying fish. He needs a sample from Esperand's cold waters.",
                "An elven student, eh? From Ayalon? Don't see many of their kind around these parts. Ay, the waters here are icy, and the fish that live in 'em are a hardy bunch. \n\nI've got a specimen here that should interest 'em. This Esperand fish was caught just off the ice floes this morning. Tell 'em Philipson sends his regards.");
        cvFishPart3.addOptionText(PORTUGUESE, "Um estudante elfo em Ayalon está estudando peixes. Ele precisa de uma amostra das águas geladas de Esperand.",
                "Um estudante elfo, hein? De Ayalon? Não vemos muitos da espécie deles por aqui. Sim, as águas aqui são geladas, e os peixes que vivem nelas são resistentes. \n\nTenho um espécime aqui que deve interessá-los. Este peixe de Esperand foi pescado perto das placas de gelo esta manhã. Diga a eles que Philipson manda lembranças.");
        cvFishPart3.addOptionText(SPANISH, "Un estudiante elfo en Ayalon está estudiando peces. Necesita una muestra de las frías aguas de Esperand.",
                "¿Un estudiante elfo? ¿De Ayalon? No se ven muchos de los suyos por aquí. Sí, las aguas aquí son gélidas, y los peces que viven en ellas son una especie resistente. \n\nTengo un espécimen aquí que debería interesarles. Este pez de Esperand fue capturado justo al lado de los témpanos de hielo esta mañana. Dile que Philipson le manda saludos.");
        cvFishPart3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, STUDYING_FISH, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvFishPart3.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.ESPERAND_FISH, 1, App.getPlayerChar());
            LibQuest.updateQuest(STUDYING_FISH, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFishPart3);

        return npc;
    }

    private void openTravelDialog(android.content.Context ctx) {
        ArrayList<LocationTravelReference> destinations = new ArrayList<>();

        LocationTravelReference helera = new LocationTravelReference(null, LocationsIds.HELERA_HARBOR, 240);
        helera.destinationName = "Helera";
        helera.travelCost = 10;
        destinations.add(helera);

        LocationTravelReference wazel = new LocationTravelReference(null, LocationsIds.WAZEL_DOCKS, 360);
        wazel.destinationName = "Wazel";
        wazel.travelCost = 13;
        destinations.add(wazel);

        Utils.showTravelSelectionDialog(ctx, destinations);
    }
}
