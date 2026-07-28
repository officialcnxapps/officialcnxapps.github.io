package com.cnx.endlesstalestwo.data.npcs.havarusNorth.farmland;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.DEFEND_FARMLAND;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.GIVING_ORDERS;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REBUILD_FARMLAND;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REINFORCE_FARMLAND;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.WAZEL_BATTLE;

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

public class Larien extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Larien");
        npc.age = 28;
        npc.job = Enums.NPCJobs.FEMALE_FARMER;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "This young woman is firmer and more serious than her innocent appearance suggests.\nShe works hard and manages the crops very well.\nLively, dedicated and calm.\nHer physical traits: Pale skin, brown hair and thin eyebrows. Thin nose, blue eyes with a serene expression.");
        npc.addDescriptionTranslation(PORTUGUESE, "Essa moça é mais firme e séria do que sua aparência inocente sugere.\nTrabalha com afinco e comanda muito bem as lavouras.\nAnimada, dedicada e tranquila.\nSeus traços físicos: Pele pálida, cabelos castanhos e sobrancelha fina. Nariz fino, olhos azuis com expressão serena.");
        npc.addDescriptionTranslation(SPANISH, "Esta joven es más firme y seria de lo que su apariencia inocente sugiere.\nTrabaja con ahínco y gestiona muy bien los cultivos.\nAnimada, dedicada y tranquila.\nSus rasgos físicos: Piel pálida, cabello castaño y cejas finas. Nariz fina, ojos azules con expresión serena.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hello there! Welcome to Farmland."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá! Bem-vindo a Farmland."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("¡Hola! Bienvenido a Farmland."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Take care!"));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Cuide-se!"));
        npc.byeMessages.put(SPANISH, Collections.singletonList("¡Cuídate!"));

        // ===== CONVERSATION OPTION 2: About GIVING_ORDERS Quest Part 1 =====
        ConversationOption cv2 = new ConversationOption(0, 1);
        cv2.addOptionText(ENGLISH, "I'm here about the defenses for Farmland.", "Thank goodness you're here! The situation is getting worse. Those dark creatures have been spotted near our fields, and we're vulnerable. Our farmers are scared, and production is already suffering. We desperately need protection.");
        cv2.addOptionText(PORTUGUESE, "Estou aqui sobre as defesas para Farmland.", "Graças aos céus que você está aqui! A situação está piorando. Aquelas criaturas das trevas foram avistadas perto de nossos campos, e estamos vulneráveis. Nossos fazendeiros estão com medo e a produção já está sofrendo. Precisamos desesperadamente de proteção.");
        cv2.addOptionText(SPANISH, "Estoy aquí sobre las defensas para Farmland.", "¡Gracias a Dios que estás aquí! La situación está empeorando. Esas criaturas oscuras han sido avistadas cerca de nuestros campos, y estamos vulnerables. Nuestros granjeros están asustados, y la producción ya está sufriendo. Necesitamos desesperadamente protección.");
        cv2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, GIVING_ORDERS, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(1, 2);
        cv3.addOptionText(ENGLISH, "What exactly do you need?", "We need soldiers stationed here - at least a dozen guards to patrol the fields and protect the workers. But soldiers alone aren't enough. We need defensive structures built - barricades, fortifications, watchtowers. The open fields make us vulnerable to attacks from any direction. Without proper defenses and extra manpower, we won't be able to harvest this season's crops, and that means famine for the kingdom.");
        cv3.addOptionText(PORTUGUESE, "Do que exatamente você precisa?", "Precisamos de soldados estacionados aqui - pelo menos uma dúzia de guardas para patrulhar os campos e proteger os trabalhadores. Mas só soldados não são suficientes. Precisamos de estruturas defensivas construídas - barricadas, fortificações, torres de vigia. Os campos abertos nos deixam vulneráveis a ataques de qualquer direção. Sem defesas adequadas e mão de obra extra, não conseguiremos colher a safra desta temporada, e isso significa fome para o reino.");
        cv3.addOptionText(SPANISH, "¿Qué necesitas exactamente?", "Necesitamos soldados estacionados aquí - al menos una docena de guardias para patrullar los campos y proteger a los trabajadores. Pero los soldados solos no son suficientes. Necesitamos estructuras defensivas construidas - barricadas, fortificaciones, torres de vigilancia. Los campos abiertos nos hacen vulnerables a ataques desde cualquier dirección. Sin defensas adecuadas y mano de obra adicional, no podremos cosechar los cultivos de esta temporada, y eso significa hambruna para el reino.");
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(2, 0);
        cv4.addOptionText(ENGLISH, "I understand. I'll report this to Guzar.", "Please hurry. Every day without protection is another day we risk losing everything. The farmers are counting on you.");
        cv4.addOptionText(PORTUGUESE, "Entendo. Vou reportar isso para Guzar.", "Por favor, se apresse. Cada dia sem proteção é outro dia que arriscamos perder tudo. Os fazendeiros estão contando com você.");
        cv4.addOptionText(SPANISH, "Entiendo. Informaré esto a Guzar.", "Por favor, date prisa. Cada día sin protección es otro día en el que corremos el riesgo de perderlo todo. Los granjeros cuentan contigo.");
        cv4.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(GIVING_ORDERS, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv4);

        // ===== QUEST 19.A: Provide Provisions =====
        ConversationOption cvProvisions = new ConversationOption(0, 0);
        cvProvisions.addOptionText(ENGLISH, "The kingdom is reinforcing Helera. I need supplies for them.", "Helera needs our help - that makes sense. We have this season's harvest stored up. I can spare some provisions - grain, dried vegetables, and preserved meat. Take what you need. Helera won't survive a siege without food. These provisions will sustain their troops and population during the defense.");
        cvProvisions.addOptionText(PORTUGUESE, "O reino está reforçando Helera. Eu preciso de suprimentos para eles.", "Helera precisa da nossa ajuda - isso faz sentido. Temos a colheita dessa temporada armazenada. Posso fornecer alguns suprimentos - grão, vegetais secos e carne preservada. Pegue o que precisar. Helera não sobreviverá a um cerco sem comida. Esses suprimentos vão sustentar as tropas deles e a população durante a defesa.");
        cvProvisions.addOptionText(SPANISH, "El reino está reforzando Helera. Necesito suministros para ellos.", "Helera necesita nuestra ayuda - eso tiene sentido. Tenemos la cosecha de esta temporada almacenada. Puedo proporcionar algunos suministros - grano, verduras secas y carne conservada. Toma lo que necesites. Helera no sobrevivirá a un asedio sin comida. Estos suministros mantendrán sus tropas y población durante la defesa.");
        cvProvisions.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.REINFORCE_HELERA, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvProvisions.listeners = (ctx, currentFragment) -> {
            // Give provisions to player
            LibInventory.addToInventory(ItemsIds.HELERA_PROVISIONS, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.REINFORCE_HELERA, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvProvisions);

        // ===== QUEST 19.B: Receive Building Materials =====
        ConversationOption cvMaterials = new ConversationOption(0, 8);
        cvMaterials.addOptionText(ENGLISH, "I've gathered materials for defensive fortifications.", "Perfect! Let me see what you have... ");
        cvMaterials.addOptionText(PORTUGUESE, "Consegui materiais para fortificações defensivas.", "Perfeito! Deixe-me ver o que você tem... ");
        cvMaterials.addOptionText(SPANISH, "He reunido materiales para fortificaciones defensivas.", "¡Perfecto! Dejame ver lo que tienes... ");
        cvMaterials.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REINFORCE_FARMLAND, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvMaterials);

        // Response if player HAS all items
        ConversationOption cvMaterialsSuccess = new ConversationOption(8, 14);
        cvMaterialsSuccess.addOptionText(ENGLISH, "[Give materials]", "Planks, spears, and rocks - exactly what we need! These will be used to build barricades and reinforce our positions. Now we have the materials, but...");
        cvMaterialsSuccess.addOptionText(PORTUGUESE, "[Entregar materiais]", "Tábuas, lanças e pedras - exatamente o que precisamos! Estes serão usados para construir barricadas e reforçar nossas posições. Agora temos os materiais, mas...");
        cvMaterialsSuccess.addOptionText(SPANISH, "[Entregar materiales]", "¡Tablas, lanzas y piedras - exactamente lo que necesitamos! Estos se utilizarán para construir barricadas y reforzar nuestras posiciones. Ahora tenemos los materiales, pero...");
        cvMaterialsSuccess.requirementValidations = (chara, ctx) -> {
            boolean hasPlanks = LibInventory.checkHasItemAmount(ItemsIds.PLANK, 5, chara);
            boolean hasSpears = LibInventory.checkHasItemAmount(ItemsIds.WOODEN_SPEAR, 7, chara);
            boolean hasStones = LibInventory.checkHasItemAmount(ItemsIds.ROCK, 5, chara);

            if (hasPlanks && hasSpears && hasStones) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvMaterialsSuccess);

        // Follow-up conversation about needing a builder
        ConversationOption cvNeedBuilder = new ConversationOption(14, 0);
        cvNeedBuilder.addOptionText(ENGLISH, "But what?", "We need someone skilled to actually build these defenses. None of our farmers have the expertise for proper fortifications.\n...\nWait... I remember someone! Hingus, from Monelix - he's a handyman who can build almost anything. He helped us repair the windmill last year. If anyone can construct solid defenses with these materials, it's him. Would you go to Monelix and ask him to come help us? You'll find him at the clock tower.");
        cvNeedBuilder.addOptionText(PORTUGUESE, "Mas o quê?", "Precisamos de alguém habilidoso para realmente construir essas defesas. Nenhum de nossos fazendeiros tem a expertise para fortificações adequadas.\n...\nEspere... eu me lembro de alguém! Hingus, de Monelix - ele é um faz-tudo que pode construir quase qualquer coisa. Ele nos ajudou a consertar o moinho de vento no ano passado. Se alguém pode construir defesas sólidas com esses materiais, é ele. Você poderia ir até Monelix e pedir para ele vir nos ajudar? Você o encontrará na torre do relógio.");
        cvNeedBuilder.addOptionText(SPANISH, "¿Pero qué?", "Necesitamos a alguien capacitado para construir realmente estas defensas. Ninguno de nuestros granjeros tiene la experiencia para fortificaciones adecuadas.\n...\nEspera... ¡recuerdo a alguien! Hingus, de Monelix - es un manitas que puede construir casi cualquier cosa. Nos ayudó a reparar el molino de viento el año pasado. Si alguien puede construir defensas sólidas con estos materiales, es él. ¿Podrías ir a Monelix y pedirle que venga a ayudarnos? Lo encontrarás en la torre del reloj.");
        cvNeedBuilder.listeners = (ctx, currentFragment) -> {
            // Remove items from inventory
            LibInventory.removeFromInventory(ItemsIds.PLANK, 5, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.WOODEN_SPEAR, 7, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.ROCK, 5, App.getPlayerChar());

            LibQuest.updateQuest(REINFORCE_FARMLAND, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvNeedBuilder);

        // Response if player DOES NOT have all items
        ConversationOption cvMaterialsFail = new ConversationOption(8, 0);
        cvMaterialsFail.addOptionText(ENGLISH, "[Check materials]", "Hmm... You don't have everything we need yet. Remember, we need 5 Planks, 7 Wooden Spears, and 5 Rocks. Please gather all the materials before returning.");
        cvMaterialsFail.addOptionText(PORTUGUESE, "[Verificar materiais]", "Hmm... Você ainda não tem tudo que precisamos. Lembre-se, precisamos de 5 Tábuas, 7 Lanças de Madeira e 5 Pedras. Por favor, reúna todos os materiais antes de voltar.");
        cvMaterialsFail.addOptionText(SPANISH, "[Verificar materiales]", "Hmm... Aún no tienes todo lo que necesitamos. Recuerda, necesitamos 5 Tablones, 7 Lanzas de Madera y 5 Piedras. Por favor, reúne todos los materiales antes de volver.");
        cvMaterialsFail.requirementValidations = (chara, ctx) -> {
            boolean hasPlanks = LibInventory.checkHasItemAmount(ItemsIds.PLANK, 5, chara);
            boolean hasSpears = LibInventory.checkHasItemAmount(ItemsIds.WOODEN_SPEAR, 7, chara);
            boolean hasStones = LibInventory.checkHasItemAmount(ItemsIds.ROCK, 5, chara);

            if (!hasPlanks || !hasSpears || !hasStones) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvMaterialsFail);

        // ===== QUEST 19.B: Part 4 - Everything Ready, Need More Warriors =====
        ConversationOption cvReinforcePart4 = new ConversationOption(0, 13);
        cvReinforcePart4.addOptionText(ENGLISH, "How are the defenses coming along?", "Hingus and his team are already working on the fortifications. The soldiers you sent are patrolling the fields. Everything is progressing well, but... I have concerns.");
        cvReinforcePart4.addOptionText(PORTUGUESE, "Como estão indo as defesas?", "Hingus e sua equipe já estão trabalhando nas fortificações. Os soldados que você enviou estão patrulhando os campos. Tudo está progredindo bem, mas... tenho preocupações.");
        cvReinforcePart4.addOptionText(SPANISH, "¿Cómo van las defensas?", "Hingus y su equipo ya están trabajando en las fortificaciones. Los soldados que enviaste están patrullando los campos. Todo está progresando bien, pero... tengo preocupaciones.");
        cvReinforcePart4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REINFORCE_FARMLAND, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvReinforcePart4);

        ConversationOption cvReinforcePart4Response = new ConversationOption(13, 0);
        cvReinforcePart4Response.addOptionText(ENGLISH, "What concerns?", "The number of soldiers and our defenses... they might not be enough if a large force attacks. Farmland is vast and open - we need more warriors to cover all vulnerable points. I've heard that Wazel has skilled mercenaries who could help us. They're expensive, but the kingdom should be able to afford it. Will you travel to Wazel and hire them? Talk to Danjor at the tower - he leads the warriors there.");
        cvReinforcePart4Response.addOptionText(PORTUGUESE, "Que preocupações?", "O número de soldados e nossas defesas... podem não ser suficientes se uma grande força atacar. Farmland é vasta e aberta - precisamos de mais guerreiros para cobrir todos os pontos vulneráveis. Ouvi dizer que Wazel tem mercenários habilidosos que poderiam nos ajudar. São caros, mas o reino deveria poder pagar. Você viajará para Wazel e os contratará? Fale com Danjor na torre - ele lidera os guerreiros de lá.");
        cvReinforcePart4Response.addOptionText(SPANISH, "¿Qué preocupaciones?", "El número de soldados y nuestras defensas... podrían no ser suficientes si una gran fuerza ataca. Farmland es vasta y abierta - necesitamos más guerreros para cubrir todos los puntos vulnerables. He oído que Wazel tiene mercenarios hábiles que podrían ayudarnos. Son caros, pero el reino debería poder pagarlos. ¿Viajarás a Wazel y los contratarás? Habla con Danjor en la torre - él lidera a los guerreros allí.");
        cvReinforcePart4Response.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(REINFORCE_FARMLAND, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvReinforcePart4Response);

        // ===== CONVERSATION OPTION 5: Status after reporting =====
        ConversationOption cv5 = new ConversationOption(0, 0);
        cv5.addOptionText(ENGLISH, "How are things holding up?", "We're managing, but barely. Every strange sound at night makes us jump. We really hope the kingdom sends help soon. Food security depends on it.");
        cv5.addOptionText(PORTUGUESE, "Como estão as coisas?", "Estamos nos virando, mas mal. Cada som estranho à noite nos faz pular. Realmente esperamos que o reino envie ajuda em breve. A segurança alimentar depende disso.");
        cv5.addOptionText(SPANISH, "¿Cómo van las cosas?", "Estamos aguantando, pero apenas. Cada sonido extraño por la noche nos hace saltar. Realmente esperamos que el reino envíe ayuda pronto. La seguridad alimentaria depende de ello.");
        cv5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, GIVING_ORDERS, 2) ||
                    LibQuest.isCharacterAtQuestPart(chara, GIVING_ORDERS, 3)
                            && !LibQuest.isQuestComplete(chara, GIVING_ORDERS)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv5);

        // ===== ROLEPLAY: Life in Farmland =====
        ConversationOption cvRoleplayFarmlife = new ConversationOption(0, 7);
        cvRoleplayFarmlife.addOptionText(ENGLISH, "What's life like here in Farmland?", "It's a simple life, but rewarding. We wake before dawn, work the fields until dusk, and fall asleep exhausted. But there's something beautiful about growing food that feeds the entire kingdom. The seasons change, the crops grow, and we feel connected to something greater than ourselves. Of course, it wasn't always peaceful - now with the attacks, things are harder.");
        cvRoleplayFarmlife.addOptionText(PORTUGUESE, "Como é a vida aqui em Farmland?", "É uma vida simples, mas gratificante. Acordamos antes do amanhecer, trabalhamos nos campos até o anoitecer, e dormimos exaustos. Mas há algo lindo em cultivar comida que alimenta o reino inteiro. As estações mudam, as colheitas crescem, e nos sentimos conectados a algo maior que nós mesmos. Claro, nem sempre foi pacífico - agora com os ataques, as coisas ficaram mais difíceis.");
        cvRoleplayFarmlife.addOptionText(SPANISH, "¿Como es la vida aquí en Farmland?", "Es una vida simple, pero gratificante. Nos despertamos antes del amanecer, trabajamos en los campos hasta el anochecer, y nos dormimos agotados. Pero hay algo hermoso en cultivar comida que alimenta el reino entero. Las estaciones cambian, las cosechas crecen, y nos sentimos conectados a algo mayor que nosotros mismos. Por supuesto, no siempre fue pacífico - ahora con los ataques, las cosas son más difíciles.");
        cvRoleplayFarmlife.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(DEFEND_FARMLAND, chara) || LibQuest.charHasQuest(REBUILD_FARMLAND, chara)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cvRoleplayFarmlife);

        ConversationOption cvRoleplayFarmlikeResponse = new ConversationOption(7, 0);
        cvRoleplayFarmlikeResponse.addOptionText(ENGLISH, "It sounds meaningful.", "It is, truly. That's why we fight so hard to protect it. If Farmland falls, it won't just be the loss of crops - it's the loss of a way of life that has sustained this kingdom for generations. I hope you understand how important is our help.");
        cvRoleplayFarmlikeResponse.addOptionText(PORTUGUESE, "Parece significativo.", "É, verdadeiramente. É por isso que lutamos tão duramente para protegê-lo. Se Farmland cair, não será apenas a perda de colheitas - é a perda de um modo de vida que sustentou este reino por gerações. Espero que você entenda como é importante nossa ajuda.");
        cvRoleplayFarmlikeResponse.addOptionText(SPANISH, "Parece significativo.", "Sí, de verdad. Por eso luchamos con tanto ahínco para protegerlo. Si Tierras de Cultivo se derrumba, no solo se perderán las cosechas, sino también un estilo de vida que ha sustentado este reino durante generaciones. Espero que comprendan lo importante que es nuestra ayuda.");
        npc.conversationOptions.add(cvRoleplayFarmlikeResponse);

        // ===== ROLEPLAY: After Defend Farmland =====
        ConversationOption cvRoleplayAfterDefense = new ConversationOption(0, 0);
        cvRoleplayAfterDefense.addOptionText(ENGLISH, "How are things here after the battle?", "Things feel much safer now, thanks to you. The dark creatures have been driven back, and our people are starting to breathe easier. We're finally able to return to our work in the fields without constant fear. But we must remain vigilant - those creatures came from the shadows once, and they could return. We need to stay alert and keep our defenses strong while we rebuild what was damaged.");
        cvRoleplayAfterDefense.addOptionText(PORTUGUESE, "Como estão as coisas aqui após a batalha?", "As coisas estão muito mais seguras agora, graças a você. As criaturas das trevas foram rechaçadas, e nosso povo está começando a respirar mais aliviado. Finalmente conseguimos retornar ao nosso trabalho nos campos sem medo constante. Mas devemos permanecer vigilantes - essas criaturas vieram das sombras uma vez, e podem retornar. Precisamos ficar alertas e manter nossas defesas fortes enquanto reconstruímos o que foi danificado.");
        cvRoleplayAfterDefense.addOptionText(SPANISH, "¿Cómo están las cosas aquí después de la batalla?", "Las cosas se sienten mucho más seguras ahora, gracias a ti. Las criaturas oscuras han sido rechazadas, y nuestra gente está empezando a respirar más tranquila. Finalmente podemos volver a nuestro trabajo en los campos sin miedo constante. Pero debemos permanecer vigilantes - esas criaturas vinieron de las sombras una vez, y podrían regresar. Necesitamos estar alerta y mantener nuestras defensas fuertes mientras reconstruimos lo que fue dañado.");
        cvRoleplayAfterDefense.requirementValidations = (chara, ctx) -> {
            boolean defendComplete = LibQuest.isQuestComplete(chara, DEFEND_FARMLAND);
            boolean hasWazelQuest = LibQuest.charHasQuest(WAZEL_BATTLE, chara);

            if (defendComplete && !hasWazelQuest) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplayAfterDefense);

        // ===== QUEST 21.A: Defend Farmland - Part 1 (Roleplay) =====
        ConversationOption cvDefend1 = new ConversationOption(0, 0);
        cvDefend1.addOptionText(ENGLISH, "I'm here to defend Farmland.", "Thank the gods you're here! The creatures are upon us. We must organize a defensive line immediately. We already locked a creature in the tavern!");
        cvDefend1.addOptionText(PORTUGUESE, "Estou aqui para defender Farmland.", "Graças aos deuses que você está aqui! As criaturas estão sobre nós. Devemos organizar uma linha defensiva imediatamente. Nós já trancamos uma criatura na taverna!");
        cvDefend1.addOptionText(SPANISH, "Estoy aquí para defender Farmland.", "¡Gracias a los dioses que estás aquí! Las criaturas están sobre nosotros. Debemos organizar una línea defensiva inmediatamente. Nosotros encerramos a una criatura en la taberna!");
        cvDefend1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, DEFEND_FARMLAND, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvDefend1);

        // ===== QUEST 21.A: Defend Farmland - Part 3 =====
        ConversationOption cvDefend3 = new ConversationOption(0, 10);
        cvDefend3.addOptionText(ENGLISH, "We fought them off!", "Yes, but we cannot rest yet! I can see more of them regrouping to the north. They're preparing another attack. We need to strike now while they're vulnerable! Are you ready to push them back?");
        cvDefend3.addOptionText(PORTUGUESE, "Nós os repelimos!", "Sim, mas não podemos descansar ainda! Posso ver mais deles se reagrupando ao norte. Eles estão preparando outro ataque. Precisamos atacar agora enquanto estão vulneráveis! Você está pronto para empurrá-los de volta?");
        cvDefend3.addOptionText(SPANISH, "¡Los repelimos!", "¡Sí, pero no podemos descansar aún! Puedo ver más de ellos reagrupándose al norte. Están preparando otro ataque. ¡Necesitamos atacar ahora mientras están vulnerables! ¿Estás listo para empujarlos hacia atrás?");
        cvDefend3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, DEFEND_FARMLAND, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvDefend3.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(DEFEND_FARMLAND, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvDefend3);

        ConversationOption cvDefend3Response = new ConversationOption(10, 0);
        cvDefend3Response.addOptionText(ENGLISH, "Let's take the fight to them!", "Good! Head to the Cemetery north of here. We'll catch them off-guard and end this threat once and for all!");
        cvDefend3Response.addOptionText(PORTUGUESE, "Vamos levar a luta para eles!", "Bom! Vá até o Cemitério ao norte daqui. Vamos pegá-los de surpresa e acabar com essa ameaça de uma vez por todas!");
        cvDefend3Response.addOptionText(SPANISH, "¡Llevemos la lucha a ellos!", "¡Bien! Dirígete al Cementerio al norte de aquí. ¡Los atraparemos desprevenidos e terminaremos con esta amenaza de una vez por todas!");
        npc.conversationOptions.add(cvDefend3Response);

        // ===== QUEST 21.B: Rebuild Farmland - Part 1 =====
        ConversationOption cvRebuild1 = new ConversationOption(0, 11);
        cvRebuild1.addOptionText(ENGLISH, "I came to help rebuild Farmland.", "Thank you for coming. The destruction here is... overwhelming. Houses collapsed, fields burned, livestock killed. Many good people lost their lives defending this land. We need to rebuild, but we don't have enough hands. Most of our workers are dead or too injured to help.");
        cvRebuild1.addOptionText(PORTUGUESE, "Vim ajudar a reconstruir Farmland.", "Obrigado por vir. A destruição aqui é... avassaladora. Casas desabaram, campos queimados, gado morto. Muitas pessoas boas perderam suas vidas defendendo esta terra. Precisamos reconstruir, mas não temos mãos suficientes. A maioria de nossos trabalhadores está morta ou muito ferida para ajudar.");
        cvRebuild1.addOptionText(SPANISH, "Vine a ayudar a reconstruir Farmland.", "Gracias por venir. La destrucción aquí es... abrumadora. Casas derrumbadas, campos quemados, ganado muerto. Muchas buenas personas perdieron la vida defendiendo esta tierra. Necesitamos reconstruir, pero no tenemos suficientes manos. La mayoría de nuestros trabajadores están muertos o demasiado heridos para ayudar.");
        cvRebuild1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.REBUILD_FARMLAND, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvRebuild1.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.REBUILD_FARMLAND, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvRebuild1);

        ConversationOption cvRebuild1Response = new ConversationOption(11, 0);
        cvRebuild1Response.addOptionText(ENGLISH, "I'll get help from the kingdom.", "Please do. Talk to Queen Enola. We need soldiers and workers from other regions. Without help, Farmland will take years to recover, if it ever does. The kingdom depends on us for food - they must understand how critical this is.");
        cvRebuild1Response.addOptionText(PORTUGUESE, "Vou buscar ajuda do reino.", "Por favor, faça isso. Fale com a Rainha Enola. Precisamos de soldados e trabalhadores de outras regiões. Sem ajuda, Farmland levará anos para se recuperar, se é que vai. O reino depende de nós para comida - eles devem entender o quão crítico isso é.");
        cvRebuild1Response.addOptionText(SPANISH, "Conseguiré ayuda del reino.", "Por favor, hazlo. Habla con la Reina Enola. Necesitamos soldados y trabajadores de otras regiones. Sin ayuda, Farmland tardará años en recuperarse, si es que lo hace. El reino depende de nosotros para la comida - deben entender lo crítico que es esto.");
        npc.conversationOptions.add(cvRebuild1Response);

        // ===== QUEST 21.B: Rebuild Farmland - Part 5 =====
        ConversationOption cvRebuild5 = new ConversationOption(0, 12);
        cvRebuild5.addOptionText(ENGLISH, "I've brought soldiers and workers to help.", "Excellent! With this help, we can start the reconstruction immediately. But there's another problem - food. Farmland usually provides most of the kingdom's food supply. With our fields destroyed, we can't produce enough. We've written letters to all cities with farms, asking for food and resources to be sent to the capital.");
        cvRebuild5.addOptionText(PORTUGUESE, "Trouxe soldados e trabalhadores para ajudar.", "Excelente! Com essa ajuda, podemos começar a reconstrução imediatamente. Mas há outro problema - comida. Farmland geralmente fornece a maior parte do suprimento de alimentos do reino. Com nossos campos destruídos, não podemos produzir o suficiente. Escrevemos cartas para todas as cidades com fazendas, pedindo que alimentos e recursos sejam enviados para a capital.");
        cvRebuild5.addOptionText(SPANISH, "He traído soldados y trabajadores para ayudar.", "¡Excelente! Con esta ayuda, podemos comenzar la reconstrucción de inmediato. Pero hay otro problema: comida. Farmland generalmente proporciona la mayor parte del suministro de alimentos del reino. Con nuestros campos destruidos, no podemos producir lo suficiente. Hemos escrito cartas a todas las ciudades con granjas, pidiendo que se envíen alimentos y recursos a la capital.");
        cvRebuild5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.REBUILD_FARMLAND, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvRebuild5.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.REBUILD_FARMLAND, 6, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvRebuild5);

        ConversationOption cvRebuild5Response = new ConversationOption(12, 0);
        cvRebuild5Response.addOptionText(ENGLISH, "I'll deliver the letters.", "Thank you. Take them to James at the gates of Monelix. He'll organize the distribution to all the farming cities. Tell him it's urgent - the kingdom's food supply depends on it. And... thank you, truly. Without your help, Farmland might not have survived this.");
        cvRebuild5Response.addOptionText(PORTUGUESE, "Vou entregar as cartas.", "Obrigado. Leve-as para James nos portões de Monelix. Ele organizará a distribuição para todas as cidades agrícolas. Diga a ele que é urgente - o suprimento de alimentos do reino depende disso. E... obrigado, de verdade. Sem sua ajuda, Farmland poderia não ter sobrevivido a isso.");
        cvRebuild5Response.addOptionText(SPANISH, "Entregaré las cartas.", "Gracias. Llévalas a James en las puertas de Monelix. Él organizará la distribución a todas las ciudades agrícolas. Dile que es urgente: el suministro de alimentos del reino depende de ello. Y... gracias, de verdad. Sin tu ayuda, Farmland podría no haber sobrevivido a esto.");
        npc.conversationOptions.add(cvRebuild5Response);

        // ===== QUEST: Plague! - Part 2 → Part 3 =====
        ConversationOption cvPlague2 = new ConversationOption(0, 15);
        cvPlague2.addOptionText(ENGLISH, "Helinda said you might know how to make insecticide.", "*Shakes her head apologetically*\nInsecticide? Oh, I wish I knew! Helinda always thinks I know more than I do. Honestly, I've never made insecticide myself. When we have pest problems, I just buy it ready-made from Elisa in Letow. She's much better with these things - been dealing with farm pests her whole life. You should go see her. If anyone can help, it's Elisa!");
        cvPlague2.addOptionText(PORTUGUESE, "Helinda disse que você pode saber como fazer inseticida.", "*Balança a cabeça pedindo desculpas*\nInseticida? Oh, eu queria saber! Helinda sempre acha que sei mais do que sei. Honestamente, nunca fiz inseticida. Quando temos problemas com pragas, apenas compro pronto de Elisa em Letow. Ela é muito melhor com essas coisas - lida com pragas de fazenda a vida toda. Você deveria ir vê-la. Se alguém pode ajudar, é Elisa!");
        cvPlague2.addOptionText(SPANISH, "Helinda dijo que podrías saber cómo hacer insecticida.", "*Sacude la cabeza disculpándose*\n¿Insecticida? ¡Oh, ojalá supiera! Helinda siempre piensa que sé más de lo que sé. Honestamente, nunca he hecho insecticida. Cuando tenemos problemas de plagas, simplemente lo compro listo de Elisa en Letow. Ella es mucho mejor con estas cosas - ha estado lidiando con plagas de granja toda su vida. Deberías ir a verla. Si alguien puede ayudar, ¡es Elisa!");
        cvPlague2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PLAGUE, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPlague2);

        ConversationOption cvPlague2Response = new ConversationOption(15, 0);
        cvPlague2Response.addOptionText(ENGLISH, "I'll go to Letow then. Thank you!", "Good luck! I hope Elisa can help. Those insects are destroying everything - we need to stop them soon or there won't be a harvest this year!");
        cvPlague2Response.addOptionText(PORTUGUESE, "Vou para Letow então. Obrigado!", "Boa sorte! Espero que Elisa possa ajudar. Esses insetos estão destruindo tudo - precisamos pará-los logo ou não haverá colheita este ano!");
        cvPlague2Response.addOptionText(SPANISH, "Iré a Letow entonces. ¡Gracias!", "¡Buena suerte! Espero que Elisa pueda ayudar. Esos insectos están destruyendo todo - ¡necesitamos detenerlos pronto o no habrá cosecha este año!");
        cvPlague2Response.listeners = (ctx, fragment) -> LibQuest.updateQuest(QuestsIds.PLAGUE, 3, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvPlague2Response);

        // ===== CONVERSATION OPTION 1: General Information =====
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What can you tell me about Farmland?", "Farmland is the heart of food production for the entire kingdom. We grow wheat, vegetables, and raise livestock. Without us, the cities would starve. It's hard work, but it's honest and essential.");
        cv1.addOptionText(PORTUGUESE, "O que você pode me dizer sobre Farmland?", "Farmland é o coração da produção de alimentos para todo o reino. Cultivamos trigo, vegetais e criamos animais. Sem nós, as cidades morreriam de fome. É trabalho duro, mas é honesto e essencial.");
        cv1.addOptionText(SPANISH, "¿Qué puedes decirme sobre Farmland?", "Farmland es el corazón de la producción de alimentos para todo el reino. Cultivamos trigo, verduras y criamos ganado. Sin nosotros, las ciudades morirían de hambre. Es trabajo duro, pero es honesto y esencial.");
        npc.conversationOptions.add(cv1);

        // ========================================
        // QUEST: CATTLE BUSINESS
        // ========================================

        // Success Path (Part 33 -> 40)
        ConversationOption cvCattleSuccess = new ConversationOption(0, 21);
        cvCattleSuccess.addOptionText(ENGLISH, "I represent Councilor Murdag of Lisport. I have a contract for cattle trade.", "Lisport? That's an interesting offer. Our livestock is doing well this season, and a new market would be beneficial. Let me see those terms.");
        cvCattleSuccess.addOptionText(PORTUGUESE, "Eu represento o Conselheiro Murdag de Lisport. Tenho um contrato para o comércio de gado.", "Lisport? Essa é uma oferta interessante. Nosso gado está indo bem esta temporada, e um novo mercado seria benéfico. Deixe-me ver esses termos.");
        cvCattleSuccess.addOptionText(SPANISH, "Represento al consejero Murdag de Lisport. Tengo un contrato para el comercio de ganado.", "¿Lisport? Es una oferta interesante. Nuestro ganado va bien esta temporada, y un nuevo mercado sería beneficioso. Déjame ver esas condiciones.");
        cvCattleSuccess.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CATTLE_BUSINESS, 33)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvCattleSuccess);

        ConversationOption cvCattleSign = new ConversationOption(21, 0);
        cvCattleSign.addOptionText(ENGLISH, "The terms are right here.", "Everything looks in order. I'll sign it. We'll start preparing the first herd for transport. Tell Murdag it's a deal.");
        cvCattleSign.addOptionText(PORTUGUESE, "Os termos estão aqui.", "Tudo parece em ordem. Eu assino. Começaremos a preparar o primeiro rebanho para o transporte. Diga a Murdag que está fechado.");
        cvCattleSign.addOptionText(SPANISH, "Las condiciones están aquí.", "Todo parece estar en orden. Lo firmaré. Empezaremos a preparar la primera manada para el transporte. Dile a Murdag que acepto.");
        cvCattleSign.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.CONTRACT_OF_CATTLE_NEGOTIATION, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.CATTLE_BUSINESS, 40, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvCattleSign);

        // Failure Path (Part 22 -> 30)
        ConversationOption cvCattleFail = new ConversationOption(0, 0);
        cvCattleFail.addOptionText(ENGLISH, "I represent Councilor Murdag of Lisport. I have a contract for cattle trade.", "Trade with Lisport? My hands are full with the local demand and the recent attacks. I can't commit to a long-distance contract right now. You'll have to look elsewhere.");
        cvCattleFail.addOptionText(PORTUGUESE, "Eu represento o Conselheiro Murdag de Lisport. Tenho um contrato para o comércio de gado.", "Comércio com Lisport? Minhas mãos estão cheias com a demanda local e os recentes ataques. Não posso me comprometer com um contrato de longa distância agora. Você terá que procurar em outro lugar.");
        cvCattleFail.addOptionText(SPANISH, "Represento al consejero Murdag de Lisport. Tengo un contrato para el comercio de ganado.", "¿Comerciar con Lisport? Tengo mucho trabajo con la demanda local y los ataques recientes. No puedo comprometerme con un contrato a larga distancia ahora mismo. Tendrás que buscar en otra parte.");
        cvCattleFail.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CATTLE_BUSINESS, 22)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvCattleFail.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.CATTLE_BUSINESS, 30, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvCattleFail);

        return npc;
    }
}
