package com.cnx.endlesstalestwo.data.npcs.havarusNorth.farmland;

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

public class Helinda extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Helinda");
        npc.age = 67;
        npc.job = Enums.NPCJobs.FEMALE_FARMER;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "A firm and determined woman in her work.\nShe enjoys her work and does it well. She likes to help and be helped, a good member of the community.\n\n\nHer physical traits: Full face with wrinkles. Green eyes, white hair and clothes stained with food.");
        npc.addDescriptionTranslation(PORTUGUESE, "Uma senhora firme nas atitudes e decidida no trabalho.\nGosta do seu ofício e o faz bem feito. Gosta de ajudar e ser ajudada, uma boa membra da comunidade.\n\n\nSeus traços físicos: Rosto cheio, com rugas. Olhos verdes, cabelo branco e roupas sujas de comida.");
        npc.addDescriptionTranslation(SPANISH, "Una mujer firme en sus actitudes y decidida en su trabajo.\nDisfruta de su oficio y lo hace bien. Le gusta ayudar y ser ayudada, una buena miembro de la comunidad.\n\n\nSus rasgos físicos: Rostro lleno con arrugas. Ojos verdes, cabello blanco y ropa manchada de comida.");
        npc.canBePickpocketed = true;

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // ===== ROLEPLAY: About her life =====
        ConversationOption cvRoleplay = new ConversationOption(0, 0);
        cvRoleplay.addOptionText(ENGLISH, "How long have you been farming here?", "*Sighs with a nostalgic smile*\nOh, nearly fifty years now. I came to Farmland as a young bride, my husband - gods rest his soul - brought me here when we married. We built our farm from nothing, just the two of us. He passed away fifteen winters ago, but I keep working the land. It's all I know, all I have. These fields... they're my life's work. Sometimes I think about resting, but what would an old woman like me do without her crops to tend? This soil has my sweat, my tears, and my love.");
        cvRoleplay.addOptionText(PORTUGUESE, "Há quanto tempo você está cultivando aqui?", "*Suspira com um sorriso nostálgico*\nOh, quase cinquenta anos agora. Vim para Farmland como uma jovem noiva, meu marido - que Deus o tenha - me trouxe aqui quando nos casamos. Construímos nossa fazenda do nada, apenas nós dois. Ele faleceu há quinze invernos, mas continuo trabalhando a terra. É tudo que sei, tudo que tenho. Esses campos... são o trabalho da minha vida. Às vezes penso em descansar, mas o que uma velha como eu faria sem suas plantações para cuidar? Este solo tem meu suor, minhas lágrimas e meu amor.");
        cvRoleplay.addOptionText(SPANISH, "¿Cuánto tiempo llevas cultivando aquí?", "*Suspira con una sonrisa nostálgica*\nOh, casi cincuenta años ahora. Vine a Farmland como una joven novia, mi esposo - que Dios lo tenga - me trajo aquí cuando nos casamos. Construimos nuestra granja de la nada, solo nosotros dos. Falleció hace quince inviernos, pero sigo trabajando la tierra. Es todo lo que sé, todo lo que tengo. Estos campos... son el trabajo de mi vida. A veces pienso en descansar, pero ¿qué haría una anciana como yo sin sus cultivos que cuidar? Este suelo tiene mi sudor, mis lágrimas y mi amor.");
        npc.conversationOptions.add(cvRoleplay);

        // RequirementValidations: NOT available during Defend Farmland or Rebuild Farmland
        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(QuestsIds.DEFEND_FARMLAND, chara) && !LibQuest.isQuestComplete(chara, QuestsIds.DEFEND_FARMLAND)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            if (LibQuest.charHasQuest(QuestsIds.REBUILD_FARMLAND, chara) && !LibQuest.isQuestComplete(chara, QuestsIds.REBUILD_FARMLAND)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        // ===== QUEST START: Plague! =====
        ConversationOption cvQuestStart = new ConversationOption(0, 1);
        cvQuestStart.addOptionText(ENGLISH, "You look worried. Is something wrong?", "*Wringing her hands in distress*\nOh, traveler! I am desperate! A terrible plague of insects is destroying my crops - and not just mine, but all the farms around Farmland! They appeared suddenly, these vile creatures, eating everything. If we don't stop them soon, we'll have no harvest this year!");
        cvQuestStart.addOptionText(PORTUGUESE, "Você parece preocupada. Há algo errado?", "*Torcendo as mãos angustiada*\nOh, viajante! Estou desesperada! Uma praga terrível de insetos está destruindo minhas plantações - e não apenas as minhas, mas todas as fazendas ao redor de Farmland! Eles apareceram de repente, essas criaturas vis, comendo tudo. Se não pararmos eles logo, não teremos colheita este ano!");
        cvQuestStart.addOptionText(SPANISH, "Pareces preocupada. ¿Pasa algo?", "*Retorciendo las manos angustiada*\n¡Oh, viajero! ¡Estoy desesperada! Una plaga terrible de insectos está destruyendo mis cultivos - y no solo los míos, ¡sino todas las granjas alrededor de Farmland! Aparecieron de repente, estas criaturas viles, comiéndolo todo. ¡Si no los detenemos pronto, no tendremos cosecha este año!");
        cvQuestStart.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.PLAGUE, chara) && LibQuest.isQuestComplete(chara, QuestsIds.OVERSEAS_RECOGNITION)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestStart);

        ConversationOption cvQuestAccept = new ConversationOption(1, 0);
        cvQuestAccept.addOptionText(ENGLISH, "I can help you. What do you need?", "*Eyes light up with hope*\nReally? Oh, thank the gods! I need to create a powerful insecticide to eliminate these pests. I know what ingredients are needed:\n- 5 Seaweed\n- 5 Coal\n- 3 Yellow Herb\n- 1 Water\n\nBring me these, and I'll... well, I'll try to prepare something. Please hurry!");
        cvQuestAccept.addOptionText(PORTUGUESE, "Posso ajudá-la. Do que você precisa?", "*Olhos se iluminam com esperança*\nSério? Oh, graças aos deuses! Preciso criar um inseticida poderoso para eliminar essas pragas. Sei quais ingredientes são necessários:\n- 5 Algas\n- 5 Carvões\n- 3 Ervas Amarelas\n- 1 Água\n\nTraga-me isso, e eu vou... bem, vou tentar preparar algo. Por favor, se apresse!");
        cvQuestAccept.addOptionText(SPANISH, "Puedo ayudarte. ¿Qué necesitas?", "*Los ojos se iluminan con esperanza*\n¿De verdad? ¡Oh, gracias a los dioses! Necesito crear un insecticida poderoso para eliminar estas plagas. Sé qué ingredientes se necesitan:\n- 5 Algas\n- 5 Carbones\n- 3 Hierbas Amarillas\n- 1 Agua\n\n¡Tráeme esto, y yo voy... bueno, intentaré preparar algo. Por favor, apresúrate!");
        cvQuestAccept.listeners = (ctx, fragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.PLAGUE, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuestAccept);

        // ===== PART 1: Collecting ingredients =====
        ConversationOption cvPart1 = new ConversationOption(0, 0);
        cvPart1.addOptionText(ENGLISH, "About the ingredients...", "Please hurry and gather them! The insects are eating more crops every day. We need:\n- 5 Seaweed\n- 5 Coal\n- 3 Yellow Herb\n- 1 Water");
        cvPart1.addOptionText(PORTUGUESE, "Sobre os ingredientes...", "Por favor, se apresse e junte-os! Os insetos estão comendo mais plantações a cada dia. Precisamos de:\n- 5 Algas\n- 5 Carvões\n- 3 Ervas Amarelas\n- 1 Água");
        cvPart1.addOptionText(SPANISH, "Sobre los ingredientes...", "¡Por favor, apresúrate y reúnelos! Los insectos están comiendo más cultivos cada día. Necesitamos:\n- 5 Algas\n- 5 Carbones\n- 3 Hierbas Amarillas\n- 1 Agua");
        cvPart1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PLAGUE, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPart1);

        // ===== PART 2: Delivering ingredients =====
        ConversationOption cvPart2Deliver = new ConversationOption(0, 2);
        cvPart2Deliver.addOptionText(ENGLISH, "I have the ingredients you asked for.", "*Takes the ingredients with trembling hands*\nOh wonderful! Now let me see... I need to mix these in the right proportions...\n*Pauses, looking confused*\nWait... I... I don't actually know how to prepare insecticide. I've never done this before! I'm just an old farmer. But I know someone who might help - Larien! She's more experienced with these things. Go speak with her!");
        cvPart2Deliver.addOptionText(PORTUGUESE, "Tenho os ingredientes que você pediu.", "*Pega os ingredientes com mãos trêmulas*\nOh maravilhoso! Agora deixe-me ver... preciso misturar isso nas proporções certas...\n*Pausa, parecendo confusa*\nEspere... eu... eu na verdade não sei como preparar inseticida. Nunca fiz isso antes! Sou apenas uma fazendeira velha. Mas conheço alguém que pode ajudar - Larien! Ela tem mais experiência com essas coisas. Vá falar com ela!");
        cvPart2Deliver.addOptionText(SPANISH, "Tengo los ingredientes que pediste.", "*Toma los ingredientes con manos temblorosas*\n¡Oh maravilloso! Ahora déjame ver... necesito mezclar esto en las proporciones correctas...\n*Pausa, luciendo confundida*\nEspera... yo... en realidad no sé cómo preparar insecticida. ¡Nunca he hecho esto antes! Solo soy una granjera vieja. Pero conozco a alguien que podría ayudar - ¡Larien! Ella tiene más experiencia con estas cosas. ¡Ve a hablar con ella!");
        cvPart2Deliver.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PLAGUE, 1)) {
                return Enums.RequirementVerification.NOT_OK;
            }

            boolean hasItems = LibInventory.checkHasItemAmount(ItemsIds.ALGAE, 5, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.COAL, 5, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.YELLOW_HERB, 3, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.WATER, 1, chara);

            if (hasItems) {
                return Enums.RequirementVerification.OK;
            } else {
                return Enums.RequirementVerification.NEED_ITEMS;
            }
        };
        npc.conversationOptions.add(cvPart2Deliver);

        ConversationOption cvPart2Confirm = new ConversationOption(2, 0);
        cvPart2Confirm.addOptionText(ENGLISH, "I'll speak with Larien then.", "Yes, yes! Go quickly! And... thank you for helping an old woman. I hope Larien knows what to do.");
        cvPart2Confirm.addOptionText(PORTUGUESE, "Vou falar com Larien então.", "Sim, sim! Vá rápido! E... obrigada por ajudar uma velha. Espero que Larien saiba o que fazer.");
        cvPart2Confirm.addOptionText(SPANISH, "Hablaré con Larien entonces.", "¡Sí, sí! ¡Ve rápido! Y... gracias por ayudar a una anciana. Espero que Larien sepa qué hacer.");
        cvPart2Confirm.listeners = (ctx, fragment) -> {
            // Remove ingredients but DON'T give them back - they're kept for later use
            LibQuest.updateQuest(QuestsIds.PLAGUE, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvPart2Confirm);

        // ===== PART 3-4: Waiting for insecticide =====
        ConversationOption cvWaiting = new ConversationOption(0, 0);
        cvWaiting.addOptionText(ENGLISH, "I'm working on getting the insecticide.", "*Wringing her hands nervously*\nPlease hurry! Every day more crops are destroyed. I pray you can find a solution soon.");
        cvWaiting.addOptionText(PORTUGUESE, "Estou trabalhando para conseguir o inseticida.", "*Torcendo as mãos nervosamente*\nPor favor, se apresse! A cada dia mais plantações são destruídas. Rezo para que você encontre uma solução logo.");
        cvWaiting.addOptionText(SPANISH, "Estoy trabajando para conseguir el insecticida.", "*Retorciendo las manos nerviosamente*\n¡Por favor, apresúrate! Cada día se destruyen más cultivos. Rezo para que encuentres una solución pronto.");
        cvWaiting.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PLAGUE, 2)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PLAGUE, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvWaiting);

        // ===== PART 5: Reporting success (after battle) =====
        ConversationOption cvPart5Report = new ConversationOption(0, 3);
        cvPart5Report.addOptionText(ENGLISH, "The insects are gone. It's done.", "*Eyes widen in disbelief*\nReally? They're... they're gone? Oh, thank the heavens! You've saved us all! I went to check the fields and... they're recovering already. You fought those horrible creatures and won!");
        cvPart5Report.addOptionText(PORTUGUESE, "Os insetos se foram. Está feito.", "*Olhos se arregalam incrédula*\nSério? Eles... eles se foram? Oh, graças aos céus! Você nos salvou! Fui verificar os campos e... eles já estão se recuperando. Você lutou contra essas criaturas horríveis e venceu!");
        cvPart5Report.addOptionText(SPANISH, "Los insectos se han ido. Está hecho.", "*Los ojos se abren con incredulidad*\n¿De verdad? Ellos... ¿se han ido? ¡Oh, gracias a los cielos! ¡Nos has salvado a todos! Fui a revisar los campos y... ya se están recuperando. ¡Luchaste contra esas criaturas horribles y ganaste!");
        cvPart5Report.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PLAGUE, 5)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvPart5Report);

        ConversationOption cvPart5Complete = new ConversationOption(3, 0);
        cvPart5Complete.addOptionText(ENGLISH, "I'm glad I could help.", "*Tears of gratitude in her eyes*\nYou're a hero! Here, please take this - it's not much, but it's all I can offer. Fresh soup from my kitchen, some beer, and what little gold I have. You've saved our harvest, our livelihoods! Farmland is forever in your debt!");
        cvPart5Complete.addOptionText(PORTUGUESE, "Fico feliz por ter ajudado.", "*Lágrimas de gratidão nos olhos*\nVocê é um herói! Aqui, por favor aceite isso - não é muito, mas é tudo que posso oferecer. Sopa fresca da minha cozinha, alguma cerveja e o pouco ouro que tenho. Você salvou nossa colheita, nossos meios de vida! Farmland está para sempre em sua dívida!");
        cvPart5Complete.addOptionText(SPANISH, "Me alegra haber podido ayudar.", "*Lágrimas de gratitud en sus ojos*\n¡Eres un héroe! Aquí, por favor toma esto - no es mucho, pero es todo lo que puedo ofrecer. Sopa fresca de mi cocina, algo de cerveza y el poco oro que tengo. ¡Salvaste nuestra cosecha, nuestros medios de vida! ¡Farmland está por siempre en deuda contigo!");
        cvPart5Complete.listeners = (ctx, fragment) -> LibQuest.completeQuest(QuestsIds.PLAGUE, App.getPlayerChar(), 6, ctx);
        npc.conversationOptions.add(cvPart5Complete);

        // ===== AFTER QUEST: Roleplay =====
        ConversationOption cvAfterQuest = new ConversationOption(0, 0);
        cvAfterQuest.addOptionText(ENGLISH, "How are the crops doing?", "*Smiles warmly*\nMuch better now, thanks to you! The fields are recovering beautifully. We'll have a good harvest after all. The other farmers speak of you as our savior. You'll always be welcome here, hero.");
        cvAfterQuest.addOptionText(PORTUGUESE, "Como estão as plantações?", "*Sorri calorosamente*\nMuito melhor agora, graças a você! Os campos estão se recuperando lindamente. Teremos uma boa colheita afinal. Os outros fazendeiros falam de você como nosso salvador. Você sempre será bem-vindo aqui, herói.");
        cvAfterQuest.addOptionText(SPANISH, "¿Cómo están los cultivos?", "*Sonríe calidamente*\n¡Mucho mejor ahora, gracias a ti! Los campos se están recuperando hermosamente. Tendremos una buena cosecha después de todo. Los otros granjeros hablan de ti como nuestro salvador. Siempre serás bienvenido aquí, héroe.");
        cvAfterQuest.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.PLAGUE)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvAfterQuest);

        return npc;
    }
}




