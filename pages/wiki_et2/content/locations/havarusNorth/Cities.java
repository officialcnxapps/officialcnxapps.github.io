package com.cnx.endlesstalestwo.data.locations.havarusNorth;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.data.regions.RegionsIds;
import com.cnx.endlesstalestwo.data.shops.ShopsIds;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.enums.Enums;

public class Cities extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, monelix());//
        App.DataManager.add(Enums.DataTypes.LOCALE, letow());//
        App.DataManager.add(Enums.DataTypes.LOCALE, farmland());//
    }

    Locale monelix() {
        Locale locale = new Locale("Monelix", RegionsIds.HAVARUS_NORTH);

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "This city is big, very well structured. Stone houses, big tavern and stores and markets that sell enormous varieties of goods. The city is surrounded by high stone walls. The castle is located in the center of city and the the clock tower stands out on the horizon over the buildings. The city streets are made of stones and there is trees in every corner.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Esta cidade é grande, muito bem estruturada. Casas de pedra, grande taverna e lojas e mercados que vendem enormes variedades de produtos. A cidade é cercada por altos muros de pedra. O castelo está localizado no centro da cidade e a torre do relógio se destaca no horizonte sobre os edifícios. As ruas da cidade são feitas de pedras e há árvores em cada esquina.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Esta ciudad es grande y está muy bien estructurada. Tiene casas de piedra, grandes tabernas y tiendas y mercados que venden una enorme variedad de productos. La ciudad está rodeada por altas murallas de piedra. El castillo está situado en el centro de la ciudad y la torre del reloj se destaca en el horizonte sobre los edificios. Las calles de la ciudad están hechas de piedra y hay árboles en cada esquina.");

        locale.actions.add(ActionsIds.HELP_PEOPLE);

        locale.places.add(LocationsIds.MONELIX_ARMY_BARRACKS);
        locale.places.add(LocationsIds.MONELIX_FORGE);
        locale.places.add(LocationsIds.MONELIX_LIBRARY);
        locale.places.add(LocationsIds.MONELIX_CASTLE);
        locale.places.add(LocationsIds.MONELIX_TAVERN);
        locale.places.add(LocationsIds.MONELIX_INN);
        locale.places.add(LocationsIds.CLOCK_TOWER);

        locale.shops.add(ShopsIds.THE_GREAT_MARKET);
        locale.shops.add(ShopsIds.THE_FOOD_TENT);
        locale.shops.add(ShopsIds.THE_JEWELER);
        locale.shops.add(ShopsIds.TOOLS_STORE);

        locale.npcs.add(NpcsIds.SIR_JARD_BRANT);
        locale.npcs.add(NpcsIds.FALASY);

        locale.type = Enums.LocationTypes.CITY;
        locale.musicFile = "medieval_city_monelix";
        return locale;
    }

    Locale letow() {
        Locale locale = new Locale("Letow", RegionsIds.HAVARUS_NORTH);

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Only a few wooden houses are located in this small village. Pigs and chickens walk among the two dozens of citizens that live here. There is also some small crop fields surrounding some houses.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Apenas algumas casas de madeira estão localizadas nesta pequena vila. Porcos e galinhas andam entre as duas dúzias de cidadãos que vivem aqui. Há também alguns pequenos campos de cultivo ao redor de algumas casas.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En este pequeño pueblo sólo hay unas cuantas casas de madera. Entre las dos docenas de habitantes que viven aquí se pasean cerdos y gallinas. También hay algunos pequeños campos de cultivo alrededor de algunas casas.");

        locale.actions.add(ActionsIds.HELP_PEOPLE);

        locale.npcs.add(NpcsIds.JOHANNA);
        locale.npcs.add(NpcsIds.ELISA);
        locale.npcs.add(NpcsIds.LORD_DEN_FALKER);

        locale.type = Enums.LocationTypes.VILLAGE;
        return locale;
    }

    Locale farmland() {
        Locale locale = new Locale("Farmland", RegionsIds.HAVARUS_NORTH);

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Due to its fertile land, this region was chosen to be the main farms to the kingdom capital. almost all food of the kingdom come from these big crops and orchards. There is also 3 houses, a mill and a barn with some sheeps in this location.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Devido à sua terra fértil, esta região foi escolhida para ser as principais fazendas da capital do reino. Quase todos os alimentos do reino vêm dessas grandes plantações e pomares. Há também 3 casas, um moinho e um celeiro com algumas ovelhas neste local.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Debido a su tierra fértil, esta región fue elegida para albergar las principales granjas de la capital del reino. Casi todos los alimentos del reino provienen de estos grandes cultivos y huertos. También hay 3 casas, un molino y un granero con algunas ovejas en este lugar.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);

        locale.places.add(LocationsIds.FARMLAND_TAVERN);

        locale.npcs.add(NpcsIds.LARIEN);
        locale.npcs.add(NpcsIds.HINGUS_AT_FARMLAND);

        locale.type = Enums.LocationTypes.FARM;
        return locale;
    }
}
