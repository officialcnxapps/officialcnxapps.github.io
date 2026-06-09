package com.cnx.endlesstalestwo.data.npcs.lisport;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.GameEngine;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibNpc;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class Rawer extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, rawer());
    }

    Npc rawer() {
        Npc npc = new Npc("Rawer");
        npc.age = 51;
        npc.job = Enums.NPCJobs.DOCTOR;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "A well-known figure in Lisport who has helped many citizens. Calm, patient and attentive, but not naive.\nKnowledgeable and skilled in treatment techniques.\nNo known family members.\n\nPhysical traits: Fair skin with deep wrinkles. Gentle smile. Large ears that protrude from his blonde hair. Beard and mustache with a dark blonde tone.");
        npc.addDescriptionTranslation(PORTUGUESE, "Figura conhecida de Lisport, já ajudou muitos cidadãos. Calmo, paciente e atencioso, mas não bobo.\nInteligente e conhecedor de técnicas de tratamento.\nSem familiares conhecidos.\n\nSeus taços físicos: Pele clara e bem enrrugada. Sorriso suave. Orelhas grandes que sobressaem pelo cabelo loiro. Barba e bidoge com tom loiro escuro.");
        npc.addDescriptionTranslation(SPANISH, "Una figura bien conocida en Lisport que ha ayudado a muchos ciudadanos. Tranquilo, paciente y atento, pero no ingenuo.\nConocedor de técnicas de tratamiento.\nSin familiares conocidos.\n\nTrasos físicos: Piel clara con arrugas profundas. Sonrisa suave. Orejas grandes que sobresalen de su cabello rubio. Barba y bigote con tono rubio oscuro.");

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hello, [GENDER_FORMAL_CALL]"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Olá, [GENDER_FORMAL_CALL]"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hola, [GENDER_FORMAL_CALL]"));

        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.MEDICAL_SUPPORT, 3)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "What do you do?", LibNpc.getAboutJobMsg(npc));
        cv1.addOptionText(PORTUGUESE, "O que mesmo você faz?", LibNpc.getAboutJobMsg(npc));
        cv1.addOptionText(SPANISH, "Entonces, ¿qué haces?", LibNpc.getAboutJobMsg(npc));

        ConversationOption cv5 = new ConversationOption(0, 0);
        cv5.addOptionText(ENGLISH, "Who are you?", "I am [NPC_NAME], I live here in Lisport since I was born, I love this place. People are always kind.");
        cv5.addOptionText(PORTUGUESE, "Quem é você?", "Eu sou [NPC_NAME], moro aqui em Lisport desde que nasci, amo esse lugar. As pessoas são sempre gentis.");
        cv5.addOptionText(SPANISH, "¿Quién eres?", "Soy [NPC_NAME], vivo aquí en Lisport desde que nací, me encanta este lugar. La gente siempre es amable.");
        cv5.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(QuestsIds.MEDICAL_SUPPORT, chara)) {
                return Enums.RequirementVerification.NOT_OK;
            }
            return Enums.RequirementVerification.OK;
        };

        ConversationOption cv2 = new ConversationOption(0, 101);
        cv2.addOptionText(ENGLISH, "Can I be helpful?", "Yes! Actually, I'm always in need of basic materials. If you could bring me some supplies, I would be very grateful. I can prepare a healing potion for you in return - it's the least I can do for someone who helps my work.");
        cv2.addOptionText(PORTUGUESE, "Posso ser útil?", "Sim! Na verdade, estou sempre precisando de materiais básicos. Se você pudesse me trazer alguns suprimentos, ficaria muito grato. Posso preparar uma poção de cura para você em troca - é o mínimo que posso fazer por alguém que ajuda meu trabalho.");
        cv2.addOptionText(SPANISH, "¿Puedo ser útil?", "¡Sí! De hecho, siempre necesito materiales básicos. Si pudieras traerme algunos suministros, estaría muy agradecido. Puedo preparar una poción de curación para ti a cambio: es lo mínimo que puedo hacer por alguien que ayuda mi trabajo.");
        cv2.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.DOCTOR_SUPPLIES, chara) && LibQuest.isQuestComplete(chara, QuestsIds.LETTER_FROM_ERINO)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv3 = new ConversationOption(0, 1);
        cv3.addOptionText(ENGLISH, "I need your help, please!", "What do you need, [GENDER_FORMAL_CALL]?");
        cv3.addOptionText(PORTUGUESE, "Preciso da sua ajuda, por favor!", "O que você precisa, [GENDER_FORMAL_CALL]?");
        cv3.addOptionText(SPANISH, "Necesito tu ayuda por favor!", "¿Qué necesitas, [GENDER_FORMAL_CALL]?");
        cv3.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.MEDICAL_SUPPORT, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv4 = new ConversationOption(1, 2);
        cv4.addOptionText(ENGLISH, "A man will die without a doctor help.", "I help. But I will need a payment after, do you agree?");
        cv4.addOptionText(PORTUGUESE, "Um homem morrerá sem ajuda médica.", "Eu ajudo. Mas vou precisar de um pagamento depois, você concorda?");
        cv4.addOptionText(SPANISH, "Un hombre morirá sin la ayuda de un médico.", "Te ayudo, pero después necesitaré un pago, ¿estás de acuerdo?");

        ConversationOption cv6 = new ConversationOption(2, 999);
        cv6.addOptionText(ENGLISH, "I agree. Now follow me!", "Ok, let's move on.");
        cv6.addOptionText(PORTUGUESE, "Eu concordo. Agora siga-me!", "Ok, vamos em frente.");
        cv6.addOptionText(SPANISH, "Estoy de acuerdo. ¡Ahora sígueme!", "Bueno, sigamos adelante.");
        cv6.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.MEDICAL_SUPPORT);
            LibQuest.updateQuest(quest, 3, App.getPlayerChar(), ctx);
        };

        ConversationOption cv7 = new ConversationOption(2, 0);
        cv7.addOptionText(ENGLISH, "No. I wont pay.", "Ok, my work is not free.");
        cv7.addOptionText(PORTUGUESE, "Não. Eu não vou pagar.", "Ok, meu trabalho não é de graça.");
        cv7.addOptionText(SPANISH, "No, no pagaré.", "Ok, mi trabajo no es gratis.");

        ConversationOption cv8 = new ConversationOption(0, 3);
        cv8.addOptionText(ENGLISH, "I am here to pay the help debt.", "[GENDER_FORMAL_CALL], the payment is not expensive, actually is not even gold that I want...\nI am a little shy, I met a beautiful lady some weeks ago when I was working in Letow. I wrote a letter to her and need someone to deliver it to me.");
        cv8.addOptionText(PORTUGUESE, "Estou aqui para pagar a dívida de ajuda.", "[GENDER_FORMAL_CALL], o pagamento não é caro, na verdade nem é ouro que eu quero...\nSou um pouco tímido, conheci uma linda moça algumas semanas atrás quando eu estava trabalhando em Letow. Escrevi uma carta para ela e preciso que alguém a entregue para mim.");
        cv8.addOptionText(SPANISH, "Estoy aquí para pagar la deuda de ayuda.", "[GENDER_FORMAL_CALL], el pago no es caro, en realidad ni siquiera es oro lo que quiero...\nSoy un poco tímido, conocí a una hermosa dama hace algunas semanas cuando estaba trabajando en Letow. Le escribí una carta y necesito que alguien me la entregue.");
        cv8.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.MEDICAL_SUPPORT);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 4) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        ConversationOption cv9 = new ConversationOption(3, 0);
        cv9.addOptionText(ENGLISH, "Who should I deliver to?", "Johanna. She lives in Letow in Havarus. A long journey there that will include a great navigation, but I am sure that when she receive the letter, I will finally marry to a woman.");
        cv9.addOptionText(PORTUGUESE, "Para quem devo entregar?", "Johanna. Ela mora em Letow, em Havarus. Uma longa viagem até lá que incluirá uma grande navegação, Mas tenho certeza de que quando ela receber a carta, finalmente me casarei com uma mulher.");
        cv9.addOptionText(SPANISH, "¿A quién debo entregar?", "Johanna. Vive en Letow, en Havarus. Un largo viaje que incluirá una gran navegación, pero estoy seguro de que cuando reciba la carta, finalmente me casaré con una mujer.");
        cv9.listeners = (ctx, fragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.MEDICAL_SUPPORT);
            LibInventory.addToInventory(ItemsIds.RAWER_LOVE_LETTER, 1, App.getPlayerChar());
            LibQuest.updateQuest(quest, 5, App.getPlayerChar(), ctx);
        };

        ConversationOption cv10 = new ConversationOption(0, 0);
        cv10.addOptionText(ENGLISH, "So, how are Johanna?", "[GENDER_FORMAL_CALL], I am very pleased with your help, you are like a cupid. Johanna sent me a response letter. Our love is flourishing.");
        cv10.addOptionText(PORTUGUESE, "Então, como vai Johanna?", "[GENDER_FORMAL_CALL], Estou muito satisfeito com sua ajuda, você é como um cupido. Johanna me enviou uma carta de resposta. Nosso amor está florescendo.");
        cv10.addOptionText(SPANISH, "Entonces, ¿cómo está Johanna?", "[GENDER_FORMAL_CALL], estoy muy contento con tu ayuda, eres como un cupido. Johanna me envió una carta de respuesta. Nuestro amor está floreciendo.");
        cv10.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.MEDICAL_SUPPORT);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() >= 6) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        npc.conversationOptions.add(cv1);
        npc.conversationOptions.add(cv2);
        npc.conversationOptions.add(cv3);
        npc.conversationOptions.add(cv4);
        npc.conversationOptions.add(cv5);
        npc.conversationOptions.add(cv6);
        npc.conversationOptions.add(cv7);
        npc.conversationOptions.add(cv8);
        npc.conversationOptions.add(cv9);
        npc.conversationOptions.add(cv10);

        // ===== QUEST: Doctor Supplies - RESTARTABLE =====

        // Quest continuation from cv2 (group 101)
        ConversationOption cvSuppliesQuest2 = new ConversationOption(101, 102);
        cvSuppliesQuest2.addOptionText(ENGLISH, "What materials do you need?", "I need clean cloth for bandages - any tissue will work. Also some green herb for medicines, and string to bind splints when setting broken bones. Specifically: 2 pieces of tissue, 1 green herb, and 1 string. Can you help me gather these?");
        cvSuppliesQuest2.addOptionText(PORTUGUESE, "Que materiais você precisa?", "Preciso de pano limpo para bandagens - qualquer tecido serve. Também algumas ervas verdes para medicamentos, e cordão para amarrar talas ao colocar ossos quebrados. Especificamente: 2 pedaços de tecido, 1 erva verde e 1 cordão. Pode me ajudar a reunir isso?");
        cvSuppliesQuest2.addOptionText(SPANISH, "¿Qué materiales necesitas?", "Necesito tela limpia para vendajes: cualquier tela sirve. También algunas hierbas verdes para medicinas, y cordón para atar tablillas al colocar huesos rotos. Específicamente: 2 piezas de tela, 1 hierba verde y 1 cordón. ¿Puedes ayudarme a reunir esto?");
        npc.conversationOptions.add(cvSuppliesQuest2);

        ConversationOption cvSuppliesQuest3 = new ConversationOption(102, 0);
        cvSuppliesQuest3.addOptionText(ENGLISH, "I'll bring you those supplies.", "Thank you! These materials will help me treat many patients. When you bring them, I'll prepare a healing potion for you. Every bit of help keeps people alive and healthy.");
        cvSuppliesQuest3.addOptionText(PORTUGUESE, "Vou trazer esses suprimentos.", "Obrigado! Esses materiais me ajudarão a tratar muitos pacientes. Quando você trouxer, prepararei uma poção de cura para você. Cada ajuda mantém as pessoas vivas e saudáveis.");
        cvSuppliesQuest3.addOptionText(SPANISH, "Te traeré esos suministros.", "¡Gracias! Estos materiales me ayudarán a tratar a muchos pacientes. Cuando los traigas, prepararé una poción de curación para ti. Cada ayuda mantiene a la gente viva y saludable.");
        cvSuppliesQuest3.listeners = (ctx, currentFragment) -> LibQuest.includeQuestToQuestbook(QuestsIds.DOCTOR_SUPPLIES, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvSuppliesQuest3);

        // Deliver Supplies
        ConversationOption cvSuppliesDeliver = new ConversationOption(0, 103);
        cvSuppliesDeliver.addOptionText(ENGLISH, "I have the medical supplies you need.", "*Eyes light up with relief*\nExcellent! Let me see... \n*Examines the materials carefully*\nPerfect quality tissue - clean and strong for bandages. Good green herb - fresh and potent. And string - just the right thickness for splints. \n*Begins organizing the supplies*\nThese will help so many people. Let me prepare that healing potion for you right away.");
        cvSuppliesDeliver.addOptionText(PORTUGUESE, "Tenho os suprimentos médicos que você precisa.", "*Olhos se iluminam de alívio*\nExcelente! Deixe-me ver... \n*Examina os materiais cuidadosamente*\nTecido de qualidade perfeita - limpo e forte para bandagens. Boa erva verde - fresca e potente. E cordão - espessura certa para talas. \n*Começa a organizar os suprimentos*\nIsso ajudará tantas pessoas. Deixe-me preparar aquela poção de cura para você imediatamente.");
        cvSuppliesDeliver.addOptionText(SPANISH, "Tengo los suministros médicos que necesitas.", "*Los ojos se iluminan de alivio*\n¡Excelente! Déjame ver... \n*Examina los materiales cuidadosamente*\nTela de calidad perfecta: limpia y fuerte para vendajes. Buena hierba verde: fresca y potente. Y cordón: el grosor justo para tablillas. \n*Comienza a organizar los suministros*\nEsto ayudará a tanta gente. Déjame preparar esa poción de curación para ti de inmediato.");
        cvSuppliesDeliver.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.DOCTOR_SUPPLIES, 1)) {
                boolean hasTissue = LibInventory.checkHasItemAmount(ItemsIds.TISSUE, 2, chara);
                boolean hasHerb = LibInventory.checkHasItemAmount(ItemsIds.GREEN_HERB, 1, chara);
                boolean hasString = LibInventory.checkHasItemAmount(ItemsIds.STRING, 1, chara);
                if (hasTissue && hasHerb && hasString) {
                    return Enums.RequirementVerification.OK;
                }
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvSuppliesDeliver);

        ConversationOption cvSuppliesComplete = new ConversationOption(103, 0);
        cvSuppliesComplete.addOptionText(ENGLISH, "[Receive healing potion]", "*Hands you a freshly prepared potion and a gold coin*\nHere you are. The potion will heal wounds quickly - I made it with care. And please, take this coin as well. If you ever find more supplies, I'll always be grateful for the help. Lives depend on having these materials available.");
        cvSuppliesComplete.addOptionText(PORTUGUESE, "[Receber poção de cura]", "*Entrega uma poção recém-preparada e uma moeda de ouro*\nAqui está. A poção curará feridas rapidamente - fiz com cuidado. E por favor, aceite esta moeda também. Se você encontrar mais suprimentos, sempre ficarei grato pela ajuda. Vidas dependem de ter esses materiais disponíveis.");
        cvSuppliesComplete.addOptionText(SPANISH, "[Recibir poción de curación]", "*Te entrega una poción recién preparada y una moneda de oro*\nAquí tienes. La poción curará heridas rápidamente: la hice con cuidado. Y por favor, toma esta moneda también. Si alguna vez encuentras más suministros, siempre estaré agradecido por la ayuda. Las vidas dependen de tener estos materiales disponibles.");
        cvSuppliesComplete.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.TISSUE, 2, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.GREEN_HERB, 1, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.STRING, 1, App.getPlayerChar());
            LibQuest.completeQuest(QuestsIds.DOCTOR_SUPPLIES, App.getPlayerChar(), 2, ctx);
            GameEngine.updateTopToolbar(currentFragment.getView(), currentFragment.isShowingBackButton);
        };
        npc.conversationOptions.add(cvSuppliesComplete);

        // ===== QUEST: Like a Landlord - Refuse house offer =====
        ConversationOption cvRefuseHouse = new ConversationOption(0, 0);
        cvRefuseHouse.addOptionText(ENGLISH, "Would you be interested in buying land in Havarus?", "Havarus? No, no... I'm a doctor, my place is here in Lisport where I know everyone and they know me. My patients depend on me. I couldn't just abandon them to move to a new kingdom. Thank you, but I must decline.");
        cvRefuseHouse.addOptionText(PORTUGUESE, "Você estaria interessado em comprar terra em Havarus?", "Havarus? Não, não... Sou médico, meu lugar é aqui em Lisport onde conheço todos e eles me conhecem. Meus pacientes dependem de mim. Eu não poderia simplesmente abandoná-los para me mudar para um novo reino. Obrigado, mas devo recusar.");
        cvRefuseHouse.addOptionText(SPANISH, "¿Estarías interesado en comprar tierra en Havarus?", "¿Havarus? No, no... Soy médico, mi lugar está aquí en Lisport donde conozco a todos y ellos me conocen. Mis pacientes dependen de mí. No podría simplemente abandonarlos para mudarme a un nuevo reino. Gracias, pero debo declinar.");
        cvRefuseHouse.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.LIKE_A_LANDLORD, 1)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.LIKE_A_LANDLORD, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRefuseHouse);

        // ========================================
        // QUEST: LIKE A DETECTIVE — PART 3
        // ========================================

        ConversationOption cvInvR1 = new ConversationOption(0, 40);
        cvInvR1.addOptionText(ENGLISH, "Doctor Rawer, I have some questions about your patients.",
                "*He puts down his tools carefully and turns to face you with a practiced, neutral smile*\nOf course. As a doctor I must be open to the community's questions. Though, you understand, I protect patient privacy where it matters. What would you like to know?");
        cvInvR1.addOptionText(PORTUGUESE, "Médico Rawer, tenho algumas perguntas sobre seus pacientes.",
                "*Ele pousa suas ferramentas com cuidado e se vira para você com um sorriso neutro e treinado*\nClaro. Como médico, devo estar aberto às perguntas da comunidade. Embora, você entende, eu proteja a privacidade dos pacientes onde importa. O que gostaria de saber?");
        cvInvR1.addOptionText(SPANISH, "Doctor Rawer, tengo algunas preguntas sobre sus pacientes.",
                "*Deposita sus herramientas con cuidado y se vuelve hacia ti con una sonrisa neutral y practicada*\nPor supuesto. Como médico debo estar abierto a las preguntas de la comunidad. Aunque, comprenderás, protejo la privacidad de los pacientes donde importa. ¿Qué desearías saber?");
        cvInvR1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.LIKE_A_DETECTIVE, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvInvR1);

        ConversationOption cvInvR2 = new ConversationOption(40, 41);
        cvInvR2.addOptionText(ENGLISH, "You receive unusual visitors at strange hours, don't you?",
                "*A very brief pause — almost imperceptible*\nUnusual hours? Medicine does not keep office hours. Pain and illness do not announce their arrival. Sometimes a case requires my attention at midnight.\n*His tone is perfectly calm*\nIs that your question?");
        cvInvR2.addOptionText(PORTUGUESE, "Você recebe visitantes incomuns em horas estranhas, não é?",
                "*Uma pausa muito breve — quase imperceptível*\nHoras incomuns? A medicina não tem horário de expediente. Dor e doença não anunciam sua chegada. Às vezes um caso requer minha atenção à meia-noite.\n*Seu tom é perfeitamente calmo*\nEssa é sua pergunta?");
        cvInvR2.addOptionText(SPANISH, "¿Recibes visitantes inusuales a horas extrañas, verdad?",
                "*Una pausa muy breve — casi imperceptible*\n¿Horas inusuales? La medicina no tiene horario de oficina. El dolor y la enfermedad no anuncian su llegada. A veces un caso requiere mi atención a medianoche.\n*Su tono es perfectamente calmado*\n¿Esa es tu pregunta?");
        npc.conversationOptions.add(cvInvR2);

        ConversationOption cvInvR3 = new ConversationOption(41, 42);
        cvInvR3.addOptionText(ENGLISH, "Are you involved in anything illegal?",
                "*He gives a soft, tired laugh*\nIllegal. Now that is a strong word. I am a doctor — I treat the sick regardless of who they are. If that concerns someone... then perhaps they should consider whether healers should refuse the wounded based on their reputations.\n*He spreads his hands*\nI work within the law.");
        cvInvR3.addOptionText(PORTUGUESE, "Está envolvido em algo ilegal?",
                "*Ele dá uma risada suave e cansada*\nIlegal. Essa é uma palavra forte. Sou médico — trato os doentes independentemente de quem sejam. Se isso preocupa alguém... então talvez devessem considerar se os curandeiros deveriam recusar os feridos com base em suas reputações.\n*Ele abre as mãos*\nTrabalho dentro da lei.");
        cvInvR3.addOptionText(SPANISH, "¿Estás involucrado en algo ilegal?",
                "*Suelta una risa suave y cansada*\nIlegal. Esa es una palabra fuerte. Soy médico — trato a los enfermos sin importar quiénes sean. Si eso preocupa a alguien... entonces tal vez deberían considerar si los curanderos deberían rechazar a los heridos según sus reputaciones.\n*Extiende las manos*\nTrabajo dentro de la ley.");
        npc.conversationOptions.add(cvInvR3);

        ConversationOption cvInvR4 = new ConversationOption(42, 0);
        cvInvR4.addOptionText(ENGLISH, "Thank you for your time.",
                "Always. Come back if you are unwell — or if you have more... philosophical questions.\n*A faint, controlled smile*");
        cvInvR4.addOptionText(PORTUGUESE, "Obrigado pelo seu tempo.",
                "Sempre. Volte se estiver mal — ou se tiver mais... perguntas filosóficas.\n*Um sorriso tênue e controlado*");
        cvInvR4.addOptionText(SPANISH, "Gracias por su tiempo.",
                "Siempre. Vuelve si no te encuentras bien — o si tienes más... preguntas filosóficas.\n*Una sonrisa tenue y controlada*");
        cvInvR4.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.LIKE_A_DETECTIVE, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvInvR4);

        return npc;
    }
}

