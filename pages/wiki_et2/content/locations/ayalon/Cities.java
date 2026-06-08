package com.cnx.endlesstalestwo.data.locations.ayalon;

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
        App.DataManager.add(Enums.DataTypes.LOCALE, ayalon());//
    }

    //TRADUZIR
    Locale ayalon() {
        Locale locale = new Locale("Elven Citadel", RegionsIds.AYALON);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cidadela dos Elfos");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Ciudadela Élfica");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A splendid city of stone towers and green-roofed buildings lining cobblestone paths. Tall spires reach toward the sky while the mountains loom in the distance, and the warm glow of lanterns fills the streets with an enchanting elven atmosphere.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma cidade esplêndida e espaçosa. Casas construídas com pequenas pedras brancas e telhados verdes. As ruas de pedra possuem árvores e flores. Os pássaros voam por cima das torres e ouve-se conversas élficas por todo lado. Ao fundo, as montanhas emolduram a cidade numa paisagem de tirar o fôlego.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una ciudad espléndida con majestuosa arquitectura élfica, torres de piedra y tejados verdes que flanquean caminos empedrados. Las altas torres se elevan hacia el cielo mientras las montañas se yerguen al fondo, y el cálido resplandor de los faroles llena las calles de una atmósfera élfica encantadora.");

        locale.actions.add(ActionsIds.HELP_PEOPLE);

        locale.places.add(LocationsIds.CASTLE_OF_AYALON);
        locale.places.add(LocationsIds.HERBALISTS_GARDEN);
        locale.places.add(LocationsIds.ELVEN_TEMPLE);
        locale.places.add(LocationsIds.WISE_ELFS_LIBRARY);
        locale.places.add(LocationsIds.ELVEN_CITY_SQUARE);

        locale.shops.add(ShopsIds.ELVISH_MARKET);

        locale.npcs.add(NpcsIds.ELVEN_CITADEL_GUARD);

        locale.type = Enums.LocationTypes.CITY;

        return locale;
    }
}
