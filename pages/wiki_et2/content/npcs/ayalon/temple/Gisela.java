package com.cnx.endlesstalestwo.data.npcs.ayalon.temple;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

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

public class Gisela extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Gisela");
        npc.age = 173;
        npc.job = Enums.NPCJobs.PRIEST;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "As calm as she is wise.\nShe is always available to the people of Ayalon. She knows the power of faith for the elves well and is a master at guiding it.\n\nHer physical traits: Youthful appearance for her age. Thin face, short silver hair. Deep gaze with her brown eyes.");
        npc.addDescriptionTranslation(PORTUGUESE, "Tão calma quanto sábia.\nEstá sempre disponível para o povo de Ayalon. Sabe bem o poder da fé para os elfos e é mestra em conduzir isso.\n\nSeus traços físicos: Aparência jovem para a idade. Rosto magro, cabelos curtos e prateados. Olhar profundo com seus olhos castanhos.");
        npc.addDescriptionTranslation(SPANISH, "Tan tranquila como sabia.\nSiempre está disponible para el pueblo de Ayalon. Conoce bien el poder de la fe para los elfos y es una maestra en conducirlo.\n\nSus rasgos físicos: Apariencia juvenil para su edad. Rostro delgado, cabello corto y plateado. Mirada profunda con sus ojos marrones.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Blessings of the temple upon you, traveler."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bênçãos do templo sobre você, viajante."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Bendiciones del templo sobre ti, viajero."));

        // ===== GENERAL ROLEPLAY =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "What is your role here?", "I am Gisela, keeper of this Sacred Temple and guardian of the ancient texts preserved within these walls. I have served here for over seven decades, maintaining the wisdom of our ancestors for future generations.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Qual é o seu papel aqui?", "Sou Gisela, guardiã deste Templo Sagrado e protetora dos textos ancestrais preservados dentro destas paredes. Sirvo aqui há mais de sete décadas, mantendo a sabedoria de nossos ancestrais para as gerações futuras.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cuál es tu papel aquí?", "Soy Gisela, guardiana de este Templo Sagrado y protectora de los textos ancestrales preservados dentro de estas paredes. He servido aquí durante más de siete décadas, manteniendo la sabiduría de nuestros ancestros para las generaciones futuras.");
        npc.conversationOptions.add(cvRoleplay1);

        // ========================================
        // QUEST: Traitor
        // ========================================

        ConversationOption cvTraitorCasiel = new ConversationOption(0, 0);
        cvTraitorCasiel.addOptionText(ENGLISH, "Have you seen Casiel? I cannot find him anywhere.", "Casiel... no, I do not know where he could be. He is not a frequent visitor to the temple. I would suggest looking through the city streets, that is where he is usually seen. I hope nothing ill has befallen him.");
        cvTraitorCasiel.addOptionText(PORTUGUESE, "Você viu Casiel? Não consigo encontrá-lo em nenhum lugar.", "Casiel... não, não sei onde ele poderia estar. Ele não é um visitante frequente do templo. Sugiro que procure pelas ruas da cidade, é onde ele costuma ser visto. Espero que nada de ruim tenha acontecido com ele.");
        cvTraitorCasiel.addOptionText(SPANISH, "¿Has visto a Casiel? No puedo encontrarlo en ningún lugar.", "Casiel... no, no sé dónde podría estar. No es un visitante frecuente del templo. Te sugiero que busques por las calles de la ciudad, es donde suele ser visto. Espero que no le haya ocurrido nada malo.");
        cvTraitorCasiel.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.isCharacterAtQuestPart(chara, QuestsIds.TRAITOR, 1)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cvTraitorCasiel);

        // ===== ELFS AND HUMANS QUEST - Part 4 =====
        ConversationOption cvElfsHumans1 = new ConversationOption(0, 10);
        cvElfsHumans1.addOptionText(ENGLISH, "I seek a scroll about elven observations of humanity. Eldrin sent me.", "Ah, Eldrin! The child of two worlds. Yes, I know the scroll he seeks. It was written by Elder Aelrindel, one of our wisest souls who dedicated her life to understanding and celebrating the beauty of humanity.\n\n*walks to an ornate shelf*\nThis scroll has been preserved here for centuries. Few ask for it these days - most have forgotten the deep bonds our peoples once shared.");
        cvElfsHumans1.addOptionText(PORTUGUESE, "Busco um pergaminho sobre observações élficas da humanidade. Eldrin me enviou.", "Ah, Eldrin! A criança de dois mundos. Sim, conheço o pergaminho que ele busca. Foi escrito pela Anciã Aelrindel, uma de nossas almas mais sábias que dedicou sua vida a entender e celebrar a beleza da humanidade.\n\n*caminha até uma prateleira ornamentada*\nEste pergaminho foi preservado aqui por séculos. Poucos o pedem hoje em dia - a maioria esqueceu os laços profundos que nossos povos já compartilharam.");
        cvElfsHumans1.addOptionText(SPANISH, "Busco un pergamino sobre observaciones élficas de la humanidad. Eldrin me envió.", "¡Ah, Eldrin! El niño de dos mundos. Sí, conozco el pergamino que busca. Fue escrito por la Anciana Aelrindel, una de nuestras almas más sabias que dedicó su vida a comprender y celebrar la belleza de la humanidad.\n\n*camina hacia un estante ornamentado*\nEste pergamino ha sido preservado aquí durante siglos. Pocos lo piden hoy en día - la mayoría ha olvidado los lazos profundos que nuestros pueblos una vez compartieron.");
        cvElfsHumans1.requirementValidations = (chara, ctx) -> {
            QuestsIds questId = QuestsIds.ELFS_AND_HUMANS;
            if (LibQuest.isCharacterAtQuestPart(chara, questId, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfsHumans1);

        ConversationOption cvElfsHumans2 = new ConversationOption(10, 0);
        cvElfsHumans2.addOptionText(ENGLISH, "May I take this scroll to Eldrin?", "*Carefully retrieves an ancient scroll*\nOf course. Elder Aelrindel would be pleased that her words still serve to build bridges between our peoples. \n*hands you the scroll with great care*\n\nThe scroll is written in ancient elven script. You'll need someone who can translate it - perhaps Scholar Nelera at the Great Library? She has the skill and knowledge to render Aelrindel's beautiful observations into words Eldrin can read.\n\nTake this sacred text with reverence, traveler. It contains wisdom our world desperately needs to remember.");
        cvElfsHumans2.addOptionText(PORTUGUESE, "Posso levar este pergaminho para Eldrin?", "*Recupera cuidadosamente um pergaminho ancestral*\nClaro. A Anciã Aelrindel ficaria satisfeita que suas palavras ainda sirvam para construir pontes entre nossos povos. \n*entrega o pergaminho com grande cuidado*\n\nO pergaminho está escrito em escrita élfica ancestral. Você precisará de alguém que possa traduzi-lo - talvez a Estudiosa Nelera na Grande Biblioteca? Ela tem a habilidade e conhecimento para transformar as belas observações de Aelrindel em palavras que Eldrin possa ler.\n\nLeve este texto sagrado com reverência, viajante. Contém sabedoria que nosso mundo precisa desesperadamente lembrar.");
        cvElfsHumans2.addOptionText(SPANISH, "¿Puedo llevar este pergamino a Eldrin?", "*Recupera cuidadosamente un pergamino ancestral*\nPor supuesto. La Anciana Aelrindel estaría complacida de que sus palabras aún sirvan para construir puentes entre nuestros pueblos. \n*te entrega el pergamino con gran cuidado*\n\nEl pergamino está escrito en escritura élfica ancestral. Necesitarás a alguien que pueda traducirlo - ¿quizás la Erudita Nelera en la Gran Biblioteca? Ella tiene la habilidad y conocimiento para convertir las hermosas observaciones de Aelrindel en palabras que Eldrin pueda leer.\n\nLleva este texto sagrado con reverencia, viajero. Contiene sabiduría que nuestro mundo necesita desesperadamente recordar.");
        cvElfsHumans2.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.ANCIENT_ELVEN_SCROLL, 1, App.getPlayerChar());
            QuestsIds questId = QuestsIds.ELFS_AND_HUMANS;
            LibQuest.updateQuest(questId, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvElfsHumans2);

        return npc;
    }
}
