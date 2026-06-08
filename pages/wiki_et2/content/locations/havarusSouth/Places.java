package com.cnx.endlesstalestwo.data.locations.havarusSouth;

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
import com.cnx.endlesstalestwo.data.battles.BattlesIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.data.regions.RegionsIds;
import com.cnx.endlesstalestwo.data.shops.ShopsIds;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.entities.Place;
import com.cnx.endlesstalestwo.enums.Enums;

public class Places extends DataHelper {

    //TRADUZIR
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.PLACE, heleraWalls());//
        App.DataManager.add(Enums.DataTypes.PLACE, bastianInn());
        App.DataManager.add(Enums.DataTypes.PLACE, bastianTavern());
        App.DataManager.add(Enums.DataTypes.PLACE, griwalshFarmHouse()); //
        App.DataManager.add(Enums.DataTypes.LOCALE, bastianMarket());//
        App.DataManager.add(Enums.DataTypes.PLACE, bastianForge());
        App.DataManager.add(Enums.DataTypes.PLACE, narrowAlley());//
        App.DataManager.add(Enums.DataTypes.PLACE, woodcuttersWarehouse());//
        App.DataManager.add(Enums.DataTypes.PLACE, heleraCastle());//
        App.DataManager.add(Enums.DataTypes.PLACE, heleraGardens());//
        App.DataManager.add(Enums.DataTypes.PLACE, heleraHarbor());//
        App.DataManager.add(Enums.DataTypes.PLACE, heleraTavern());
        App.DataManager.add(Enums.DataTypes.PLACE, heleraInn());
        App.DataManager.add(Enums.DataTypes.PLACE, smithersClan());//
        App.DataManager.add(Enums.DataTypes.PLACE, umeraTavern());
        App.DataManager.add(Enums.DataTypes.PLACE, minersLodge());//
    }

    Place heleraWalls() {
        Place place = new Place("Helera Walls", LocationsIds.HELERA_GATES);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Muros de Helera");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Muros de Helera");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Right after the gate is a door to enter inside the walls. The interior corridors are about 2 meters wide and smell of mold. There are benches and lockers for clothes and weapons in several places. Guards are on duty here.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Logo após o portão, há uma porta para entrar dentro dos muros. Os corredores internos têm cerca de 2 metros de largura e cheiram a mofo. Há bancos e armários para roupas e armas em vários lugares. Guardas estão de plantão aqui.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Justo después de la puerta, hay una entrada para acceder al interior de los muros. Los pasillos interiores tienen aproximadamente 2 metros de ancho y huelen a moho. Hay bancos y armarios para ropa y armas en varios lugares. Los guardias están de servicio aquí.");

        place.npcs.add(NpcsIds.YANDOV);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place griwalshFarmHouse() {
        Place place = new Place("Griwalsh Farm House", LocationsIds.HAVARUS_SOUTH_SHORES);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Fazenda de Griwalsh");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Casa de Griwalsh");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A big house made of clay, wood and straw. Its roof is pointed creating an iconic view from outside. The house is surrounded by small planting fields with various vegetables. There is a wooden bench and table below a big tree.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma grande casa feita de barro, madeira e palha. Seu telhado é pontiagudo, criando uma vista icônica do exterior. A casa é cercada por pequenos campos de plantação com vários vegetais. Há um banco e uma mesa de madeira debaixo de uma grande árvore.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una gran casa hecha de arcilla, madera y paja. Su techo es puntiagudo, creando una vista icónica desde el exterior. La casa está rodeada de pequeños campos de cultivo con varios vegetales. Hay un banco y una mesa de madera debajo de un gran árbol.");

        place.npcs.add(NpcsIds.GRIWALSH);

        place.type = Enums.LocationTypes.HOUSE;
        return place;
    }

    Place bastianTavern() {
        Place place = new Place("Tavern", LocationsIds.BASTIAN);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Taberna");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Taberna");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_TAVERN_DESCRIPTION_ENGLISH);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_TAVERN_DESCRIPTION_PORTUGUESE);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_TAVERN_DESCRIPTION_SPANISH);

        place.actions.add(ActionsIds.COOKING);

        place.resetId("BASTIAN_TAVERN");

        place.type = Enums.LocationTypes.TAVERN;
        return place;
    }

    Place bastianInn() {
        Place place = new Place("Inn", LocationsIds.BASTIAN);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pousada");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Posada");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_INN_DESCRIPTION_ENGLISH);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_INN_DESCRIPTION_PORTUGUESE);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_INN_DESCRIPTION_SPANISH);

        place.actions.add(ActionsIds.REST);

        place.resetId("BASTIAN_INN");

        place.type = Enums.LocationTypes.INN;
        return place;
    }

    Locale bastianMarket() {
        Locale placeLocale = new Locale("Bastian Market", RegionsIds.HAVARUS_SOUTH);
        placeLocale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mercado de Bastian");
        placeLocale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mercado de Bastian");

        placeLocale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "This market is set on the city center, making it easy for citizens to buy and sell their goods. The colorful tents of the shops are arranged on the side of the main street, which is not very wide. People and merchants bump into each other as they walk along here.");
        placeLocale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Este mercado está localizado no centro da cidade, facilitando a compra e venda de mercadorias pelos cidadãos. As barracas coloridas das lojas estão dispostas ao lado da rua principal, que não é muito larga. Pessoas e mercadores se esbarram enquanto caminham por aqui.");
        placeLocale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Este mercado está ubicado en el centro de la ciudad, facilitando la compra y venta de bienes por parte de los ciudadanos. Las coloridas carpas de las tiendas están dispuestas a lo largo de la calle principal, que no es muy ancha. La gente y los comerciantes se chocan mientras caminan por aquí.");

        placeLocale.type = Enums.LocationTypes.ROAD;

        placeLocale.places.add(LocationsIds.NARROW_ALLEY);

        placeLocale.npcs.add(NpcsIds.WELLA);
        placeLocale.npcs.add(NpcsIds.RONAN);

        placeLocale.shops.add(ShopsIds.BASTIAN_CENTRAL_MARKET);
        return placeLocale;
    }

    Place bastianForge() {
        Place place = new Place("Forge", LocationsIds.BASTIAN);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forja");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Fragua");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_FORGE_DESCRIPTION_ENGLISH);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_FORGE_DESCRIPTION_PORTUGUESE);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_FORGE_DESCRIPTION_SPANISH);

        place.type = Enums.LocationTypes.FORGE;

        place.actions.add(ActionsIds.CRAFT_GENERAL);

        place.resetId("BASTIAN_FORGE");

        return place;
    }

    Place narrowAlley() {
        Place place = new Place("Narrow Alley", LocationsIds.BASTIAN_MARKET);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Beco Estreito");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Callejón Estrecho");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The walls of the buildings constructed nearby create a very narrow alley where the sun doesn't shine. There is some crates and trash along the way and there is no exit other than the place you entered this alley. Perfect spot for hiding.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "As paredes dos edifícios construídos nas proximidades criam um beco muito estreito onde o sol não brilha. Há algumas caixas e lixo ao longo do caminho e não há saída além do local por onde você entrou neste beco. Um local perfeito para se esconder.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Las paredes de los edificios cercanos crean un callejón muy estrecho donde no llega el sol. Hay algunas cajas y basura a lo largo del camino y no hay salida aparte del lugar por donde entraste a este callejón. Un lugar perfecto para esconderse.");

        place.npcs.add(NpcsIds.ZILAYS);

        place.actions.add(ActionsIds.LOOK_FOR_TROUBLE);

        place.type = Enums.LocationTypes.ROAD;
        return place;
    }

    Place woodcuttersWarehouse() {
        Place place = new Place("Woodcutters Warehouse", LocationsIds.APENNA);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Armazém dos Lenhadores");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Almacén de los Leñadores");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A high and large building constructed with big logs. The interior have some cabinets, shelves and tables where the lumberjacks store their tools and axes. The wooden benches serve as rest spot.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um edifício alto e grande construído com grandes toras. O interior tem alguns armários, prateleiras e mesas onde os lenhadores guardam suas ferramentas e machados. Os bancos de madeira servem como local de descanso.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un edificio alto y grande construido con grandes troncos. El interior tiene algunos armarios, estantes y mesas donde los leñadores guardan sus herramientas y hachas. Los bancos de madera sirven como lugar de descanso.");

        place.npcs.add(NpcsIds.RENNE_HARDWOOD);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place heleraCastle() {
        Place place = new Place("Helera Castle", LocationsIds.HELERA);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Castelo de Helera");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Castillo de Helera");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Outside the building is imposing. Inside the castle you can notice the organization and luxury that the royal family applied in this building. The prince Vinie is the regent here and he knows how to decorate a castle with good quality furniture.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Do lado de fora, o edifício é imponente. Dentro do castelo, você pode notar a organização e o luxo que a família real aplicou nesta construção. O príncipe Vinie é o regente aqui e ele sabe como decorar um castelo com móveis de boa qualidade.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Por fuera, el edificio es imponente. Dentro del castillo, puedes notar la organización y el lujo que la familia real aplicó en esta construcción. El príncipe Vinie es el regente aquí y sabe cómo decorar un castillo con muebles de buena calidad.");

        place.npcs.add(NpcsIds.LORD_MATHEW_WINTAR);

        place.type = Enums.LocationTypes.CASTLE;
        return place;
    }

    Place heleraGardens() {
        Place place = new Place("Helera Gardens", LocationsIds.HELERA);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Jardins de Helera");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Jardines de Helera");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The central square of the town with a centralized fountain and some decorative bushes. There is wodden benches and some seagulls and pigeons around. During the day, people use the tents to sell every type of goods and beverages, like a central market.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A praça central da cidade com uma fonte centralizada e alguns arbustos decorativos. Há bancos de madeira e algumas gaivotas e pombas ao redor. Durante o dia, as pessoas usam as barracas para vender todo tipo de mercadorias e bebidas, como um mercado central.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La plaza central de la ciudad con una fuente central y algunos arbustos decorativos. Hay bancos de madera y algunas gaviotas y palomas alrededor. Durante el día, la gente usa las carpas para vender todo tipo de bienes y bebidas, como un mercado central.");

        place.npcs.add(NpcsIds.VERONA);
        place.npcs.add(NpcsIds.LADY_LARA);

        place.type = Enums.LocationTypes.VILLAGE;
        return place;
    }

    Place heleraHarbor() {
        Place place = new Place("Helera Harbor", LocationsIds.HELERA);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Porto de Helera");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Puerto de Helera");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A long and spacious dock that can serve at least 4 big ships. There are several pulley systems for lifting and lowering boxes of goods. Many barrels and boxes are scattered around the pier waiting for the stevedores.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um cais longo e espaçoso que pode servir pelo menos 4 grandes navios. Há vários sistemas de polias para levantar e abaixar caixas de mercadorias. Muitos barris e caixas estão espalhados pelo cais esperando pelos estivadores.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un muelle largo y espacioso que puede albergar al menos 4 grandes barcos. Hay varios sistemas de poleas para levantar y bajar cajas de mercancías. Muchos barriles y cajas están esparcidos por el muelle esperando a los estibadores.");

        place.resetId("HELERA_HARBOR");

        place.actions.add(ActionsIds.FISHING_BASIC);
        place.imgFile = "locale_helera_harbor";

        place.npcs.add(NpcsIds.CAPTAIN_LUKAS);
        place.npcs.add(NpcsIds.GUZAR_AT_HELERA_HARBOR);

        place.possibleBattles.put(BattlesIds.SWASHBUCKLER_PIRATE_1, 8);

        place.type = Enums.LocationTypes.HARBOR;
        return place;
    }

    Place heleraTavern() {
        Place place = new Place("Tavern", LocationsIds.HELERA);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Taberna");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Taberna");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_TAVERN_DESCRIPTION_ENGLISH);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_TAVERN_DESCRIPTION_PORTUGUESE);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_TAVERN_DESCRIPTION_SPANISH);

        place.actions.add(ActionsIds.COOKING);

        place.resetId("HELERA_TAVERN");

        place.npcs.add(NpcsIds.FELICIA);

        place.type = Enums.LocationTypes.TAVERN;
        return place;
    }

    Place heleraInn() {
        Place place = new Place("Inn", LocationsIds.HELERA);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pousada");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Posada");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_INN_DESCRIPTION_ENGLISH);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_INN_DESCRIPTION_PORTUGUESE);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_INN_DESCRIPTION_SPANISH);

        place.actions.add(ActionsIds.REST);

        place.resetId("HELERA_INN");

        place.type = Enums.LocationTypes.INN;
        return place;
    }

    Place smithersClan() {
        Place place = new Place("Smithers' Clan", LocationsIds.HELERA);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Clã dos Ferreiros");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Clan de los Herreros");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is like any other forge but bigger. There is a room in the back where the blacksmiths can sit around a table to have meetings or eat. Some cabinets store the aprons and tools used to forge and craft.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É como qualquer outra forja, mas maior. Há uma sala nos fundos onde os ferreiros podem se sentar ao redor de uma mesa para reuniões ou refeições. Alguns armários guardam os aventais e ferramentas usados para forjar e criar.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es como cualquier otra fragua, pero más grande. Hay una habitación en la parte trasera donde los herreros pueden sentarse alrededor de una mesa para reuniones o comidas. Algunos armarios guardan los delantales y herramientas utilizadas para forjar y crear.");

        place.actions.add(ActionsIds.CRAFT_GENERAL);

        place.npcs.add(NpcsIds.PERSEUS);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place umeraTavern() {
        Place place = new Place("Tavern", LocationsIds.UMERA);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Taberna");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Taberna");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_TAVERN_DESCRIPTION_ENGLISH);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_TAVERN_DESCRIPTION_PORTUGUESE);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_TAVERN_DESCRIPTION_SPANISH);

        place.actions.add(ActionsIds.COOKING);

        place.resetId("UMERA_TAVERN");

        place.npcs.add(NpcsIds.KORINA);

        place.type = Enums.LocationTypes.TAVERN;
        return place;
    }

    Place minersLodge() {
        Place place = new Place("Miners Lodge", LocationsIds.UMERA);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Alojamento dos Mineiros");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Albergue de los Mineros");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is a simple building made of square stones. The inner space is enough to accommodate around 10 people. There is furniture to hold pickaxes, hammers and other tools. In the back of the building there is a shed where the miners store rocks and ores before selling or transporting.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É um edifício simples feito de pedras quadradas. O espaço interno é suficiente para acomodar cerca de 10 pessoas. Há móveis para guardar picaretas, martelos e outras ferramentas. Na parte de trás do edifício, há um galpão onde os mineiros armazenam rochas e minérios antes de vender ou transportar.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es un edificio simple hecho de piedras cuadradas. El espacio interior es suficiente para albergar a unas 10 personas. Hay muebles para guardar picos, martillos y otras herramientas. En la parte trasera del edificio, hay un cobertor donde los mineros almacenan rocas y minerales antes de venderlos o transportarlos.");

        place.npcs.add(NpcsIds.GRUWALD);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }
}
