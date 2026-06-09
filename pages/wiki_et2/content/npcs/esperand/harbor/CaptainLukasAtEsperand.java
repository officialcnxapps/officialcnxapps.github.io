package com.cnx.endlesstalestwo.data.npcs.esperand.harbor;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.INVESTIGATE_THE_BEAST;
import static com.cnx.endlesstalestwo.data.quests.QuestsIds.SEA_VERIFICATION;

import com.cnx.cnxgameengine.utils.LibUtils;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.activities.GameplayActivity;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;
import com.cnx.endlesstalestwo.libs.Utils;

import java.util.Collections;

public class CaptainLukasAtEsperand extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Captain Lukas");
        npc.addNameTranslation(PORTUGUESE, "Capitão Lukas");
        npc.addNameTranslation(SPANISH, "Capitán Lukas");
        npc.age = 43;
        npc.job = Enums.NPCJobs.SHIP_CAPTAIN;
        npc.gender = Enums.Gender.MALE;
        npc.imgFile = "npc_captain_lukas";
        npc.resetId("CAPTAIN_LUKAS_AT_ESPERAND");

        npc.addDescriptionTranslation(ENGLISH, "A clever man with strong social skills.\nHe leads his sailors calmly, but no one oversteps his authority.\n\nHis physical traits: Short beard and mustache, light brown hair, fair skin with a light tan.");
        npc.addDescriptionTranslation(PORTUGUESE, "Um homem esperto, com boas habilidades sociais.\nLidera seus marinheiros com tranquilidade, mas ninguém passa por cima de sua autoridade.\n\nSeus traços físicos: Barba e bigode curto. Cabelo castanho e claro. Pele clara mas com bronzeado leve.");
        npc.addDescriptionTranslation(SPANISH, "Un hombre astuto, con buenas habilidades sociales.\nLidera a sus marineros con tranquilidad, pero nadie pasa por encima de su autoridad.\n\nSus rasgos físicos: Barba y bigote cortos, cabello castaño claro y piel clara con un leve bronceado.");

        npc.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, INVESTIGATE_THE_BEAST, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("Hey, [PLAYERNAME]"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("Hei, [PLAYERNAME]"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("Hey, [PLAYERNAME]"));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("Let me know when you are ready to go back."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Avise assim que estiver pronto para voltarmos."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Avísame cuando estés listo para que regresemos."));

        ///ABOUT QUEST: SEA VERIFICATION
        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "Did you see what I saw?", "I think so, I thought we were going to be attacked! My heart was racing fast, and look, a sea captain doesn't scare easily...\nBut I think it's a good sign, that spot in the sea must be the beast's hideout.");
        cv1.addOptionText(PORTUGUESE, "Você viu o que eu vi?", "Acho que sim, achei que seríamos atacados! Meu coração estava a palpitar rápido e olha que um capitão dos mares não se assusta fácil...\nMas acho que é um bom sinal, aquele ponto no mar só pode ser o esconderijo dessa besta.");
        cv1.addOptionText(SPANISH, "¿Viste lo que yo vi?", "Creo que sí, ¡pensé que íbamos a ser atacados! Mi corazón latía rápido, y mira, un capitán de mar no se asusta fácilmente...\nPero creo que es una buena señal, ese punto en el mar debe ser el escondite de la bestia.");
        cv1.requirementValidations = (chara, ctx) -> {
            if (!LibQuest.isCharacterAtQuestPart(chara, SEA_VERIFICATION, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(1, 2);
        cv2.addOptionText(ENGLISH, "But how will we get so deep?", "Well, when we stopped and I dropped the anchor, it must have sunk about 20 or 30 meters until it hit something. I think a submersion spell might be the answer.");
        cv2.addOptionText(PORTUGUESE, "Mas como chegaremos tão profundo?", "Então, quando paramos e lancei a âncora, ela deve ter afundado uns 20 ou 30 metros até esbarrar naquilo. Acho que uma magia de submersão pode ser a resposta.");
        cv2.addOptionText(SPANISH, "¿Pero cómo llegaremos tan profundo?", "Bueno, cuando paramos y solté el ancla, debe haberse hundido unos 20 o 30 metros hasta chocar con algo. Creo que un hechizo de inmersión podría ser la respuesta.");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(2, 3);
        cv3.addOptionText(ENGLISH, "And where can I get that?", "I know Verona, she's known for knowing some nature spells, maybe she can help you with that.");
        cv3.addOptionText(PORTUGUESE, "E onde consigo isso?", "Conheço a Verona, ela é conhecida por conhecer algumas magias da natureza, talvez saiba como te ajudar com isso.");
        cv3.addOptionText(SPANISH, "¿Y dónde puedo conseguir eso?", "Conozco a Verona, es conocida por conocer algunos hechizos de la naturaleza, tal vez pueda ayudarte con eso.");
        npc.conversationOptions.add(cv3);

        ConversationOption cv4 = new ConversationOption(3, 999);
        cv4.addOptionText(ENGLISH, "Okay! Now let's go back carefully.", "Alright, let's stay away from trouble and return to Helera.");
        cv4.addOptionText(PORTUGUESE, "Ok! Agora vamos voltar com cuidado.", "Tá certo, vamos passar longe do problema e voltar à Helera.");
        cv4.addOptionText(SPANISH, "¡De acuerdo! Ahora volvamos con cuidado.", "Muy bien, mantengámonos alejados de problemas y regresemos a Helera.");
        cv4.listeners = (ctx, currentFragment) -> {
            if (App.getPlayerChar() != null && LibUtils.getActivityFromContext(ctx) instanceof GameplayActivity gPlayActivity) {
                Utils.getCharToLocation(LocationsIds.HELERA_HARBOR, 0, gPlayActivity, App.getPlayerChar());
                LibQuest.updateQuest(INVESTIGATE_THE_BEAST, 3, App.getPlayerChar(), ctx);
            }
        };
        npc.conversationOptions.add(cv4);

        return npc;
    }
}
