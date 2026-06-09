package com.cnx.endlesstalestwo.data.shops.umera;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class MinersWarehouse {
    public Shop create() {
        Shop shop = new Shop("Miners Warehouse", 6, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Galpão dos Mineradores");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "");
        shop.type = Enums.ShopType.GENERAL;

        // Mining Tools
        shop.addStockItem(ItemsIds.PICKAXE);
        shop.addStockItem(ItemsIds.STEEL_PICKAXE);

        // Fishing Tools
        shop.addStockItem(ItemsIds.FISHING_ROD);

        // Woodcutting Tools
        shop.addStockItem(ItemsIds.WOODCUTTERS_AXE);

        // Hunting Tools
        shop.addStockItem(ItemsIds.HUNTING_TRAP);

        // Ores & Ingots
        shop.addStockItem(ItemsIds.IRON_ORE);
        shop.addStockItem(ItemsIds.IRON_INGOT);
        shop.addStockItem(ItemsIds.COPPER_ORE);
        shop.addStockItem(ItemsIds.COPPER_INGOT);
        shop.addStockItem(ItemsIds.GOLD_ORE);
        shop.addStockItem(ItemsIds.COAL);

        // Materials
        shop.addStockItem(ItemsIds.STRING);
        shop.addStockItem(ItemsIds.ROPE);

        // Misc
        shop.addStockItem(ItemsIds.TORCH);

        // Maps
        shop.addStockItem(ItemsIds.HAVARUS_SOUTH_MAP);
        shop.addStockItem(ItemsIds.GYBRALAR_FOREST_MAP);

        shop.itemsTypes.add(Enums.ItemType.TOOL);
        return shop;
    }
}

