package com.cnx.endlesstalestwo.data.locations.lisport;

import android.content.Context;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.houses.HousesIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.data.regions.RegionsIds;
import com.cnx.endlesstalestwo.data.shops.ShopsIds;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.entities.Location;
import com.cnx.endlesstalestwo.enums.Enums;

public class Cities extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, lisport());//
    }

    Locale lisport() {
        Locale locale = new Locale("Lisport", RegionsIds.LISPORT);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lisport");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lisport");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A decently structured city. Mixes wooden and stone houses. A castle stands in the background, with a central, tree-lined square for local commerce.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma cidade decentemente estruturada. Mescla casas de madeira e pedra. Um castelo fica ao fundo, tendo uma praça central e arborizada para o comércio local.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una ciudad decentemente estructurada. Mezcla casas de madera y piedra. Al fondo se alza un castillo y una plaza central arbolada destinada al comercio local.");

        locale.type = Enums.LocationTypes.CITY;
        locale.musicFile = "medieval_city_1";

        locale.shops.add(ShopsIds.FOOD_STORE);
        locale.shops.add(ShopsIds.POTION_BREEDERS_UNION);
        locale.shops.add(ShopsIds.TOOLS_STORE);
        locale.shops.add(ShopsIds.CRAFTER_POINT);
        locale.shops.add(ShopsIds.BATTLERS_TENT);

        locale.stables.add(ShopsIds.LISPORT_STABLE);

        locale.actions.add(ActionsIds.HELP_PEOPLE);

        locale.npcs.add(NpcsIds.ERINO_AT_LISPORT);
        locale.npcs.add(NpcsIds.ERINO_AT_LISPORT_2);
        locale.npcs.add(NpcsIds.RAWER);

        locale.listeners = new Location.LocationListeners() {
            @Override
            public void onEnterLocation(Context ctx) {
                if (!App.Shell.isCorrupted()) {
                    App.getPlayerChar().addOwnedHouse(HousesIds.SMALL_HOUSE_LISPORT);
                }
            }

            @Override
            public void onLeaveLocation(Context ctx) {

            }
        };

        return locale;
    }
}
