package com.cnx.endlesstalestwo.data.npcs.gybralar;

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

public class ElfGoddessStatue extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Elf Goddess Statue");
        npc.addNameTranslation(PORTUGUESE, "Estátua da Deusa Élfica");
        npc.addNameTranslation(SPANISH, "Estatua de la Diosa Élfica");
        npc.age = 0;
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");
        npc.imgFile = "npc_statue_of_aelindra";

        npc.requirementValidations = (chara, ctx) -> {
            // Statue only visible from STRATEGY part 3 onward (when player reaches the tunnel)
            boolean strategyReady = LibQuest.isCharacterAtQuestPart(chara, QuestsIds.STRATEGY, 3)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.STRATEGY, 4)
                    || LibQuest.isQuestComplete(chara, QuestsIds.STRATEGY)
                    || LibQuest.charHasQuest(QuestsIds.ELF_KNOWLEDGE, chara);
            if (strategyReady) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Welcome, human child of earth and fleeting time"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bem-vindo, humano filho da terra e do tempo fugaz."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Bienvenido, humano hijo de la tierra y del tiempo fugaz."));

        // ===== STRATEGY QUEST - Part 4: First encounter with statue =====
        ConversationOption cvStrategy1 = new ConversationOption(0, 1);
        cvStrategy1.addOptionText(ENGLISH, "Goddess Aelindra, I seek passage to Ayalon.", "*A voice echoes in your mind*\nMortal seeking Ayalon... You carry a royal seal and pure intentions, but worthiness must be proven. To activate the portal beyond, present an offering of rare sacred herbs.");
        cvStrategy1.addOptionText(PORTUGUESE, "Deusa Aelindra, busco passagem para Ayalon.", "*Uma voz ecoa em sua mente*\nMortal buscando Ayalon... Você porta um selo real e intenções puras, mas a dignidade deve ser provada. Para ativar o portal além, apresente uma oferenda de ervas sagradas raras.");
        cvStrategy1.addOptionText(SPANISH, "Diosa Aelindra, busco paso a Ayalon.", "*Una voz resuena en tu mente*\nMortal buscando Ayalon... Portas un sello real e intenciones puras, pero la valía debe probarse. Para activar el portal más allá, presenta una ofrenda de hierbas sagradas raras.");
        cvStrategy1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.STRATEGY, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvStrategy1);

        ConversationOption cvStrategy2 = new ConversationOption(1, 0);
        cvStrategy2.addOptionText(ENGLISH, "I understand. I will find these sacred herbs.", "Return when you have them. The portal awaits those who understand that true alliance requires respect for ancient ways.");
        cvStrategy2.addOptionText(PORTUGUESE, "Entendo. Vou encontrar essas ervas sagradas.", "Retorne quando as tiver. O portal aguarda aqueles que entendem que a verdadeira aliança requer respeito pelos caminhos antigos.");
        cvStrategy2.addOptionText(SPANISH, "Entiendo. Encontraré esas hierbas sagradas.", "Regresa cuando las tengas. El portal aguarda a aquellos que entienden que la verdadera alianza requiere respeto por los caminos antiguos.");
        cvStrategy2.listeners = (ctx, currentFragment) -> {
            // Complete Strategy quest and start Elf Knowledge
            LibQuest.completeQuest(QuestsIds.STRATEGY, App.getPlayerChar(), 4, ctx);
            LibQuest.includeQuestToQuestbook(QuestsIds.ELF_KNOWLEDGE, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvStrategy2);

        // ===== ELF KNOWLEDGE QUEST - Part 2: Deliver 3 White Herbs =====
        ConversationOption cvElfKnowledge1 = new ConversationOption(0, 2);
        cvElfKnowledge1.addOptionText(ENGLISH, "I have brought the sacred white herbs.", "*The statue's eyes glow*\nYou have proven your dedication. Place the herbs before me.");
        cvElfKnowledge1.addOptionText(PORTUGUESE, "Trouxe as ervas brancas sagradas.", "*Os olhos da estátua brilham*\nVocê provou sua dedicação. Coloque as ervas diante de mim.");
        cvElfKnowledge1.addOptionText(SPANISH, "He traído las hierbas blancas sagradas.", "*Los ojos de la estatua brillan*\nHas demostrado tu dedicación. Coloca las hierbas ante mí.");
        cvElfKnowledge1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELF_KNOWLEDGE, 2) &&
                    LibInventory.checkHasItemAmount(ItemsIds.WHITE_HERB, 3, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfKnowledge1);

        ConversationOption cvElfKnowledge2 = new ConversationOption(2, 0);
        cvElfKnowledge2.addOptionText(ENGLISH, "*Place the three white herbs at the statue's base*", "*The herbs dissolve in ethereal light*\nThe offering is accepted. The portal to Ayalon is now open to you. Speak with me whenever you wish to travel between realms. May your journey bring the alliance you seek.");
        cvElfKnowledge2.addOptionText(PORTUGUESE, "*Coloca as três ervas brancas na base da estátua*", "*As ervas se dissolvem em luz etérea*\nA oferenda é aceita. O portal para Ayalon está agora aberto para você. Fale comigo sempre que desejar viajar entre reinos. Que sua jornada traga a aliança que busca.");
        cvElfKnowledge2.addOptionText(SPANISH, "*Coloca las tres hierbas blancas en la base de la estatua*", "*Las hierbas se disuelven en luz etérea*\nLa ofrenda es aceptada. El portal a Ayalon está ahora abierto para ti. Háblame siempre que desees viajar entre reinos. Que tu viaje traiga la alianza que buscas.");
        cvElfKnowledge2.listeners = (ctx, currentFragment) -> {
            // Remove 3 White Herbs from inventory
            LibInventory.removeFromInventory(ItemsIds.WHITE_HERB, 3, App.getPlayerChar());
            // Update quest to part 3 (portal now accessible)
            LibQuest.updateQuest(QuestsIds.ELF_KNOWLEDGE, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvElfKnowledge2);

        // ===== ELF KNOWLEDGE QUEST - Part 3+: Travel to Ayalon =====
        ConversationOption cvPortalTravel = new ConversationOption(0, 0);
        cvPortalTravel.addOptionText(ENGLISH, "I wish to travel to Ayalon.", "*The portal behind the statue shimmers*\nStep through, mortal. Ayalon awaits.");
        cvPortalTravel.addOptionText(PORTUGUESE, "Desejo viajar para Ayalon.", "*O portal atrás da estátua brilha*\nEntre, mortal. Ayalon aguarda.");
        cvPortalTravel.addOptionText(SPANISH, "Deseo viajar a Ayalon.", "*El portal detrás de la estatua resplandece*\nEntra, mortal. Ayalon aguarda.");
        cvPortalTravel.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELF_KNOWLEDGE, 3) ||
                    LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELF_KNOWLEDGE, 4) ||
                    LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELF_KNOWLEDGE, 5) ||
                    LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELF_KNOWLEDGE, 6) ||
                    LibQuest.isQuestComplete(chara, QuestsIds.ELF_KNOWLEDGE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPortalTravel.listeners = (ctx, fragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.GREEN_CAVE, 0, gPlayActivity, App.getPlayerChar());
            }
        };
        npc.conversationOptions.add(cvPortalTravel);

        return npc;
    }
}

