package com.cnx.endlesstalestwo.data.npcs.havarusNorth.swampIsland.fortress;

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

import java.util.Arrays;

public class Galdor extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Galdor");
        npc.age = 55;
        npc.job = Enums.NPCJobs.GUILD_LEADER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A gang leader who speaks few words.\nFirm, serious, and gruff.\nHe knows how to lead, fight, and survive.\n\nHis physical traits: Dark skin, serious gaze, full, graying beard. Skin marked by weariness and scars.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um líder de bandidagem que expressa poucas palavras.\nFirme, sério e grosseiro.\nSabe liderar, batalhar e sobreviver.\n\nSeus traços físicos: Pele morena, olhar sério, barba preenchida e grisalha. Pele sofrida e com cicatrizes.");
        npc.addDescriptionTranslation(SPANISH, "Un líder de pandilla de pocas palabras.\nFirme, serio y brusco.\nSabe liderar, luchar y sobrevivir.\n\nSus rasgos físicos: piel oscura, mirada seria, barba tupida y canosa. Piel marcada por el cansancio y las cicatrices.");

        // Greetings
        npc.greetingsMessages.put(ENGLISH, Arrays.asList(
                "Hmph. Another wanderer straying into my mire. State your business.",
                "Don't track mud in here... oh, wait, it's all mud. What is it?",
                "You reek of dry land. Make it quick.",
                "Unless you've got something useful to say, get lost."
        ));
        npc.greetingsMessages.put(PORTUGUESE, Arrays.asList(
                "Hmph. Outro andarilho perdido no meu lamaçal. Diga a que veio.",
                "Não entre sujando tudo de lama... ah, espera, é tudo lama mesmo. O que é?",
                "Você fede a terra seca. Seja rápido.",
                "A menos que tenha algo útil para dizer, desapareça."
        ));
        npc.greetingsMessages.put(SPANISH, Arrays.asList(
                "Hmph. Otro vagabundo perdido en mi ciénaga. Expón tu asunto.",
                "No traigas barro aquí... oh, espera, todo es barro. ¿Qué ocurre?",
                "Apestas a tierra firme. Date prisa.",
                "A menos que tengas algo útil que decir, piérdete."
        ));

        npc.byeMessages.put(ENGLISH, Arrays.asList("Finally. Don't let the leeches get you on the way out.", "Good riddance."));
        npc.byeMessages.put(PORTUGUESE, Arrays.asList("Finalmente. Não deixe as sanguessugas te pegarem na saída.", "Já vai tarde."));
        npc.byeMessages.put(SPANISH, Arrays.asList("Finalmente. Que no te piquen las sanguijuelas al salir.", "Menos mal."));

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What do you do around here?", "I think that's none of your business... I have my business and I do it my way, I conquered this swamp.");
        cv1.addOptionText(PORTUGUESE, "O que faz por aqui?", "Acho que isso não é da sua conta... Tenho meus negócios e faço do meu jeito, conquistei esse pântano.");
        cv1.addOptionText(SPANISH, "¿Qué hace por aquí?", "Creo que eso no es de tu incumbencia... Tengo mis negocios y los hago a mi manera, he conquistado este pantano.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv3 = new ConversationOption(0, 0);
        cv3.addOptionText(ENGLISH, "Something about this swamp...", "It's a swamp. It's wet, it's muddy, and it's mine. Problem?");
        cv3.addOptionText(PORTUGUESE, "Algo sobre este pântano...", "É um pântano. É úmido, é lamacento e é meu. Algum problema?");
        cv3.addOptionText(SPANISH, "Algo sobre este pantano...", "Es un pantano. Está húmedo, está fangoso y es mío. ¿Algún problema?");
        npc.conversationOptions.add(cv3);

        ///ABOUT QUEST: DESTROY THE LAIR
        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "I come on behalf of Griwalsh", "Ah, the old man from the south. He always buys my herbs, I left a bag reserved for him. You can take it here, it's already paid for.");
        cv2.addOptionText(PORTUGUESE, "Venho em nome de Griwalsh", "Ah, o velho do sul. Ele sempre compra minhas ervas, deixei um saco reservado para ele. Pode pegar aqui, já está pago.");
        cv2.addOptionText(SPANISH, "Vengo en nombre de Griwalsh", "Ah, el viejo del sur. Siempre compra mis hierbas, le dejé una bolsa reservada. Puedes cogerla aquí, ya está pagada.");
        cv2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DESTROY_THE_LAIR, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv2.listeners = (ctx, currentFragment) -> {
            LibInventory.addToInventory(ItemsIds.BAG_OF_SWAMP_HERBS, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.DESTROY_THE_LAIR, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv2);

        // ===== QUEST: Swamp Club - EVIL (Alignment ≤ 25) =====

        // Quest Introduction (only for evil characters)
        ConversationOption cvSwampIntro = new ConversationOption(0, 201);
        cvSwampIntro.addOptionText(ENGLISH, "I'm interested in... profitable work.", "*Eyes narrow, studying you carefully*\nProfitable, eh? \n*Grins darkly*\nI don't take just anyone into my operations. This swamp runs red with the blood of fools who thought they could handle the life. But you... you've got that look. That darkness in your eyes. Maybe you're not another soft-bellied coward after all.");
        cvSwampIntro.addOptionText(PORTUGUESE, "Estou interessado em... trabalho lucrativo.", "*Olhos se estreitam, estudando você cuidadosamente*\nLucrativo, é? \n*Sorri sombriamente*\nNão aceito qualquer um nas minhas operações. Este pântano corre vermelho com o sangue de tolos que acharam que podiam lidar com a vida. Mas você... você tem aquele olhar. Aquela escuridão nos olhos. Talvez você não seja apenas outro covarde fraco afinal.");
        cvSwampIntro.addOptionText(SPANISH, "Estoy interesado en... trabajo lucrativo.", "*Los ojos se estrechan, estudiándote cuidadosamente*\n¿Lucrativo, eh? \n*Sonríe sombríamente*\nNo acepto a cualquiera en mis operaciones. Este pantano corre rojo con la sangre de tontos que pensaron que podían manejar la vida. Pero tú... tienes esa mirada. Esa oscuridad en los ojos. Quizás no seas otro cobarde débil después de todo.");
        cvSwampIntro.requirementValidations = (chara, ctx) -> {
            // Only appears if alignment ≤ 25 AND quest not started
            if (!LibQuest.charHasQuest(QuestsIds.SWAMP_CLUB, chara)) {
                int alignment = chara.attributesManager.getCurrent(Enums.AttributeName.ALIGNMENT);
                if (alignment <= 25) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvSwampIntro);

        ConversationOption cvSwampTest = new ConversationOption(201, 202);
        cvSwampTest.addOptionText(ENGLISH, "I can handle whatever you throw at me.", "Bold words. Let's see if you can back them up. My gang doesn't play nice - we take what we want, when we want it. Rob, steal, intimidate... sometimes worse. If that's too much for your delicate conscience, leave now. But if you're ready to embrace the profitable side of darkness... I've got work for you.");
        cvSwampTest.addOptionText(PORTUGUESE, "Posso lidar com o que quer que você me lance.", "Palavras ousadas. Vamos ver se consegue cumprir. Minha gangue não brinca - pegamos o que queremos, quando queremos. Roubar, furtar, intimidar... às vezes pior. Se isso é demais para sua consciência delicada, vá embora agora. Mas se está pronto para abraçar o lado lucrativo das trevas... tenho trabalho para você.");
        cvSwampTest.addOptionText(SPANISH, "Puedo manejar lo que sea que me lances.", "Palabras audaces. Veamos si puedes respaldarlas. Mi banda no juega limpio: tomamos lo que queremos, cuando lo queremos. Robar, hurtar, intimidar... a veces peor. Si eso es demasiado para tu delicada conciencia, vete ahora. Pero si estás listo para abrazar el lado lucrativo de la oscuridad... tengo trabajo para ti.");
        npc.conversationOptions.add(cvSwampTest);

        ConversationOption cvSwampAccept = new ConversationOption(202, 0);
        cvSwampAccept.addOptionText(ENGLISH, "I'm in. What's the first job?", "*Leans back with satisfied grin*\nGood. First, I need information. There's a merchant route I want to hit, but I need to know when they travel. Go to Monelix Docks - find Captain Norman. He knows the routes. Get that information from him... by any means necessary. Don't be gentle. Intimidate him if you must. Just get me those routes.");
        cvSwampAccept.addOptionText(PORTUGUESE, "Estou dentro. Qual é o primeiro trabalho?", "*Reclina com sorriso satisfeito*\nBom. Primeiro, preciso de informações. Há uma rota de mercador que quero atacar, mas preciso saber quando viajam. Vá às Docas de Monelix - encontre Capitão Norman. Ele conhece as rotas. Consiga essa informação dele... por qualquer meio necessário. Não seja gentil. Intimide-o se precisar. Apenas me traga essas rotas.");
        cvSwampAccept.addOptionText(SPANISH, "Estoy dentro. ¿Cuál es el primer trabajo?", "*Se reclina con sonrisa satisfecha*\nBien. Primero, necesito información. Hay una ruta de mercaderes que quiero atacar, pero necesito saber cuándo viajan. Ve a los Muelles de Monelix: encuentra al Capitán Norman. Él conoce las rutas. Consigue esa información de él... por cualquier medio necesario. No seas amable. Intimídalo si es necesario. Solo tráeme esas rutas.");
        cvSwampAccept.listeners = (ctx, currentFragment) -> LibQuest.includeQuestToQuestbook(QuestsIds.SWAMP_CLUB, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvSwampAccept);

        // After completing each part - progress dialogue

        // Part 2: Report Intelligence
        ConversationOption cvPart1Complete = new ConversationOption(0, 0);
        cvPart1Complete.addOptionText(ENGLISH, "I got the information. Merchants travel through Havarus Main Road.", "*Grins wickedly*\nPerfect. Norman sang like a bird, did he? Good. Now we know exactly where to strike. Next - put that information to use. Go to Havarus Main Road and ambush that merchant. Take everything he's carrying. Don't leave witnesses.");
        cvPart1Complete.addOptionText(PORTUGUESE, "Consegui a informação. Mercadores viajam pela Estrada Principal de Havarus.", "*Sorri maliciosamente*\nPerfeito. Norman cantou como um passarinho, não foi? Bom. Agora sabemos exatamente onde atacar. Próximo - use essa informação. Vá até a Estrada Principal de Havarus e embosque aquele mercador. Pegue tudo que ele carrega. Não deixe testemunhas.");
        cvPart1Complete.addOptionText(SPANISH, "Conseguí la información. Los mercaderes viajan por el Camino Principal de Havarus.", "*Sonríe maliciosamente*\nPerfecto. Norman cantó como un pájaro, ¿verdad? Bien. Ahora sabemos exactamente dónde atacar. Siguiente: usa esa información. Ve al Camino Principal de Havarus y embosca a ese mercader. Toma todo lo que lleva. No dejes testigos.");
        cvPart1Complete.requirementValidations = (chara, ctx) -> LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SWAMP_CLUB, 2) ? Enums.RequirementVerification.OK : Enums.RequirementVerification.NOT_OK;
        cvPart1Complete.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(QuestsIds.SWAMP_CLUB, 3, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvPart1Complete);

        // Part 3 → 4: Rob Merchant Complete — player returns to Galdor at part 4
        ConversationOption cvPart2Complete = new ConversationOption(0, 0);
        cvPart2Complete.addOptionText(ENGLISH, "The merchant won't be troubling anyone.", "*Counts stolen goods with approval*\nNot bad. You didn't hesitate. That's good. Next job - I need you to visit Letow. Those villagers have been... resistant to paying protection money. Make them understand who's in charge. Rough up a few if needed. Come back with gold.");
        cvPart2Complete.addOptionText(PORTUGUESE, "O mercador não vai incomodar ninguém.", "*Conta mercadorias roubadas com aprovação*\nNada mal. Você não hesitou. Isso é bom. Próximo trabalho - preciso que visite Letow. Aqueles aldeões têm sido... resistentes a pagar dinheiro de proteção. Faça-os entender quem está no comando. Bata em alguns se necessário. Volte com ouro.");
        cvPart2Complete.addOptionText(SPANISH, "El mercader no molestará a nadie.", "*Cuenta mercancías robadas con aprobación*\nNada mal. No vacilaste. Eso es bueno. Siguiente trabajo: necesito que visites Letow. Esos aldeanos han sido... resistentes a pagar dinero de protección. Hazles entender quién manda. Golpea a algunos si es necesario. Vuelve con oro.");
        cvPart2Complete.requirementValidations = (chara, ctx) -> LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SWAMP_CLUB, 4) ? Enums.RequirementVerification.OK : Enums.RequirementVerification.NOT_OK;
        cvPart2Complete.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(QuestsIds.SWAMP_CLUB, 5, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvPart2Complete);

        // Part 6 → 7: Extort Letow Complete — player returns to Galdor at part 6
        ConversationOption cvPart3Complete = new ConversationOption(0, 0);
        cvPart3Complete.addOptionText(ENGLISH, "The villagers paid. Fear works wonders.", "Excellent. Fear is the best teacher. Now, we need supplies - food, weapons. There's a storage in Farmland. Break in, take what we need. There'll be guards. Fight them if you must. Bring back supplies.");
        cvPart3Complete.addOptionText(PORTUGUESE, "Os aldeões pagaram. Medo funciona maravilhas.", "Excelente. Medo é o melhor professor. Agora, precisamos de suprimentos - comida, armas. Há um armazenamento em Farmland. Invada, pegue o que precisamos. Haverá guardas. Lute contra eles se precisar. Traga suprimentos.");
        cvPart3Complete.addOptionText(SPANISH, "Los aldeanos pagaron. El miedo funciona maravillas.", "Excelente. El miedo es el mejor maestro. Ahora, necesitamos suministros: comida, armas. Hay un almacenamiento en Farmland. Irrumpe, toma lo que necesitamos. Habrá guardias. Lucha contra ellos si es necesario. Trae suministros.");
        cvPart3Complete.requirementValidations = (chara, ctx) -> LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SWAMP_CLUB, 6) ? Enums.RequirementVerification.OK : Enums.RequirementVerification.NOT_OK;
        cvPart3Complete.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(QuestsIds.SWAMP_CLUB, 7, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvPart3Complete);

        // Part 8 → 9: Raid Farmland Complete — player returns to Galdor at part 8
        ConversationOption cvPart4Complete = new ConversationOption(0, 0);
        cvPart4Complete.addOptionText(ENGLISH, "Farmland storage has been... cleared out.", "Perfect. You're proving useful. Now - I need materials to set up traps on trade routes. Bring me: 1 Hunting Trap, 3 Ropes, 3 Rocks, and 1 Log. We'll sabotage the roads, force merchants through OUR paths.");
        cvPart4Complete.addOptionText(PORTUGUESE, "O armazenamento de Farmland foi... esvaziado.", "Perfeito. Você está se provando útil. Agora - preciso de materiais para montar armadilhas nas rotas comerciais. Traga-me: 1 Armadilha de Caça, 3 Cordas, 3 Pedras e 1 Tora. Vamos sabotar as estradas, forçar mercadores através dos NOSSOS caminhos.");
        cvPart4Complete.addOptionText(SPANISH, "El almacenamiento de Farmland ha sido... vaciado.", "Perfecto. Estás demostrando ser útil. Ahora: necesito materiales para montar trampas en las rutas comerciales. Tráeme: 1 Trampa de Caza, 3 Cuerdas, 3 Piedras y 1 Tronco. Sabotearemos los caminos, forzaremos a los mercaderes a través de NUESTROS caminos.");
        cvPart4Complete.requirementValidations = (chara, ctx) -> LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SWAMP_CLUB, 8) ? Enums.RequirementVerification.OK : Enums.RequirementVerification.NOT_OK;
        cvPart4Complete.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(QuestsIds.SWAMP_CLUB, 9, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvPart4Complete);

        // Part 9 → 10: Deliver Sabotage Materials — player at part 9 with items
        ConversationOption cvPart5Complete = new ConversationOption(0, 0);
        cvPart5Complete.addOptionText(ENGLISH, "Here are the materials for the traps.", "*Examines materials*\nGood quality. These'll work perfectly. Now... we have a problem. Someone in Farmland saw one of our operations. A witness. They're planning to talk to authorities. Find them. Silence them. Permanently. I don't care how you do it.");
        cvPart5Complete.addOptionText(PORTUGUESE, "Aqui estão os materiais para as armadilhas.", "*Examina materiais*\nBoa qualidade. Isso funcionará perfeitamente. Agora... temos um problema. Alguém em Farmland viu uma de nossas operações. Uma testemunha. Estão planejando falar com as autoridades. Encontre-os. Silencie-os. Permanentemente. Não me importo como você faz.");
        cvPart5Complete.addOptionText(SPANISH, "Aquí están los materiales para las trampas.", "*Examina materiais*\nBuena calidad. Funcionarán perfectamente. Ahora... tenemos un problema. Alguien en Farmland vio una de nuestras operaciones. Un testigo. Están planeando hablar con las autoridades. Encuéntralo. Siléncialo. Permanentemente. No me importa cómo lo hagas.");
        cvPart5Complete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SWAMP_CLUB, 9)) {
                boolean hasTrap = LibInventory.checkHasItemAmount(ItemsIds.HUNTING_TRAP, 1, chara);
                boolean hasRope = LibInventory.checkHasItemAmount(ItemsIds.ROPE, 3, chara);
                boolean hasStone = LibInventory.checkHasItemAmount(ItemsIds.ROCK, 3, chara);
                boolean hasLog = LibInventory.checkHasItemAmount(ItemsIds.LOG, 1, chara);
                if (hasTrap && hasRope && hasStone && hasLog) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvPart5Complete.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.HUNTING_TRAP, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.ROPE, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.ROCK, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.LOG, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.SWAMP_CLUB, 10, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPart5Complete);

        // Part 11 → Prison Break: Witness silenced — player returns to Galdor at part 11
        ConversationOption cvPart6Complete = new ConversationOption(0, 203);
        cvPart6Complete.addOptionText(ENGLISH, "The witness problem is... solved.", "*Cold smile*\nRuthless. I like that. You've proven yourself - robbed, intimidated, killed without hesitation. You're one of us now. But there's one final job. One of my men is imprisoned. Break into the prison and free him. There'll be guards. Handle them. Bring him back alive.");
        cvPart6Complete.addOptionText(PORTUGUESE, "O problema da testemunha está... resolvido.", "*Sorriso frio*\nImpiedoso. Gosto disso. Você se provou - roubou, intimidou, matou sem hesitar. Você é um de nós agora. Mas há um trabalho final. Um dos meus homens está preso. Invada a prisão e liberte-o. Haverá guardas. Cuide deles. Traga-o de volta vivo.");
        cvPart6Complete.addOptionText(SPANISH, "El problema del testigo está... resuelto.", "*Sonrisa fría*\nDespiadado. Me gusta eso. Te has probado: robaste, intimidaste, mataste sin vacilar. Eres uno de nosotros ahora. Pero hay un trabajo final. Uno de mis hombres está encarcelado. Irrumpe en la prisión y libéralo. Habrá guardias. Encárgate de ellos. Tráelo de vuelta vivo.");
        cvPart6Complete.requirementValidations = (chara, ctx) -> LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SWAMP_CLUB, 11) ? Enums.RequirementVerification.OK : Enums.RequirementVerification.NOT_OK;
        npc.conversationOptions.add(cvPart6Complete);

        ConversationOption cvPrisonBreak = new ConversationOption(203, 0);
        cvPrisonBreak.addOptionText(ENGLISH, "I'll break him out.", "Then move. Prison won't be easy - guards are trained. But you've handled worse. Don't disappoint me.");
        cvPrisonBreak.addOptionText(PORTUGUESE, "Vou libertá-lo.", "Então vá. A prisão não será fácil - guardas são treinados. Mas você já lidou com pior. Não me decepcione.");
        cvPrisonBreak.addOptionText(SPANISH, "Lo liberaré.", "Entonces muévete. La prisión no será fácil: los guardias están entrenados. Pero has manejado cosas peores. No me decepciones.");
        // NO listener - battle at Prison Cells will update to Part 12 on victory
        npc.conversationOptions.add(cvPrisonBreak);

        // Quest completion — player at part 12 after prison break victory
        ConversationOption cvComplete = new ConversationOption(0, 0);
        cvComplete.addOptionText(ENGLISH, "The prison break was successful.", "*Nods with approval*\nImpressive. You've proven yourself through crime and violence. You're a natural. Welcome to the gang, officially. You've got a place here in the swamp, among real predators. \n*Hands you a dark shield and coins*\nYour rewards. Wear that shield with pride - it marks you as one of us. We'll have more work soon. Dark, profitable work.");
        cvComplete.addOptionText(PORTUGUESE, "A fuga da prisão foi um sucesso.", "*Acena com aprovação*\nImpressionante. Você se provou através de crime e violência. Você é um nato. Bem-vindo à gangue, oficialmente. Você tem um lugar aqui no pântano, entre predadores reais. \n*Entrega um escudo escuro e moedas*\nSuas recompensas. Use esse escudo com orgulho - marca você como um de nós. Teremos mais trabalho em breve. Trabalho escuro e lucrativo.");
        cvComplete.addOptionText(SPANISH, "La fuga de la prisión fue un éxito.", "*Asiente con aprobación*\nImpresionante. Te has probado a través del crimen y la violencia. Eres un nato. Bienvenido a la banda, oficialmente. Tienes un lugar aquí en el pantano, entre depredadores reales. \n*Te entrega un escudo oscuro y monedas*\nTus recompensas. Usa ese escudo con orgullo: te marca como uno de nosotros. Tendremos más trabajo pronto. Trabajo oscuro y lucrativo.");
        cvComplete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.SWAMP_CLUB, 12) && !LibQuest.isQuestComplete(chara, QuestsIds.SWAMP_CLUB)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvComplete.listeners = (ctx, currentFragment) -> {
            App.getPlayerChar().attributesManager.decrease(Enums.AttributeName.ALIGNMENT, 15);
            LibQuest.completeQuest(QuestsIds.SWAMP_CLUB, App.getPlayerChar(), 12, ctx);
        };
        npc.conversationOptions.add(cvComplete);

        // After quest roleplay
        ConversationOption cvAfterQuest = new ConversationOption(0, 0);
        cvAfterQuest.addOptionText(ENGLISH, "Any more work available?", "Always. The criminal life never stops. Check back later - I'll have something profitable for someone with your... talents.");
        cvAfterQuest.addOptionText(PORTUGUESE, "Há mais trabalho disponível?", "Sempre. A vida criminosa nunca para. Volte mais tarde - terei algo lucrativo para alguém com seus... talentos.");
        cvAfterQuest.addOptionText(SPANISH, "¿Hay más trabajo disponible?", "Siempre. La vida criminal nunca se detiene. Vuelve más tarde: tendré algo lucrativo para alguien con tus... talentos.");
        cvAfterQuest.requirementValidations = (chara, ctx) -> LibQuest.isQuestComplete(chara, QuestsIds.SWAMP_CLUB) ? Enums.RequirementVerification.OK : Enums.RequirementVerification.NOT_OK;
        npc.conversationOptions.add(cvAfterQuest);

        // ========================================
        // QUEST: CONTRABAND — PART 31 (Swamp Fortress)
        // ========================================

        ConversationOption cvContrabandPart31 = new ConversationOption(0, 0);
        cvContrabandPart31.addOptionText(ENGLISH, "Mordius sent me. I have the sealed monastery package.",
                "*His eyes narrow, but a knowing glimmer appears*\nMordius... yes. About time.\n\n*He takes the package, checks the seal briefly, and pockets it without ceremony*\n\nTell that priest his goods arrived safe. And tell him the swamp always pays its debts. Eventually.");
        cvContrabandPart31.addOptionText(PORTUGUESE, "Mordius me enviou. Tenho o pacote selado do monastério.",
                "*Seus olhos se estreitam, mas um brilho de entendimento aparece*\nMordius... sim. Já era hora.\n\n*Ele pega o pacote, verifica o selo brevemente e o guarda sem cerimônia*\n\nDiga a esse padre que as mercadorias chegaram seguras. E diga a ele que o pântano sempre paga suas dívidas. Eventualmente.");
        cvContrabandPart31.addOptionText(SPANISH, "Mordius me envió. Tengo el paquete sellado del monasterio.",
                "*Sus ojos se estrechan, pero aparece un brillo de entendimiento*\nMordius... sí. Ya era hora.\n\n*Toma el paquete, verifica el sello brevemente y lo guarda sin ceremonia*\n\nDile a ese sacerdote que sus mercancías llegaron seguras. Y dile que el pantano siempre paga sus deudas. Eventualmente.");
        cvContrabandPart31.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.CONTRABAND, 31)
                    && LibInventory.checkHasItem(ItemsIds.CONTRABAND_PACKAGE, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvContrabandPart31.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.CONTRABAND_PACKAGE, 1, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.CONTRABAND, 40, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvContrabandPart31);

        return npc;
    }
}

