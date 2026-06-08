package com.cnx.endlesstalestwo.data.locations.esperand;

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
        App.DataManager.add(Enums.DataTypes.LOCALE, esperand());
    }

    Locale esperand() {
        Locale locale = new Locale("Esperand", RegionsIds.ESPERAND);

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Even with the very low temperatures the people that live here built an incredible town. The houses are constructed with a mix of rocks and logs, the roofs are full of snow but it's visible that most of roofs are painted blue. There is a well in the city main square. Every road has a fixed lit torch to illuminate and warm.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mesmo com as baixíssimas temperaturas, as pessoas que vivem aqui construíram uma cidade incrível. As casas são construídas com uma mistura de pedras e troncos, os telhados estão cheios de neve, mas é visível que a maioria dos telhados são pintados de azul. Há um poço na praça principal da cidade. Todas as ruas têm uma tocha acesa fixa para iluminar e aquecer.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Incluso con las bajas temperaturas, las personas que viven aquí construyeron una ciudad increíble. Las casas están construidas con una mezcla de rocas y troncos, los techos están llenos de nieve, pero es visible que la mayoría de los techos están pintados de azul. Hay un pozo en la plaza principal de la ciudad. Cada camino tiene una antorcha encendida fija para iluminar y calentar.");

        locale.actions.add(ActionsIds.HELP_PEOPLE);

        locale.places.add(LocationsIds.ESPERAND_INN);
        locale.places.add(LocationsIds.ESPERAND_TAVERN);
        locale.places.add(LocationsIds.CHURCH_OF_HOPE);
        locale.places.add(LocationsIds.ESPERAND_CITY_HALL);

        locale.shops.add(ShopsIds.POTIONS_MARKET);
        locale.shops.add(ShopsIds.MAGIC_PROTECTIONS_STORE);
        locale.shops.add(ShopsIds.NOT_FROZEN_FOODS);
        locale.shops.add(ShopsIds.COLD_BATTLER);
        locale.shops.add(ShopsIds.COMMON_STABLE);

        locale.npcs.add(NpcsIds.MALINA);
        locale.npcs.add(NpcsIds.VALANYA);

        locale.type = Enums.LocationTypes.CITY;
        locale.musicFile = "medieval_city_esperand";

        return locale;
    }
}
