package com.cnx.endlesstalestwo.data.shops.fishermanVille;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class FishermanStore {
    public Shop create() {
        Shop shop = new Shop("Fisherman Store", 6, 20);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Loja do Pescador");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tienda del Pescador");
        shop.type = Enums.ShopType.GENERAL;

        // Fishing Tools
        shop.addStockItem(ItemsIds.FISHING_ROD);
        shop.addStockItem(ItemsIds.REINFORCED_FISHING_ROD);

        // Fish & Seafood
        shop.addStockItem(ItemsIds.SARDINE);
        shop.addStockItem(ItemsIds.COOKED_SARDINE);
        shop.addStockItem(ItemsIds.CRAB);
        shop.addStockItem(ItemsIds.TUNA);

        // Materials
        shop.addStockItem(ItemsIds.BRANCH);
        shop.addStockItem(ItemsIds.STRING);

        // Bags
        shop.addStockItem(ItemsIds.LEATHER_BAG);

        shop.itemsTypes.add(Enums.ItemType.TOOL);
        shop.itemsTypes.add(Enums.ItemType.FOOD);
        return shop;
    }
}

