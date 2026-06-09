package com.cnx.endlesstalestwo.data.shops.global;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.mounts.MountsIds;
import com.cnx.endlesstalestwo.entities.Stable;

public class CommonStable {
    public Stable create() {
        Stable stable = new Stable("Common Stable", 7, 19);
        stable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estábulo Comum");
        stable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Establo Común");

        // Basic Mounts
        stable.addStockMount(MountsIds.DONKEY);
        stable.addStockMount(MountsIds.GRADE_HORSE);
        stable.addStockMount(MountsIds.MEDIUM_HORSE);

        return stable;
    }
}

