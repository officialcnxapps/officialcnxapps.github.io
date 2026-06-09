package com.cnx.endlesstalestwo.data.npcs.lisport.Forge;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.knowledges.KnowledgesIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibNpc;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Nubia extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, nubia());
    }

    Npc nubia() {
        Npc npc = new Npc("Nubia");
        npc.age = 26;
        npc.job = Enums.NPCJobs.FEMALE_BLACKSMITH;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "An innovative woman who doesn't worry about what others think.\nLearned about life from her father and became a brave artisan and blacksmith.\nNever backs down to anyone and is always helpful.\n\nPhysical traits: Pale skin and delicate face. Clear grey eyes and thin eyebrows. Long brown hair always tied back.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma mulher inovadora que não se preocupa com o que pensam os outros.\nAprendeu sobre a vida com o pai e se tornou uma corajosa artesã e ferreira.\nNão baixa a cabeça para ninguém e é sempre prestativa.\n\nSeus taços físicos: Pele pálida e rosto fino. Olhos cinza claros e sobrancelha fina. Cabelos castanhos longos e sempre amarrados.");
        npc.addDescriptionTranslation(SPANISH, "Una mujer innovadora que no se preocupa por lo que piensan los demás.\nAprendió sobre la vida de su padre y se convirtió en una valiente artesana y herradora.\nNunca cede ante nadie y siempre es servicial.\n\nTrasos físicos: Piel pálida y cara delicada. Ojos gris claro y cejas finas. Cabello largo castaño siempre atado hacia atrás.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Welcome!"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bem-vindo"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Bienvenido"));

        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "So, what do you do?", LibNpc.getAboutJobMsg(npc));
        cv1.addOptionText(PORTUGUESE, "Então, o que mesmo você faz?", LibNpc.getAboutJobMsg(npc));
        cv1.addOptionText(SPANISH, "Entonces, ¿qué haces?", LibNpc.getAboutJobMsg(npc));

        ConversationOption cv3 = new ConversationOption(1, 0);
        cv3.addOptionText(ENGLISH, "A female blacksmith, do men trust your work?", "I know what you mean, a lot of prejudice, right? Sometimes it is hard, but I learned my job from my father and I do it very well. The merchants from Lisport trust my products, so I can lift my head and continue my work calmly.");
        cv3.addOptionText(PORTUGUESE, "Uma ferreira, os homens confiam no seu trabalho?", "Eu sei o que você quer dizer, tem muito preconceito, né? Às vezes é difícil, mas aprendi meu trabalho com meu pai e faço-o muito bem. Os comerciantes de Lisport confiam nos meus produtos, por isso posso levantar a cabeça e continuar o meu trabalho com tranquilidade.");
        cv3.addOptionText(SPANISH, "Mujer herrera, ¿los hombres confían en tu trabajo?", "Sé lo que quieres decir, hay muchos prejuicios, ¿no? A veces es duro, pero aprendí mi trabajo de mi padre y lo hago muy bien. Los comerciantes de Lisport confían en mis productos, así que puedo levantar la cabeza y continuar con mi trabajo con tranquilidad.");

        ConversationOption cv2 = new ConversationOption(0, 2);
        cv2.addOptionText(ENGLISH, "Is your work hard to learn?", "Some people say it is a gift from life. But I think that everybody can at least learn the basics. Craft and forge products are not extremely complex.");
        cv2.addOptionText(PORTUGUESE, "Seu trabalho é difícil de aprender?", "Algumas pessoas dizem que é um presente da vida. Mas eu acho que todos podem aprender pelo menos o básico. Produtos artesanais e forjados não são extremamente complexos.");
        cv2.addOptionText(SPANISH, "¿Es difícil aprender tu trabajo?", "Algunas personas dicen que es un regalo de la vida, pero yo creo que todo el mundo puede aprender al menos los conceptos básicos. Los productos de artesanía y forja no son extremadamente complejos.");
        cv2.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar().hasKnowledge(KnowledgesIds.CRAFTING) || LibQuest.charHasQuest(QuestsIds.LEARNING_CRAFT, App.getPlayerChar())) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        ConversationOption cv4 = new ConversationOption(2, 3);
        cv4.addOptionText(ENGLISH, "I would like learn.", "Really? Want me to teach you the basics?");
        cv4.addOptionText(PORTUGUESE, "Eu gostaria de aprender.", "Sério? Quer que eu te ensine o básico?");
        cv4.addOptionText(SPANISH, "Me gustaria aprender.", "¿En serio? ¿Quieres que te enseñe lo básico?");

        ConversationOption cv5 = new ConversationOption(3, 4);
        cv5.addOptionText(ENGLISH, "Yes.", "Great, I like that you trust me to teach you the basics about crafting. It will take some time, but let's go.");
        cv5.addOptionText(PORTUGUESE, "Sim", "Ótimo, eu gosto que você confie em mim para lhe ensinar o básico sobre artesanato. Vai levar algum tempo, mas vamos lá.");
        cv5.addOptionText(SPANISH, "Sí", "Genial, me gusta que confíes en mí para enseñarte los conceptos básicos de las manualidades. Tomará algo de tiempo, pero vamos.");
        cv5.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.LEARNING_CRAFT, App.getPlayerChar(), ctx);
        };

        ConversationOption cv6 = new ConversationOption(3, 0);
        cv6.addOptionText(ENGLISH, "Not now.", "Alright, you decide.");
        cv6.addOptionText(PORTUGUESE, "Agora não", "Tudo bem, você decide.");
        cv6.addOptionText(SPANISH, "Ahora no", "Está bien, tú decides.");

        //TRADUZIR
        ConversationOption cv7 = new ConversationOption(4, 0);
        cv7.addOptionText(ENGLISH, "What should I do first?", "You can start by getting some raw materials that we can use for experiments.\nA good armor, for example, will need at least an iron ingot, and for that we need 2 iron ores.");
        cv7.addOptionText(PORTUGUESE, "O que devo fazer primeiro?", "Você pode começar conseguindo algumas matérias-primas que podemos usar para experimentos.\nUma boa armadura, por exemplo, precisará de pelo menos um lingote de ferro, e para isso precisamos de 2 minérios de ferro.");
        cv7.addOptionText(SPANISH, "¿Qué debo hacer primero?", "Puedes comenzar obteniendo algunas materias primas que podemos usar para experimentos.\nUna buena armadura, por ejemplo, necesitará al menos un lingote de hierro, y para eso necesitamos 2 minerales de hierro.");

        ConversationOption cv8 = new ConversationOption(0, 0);
        cv8.addOptionText(ENGLISH, "I have the ores.", "Good, good. Now, I will teach you the basic of the basics, that is melt an ore to create an ingot.\n<Some Explanations>\nNow, do it yourself, melt the ores.");
        cv8.addOptionText(PORTUGUESE, "Eu tenho os minérios.", "Bom, muito bom. Agora, vou te ensinar o básico do básico, que é derreter um minério para criar um lingote.\n<Algumas explicações>\nAgora, faça você mesmo, derreta os minérios.");
        cv8.addOptionText(SPANISH, "Tengo los minerales.", "Bien, bien. Ahora, te enseñaré lo básico de lo básico, que es fundir un mineral para crear un lingote.\n<Algunas explicaciones>\nAhora, hazlo tú mismo, funde los minerales.");
        cv8.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null
                    && LibInventory.checkHasItemAmount(ItemsIds.IRON_ORE, 2, App.getPlayerChar())
                    && LibQuest.isCharacterAtQuestPart(App.getPlayerChar(), QuestsIds.LEARNING_CRAFT, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv8.listeners = (ctx, currentFragment) -> {
            App.getPlayerChar().addKnowledge(App.DataManager.getKnowledge(KnowledgesIds.CRAFTING));
            LibQuest.updateQuest(QuestsIds.LEARNING_CRAFT, 2, App.getPlayerChar(), ctx);
        };

        ConversationOption cv9 = new ConversationOption(0, 5);
        cv9.addOptionText(ENGLISH, "Here, I have the iron ingot.", "[PLAYERNAME], great, you worked very well.");
        cv9.addOptionText(PORTUGUESE, "Aqui, eu tenho o lingote de ferro.", "[PLAYERNAME], ótimo, você trabalhou muito bem.");
        cv9.addOptionText(SPANISH, "Aquí, tengo el lingote de hierro.", "[PLAYERNAME], excelente, has trabajado muy bien.");
        cv9.requirementValidations = (chara, ctx) -> {
            if (App.getPlayerChar() != null
                    && LibInventory.checkHasItem(ItemsIds.IRON_INGOT, App.getPlayerChar())
                    && LibQuest.isCharacterAtQuestPart(App.getPlayerChar(), QuestsIds.LEARNING_CRAFT, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv10 = new ConversationOption(5, 6);
        cv10.addOptionText(ENGLISH, "What is next?", "Now, I will share with you some tips and knowledges about crafting and you will be ready to go.\n<She passed 3 hours teaching you>");
        cv10.addOptionText(PORTUGUESE, "O que vem a seguir?", "Agora, vou compartilhar com você algumas dicas e conhecimentos sobre artesanato e você estará pronto para começar.\n<Ela passou 3 horas te ensinando>");
        cv10.addOptionText(SPANISH, "¿Qué sigue ahora?", "Ahora, compartiré contigo algunos consejos y conocimientos sobre la artesanía y estarás listo para comenzar.\n<Ella pasó 3 horas enseñándote>");
        cv10.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.IRON_INGOT, 1, App.getPlayerChar());
            App.Shell.flowManager.updateInGameTime(180, false, ctx);
            LibQuest.completeQuest(QuestsIds.LEARNING_CRAFT, App.getPlayerChar(), 3, ctx);
        };

        ConversationOption cv11 = new ConversationOption(6, 0);
        cv11.addOptionText(ENGLISH, "Thanks Nubia, now I know how to craft.", "Yes, you know. Now, you can try many combinations of materials to craft products, clothes, armors and weapons.");
        cv11.addOptionText(PORTUGUESE, "Obrigado Nubia, agora eu sei como criar.", "Sim, você sabe. Agora, você pode tentar muitas combinações de materiais para criar produtos, roupas, armaduras e armas.");
        cv11.addOptionText(SPANISH, "Gracias Nubia, ahora sé cómo elaborar.", "Sí, lo sabes. Ahora puedes probar muchas combinaciones de materiales para elaborar productos, ropa, armaduras y armas.");

        npc.conversationOptions.add(cv1);
        npc.conversationOptions.add(cv2);
        npc.conversationOptions.add(cv3);
        npc.conversationOptions.add(cv4);
        npc.conversationOptions.add(cv5);
        npc.conversationOptions.add(cv6);
        npc.conversationOptions.add(cv7);
        npc.conversationOptions.add(cv8);
        npc.conversationOptions.add(cv9);
        npc.conversationOptions.add(cv10);
        npc.conversationOptions.add(cv11);

        return npc;
    }
}

