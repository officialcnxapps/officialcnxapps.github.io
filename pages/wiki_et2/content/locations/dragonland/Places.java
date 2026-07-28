package com.cnx.endlesstalestwo.data.locations.dragonland;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.entities.Place;
import com.cnx.endlesstalestwo.enums.Enums;

public class Places extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.PLACE, woodenHut());
    }

    Place woodenHut() {
        Place place = new Place("Wooden Hut", LocationsIds.GROVE_OF_DEAD_TREES);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cabana de Madeira");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Choza de Madera");
        place.resetId("WOODEN_HUT");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A small, sturdy hut built from weathered logs and stones. The interior is cramped but warm, smelling of dried herbs, old parchment, and a faint, metallic tang of dragon blood.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma cabana pequena e robusta construída com toras e pedras desgastadas. O interior é apertado mas quente, cheirando a ervas secas, pergaminhos antigos e um leve toque metálico de sangue de dragão.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una pequeña y robusta cabaña construida con troncos y piedras desgastadas por el tiempo. El interior es estrecho pero cálido, con olor a hierbas secas, pergaminos viejos y un ligero toque metálico de sangre de dragón.");

        place.npcs.add(NpcsIds.AFFRONIS);

        place.type = Enums.LocationTypes.HOUSE;
        return place;
    }
}
