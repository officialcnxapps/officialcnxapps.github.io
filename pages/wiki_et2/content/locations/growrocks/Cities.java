package com.cnx.endlesstalestwo.data.locations.growrocks;

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
    //TRADUZIR
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, dwarvenCity());//
    }

    Locale dwarvenCity() {
        Locale locale = new Locale("Dwarven City", RegionsIds.GROWROCKS);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cidade dos Anões");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Ciudad de los Enanos");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Beautiful houses and buildings are built entirely of stone. The reddish roofs and chimneys give the city a modern appearance compared to the simpler villages. The streets are made of light cobblestones and are lit by torchlight. The environment is spacious and the dwarves move around on foot or pushing wheelbarrows filled with stones, food and other materials.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Belas casas e prédios construídos inteiramente de pedras. Os telhados avermelhados e as chaminés deixam a cidade com uma aparência moderna em relação as vilas mais simples. As ruas são feitas com paralelepípedos claros e são iluminadas por postes de tochas. O ambiente é amplo e os anões circulam a pé ou empurrando carrinhos de mão com pedras, comidas e outros materiais.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hermosas casas y edificios construidos enteramente de piedra. Los techos y chimeneas rojizas le dan a la ciudad un aspecto moderno en comparación con los pueblos más simples. Las calles están hechas de adoquines claros y están iluminadas por antorchas. El ambiente es espacioso y los enanos se mueven a pie o empujando carretillas llenas de piedras, comida y otros materiales.");

        locale.actions.add(ActionsIds.HELP_PEOPLE);

        locale.places.add(LocationsIds.DWARVEN_TAVERN);
        locale.places.add(LocationsIds.DWARVEN_BARRACKS);
        locale.places.add(LocationsIds.DWARVEN_FORGE);
        locale.places.add(LocationsIds.DWARVEN_MINERS_ASSOCIATION);
        locale.places.add(LocationsIds.VEGETABLES_GARDENS);

        locale.shops.add(ShopsIds.DWARVEN_MARKET);

        locale.npcs.add(NpcsIds.KAMALA_SHINEFINGERS);
        locale.npcs.add(NpcsIds.OLIMAN_WISEHEAD);

        locale.type = Enums.LocationTypes.CITY;
        locale.musicFile = "medieval_dwarves_1";

        return locale;
    }
}
