package com.cnx.endlesstalestwo.data.locations.havarusNorth;

import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_FORGE_DESCRIPTION_ENGLISH;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_FORGE_DESCRIPTION_PORTUGUESE;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_FORGE_DESCRIPTION_SPANISH;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_INN_DESCRIPTION_ENGLISH;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_INN_DESCRIPTION_PORTUGUESE;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_INN_DESCRIPTION_SPANISH;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_TAVERN_DESCRIPTION_ENGLISH;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_TAVERN_DESCRIPTION_PORTUGUESE;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_TAVERN_DESCRIPTION_SPANISH;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.entities.Place;
import com.cnx.endlesstalestwo.enums.Enums;

public class Places extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.PLACE, monelixForge());//
        App.DataManager.add(Enums.DataTypes.PLACE, castle());//
        App.DataManager.add(Enums.DataTypes.PLACE, castleKitchen());//
        App.DataManager.add(Enums.DataTypes.PLACE, castleThroneRoom());//
        App.DataManager.add(Enums.DataTypes.PLACE, monelixTavern());//
        App.DataManager.add(Enums.DataTypes.PLACE, monelixInn());
        App.DataManager.add(Enums.DataTypes.PLACE, monelixLibrary());//
        App.DataManager.add(Enums.DataTypes.PLACE, clockTower());//
        App.DataManager.add(Enums.DataTypes.PLACE, armyBarracks());//
        App.DataManager.add(Enums.DataTypes.PLACE, farmlandTavern());
        App.DataManager.add(Enums.DataTypes.PLACE, swampFortressEntrance());//
        App.DataManager.add(Enums.DataTypes.PLACE, swampIslandTower());//
        App.DataManager.add(Enums.DataTypes.PLACE, swampFortress());//
        App.DataManager.add(Enums.DataTypes.PLACE, letowInn());
        App.DataManager.add(Enums.DataTypes.PLACE, prisonCells());//
        App.DataManager.add(Enums.DataTypes.PLACE, prisonOfficeRoom());//
    }

    Place monelixForge() {
        Place place = new Place("Forge", LocationsIds.MONELIX);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forja");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Fragua");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_FORGE_DESCRIPTION_ENGLISH);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_FORGE_DESCRIPTION_PORTUGUESE);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_FORGE_DESCRIPTION_SPANISH);

        place.actions.add(ActionsIds.CRAFT_GENERAL);

        place.resetId("MONELIX_FORGE");
        place.type = Enums.LocationTypes.FORGE;
        place.imgFile = "locale_monelix_forge";
        place.setLocale(LocationsIds.MONELIX);

        place.npcs.add(NpcsIds.MORKUS);

        return place;
    }

    Place castle() {
        Place place = new Place("Monelix Castle", LocationsIds.MONELIX);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Castelo de Monelix");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Castillo de Monelix");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A really majestic place. The rooms and corridors are decorated and ornate with red and white flags and tapestries. The furniture have the best quality and have gold details. Royal soldiers walk around patrolling the place.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um lugar realmente majestoso. Os cômodos e corredores são decorados e ornamentados com bandeiras e tapeçarias vermelhas e brancas. Os móveis são da melhor qualidade e têm detalhes dourados. Soldados reais andam por aí patrulhando o lugar.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un lugar realmente majestuoso. Las habitaciones y los pasillos están decorados y adornados con banderas rojas y blancas y tapices. Los muebles son de la mejor calidad y tienen detalles en oro. Los soldados reales caminan por el lugar patrullando.");

        place.places.add(LocationsIds.MONELIX_CASTLE_THRONE_ROOM);
        place.places.add(LocationsIds.MONELIX_CASTLE_KITCHEN);

        place.resetId("MONELIX_CASTLE");
        place.setLocale(LocationsIds.MONELIX);

        place.npcs.add(NpcsIds.LADY_JADE);

        place.type = Enums.LocationTypes.CASTLE;
        return place;
    }

    Place castleThroneRoom() {
        Place place = new Place("Throne Room", LocationsIds.MONELIX_CASTLE, true);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sala do Trono");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Salón del Trono");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A round room with much space. The throne is centered at the back of the room, two other armchairs are located on the sides of the throne. A big table is exactly on the center of the room. A very comfortable and decorated room.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma sala redonda com muito espaço. O trono está centralizado no fundo da sala, duas outras poltronas estão localizadas nas laterais do trono. Uma mesa grande está exatamente no centro da sala. Uma sala muito confortável e decorada.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una sala circular con mucho espacio. El trono está centrado en el fondo de la sala, otros dos sillones se encuentran a los lados del trono. Una gran mesa está exactamente en el centro de la sala. Una sala muy cómoda y decorada.");

        place.returnToPlace = LocationsIds.MONELIX_CASTLE;

        place.resetId("MONELIX_CASTLE_THRONE_ROOM");
        place.setLocale(LocationsIds.MONELIX_CASTLE, true);

        place.npcs.add(NpcsIds.QUEEN_ENOLA);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place castleKitchen() {
        Place place = new Place("Castle Kitchen", LocationsIds.MONELIX_CASTLE, true);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cozinha do Castelo");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cocina del Castillo");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A big room, full of wooden tables and counters. The ovens are filled with firewood and ready to cook. Some ingredients and herbs are hanging in the stone walls and over the tables. A good smell of food can be smelled.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma sala grande, cheia de mesas e balcões de madeira. Os fornos estão cheios de lenha e prontos para cozinhar. Alguns ingredientes e ervas estão pendurados nas paredes de pedra e sobre as mesas. Um bom cheiro de comida pode ser sentido.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una gran sala, llena de mesas y mostradores de madera. Los hornos están llenos de leña y listos para cocinar. Algunos ingredientes y hierbas cuelgan de las paredes de piedra y sobre las mesas. Se percibe un agradable olor a comida.");

        place.returnToPlace = LocationsIds.MONELIX_CASTLE;

        place.resetId("MONELIX_CASTLE_KITCHEN");
        place.setLocale(LocationsIds.MONELIX_CASTLE, true);

        place.npcs.add(NpcsIds.PRIANY);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place monelixTavern() {
        Place place = new Place("Tavern", LocationsIds.MONELIX);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Taberna");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Taberna");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_TAVERN_DESCRIPTION_ENGLISH + "\nProbably the biggest tavern around the kingdom.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_TAVERN_DESCRIPTION_PORTUGUESE + "\nProvavelmente a maior taberna do reino.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_TAVERN_DESCRIPTION_SPANISH + "\nProbablemente la taberna más grande del reino.");

        place.actions.add(ActionsIds.COOKING);

        place.resetId("MONELIX_TAVERN");
        place.imgFile = "locale_monelix_tavern";
        place.setLocale(LocationsIds.MONELIX);

        place.npcs.add(NpcsIds.TURWALD);

        place.type = Enums.LocationTypes.TAVERN;
        place.musicFile = "tavern_2";
        return place;
    }

    Place monelixInn() {
        Place place = new Place("Inn", LocationsIds.MONELIX);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pousada");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Posada");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_INN_DESCRIPTION_ENGLISH);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_INN_DESCRIPTION_PORTUGUESE);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_INN_DESCRIPTION_SPANISH);

        place.actions.add(ActionsIds.REST);

        place.resetId("MONELIX_INN");
        place.setLocale(LocationsIds.MONELIX);

        place.type = Enums.LocationTypes.INN;
        return place;
    }

    Place clockTower() {
        Place place = new Place("Clock Tower", LocationsIds.MONELIX);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Torre do Relógio");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Torre del Reloj");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "This tall building is built with big square stones. Its interior has a staircase close to the walls that goes up to the top. Some windows allow the light to enter. At the top, many gears and mechanisms make the clock count and work, the higher you go, the louder the noise gets.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Este edifício alto é construído com grandes pedras quadradas. Seu interior tem uma escadaria próxima às paredes que sobe até o topo. Algumas janelas permitem a entrada de luz. No topo, muitas engrenagens e mecanismos fazem o relógio contar e funcionar, quanto mais alto você vai, mais alto o barulho fica.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Este alto edificio está construido con grandes piedras cuadradas. En su interior hay una escalera pegada a los muros que sube hasta la cima. Unas ventanas dejan entrar la luz. En la parte superior, numerosos engranajes y mecanismos hacen que el reloj cuente y funcione, mientras más alto se sube, más fuerte se hace el ruido.");

        place.npcs.add(NpcsIds.HINGUS);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place monelixLibrary() {
        Place place = new Place("Monelix Library", LocationsIds.MONELIX);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Biblioteca de Monelix");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Biblioteca de Monelix");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "This place is silent, beautiful and majestic. Tons of books are filling hundreds of shelves. Beautiful tables and chairs are located in a kind of study room. Large stained glass windows allows a great natural lighting.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Este lugar é silencioso, bonito e majestoso. Toneladas de livros estão enchendo centenas de prateleiras. Lindas mesas e cadeiras estão localizadas em uma espécie de sala de estudo. Grandes vitrais permitem uma ótima iluminação natural.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Este lugar es silencioso, hermoso y majestuoso. Toneladas de libros llenan cientos de estantes. Hermosas mesas y sillas se encuentran en una especie de sala de estudio. Grandes ventanales de vidrio permiten una excelente iluminación natural.");

        place.npcs.add(NpcsIds.HAFANNE);
        place.npcs.add(NpcsIds.NELERA_MONELIX_LIBRARY);
        place.npcs.add(NpcsIds.MAXIMILIAN);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place armyBarracks() {
        Place place = new Place("Monelix Army Barracks", LocationsIds.MONELIX);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Quartel do Exército");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cuartel del ejército");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Some tents are aligned in the court. Crates with goods, armors and weapons are stacked nearby. The main building is made part of stone and part of wood. Many soldiers are here, some are working and patrolling and some are resting.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Algumas tendas estão alinhadas no pátio. Caixas com mercadorias, armaduras e armas estão empilhadas nas proximidades. O edifício principal é feito parte de pedra e parte de madeira. Muitos soldados estão aqui, alguns estão trabalhando e patrulhando e alguns estão descansando.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En el patio se alinean algunas tiendas de campaña y cerca se apilan cajas con mercancías, armaduras y armas. El edificio principal está construido en parte con piedra y en parte con madera. Hay muchos soldados, algunos trabajando y patrullando y otros descansando.");

        place.npcs.add(NpcsIds.GUZAR);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place farmlandTavern() {
        Place place = new Place("Tavern", LocationsIds.FARMLAND);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Taberna");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Taberna");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_TAVERN_DESCRIPTION_ENGLISH);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_TAVERN_DESCRIPTION_PORTUGUESE);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_TAVERN_DESCRIPTION_SPANISH);

        place.actions.add(ActionsIds.COOKING);

        place.npcs.add(NpcsIds.HELINDA);

        place.resetId("FARMLAND_TAVERN");
        place.setLocale(LocationsIds.FARMLAND);

        place.imgFile = "locale_farmland_tavern";

        place.type = Enums.LocationTypes.TAVERN;
        return place;
    }

    Place swampFortressEntrance() {
        Place place = new Place("Swamp Fortress - Entrance", LocationsIds.SWAMP_ISLAND);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forte do Pântano - Entrada");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Fuerte del Pantano - Entrada");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "In the middle of the mud lies this fortress. Closed with walls made of logs and with a small bridge that guides to the front gate. You can see guards on the towers located in the corners.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "No meio da lama fica esta fortaleza. Fechada com muros feitos de troncos e com uma pequena ponte que guia até o portão da frente. Você pode ver guardas nas torres localizadas nos cantos.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En medio del barro se encuentra esta fortaleza, cerrada con muros de troncos y con un pequeño puente que conduce hasta la puerta principal. Se pueden ver guardias en las torres situadas en las esquinas.");

        place.places.add(LocationsIds.SWAMP_FORTRESS);
        place.type = Enums.LocationTypes.SWAMP;

        place.npcs.add(NpcsIds.FARGUS);

        return place;
    }

    Place swampFortress() {
        Place place = new Place("Swamp Fortress", LocationsIds.SWAMP_FORTRESS_ENTRANCE, true);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forte do Pântano");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Fuerte del Pantano");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Since the ground is muddy and wet, there is wooden bridges connecting all sides and huts. Each corner have a tower with a guard. In the middle is a bigger building made of logs.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Como o chão é lamacento e molhado, há pontes de madeira conectando todos os lados e cabanas. Cada canto tem uma torre com um guarda. No meio, há uma construção maior feita de troncos.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Como el terreno es fangoso y húmedo, hay puentes de madera que conectan todos los lados y las cabañas. En cada esquina hay una torre con un guardia. En el medio hay un edificio más grande hecho de troncos.");

        place.npcs.add(NpcsIds.GALDOR);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place swampIslandTower() {
        Place place = new Place("Swamp Island Tower", LocationsIds.SWAMP_ISLAND_SHORES);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Torre da Ilha Pantâno");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Torre de la Isla Pantâno");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A simple observation tower which was built with logs and planks. It is about 6 meters tall, not so high, but enough to watch the sea.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma torre de observação simples que foi construída com troncos e tábuas. Tem cerca de 6 metros de altura, não tão alta, mas o suficiente para observar o mar.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una sencilla torre de observación construida con troncos y tablones. Mide unos 6 metros de altura, no demasiado alta, pero suficiente para observar el mar.");

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place letowInn() {
        Place place = new Place("Inn", LocationsIds.LETOW);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pousada");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Posada");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_INN_DESCRIPTION_ENGLISH);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_INN_DESCRIPTION_PORTUGUESE);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_INN_DESCRIPTION_SPANISH);

        place.actions.add(ActionsIds.REST);

        place.resetId("LETOW_INN");
        place.setLocale(LocationsIds.LETOW);

        place.npcs.add(NpcsIds.MIRJANA);

        place.type = Enums.LocationTypes.INN;
        return place;
    }

    Place prisonOfficeRoom() {
        Place locale = new Place("Prison Office Room", LocationsIds.PRISON_GATES);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sala do Escritório da Prisão");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Oficina de la Prisión");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A simple but big room. Two tables, some cabinets and shelves are all the furniture here. There is also weapons on racks hanging in the walls. There is parchments and papers over the tables.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma sala simples, mas grande. Duas mesas, alguns armários e prateleiras são todos os móveis aqui. Há também armas em prateleiras penduradas nas paredes. Há pergaminhos e papéis sobre as mesas.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una habitación sencilla pero grande. El mobiliario está formado por dos mesas, algunos armarios y estanterías. También hay armas en percheros colgados en las paredes. Hay pergaminos y papeles sobre las mesas.");

        locale.places.add(LocationsIds.PRISON_CELLS);

        locale.npcs.add(NpcsIds.BRINN);

        locale.type = Enums.LocationTypes.BUILDING;
        return locale;
    }

    Place prisonCells() {
        Place locale = new Place("Prison Cells", LocationsIds.PRISON_OFFICE_ROOM, true);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Celas da Prisão");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Celdas de la Prisión");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "When going down one floor under the main floor you find yourself in a large dark corridor carved into the rocks. Each side of the corridors is full of small cells enclosed by iron bars. the odor is terrible and the environment is dark. The prisioners don't shut up.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ao descer um andar abaixo do andar principal, você se encontra em um grande corredor escuro escavado nas rochas. Cada lado dos corredores é cheio de pequenas celas cercadas por barras de ferro. O odor é terrível e o ambiente é escuro. Os prisioneiros não se calam.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Al bajar un piso por debajo del piso principal te encuentras con un gran pasillo oscuro tallado en la roca. Cada lado de los pasillos está lleno de pequeñas celdas encerradas por barrotes de hierro. El olor es terrible y el ambiente es oscuro. Los prisioneros no se callan.");

        locale.npcs.add(NpcsIds.JEROME);

        locale.type = Enums.LocationTypes.BUILDING;
        return locale;
    }
}