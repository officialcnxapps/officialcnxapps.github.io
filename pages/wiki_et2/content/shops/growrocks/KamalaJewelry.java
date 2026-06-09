package com.cnx.endlesstalestwo.data.shops.growrocks;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class KamalaJewelry {
    public Shop create() {
        Shop shop = new Shop("Kamala's Jewelry", 6, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Joias da Kamala");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Joyas de Kamala");
        shop.type = Enums.ShopType.GENERAL;

        // Necklaces
        shop.addStockItem(ItemsIds.NECKLACE_OF_FOCUS);
        shop.addStockItem(ItemsIds.NECKLACE_OF_FLAMES);
        shop.addStockItem(ItemsIds.NECKLACE_OF_OCEAN);
        shop.addStockItem(ItemsIds.NATURE_NECKLACE);
        shop.addStockItem(ItemsIds.SUPREME_NECKLACE);

        // Amulets
        shop.addStockItem(ItemsIds.AMULET_OF_FORTITUDE);
        shop.addStockItem(ItemsIds.CELESTIAL_AMULET);
        shop.addStockItem(ItemsIds.DARKNESS_AMULET);

        // Rings
        shop.addStockItem(ItemsIds.RING_OF_POWER);
        shop.addStockItem(ItemsIds.RING_OF_SPELLCRAFTERS);
        shop.addStockItem(ItemsIds.ENDLESS_RING);
        shop.addStockItem(ItemsIds.RING_OF_CRAFTER);
        shop.addStockItem(ItemsIds.RING_OF_ALCHEMIST);

        // Special Jewels
        shop.addStockItem(ItemsIds.JEWEL_OF_RIGHTEOUS);
        shop.addStockItem(ItemsIds.JEWEL_OF_UNJUST);

        // Gems & Valuables
        shop.addStockItem(ItemsIds.RUBY);
        shop.addStockItem(ItemsIds.EMERALD);
        shop.addStockItem(ItemsIds.DIAMOND);
        shop.addStockItem(ItemsIds.SAPPHIRE);
        shop.addStockItem(ItemsIds.GOLD_BAG);

        shop.itemsTypes.add(Enums.ItemType.JEWEL);
        shop.itemsTypes.add(Enums.ItemType.VALUABLE);

        return shop;
    }
}

