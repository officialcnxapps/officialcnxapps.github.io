package com.cnx.endlesstalestwo.data.npcs.havarusNorth.greatRock;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class CasielPeak extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Casiel");
        npc.resetId("CASIEL_PEAK");
        npc.age = 186;
        npc.job = Enums.NPCJobs.PRIEST;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "");
        npc.addDescriptionTranslation(PORTUGUESE, "");
        npc.addDescriptionTranslation(SPANISH, "");

        // Greetings vazias - vai direto para a conversa
        npc.greetingsMessages.put(ENGLISH, java.util.Collections.singletonList("You..."));
        npc.greetingsMessages.put(PORTUGUESE, java.util.Collections.singletonList("Você..."));
        npc.greetingsMessages.put(SPANISH, java.util.Collections.singletonList("Usted..."));
        npc.cantSayBye = true;

        // Apenas aparece na Part 4 da quest Traitor
        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.TRAITOR, 4)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        // ===== TRAITOR QUEST: Part 4→5 - Revelação do plano de Casiel =====
        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "Casiel! What are you doing?!", "*Turns with a twisted smile, eyes glowing purple*\nAh, [PLAYERNAME]. So persistent. You finally caught up to me.");
        cv1.addOptionText(PORTUGUESE, "Casiel! O que você está fazendo?!", "*Vira-se com um sorriso retorcido, olhos brilhando roxo*\nAh, [PLAYERNAME]. Tão persistente. Você finalmente me alcançou.");
        cv1.addOptionText(SPANISH, "¡Casiel! ¿¡Qué estás haciendo!?", "*Se gira con una sonrisa retorcida, ojos brillando púrpura*\nAh, [PLAYERNAME]. Tan persistente. Finalmente me alcanzaste.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(1, 2);
        cv2.addOptionText(ENGLISH, "You forged the book! You lied about the portal spell!", "*Laughs darkly*\nIndeed. Clever of you to figure it out. Yes, it was all me. I brought the dark creatures to your world. I forged that book and gave you a false spell.");
        cv2.addOptionText(PORTUGUESE, "Você forjou o livro! Mentiu sobre o feitiço do portal!", "*Ri sombriamente*\nDe fato. Inteligente de você descobrir. Sim, fui tudo eu. Eu trouxe as criaturas das trevas para seu mundo. Eu forjei aquele livro e te dei um feitiço falso.");
        cv2.addOptionText(SPANISH, "¡Falsificaste el libro! ¡Mentiste sobre el hechizo del portal!", "*Ríe oscuramente*\nEn efecto. Inteligente de tu parte descubrirlo. Sí, fui todo yo. Traje las criaturas oscuras a tu mundo. Falsifiqué ese libro y te di un hechizo falso.");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(2, 3);
        cv3.addOptionText(ENGLISH, "Why?! Why betray everyone?!", "*Eyes flash with pain and rage*\nYou want to know why? Because I have NOTHING LEFT TO LOSE! When Targon died, he left vacant the position of Death King - and I realized... only through that power can I undo the greatest injustice ever done to me!");
        cv3.addOptionText(PORTUGUESE, "Por quê?! Por que trair a todos?!", "*Olhos brilham com dor e raiva*\nQuer saber por quê? Porque não tenho MAIS NADA A PERDER! Quando Targon morreu, deixou vago o cargo de Rei da Morte - e percebi... apenas através desse poder posso desfazer a maior injustiça já feita comigo!");
        cv3.addOptionText(SPANISH, "¿¡Por qué!? ¿¡Por qué traicionar a todos!?", "*Los ojos brillan con dolor y rabia*\n¿Quieres saber por qué? ¡Porque no tengo NADA MÁS QUE PERDER! Cuando Targon murió, dejó vacante el puesto de Rey de la Muerte - y me di cuenta... ¡solo a través de ese poder puedo deshacer la mayor injusticia que me han hecho!");
        npc.conversationOptions.add(cv3);

        ConversationOption cv3a = new ConversationOption(3, 4);
        cv3a.addOptionText(ENGLISH, "What injustice? What are you talking about?", "*Voice breaks with grief and fury*\nMy family... my beloved wife Aelara and my children... They were slaughtered by dark creatures DECADES ago! For years I researched, I studied the forbidden texts about death magic, seeking a way to bring them back. \n\n*Clenches fists*\nI resisted for so long! I KNEW it was wrong! But the pain... the emptiness... it never stops! Only as Death King can I command the power to reunite with them!");
        cv3a.addOptionText(PORTUGUESE, "Que injustiça? Do que você está falando?", "*Voz se quebra com luto e fúria*\nMinha família... minha amada esposa Aelara e meus filhos... Foram massacrados por criaturas das trevas há DÉCADAS! Por anos pesquisei, estudei os textos proibidos sobre magia da morte, buscando uma forma de trazê-los de volta. \n\n*Fecha os punhos*\nResisti por tanto tempo! EU SABIA que estava errado! Mas a dor... o vazio... nunca para! Apenas como Rei da Morte posso comandar o poder para me reunir com eles!");
        cv3a.addOptionText(SPANISH, "¿Qué injusticia? ¿De qué hablas?", "*La voz se quiebra con dolor y furia*\nMi familia... mi amada esposa Aelara y mis hijos... ¡Fueron masacrados por criaturas oscuras hace DÉCADAS! Durante años investigué, estudié los textos prohibidos sobre magia de la muerte, buscando una forma de traerlos de vuelta. \n\n*Cierra los puños*\n¡Resistí durante tanto tiempo! ¡SABÍA que estaba mal! Pero el dolor... el vacío... ¡nunca se detiene! ¡Solo como Rey de la Muerte puedo comandar el poder para reunirme con ellos!");
        npc.conversationOptions.add(cv3a);

        ConversationOption cv3b = new ConversationOption(4, 5);
        cv3b.addOptionText(ENGLISH, "You can't bring back the dead! It's impossible!", "*Laughs bitterly*\nImpossible? You know nothing of ancient magic! Any sufficiently powerful elven mage can claim the throne of Death King - it requires no prophecy, only WILL and POWER! \n\n*Eyes gleam with forbidden knowledge*\nThrough my studies, I discovered the truth... The Death King commands absolute power over life and death! I can resurrect my family, make them immortal, ensure no one ever suffers loss like I have! This world will know TRUE peace!");
        cv3b.addOptionText(PORTUGUESE, "Você não pode trazer de volta os mortos! É impossível!", "*Ri amargamente*\nImpossível? Você não sabe nada de magia ancestral! Qualquer mago élfico suficientemente poderoso pode reivindicar o trono de Rei da Morte - não requer profecia alguma, apenas VONTADE e PODER! \n\n*Olhos brilham com conhecimento proibido*\nAtravés dos meus estudos, descobri a verdade... O Rei da Morte comanda poder absoluto sobre vida e morte! Posso ressuscitar minha família, torná-los imortais, garantir que ninguém sofra perda como eu sofri! Este mundo conhecerá a VERDADEIRA paz!");
        cv3b.addOptionText(SPANISH, "¡No puedes traer de vuelta a los muertos! ¡Es imposible!", "*Ríe amargamente*\n¿Imposible? ¡No sabes nada de magia ancestral! Cualquier mago élfico suficientemente poderoso puede reclamar el trono de Rey de la Muerte - ¡no requiere profecía alguna, solo VOLUNTAD y PODER! \n\n*Los ojos brillan con conocimiento prohibido*\nA través de mis estudios, descubrí la verdad... ¡El Rey de la Muerte comanda poder absoluto sobre la vida y la muerte! ¡Puedo resucitar a mi familia, hacerlos inmortales, asegurar que nadie sufra pérdida como yo he sufrido! ¡Este mundo conocerá la VERDADERA paz!");
        npc.conversationOptions.add(cv3b);

        ConversationOption cv4 = new ConversationOption(5, 6);
        cv4.addOptionText(ENGLISH, "You're insane! This isn't peace, it's tyranny!", "*Absorbs more energy, growing stronger*\nTyranny? I will END all suffering! As Death King, I will command absolute power over life and death itself! \n\n*Voice echoes with otherworldly power*\nNo more families torn apart! No more children losing parents! No more lovers separated by death! I will create a perfect world where death serves LIFE, not the other way around! \n\n*Eyes blaze with purple fire*\nMy Aelara... my children... they will live again! And NO ONE will ever feel this pain again! \n\n*Unleashes a burst of dark energy*\n\nThis is mercy, mortal! You'll understand when you see the world I create! Farewell!");
        cv4.addOptionText(PORTUGUESE, "Você está louco! Isso não é paz, é tirania!", "*Absorve mais energia, ficando mais forte*\nTirania? Eu ACABAREI com todo sofrimento! Como Rei da Morte, comandarei poder absoluto sobre a própria vida e morte! \n\n*Voz ecoa com poder sobrenatural*\nChega de famílias despedaçadas! Chega de crianças perdendo pais! Chega de amantes separados pela morte! Criarei um mundo perfeito onde a morte serve à VIDA, não o contrário! \n\n*Olhos flamejam com fogo roxo*\nMinha Aelara... meus filhos... viverão novamente! E NINGUÉM sentirá essa dor novamente! \n\n*Libera uma explosão de energia sombria*\n\nIsto é misericórdia, mortal! Entenderá quando vir o mundo que criarei! Adeus!");
        cv4.addOptionText(SPANISH, "¡Estás loco! ��Esto no es paz, es tiranía!", "*Absorbe más energía, haciéndose más fuerte*\n¿Tiranía? ¡ACABARÉ con todo sufrimiento! ¡Como Rey de la Muerte, comandaré poder absoluto sobre la vida y la muerte misma! \n\n*La voz resuena con poder sobrenatural*\n¡Se acabaron las familias destrozadas! ¡Se acabaron los niños perdiendo padres! ¡Se acabaron los amantes separados por la muerte! ¡Crearé un mundo perfecto donde la muerte sirve a la VIDA, no al revés! \n\n*Los ojos arden con fuego púrpura*\nMi Aelara... mis hijos... ¡vivirán de nuevo! ¡Y NADIE sentirá este dolor nunca más! \n\n*Desata una explosión de energía oscura*\n\n¡Esto es misericordia, mortal! ¡Entenderás cuando veas el mundo que crearé! ¡Adiós!");
        npc.conversationOptions.add(cv4);

        ConversationOption cv5 = new ConversationOption(6, 999);
        cv5.addOptionText(ENGLISH, "Come back here!", "*Casiel vanishes in a flash of purple light*\n");
        cv5.addOptionText(PORTUGUESE, "Volte aqui!", "*Casiel desaparece num clarão de luz roxa*\n");
        cv5.addOptionText(SPANISH, "¡Vuelve aquí!", "*Casiel desaparece en un destello de luz púrpura*\n");
        cv5.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.TRAITOR, 5, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cv5);

        return npc;
    }
}

