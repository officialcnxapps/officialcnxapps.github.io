package com.cnx.endlesstalestwo.data.shops.lisport;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.mounts.MountsIds;
import com.cnx.endlesstalestwo.entities.Stable;

public class LisportStable {
    public Stable create() {
        Stable stable = new Stable("Lisport Stable", 7, 19);
        stable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estábulo de Lisport");
        stable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Estable de Lisport");

        // Mounts
        stable.addStockMount(MountsIds.DONKEY);
        stable.addStockMount(MountsIds.GRADE_HORSE);
        stable.addStockMount(MountsIds.MEDIUM_HORSE);

        return stable;
    }
}

