package com.cnx.endlesstalestwo.data.npcs.havarusNorth.greatRock;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.DRAGONS;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.LEARNING_CLIMBING;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Martin extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Martin");
        npc.age = 34;
        npc.job = Enums.NPCJobs.ADVENTURER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A born adventurer. He wanders the lands of the kingdom.\nLively, happy and with a great sense of humor.\nPerhaps more innocent than he should be for his age.\n\nHis physical traits: Very sparse beard, short hair covered by his yellow beret. Light blue eyes and a peculiar metal monocle.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um aventureiro nato. Vaga pelas terras do reino.\nAnimado, feliz e com senso de humor elevado.\nTalvez mais inocente do que deveria para sua idade.\n\nSeus traços físicos: Barba bem rala, cabelo curto coberto pela sua boina amarela. Olhos azuis claros e um óculos esquisito de metal.");
        npc.addDescriptionTranslation(SPANISH, "Un aventurero nato. Vaga por las tierras del reino.\nAnimado, feliz y con gran sentido del humor.\nQuizás más inocente de lo que debería para su edad.\n\nSus rasgos físicos: Barba muy escasa, cabello corto cubierto por su boina amarilla. Ojos azules claros y un peculiar monóculo de metal.");

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "What do you do around here?", "Me? I climb. The Great Rock, mostly. It's not just a hobby, it's... well, it's everything. The wind in your hair, the burn in your muscles, the view from the top... there's nothing like it.");
        cv1.addOptionText(PORTUGUESE, "O que você faz por aqui?", "Eu? Eu escalo. A Grande Rocha, principalmente. Não é só um passatempo, é... bem, é tudo. O vento no cabelo, a queimação nos músculos, a vista do topo... não há nada igual.");
        cv1.addOptionText(SPANISH, "¿Qué haces por aquí?", "Yo? Escalo. La Gran Roca, sobre todo. No es solo un hobby, es... bueno, lo es todo. El viento en el pelo, el ardor en los músculos, la vista desde la cima... no hay nada igual.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Heard any good stories about the Great Rock lately?", "Well, they say a dragon once tried to take a bite out of it, but broke all its teeth! Probably just a tall tale, but it makes for a good laugh at the tavern, eh?");
        cv2.addOptionText(PORTUGUESE, "Ouviu alguma boa história sobre a Grande Rocha ultimamente?", "Bem, dizem que um dragão uma vez tentou dar uma mordida nela, mas quebrou todos os dentes! Provavelmente apenas uma história da carochinha, mas rende boas risadas na taverna, hein?");
        cv2.addOptionText(SPANISH, "¿Has oído alguna buena historia sobre la Gran Roca últimamente?", "Bueno, dicen que un dragón intentó una vez morderla, ¡pero se rompió todos los dientes! Probablemente solo sea un cuento chino, pero da para unas buenas risas en la taberna, ¿eh?");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(1, 0);
        cv3.addOptionText(ENGLISH, "What's the toughest climb you've ever faced?", "Toughest? Ha! Every climb is just a warm-up for the Great Rock! Though, there was this one time I wrestled a grumpy mountain goat for the last good handhold... the goat won that round, the cheeky devil.");
        cv3.addOptionText(PORTUGUESE, "Qual foi a escalada mais difícil que você já enfrentou?", "Mais difícil? Ha! Cada escalada é apenas um aquecimento para a Grande Rocha! Embora, houve uma vez que lutei com uma cabra montesa mal-humorada pelo último bom apoio para as mãos... a cabra venceu aquela rodada, a diabinha atrevida.");
        cv3.addOptionText(SPANISH, "¿Cuál es la escalada más difícil a la que te has enfrentado?", "¿La más difícil? ¡Ja! ¡Cada escalada es solo un calentamiento para la Gran Roca! Aunque, hubo una vez que luché con una cabra montés gruñona por el último buen agarre... la cabra ganó esa ronda, la muy pilla.");
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(1, 2);
        cv4.addOptionText(ENGLISH, "I'd like to learn climbing.", "Really? I'd love to teach, it would be good to see another enthusiast!\nOf course, I'd accept a small gift for the help, but if you want, I'll teach you.");
        cv4.addOptionText(PORTUGUESE, "Eu gostaria de aprender escalada.", "Verdade? Eu adoraria ensinar, seria bom ver outro entusiasta!\nClaro, eu aceitaria um presentinho pela ajuda, mas se quiser, eu lhe ensino.");
        cv4.addOptionText(SPANISH, "Me gustaría aprender a escalar.", "¿En serio? ¡Me encantaría enseñar, sería bueno ver a otro entusiasta!\nPor supuesto, aceptaría un pequeño regalo por la ayuda, pero si quieres, te enseñaré.");
        cv4.requirementValidations = (ctx, currentFragment) -> {
            if (LibQuest.charHasQuest(LEARNING_CLIMBING, App.getPlayerChar())) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(2, 0);
        cv5.addOptionText(ENGLISH, "I accept your help, what do you want in return?", "Wonderful!\nI'll ask for just one simple thing. I need to improve my equipment and for that I need some materials: ropes, strings and tissues.\nBring me some while I prepare a climbing lesson.");
        cv5.addOptionText(PORTUGUESE, "Aceito sua ajuda, o que quer em troca?", "Maravilha!\nVou pedir apenas uma coisa simples. Preciso melhorar meus equipamentos e pra isso preciso de alguns materiais: cordas, cordões e tecidos.\nMe traga alguns enquanto preparo uma aula de escalada.");
        cv5.addOptionText(SPANISH, "Acepto tu ayuda, ¿qué quieres a cambio?", "¡Maravilloso!\nSolo pediré una cosa sencilla. Necesito mejorar mi equipo y para ello necesito algunos materiales: cuerdas, cordeles y tejidos.\nTráeme algunos mientras preparo una lección de escalada.");
        cv5.listeners = (ctx, currentFragment) -> {
            LibQuest.includeQuestToQuestbook(LEARNING_CLIMBING, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv5);

        ConversationOption cv6 = new ConversationOption(0, 0);
        cv6.addOptionText(ENGLISH, "I have your materials", "Well, well, that's good! Now, it's simple, I'll show you the most important aspects of climbing. In fact, you can keep one of the ropes, you'll need it.\n<1 hour passes>\nAlright, I think you can try on your own now.");
        cv6.addOptionText(PORTUGUESE, "Estou com seus materiais", "Ora, ora, que bom! Agora, é simples, vou lhe mostrar os aspectos mais importantes da escalada. Inclusive, pode ficar com uma das cordas, vai precisar.\n<Passa-se 1 hora>\nCerto, acho que você pode tentar por conta própria agora.");
        cv6.addOptionText(SPANISH, "Tengo tus materiales", "¡Bueno, bueno, qué bien! Ahora, es sencillo, te mostraré los aspectos más importantes de la escalada. De hecho, puedes quedarte con una de las cuerdas, la necesitarás.\n<Pasa 1 hora>\nMuy bien, creo que ya puedes intentarlo por tu cuenta.");
        cv6.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, LEARNING_CLIMBING, 1)
                    && LibInventory.checkHasItemAmount(ItemsIds.ROPE, 2, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.STRING, 3, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.TISSUE, 2, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cv6.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.STRING, 3, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.ROPE, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.TISSUE, 2, App.getPlayerChar());
            App.Shell.flowManager.updateInGameTime(60, false, ctx);
            LibQuest.updateQuest(LEARNING_CLIMBING, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv6);

        ConversationOption cv7 = new ConversationOption(0, 0);
        cv7.addOptionText(ENGLISH, "Climbing has proven to be very useful!", "I knew it! It allows you to see the world from much more incredible points and find unique and unexplored places. I'm glad I taught you.");
        cv7.addOptionText(PORTUGUESE, "Escalar se mostrou bem útil!", "Eu sabia! Isso lhe permite ver o mundo de pontos muito mais incríveis e encontrar locais únicos e nunca explorados. Fico feliz em ter lhe ensinado.");
        cv7.addOptionText(SPANISH, "¡Escalar ha demostrado ser muy útil!", "¡Lo sabía! Te permite ver el mundo desde puntos mucho más increíbles y encontrar lugares únicos e inexplorados. Me alegro de haberte enseñado.");
        cv7.requirementValidations = (ctx, currentFragment) -> {
            if (LibQuest.isQuestComplete(App.getPlayerChar(), LEARNING_CLIMBING)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv7);

        // ========================================
        // QUEST: DRAGONS?
        // ========================================

        // Part 3: Talk to Martin
        ConversationOption cvDragonsPart3Start = new ConversationOption(0, 10);
        cvDragonsPart3Start.addOptionText(ENGLISH, "Have you seen anything unusual from the peaks recently?",
                "*He lowers his googles, his usual cheerful expression turning curious*\nUnusual? Well, the wind's been biting harder, and the goats are more skittish than a cat in a dog kennel. But if you're asking about the sky... I did see something that made my hair stand on end.");
        cvDragonsPart3Start.addOptionText(PORTUGUESE, "Você viu algo incomum dos picos recentemente?",
                "*Ele baixa os óculos, sua expressão alegre habitual tornando-se curiosa*\nIncomum? Bem, o vento tem batido mais forte e as cabras estão mais ariscas que gato em canil. Mas se você está perguntando sobre o céu... eu vi algo que me deixou de cabelo em pé.");
        cvDragonsPart3Start.addOptionText(SPANISH, "¿Has visto algo inusual desde las cimas recientemente?",
                "*Baja su anteojos, su habitual expresión alegre volviéndose curiosa*\n¿Inusual? Bueno, el viento ha estado golpeando más fuerte y las cabras están más asustadizas que un gato en una perrera. Pero si preguntas por el cielo... vi algo que me puso los pelos de punta.");
        cvDragonsPart3Start.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, DRAGONS, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvDragonsPart3Start);

        ConversationOption cvDragonsPart3Detail = new ConversationOption(10, 0);
        cvDragonsPart3Detail.addOptionText(ENGLISH, "Was it a dragon?",
                "A dragon? Ha! That's what I told the local authorities, but they just laughed and said I'd spent too much time in the thin air. \n\nI was climbing the northern face of Esperand's mountains last week. I reached a ledge near the summit and saw it — a shadow larger than any bird, wings like sails of a ghost ship. It circled the peak once and then vanished into the fog. I know what I saw, friend. It was no bird.");
        cvDragonsPart3Detail.addOptionText(PORTUGUESE, "Era um dragão?",
                "Um dragão? Ha! Foi o que eu disse às autoridades locais, mas eles apenas riram e disseram que eu passei tempo demais no ar rarefeito. \n\nEu estava escalando a face norte das montanhas de Esperand na semana passada. Alcancei uma borda perto do cume e o vi — uma sombra maior que qualquer pássaro, asas como velas de um navio fantasma. Circulou o pico uma vez e depois desapareceu na névoa. Eu sei o que vi, amigo. Não era pássaro nenhum.");
        cvDragonsPart3Detail.addOptionText(SPANISH, "¿Era un dragón?",
                "¿Un dragón? ¡Ja! Eso es lo que les dije a las autoridades locales, pero solo se rieron y dijeron que había pasado demasiado tiempo en el aire ralo. \n\nEstaba escalando la cara norte de las montañas de Esperand la semana pasada. Alcancé un saliente cerca de la cima y lo vi: una sombra más grande que cualquier pájaro, alas como velas de un barco fantasma. Rodeó el pico una vez y luego desapareció en la niebla. Sé lo que vi, amigo. No era ningún pájaro.");
        cvDragonsPart3Detail.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(DRAGONS, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvDragonsPart3Detail);

        return npc;
    }
}