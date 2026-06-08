package com.cnx.endlesstalestwo.data.locations.wazel;

import static com.cnx.endlesstalestwo.enums.Enums.RequirementVerification.NEED_ITEMS;
import static com.cnx.endlesstalestwo.enums.Enums.RequirementVerification.NEED_KNOWLEDGES;
import static com.cnx.endlesstalestwo.enums.Enums.RequirementVerification.OK;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.battles.BattlesIds;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.knowledges.KnowledgesIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.data.regions.RegionsIds;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;

public class Others extends DataHelper {

    //TRADUZIR
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, wazelDocks());//
        App.DataManager.add(Enums.DataTypes.LOCALE, wazelWatchTower());//
        App.DataManager.add(Enums.DataTypes.LOCALE, easternSandyRoad());//
        App.DataManager.add(Enums.DataTypes.LOCALE, desertTrail());//
        App.DataManager.add(Enums.DataTypes.LOCALE, southernSandyRoad());//
        App.DataManager.add(Enums.DataTypes.LOCALE, oasis());//
        App.DataManager.add(Enums.DataTypes.LOCALE, gatesOfOrcVillage());//
        App.DataManager.add(Enums.DataTypes.LOCALE, orcVillage());//
        App.DataManager.add(Enums.DataTypes.LOCALE, desertShores());//
        App.DataManager.add(Enums.DataTypes.LOCALE, towerOfWarriosEntrance());//
        App.DataManager.add(Enums.DataTypes.LOCALE, surroundingsOfDeepCrater());//
        App.DataManager.add(Enums.DataTypes.LOCALE, deepCrater());//
        App.DataManager.add(Enums.DataTypes.LOCALE, desertCaveEntrance());//
        App.DataManager.add(Enums.DataTypes.LOCALE, desertCaveSouthSide());//
        App.DataManager.add(Enums.DataTypes.LOCALE, desertCaveLeftSide());//
        App.DataManager.add(Enums.DataTypes.LOCALE, desertCaveRightSide());//
        App.DataManager.add(Enums.DataTypes.LOCALE, desertCaveNorthSide());//
    }

    Locale wazelDocks() {
        Locale locale = new Locale("Wazel Docks", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Docas de Wazel");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Muelles de Wazel");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A simple wooden pier, a small dock and a shed built with large stones to store goods. There are a few palm trees to provide shade for the workers.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um pier simples de madeira, uma doca pequena e um galpão construído com pedras largas para guardar mercadorias. Há umas poucas palmeiras para dar uma sombra aos trabalhadores.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un simple muelle de madera, un pequeño embarcadero y un cobertizo construido con grandes piedras para almacenar mercancías. Hay algunas palmeras que proporcionan sombra a los trabajadores.");

        locale.actions.add(ActionsIds.FISHING_BASIC);

        locale.npcs.add(NpcsIds.CAPTAIN_BRADOCH);
        locale.npcs.add(NpcsIds.RADUC);

        locale.possibleBattles.put(BattlesIds.SWASHBUCKLER_PIRATE_1, 11);

        locale.type = Enums.LocationTypes.HARBOR;
        return locale;
    }

    Locale wazelWatchTower() {
        Locale locale = new Locale("Wazel Watch Tower", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Torre de Vigia de Wazel");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Torre de Vigilancia de Wazel");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The tower is small, built of palm logs and planks. One side of the top is open and in the center there is a space for a fire, probably used to light up at night and warn ships that this is the port of Wazel. There is good visibility from the sea.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A torre é pequena, construída com toras de palmeira e tábuas. Um dos lados da parte superior é açada e no centro há um espaço para fazer uma fogueira, provavelmente usada para iluminar durante a noite e avisar aos navios que aqui fica o porto de Wazel. Há uma boa visibilidade do mar.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La torre es pequeña, construida con troncos de palmera y tablones. Un lado de la parte superior está abierto y en el centro hay un espacio para una fogata, probablemente usado para iluminar por la noche y advertir a los barcos que este es el puerto de Wazel. Hay buena visibilidad del mar.");

        locale.npcs.add(NpcsIds.KATIUSCA);

        locale.type = Enums.LocationTypes.TOWER;

        return locale;
    }

    Locale easternSandyRoad() {
        Locale locale = new Locale("Eastern Sandy Road", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estrada Arenosa Oriental");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Camino Arenoso del Este");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A stretch of path through sand and low dunes. The constant sun causes excessive heat and you have to close your eyes to avoid the glare and reflected light. There is very little vegetation along this stretch. You can see a small hill to the east.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um trecho de caminho em meio as areias e dunas baixas. O sol constante causa um calor excessivo e é preciso cerrar os olhos para evitar a claridade e a luz que reflete. Há pouquíssima vegetação neste trecho. É possível ver uma pequena colina á leste.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un tramo de camino a través de arena y dunas bajas. El sol constante causa un calor excesivo y hay que cerrar los ojos para evitar el resplandor y la luz reflejada. Hay muy poca vegetación en este tramo. Se puede ver una pequeña colina al este.");

        locale.possibleBattles.put(BattlesIds.SAND_GOLEM_1, 14);
        locale.possibleBattles.put(BattlesIds.DESERT_SCORPION_1, 13);
        locale.possibleBattles.put(BattlesIds.LION_1, 12);

        locale.type = Enums.LocationTypes.ROAD;

        return locale;
    }

    Locale desertTrail() {
        Locale locale = new Locale("Desert Trail", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Trilha do Deserto");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sendero del Desierto");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Sun, heat and sand are what define this landscape, which is cut through by a dirt road. The heat leaves you breathless and you have to cover your face frequently to avoid the sand. There are almost no palm trees or cacti along the entire long route.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sol, calor e areia é o que definem esta paisagem que é cortada por uma rua de tierra batida. O calor te deixa ofegante e é preciso cobrir o rosto com frequência para evitar a areia. Quase não há palmeiras nem cactus durante todo o longo percurso.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sol, calor y arena definen este paisaje, atravesado por un camino de tierra. El calor te deja sin aliento y hay que cubrirse la cara con frecuencia para evitar la arena. Casi no hay palmeras o cactus a lo largo de todo el largo recorrido.");

        locale.possibleBattles.put(BattlesIds.SAND_GOLEM_1, 15);
        locale.possibleBattles.put(BattlesIds.DESERT_SCORPION_1, 14);
        locale.possibleBattles.put(BattlesIds.LION_1, 13);

        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);

        locale.type = Enums.LocationTypes.ROAD;

        return locale;
    }

    Locale southernSandyRoad() {
        Locale locale = new Locale("Southern Sandy Road", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estrada Arenosa do Sul");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Camino Arenoso del Sur");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A short stretch of road surrounded by sand. There are almost no dunes here. A few palm trees, rocks and cacti are all the flora present. There is an oasis further ahead that attracts some animals and people. Far away, at the end of the road, it is possible to see some kind of settlement.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um trecho de estrada não muito longo cercado de areia. Não há quase nenhuma duna aqui. Algumas palmeiras, pedras e cactus são toda a flora presente. Há um oásis mais a frente que atrai alguns animais e pessoas. Longe, no fim do caminho é possível ver algum tipo de assentamento.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un corto tramo de camino rodeado de arena. Aquí casi no hay dunas. Algunas palmeras, rocas y cactus son toda la flora presente. Hay un oasis más adelante que atrae a algunos animales y personas. Al final del camino, se puede ver algún tipo de asentamiento.");

        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);

        locale.type = Enums.LocationTypes.ROAD;

        return locale;
    }

    Locale oasis() {
        Locale locale = new Locale("Oasis", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Oásis");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Oasis");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "In the middle of the desert, this small lake surrounded by small bushes and some palm trees, makes this place look like a relaxing paradise. Some wildlife is present and the water looks clean.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Em meio ao deserto, este pequeno lago cercado com pequenos arbustos e algumas palmeiras, fazem este local parecer um paraíso de descanso. Alguma vida selvagem está presente e a água parece limpa.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En medio del desierto, este pequeño lago rodeado de arbustos y algunas palmeras hace que este lugar parezca un paraíso relajante. Hay algo de vida silvestre y el agua parece limpia.");

        locale.actions.add(ActionsIds.FISHING_BASIC);
        locale.actions.add(ActionsIds.HUNT_TRAP);

        locale.possibleBattles.put(BattlesIds.CROCODILE_1, 18);
        locale.possibleBattles.put(BattlesIds.DESERT_SCORPION_1, 12);
        locale.possibleBattles.put(BattlesIds.LION_1, 15);

        locale.npcs.add(NpcsIds.ZANICA);

        locale.type = Enums.LocationTypes.LAKE;

        return locale;
    }

    Locale gatesOfOrcVillage() {
        Locale locale = new Locale("Gates of Orc Village", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Portões da Vila dos Orcs");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Puertas de la Aldea Orca");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A large archway of rocks between a log palisade forms the entrance to this large orc camp. There are a number of skulls and symbols hanging from it, along with torches stuck into the ground.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um grande arco de rochas entre uma paliçada de toras formam a entrada deste grande acampamento orc. Há algumas caveiras e símbolos pendurados juntamente com tochas cravadas ao chão.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un gran arco de rocas entre una empalizada de troncos forma la entrada a este gran campamento orco. Hay varios cráneos y símbolos colgando, junto con antorchas clavadas en el suelo.");

        locale.possibleBattles.put(BattlesIds.ORC_BATTLER_1, 18);
        locale.possibleBattles.put(BattlesIds.ORC_PEASANT_1, 16);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale orcVillage() {
        Locale locale = new Locale("Orc Village", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Vila dos Orcs");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aldea Orca");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "As you enter the orc village, you realize the danger. If you don't hide, you will have to face the fearsome orcs. The huts are made of leather and dried palm leaves. There are wooden symbols and statues. There is also a large bonfire and a larger hut made of logs.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ao adentrar a vila dos orcs, você percebe o perigo. Se não se esconder terá que enfrentar os temidos orcs. As cabanas são feitas de couro e folhas secas de palmeira. Há simbolos e estátuas de madiera. Há também uma grande fogueira e uma cabana maior feita de toras.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Al entrar en la aldea orca, te das cuenta del peligro. Si no te escondes, tendrás que enfrentarte a los temibles orcos. Las cabañas están hechas de cuero y hojas secas de palmera. Hay símbolos y estatuas de madera. También hay una gran fogata y una cabaña más grande hecha de troncos.");

        locale.possibleBattles.put(BattlesIds.ORC_BATTLER_2, 22);
        locale.possibleBattles.put(BattlesIds.ORC_MASTER_1, 16);
        locale.possibleBattles.put(BattlesIds.ORC_BATTLER_1, 15);

        locale.npcs.add(NpcsIds.KORZK);

        locale.type = Enums.LocationTypes.VILLAGE;
        return locale;
    }

    Locale desertShores() {
        Locale locale = new Locale("Desert Shores", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Praia do Deserto");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Orillas del Desierto");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "As you descend the dunes, the huge sea appears with its long waves and the sea air brings some relief from the extreme heat of the sun. The beach has very yellow sand with some rocks and a few palm trees.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ao descer as dunas o enorme mar surge com suas ondas compridas e a maresia traz um certo alívio para o calor extremo do sol. A praia tem areia bem amarela com algumas pedras e poucas palmeiras.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Al bajar las dunas, aparece el enorme mar con sus largas olas y la brisa marina trae un poco de alivio al calor extremo del sol. La playa tiene arena muy amarilla con algunas rocas y pocas palmeras.");

        locale.possibleBattles.put(BattlesIds.SAND_GOLEM_1, 18);
        locale.possibleBattles.put(BattlesIds.CROCODILE_1, 18);
        locale.possibleBattles.put(BattlesIds.LION_1, 15);
        locale.possibleBattles.put(BattlesIds.TORMENT_PIRATE_1, 15);
        locale.possibleBattles.put(BattlesIds.SWASHBUCKLER_PIRATE_1, 15);

        locale.actions.add(ActionsIds.FISHING_BASIC);
        locale.actions.add(ActionsIds.FISHING_EXTRA);
        locale.type = Enums.LocationTypes.SEA;
        return locale;
    }

    Locale towerOfWarriosEntrance() {
        Locale locale = new Locale("Tower Of Warriors - Entrance", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Torre dos Guerreiros - Entrada");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Torre de los Guerreros - Entrada");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Standing right in front of the entrance door, it is impossible to see the rounded top of the tower. Large stones form the circular construction with its observation top made of wood. This is the base of the warriors' guild.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estando parado logo em frente a porta de entrada, é impossível ver o topo arrendondado da torre. Pedras largas formam a construção circular que tem o seu topo de observação feito de madeira. Aqui é a base da guilda dos guerreiros.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "De pie frente a la puerta de entrada, es imposible ver la parte superior redondeada de la torre. Grandes piedras forman la construcción circular con su parte superior de observación hecha de madera. Esta es la base del gremio de guerreros.");

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale surroundingsOfDeepCrater() {
        Locale locale = new Locale("Surroundings of Deep Crater", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Arredores da Cratera Profunda");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Alrededores del Cráter Profundo");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A huge hole in the middle of the desert, one false step and you would fall about 80 meters. The diameter of this crater is quite large and when looking at the bottom you can see some rocks and a cave entrance.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um enorme buraco em meio ao deserto, um passo em falso e você despencaria uns 80 metros. O diâmetro dessa cratera é bem grande e ao olhar para o fundo é possível notar algumas rochas e uma entrada de caverna.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un enorme agujero en medio del desierto, un paso en falso y caerías unos 80 metros. El diámetro de este cráter es bastante grande y al mirar al fondo se pueden ver algunas rocas y una entrada a una cueva.");

        locale.possibleBattles.put(BattlesIds.DESERT_SCORPION_1, 19);
        locale.possibleBattles.put(BattlesIds.LION_1, 9);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale deepCrater() {
        Locale locale = new Locale("Deep Crater", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cratera Profunda");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cráter Profundo");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "After a long descent through cracks and rocks, you reached the bottom, where the ground is rocky but flat. Even though the sun is still shining, it is cooler and darker here. There is a hole in one of the walls that seems to lead to a cave.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Depois de uma enorme descida pelas fendas e rochas você chegou ao fundo, onde o chão é pedregoso porém plano. Mesmo com o sol ainda iluminando, aqui é mais fresco e escuro. Há um buraco em uma das paredes que parece levar para uma caverna.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Después de un largo descenso por grietas y rocas, llegaste al fondo, donde el suelo es rocoso pero plano. Aunque el sol sigue brillando, aquí es más fresco y oscuro. Hay un agujero en una de las paredes que parece llevar a una cueva.");


        locale.actions.add(ActionsIds.MINING_BASIC);
        locale.type = Enums.LocationTypes.CAVERN;
        locale.requirementValidations = (chara, ctx) -> {
            if (!chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return NEED_KNOWLEDGES;
            }
            if (!LibInventory.checkHasItem(ItemsIds.ROPE, chara)) {
                return NEED_ITEMS;
            }
            return OK;
        };

        locale.possibleBattles.put(BattlesIds.SAND_GOLEM_1, 15);
        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_1, 16);
        locale.possibleBattles.put(BattlesIds.DESERT_SCORPION_1, 16);

        return locale;
    }

    Locale desertCaveEntrance() {
        Locale locale = new Locale("Desert Cavern - Entrance", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna do Deserto - Entrada");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Caverna del Desierto - Entrada");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Amidst the sand dunes is a hill of rocks with a small opening that clearly leads into the hills and dunes. Beside the entrance is a single tree.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Em meio as dunas de areia há um morro de rochas com uma pequena abertura que claramente leva para dentro dos morros e dunas. Ao lado da entrada há uma única árvore.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En medio de las dunas de arena hay una colina de rocas con una pequeña abertura que claramente conduce al interior de las colinas y dunas. Junto a la entrada hay un único árbol.");

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale desertCaveSouthSide() {
        Locale locale = new Locale("Desert Cavern - South Side", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna do Deserto - Lado Sul");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Caverna del Desierto - Lado Sur");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Upon entering, you notice that the floor is full of white sand and some small rocks. The walls are made of calcified sand rock. There are two corridors at the end of the chamber, one to the left and one to the right. It is not possible to see what is there because there is no natural light.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ao entrar você percebe que o chão é cheio de areia branca e algumas rochas pequenas. As paredes são de rocha de areia calcificada. Há dois corredores ao final da câmara, um para esquerda e outro para direita, não é possível ver o que há lá pois não há iluminação natural.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Al entrar, notas que el suelo está lleno de arena blanca y algunas rocas pequeñas. Las paredes son de roca de arena calcificada. Hay dos corredores al final de la cámara, uno a la izquierda y otro a la derecha. No es posible ver qué hay allí porque no hay luz natural.");

        locale.actions.add(ActionsIds.MINING_BASIC);
        locale.type = Enums.LocationTypes.CAVERN;

        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_1, 15);
        locale.possibleBattles.put(BattlesIds.DESERT_SCORPION_1, 15);

        return locale;
    }

    Locale desertCaveLeftSide() {
        Locale locale = new Locale("Desert Cavern - Left Side", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna do Deserto - Lado Esquerdo");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Caverna del Desierto - Lado Izquierdo");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "At the end of the corridor you arrive at this chamber which is wide and dark. The floor is still sandy, but the walls already have some stalagmites in addition to the rocks. There are some bats on the ceiling and scorpions in the corners.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ao fim do corredor você chega nesta câmara que é ampla e escura. O solo ainda é arenoso, mas as paredes já possuem algumas estalagmites além das rochas. Há alguns morcegos no teto e escorpiões nos cantos.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Al final del corredor llegas a esta cámara que es amplia y oscura. El suelo sigue siendo arenoso, pero las paredes ya tienen algunas estalagmitas además de las rocas. Hay algunos murciélagos en el techo y escorpiones en las esquinas.");

        locale.actions.add(ActionsIds.MINING_BASIC);
        locale.type = Enums.LocationTypes.CAVERN;
        locale.requirementValidations = (chara, ctx) -> {
            if (!LibInventory.checkHasItem(ItemsIds.TORCH, chara)) {
                return NEED_ITEMS;
            }
            return OK;
        };

        locale.possibleBattles.put(BattlesIds.SAND_GOLEM_1, 15);
        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_1, 15);
        locale.possibleBattles.put(BattlesIds.DESERT_SCORPION_1, 18);
        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_2, 15);

        return locale;
    }

    Locale desertCaveRightSide() {
        Locale locale = new Locale("Desert Cavern - Right Side", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna do Deserto - Lado Direito");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Caverna del Desierto - Lado Derecho");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "At the end of the corridor you reach this chamber, which is long and narrow. The floor is still sandy, but the walls already have some stalagmites in addition to the rocks. There is some moisture on the rocks on the right side, probably from the proximity to the sea outside.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ao fim do corredor você chega nesta câmara que é comprida e estreita. O solo ainda é arenoso, mas as paredes já possuem algumas estalagmites além das rochas. Nas rochas do lado direito há um pouco de umidade, provavelmente proveniente da proximidade com o mar do lado externo.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Al final del corredor llegas a esta cámara que es larga y estrecha. El suelo sigue siendo arenoso, pero las paredes ya tienen algunas estalagmitas además de las rocas. Hay algo de humedad en las rocas del lado derecho, probablemente por la proximidad al mar exterior.");

        locale.actions.add(ActionsIds.MINING_BASIC);
        locale.type = Enums.LocationTypes.CAVERN;
        locale.requirementValidations = (chara, ctx) -> {
            if (!LibInventory.checkHasItem(ItemsIds.TORCH, chara)) {
                return NEED_ITEMS;
            }
            return OK;
        };

        locale.possibleBattles.put(BattlesIds.SAND_GOLEM_1, 15);
        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_1, 15);
        locale.possibleBattles.put(BattlesIds.DESERT_SCORPION_1, 18);
        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_2, 15);

        return locale;
    }

    Locale desertCaveNorthSide() {
        Locale locale = new Locale("Desert Cavern - North Side", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna do Deserto - Lado Norte");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Caverna del Desierto - Lado Norte");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "In this deepest chamber of the cave, there is a small crack at the top that allows some light from outside. There is a small pool of water that must have formed from the rare times that it rains in the region. The rocks on the walls are less sandy and the environment is wider. It seems like a good place to mine for some gemstones.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Nesta câmara mais profunda da caverna, há uma pequena fenda na parte superior que permite um pouco de luz externa. Há uma pequena poça de água que deve ter se formado com as poucas vezes que chove na região. As rochas das paredes são menos arenosas e o ambiente é mais amplo. Parece um bom local para minerar algumas pedras preciosas.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En esta cámara más profunda de la cueva, hay una pequeña grieta en la parte superior que permite algo de luz exterior. Hay un pequeño charco de agua que debe haberse formado en las raras veces que llueve en la región. Las rocas de las paredes son menos arenosas y el ambiente es más amplio. Parece un buen lugar para extraer algunas piedras preciosas.");

        locale.actions.add(ActionsIds.MINING_RARE);
        locale.type = Enums.LocationTypes.CAVERN;
        locale.requirementValidations = (chara, ctx) -> {
            if (!LibInventory.checkHasItem(ItemsIds.TORCH, chara)) {
                return NEED_ITEMS;
            }
            return OK;
        };

        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_1, 11);
        locale.possibleBattles.put(BattlesIds.MEDUSA_1, 14);
        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_2, 20);
        locale.possibleBattles.put(BattlesIds.SAND_GOLEM_1, 30);
        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_FIRE_1, 27);

        return locale;
    }
}

