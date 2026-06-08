package com.cnx.endlesstalestwo.data.locations.havarusSouth;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.battles.BattlesIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.data.regions.RegionsIds;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.enums.Enums;

public class Others extends DataHelper {

    //TRADUZIR
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, woodcuttersGrove());//
        App.DataManager.add(Enums.DataTypes.LOCALE, bastianEastTrail());
        App.DataManager.add(Enums.DataTypes.LOCALE, heleraGates());//
        App.DataManager.add(Enums.DataTypes.LOCALE, havarusSouthRoad());//
        App.DataManager.add(Enums.DataTypes.LOCALE, havarusSouthShores());//
        App.DataManager.add(Enums.DataTypes.LOCALE, heleraNorthTrail());//
        App.DataManager.add(Enums.DataTypes.LOCALE, southeastHillocks());//
        App.DataManager.add(Enums.DataTypes.LOCALE, minersCaveEntrance());//
        App.DataManager.add(Enums.DataTypes.LOCALE, minersCave());//
        App.DataManager.add(Enums.DataTypes.LOCALE, minersCaveFloor1());//
        App.DataManager.add(Enums.DataTypes.LOCALE, apennaEastRoad());//
        App.DataManager.add(Enums.DataTypes.LOCALE, apennaWestRoad());//
        App.DataManager.add(Enums.DataTypes.LOCALE, bastianLake());//
    }

    Locale woodcuttersGrove() {
        Locale locale = new Locale("Woodcutters Grove", RegionsIds.HAVARUS_SOUTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Bosque dos Lenhadores");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bosque de los Leñadores");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Trees of all formats, colors and sizes. Many paths where lumberjacks walk trough the grove to work have logs on the side. You can hear the chop of axes and the birds flying away.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Árvores de todos os formatos, cores e tamanhos. Muitos caminhos onde lenhadores passam pelo bosque para trabalhar têm troncos ao lado. Você pode ouvir o som de machados e pássaros voando para longe.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Árboles de todos los formatos, colores y tamaños. Muchos caminos por donde los leñadores pasan para trabajar tienen troncos a los lados. Puedes escuchar el sonido de hachas y pájaros volando lejos.");

        locale.actions.add(ActionsIds.WOODCUTTING);
        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.possibleBattles.put(BattlesIds.GROVE_GOBLIN_2, 12);
        locale.possibleBattles.put(BattlesIds.FOREST_WOLF_1, 13);
        locale.possibleBattles.put(BattlesIds.WILD_BOAR_1, 13);

        locale.npcs.add(NpcsIds.DRIGO);

        locale.type = Enums.LocationTypes.FOREST;
        return locale;
    }

    Locale heleraGates() {
        Locale locale = new Locale("Helera Gates", RegionsIds.HAVARUS_SOUTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Portões de Helera");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Puertas de Helera");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The stone walls that surround the city have about 3 to 4 meters high. Two guards are standing in front of the big wood gate. Some other guards are patrolling the walls.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "As muralhas de pedra que cercam a cidade têm cerca de 3 a 4 metros de altura. Dois guardas estão em frente ao grande portão de madeira. Outros guardas estão patrulhando as muralhas.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Las murallas de piedra que rodean la ciudad tienen entre 3 y 4 metros de altura. Dos guardias están frente a la gran puerta de madera. Otros guardias patrullan las murallas.");

        locale.type = Enums.LocationTypes.ROAD;

        locale.places.add(LocationsIds.HELERA_WALLS);
        return locale;
    }

    Locale havarusSouthRoad() {
        Locale locale = new Locale("Havarus South Road", RegionsIds.HAVARUS_SOUTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estrada Sul de Havarus");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Camino Sur de Havarus");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A long road with many different views. You see grass and plains in the most places, but also you can look around and see an enormous forest, some villages and a city. The road have marks of wagons wheels.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma longa estrada com muitas vistas diferentes. Você vê grama e planícies na maioria dos lugares, mas também pode olhar ao redor e ver uma enorme floresta, algumas aldeias e uma cidade. A estrada tem marcas de rodas de carroças.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un largo camino con muchas vistas diferentes. Ves hierba y llanuras en la mayoría de los lugares, pero también puedes mirar alrededor y ver un enorme bosque, algunas aldeas y una ciudad. El camino tiene marcas de ruedas de carretas.");

        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);
        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.possibleBattles.put(BattlesIds.BANDIT_1, 13);
        locale.possibleBattles.put(BattlesIds.PICKPOCKETER_1, 13);


        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale minersCaveEntrance() {
        Locale locale = new Locale("Miners Cave - Entrance", RegionsIds.HAVARUS_SOUTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Entrada da Caverna dos Mineiros");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Entrada de la Cueva de los Mineros");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "You are standing in front of a hill made of rocks that have a big hole on it, naturally open. Behind and above the hill there is many trees and bushes. A wood sign indicates 'Miners Cave'.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Você está em pé na frente de uma colina feita de pedras que tem um grande buraco, naturalmente aberto. Atrás e acima da colina há muitas árvores e arbustos. Uma placa de madeira indica 'Caverna de Mineração'.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Estás parado frente a una colina hecha de rocas que tiene un gran agujero, naturalmente abierto. Detrás y encima de la colina hay muchos árboles y arbustos. Un letrero de madera indica 'Cueva de los Mineros'.");

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale minersCave() {
        Locale locale = new Locale("Miners Cave", RegionsIds.HAVARUS_SOUTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mina");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mina");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "After the entrance, you don't feel cloistered because the rock walls are high and the corridors have space enough for walking. When you walk more inside the natural light decreases but the torches on the walls illuminate enough to see well.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Após a entrada, você não se sente confinado porque as paredes de rocha são altas e os corredores têm espaço suficiente para caminhar. Quando você caminha mais para dentro, a luz natural diminui, mas as tochas nas paredes iluminam o suficiente para ver bem.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Después de la entrada, no te sientes encerrado porque las paredes de roca son altas y los corredores tienen suficiente espacio para caminar. Cuando avanzas más adentro, la luz natural disminuye, pero las antorchas en las paredes iluminan lo suficiente para ver bien.");

        locale.actions.add(ActionsIds.MINING_BASIC);

        locale.possibleBattles.put(BattlesIds.CAVE_BAT_2, 11);
        locale.possibleBattles.put(BattlesIds.BANDIT_1, 13);

        locale.type = Enums.LocationTypes.CAVERN;
        return locale;
    }

    Locale minersCaveFloor1() {
        Locale locale = new Locale("Miners Cave - Floor -1", RegionsIds.HAVARUS_SOUTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mina - Andar -1");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva de los Mineros - Piso -1");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "After climbing down the rope ladder, you are now in a central room with many chambers around. Torches generate light to see the boxes of rocks, the mining tools and the marks of pickaxes on the walls.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Após descer a escada de corda, você está agora em uma sala central com muitas câmaras ao redor. Tochas geram luz para ver as caixas de pedras, as ferramentas de mineração e as marcas de picaretas nas paredes.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Después de bajar por la escalera de cuerda, estás ahora en una sala central con muchas cámaras alrededor. Las antorchas generan luz para ver las cajas de rocas, las herramientas de minería y las marcas de picos en las paredes.");

        locale.actions.add(ActionsIds.MINING_BASIC);
        locale.actions.add(ActionsIds.MINING_EXTRA);

        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_1, 13);
        locale.possibleBattles.put(BattlesIds.SKELETON_GUARDIAN_1, 6);
        locale.possibleBattles.put(BattlesIds.CAVE_BAT_2, 12);

        locale.type = Enums.LocationTypes.CAVERN;
        return locale;
    }

    Locale southeastHillocks() {
        Locale locale = new Locale("Southeast Hillocks", RegionsIds.HAVARUS_SOUTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Colinas do Sudeste");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Colinas del Sureste");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A charmful landscape made of small hills and trees scattered around. When you climb any hillock you can see the ocean on the east. A few wild animals, like birds and deers are living in this location.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma paisagem encantadora feita de pequenas colinas e árvores espalhadas. Quando você sobe qualquer colina, pode ver o oceano ao leste. Alguns animais selvagens, como pássaros e veados, vivem neste local.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un paisaje encantador hecho de pequeñas colinas y árboles dispersos. Cuando subes a cualquier colina, puedes ver el océano al este. Algunos animales salvajes, como pájaros y ciervos, viven en este lugar.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.actions.add(ActionsIds.HUNT_BASIC);

        locale.possibleBattles.put(BattlesIds.WILD_BOAR_1, 6);

        locale.type = Enums.LocationTypes.PLAINS;
        return locale;
    }

    Locale heleraNorthTrail() {
        Locale locale = new Locale("Helera North Trail", RegionsIds.HAVARUS_SOUTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Trilha Norte de Helera");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sendero Norte de Helera");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Crossing this trail makes you observe that many fishermen pass by here to sell their fish at Helera. To east you can see a nice landscape and to west all you can see is trees.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cruzando esta trilha, você observa que muitos pescadores passam por aqui para vender seus peixes em Helera. Para o leste, você pode ver uma bela paisagem e, para o oeste, tudo o que você vê são árvores.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cruzando este sendero, observas que muchos pescadores pasan por aquí para vender sus peces en Helera. Al este puedes ver un bonito paisaje y al oeste todo lo que ves son árboles.");

        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);
        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale apennaEastRoad() {
        Locale locale = new Locale("Apenna East Road", RegionsIds.HAVARUS_SOUTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estrada Leste de Apenna");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Camino Este de Apenna");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The road is not lengthy, it is spacious and allow you to see very well the horizon. You can clearly see Apenna village and also a big city rounded by walls to the southeast.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A estrada não é longa, é espaçosa e permite que você veja muito bem o horizonte. Você pode ver claramente a aldeia de Apenna e também uma grande cidade cercada por muralhas ao sudeste.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El camino no es largo, es espacioso y te permite ver muy bien el horizonte. Puedes ver claramente la aldea de Apenna y también una gran ciudad rodeada de murallas al sureste.");

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale apennaWestRoad() {
        Locale locale = new Locale("Apenna West Road", RegionsIds.HAVARUS_SOUTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estrada Oeste de Apenna");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Camino Oeste de Apenna");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Nothing special here, a road for wagons and people naturally made between the plains that connects two villages.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Nada de especial aqui, uma estrada para carroças e pessoas naturalmente feita entre as planícies que conecta duas aldeias.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Nada especial aquí, un camino para carretas y personas naturalmente hecho entre las llanuras que conecta dos aldeas.");

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale bastianEastTrail() {
        Locale locale = new Locale("Bastian East Trail", RegionsIds.HAVARUS_SOUTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Trilha Leste de Bastian");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sendero Este de Bastian");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "this trail is narrow but not too long and have many trees on the sides. Two wagons can´t cross side by side. To east you can smell fishes and to west you can see a city.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Esta trilha é estreita, mas não muito longa, e tem muitas árvores nas laterais. Duas carroças não podem cruzar lado a lado. Para o leste, você pode sentir o cheiro de peixes e, para o oeste, você pode ver uma cidade.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Este sendero es estrecho, pero no muy largo, y tiene muchos árboles a los lados. Dos carretas no pueden cruzarse lado a lado. Al este puedes oler pescado y al oeste puedes ver una ciudad.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale havarusSouthShores() {
        Locale locale = new Locale("Havarus South Shores", RegionsIds.HAVARUS_SOUTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Costa Sul de Havarus");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Costas del Sur de Havarus");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A very large shore where the waves are calm when hit the small rocks of the beach. The ocean is at south and there is a big plains around to north. Many wild animals and just a single farm house complete this landscape.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma costa muito larga onde as ondas são calmas ao bater nas pequenas rochas da praia. O oceano está ao sul e há uma grande planície ao norte. Muitos animais selvagens e apenas uma única casa de fazenda completam esta paisagem.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una costa muy amplia donde las olas son tranquilas al golpear las pequeñas rocas de la playa. El océano está al sur y hay una gran llanura al norte. Muchos animales salvajes y solo una casa de granja completan este paisaje.");

        locale.actions.add(ActionsIds.HUNT_BASIC);
        locale.actions.add(ActionsIds.HUNT_TRAP);
        locale.actions.add(ActionsIds.FISHING_BASIC);
        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.possibleBattles.put(BattlesIds.CROCODILE_1, 15);
        locale.possibleBattles.put(BattlesIds.WILD_BOAR_1, 10);
        locale.possibleBattles.put(BattlesIds.SWASHBUCKLER_PIRATE_1, 8);

        locale.type = Enums.LocationTypes.SEA;

        locale.places.add(LocationsIds.GRIWALSH_FARM_HOUSE);
        return locale;
    }

    Locale bastianLake() {
        Locale locale = new Locale("Bastian Lake", RegionsIds.HAVARUS_SOUTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lago Bastian");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lago Bastian");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is not a very big lake but certainly is deep since the water looks dark and calm. From time to time you can notice fishes coming to shallow areas. A good nature breeze is present here.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Não é um lago muito grande, mas certamente é profundo, já que a água parece escura e calma. De vez em quando, você pode notar peixes vindo para áreas rasas. Uma brisa natural agradável está presente aqui.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "No es un lago muy grande, pero ciertamente es profundo, ya que el agua parece oscura y tranquila. De vez en cuando, puedes notar peces viniendo a áreas poco profundas. Una agradable brisa natural está presente aquí.");

        locale.actions.add(ActionsIds.FISHING_BASIC);
        locale.actions.add(ActionsIds.FISHING_EXTRA);

        locale.possibleBattles.put(BattlesIds.CROCODILE_1, 23);

        locale.npcs.add(NpcsIds.JULY);

        locale.type = Enums.LocationTypes.LAKE;
        return locale;
    }


}
