package com.cnx.endlesstalestwo.data.npcs.esperand.monastery;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.Contraband;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class BrotherMordius extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Brother Mordius");
        npc.addNameTranslation(PORTUGUESE, "Irmão Mordius");
        npc.addNameTranslation(SPANISH, "Hermano Mordius");
        npc.age = 45;
        npc.job = Enums.NPCJobs.PRIEST;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "He carries a heavy aura. He does not seem kind.\nHe pretends to be faithful, but values material gain more.\nClever and mysterious.\n\nHis physical traits: Very short blond hair and bald on top, small eyes with a dark stare, and an aged face with a malicious smile.");
        npc.addDescriptionTranslation(PORTUGUESE, "Passa uma energia pesada. Não parece ser bondoso.\nFinge ser fiel na fé, mas valoriza mais a materialização.\nEsperto e misterioso.\n\nSeus traços físicos: cabelo bem curto, loiro e careca no topo. Olhos pequenos e olhar sombrio. Rosto envelhecido com sorriso malicioso.");
        npc.addDescriptionTranslation(SPANISH, "Transmite una energía pesada. No parece bondadoso.\nFinge ser fiel en la fe, pero valora más lo material.\nAstuto y misterioso.\n\nSus rasgos físicos: Cabello muy corto y rubio, calvo en la parte superior, ojos pequeños con mirada sombría y rostro envejecido con sonrisa maliciosa.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("...Greetings."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("...Saudações."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("...Saludos."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Walk carefully."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Caminhe com cuidado."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Camina con cuidado."));

        // ===== ROLEPLAY: Quiet and shadowy =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "You seem different from the other priests.", "*Brief glance*\nEveryone has their... purpose. Mine is quieter than most. I prefer solitude.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Você parece diferente dos outros sacerdotes.", "*Olhar breve*\nTodos têm seu... propósito. O meu é mais silencioso que a maioria. Prefiro a solidão.");
        cvRoleplay1.addOptionText(SPANISH, "Pareces diferente de los otros sacerdotes.", "*Mirada breve*\nTodos tienen su... propósito. El mío es más silencioso que la mayoría. Prefiero la soledad.");
        cvRoleplay1.requirementValidations = (chara, ctx) -> {
            // Only before quest starts
            if (!LibQuest.charHasQuest(QuestsIds.SMUGGLER, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY: About the monastery =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Do you like living here?", "It serves... certain needs. The walls provide cover. The prayers provide... noise. Sometimes one must work in shadows even in houses of light.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Você gosta de viver aqui?", "Serve... certas necessidades. As paredes fornecem cobertura. As orações fornecem... barulho. Às vezes é preciso trabalhar nas sombras mesmo em casas de luz.");
        cvRoleplay2.addOptionText(SPANISH, "¿Te gusta vivir aquí?", "Sirve... ciertas necesidades. Las paredes proporcionan cobertura. Las oraciones proporcionan... ruido. A veces uno debe trabajar en las sombras incluso en casas de luz.");
        npc.conversationOptions.add(cvRoleplay2);

        // ===== QUEST: Smuggler - Introduction (requires EVIL alignment ≤25) =====
        ConversationOption cvQuest1 = new ConversationOption(0, 1);
        cvQuest1.addOptionText(ENGLISH, "You look like someone who deals in... less conventional business.", "*Eyes narrow, studying you carefully*\nPerhaps. \n*Long pause*\nYou don't have the look of a saint yourself. That could be... useful.");
        cvQuest1.addOptionText(PORTUGUESE, "Você parece alguém que lida com... negócios menos convencionais.", "*Olhos se estreitam, estudando você cuidadosamente*\nTalvez. \n*Longa pausa*\nVocê não tem cara de santo. Isso poderia ser... útil.");
        cvQuest1.addOptionText(SPANISH, "Pareces alguien que trata con... negocios menos convencionales.", "*Los ojos se estrechan, estudiándote cuidadosamente*\nQuizás. \n*Larga pausa*\nNo tienes aspecto de santo. Eso podría ser... útil.");
        cvQuest1.requirementValidations = (chara, ctx) -> {
            // Requires EVIL alignment (≤25) and quest not started
            if (!LibQuest.charHasQuest(QuestsIds.SMUGGLER, chara)) {
                if (chara.attributesManager.getCurrent(Enums.AttributeName.ALIGNMENT) <= 25) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuest1);

        ConversationOption cvQuest2 = new ConversationOption(1, 2);
        cvQuest2.addOptionText(ENGLISH, "I'm listening.", "*Lowers voice*\nI have... business associates. They pay well for certain goods. Problem is, the city guards watch too closely. I need someone who can move unnoticed. Someone who doesn't ask questions.");
        cvQuest2.addOptionText(PORTUGUESE, "Estou ouvindo.", "*Abaixa a voz*\nEu tenho... associados de negócios. Eles pagam bem por certas mercadorias. O problema é que os guardas da cidade observam de perto demais. Preciso de alguém que possa se mover despercebido. Alguém que não faça perguntas.");
        cvQuest2.addOptionText(SPANISH, "Estoy escuchando.", "*Baja la voz*\nTengo... asociados de negocios. Pagan bien por ciertas mercancías. El problema es que los guardias de la ciudad vigilan demasiado de cerca. Necesito a alguien que pueda moverse sin ser notado. Alguien que no haga preguntas.");
        npc.conversationOptions.add(cvQuest2);

        ConversationOption cvQuest3 = new ConversationOption(2, 3);
        cvQuest3.addOptionText(ENGLISH, "What kind of goods?", "*Dismissive wave*\nIrrelevant. What matters is this: there's a package waiting at the Esperand docks. Hidden near the old crates. You take it to my... friends... at the Barbarian Settlement. They give you payment. You bring my cut back here. Simple.");
        cvQuest3.addOptionText(PORTUGUESE, "Que tipo de mercadorias?", "*Gesto desdenhoso*\nIrrelevante. O que importa é isto: há um pacote esperando nas docas de Esperand. Escondido perto das caixas velhas. Você leva para meus... amigos... no Assentamento Bárbaro. Eles te dão o pagamento. Você traz minha parte de volta aqui. Simples.");
        cvQuest3.addOptionText(SPANISH, "¿Qué tipo de mercancías?", "*Gesto desdeñoso*\nIrrelevante. Lo que importa es esto: hay un paquete esperando en los muelles de Esperand. Escondido cerca de las cajas viejas. Lo llevas a mis... amigos... en el Asentamiento Bárbaro. Te dan el pago. Traes mi parte de vuelta aquí. Simple.");
        npc.conversationOptions.add(cvQuest3);

        ConversationOption cvQuest4 = new ConversationOption(3, 0);
        cvQuest4.addOptionText(ENGLISH, "I'll do it. For the right price.", "*Cold smile*\nYour share will be generous. Just remember - discretion is essential. If you speak of this to anyone, the deal ends badly. For both of us. \n*Hands you a small marked token*\nShow this to the barbarians. They'll know you're working for me.");
        cvQuest4.addOptionText(PORTUGUESE, "Farei isso. Pelo preço certo.", "*Sorriso frio*\nSua parte será generosa. Apenas lembre-se - discrição é essencial. Se você falar disso para alguém, o negócio acaba mal. Para ambos. \n*Entrega uma pequena ficha marcada*\nMostre isso aos bárbaros. Eles saberão que você trabalha para mim.");
        cvQuest4.addOptionText(SPANISH, "Lo haré. Por el precio correcto.", "*Sonrisa fría*\nTu parte será generosa. Solo recuerda: la discreción es esencial. Si hablas de esto con alguien, el trato termina mal. Para ambos. \n*Te entrega una pequeña ficha marcada*\nMuestra esto a los bárbaros. Sabrán que trabajas para mí.");
        cvQuest4.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.SMUGGLER, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuest4);

        // ===== QUEST: Smuggler - Part 3 (Return with payment) =====
        ConversationOption cvReturn = new ConversationOption(0, 4);
        cvReturn.addOptionText(ENGLISH, "I have the payment from the barbarians.", "*Quickly counts the coins*\nGood. Very good. You kept your mouth shut and completed the job. \n*Takes his share*\nHere's your cut. You've proven... reliable.");
        cvReturn.addOptionText(PORTUGUESE, "Tenho o pagamento dos bárbaros.", "*Conta rapidamente as moedas*\nBom. Muito bom. Você manteve a boca fechada e completou o trabalho. \n*Pega sua parte*\nAqui está sua parte. Você provou ser... confiável.");
        cvReturn.addOptionText(SPANISH, "Tengo el pago de los bárbaros.", "*Cuenta rápidamente las monedas*\nBien. Muy bien. Mantuviste la boca cerrada y completaste el trabajo. \n*Toma su parte*\nAquí está tu parte. Has demostrado ser... confiable.");
        cvReturn.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SMUGGLER, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvReturn);

        ConversationOption cvComplete = new ConversationOption(4, 0);
        cvComplete.addOptionText(ENGLISH, "[Take your share]", "Remember - this conversation never happened. If anyone asks, you were here for... spiritual guidance. \n*Cold eyes*\nThere may be more opportunities in the future. For those willing to work in the shadows.");
        cvComplete.addOptionText(PORTUGUESE, "[Pegue sua parte]", "Lembre-se - essa conversa nunca aconteceu. Se alguém perguntar, você estava aqui para... orientação espiritual. \n*Olhos frios*\nPode haver mais oportunidades no futuro. Para aqueles dispostos a trabalhar nas sombras.");
        cvComplete.addOptionText(SPANISH, "[Toma tu parte]", "Recuerda: esta conversación nunca ocurrió. Si alguien pregunta, estabas aquí para... orientación espiritual. \n*Ojos fríos*\nPuede haber más oportunidades en el futuro. Para aquellos dispuestos a trabajar en las sombras.");
        cvComplete.listeners = (ctx, currentFragment) -> {
            App.getPlayerChar().attributesManager.decrease(Enums.AttributeName.ALIGNMENT, 8);
            LibQuest.completeQuest(QuestsIds.SMUGGLER, App.getPlayerChar(), 4, ctx);
        };
        npc.conversationOptions.add(cvComplete);

        // ===== ROLEPLAY: After quest completion =====
        ConversationOption cvAfterQuest = new ConversationOption(0, 0);
        cvAfterQuest.addOptionText(ENGLISH, "Any more... opportunities?", "*Brief nod*\nNot at this moment. These things require... timing. Maybe you need more 'evilness'... then you'll be considered.");
        cvAfterQuest.addOptionText(PORTUGUESE, "Mais alguma... oportunidade?", "*Aceno breve*\nNão neste momento. Essas coisas exigem... tempo. Talvez você precise mais 'maldade'... então você será considerado.");
        cvAfterQuest.addOptionText(SPANISH, "¿Alguna... oportunidad más?", "*Asentimiento breve*\nNo en este momento. Estas cosas requieren... tiempo. Quizás necesitas más 'maldad'... entonces serás considerado.");
        cvAfterQuest.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.SMUGGLER)
                    && chara.attributesManager.getCurrent(Enums.AttributeName.ALIGNMENT) > 20
                    && !LibQuest.charHasQuest(QuestsIds.CONTRABAND, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAfterQuest);

        // ========================================
        // QUEST: CONTRABAND
        // ========================================

        // Start quest (after Smuggler complete + alignment <= 20)
        ConversationOption cvContrabandOffer = new ConversationOption(0, 10);
        cvContrabandOffer.addOptionText(ENGLISH, "Do you have another... job for me?",
                "*He glances around carefully, then lowers his voice*\nYou proved yourself with the last task. Now I have something more... complex.\nA package needs to be collected from Cradul at the Barbarian Settlement. Then brought back here so I can add certain goods and attach the monastery seal. After that, it must be delivered discreetly. Interested?");
        cvContrabandOffer.addOptionText(PORTUGUESE, "Você tem outro... trabalho para mim?",
                "*Ele olha ao redor com cuidado, depois abaixa a voz*\nVocê provou seu valor na última tarefa. Agora tenho algo mais... complexo.\nUm pacote precisa ser coletado de Cradul no Assentamento Bárbaro. Depois trazido aqui para que eu possa adicionar certas mercadorias e afixar o selo do monastério. Depois disso, deve ser entregue discretamente. Interessado?");
        cvContrabandOffer.addOptionText(SPANISH, "¿Tienes otro... trabajo para mí?",
                "*Mira alrededor con cuidado, luego baja la voz*\nTe demostraste con la última tarea. Ahora tengo algo más... complejo.\nUn paquete necesita ser recogido de Cradul en el Asentamiento Bárbaro. Luego traído aquí para que pueda agregarle ciertas mercancías y colocar el sello del monasterio. Después de eso, debe ser entregado discretamente. ¿Interesado?");
        cvContrabandOffer.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.SMUGGLER)
                    && !LibQuest.charHasQuest(QuestsIds.CONTRABAND, chara)
                    && chara.attributesManager.getCurrent(Enums.AttributeName.ALIGNMENT) <= 20) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvContrabandOffer);

        ConversationOption cvContrabandAccept = new ConversationOption(10, 0);
        cvContrabandAccept.addOptionText(ENGLISH, "I'm in. Where do I start?",
                "*A thin smile*\nGo to Cradul at the Barbarian Settlement. He has the package. Bring it back here before you go anywhere else. I will take care of the rest.\nAnd remember — discretion above all. Not a word.");
        cvContrabandAccept.addOptionText(PORTUGUESE, "Eu topo. Por onde começo?",
                "*Um sorriso tênue*\nVá até Cradul no Assentamento Bárbaro. Ele tem o pacote. Traga-o de volta aqui antes de ir a qualquer outro lugar. Eu cuido do resto.\nE lembre-se — discrição acima de tudo. Nem uma palavra.");
        cvContrabandAccept.addOptionText(SPANISH, "Me apunto. ¿Por dónde empiezo?",
                "*Una sonrisa tenue*\nVe a Cradul en el Asentamiento Bárbaro. Él tiene el paquete. Tráelo aquí antes de ir a cualquier otro lugar. Yo me encargaré del resto.\nY recuerda — discreción ante todo. Ni una palabra.");
        cvContrabandAccept.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(Contraband.get(), App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvContrabandAccept);

        ConversationOption cvContrabandDecline = new ConversationOption(10, 0);
        cvContrabandDecline.addOptionText(ENGLISH, "Not now.", "*He nods slowly*\nAs you wish. The offer remains... for those with the nerve.");
        cvContrabandDecline.addOptionText(PORTUGUESE, "Agora não.", "*Ele acena lentamente*\nComo quiser. A oferta permanece... para quem tiver coragem.");
        cvContrabandDecline.addOptionText(SPANISH, "Ahora no.", "*Asiente lentamente*\nComo desees. La oferta permanece... para quienes tengan el coraje.");
        npc.conversationOptions.add(cvContrabandDecline);

        // Part 2: Player brings the package → Mordius seals it + random destination
        ConversationOption cvContrabandPart2 = new ConversationOption(0, 0);
        cvContrabandPart2.addOptionText(ENGLISH, "I have a package from Cradul.",
                "*He takes it quickly and moves to his back room*\n\n*Returns shortly with the package visibly heavier and bearing the monastery's wax seal*\n\nDone. The contents have been... enriched, and the seal confirms its official monastery origins. No one questions monastery shipments.\n\n*His eyes fix on yours*\n\nNow get it to destination, it is written in the package.");
        cvContrabandPart2.addOptionText(PORTUGUESE, "Tenho um pacote de Cradul.",
                "*Ele o pega rapidamente e vai para o seu quarto dos fundos*\n\n*Retorna em breve com o pacote visivelmente mais pesado e com o selo de cera do monastério*\n\nFeito. O conteúdo foi... enriquecido, e o selo confirma suas origens oficiais do monastério. Ninguém questiona os carregamentos do monastério.\n\n*Seus olhos fixam nos seus*\n\nAgora leve isso para o destino, está escrito no pacote.");
        cvContrabandPart2.addOptionText(SPANISH, "Tengo uno paquete de Cradul.",
                "*Lo toma rápidamente y va a su sala trasera*\n\n*Regresa pronto con el paquete visiblemente más pesado y con el sello de cera del monasterio*\n\nHecho. El contenido ha sido... enriquecido, y el sello confirma sus orígenes oficiales del monasterio. Nadie cuestiona los envíos del monasterio.\n\n*Sus ojos fijan en los tuyos*\n\nAhora délo al destino, está escrito en el paquete.");
        cvContrabandPart2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CONTRABAND, 2)
                    && LibInventory.checkHasItem(ItemsIds.CONTRABAND_PACKAGE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvContrabandPart2.listeners = (ctx, currentFragment) -> {
            // Random destination: 31 = Swamp Fortress (Galdor), 32 = Orc Village (Korzk), 33 = Prison (Brinn)
            int roll = LibUtils.getRandom(1, 3);
            int nextPart = (roll == 1) ? 31 : (roll == 2) ? 32 : 33;
            LibQuest.updateQuest(QuestsIds.CONTRABAND, nextPart, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvContrabandPart2);

        // Part 4: Player returns after delivering → Mordius gives Monastery Shipment Report
        ConversationOption cvContrabandPart4 = new ConversationOption(0, 0);
        cvContrabandPart4.addOptionText(ENGLISH, "The delivery is done.",
                "*He exhales quietly*\nGood. No complications, I trust?\n\n*He reaches into a drawer and produces an official-looking document*\n\nThis is a falsified monastery shipment ledger entry. Take it to Esperand City Hall — my contact there will swap it with the real record. Once that is done, the fake shipment disappears from the official documents entirely.\n\nDo not lose it.");
        cvContrabandPart4.addOptionText(PORTUGUESE, "A entrega foi feita.",
                "*Ele expira silenciosamente*\nBom. Sem complicações, espero?\n\n*Ele alcança uma gaveta e produz um documento com aparência oficial*\n\nEste é um registro falsificado de remessa do monastério. Leve ao City Hall de Esperand — meu contato lá vai trocá-lo pelo registro real. Feito isso, a remessa falsa desaparece completamente dos documentos oficiais.\n\nNão o perca.");
        cvContrabandPart4.addOptionText(SPANISH, "La entrega está hecha.",
                "*Exhala silenciosamente*\nBien. Sin complicaciones, espero?\n\n*Saca de un cajón un documento de apariencia oficial*\n\nEste es un registro falso de envío del monasterio. Llévalo al Ayuntamiento de Esperand — mi contacto allí lo intercambiará con el registro real. Una vez hecho eso, el envío falso desaparece completamente de los documentos oficiales.\n\nNo lo pierdas.");
        cvContrabandPart4.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CONTRABAND, 40)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvContrabandPart4.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.MONASTERY_SHIPMENT_REPORT, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.CONTRABAND, 50, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvContrabandPart4);

        // Part 6: Player returns after city hall → Complete quest
        ConversationOption cvContrabandPart6 = new ConversationOption(0, 0);
        cvContrabandPart6.addOptionText(ENGLISH, "The records have been altered. Everything is clean.",
                "*For a moment, something like satisfaction crosses his cold face*\nExcellent. The shipment never existed. The monastery's reputation is intact, and our transaction is complete.\n\n*He counts out coins and slides them across*\n\nYour payment. And a little extra for... clean work.\n\nAs always — this conversation never happened.");
        cvContrabandPart6.addOptionText(PORTUGUESE, "Os registros foram alterados. Tudo limpo.",
                "*Por um momento, algo parecido com satisfação cruza seu rosto frio*\nExcelente. O carregamento nunca existiu. A reputação do monastério está intacta, e nossa transação está concluída.\n\n*Conta algumas moedas e as desliza pela mesa*\n\nSeu pagamento. E um pouco extra por... trabalho limpo.\n\nComo sempre — essa conversa nunca aconteceu.");
        cvContrabandPart6.addOptionText(SPANISH, "Los registros han sido alterados. Todo limpio.",
                "*Por un momento, algo parecido a la satisfacción cruza su rostro frío*\nExcelente. El envío nunca existió. La reputación del monasterio está intacta, y nuestra transacción está completa.\n\n*Cuenta unas monedas y las desliza por la mesa*\n\nTu pago. Y un poco extra por... trabajo limpio.\n\nComo siempre — esta conversación nunca ocurrió.");
        cvContrabandPart6.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CONTRABAND, 60)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvContrabandPart6.listeners = (ctx, currentFragment) -> {
            LibQuest.completeQuest(QuestsIds.CONTRABAND, App.getPlayerChar(), 70, ctx);
        };
        npc.conversationOptions.add(cvContrabandPart6);

        // Part 1 (restartable continuation): Quest was completed and restarted — remind player to go to Cradul
        ConversationOption cvContrabandRestart = new ConversationOption(0, 0);
        cvContrabandRestart.addOptionText(ENGLISH, "Ready for another run.",
                "*He barely moves, just the slightest nod*\nGood. You know what to do. Go to Cradul at the Barbarian Settlement. Bring me what he has. No more words needed.");
        cvContrabandRestart.addOptionText(PORTUGUESE, "Pronto para mais uma rodada.",
                "*Ele mal se move, apenas um leve aceno*\nBom. Você sabe o que fazer. Vá até Cradul no Assentamento Bárbaro. Me traga o que ele tiver. Não são necessárias mais palavras.");
        cvContrabandRestart.addOptionText(SPANISH, "Listo para otra ronda.",
                "*Apenas se mueve, solo un leve asentimiento*\nBien. Sabes lo que hay que hacer. Ve a Cradul en el Asentamiento Bárbaro. Tráeme lo que tenga. No hacen falta más palabras.");
        cvContrabandRestart.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(QuestsIds.CONTRABAND, chara)
                    && LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CONTRABAND, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvContrabandRestart);

        return npc;
    }
}
