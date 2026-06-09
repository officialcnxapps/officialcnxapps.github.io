package com.cnx.endlesstalestwo.data.shops.growrocks;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class DwarvenMarket {
    public Shop create() {
        Shop shop = new Shop("Dwarven Market", 6, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mercado dos Anões");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mercado de los Enanos");
        shop.type = Enums.ShopType.GENERAL;

        // Mining Tools
        shop.addStockItem(ItemsIds.STEEL_PICKAXE);
        shop.addStockItem(ItemsIds.DWARVENS_PICKAXE);

        // Food - Mushrooms
        shop.addStockItem(ItemsIds.DARK_MUSHROOM);
        shop.addStockItem(ItemsIds.BROWN_MUSHROOM);
        shop.addStockItem(ItemsIds.SOUP);

        // Caltranium Armor
        shop.addStockItem(ItemsIds.CALTRANIUM_ARMOR);
        shop.addStockItem(ItemsIds.CALTRANIUM_LEGS);
        shop.addStockItem(ItemsIds.CALTRANIUM_SHIELD);
        shop.addStockItem(ItemsIds.CALTRANIUM_BOOTS);
        shop.addStockItem(ItemsIds.CALTRANIUM_HELMET);

        // Jewelry
        shop.addStockItem(ItemsIds.RING_OF_CRAFTER);

        // Materials
        shop.addStockItem(ItemsIds.CALTRANIUM_ORE);
        shop.addStockItem(ItemsIds.CALTRANIUM_INGOT);

        // Maps & Books
        shop.addStockItem(ItemsIds.GROWROCKS_MAP);
        shop.addStockItem(ItemsIds.THE_MASTER_BOOK_OF_CRAFTER);

        shop.itemsTypes.add(Enums.ItemType.ARMOR);
        shop.itemsTypes.add(Enums.ItemType.LEGS);
        shop.itemsTypes.add(Enums.ItemType.SHIELD);
        shop.itemsTypes.add(Enums.ItemType.BOOTS);
        shop.itemsTypes.add(Enums.ItemType.HELMET);
        shop.itemsTypes.add(Enums.ItemType.MISC);
        shop.itemsTypes.add(Enums.ItemType.VALUABLE);
        return shop;
    }
}

