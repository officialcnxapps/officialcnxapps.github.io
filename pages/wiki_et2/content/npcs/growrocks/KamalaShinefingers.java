package com.cnx.endlesstalestwo.data.npcs.growrocks;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import android.os.Looper;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.shops.ShopsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class KamalaShinefingers extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Kamala Shinefingers");
        npc.age = 26;
        npc.job = Enums.NPCJobs.FEMALE_JEWELER;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "Detail-oriented and methodical.\nTogether with her two brothers, they form a very profitable work alliance.\nIntelligent and distrustful despite her young age.\n\nHer physical traits: Wavy black hair, thin eyebrows over light-brown eyes, and a small nose on a harmonious face.");
        npc.addDescriptionTranslation(PORTUGUESE, "Detalhista e metódica.\nJunto com seus 2 irmãos, formam uma aliança de trabalho muito rentável.\nÉ inteligente e desconfiada apesar da pouca idade.\n\nSeus traços físicos: Cabelos ondulados e pretos. Sobrancelhas finas sobre os olhos castanhos claro. Nariz pequeno no rosto harmonioso.");
        npc.addDescriptionTranslation(SPANISH, "Detallista y metódica.\nJunto con sus 2 hermanos, forman una alianza de trabajo muy rentable.\nEs inteligente y desconfiada a pesar de su corta edad.\n\nSus rasgos físicos: Cabello ondulado y negro, cejas finas sobre ojos castaño claros y nariz pequeña en un rostro armonioso.");

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        //this NPC is sister of NPCs ElliotShinefingers and TrausShinefingers

        // ===== SHOP: Open jewelry shop =====
        ConversationOption cv0 = new ConversationOption(0, 2);
        cv0.addOptionText(ENGLISH, "Who are you?", "I am Kamala Shinefingers. You clearly are not from here, it is so rare to see other people different here in Growrocks!\nI transform our ores into precious jewelry. I've been doing this since I was very young.");
        cv0.addOptionText(PORTUGUESE, "Quem é você?", "Sou Kamala Shinefingers. Você claramente não á daqui, é tão raro ver outras pessoas diferentes aqui em Growrocks!\nEu transformo nossos minérios em jóias preciosas. Faço isso desde muito jovem.");
        cv0.addOptionText(SPANISH, "¿Quién eres?", "Soy Kamala Shinefingers. ¡Claramente no eres de aquí, es tan raro ver a otras personas diferentes aquí en Growrocks!\nTransformo nuestros minerales en joyas preciosas. He estado haciendo esto desde que era muy joven.");
        npc.conversationOptions.add(cv0);

        ConversationOption cvShop = new ConversationOption(0, 0);
        cvShop.addOptionText(ENGLISH, "Can I see your jewelry collection?", "Of course! I have some beautiful pieces. Take a look...");
        cvShop.addOptionText(PORTUGUESE, "Posso ver sua coleção de joias?", "Claro! Tenho algumas peças lindas. Dê uma olhada...");
        cvShop.addOptionText(SPANISH, "¿Puedo ver tu colección de joyas?", "¡Por supuesto! Tengo algunas piezas hermosas. Echa un vistazo...");
        cvShop.listeners = (ctx, fragment) -> {
            fragment.setScreenTouchable(false);
            new android.os.Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                    gPlayActivity.lockScreenTouches(true);
                    gPlayActivity.goToViewShop(ShopsIds.KAMALAS_JEWELRY);
                }
            }, 1600);
        };
        npc.conversationOptions.add(cvShop);

        // ===== ROLEPLAY 1: About her craft =====
        ConversationOption cvRoleplay1 = new ConversationOption(2, 0);
        cvRoleplay1.addOptionText(ENGLISH, "Tell me about your jewelry work.", "I work with precious metals and gems. Gold, silver, sometimes copper for practice pieces. Dwarves understand metalwork better than any other race - our jewelry is not just decoration, it is precision, artistry, legacy. Each ring, each pendant carries meaning. I learned from my grandmother, she from hers. The techniques pass down through generations, refined each time. My brothers work with stone and ore. I work with beauty.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Conte-me sobre seu trabalho com joias.", "Trabalho com metais preciosos e gemas. Ouro, prata, às vezes cobre para peças de prática. Anões entendem metalurgia melhor que qualquer outra raça - nossas joias não são apenas decoração, são precisão, arte, legado. Cada anel, cada pingente carrega significado. Aprendi com minha avó, ela com a dela. As técnicas passam através de gerações, refinadas cada vez. Meus irmãos trabalham com pedra e minério. Eu trabalho com beleza.");
        cvRoleplay1.addOptionText(SPANISH, "Cuéntame sobre tu trabajo con joyas.", "Trabajo con metales preciosos y gemas. Oro, plata, a veces cobre para piezas de práctica. Los enanos entienden metalurgia mejor que cualquier otra raza - nuestras joyas no son solo decoración, son precisión, arte, legado. Cada anillo, cada colgante lleva significado. Aprendí de mi abuela, ella de la suya. Las técnicas pasan a través de generaciones, refinadas cada vez. Mis hermanos trabajan con piedra y mineral. Yo trabajo con belleza.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY 2: About her family =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Are you related to Elliot and Traus?", "Yes, they are my brothers. Elliot works the deep mines, always searching for rare ores. Traus moves between the temple and the fortress - he is devoted but restless. We are different, but we share the Shinefingers legacy - our family has always worked with what the earth provides. They extract it, I shape it into something beautiful. Different skills, same purpose.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Você é parente de Elliot e Traus?", "Sim, eles são meus irmãos. Elliot trabalha nas minas profundas, sempre buscando minérios raros. Traus se move entre o templo e a fortaleza - ele é devoto mas inquieto. Somos diferentes, mas compartilhamos o legado Shinefingers - nossa família sempre trabalhou com o que a terra fornece. Eles extraem, eu moldo em algo belo. Habilidades diferentes, mesmo propósito.");
        cvRoleplay2.addOptionText(SPANISH, "¿Eres pariente de Elliot y Traus?", "Sí, son mis hermanos. Elliot trabaja en las minas profundas, siempre buscando minerales raros. Traus se mueve entre el templo y la fortaleza - es devoto pero inquieto. Somos diferentes, pero compartimos el legado Shinefingers - nuestra familia siempre ha trabajado con lo que la tierra proporciona. Ellos extraen, yo moldeo en algo hermoso. Habilidades diferentes, mismo propósito.");
        cvRoleplay2.requirementValidations = (chara, ctx) -> {
            if (LibQuest.charHasQuest(QuestsIds.LOST_BROTHER, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvRoleplay2);

        return npc;
    }
}






