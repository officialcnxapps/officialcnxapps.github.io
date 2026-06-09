package com.cnx.endlesstalestwo.data.shops.global;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class ToolsShop {
    public Shop create() {
        Shop shop = new Shop("Tools Store", 6, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Loja de Ferramentas");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tienda de Hierramentas");
        shop.type = Enums.ShopType.GENERAL;

        // Mining Tools
        shop.addStockItem(ItemsIds.PICKAXE);

        // Fishing Tools
        shop.addStockItem(ItemsIds.FISHING_ROD);
        shop.addStockItem(ItemsIds.REINFORCED_FISHING_ROD);

        // Woodcutting Tools
        shop.addStockItem(ItemsIds.WOODCUTTERS_AXE);

        // Hunting Tools
        shop.addStockItem(ItemsIds.HUNTING_TRAP);

        // Ores & Ingots
        shop.addStockItem(ItemsIds.IRON_ORE);
        shop.addStockItem(ItemsIds.IRON_INGOT);
        shop.addStockItem(ItemsIds.COPPER_ORE);

        // Materials
        shop.addStockItem(ItemsIds.STRING);

        // Misc
        shop.addStockItem(ItemsIds.TORCH);
        shop.addStockItem(ItemsIds.ARMOR_MOLD);
        shop.addStockItem(ItemsIds.HELMET_MOLD);

        shop.itemsTypes.add(Enums.ItemType.TOOL);
        return shop;
    }
}

