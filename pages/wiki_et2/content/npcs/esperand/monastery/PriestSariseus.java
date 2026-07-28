package com.cnx.endlesstalestwo.data.npcs.esperand.monastery;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class PriestSariseus extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Priest Sariseus");
        npc.addNameTranslation(PORTUGUESE,"Sacerdote Sariseus");
        npc.addNameTranslation(SPANISH,"Sacerdote Sariseus");
        npc.age = 60;
        npc.job = Enums.NPCJobs.PRIEST;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Very wise, he measures his words and speaks with harmony.\nHe runs the monastery with wisdom and knows both magic and theology.\n\nHis physical traits: Full white beard, slightly wavy graying hair beneath the hood, clear blue eyes, and skin that matches his age.");
        npc.addDescriptionTranslation(PORTUGUESE, "Muito sábio, mede suas palavras e fala com harmonia.\nAdministra o monastério com sabedoria e sabe tanto de magia quanto de teologia.\n\nSeus traços físicos: Barba branca e completa. Cabelos grisalhos levemente ondulados por baixo do capuz. Olhos azuis claros e pele que condiz com a idade.");
        npc.addDescriptionTranslation(SPANISH, "Muy sabio, mide sus palabras y habla con armonía.\nAdministra el monasterio con sabiduría y conoce tanto de magia como de teología.\n\nSus rasgos físicos: Barba blanca y completa, cabello canoso levemente ondulado bajo la capucha, ojos azules claros y piel acorde con su edad.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Divine greetings to you, [GENDER_FORMAL_CALL]."));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Saudações divinas a você, [GENDER_FORMAL_CALL]."));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Saludos divinos para usted, [GENDER_FORMAL_CALL]."));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Take care, pilgrim."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Cuide-se, peregrino."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Cuídese, peregrino."));

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What can you tell me about this monastery?", "Ah, this sacred ground? It has stood for centuries, a bastion of light against the encroaching shadows. We are humble servants of the Maker, dedicated to prayer and the preservation of knowledge. My old bones have seen many seasons within these walls.");
        cv1.addOptionText(PORTUGUESE, "O que me pode dizer sobre este mosteiro?", "Ah, este solo sagrado? Ele existe há séculos, um bastião de luz contra as sombras que se aproximam. Somos servos humildes do Criador, dedicados à oração e à preservação do conhecimento. Os meus velhos ossos já viram muitas estações dentro destas paredes.");
        cv1.addOptionText(SPANISH, "¿Qué puede contarme sobre este monasterio?", "Ah, ¿este suelo sagrado? Ha permanecido en pie durante siglos, un bastión de luz contra las sombras que acechan. Somos humildes siervos del Hacedor, dedicados a la oración y la preservación del conocimiento. Mis viejos huesos han visto muchas estaciones dentro de estos muros.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Do you have any wisdom to share, father?", "Hah, a traveler seeking wisdom from an old man. Remember this, child: faith is a shield, but kindness is a blade that can sunder any darkness. Walk with a good heart, and the Maker's path will always be lit for you.");
        cv2.addOptionText(PORTUGUESE, "Tem alguma sabedoria para partilhar, padre?", "Hah, um viajante à procura da sabedoria de um velho. Lembra-te disto, jovem: a fé é um escudo, mas a bondade é uma lâmina que pode fender qualquer escuridão. Caminha com um bom coração, e o caminho do Criador estará sempre iluminado para ti.");
        cv2.addOptionText(SPANISH, "¿Tiene alguna sabiduría que compartir, padre?", "Ja, un viajero buscando la sabiduría de un anciano. Recuerda esto, hijo/a: la fe es un escudo, pero la bondad es una espada que puede cortar cualquier oscuridad. Camina con un buen corazón, y el camino del Hacedor siempre estará iluminado para ti.");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(0, 1);
        cv3.addOptionText(ENGLISH, "What can you tell me about light and dark magic?", "Interesting question.\nObviously they are opposing magics, if used well they are very powerful and thanks to the creator, light magic will almost always persevere over dark magic.\nBut, any specific reason for this question?");
        cv3.addOptionText(PORTUGUESE, "O que pode me contar sobre magia de luz e trevas?", "Pergunta interessante.\nObviamente são magias opostas, se bem usadas são muito poderosas e graças ao criador, a magia de luz quase sempre perserverá sobre a de trevas.\nMas, algum motivo específico para esta pergunta?");
        cv3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.WHO_IS_THE_ENEMY, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(1, 2);
        cv4.addOptionText(ENGLISH, "I believe a dark magic ritual occurred recently.", "Oh, yes, that makes sense. A few days ago while we were praying we felt very bad vibrations, we thought it was dark magic. Only those who deal with these types of magics and are in meditation would be able to feel it. If you think so, it's because you know something more.");
        cv4.addOptionText(PORTUGUESE, "Creio que um ritual de magia negra ocorreu recentemente.", "Oh, sim, faz sentido. Há alguns dias enquanto orávamos sentimos vibrações muito ruins, pensamos mesmo ser magia das trevas. Somente quem lida com magias destes tipos e está em meditação seria capaz de sentir. Se você pensa isso, é devido a saber de algo mais.");
        cv4.addOptionText(SPANISH, "Creo que un ritual de magia negra ocurrió recientemente.", "Oh, sí, eso tiene sentido. Hace unos días, mientras orábamos, sentimos vibraciones muy malas, pensamos que era magia oscura. Solo aquellos que lidian con este tipo de magias y están en meditación podrían sentirlo. Si piensas eso, es porque sabes algo más.");
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(2, 0);
        cv5.addOptionText(ENGLISH, "Yes, guards have slain a beast from the darkness.", "Oh, I don't believe it. That worries me. With the energy we felt and your information, I imagine that a dark ritual must have really occurred.\nI tried to use light magic to track these evil energies and found that they most likely came from the Frozen Cavern, a little to the northeast of here. You should go there.");
        cv5.addOptionText(PORTUGUESE, "Sim, guardas abateram uma besta das trevas.", "Oh, não creio. Isso me traz preocupações. Com a energia que sentimos e essa sua informação, imagino que realmente um ritual das trevas deve ter ocorrido.\nEu tentei usar magia de luz para rastrear essas energias malígnas e descobri que muito provavelmente vieram da Caverna Congelada, um pouco a nordeste daqui. Deveria ir lá.");
        cv5.addOptionText(SPANISH, "Sí, los guardias han matado a una bestia de la oscuridad.", "Oh, no lo puedo creer. Eso me preocupa. Con la energía que sentimos y tu información, imagino que realmente debe haber ocurrido un ritual oscuro.\nTraté de usar magia de luz para rastrear estas energías malignas y descubrí que muy probablemente vinieron de la Caverna Congelada, un poco al noreste de aquí. Deberías ir allí.");
        cv5.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.WHO_IS_THE_ENEMY, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv5);

        // ===== QUEST: New Route - Part 3 (The Path of Faith) =====
        ConversationOption cvNewRoute3 = new ConversationOption(0, 3);
        cvNewRoute3.addOptionText(ENGLISH, "A wise elf named Aslatan seeks wisdom about life's meaning.", "*Closes prayer book gently*\nAh, the eternal question that brings many to our monastery doors. Life's meaning...\n\n*Walks toward the altar, hands clasped*\n\nI believe true meaning is found in compassion and service to others. We are all children of the divine, connected by threads of shared humanity. When we ease another's suffering, when we offer kindness to strangers, when we forgive those who wrong us - we touch the sacred.\n\nA life of meaning is not measured in gold or glory, but in hearts touched and souls uplifted. Every act of love, every moment of mercy, every sacrifice for another's wellbeing - these are the building blocks of purpose.\n\nTell Aslatan: seek not what the world can give you, but what you can give the world. In selfless service, we find our truest selves.");
        cvNewRoute3.addOptionText(PORTUGUESE, "Um elfo sábio chamado Aslatan busca sabedoria sobre o significado da vida.", "*Fecha o livro de orações gentilmente*\nAh, a questão eterna que traz muitos às portas do nosso monastério. O significado da vida...\n\n*Caminha em direção ao altar, mãos unidas*\n\nAcredito que o verdadeiro significado é encontrado na compaixão e no serviço aos outros. Somos todos filhos do divino, conectados por fios de humanidade compartilhada. Quando aliviamos o sofrimento de outro, quando oferecemos gentileza a estranhos, quando perdoamos aqueles que nos fazem mal - tocamos o sagrado.\n\nUma vida de significado não é medida em ouro ou glória, mas em corações tocados e almas elevadas. Cada ato de amor, cada momento de misericórdia, cada sacrifício pelo bem-estar de outro - estes são os blocos de construção do propósito.\n\nDiga a Aslatan: não busque o que o mundo pode lhe dar, mas o que você pode dar ao mundo. No serviço altruísta, encontramos nosso eu mais verdadeiro.");
        cvNewRoute3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SEEKING_WISDOM, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvNewRoute3);

        ConversationOption cvNewRoute3Complete = new ConversationOption(3, 0);
        cvNewRoute3Complete.addOptionText(ENGLISH, "Thank you, Father.", "May the divine light guide your path, child. One final perspective remains - in Lisport Harbor, the dock workers who trade daily understand the material world's wisdom through commerce and prosperity. Seek them out, then you'll have gathered knowledge from all walks of life to share with this Aslatan you mentioned.");
        cvNewRoute3Complete.addOptionText(PORTUGUESE, "Obrigado, Padre.", "Que a luz divina guie seu caminho, filho. Uma perspectiva final permanece - no Porto de Lisport, os trabalhadores das docas que comercializam diariamente compreendem a sabedoria do mundo material através do comércio e da prosperidade. Procure-os, então você terá reunido conhecimento de todos os caminhos da vida para compartilhar com esse tal Aslatan que mencionou.");
        cvNewRoute3Complete.listeners = (ctx, fragment) -> LibQuest.updateQuest(QuestsIds.SEEKING_WISDOM, 4, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvNewRoute3Complete);

        // ===== QUEST: Free Spirit - Part 4 =====

        // Step 1: Player shows the book, Sariseus reacts and asks why
        ConversationOption cvFreeSpirit1 = new ConversationOption(0, 6);
        cvFreeSpirit1.addOptionText(ENGLISH, "Father, I found this ancient book written by your father.", "*Sariseus' eyes light up with recognition, reaching out to touch the cover gently*\n\nMy father's work! I haven't seen this tome in years... where did you find it?\n\n*He carefully opens the book, briefly scanning the familiar passages, then looks up at you with curiosity*\n\nThis book is about liberating trapped spirits. A rare and specific topic.\n\nWhat brings you to seek such knowledge?");
        cvFreeSpirit1.addOptionText(PORTUGUESE, "Padre, encontrei este livro antigo escrito por seu pai.", "*Os olhos de Sariseus se iluminam com reconhecimento, alcançando para tocar a capa gentilmente*\n\nO trabalho do meu pai! Não vejo este tomo há anos... onde o encontrou?\n\n*Ele abre cuidadosamente o livro, percorrendo brevemente as passagens familiares, depois olha para você com curiosidade*\n\nEste livro é sobre libertar espíritos presos. Um tema raro e específico.\n\nO que o traz a buscar tal conhecimento?");
        cvFreeSpirit1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.FREE_SPIRIT, 4)
                && LibInventory.checkHasItem(com.cnx.endlesstalestwo.data.items.ItemsIds.ANCIENT_LIBERATION_TOME, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvFreeSpirit1);

        // Step 2: Player explains about the spirit
        ConversationOption cvFreeSpiritExplain = new ConversationOption(6, 7);
        cvFreeSpiritExplain.addOptionText(ENGLISH, "[Explain about the spirit]", "*Sariseus listens attentively, his expression shifting from curiosity to deep compassion*\n\nA restless soul... wandering in the dead of night, trapped between worlds. My father wrote extensively about such cases.\n\n*He returns to the book, turning to a specific passage*\n\nYes... yes, it is all here. The ritual of liberation is simpler than one might expect. No sacred items, no elaborate ceremonies are needed.\n\nThe spirit must return to the place where she died. There, with a heart truly open to peace, she must surrender to the divine light and release all attachment to this world. It is through acceptance - not struggle - that the soul ascends.\n\n*He looks at you with quiet certainty*\n\nTell her this. If she is ready, the gods will do the rest.");
        cvFreeSpiritExplain.addOptionText(PORTUGUESE, "[Explicar sobre o espírito]", "*Sariseus escuta atentamente, sua expressão mudando de curiosidade para profunda compaixão*\n\nUma alma inquieta... vagando na madrugada, presa entre os mundos. Meu pai escreveu extensivamente sobre tais casos.\n\n*Ele retorna ao livro, virando para uma passagem específica*\n\nSim... sim, está tudo aqui. O ritual de libertação é mais simples do que se poderia esperar. Nenhum item sagrado, nenhuma cerimônia elaborada é necessária.\n\nO espírito deve retornar ao lugar onde morreu. Lá, com o coração verdadeiramente aberto à paz, ela deve se render à luz divina e libertar todo o apego a este mundo. É através da aceitação - não da luta - que a alma ascende.\n\n*Ele olha para você com quieta certeza*\n\nDiga a ela isso. Se ela estiver pronta, os deuses farão o resto.");
        npc.conversationOptions.add(cvFreeSpiritExplain);

        // Step 3: Player thanks and leaves
        ConversationOption cvFreeSpiritComplete = new ConversationOption(7, 0);
        cvFreeSpiritComplete.addOptionText(ENGLISH, "Thank you, Father. I'll tell the spirit.", "May the divine light guide both you and the spirit to peace. Go now, and help that poor soul find rest at last.");
        cvFreeSpiritComplete.addOptionText(PORTUGUESE, "Obrigado, Padre. Vou contar ao espírito.", "Que a luz divina guie você e o espírito à paz. Vá agora, e ajude essa pobre alma a encontrar descanso finalmente.");
        cvFreeSpiritComplete.listeners = (ctx, fragment) -> {
            LibInventory.removeFromInventory(com.cnx.endlesstalestwo.data.items.ItemsIds.ANCIENT_LIBERATION_TOME, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.FREE_SPIRIT, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvFreeSpiritComplete);

        return npc;
    }
}
