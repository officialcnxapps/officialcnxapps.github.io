package com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.library;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.R;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Hafanne extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Hafanne");
        npc.age = 20;
        npc.job = Enums.NPCJobs.LIBRARIAN;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "Despite being very young, she has great general knowledge — a prodigy.\nHer life experience comes only from theory; she needs to live more in practice.\nShe inherited her work from her father, from whom she learned a great deal from an early age.\n\nHer physical traits: Light brown hair, green eyes, fair skin. Young face with thin cheeks and red lips.");
        npc.addDescriptionTranslation(PORTUGUESE, "Apesar de muito jovem, tem um grande conhecimento geral, uma prodígio.\nSua experiencia de vida vem apenas da teoria, precisa viver mais a vida na prática.\nHerdou seu trabalho de seu pai, com quem aprendeu muito desde cedo.\n\nSeus traços físicos: Cabelos castanhos claros, olhos verdes, pele clara. Rosto jovem com bochechas magras e lábios vermelhos.");
        npc.addDescriptionTranslation(SPANISH, "A pesar de ser muy joven, tiene un gran conocimiento general, una prodigio.\nSu experiencia de vida proviene solo de la teoría; necesita vivir más en la práctica.\nHeredó su trabajo de su padre, de quien aprendió mucho desde pequeña.\n\nSus rasgos físicos: Cabello castaño claro, ojos verdes, piel clara. Rostro joven con mejillas delgadas y labios rojos.");
        npc.canBePickpocketed = true;

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "Do you enjoy studying here?", "It's quiet, and the collection of historical texts is amazing. Plus, I can sneak in some science books too!");
        cv1.addOptionText(PORTUGUESE, "Você gosta de estudar aqui?", "É silencioso e a coleção de textos históricos é incrível. Além disso, posso contrabandear alguns livros de ciências também!");
        cv1.addOptionText(SPANISH, "¿Te gusta estudiar aquí?", "Es tranquilo y la colección de textos históricos es asombrosa. ¡Además, puedo colar algunos libros de ciencia también!");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "What are you studying today?", "I'm delving into the advancements of the Second Era. It's fascinating how much changed in such a short time! Just don't ask me to point to any of these places on a map... geography is not my strong suit.");
        cv2.addOptionText(PORTUGUESE, "O que você está estudando hoje?", "Estou mergulhando nos avanços da Segunda Era. É fascinante o quanto mudou em tão pouco tempo! Só não me peça para apontar nenhum desses lugares em um mapa... geografia não é meu forte.");
        cv2.addOptionText(SPANISH, "¿Qué estás estudiando hoy?", "Estoy profundizando en los avances de la Segunda Era. ¡Es fascinante cuánto cambió en tan poco tiempo! Eso sí, no me pidas que señale ninguno de estos lugares en un mapa... la geografía no es mi fuerte.");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(1, 0);
        cv3.addOptionText(ENGLISH, "Isn't sneaking books illegal?", "Oh, that? Just a little joke. Everything here is perfectly above board, of course!");
        cv3.addOptionText(PORTUGUESE, "Contrabandear livros não é ilegal?", "Ah, isso? Só uma piadinha. Está tudo perfeitamente dentro das regras, claro!");
        cv3.addOptionText(SPANISH, "¿No es ilegal colar libros?", "Ah, ¿eso? Solo una bromita. ¡Todo aquí está perfectamente en regla, por supuesto!");
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(0, 2);
        cv4.addOptionText(ENGLISH, "Do you know where I can get a map of the region?", "Actually, I have one right here! But I'm terrible with maps, so it doesn't do me much good. You can have it if you want.");
        cv4.addOptionText(PORTUGUESE, "Você sabe onde posso conseguir um mapa da região?", "Na verdade, eu tenho um aqui! Mas sou péssima com mapas, então não me serve de muita coisa. Pode ficar com ele se quiser.");
        cv4.addOptionText(SPANISH, "¿Sabes dónde puedo conseguir un mapa de la región?", "¡De hecho, tengo uno aquí mismo! Pero soy terrible con los mapas, así que no me sirve de mucho. Puedes quedártelo si quieres.");
        cv4.requirementValidations = (chara, ctx) -> {
            if (LibInventory.checkHasItem(ItemsIds.HAVARUS_NORTH_MAP, chara)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(2, 0);
        cv5.addOptionText(ENGLISH, "Really? It will be useful to me.", "Okay, you can take it, I won't use it anyway, if that's the case I'll ask for directions on how to get to places.");
        cv5.addOptionText(PORTUGUESE, "Sério? Vai me ser útil.", "Tudo bem, pode pegar, não irei mesmo usar, se for o caso peço indicações de como chegar aos lugares.");
        cv5.addOptionText(SPANISH, "¿En serio? Me será útil.", "De acuerdo, puedes tomarlo, no lo voy a usar de todos modos, si es el caso pediré indicaciones sobre cómo llegar a los lugares.");
        cv5.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.HAVARUS_NORTH_MAP, 1, App.getPlayerChar());
            String itemName = App.DataManager.getItem(ItemsIds.HAVARUS_NORTH_MAP).getName(App.CURRENT_LANGUAGE);
            LibUtils.showToast(LibUtils.getString(R.string.receivedItem, ctx) + itemName, 0, CoreEnums.MessageType.INFO, ctx);

        };
        npc.conversationOptions.add(cv5);

        // ===== QUEST: New Route - Part 1 (The Wisdom Seeker) =====
        ConversationOption cvNewRoute1 = new ConversationOption(0, 3);
        cvNewRoute1.addOptionText(ENGLISH, "A man named Aslatan seeks wisdom about life's meaning.", "Ah, the eternal question! What makes a life meaningful? \n\n*Walks among the shelves, running fingers over book spines*\n\nI believe meaning comes from knowledge and sharing it. Every book I preserve, every fact I teach, becomes part of humanity's eternal tapestry. When we learn and teach, we transcend our brief existence. We become links in an infinite chain of wisdom.\n\nTell Aslatan: a meaningful life is one that illuminates darkness, that passes light to future generations. Whether through books or deeds, we must leave the world brighter than we found it.");
        cvNewRoute1.addOptionText(PORTUGUESE, "Um homem chamado Aslatan busca sabedoria sobre o significado da vida.", "Ah, a questão eterna! O que torna uma vida significativa? \n\n*Caminha entre as prateleiras, passando os dedos sobre as lombadas dos livros*\n\nAcredito que o significado vem do conhecimento e de compartilhá-lo. Cada livro que preservo, cada fato que ensino, torna-se parte da tapeçaria eterna da humanidade. Quando aprendemos e ensinamos, transcendemos nossa breve existência. Tornamo-nos elos numa cadeia infinita de sabedoria.\n\nDiga a Aslatan: uma vida significativa é aquela que ilumina a escuridão, que passa luz para as gerações futuras. Seja através de livros ou ações, devemos deixar o mundo mais brilhante do que o encontramos.");
        cvNewRoute1.addOptionText(SPANISH, "Un hombre llamado Aslatan busca sabiduría sobre el significado de la vida.", "¡Ah, la pregunta eterna! ¿Qué hace que una vida sea significativa? \n\n*Camina entre los estantes, pasando los dedos sobre los lomos de los libros*\n\nCreo que el significado proviene del conocimiento y de compartirlo. Cada libro que preservo, cada hecho que enseño, se convierte en parte del tapiz eterno de la humanidad. Cuando aprendemos y enseñamos, trascendemos nuestra breve existencia. Nos convertimos en eslabones de una cadena infinita de sabiduría.\n\nDile a Aslatan: una vida significativa es aquella que ilumina la oscuridad, que pasa luz a las generaciones futuras. Ya sea a través de libros o acciones, debemos dejar el mundo más brillante de lo que lo encontramos.");
        cvNewRoute1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SEEKING_WISDOM, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvNewRoute1);

        ConversationOption cvNewRoute1Complete = new ConversationOption(3, 0);
        cvNewRoute1Complete.addOptionText(ENGLISH, "Thank you for your wisdom.", "Knowledge is meant to be shared. I hope my perspective helps him find peace. Now, seek those who defend the walls in Helera - warriors who face danger daily will offer a very different view on life's meaning!");
        cvNewRoute1Complete.addOptionText(PORTUGUESE, "Obrigado por sua sabedoria.", "O conhecimento deve ser compartilhado. Espero que minha perspectiva ajude-o a encontrar paz. Agora, procure aqueles que defendem as muralhas em Helera - guerreiros que enfrentam perigo diariamente oferecerão uma visão muito diferente sobre o significado da vida!");
        cvNewRoute1Complete.addOptionText(SPANISH, "Gracias por tu sabiduría.", "El conocimiento debe ser compartido. Espero que mi perspectiva le ayude a encontrar paz. ¡Ahora, busca a aquellos que defienden las murallas en Helera - guerreros que enfrentan peligro diariamente ofrecerán una vista muy diferente sobre el significado de la vida!");
        cvNewRoute1Complete.listeners = (ctx, fragment) -> LibQuest.updateQuest(QuestsIds.SEEKING_WISDOM, 2, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvNewRoute1Complete);

        // ===== QUEST: Free Spirit - Part 3 =====
        ConversationOption cvFreeSpirit1 = new ConversationOption(0, 6);
        cvFreeSpirit1.addOptionText(ENGLISH, "I need access to rare books about spirit liberation.", "*Hafanne looks up from her book, adjusting her glasses*\n\nSpirit liberation? That's... quite unusual. Not many people come asking about such topics.\n\n*She glances toward a locked section*\n\nWe do have an ancient tome in the restricted section - 'The Liberation of Earthbound Spirits' by Father Gregorius Sariseus. It's rarely requested.\n\n*She studies you carefully*\n\nBut I can't just hand out restricted materials to anyone. I need assurance of your intentions... or perhaps a gift that shows your commitment to knowledge.");
        cvFreeSpirit1.addOptionText(PORTUGUESE, "Preciso de acesso a livros raros sobre libertação de espíritos.", "*Hafanne levanta o olhar do livro, ajustando os óculos*\n\nLibertação de espíritos? Isso é... bastante incomum. Não são muitas pessoas que vêm perguntar sobre tais tópicos.\n\n*Ela olha para uma seção trancada*\n\nTemos um tomo antigo na seção restrita - 'A Libertação de Espíritos Terrenos' por Padre Gregorius Sariseus. É raramente solicitado.\n\n*Ela te estuda cuidadosamente*\n\nMas não posso simplesmente entregar materiais restritos a qualquer um. Preciso de garantia de suas intenções... ou talvez um presente que mostre seu compromisso com o conhecimento.");
        cvFreeSpirit1.addOptionText(SPANISH, "Necesito acceso a libros raros sobre liberación de espíritus.", "*Hafanne levanta la vista de su libro, ajustando sus gafas*\n\n¿Liberación de espíritus? Eso es... bastante inusual. No muchas personas vienen preguntando sobre tales temas.\n\n*Mira hacia una sección cerrada con llave*\n\nTenemos un tomo antiguo en la sección restringida - 'La Liberación de Espíritus Terrenales' por Padre Gregorius Sariseus. Es raramente solicitado.\n\n*Te estudia cuidadosamente*\n\nPero no puedo simplemente entregar materiales restringidos a cualquiera. Necesito seguridad de tus intenciones... o quizás un regalo que muestre tu compromiso con el conocimiento.");
        cvFreeSpirit1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FREE_SPIRIT, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvFreeSpirit1);

        // Option A: Charisma 18+
        ConversationOption cvFreeSpiritPersuade = new ConversationOption(6, 7);
        cvFreeSpiritPersuade.addOptionText(ENGLISH, "[Persuade] (Charisma 18)", "*Hafanne looks into your eyes and sees genuine compassion*\n\nI... I can see you truly mean well. Your intentions are pure. Very well, I'll retrieve the tome for you.\n\n*She unlocks the restricted section and carefully brings out an ancient leather-bound book*\n\nThis book was written by the father of Priest Sariseus, who serves at our Monastery. The knowledge within is sacred and powerful. Use it wisely.");
        cvFreeSpiritPersuade.addOptionText(PORTUGUESE, "[Persuadir] (Carisma 18)", "*Hafanne olha nos seus olhos e vê compaixão genuína*\n\nEu... posso ver que você realmente tem boas intenções. Suas intenções são puras. Muito bem, vou buscar o tomo para você.\n\n*Ela destranca a seção restrita e traz cuidadosamente um livro antigo encadernado em couro*\n\nEste livro foi escrito pelo pai do Padre Sariseus, que serve em nosso Monastério. O conhecimento dentro é sagrado e poderoso. Use-o sabiamente.");
        cvFreeSpiritPersuade.addOptionText(SPANISH, "[Persuadir] (Carisma 18)", "*Hafanne mira en tus ojos y ve compasión genuina*\n\nYo... puedo ver que realmente tienes buenas intenciones. Tus intenciones son puras. Muy bien, recuperaré el tomo para ti.\n\n*Desbloquea la sección restringida y trae cuidadosamente un libro antiguo encuadernado en cuero*\n\nEste libro fue escrito por el padre del Sacerdote Sariseus, que sirve en nuestro Monasterio. El conocimiento dentro es sagrado y poderoso. Úsalo sabiamente.");
        cvFreeSpiritPersuade.requirementValidations = (chara, ctx) -> {
            int charisma = chara.attributesManager.getCurrent(Enums.AttributeName.CHARISMA);
            if (charisma >= 18) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_ATTRIBUTES;
        };
        cvFreeSpiritPersuade.showEvenWhenNotValid = true;
        npc.conversationOptions.add(cvFreeSpiritPersuade);

        // Option B: Gift gold ring
        ConversationOption cvFreeSpiritGift = new ConversationOption(6, 7);
        cvFreeSpiritGift.addOptionText(ENGLISH, "I have this gold ring as a token of appreciation", "*Hafanne's eyes widen at the sight of the ring*\n\nOh my! This is beautiful... and quite valuable. A perfect addition to my personal collection.\n\n*She accepts the ring with a smile*\n\nVery well, for such a thoughtful gift, I'll grant you access. \n\n*She unlocks the restricted section and carefully brings out an ancient leather-bound book*\n\nThis book was written by the father of Priest Sariseus, who serves at our Monastery. The knowledge within is sacred and powerful. Use it wisely.");
        cvFreeSpiritGift.addOptionText(PORTUGUESE, "Tenho este anel de ouro como símbolo de apreço", "*Os olhos de Hafanne se arregalam ao ver o anel*\n\nOh meu! Isto é lindo... e bastante valioso. Uma adição perfeita à minha coleção pessoal.\n\n*Ela aceita o anel com um sorriso*\n\nMuito bem, por um presente tão atencioso, vou conceder-lhe acesso.\n\n*Ela destranca a seção restrita e traz cuidadosamente um livro antigo encadernado em couro*\n\nEste livro foi escrito pelo pai do Padre Sariseus, que serve em nosso Monastério. O conhecimento dentro é sagrado e poderoso. Use-o sabiamente.");
        cvFreeSpiritGift.addOptionText(SPANISH, "Tengo este anillo de oro como muestra de aprecio", "*Los ojos de Hafanne se ensanchan al ver el anillo*\n\n¡Oh Dios! Esto es hermoso... y bastante valioso. Una adición perfecta a mi colección personal.\n\n*Acepta el anillo con una sonrisa*\n\nMuy bien, por un regalo tan considerado, te concederé acceso.\n\n*Desbloquea la sección restringida y trae cuidadosamente un libro antiguo encuadernado en cuero*\n\nEste libro fue escrito por el padre del Sacerdote Sariseus, que sirve en nuestro Monasterio. El conocimiento dentro es sagrado y poderoso. Úsalo sabiamente.");
        cvFreeSpiritGift.requirementValidations = (chara, ctx) -> {
            if (LibInventory.checkHasItem(ItemsIds.GOLD_RING, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_ITEMS;
        };
        cvFreeSpiritGift.listeners = (ctx, fragment) -> {
            LibInventory.removeFromInventory(ItemsIds.GOLD_RING, 1, App.getPlayerChar());
        };
        cvFreeSpiritGift.showEvenWhenNotValid = true;
        npc.conversationOptions.add(cvFreeSpiritGift);

        // Option C: Wait
        ConversationOption cvFreeSpiritWait = new ConversationOption(6, 0);
        cvFreeSpiritWait.addOptionText(ENGLISH, "I'll think about it and return later.", "As you wish. The restricted section will still be here when you're ready.");
        cvFreeSpiritWait.addOptionText(PORTUGUESE, "Vou pensar sobre isso e retornar depois.", "Como desejar. A seção restrita ainda estará aqui quando estiver pronto.");
        cvFreeSpiritWait.addOptionText(SPANISH, "Lo pensaré y regresaré más tarde.", "Como desees. La sección restringida seguirá aquí cuando estés listo.");
        npc.conversationOptions.add(cvFreeSpiritWait);

        // Continue after getting book
        ConversationOption cvFreeSpiritGotBook = new ConversationOption(7, 0);
        cvFreeSpiritGotBook.addOptionText(ENGLISH, "Thank you for the book.", "You're welcome. The book mentions that Father Sariseus at the Monastery is the author's son. He might be able to explain the ritual in more detail. Good luck with your quest.");
        cvFreeSpiritGotBook.addOptionText(PORTUGUESE, "Obrigado pelo livro.", "De nada. O livro menciona que o Padre Sariseus no Monastério é o filho do autor. Ele pode ser capaz de explicar o ritual com mais detalhes. Boa sorte na sua busca.");
        cvFreeSpiritGotBook.addOptionText(SPANISH, "Gracias por el libro.", "De nada. El libro menciona que el Padre Sariseus en el Monasterio es el hijo del autor. Él podría explicar el ritual con más detalle. Buena suerte con tu búsqueda.");
        cvFreeSpiritGotBook.listeners = (ctx, fragment) -> {
            LibInventory.addToInventory(ItemsIds.ANCIENT_LIBERATION_TOME, 1, App.getPlayerChar());
            String itemName = App.DataManager.getItem(ItemsIds.ANCIENT_LIBERATION_TOME).getName(App.CURRENT_LANGUAGE);
            LibUtils.showToast(LibUtils.getString(R.string.receivedItem, ctx) + itemName, 0, CoreEnums.MessageType.INFO, ctx);
            LibQuest.updateQuest(QuestsIds.FREE_SPIRIT, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFreeSpiritGotBook);

        return npc;
    }
}