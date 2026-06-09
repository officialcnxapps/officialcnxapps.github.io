package com.cnx.endlesstalestwo.data.npcs.esperand.barbarianSettlement;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Cradul extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Cradul");
        npc.age = 40;
        npc.job = Enums.NPCJobs.GUILD_LEADER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A man of few words, serious.\nLeader of the barbarians who commands fear and respect.\nEasily angered and clearly dislikes weak and simplistic people.\n\nHis physical traits: Muscular. Large face, long hair, large beard. Brown eyes with an angry expression.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma pessoa de poucas palavras, sério.\nLíder dos bárbaros que impõe medo e respeito.\nFacilmente raivoso e claramente desgosta de pessoas fracas e simplórias.\n\nSeus traços físicos: Musculoso. Rosto grande, cabelos compridos, barba grande. Olhos castanhos com expressão brava.");
        npc.addDescriptionTranslation(SPANISH, "Una persona de pocas palabras, seria.\nLíder de los bárbaros que impone miedo y respeto.\nSe enfurece con facilidad y claramente detesta a las personas débiles y simplonas.\n\nSus rasgos físicos: Musculoso. Rostro grande, cabello largo, barba grande. Ojos castaños con expresión brava.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("What you want?"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("O que você quer?"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("¿Qué quieres?"));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Go."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Vá."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Ve."));

        // ===== ROLEPLAY: Barbarian leader =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "You're the barbarian leader?", "Cradul lead warriors. Strong fighters. We not need soft city people. You have business or you go.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Você é o líder bárbaro?", "Cradul lidera guerreiros. Lutadores fortes. Nós não precisar de gente fraca da cidade. Você tem negócio ou você vai.");
        cvRoleplay1.addOptionText(SPANISH, "¿Eres el líder bárbaro?", "Cradul lidera guerreros. Luchadores fuertes. No necesitamos gente débil de ciudad. Tienes negocio o te vas.");
        cvRoleplay1.requirementValidations = (chara, ctx) -> {
            // Only show before or after quest
            if (!LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SMUGGLER, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay1);

        // ===== QUEST: Smuggler - Delivery (Part 2→3) =====
        ConversationOption cvDelivery = new ConversationOption(0, 1);
        cvDelivery.addOptionText(ENGLISH, "I have a delivery from the priest.", "*Eyes narrow suspiciously, hand moves to weapon*\nPriest? What priest? Many people claim things. \n*Steps closer, intimidating*\nWhy I trust you?");
        cvDelivery.addOptionText(PORTUGUESE, "Tenho uma entrega do sacerdote.", "*Olhos se estreitam com desconfiança, mão se move para a arma*\nSacerdote? Que sacerdote? Muitas pessoas alegam coisas. \n*Se aproxima, intimidador*\nPor que eu confiaria em você?");
        cvDelivery.addOptionText(SPANISH, "Tengo una entrega del sacerdote.", "*Los ojos se estrechan con desconfianza, la mano se mueve hacia el arma*\n¿Sacerdote? ¿Qué sacerdote? Mucha gente dice cosas. \n*Se acerca, intimidante*\n¿Por qué confiar en ti?");
        cvDelivery.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SMUGGLER, 2)) {
                // Check if player has the contraband package
                boolean hasPackage = LibInventory.checkHasItemAmount(ItemsIds.CONTRABAND_PACKAGE, 1, chara);
                if (hasPackage) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvDelivery);

        ConversationOption cvShowToken = new ConversationOption(1, 0);
        cvShowToken.addOptionText(ENGLISH, "[Show Mordius's token and the package]", "*You show the marked token. Cradul's expression changes immediately*\n\n*Grunts in recognition*\nAh. The priest runner. \n*Takes package without opening it, inspects the token*\nGood. \n*Tosses you a heavy coin purse*\nPayment. More gold than expected, yes? We pay well for... discretion. \n*Puts token in his belt*\nGive priest his share. Tell him... good business continues. \n*Turns away dismissively*\nWe done. Go.");
        cvShowToken.addOptionText(PORTUGUESE, "[Mostrar ficha de Mordius e o pacote]", "*Você mostra a ficha marcada. A expressão de Cradul muda imediatamente*\n\n*Grunhe em reconhecimento*\nAh. O mensageiro do sacerdote. \n*Pega o pacote sem abrir, inspeciona a ficha*\nBom. \n*Joga para você uma pesada bolsa de moedas*\nPagamento. Mais ouro do que esperava, sim? Pagamos bem por... discrição. \n*Coloca a ficha em seu cinto*\nDar ao sacerdote a parte dele. Dizer a ele... bons negócios continuam. \n*Se vira desdenhosamente*\nTerminamos. Ir.");
        cvShowToken.addOptionText(SPANISH, "[Mostrar ficha de Mordius y el paquete]", "*Muestras la ficha marcada. La expresión de Cradul cambia inmediatamente*\n\n*Gruñe en reconocimiento*\nAh. El mensajero del sacerdote. \n*Toma el paquete sin abrirlo, inspecciona la ficha*\nBien. \n*Te arroja una pesada bolsa de monedas*\nPago. Más oro de lo esperado, ¿sí? Pagamos bien por... discreción. \n*Pone la ficha en su cinturón*\nDale al sacerdote su parte. Dile... buenos negocios continúan. \n*Se da la vuelta desdeñosamente*\nTerminamos. Vete.");
        cvShowToken.listeners = (ctx, currentFragment) -> {
            // Remove contraband package from inventory
            LibInventory.removeFromInventory(ItemsIds.CONTRABAND_PACKAGE, 1, App.getPlayerChar());
            // Update quest to part 3 (return to Mordius)
            LibQuest.updateQuest(QuestsIds.SMUGGLER, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvShowToken);

        // ========================================
        // QUEST: CONTRABAND
        // ========================================

        // Part 1: Player asks Cradul for the package (group 0 → 0)
        ConversationOption cvContrabandPart1 = new ConversationOption(0, 0);
        cvContrabandPart1.addOptionText(ENGLISH,
                "Mordius sent me. He needs the package.",
                "*Cradul stares at you for a long moment, then grunts in recognition*\nAh. Priest runner again. \n*Disappears briefly and returns with a wrapped bundle*\nHere. Tell priest this batch is... special. Handle carefully. \n*Shoves the package into your hands*\nNow go. Not stay here with that.");
        cvContrabandPart1.addOptionText(PORTUGUESE,
                "Mordius me enviou. Ele precisa do pacote.",
                "*Cradul te encarou por um longo momento, depois grunhe em reconhecimento*\nAh. O mensageiro do sacerdote de novo. \n*Desaparece brevemente e volta com um embrulho*\nAqui. Diga ao sacerdote que este lote é... especial. Manuseie com cuidado. \n*Empurra o pacote para as suas mãos*\nAgora vá. Não ficar aqui com isso.");
        cvContrabandPart1.addOptionText(SPANISH,
                "Mordius me envió. Necesita el paquete.",
                "*Cradul te mira fijamente durante un largo momento, luego gruñe en reconocimiento*\nAh. El mensajero del sacerdote otra vez. \n*Desaparece brevemente y vuelve con un bulto envuelto*\nAquí. Dile al sacerdote que este lote es... especial. Maneja con cuidado. \n*Te empuja el paquete en las manos*\nAhora vete. No quedarse aquí con eso.");
        cvContrabandPart1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CONTRABAND, 1)
                    && !LibInventory.checkHasItem(ItemsIds.CONTRABAND_PACKAGE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvContrabandPart1.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.CONTRABAND_PACKAGE, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.CONTRABAND, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvContrabandPart1);

        // Part 1 (already has package - reminder to go to Mordius)
        ConversationOption cvContrabandPart1Reminder = new ConversationOption(0, 0);
        cvContrabandPart1Reminder.addOptionText(ENGLISH,
                "About the package...",
                "*Cradul narrows his eyes and crosses his arms*\nYou already have what you need. Take it to priest. Not come back here until done.");
        cvContrabandPart1Reminder.addOptionText(PORTUGUESE,
                "Sobre o pacote...",
                "*Cradul entrecerra os olhos e cruza os braços*\nVocê já tem o que precisa. Leve ao sacerdote. Não voltar aqui até terminar.");
        cvContrabandPart1Reminder.addOptionText(SPANISH,
                "Sobre el paquete...",
                "*Cradul entrecierra los ojos y cruza los brazos*\nYa tienes lo que necesitas. Llévalo al sacerdote. No volver aquí hasta terminar.");
        cvContrabandPart1Reminder.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CONTRABAND, 1)
                    && LibInventory.checkHasItem(ItemsIds.CONTRABAND_PACKAGE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvContrabandPart1Reminder);

        return npc;
    }
}
