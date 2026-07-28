package com.cnx.endlesstalestwo.data.shops.apenna;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class WoodcuttersWarehouse {
    public Shop create() {
        Shop shop = new Shop("Woodcutters Warehouse", 6, 22);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Galpão dos Lenhadores");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Almacén de los Leñadores");
        shop.type = Enums.ShopType.INGREDIENTS;

        shop.addStockItem(ItemsIds.PLANK);
        shop.addStockItem(ItemsIds.LOG);
        shop.addStockItem(ItemsIds.WOODCUTTERS_AXE);
        shop.addStockItem(ItemsIds.HAVARUS_SOUTH_MAP);
        shop.addStockItem(ItemsIds.COAL);
        shop.addStockItem(ItemsIds.BRANCH);

        shop.itemsTypes.add(Enums.ItemType.TOOL);
        shop.itemsTypes.add(Enums.ItemType.MISC);
        return shop;
    }
}

