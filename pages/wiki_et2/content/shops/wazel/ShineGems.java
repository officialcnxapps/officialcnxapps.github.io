package com.cnx.endlesstalestwo.data.shops.wazel;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class ShineGems {
    public Shop create() {
        Shop shop = new Shop("Shine Gems", 7, 19);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Jóias Brilhosas");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Gemas Brillantes");
        shop.type = Enums.ShopType.GENERAL;

        // Jewels - Necklaces & Amulets
        shop.addStockItem(ItemsIds.NECKLACE_OF_FOCUS);
        shop.addStockItem(ItemsIds.NATURE_NECKLACE);
        shop.addStockItem(ItemsIds.AMULET_OF_FORTITUDE);

        // Rings
        shop.addStockItem(ItemsIds.RING_OF_POWER);
        shop.addStockItem(ItemsIds.RING_OF_CRAFTER);
        shop.addStockItem(ItemsIds.RING_OF_ALCHEMIST);
        shop.addStockItem(ItemsIds.RUBY_RING);

        // Valuables - Ores & Ingots
        shop.addStockItem(ItemsIds.GOLD_ORE);
        shop.addStockItem(ItemsIds.GOLD_INGOT);
        shop.addStockItem(ItemsIds.COPPER_ORE);
        shop.addStockItem(ItemsIds.COPPER_INGOT);

        // Valuables - Gems
        shop.addStockItem(ItemsIds.EMERALD);
        shop.addStockItem(ItemsIds.DIAMOND);
        shop.addStockItem(ItemsIds.RUBY);

        // Maps
        shop.addStockItem(ItemsIds.WAZEL_MAP);

        // Bags & Misc
        shop.addStockItem(ItemsIds.LEATHER_BAG);
        shop.addStockItem(ItemsIds.GREAT_LEATHER_BAG);

        shop.itemsTypes.add(Enums.ItemType.JEWEL);
        shop.itemsTypes.add(Enums.ItemType.VALUABLE);
        shop.itemsTypes.add(Enums.ItemType.MISC);
        shop.itemsTypes.add(Enums.ItemType.BAG);
        return shop;
    }
}

