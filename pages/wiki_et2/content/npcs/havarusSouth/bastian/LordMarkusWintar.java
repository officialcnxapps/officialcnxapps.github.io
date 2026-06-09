package com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.houses.HousesIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class LordMarkusWintar extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Lord Markus Wintar");
        npc.age = 53;
        npc.job = Enums.NPCJobs.GOVERNOR;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        // ===== QUEST: Like a Landlord =====

        // Start quest
        ConversationOption cvQuestStart = new ConversationOption(0, 1);
        cvQuestStart.addOptionText(ENGLISH, "My lord, do you need any assistance?", "Ah, [PLAYERNAME], excellent timing! I have a proposition that requires someone with... diplomatic skills.\n\n*Unfolds a map of the region*\n\nI own a fine parcel of farmland and a comfortable house here in Havarus. I wish to sell them to inhabitants of Lisport who might benefit from relocating to our great kingdom.\n\n*Looks at you thoughtfully*\n\nBut people are hesitant to make such big decisions. They need convincing. Would you travel to Lisport and find buyers for me? I'll make it worth your while.");
        cvQuestStart.addOptionText(PORTUGUESE, "Meu senhor, precisa de alguma assistência?", "Ah, [PLAYERNAME], momento excelente! Tenho uma proposta que requer alguém com... habilidades diplomáticas.\n\n*Desdobra um mapa da região*\n\nPossuo uma boa parcela de terra agrícola e uma casa confortável aqui em Havarus. Desejo vendê-las para habitantes de Lisport que possam se beneficiar de se mudar para o nosso grande reino.\n\n*Olha para você pensativamente*\n\nMas as pessoas hesitam em tomar decisões tão grandes. Elas precisam de convencimento. Você viajaria para Lisport e encontraria compradores para mim? Farei valer a pena.");
        cvQuestStart.addOptionText(SPANISH, "Mi señor, ¿necesita alguna asistencia?", "¡Ah, [PLAYERNAME], momento excelente! Tengo una proposición que requiere alguien con... habilidades diplomáticas.\n\n*Despliega un mapa de la región*\n\nPoseo una buena parcela de tierra agrícola y una casa cómoda aquí en Havarus. Deseo venderlas a habitantes de Lisport que puedan beneficiarse de mudarse a nuestro gran reino.\n\n*Te mira pensativamente*\n\nPero la gente duda en tomar decisiones tan grandes. Necesitan convencimiento. ¿Viajarías a Lisport y encontrarías compradores para mí? Haré que valga la pena.");
        cvQuestStart.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.charHasQuest(QuestsIds.LIKE_A_LANDLORD, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuestStart);

        ConversationOption cvQuestAccept = new ConversationOption(1, 0);
        cvQuestAccept.addOptionText(ENGLISH, "I'll help you find buyers.", "Splendid! I need two buyers - one for the farmland, another for the house. Preferably people who would truly benefit from the opportunity. A farmer seeking to expand, a scholar wanting access to our libraries, that sort of thing.\n\n*Nods approvingly*\n\nFind them, convince them, and return to me with confirmation. Good luck, [PLAYERNAME]!");
        cvQuestAccept.addOptionText(PORTUGUESE, "Vou ajudá-lo a encontrar compradores.", "Esplêndido! Preciso de dois compradores - um para a terra agrícola, outro para a casa. Preferencialmente pessoas que realmente se beneficiariam da oportunidade. Um fazendeiro buscando expandir, um estudioso querendo acesso às nossas bibliotecas, esse tipo de coisa.\n\n*Acena aprovadoramente*\n\nEncontre-os, convença-os e retorne para mim com a confirmação. Boa sorte, [PLAYERNAME]!");
        cvQuestAccept.addOptionText(SPANISH, "Le ayudaré a encontrar compradores.", "¡Espléndido! Necesito dos compradores: uno para la tierra agrícola, otro para la casa. Preferiblemente personas que realmente se beneficiarían de la oportunidad. Un granjero buscando expandirse, un erudito queriendo acceso a nuestras bibliotecas, ese tipo de cosas.\n\n*Asiente con aprobación*\n\nEncuéntralos, convéncelos y regresa a mí con la confirmación. ¡Buena suerte, [PLAYERNAME]!");
        cvQuestAccept.listeners = (ctx, fragment) -> {
            LibQuest.includeQuestToQuestbook(QuestsIds.LIKE_A_LANDLORD, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuestAccept);

        ConversationOption cvQuestDecline = new ConversationOption(1, 0);
        cvQuestDecline.addOptionText(ENGLISH, "I'm not interested right now.", "I understand. The offer stands if you change your mind. Such opportunities don't come often.");
        cvQuestDecline.addOptionText(PORTUGUESE, "Não estou interessado agora.", "Eu entendo. A oferta permanece se você mudar de ideia. Tais oportunidades não surgem com frequência.");
        cvQuestDecline.addOptionText(SPANISH, "No estoy interesado ahora.", "Entiendo. La oferta permanece si cambias de opinión. Tales oportunidades no surgen a menudo.");
        npc.conversationOptions.add(cvQuestDecline);

        // Complete quest - gives house as reward
        ConversationOption cvQuestComplete = new ConversationOption(0, 0);
        cvQuestComplete.addOptionText(ENGLISH, "I found buyers for the land and house.", "*Eyes light up with satisfaction*\n\nExcellent work, [PLAYERNAME]! A farmer seeking to expand his operations and a scholar pursuing knowledge in our great kingdom. Both are exactly the kind of people we want in Havarus.\n\n*Pulls out a document and signs it*\n\nAs promised, your reward. I'm transferring ownership of a fine house here in Bastian to you - a comfortable home with all the amenities. Consider it yours.\n\n*Hands you the deed*\n\nYou've done well. Thank you for your assistance in this matter.");
        cvQuestComplete.addOptionText(PORTUGUESE, "Encontrei compradores para a terra e a casa.", "*Os olhos se iluminam de satisfação*\n\nExcelente trabalho, [PLAYERNAME]! Um fazendeiro buscando expandir suas operações e uma estudiosa buscando conhecimento em nosso grande reino. Ambos são exatamente o tipo de pessoa que queremos em Havarus.\n\n*Puxa um documento e assina*\n\nConforme prometido, sua recompensa. Estou transferindo a propriedade de uma bela casa aqui em Bastian para você - uma casa confortável com todas as comodidades. Considere sua.\n\n*Entrega a escritura*\n\nVocê se saiu bem. Obrigado por sua assistência neste assunto.");
        cvQuestComplete.addOptionText(SPANISH, "Encontré compradores para la tierra y la casa.", "*Los ojos se iluminan de satisfacción*\n\n¡Excelente trabajo, [PLAYERNAME]! Un granjero buscando expandir sus operaciones y una estudiosa buscando conocimiento en nuestro gran reino. Ambos son exactamente el tipo de personas que queremos en Havarus.\n\n*Saca un documento y lo firma*\n\nComo prometí, tu recompensa. Estoy transfiriendo la propiedad de una hermosa casa aquí en Bastian a ti: un hogar cómodo con todas las comodidades. Considérala tuya.\n\n*Te entrega la escritura*\n\nLo hiciste bien. Gracias por tu asistencia en este asunto.");
        cvQuestComplete.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.LIKE_A_LANDLORD, 4)
                    && !LibQuest.isQuestComplete(chara, QuestsIds.LIKE_A_LANDLORD)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvQuestComplete.listeners = (ctx, fragment) -> {
            // Give house to player
            App.getPlayerChar().addOwnedHouse(HousesIds.BASTIAN_HOME);

            // Complete quest
            LibQuest.completeQuest(QuestsIds.LIKE_A_LANDLORD, App.getPlayerChar(), 5, ctx);
        };
        npc.conversationOptions.add(cvQuestComplete);

        // ===== ROLEPLAY CONVERSATIONS =====

        // Roleplay: About his profession as Governor
        ConversationOption cvRoleplayProfession = new ConversationOption(0, 0);
        cvRoleplayProfession.addOptionText(ENGLISH, "What is it like being governor of Bastian?", "Ah, it's a responsibility I take very seriously, [PLAYERNAME]. Bastian may not be as grand as Monelix or as ancient as Ayalon, but it's a city with potential.\n\n*Gestures toward the city*\n\nMy duties involve ensuring trade flows smoothly, maintaining order, and making strategic decisions that benefit our citizens. Every land transaction, every new business, every diplomatic meeting - all contribute to our prosperity.\n\n*Smiles with pride*\n\nThe Wintar family has always served the kingdom with distinction. I intend to uphold that legacy.");
        cvRoleplayProfession.addOptionText(PORTUGUESE, "Como é ser governador de Bastian?", "Ah, é uma responsabilidade que levo muito a sério, [PLAYERNAME]. Bastian pode não ser tão grandiosa quanto Monelix ou tão antiga quanto Ayalon, mas é uma cidade com potencial.\n\n*Gesticula em direção à cidade*\n\nMinhas obrigações envolvem garantir que o comércio flua suavemente, manter a ordem e tomar decisões estratégicas que beneficiem nossos cidadãos. Cada transação de terra, cada novo negócio, cada reunião diplomática - tudo contribui para nossa prosperidade.\n\n*Sorri com orgulho*\n\nA família Wintar sempre serviu o reino com distinção. Pretendo manter esse legado.");
        cvRoleplayProfession.addOptionText(SPANISH, "¿Cómo es ser gobernador de Bastian?", "Ah, es una responsabilidad que tomo muy en serio, [PLAYERNAME]. Bastian puede no ser tan grandiosa como Monelix o tan antigua como Ayalon, pero es una ciudad con potencial.\n\n*Gesticula hacia la ciudad*\n\nMis deberes involucran asegurar que el comercio fluya sin problemas, mantener el orden y tomar decisiones estratégicas que beneficien a nuestros ciudadanos. Cada transacción de tierra, cada nuevo negocio, cada reunión diplomática: todo contribuye a nuestra prosperidad.\n\n*Sonríe con orgullo*\n\nLa familia Wintar siempre ha servido al reino con distinción. Pretendo mantener ese legado.");
        npc.conversationOptions.add(cvRoleplayProfession);

        // Roleplay: About life and family (sequence)
        ConversationOption cvRoleplayFamily1 = new ConversationOption(0, 100);
        cvRoleplayFamily1.addOptionText(ENGLISH, "Tell me about the Wintar family.", "*Leans back with a thoughtful expression*\n\nAh, the Wintars. We are one of the most prominent noble families in the kingdom, [PLAYERNAME], alongside the royal Lysnes family.\n\n*Gestures thoughtfully*\n\nI have three siblings: Mukas governs the independent island of Esperand, Mathew leads Helera, and our sister Jade... she was married to the late King Oriun and is now advisor to Queen Enola, her daughter.\n\n*Smiles with pride*\n\nThe Wintar family has always maintained strong ties with the crown. Would you like to know more?");
        cvRoleplayFamily1.addOptionText(PORTUGUESE, "Conte-me sobre a família Wintar.", "*Recosta-se com uma expressão pensativa*\n\nAh, os Wintars. Somos uma das famílias nobres mais proeminentes do reino, [PLAYERNAME], ao lado da família real Lysnes.\n\n*Gesticula pensativamente*\n\nTenho três irmãos: Mukas governa a ilha independente de Esperand, Mathew lidera Helera, e nossa irmã Jade... ela era casada com o falecido Rei Oriun e agora é conselheira da Rainha Enola, filha dela.\n\n*Sorri com orgulho*\n\nA família Wintar sempre manteve laços fortes com a coroa. Gostaria de saber mais?");
        cvRoleplayFamily1.addOptionText(SPANISH, "Cuéntame sobre la familia Wintar.", "*Se reclina con una expresión pensativa*\n\nAh, los Wintars. Somos una de las familias nobles más prominentes del reino, [PLAYERNAME], junto a la familia real Lysnes.\n\n*Gesticula pensativamente*\n\nTengo tres hermanos: Mukas gobierna la isla independiente de Esperand, Mathew lidera Helera, y nuestra hermana Jade... estaba casada con el difunto Rey Oriun y ahora es consejera de la Reina Enola, su hija.\n\n*Sonríe con orgullo*\n\nLa familia Wintar siempre ha mantenido fuertes lazos con la corona. ¿Te gustaría saber más?");
        npc.conversationOptions.add(cvRoleplayFamily1);

        ConversationOption cvRoleplayFamily2 = new ConversationOption(100, 101);
        cvRoleplayFamily2.addOptionText(ENGLISH, "Yes, please continue.", "*Nods appreciatively*\n\nI'm married and have a daughter who studies diplomacy and languages in Monelix. A bright young woman with a keen mind for politics and culture. I'm quite proud of her.\n\n*Becomes more serious*\n\nThe relationship between the Wintars and the Lysnes has always been one of mutual respect and cooperation. My sister Jade's marriage to King Oriun strengthened that bond, and now Queen Enola carries both bloodlines - truly a bridge between our families.");
        cvRoleplayFamily2.addOptionText(PORTUGUESE, "Sim, por favor continue.", "*Acena com apreço*\n\nSou casado e tenho uma filha que estuda diplomacia e idiomas em Monelix. Uma jovem brilhante com uma mente aguçada para política e cultura. Tenho muito orgulho dela.\n\n*Fica mais sério*\n\nA relação entre os Wintars e os Lysnes sempre foi de respeito mútuo e cooperação. O casamento de minha irmã Jade com o Rei Oriun fortaleceu esse vínculo, e agora a Rainha Enola carrega ambas as linhagens - verdadeiramente uma ponte entre nossas famílias.");
        cvRoleplayFamily2.addOptionText(SPANISH, "Sí, por favor continúa.", "*Asiente con aprecio*\n\nEstoy casado y tengo una hija que estudia diplomacia e idiomas en Monelix. Una joven brillante con una mente aguda para política y cultura. Estoy muy orgulloso de ella.\n\n*Se pone más serio*\n\nLa relación entre los Wintars y los Lysnes siempre ha sido de respeto mutuo y cooperación. El matrimonio de mi hermana Jade con el Rey Oriun fortaleció ese vínculo, y ahora la Reina Enola lleva ambos linajes: verdaderamente un puente entre nuestras familias.");
        npc.conversationOptions.add(cvRoleplayFamily2);

        ConversationOption cvRoleplayFamily3 = new ConversationOption(101, 0);
        cvRoleplayFamily3.addOptionText(ENGLISH, "Your family sounds remarkable.", "*Bows head slightly in gratitude*\n\nYou're kind to say so. We do our best to serve the kingdom with honor.\n\n*Straightens up*\n\nPerhaps one day you'll meet my siblings. Mathew in Helera is a capable leader, especially in times of crisis. Mukas has done wonders with Esperand's independence. And Jade... well, she's the wisest of us all.\n\n*Smiles warmly*\n\nBut enough about my family. Is there anything else I can help you with today?");
        cvRoleplayFamily3.addOptionText(PORTUGUESE, "Sua família parece notável.", "*Inclina a cabeça levemente em gratidão*\n\nÉ gentil em dizer isso. Fazemos o nosso melhor para servir o reino com honra.\n\n*Endireita-se*\n\nTalvez um dia você conheça meus irmãos. Mathew em Helera é um líder capaz, especialmente em tempos de crise. Mukas fez maravilhas com a independência de Esperand. E Jade... bem, ela é a mais sábia de todos nós.\n\n*Sorri calorosamente*\n\nMas chega sobre minha família. Há algo mais em que eu possa ajudá-lo hoje?");
        cvRoleplayFamily3.addOptionText(SPANISH, "Su familia suena notable.", "*Inclina la cabeza ligeramente en gratitud*\n\nEs amable al decirlo. Hacemos nuestro mejor esfuerzo para servir al reino con honor.\n\n*Se endereza*\n\nQuizás algún día conozcas a mis hermanos. Mathew en Helera es un líder capaz, especialmente en tiempos de crisis. Mukas ha hecho maravillas con la independencia de Esperand. Y Jade... bueno, es la más sabia de todos nosotros.\n\n*Sonríe calurosamente*\n\nPero basta sobre mi familia. ¿Hay algo más en lo que pueda ayudarte hoy?");
        npc.conversationOptions.add(cvRoleplayFamily3);

        ConversationOption cvRoleplayFamily2Decline = new ConversationOption(100, 0);
        cvRoleplayFamily2Decline.addOptionText(ENGLISH, "That's enough for now, thank you.", "*Nods understandingly*\n\nOf course. The Wintar family history can be quite extensive. Feel free to ask if you're ever curious again.");
        cvRoleplayFamily2Decline.addOptionText(PORTUGUESE, "Isso é suficiente por agora, obrigado.", "*Acena com compreensão*\n\nClaro. A história da família Wintar pode ser bastante extensa. Sinta-se à vontade para perguntar se ficar curioso novamente.");
        cvRoleplayFamily2Decline.addOptionText(SPANISH, "Eso es suficiente por ahora, gracias.", "*Asiente com compreensão*\n\nPor supuesto. La historia de la familia Wintar puede ser bastante extensa. Siéntete libre de preguntar si alguna vez tienes curiosidad de nuevo.");
        npc.conversationOptions.add(cvRoleplayFamily2Decline);

        // ===== QUEST: Kingdoms Cup - Part 1 =====
        ConversationOption cvKingdomsCup1 = new ConversationOption(0, 10);
        cvKingdomsCup1.addOptionText(ENGLISH, "A young man named Freddy wants to organize a tournament between all kingdoms.", "Freddy? Ah yes, that energetic young fellow from here in Bastian. I've seen him around - always full of ideas and enthusiasm.\n\n*Strokes his beard thoughtfully*\n\nA tournament between all kingdoms, you say? Tell me more about this.");
        cvKingdomsCup1.addOptionText(PORTUGUESE, "Um jovem chamado Freddy quer organizar um torneio entre todos os reinos.", "Freddy? Ah sim, aquele jovem cheio de energia daqui de Bastian. Eu o vi por aí - sempre cheio de ideias e entusiasmo.\n\n*Acaricia a barba pensativamente*\n\nUm torneio entre todos os reinos, você diz? Conte-me mais sobre isso.");
        cvKingdomsCup1.addOptionText(SPANISH, "Un joven llamado Freddy quiere organizar un torneo entre todos los reinos.", "¿Freddy? Ah sí, ese joven lleno de energía de aquí de Bastian. Lo he visto por ahí, siempre lleno de ideas y entusiasmo.\n\n*Se acaricia la barba pensativamente*\n\n¿Un torneo entre todos los reinos, dices? Cuéntame más sobre esto.");
        cvKingdomsCup1.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.KINGDOMS_CUP, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvKingdomsCup1);

        ConversationOption cvKingdomsCup2 = new ConversationOption(10, 11);
        cvKingdomsCup2.addOptionText(ENGLISH, "A Mob Ball competition bringing all kingdoms together.", "Mob Ball! Now that's interesting. A sporting competition could do wonders for unity and morale among our peoples.\n\n*Pauses, considering*\n\nBut organizing something of this scale... it's ambitious. Does Freddy have a plan? Has he thought about the logistics, the costs, bringing leaders together?");
        cvKingdomsCup2.addOptionText(PORTUGUESE, "Uma competição de Mob Ball reunindo todos os reinos.", "Mob Ball! Agora isso é interessante. Uma competição esportiva poderia fazer maravilhas pela unidade e moral entre nossos povos.\n\n*Pausa, considerando*\n\nMas organizar algo desta escala... é ambicioso. Freddy tem um plano? Ele pensou na logística, nos custos, em reunir os líderes?");
        cvKingdomsCup2.addOptionText(SPANISH, "Una competición de Mob Ball reuniendo todos los reinos.", "¡Mob Ball! Eso es interesante. Una competición deportiva podría hacer maravillas por la unidad y la moral entre nuestros pueblos.\n\n*Pausa, considerando*\n\nPero organizar algo de esta escala... es ambicioso. ¿Freddy tiene un plan? ¿Ha pensado en la logística, los costos, reunir a los líderes?");
        npc.conversationOptions.add(cvKingdomsCup2);

        ConversationOption cvKingdomsCup3 = new ConversationOption(11, 0);
        cvKingdomsCup3.addOptionText(ENGLISH, "He's counting on your support to convince the other leaders.", "*Smiles warmly*\n\nAh, I see. He's a smart young man - he knows that if Bastian supports this, others will follow. And you know what? The energy of youth reminds us lords what truly matters.\n\n*Nods decisively*\n\nVery well! Tell Freddy that Bastian is in. I will support this Kingdoms Cup. Now, you'll need to speak with the other leaders. Start with my sister Jade in Monelix - mention that I've already accepted. That should help persuade them.");
        cvKingdomsCup3.addOptionText(PORTUGUESE, "Ele conta com seu apoio para convencer os outros líderes.", "*Sorri calorosamente*\n\nAh, entendo. É um jovem esperto - sabe que se Bastian apoiar isso, outros seguirão. E sabe de uma coisa? A energia da juventude nos lembra, a nós lordes, o que realmente importa.\n\n*Acena decisivamente*\n\nMuito bem! Diga a Freddy que Bastian está dentro. Vou apoiar esta Copa dos Reinos. Agora, você precisará falar com os outros líderes. Comece com minha irmã Jade em Monelix - mencione que eu já aceitei. Isso deve ajudar a persuadi-los.");
        cvKingdomsCup3.addOptionText(SPANISH, "Él cuenta con tu apoyo para convencer a los otros líderes.", "*Sonríe calurosamente*\n\nAh, entiendo. Es un joven inteligente: sabe que si Bastian apoya esto, otros seguirán. ¿Y sabes qué? La energía de la juventud nos recuerda a los señores lo que realmente importa.\n\n*Asiente con decisión*\n\n¡Muy bien! Dile a Freddy que Bastian está dentro. Apoyaré esta Copa de los Reinos. Ahora, necesitarás hablar con los otros líderes. Empieza con mi hermana Jade en Monelix; menciona que yo ya he aceptado. Eso debería ayudar a persuadirlos.");
        cvKingdomsCup3.listeners = (ctx, currentFragment) -> {
            Quest quest = App.getPlayerChar().getQuest(QuestsIds.KINGDOMS_CUP);
            LibQuest.updateQuest(quest, 2, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvKingdomsCup3);

        return npc;
    }
}

