package com.cnx.endlesstalestwo.data.npcs.havarusNorth.letow;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.REBUILD_FARMLAND;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.GameEngine;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class LordDenFalker extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Lord Den Falker");
        npc.age = 77;
        npc.job = Enums.NPCJobs.LANDLORD;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Welcome to Letow, traveler."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bem-vindo a Letow, viajante."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Bienvenido a Letow, viajero."));

        //This NPC is important for the Havarus kingdom, being involved in Brant & Falker quest and have been a good father for his daughter Lady Lara. He is the landlord of Letow, he is usually gentle and kind.
        //He doesn't like the Brant family because of the problems of the past.

        // ===== QUEST: REBUILD_FARMLAND - PART 4 (Request workers) =====
        ConversationOption cvRebuildFarmland4 = new ConversationOption(0, 1);
        cvRebuildFarmland4.addOptionText(ENGLISH, "Lord Den, Farmland needs workers to rebuild.", "Farmland... I've heard of the devastation. Terrible, absolutely terrible. So many good people lost. My people here in Letow are farmers and craftsmen - they know the land and how to work it. Despite our... difficult beginnings, we've always respected Farmland's contribution to the kingdom.");
        cvRebuildFarmland4.addOptionText(PORTUGUESE, "Lord Den, Farmland precisa de trabalhadores para reconstruir.", "Farmland... Ouvi falar da devastação. Terrível, absolutamente terrível. Tantas pessoas boas perdidas. Meu povo aqui em Letow são fazendeiros e artesãos - eles conhecem a terra e como trabalhá-la. Apesar de nossos... começos difíceis, sempre respeitamos a contribuição de Farmland ao reino.");
        cvRebuildFarmland4.addOptionText(SPANISH, "Lord Den, Farmland necesita trabajadores para reconstruir.", "Farmland... He oído de la devastación. Terrible, absolutamente terrible. Tanta gente buena perdida. Mi gente aquí en Letow son granjeros y artesanos - conocen la tierra y cómo trabajarla. A pesar de nuestros... comienzos difíciles, siempre hemos respetado la contribución de Farmland al reino.");
        cvRebuildFarmland4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, REBUILD_FARMLAND, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRebuildFarmland4);

        ConversationOption cvRebuildFarmland4Response = new ConversationOption(1, 0);
        cvRebuildFarmland4Response.addOptionText(ENGLISH, "Will you send workers to help?", "Of course. I'll send a group of my best workers and farmers. They'll help rebuild homes, restore fields, and teach the survivors how to maximize what little they have left. It's what we do here - we know how to make barren land productive. Tell Larien that Letow stands with Farmland. We may have our grievances with the crown, but we don't abandon our fellow farmers in their hour of need.");
        cvRebuildFarmland4Response.addOptionText(PORTUGUESE, "Você enviará trabalhadores para ajudar?", "Claro. Enviarei um grupo dos meus melhores trabalhadores e fazendeiros. Eles ajudarão a reconstruir casas, restaurar campos e ensinar aos sobreviventes como maximizar o pouco que restou. É o que fazemos aqui - sabemos como tornar terra árida produtiva. Diga a Larien que Letow está com Farmland. Podemos ter nossas queixas com a coroa, mas não abandonamos nossos companheiros fazendeiros em sua hora de necessidade.");
        cvRebuildFarmland4Response.addOptionText(SPANISH, "¿Enviará trabajadores para ayudar?", "Por supuesto. Enviaré un grupo de mis mejores trabajadores y granjeros. Ayudarán a reconstruir casas, restaurar campos y enseñar a los sobrevivientes cómo maximizar lo poco que les queda. Es lo que hacemos aquí - sabemos cómo hacer productiva la tierra estéril. Dile a Larien que Letow está con Farmland. Podemos tener nuestras quejas con la corona, pero no abandonamos a nuestros compañeros granjeros en su hora de necesidad.");
        cvRebuildFarmland4Response.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(REBUILD_FARMLAND, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvRebuildFarmland4Response);

        // ========================================
        // QUEST: BRANTS_FALKERS — PART 3
        // ========================================

        ConversationOption cvBF3 = new ConversationOption(0, 2);
        cvBF3.addOptionText(ENGLISH, "I've been speaking with Lady Lara and Sir Jard about the conflict...", "You've spoken to both of them. Good. Then you've heard the noise and the anger. Now you will hear the truth.\n\nI am an old man. I have few lies left in me — and fewer reasons for them. Sit.");
        cvBF3.addOptionText(PORTUGUESE, "Tenho falado com Lady Lara e Sir Jard sobre o conflito...", "Você falou com ambos. Bem. Então ouviu o barulho e a raiva. Agora ouvirá a verdade.\n\nSou um homem velho. Tenho poucas mentiras restantes em mim — e menos razões para elas. Sente-se.");
        cvBF3.addOptionText(SPANISH, "He estado hablando con Lady Lara y Sir Jard sobre el conflicto...", "Has hablado con ambos. Bien. Entonces has escuchado el ruido y la ira. Ahora escucharás la verdad.\n\nSoy un hombre viejo. Me quedan pocas mentiras — y menos razones para ellas. Siéntate.");
        cvBF3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANTS_FALKERS, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvBF3);

        ConversationOption cvBF3b = new ConversationOption(2, 0);
        cvBF3b.addOptionText(ENGLISH, "Tell me your side of the story.", "The contract existed. I signed it. I knew what it contained. What I did not know was the hidden clause — that canceling the marriage would forfeit all of our original lands.\n\nI should have read it more carefully. I was a proud man, too proud to scrutinize every word.\n\nLara asked me to cancel the marriage because Jard was cruel to her. Not publicly — but I saw the bruises once. I chose my daughter over politics. I would choose the same again.\n\nMartyn activated the clause and took everything. I protested through proper channels — and then the war came. I lost men. He lost his life.\n\nDo I feel responsible? Yes. I made the mistake of trusting a man who had already buried a trap in the agreement. Go speak to Lara and Jard. Decide what you believe is just.");
        cvBF3b.addOptionText(PORTUGUESE, "Me conte seu lado da história.", "O contrato existia. Eu o assinei. Sabia o que continha. O que não sabia era a cláusula oculta — que cancelar o casamento nos faria perder todas as nossas terras originais.\n\nDeveria ter lido com mais cuidado. Era um homem orgulhoso, orgulhoso demais para examinar cada palavra.\n\nLara me pediu para cancelar o casamento porque Jard era cruel com ela. Não publicamente — mas vi as marcas uma vez. Escolhi minha filha em vez da política. Escolheria o mesmo de novo.\n\nMartyn ativou a cláusula e tomou tudo. Protestei pelas vias adequadas — e então a guerra veio. Perdi homens. Ele perdeu a vida.\n\nMe sinto responsável? Sim. Cometi o erro de confiar em um homem que já havia enterrado uma armadilha no acordo. Vá falar com Lara e Jard. Decida o que acredita ser justo.");
        cvBF3b.addOptionText(SPANISH, "Cuéntame tu versión de la historia.", "El contrato existía. Lo firmé. Sabía lo que contenía. Lo que no sabía era la cláusula oculta — que cancelar el matrimonio nos haría perder todas nuestras tierras originales.\n\nDebería haberlo leído con más cuidado. Era un hombre orgulloso, demasiado orgulloso para escudriñar cada palabra.\n\nLara me pidió que cancelara el matrimonio porque Jard era cruel con ella. No públicamente — pero vi los moratones una vez. Elegí a mi hija sobre la política. Elegiría lo mismo de nuevo.\n\nMartyn activó la cláusula y se lo llevó todo. Protesté por los canales adecuados — y luego llegó la guerra. Perdí hombres. Él perdió la vida.\n\n¿Me siento responsable? Sí. Cometí el error de confiar en un hombre que ya había enterrado una trampa en el acuerdo. Ve a hablar con Lara y Jard. Decide qué crees que es justo.");
        cvBF3b.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.BRANTS_FALKERS, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBF3b);

        // ========================================
        // QUEST: BRANT_FAMILY — PART 5 (Confront Lord Den)
        // ========================================

        ConversationOption cvBrF5 = new ConversationOption(0, 3);
        cvBrF5.addOptionText(ENGLISH, "Your operation was raided, Lord Den. It's time to answer for what you've done.", "Raided? Yes... your Brant friends did not waste time.\n\n[He sits heavily, looking older than ever]\n\nI do not deny it. I dealt with the Swamp Island men. I had no choice — Letow starves on this soil while the Brants feast in their towers. I did what I had to do to keep my people alive.\n\nBut I am not a fool. I know when I am beaten.");
        cvBrF5.addOptionText(PORTUGUESE, "Sua operação foi destruída, Lorde Den. É hora de responder pelo que fez.", "Destruída? Sim... seus amigos dos Brant não desperdiçaram tempo.\n\n[Ele se senta pesadamente, parecendo mais velho do que nunca]\n\nNão nego. Negociei com os homens da Ilha do Pântano. Não tinha escolha — Letow passa fome neste solo enquanto os Brant festejam em suas torres. Fiz o que tinha que fazer para manter meu povo vivo.\n\nMas não sou tolo. Sei quando fui derrotado.");
        cvBrF5.addOptionText(SPANISH, "Su operación fue destruida, Lord Den. Es hora de responder por lo que hizo.", "¿Destruida? Sí... sus amigos de los Brant no perdieron tiempo.\n\n[Se sienta pesadamente, pareciendo más viejo que nunca]\n\nNo lo niego. Traté con los hombres de la Isla del Pantano. No tenía elección: Letow pasa hambre en este suelo mientras los Brant festejan en sus torres. Hice lo que tenía que hacer para mantener a mi gente con vida.\n\nPero no soy un tonto. Sé cuando he sido derrotado.");
        cvBrF5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANT_FAMILY, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvBrF5);

        ConversationOption cvBrF5b = new ConversationOption(3, 0);
        cvBrF5b.addOptionText(ENGLISH, "Then write a letter confessing what you've done.", "[He stares at you for a long moment, then reaches for parchment]\n\nA confession. To preserve what little I have left.\n\n[He writes deliberately, then folds the letter and presses it with his seal]\n\nThere. A full account of my dealings. My reasons. My regrets.\n\nTake it to whomever Jard sends you. I ask only that the injustice done to my family not be forgotten when this letter is read.\n\n[He hands you the folded letter]");
        cvBrF5b.addOptionText(PORTUGUESE, "Então escreva uma carta confessando o que fez.", "[Ele o encara por um longo momento, depois pega um pergaminho]\n\nUma confissão. Para preservar o pouco que ainda tenho.\n\n[Ele escreve deliberadamente, depois dobra a carta e a sela]\n\nAí está. Um relato completo dos meus negócios. Meus motivos. Meus arrependimentos.\n\nLeve a quem Jard te enviar. Só peço que a injustiça feita à minha família não seja esquecida quando esta carta for lida.\n\n[Ele lhe entrega a carta dobrada]");
        cvBrF5b.addOptionText(SPANISH, "Entonces escriba una carta confesando lo que hizo.", "[Te mira fijamente por un largo momento, luego toma un pergamino]\n\nUna confesión. Para preservar lo poco que me queda.\n\n[Escribe deliberadamente, luego dobla la carta y la sella]\n\nAquí está. Un relato completo de mis tratos. Mis razones. Mis arrepentimientos.\n\nLlévasela a quien Jard te envíe. Solo pido que la injusticia hecha a mi familia no sea olvidada cuando se lea esta carta.\n\n[Te entrega la carta doblada]");
        cvBrF5b.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.FALKER_APOLOGY_LETTER, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.BRANT_FAMILY, 6, App.getPlayerChar(), ctx);
            GameEngine.saveGame(ctx);
        };
        npc.conversationOptions.add(cvBrF5b);

        // ========================================
        // QUEST: FALKER_FAMILY — PART 1
        // ========================================

        ConversationOption cvFF1 = new ConversationOption(0, 4);
        cvFF1.addOptionText(ENGLISH, "I've chosen to help your family. What do you need?", "You chose wisely — or foolishly. Only time will tell.\n\nI have reason to believe the original land contract is still stored somewhere in the prison. Sir Martyn had it filed there as part of his 'administrative record' — ironically, in the very building he built on my family's land.\n\nIf that contract can be found, I believe it contains a clause that was never fully explained to me. A clause that may reveal the manipulation.\n\nGo to the Prison Office Room. Speak with the guard Brinn. He has access to the old archives.");
        cvFF1.addOptionText(PORTUGUESE, "Escolhi ajudar a sua família. O que precisa?", "Você escolheu sabiamente — ou tolamente. Só o tempo dirá.\n\nTenho razões para acreditar que o contrato original de terras ainda está guardado em algum lugar da prisão. Sir Martyn o arquivou lá como parte de seu 'registro administrativo' — ironicamente, no mesmo prédio que construiu nas terras da minha família.\n\nSe esse contrato puder ser encontrado, acredito que contém uma cláusula que nunca me foi totalmente explicada. Uma cláusula que pode revelar a manipulação.\n\nVá à Sala de Registros da Prisão. Fale com o guarda Brinn. Ele tem acesso aos arquivos antigos.");
        cvFF1.addOptionText(SPANISH, "Elegí ayudar a tu familia. ¿Qué necesitas?", "Elegiste sabiamente — o tontamente. Solo el tiempo lo dirá.\n\nTengo razones para creer que el contrato de tierras original todavía está guardado en algún lugar de la prisión. Sir Martyn lo archivó allí como parte de su 'registro administrativo' — irónicamente, en el mismo edificio que construyó en las tierras de mi familia.\n\nSi ese contrato puede encontrarse, creo que contiene una cláusula que nunca me fue completamente explicada. Una cláusula que puede revelar la manipulación.\n\nVe a la Sala de Registros de la Prisión. Habla con el guardia Brinn. Tiene acceso a los archivos antiguos.");
        cvFF1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FALKER_FAMILY, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvFF1);

        ConversationOption cvFF1b = new ConversationOption(4, 0);
        cvFF1b.addOptionText(ENGLISH, "I'll go to the prison and find the contract.", "Brinn is not a man easily moved by appeals to justice. But he is a man easily moved by good food and drink. Remember that.");
        cvFF1b.addOptionText(PORTUGUESE, "Irei à prisão e encontrarei o contrato.", "Brinn não é um homem facilmente movido por apelos à justiça. Mas é um homem facilmente movido por boa comida e bebida. Lembre-se disso.");
        cvFF1b.addOptionText(SPANISH, "Iré a la prisión y encontraré el contrato.", "Brinn no es un hombre fácilmente movido por apelaciones a la justicia. Pero es un hombre fácilmente movido por buena comida y bebida. Recuerda eso.");
        cvFF1b.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.FALKER_FAMILY, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFF1b);

        // ========================================
        // QUEST: FALKER_FAMILY — PART 8
        // ========================================

        ConversationOption cvFF9 = new ConversationOption(0, 5);
        cvFF9.addOptionText(ENGLISH, "Lady Jade ruled that Letow receives 20 heads of cattle as compensation.", "20 cattle.\n\n[He chuckles quietly]\n\nOf course it isn't enough. Twenty cattle does not feed the memory of what we lost.\n\nBut I am beyond petitions and appeals. If the kingdom will not give us what we deserve, we will take something in return. The Brant farms in Farmland have hundreds of cattle. We take some of theirs. Quietly. At night.\n\nGo to Farmland, guide the cattle south. My men will meet them at the Letow border.");
        cvFF9.addOptionText(PORTUGUESE, "Lady Jade determinou que Letow receba 20 cabeças de gado.", "Vinte cabeças de gado.\n\n[Ele ri suavemente]\n\nClaro que é insuficiente. Vinte cabeças não alimentam a memória do que perdemos.\n\nMas estou além de petições e apelos. Se o reino não nos dará o que merecemos, pegaremos algo em troca. As fazendas dos Brant em Farmland têm centenas de cabeças. Pegamos algumas deles. Silenciosamente. De madrugada.\n\nVá a Farmland, guie o gado para o sul. Meus homens os encontrarão na fronteira de Letow.");
        cvFF9.addOptionText(SPANISH, "Lady Jade dictaminó que Letow reciba 20 cabezas de ganado.", "Veinte cabezas de ganado.\n\n[Él ríe suavemente]\n\nClaro que és insuficiente. Veinte cabezas no alimentan la memoria de lo que perdimos.\n\nPero estoy más allá de las peticiones y las apelaciones. Si el reino no nos dará lo que merecemos, tomaremos algo a cambio. Las granjas de los Brant en Farmland tienen cientos de cabezas. Tomamos algunas de ellas. Silenciosamente. De noche.\n\nVe a Farmland, guía el ganado hacia el sur. Mis hombres los recibirán en la frontera de Letow.");
        cvFF9.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FALKER_FAMILY, 8)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvFF9);

        ConversationOption cvFF9b = new ConversationOption(5, 0);
        cvFF9b.addOptionText(ENGLISH, "I'll go to Farmland tonight.", "Good. And if the Brants notice some cattle went missing... well, animals wander sometimes. Who can say?");
        cvFF9b.addOptionText(PORTUGUESE, "Irei a Farmland esta noite.", "Bom. E se os Brant notarem que algumas cabeças sumiram... bem, animais vagam às vezes. Quem pode dizer?");
        cvFF9b.addOptionText(SPANISH, "Iré a Farmland esta noche.", "Bien. Y si los Brant notan que falta algo de ganado... bueno, los animales vagan a veces. ¿Quién puede decirlo?");
        cvFF9b.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.FALKER_FAMILY, 9, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFF9b);

        // ========================================
        // QUEST: FALKER_FAMILY — PART 10 (Complete)
        // ========================================

        ConversationOption cvFF11 = new ConversationOption(0, 0);
        cvFF11.addOptionText(ENGLISH, "The cattle are in Letow. The Brants noticed nothing.", "[He closes his eyes for a moment, then opens them with quiet satisfaction]\n\nGood. Very good.\n\nI may be old, and my lands may be barren. But I still have cunning. And now I have cattle.\n\nYou have done something that years of legal battles could not. The Falker name can hold its head up again. Thank you, stranger.\n\nTake this — it is not much, but it is all I can honestly give.");
        cvFF11.addOptionText(PORTUGUESE, "O gado está em Letow. Os Brant não notaram nada.", "[Ele fecha os olhos por um momento, depois os abre com satisfação tranquila]\n\nBom. Muito bom.\n\nPosso ser velho, e minhas terras podem ser áridas. Mas ainda tenho astúcia. E agora tenho gado.\n\nVocê fez algo que anos de batalhas legais não conseguiram. O nome Falker pode erguer a cabeça novamente. Obrigado, estranho.\n\nPegue isso — não é muito, mas é tudo que posso honestamente dar.");
        cvFF11.addOptionText(SPANISH, "El ganado está en Letow. Los Brant no notaron nada.", "[Cierra los ojos por un momento, luego los abre con tranquila satisfacción]\n\nBien. Muy bien.\n\nPuedo ser viejo, y mis tierras pueden ser áridas. Pero todavía tengo astucia. Y ahora tengo ganado.\n\nHas hecho algo que años de batallas legales no pudieron. El nombre Falker puede volver a levantar la cabeza. Gracias, forastero.\n\nToma esto — no es mucho, pero es todo lo que puedo dar honestamente.");
        cvFF11.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FALKER_FAMILY, 10)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvFF11.listeners = (ctx, currentFragment) -> {
            App.getPlayerChar().attributesManager.increase(Enums.AttributeName.ALIGNMENT, 10);
            LibQuest.completeQuest(QuestsIds.FALKER_FAMILY, App.getPlayerChar(), 11, ctx);
        };
        npc.conversationOptions.add(cvFF11);

        // ========================================
        // POST-QUEST: BRANT_FAMILY — Den FURIOUS
        // ========================================

        ConversationOption cvBrFFurious = new ConversationOption(0, 0);
        cvBrFFurious.addOptionText(ENGLISH, "Lord Den...", "Do not speak to me. You come here after what you've done?\n\nMy house. My home. Burned to the ground while I slept nearby.\n\nI do not forget. And I do not forgive. Whatever coin Jard paid you — I hope you spend it wisely, because you will find no friend here.\n\nLeave. Now.");
        cvBrFFurious.addOptionText(PORTUGUESE, "Lorde Den...", "Não me fale. Você vem aqui depois do que fez?\n\nMinha casa. Meu lar. Queimado até o chão enquanto eu dormia nas proximidades.\n\nNão esqueço. E não perdoo. Qualquer moeda que Jard te pagou — espero que gaste bem, porque não encontrará amigo aqui.\n\nVá embora. Agora.");
        cvBrFFurious.addOptionText(SPANISH, "Lord Den...", "No me hables. ¿Vienes aquí después de lo que hiciste?\n\nMi casa. Mi hogar. Quemado hasta los cimientos mientras yo dormía cerca.\n\nNo olvido. Y no perdono. Cualquier moneda que Jard te pagó — espero que la gastes bien, porque no encontrarás amigo aquí.\n\nVete. Ahora.");
        cvBrFFurious.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(QuestsIds.BRANT_FAMILY, chara)) {
                for (int p : new int[]{9, 10, 11, 12}) {
                    if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANT_FAMILY, p)) {
                        return Enums.RequirementVerification.OK;
                    }
                }
            }
            if (LibQuest.isQuestComplete(chara, QuestsIds.BRANT_FAMILY)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvBrFFurious);

        // General roleplay conversation
        ConversationOption cvRoleplay = new ConversationOption(0, 0);
        cvRoleplay.addOptionText(ENGLISH, "Tell me about Letow.", "Letow... This land was given to me by King Oriun, after Sir Martyn Brant took my family's lands to build his prison. They said it was a fair trade, but look around - this soil is harsh, difficult. We've made it work through sheer determination. My people are tough, skilled, and loyal. We may not have the fertile lands of Farmland or the wealth of Monelix, but we survive. We always survive.");
        cvRoleplay.addOptionText(PORTUGUESE, "Conte-me sobre Letow.", "Letow... Esta terra me foi dada pelo Rei Oriun, depois que Sir Martyn Brant tomou as terras da minha família para construir a prisão. Disseram que era uma troca justa, mas olhe ao redor - este solo é áspero, difícil. Nós fizemos isso funcionar através de pura determinação. Meu povo é resistente, habilidoso e leal. Podemos não ter as terras férteis de Farmland ou a riqueza de Monelix, mas sobrevivemos. Sempre sobrevivemos.");
        cvRoleplay.addOptionText(SPANISH, "Cuéntame sobre Letow.", "Letow... Esta tierra me fue dada por el Rey Oriun, después de que Sir Martyn Brant tomara las tierras de mi familia para construir su prisión. Dijeron que era un intercambio justo, pero mira alrededor - este suelo es áspero, difícil. Lo hemos hecho funcionar a través de pura determinación. Mi gente es resistente, hábil y leal. Puede que no tengamos las tierras fértiles de Farmland o la riqueza de Monelix, pero sobrevivimos. Siempre sobrevivimos.");
        cvRoleplay.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(QuestsIds.BRANT_FAMILY, chara)) {
                for (int p : new int[]{9, 10, 11, 12}) {
                    if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BRANT_FAMILY, p)) {
                        return Enums.RequirementVerification.NOT_OK;
                    }
                }
            }
            if (LibQuest.isQuestComplete(chara, QuestsIds.BRANT_FAMILY)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cvRoleplay);

        return npc;
    }
}