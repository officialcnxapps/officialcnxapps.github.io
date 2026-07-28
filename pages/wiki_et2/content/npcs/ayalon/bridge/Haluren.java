package com.cnx.endlesstalestwo.data.npcs.ayalon.bridge;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.STUDYING_FISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Haluren extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Haluren");
        npc.age = 91;
        npc.job = Enums.NPCJobs.STUDENT;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A young elf, enchanted by the world he lives in and by his own culture.\nA nature enthusiast. No known relatives.\nHe usually spends his days wandering around the outskirts of the city.\n\nHis physical traits: Long blond hair, a square face with well-defined lines. Very fair skin.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um jovem elfo. Encantado com o mundo onde vive e com a sua própria cultura.\nEntusiasta da natureza. Nenhum familiar conhecido.\nPassa seus dias costumeiramente a andar pelos arredores da cidade.\n\nSeus taços físicos: Cabelos longos e loiros, rosto quadrado e com linhas bem definidas. Pele bem clara.");
        npc.addDescriptionTranslation(SPANISH, "Un joven elfo, encantado con el mundo en el que vive y con su propia cultura.\nEntusiasta de la naturaleza. No tiene familiares conocidos.\nSuele pasar sus días caminando por los alrededores de la ciudad.\n\nSus rasgos físicos: Cabello largo y rubio, rostro cuadrado con líneas bien definidas. Piel muy clara.");
        npc.canBePickpocketed = true;

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // Roleplay conversations
        ConversationOption cvRoleplay1 = new ConversationOption(0, 3);
        cvRoleplay1.addOptionText(ENGLISH, "What do you study, Haluren?", "I study the ancient paths, mortal. The Blue River has been a boundary between worlds for millennia - not just between Ayalon and the outer forests, but between the known and the mystical. This bridge... it sings with old magic. I listen, I observe, I record. Perhaps one day I will understand why the waters here run so blue, or why the stars reflect differently in this river than in any other.");
        cvRoleplay1.addOptionText(PORTUGUESE, "O que você estuda, Haluren?", "Estudo os caminhos ancestrais, mortal. O Rio Azul tem sido uma fronteira entre mundos por milênios - não apenas entre Ayalon e as florestas externas, mas entre o conhecido e o místico. Esta ponte... canta com magia antiga. Eu escuto, observo, registro. Talvez um dia eu entenda por que as águas aqui correm tão azuis, ou por que as estrelas se refletem de forma diferente neste rio do que em qualquer outro.");
        cvRoleplay1.addOptionText(SPANISH, "¿Qué estudias, Haluren?", "Estudio los caminos ancestrales, mortal. El Río Azul ha sido una frontera entre mundos durante milenios - no solo entre Ayalon y los bosques exteriores, sino entre lo conocido y lo místico. Este puente... canta con magia antigua. Escucho, observo, registro. Quizás algún día entienda por qué las aguas aquí corren tan azules, o por qué las estrelas se reflejan de manera diferente en este río que en cualquier otro.");
        npc.conversationOptions.add(cvRoleplay1);

        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "You spend much time on this bridge?", "*Nods*\nIndeed. Some consider it a lonely post, but I find great peace here. The river whispers secrets to those patient enough to listen. I have witnessed dawn break over these waters for nearly two decades now. Each sunrise is different, each reflection unique. The bridge is my classroom, and nature itself is my teacher. Besides, someone must watch the crossing. This path connects Ayalon to the green cave and beyond - it requires a guardian's eye.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Você passa muito tempo nesta ponte?", "*Acena*\nDe fato. Alguns consideram um poste solitário, mas eu encontro grande paz aqui. O rio sussurra segredos para aqueles pacientes o suficiente para ouvir. Testemunhei o amanhecer nascer sobre essas águas por quase duas décadas. Cada nascer do sol é diferente, cada reflexo único. A ponte é minha sala de aula, e a própria natureza é minha professora. Além disso, alguém deve vigiar a travessia. Este caminho conecta Ayalon à caverna verde e além - requer o olho de um guardião.");
        cvRoleplay2.addOptionText(SPANISH, "¿Pasas mucho tiempo en este puente?", "*Asiente*\nEn efecto. Algunos lo consideran un puesto solitario, pero yo encuentro gran paz aquí. El río susurra secretos a quienes son lo suficientemente pacientes para escuchar. He presenciado el amanecer sobre estas aguas durante casi dos décadas. Cada amanecer es diferente, cada reflejo único. El puente es mi aula, y la naturaleza misma es mi maestra. Además, alguien debe vigilar el cruce. Este camino conecta Ayalon con la cueva verde y más allá - requiere el ojo de un guardián.");
        npc.conversationOptions.add(cvRoleplay2);

        // ===== TRAITOR QUEST: Part 2→3 - Casiel went to statue =====
        ConversationOption cvTraitor1 = new ConversationOption(0, 0);
        cvTraitor1.addOptionText(ENGLISH, "Haluren, did Casiel cross this bridge?", "*Face darkens*\nYes... I saw him. He ran across like a man possessed, heading towards the green cave where the goddess statue portal lies. His aura was wrong, mortal - twisted with dark purpose. The river itself recoiled from his passage. There is something wrong!");
        cvTraitor1.addOptionText(PORTUGUESE, "Haluren, Casiel cruzou esta ponte?", "*Rosto escurece*\nSim... eu o vi. Ele correu através como um homem possuído, indo em direção à caverna verde onde fica o portal da estátua da deusa. Sua aura estava errada, mortal - retorcida com propósito sombrio. O próprio rio recuou de sua passagem. Há algo de errado!");
        cvTraitor1.addOptionText(SPANISH, "Haluren, ¿Casiel cruzó este puente?", "*Rostro se oscurece*\nSí... lo vi. Corrió a través como un hombre poseído, dirigiéndose hacia la cueva verde donde está el portal de la estatua de la diosa. Su aura estaba mal, mortal - retorcida com propósito oscuro. El propio río retrocedió ante su paso. Hay algo de errado!");
        cvTraitor1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.TRAITOR, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvTraitor1.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.TRAITOR, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvTraitor1);

        // ========================================
        // QUEST: STUDYING FISH
        // ========================================

        // Start quest
        ConversationOption cvFishStart = new ConversationOption(3, 10);
        cvFishStart.addOptionText(ENGLISH, "You seem interested in the river. What are you looking for?",
                "I am also studying the aquatic life here in Ayalon, traveler. I believe the fish in these mystical waters hold secrets to healing and vitality. However, my research is limited to this region. I often wonder... do fish in other lands possess similar properties?");
        cvFishStart.addOptionText(PORTUGUESE, "Você parece interessado no rio. O que está procurando?",
                "Estou também estudando a vida aquática aqui em Ayalon, viajante. Acredito que os peixes nestas águas místicas guardam segredos de cura e vitalidade. No entanto, minha pesquisa limita-se a esta região. Muitas vezes me pergunto... os peixes em outras terras possuem propriedades semelhantes?");
        cvFishStart.addOptionText(SPANISH, "Pareces interesado en el río. ¿Qué buscas?",
                "Estoy tambiém estudiando la vida acuática aquí en Ayalon, viajero. Creo que los peces en estas aguas místicas guardan secretos de curación y vitalidad. Sin embargo, mi investigación se limita a esta región. A menudo me pregunto... ¿tendrán los peces de otras tierras propiedades similares?");
        cvFishStart.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(STUDYING_FISH, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvFishStart);

        ConversationOption cvFishAccept = new ConversationOption(10, 0);
        cvFishAccept.addOptionText(ENGLISH, "I can help you gather samples from other kingdoms.",
                "Would you really? That would be a tremendous help! I need samples from three distinct regions: Havarus, Lisport, and Esperand. \n\nTalk to Jack in Fisherman Ville, Klaus in Lisport Shores, and Captain Philipson in Esperand Harbor. They are all experienced with the local waters and might be able to provide the samples I need.");
        cvFishAccept.addOptionText(PORTUGUESE, "Posso ajudar você a coletar amostras de outros reinos.",
                "Sério? Isso seria uma ajuda tremenda! Preciso de amostras de três regiões distintas: Havarus, Lisport e Esperand. \n\nFale com Jack em Fisherman Ville, Klaus em Lisport Shores e o Capitão Philipson no Porto de Esperand. Todos eles têm experiência com as águas locais e podem fornecer as amostras que preciso.");
        cvFishAccept.addOptionText(SPANISH, "Puedo ayudarte a recolectar muestras de otros reinos.",
                "¿De verdad? ¡Eso seria de gran ajuda! Necesito muestras de tres regiones distintas: Havarus, Lisport y Esperand. \n\nHabla con Jack in Fisherman Ville, Klaus en las Playas de Lisport y el Capitán Philipson en el Puerto de Esperand. Todos ellos tienen experiencia con las aguas locales y podrían proporcionar las muestras que necesito.");
        cvFishAccept.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(STUDYING_FISH, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFishAccept);

        ConversationOption cvFishDecline = new ConversationOption(10, 0);
        cvFishDecline.addOptionText(ENGLISH, "Maybe another time.", "I understand. The river's secrets will wait for a patient observer.");
        cvFishDecline.addOptionText(PORTUGUESE, "Talvez outra hora.", "Eu entendo. Os segredos do rio esperarão por um observador paciente.");
        cvFishDecline.addOptionText(SPANISH, "Tal vez en otro momento.", "Entiendo. Los secretos del río esperarán a un observador paciente.");
        npc.conversationOptions.add(cvFishDecline);

        // Part 4: Complete quest
        ConversationOption cvFishComplete = new ConversationOption(0, 0);
        cvFishComplete.addOptionText(ENGLISH, "I have the fish samples from Havarus, Lisport, and Esperand.",
                "Incredible! You actually gathered them all. Let me see... \n\n*He examines the samples with excitement*\n\nYes, these are perfect! The differences are fascinating. This will keep me busy for months. Thank you, traveler. Please, take this Nature Necklace as a token of my gratitude. It is a symbol of the harmony I seek to understand.");
        cvFishComplete.addOptionText(PORTUGUESE, "Tenho as amostras de peixe de Havarus, Lisport e Esperand.",
                "Incrível! Você realmente coletou todas elas. Deixe-me ver... \n\n*Ele examina as amostras com entusiasmo*\n\nSim, estas são perfeitas! As diferenças são fascinantes. Isso me manterá ocupado por meses. Obrigado, viajante. Por favor, aceite este Colar da Natureza como um símbolo da minha gratidão. É um símbolo da harmonia que busco compreender.");
        cvFishComplete.addOptionText(SPANISH, "Tengo las muestras de peces de Havarus, Lisport y Esperand.",
                "¡Increíble! Realmente las recolectaste todas. Déjame ver... \n\n*Examina las muestras con entusiasmo*\n\n¡Sí, son perfectas! Las diferencias son fascinantes. Esto me mantendrá ocupado durante meses. Gracias, viajero. Por favor, toma este Collar de la Naturaleza como muestra de mi gratitud. Es un símbolo de la armonía que busco comprender.");
        cvFishComplete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, STUDYING_FISH, 4)
                    && LibInventory.checkHasItem(ItemsIds.HAVARUS_FISH, chara)
                    && LibInventory.checkHasItem(ItemsIds.LISPORT_FISH, chara)
                    && LibInventory.checkHasItem(ItemsIds.ESPERAND_FISH, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvFishComplete.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.HAVARUS_FISH, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.LISPORT_FISH, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.ESPERAND_FISH, 1, App.getPlayerChar());
            LibQuest.completeQuest(STUDYING_FISH, App.getPlayerChar(), 11, ctx);
        };
        npc.conversationOptions.add(cvFishComplete);

        return npc;
    }
}