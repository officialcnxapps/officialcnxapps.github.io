package com.cnx.endlesstalestwo.data.shops.bastian;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class Jewelry {
    public Shop create() {
        Shop shop = new Shop("Jewelery", 8, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Joalheria");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Joyas");
        shop.type = Enums.ShopType.GENERAL;

        // Necklaces & Amulets
        shop.addStockItem(ItemsIds.NECKLACE_OF_FOCUS);
        shop.addStockItem(ItemsIds.NATURE_NECKLACE);
        shop.addStockItem(ItemsIds.AMULET_OF_FORTITUDE);

        // Jewels & Rings
        shop.addStockItem(ItemsIds.JEWEL_OF_RIGHTEOUS);
        shop.addStockItem(ItemsIds.JEWEL_OF_UNJUST);
        shop.addStockItem(ItemsIds.RING_OF_POWER);

        // Ores
        shop.addStockItem(ItemsIds.GOLD_ORE);
        shop.addStockItem(ItemsIds.COPPER_ORE);

        shop.addStockItem(ItemsIds.GOLD_BAG);

        shop.itemsTypes.add(Enums.ItemType.JEWEL);
        shop.itemsTypes.add(Enums.ItemType.VALUABLE);
        return shop;
    }
}

