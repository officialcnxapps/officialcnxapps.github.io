package com.cnx.endlesstalestwo.data.npcs.growrocks.forge;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.crafts.Crafts;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Collections;

public class LugagIronhand extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Lugag Ironhand");
        npc.age = 46;
        npc.job = Enums.NPCJobs.MALE_BLACKSMITH;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "This dwarf is very hardworking and loves manual craft, a perfectionist.\nGenerous but not naive, he knows the value of his work.\nOlder brother of Richard from the miners' guild.\n\nHis physical traits: A broad, marked face, deep light-brown eyes, mixed brown-red beard, and short hair.");
        npc.addDescriptionTranslation(PORTUGUESE, "Este anão é muito esforçado e amante do seu trabalho manual, perfeccionista.\nGeneroso mas não inocente, sabe o valor do seu trabalho.\nIrmão mais velho de Richard, da guilda dos mineradores.\n\nSeus traços físicos: Rosto gordo e marcado. Olhos castanho claros, profundos. Barba mista entre castanho e ruivo e cabelo curto.");
        npc.addDescriptionTranslation(SPANISH, "Este enano es muy esforzado y amante del trabajo manual, perfeccionista.\nGeneroso pero no ingenuo, conoce el valor de su trabajo.\nHermano mayor de Richard, de la asociación de mineros.\n\nSus rasgos físicos: Rostro ancho y marcado, ojos castaño claros y profundos, barba mezclada entre castaño y rojizo, y cabello corto.");
        npc.canBePickpocketed = true;

        npc.greetingsMessages.put(ENGLISH, Collections.singletonList("The forge calls. What do you need?"));
        npc.greetingsMessages.put(PORTUGUESE, Collections.singletonList("A forja chama. O que precisa?"));
        npc.greetingsMessages.put(SPANISH, Collections.singletonList("La forja llama. ¿Qué necesitas?"));

        npc.byeMessages.put(ENGLISH, Collections.singletonList("May your steel never break."));
        npc.byeMessages.put(PORTUGUESE, Collections.singletonList("Que seu aço nunca quebre."));
        npc.byeMessages.put(SPANISH, Collections.singletonList("Que tu acero nunca se rompa."));

        // ===== ROLEPLAY: About the forge =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "Tell me about your work.", "I am master smith of Growrocks. Forty years at the forge, and still learning. Metal has secrets - how hot, how long, how hard to strike. Every piece different. Iron for strength, steel for sharpness, caltranium for the finest work. The forge is not just fire and hammer - it is art, science, tradition. My father taught me, his father taught him, back through generations. When I forge, I continue that line. That is the dwarven way.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Conte-me sobre seu trabalho.", "Sou mestre ferreiro de Growrocks. Quarenta anos na forja, e ainda aprendendo. O metal tem segredos - quão quente, quanto tempo, quão forte bater. Cada peça diferente. Ferro para força, aço para afiação, caltranio para o trabalho mais fino. A forja não é apenas fogo e martelo - é arte, ciência, tradição. Meu pai me ensinou, o pai dele o ensinou, através de gerações. Quando forjo, continuo essa linha. Este é o caminho anão.");
        cvRoleplay1.addOptionText(SPANISH, "Cuéntame sobre tu trabajo.", "Soy maestro herrero de Growrocks. Cuarenta años en la forja, y aún aprendiendo. El metal tiene secretos - cuán caliente, cuánto tiempo, cuán fuerte golpear. Cada pieza diferente. Hierro para fuerza, acero para filo, caltranio para el trabajo más fino. La forja no es solo fuego y martillo - es arte, ciencia, tradición. Mi padre me enseñó, su padre le enseñó, a través de generaciones. Cuando forjo, continúo esa línea. Ese es el camino enano.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY 2: About teaching =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "Do you teach others your craft?", "I teach my apprentices, yes. Dwarven children who show the gift - steady hands, sharp eyes, patience. Not everyone can smith. Some have the strength but not the vision. Some have the vision but not the patience. True smithing requires all three. I have two apprentices now - learning slowly, as it should be. Cannot rush the forge. Cannot rush the learning. Both burn what they touch.");
        cvRoleplay2.addOptionText(PORTUGUESE, "Você ensina seu ofício a outros?", "Ensino meus aprendizes, sim. Crianças anãs que mostram o dom - mãos firmes, olhos afiados, paciência. Nem todos podem forjar. Alguns têm a força mas não a visão. Alguns têm a visão mas não a paciência. A verdadeira ferraria requer os três. Tenho dois aprendizes agora - aprendendo devagar, como deve ser. Não se pode apressar a forja. Não se pode apressar o aprendizado. Ambos queimam o que tocam.");
        npc.conversationOptions.add(cvRoleplay2);

        // ===== ROLEPLAY 3: How to craft Dwarven Pickaxe (only during Part 5 of quest) =====
        ConversationOption cvRoleplayPickaxe = new ConversationOption(0, 0);
        cvRoleplayPickaxe.addOptionText(ENGLISH, "How do I craft a Dwarven Pickaxe?", "*Stops hammering, examines you with interest*\nAh, Oliman's final test. Smart to ask. Many try without guidance - fail badly.\n\n*Wipes hands on apron*\nOur pickaxe requires three things: one steel ingot, one gold ingot, one log for the handle. But here's the secret - it's not just materials. The tempering must be perfect. Too hot, the steel cracks. Too cold, it stays weak. You need steady hands, patience, proper timing.\n\nVery difficult to craft correctly. Most surface dwellers cannot do it. If you lack the skill or materials, you must trade for one - but that shows wisdom too, knowing your limits.");
        cvRoleplayPickaxe.addOptionText(PORTUGUESE, "Como eu fabrico uma Picareta dos Anões?", "*Para de martelar, examina você com interesse*\nAh, o teste final de Oliman. Esperto em perguntar. Muitos tentam sem orientação - falham feio.\n\n*Limpa as mãos no avental*\nA nossa picareta requer três coisas: uma barra de aço, uma barra de ouro, uma tora para o cabo. Mas aqui está o segredo - não são apenas materiais. A temperatura deve ser perfeita. Muito quente, o aço racha. Muito frio, fica fraco. Você precisa de mãos firmes, paciência, tempo adequado.\n\nMuito difícil de fabricar corretamente. A maioria dos habitantes da superfície não consegue. Se você não tem a habilidade ou materiais, deve negociar por uma - mas isso também mostra sabedoria, conhecer seus limites.");
        cvRoleplayPickaxe.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_DWARVEN_CITY, 8)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvRoleplayPickaxe.listeners = (ctx, currentFragment) -> {
            if (App.DataManager != null && App.DataManager.getCraft("CRAFT_RECIPE|DWARVENS_PICKAXE-STEEL_INGOT-GOLD_INGOT-LOG") == null){
                App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, new Crafts().craftDwarvenPickaxe());
            }
        };
        npc.conversationOptions.add(cvRoleplayPickaxe);

        // ===== QUEST PART 2: Talk to Lugag =====
        ConversationOption cvQuestTalk = new ConversationOption(0, 0);
        cvQuestTalk.addOptionText(ENGLISH, "Oliman sent me to speak with you.", "*Sets down his hammer, wipes his hands on his leather apron*\nAh. The surface dweller Oliman mentioned. So he trusts you enough to send you here - that says something. I do not take such referrals lightly.\n\n*Gestures toward the forge*\nThe forge needs feeding. We burn through supplies faster than the miners can haul them. Right now I need ten coals and five logs - dry ones, none of that wet forest wood. Bring them to me and we'll see if you're as capable as Oliman believes.");
        cvQuestTalk.addOptionText(PORTUGUESE, "Oliman me enviou para falar com você.", "*Pousa o martelo, limpa as mãos no avental de couro*\nAh. O habitante da superfície que Oliman mencionou. Então ele confia em você o suficiente para te enviar aqui - isso diz algo. Não levo tais indicações de ânimo leve.\n\n*Aponta para a forja*\nA forja precisa de combustível. Consumimos suprimentos mais rápido do que os mineradores conseguem trazer. Agora preciso de dez carvões e cinco toras - secas, nenhuma daquela madeira úmida de floresta. Traga-as para mim e veremos se você é tão capaz quanto Oliman acredita.");
        cvQuestTalk.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_DWARVEN_CITY, 2)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        cvQuestTalk.listeners = (ctx, currentFragment) -> {
            LibQuest.updateQuest(QuestsIds.THE_DWARVEN_CITY, 3, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuestTalk);

        // ===== QUEST PART 3: Deliver supplies =====
        ConversationOption cvQuest = new ConversationOption(0, 1);
        cvQuest.addOptionText(ENGLISH, "I have wood and coal for you.", "*Looks up from his work, hammer still in hand*\nAh. Oliman tests you, then. Bringing supplies to the smith - simple task, but necessary. The forge devours fuel. Always hungry, never satisfied.\n\n*Wipes sweat from his brow*\nYou have what I need?");
        cvQuest.addOptionText(PORTUGUESE, "Tenho madeira e carvão para você.", "*Levanta o olhar de seu trabalho, martelo ainda na mão*\nAh. Oliman testa você, então. Trazer suprimentos para o ferreiro - tarefa simples, mas necessária. A forja devora combustível. Sempre faminta, nunca satisfeita.\n\n*Limpa o suor da testa*\nVocê tem o que preciso?");
        cvQuest.addOptionText(SPANISH, "Tengo madera y carbón para ti.", "*Levanta la vista de su trabajo, martillo aún en mano*\nAh. Oliman te prueba, entonces. Traer suministros al herrero - tarea simple, pero necesaria. La forja devora combustible. Siempre hambrienta, nunca satisfecha.\n\n*Limpia el sudor de su frente*\n¿Tienes lo que necesito?");
        cvQuest.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_DWARVEN_CITY, 3) &&
                    LibInventory.checkHasItemAmount(ItemsIds.LOG, 5, chara) &&
                    LibInventory.checkHasItemAmount(ItemsIds.COAL, 10, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };
        npc.conversationOptions.add(cvQuest);

        ConversationOption cvQuestDeliver = new ConversationOption(1, 0);
        cvQuestDeliver.addOptionText(ENGLISH, "[Deliver 5 Logs and 10 Coals]", "*Takes the materials, inspecting the quality*\n\nGood. Dry wood - burns hot. Quality coal - burns long. You chose well, or were lucky. Either way, acceptable.\n\n*Tosses wood into the forge, adds coal carefully*\n\nThe flames rise. The forge lives. Tell Oliman - task complete. Now leave me to my work. Metal does not forge itself.");
        cvQuestDeliver.addOptionText(PORTUGUESE, "[Entregar 5 Madeiras e 10 Carvões]", "*Pega os materiais, inspecionando a qualidade*\n\nBom. Madeira seca - queima quente. Carvão de qualidade - queima longo. Você escolheu bem, ou teve sorte. De qualquer forma, aceitável.\n\n*Joga madeira na forja, adiciona carvão cuidadosamente*\n\nAs chamas se erguem. A forja vive. Diga a Oliman - tarefa completa. Agora me deixe com meu trabalho. O metal não se forja sozinho.");
        cvQuestDeliver.addOptionText(SPANISH, "[Entregar 5 Maderas y 10 Carbones]", "*Toma los materiales, inspeccionando la calidad*\n\nBien. Madera seca - quema caliente. Carbón de calidad - quema largo. Elegiste bien, o tuviste suerte. De cualquier manera, aceptable.\n\n*Arroja madera en la forja, añade carbón cuidadosamente*\n\nLas llamas se elevan. La forja vive. Dile a Oliman - tarea completa. Ahora déjame con mi trabajo. El metal no se forja solo.");
        cvQuestDeliver.listeners = (ctx, currentFragment) -> {
            LibInventory.removeFromInventory(ItemsIds.LOG, 5, App.getPlayerChar());
            LibInventory.removeFromInventory(ItemsIds.COAL, 10, App.getPlayerChar());
            LibQuest.updateQuest(QuestsIds.THE_DWARVEN_CITY, 4, App.getPlayerChar(), ctx);
        };
        npc.conversationOptions.add(cvQuestDeliver);

        return npc;
    }
}

