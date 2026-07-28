package com.cnx.endlesstalestwo.data.npcs.lisport.Tavern;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.LIKE_A_LANDLORD;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Gareth extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Gareth");
        npc.age = 42;
        npc.job = Enums.NPCJobs.MALE_FARMER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Solitary and quiet. A somewhat 'bland' man.\nDoesn't seem very satisfied with his life, but lives it one day at a time.\nA worker who knows his craft well.\n\nPhysical traits: Bald on the top of his head. Thin cheeks. Light green eyes and short beard and mustache.");
        npc.addDescriptionTranslation(PORTUGUESE, "Solitário e quieto. Um homem meio 'sem sal'.\nParece não estar muito satisfeito com sua vida, mas vai vivendo um dia de cada vez.\nTrabalhador que conhece bem seu ofício.\n\nSeus taços físicos: Calvo no topo da cabeça. bochechas magras. Olhos verdes claros e barba e bigode curtos.");
        npc.addDescriptionTranslation(SPANISH, "Solitario y callado. Un hombre algo 'soso'.\nNo parece muy satisfecho con su vida, pero la vive un día a la vez.\nUn trabajador que conoce bien su oficio.\n\nTrasos físicos: Calvo en la parte superior de la cabeza. Mejillas delgadas. Ojos verde claro y barba y bigote cortos.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hello there."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola."));

        // Only exists during quest
        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(LIKE_A_LANDLORD, chara) && !LibQuest.isQuestComplete(chara, LIKE_A_LANDLORD)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // ===== QUEST: Like a Landlord =====

        // Initial question about buying land
        ConversationOption cvQuestStart = new ConversationOption(0, 1);
        cvQuestStart.addOptionText(ENGLISH, "Would you be interested in buying land in Havarus?", "*Looks up from his work, pausing thoughtfully*\n\nHavarus? Land there, you say?\n\n*Rubs his calloused hands*\n\nI've been farming these small plots in Lisport for years, barely making enough to feed my family. The soil here is thin, and the market is limited.\n\n*Hesitates, looking uncertain*\n\nBut... moving to another kingdom? That's a big decision. Leaving everything I know here... I don't know. It would be a risk.");
        cvQuestStart.addOptionText(PORTUGUESE, "Você estaria interessado em comprar terra em Havarus?", "*Levanta o olhar de seu trabalho, pausando pensativamente*\n\nHavarus? Terra lá, você diz?\n\n*Esfrega as mãos calejadas*\n\nEu cultivo essas pequenas parcelas em Lisport há anos, mal ganhando o suficiente para alimentar minha família. O solo aqui é fino e o mercado é limitado.\n\n*Hesita, parecendo incerto*\n\nMas... mudar para outro reino? Essa é uma grande decisão. Deixar tudo que conheço aqui... não sei. Seria um risco.");
        cvQuestStart.addOptionText(SPANISH, "¿Estarías interesado en comprar tierra en Havarus?", "*Levanta la vista de su trabajo, haciendo una pausa pensativa*\n\n¿Havarus? ¿Tierra allí, dices?\n\n*Se frota las manos callosas*\n\nHe estado cultivando estas pequeñas parcelas en Lisport durante años, apenas ganando lo suficiente para alimentar a mi familia. El suelo aquí es delgado y el mercado es limitado.\n\n*Duda, pareciendo inseguro*\n\nPero... ¿mudarme a otro reino? Esa es una gran decisión. Dejar todo lo que conozco aquí... no sé. Sería un riesgo.");
        cvQuestStart.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, LIKE_A_LANDLORD, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestStart);

        // Option to persuade (requires Charisma 14+)
        ConversationOption cvPersuade = new ConversationOption(1, 0);
        cvPersuade.addOptionText(ENGLISH, "[Persuade] Think about the opportunities in Havarus.(Charisma 14)", "*Leans forward, listening carefully to your words*\n\nYou're right... Havarus is the great kingdom with larger markets and more fertile land. Better opportunities to sell my crops. If I could buy good farmland there, I could finally expand my operations, maybe even hire some help.\n\n*Nods slowly, becoming convinced*\n\nYou know what? You've convinced me. If Lord Markus is offering land at a fair price, I'll take it. Tell him Gareth the farmer accepts his offer. I'll start preparing to move my family soon.");
        cvPersuade.addOptionText(PORTUGUESE, "[Persuadir] Pense nas oportunidades em Havarus.(Carisma 14)", "*Inclina-se para frente, ouvindo suas palavras atentamente*\n\nVocê está certo... Havarus é o grande reino com mercados maiores e terra mais fértil. Melhores oportunidades para vender minhas colheitas. Se eu pudesse comprar boa terra de cultivo lá, eu finalmente poderia expandir minhas operações, talvez até contratar alguma ajuda.\n\n*Acena lentamente, ficando convencido*\n\nSabe de uma coisa? Você me convenceu. Se Lorde Markus estiver oferecendo terra a um preço justo, eu aceito. Diga a ele que Gareth, o fazendeiro, aceita sua oferta. Vou começar a preparar minha família para a mudança em breve.");
        cvPersuade.addOptionText(SPANISH, "[Persuadir] Piensa en las oportunidades en Havarus.(Carisma 14)", "*Se inclina hacia adelante, escuchando tus palabras atentamente*\n\nTienes razón... Havarus es el gran reino con mercados más grandes y tierra más fértil. Mejores oportunidades para vender mis cultivos. Si pudiera comprar buena tierra de cultivo allí, finalmente podría expandir mis operaciones, tal vez incluso contratar ayuda.\n\n*Asiente lentamente, quedando convencido*\n\n¿Sabes qué? Me has convencido. Si Lord Markus ofrece tierra a un precio justo, la tomaré. Dile a Gareth el granjero que acepta su oferta. Comenzaré a preparar a mi familia para mudarnos pronto.");
        cvPersuade.requirementValidations = (chara, ctx) -> {
            int charisma = chara.attributesManager.getCurrent(Enums.AttributeName.CHARISMA);
            if (charisma >= 14) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_ATTRIBUTES;
        };
        cvPersuade.showEvenWhenNotValid = true;
        cvPersuade.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(LIKE_A_LANDLORD);
            LibQuest.updateQuest(quest, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPersuade);

        // Option to let him think about it (quest stays in standby)
        ConversationOption cvLetThink = new ConversationOption(1, 0);
        cvLetThink.addOptionText(ENGLISH, "Take your time to think about it.", "Yes... I need to think this through carefully. It's not a decision to make lightly. Come back later, maybe I'll have an answer then.");
        cvLetThink.addOptionText(PORTUGUESE, "Tome seu tempo para pensar sobre isso.", "Sim... preciso pensar nisso com cuidado. Não é uma decisão para tomar de ânimo leve. Volte mais tarde, talvez eu tenha uma resposta então.");
        cvLetThink.addOptionText(SPANISH, "Tómate tu tiempo para pensarlo.", "Sí... necesito pensar esto cuidadosamente. No es una decisión para tomar a la ligera. Vuelve más tarde, tal vez tenga una respuesta entonces.");
        npc.conversationOptions.add(cvLetThink);

        npc.hasRandomizedConversations = true;
        return npc;
    }
}



