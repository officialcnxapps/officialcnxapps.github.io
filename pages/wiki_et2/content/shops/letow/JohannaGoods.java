package com.cnx.endlesstalestwo.data.shops.letow;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class JohannaGoods {
    public Shop create() {
        Shop shop = new Shop("Johanna Goods", 6, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Produções Johanna");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cosas de Johanna");
        shop.type = Enums.ShopType.GENERAL;

        // Jewelry
        shop.addStockItem(ItemsIds.RING_OF_CRAFTER);

        // Ores & Ingots
        shop.addStockItem(ItemsIds.IRON_ORE);
        shop.addStockItem(ItemsIds.IRON_INGOT);

        // Materials
        shop.addStockItem(ItemsIds.TISSUE);
        shop.addStockItem(ItemsIds.STRING);
        shop.addStockItem(ItemsIds.ROPE);
        shop.addStockItem(ItemsIds.WOOL);
        shop.addStockItem(ItemsIds.LEATHER);

        // Bags
        shop.addStockItem(ItemsIds.LEATHER_BAG);

        shop.itemsTypes.add(Enums.ItemType.TOOL);
        shop.itemsTypes.add(Enums.ItemType.MISC);
        return shop;
    }
}

