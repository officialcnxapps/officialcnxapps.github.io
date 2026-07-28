package com.cnx.endlesstalestwo.data.npcs.growrocks.vegetablesGardens;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import static com.cnx.endlesstalestwo.enums.Enums.RequirementVerification.NOT_OK;
import static com.cnx.endlesstalestwo.enums.Enums.RequirementVerification.OK;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class FiolaBrownhand extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Fiola Brownhand");
        npc.age = 36;
        npc.job = Enums.NPCJobs.FEMALE_FARMER;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "This dwarf seems more innocent and calm.\nShe works nonstop, with dedication and love for nature.\nHer son Loki is raised only by her; who is his father?\n\nHer physical traits: Blond hair, brown eyes so light they almost look yellow, and a square face with very fair skin.");
        npc.addDescriptionTranslation(PORTUGUESE, "Essa anã parece ser mais inocente e calma.\nTrabalha sem parar, com dedicação e amor a natureza.\nSeu filho, Loki, é criado somente por ela, quem seria o pai?\n\nSeus traços físicos: Cabelo loiro, olhos castanhos tão claros que chegam a ser amarelos. Rosto quadrado com pele bem clara.");
        npc.addDescriptionTranslation(SPANISH, "Esta enana parece ser más inocente y tranquila.\nTrabaja sin parar, con dedicación y amor por la naturaleza.\nSu hijo, Loki, es criado solo por ella; ¿quién sería el padre?\n\nSus rasgos físicos: Cabello rubio, ojos castaños tan claros que casi parecen amarillos, y rostro cuadrado con piel muy clara.");
        npc.canBePickpocketed = true;

        npc.generateRandomByes();
        npc.generateRandomGreetings();

        // ===== QUEST PART 4: Talk to Fiola =====
        ConversationOption cvQuestTalk = new ConversationOption(0, 0);
        cvQuestTalk.addOptionText(ENGLISH, "Oliman sent me to speak with you.", "*Wipes her hands on her apron, looks up from the garden beds with a curious expression*\nOliman sent you? A surface dweller helping in our gardens... that is unusual. But if Oliman trusts you enough to send you here, then I will give you a chance.\n\n*Gestures at the rows of vegetables*\nMy people need food and I am running short of supplies. If you want to help, bring me five carrots and three pieces of raw meat. Good quality - our people deserve nothing less. Can you do that?");
        cvQuestTalk.addOptionText(PORTUGUESE, "Oliman me enviou para falar com você.", "*Limpa as mãos no avental, levanta o olhar dos canteiros com uma expressão curiosa*\nOliman te enviou? Um habitante da superfície ajudando em nossos jardins... isso é incomum. Mas se Oliman confia em você o suficiente para te enviar aqui, então darei uma chance.\n\n*Gesticula para as fileiras de vegetais*\nMeu povo precisa de comida e estou ficando sem suprimentos. Se quiser ajudar, traga-me cinco cenouras e três pedaços de carne crua. Boa qualidade - nosso povo não merece nada menos. Você consegue fazer isso?");
        cvQuestTalk.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_DWARVEN_CITY, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvQuestTalk.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.THE_DWARVEN_CITY, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuestTalk);

        // ===== QUEST PART 5: Deliver food supplies =====
        ConversationOption cvQuest = new ConversationOption(0, 1);
        cvQuest.addOptionText(ENGLISH, "I have the carrots and meat you asked for.", "*Looks up from the garden beds, eyes lighting up with recognition*\nAh, you returned! And quickly too. Let me see...\n\n*Wipes her hands on her apron and steps closer*\nYou have everything? The five carrots and the three pieces of meat?");
        cvQuest.addOptionText(PORTUGUESE, "Tenho as cenouras e a carne que pediu.", "*Levanta o olhar dos canteiros, olhos iluminando-se com reconhecimento*\nAh, voltou! E rápido também. Deixa eu ver...\n\n*Limpa as mãos no avental e se aproxima*\nTem tudo? As cinco cenouras e os três pedaços de carne?");
        cvQuest.addOptionText(SPANISH, "Tengo las zanahorias y la carne que pediste.", "*Levanta la vista de los bancales, ojos iluminándose con reconocimiento*\n¡Ah, volviste! Y rápido también. Déjame ver...\n\n*Limpia las manos en el delantal y se acerca*\n¿Lo tienes todo? ¿Las cinco zanahorias y los tres trozos de carne?");
        cvQuest.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_DWARVEN_CITY, 5) &&
                    LibInventory.checkHasItemAmount(ItemsIds.CARROT, 5, chara) &&
                    LibInventory.checkHasItemAmount(ItemsIds.RAW_MEAT, 3, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuest);

        ConversationOption cvQuestDeliver = new ConversationOption(1, 0);
        cvQuestDeliver.addOptionText(ENGLISH, "*Deliver 5 Carrots and 3 Raw Meat*", "Good carrots - firm, fresh, not wilted. Meat is well-preserved, good quality.\n*Nods with approval*\nThis will feed several families tonight. You have served Growrocks well.\n\n*Pauses, studying you with a thoughtful look*\n\nYou know... if you truly wish to understand our people, it is not enough to work alongside us. You must understand what moves our hearts. Go to our temple - speak with Janusa Godhead, our priestess. She knows the old ways, the gods, the traditions. That knowledge will open more doors here than any pickaxe ever could.");
        cvQuestDeliver.addOptionText(SPANISH, "*Entregar 5 Zanahorias y 3 Carnes Crudas*", "Buenas zanahorias - firmes, frescas, no marchitas. Carne bien preservada, buena calidad.\n*Asiente con aprobación*\nEsto alimentará a varias familias esta noche. Has servido bien a Growrocks.\n\n*Pausa, estudiándote con una mirada pensativa*\n\nSabes... si verdaderamente deseas entender a nuestro pueblo, no es suficiente trabajar junto a nosotros. Debes entender lo que mueve nuestros corazones. Ve a nuestro templo - habla con Janusa Godhead, nuestra sacerdotisa. Ella conoce los caminos antiguos, los dioses, las tradiciones. Ese conocimiento abrirá más puertas aquí de lo que cualquier pico jamás podría.");
        cvQuestDeliver.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.CARROT, 5, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.RAW_MEAT, 3, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.THE_DWARVEN_CITY, 6, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuestDeliver);

        // ========================================
        // QUEST: TOO POWERFUL
        // ========================================

        // Part 3: Talk to Fiola Brownhand
        ConversationOption cvTooPowerful3 = new ConversationOption(0, 0);
        cvTooPowerful3.addOptionText(ENGLISH, "Governor Oliman said your family knew techniques to keep dragons away.",
                "*She stops her work and looks at you with a heavy sigh, wiping dirt from her forehead*\nAye... my grandfather told me many stories. He was a sentinel in the old mountains before we came here. He said dragons are not just beasts of fire; they are creatures of pride and territory. They only retreat if they feel genuinely threatened — if they believe a greater predator is in the area. \n\nHe used to collect scales and even the blood of dragons directly from their nests. By spreading these scents around our halls and rituallistically displaying their remains, we created an atmosphere of fear. The dragons thought their own kind were being hunted and killed, and they chose easier targets elsewhere. If you want to expel them, you must do the same. Collect their blood and scales. It is the only way.");
        cvTooPowerful3.addOptionText(PORTUGUESE, "Governador Oliman disse que sua família conhecia técnicas para afastar dragões. ",
                "*Ela para seu trabalho e olha para você com um suspiro pesado, limpando a terra da testa*\nSim... meu avô me contou muitas histórias. Ele era um sentinela nas velhas montanhas antes de virmos para cá. Ele dizia que dragões não são apenas feras de fogo; são criaturas de orgulho e território. Eles só recuam se se sentirem genuinamente ameaçados — se acreditarem que um predador maior está na área. \n\nEle costumava coletar escamas e até o sangue de dragões diretamente de seus ninhos. Ao espalhar esses cheiros em nossos salões e exibir ritualisticamente seus restos, criávamos uma atmosfera de medo. Os dragões pensavam que sua própria espécie estava sendo caçada e morta, e escolhiam alvos mais fáceis em outros lugares. Se você quer expulsá-los, deve fazer o mesmo. Colete o sangue e as escamas deles. É o único jeito.");
        cvTooPowerful3.addOptionText(SPANISH, "Gobernador Oliman dijo que su familia conocía técnicas para alejar a los dragones.",
                "*Deja su trabajo y te mira con un pesado suspiro, limpiándose la tierra de la frente*\nSí... mi abuelo me contó muchas historias. Era un centinela en las viejas montañas antes de que viniéramos aquí. Decía que los dragones no son solo bestias de fuego; son criaturas de orgullo y territorio. Solo se retiran si se sienten genuinamente amenazados, si creen que hay un depredador mayor en la zona. \n\nSolía recolectar escamas e incluso la sangre de los dragones directamente de sus nidos. Al esparcir estos olores por nuestros salones y mostrar ritualmente sus restos, creábamos una atmósfera de miedo. Los dragones pensaban que los suyos estaban siendo cazados y asesinados, y elegían objetivos más fáciles en otros lugares. Si quieres expulsarlos, debes hacer lo mismo. Recolecta su sangre y sus escamas. Es la única forma.");
        cvTooPowerful3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.TOO_POWERFUL, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvTooPowerful3.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(QuestsIds.TOO_POWERFUL, 4, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvTooPowerful3);

        // ========================================
        // QUEST: BLOOD WITH BLOOD
        // ========================================

        // Part 2: Deliver to Fiola
        ConversationOption cvBloodWithBlood2 = new ConversationOption(0, 0);
        cvBloodWithBlood2.addOptionText(ENGLISH, "I have the samples from the three dragon types.",
                "*She looks at the vials and scales with a mixture of awe and fear*\nYou truly did it... fire, ice, and acid. My grandfather would be proud. This is enough to make the most dominant bull dragon hesitate. \n\n*She takes a specialized blade from her belt and begins to coat it with the mixture of blood and pulverized scales*\n\nTake this. I call it the **Blood Blade**. It carries the scent of their fallen kin. When you stand at their nests, hold it high and let them smell the end of their migration. Go now, before the scent fades.");
        cvBloodWithBlood2.addOptionText(PORTUGUESE, "Eu tenho as amostras dos três tipos de dragão.",
                "*Ela olha para os frascos e escamas com uma mistura de admiração e medo*\nVocê realmente conseguiu... fogo, gelo e ácido. Meu avô ficaria orgulhoso. Isso é o suficiente para fazer o dragão mais dominante hesitar. \n\n*Ela pega uma lâmina especializada de seu cinto e começa a banhá-la com a mistura de sangue e escamas pulverizadas*\n\nPegue isto. Eu a chamo de **Lâmina de Sangue**. Ela carrega o cheiro de seus parentes caídos. Quando você estiver nos ninhos deles, segure-a no alto e deixe-os sentir o cheiro do fim de sua migração. Vá agora, antes que o cheiro desapareça.");
        cvBloodWithBlood2.addOptionText(SPANISH, "Tengo las muestras de los tres tipos de dragones.",
                "*Mira los frascos y las escamas con una mezcla de asombro y miedo*\nRealmente lo hiciste... fuego, hielo y ácido. Mi abuelo estaría orgulloso. Esto es suficiente para hacer vacilar al dragón más dominante. \n\n*Toma una hoja especializada de su cinturón y comienza a recubrirla con la mezcla de sangre y escamas pulverizadas*\n\nToma esto. La llamo la **Hoja de Sangre**. Lleva el aroma de sus parientes caídos. Cuando estés en sus nidos, mantenla en alto y deja que huelan el fin de su migración. Ve ahora, antes de que el aroma se desvanezca.");
        cvBloodWithBlood2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.BLOOD_WITH_BLOOD, 2)) {
                return OK;
            }
            return NOT_OK;
        };
        cvBloodWithBlood2.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.FIRE_BLOOD, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.ICE_BLOOD, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.ACID_BLOOD, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.DRAGON_SCALE, 3, App.getPlayerChar());
            LibInventory.addToInventory(ItemsIds.BLOOD_BLADE, 1, App.getPlayerChar());
            LibQuest.completeQuest(QuestsIds.BLOOD_WITH_BLOOD, App.getPlayerChar(), 3, ctx);
            LibQuest.includeQuestToQuestbook(QuestsIds.DRAGON_FEAR, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvBloodWithBlood2);

        // ===== ROLEPLAY: About farming underground =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "How do you grow food underground?", "Clever question. Most think dwarves only eat mushrooms and stone bread. Not true. We have gardens - see around you? Special crystals in the ceiling glow like sun. Water from deep springs. Soil brought from surface generations ago, mixed with mineral-rich earth from mines. Carrots, potatoes, turnips, even some fruits. Hard work, but dwarves know hard work. We feed our people without depending on surface traders. Self-sufficient, as we should be.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Como vocês cultivam comida subterraneamente?", "Pergunta esperta. A maioria pensa que anões só comem cogumelos e pão de pedra. Não é verdade. Temos jardins - vê ao seu redor? Cristais especiais no teto brilham como sol. Água de fontes profundas. Solo trazido da superfície gerações atrás, misturado com terra rica em minerais das minas. Cenouras, batatas, nabos, até algumas frutas. Trabalho árduo, mas anões conhecem trabalho árduo. Alimentamos nosso povo sem depender de comerciantes da superfície. Auto-suficientes, como devemos ser.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY 2: About her son =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Tell me about your family.", "I have a son - Loki. Good boy, works hard. He helps me in the gardens when he's not training with the guard. I'm proud of him. His father died in a mining accident years ago, but we endure. That is the dwarven way - we face hardship, we continue, we honor those we lost through our work. Every seed I plant honors his memory.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Conte-me sobre sua família.", "Tenho um filho - Loki. Bom rapaz, trabalha duro. Ele me ajuda nos jardins quando não está treinando com a guarda. Tenho orgulho dele. Seu pai morreu em um acidente de mineração anos atrás, mas perseveramos. Este é o caminho anão - enfrentamos dificuldades, continuamos, honramos aqueles que perdemos através de nosso trabalho. Cada semente que planto honra sua memória.");
        cvRoleplay2.addOptionText(SPANISH, "Cuéntame sobre tu familia.", "Tengo un hijo - Loki. Buen chico, trabaja duro. Me ayuda en los jardines cuando no está entrenando con la guardia. Estoy orgullosa de él. Su padre murió en un accidente de minería hace años, pero perseveramos. Ese es el camino enano - enfrentamos dificultades, continuamos, honramos a quienes perdimos a través de nuestro trabajo. Cada semilla que planto honra su memoria.");
        npc.conversationOptions.add(cvRoleplay2);

        return npc;
    }
}

