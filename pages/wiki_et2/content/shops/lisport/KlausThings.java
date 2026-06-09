package com.cnx.endlesstalestwo.data.shops.lisport;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class KlausThings {
    public Shop create() {
        Shop shop = new Shop("Klaus Things", 6, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Coisas do Klaus");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cosas de Klaus");
        shop.type = Enums.ShopType.GENERAL;

        // Fishing Tools
        shop.addStockItem(ItemsIds.FISHING_ROD);

        // Woodcutting Tools
        shop.addStockItem(ItemsIds.WOODCUTTERS_AXE);

        // Hunting Tools
        shop.addStockItem(ItemsIds.HUNTING_TRAP);

        // Food
        shop.addStockItem(ItemsIds.SARDINE);
        shop.addStockItem(ItemsIds.CRAB);
        shop.addStockItem(ItemsIds.EGG);

        // Materials
        shop.addStockItem(ItemsIds.LOG);
        shop.addStockItem(ItemsIds.COAL);

        // Bags
        shop.addStockItem(ItemsIds.LEATHER_BAG);

        // Misc
        shop.addStockItem(ItemsIds.SPYGLASS);

        shop.itemsTypes.add(Enums.ItemType.TOOL);
        shop.itemsTypes.add(Enums.ItemType.BAG);
        shop.itemsTypes.add(Enums.ItemType.FOOD);
        return shop;
    }
}

