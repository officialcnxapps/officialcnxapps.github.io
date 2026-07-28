package com.cnx.endlesstalestwo.data.npcs.wazel.deepCrater;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

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

import java.util.Collections;

public class MysticRock extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Mystic Rock");
        npc.addNameTranslation(PORTUGUESE, "Pedra Mística");
        npc.addNameTranslation(SPANISH, "Roca Mística");
        npc.age = 900;
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.UNKNOWN;
        npc.allowTraitsAnalysis = false;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("A mortal..."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Um mortal..."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Un mortal..."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("..."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("..."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("..."));

        // ===== ROLEPLAY: What are you? =====
        ConversationOption cvRoleplay = new ConversationOption(0, 0);
        cvRoleplay.addOptionText(ENGLISH, "What are you?", "...Awareness... trapped in stone... ancient... waiting... The desert remembers... I remember... ages passing... civilizations rising... falling... I endure...");
        cvRoleplay.addOptionText(PORTUGUESE, "O que você é?", "...Consciência... presa em pedra... ancestral... esperando... O deserto lembra... Eu lembro... eras passando... civilizações surgindo... caindo... Eu persisto...");
        cvRoleplay.addOptionText(SPANISH, "¿Qué eres?", "...Conciencia... atrapada en piedra... ancestral... esperando... El desierto recuerda... Yo recuerdo... eras pasando... civilizaciones surgiendo... cayendo... Yo perduro...");
        npc.conversationOptions.add(cvRoleplay);

        // ===== QUEST PART 2: Dwarven knowledge =====
        ConversationOption cvQuest1 = new ConversationOption(0, 1);
        cvQuest1.addOptionText(ENGLISH, "Do you know about dwarves beneath the desert?", "...Dwarves... yes... deep ones... stone shapers... \n*The rock seems to pulse with ancient energy*\n...Below... far below... where earth's heart beats... they dwell... Growrocks... city of hammer and anvil... carved from living rock... deeper than mortal miners dare go...");
        cvQuest1.addOptionText(PORTUGUESE, "Você sabe sobre anões sob o deserto?", "...Anões... sim... das profundezas... moldadores de pedra... \n*A rocha parece pulsar com energia ancestral*\n...Abaixo... muito abaixo... onde o coração da terra bate... eles habitam... Growrocks... cidade de martelo e bigorna... esculpida em rocha viva... mais profundo do que mineradores mortais ousam ir...");
        cvQuest1.addOptionText(SPANISH, "¿Sabes sobre enanos bajo el desierto?", "...Enanos... sí... de las profundidades... moldeadores de piedra... \n*La roca parece pulsar con energía ancestral*\n...Abajo... muy abajo... donde el corazón de la tierra late... habitan... Growrocks... ciudad de martillo y yunque... tallada en roca viva... más profundo de lo que los minas mortales se atreven a ir...");
        cvQuest1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuest1);

        ConversationOption cvQuest2 = new ConversationOption(1, 0);
        cvQuest2.addOptionText(ENGLISH, "How can I reach Growrocks?", "...Passage exists... ancient tunnel... Long Cave Trail... \nVisions flicker through your mind - dark tunnels, winding passages\n...I can send you there... but path requires... payment... iron from earth's veins... one piece... \n\n...And word... magic word... spoken in old tongue... dwarven tongue... without it... gates remain sealed... \n\n...Seek knowledge... seek those who study... they may know the word...");
        cvQuest2.addOptionText(PORTUGUESE, "Como posso alcançar Growrocks?", "...Passagem existe... túnel ancestral... Trilha da Caverna Longa... \nVisões cintilam em sua mente - túneis escuros, passagens sinuosas\n...Posso enviar você lá... mas caminho requer... pagamento... ferro das veias da terra... uma peça... \n\n...E palavra... palavra mágica... falada em língua antiga... língua anã... sem ela... portões permanecem selados... \n\n...Busque conhecimento... busque aqueles que estudam... eles podem saber a palavra...");
        cvQuest2.addOptionText(SPANISH, "¿Cómo puedo llegar a Growrocks?", "...Pasaje existe... túnel ancestral... Sendero de la Cueva Larga... \nVisiones parpadean en tu mente - túneles oscuros, pasajes sinuosos\n...Puedo enviarte allí... pero camino requiere... pago... hierro de las venas de la tierra... una pieza... \n\n...Y palabra... palabra mágica... hablada en lengua antigua... lengua enana... sin ella... puertas permanecen selladas... \n\n...Busca conocimiento... busca a quienes estudian... pueden saber la palabra...");
        cvQuest2.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.PEOPLE_OF_THE_DEPTHS, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuest2);

        // ===== QUEST PART 4: Transport with magic word + iron ore =====
        ConversationOption cvQuestTransport = new ConversationOption(0, 2);
        cvQuestTransport.addOptionText(ENGLISH, "I have iron ore and know the magic word: Khazad-dûm", "*The rock glows intensely*\n...Word correct... ancient word... mountain home... deep halls... \n\n*You place the iron ore before the rock - it dissolves into the stone*\n...Payment accepted... iron returns to earth... \n\n*Ancient energy swirls around you*\n...Passage opens... Long Cave Trail awaits... go now... seek the gates... speak to guardians with respect... they watch always...");
        cvQuestTransport.addOptionText(PORTUGUESE, "Tenho minério de ferro e conheço a palavra mágica: Khazad-dûm", "*A rocha brilha intensamente*\n...Palavra correta... palavra ancestral... lar da montanha... salões profundos... \n\n*Você coloca o minério de ferro diante da rocha - ele se dissolve na pedra*\n...Pagamento aceito... ferro retorna à terra... \n\n*Energia ancestral gira ao seu redor*\n...Passagem se abre... Trilha da Caverna Longa aguarda... vá agora... busque os portões... fale com guardiões com respeito... eles vigiam sempre...");
        cvQuestTransport.addOptionText(SPANISH, "Tengo mineral de hierro y conozco la palabra mágica: Khazad-dûm", "*La roca brilla intensamente*\n...Palabra correcta... palabra ancestral... hogar de la montaña... salones profundos... \n\n*Colocas el mineral de hierro ante la roca - se disuelve en la piedra*\n...Pago aceptado... hierro regresa a la tierra... \n\n*Energía ancestral gira a tu alrededor*\n...Pasaje se abre... Sendero de la Cueva Larga aguarda... ve ahora... busca las puertas... habla con guardianes con respeto... vigilan siempre...");
        cvQuestTransport.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS, 4) &&
                    LibInventory.checkHasItem(ItemsIds.IRON_ORE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestTransport);

        ConversationOption cvQuestTeleport = new ConversationOption(2, 999);
        cvQuestTeleport.addOptionText(ENGLISH, "*Step into the ancient energy*", "*The world shifts around you - stone and earth blur*");
        cvQuestTeleport.addOptionText(PORTUGUESE, "*Entre na energia ancestral*", "*O mundo muda ao seu redor - pedra e terra se desfocam*");
        cvQuestTeleport.addOptionText(SPANISH, "*Entra en la energía ancestral*", "*El mundo cambia a tu alrededor - piedra y tierra se desdibujan*");
        cvQuestTeleport.listeners = (ctx, currentFragment) -> {
            // Remove iron ore
            LibInventory.removeFromInventory(ItemsIds.IRON_ORE, 1, App.getPlayerChar());
            // Update quest to part 5
            LibQuest.updateQuest(QuestsIds.PEOPLE_OF_THE_DEPTHS, 5, App.getPlayerChar(), ctx);
            // Teleport player to Long Cave Trail
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.LONG_CAVE_TRAIL, 0, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvQuestTeleport);

        // ===== RECURRING TRAVEL: After completing transport once =====
        ConversationOption cvRecurringTravel = new ConversationOption(0, 3);
        cvRecurringTravel.addOptionText(ENGLISH, "I wish to travel to Long Cave Trail again.", "...Return... to depths... \n*The rock pulses with recognition*\n...Iron... one piece... passage reopens...");
        cvRecurringTravel.addOptionText(PORTUGUESE, "Desejo viajar para a Trilha da Caverna Longa novamente.", "...Retornar... às profundezas... \n*A rocha pulsa com reconhecimento*\n...Ferro... uma peça... passagem se reabre...");
        cvRecurringTravel.addOptionText(SPANISH, "Deseo viajar al Sendero de la Cueva Larga nuevamente.", "...Regresar... a las profundidades... \n*La roca pulsa con reconocimiento*\n...Hierro... una pieza... pasaje se reabre...");
        cvRecurringTravel.requirementValidations = (chara, ctx) -> {
            if ((LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS, 5)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS, 6)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS, 7)
                    || LibQuest.isQuestComplete(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS)) &&
                    LibInventory.checkHasItem(ItemsIds.IRON_ORE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRecurringTravel);

        ConversationOption cvRecurringTravelNotOre = new ConversationOption(0, 0);
        cvRecurringTravelNotOre.addOptionText(ENGLISH, "I wish to travel to Long Cave Trail again.", "...Return... to depths... \n...Iron is needed...");
        cvRecurringTravelNotOre.addOptionText(PORTUGUESE, "Desejo viajar para a Trilha da Caverna Longa novamente.", "...Retornar... às profundezas... \n...Ferro é necessário...");
        cvRecurringTravelNotOre.addOptionText(SPANISH, "Deseo viajar al Sendero de la Cueva Larga nuevamente.", "...Regresar... a las profundidades... \n...Hierro es necesario...");
        cvRecurringTravelNotOre.requirementValidations = (chara, ctx) -> {
            if ((LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS, 5)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS, 6)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS, 7)
                    || LibQuest.isQuestComplete(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS)) &&
                    !LibInventory.checkHasItem(ItemsIds.IRON_ORE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRecurringTravelNotOre);

        ConversationOption cvRecurringTeleport = new ConversationOption(3, 0);
        cvRecurringTeleport.addOptionText(ENGLISH, "*Give iron ore and step into the energy*", "*The iron dissolves into the ancient stone*\n...Payment accepted... passage opens... \n\n*Energy swirls around you once more*\n*The familiar sensation of ancient magic transports you*\n\nYou arrive in Long Cave Trail, the dwarven tunnels stretching before you.");
        cvRecurringTeleport.addOptionText(PORTUGUESE, "*Entregar minério de ferro e entrar na energia*", "*O ferro se dissolve na pedra ancestral*\n...Pagamento aceito... passagem se abre... \n\n*Energia gira ao seu redor mais uma vez*\n*A sensação familiar de magia ancestral o transporta*\n\nVocê chega na Trilha da Caverna Longa, os túneis anões se estendendo diante de você.");
        cvRecurringTeleport.addOptionText(SPANISH, "*Entregar mineral de hierro y entrar en la energía*", "*El hierro se disuelve en la piedra ancestral*\n...Pago aceptado... pasaje se abre... \n\n*Energía gira a tu alrededor una vez más*\n*La sensación familiar de magia ancestral te transporta*\n\nLlegas al Sendero de la Cueva Larga, los túneles enanos se extienden ante ti.");
        cvRecurringTeleport.listeners = (ctx, fragment) -> {
            // Remove iron ore
            LibInventory.removeFromInventory(ItemsIds.IRON_ORE, 1, App.getPlayerChar());
            // Teleport player to Long Cave Trail
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.LONG_CAVE_TRAIL, 0, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvRecurringTeleport);

        return npc;
    }
}

