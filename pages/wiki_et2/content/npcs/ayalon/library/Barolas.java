package com.cnx.endlesstalestwo.data.npcs.ayalon.library;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Barolas extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Barolas");
        npc.age = 133;
        npc.job = Enums.NPCJobs.COUNSELOR;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Serious and focused. This half-elf is very intelligent, but prefers to keep a mystery about his knowledge and attitudes.\nHe likes to leave everything well explained, always demonstrating wisdom.\n\nHis physical traits: Brown skin, green eyes. Long, straight, light brown hair.");
        npc.addDescriptionTranslation(PORTUGUESE, "Sério e compenetrado. Este elfo mestiço é muito inteligente, porém prefere manter mistério sobre seus conhecimentos e atitudes.\nGosta de deixar tudo bem explicado, demonstrando sempre sabedoria.\n\nSeus traços físicos: Pele morena, olhos verdes. Cabelo castanho claro, liso e comprido.");
        npc.addDescriptionTranslation(SPANISH, "Serio y concentrado. Este elfo mestizo es muy inteligente, pero prefiere mantener el misterio sobre sus conocimientos y actitudes.\nLe gusta dejar todo bien explicado, demostrando siempre sabiduría.\n\nSus rasgos físicos: Piel morena, ojos verdes. Cabello castaño claro, liso y largo.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Welcome to the Great Library of Ayalon, scholar."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Bem-vindo à Grande Biblioteca de Ayalon, erudito."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Bienvenido a la Gran Biblioteca de Ayalon, erudito."));

        // ===== THE ELF LIBRARY QUEST: Part 1 - First visit to library =====
        ConversationOption cvLibrary1 = new ConversationOption(0, 1);
        cvLibrary1.addOptionText(ENGLISH, "I have been granted access to this library by Emperor Arilas.", "*Looks up from an ancient tome*\nAh, yes. The human who earned our trust. Emperor Arilas sent word of your access. I am Barolas, keeper of this sacred repository of elven knowledge spanning millennia.");
        cvLibrary1.addOptionText(PORTUGUESE, "Recebi acesso a esta biblioteca pelo Imperador Arilas.", "*Ergue os olhos de um tomo ancestral*\nAh, sim. O humano que conquistou nossa confiança. O Imperador Arilas enviou aviso de seu acesso. Sou Barolas, guardião deste repositório sagrado de conhecimento élfico que atravessa milênios.");
        cvLibrary1.addOptionText(SPANISH, "Me ha concedido acceso a esta biblioteca el Emperador Arilas.", "*Levanta la vista de un tomo ancestral*\nAh, sí. El humano que ganó nuestra confianza. El Emperador Arilas envió aviso de tu acceso. Soy Barolas, guardián de este repositorio sagrado de conocimiento élfico que abarca milenios.");
        cvLibrary1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_ELF_LIBRARY, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvLibrary1);

        ConversationOption cvLibrary2 = new ConversationOption(1, 2);
        cvLibrary2.addOptionText(ENGLISH, "I seek knowledge about dark magic and how to combat it.", "A grave subject for grave times. \n*Gestures to the vast shelves*\nThese archives contain centuries of elvish wisdom about the balance of light and darkness. You are welcome to study here, though I must inform you of certain... limitations.");
        cvLibrary2.addOptionText(PORTUGUESE, "Busco conhecimento sobre magia negra e como combatê-la.", "Um assunto grave para tempos graves. \n*Gesticula para as vastas prateleiras*\nEstes arquivos contêm séculos de sabedoria élfica sobre o equilíbrio entre luz e trevas. Você é bem-vindo para estudar aqui, embora deva informá-lo sobre certas... limitações.");
        cvLibrary2.addOptionText(SPANISH, "Busco conocimiento sobre magia oscura y cómo combatirla.", "Un tema grave para tiempos graves. \n*Gesticula hacia los vastos estantes*\nEstos archivos contienen siglos de sabiduría élfica sobre el equilibrio entre luz y oscuridad. Eres bienvenido a estudiar aquí, aunque debo informarte sobre ciertas... limitaciones.");
        npc.conversationOptions.add(cvLibrary2);

        ConversationOption cvLibrary3 = new ConversationOption(2, 0);
        cvLibrary3.addOptionText(ENGLISH, "What limitations?", "*Sighs gently*\nFirst, our most precious tomes cannot leave these walls - they are irreplaceable and bound by preservation enchantments to this place. Second, and perhaps more challenging for you... \n*picks up a book*\nAll our texts are written in the ancient elven script. Without knowledge of our language, these pages will remain mysteries to you. You will need a translator versed in both languages.");
        cvLibrary3.addOptionText(PORTUGUESE, "Quais limitações?", "*Suspira gentilmente*\nPrimeiro, nossos tomos mais preciosos não podem deixar estas paredes - são insubstituíveis e ligados por encantamentos de preservação a este lugar. Segundo, e talvez mais desafiador para você... \n*pega um livro*\nTodos os nossos textos estão escritos na antiga escrita élfica. Sem conhecimento de nossa língua, estas páginas permanecerão mistérios para você. Você precisará de um tradutor versado em ambas as línguas.");
        cvLibrary3.addOptionText(SPANISH, "¿Qué limitaciones?", "*Suspira suavemente*\nPrimero, nuestros tomos más preciosos no pueden salir de estas paredes: son irremplazables y están atados por encantamientos de preservación a este lugar. Segundo, y quizás más desafiante para ti... \n*toma un libro*\nTodos nuestros textos están escritos en la antigua escritura élfica. Sin conocimiento de nuestro idioma, estas páginas seguirán siendo misterios para ti. Necesitarás un traductor versado en ambas lenguas.");
        cvLibrary3.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.THE_ELF_LIBRARY, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvLibrary3);

        // ===== GENERAL ROLEPLAY CONVERSATION =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "How old is this library?", "This library has stood for over two thousand years. Some of the texts you see were penned before your kingdom of Havarus even existed. We elves do not merely preserve knowledge - we are its eternal guardians, ensuring wisdom transcends the fleeting lives of mortals.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Qual a idade desta biblioteca?", "Esta biblioteca existe há mais de dois mil anos. Alguns dos textos que você vê foram escritos antes mesmo do seu reino de Havarus existir. Nós elfos não apenas preservamos conhecimento - somos seus guardiões eternos, garantindo que a sabedoria transcenda as vidas fugazes dos mortais.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cuántos años tiene esta biblioteca?", "Esta biblioteca ha existido durante más de dos mil años. Algunos de los textos que ves fueron escritos antes de que tu reino de Havarus existiera. Nosotros los elfos no solo preservamos el conocimiento: somos sus guardianes eternos, asegurando que la sabiduría trascienda las vidas fugaces de los mortales.");
        npc.conversationOptions.add(cvRoleplay1);

        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "What kind of knowledge is preserved here?", "Everything, mortal. From the origins of magic itself to the chronicles of empires long fallen. We have treatises on healing arts that surpass any human medical knowledge, texts on the nature of the elements, histories of wars and peace, philosophical debates spanning centuries. The elves believe that all knowledge is interconnected - that understanding the past illuminates the present and guides the future.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Que tipo de conhecimento é preservado aqui?", "Tudo, mortal. Desde as origens da própria magia até as crônicas de impérios há muito caídos. Temos tratados sobre artes de cura que superam qualquer conhecimento médico humano, textos sobre a natureza dos elementos, histórias de guerras e paz, debates filosóficos que atravessam séculos. Os elfos acreditam que todo conhecimento está interconectado - que compreender o passado ilumina o presente e guia o futuro.");
        npc.conversationOptions.add(cvRoleplay2);

        ConversationOption cvRoleplay3 = new ConversationOption(0, 0);
        cvRoleplay3.addOptionText(ENGLISH, "Do many humans visit this library?", "*Shakes head slowly*\nYou are only the second human to set foot in these halls in my century of service here. The first was a diplomat during my grandfather's time as keeper. We elves withdrew from human contact after... disagreements about how magic should be used. Your presence here represents a significant moment - perhaps a new chapter in the relationship between our peoples.");
        cvRoleplay3.addOptionText(PORTUGUESE, "Muitos humanos visitam esta biblioteca?", "*Balança a cabeça lentamente*\nVocê é apenas o segundo humano a pisar nestas salas em meu século de serviço aqui. O primeiro foi um diplomata durante o tempo de meu avô como guardião. Nós elfos nos afastamos do contato humano após... desentendimentos sobre como a magia deveria ser usada. Sua presença aqui representa um momento significativo - talvez um novo capítulo no relacionamento entre nossos povos.");
        cvRoleplay3.addOptionText(SPANISH, "¿Muchos humanos visitan esta biblioteca?", "*Sacude la cabeza lentamente*\nEres solo el segundo humano en poner un pie en estas salas en mi siglo de servicio aquí. El primero fue un diplomático durante el tiempo de mi abuelo como guardián. Nosotros los elfos nos retiramos del contacto humano después de... desacuerdos sobre cómo debería usarse la magia. Tu presencia aquí representa un momento significativo: quizás un nuevo capítulo en la relación entre nuestros pueblos.");
        npc.conversationOptions.add(cvRoleplay3);

        return npc;
    }
}
