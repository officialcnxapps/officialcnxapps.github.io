package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.library;

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
import com.cnx.endlesstalestwo.libs.LibNpc;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Maximilian extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Maximilian");
        npc.age = 52;
        npc.job = Enums.NPCJobs.TRADER; // Wealthy collector/trader
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Materialistic and greedy. He values his possessions more than anything else.\nHe is clever and doesn't let anyone tell him what to do.\nA kingdom noble that nobody knows where his wealth came from.\n\nHis physical traits: Full face, blue eyes and a wide forehead. No beard, short white hair. High-quality red and green garments.");
        npc.addDescriptionTranslation(PORTUGUESE, "Materialista e ganancioso. Dá mais valor a seus pertences do que para qualquer outra coisa.\nÉ esperto, não deixa ninguém lhe dizer o que fazer.\nUm nobre do reino que ninguém sabe de onde tirou sua riqueza.\n\nSeus traços físicos: Rosto preenchido, olhos azuis e testa larga. Sem barba, cabelo curto e branco. Vestes vermelhas e verdes de alta qualidade.");
        npc.addDescriptionTranslation(SPANISH, "Materialista y codicioso. Valora sus posesiones más que cualquier otra cosa.\nEs listo y no deja que nadie le diga lo que tiene que hacer.\nUn noble del reino del que nadie sabe de dónde sacó su riqueza.\n\nSus rasgos físicos: Rostro lleno, ojos azules y frente ancha. Sin barba, cabello corto y blanco. Vestimentas rojas y verdes de alta calidad.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Ah, welcome."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Ah, bem-vindo."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Ah, bienvenido."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Until next time."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Até a próxima."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Hasta la próxima."));

        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.RIOT_CONTROL)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // ===== ROLEPLAY: What do you do here? =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 10);
        cvRoleplay1.addOptionText(ENGLISH, "What do you do here?", "I'm a collector, my friend. I seek rare and valuable items from across all the kingdoms - gemstones, legendary weapons, ancient artifacts. Each piece in my collection has a story to tell. I've devoted my life to finding and preserving these treasures.\nRight now I am seeking books about some rare gems.");
        cvRoleplay1.addOptionText(PORTUGUESE, "O que você faz aqui?", "Sou um colecionador, meu amigo. Procuro itens raros e valiosos de todos os reinos - gemas, armas lendárias, artefatos antigos. Cada peça da minha coleção tem uma história para contar. Dediquei minha vida a encontrar e preservar esses tesouros.\nNo momento estou procurando livros sobre algumas gemas raras.");
        cvRoleplay1.addOptionText(SPANISH, "¿Qué haces aquí?", "Soy un coleccionista, mi amigo. Busco objetos raros y valiosos de todos los reinos: gemas, armas legendarias, artefactos antiguos. Cada pieza de mi colección tiene una historia que contar. He dedicado mi vida a encontrar y preservar estos tesoros.\nActualmente estoy buscando libros sobre algunas piedras preciosas raras.");
        cvRoleplay1.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.COLLECTOR, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY: About his collection =====
        ConversationOption cvRoleplay2 = new ConversationOption(10, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Quite an impressive collection.", "Thank you! I've spent decades acquiring these treasures. From ancient elven artifacts to dwarven masterworks, from legendary weapons to the rarest gems ever discovered. Collecting is not merely a hobby - it's a passion, an art form. My father was a merchant, and I inherited his fortune. I chose to invest it in beauty and history.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Uma coleção bastante impressionante.", "Obrigado! Passei décadas adquirindo esses tesouros. De artefatos élficos antigos a obras-primas anãs, de armas lendárias às gemas mais raras já descobertas. Colecionar não é meramente um hobby - é uma paixão, uma forma de arte. Meu pai era mercador, e herdei sua fortuna. Escolhi investí-la em beleza e história.");
        cvRoleplay2.addOptionText(SPANISH, "Una colección bastante impresionante.", "¡Gracias! He pasado décadas adquiriendo estos tesoros. Desde artefactos élficos antiguos hasta obras maestras enanas, desde armas legendarias hasta las gemas más raras jamás descubiertas. Coleccionar no es meramente un pasatiempo, es una pasión, una forma de arte. Mi padre era comerciante y heredé su fortuna. Elegí invertirla en belleza e historia.");
        cvRoleplay2.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.COLLECTOR, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay2);

        // ===== QUEST: Collector - Introduction =====
        ConversationOption cvQuest1 = new ConversationOption(10, 1);
        cvQuest1.addOptionText(ENGLISH, "Are you looking for new pieces for your collection?", "*Eyes light up with interest*\nAlways! A true collector never stops searching. Are you an adventurer? Someone who travels to dangerous places, explores forgotten ruins, delves into ancient mines? If so, you might be exactly the person I need.");
        cvQuest1.addOptionText(PORTUGUESE, "Está procurando novas peças para sua coleção?", "*Olhos brilham com interesse*\nSempre! Um verdadeiro colecionador nunca para de procurar. Você é um aventureiro? Alguém que viaja para lugares perigosos, explora ruínas esquecidas, mergulha em minas antigas? Se sim, você pode ser exatamente a pessoa que preciso.");
        cvQuest1.addOptionText(SPANISH, "¿Estás buscando nuevas piezas para tu colección?", "*Los ojos brillan con interés*\n¡Siempre! Un verdadero coleccionista nunca deja de buscar. ¿Eres un aventurero? ¿Alguien que viaja a lugares peligrosos, explora ruinas olvidadas, se adentra en minas antiguas? Si es así, podrías ser exactamente la persona que necesito.");
        cvQuest1.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.COLLECTOR, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuest1);

        ConversationOption cvQuest2 = new ConversationOption(1, 2);
        cvQuest2.addOptionText(ENGLISH, "What kind of items are you seeking?", "I'm working on expanding my collection with exceptional rare pieces. I need: two rare gemstones - an Emerald and a Diamond. Also, a Ruby Ring of fine craftsmanship. And finally, two pieces of rare Caltranium armor - a Helmet and Boots. Each must be of RARE quality. I pay well for quality treasures - for each piece you bring, I'll reward you immediately. And when the collection is complete... well, the final reward will be extraordinary.");
        cvQuest2.addOptionText(PORTUGUESE, "Que tipo de itens você está procurando?", "Estou trabalhando em expandir minha coleção com peças raras excepcionais. Preciso de: duas gemas raras - uma Esmeralda e um Diamante. Também, um Anel de Rubi de artesanato fino. E finalmente, duas peças de armadura rara de Caltrânio - um Elmo e Botas. Cada um deve ser de qualidade RARA. Pago bem por tesouros de qualidade - para cada peça que trouxer, recompensarei imediatamente. E quando a coleção estiver completa... bem, a recompensa final será extraordinária.");
        cvQuest2.addOptionText(SPANISH, "¿Qué tipo de objetos estás buscando?", "Estoy trabajando en expandir mi colección con piezas raras excepcionales. Necesito: dos gemas raras: una Esmeralda y un Diamante. También, un Anillo de Rubí de artesanía fina. Y finalmente, dos piezas de armadura rara de Caltranio: un Yelmo y Botas. Cada uno debe ser de calidad RARA. Pago bien por tesoros de calidad: por cada pieza que traigas, te recompensaré inmediatamente. Y cuando la colección esté completa... bueno, la recompensa final será extraordinaria.");
        npc.conversationOptions.add(cvQuest2);

        ConversationOption cvQuest3 = new ConversationOption(2, 0);
        cvQuest3.addOptionText(ENGLISH, "I'll help you complete your collection.", "Excellent! I knew you had the spirit of a true treasure hunter. Start with an Emerald - a beautiful green gem. Bring it to me when you find one, and I'll pay you immediately. Take your time - quality is what matters. Good luck, my friend!");
        cvQuest3.addOptionText(PORTUGUESE, "Vou ajudá-lo a completar sua coleção.", "Excelente! Eu sabia que você tinha o espírito de um verdadeiro caçador de tesouros. Comece com uma Esmeralda - uma bela gema verde. Traga-a para mim quando encontrar uma, e pagarei imediatamente. Tome seu tempo - qualidade é o que importa. Boa sorte, meu amigo!");
        cvQuest3.addOptionText(SPANISH, "Te ayudaré a completar tu colección.", "¡Excelente! Sabía que tenías el espíritu de un verdadero cazador de tesoros. Comienza con una Esmeralda: una hermosa gema verde. Tráemela cuando la encuentres y te pagaré inmediatamente. Tómate tu tiempo: la calidad es lo que importa. ¡Buena suerte, mi amigo!");
        cvQuest3.listeners = (ctx, currentFragment) -> LibQuest.includeQuestToQuestbook(QuestsIds.COLLECTOR, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvQuest3);

        // ===== QUEST: Collector - Part 2 (Deliver Emerald) =====
        ConversationOption cvEmerald = new ConversationOption(0, 3);
        cvEmerald.addOptionText(ENGLISH, "I have an Emerald for your collection.", "*Takes the gem eagerly, examines it with magnifying glass*\nPerfect! Look at that clarity, that deep green color! This is exactly what I needed. \n*Places it carefully in display case*\nHere's your payment, as promised. Now, bring me a Diamond - the rarest gem of all. Take your time finding a perfect specimen.");
        cvEmerald.addOptionText(PORTUGUESE, "Tenho uma Esmeralda para sua coleção.", "*Pega a gema ansiosamente, examina com lupa*\nPerfeito! Olhe essa clareza, essa cor verde profunda! É exatamente o que eu precisava. \n*Coloca cuidadosamente na vitrine*\nAqui está seu pagamento, como prometido. Agora, traga-me um Diamante - a gema mais rara de todas. Tome seu tempo para encontrar um espécime perfeito.");
        cvEmerald.addOptionText(SPANISH, "Tengo una Esmeralda para tu colección.", "*Toma la gema ansiosamente, la examina con lupa*\n¡Perfecto! ¡Mira esa claridad, ese color verde profundo! Es exactamente lo que necesitaba. \n*La coloca cuidadosamente en la vitrina*\nAquí está tu pago, como prometí. Ahora, tráeme un Diamante: la gema más rara de todas. Tómate tu tiempo para encontrar un espécimen perfecto.");
        cvEmerald.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.COLLECTOR, 1)) {
                boolean hasEmerald = LibInventory.checkHasItemAmount(ItemsIds.EMERALD, 1, chara);
                if (hasEmerald) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvEmerald);

        ConversationOption cvEmeraldReward = new ConversationOption(3, 0);
        cvEmeraldReward.addOptionText(ENGLISH, "[Accept payment]", "8 pieces of gold and a good wine, enjoy...\nOne down, four to go! Each piece brings me closer to perfection.");
        cvEmeraldReward.addOptionText(PORTUGUESE, "[Aceitar pagamento]", "8 moedas de ouro e um bom vinho, aproveite...\nUma pronta, faltam quatro! Cada peça me aproxima da perfeição.");
        cvEmeraldReward.addOptionText(SPANISH, "[Aceptar pago]", "8 monedas de oro y un buen vino, disfruta...\n¡Una hecha, faltan cuatro! Cada pieza me acerca a la perfección.");
        cvEmeraldReward.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.EMERALD, 1, App.getPlayerChar());
            App.getPlayerChar().addGold(8);
            LibInventory.addToInventory(ItemsIds.WINE, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.COLLECTOR, 2, App.getPlayerChar(), ctx);
            currentFragment.updateTopDisplay();
        };
        npc.conversationOptions.add(cvEmeraldReward);

        // ===== QUEST: Collector - Part 3 (Deliver Diamond) =====
        ConversationOption cvDiamond = new ConversationOption(0, 4);
        cvDiamond.addOptionText(ENGLISH, "I have a Diamond for your collection.", "*Hands tremble with emotion*\nBy the gods... a diamond! A REAL diamond! \n*Takes it reverently*\nDo you understand what you've brought me? This is perfection crystallized! The rarest treasure! \n*Places it in the center of the display*\nBeautiful! Here's your reward. Now, I need a Ruby Ring - exquisite jewelry with ruby gem. Find me one!");
        cvDiamond.addOptionText(PORTUGUESE, "Tenho um Diamante para sua coleção.", "*Mãos tremem de emoção*\nPelos deuses... um diamante! Um diamante DE VERDADE! \n*Pega com reverência*\nVocê entende o que me trouxe? Isso é perfeição cristalizada! O tesouro mais raro! \n*Coloca no centro da vitrine*\nLindo! Aqui está sua recompensa. Agora, preciso de um Anel de Rubi - joia requintada com gema de rubi. Encontre um para mim!");
        cvDiamond.addOptionText(SPANISH, "Tengo un Diamante para tu colección.", "*Las manos tiemblan de emoción*\n¡Por los dioses... un diamante! ¡Un diamante REAL! \n*Lo toma con reverencia*\n¿Entiendes lo que me has traído? ¡Esto es perfección cristalizada! ¡El tesoro más raro! \n*Lo coloca en el centro de la vitrina*\n¡Hermoso! Aquí está tu recompensa. Ahora, necesito un Anillo de Rubí: joyería exquisita con gema de rubí. ¡Encuéntrame uno!");
        cvDiamond.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.COLLECTOR, 2)) {
                boolean hasDiamond = LibInventory.checkHasItemAmount(ItemsIds.DIAMOND, 1, chara);
                if (hasDiamond) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvDiamond);

        ConversationOption cvDiamondReward = new ConversationOption(4, 0);
        cvDiamondReward.addOptionText(ENGLISH, "[Accept payment]", "Another 8 pieces of pure gold coins and a nice mead, enjoy!\nTwo masterpieces acquired! Three more to go!");
        cvDiamondReward.addOptionText(PORTUGUESE, "[Aceitar pagamento]", "Mais 8 moedas de ouro puro e um bom hidromel, aproveite!\nDuas obras-primas adquiridas! Faltam mais três!");
        cvDiamondReward.addOptionText(SPANISH, "[Aceptar pago]", "¡Otras 8 monedas de oro puro y un buen hidromiel, disfruta!\n¡Dos obras maestras adquiridas! ¡Faltan tres más!");
        cvDiamondReward.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.DIAMOND, 1, App.getPlayerChar());
            App.getPlayerChar().addGold(8);
            LibInventory.addToInventory(ItemsIds.MEAD_POTION, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.COLLECTOR, 3, App.getPlayerChar(), ctx);
            currentFragment.updateTopDisplay();
        };
        npc.conversationOptions.add(cvDiamondReward);

        // ===== QUEST: Collector - Part 4 (Deliver Ruby Ring) =====
        ConversationOption cvRing = new ConversationOption(0, 5);
        cvRing.addOptionText(ENGLISH, "I have a Ruby Ring for your collection.", "*Eyes widen with delight*\nMagnificent! Such exquisite craftsmanship! \n*Examines the ring carefully*\nThe ruby shines with inner fire, and the metalwork is impeccable. This is a masterpiece of jewelry! \n*Places it in a special display*\nPerfect! Here's your reward. Now, the armor pieces - bring me a Caltranium Helmet. These are forged by master smiths and quite rare.");
        cvRing.addOptionText(PORTUGUESE, "Tenho um Anel de Rubi para sua coleção.", "*Olhos se arregalam de prazer*\nMagnífico! Que artesanato requintado! \n*Examina o anel cuidadosamente*\nO rubi brilha com fogo interior, e o trabalho em metal é impecável. Esta é uma obra-prima de joalheria! \n*Coloca em uma vitrine especial*\nPerfeito! Aqui está sua recompensa. Agora, as peças de armadura - traga-me um Elmo de Caltrânio. São forjados por mestres ferreiros e bem raros.");
        cvRing.addOptionText(SPANISH, "Tengo un Anillo de Rubí para tu colección.", "*Los ojos se abren con deleite*\n¡Magnífico! ¡Qué artesanía exquisita! \n*Examina el anillo cuidadosamente*\nEl rubí brilla con fuego interior, y el trabajo en metal es impecable. ¡Esta es una obra maestra de joyería! \n*Lo coloca en una vitrina especial*\n¡Perfecto! Aquí está tu recompensa. Ahora, las piezas de armadura: tráeme un Yelmo de Caltranio. Son forjados por maestros herreros y bastante raros.");
        cvRing.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.COLLECTOR, 3)) {
                boolean hasRing = LibInventory.checkHasItemAmount(ItemsIds.RUBY_RING, 1, chara);
                if (hasRing) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRing);

        ConversationOption cvRingReward = new ConversationOption(5, 0);
        cvRingReward.addOptionText(ENGLISH, "[Accept payment]", "You got 15 coins and I got a shinning ring.\nThree treasures secured! Two more pieces!");
        cvRingReward.addOptionText(PORTUGUESE, "[Aceitar pagamento]", "Você recebeu 15 moedas e eu fiquei com um anel brilhante.\nTrês tesouros garantidos! Faltam duas peças!");
        cvRingReward.addOptionText(SPANISH, "[Aceptar pago]", "Tú tienes 15 monedas y yo tengo un anillo brillante.\n¡Tres tesoros asegurados! ¡Faltan dos piezas!");
        cvRingReward.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.RUBY_RING, 1, App.getPlayerChar());
            App.getPlayerChar().addGold(15);
            LibQuest.updateQuest(QuestsIds.COLLECTOR, 4, App.getPlayerChar(), ctx);
            currentFragment.updateTopDisplay();
        };
        npc.conversationOptions.add(cvRingReward);

        // ===== QUEST: Collector - Part 5 (Deliver Caltranium Helmet) =====
        ConversationOption cvHelmet = new ConversationOption(0, 6);
        cvHelmet.addOptionText(ENGLISH, "I have a Caltranium Helmet for your collection.", "*Examines the helmet carefully*\nExquisite! Look at the metalwork, the engravings! Caltranium is one of the finest metals, and this helmet shows the skill of a master smith. \n*Places it on a special stand*\nPerfect! Now, one final piece - Caltranium Boots to complete the armor set. Find me a pair, and your work will be complete!");
        cvHelmet.addOptionText(PORTUGUESE, "Tenho um Elmo de Caltrânio para sua coleção.", "*Examina o elmo cuidadosamente*\nPrimoroso! Olhe o trabalho em metal, as gravuras! Caltrânio é um dos melhores metais, e este elmo mostra a habilidade de um mestre ferreiro. \n*Coloca em um suporte especial*\nPerfeito! Agora, uma peça final - Botas de Caltrânio para completar o conjunto de armadura. Encontre um par para mim, e seu trabalho estará completo!");
        cvHelmet.addOptionText(SPANISH, "Tengo un Yelmo de Caltranio para tu colección.", "*Examina el yelmo cuidadosamente*\n¡Exquisito! ¡Mira el trabajo en metal, los grabados! El Caltranio es uno de los mejores metales, y este yelmo muestra la habilidad de un maestro herrero. \n*Lo coloca en un soporte especial*\n¡Perfecto! Ahora, una pieza final: Botas de Caltranio para completar el conjunto de armadura. ¡Encuéntrame un par y tu trabajo estará completo!");
        cvHelmet.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.COLLECTOR, 4)) {
                boolean hasHelmet = LibInventory.checkHasItemAmount(ItemsIds.CALTRANIUM_HELMET, 1, chara);
                if (hasHelmet) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvHelmet);

        ConversationOption cvHelmetReward = new ConversationOption(6, 0);
        cvHelmetReward.addOptionText(ENGLISH, "[Accept payment]", "Gold and magical potion, good, hãh?\nAlmost there! Just the boots remain!");
        cvHelmetReward.addOptionText(PORTUGUESE, "[Aceitar pagamento]", "Ouro e poção mágica, bom, não?\nQuase lá! Só faltam as botas!");
        cvHelmetReward.addOptionText(SPANISH, "[Aceptar pago]", "¡Oro y poción mágica, bien, eh?\n¡Casi llegamos! ¡Solo faltan las botas!");
        cvHelmetReward.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.CALTRANIUM_HELMET, 1, App.getPlayerChar());
            App.getPlayerChar().addGold(18);
            LibInventory.addToInventory(ItemsIds.MP_POTION, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.COLLECTOR, 5, App.getPlayerChar(), ctx);
            currentFragment.updateTopDisplay();
        };
        npc.conversationOptions.add(cvHelmetReward);

        // ===== QUEST: Collector - Part 6 (Deliver Caltranium Boots - FINAL) =====
        ConversationOption cvBoots = new ConversationOption(0, 7);
        cvBoots.addOptionText(ENGLISH, "I have Caltranium Boots for your collection.", "*Takes the boots with both hands*\nRemarkable! Look at this craftsmanship - every detail perfect! This completes my collection! \n*Steps back to admire all pieces together*\nGemstones that sparkle, exquisite jewelry, masterwork armor... You've helped me achieve something extraordinary! My collection is now complete, and it's all thanks to you!");
        cvBoots.addOptionText(PORTUGUESE, "Tenho Botas de Caltrânio para sua coleção.", "*Pega as botas com ambas as mãos*\nNotável! Olhe este artesanato - cada detalhe perfeito! Isto completa minha coleção! \n*Recua para admirar todas as peças juntas*\nGemas que brilham, joias requintadas, armadura de mestre... Você me ajudou a alcançar algo extraordinário! Minha coleção está agora completa, e é tudo graças a você!");
        cvBoots.addOptionText(SPANISH, "Tengo Botas de Caltranio para tu colección.", "*Toma las botas con ambas manos*\n¡Extraordinario! ¡Mira esta artesanía, cada detalle perfecto! ¡Esto completa mi colección! \n*Retrocede para admirar todas las piezas juntas*\nGemas que brillan, joyería exquisita, armadura maestra... ¡Me has ayudado a lograr algo extraordinario! ¡Mi colección está ahora completa, y es todo gracias a ti!");
        cvBoots.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.COLLECTOR, 5)) {
                boolean hasBoots = LibInventory.checkHasItemAmount(ItemsIds.CALTRANIUM_BOOTS, 1, chara);
                if (hasBoots) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvBoots);

        ConversationOption cvBootsReward = new ConversationOption(7, 0);
        cvBootsReward.addOptionText(ENGLISH, "[Accept final payment]", "*Opens a special locked chest*\nHere - your final payment. You've earned every coin and also I will give you one of my potions. This collection will be my legacy. Scholars will study it for generations! Thank you, my friend. You've helped me fulfill a lifelong dream!");
        cvBootsReward.addOptionText(PORTUGUESE, "[Aceitar pagamento final]", "*Abre um baú especial trancado*\nAqui - seu pagamento final. Você mereceu cada moeda e também vou lhe dar uma das minhas poções. Esta coleção será meu legado. Estudiosos a estudarão por gerações! Obrigado, meu amigo. Você me ajudou a realizar um sonho de toda a vida!");
        cvBootsReward.addOptionText(SPANISH, "[Aceptar pago final]", "*Abre un cofre especial cerrado*\nAquí: tu pago final. Te has ganado cada moneda y además te daré una de mis pociones. Esta colección será mi legado. ¡Los eruditos la estudiarán durante generaciones! Gracias, mi amigo. ¡Me has ayudado a cumplir un sueño de toda la vida!");
        cvBootsReward.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.CALTRANIUM_BOOTS, 1, App.getPlayerChar());
            App.getPlayerChar().addGold(25);
            LibInventory.addToInventory(ItemsIds.ELIXIR_POTION, 1, App.getPlayerChar());
            LibQuest.completeQuest(QuestsIds.COLLECTOR, App.getPlayerChar(), 6, ctx);
            currentFragment.updateTopDisplay();
        };
        npc.conversationOptions.add(cvBootsReward);

        // ===== ROLEPLAY: After quest completion =====
        ConversationOption cvAfterQuest = new ConversationOption(0, 0);
        cvAfterQuest.addOptionText(ENGLISH, "How is your collection?", "Perfect! Absolutely perfect! The collection is the centerpiece of the library now. Visitors come from distant kingdoms just to see it. The gemstones sparkle, the jewelry shines, the armor gleams with craftsmanship... You've helped me achieve a lifetime dream. I'll always be grateful for your help, my friend.");
        cvAfterQuest.addOptionText(PORTUGUESE, "Como está sua coleção?", "Perfeita! Absolutamente perfeita! A coleção é agora a peça central da biblioteca. Visitantes vêm de reinos distantes apenas para vê-la. As gemas brilham, as joias reluzem, a armadura resplandece com artesanato... Você me ajudou a realizar um sonho de toda a vida. Sempre serei grato pela sua ajuda, meu amigo.");
        cvAfterQuest.addOptionText(SPANISH, "¿Cómo está tu colección?", "¡Perfecta! ¡Absolutamente perfecta! La colección es ahora la pieza central de la biblioteca. Visitantes vienen de reinos distantes solo para verla. Las gemas brillan, las joyas resplandecen, la armadura reluce con artesanía... Me ayudaste a lograr un sueño de toda la vida. Siempre estaré agradecido por tu ayuda, mi amigo.");
        cvAfterQuest.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.COLLECTOR)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAfterQuest);

        ConversationOption aboutJobOption = new ConversationOption(0, 0);
        aboutJobOption.addOptionText(ENGLISH, "What you do for living?", LibNpc.getAboutJobMsg(npc));
        aboutJobOption.addOptionText(PORTUGUESE, "O que você faz para viver?", LibNpc.getAboutJobMsg(npc));
        aboutJobOption.addOptionText(SPANISH, "¿Que haces para vivir?", LibNpc.getAboutJobMsg(npc));

        npc.conversationOptions.add(aboutJobOption);

        return npc;
    }
}


