package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.clockTower;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.DESTROY_THE_LAIR;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REINFORCE_FARMLAND;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.WAZEL_BATTLE;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Hingus extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Hingus");
        npc.age = 49;
        npc.job = Enums.NPCJobs.HANDYMAN;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REINFORCE_FARMLAND, 4)
                    || LibQuest.isCharacterAtQuestPart(chara, REINFORCE_FARMLAND, 5)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        ///ABOUT QUEST: DESTROY THE LAIR
        ConversationOption cv2 = new ConversationOption(0, 1);
        cv2.addOptionText(ENGLISH, "Guzar told me to talk to you.", "Captain Guzar, from the army? Must be something important then. What do you need?");
        cv2.addOptionText(PORTUGUESE, "Guzar disse-me para falar com você.", "O capitão Guzar, do exército? Deve ser algo importante então. O que precisa?");
        cv2.addOptionText(SPANISH, "Guzar me dijo que hablara contigo.", "¿El capitán Guzar, del ejército? Debe ser algo importante entonces. ¿Qué necesitas?");
        cv2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, DESTROY_THE_LAIR, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(1, 2);
        cv3.addOptionText(ENGLISH, "Something explosive to destroy a lair.", "Wow, pretty specific, huh? But look, you're really lucky. Just a few days ago I was messing with some gears and mixing oils and other ingredients and I ended up causing a small fire. I think if I put it all together again, but in different quantities, it will cause what you're looking for. Give me a moment...\n<Minutes pass>\nHere, this little box will cause a lot of damage if you light a fire near it.");
        cv3.addOptionText(PORTUGUESE, "Algo explosivo para destruir um covil.", "Nossa, bem específico, não? Mas veja só, você tem mesmo sorte. Ainda há poucos dias atrás estive mexendo com algumas engrenagens e misturando óleos e outros ingredientes e acabei por causar um pequeno incêndio. Creio que se eu juntar tudo de novo, mas em quantidades diferentes vai causar o que você procura. Me dê um tempo...\n<Passam-se minutos>\nAqui, esta pequena caixa vai causar um bom estrago se você acender um fogo perto dela.");
        cv3.addOptionText(SPANISH, "Algo explosivo para destruir una guarida.", "Vaya, bastante específico, ¿eh? Pero mira, tienes mucha suerte. Hace solo unos días estaba jugando con algunos engranajes y mezclando aceites y otros ingredientes y terminé causando un pequeño incendio. Creo que si lo vuelvo a juntar todo, pero en diferentes cantidades, causará lo que estás buscando. Dame un momento...\n<Pasan los minutos>\nAquí, esta pequeña caja causará mucho daño si enciendes un fuego cerca de ella.");
        cv3.listeners = (ctx, currentFragment) -> {
            App.Shell.flowManager.updateInGameTime(20, true, ctx);
            LibInventory.addToInventory(ItemsIds.BOMB_CRATE, 1, App.getPlayerChar());
            LibQuest.updateQuest(DESTROY_THE_LAIR, 6, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(2, 0);
        cv4.addOptionText(ENGLISH, "Thank you", "No problem, helping the royal guard is usually a benefit. Besides, my grandfather was a great soldier, I feel I owe this honor.");
        cv4.addOptionText(PORTUGUESE, "Lhe agradeço", "Não há problemas, ajudar a guarda real costuma ser um benefício. Além de que, meu avô foi um grande soldado, sinto que devo esta honra.");
        cv4.addOptionText(SPANISH, "Gracias", "No hay problema, ayudar a la guardia real suele ser un beneficio. Además, mi abuelo fue un gran soldado, siento que debo este honor.");
        npc.conversationOptions.add(cv4);

        // ===== QUEST 19.B: Hire Constructor for Farmland =====
        ConversationOption cvHire = new ConversationOption(0, 0);
        cvHire.addOptionText(ENGLISH, "Farmland needs defensive structures built urgently. Can you help?", "Farmland? The farmlands? They need structures? In times like these with creatures attacking everywhere, I understand. Building fortifications is different from clock repair, but I've built structures before. Barricades, watchtowers, defensive walls - I can manage that. I'll take my tools and materials and head there immediately.");
        cvHire.addOptionText(PORTUGUESE, "Farmland precisa de estruturas defensivas construídas urgentemente. Você pode ajudar?", "Farmland? As terras agrícolas? Eles precisam de estruturas? Em tempos como estes com criaturas atacando em todos os lugares, entendo. Construir fortificações é diferente de consertar relógios, mas já construí estruturas antes. Barricadas, torres de vigia, muros defensivos - posso gerenciar isso. Vou levar minhas ferramentas e materiais e ir para lá imediatamente.");
        cvHire.addOptionText(SPANISH, "Farmland necesita estructuras defensivas construidas urgentemente. ¿Puedes ayudar?", "¿Farmland? ¿Las tierras de cultivo? ¿Necesitan estructuras? En tiempos como estos com criaturas atacando en todos lados, lo entiendo. Construir fortificaciones es diferente de reparar relojes, pero he construido estructuras antes. Barricadas, torres de vigilancia, muros defensivos - puedo manejarlo. Llevaré mis herramientas y materiales e iré de inmediato.");
        cvHire.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REINFORCE_FARMLAND, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvHire.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(REINFORCE_FARMLAND, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvHire);

        ConversationOption cv5 = new ConversationOption(0, 0);
        cv5.addOptionText(ENGLISH, "Thank you for the defenses in Farmland.", "Oh, no problem! I hope the fortifications I raised actually helped protect the farmers and their harvests. Helping the kingdom helps me and my family as well.");
        cv5.addOptionText(PORTUGUESE, "Obrigado pelas defesas em Farmland.", "Oh, não há de que! Espero que as defesas que construí tenham sido mesmo úteis para proteger os agricultores e suas colheitas. Ajudar o reino ajuda a mim e a minha família também.");
        cv5.addOptionText(SPANISH, "Gracias por las defensas en Farmland.", "¡Oh, no hay de qué! Espero que las defensas que construí hayan sido realmente útiles para proteger a los agricultores y sus cosechas. Ayudar al reino también ayuda a mi familia y a mí.");
        cv5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, REINFORCE_FARMLAND) && !LibQuest.charHasQuest(WAZEL_BATTLE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv5);

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What is it like working here in the clock tower?", "Ah, the clock tower... it's a marvel of engineering, isn't it? Every tick, every tock, a testament to precision. These gears, some as big as a carriage wheel, others smaller than my thumb, all working in perfect harmony. It's a constant symphony of metal and time. Keeps me busy, that's for sure, but there's a certain satisfaction in keeping this old giant ticking along smoothly.");
        cv1.addOptionText(PORTUGUESE, "Como é trabalhar aqui na torre do relógio?", "Ah, a torre do relógio... é uma maravilha da engenharia, não é? Cada tique, cada taque, um testemunho de precisão. Estas engrenagens, algumas tão grandes quanto uma roda de carruagem, outras menores que o meu polegar, todas trabalhando em perfeita harmonia. É uma sinfonia constante de metal e tempo. Mantém-me ocupado, isso é certo, mas há uma certa satisfação em manter este velho gigante a funcionar sem problemas.");
        cv1.addOptionText(SPANISH, "¿Cómo es trabajar aquí en la torre del reloj?", "Ah, la torre del reloj... es una maravilla de la ingeniería, ¿no es así? Cada tic, cada tac, un testimonio de precisión. Estos engranajes, algunos tan grandes como una rueda de carruaje, otros más pequeños que mi pulgar, todos trabajando en perfecta armonía. Es una sinfonía constante de metal y tiempo. Me mantiene ocupado, eso seguro, pero hay una cierta satisfacción en mantener a este viejo gigante funcionando sin problemas.");
        npc.conversationOptions.add(cv1);

        npc.hasRandomizedConversations = true;

        return npc;
    }
}