package com.cnx.endlesstalestwo.data.locations.havarusNorth;

import static com.cnx.endlesstalestwo.data.npcs.NpcsIds.CASIEL_PEAK;

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
import com.cnx.endlesstalestwo.data.shops.ShopsIds;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Others extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, monelixDocks());//
        App.DataManager.add(Enums.DataTypes.LOCALE, farmlandRoad());//
        App.DataManager.add(Enums.DataTypes.LOCALE, fearfulCaveEntrance());//
        App.DataManager.add(Enums.DataTypes.LOCALE, fearfulCave());//
        App.DataManager.add(Enums.DataTypes.LOCALE, fearfulCave1());//
        App.DataManager.add(Enums.DataTypes.LOCALE, fearfulCave2());//
        App.DataManager.add(Enums.DataTypes.LOCALE, fearfulCave3());//
        App.DataManager.add(Enums.DataTypes.LOCALE, farmlandBridge());//
        App.DataManager.add(Enums.DataTypes.LOCALE, cemeteryRoad());//
        App.DataManager.add(Enums.DataTypes.LOCALE, cemetery());//
        App.DataManager.add(Enums.DataTypes.LOCALE, northernMounts());//
        App.DataManager.add(Enums.DataTypes.LOCALE, havarusLongRoad());//
        App.DataManager.add(Enums.DataTypes.LOCALE, monelixGates());//
        App.DataManager.add(Enums.DataTypes.LOCALE, monelixLake());//
        App.DataManager.add(Enums.DataTypes.LOCALE, swampRoad());//
        App.DataManager.add(Enums.DataTypes.LOCALE, swampIsland());//
        App.DataManager.add(Enums.DataTypes.LOCALE, swampIslandShores());//
        App.DataManager.add(Enums.DataTypes.LOCALE, plainsOfNorth());//
        App.DataManager.add(Enums.DataTypes.LOCALE, havarusMainRoad());//
        App.DataManager.add(Enums.DataTypes.LOCALE, eastShores());//
        App.DataManager.add(Enums.DataTypes.LOCALE, surroundingsOfGreatRock());//
        App.DataManager.add(Enums.DataTypes.LOCALE, greatRockCavern());//
        App.DataManager.add(Enums.DataTypes.LOCALE, greatRockLevel1());//
        App.DataManager.add(Enums.DataTypes.LOCALE, greatRockLevel2());//
        App.DataManager.add(Enums.DataTypes.LOCALE, greatRockPeak());//
        App.DataManager.add(Enums.DataTypes.LOCALE, prisonWay());//
        App.DataManager.add(Enums.DataTypes.LOCALE, prisonGates());//
    }

    Locale monelixDocks() {
        Locale locale = new Locale("Monelix Docks", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Docas de Monelix");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Muelles de Monelix");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "You imagine that the docks of the main city of the kingdom would be enormous, but no, just a single large wooden pier with a big crane to move crates and goods. In the coast, two buildings are used as warehouse.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Você imagina que as docas da cidade principal do reino seriam enormes, mas não, apenas um único grande píer de madeira com um grande guindaste para mover caixas e mercadorias. Na costa, dois edifícios são usados como armazém.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Imaginas que los muelles de la ciudad principal del reino serían enormes, pero no, solo un gran muelle de madera con una gran grúa para mover cajas y mercancías. En la costa, dos edificios se utilizan como almacén.");

        locale.actions.add(ActionsIds.FISHING_BASIC);

        locale.npcs.add(NpcsIds.CAPTAIN_NORMAN);
        locale.npcs.add(NpcsIds.HILDO);

        locale.type = Enums.LocationTypes.HARBOR;
        return locale;
    }

    Locale farmlandRoad() {
        Locale locale = new Locale("Farmland Road", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estrada Farmland");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carretera Farmland");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A simple road that connects Monelix to its farms. The road is muddy and has several marks from wagon wheels.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma estrada simples que conecta Monelix às suas fazendas. A estrada é lamacenta e tem várias marcas de rodas de carroça.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un camino sencillo que comunica Monelix con sus fincas. El camino es fangoso y tiene varias marcas de ruedas de carretas.");

        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);

        locale.possibleBattles.put(BattlesIds.BANDIT_1, 18);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale fearfulCaveEntrance() {
        Locale locale = new Locale("Fearful Cave - Entrance", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna Fearful - Entrada");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva Fearful - Entrada");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "You stand in front of a small stone hill with an entrance. The ground is gray and some dry trees are present.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Você está em frente a uma pequena colina de pedra com uma entrada. O chão é cinza e algumas árvores secas estão presentes");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Te encuentras frente a una pequeña colina de piedra con una entrada. El suelo es gris y hay algunos árboles secos.");

        locale.possibleBattles.put(BattlesIds.CAVE_BAT_1, 16);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale fearfulCave() {
        Locale locale = new Locale("Fearful Cave", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna Fearful");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva Fearful");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Just a few meters inside the dungeon and the light almost disappear. Rocks and stones forge the chambers. You can listen to water dripping and some weird grunts from strange creatures.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Apenas alguns metros dentro da masmorra e a luz quase desaparece. Rochas e pedras forjam as câmaras. Você pode ouvir água pingando e alguns grunhidos estranhos de criaturas estranhas.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Apenas unos metros más adelante, la luz desaparece casi por completo. Las rocas y las piedras forjan las cámaras. Se puede escuchar el goteo del agua y algunos gruñidos extraños de criaturas extrañas.");

        locale.actions.add(ActionsIds.MINING_BASIC);

        locale.possibleBattles.put(BattlesIds.CAVE_BAT_1, 16);
        locale.possibleBattles.put(BattlesIds.CAVE_BAT_2, 18);
        locale.possibleBattles.put(BattlesIds.DUNGEON_IMP_1, 16);


        locale.type = Enums.LocationTypes.DUNGEON;
        return locale;
    }

    Locale fearfulCave1() {
        Locale locale = new Locale("Fearful Cave - Floor -1", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna Fearful - Andar -1");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva Fearful - Piso -1");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "After climbing down a rocky ledge, you find yourself in dark place. Without a source of light would be impossible to see that the chambers of the cave are big and wet.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Depois de descer por uma saliência rochosa, você se encontra em um lugar escuro. Sem uma fonte de luz seria impossível ver que as câmaras da caverna são grandes e úmidas.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Después de descender por una cornisa rocosa, te encuentras en un lugar oscuro. Sin una fuente de luz sería imposible ver que las cámaras de la cueva son grandes y húmedas.");

        locale.actions.add(ActionsIds.MINING_BASIC);

        locale.requirementValidations = (chara, ctx) -> {
            if (LibInventory.checkHasItemAmount(ItemsIds.TORCH, 1, chara)
                    && chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.OK;
            } else if (!chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.NEED_KNOWLEDGES;
            }

            return Enums.RequirementVerification.NEED_ITEMS;
        };

        locale.possibleBattles.put(BattlesIds.CAVE_BAT_2, 15);
        locale.possibleBattles.put(BattlesIds.SKELETON_GUARDIAN_1, 22);
        locale.possibleBattles.put(BattlesIds.SUCCUBUS_1, 11);
        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_FIRE_1, 11);

        locale.type = Enums.LocationTypes.DUNGEON;
        return locale;
    }

    Locale fearfulCave2() {
        Locale locale = new Locale("Fearful Cave - Floor -2", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna Fearful - Andar -2");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva Fearful - Piso -2");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "This place is cold, dark and wet. The rocks have slime, bats fly, cockroaches run in the corners. You can easily feel claustrophobic.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Este lugar é frio, escuro e úmido. As pedras têm limo, morcegos voam, baratas correm pelos cantos. Você pode facilmente se sentir claustrofóbico.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Este lugar es frío, oscuro y húmedo. Las rocas tienen limo, los murciélagos vuelan, las cucarachas corren por los rincones. Es fácil sentir claustrofobia.");

        locale.requirementValidations = (chara, ctx) -> {
            if (LibInventory.checkHasItemAmount(ItemsIds.TORCH, 1, chara)
                    && chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.OK;
            } else if (!chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.NEED_KNOWLEDGES;
            }

            return Enums.RequirementVerification.NEED_ITEMS;
        };

        locale.actions.add(ActionsIds.MINING_EXTRA);

        locale.possibleBattles.put(BattlesIds.VENOM_SPIDER_1, 15);
        locale.possibleBattles.put(BattlesIds.SKELETON_GUARDIAN_1, 34);
        locale.possibleBattles.put(BattlesIds.SUCCUBUS_1, 24);
        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_FIRE_1, 19);

        locale.type = Enums.LocationTypes.DUNGEON;
        return locale;
    }

    Locale fearfulCave3() {
        Locale locale = new Locale("Fearful Cave - Floor -3", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna Fearful - Andar -3");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva Fearful - Piso -3");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A big chamber with a small lake in the end. Muddy and wet. Rocks and weird creatures are the most present things here. This place is really deep, dark and scary.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma grande câmara com um pequeno lago no final. Lamacento e molhado. Rochas e criaturas estranhas são as coisas mais presentes aqui. Este lugar é realmente profundo, escuro e assustador.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una cámara grande con un pequeño lago al final. Barroso y mojado. Las rocas y las criaturas extrañas son las cosas más comunes aquí. Este lugar es realmente profundo, oscuro y aterrador.");

        locale.requirementValidations = (chara, ctx) -> {
            if (LibInventory.checkHasItemAmount(ItemsIds.ROPE, 1, chara)
                    && LibInventory.checkHasItemAmount(ItemsIds.TORCH, 1, chara)
                    && chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.OK;
            } else if (!chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.NEED_KNOWLEDGES;
            }

            return Enums.RequirementVerification.NEED_ITEMS;
        };

        locale.actions.add(ActionsIds.MINING_EXTRA);

        locale.possibleBattles.put(BattlesIds.VENOM_SPIDER_1, 24);
        locale.possibleBattles.put(BattlesIds.SKELETON_GUARDIAN_1, 45);
        locale.possibleBattles.put(BattlesIds.SUCCUBUS_1, 35);
        locale.possibleBattles.put(BattlesIds.MEDUSA_1, 23);

        locale.type = Enums.LocationTypes.DUNGEON;
        return locale;
    }

    Locale farmlandBridge() {
        Locale locale = new Locale("Farmland Bridge", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ponte de Farmland");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Puente de Farmland");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A 20 meters long stone bridge that crosses over the Monelix river. A great work of engineering that supports fully loaded carts. Also it is a good spot to fishing.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma ponte de pedra de 20 metros de comprimento que atravessa o rio Monelix. Uma grande obra de engenharia que suporta carroças grandes e cheias. Também é um bom local para pescar.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Puente de piedra de 20 metros de largo que cruza el río Monelix. Una gran obra de ingeniería que soporta carros grandes y completamente cargados. También es un buen lugar para pescar.");

        locale.actions.add(ActionsIds.FISHING_BASIC);
        locale.actions.add(ActionsIds.FISHING_EXTRA);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale cemeteryRoad() {
        Locale locale = new Locale("Cemetery Road", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caminho do Cemitério");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Camino del Cementerio");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "When you leave Farmland to the north, you face yourself in a not long road. To every side you look you see something: some hills, a water stream a cemetery and farm crops.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Quando você sai de Farmland para o norte, você se depara com uma estrada não muito longa. Para cada lado que você olha, você vê algo: algumas colinas, um riacho, um cemitério e plantações de fazenda.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cuando sales de Farmland hacia el norte, te encuentras con un camino no muy largo. A cada lado que mires, ves algo: algunas colinas, un arroyo, un cementerio y cultivos agrícolas.");

        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);

        locale.possibleBattles.put(BattlesIds.PICKPOCKETER_1, 18);
        locale.possibleBattles.put(BattlesIds.BANDIT_1, 23);
        locale.possibleBattles.put(BattlesIds.BANDIT_2, 16);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale cemetery() {
        Locale locale = new Locale("Cemetery", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cemitério");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cementerio");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A place to honor and remember people that passed away. Surrounded with a small wooden fence. Many tombs are marked with stones or crossed sticks.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um lugar para honrar e lembrar pessoas que faleceram. Cercado por uma pequena cerca de madeira. Muitos túmulos são marcadas com pedras ou varas cruzadas.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un lugar para honrar y recordar a las personas que fallecieron. Rodeado de una pequeña valla de madera. Muchas tumbas están marcadas con piedras o palos cruzados.");

        locale.npcs.add(NpcsIds.BRIANNE);

        locale.possibleBattles.put(BattlesIds.SKELETON_GUARDIAN_1, 12);
        locale.possibleBattles.put(BattlesIds.SPIDER_1_VENOM_SPIDER_1, 12);
        locale.possibleBattles.put(BattlesIds.VENOM_SPIDER_1, 16);
        locale.possibleBattles.put(BattlesIds.BANDIT_1, 16);
        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_LIGHT_1, 8);
        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_FIRE_1, 8);
        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_AIR_1, 8);

        locale.type = Enums.LocationTypes.PLAINS;
        return locale;
    }

    Locale northernMounts() {
        Locale locale = new Locale("Northern Mounts", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Montes do Norte");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Montes del Norte");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "These mounts are not high, but you easily get tired walking around here. The hills are covered by a greenish yellow grass.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Essas montanhas não são altas, mas você se cansa facilmente andando por aqui. As colinas são cobertas por uma grama amarelo-esverdeada.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Estos montes no son altos, pero uno se cansa fácilmente al caminar por ellos. Las colinas están cubiertas por una hierba de color amarillo verdoso.");

        locale.actions.add(ActionsIds.MINING_BASIC);
        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.possibleBattles.put(BattlesIds.WILD_BOAR_1, 17);

        locale.type = Enums.LocationTypes.MOUNT;
        return locale;
    }

    Locale havarusLongRoad() {
        Locale locale = new Locale("Havarus Long Road", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estrada Longa");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "El Largo Camino");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The name says it all, a long road that is probably longer than 20 kilometers. It crosses the kingdom land from west to east, connecting Monelix to a small village.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O nome diz tudo, uma longa estrada que provavelmente tem mais de 20 quilômetros. Ela atravessa a terra do reino de oeste a leste, conectando Monelix a uma pequena vila.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El nombre dice todo, una larga carretera que probablemente tenga más de 20 kilómetros. Cruza el territorio del reino de oeste a este, conectando Monelix con un pequeño pueblo.");

        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);

        locale.possibleBattles.put(BattlesIds.BANDIT_1, 18);
        locale.possibleBattles.put(BattlesIds.BANDIT_2, 15);
        locale.possibleBattles.put(BattlesIds.PICKPOCKETER_1, 12);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale monelixGates() {
        Locale locale = new Locale("Monelix Gates", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Portões de Monelix");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Puertas de Monelix");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The entrance of Monelix, the kingdom capital. Very high gates made with thick wood and reinforced with iron. Some royal soldiers guard this entrance.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A entrada de Monelix, a capital do reino. Portões muito altos feitos com madeira grossa e reforçados com ferro. Alguns soldados reais guardam esta entrada.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La entrada de Monelix, la capital del reino. Puertas muy altas, hechas de madera gruesa y reforzadas con hierro. Algunos soldados reales custodian esta entrada.");

        locale.stables.add(ShopsIds.THE_MAJESTIC_STEED);

        locale.npcs.add(NpcsIds.JAMES);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale monelixLake() {
        Locale locale = new Locale("Monelix Lake", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lago de Monelix");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lago de Monelix");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The water is almost crystal clear. Sometimes it is possible to see fishes jumping in the water. The lake presents a small riparian forest all around. There is very good breeze flowing over here.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A água é quase cristalina. Às vezes é possível ver peixes pulando na água. O lago apresenta uma pequena mata ciliar ao redor. Há uma brisa muito boa fluindo aqui.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El agua es casi cristalina. A veces es posible ver peces saltando en el agua. El lago presenta un pequeño bosque de ribera alrededor. Hay una brisa muy agradable que corre por aquí.");

        locale.actions.add(ActionsIds.FISHING_BASIC);
        locale.actions.add(ActionsIds.FISHING_EXTRA);
        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.possibleBattles.put(BattlesIds.WILD_BOAR_1, 17);
        locale.possibleBattles.put(BattlesIds.CROCODILE_1, 17);

        locale.npcs.add(NpcsIds.WILLIAM);

        locale.type = Enums.LocationTypes.LAKE;
        return locale;
    }

    Locale swampRoad() {
        Locale locale = new Locale("Swamp Road", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estrada do Pântano");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Camino del Pantano");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The road is muddy and not so long. The name of this road determines to where this road can lead.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A estrada é lamacenta e não tão longa. O nome desta estrada determina para onde esta estrada pode levar.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El camino es fangoso y no muy largo. El nombre de este camino determina a dónde puede llevar.");

        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);

        locale.possibleBattles.put(BattlesIds.BANDIT_2, 15);
        locale.possibleBattles.put(BattlesIds.PICKPOCKETER_1, 15);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale swampIsland() {
        Locale locale = new Locale("Swamp Island", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ilha Pântano");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Isla Pantano");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The soil is terrible like every swamp. Where the water is not over the ankles, the ground is muddy. Every tree and rock have slime. Every time the Monelix river overflow, this place gets worse. Lots of reptiles live here.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O solo é terrível como qualquer pântano. Onde a água não passa dos tornozelos, o chão é lamacento. Cada árvore e pedra tem limo. Toda vez que o rio Monelix transborda, este lugar piora. Muitos répteis vivem aqui.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El suelo es terrible como cualquier pantano. Donde el agua no llega a los tobillos, el suelo está fangoso. Todos los árboles y las rocas tienen limo. Cada vez que el río Monelix se desborda, este lugar empeora. Aquí viven muchos reptiles.");

        locale.actions.add(ActionsIds.FISHING_BASIC);
        locale.actions.add(ActionsIds.GATHERING_EXTRA);
        locale.actions.add(ActionsIds.HUNT_TRAP);
        locale.actions.add(ActionsIds.WOODCUTTING);

        locale.npcs.add(NpcsIds.GHOST_DMITRI);

        locale.possibleBattles.put(BattlesIds.SWAMP_TOAD_1, 24);
        locale.possibleBattles.put(BattlesIds.SWAMP_TOAD_2, 15);
        locale.possibleBattles.put(BattlesIds.FOREST_PREDATOR_1, 14);
        locale.possibleBattles.put(BattlesIds.CROCODILE_1, 17);


        locale.type = Enums.LocationTypes.SWAMP;
        return locale;
    }

    Locale swampIslandShores() {
        Locale locale = new Locale("Swamp Island Shores", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Costa da Ilha Pântano");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Costa de la Isla Pantano");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "This is the driest part of this island. There are more rocks on the ground and you can feel the feel the droplets of salty sea water. A tower made of wood is nearby.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Esta é a parte mais seca desta ilha. Há mais pedras no chão e você pode sentir as gotas de água salgada do mar. Uma torre de madeira está próxima.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Esta es la parte más seca de la isla. Hay más rocas en el suelo y se pueden sentir las gotas de agua salada del mar. Cerca hay una torre de madera.");

        locale.actions.add(ActionsIds.FISHING_BASIC);
        locale.actions.add(ActionsIds.FISHING_EXTRA);
        locale.actions.add(ActionsIds.HUNT_BASIC);

        locale.possibleBattles.put(BattlesIds.SWAMP_TOAD_1, 12);
        locale.possibleBattles.put(BattlesIds.SWAMP_TOAD_2, 8);
        locale.possibleBattles.put(BattlesIds.FOREST_PREDATOR_1, 9);
        locale.possibleBattles.put(BattlesIds.CROCODILE_1, 22);
        locale.possibleBattles.put(BattlesIds.TORMENT_PIRATE_1, 11);


        locale.type = Enums.LocationTypes.SEA;
        return locale;
    }

    Locale plainsOfNorth() {
        Locale locale = new Locale("Plains of North", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Planícies do Norte");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Llanuras del Norte");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A vast piece of land with no special things. Some trees, some bushes and lots of grass. Of course, some deers, boars and other wild life is walking over here.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um vasto pedaço de terra sem nada de especial. Algumas árvores, alguns arbustos e muita grama. Claro, alguns veados, javalis e outros animais selvagens estão andando por aqui.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un terreno enorme sin nada especial. Algunos árboles, algunos arbustos y mucha hierba. Por supuesto, algunos ciervos, jabalíes y otros animales salvajes caminan por aquí.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.actions.add(ActionsIds.HUNT_BASIC);

        locale.possibleBattles.put(BattlesIds.WILD_BOAR_1, 19);

        locale.npcs.add(NpcsIds.PHIL);

        locale.type = Enums.LocationTypes.PLAINS;
        return locale;
    }

    Locale havarusMainRoad() {
        Locale locale = new Locale("Havarus Main Road", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estrada Principal de Havarus");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carretera Principal de Havarus");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "This is the most important road of the kingdom, used by many people that travel from north and south. It is large and long and there is always someone traveling through.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Esta é a estrada mais importante do reino, usada por muitas pessoas que viajam do norte e do sul. É larga e longa e sempre tem alguém viajando por ela.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Esta es la vía más importante del reino, utilizada por muchas personas que viajan desde el norte y el sur. Es ancha y larga y siempre hay alguien que pasa por ella.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.actions.add(ActionsIds.HUNT_BASIC);
        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);

        locale.possibleBattles.put(BattlesIds.BANDIT_1, 16);
        locale.possibleBattles.put(BattlesIds.BANDIT_2, 12);
        locale.possibleBattles.put(BattlesIds.WILD_BOAR_1, 7);
        locale.possibleBattles.put(BattlesIds.PICKPOCKETER_1, 13);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale eastShores() {
        Locale locale = new Locale("East Shores", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Costa Leste");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Costa Este");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The east coast looks like a perfect beach to relax and observe the ocean. The sand is soft and the waves are calm. With very clear sky you can see the big ships heading towards Esperand.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A costa leste parece uma praia perfeita para relaxar e observar o oceano. A areia é macia e as ondas são calmas. Com céu muito claro, você pode ver os grandes navios indo em direção a Esperand.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La costa este parece una playa perfecta para relajarse y observar el océano. La arena es suave y las olas tranquilas. Con un cielo muy despejado se pueden ver los grandes barcos que se dirigen hacia Esperand.");

        locale.actions.add(ActionsIds.FISHING_EXTRA);

        locale.possibleBattles.put(BattlesIds.CROCODILE_1, 15);
        locale.possibleBattles.put(BattlesIds.TORMENT_PIRATE_1, 8);
        locale.possibleBattles.put(BattlesIds.SWASHBUCKLER_PIRATE_1, 12);

        locale.type = Enums.LocationTypes.SEA;
        return locale;
    }

    Locale surroundingsOfGreatRock() {
        Locale locale = new Locale("Surroundings of Great Rock", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Arredores da Grande Rocha");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Entorno da Gran Roca");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "You are very near to the mountain, if you look straight up you can't see the peak. There is rocks everywhere.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Você está muito perto da montanha, se olhar diretamente para cima não consegue ver o pico. Há pedras por todo lugar.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Estás muy cerca de la montaña, si miras hacia arriba no puedes ver el pico. Hay rocas por todas partes.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.npcs.add(NpcsIds.MARTIN);

        locale.type = Enums.LocationTypes.PLAINS;
        return locale;
    }

    Locale greatRockCavern() {
        Locale locale = new Locale("Great Rock Cavern", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna da Grande Rocha");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva da Gran Roca");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "You are inside a dungeon below the Great Rock mountain. It is a moist and dark cavern, full of big pieces of rocks.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Você está dentro de uma masmorra abaixo da montanha Great Rock. É uma caverna úmida e escura, cheia de grandes pedaços de pedras.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Estás dentro de una mazmorra debajo de la montaña Great Rock. Es una caverna húmeda y oscura, llena de grandes trozos de rocas.");

        locale.possibleBattles.put(BattlesIds.MOUNTAIN_GOLEM_1, 17);

        locale.actions.add(ActionsIds.MINING_BASIC);

        locale.possibleBattles.put(BattlesIds.MOUNTAIN_TROLL_1, 19);
        locale.possibleBattles.put(BattlesIds.CAVE_BAT_2, 18);
        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_1, 13);

        locale.type = Enums.LocationTypes.DUNGEON;
        return locale;
    }

    Locale greatRockLevel1() {
        Locale locale = new Locale("Great Rock - Level 1", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Grande Rocha - Nível 1");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Gran Roca - Nivel 1");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "You are climbing the biggest known mountain, the first step is done, but there's much to climb until the peak.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Você está escalando a maior montanha conhecida, o primeiro passo já foi dado, mas ainda há muito a escalar até o pico.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Estas escalando la montaña más grande conocida, el primer paso ya está dado, pero hay mucho que escalar hasta llegar a la cima.");

        locale.actions.add(ActionsIds.MINING_BASIC);

        locale.possibleBattles.put(BattlesIds.MOUNTAIN_GOLEM_1, 16);
        locale.possibleBattles.put(BattlesIds.MOUNTAIN_TROLL_1, 15);
        locale.possibleBattles.put(BattlesIds.TORMENT_PIRATE_1, 11);

        locale.requirementValidations = (chara, ctx) -> {
            if (
                    LibInventory.checkHasItemAmount(ItemsIds.ROPE, 1, chara)
                            && (chara.hasKnowledge(KnowledgesIds.CLIMBING) || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.LEARNING_CLIMBING, 2))
            ) {
                return Enums.RequirementVerification.OK;
            } else if (!chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.NEED_KNOWLEDGES;
            }

            return Enums.RequirementVerification.NEED_ITEMS;
        };

        locale.type = Enums.LocationTypes.MOUNTAIN;
        return locale;
    }

    Locale greatRockLevel2() {
        Locale locale = new Locale("Great Rock - Level 2", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Grande Rocha - Nível 2");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Gran Roca - Nivel 2");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "You made a big effort to reach this height. You can feel the air colder and the pressure increasing. You can see the entire valley from here, a beautiful landscape.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Você fez um grande esforço para chegar a essa altura. Você pode sentir o ar mais frio e a pressão aumentando. Você pode ver o vale inteiro daqui, uma paisagem linda.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Has hecho un gran esfuerzo para llegar a esta altura. Puedes sentir el aire más frío y la presión aumentando. Desde aquí se ve todo el valle, un paisaje precioso.");

        locale.requirementValidations = (chara, ctx) -> {
            if (LibInventory.checkHasItemAmount(ItemsIds.ROPE, 1, chara)
                    && chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.OK;
            } else if (!chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.NEED_KNOWLEDGES;
            }

            return Enums.RequirementVerification.NEED_ITEMS;
        };

        locale.possibleBattles.put(BattlesIds.MOUNTAIN_GOLEM_1, 28);
        locale.possibleBattles.put(BattlesIds.MOUNTAIN_TROLL_1, 19);

        locale.actions.add(ActionsIds.MINING_EXTRA);

        locale.type = Enums.LocationTypes.MOUNTAIN;
        return locale;
    }

    Locale greatRockPeak() {
        Locale locale = new Locale("Great Rock - Peak", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Grande Rocha - Pico");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Gran Roca - Pico");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "You made it to the top. The feeling of freedom is bigger than the feeling of vertigo. You can see the whole kingdom from this peak.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Você chegou ao topo. A sensação de liberdade é maior que a sensação de vertigem. Você pode ver o reino inteiro deste pico.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Has llegado a la cima. La sensación de libertad es mayor que la de vértigo. Desde esta cima se puede ver todo el reino.");

        locale.requirementValidations = (chara, ctx) -> {
            if (LibInventory.checkHasItemAmount(ItemsIds.ROPE, 1, chara)
                    && chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.OK;
            } else if (!chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.NEED_KNOWLEDGES;
            }

            return Enums.RequirementVerification.NEED_ITEMS;
        };

        locale.npcs.add(CASIEL_PEAK);

        locale.possibleBattles.put(BattlesIds.MOUNTAIN_GOLEM_1, 16);
        locale.possibleBattles.put(BattlesIds.MOUNTAIN_TROLL_1, 16);

        if ((LibQuest.charHasQuest(QuestsIds.BLOOD_WITH_BLOOD, App.getPlayerChar())
                || LibQuest.charHasQuest(QuestsIds.DRAGON_FEAR, App.getPlayerChar()))
                && !LibQuest.isQuestComplete(App.getPlayerChar(), QuestsIds.DRAGON_FEAR)) {
            locale.possibleBattles.put(BattlesIds.FIRE_DRAGON_1, 20);
        }

        locale.actions.add(ActionsIds.MINING_EXTRA);

        locale.type = Enums.LocationTypes.MOUNTAIN;
        return locale;
    }

    Locale prisonWay() {
        Locale locale = new Locale("Prison Way", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caminho da Prisão");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Camino de la Prisión");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "This path is short and full of wagon wheel tracks. Those wagons carry prisioners and goods to the prison that is ahead.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Este caminho é curto e cheio de marcas de rodas de carroça. Essas carroças carregam prisioneiros e bens para a prisão que está à frente.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Este camino es corto y está lleno de huellas de ruedas de carros que transportan prisioneros y mercancías a la prisión que está más adelante.");

        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);

        locale.possibleBattles.put(BattlesIds.BANDIT_2, 9);
        locale.possibleBattles.put(BattlesIds.PICKPOCKETER_1, 11);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }

    Locale prisonGates() {
        Locale locale = new Locale("Prison Gates", RegionsIds.HAVARUS_NORTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Portões da Prisão");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Puertas de la Prisión");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The walls are high and the gate, made of wood and steel, are closed. A guard is standing left of the gate. Looks like impossible to climb the wall without a long stair.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Os muros são altos e o portão, feito de madeira e aço, está fechado. Um guarda está de pé à esquerda do portão. Parece impossível escalar o muro sem uma escada longa.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Los muros son altos y la puerta, hecha de madera y acero, está cerrada. Hay un guardia a la izquierda de la puerta. Parece imposible escalar la pared sin una escalera larga.");

        locale.places.add(LocationsIds.PRISON_OFFICE_ROOM);

        locale.type = Enums.LocationTypes.ROAD;
        return locale;
    }
}
