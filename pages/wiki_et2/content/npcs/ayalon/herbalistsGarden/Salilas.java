package com.cnx.endlesstalestwo.data.npcs.ayalon.herbalistsGarden;

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

public class Salilas extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Salilas");
        npc.age = 164;
        npc.job = Enums.NPCJobs.MALE_FARMER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "An experienced elf and an expert in his craft.\nRespectful and highly respected, he knows what he says and is a great connoisseur of his culture. Kind-hearted.\n\nHis physical traits: his fair skin is wrinkled. A well-defined face with a full gray beard, as well as his straight hair.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um elfo experiente e especialista no que faz no seu ofício.\nRespeitoso e muito respeitado, sabe o que diz e é grande conhecedor da sua cultura. Bondoso.\n\nSeus traços físicos: sua pele clara está enrugada. Rosto bem definido com uma barba completa grisalha, assim como seu liso cabelo.");
        npc.addDescriptionTranslation(SPANISH, "Un elfo experimentado y experto en su oficio.\nRespetuoso y muy respetado, sabe lo que dice y es un gran conocedor de su cultura. Bondadoso.\n\nSus rasgos físicos: su piel clara está arrugada. Rostro bien definido con una barba completa canosa, al igual que su cabello liso.");
        npc.canBePickpocketed = true;

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // ===== GENERAL ROLEPLAY CONVERSATIONS =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "What is it like to be a master herbalist in Ayalon?", "It is a calling, not merely a profession. Every plant here is connected to the ancient magic of our realm. I study not just their medicinal properties, but their songs - yes, plants sing, mortal, though few can hear them. Each herb tells a story of the soil, the stars, and the seasons. It is my honor to preserve this knowledge for future generations.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Como é ser um mestre herbalista em Ayalon?", "É uma vocação, não apenas uma profissão. Cada planta aqui está conectada à magia ancestral de nosso reino. Estudo não apenas suas propriedades medicinais, mas suas canções - sim, as plantas cantam, mortal, embora poucos possam ouvi-las. Cada erva conta uma história do solo, das estrelas e das estações. É minha honra preservar este conhecimento para as gerações futuras.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cómo es ser un maestro herbolario en Ayalon?", "Es una vocación, no simplemente una profesión. Cada planta aquí está conectada con la magia ancestral de nuestro reino. Estudio no solo sus propiedades medicinales, sino sus canciones - sí, las plantas cantan, mortal, aunque pocos pueden escucharlas. Cada hierba cuenta una historia del suelo, las estrellas y las estaciones. Es mi honor preservar este conocimiento para las generaciones futuras.");
        npc.conversationOptions.add(cvRoleplay1);

        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "This garden is beautiful. How long have you tended it?", "*Smiles gently*\nI have been guardian of this sacred garden for over forty years now. But the garden itself... it has existed for centuries, passed from herbalist to herbalist. Some of these plants are older than your great-grandparents, mortal. We elves believe that to tend a garden is to tend the future. Every seed planted today may become a great tree that shelters someone two hundred years hence. It teaches patience, respect, and the long view of life.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Este jardim é lindo. Há quanto tempo você o cultiva?", "*Sorri gentilmente*\nSou guardião deste jardim sagrado há mais de quarenta anos. Mas o jardim em si... existe há séculos, passado de herbalista em herbalista. Algumas dessas plantas são mais velhas que seus bisavós, mortal. Nós elfos acreditamos que cuidar de um jardim é cuidar do futuro. Cada semente plantada hoje pode se tornar uma grande árvore que abrigará alguém daqui a duzentos anos. Isso ensina paciência, respeito e a visão longa da vida.");
        cvRoleplay2.addOptionText(SPANISH, "Este jardín es hermoso. ¿Cuánto tiempo lo has cuidado?", "*Sonríe suavemente*\nHe sido guardián de este jardín sagrado durante más de cuarenta años. Pero el jardín en sí... ha existido durante siglos, pasado de herbolario en herbolario. Algunas de estas plantas son más viejas que tus bisabuelos, mortal. Los elfos creemos que cuidar un jardín es cuidar el futuro. Cada semilla plantada hoy puede convertirse en un gran árbol que cobije a alguien dentro de doscientos años. Enseña paciencia, respeto y la visión larga de la vida.");
        npc.conversationOptions.add(cvRoleplay2);

        // ===== ELF KNOWLEDGE QUEST: Part 5 - Deliver black oak seeds =====
        ConversationOption cvElfKnowledge1 = new ConversationOption(0, 1);
        cvElfKnowledge1.addOptionText(ENGLISH, "Salilas? I bring black oak seeds from Emperor Arilas.", "*Looks up from tending plants*\nBlack oak seeds from the human lands? \n*Examines them carefully*\nYes, yes... these are perfect. Freshly harvested, healthy... whoever provided these knows their craft.");
        cvElfKnowledge1.addOptionText(PORTUGUESE, "Salilas? Trago sementes de carvalho negro do Imperador Arilas.", "*Levanta os olhos das plantas*\nSementes de carvalho negro das terras humanas? \n*Examina-as cuidadosamente*\nSim, sim... estão perfeitas. Recém-colhidas, saudáveis... quem forneceu estas conhece seu ofício.");
        cvElfKnowledge1.addOptionText(SPANISH, "¿Salilas? Traigo semillas de roble negro del Emperador Arilas.", "*Levanta la vista de cuidar las plantas*\n¿Semillas de roble negro de las tierras humanas? \n*Las examina cuidadosamente*\nSí, sí... son perfectas. Recién cosechadas, saludables... quien las proporcionó conoce su oficio.");
        cvElfKnowledge1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ELF_KNOWLEDGE, 5) &&
                    LibInventory.checkHasItem(ItemsIds.BLACK_OAK_SEEDS, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvElfKnowledge1);

        ConversationOption cvElfKnowledge2 = new ConversationOption(1, 2);
        cvElfKnowledge2.addOptionText(ENGLISH, "They come from Griwalsh, a human alchemist and herbalist.", "Griwalsh! I know this name. My predecessor, Master Velandis, spoke of him decades ago. They exchanged knowledge of herbs before the separation between our peoples. It warms my heart to know his legacy continues.");
        cvElfKnowledge2.addOptionText(PORTUGUESE, "Vêm de Griwalsh, um alquimista e herbalista humano.", "Griwalsh! Conheço esse nome. Meu predecessor, Mestre Velandis, falava dele há décadas. Eles trocavam conhecimento sobre ervas antes da separação entre nossos povos. Aquece meu coração saber que seu legado continua.");
        cvElfKnowledge2.addOptionText(SPANISH, "Vienen de Griwalsh, un alquimista y herbolario humano.", "¡Griwalsh! Conozco este nombre. Mi predecesor, el Maestro Velandis, habló de él hace décadas. Intercambiaron conocimiento sobre hierbas antes de la separación entre nuestros pueblos. Me alegra saber que su legado continúa.");
        npc.conversationOptions.add(cvElfKnowledge2);

        ConversationOption cvElfKnowledge3 = new ConversationOption(2, 0);
        cvElfKnowledge3.addOptionText(ENGLISH, "He sends his regards and hopes for renewed friendship.", "*Smiles warmly*\nAs do I. These seeds will be planted in our sacred grove. Black oaks grow slowly, but they live for centuries. When these trees mature, they will stand as living monuments to this moment of reconciliation. \n*Places hand over heart in elven gesture*\nTell Griwalsh that Salilas accepts his gift with honor. I will inform Emperor Arilas that you have completed your task with dedication and respect.");
        cvElfKnowledge3.addOptionText(PORTUGUESE, "Ele envia seus cumprimentos e espera por uma amizade renovada.", "*Sorri calorosamente*\nAssim como eu. Estas sementes serão plantadas em nosso bosque sagrado. Carvalhos negros crescem lentamente, mas vivem por séculos. Quando essas árvores amadurecerem, permanecerão como monumentos vivos deste momento de reconciliação. \n*Coloca a mão sobre o coração em gesto élfico*\nDiga a Griwalsh que Salilas aceita seu presente com honra. Vou informar ao Imperador Arilas que você completou sua tarefa com dedicação e respeito.");
        cvElfKnowledge3.addOptionText(SPANISH, "Él envía sus saludos y espera una amistad renovada.", "*Sonríe cálidamente*\nAl igual que yo. Estas semillas se plantarán en nuestro bosque sagrado. Los robles negros crecen lentamente, pero viven durante siglos. Cuando estos árboles maduren, permanecerán como monumentos vivos de este momento de reconciliación. \n*Coloca la mano sobre el corazón en gesto élfico*\nDile a Griwalsh que Salilas acepta su regalo con honor. Informaré al Emperador Arilas que has completado tu tarea con dedicación y respeto.");
        cvElfKnowledge3.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.BLACK_OAK_SEEDS, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.ELF_KNOWLEDGE, 6, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvElfKnowledge3);

        // ===== TRAITOR QUEST: Part 1→2 - Casiel sighting =====
        ConversationOption cvTraitor1 = new ConversationOption(0, 0);
        cvTraitor1.addOptionText(ENGLISH, "Salilas, have you seen Casiel?", "*Looks up with concern*\nCasiel? Yes, I saw him leave the citadel in great haste not long ago. He went west, towards the Blue River bridge. His demeanor was... troubling. His eyes were dark, his face twisted with some hidden purpose. Why do you seek him, mortal?");
        cvTraitor1.addOptionText(PORTUGUESE, "Salilas, você viu Casiel?", "*Levanta os olhos com preocupação*\nCasiel? Sim, eu o vi deixar a cidadela com grande pressa há pouco tempo. Ele foi para oeste, em direção à ponte do Rio Azul. Seu comportamento era... perturbador. Seus olhos estavam escuros, seu rosto contorcido com algum propósito oculto. Por que o procuras, mortal?");
        cvTraitor1.addOptionText(SPANISH, "Salilas, ¿has visto a Casiel?", "*Levanta la vista con preocupación*\n¿Casiel? Sí, lo vi salir de la ciudadela con gran prisa hace poco tiempo. Fue hacia el oeste, hacia el puente del Río Azul. Su comportamiento era... inquietante. Sus ojos estaban oscuros, su rostro retorcido con algún propósito oculto. ¿Por qué lo buscas, mortal?");
        cvTraitor1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.TRAITOR, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvTraitor1.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.TRAITOR, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvTraitor1);

        return npc;
    }
}
