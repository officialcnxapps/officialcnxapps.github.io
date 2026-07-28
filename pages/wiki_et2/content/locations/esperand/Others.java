package com.cnx.endlesstalestwo.data.locations.esperand;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.battles.BattlesIds;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.knowledges.KnowledgesIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.regions.RegionsIds;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Others extends DataHelper {

    //TRADUZIR
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, esperandHarbor());//
        App.DataManager.add(Enums.DataTypes.LOCALE, winterGrove());//
        App.DataManager.add(Enums.DataTypes.LOCALE, esperandMainRoad());//
        App.DataManager.add(Enums.DataTypes.LOCALE, esperandWatchTowerEntrance());//
        App.DataManager.add(Enums.DataTypes.LOCALE, frozenWestTrail());//
        App.DataManager.add(Enums.DataTypes.LOCALE, surroundingsOfBarbarianSettlement());//
        App.DataManager.add(Enums.DataTypes.LOCALE, baarbarianSettlement());//
        App.DataManager.add(Enums.DataTypes.LOCALE, surroundingsOfIceMountains());//
        App.DataManager.add(Enums.DataTypes.LOCALE, iceMountainLevel1());//
        App.DataManager.add(Enums.DataTypes.LOCALE, iceMountainLevel2());//
        App.DataManager.add(Enums.DataTypes.LOCALE, iceMountainPeak());//
        App.DataManager.add(Enums.DataTypes.LOCALE, monasteryRoad());//
        App.DataManager.add(Enums.DataTypes.LOCALE, monasteryGates());//
        App.DataManager.add(Enums.DataTypes.LOCALE, monasteryGarden());//
        App.DataManager.add(Enums.DataTypes.LOCALE, frozenLake());//
        App.DataManager.add(Enums.DataTypes.LOCALE, icyCaveEntrance());//
        App.DataManager.add(Enums.DataTypes.LOCALE, icyCave());//
        App.DataManager.add(Enums.DataTypes.LOCALE, icyCaveFloor1());//
        App.DataManager.add(Enums.DataTypes.LOCALE, icyCaveFloor2());//
    }

    Locale esperandHarbor() {
        Locale locale = new Locale("Esperand Harbor", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Porto de Esperand");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Puerto de Esperand");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The wind here is freezing specially in the pier. The harbor is simple: a dock that can serve one ship at a time. A warehouse made of planks, a small watch tower and a house that is always blowing smoke out of the chimney.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O vento aqui é congelante, especialmente no cais. O porto é simples: uma doca que pode servir a um navio de cada vez. Um armazém feito de tábuas, uma pequena torre de vigia e uma casa que está sempre a expelir fumo pela chaminé.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El viento aquí es helado, especialmente en el muelle. El puerto es simple: un muelle que puede servir a un barco a la vez. Un almacén hecho de tablones, una pequeña torre de vigilancia y una casa que siempre está echando humo por la chimenea.");

        locale.actions.add(ActionsIds.FISHING_EXTRA);

        locale.npcs.add(NpcsIds.CAPTAIN_PHILIPSON);
        locale.npcs.add(NpcsIds.CAPTAIN_LUKAS_AT_ESPERAND);

        locale.possibleBattles.put(BattlesIds.OCTUMAN_1, 100);

        locale.type = Enums.LocationTypes.HARBOR;
        return locale;
    }

    Locale winterGrove() {
        Locale locale = new Locale("Winter Grove", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Bosque Invernal");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bosque Invernal");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "There is a bunch of trees and rocks, you cannot define their colors because they are almost buried by snow. There is some tall grass that are frozen and obstruct the view. The wild life in this grove is scarce.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Há um monte de árvores e rochas, não é possível definir as suas cores porque estão quase soterradas pela neve. Há alguma erva alta que está congelada e obstrui a visão. A vida selvagem neste bosque é escassa.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hay un montón de árboles y rocas, no se pueden definir sus colores porque están casi enterrados por la nieve. Hay un poco de hierba alta que está congelada y obstruye la vista. La vida salvaje en este bosque es escasa.");

        locale.actions.add(ActionsIds.HUNT_BASIC);
        locale.actions.add(ActionsIds.WOODCUTTING);

        locale.possibleBattles.put(BattlesIds.ICE_GOLEM_1, 8);
        locale.possibleBattles.put(BattlesIds.FROST_WRAITH_1, 8);
        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_AIR_1, 10);

        locale.type = Enums.LocationTypes.FOREST;

        return locale;
    }

    Locale esperandMainRoad() {
        Locale locale = new Locale("Main Road", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estrada Principal");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carretera Principal");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The landscape is like an endless white carpet. From time to time you see some trees and bushes. All you can do is to follow the road made by wagons and people to avoid sinking your feet into the snow. The snow falls slowly and lightly and far away on the horizon to the north it is possible to see a small light that seems to come from torches in a city.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A paisagem é como um tapete branco sem fim. De vez em quando você vê algumas árvores e arbustos. Tudo o que você pode fazer é seguir a estrada feita por carroças e pessoas para evitar afundar os pés na neve. A neve cai lenta e levemente e, ao longe, no horizonte, ao norte, é possível ver uma pequena luz que parece vir de tochas em uma cidade.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El paisaje es como una alfombra blanca sin fin. De vez en cuando se ven algunos árboles y arbustos. Todo lo que puedes hacer es seguir el camino hecho por carros y personas para evitar que tus pies se hundan en la nieve. La nieve cae lenta y ligeramente y a lo lejos en el horizonte hacia el norte es posible ver una pequeña luz que parece provenir de antorchas en una ciudad.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.imgFile = "locale_esperand_main_road";

        locale.resetId("ESPERAND_MAIN_ROAD");

        locale.npcs.add(NpcsIds.A_SPIRIT);

        locale.possibleBattles.put(BattlesIds.PICKPOCKETER_1, 14);
        locale.possibleBattles.put(BattlesIds.BANDIT_2, 12);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale esperandWatchTowerEntrance() {
        Locale locale = new Locale("Watch Tower - Entrance", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Torre de Vigia - Entrada");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Torre de Vigilancia - Entrada");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A high building with a differentiated architecture, its appearance is like a long triangular hut made of logs. Some blue and orange flags are hanging on the walls.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um prédio alto com uma arquitetura diferenciada, sua aparência é como uma longa cabana triangular feita de toras. Algumas bandeiras azuis e laranjas estão penduradas nas paredes.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un edificio alto con una arquitectura diferenciada, su apariencia es como una larga cabaña triangular hecha de troncos. Algunas banderas azules y naranjas están colgadas en las paredes.");

        locale.type = Enums.LocationTypes.ROAD;
        locale.imgFile = "locale_esperand_watch_tower_entrance";

        locale.resetId("ESPERAND_WATCH_TOWER_ENTRANCE");

        locale.places.add(LocationsIds.ESPERAND_WATCH_TOWER);

        return locale;
    }

    Locale frozenWestTrail() {
        Locale locale = new Locale("Frozen West Trail", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Trilha Congelada do Oeste");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sendero Helado del Oeste");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Following this road, it is easy to see the icy mountains to the west and the city to the east. The stretch is not that long, but it is difficult to walk due to the deeper snow and the cutting wind hitting your face.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Seguindo por esta estrada é fácil ver as montanhas gélidas ao oeste e a cidade a leste. O trecho não é tão longo, mas é difícil caminhar devido a neve mais funda e o vento cortante a bater no rosto.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Siguiendo por este camino, es fácil ver las montañas heladas al oeste y la ciudad al este. El tramo no es tan largo, pero es difícil caminar debido a la nieve más profunda y al viento cortante que golpea tu cara.");

        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);

        locale.npcs.add(NpcsIds.FATHER_BARNABAS);

        locale.possibleBattles.put(BattlesIds.PICKPOCKETER_1, 14);
        locale.possibleBattles.put(BattlesIds.FROST_WRAITH_1, 6);
        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_AIR_1, 10);

        locale.type = Enums.LocationTypes.ROAD;

        return locale;
    }

    Locale surroundingsOfBarbarianSettlement() {
        Locale locale = new Locale("Surroundings of Barbarian Sett.", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Arredores do Acampamento Bárbaro");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Alrededores del Asentamiento Bárbaro");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The camp is not fenced but has several barricades made of wooden crates and spears. Some skulls and flags make it clear that the barbarians live here and do not want company. It is possible to see bonfires and movement further ahead.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O acampamento não é cercado mas possui várias barricadas feitas com caixotes e lanças de madeira. Algumas caveiras e bandeiras deixam claro que os bárbaros moram aqui e não querem companhia. è possível ver fogueiras e movimentação mais a frente.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El campamento no está cercado, pero tiene varias barricadas hechas de cajas de madera y lanzas. Algunas calaveras y banderas dejan en claro que los bárbaros viven aquí y no quieren compañía. Es posible ver fogatas y movimiento más adelante.");

        locale.type = Enums.LocationTypes.ROAD;

        locale.possibleBattles.put(BattlesIds.BARBARIAN_1, 16);


        locale.resetId("SURROUNDINGS_OF_BARBARIAN_SETTLEMENT");
        locale.imgFile = "locale_surroundings_of_barbarian_sett";

        return locale;
    }

    Locale baarbarianSettlement() {
        Locale locale = new Locale("Barbarian Settlement", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Acampamento Bárbaro");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Asentamiento Bárbaro");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "You find yourself surrounded by symbols, skulls, flags, totems and huts made of leather, bones and fabrics. The place is clearly dangerous as the barbarians surround you easily.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Você se ve cercado por símbolos, caveiras, bandeiras, totens e cabanas feitas com couro, ossos e tecidos. O local é claramente perigoso visto que os bárbaros lhe cercam facilmente. ");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Te encuentras rodeado de símbolos, calaveras, banderas, tótems y cabañas hechas de cuero, huesos y telas. El lugar es claramente peligroso ya que los bárbaros te rodean fácilmente.");

        locale.npcs.add(NpcsIds.CRADUL);

        locale.possibleBattles.put(BattlesIds.BARBARIAN_1, 30);
        locale.possibleBattles.put(BattlesIds.BARBARIAN_2, 11);

        locale.type = Enums.LocationTypes.VILLAGE;
        return locale;
    }

    Locale surroundingsOfIceMountains() {
        Locale locale = new Locale("Surroundings of Ice Mountains", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Arredores das Montanhas de Gelo");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Alrededores de las Montañas de Hielo");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "You are very close to the gigantic mountain of snow and ice. The terrain is already steep but it is still possible to climb without special equipment. Climbing this mountain of ice must be very difficult, especially with so much wind.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Você está bem próximo da gigantesca montanha de neve e gelo. O terreno já é íngreme mas ainda é possível subir sem equipamente especial. Escalar este monte de gelo deve ser muito díficil, ainda mais com tanto vento. ");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Estás muy cerca de la gigantesca montaña de nieve y hielo. El terreno ya es empinado pero aún es posible escalar sin equipo especial. Escalar esta montaña de hielo debe ser muy difícil, especialmente con tanto viento.");

        locale.type = Enums.LocationTypes.ROAD;

        return locale;
    }

    Locale iceMountainLevel1() {
        Locale locale = new Locale("Ice Mountains - Level 1", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Montanhas de Gelo - Nível 1");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Montañas de Hielo - Nivel 1");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "After a difficult climb you reach a flatter and higher point on the mountain. The air is freezing and the height is already a bit scary. Here there are still some rocks visible but most of the things are covered in frozen snow.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Depois de uma escalada complicada você chega até um ponto mais plano e elevado na montanha. O ar é congelante e a altura já é um pouco assustadora. Aqui ainda há algumas pedras visíveis mas a maioria das coisas está coberta de neve congelada.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Después de una escalada difícil llegas a un punto más plano y alto en la montaña. El aire es helado y la altura ya da un poco de miedo. Aquí todavía hay algunas rocas visibles, pero la mayoría de las cosas están cubiertas de nieve congelada.");

        locale.actions.add(ActionsIds.MINING_BASIC);
        locale.possibleBattles.put(BattlesIds.ICE_GOLEM_1, 22);
        locale.possibleBattles.put(BattlesIds.FROST_WRAITH_1, 13);
        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_AIR_1, 13);

        locale.requirementValidations = (chara, ctx) -> {
            if (chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.OK;
            } else {
                return Enums.RequirementVerification.NEED_KNOWLEDGES;
            }
        };

        locale.alwaysShow = true;
        locale.type = Enums.LocationTypes.MOUNTAIN;

        return locale;
    }

    Locale iceMountainLevel2() {
        Locale locale = new Locale("Ice Mountains - Level 2", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Montanhas de Gelo - Nível 2");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Montañas de Hielo - Nivel 2");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "At this altitude, it is impossible to stand still without freezing. The wind is strong and all you see is snow and ice. There are some small openings in the rocks of the mountain that probably serve as nests for creatures.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Nesta altitude é impossível ficar parado sem congelar. O vento é forte e tudo que se vê é neve e gelo. Há algumas pequenas aberturas nas pedras da montanha que provavelmente servem como ninho de criaturas.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "A esta altitud, es imposible quedarse quieto sin congelarse. El viento es fuerte y todo lo que se ve es nieve y hielo. Hay algunas pequeñas aberturas en las rocas de la montaña que probablemente sirven como nidos para las criaturas.");

        locale.type = Enums.LocationTypes.MOUNTAIN;

        locale.possibleBattles.put(BattlesIds.ICE_GOLEM_1, 26);
        locale.possibleBattles.put(BattlesIds.FROST_WRAITH_1, 18);
        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_AIR_1, 15);

        locale.requirementValidations = (chara, ctx) -> {
            if (chara.hasKnowledge(KnowledgesIds.CLIMBING) && LibInventory.checkHasItem(ItemsIds.ROPE, chara)) {
                return Enums.RequirementVerification.OK;
            } else if (!LibInventory.checkHasItem(ItemsIds.ROPE, chara)) {
                return Enums.RequirementVerification.NEED_ITEMS;
            } else {
                return Enums.RequirementVerification.NEED_KNOWLEDGES;
            }
        };

        locale.alwaysShow = true;

        return locale;
    }

    Locale iceMountainPeak() {
        Locale locale = new Locale("Ice Mountains - Peak", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Montanhas de Gelo - Pico");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Montañas de Hielo - Pico");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Getting to the top was tough. The view would have been beautiful if it weren't for the fog and snow getting in the way. The air is thin and extremely freezing. There's very little space here, but you can see that some creature inhabits the place from time to time.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Chegar até o topo foi árduo. A vista poderia ser linda se não fosse a névoa e a neve atrapalhando. O ar é rarefeito e extremamente congelante. Há pouco espaço aqui, mas percebe-se que alguma criatura habita o lugar de vez em quando.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Llegar a la cima fue difícil. La vista habría sido hermosa si no fuera por la niebla y la nieve que se interponían en el camino. El aire es delgado y extremadamente helado. Hay muy poco espacio aquí, pero se puede ver que alguna criatura habita el lugar de vez en cuando.");

        locale.possibleBattles.put(BattlesIds.FROST_WRAITH_1, 22);
        locale.possibleBattles.put(BattlesIds.ICE_GOLEM_1, 18);
        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_AIR_1, 16);

        if ((LibQuest.charHasQuest(QuestsIds.BLOOD_WITH_BLOOD, App.getPlayerChar())
                || LibQuest.charHasQuest(QuestsIds.DRAGON_FEAR, App.getPlayerChar()))
                && !LibQuest.isQuestComplete(App.getPlayerChar(), QuestsIds.DRAGON_FEAR)) {
            locale.possibleBattles.put(BattlesIds.ICE_DRAGON_1, 20);
        }

        locale.requirementValidations = (chara, ctx) -> {
            if (chara.hasKnowledge(KnowledgesIds.CLIMBING) && LibInventory.checkHasItem(ItemsIds.ROPE, chara)) {
                return Enums.RequirementVerification.OK;
            } else if (!LibInventory.checkHasItem(ItemsIds.ROPE, chara)) {
                return Enums.RequirementVerification.NEED_ITEMS;
            } else {
                return Enums.RequirementVerification.NEED_KNOWLEDGES;
            }
        };

        locale.alwaysShow = true;

        locale.type = Enums.LocationTypes.MOUNTAIN;

        return locale;
    }

    Locale monasteryRoad() {
        Locale locale = new Locale("Monastery Road", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estrada do Mosteiro");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Camino del Monasterio");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The road is long and straight, from north to south all you can see is snow and a few tall pine trees. The route is little used, but as it is a freight route between the city and the monastery, the road is marked by carts.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O caminho é comprido e reto, de norte a sul tudo que se vê é neve e alguns pinheiros mais altos. A rota é pouco usada, mas por ser uma rota de cargas entre a cidade e o mosteiro, a estrada ficou marcada pelas carroças.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El camino es largo y recto, de norte a sur todo lo que se puede ver es nieve y algunos pinos altos. La ruta es poco utilizada, pero como es una ruta de carga entre la ciudad y el monasterio, el camino está marcado por carros.");

        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);
        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.possibleBattles.put(BattlesIds.BANDIT_2, 18);
        locale.possibleBattles.put(BattlesIds.CORRUPTED_WIZARD_1, 15);

        locale.type = Enums.LocationTypes.ROAD;

        return locale;
    }

    Locale monasteryGates() {
        Locale locale = new Locale("Monastery Gates", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Portões do Mosteiro");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Puertas del Monasterio");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The monastery is surrounded by not very high walls. The entrance gate is made of planks and reinforced with iron. There is only one guard who acts as a doorman. The monastery is a beautiful building in the Gothic style.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O mosteiro é cercado por muros não muito altos. O portão de entrada é feito de tábuas e reforçado com ferro. Há apenas um guarda que atua como um porteiro. O mosteiro é uma bela construção com estilo gótico.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El monasterio está rodeado por muros no muy altos. La puerta de entrada está hecha de tablones y reforzada con hierro. Solo hay un guardia que actúa como portero. El monasterio es un hermoso edificio de estilo gótico.");

        locale.type = Enums.LocationTypes.ROAD;

        return locale;
    }

    Locale monasteryGarden() {
        Locale locale = new Locale("Monastery Garden", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Jardim do Mosteiro");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Jardín del Monasterio");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The garden is large and has a small lake made of stones with frozen water. There are no flowers, only trees, as they would not withstand the cold. The accommodations are all around the garden with some corridors surrounded by pillars.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O jardim é amplo e conta com um pequeno lago feito com pedras com água congelada. Não há flores, apenas árvores, pois elas não resistiriam ao frio. Os alojamentos estão por toda a volta do jardim com alguns corredores cercados de pilares.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El jardín es grande y tiene un pequeño lago hecho de piedras con agua congelada. No hay flores, solo árboles, ya que no resistirían el frío. Los alojamientos están alrededor del jardín con algunos pasillos rodeados de pilares.");

        locale.actions.add(ActionsIds.HELP_PEOPLE);

        locale.places.add(LocationsIds.MONASTERY_ROOMS);

        locale.npcs.add(NpcsIds.GODMAN);
        locale.npcs.add(NpcsIds.BROTHER_MORDIUS);

        locale.type = Enums.LocationTypes.VILLAGE;
        return locale;
    }

    Locale frozenLake() {
        Locale locale = new Locale("Frozen Lake", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lago Congelado");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lago Congelado");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The lake is not huge and due to the cold weather it has a crust of ice on top. Some trees and bushes complete the scenery of the place. It is possible to see fish swimming, but to fish you need to break the ice first.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O lago não é enorme e devido ao frio tem uma crosta de gelo por cima. Algumas árvores e arbustos completam o cenário do local. É possível ver peixes a nadar, porém para pescar é preciso quebrar o gelo antes.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El lago no es enorme y debido al clima frío tiene una costra de hielo encima. Algunos árboles y arbustos completan el paisaje del lugar. Es posible ver peces nadando, pero para pescar es necesario romper el hielo primero.");

        locale.actions.add(ActionsIds.FISHING_BASIC);

        locale.type = Enums.LocationTypes.LAKE;

        return locale;
    }

    Locale icyCaveEntrance() {
        Locale locale = new Locale("Icy Cave - Entrance", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna Gélida - Entrada");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva Helada - Entrada");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Some trees almost cover the hole in the middle of the rocks. There is a lot of ice on top of the small hill that forms the entrance to the cave. The place seems to be a good lair for all kinds of creatures.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Algumas árvores quase encobrem o buraco no meio das pedras. Há bastante gelo por cima do pequeno morro que forma a entrada da caverna. O local parece ser um bom covil para tudo que é tipo de criatura.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Algunos árboles casi cubren el agujero en medio de las rocas. Hay mucho hielo en la parte superior de la pequeña colina que forma la entrada a la cueva. El lugar parece ser una buena guarida para todo tipo de criaturas.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.type = Enums.LocationTypes.ROAD;

        return locale;
    }

    Locale icyCave() {
        Locale locale = new Locale("Icy Cave", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna Gélida");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva Helada");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "In its very beggining the natural light illuminates the rocks and the frozen stalagmites. It is very cold inside but at least there is no wind inside the corridors of this frozen walls cave.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "En su mismo comienzo, la luz natural ilumina las rocas y las estalagmitas congeladas. Hace mucho frío adentro, pero al menos no hay viento dentro de los corredores de esta cueva de paredes congeladas.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En sus inicios la luz natural ilumina las rocas y las estalagmitas congeladas. Hace mucho frío por dentro, pero al menos no hay viento dentro de los corredores de esta cueva de paredes congeladas.");

        locale.actions.add(ActionsIds.MINING_BASIC);
        locale.actions.add(ActionsIds.GATHERING_EXTRA);

        locale.possibleBattles.put(BattlesIds.ICE_GOLEM_1, 15);
        locale.possibleBattles.put(BattlesIds.FROST_WRAITH_1, 9);

        locale.type = Enums.LocationTypes.CAVERN;

        return locale;
    }

    Locale icyCaveFloor1() {
        Locale locale = new Locale("Icy Cave - Floor -1", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna Gélida - Andar -1");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva Helada - Piso -1");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The cave has a lot of natural corridors but to go down you climbed down a human made staircase. The main chamber is surrounded with rocks and ice. The ground is muddy and to go further down I will need a torch.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A caverna tem muitos corredores naturais, mas para descer você desce uma escada feita pelo homem. A câmara principal é cercada por pedras e gelo. O chão está lamacento e para descer mais precisarei de uma tocha.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La cueva tiene muchos pasillos naturales, pero para bajar bajaste por una escalera hecha por humanos. La cámara principal está rodeada de rocas y hielo. El suelo está embarrado y para bajar más necesitaré una linterna.");

        locale.actions.add(ActionsIds.MINING_BASIC);
        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.possibleBattles.put(BattlesIds.ICE_GOLEM_1, 28);
        locale.possibleBattles.put(BattlesIds.FROST_WRAITH_1, 16);
        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_LIGHT_1, 15);

        locale.type = Enums.LocationTypes.CAVERN;

        return locale;
    }

    Locale icyCaveFloor2() {
        Locale locale = new Locale("Icy Cave - Floor -2", RegionsIds.ESPERAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna Gélida - Andar -2");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva Helada - Piso -2");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "This floor is dark and very cold. The rock walls are frozen and the oxygen seems scarce. You need to use a torch to illuminate the narrow corridors. No plants and no lime are able to grow here. The ground is frozen mud and rocks.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Este piso es oscuro y muy frío. Las paredes de roca están congeladas y el oxígeno parece escaso. Necesitas usar una antorcha para iluminar los estrechos pasillos. Ni las plantas ni la cal pueden crecer aquí. El suelo es de barro congelado y rocas.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Este piso es oscuro y muy frío. Las paredes de roca están congeladas y el oxígeno parece escaso. Necesitas usar una antorcha para iluminar los estrechos pasillos. Aquí no pueden crecer ni plantas ni cal. El suelo es de barro y rocas congeladas.");

        locale.actions.add(ActionsIds.MINING_RARE);
        locale.actions.add(ActionsIds.GATHERING_EXTRA);
        locale.alwaysShow = true;

        locale.possibleBattles.put(BattlesIds.ICE_GOLEM_1, 35);
        locale.possibleBattles.put(BattlesIds.FROST_WRAITH_1, 32);

        locale.requirementValidations = (chara, ctx) -> {
            if (!LibInventory.checkHasItem(ItemsIds.TORCH, chara)) {
                return Enums.RequirementVerification.NEED_ITEMS;
            }

            return Enums.RequirementVerification.OK;
        };

        locale.type = Enums.LocationTypes.CAVERN;
        locale.places.add(LocationsIds.ICY_CAVE_RITUAL_PLACE);

        return locale;
    }
}

