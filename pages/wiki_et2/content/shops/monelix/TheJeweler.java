package com.cnx.endlesstalestwo.data.shops.monelix;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class TheJeweler {
    public Shop create() {
        Shop shop = new Shop("The Jeweler", 7, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O Joalheiro");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "El Joyero");
        shop.type = Enums.ShopType.GENERAL;

        // Necklaces
        shop.addStockItem(ItemsIds.NECKLACE_OF_FOCUS);
        shop.addStockItem(ItemsIds.NECKLACE_OF_FLAMES);
        shop.addStockItem(ItemsIds.NECKLACE_OF_OCEAN);
        shop.addStockItem(ItemsIds.NATURE_NECKLACE);
        shop.addStockItem(ItemsIds.SUPREME_NECKLACE);

        // Amulets & Jewels
        shop.addStockItem(ItemsIds.AMULET_OF_FORTITUDE);
        shop.addStockItem(ItemsIds.CELESTIAL_AMULET);
        shop.addStockItem(ItemsIds.DARKNESS_AMULET);
        shop.addStockItem(ItemsIds.JEWEL_OF_RIGHTEOUS);
        shop.addStockItem(ItemsIds.JEWEL_OF_UNJUST);

        // Rings
        shop.addStockItem(ItemsIds.ENDLESS_RING);
        shop.addStockItem(ItemsIds.RING_OF_POWER);
        shop.addStockItem(ItemsIds.RING_OF_CRAFTER);
        shop.addStockItem(ItemsIds.RING_OF_ALCHEMIST);

        // Ores & Ingots
        shop.addStockItem(ItemsIds.GOLD_INGOT);
        shop.addStockItem(ItemsIds.STEEL_INGOT);
        shop.addStockItem(ItemsIds.GOLD_ORE);
        shop.addStockItem(ItemsIds.COPPER_ORE);
        shop.addStockItem(ItemsIds.COPPER_INGOT);

        shop.itemsTypes.add(Enums.ItemType.JEWEL);
        shop.itemsTypes.add(Enums.ItemType.VALUABLE);
        return shop;
    }
}

