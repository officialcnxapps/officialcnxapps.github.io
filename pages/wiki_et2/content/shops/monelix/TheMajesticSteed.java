package com.cnx.endlesstalestwo.data.shops.monelix;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.mounts.MountsIds;
import com.cnx.endlesstalestwo.entities.Stable;

public class TheMajesticSteed {
    public Stable create() {
        Stable stable = new Stable("The Majestic Steed", 6, 20);
        stable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O Corcel Majestoso");
        stable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "El Corcel Majestuoso");

        // Basic Mounts
        stable.addStockMount(MountsIds.DONKEY);
        stable.addStockMount(MountsIds.GRADE_HORSE);
        stable.addStockMount(MountsIds.MEDIUM_HORSE);

        // Premium Horses
        stable.addStockMount(MountsIds.SHIRE_HORSE);
        stable.addStockMount(MountsIds.THOROUGHBRED);
        stable.addStockMount(MountsIds.APPALOOSA);

        // Exotic Mounts
        stable.addStockMount(MountsIds.GRIFFIN);

        return stable;
    }
}


