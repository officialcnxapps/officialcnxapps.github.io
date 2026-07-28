package com.cnx.endlesstalestwo.data.npcs.wazel.towerWarriors;

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

public class Eridan extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Eridan");
        npc.age = 29;
        npc.job = Enums.NPCJobs.SOLDIER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Skilled warrior.\nHe likes his craft and hopes to grow in his career.\nCurious and fearless.\n\nHis physical traits: Dark eyes with Oriental features. Black hair as well as his goatee. Friendly expression.");
        npc.addDescriptionTranslation(PORTUGUESE, "Guerreiro habilidoso.\nGosta do seu ofício e espera crescer na carreira.\nCurioso e destemido.\n\nSeus traços físicos: Olhos escuros e com traços orientais. Cabelos pretos assim como o cavanhaque. Espressão amigável.");
        npc.addDescriptionTranslation(SPANISH, "Guerrero habilidoso.\nLe gusta su oficio y espera crecer en su carrera.\nCurioso e intrépido.\n\nSus rasgos físicos: Ojos oscuros con rasgos orientales. Cabello negro al igual que su perilla. Expresión amigable.");

        // ===== ROLEPLAY CONVERSATIONS =====

        ConversationOption cvRoleplay1 = new ConversationOption(0, 1);
        cvRoleplay1.addOptionText(ENGLISH, "How are you, soldier?", "Still alive, which is more than I can say for some. These golems... they're not like anything we've trained to fight. Ancient creatures with power beyond normal beasts.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Como vai, soldado?", "Ainda vivo, o que é mais do que posso dizer sobre alguns. Esses golens... não são como qualquer coisa que fomos treinados para lutar. Criaturas antigas com poder além das bestas normais.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cómo estás, soldado?", "Todavía vivo, que es más de lo que puedo decir de algunos. Estos gólems... no son como nada para lo que hayamos sido entrenados. Criaturas antiguas con poder más allá de las bestias normales.");
        cvRoleplay1.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.THE_GOLEM_TALE, chara) || LibQuest.isQuestComplete(chara, QuestsIds.THE_GOLEM_TALE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay1);

        // ===== QUEST: THE GOLEM TALE =====

        // Quest Introduction
        ConversationOption cvQuestIntro = new ConversationOption(1, 101);
        cvQuestIntro.addOptionText(ENGLISH, "You mentioned golems. Tell me about them.", "*Face hardens with painful memory*\nA few months ago, I was on patrol in the desert near Wazel. Sand Golem... massive creature made of living sand with ancient runes carved into its body. It almost killed me. \n\n*Shows scar on arm*\nLeft me with this. Ever since, I've been obsessed. I need to understand these creatures - all four types. Sand, Forest, Mountain, and Ice. If I can get samples from each, maybe I can find their weaknesses.");
        cvQuestIntro.addOptionText(PORTUGUESE, "Você mencionou golens. Me fale sobre eles.", "*Rosto endurece com memória dolorosa*\nHá alguns meses, estava em patrulha no deserto perto de Wazel. Golem de Areia... criatura massiva feita de areia viva com runas antigas esculpidas em seu corpo. Quase me matou. \n\n*Mostra cicatriz no braço*\nMe deixou com isto. Desde então, estou obcecado. Preciso entender essas criaturas - todos os quatro tipos. Areia, Floresta, Montanha e Gelo. Se eu conseguir amostras de cada um, talvez possa encontrar suas fraquezas.");
        cvQuestIntro.addOptionText(SPANISH, "Mencionaste gólems. Cuéntame sobre ellos.", "*Rostro se endurece con recuerdo doloroso*\nHace unos meses, estaba en patrulla en el desierto cerca de Wazel. Gólem de Arena... criatura masiva hecha de arena viva con runas antiguas talladas en su cuerpo. Casi me mata. \n\n*Muestra cicatriz en brazo*\nMe dejó con esto. Desde entonces, estoy obsesionado. Necesito entender a estas criaturas: los cuatro tipos. Arena, Bosque, Montaña y Hielo. Si puedo obtener muestras de cada uno, quizás pueda encontrar sus debilidades.");
        cvQuestIntro.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.THE_GOLEM_TALE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestIntro);

        ConversationOption cvQuestAccept = new ConversationOption(101, 0);
        cvQuestAccept.addOptionText(ENGLISH, "I'll help you hunt these golems.", "*Eyes light up with hope*\nReally? Thank you! These creatures are incredibly dangerous. The Sand Golem roams desert areas. The Forest Golem protects ancient groves. The Mountain Golem dwells in rocky peaks. And the Ice Golem guards frozen lands. \n\nI need you to defeat each one and bring me a sample - anything that proves they can bleed, break, or be destroyed. Can you do this?");
        cvQuestAccept.addOptionText(PORTUGUESE, "Vou ajudá-lo a caçar esses golens.", "*Olhos brilham com esperança*\nSério? Obrigado! Essas criaturas são incrivelmente perigosas. O Golem de Areia vagueia por áreas desérticas. O Golem da Floresta protege bosques antigos. O Golem da Montanha habita em picos rochosos. E o Golem de Gelo guarda terras congeladas. \n\nPreciso que você derrote cada um e me traga uma amostra - qualquer coisa que prove que eles podem sangrar, quebrar ou ser destruídos. Pode fazer isto?");
        cvQuestAccept.addOptionText(SPANISH, "Te ayudaré a cazar estos gólems.", "*Los ojos brillan con esperanza*\n¿En serio? ¡Gracias! Estas criaturas son increíblemente peligrosas. El Gólem de Arena vaga por áreas desérticas. El Gólem del Bosque protege bosques antiguos. El Gólem de la Montaña habita en picos rocosos. Y el Gólem de Hielo guarda tierras congeladas. \n\nNecesito que derrotes a cada uno y me traigas una muestra: cualquier cosa que demuestre que pueden sangrar, romperse o ser destruidos. ¿Puedes hacerlo?");
        cvQuestAccept.listeners = (ctx, currentFragment) -> LibQuest.includeQuestToQuestbook(QuestsIds.THE_GOLEM_TALE, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvQuestAccept);

        // Part 1: Sand Golem Sample - Update to Part 2
        ConversationOption cvPart1Complete = new ConversationOption(0, 0);
        cvPart1Complete.addOptionText(ENGLISH, "I defeated the Sand Golem. Here's your sample.", "*Takes the enchanted sand, examining it carefully*\nIncredible... it's still warm, still shifting. The magic binding these creatures is ancient beyond measure. One down, three to go. Next - find the Forest Golem. It dwells in ancient groves, protecting nature itself.");
        cvPart1Complete.addOptionText(PORTUGUESE, "Derrotei o Golem de Areia. Aqui está sua amostra.", "*Pega a areia encantada, examinando cuidadosamente*\nIncrível... ainda está quente, ainda mudando. A magia que liga essas criaturas é antiga além da medida. Um feito, faltam três. Próximo - encontre o Golem da Floresta. Ele habita em bosques antigos, protegendo a própria natureza.");
        cvPart1Complete.addOptionText(SPANISH, "Derroté al Gólem de Arena. Aquí está tu muestra.", "*Toma la arena encantada, examinándola cuidadosamente*\nIncreíble... todavía está caliente, todavía cambiando. La magia que une a estas criaturas es antigua más allá de la medida. Uno hecho, faltan tres. Siguiente: encuentra al Gólem del Bosque. Habita en bosques antiguos, protegiendo la naturaleza misma.");
        cvPart1Complete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_GOLEM_TALE, 1) && LibInventory.checkHasItem(ItemsIds.ENCHANTED_DESERT_SAND, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPart1Complete.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.ENCHANTED_DESERT_SAND, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.THE_GOLEM_TALE, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPart1Complete);

        // Part 2: Forest Golem Sample - Update to Part 3
        ConversationOption cvPart2Complete = new ConversationOption(0, 0);
        cvPart2Complete.addOptionText(ENGLISH, "The Forest Golem has fallen. Here's the mosswood.", "*Holds the living wood, amazed as leaves sprout*\nFascinating... life that never ends. These golems are truly elemental forces given form. Two down. The Mountain Golem awaits - the strongest and most ancient. Seek it in the rocky peaks where few dare tread.");
        cvPart2Complete.addOptionText(PORTUGUESE, "O Golem da Floresta caiu. Aqui está a madeira musgosa.", "*Segura a madeira viva, admirado enquanto folhas brotam*\nFascinante... vida que nunca acaba. Esses golens são verdadeiramente forças elementais dadas à forma. Dois feitos. O Golem da Montanha aguarda - o mais forte e mais antigo. Procure-o nos picos rochosos onde poucos ousam pisar.");
        cvPart2Complete.addOptionText(SPANISH, "El Gólem del Bosque ha caído. Aquí está la madera musgosa.", "*Sostiene la madera viva, asombrado mientras brotan hojas*\nFascinante... vida que nunca termina. Estos gólems son verdaderamente fuerzas elementales dadas forma. Dos hechos. El Gólem de la Montaña aguarda: el más fuerte y más antiguo. Búscalo en los picos rocosos donde pocos se atreven a pisar.");
        cvPart2Complete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_GOLEM_TALE, 2) && LibInventory.checkHasItem(ItemsIds.LIVING_MOSSWOOD, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPart2Complete.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.LIVING_MOSSWOOD, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.THE_GOLEM_TALE, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPart2Complete);

        // Part 3: Mountain Golem Sample - Update to Part 4
        ConversationOption cvPart3Complete = new ConversationOption(0, 0);
        cvPart3Complete.addOptionText(ENGLISH, "The Mountain Golem is defeated. These runes are powerful.", "*Studies the runic stone with reverence*\nBy the gods... these runes are older than our kingdoms. The magic here is primal, pure earth power. Only one remains - the Ice Golem of the frozen north. Complete the collection, and we'll finally understand these ancient guardians.");
        cvPart3Complete.addOptionText(PORTUGUESE, "O Golem da Montanha está derrotado. Essas runas são poderosas.", "*Estuda a pedra rúnica com reverência*\nPelos deuses... essas runas são mais antigas que nossos reinos. A magia aqui é primitiva, puro poder da terra. Apenas um resta - o Golem de Gelo do norte congelado. Complete a coleção, e finalmente entenderemos esses guardiões antigos.");
        cvPart3Complete.addOptionText(SPANISH, "El Gólem de la Montaña está derrotado. Estas runas son poderosas.", "*Estudia la piedra rúnica con reverencia*\nPor los dioses... estas runas son más antiguas que nuestros reinos. La magia aquí es primitiva, puro poder de la tierra. Solo queda uno: el Gólem de Hielo del norte congelado. Completa la colección, y finalmente entenderemos a estos guardianes antiguos.");
        cvPart3Complete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_GOLEM_TALE, 3) && LibInventory.checkHasItem(ItemsIds.RUNIC_STONE_FRAGMENT, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPart3Complete.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.RUNIC_STONE_FRAGMENT, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.THE_GOLEM_TALE, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPart3Complete);

        // Part 4: Ice Golem Sample - Update to Part 5
        ConversationOption cvPart4Complete = new ConversationOption(0, 0);
        cvPart4Complete.addOptionText(ENGLISH, "The Ice Golem is no more. Here's the final sample.", "*Takes the eternal ice crystal, feeling its cold*\nPerfect. All four samples collected. Sand, Wood, Stone, and Ice. Let me examine them together...");
        cvPart4Complete.addOptionText(PORTUGUESE, "O Golem de Gelo não existe mais. Aqui está a amostra final.", "*Pega o cristal de gelo eterno, sentindo seu frio*\nPerfeito. Todas as quatro amostras coletadas. Areia, Madeira, Pedra e Gelo. Deixe-me examiná-las juntas...");
        cvPart4Complete.addOptionText(SPANISH, "El Gólem de Hielo ya no existe. Aquí está la muestra final.", "*Toma el cristal de hielo eterno, sintiendo su frío*\nPerfecto. Las cuatro muestras recopiladas. Arena, Madera, Piedra y Hielo. Déjame examinarlas juntas...");
        cvPart4Complete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_GOLEM_TALE, 4) && LibInventory.checkHasItem(ItemsIds.ETERNAL_ICE_CRYSTAL, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPart4Complete.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.ETERNAL_ICE_CRYSTAL, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.THE_GOLEM_TALE, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPart4Complete);

        // Part 5: All Samples Delivered - Quest Complete
        ConversationOption cvComplete = new ConversationOption(0, 0);
        cvComplete.addOptionText(ENGLISH, "What did you discover about the golems?", "*Looks up with newfound understanding*\nThese aren't just weapons or guardians. They're... protectors. Each one guarding a specific element of nature. We've been thinking of them as monsters, but they're custodians of the world's magic. \n\n*Looks at you with newfound respect*\nYou've given me what I sought - understanding. Not how to destroy them, but why they exist. Thank you, my friend. Here - take this. You've earned it, and you've taught me a valuable lesson about respecting the old magic.");
        cvComplete.addOptionText(PORTUGUESE, "O que você descobriu sobre os golens?", "*Olha para cima com nova compreensão*\nEstes não são apenas armas ou guardiões. São... protetores. Cada um guardando um elemento específico da natureza. Temos pensado neles como monstros, mas são custodiantes da magia do mundo. \n\n*Olha para você com novo respeito*\nVocê me deu o que busquei - compreensão. Não como destruí-los, mas por que eles existem. Obrigado, meu amigo. Aqui - pegue isto. Você mereceu, e me ensinou uma lição valiosa sobre respeitar a magia antiga.");
        cvComplete.addOptionText(SPANISH, "¿Qué descubriste sobre los gólems?", "*Levanta la mirada con nueva comprensión*\nEstos no son solo armas o guardianes. Son... protectores. Cada uno guardando un elemento específico de la naturaleza. Hemos estado pensando en ellos como monstruos, pero son custodios de la magia del mundo. \n\n*Te mira con nuevo respeto*\nMe has dado lo que buscaba: comprensión. No cómo destruirlos, sino por qué existen. Gracias, mi amigo. Aquí, toma esto. Te lo has ganado, y me has enseñado una lección valiosa sobre respeitar la magia antigua.");
        cvComplete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_GOLEM_TALE, 5)
                    && !LibQuest.isQuestComplete(chara, QuestsIds.THE_GOLEM_TALE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvComplete.listeners = (ctx, currentFragment) -> LibQuest.completeQuest(QuestsIds.THE_GOLEM_TALE, App.getPlayerChar(), 5, ctx);
        npc.conversationOptions.add(cvComplete);

        // After Quest Roleplay
        ConversationOption cvAfterQuest = new ConversationOption(0, 0);
        cvAfterQuest.addOptionText(ENGLISH, "How are your golem studies going?", "I've learned so much from those samples. The golems aren't our enemies - they're guardians of natural balance. Ancient magic given form to protect the elements. I've shared this knowledge with other soldiers. Perhaps we can coexist with these creatures rather than fight them.");
        cvAfterQuest.addOptionText(PORTUGUESE, "Como vão seus estudos sobre golens?", "Aprendi tanto com essas amostras. Os golens não são nossos inimigos - são guardiões do equilíbrio natural. Magia antiga dada forma para proteger os elementos. Compartilhei esse conhecimento com outros soldados. Talvez possamos coexistir com essas criaturas ao invés de lutar contra elas.");
        cvAfterQuest.addOptionText(SPANISH, "¿Cómo van tus estudios sobre gólems?", "He aprendido tanto de esas muestras. Los gólems no son nuestros enemigos: son guardianes del equilibrio natural. Magia antigua dada forma para proteger los elementos. He compartido este conocimento con otros soldados. Quizás podamos coexistir con estas criaturas en lugar de luchar contra ellas.");
        cvAfterQuest.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.THE_GOLEM_TALE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAfterQuest);

        npc.hasRandomizedConversations = true;
        return npc;
    }
}




