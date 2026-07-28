package com.cnx.endlesstalestwo.data.npcs.lisport.Church;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.LIKE_A_LANDLORD;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Elena extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Elena");
        npc.age = 22;
        npc.job = Enums.NPCJobs.STUDENT;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A dreamy and loyal girl. It is easy to see that she wants to live a better life than Lisport can offer.\nShe is brave but still innocent.\nDaughter of Alden.\n\nPhysical traits: Short hair, thin face. Light brown eyes, thin nose and full lips.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma garota sonhadora e fiel. É fácil perceber que quer viver uma vida melhor do que Lisport pode oferecer.\nÉ corajosa mas também ainda inocente.\nFilha de Alden.\n\nSeus taços físicos: Cabelos curtos, rosto magro. Olhos castanhos claros, nariz fino e lábios grossos.");
        npc.addDescriptionTranslation(SPANISH, "Una chica soñadora y leal. Es fácil ver que quiere vivir una vida mejor de la que Lisport puede ofrecer.\nEs valiente pero aún inocente.\nHija de Alden.\n\nTrasos físicos: Cabello corto, cara delgada. Ojos castaño claro, nariz delgada y labios llenos.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Good day."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bom dia."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Buen día."));

        // Only exists during quest
        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(LIKE_A_LANDLORD, chara) && !LibQuest.isQuestComplete(chara, LIKE_A_LANDLORD)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // ===== QUEST: Like a Landlord =====

        // Initial question about buying house
        ConversationOption cvQuestStart = new ConversationOption(0, 1);
        cvQuestStart.addOptionText(ENGLISH, "Would you be interested in buying a house in Havarus?", "*Looks up from her books, eyes brightening slightly*\n\nA house in Havarus? The great kingdom with its grand libraries and schools of learning?\n\n*Clutches her books closer*\n\nI've read so much about it... I've exhausted every book in our small collection here in Lisport. I dream of studying there, learning from the great scholars.\n\n*Her excitement fades, looking uncertain*\n\nBut... I've never had the means or opportunity. And leaving my father here... I don't know. It's a big step.");
        cvQuestStart.addOptionText(PORTUGUESE, "Você estaria interessada em comprar uma casa em Havarus?", "*Levanta o olhar de seus livros, os olhos brilhando levemente*\n\nUma casa em Havarus? O grande reino com suas grandes bibliotecas e escolas de aprendizado?\n\n*Aperta seus livros mais perto*\n\nEu li tanto sobre isso... esgotei todos os livros de nossa pequena coleção aqui em Lisport. Sonho em estudar lá, aprender com os grandes estudiosos.\n\n*Sua empolgação diminui, parecendo incerta*\n\nMas... nunca tive os meios ou a oportunidade. E deixar meu pai aqui... não sei. É um grande passo.");
        cvQuestStart.addOptionText(SPANISH, "¿Estarías interesada en comprar una casa en Havarus?", "*Levanta la vista de sus libros, los ojos brillando ligeramente*\n\n¿Una casa en Havarus? ¿El gran reino con sus grandes bibliotecas y escuelas de aprendizaje?\n\n*Aprieta sus libros más cerca*\n\nHe leído tanto sobre eso... he agotado todos los libros de nuestra pequeña colección aquí en Lisport. Sueño con estudiar allí, aprender de los grandes eruditos.\n\n*Su emoción se desvanece, pareciendo insegura*\n\nPero... nunca tuve los medios o la oportunidad. Y dejar a mi padre aquí... no sé. Es un gran paso.");
        cvQuestStart.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, LIKE_A_LANDLORD, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestStart);

        // Option to persuade (requires Charisma 16+)
        ConversationOption cvPersuade = new ConversationOption(1, 2);
        cvPersuade.addOptionText(ENGLISH, "[Persuade] This is your chance to follow your dreams.(Charisma 18)", "*Listens intently, her expression changing*\n\nYou're right... this IS exactly the opportunity I've been waiting for!\n\n*Speaks with growing enthusiasm*\n\nIf Lord Markus is offering a house, I could establish myself properly, continue my studies without worry about lodging! I've saved every gold coin I have for something like this.\n\n*Nods decisively*\n\nYes! Tell Lord Markus that Elena accepts. But... I need to write to my father first. He's Alden, the alchemist at the Breeders Union. He needs to know I'm moving soon.");
        cvPersuade.addOptionText(PORTUGUESE, "[Persuadir] Esta é sua chance de seguir seus sonhos.(Carisma 18)", "*Ouve atentamente, sua expressão mudando*\n\nVocê está certo... esta É exatamente a oportunidade que eu estava esperando!\n\n*Fala com entusiasmo crescente*\n\nSe Lorde Markus está oferecendo uma casa, eu poderia me estabelecer adequadamente, continuar meus estudos sem preocupação com moradia! Guardei cada moeda de ouro que tenho para algo assim.\n\n*Acena decisivamente*\n\nSim! Diga a Lorde Markus que Elena aceita. Mas... preciso escrever para meu pai primeiro. Ele é Alden, o alquimista da União de Criadores. Ele precisa saber que vou me mudar em breve.");
        cvPersuade.addOptionText(SPANISH, "[Persuadir] Esta es tu oportunidad de seguir tus sueños.(Carisma 18)", "*Escucha atentamente, su expresión cambiando*\n\n¡Tienes razón... esta ES exactamente la oportunidad que estaba esperando!\n\n*Habla con creciente entusiasmo*\n\nSi Lord Markus está ofreciendo una casa, ¡podría establecerme adecuadamente, continuar mis estudios sin preocupación por alojamiento! He ahorrado cada moneda de oro que tengo para algo así.\n\n*Asiente decididamente*\n\n¡Sí! Dile a Lord Markus que Elena acepta. Pero... necesito escribirle a mi padre primero. Es Alden, el alquimista del Gremio de Criadores. Necesita saber que me mudaré pronto.");
        cvPersuade.requirementValidations = (chara, ctx) -> {
            int charisma = chara.attributesManager.getCurrent(Enums.AttributeName.CHARISMA);
            if (charisma >= 18) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_ATTRIBUTES;
        };
        cvPersuade.showEvenWhenNotValid = true;
        npc.conversationOptions.add(cvPersuade);

        // Option to let her think about it (quest stays in standby)
        ConversationOption cvLetThink = new ConversationOption(1, 0);
        cvLetThink.addOptionText(ENGLISH, "Take your time to think about it.", "Thank you for understanding. This is such an important decision... I need to think it through carefully. Perhaps we can talk again later.");
        cvLetThink.addOptionText(PORTUGUESE, "Tome seu tempo para pensar sobre isso.", "Obrigada por entender. Esta é uma decisão tão importante... preciso pensar com cuidado. Talvez possamos conversar novamente mais tarde.");
        cvLetThink.addOptionText(SPANISH, "Tómate tu tiempo para pensarlo.", "Gracias por entender. Esta es una decisión tan importante... necesito pensarlo cuidadosamente. Quizás podamos hablar de nuevo más tarde.");
        npc.conversationOptions.add(cvLetThink);

        ConversationOption cvGiveLetter = new ConversationOption(2, 0);
        cvGiveLetter.addOptionText(ENGLISH, "[Receive letter]", "*Hands you a carefully folded letter*\n\nPlease deliver this to my father. Tell him I'm following my dreams. I know he'll understand and support me. He's always encouraged my studies.\n\n*Smiles warmly*\n\nThank you for this opportunity. I'll start preparing for the move. I can't wait to begin my new life in Havarus!");
        cvGiveLetter.addOptionText(PORTUGUESE, "[Receber carta]", "*Entrega uma carta cuidadosamente dobrada*\n\nPor favor, entregue isto ao meu pai. Diga a ele que estou seguindo meus sonhos. Sei que ele entenderá e me apoiará. Ele sempre incentivou meus estudos.\n\n*Sorri calorosamente*\n\nObrigada por esta oportunidade. Vou começar a me preparar para a mudança. Mal posso esperar para começar minha nova vida em Havarus!");
        cvGiveLetter.addOptionText(SPANISH, "[Recibir carta]", "*Te entrega una carta cuidadosamente doblada*\n\nPor favor, entrégale esto a mi padre. Dile que estoy siguiendo mis sueños. Sé que él entenderá y me apoyará. Siempre ha alentado mis estudios.\n\n*Sonríe calurosamente*\n\n¡Gracias por esta oportunidad! Comenzaré a prepararme para la mudanza. ¡No puedo esperar para comenzar mi nueva vida en Havarus!");
        cvGiveLetter.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(LIKE_A_LANDLORD);
            LibInventory.addToInventory(ItemsIds.STUDENT_LETTER, 1, App.getPlayerChar());
            LibQuest.updateQuest(quest, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvGiveLetter);

        return npc;
    }
}



