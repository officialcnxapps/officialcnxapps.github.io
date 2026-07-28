package com.cnx.endlesstalestwo.data.npcs.dragonland;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.enums.Enums.RequirementVerification.NOT_OK;
import static com.cnx.endlesstalestwo.enums.Enums.RequirementVerification.OK;

import android.os.Looper;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.R;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.shops.ShopsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.GameplayCoreEntity;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Arrays;

public class Affronis extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Affronis");
        npc.age = 72;
        npc.job = Enums.NPCJobs.ALCHEMIST;
        npc.gender = Enums.Gender.MALE;

        npc.addDescriptionTranslation(ENGLISH, "A wise and solitary elder who has dedicated his life to studying dragons.\nHe has no friends or family, but his solitude hasn't driven him mad.\nHis deep gaze already shows that he doesn't remember ordinary life.\n\nHis physical features: Long white hair and beard, weathered skin from the sun and wind. He wears simple, worn-out robes of a scholar.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um ancião sábio e solitário que dedicou sua vida a estudar os dragões.\nNão tem amigos nem família, a solidão não lhe enlouqueceu.\nSeu olhar profundo já demonstra que não lembra da vida comum.\n\nSeus traços físicos: Longos cabelos e barba brancos, pele castigada pelo sol e pelo vento. Veste túnicas simples e gastas de um estudioso.");
        npc.addDescriptionTranslation(SPANISH, "Un anciano sabio y solitario que ha dedicado su vida al estudio de los dragones.\nNo tiene amigos ni familia, pero su soledad no lo ha vuelto loco.\nSu mirada profunda ya revela que no recuerda la vida ordinaria.\n\nSus traços físicos: Cabello y barba largos y blancos, piel curtida por el sol y el viento. Viste túnicas sencillas y gastadas de erudito.");

        npc.greetingsMessages.put(ENGLISH, Arrays.asList("The dragons are restless today. Be careful.", "Welcome to my sanctuary. Wisdom is as rare as a dragon's tear here."));
        npc.greetingsMessages.put(PORTUGUESE, Arrays.asList("Os dragões estão inquietos hoje. Tenha cuidado.", "Bem-vindo ao meu santuário. A sabedoria é tão rara quanto a lágrima de um dragão aqui."));
        npc.greetingsMessages.put(SPANISH, Arrays.asList("Los dragones están inquietos hoy. Ten cuidado.", "Bienvenido a mi santuario. La sabiduría es tan rara como la lágrima de un dragón aquí."));

        npc.byeMessages.put(ENGLISH, Arrays.asList("Safe travels, and watch the skies.", "Solitude returns. Farewell."));
        npc.byeMessages.put(PORTUGUESE, Arrays.asList("Boa viagem, e vigie os céus.", "A solidão retorna. Adeus."));
        npc.byeMessages.put(SPANISH, Arrays.asList("Buen viaje, y vigila los cielos.", "A solidão retorna. Adiós."));

        // Helper to check if player is at part 3 or further in Dragonland Quest
        GameplayCoreEntity.RequirementsValidations dragonlandMinPart3AllowActions = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 3)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 4)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 5)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 6)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 7)
                    || LibQuest.isQuestComplete(chara, QuestsIds.DRAGONLAND)) {
                return OK;
            }
            return NOT_OK;
        };

        // Helper to check if player is at part 2 or further in Dragonland Quest
        GameplayCoreEntity.RequirementsValidations dragonlandMinPart2AllowActions = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 2)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 3)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 4)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 5)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 6)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 7)
                    || LibQuest.isQuestComplete(chara, QuestsIds.DRAGONLAND)) {
                return OK;
            }
            return NOT_OK;
        };

        // ========================================
        // QUEST: DRAGONLAND
        // ========================================

        // Part 1: Initial encounter
        ConversationOption cvDragonland1 = new ConversationOption(0, 0);
        cvDragonland1.addOptionText(ENGLISH, "Help me! I was brought here by a massive dragon.",
                "*He looks at you with a curious tilt of his head, not at all surprised*\nBrought by the King, were you? That is rare. Usually, he just drops intruders from a much higher altitude. You must have something that piqued his interest... or perhaps he just wanted a new neighbor. \n\nIf you wish to leave this place, you'll need more than a plea for help. There's a boat carcass near the plains. It's been there for as long as I can remember. Go, see if any of it is still salvageable. If it is, we might be able to get you back to your land.");
        cvDragonland1.addOptionText(PORTUGUESE, "Ajude-me! Fui trazido aqui por um dragão enorme.",
                "*Ele olha para você com uma inclinação curiosa de cabeça, nem um pouco surpreso*\nTrazido pelo Rei, foi? Isso é raro. Geralmente, ele apenas solta os intrusos de uma altitude muito maior. Você deve ter algo que despertou o interesse dele... ou talvez ele apenas quisesse um novo vizinho. \n\nSe você deseja sair deste lugar, precisará de mais do que um pedido de ajuda. Há uma carcaça de barco perto das planícies. Está lá desde que me lembro. Vá, veja se algo ainda pode ser aproveitado. Se puder, talvez consigamos levar você de volta para sua terra.");
        cvDragonland1.addOptionText(SPANISH, "¡Ayúdame! Fui traído aquí por un dragón enorme.",
                "*Te mira con una curiosa inclinación de cabeza, nada sorprendido*\nTraído por el Rey, ¿verdad? Eso es raro. Por lo general, se limita a dejar caer a los intrusos desde una altitud mucho mayor. Debes tener algo que despertó su interés... o tal vez solo quería un nuevo vecino. \n\nSi quieres salir de este lugar, necesitarás algo más que una petición de ayuda. Hay una carcasa de barco cerca de las llanuras. Ha estado allí desde que tengo memoria. Ve, mira si algo todavía se puede salvar. Si es así, podríamos ser capaces de llevarte de vuelta con los tuyos.");
        cvDragonland1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 1)) {
                return OK;
            }
            return NOT_OK;
        };
        cvDragonland1.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(QuestsIds.DRAGONLAND, 2, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvDragonland1);

        // Part 3: Repair materials
        ConversationOption cvDragonland3 = new ConversationOption(0, 0);
        cvDragonland3.addOptionText(ENGLISH, "I found the boat. It can be repaired, but I need materials.",
                "*He nods slowly, stroking his long white beard*\nYes, the bones of the ship are strong. To make it seaworthy again, I will need specific supplies. When you have what is necessary, bring it to me and I will help.\n\nScavenge what you can; I may be kind enough to allow you to use my tools as well. I'll be here, preparing the tools.");
        cvDragonland3.addOptionText(PORTUGUESE, "Encontrei o barco. Ele pode ser reparado, mas preciso de materiais.",
                "*Ele acena lentamente, acariciando sua longa barba branca*\nSim, os ossos do navio são fortes. Para torná-lo navegável novamente, precisarei de suprimentos específicos. Quando tiver o necessário, traga para mim, eu ajudo.\n\nVasculhe o que puder, posso ser gentil e permitir que use tambem minhas ferramentas. Estarei aqui, preparando as ferramentas.");
        cvDragonland3.addOptionText(SPANISH, "He encontrado el barco. Se puede reparar, pero necesito materiales.",
                "*Asiente lentamente, acariciando su larga barba blanca*\nSí, los huesos del barco son fuertes. Para que vuelva a estar en condiciones de navegar, necesitaré suministros específicos. Cuando tengas lo necesario, tráemelo y te ayudaré.\n\nBusca lo que puedas; puedo ser lo suficientemente amable como para permitirte usar mis herramientas también. Estaré aquí, preparando las herramientas.");
        cvDragonland3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 3)
                    && LibInventory.checkHasItemAmount(ItemsIds.LOG, 3, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.ROPE, 3, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.STRING, 4, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.TISSUE, 3, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.PLANK, 5, chara)) {
                return NOT_OK;
            } else if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 3)) {
                return OK;
            }
            return NOT_OK;
        };
        npc.conversationOptions.add(cvDragonland3);

        ConversationOption cvDragonlandRepair = new ConversationOption(0, 0);
        cvDragonlandRepair.addOptionText(ENGLISH, "I have all the repair materials.",
                "*He examines the supplies with a keen eye, then gives a rare, toothless grin*\nIncredible. You have a knack for survival, traveler. Very well, let us begin. \n\n*He spends several hours working with you on the carcass, until the small boat is finally watertight and ready*\n\nThere. She's not a royal galleon, but she'll carry you home. The wind is favorable. Use the boat whenever you are ready. I... think I will stay here. My work with the dragons is not yet finished.");
        cvDragonlandRepair.addOptionText(PORTUGUESE, "Tenho todos os materiais de reparo.",
                "*Ele examina os suprimentos com um olhar atento, depois dá um raro sorriso desdentado*\nIncrível. Você tem um dom para a sobrevivência, viajante. Muito bem, vamos começar. \n\n*Ele passa várias horas trabalhando com você na carcaça, até que o pequeno barco esteja finalmente estanque e pronto*\n\nPronto. Ela não é um galeão real, mas o levará para casa. O vento está favorável. Use o barco quando estiver pronto. Eu... acho que vou ficar por aqui. Meu trabalho com os dragões ainda não terminou.");
        cvDragonlandRepair.addOptionText(SPANISH, "Tengo todos los materiales de reparación.",
                "*Examina los suministros con ojo agudo, luego esboza una rara sonrisa desdentada*\nIncreíble. Tienes un don para la supervivencia, viajero. Muy bien, comencemos. \n\n*Pasa varias horas trabajando contigo en la carcasa, hasta que el pequeño bote finalmente es estanco y está listo*\n\nListo. No es un galeón real, pero te llevará a casa. El viento es favorable. Usa el bote cuando estés listo. Yo... creo que me quedaré aquí. Mi trabajo con los dragones aún no ha terminado.");
        cvDragonlandRepair.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DRAGONLAND, 3)
                    && LibInventory.checkHasItemAmount(ItemsIds.LOG, 3, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.ROPE, 3, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.STRING, 4, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.TISSUE, 3, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.PLANK, 5, chara)) {
                return OK;
            }
            return NOT_OK;
        };
        cvDragonlandRepair.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.LOG, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.ROPE, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.STRING, 4, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.TISSUE, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.PLANK, 5, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.DRAGONLAND, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvDragonlandRepair);

        // ========================================
        // ROLEPLAY CONVERSATIONS
        // ========================================
        // ========================================
        // ACTIONS VIA CONVERSATION
        // ========================================

        // REST
        ConversationOption cvRest = new ConversationOption(0, 1);
        cvRest.addOptionText(ENGLISH, "Can I rest here?", "My hut is small, but safe. I ask only 2 gold pieces for the firewood and supplies. A fair price for safety from the claws above, don't you think?");
        cvRest.addOptionText(PORTUGUESE, "Posso descansar aqui?", "Minha cabana é pequena, mas segura. Peço apenas 2 moedas de ouro pela lenha e suprimentos. Um preço justo pela segurança contra as garras lá no alto, não acha?");
        cvRest.addOptionText(SPANISH, "¿Puedo descansar aquí?", "Mi choza es pequeña, pero segura. Solo pido 2 piezas de oro por la leña y los suministros. Un precio justo por la seguridad frente a las garras de arriba, ¿no crees?");
        cvRest.requirementValidations = dragonlandMinPart3AllowActions;
        npc.conversationOptions.add(cvRest);

        ConversationOption cvRestAccept = new ConversationOption(1, 0);
        cvRestAccept.addOptionText(ENGLISH, "Here are 2 gold. [Rest]", "Very well. Rest as long as you need. The fire will stay lit.");
        cvRestAccept.addOptionText(PORTUGUESE, "Aqui estão 2 ouro. [Descansar]", "Muito bem. Descanse o quanto precisar. O fogo continuará aceso.");
        cvRestAccept.addOptionText(SPANISH, "Aquí tienes 2 de oro. [Descansar]", "Muy bien. Descansa todo lo que necesites. El fuego permanecerá encendido.");
        cvRestAccept.requirementValidations = (chara, ctx) -> chara.checkHasGold(2) ? OK : Enums.RequirementVerification.NEED_GOLD;
        cvRestAccept.listeners = (ctx, frag) -> {
            if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                App.getPlayerChar().removeGold(2);
                gPlayActivity.lockScreenTouches(true);
                new android.os.Handler(Looper.getMainLooper()).postDelayed(() -> {
                    App.getPlayerChar().restoreFullHealth();
                    App.getPlayerChar().restoreHungry(420);
                    gPlayActivity.lockScreenTouches(false);
                    LibUtils.showToast(LibUtils.getString(R.string.RestoredEnergies, ctx), 0, ctx);
                }, 1500);
            }
        };
        npc.conversationOptions.add(cvRestAccept);

        ConversationOption cvRestDecline = new ConversationOption(1, 0);
        cvRestDecline.addOptionText(ENGLISH, "Maybe later.", "As you wish. The wild is not as forgiving as my four walls.");
        cvRestDecline.addOptionText(PORTUGUESE, "Talvez mais tarde.", "Como desejar. A natureza não é tão indulgente quanto minhas quatro paredes.");
        cvRestDecline.addOptionText(SPANISH, "Tal vez más tarde.", "Como desees. A naturaleza no es tão indulgente como mis cuatro paredes.");
        npc.conversationOptions.add(cvRestDecline);

        // ALCHEMY
        ConversationOption cvAlchemy = new ConversationOption(0, 0);
        cvAlchemy.addOptionText(ENGLISH, "Can I use your alchemy tools?", "My tools are yours to use. Just be careful with the dragon blood samples.");
        cvAlchemy.addOptionText(PORTUGUESE, "Posso usar suas ferramentas de alquimia?", "Minhas ferramentas são suas para usar. Apenas tome cuidado com as amostras de sangue de dragão.");
        cvAlchemy.addOptionText(SPANISH, "¿Puedo usar tus herramientas de alquimia?", "Mis herramientas son tuyas. Solo ten cuidado con las muestras de sangre de dragón.");
        cvAlchemy.requirementValidations = dragonlandMinPart3AllowActions;
        cvAlchemy.listeners = (ctx, frag) -> {
            if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                gPlayActivity.goToCraft(Enums.CraftTypes.ALCHEMY);
            }
        };
        npc.conversationOptions.add(cvAlchemy);

        // CRAFT
        ConversationOption cvCraft = new ConversationOption(0, 0);
        cvCraft.addOptionText(ENGLISH, "Can I craft something here?", "The workbench is available. A true craftsman can find inspiration even in this arid land.");
        cvCraft.addOptionText(PORTUGUESE, "Posso criar algo aqui?", "A bancada está disponível. Um verdadeiro artesão pode encontrar inspiração mesmo nesta terra árida.");
        cvCraft.addOptionText(SPANISH, "¿Puedo fabricar algo aquí?", "El banco de trabajo está disponible. Un verdadero artesano puede encontrar inspiración incluso en esta tierra árida.");
        cvCraft.requirementValidations = dragonlandMinPart3AllowActions;
        cvCraft.listeners = (ctx, frag) -> {
            if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                gPlayActivity.goToCraft(Enums.CraftTypes.GENERAL);
            }
        };
        npc.conversationOptions.add(cvCraft);

        // COOKING
        ConversationOption cvCook = new ConversationOption(0, 0);
        cvCook.addOptionText(ENGLISH, "May I use your stove?", "The fire is always hot here. Help yourself.");
        cvCook.addOptionText(PORTUGUESE, "Posso usar seu fogão?", "O fogo está sempre quente aqui. Fique à vontade.");
        cvCook.addOptionText(SPANISH, "¿Puedo usar tu estufa?", "El fuego siempre está caliente aquí. Sírvete tú mismo.");
        cvCook.requirementValidations = dragonlandMinPart3AllowActions;
        cvCook.listeners = (ctx, frag) -> {
            if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                gPlayActivity.goToCraft(Enums.CraftTypes.COOKING);
            }
        };
        npc.conversationOptions.add(cvCook);

        // SHOP ACCESS
        ConversationOption cvShop = new ConversationOption(0, 0);
        cvShop.addOptionText(ENGLISH, "Do you have anything for sale?", "I have some surplus supplies and alchemical creations.");
        cvShop.addOptionText(PORTUGUESE, "Você tem algo à venda?", "Tenho alguns suprimentos excedentes e criações alquímicas.");
        cvShop.addOptionText(SPANISH, "¿Tienes algo en venta?", "Tengo algunos suministros excedentes y creaciones alquímicas.");
        cvShop.requirementValidations = dragonlandMinPart3AllowActions;
        cvShop.listeners = (ctx, frag) -> {
            if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                gPlayActivity.goToViewShop(ShopsIds.AFFRONIS_PRODUCTIONS);
            }
        };
        npc.conversationOptions.add(cvShop);

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Why do you live here?", "I came here years ago to study these magnificent creatures. At first, I was trapped, but over time, I found peace in the solitude and the dragons' presence. This is my home now.");
        cv1.addOptionText(PORTUGUESE, "Por que você mora aqui?", "Vim aqui há anos para estudar essas criaturas magníficas. No começo, fiquei preso, mas com o tempo, encontrei paz na solidão e na presença dos dragões. Este é o meu lar agora.");
        cv1.addOptionText(SPANISH, "¿Por qué vives aquí?", "Vine aquí hace años para estudiar a estas magníficas criaturas. Al principio estuve atrapado, pero con el tiempo encontré la paz en la soledad y la presencia de los dragones. Este es mi hogar ahora.");
        cv1.requirementValidations = dragonlandMinPart2AllowActions;
        npc.conversationOptions.add(cv1);

        ConversationOption cv2Roleplay = new ConversationOption(0, 0);
        cv2Roleplay.addOptionText(ENGLISH, "What have you learned about dragons?", "They are not just beasts. They are ancient, proud, and deeply connected to the primal forces of this world. To understand them is to understand the very breath of the earth.");
        cv2Roleplay.addOptionText(PORTUGUESE, "O que você aprendeu sobre os dragões?", "Eles não são apenas feras. São antigos, orgulhosos e profundamente conectados com as forças primordiais deste mundo. Entendê-los é entender o próprio sopro da terra.");
        cv2Roleplay.addOptionText(SPANISH, "¿Qué has aprendido sobre los dragones?", "No son solo bestias. Son antiguos, orgullosos y profundamente conectados con las fuerzas primordiales de este mundo. Entenderlos es entender el propio aliento de la tierra.");
        cv2Roleplay.requirementValidations = dragonlandMinPart2AllowActions;
        npc.conversationOptions.add(cv2Roleplay);

        ConversationOption cv3Roleplay = new ConversationOption(0, 0);
        cv3Roleplay.addOptionText(ENGLISH, "Is there anyone else on this island?", "Just me, my research, and the dragons. Most who find themselves here are either brave enough to handle the dragons or too dead to complain. I prefer the quiet, though the roars can get quite loud at night.");
        cv3Roleplay.addOptionText(PORTUGUESE, "Há mais alguém nesta ilha?", "Apenas eu, minhas pesquisas e os dragões. A maioria que se encontra aqui é corajosa o suficiente para lidar com os dragões ou está morta demais para reclamar. Prefiro o silêncio, embora os rugidos possam ficar bem altos à noite.");
        cv3Roleplay.addOptionText(SPANISH, "¿Hay alguém más en esta isla?", "Solo yo, mis investigaciones y los dragones. La mayoría de los que se encuentran aquí son lo suficientemente valientes para manejar a los dragones o están demasiado muertos para quejarse. Prefiero el silencio, aunque los rugidos podem ser bastante fuertes por la noche.");
        cv3Roleplay.requirementValidations = dragonlandMinPart2AllowActions;
        npc.conversationOptions.add(cv3Roleplay);

        ConversationOption cv4Roleplay = new ConversationOption(0, 0);
        cv4Roleplay.addOptionText(ENGLISH, "Don't the dragons bother you?", "They have grown used to my presence. I respect their nests, and they, in their own primal way, respect my boundaries. It's a delicate balance, one that took years to establish.");
        cv4Roleplay.addOptionText(PORTUGUESE, "Os dragões não incomodam você?", "Eles se acostumaram com a minha presença. Eu respeito seus ninhos e eles, à sua maneira primordial, respeitam meus limites. É um equilíbrio delicado, que levou anos para ser estabelecido.");
        cv4Roleplay.addOptionText(SPANISH, "¿No te molestan los dragones?", "Se han acostumbrado a mi presencia. Respeto sus nidos y ellos, a su manera primitiva, respetan mis límites. Es un equilibrio delicado, que llevó años establecer.");
        cv4Roleplay.requirementValidations = dragonlandMinPart2AllowActions;
        npc.conversationOptions.add(cv4Roleplay);

        return npc;
    }
}
