package com.cnx.endlesstalestwo.data.npcs.lisport.Farms;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.enums.Enums.QuestStatus.COMPLETED;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibNpc;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Herald extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, herald());
    }

    Npc herald() {
        Npc npc = new Npc("Herald");
        npc.age = 48;
        npc.job = Enums.NPCJobs.MALE_FARMER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A good friend. Loyal to family and work.\nContent with little, very hardworking despite his intellectual limitations.\nMarried to Madelaine, has 2 children.\n\nPhysical traits: Clear eyes, thick eyebrows. Well-groomed and grey beard like his hair. Skin weathered from working in the sun.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um bom amigo. Fiel a família, ao trabalho.\nSe contenta com pouco, muito esforçado apesar das suas limitações intelectuais.\nCasado com Madelaine, possui 2 filhos.\n\nSeus taços físicos: Olhos claros, sobrancelha espessa. Barba bem feita e grisalha como seu cabelo. Pele sofrida por trabalhar no sol.");
        npc.addDescriptionTranslation(SPANISH, "Un buen amigo. Leal a la familia y al trabajo.\nContento con poco, muy trabajador a pesar de sus limitaciones intelectuales.\nCasado con Madelaine, tiene 2 hijos.\n\nTrasos físicos: Ojos claros, cejas espesas. Barba bien cuidada grisácea como su cabello. Piel dañada por trabajar bajo el sol.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hello, [PLAYERNAME]"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá, [PLAYERNAME]"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola, [PLAYERNAME]"));

        npc.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.UNDER_ATTACK);
            if (requiredQuest != null && (requiredQuest.getCurrentPartOrder() > 2 || requiredQuest.status.equals(COMPLETED))) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Refresh my mind, what do you do?", LibNpc.getAboutJobMsg(npc));
        cv1.addOptionText(PORTUGUESE, "Refresque minha memória, o que você faz?", LibNpc.getAboutJobMsg(npc));
        cv1.addOptionText(SPANISH, "Refresca mi memoria, ¿qué haces?", LibNpc.getAboutJobMsg(npc));


        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "How are you feeling?", "Very well, my friend. I have a job and a family, all good.");
        cv2.addOptionText(PORTUGUESE, "Como está se sentindo?", "Muito bem, meu amigo. Tenho um emprego e uma família, tudo bem.");
        cv2.addOptionText(SPANISH, "¿Cómo te estás sintiendo?", "Muy bien, amigo mío. Tengo un trabajo y una familia, todo bien.");

        ConversationOption cv3 = new ConversationOption(0, 0);
        cv3.addOptionText(ENGLISH, "So [NPC_NAME], what could we do to improve our lives?", "[PLAYERNAME], be realistic... we are mere commoners, we don't even know how to read. We don't have many better chances than we currently have.");
        cv3.addOptionText(PORTUGUESE, "Então [NPC_NAME], o que poderíamos fazer para melhorar de vida?", "[PLAYERNAME], seja realista... somos meros plebeus, nem sequer sabemos ler. Não temos muitas chances melhores do que temos atualmente.");
        cv3.addOptionText(SPANISH, "Entonces [NPC_NAME], ¿qué podríamos hacer para mejorar nuestras vidas?", "[PLAYERNAME], sé realista... somos simples plebeyos, ni siquiera sabemos leer. No tenemos muchas mejores oportunidades que las que tenemos actualmente.");

        ConversationOption cv4 = new ConversationOption(0, 1);
        cv4.addOptionText(ENGLISH, "You don't know how to read, do you?", "I really would like to know, but I hadn't have opportunity when I was a child and now as an adult I don't have gold nor time to it. Are you interested in learning?");
        cv4.addOptionText(PORTUGUESE, "Você não sabe ler, não é?", "Eu realmente gostaria de saber, mas não tive oportunidade quando era criança e agora, como adulto, não tenho ouro nem tempo para isso. Você tem interesse em aprender?");
        cv4.addOptionText(SPANISH, "No sabes leer ¿verdad?", "Realmente me gustaría saberlo, pero no tuve oportunidad cuando era niña y ahora que soy adulta no tengo ni el oro ni el tiempo para ello. ¿Te interesa aprender?");
        cv4.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.I_WANT_TO_READ);
            if (requiredQuest != null && (requiredQuest.getCurrentPartOrder() == 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv5 = new ConversationOption(1, 0);
        cv5.addOptionText(ENGLISH, "Yes, I think it would be really useful.", "For sure it is. I heard that Klaus, the old man that lives near the shores, know how to read and write, he teached many bourgeois. If you have time and gold, you should talk to him.");
        cv5.addOptionText(PORTUGUESE, "Sim, acho que seria muito útil.", "Com certeza é. Ouvi dizer que Klaus, o velho que mora perto das margens, sabe ler e escrever, ele ensinou muitos burgueses. Se você tem tempo e ouro, você deveria falar com ele.");
        cv5.addOptionText(SPANISH, "Sí, creo que sería realmente útil.", "Seguro que lo es. He oído que Klaus, el anciano que vive cerca de los bancos, sabe leer y escribir, enseñó a muchos burgueses. Si tienes tiempo y oro, deberías hablar con él.");
        cv5.listeners = (ctx, fragment) -> LibQuest.updateQuest(QuestsIds.I_WANT_TO_READ, 2, App.getPlayerChar(), ctx);

        npc.conversationOptions.add(cv1);
        npc.conversationOptions.add(cv2);
        npc.conversationOptions.add(cv3);
        npc.conversationOptions.add(cv4);
        npc.conversationOptions.add(cv5);

        return npc;
    }
}
