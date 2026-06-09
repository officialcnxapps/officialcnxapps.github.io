package com.cnx.endlesstalestwo.data.npcs.ayalon.citySquare;

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

public class Casiel extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Casiel");
        npc.age = 186;
        npc.job = Enums.NPCJobs.PRIEST;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Casiel always seems enigmatic, with distant thoughts but still remaining attentive to his world.\nWise, a great knower of the past and ancestral magic.\nA master in his field. At times he seems very nostalgic. No known living relatives.\n\nHis physical traits: Straight, short black hair. Light green skin. In addition to his ears, his nose is also pointed.");
        npc.addDescriptionTranslation(PORTUGUESE, "Casiel parece sempre enigmático, com pensamentos distantes porém não deixando de estar atento ao seu mundo.\nSábio, grande conhecedor do passado e das magias ancestrais.\nUm mestre na sua área. Por vezes parece muito saudosista. Nenhum familiar vivo conhecido.\n\nSeus taços físicos:  Cabelos lisos negros e curtos. Pele verde clara. Além das orelhas, seu nariz também é pontudo.");
        npc.addDescriptionTranslation(SPANISH, "Casiel siempre parece enigmático, con pensamientos distantes pero sin dejar de estar atento a su mundo.\nSabio, gran conocedor del pasado y de las magias ancestrales.\nUn maestro en su área. A veces parece muy nostálgico. Sin familiares vivos conocidos.\n\nSus rasgos físicos: Cabello liso negro y corto. Piel verde clara. Además de las orejas, su nariz también es puntiaguda.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Greetings, human. I am Casiel, the High Mage of Ayalon. How may I assist you?"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Saudações, humano. Sou Casiel, o Alto Mago de Ayalon. Como posso ajudá-lo?"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Saludos, humano. Soy Casiel, el Alto Mago de Ayalon. ¿Cómo puedo ayudarte?"));

        // Casiel disappears after portal fails (Part 4+) - he betrayed everyone and fled
        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_PORTAL, 4) ||
                    LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_PORTAL, 5) ||
                    LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_PORTAL, 6) ||
                    LibQuest.isQuestComplete(chara, QuestsIds.THE_PORTAL)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        // ===== MAGICAL SUPPLIES QUEST: Part 3 - Learn about counter-portal =====
        ConversationOption cvMagicalSupplies1 = new ConversationOption(0, 1);
        cvMagicalSupplies1.addOptionText(ENGLISH, "Casiel, Nelera sent me. We need your help with a demon summoning.", "*Eyes narrow with concern*\nA demon summoning? This is grave news indeed. Nelera is wise to seek counsel. Tell me what you know of this threat.");
        cvMagicalSupplies1.addOptionText(PORTUGUESE, "Casiel, Nelera me enviou. Precisamos da sua ajuda com uma invocação demoníaca.", "*Olhos se estreitam com preocupação*\nUma invocação demoníaca? São notícias graves de fato. Nelera é sábia em buscar conselho. Conte-me o que sabe sobre essa ameaça.");
        cvMagicalSupplies1.addOptionText(SPANISH, "Casiel, Nelera me envió. Necesitamos tu ayuda con una invocación demoníaca.", "*Los ojos se estrechan con preocupación*\n¿Una invocación demoníaca? Son noticias graves en verdad. Nelera es sabia al buscar consejo. Cuéntame lo que sabes de esta amenaza.");
        cvMagicalSupplies1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.MAGICAL_SUPPLIES, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvMagicalSupplies1);

        ConversationOption cvMagicalSupplies2 = new ConversationOption(1, 2);
        cvMagicalSupplies2.addOptionText(ENGLISH, "[Explain about Targon and the dark rituals]", "*Strokes chin thoughtfully*\nTargon the Voidbringer... I know of this demon. Ancient texts speak of him - a creature of immense malevolence from the deepest pits of the underworld. If dark cultists are truly attempting to summon him to your realm, the consequences would be catastrophic. Entire kingdoms could fall before his power.");
        cvMagicalSupplies2.addOptionText(PORTUGUESE, "[Explicar sobre Targon e os rituais das trevas]", "*Acaricia o queixo pensativamente*\nTargon o Portador do Vazio... Conheço esse demônio. Textos ancestrais falam dele - uma criatura de imensa malevolência dos poços mais profundos do submundo. Se cultistas das trevas estão verdadeiramente tentando invocá-lo para seu reino, as consequências seriam catastróficas. Reinos inteiros poderiam cair diante de seu poder.");
        cvMagicalSupplies2.addOptionText(SPANISH, "[Explicar sobre Targon y los rituales oscuros]", "*Acaricia la barbilla pensativamente*\nTargon el Portador del Vacío... Conozco a este demonio. Textos ancestrales hablan de él - una criatura de inmensa malevolencia de los pozos más profundos del inframundo. Si cultistas oscuros están verdaderamente intentando invocarlo a tu reino, las consecuencias serían catastróficas. Reinos enteros podrían caer ante su poder.");
        npc.conversationOptions.add(cvMagicalSupplies2);

        ConversationOption cvMagicalSupplies3 = new ConversationOption(2, 3);
        cvMagicalSupplies3.addOptionText(ENGLISH, "Is there a way to stop him? Nelera mentioned a counter-portal...", "*Nods slowly*\nYes, there is hope. The counter-portal spell Nelera discovered in our archives is powerful magic - ancient elven sorcery from the wars of old. It creates a reversal gateway, a magical vortex that can pull Targon back to the underworld before he fully manifests in your world.\n\nBut such magic requires specific components. The spell binds the demon's essence and forces it back through the dimensional barrier. We must act swiftly - once Targon fully crosses over, the spell becomes far more difficult to cast.");
        cvMagicalSupplies3.addOptionText(SPANISH, "¿Hay una manera de detenerlo? Nelera mencionó un contraportal...", "*Asiente lentamente*\nSí, hay esperanza. El hechizo de contraportal que Nelera descubrió en nuestros archivos es magia poderosa - hechicería élfica ancestral de las guerras antiguas. Crea un portal de reversión, un vórtice mágico que puede empujar a Targon de vuelta al inframundo antes de que se manifieste completamente en tu mundo.\n\nPero tal magia requiere componentes específicos. El hechizo ata la esencia del demonio y la fuerza de vuelta a través de la barrera dimensional. Debemos actuar rápidamente - una vez que Targon cruce completamente, el hechizo se vuelve mucho más difícil de lanzar.");
        npc.conversationOptions.add(cvMagicalSupplies3);

        ConversationOption cvMagicalSupplies4 = new ConversationOption(3, 0);
        cvMagicalSupplies4.addOptionText(ENGLISH, "What components do we need for this spell?", "*Gestures to ancient scrolls*\nThe counter-portal requires ingredients that channel both natural and mystical energies. Bring me these items:\n\n- 1 White Herb - for purity and cleansing\n- 2 Red Herbs - for life force and vitality\n- 2 Yellow Herbs - for light and warding\n- Emerald Dust - to stabilize the magical vortex\n- Wine - as a catalyst for the ritual\n\nThese components may seem simple, but together they form a powerful magical matrix. Gather them and return to me. Time is of the essence.");
        cvMagicalSupplies4.addOptionText(PORTUGUESE, "Quais componentes precisamos para esse feitiço?", "*Gesticula para pergaminhos ancestrais*\nO contra-portal requer ingredientes que canalizam energias naturais e místicas. Traga-me estes itens:\n\n- 1 Erva Branca - para pureza e limpeza\n- 2 Ervas Vermelhas - para força vital e vitalidade\n- 2 Ervas Amarelas - para luz e proteção\n- Pó de Esmeralda - para estabilizar o vórtice mágico\n- Vinho - como catalisador para o ritual\n\nEstes componentes podem parecer simples, mas juntos formam uma matriz mágica poderosa. Reúna-os e retorne para mim. O tempo é essencial.");
        cvMagicalSupplies4.addOptionText(SPANISH, "¿Qué componentes necesitamos para este hechizo?", "*Gesticula hacia pergaminos ancestrales*\nEl contraportal requiere ingredientes que canalizan energías naturales y místicas. Tráeme estos artículos:\n\n- 1 Hierba Blanca - para pureza y limpieza\n- 2 Hierbas Rojas - para fuerza vital y vitalidad\n- 2 Hierbas Amarillas - para luz y protección\n- Polvo de Esmeralda - para estabilizar el vórtice mágico\n- Vino - como catalizador para el ritual\n\nEstos componentes pueden parecer simples, pero juntos forman una matriz mágica poderosa. Reúnelos y vuelve a mí. El tiempo es esencial.");
        cvMagicalSupplies4.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(QuestsIds.MAGICAL_SUPPLIES, 4, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvMagicalSupplies4);

        // ===== MAGICAL SUPPLIES QUEST: Part 4 - Deliver ingredients =====
        ConversationOption cvMagicalSupplies5 = new ConversationOption(0, 4);
        cvMagicalSupplies5.addOptionText(ENGLISH, "Casiel, I've gathered the ingredients you requested.", "*Examines the items carefully*\nGood, good... \n*carefully inspects each component*\nThe herbs are fresh, properly harvested. The emerald dust has the right crystalline structure. The wine... yes, this will suffice as a catalyst.");
        cvMagicalSupplies5.addOptionText(PORTUGUESE, "Casiel, reuni os ingredientes que você pediu.", "*Examina os itens cuidadosamente*\nBom, bom... \n*inspeciona cuidadosamente cada componente*\nAs ervas estão frescas, adequadamente colhidas. O pó de esmeralda tem a estrutura cristalina correta. O vinho... sim, isto servirá como catalisador.");
        cvMagicalSupplies5.addOptionText(SPANISH, "Casiel, he reunido los ingredientes que solicitaste.", "*Examina los artículos cuidadosamente*\nBien, bien... \n*inspecciona cuidadosamente cada componente*\nLas hierbas están frescas, adecuadamente cosechadas. El polvo de esmeralda tiene la estructura cristalina correcta. El vino... sí, esto servirá como catalizador.");
        cvMagicalSupplies5.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.isCharacterAtQuestPart(chara, QuestsIds.MAGICAL_SUPPLIES, 4)) {
                return Enums.RequirementVerification.NOT_OK;
            }

            boolean hasWhiteHerb = LibInventory.checkHasItemAmount(ItemsIds.WHITE_HERB, 1, chara);
            boolean hasRedHerbs = LibInventory.checkHasItemAmount(ItemsIds.RED_HERB, 2, chara);
            boolean hasYellowHerbs = LibInventory.checkHasItemAmount(ItemsIds.YELLOW_HERB, 2, chara);
            boolean hasEmeraldPowder = LibInventory.checkHasItemAmount(ItemsIds.EMERALD_POWDER, 1, chara);
            boolean hasWine = LibInventory.checkHasItemAmount(ItemsIds.WINE, 1, chara);

            if (hasWhiteHerb && hasRedHerbs && hasYellowHerbs && hasEmeraldPowder && hasWine) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvMagicalSupplies5);

        ConversationOption cvMagicalSupplies6 = new ConversationOption(4, 5);
        cvMagicalSupplies6.addOptionText(ENGLISH, "Is this everything we need?", "*Hesitates, then sets down the components*\nI must be honest with you, [PLAYERNAME]. These ingredients will form the foundation of the counter-portal spell, but... \n*sighs heavily*\nthere is one more component. The most difficult one to obtain.");
        cvMagicalSupplies6.addOptionText(PORTUGUESE, "Isso é tudo que precisamos?", "*Hesita, então coloca os componentes no chão*\nDevo ser honesto com você, [PLAYERNAME]. Estes ingredientes formarão a fundação do feitiço de contra-portal, mas... \n*suspira pesadamente*\nhá mais um componente. O mais difícil de obter.");
        cvMagicalSupplies6.addOptionText(SPANISH, "¿Esto es todo lo que necesitamos?", "*Vacila, luego deja los componentes*\nDebo ser honesto contigo, [PLAYERNAME]. Estos ingredientes formarán la base del hechizo de contraportal, pero... \n*suspira pesadamente*\nhay un componente más. El más difícil de obtener.");
        npc.conversationOptions.add(cvMagicalSupplies6);

        ConversationOption cvMagicalSupplies7 = new ConversationOption(5, 0);
        cvMagicalSupplies7.addOptionText(ENGLISH, "What is this final ingredient?", "*Takes the ingredients and stores them safely*\nThe spell requires an anchor - something from the underworld itself to create a stable connection for the reversal. This anchor must be powerful enough to bind Targon's essence. I did not mention it before because... such a thing is incredibly rare and dangerous to obtain.\n\n*Looks at you gravely*\nWe need a fragment of underworld essence - a crystallized piece of dark energy from the demon realm. Finding such an artifact will not be easy. This requires further investigation. Return to me when you're ready to continue this perilous quest.");
        cvMagicalSupplies7.addOptionText(PORTUGUESE, "Qual é esse ingrediente final?", "*Pega os ingredientes e os guarda com segurança*\nO feitiço requer uma âncora - algo do próprio submundo para criar uma conexão estável para a reversão. Esta âncora deve ser poderosa o suficiente para prender a essência de Targon. Não mencionei antes porque... tal coisa é incrivelmente rara e perigosa de obter.\n\n*Olha para você gravemente*\nPrecisamos de um fragmento de essência do submundo - um pedaço cristalizado de energia das trevas do reino demoníaco. Encontrar tal artefato não será fácil. Isto requer mais investigação. Retorne para mim quando estiver pronto para continuar esta perigosa missão.");
        cvMagicalSupplies7.addOptionText(SPANISH, "¿Cuál es este ingrediente final?", "*Toma los ingredientes y los guarda con seguridad*\nEl hechizo requiere un ancla - algo del propio inframundo para crear una conexión estable para la reversión. Esta ancla debe ser lo suficientemente poderosa para atar la esencia de Targon. No lo mencioné antes porque... tal cosa es increíblemente rara y peligrosa de obtener.\n\n*Te mira gravemente*\nNecesitamos un fragmento de esencia del inframundo - una pieza cristalizada de energía oscura del reino demoníaco. Encontrar tal artefacto no será fácil. Esto requiere más investigación. Vuelve a mí cuando estés listo para continuar esta peligrosa misión.");
        cvMagicalSupplies7.listeners = (ctx, currentFragment) -> {
            // Remove ingredients from inventory
            LibInventory.removeFromInventory(ItemsIds.WHITE_HERB, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.RED_HERB, 2, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.YELLOW_HERB, 2, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.EMERALD_POWDER, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.WINE, 1, App.getPlayerChar());

            LibQuest.completeQuest(QuestsIds.MAGICAL_SUPPLIES, App.getPlayerChar(), 5, ctx);
            LibQuest.includeQuestToQuestbook(QuestsIds.ONE_LAST_INGREDIENT, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvMagicalSupplies7);

        // ===== ONE LAST INGREDIENT QUEST: Part 1 - Need for Dark Blood =====
        ConversationOption cvOneLastStart = new ConversationOption(0, 0);
        cvOneLastStart.addOptionText(ENGLISH, "What's next for the counter-portal?", "*Sighs heavily*\nThere is... a complication. The ritual requires one more ingredient - something I hesitated to mention earlier. \n*picks up a tome*\nThe counter-portal needs an anchor - a piece of the underworld itself to create a stable connection. Specifically, we need blood from someone who serves the dark forces. A cultist who participated in Targon's summoning.\n\nWithout this anchor, the portal will be unstable and likely fail. I know this is asking much, but you must find one of these dark mages and... acquire their blood. It's distasteful, I know, but necessary. Perhaps your military contact, Guzar, might have intelligence on where to find such individuals.");
        cvOneLastStart.addOptionText(PORTUGUESE, "Qual é o próximo passo para o contra-portal?", "*Suspira pesadamente*\nHá... uma complicação. O ritual requer mais um ingrediente - algo que hesitei em mencionar antes. \n*pega um tomo*\nO contra-portal precisa de uma âncora - um pedaço do próprio submundo para criar uma conexão estável. Especificamente, precisamos de sangue de alguém que serve às forças das trevas. Um cultista que participou da invocação de Targon.\n\nSem esta âncora, o portal será instável e provavelmente falhará. Sei que estou pedindo muito, mas você deve encontrar um desses magos das trevas e... adquirir seu sangue. É desagradável, eu sei, mas necessário. Talvez seu contato militar, Guzar, possa ter informações sobre onde encontrar tais indivíduos.");
        cvOneLastStart.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ONE_LAST_INGREDIENT, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvOneLastStart);

        // ===== ONE LAST INGREDIENT QUEST: Part 4 - Deliver Dark Blood =====
        ConversationOption cvOneLastIngredient1 = new ConversationOption(0, 6);
        cvOneLastIngredient1.addOptionText(ENGLISH, "Casiel, I obtained the dark blood you needed.", "*Eyes widen with surprise*\nYou... you actually found it? \n*carefully examines the vial*\nYes, this is authentic. I can sense the corrupted essence within. Dark magic leaves a distinct signature - like rot upon the soul. [PLAYERNAME], acquiring this must have been dangerous. You have my gratitude.");
        cvOneLastIngredient1.addOptionText(PORTUGUESE, "Casiel, obtive o sangue negro que você precisava.", "*Olhos se arregalam com surpresa*\nVocê... você realmente o encontrou? \n*examina cuidadosamente o frasco*\nSim, isto é autêntico. Posso sentir a essência corrompida dentro dele. Magia negra deixa uma assinatura distinta - como podridão na alma. [PLAYERNAME], adquirir isto deve ter sido perigoso. Tem minha gratidão.");
        cvOneLastIngredient1.addOptionText(SPANISH, "Casiel, obtuve la sangre oscura que necesitabas.", "*Los ojos se abren con sorpresa*\nTú... ¿realmente la encontraste? \n*examina cuidadosamente el frasco*\nSí, esto es auténtico. Puedo sentir la esencia corrompida dentro. La magia oscura deja una firma distinta - como podredumbre en el alma. [PLAYERNAME], adquirir esto debe haber sido peligroso. Tienes mi gratitud.");
        cvOneLastIngredient1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.ONE_LAST_INGREDIENT, 4)) {
                if (LibInventory.checkHasItemAmount(ItemsIds.DARK_BLOOD, 1, chara)) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvOneLastIngredient1);

        ConversationOption cvOneLastIngredient2 = new ConversationOption(6, 7);
        cvOneLastIngredient2.addOptionText(ENGLISH, "Can you prepare the counter-portal now?", "*Nods solemnly*\nYes. With this final ingredient, I can complete the ritual. \n*begins mixing the blood with the herbal potion*\nThe process is delicate - I must bind the dark essence to the herbs and infuse everything into an enchanted scroll. Watch closely...");
        cvOneLastIngredient2.addOptionText(PORTUGUESE, "Você pode preparar o contra-portal agora?", "*Acena solenemente*\nSim. Com este ingrediente final, posso completar o ritual. \n*começa a misturar o sangue com a poção de ervas*\nO processo é delicado - devo prender a essência das trevas às ervas e infundir tudo em um pergaminho encantado. Observe atentamente...");
        cvOneLastIngredient2.addOptionText(SPANISH, "¿Puedes preparar el contraportal ahora?", "*Asiente solemnemente*\nSí. Con este ingrediente final, puedo completar el ritual. \n*comienza a mezclar la sangre con la poción de hierbas*\nEl proceso es delicado - debo atar la esencia oscura a las hierbas e infundir todo en un pergamino encantado. Observa atentamente...");
        npc.conversationOptions.add(cvOneLastIngredient2);

        ConversationOption cvOneLastIngredient3 = new ConversationOption(7, 8);
        cvOneLastIngredient3.addOptionText(ENGLISH, "[Watch the ritual]", "*Casiel chants in ancient elvish, his hands glowing with silver light. The dark blood begins to shimmer as it mixes with the herbal potion, turning from crimson to deep purple. He carefully pours the mixture over an ornate scroll, the liquid seeping into the parchment itself.*\n\n\n*Runic symbols appear on the scroll, pulsing with contained power. After several minutes, Casiel's chanting ceases. The ritual is complete.*\n");
        cvOneLastIngredient3.addOptionText(PORTUGUESE, "[Observar o ritual]", "*Casiel canta em élfico ancestral, suas mãos brilhando com luz prateada. O sangue negro começa a cintilar ao se misturar com a poção de ervas, mudando de carmesim para roxo profundo. Ele cuidadosamente despeja a mistura sobre um pergaminho ornamentado, o líquido penetrando no próprio pergaminho.*\n\n\n*Símbolos rúnicos aparecem no pergaminho, pulsando com poder contido. Após vários minutos, o canto de Casiel cessa. O ritual está completo.*\n");
        cvOneLastIngredient3.addOptionText(SPANISH, "[Observar el ritual]", "*Casiel canta en élfico ancestral, sus manos brillando con luz plateada. La sangre oscura comienza a brillar al mezclarse con la poción de hierbas, cambiando de carmesí a púrpura profundo. Cuidadosamente vierte la mezcla sobre un pergamino ornamentado, el líquido penetrando en el propio pergamino.*\n\n\n*Símbolos rúnicos aparecen en el pergamino, pulsando con poder contenido. Después de varios minutos, el canto de Casiel cesa. El ritual está completo.*\n");
        npc.conversationOptions.add(cvOneLastIngredient3);

        ConversationOption cvOneLastIngredient4 = new ConversationOption(8, 0);
        cvOneLastIngredient4.addOptionText(ENGLISH, "Is it ready?", "*Hands you the scroll carefully*\nIt is done. This scroll contains a reversal portal - when opened in Targon's presence, it will create a vortex pulling him back to the underworld. \n*His expression grows serious*\nBut [PLAYERNAME], you must understand - this will only work if Targon hasn't fully manifested. Once a demon lord completely crosses the dimensional barrier, even this magic may not be enough.\n\nYou must find him quickly, before his summoning is complete. Open the scroll, aim it at him, and the magic will do the rest. Go now - time is against us.");
        cvOneLastIngredient4.addOptionText(PORTUGUESE, "Está pronto?", "*Entrega o pergaminho cuidadosamente*\nEstá feito. Este pergaminho contém um portal de reversão - quando aberto na presença de Targon, criará um vórtice puxando-o de volta ao submundo. \n*Sua expressão fica séria*\nMas [PLAYERNAME], você deve entender - isto só funcionará se Targon não tiver se manifestado completamente. Uma vez que um lorde demoníaco cruze completamente a barreira dimensional, até mesmo esta magia pode não ser suficiente.\n\nVocê deve encontrá-lo rapidamente, antes que sua invocação esteja completa. Abra o pergaminho, aponte para ele, e a magia fará o resto. Vá agora - o tempo está contra nós.");
        cvOneLastIngredient4.addOptionText(SPANISH, "¿Está listo?", "*Te entrega el pergamino cuidadosamente*\nEstá hecho. Este pergamino contiene un portal de reversión - cuando se abra en presencia de Targon, creará un vórtice que lo arrastrará de vuelta al inframundo. \n*Su expresión se vuelve seria*\nPero [PLAYERNAME], debes entender - esto solo funcionará si Targon no se ha manifestado completamente. Una vez que un señor demonio cruce completamente la barrera dimensional, incluso esta magia puede no ser suficiente.\n\nDebes encontrarlo rápidamente, antes de que su invocación esté completa. Abre el pergamino, apúntalo hacia él, y la magia hará el resto. Ve ahora - el tiempo está en nuestra contra.");
        cvOneLastIngredient4.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.DARK_BLOOD, 1, App.getPlayerChar());
            LibQuest.completeQuest(QuestsIds.ONE_LAST_INGREDIENT, App.getPlayerChar(), 5, ctx);
            LibQuest.includeQuestToQuestbook(QuestsIds.THE_PORTAL, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvOneLastIngredient4);

        // ===== ROLEPLAY CONVERSATIONS - FAMILY LOSS =====
        // Random conversation about Ayalon's peace (hints at loss)
        ConversationOption cvFamily1 = new ConversationOption(0, 0);
        cvFamily1.addOptionText(ENGLISH, "Ayalon seems like a peaceful place.", "*A shadow crosses his face*\nYes... it is peaceful now. I cherish this tranquility more than most, perhaps. \n*pauses, looking distant*\nNot all of us have always known such peace. \n\n*quickly changes subject*\nBut enough of that. Is there something specific you need assistance with?");
        cvFamily1.addOptionText(PORTUGUESE, "Ayalon parece um lugar pacífico.", "*Uma sombra cruza seu rosto*\nSim... é pacífico agora. Valorizo esta tranquilidade mais do que a maioria, talvez. \n*pausa, parecendo distante*\nNem todos nós sempre conhecemos tal paz. \n\n*rapidamente muda de assunto*\nMas chega disso. Há algo específico com que precisa de assistência?");
        cvFamily1.addOptionText(SPANISH, "Ayalon parece un lugar pacífico.", "*Una sombra cruza su rostro*\nSí... es pacífico ahora. Aprecio esta tranquilidad más que la mayoría, quizás. \n*pausa, pareciendo distante*\nNo todos nosotros siempre hemos conocido tal paz. \n\n*rápidamente cambia de tema*\nPero basta de eso. ¿Hay algo específico en lo que necesites asistencia?");
        npc.conversationOptions.add(cvFamily1);

        // Random conversation about home and what we protect
        ConversationOption cvFamily3 = new ConversationOption(0, 109);
        cvFamily3.addOptionText(ENGLISH, "What is your role among the elves?", "I am the High Mage of Ayalon. I have many years of experience with magic and nature, and for some time now I have been deeply studying all spectrums of magic, elements and realms.\nThis allows me to be responsible for the magical protection of our people.");
        cvFamily3.addOptionText(PORTUGUESE, "Qual seu ofício perante os elfos?", "Eu sou o alto mago de Ayalon, tenho muitos anos de experiência com magia e natureza, há já alguns anos que estudo profundamente todos os espectros de magias, elementos e mundos.\nIsso me permite ser o responsável pela proteção mágica do nosso povo.");
        cvFamily3.addOptionText(SPANISH, "¿Cuál es tu oficio entre los elfos?", "Soy el Alto Mago de Ayalon, tengo muchos años de experiencia con la magia y la naturaleza, y hace ya algún tiempo que estudio profundamente todos los espectros de magia, elementos y mundos.\nEsto me permite ser el responsable de la protección mágica de nuestro pueblo.");
        npc.conversationOptions.add(cvFamily3);

        // Random conversation about home and what we protect
        ConversationOption cvFamily4 = new ConversationOption(109, 0);
        cvFamily4.addOptionText(ENGLISH, "What drives you to protect people so fiercely?", "*Eyes grow distant, pain flickering briefly*\nWhen you... when you lose those you care about most, you understand the true value of protection. \n*clenches fist slightly*\nI have seen what happens when darkness is allowed to flourish unchecked. I will not... I cannot let it happen again. \n\n*voice becomes firm*\nEvery life saved, every threat stopped - it matters. It all matters.");
        cvFamily4.addOptionText(PORTUGUESE, "O que o motiva a proteger as pessoas tão ferozmente?", "*Olhos ficam distantes, dor cintilando brevemente*\nQuando você... quando perde aqueles que mais ama, entende o verdadeiro valor da proteção. \n*fecha o punho ligeiramente*\nVi o que acontece quando a escuridão é permitida florescer sem controle. Não vou... não posso deixar acontecer novamente. \n\n*voz fica firme*\nCada vida salva, cada ameaça detida - importa. Tudo importa.");
        cvFamily4.addOptionText(SPANISH, "¿Qué te motiva a proteger a la gente tan ferozmente?", "*Los ojos se vuelven distantes, dolor parpadeando brevemente*\nCuando tú... cuando pierdes a aquellos que más amas, entiendes el verdadero valor de la protección. \n*cierra el puño ligeramente*\nHe visto lo que pasa cuando se permite que la oscuridad florezca sin control. No voy... no puedo dejar que pase de nuevo. \n\n*la voz se vuelve firme*\nCada vida salvada, cada amenaza detenida - importa. Todo importa.");
        npc.conversationOptions.add(cvFamily4);

        // Random conversation 1
        ConversationOption cvRandom1 = new ConversationOption(109, 111);
        cvRandom1.addOptionText(ENGLISH, "What is it like being the High Mage of Ayalon?", "It is both an honor and a great responsibility. I have dedicated centuries to mastering the arcane arts and protecting my people. Magic is not merely about power - it requires wisdom, discipline, and understanding the delicate balance between the natural and mystical realms. Every spell I cast, every decision I make, affects not just individuals but the entire fabric of our society.");
        cvRandom1.addOptionText(PORTUGUESE, "Como é ser o Alto Mago de Ayalon?", "É tanto uma honra quanto uma grande responsabilidade. Dediquei séculos para dominar as artes arcanas e proteger meu povo. Magia não é meramente sobre poder - requer sabedoria, disciplina e compreensão do delicado equilíbrio entre os reinos natural e místico. Cada feitiço que lanço, cada decisão que tomo, afeta não apenas indivíduos, mas toda a estrutura de nossa sociedade.");
        cvRandom1.addOptionText(SPANISH, "¿Cómo es ser el Alto Mago de Ayalon?", "Es tanto un honor como una gran responsabilidad. He dedicado siglos a dominar las artes arcanas y proteger a mi gente. La magia no es meramente sobre el poder - requiere sabiduría, disciplina y comprensión del delicado equilibrio entre los reinos natural y místico. Cada hechizo que lanzo, cada decisión que tomo, afecta no solo a individuos, sino a toda la estructura de nuestra sociedad.");
        npc.conversationOptions.add(cvRandom1);

        // Random conversation about time and memory
        ConversationOption cvFamily2 = new ConversationOption(111, 0);
        cvFamily2.addOptionText(ENGLISH, "You mentioned having centuries to study magic. Don't you ever feel lonely?", "*Expression becomes guarded*\nLoneliness... yes, it can be a companion to those who live as long as we do. Some losses... \n*voice catches slightly*\nSome losses echo across the years, no matter how much time passes. \n\n*straightens, regaining composure*\nBut I have my duties, my studies. Purpose helps one endure much.");
        cvFamily2.addOptionText(PORTUGUESE, "Você mencionou ter séculos para estudar magia. Nunca se sente solitário?", "*Expressão fica cautelosa*\nSolidão... sim, pode ser uma companheira daqueles que vivem tanto quanto nós. Algumas perdas... \n*voz falha ligeiramente*\nAlgumas perdas ecoam através dos anos, não importa quanto tempo passe. \n\n*endireita-se, recuperando a compostura*\nMas tenho meus deveres, meus estudos. Propósito ajuda a suportar muito.");
        npc.conversationOptions.add(cvFamily2);

        // Random conversation 2
        ConversationOption cvRandom2 = new ConversationOption(0, 0);
        cvRandom2.addOptionText(ENGLISH, "How do elves view magic differently than humans?", "Elves see magic as an extension of nature itself - we do not force or dominate it, but rather flow with its currents like a river. Humans often approach magic with impatience, seeking quick power without understanding its deeper essence. This is not criticism, merely observation. Your shorter lifespans drive you to accomplish much in little time. We elves have centuries to study, meditate, and truly comprehend the mysteries we wield.");
        cvRandom2.addOptionText(PORTUGUESE, "Como os elfos veem a magia de forma diferente dos humanos?", "Elfos veem a magia como uma extensão da própria natureza - não a forçamos ou dominamos, mas fluímos com suas correntes como um rio. Humanos frequentemente abordam a magia com impaciência, buscando poder rápido sem entender sua essência mais profunda. Isto não é crítica, meramente observação. Suas vidas mais curtas os impulsionam a realizar muito em pouco tempo. Nós elfos temos séculos para estudar, meditar e verdadeiramente compreender os mistérios que manejamos.");
        cvRandom2.addOptionText(SPANISH, "¿Cómo ven los elfos la magia de manera diferente a los humanos?", "Los elfos ven la magia como una extensión de la naturaleza misma - no la forzamos o dominamos, sino que fluimos con sus corrientes como un río. Los humanos a menudo abordan la magia con impaciencia, buscando poder rápido sin entender su esencia más profunda. Esto no es crítica, meramente observación. Sus vidas más cortas los impulsan a lograr mucho en poco tiempo. Nosotros los elfos tenemos siglos para estudiar, meditar y verdaderamente comprender los misterios que manejamos.");
        npc.conversationOptions.add(cvRandom2);

        return npc;
    }
}
