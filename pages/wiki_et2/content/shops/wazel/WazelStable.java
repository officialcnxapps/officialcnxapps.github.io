package com.cnx.endlesstalestwo.data.shops.wazel;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.mounts.MountsIds;
import com.cnx.endlesstalestwo.entities.Stable;

public class WazelStable {
    public Stable create() {
        Stable stable = new Stable("Wazel Stable", 7, 19);
        stable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estábulo de Wazel");
        stable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Establo de Wazel");

        // Desert Mount
        stable.addStockMount(MountsIds.CAMEL);

        return stable;
    }
}

