package com.cnx.endlesstalestwo.data.npcs.growrocks.tavern;

import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.ENGLISH;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.PORTUGUESE;
import static com.cnx.cnxgameengine.utils.CoreEnums.AvailableLanguages.SPANISH;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConversationOption;
import com.cnx.endlesstalestwo.entities.Npc;
import com.cnx.endlesstalestwo.enums.Enums;

public class PourinBarkskin extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.NPC, npc());
    }

    Npc npc() {
        Npc npc = new Npc("Pourin Barkskin");
        npc.age = 41;
        npc.job = Enums.NPCJobs.MALE_TAVERN_KEEPER;
        npc.gender = Enums.Gender.MALE;
        npc.addDescriptionTranslation(ENGLISH, "He highly values honor and loyalty. He would never abandon his own.\nHe works with pleasure and does it skillfully.\nHe deeply loves his wife, Erin. He is a good man.\n\nHis physical traits: Red braided-back hair matching his large beard, broad face, clear small eyes, large ears, and fair skin.");
        npc.addDescriptionTranslation(PORTUGUESE, "Dá muito valor a honra e a lealdade. Nunca abandonaria os seus.\nTrabalho com gosto e o faz com habilidade.\nTem grande amor por sua esposa, Erin. É um bom homem.\n\nSeus traços físicos: Cabelos trançados para trás de cor ruiva assim como sua vasta barba. Rosto largo, olhos claros e pequenos. Orelhas grandes e pele clara.");
        npc.addDescriptionTranslation(SPANISH, "Valora mucho el honor y la lealtad. Nunca abandonaría a los suyos.\nTrabaja con gusto y lo hace con habilidad.\nSiente un gran amor por su esposa, Erin. Es un buen hombre.\n\nSus rasgos físicos: Cabello rojizo trenzado hacia atrás, al igual que su amplia barba. Rostro ancho, ojos claros y pequeños, orejas grandes y piel clara.");
        npc.canBePickpocketed = true;

        npc.generateRandomGreetings();
        npc.generateRandomByes();

        // ===== ROLEPLAY 1: About the tavern =====
        ConversationOption cvRoleplay1 = new ConversationOption(0, 0);
        cvRoleplay1.addOptionText(ENGLISH, "How's business?", "Steady. Dwarves work hard, drink hard. After a long day in the mines or the forge, they come here to relax. I serve mushroom ale - specialty of Growrocks - and hearty food. Good bread, roasted meats, root vegetables. Simple food, but fills the belly. My wife Erin helps me run the place. We've been here fifteen years, and business never slows. A dwarf will always find his way to ale and good company.");
        cvRoleplay1.addOptionText(PORTUGUESE, "Como vão os negócios?", "Firmes. Anões trabalham duro, bebem duro. Depois de um longo dia nas minas ou na forja, eles vêm aqui relaxar. Sirvo cerveja de cogumelos - especialidade de Growrocks - e comida farta. Bom pão, carnes assadas, vegetais de raiz. Comida simples, mas enche a barriga. Minha esposa Erin me ajuda a administrar o lugar. Estamos aqui há quinze anos, e os negócios nunca param. Um anão sempre encontrará seu caminho para cerveja e boa companhia.");
        cvRoleplay1.addOptionText(SPANISH, "¿Cómo van los negocios?", "Estables. Los enanos trabajan duro, beben duro. Después de un largo día en las minas o la forja, vienen aquí a relajarse. Sirvo cerveza de hongos - especialidad de Growrocks - y comida abundante. Buen pan, carnes asadas, vegetales de raíz. Comida simple, pero llena el estómago. Mi esposa Erin me ayuda a administrar el lugar. Llevamos aquí quince años, y los negocios nunca paran. Un enano siempre encontrará su camino hacia la cerveza y buena compañía.");
        npc.conversationOptions.add(cvRoleplay1);

        // ===== ROLEPLAY 2: About dwarven ale =====
        ConversationOption cvRoleplay2 = new ConversationOption(0, 0);
        cvRoleplay2.addOptionText(ENGLISH, "What makes dwarven ale special?", "The mushrooms. We grow special fungi deep in the caves - they ferment into the strongest, smoothest ale you'll ever taste. One mug will warm your bones. Three mugs and you'll sleep like a stone. Surface dwellers usually can't handle it - too strong for them. But dwarves? We drink it like water. Been brewing the same recipe for five generations. Secret's in the cave water and the fungus variety. Can't replicate it anywhere else.");
        cvRoleplay2.addOptionText(PORTUGUESE, "O que torna a cerveja anã especial?", "Os cogumelos. Cultivamos fungos especiais nas profundezas das cavernas - eles fermentam na cerveja mais forte e suave que você já provará. Uma caneca aquecerá seus ossos. Três canecas e você dormirá como pedra. Habitantes da superfície geralmente não aguentam - forte demais para eles. Mas anões? Bebemos como água. Fabricamos a mesma receita há cinco gerações. O segredo está na água da caverna e na variedade de fungos. Não pode ser replicado em nenhum outro lugar.");
        cvRoleplay2.addOptionText(SPANISH, "¿Qué hace especial la cerveza enana?", "Los hongos. Cultivamos hongos especiales en las profundidades de las cavernas - fermentan en la cerveza más fuerte y suave que probarás. Una jarra calentará tus huesos. Tres jarras y dormirás como piedra. Los habitantes de la superficie generalmente no pueden manejarlo - demasiado fuerte para ellos. ¿Pero enanos? Lo bebemos como agua. Hemos estado elaborando la misma receta durante cinco generaciones. El secreto está en el agua de la caverna y la variedad de hongos. No se puede replicar en ningún otro lugar.");
        npc.conversationOptions.add(cvRoleplay2);

        // ===== ROLEPLAY 3: About his marriage =====
        ConversationOption cvRoleplay3 = new ConversationOption(0, 0);
        cvRoleplay3.addOptionText(ENGLISH, "How did you meet Erin?", "Ah, good story. Twenty years ago, I was working in another tavern - just a server, not the owner. Erin came in looking for work as a cook. The moment I saw her, I knew. She had this fire in her eyes, this determination. We worked together for five years before I finally had the courage to ask her to marry me. She said yes - best day of my life. We saved our gold, bought this place together, built it from nothing. She's not just my wife - she's my partner, my best friend. Couldn't imagine running this tavern without her.");
        cvRoleplay3.addOptionText(SPANISH, "¿Cómo conociste a Erin?", "Ah, buena historia. Hace veinte años, trabajaba en otra taberna - solo un camarero, no el dueño. Erin entró buscando trabajo como cocinera. En el momento en que la vi, lo supe. Tenía ese fuego en los ojos, esa determinación. Trabajamos juntos durante cinco años antes de que finalmente tuviera el coraje de pedirle que se casara conmigo. Dijo que sí - el mejor día de mi vida. Ahorramos nuestro oro, compramos este lugar juntos, lo construimos de la nada. No es solo mi esposa - es mi socia, mi mejor amiga. No podría imaginar administrar esta taberna sin ella.");
        npc.conversationOptions.add(cvRoleplay3);

        return npc;
    }
}