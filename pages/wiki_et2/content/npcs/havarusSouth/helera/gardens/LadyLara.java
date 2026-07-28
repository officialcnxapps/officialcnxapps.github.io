package com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.gardens;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.FalkerFamily;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class LadyLara extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Lady Lara");
        npc.age = 36;
        npc.job = Enums.NPCJobs.NONE;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A very elegant and refined woman.\nShe is the daughter of Lord Den Falker of Letow.\nDetermined and wise.\n\nHer physical traits: Long blonde hair. Crystal blue eyes. Fair, thin skin.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma mulher muito elegante e refinada.\nÉ filha de Lord Den Falker de Letow.\nDeterminada e sábia.\n\nSeus traços físicos: Cabelos loiros compridos. Olhos azuis cristalinos. Pele fina clara.");
        npc.addDescriptionTranslation(SPANISH, "Una mujer muy elegante y refinada.\nEs hija de Lord Den Falker de Letow.\nDeterminada y sabia.\n\nSus rasgos físicos: Cabello rubio y largo. Ojos azules cristalinos. Piel fina y clara.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Good day to you. The gardens are peaceful today, aren't they?"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bom dia. Os jardins estão calmos hoje, não estão?"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Buenos días. Los jardines están tranquilos hoy, ¿verdad?"));

        npc.generateRandomByes();

        // ========================================
        // ROLEPLAY - General conversations
        // ========================================

        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "You seem content here in the gardens.", "Content? Perhaps. These gardens were my refuge when the family conflict was at its worst. When my father lost our ancestral lands, I spent many days here, watching flowers grow where I could not control anything else. It taught me patience.\n\nI chose to refuse the marriage, and I carry the weight of that choice every day. But I do not regret it.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Você parece contente aqui nos jardins.", "Contente? Talvez. Esses jardins foram meu refúgio quando o conflito familiar estava no seu pior. Quando meu pai perdeu nossas terras ancestrais, passei muitos dias aqui, observando as flores crescerem onde eu não podia controlar mais nada. Me ensinou paciência.\n\nEscolhi recusar o casamento, e carrego o peso dessa escolha todos os dias. Mas não me arrependo.");
        cvRoleplay1.addOptionText(SPANISH, "Pareces contenta aquí en los jardines.", "¿Contenta? Quizás. Estos jardines fueron mi refugio cuando el conflicto familiar estaba en su peor momento. Cuando mi padre perdió nuestras tierras ancestrales, pasé muchos días aquí, viendo crecer flores donde no podía controlar nada más. Me enseñó paciencia.\n\nElegí rechazar el matrimonio y cargo con el peso de esa decisión cada día. Pero no me arrepiento.");
        npc.conversationOptions.add(cvRoleplay1);

        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "What do you think of Helera?", "Helera is my home — its walls, its people, its history. But it is also the city that carries the shadow of the Brant name. Sir Martyn built his prison not far from here. Every time I walk past, I think of what my father lost... and what I refused to give in return.\n\nStill, Helera has good people. People who have nothing to do with the old quarrels of nobles.");
        cvRoleplay2.addOptionText(PORTUGUESE, "O que você pensa de Helera?", "Helera é minha casa — suas paredes, seu povo, sua história. Mas também é a cidade que carrega a sombra do nome Brant. Sir Martyn construiu sua prisão não muito longe daqui. Toda vez que passo por lá, penso no que meu pai perdeu... e no que me recusei a dar em troca.\n\nMesmo assim, Helera tem boas pessoas. Pessoas que nada têm a ver com as velhas querelas dos nobres.");
        cvRoleplay2.addOptionText(SPANISH, "¿Qué opinas de Helera?", "Helera es mi hogar: sus muros, su gente, su historia. Pero también es la ciudad que carga la sombra del nombre Brant. Sir Martyn construyó su prisión no muy lejos de aquí. Cada vez que paso por allí, pienso en lo que mi padre perdió... y en lo que me negué a dar a cambio.\n\nAun así, Helera tiene buena gente. Gente que no tiene nada que ver con las viejas disputas de los nobles.");
        npc.conversationOptions.add(cvRoleplay2);

        // ========================================
        // QUEST: BRANTS_FALKERS — PART 1
        // ========================================

        ConversationOption cvBF1 = new ConversationOption(0, 1);
        cvBF1.addOptionText(ENGLISH, "I witnessed a fight between Brant and Falker servants...", "A fight? Yes... it still happens. That feud has burned for decades and no one can seem to put it out.\n\nI suppose you want to know why. Very well. Sit down, or stand — it doesn't matter. This is a long story, and it begins with me.");
        cvBF1.addOptionText(PORTUGUESE, "Presenciei uma briga entre servos dos Brant e Falker...", "Uma briga? Sim... ainda acontece. Essa rixa queima há décadas e ninguém consegue apagá-la.\n\nImagino que quer saber o porquê. Muito bem. Sente-se, ou fique em pé — não importa. Essa é uma longa história, e começa comigo.");
        cvBF1.addOptionText(SPANISH, "Fui testigo de una pelea entre siervos de los Brant y Falker...", "¿Una pelea? Sí... sigue pasando. Esa disputa lleva décadas ardiendo y nadie parece capaz de apagarla.\n\nImagino que quieres saber el porqué. Muy bien. Siéntate, o quédate de pie: no importa. Esta es una larga historia, y comienza conmigo.");
        cvBF1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANTS_FALKERS, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvBF1);

        ConversationOption cvBF1b = new ConversationOption(1, 0);
        cvBF1b.addOptionText(ENGLISH, "Tell me your side of the story.", "I was promised to Sir Jard Brant. The arrangement suited our fathers, not me. Jard was arrogant, unfaithful, and treated women as possessions. I asked my father to cancel the marriage, and he — bless his gentle soul — agreed.\n\nSir Martyn used that refusal as an excuse to take our family lands through a clause he had buried in the contract. My father was given barren lands in Letow as 'compensation'.\n\nJard blames us for the war that followed and for his father's death. But Sir Martyn chose war, not us. We chose freedom.");
        cvBF1b.addOptionText(PORTUGUESE, "Me conte seu lado da história.", "Fui prometida a Sir Jard Brant. O arranjo convinha a nossos pais, não a mim. Jard era arrogante, infiel, e tratava as mulheres como posses. Pedi ao meu pai que cancelasse o casamento, e ele — bênção para sua alma gentil — concordou.\n\nSir Martyn usou essa recusa como desculpa para tomar as terras da nossa família através de uma cláusula que ele havia enterrado no contrato. Meu pai recebeu terras áridas em Letow como 'compensação'.\n\nJard nos culpa pela guerra que se seguiu e pela morte de seu pai. Mas foi Sir Martyn quem escolheu a guerra, não nós. Nós escolhemos a liberdade.");
        cvBF1b.addOptionText(SPANISH, "Cuéntame tu versión de la historia.", "Me prometieron a Sir Jard Brant. El acuerdo convenía a nuestros padres, no a mí. Jard era arrogante, infiel y trataba a las mujeres como posesiones. Le pedí a mi padre que cancelara el matrimonio, y él — bendita sea su alma amable — aceptó.\n\nSir Martyn usó ese rechazo como excusa para apoderarse de las tierras de nuestra familia a través de una cláusula que había enterrado en el contrato. A mi padre le dieron tierras áridas en Letow como 'compensación'.\n\nJard nos culpa por la guerra que siguió y por la muerte de su padre. Pero fue Sir Martyn quien eligió la guerra, no nosotros. Nosotros elegimos la libertad.");
        cvBF1b.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.BRANTS_FALKERS, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBF1b);

        // ========================================
        // QUEST: BRANTS_FALKERS — PART 4 (Choose Falker Side)
        // ========================================

        ConversationOption cvBF4 = new ConversationOption(0, 2);
        cvBF4.addOptionText(ENGLISH, "I've spoken with everyone. I'd like to help your family.", "You've spoken with Den, then. And Jard too, I presume.\n\nI won't pretend we are without fault. But the Brants manufactured their justification — that contract had a poison clause written to punish us if the marriage fell through.\n\nIf you truly want to help... I won't refuse. But understand that getting involved in this means making enemies of the Brants. Are you certain?");
        cvBF4.addOptionText(PORTUGUESE, "Falei com todos. Gostaria de ajudar a sua família.", "Você falou com Den, então. E com Jard também, presumo.\n\nNão vou fingir que somos sem culpa. Mas os Brant fabricaram sua justificativa — esse contrato tinha uma cláusula venenosa escrita para nos punir se o casamento não acontecesse.\n\nSe você realmente quer ajudar... não recusarei. Mas entenda que se envolver nisso significa fazer inimigos dos Brant. Tem certeza?");
        cvBF4.addOptionText(SPANISH, "He hablado con todos. Me gustaría ayudar a tu familia.", "Has hablado con Den, entonces. Y con Jard también, supongo.\n\nNo voy a fingir que somos inocentes. Pero los Brant fabricaron su justificación: ese contrato tenía una cláusula envenenada escrita para castigarnos si el matrimonio fracasaba.\n\nSi realmente quieres ayudar... no lo rechazaré. Pero entiende que involucrarte en esto significa hacerte enemigo de los Brant. ¿Estás seguro?");
        cvBF4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANTS_FALKERS, 4)
                    && !LibQuest.charHasQuest(QuestsIds.FALKER_FAMILY, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvBF4);

        ConversationOption cvBF4b = new ConversationOption(2, 0);
        cvBF4b.addOptionText(ENGLISH, "Yes. I'll help the Falker family.", "Then you have my gratitude — and my father's, though he is too proud to ask for help himself.\n\nGo speak with him in Letow. He has a plan that requires someone... nimble. Someone the Brants don't know.");
        cvBF4b.addOptionText(PORTUGUESE, "Sim. Vou ajudar a família Falker.", "Então tem minha gratidão — e a de meu pai, embora ele seja orgulhoso demais para pedir ajuda.\n\nVá falar com ele em Letow. Ele tem um plano que requer alguém... ágil. Alguém que os Brant não conhecem.");
        cvBF4b.addOptionText(SPANISH, "Sí. Ayudaré a la familia Falker.", "Entonces tienes mi gratitud — y la de mi padre, aunque él es demasiado orgulloso para pedir ayuda.\n\nVe a hablar con él en Letow. Tiene un plan que requiere a alguien... ágil. Alguien que los Brant no conozcan.");
        cvBF4b.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.BRANTS_FALKERS, App.getPlayerChar(), 44, ctx);
            Quest quest = FalkerFamily.get();
            LibQuest.includeQuestToQuestbook(quest, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBF4b);

        // ========================================
        // QUEST: FALKER_FAMILY — PART 4 (Show Old Brant Contract)
        // ========================================

        ConversationOption cvFF5 = new ConversationOption(0, 3);
        cvFF5.addOptionText(ENGLISH, "I found the original Brant contract.", "What? You found it? Let me see that.\n\n[She reads carefully. Her expression shifts from disbelief to cold fury.]\n\nThis... look at this. Clause seven. The ink is darker — fresher. The handwriting does not match the rest of the document at all.\n\nThis clause was added after the signing. My father's witness mark is on a document that did not contain this condition when he agreed to it. It was forged. Sir Martyn Brant forged it.\n\nThis is the proof I have been searching for. It must reach the kingdom's council. Lady Jade Wintar — she is the counselor in Monelix Castle. She is just. Take this to her.");
        cvFF5.addOptionText(PORTUGUESE, "Encontrei o contrato original dos Brant.", "O quê? Você o encontrou? Deixe-me ver.\n\n[Ela lê com atenção. Sua expressão muda da incredulidade para uma fúria fria.]\n\nIsso... olhe aqui. A cláusula sete. A tinta é mais escura — mais recente. A caligrafia não corresponde ao restante do documento.\n\nEssa cláusula foi acrescentada depois da assinatura. O sinal de testemunha do meu pai está num documento que não continha essa condição quando ele concordou. Foi forjado. Sir Martyn Brant forjou isso.\n\nEsta é a prova que eu estava buscando. Ela precisa chegar ao conselho do reino. Lady Jade Wintar — ela é a conselheira no Castelo de Monelix. Ela é justa. Leve isso a ela.");
        cvFF5.addOptionText(SPANISH, "Encontré el contrato original de los Brant.", "¿Qué? ¿Lo encontraste? Déjame verlo.\n\n[Ella lo lee con atención. Su expresión cambia de incredulidad a una furia fría.]\n\nEsto... mira aquí. La cláusula siete. La tinta es más oscura — más reciente. La letra no coincide en absoluto con el resto del documento.\n\nEsta cláusula fue añadida después de la firma. La marca de testigo de mi padre está en un documento que no contenía esta condición cuando él lo aceptó. Fue falsificado. Sir Martyn Brant lo falsificó.\n\nEsta es la prueba que he estado buscando. Debe llegar al consejo del reino. Lady Jade Wintar — es la consejera en el Castillo de Monelix. Es justa. Llévale esto.");
        cvFF5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FALKER_FAMILY, 4)
                    && LibInventory.checkHasItem(ItemsIds.OLD_BRANT_CONTRACT, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvFF5);

        ConversationOption cvFF5b = new ConversationOption(3, 0);
        cvFF5b.addOptionText(ENGLISH, "I'll take it to Lady Jade right away.", "Be careful on the way. The Brants have allies in Monelix, and if they discover what you carry... they won't let you walk in unchallenged.");
        cvFF5b.addOptionText(PORTUGUESE, "Levarei a Lady Jade imediatamente.", "Tenha cuidado no caminho. Os Brant têm aliados em Monelix, e se descobrirem o que você carrega... não vão deixá-lo passar sem desafio.");
        cvFF5b.addOptionText(SPANISH, "Se lo llevaré a Lady Jade de inmediato.", "Ten cuidado en el camino. Los Brant tienen aliados en Monelix, y si descubren lo que llevas... no te dejarán pasar sin un desafío.");
        cvFF5b.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.FALKER_FAMILY, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFF5b);

        // ========================================
        // QUEST: FALKER_FAMILY — PART 7 (Return after Lady Jade verdict)
        // ========================================

        ConversationOption cvFF8 = new ConversationOption(0, 0);
        cvFF8.addOptionText(ENGLISH, "Lady Jade ruled that Letow will receive 20 heads of cattle.", "Ten cattle.\n\n*She laughs softly — not with joy, but with bitter disbelief*\n\nFor lands that sustained dozens of families? For decades of struggling in Letow's barren soil? Twenty cattle is... an insult dressed as justice.\n\nMy father will want to hear this. But do not be surprised if he has something more decisive in mind. Go to Letow. Speak with him.");
        cvFF8.addOptionText(PORTUGUESE, "Lady Jade determinou que Letow receberá 20 cabeças de gado.", "Dez cabeças de gado.\n\n*Ela ri suavemente — não de alegria, mas de amarga incredulidade*\n\nPelas terras que sustentaram dezenas de famílias? Por décadas lutando no solo árido de Letow? Vinte cabeças de gado é... um insulto disfarçado de justiça.\n\nMeu pai vai querer saber disso. Mas não se surpreenda se ele tiver algo mais decisivo em mente. Vá a Letow. Fale com ele.");
        cvFF8.addOptionText(SPANISH, "Lady Jade dictaminó que Letow recibirá 20 cabezas de ganado.", "Diez cabezas de ganado.\n\n*Ella ríe suavemente — no de alegría, sino con amarga incredulidad*\n\n¿Por tierras que sustentaron a decenas de familias? ¿Por décadas luchando en el suelo árido de Letow? Veinte cabezas de ganado es... un insulto disfrazado de justicia.\n\nMi padre querrá escuchar esto. Pero no te sorprendas si tiene algo más decisivo en mente. Ve a Letow. Habla con él.");
        cvFF8.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FALKER_FAMILY, 7)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvFF8.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.FALKER_FAMILY, 8, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFF8);

        // ========================================
        // QUEST: BRANT_FAMILY — PART 11 (Deliver love letter)
        // ========================================

        ConversationOption cvBrF11 = new ConversationOption(0, 0);
        cvBrF11.addOptionText(ENGLISH, "Sir Jard asked me to deliver this letter to you.", "[She takes the letter, begins to read. Her expression hardens almost immediately]\n\n'My dearest Lara'...\n\n[She tears it in half without finishing]\n\nTell him to save the ink. After everything he has done — after his father manipulated my family, after years of conflict, after that house...\n\n[She composes herself]\n\nThere is no world in which I would accept this man's affections. Tell him. Clearly. And if you have any sense, distance yourself from him too.");
        cvBrF11.addOptionText(PORTUGUESE, "Sir Jard me pediu para entregar esta carta a você.", "[Ela pega a carta e começa a ler. Sua expressão endurece quase imediatamente]\n\n'Minha querida Lara'...\n\n[Ela a rasga ao meio sem terminar]\n\nDiga-lhe para poupar a tinta. Depois de tudo que fez — depois de seu pai manipular minha família, depois de anos de conflito, depois daquela casa...\n\n[Ela se recompõe]\n\nNão há mundo em que eu aceitaria as afeições desse homem. Diga a ele. Claramente. E se tiver bom senso, distancie-se dele também.");
        cvBrF11.addOptionText(SPANISH, "Sir Jard me pidió que te entregara esta carta.", "[Ella toma la carta y comienza a leer. Su expresión se endurece casi de inmediato]\n\n'Mi querida Lara'...\n\n[La rompe por la mitad sin terminar de leerla]\n\nDile que ahorre la tinta. Después de todo lo que ha hecho — después de que su padre manipuló a mi familia, después de años de conflicto, después de esa casa...\n\n[Ella se recompone]\n\nNo hay mundo en el que aceptaría las atenciones de ese hombre. Díselo. Claramente. Y si tienes buen juicio, aléjate de él también.");
        cvBrF11.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANT_FAMILY, 10)
                    && LibInventory.checkHasItem(ItemsIds.JARDS_LOVE_LETTER, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvBrF11.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.JARDS_LOVE_LETTER, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.BRANT_FAMILY, 11, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBrF11);

        // ========================================
        // POST-QUEST: FalkerFamily — Gratitude
        // ========================================

        ConversationOption cvFFDone = new ConversationOption(0, 0);
        cvFFDone.addOptionText(ENGLISH, "How is your father doing?", "Better than he has in years. My father is not the type to show weakness, but I could see it in his eyes — relief. A man can carry the weight of injustice for only so long before it breaks him.\n\nHe feels the scales have balanced a little. Not completely — the past cannot be undone. But he can look at Letow now without only seeing what was taken.\n\nYou gave him that. Thank you.");
        cvFFDone.addOptionText(PORTUGUESE, "Como seu pai está?", "Melhor do que esteve em anos. Meu pai não é do tipo de mostrar fraqueza, mas eu podia ver em seus olhos — alívio. Um homem pode carregar o peso da injustiça por apenas um tempo antes de se quebrar.\n\nEle sente que a balança equilibrou um pouco. Não completamente — o passado não pode ser desfeito. Mas agora ele pode olhar para Letow sem ver apenas o que foi tirado.\n\nVocê lhe deu isso. Obrigada.");
        cvFFDone.addOptionText(SPANISH, "¿Cómo está tu padre?", "Mejor de lo que ha estado en años. Mi padre no es del tipo que muestra debilidad, pero podía verlo en sus ojos — alivio. Un hombre solo puede cargar el peso de la injusticia durante cierto tiempo antes de quebrarse.\n\nSiente que la balanza se equilibró un poco. No del todo — el pasado no puede deshacerse. Pero ahora puede mirar a Letow sin ver solo lo que le quitaron.\n\nTú le diste eso. Gracias.");
        cvFFDone.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.FALKER_FAMILY)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvFFDone);

        return npc;
    }
}