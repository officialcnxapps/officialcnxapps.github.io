package com.cnx.endlesstalestwo.data.locations.ayalon;

import static com.cnx.endlesstalestwo.data.quests.QuestsIds.THE_FINAL_BATTLE;
import static com.cnx.endlesstalestwo.enums.Enums.RequirementVerification.NOT_OK;
import static com.cnx.endlesstalestwo.enums.Enums.RequirementVerification.OK;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.battles.BattlesIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.data.regions.RegionsIds;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Others extends DataHelper {

    //TRADUZIR
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, greenCave());//
        App.DataManager.add(Enums.DataTypes.LOCALE, surroundingsOfGreenCave());//
        App.DataManager.add(Enums.DataTypes.LOCALE, trailOfGreenGrove());//
        App.DataManager.add(Enums.DataTypes.LOCALE, greenwishWoods());//
        App.DataManager.add(Enums.DataTypes.LOCALE, greenwishHillocks());//
        App.DataManager.add(Enums.DataTypes.LOCALE, gloriennWaterfall());//
        App.DataManager.add(Enums.DataTypes.LOCALE, elvenBridge());//
        App.DataManager.add(Enums.DataTypes.LOCALE, ayalonDocks());//
        App.DataManager.add(Enums.DataTypes.LOCALE, ayalonNorthTrail());//
        App.DataManager.add(Enums.DataTypes.LOCALE, elvenGarden());//
        App.DataManager.add(Enums.DataTypes.LOCALE, elvenGardenDestroyed());//
    }

    Locale greenCave() {
        Locale locale = new Locale("Green Cave", RegionsIds.AYALON);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna Verde");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva Verde");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A narrow, long and tall cave. Its walls are made of greenish rocks from which small plants and vines grow. Due to the space inside and the light coming from a large crack, even some small trees have grown from the ground.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma caverna estreita, comprida e alta. Suas paredes são formadas por pedras esverdeadas de onde crescem pequenas plantas e trepadeiras. Devido ao espaço interno e a luz proveniente de uma fenda grande, até algumas pequenas árvores nasceram do solo.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una cueva estrecha, larga y alta. Sus paredes están hechas de rocas verdosas de las que crecen pequeñas plantas y enredaderas. Debido al espacio interior y la luz que entra por una gran grieta, incluso algunos árboles pequeños han crecido del suelo.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.npcs.add(NpcsIds.STATUE_OF_AELINDRA);

        locale.type = Enums.LocationTypes.CAVERN;

        return locale;
    }

    Locale surroundingsOfGreenCave() {
        Locale locale = new Locale("Surroundings of Green Cave", RegionsIds.AYALON);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Arredores da Caverna Verde");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Alrededores de la Cueva Verde");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The entrance to the cave is a wide crack in the ground where you can climb down the side in the form of a ravine. There is low grass and some trees in the surrounding area.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A entrada para a caverna é uma fenda larga no chão onde é possível descer pela lateral em forma de barranco. Há grama rasteira e algumas árvores nos arredores.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La entrada a la cueva es una amplia grieta en el suelo donde se puede bajar por el lateral en forma de barranco. Hay hierba baja y algunos árboles en los alrededores.");

        locale.type = Enums.LocationTypes.ROAD;

        return locale;
    }

    Locale trailOfGreenGrove() {
        Locale locale = new Locale("Trail of Green Grove", RegionsIds.AYALON);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Trilha do Bosque Verde");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sendero de la Arboleda Verde");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A path created by the erosion of grass where people and animals walk. There are several bushes and plants as well as some trees further away. It is a slightly winding trail that leads to a forest.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um caminho criado pelo desgaste da grama por onde passam pessoas e animais. Há vários arbustos e plantas além de algumas árvores mais distantes. É uma trilha levemente sinuosa que leva até uma floresta.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un camino creado por la erosión de la hierba por donde caminan personas y animales. Hay varios arbustos y plantas, así como algunos árboles más alejados. Es un sendero ligeramente sinuoso que conduce a un bosque.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.possibleBattles.put(BattlesIds.MALIGNANT_ELF_1, 11);
        locale.possibleBattles.put(BattlesIds.PICKPOCKETER_1, 13);

        locale.type = Enums.LocationTypes.ROAD;

        return locale;
    }

    Locale greenwishWoods() {
        Locale locale = new Locale("Greenwish Woods", RegionsIds.AYALON);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Bosque dos Desejos Verdes");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bosque de los Deseos Verdes");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "In this forest you can find a huge diversity of fauna and flora that you will never find anywhere else. There are yellow, green, red, orange and purple trees. The plants are also beautiful and there is a faint but slightly glowing mist.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Nesta floresta é possível encontrar uma enorme diversidade de fauna e flora que jamais será encontrada em outro lugar. Há árvores amarelas, verdes, vermelhas, laranjas e roxas. As plantas também são belas e há uma névoa fraca porém levemente brilhante.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En este bosque puedes encontrar una enorme diversidad de fauna y flora que nunca encontrarás en ningún otro lugar. Hay árboles amarillos, verdes, rojos, naranjas y morados. Las plantas también son hermosas y hay una niebla tenue pero ligeramente brillante.");

        locale.actions.add(ActionsIds.GATHERING_EXTRA);
        locale.actions.add(ActionsIds.WOODCUTTING);
        locale.actions.add(ActionsIds.HUNT_BASIC);
        locale.actions.add(ActionsIds.HUNT_TRAP);

        locale.possibleBattles.put(BattlesIds.FOREST_GOLEM_1, 18);
        locale.possibleBattles.put(BattlesIds.FOREST_PREDATOR_1, 17);
        locale.possibleBattles.put(BattlesIds.MALIGNANT_ELF_2, 10);
        locale.possibleBattles.put(BattlesIds.MALIGNANT_ELF_1, 20);
        locale.possibleBattles.put(BattlesIds.CORRUPTED_WIZARD_1, 16);

        locale.type = Enums.LocationTypes.FOREST;

        return locale;
    }

    Locale greenwishHillocks() {
        Locale locale = new Locale("Greenwish Hillocks", RegionsIds.AYALON);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Colinas dos Desejos Verdes");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Colinas de los Deseos Verdes");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "In the middle of the forest there are these small limestone hills. The plants grow on much of the elevation that is among the trees. Even from the top of the hills it is not possible to see far because of the large trees that surround them.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Em meio há floresta há estes pequenos morros de pedra calcária. As plantas crescem sobre boa parte da elevação que está em meio as árvores. Mesmo do topo dos outeiros não é possível ver longe devido as grandes árvores que os cercam.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En medio del bosque se encuentran estas pequeñas colinas de piedra caliza. Las plantas crecen en gran parte de la elevación que está entre los árboles. Incluso desde la cima de las colinas no es posible ver lejos debido a los grandes árboles que las rodean.");

        locale.actions.add(ActionsIds.MINING_BASIC);

        locale.type = Enums.LocationTypes.MOUNT;

        locale.possibleBattles.put(BattlesIds.MALIGNANT_ELF_2, 11);
        locale.possibleBattles.put(BattlesIds.FOREST_GOLEM_1, 16);
        locale.possibleBattles.put(BattlesIds.MOUNTAIN_GOLEM_1, 12);

        return locale;
    }

    Locale gloriennWaterfall() {
        Locale locale = new Locale("Glorienn Waterfall", RegionsIds.AYALON);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cachoeira de Glorienn");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cascada de Glorienn");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "You find yourself on the edge of a river that is not very wide. When you look ahead, you see a beautiful waterfall that is about 15 meters high. The sound of the water hitting the rocks and flowing downstream is loud. There is a lot of vegetation on the slope and you can see the occasional animal drinking water.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Você se vê na beira de um rio não muito largo. Ao olhar em frente vê uma linda queda de água com uns 15 metros de altura. O barulho da água batendo nas pedras e escorrendo rio abaixo é alto. Há bastante vegetação na encosta e é possível avistar um ou outro animal a beber água.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "");

        locale.actions.add(ActionsIds.FISHING_EXTRA);
        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.npcs.add(NpcsIds.LAURIAS);

        locale.type = Enums.LocationTypes.LAKE;

        return locale;
    }

    Locale elvenBridge() {
        Locale locale = new Locale("Elven Bridge", RegionsIds.AYALON);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ponte Élfica");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Puente Élfico");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The bridge made of white stones forms a small arch over the river. Its handrails are elegant for a bridge that is almost in the middle of a forest. To the east you can see some buildings from the city of the elves and to the west you can only see paths through the trees.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A ponte feita com pedras brancas forma um pequeno arco por sobre o rio. Seus corrimãos são elegantes para uma ponte que está quase em meio há um bosque. A leste é possível avistar algumas construções da cidade dos elfos e a oeste só se vê caminhos por entre as árvores.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El puente hecho de piedras blancas forma un pequeño arco sobre el río. Sus pasamanos son elegantes para un puente que está casi en medio de un bosque. Hacia el este se pueden ver algunos edificios de la ciudad de los elfos y hacia el oeste solo se ven senderos entre los árboles.");

        locale.actions.add(ActionsIds.FISHING_BASIC);

        locale.npcs.add(NpcsIds.HALUREN);

        locale.type = Enums.LocationTypes.ROAD;

        return locale;
    }

    Locale ayalonDocks() {
        Locale locale = new Locale("Ayalon Docks", RegionsIds.AYALON);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Docas de Ayalon");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Muelles de Ayalon");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The elven harbor is not as grand and beautiful as the city. The pier is wide, made of light wooden planks. The boxes are well organized and the pulley system is large enough for heavy loads. There is a small lighthouse and a round dock, both with green roofs.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O porto dos elfos não é tão grandioso e belo quanto a cidade. O pier é largo, feito com tábuas de madeira clara. AS caixas estão bem organizadas e o sistema de polias é grande o bastante para cargas pesadas. Há um pequeno farol e uma doca arredondada, ambos com telhado verde.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El puerto élfico no es tan grandioso y hermoso como la ciudad. El muelle es ancho, hecho de tablones de madera clara. Las cajas están bien organizadas y el sistema de poleas es lo suficientemente grande para cargas pesadas. Hay un pequeño faro y un muelle redondo, ambos con techos verdes.");

        locale.actions.add(ActionsIds.FISHING_BASIC);
        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);

        locale.npcs.add(NpcsIds.ASLATAN);

        locale.type = Enums.LocationTypes.HARBOR;

        return locale;
    }

    Locale ayalonNorthTrail() {
        Locale locale = new Locale("Ayalon North Trail", RegionsIds.AYALON);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Trilha Norte de Ayalon");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sendero Norte de Ayalon");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A short, simple trail that connects the northern exit of the citadel to the walls of the elves' sacred garden. The surrounding fields are green and flat, and the walls directly ahead are high and almost white.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma trilha simples e curta que faz a ligação entre a saída norte da cidadela e os muros do jardim sagrado dos elfos. Os campos no entorno são verdes e planos e os muros que estão bem a frente são altos e quase brancos.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un sendero corto y sencillo que conecta la salida norte de la ciudadela con las paredes del jardín sagrado de los elfos. Los campos circundantes son verdes y llanos, y las paredes que están directamente al frente son altas y casi blancas.");

        locale.type = Enums.LocationTypes.ROAD;

        return locale;
    }

    Locale elvenGarden() {
        Locale locale = new Locale("Elven Garden", RegionsIds.AYALON);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Jardim Élfico");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Jardín Élfico");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A large, well-kept natural garden. There are a variety of flowers and plants. The entire south side is surrounded by walls and to the north there is a large rocky slope. Right in the middle of this garden is the mother tree, giant, vivid and with shiny leaves.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um jardim natural amplo e bem cuidado. Há flores diversas e plantas variadas. Todo lado sul é cercado por muros e ao norte há uma grande encosta de rochas. Bem no meio deste jardim está a árvore mãe, gigante, vívida e com folhas brilhantes.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un jardín natural grande y bien cuidado. Hay una variedad de flores y plantas. Todo el lado sur está rodeado de muros y al norte hay una gran ladera rocosa. Justo en medio de este jardín se encuentra el árbol madre, gigante, vívido y con hojas brillantes.");

        locale.actions.add(ActionsIds.GATHERING_EXTRA);

        locale.npcs.add(NpcsIds.FLAVIEA);

        locale.type = Enums.LocationTypes.FOREST;
        locale.alwaysShow = false;

        locale.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, THE_FINAL_BATTLE)
                    || LibQuest.isCharacterAtQuestPart(chara, THE_FINAL_BATTLE, 5)) {
                return NOT_OK;
            }
            return OK;
        };

        return locale;
    }

    Locale elvenGardenDestroyed() {
        Locale locale = new Locale("Elven Garden", RegionsIds.AYALON);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Jardim Élfico");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Jardín Élfico");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A large, well-kept natural garden. There are a variety of flowers and plants. The entire south side is surrounded by walls and to the north there is a large rocky slope. Right in the middle of this garden was the mother tree, now destroyed by the dark powers of Casiel, the traitor.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um jardim natural amplo e bem cuidado. Há flores diversas e plantas variadas. Todo lado sul é cercado por muros e ao norte há uma grande encosta de rochas. Bem no meio deste jardim ficava a árvore-mãe, agora destruída pelos poderes sombrios de Casiel, o traidor.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un jardín natural grande y bien cuidado. Hay una variedad de flores y plantas. Todo el lado sur está rodeado de muros y al norte hay una gran ladera rocosa. Justo en medio de este jardín se encontraba el árbol madre, ahora destruido por los oscuros poderes de Casiel, el traidor.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.npcs.add(NpcsIds.FLAVIEA);

        locale.type = Enums.LocationTypes.FOREST;
        locale.imgFile = "locale_elven_garden_destroyed";
        locale.alwaysShow = false;

        locale.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, THE_FINAL_BATTLE)
                    || LibQuest.isCharacterAtQuestPart(chara, THE_FINAL_BATTLE, 5)) {
                return OK;
            }
            return NOT_OK;
        };

        locale.resetId("ELVEN_GARDEN_DESTROYED");

        return locale;
    }
}

