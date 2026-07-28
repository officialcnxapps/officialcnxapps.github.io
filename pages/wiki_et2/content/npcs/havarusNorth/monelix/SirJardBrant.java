package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.NOBLES_BALL;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.R;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.houses.HousesIds;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class SirJardBrant extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Sir Jard Brant");
        npc.age = 37;
        npc.job = Enums.NPCJobs.LANDLORD;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "He speaks with superiority, at times arrogant. Little empathy.\nIntelligent and clever, he knows shortcuts to get what he needs.\nHe values his name and his family greatly, despite actively seeking marriage.\n\nHis physical traits: Silky light brown hair. Neatly trimmed beard and mustache. Judging look in his light eyes. Square face.");
        npc.addDescriptionTranslation(PORTUGUESE, "Fala com superioridade, por vezes arrogante. Pouco empático\nInteligente e esperto, conhece atalhos para conseguir o que precisa.\nValoriza muito seu nome e sua família, apesar de estar buscando casamento.\n\nSeus traços físicos: Cabelos sedosos de cor castanho claro. Barba e bigode bem aparados. Olhar de julgamento em seus olhos claros. Rosto quadrado.");
        npc.addDescriptionTranslation(SPANISH, "Habla con superioridad, a veces arrogante. Poco empático.\nInteligente y listo, conoce atajos para conseguir lo que necesita.\nValora mucho su nombre y su familia, a pesar de estar buscando matrimonio.\n\nSus rasgos físicos: Cabello sedoso de color castaño claro. Barba y bigote bien recortados. Mirada de juicio en sus ojos claros. Rostro cuadrado.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("You'd better have a reason for bothering me."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Você deve ter um bom motivo para me incomodar."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Será mejor que tengas un buen motivo para molestarme."));

        npc.generateRandomByes();

        // ========================================
        // QUEST: BRANTS_FALKERS — PART 2
        // ========================================

        ConversationOption cvBF2 = new ConversationOption(0, 1);
        cvBF2.addOptionText(ENGLISH, "I've been looking into the Brant-Falker conflict...", "Have you now. And what do you think you've learned so far? That the Falkers are victims? That poor Lady Lara just wanted to follow her heart?\n\nLet me tell you what actually happened. Sit down. This won't take long.");
        cvBF2.addOptionText(PORTUGUESE, "Tenho investigado o conflito Brant-Falker...", "Mesmo? E o que você acha que aprendeu até agora? Que os Falker são vítimas? Que a pobre Lady Lara só queria seguir seu coração?\n\nDeixe-me dizer o que realmente aconteceu. Sente-se. Não vai demorar.");
        cvBF2.addOptionText(SPANISH, "He estado investigando el conflicto Brant-Falker...", "¿Ah sí? ¿Y qué crees que has aprendido hasta ahora? ¿Que los Falker son víctimas? ¿Que la pobre Lady Lara solo quería seguir su corazón?\n\nDéjame decirte lo que realmente pasó. Siéntate. No tomará mucho tiempo.");
        cvBF2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANTS_FALKERS, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvBF2);

        ConversationOption cvBF2b = new ConversationOption(1, 0);
        cvBF2b.addOptionText(ENGLISH, "Tell me what happened from your perspective.", "My father made an agreement with Lord Den — political, yes, but also personal. Lara and I were meant to merge two great families. My father believed in it. I believed in it.\n\nThen Den came crawling to my father saying Lara 'refused.' Not him — she did. And Den, that spineless coward, let her. Abandoned the contract. Abandoned the alliance.\n\nFather went to enforce the legal clause written in the agreement. Den resisted. War broke out. Short, but brutal. My father died.\n\nNow they sit in their comfortable halls — Lara in her gardens, Den in his Letow ruins — while I carry his coffin in my memory. If you want to understand this conflict, talk to Lord Den. He lives in Letow. And choose your words carefully around him.");
        cvBF2b.addOptionText(PORTUGUESE, "Me conte o que aconteceu pela sua perspectiva.", "Meu pai fez um acordo com Lorde Den — político, sim, mas também pessoal. Lara e eu deveríamos unir duas grandes famílias. Meu pai acreditava nisso. Eu acreditava.\n\nEntão Den veio rastejando até meu pai dizendo que Lara 'recusou'. Não ele — ela. E Den, aquele covarde sem espinha, deixou. Abandonou o contrato. Abandonou a aliança.\n\nPai foi fazer valer a cláusula legal escrita no acordo. Den resistiu. A guerra eclodiu. Curta, mas brutal. Meu pai morreu.\n\nAgora eles se sentam em seus salões confortáveis — Lara em seus jardins, Den nas ruínas de Letow — enquanto eu carrego o caixão dele na memória. Se quiser entender esse conflito, fale com Lorde Den. Ele mora em Letow. E escolha bem as palavras ao redor dele.");
        cvBF2b.addOptionText(SPANISH, "Cuéntame lo que pasó desde tu perspectiva.", "Mi padre hizo un acuerdo con Lord Den — político, sí, pero también personal. Lara y yo íbamos a unir dos grandes familias. Mi padre creía en ello. Yo creía.\n\nLuego Den vino arrastrándose a decirle a mi padre que Lara 'rechazó'. No él — ella. Y Den, ese cobarde sin espina dorsal, lo permitió. Abandonó el contrato. Abandonó la alianza.\n\nPadre fue a hacer valer la cláusula legal escrita en el acuerdo. Den se resistió. Estalló la guerra. Corta, pero brutal. Mi padre murió.\n\nAhora se sientan en sus cómodas salas — Lara en sus jardines, Den en sus ruinas de Letow — mientras yo cargo su ataúd en la memoria. Si quieres entender este conflicto, habla con Lord Den. Vive en Letow. Y elige bien tus palabras al estar cerca de él.");
        cvBF2b.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.BRANTS_FALKERS, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBF2b);

        // ========================================
        // QUEST: BRANTS_FALKERS — PART 4 (Choose Brant Side)
        // ========================================

        ConversationOption cvBF4 = new ConversationOption(0, 2);
        cvBF4.addOptionText(ENGLISH, "I've heard all sides. I'd like to help the Brant family.", "You've spoken to Den, then. And Lara.\n\nMost people hear both sides and walk away. The fact that you're standing here, saying that... it tells me something about you.\n\nFine. I have a use for someone like you. Someone Den doesn't know. The Falkers hide secrets — I'm certain of it. Will you dig them up for me?");
        cvBF4.addOptionText(PORTUGUESE, "Ouvi todos os lados. Gostaria de ajudar a família Brant.", "Você falou com Den, então. E com Lara.\n\nA maioria das pessoas ouve ambos os lados e vai embora. O fato de você estar aqui, dizendo isso... me diz algo sobre você.\n\nBem. Tenho uso para alguém como você. Alguém que Den não conhece. Os Falker escondem segredos — tenho certeza disso. Você vai desenterrá-los para mim?");
        cvBF4.addOptionText(SPANISH, "He escuchado todos los lados. Me gustaría ayudar a la familia Brant.", "Has hablado con Den, entonces. Y con Lara.\n\nLa mayoría de la gente escucha ambos lados y se va. El hecho de que estés aquí, diciendo eso... me dice algo sobre ti.\n\nBien. Tengo uso para alguien como tú. Alguien que Den no conoce. Los Falker esconden secretos — estoy seguro. ¿Los desenterrarás para mí?");
        cvBF4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANTS_FALKERS, 4)
                    && !LibQuest.charHasQuest(QuestsIds.BRANT_FAMILY, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvBF4);

        ConversationOption cvBF4b = new ConversationOption(2, 0);
        cvBF4b.addOptionText(ENGLISH, "Yes. I'll help the Brant family.", "Good. Come back when you're ready to begin. I'll tell you exactly what to look for — and where.");
        cvBF4b.addOptionText(PORTUGUESE, "Sim. Vou ajudar a família Brant.", "Bom. Volte quando estiver pronto para começar. Direi exatamente o que procurar — e onde.");
        cvBF4b.addOptionText(SPANISH, "Sí. Ayudaré a la familia Brant.", "Bien. Vuelve cuando estés listo para comenzar. Te diré exactamente qué buscar — y dónde.");
        cvBF4b.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.BRANTS_FALKERS, App.getPlayerChar(), 45, ctx);
            LibQuest.includeQuestToQuestbook(QuestsIds.BRANT_FAMILY, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBF4b);

        // ========================================
        // QUEST: BRANT_FAMILY — PART 1 (Lay out the plan)
        // ========================================

        ConversationOption cvBrF1 = new ConversationOption(0, 0);
        cvBrF1.addOptionText(ENGLISH, "I'm ready to help. What do you need?", "Den has always been too clean in public. But no man running a failing territory stays afloat without cutting corners somewhere.\n\nI suspect he deals with the Swamp Island bandits. Smuggling, extortion — who knows. But I need proof.\n\nGo to Letow at night. Between 22 and 5 in the morning, when he thinks no one is watching. Observe. Report back.");
        cvBrF1.addOptionText(PORTUGUESE, "Estou pronto para ajudar. O que precisa?", "Den sempre foi limpo demais em público. Mas nenhum homem administrando um território falido se mantém à tona sem cortar atalhos em algum lugar.\n\nSuspeito que ele negocia com os bandidos da Ilha do Pântano. Contrabando, extorsão — quem sabe. Mas preciso de prova.\n\nVá a Letow de madrugada. Entre 22 e 5 da manhã, quando ele acha que ninguém está observando. Observe. Reporte.");
        cvBrF1.addOptionText(SPANISH, "Estoy listo para ayudar. ¿Qué necesitas?", "Den siempre ha sido demasiado limpio en público. Pero ningún hombre administrando un territorio en quiebra se mantiene a flote sin tomar atajos en algún lugar.\n\nSospecho que trata con los bandidos de la Isla del Pantano. Contrabando, extorsión — quién sabe. Pero necesito pruebas.\n\nVe a Letow de noche. Entre las 22 y las 5 de la madrugada, cuando crea que nadie lo observa. Observa. Reporta.");
        cvBrF1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANT_FAMILY, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvBrF1.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.BRANT_FAMILY, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBrF1);

        // ========================================
        // QUEST: BRANT_FAMILY — PART 3 (Report night findings)
        // ========================================

        ConversationOption cvBrF3 = new ConversationOption(0, 0);
        cvBrF3.addOptionText(ENGLISH, "I saw Den meeting with armed men from Swamp Island at night.", "I knew it. That snake.\n\nSo he's been trading with outlaws to keep his people fed. Typical. Can't stand on his own, so he crawls into the mud with criminals.\n\nThis is enough to press him into a corner. I'm sending guards to raid his estate and seize the evidence. You go to Letow — be there when they arrive.");
        cvBrF3.addOptionText(PORTUGUESE, "Vi Den se encontrando com homens armados da Ilha do Pântano de madrugada.", "Eu sabia. Aquela cobra.\n\nEntão ele tem negociado com foras da lei para manter seu povo alimentado. Típico. Não consegue se sustentar sozinho, então rasteja para a lama com criminosos.\n\nIsso é suficiente para acuá-lo num canto. Estou enviando guardas para invadir sua propriedade e apreender as evidências. Você vai a Letow — esteja lá quando chegarem.");
        cvBrF3.addOptionText(SPANISH, "Vi a Den reuniéndose con hombres armados de la Isla del Pantano de noche.", "Lo sabía. Esa serpiente.\n\nAsí que ha estado comerciando con forajidos para mantener a su gente alimentada. Típico. No puede sostenerse solo, así que se arrastra al barro con criminales.\n\nEsto es suficiente para acorralarlo. Envío guardias a allanar su propiedad y confiscar las pruebas. Ve a Letow — sé allí cuando lleguen.");
        cvBrF3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANT_FAMILY, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvBrF3.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.BRANT_FAMILY, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBrF3);

        // ========================================
        // QUEST: BRANT_FAMILY — PART 7 (Decide on burning the house)
        // ========================================

        ConversationOption cvBrF7 = new ConversationOption(0, 3);
        cvBrF7.addOptionText(ENGLISH, "Lady Jade ruled that Den must cease all illegal operations.", "Cease operations. That's it.\n\n[He stands, jaw clenched]\n\nHe murders my father — through dishonor if not by sword — runs criminal operations in his territory, and all the Crown says is 'cease operations'?\n\nFine. If justice won't reach his door, fire will. I want Den's manor burned. He built it on land stolen from my family's influence. Let it turn to ash.\n\nGo to Letow at night. Bring a torch. His guards will try to stop you — deal with them. I'll make sure you have what you need.");
        cvBrF7.addOptionText(PORTUGUESE, "Lady Jade determinou que Den deve cessar todas as operações ilegais.", "Cessar as operações. É isso.\n\n[Ele se levanta, mandíbula contraída]\n\nEle assassina meu pai — pela desonra se não pela espada — conduz operações criminosas em seu território, e tudo que a Coroa diz é 'cessar as operações'?\n\nBem. Se a justiça não chegará à sua porta, o fogo chegará. Quero a mansão de Den queimada. Ele a construiu com a influência das terras roubadas da minha família. Que se torne cinza.\n\nVá a Letow de madrugada. Traga uma tocha. Seus guardas vão tentar detê-lo — lide com eles. Garantirei que tenha o que precisa.");
        cvBrF7.addOptionText(SPANISH, "Lady Jade dictaminó que Den debe cesar todas las operaciones ilegales.", "Cesar las operaciones. Eso es todo.\n\n[Se pone de pie, con la mandíbula apretada]\n\n¿Él asesina a mi padre — por deshonra si no por espada —, dirige operaciones criminales en su territorio, y todo lo que dice la Corona es 'cesar las operaciones'?\n\nBien. Si la justicia no llegará a su puerta, el fuego lo hará. Quiero la mansión de Den quemada. La construyó con la influencia de las tierras robadas de mi familia. Que se convierta en cenizas.\n\nVe a Letow de noche. Lleva una antorcha. Sus guardias intentarán detenerte — ocúpate de ellos. Me aseguraré de que tengas lo que necesitas.");
        cvBrF7.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANT_FAMILY, 7)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvBrF7);

        ConversationOption cvBrF7b = new ConversationOption(3, 0);
        cvBrF7b.addOptionText(ENGLISH, "I'll do it. Den's house will burn.", "Good. You will need a torch. Go when the night is darkest. And don't leave until the job is done.");
        cvBrF7b.addOptionText(PORTUGUESE, "Farei isso. A casa de Den vai queimar.", "Bom. Arranje uma tocha. Vá quando a noite estiver mais escura. E não saia de lá até que a tarefa esteja feita.");
        cvBrF7b.addOptionText(SPANISH, "Lo haré. La casa de Den arderá.", "Bien. Llevará una antorcha. Ve cuando la noche esté más oscura. Y no salgas de allí hasta que el trabajo esté hecho.");
        cvBrF7b.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.BRANT_FAMILY, 8, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBrF7b);

        // ========================================
        // QUEST: BRANT_FAMILY — PART 9 (Report house burned)
        // ========================================

        ConversationOption cvBrF9 = new ConversationOption(0, 9);
        cvBrF9.addOptionText(ENGLISH, "It's done. Den's house is ash.", "[A long pause. He exhales slowly]\n\nGood. That is... good.\n\nMy father built his life trying to hold alliances together. Den tore it all apart with one broken promise. That house stood as a monument to his arrogance. Now it doesn't.\n\nWe are not done yet, though. There is one more thing I need from you. Something... personal. ");
        cvBrF9.addOptionText(PORTUGUESE, "Está feito. A casa de Den virou cinzas.", "[Uma longa pausa. Ele exala devagar]\n\nBom. Isso é... bom.\n\nMeu pai construiu sua vida tentando manter alianças unidas. Den destruiu tudo com uma promessa quebrada. Aquela casa se erguia como um monumento à sua arrogância. Agora não.\n\nAinda não terminamos, porém. Há mais uma coisa que preciso de você. Algo... pessoal.");
        cvBrF9.addOptionText(SPANISH, "Está hecho. La casa de Den es ceniza.", "[Una larga pausa. Exhala despacio]\n\nBien. Eso es... bien.\n\nMi padre construyó su vida intentando mantener las alianzas unidas. Den lo destruyó todo con una promesa rota. Esa casa se alzaba como un monumento a su arrogancia. Ahora ya no.\n\nAún no hemos terminado, sin embargo. Hay una cosa más que necesito de ti. Algo... personal.");
        cvBrF9.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANT_FAMILY, 9)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvBrF9);

        // ========================================
        // QUEST: BRANT_FAMILY — PART 10 (Give love letter)
        // ========================================

        ConversationOption cvBrF10 = new ConversationOption(9, 0);
        cvBrF10.addOptionText(ENGLISH, "Ssomething personal for me to do?", "Yes.\n\n[He produces a sealed letter from his coat]\n\nI wrote this for Lady Lara. I know what you're thinking — after everything, after the fire... But what I feel for her is real. It always was.\n\nTake this to her. I want her to read it from my own hand. Maybe she'll understand that this was never about politics for me. Maybe she won't. But I need to try.");
        cvBrF10.addOptionText(PORTUGUESE, "Algo pessoal para eu fazer?", "Sim.\n\n[Ele tira uma carta selada do casaco]\n\nEscrevi isso para Lady Lara. Sei o que está pensando — depois de tudo, depois do fogo... Mas o que sinto por ela é real. Sempre foi.\n\nLeve isso a ela. Quero que ela leia escrito pela minha própria mão. Talvez ela entenda que isso nunca foi sobre política para mim. Talvez não. Mas preciso tentar.");
        cvBrF10.addOptionText(SPANISH, "¿Algo personal para que yo hacer?", "Sí.\n\n[Saca una carta sellada de su abrigo]\n\nEscribí esto para Lady Lara. Sé lo que estás pensando — después de todo, después del fuego... Pero lo que siento por ella es real. Siempre lo fue.\n\nLlévale esto. Quiero que lo lea de mi propio puño y letra. Tal vez entienda que esto nunca fue de política para mí. Tal vez no. Pero necesito intentarlo.");
        cvBrF10.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANT_FAMILY, 9)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvBrF10.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.JARDS_LOVE_LETTER, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.BRANT_FAMILY, 10, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBrF10);

        // ========================================
        // QUEST: BRANT_FAMILY — PART 11 (Accept defeat / Complete)
        // ========================================

        ConversationOption cvBrF12 = new ConversationOption(0, 0);
        cvBrF12.addOptionText(ENGLISH, "I delivered your letter. She tore it in half without finishing it.", "[He stares at you for a long moment]\n\nOf course she did.\n\n[He sits down heavily, the fire gone from his eyes for just a moment]\n\nI've spent years burning with anger. Burning Den's house, burning bridges, burning everything. And still... I couldn't burn the part of me that hoped she would read that letter and think of what we might have been.\n\nShe never will. I understand that now.\n\nYou've done what I asked. More than I asked. Take your reward. The Brant name is satisfied. Whether I am... is a different question.");
        cvBrF12.addOptionText(PORTUGUESE, "Entreguei sua carta. Ela a rasgou ao meio sem terminar de ler.", "[Ele o encara por um longo momento]\n\nClaro que foi assim.\n\n[Ele se senta pesadamente, o fogo desaparecendo de seus olhos por um momento]\n\nPassei anos ardendo de raiva. Queimando a casa de Den, queimando pontes, queimando tudo. E ainda assim... não conseguia queimar a parte de mim que esperava que ela lesse aquela carta e pensasse no que poderíamos ter sido.\n\nEla nunca vai. Entendo isso agora.\n\nVocê fez o que pedi. Mais do que pedi. Pegue sua recompensa. O nome Brant está satisfeito. Se eu estou... é uma questão diferente.");
        cvBrF12.addOptionText(SPANISH, "Entregué tu carta. La rompió por la mitad sin terminar de leer.", "[Te mira fijamente por un largo momento]\n\nClaro que lo hizo.\n\n[Se sienta pesadamente, el fuego desaparece de sus ojos por un momento]\n\nHe pasado años ardiendo de ira. Quemando la casa de Den, queimando puentes, queimando todo. Y aun así... no podía quemar la parte de mí que esperaba que ella leyera esa carta y pensara en lo que podríamos haber sido.\n\nNunca lo hará. Lo entiendo ahora.\n\nHas hecho lo que te pedí. Más de lo que te pedí. Toma tu recompensa. El nombre Brant está satisfecho. Si yo lo estoy... es una pregunta diferente.");
        cvBrF12.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANT_FAMILY, 11)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvBrF12.listeners = (ctx, currentFragment) -> {
            App.getPlayerChar().attributesManager.decrease(Enums.AttributeName.ALIGNMENT, 8);
            LibQuest.completeQuest(QuestsIds.BRANT_FAMILY, App.getPlayerChar(), 12, ctx);
        };
        npc.conversationOptions.add(cvBrF12);

        // ========================================
        // POST-QUEST: BRANT_FAMILY complete — Bitter but satisfied
        // ========================================

        ConversationOption cvBrFDone = new ConversationOption(0, 0);
        cvBrFDone.addOptionText(ENGLISH, "How are things with the Falkers now?", "Quiet. Which is all I ever truly wanted — to be left alone with my grief and my father's memory.\n\nDen has nothing left to burn. He knows it. The balance of power is different now.\n\nI won't pretend I'm healed. But justice was done. My father's death meant something. That matters.");
        cvBrFDone.addOptionText(PORTUGUESE, "Como estão as coisas com os Falker agora?", "Quieto. É tudo que eu realmente queria — ser deixado em paz com minha dor e a memória do meu pai.\n\nDen não tem mais nada a queimar. Ele sabe disso. O equilíbrio de poder é diferente agora.\n\nNão vou fingir que estou curado. Mas a justiça foi feita. A morte do meu pai significou algo. Isso importa.");
        cvBrFDone.addOptionText(SPANISH, "¿Cómo están las cosas con los Falker ahora?", "Tranquilo. Que es todo lo que realmente quería — que me dejaran en paz con mi dolor y la memoria de mi padre.\n\nDen ya no tiene nada que quemar. Lo sabe. El equilibrio de poder es diferente ahora.\n\nNo voy a fingir que estoy curado. Pero se hizo justicia. La muerte de mi padre significó algo. Eso importa.");
        cvBrFDone.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.BRANT_FAMILY)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvBrFDone);

        // ========================================
        // HOUSING - Buy Monelix Manor
        // ========================================

        ConversationOption cvHouseStart = new ConversationOption(0, 20);
        cvHouseStart.addOptionText(ENGLISH, "I would like to live in Monelix.", "Monelix is not for drifters. But you have earned a certain standing in the realm. There is a manor available, one fit for someone of recognized service. If you want it, the price is 60 gold coins and 8 gems.");
        cvHouseStart.addOptionText(PORTUGUESE, "Eu gostaria de viver em Monelix.", "Monelix não é para qualquer andarilho. Mas você conquistou certa posição no reino. Há uma mansão disponível, digna de alguém com serviços reconhecidos. Se a quiser, o preço é 60 moedas de ouro e 8 gemas.");
        cvHouseStart.addOptionText(SPANISH, "Me gustaría vivir en Monelix.", "Monelix no es para cualquier vagabundo. Pero has conquistado cierta posición en el reino. Hay una mansión disponible, digna de alguien con servicios reconocidos. Si la quieres, el precio es 60 monedas de oro y 8 gemas.");
        cvHouseStart.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.isQuestComplete(chara, QuestsIds.OVERSEAS_RECOGNITION) || chara.ownsHouse(HousesIds.HOME_MONELIX_MANOR)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cvHouseStart);

        ConversationOption cvHouseBuy = new ConversationOption(20, 0);
        cvHouseBuy.addOptionText(ENGLISH, "I will buy the manor. [60 gold & 8 Gems]", "Very well. The deed will be transferred to your name. See that you prove worthy of owning property in Monelix.");
        cvHouseBuy.addOptionText(PORTUGUESE, "Vou comprar a mansão. [60 gold & 8 Gems]", "Muito bem. A escritura será transferida para o seu nome. Trate de provar que é digno de possuir uma propriedade em Monelix.");
        cvHouseBuy.addOptionText(SPANISH, "Comprar la mansion. [60 gold & 8 Gems]", "Muy bien. La escritura sera transferida a tu nombre. Procura demostrar que eres digno de poseer una propiedad en Monelix.");
        cvHouseBuy.requirementValidations = (chara, ctx) -> {
            if (!chara.ownsHouse(HousesIds.HOME_MONELIX_MANOR)
                    && chara.checkHasGold(60)
                    && App.Shell.getAccount().getGems() >= 8) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvHouseBuy.listeners = (ctx, currentFragment) -> {
            if (!App.getPlayerChar().ownsHouse(HousesIds.HOME_MONELIX_MANOR)) {
                App.getPlayerChar().removeGold(60);
                App.Shell.getAccount().removeGems(8);
                App.getPlayerChar().addOwnedHouse(HousesIds.HOME_MONELIX_MANOR);
                LibUtils.showToast(LibUtils.getString(R.string.houseBought, ctx), 1, CoreEnums.MessageType.SUCCESS, ctx);
                currentFragment.updateTopDisplay();
                App.Shell.saveGame(ctx);
            }
        };
        npc.conversationOptions.add(cvHouseBuy);

        ConversationOption cvHouseNoMoney = new ConversationOption(20, 0);
        cvHouseNoMoney.addOptionText(ENGLISH, "I still lack the price.", "Then do not waste my time. Return when you have the full amount.");
        cvHouseNoMoney.addOptionText(PORTUGUESE, "Ainda me falta o valor.", "Então não desperdice meu tempo. Retorne quando tiver a quantia completa.");
        cvHouseNoMoney.addOptionText(SPANISH, "Aún me falta el valor.", "Entonces no desperdicies mi tiempo. Regresa cuando tengas la cantidad completa.");
        cvHouseNoMoney.requirementValidations = (chara, ctx) -> {
            if (!chara.ownsHouse(HousesIds.HOME_MONELIX_MANOR)
                    && (!chara.checkHasGold(60) || App.Shell.getAccount().getGems() < 8)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvHouseNoMoney);

        ConversationOption cvHouseDecline = new ConversationOption(20, 0);
        cvHouseDecline.addOptionText(ENGLISH, "Perhaps another time.", "See that you do not take too long. Opportunities in Monelix are not endless.");
        cvHouseDecline.addOptionText(PORTUGUESE, "Talvez outra hora.", "Veja se não demora demais. Oportunidades em Monelix não são infinitas.");
        cvHouseDecline.addOptionText(SPANISH, "Quiza en otro momento.", "Procura no tardar demasiado. Las oportunidades en Monelix no son infinitas.");
        npc.conversationOptions.add(cvHouseDecline);

        // ========================================
        // ROLEPLAY - General conversations
        // ========================================

        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "You seem like a man carrying a heavy burden.", "Heavy? No. Determined. There is a difference.\n\nMy father built Monelix's influence with his own hands. He was an advisor to the Crown — the kind of man who shaped kingdoms. And the Falkers took him from me. Not with a sword, but with a broken promise.\n\nI will not rest until they answer for it. That is not a burden. That is a purpose.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Você parece um homem carregando um peso pesado.", "Pesado? Não. Determinado. Há uma diferença.\n\nMeu pai construiu a influência de Monelix com as próprias mãos. Era conselheiro da Coroa — o tipo de homem que moldava reinos. E os Falker o tiraram de mim. Não com uma espada, mas com uma promessa quebrada.\n\nNão descansarei até que respondam por isso. Isso não é um fardo. É um propósito.");
        cvRoleplay1.addOptionText(SPANISH, "Pareces un hombre cargando un peso pesado.", "¿Pesado? No. Determinado. Hay una diferencia.\n\nMi padre construyó la influencia de Monelix con sus propias manos. Era asesor de la Corona, el tipo de hombre que moldeaba reinos. Y los Falker me lo arrebataron. No con una espada, sino con una promesa rota.\n\nNo descansaré hasta que respondan por ello. Eso no es una carga. Es un propósito.");
        npc.conversationOptions.add(cvRoleplay1);

        // Noble family gateway (0 -> 5): unlocks the question about Sir Martyn
        ConversationOption cvNobleFamily = new ConversationOption(0, 5);
        cvNobleFamily.addOptionText(ENGLISH, "You seem to come from a noble family.", "You have a sharp eye. The Brant name carries weight in Monelix — and well beyond it. My father, Sir Martyn Brant, was an advisor to the Crown. A man of real influence. And I intend to honor that legacy, whatever the cost.");
        cvNobleFamily.addOptionText(PORTUGUESE, "Você parece ser de uma família nobre.", "Você tem bom olho. O nome Brant carrega peso em Monelix — e muito além dele. Meu pai, Sir Martyn Brant, era conselheiro da Coroa. Um homem de verdadeira influência. E pretendo honrar esse legado, custe o que custar.");
        cvNobleFamily.addOptionText(SPANISH, "Pareces ser de una familia noble.", "Tienes buen ojo. El nombre Brant tiene peso en Monelix — y mucho más allá. Mi padre, Sir Martyn Brant, era asesor de la Corona. Un hombre de verdadera influencia. Y pienso honrar ese legado, cueste lo que cueste.");
        npc.conversationOptions.add(cvNobleFamily);

        // Father conversation — only accessible after asking about noble family (5 -> 0)
        ConversationOption cvRoleplay2 = new ConversationOption(5, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Tell me about your father, Sir Martyn.", "Sir Martyn Brant was a man of principles. He served the Crown faithfully, and he believed that alliances — between families, between cities — were the foundation of stability.\n\nThe Falker deal was one such alliance. Lord Den gave his word. His daughter was promised. And then... Den let his daughter break it.\n\nWhen the marriage fell through, Father didn't just lose a political agreement. He lost his life in the war that followed. And I lost everything.\n\nDen says Lara didn't want the marriage. As if that matters. Your word is your word.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Me fale sobre seu pai, Sir Martyn.", "Sir Martyn Brant era um homem de princípios. Serviu à Coroa com fidelidade e acreditava que as alianças — entre famílias, entre cidades — eram a base da estabilidade.\n\nO acordo com os Falker era uma dessas alianças. Lorde Den deu sua palavra. Sua filha foi prometida. E então... Den deixou sua filha quebrá-la.\n\nQuando o casamento não aconteceu, Pai não perdeu apenas um acordo político. Perdeu sua vida na guerra que se seguiu. E eu perdi tudo.\n\nDen diz que Lara não queria o casamento. Como se isso importasse. Sua palavra é sua palavra.");
        cvRoleplay2.addOptionText(SPANISH, "Háblame de tu padre, Sir Martyn.", "Sir Martyn Brant era un hombre de principios. Sirvió a la Corona con fidelidad y creía que las alianzas — entre familias, entre ciudades — eran la base de la estabilidad.\n\nEl acuerdo con los Falker era una de esas alianzas. Lord Den dio su palabra. Su hija fue prometida. Y luego... Den dejó que su hija la rompiera.\n\nCuando el matrimonio fracasó, Padre no solo perdió un acuerdo político. Perdió su vida en la guerra que siguió. Y yo lo perdí todo.\n\nDen dice que Lara no quería casarse. Como si eso importara. Tu palabra es tu palabra.");
        npc.conversationOptions.add(cvRoleplay2);

        // Close noble family topic without asking about father (5 -> 0)
        ConversationOption cvNobleClose = new ConversationOption(5, 0);
        cvNobleClose.addOptionText(ENGLISH, "I see. Thank you for sharing that.", "Don't mistake it for warmth. I simply don't hide what I am.");
        cvNobleClose.addOptionText(PORTUGUESE, "Entendo. Obrigado por compartilhar isso.", "Não confunda isso com cordialidade. Simplesmente não escondo o que sou.");
        cvNobleClose.addOptionText(SPANISH, "Entiendo. Gracias por compartir eso.", "No lo confundas con calidez. Simplemente no escondo lo que soy.");
        npc.conversationOptions.add(cvNobleClose);

        // ========================================
        // QUEST: NOBLE'S BALL
        // ========================================

        // Part 2: Invite Sir Jard Brant
        ConversationOption cvBallPart2 = new ConversationOption(0, 0);
        cvBallPart2.addOptionText(ENGLISH, "Sir Jard, I have an invitation for you for the Noble's Ball at the castle.",
                "*He takes the invitation with a satisfied look*\nA ball? About time the crown showed some class. I shall attend, of course. A Brant's presence is essential for such an event. \n\nI only hope the organizers had the sense not to invite any of those... Falker. Their presence would surely dampen the evening's elegance.");
        cvBallPart2.addOptionText(PORTUGUESE, "Sir Jard, tenho um convite para você para o Baile de Nobres no castelo.",
                "*Ele pega o convite com um olhar satisfeito*\nUm baile? Já era hora da coroa mostrar alguma classe. Eu comparecerei, é claro. A presença de um Brant é essencial para tal evento. \n\nSó espero que os organizadores tenham tido o bom senso de não convidar nenhum daqueles... Falker. A presença deles certamente diminuiria a elegância da noite.");
        cvBallPart2.addOptionText(SPANISH, "Sir Jard, tengo una invitación para usted para el Baile de Nobles en el castillo.",
                "*Toma la invitación con una mirada satisfecha*\n¿Un baile? Ya era hora de que la corona mostrara algo de clase. Asistiré, por supuesto. La presencia de un Brant es esencial para tal evento. \n\nSolo espero que los organizadores hayan tenido el sentido común de no invitar a ninguno de esos... Falker. Su presencia seguramente empañaría la elegancia de la noche.");
        cvBallPart2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, NOBLES_BALL, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvBallPart2.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(NOBLES_BALL, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBallPart2);

        return npc;
    }
}
