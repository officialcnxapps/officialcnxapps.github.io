package com.cnx.endlesstalestwo.data.npcs.esperand.church;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.libs.Utils.isInsideAvailableHours;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class Valanya extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Valanya");
        npc.age = 54;
        npc.job = Enums.NPCJobs.FEMALE_JEWELER;
        npc.gender = Enums.Gender.FEMALE;
        npc.addDescriptionTranslation(ENGLISH, "This woman likes her routine. Focused on work and attentive to details.\nImpressionable, but not naive. She knows every corner of Esperand well.\n\nHer physical traits: Short hair already almost gray. Honey-colored eyes and reddish cheeks.");
        npc.addDescriptionTranslation(PORTUGUESE, "Esta mulher gosta da sua rotina. Focada no trabalho e atenciosa aos detalhes.\nImpressionável, mas não inocente. Conhece bem todos os cantos de Esperand.\n\nSeus traços físicos: Cabelo curto já quase grisalho. Olhos cor de mel e bochechas avermelhadas.");
        npc.addDescriptionTranslation(SPANISH, "Esta mujer disfruta su rutina. Enfocada en el trabajo y atenta a los detalles.\nImpresionable, pero no ingenua. Conoce bien todos los rincones de Esperand.\n\nSus rasgos físicos: Cabello corto ya casi canoso. Ojos color miel y mejillas enrojecidas.");
        npc.canBePickpocketed = true;

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 0);
        cv1.addOptionText(ENGLISH, "Why work with jewels in a church?", "Because devotion is not only spoken. Gems catch light in ways common metal cannot. I shape pendants and offerings so faith may be worn or placed before the altar with dignity.");
        cv1.addOptionText(PORTUGUESE, "Por que trabalhar com joias numa igreja?", "Porque devoção não se expressa apenas com palavras. Gemas capturam a luz de um modo que metal comum não consegue. Eu moldo pingentes e oferendas para que a fé possa ser usada ou deixada diante do altar com dignidade.");
        cv1.addOptionText(SPANISH, "¿Por qué trabajar con joyas en una iglesia?", "Porque la devoción no solo se expresa con palabras. Las gemas capturan la luz de un modo que el metal común no puede. Moldeo colgantes y ofrendas para que la fe pueda llevarse o dejarse ante el altar con dignidad.");
        npc.conversationOptions.add(cv1);

        // ===== ROLEPLAY: Rumores da cidade — O espírito errante =====
        ConversationOption cvRumors = new ConversationOption(0, 1);
        cvRumors.addOptionText(ENGLISH,
                "Heard any interesting rumors lately?",
                "Hmm... *lowers voice slightly*\nActually, yes. Some travelers passing through have been talking about a spirit. A wandering figure seen in unusual places. No one seems to know who — or what — it is.");
        cvRumors.addOptionText(PORTUGUESE,
                "Ouviu algum rumor interessante ultimamente?",
                "Hmm... *abaixa um pouco a voz*\nNa verdade, sim. Alguns viajantes de passagem têm comentado sobre um espírito. Uma figura errante vista em lugares incomuns. Ninguém parece saber quem — ou o que — é.");
        cvRumors.addOptionText(SPANISH,
                "¿Has oído algún rumor interesante últimamente?",
                "Hmm... *baja ligeramente la voz*\nEn realidad, sí. Algunos viajeros de paso han estado hablando de un espíritu. Una figura errante vista en lugares inusuales. Nadie parece saber quién — o qué — es.");
        npc.conversationOptions.add(cvRumors);

        ConversationOption cvRumorsDetails = new ConversationOption(1, 0);
        cvRumorsDetails.addOptionText(ENGLISH,
                "A spirit? Tell me more.",
                "I've never seen it myself, so I can't say for certain. But the travelers say it wanders the empty roads in the dead of night. No footsteps. No sound. Just a pale figure drifting through the dark. It doesn't seem to harm anyone... but seeing it leaves people unsettled. Perhaps it's a lost soul. Perhaps something else entirely.");
        cvRumorsDetails.addOptionText(PORTUGUESE,
                "Um espírito? Me conte mais.",
                "Nunca o vi pessoalmente, então não posso dizer com certeza. Mas os viajantes dizem que ele vaga pelas estradas vazias nas madrugadas. Sem passos. Sem som. Apenas uma figura pálida à deriva na escuridão. Não parece machucar ninguém... mas quem o vê fica perturbado. Talvez seja uma alma perdida. Talvez algo completamente diferente.");
        cvRumorsDetails.addOptionText(SPANISH,
                "¿Un espíritu? Cuéntame más.",
                "Nunca lo he visto, así que no puedo decirlo con certeza. Pero los viajeros dicen que vaga por los caminos vacíos en plena madrugada. Sin pasos. Sin sonido. Solo una figura pálida a la deriva en la oscuridad. No parece dañar a nadie... pero quienes lo ven quedan perturbados. Quizás sea un alma perdida. Quizás algo completamente distinto.");
        npc.conversationOptions.add(cvRumorsDetails);

        npc.requirementValidations = (chara, ctx) -> {
            if (isInsideAvailableHours(16, 19)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        npc.resetId("VALANYA_CHURCH");

        return npc;
    }
}