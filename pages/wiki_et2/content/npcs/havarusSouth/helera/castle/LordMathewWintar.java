package com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.castle;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.KINGDOMS_CUP;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.NOBLES_BALL;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REBUILD_HELERA;

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

public class LordMathewWintar extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Lord Mathew Wintar");
        npc.age = 55;
        npc.job = Enums.NPCJobs.GOVERNOR;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A very efficient leader, he is appreciated by the people.\nHe acts with seriousness but has moments of good humor.\nHe highly values family.\n\nHis physical traits: Well-groomed beard and mustache with some white hairs. Serious gaze. Light brown hair and blue eyes. Skin showing some age.");
        npc.addDescriptionTranslation(PORTUGUESE, "Líder muito eficiente, tem o apreço do povo.\nAtua com seriedade mas tem momentos de bom humor.\nValoriza muito a família.\n\nSeus traços físicos: Barba e bigode bem feitos com alguns fios brancos. Olhar sério. Cabelos castanho claros e olhos azuis. Pele já com alguma idade.");
        npc.addDescriptionTranslation(SPANISH, "Líder muy eficiente, cuenta con el aprecio del pueblo.\nActúa con seriedad pero tiene momentos de buen humor.\nValora mucho a la familia.\n\nSus rasgos físicos: Barba y bigote bien cuidados con algunas canas. Mirada seria. Cabello castaño claro y ojos azules. Piel que ya muestra cierta edad.");
        npc.canBePickpocketed = true;

        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REBUILD_HELERA, 2)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Welcome to Helera. I am Lord Mathew Wintar, governor of this city. I am truly honored by your presence."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bem-vindo a Helera. Eu sou Lorde Mathew Wintar, governador desta cidade. Estou deveras agraciado com sua presença."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Bienvenido a Helera. Soy Lord Mathew Wintar, gobernador de esta ciudad. Estoy verdaderamente honrado por tu presencia."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("May Helera stand strong."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Que Helera permaneça firme."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Que Helera se mantenga firme."));

        // ===== GENERAL CONVERSATION =====
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "How is Helera doing?", "We've been through difficult times, but the people of Helera are resilient. We will rebuild and become stronger than before.");
        cv1.addOptionText(PORTUGUESE, "Como Helera está?", "Passamos por momentos difíceis, mas o povo de Helera é resiliente. Vamos reconstruir e nos tornaremos mais fortes do que antes.");
        cv1.addOptionText(SPANISH, "¿Cómo está Helera?", "Hemos pasado por momentos difíciles, pero la gente de Helera es resistente. Reconstruiremos y seremos más fuertes que antes.");
        cv1.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.isQuestComplete(chara, REBUILD_HELERA) && LibQuest.charHasQuest(REBUILD_HELERA, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv1);

        ConversationOption cvAfterRebuild = new ConversationOption(0, 0);
        cvAfterRebuild.addOptionText(ENGLISH, "How is Helera doing?", "We worked hard to rebuild Helera. Now everything is improving and our people and our commerce are doing well. My friend, this is truly delightful for our kingdom.");
        cvAfterRebuild.addOptionText(PORTUGUESE, "Como Helera está?", "Trabalhamos muito para renovar Helera. Agora tudo está melhorando e nosso povo e nosso comércio estão bem. Meu caro, isso é deveras agradável para nosso reino.");
        cvAfterRebuild.addOptionText(SPANISH, "¿Cómo está Helera?", "Trabajamos duro para reconstruir Helera. Ahora todo está mejorando y nuestra gente y nuestro comercio están bien. Mi amigo, esto es realmente encantador para nuestro reino.");
        cvAfterRebuild.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, REBUILD_HELERA)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAfterRebuild);

        // ===== ROLEPLAY CONVERSATION =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "How long have you governed Helera?", "I have served as governor for nearly two decades now. When I first arrived, Helera was merely a promising port. Through careful diplomacy and strategic trade agreements, we've grown into a vital hub connecting the northern and southern regions. However, with prosperity comes responsibility - and sometimes, danger. Each day brings new challenges, but seeing our people thrive makes every burden worthwhile.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Há quanto tempo governa Helera?", "Sirvo como governador há quase duas décadas. Quando cheguei pela primeira vez, Helera era apenas um porto promissor. Através de diplomacia cuidadosa e acordos comerciais estratégicos, crescemos e nos tornamos um centro vital conectando as regiões do norte e do sul. Contudo, com prosperidade vem responsabilidade - e às vezes, perigo. Cada dia traz novos desafios, mas ver nosso povo prosperar faz cada fardo valer a pena.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cuánto tiempo lleva gobernando Helera?", "He servido como gobernador durante casi dos décadas. Cuando llegué por primera vez, Helera era apenas un puerto prometedor. A través de una cuidadosa diplomacia y acuerdos comerciales estratégicos, hemos crecido hasta convertirnos en un centro vital que conecta las regiones del norte y del sur. Sin embargo, con la prosperidad viene la responsabilidad - y a veces, el peligro. Cada día trae nuevos desafíos, pero ver a nuestra gente prosperar hace que cada carga valga la pena.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== REBUILD_HELERA PART 1: Initial conversation =====
        ConversationOption cvRebuild1 = new ConversationOption(0, 1);
        cvRebuild1.addOptionText(ENGLISH, "The destruction here is terrible.", "Yes... the dark creatures left devastation in their wake. Buildings collapsed, the harbor is damaged, and many were lost. The people are in despair. We must organize the reconstruction, but morale is low. We need to address the population first.");
        cvRebuild1.addOptionText(PORTUGUESE, "A destruição aqui é terrível.", "Sim... as criaturas das trevas deixaram devastação em seu rastro. Edifícios desabaram, o porto está danificado e muitos se perderam. O povo está em desespero. Precisamos organizar a reconstrução, mas a moral está baixa. Precisamos falar com a população primeiro.");
        cvRebuild1.addOptionText(SPANISH, "La destrucción aquí es terrible.", "Sí... las criaturas oscuras dejaron devastación a su paso. Los edificios se derrumbaron, el puerto está dañado y muchos se perdieron. La gente está desesperada. Debemos organizar la reconstrucción, pero la moral está baja. Necesitamos dirigirnos primero a la población.");
        cvRebuild1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REBUILD_HELERA, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRebuild1);

        ConversationOption cvRebuild1b = new ConversationOption(1, 0);
        cvRebuild1b.addOptionText(ENGLISH, "Let's go speak with them together.", "Good idea. Come with me to the gardens. The people gather there. Together we can inspire them and organize the work ahead. Let's go.");
        cvRebuild1b.addOptionText(PORTUGUESE, "Vamos falar com eles juntos.", "Boa ideia. Venha comigo aos jardins. O povo se reúne lá. Juntos podemos inspirá-los e organizar o trabalho pela frente. Vamos lá.");
        cvRebuild1b.addOptionText(SPANISH, "Vamos a hablar con ellos juntos.", "Buena idea. Ven conmigo a los jardines. La gente se reúne allí. Juntos podemos inspirarlos y organizar el trabajo por delante. Vamos.");
        cvRebuild1b.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(REBUILD_HELERA, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvRebuild1b);

        // ===== REBUILD_HELERA PART 3: After talking to Queen =====
        ConversationOption cvRebuild3 = new ConversationOption(0, 2);
        cvRebuild3.addOptionText(ENGLISH, "I spoke with Queen Enola about help.", "Excellent! What did she say? Will the kingdom provide assistance?");
        cvRebuild3.addOptionText(PORTUGUESE, "Falei com a Rainha Enola sobre ajuda.", "Excelente! O que ela disse? O reino vai fornecer assistência?");
        cvRebuild3.addOptionText(SPANISH, "Hablé con la Reina Enola sobre ayuda.", "¡Excelente! ¿Qué dijo? ¿El reino proporcionará asistencia?");
        cvRebuild3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REBUILD_HELERA, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRebuild3);

        ConversationOption cvRebuild3b = new ConversationOption(2, 0);
        cvRebuild3b.addOptionText(ENGLISH, "Yes, she authorized heavy carts from the royal stables.", "That's wonderful news! With those carts, we can clear the debris and transport building materials efficiently. The queen's support means a great deal to Helera. Now, go speak with James at the city gates in Monelix - he'll coordinate with the stable master to prepare the carts. Once you confirm the carts are ready, we can begin the heavy work of reconstruction.");
        cvRebuild3b.addOptionText(PORTUGUESE, "Sim, ela autorizou carroças pesadas dos estábulos reais.", "Que notícia maravilhosa! Com essas carroças, podemos limpar os escombros e transportar materiais de construção com eficiência. O apoio da rainha significa muito para Helera. Agora, vá falar com James nos portões da cidade em Monelix - ele coordenará com o mestre dos estábulos para preparar as carroças. Depois de confirmar que as carroças estão prontas, podemos começar o trabalho pesado de reconstrução.");
        cvRebuild3b.addOptionText(SPANISH, "Sí, ella autorizó carretas pesadas de los establos reales.", "¡Qué noticia maravillosa! Con esas carretas, podemos limpiar los escombros y transportar materiales de construcción eficientemente. El apoyo de la reina significa mucho para Helera. Ahora, ve a hablar con James en las puertas de la ciudad en Monelix - él coordinará con el maestro de establos para preparar las carretas. Una vez que confirmes que las carretas están listas, podemos comenzar el trabajo pesado de reconstrucción.");
        // No listener needed - quest already advanced by Queen Enola
        npc.conversationOptions.add(cvRebuild3b);

        // ===== REBUILD_HELERA PART 5: Receiving building materials =====
        ConversationOption cvRebuild5 = new ConversationOption(0, 0);
        cvRebuild5.addOptionText(ENGLISH, "I've brought building materials.", "Wonderful! Let me see... Rocks, planks, and ropes - exactly what we need for reconstruction. These materials will help rebuild the damaged houses. The people will be grateful. With these supplies and willing hands, we can restore Helera to its former glory.");
        cvRebuild5.addOptionText(PORTUGUESE, "Trouxe materiais de construção.", "Maravilhoso! Deixe-me ver... Pedras, tábuas e cordas - exatamente o que precisamos para a reconstrução. Esses materiais ajudarão a reconstruir as casas danificadas. O povo ficará grato. Com esses suprimentos e mãos dispostas, podemos restaurar Helera à sua glória anterior.");
        cvRebuild5.addOptionText(SPANISH, "He traído materiales de construcción.", "¡Maravilloso! Déjame ver... Piedras, tablas y cuerdas - exactamente lo que necesitamos para la reconstrucción. Estos materiales ayudarán a reconstruir las casas dañadas. La gente estará agradecida. Con estos suministros y manos dispuestas, podemos restaurar Helera a su gloria anterior.");
        cvRebuild5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REBUILD_HELERA, 5)) {
                // Validate items before showing option
                boolean hasStones = LibInventory.checkHasItemAmount(ItemsIds.ROCK, 5, chara);
                boolean hasPlanks = LibInventory.checkHasItemAmount(ItemsIds.PLANK, 5, chara);
                boolean hasRopes = LibInventory.checkHasItemAmount(ItemsIds.ROPE, 5, chara);

                if (hasStones && hasPlanks && hasRopes) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvRebuild5.listeners = (ctx, currentFragment) -> {
            // Validate items
            boolean hasStones = LibInventory.checkHasItemAmount(ItemsIds.ROCK, 5, App.getPlayerChar());
            boolean hasPlanks = LibInventory.checkHasItemAmount(ItemsIds.PLANK, 5, App.getPlayerChar());
            boolean hasRopes = LibInventory.checkHasItemAmount(ItemsIds.ROPE, 5, App.getPlayerChar());

            if (hasStones && hasPlanks && hasRopes) {
                // Remove items from inventory
                LibInventory.removeFromInventory(ItemsIds.ROCK, 5, App.getPlayerChar());
                LibInventory.removeFromInventory(ItemsIds.PLANK, 5, App.getPlayerChar());
                LibInventory.removeFromInventory(ItemsIds.ROPE, 5, App.getPlayerChar());

                // Update quest to part 6
                LibQuest.updateQuest(REBUILD_HELERA, 6, App.getPlayerChar(), ctx);
            }
        };
        npc.conversationOptions.add(cvRebuild5);

        // ===== QUEST: Kingdoms Cup - Part 4 =====
        ConversationOption cvKingdomsCup1 = new ConversationOption(0, 50);
        cvKingdomsCup1.addOptionText(ENGLISH, "A young man is organizing a sporting tournament between all cities and kingdoms.", "A sporting tournament? That's quite ambitious.\n\n*Looks interested but cautious*\n\nWhat sport are we discussing? And tell me - who else has already committed to this venture?");
        cvKingdomsCup1.addOptionText(PORTUGUESE, "Um jovem está organizando um torneio esportivo entre todas as cidades e reinos.", "Um torneio esportivo? Isso é bastante ambicioso.\n\n*Parece interessado mas cauteloso*\n\nQue esporte estamos discutindo? E conte-me - quem mais já se comprometeu com este empreendimento?");
        cvKingdomsCup1.addOptionText(SPANISH, "Un joven está organizando un torneo deportivo entre todas las ciudades y reinos.", "¿Un torneo deportivo? Eso es bastante ambicioso.\n\n*Parece interesado pero cauteloso*\n\n¿De qué deporte estamos hablando? Y cuéntame: ¿quién más ya se ha comprometido con este emprendimiento?");
        cvKingdomsCup1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.KINGDOMS_CUP, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvKingdomsCup1);

        ConversationOption cvKingdomsCup2 = new ConversationOption(50, 0);
        cvKingdomsCup2.addOptionText(ENGLISH, "Mob Ball! Lord Markus, Lady Jade, and King Oliver have all accepted.", "*Stands up with enthusiasm*\n\nMob Ball! That's perfect - passionate, physical, uniting! And Markus, Jade, and even King Oliver agreed? If all of them see the value in this, then it must be truly worthwhile!\n\n*Nods decisively*\n\nA sporting competition bringing all cities and kingdoms together would boost morale tremendously and show our resilience to the world. Helera accepts! Tell the organizer that Lord Mathew Wintar gives his full support!");
        cvKingdomsCup2.addOptionText(PORTUGUESE, "Mob Ball! Lorde Markus, Lady Jade e Rei Oliver aceitaram.", "*Levanta-se com entusiasmo*\n\nMob Ball! Isso é perfeito - apaixonado, físico, unificador! E Markus, Jade e até o Rei Oliver concordaram? Se todos eles veem o valor nisso, então deve realmente valer a pena!\n\n*Acena decisivamente*\n\nUma competição esportiva unindo todas as cidades e reinos elevaria o moral tremendamente e mostraria nossa resiliência ao mundo. Helera aceita! Diga ao organizador que Lorde Mathew Wintar dá seu total apoio!");
        cvKingdomsCup2.addOptionText(SPANISH, "¡Mob Ball! Lord Markus, Lady Jade y el Rey Oliver han aceptado.", "*Se levanta con entusiasmo*\n\n¡Mob Ball! Eso es perfecto: apasionado, físico, unificador. ¿Y Markus, Jade e incluso el Rey Oliver aceptaron? ¡Si todos ellos ven el valor en esto, entonces debe valer realmente la pena!\n\n*Asiente con decisión*\n\nUna competición deportiva uniendo todas las ciudades y reinos elevaría la moral tremendamente y mostraría nuestra resiliencia al mundo. ¡Helera acepta! ¡Dile al organizador que Lord Mathew Wintar da su total apoyo!");
        cvKingdomsCup2.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(KINGDOMS_CUP, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvKingdomsCup2);

        // ========================================
        // QUEST: NOBLE'S BALL
        // ========================================

        // Part 4: Invite Lord Mathew Wintar
        ConversationOption cvBallPart4 = new ConversationOption(0, 0);
        cvBallPart4.addOptionText(ENGLISH, "Lord Mathew, I have an invitation for the Noble's Ball at Monelix Castle.",
                "*He smiles warmly*\nA ball! My sister Jade always did have a flair for organizing these grand events. It will be good to see the family gathered in Monelix. \n\nI will certainly attend, and I'll make sure to notify my brothers, Markus and Mukas, as well. We Wintars wouldn't miss such a celebration for anything. Thank you for bringing this personally.");
        cvBallPart4.addOptionText(PORTUGUESE, "Lorde Mathew, tenho um convite para o Baile de Nobres no Castelo de Monelix.",
                "*Ele sorri calorosamente*\nUm baile! Minha irmã Jade sempre teve um talento especial para organizar esses grandes eventos. Será bom ver a família reunida em Monelix. \n\nEu certamente comparecerei, e farei questão de avisar meus irmãos, Markus e Mukas, também. Nós, os Wintar, não perderíamos tal celebração por nada. Obrigado por trazer isso pessoalmente.");
        cvBallPart4.addOptionText(SPANISH, "Lord Mathew, tengo una invitación para el Baile de Nobles en el Castillo de Monelix.",
                "*Sonríe con calidez*\n¡Un baile! Mi hermana Jade siempre tuvo un don para organizar estos grandes eventos. Será bueno ver a la familia reunida en Monelix. \n\nCiertamente asistiré, y me aseguraré de notificar a mis hermanos, Markus y Mukas, también. Los Wintar no nos perderíamos una celebración así por nada. Gracias por traer esto personalmente.");
        cvBallPart4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, NOBLES_BALL, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvBallPart4.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(NOBLES_BALL, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBallPart4);

        return npc;
    }
}