package com.cnx.endlesstalestwo.data.npcs.havarusNorth.prison;

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

public class Jerome extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Jerome");
        npc.age = 52;
        npc.job = Enums.NPCJobs.PRISONER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "Lunatic. He's been imprisoned for a long time.\nHe must have had some kind of disorder even before his imprisonment.\nHis stories can sometimes even seem true.\n\nHis physical traits: White hair and beard, wrinkled and aged skin. Light eyes with a distant expression.");
        npc.addDescriptionTranslation(PORTUGUESE, "Lunático, Está preso a muito tempo.\nDevia ter algum tipo de distúrbio já antes da prisão.\nSuas histórias podem as vezes até parecer verdadeiras.\n\nSeus traços físicos: Cabelos e barba brancos, pele enrugada e envelhecida. Olhos claros com expressão distante.");
        npc.addDescriptionTranslation(SPANISH, "Lunático. Lleva mucho tiempo encarcelado.\nDebe haber padecido algún trastorno incluso antes de su encarcelamiento.\nSus historias a veces parecen ciertas.\n\nSus rasgos físicos: cabello y barba blancos, piel arrugada y envejecida. Ojos claros con expresión distante.");

        // Conversation options
        ConversationOption cv1 = new ConversationOption(0, 1);
        cv1.addOptionText(ENGLISH, "What are you staring at?", "The walls! They breathe, you know. In... and out... In... and out. If you listen closely, they tell you secrets. Terrible, wonderful secrets.");
        cv1.addOptionText(PORTUGUESE, "Para que você está olhando?", "As paredes! Elas respiram, sabia? Inspiram... e expiram... Inspiram... e expiram. Se você escutar com atenção, elas te contam segredos. Segredos terríveis e maravilhosos.");
        cv1.addOptionText(SPANISH, "¿Qué estás mirando?", "¡Las paredes! Respiran, ¿sabes? Inhalan... y exhalan... Inhalan... y exhalan. Si escuchas con atención, te cuentan secretos. Secretos terribles y maravillosos.");
        npc.conversationOptions.add(cv1);

        ConversationOption cv2 = new ConversationOption(0, 0);
        cv2.addOptionText(ENGLISH, "Are you alright?", "Hah! Alright? I've never been better! The king himself serves me my meals. Sometimes he looks like a rat, sometimes like a guard... he's a master of disguise, you see!");
        cv2.addOptionText(PORTUGUESE, "Você está bem?", "Hah! Bem? Nunca estive melhor! O próprio rei me serve as refeições. Às vezes ele parece um rato, às vezes um guarda... ele é um mestre dos disfarces, entende!");
        cv2.addOptionText(SPANISH, "¿Estás bien?", "¡Ja! ¿Bien? ¡Nunca he estado mejor! El mismísimo rey me sirve la comida. A veces parece una rata, a veces un guardia... ¡es un maestro del disfraz, ya ves!");
        npc.conversationOptions.add(cv2);

        ConversationOption cv3 = new ConversationOption(1, 0);
        cv3.addOptionText(ENGLISH, "What kind of secrets?", "They whisper of a hidden key, a door that isn't there. They say it opens a path to the sky, but only for those who can hear the stones sing.");
        cv3.addOptionText(PORTUGUESE, "Que tipo de segredos?", "Elas sussurram sobre uma chave escondida, uma porta que não está lá. Dizem que abre um caminho para o céu, mas apenas para aqueles que conseguem ouvir as pedras cantarem.");
        cv3.addOptionText(SPANISH, "¿Qué clase de secretos?", "Susurran sobre una llave oculta, una puerta que no está ahí. Dicen que abre un camino al cielo, pero solo para aquellos que pueden oír cantar a las piedras.");
        npc.conversationOptions.add(cv3);

        // ========================================
        // QUEST: NIGHTMARE TO REALITY
        // ========================================

        ConversationOption cvNightmareAnswers = new ConversationOption(0, 0);
        cvNightmareAnswers.addOptionText(ENGLISH, "A man in Wazel harbor is having nightmares about ghostly pirates and an old captain.", "*His eyes bulge and he begins to sway, his voice a frantic whisper*\nNightmares? No, no, no! Voyages! We travel in the mists, between the breaths of the world! I saw the sailor, yes... I spoke to him in the gray places. I told him! I warned him! The fog-eaters are coming! \n*He laughs maniacally, then suddenly stops, deadly serious*\nThe old captain... Vorne... he never left the desert. He's waiting in the shimmering heat... the Oasis... where the water tastes like salt and the sand remembers the sea. Go, tell the sailor! The dream is the anchor, and the anchor is dropping!");
        cvNightmareAnswers.addOptionText(PORTUGUESE, "Um homem no porto de Wazel está tendo pesadelos com piratas fantasmas e um capitão antigo.", "*Os olhos dele saltam e ele começa a balançar, a voz um sussurro frenético*\nPesadelos? Não, não, não! Viagens! Nós viajamos nas névoas, entre as respirações do mundo! Eu vi o marinheiro, sim... eu falei com ele nos lugares cinzentos. Eu contei a ele! Eu o avisei! Os comedores de névoa estão chegando! \n*Ele ri maniacamente, depois para de repente, mortalmente sério*\nO velho capitão... Vorne... ele nunca saiu do deserto. Ele está esperando no calor cintilante... o Oásis... onde a água tem gosto de sal e a areia se lembra do mar. Vá, conte ao marinheiro! O sonho é a âncora, e a âncora está caindo!");
        cvNightmareAnswers.addOptionText(SPANISH, "Un hombre en el puerto de Wazel tiene pesadillas con piratas fantasmales y un viejo capitán.", "*Sus ojos se abren de par en par y empieza a balancearse, su voz es un susurro frenético*\n¿Pesadillas? ¡No, no, no! ¡Viajes! ¡Viajamos en las brumas, entre los alientos del mundo! Vi al marinero, sí... ¡hablé con él en los lugares grises! ¡Se lo dije! ¡Le advertí! ¡Ya vienen os comedores de niebla! \n*Ríe maníacamente, luego se detiene de repente, mortalmente serio*\nEl viejo capitán... Vorne... nunca dejó el desierto. Está esperando en el calor resplandeciente... el Oasis... donde el agua sabe a sal y la arena recuerda al mar. ¡Ve, díselo al marinero! ¡El sueño es el ancla, y el ancla está cayendo!");
        cvNightmareAnswers.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.NIGHTMARE_TO_REALITY, 1)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvNightmareAnswers.listeners = (ctx, currentFragment) -> LibQuest.updateQuest(QuestsIds.NIGHTMARE_TO_REALITY, 2, App.getPlayerChar(), ctx);
        npc.conversationOptions.add(cvNightmareAnswers);

        return npc;
    }
}
