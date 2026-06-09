package com.cnx.endlesstalestwo.data.shops.monelix;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class TheFoodTent {
    public Shop create() {
        Shop shop = new Shop("The Food Tent", 6, 20);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A Tenda do Alimento");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "La Tienda de Alimentos");
        shop.type = Enums.ShopType.GENERAL;

        // Fruits & Vegetables
        shop.addStockItem(ItemsIds.POMEGRANATE);
        shop.addStockItem(ItemsIds.CARROT);

        // Ingredients
        shop.addStockItem(ItemsIds.FLOUR);
        shop.addStockItem(ItemsIds.EGG);

        // Meat & Fish
        shop.addStockItem(ItemsIds.RAW_MEAT);
        shop.addStockItem(ItemsIds.SARDINE);

        // Prepared Food
        shop.addStockItem(ItemsIds.BREAD);
        shop.addStockItem(ItemsIds.SOUP);
        shop.addStockItem(ItemsIds.SEASONED_MEAT);
        shop.addStockItem(ItemsIds.COOKED_MEAT);
        shop.addStockItem(ItemsIds.COOKED_CRAB);

        // Beverages
        shop.addStockItem(ItemsIds.WATER);

        // Mushrooms
        shop.addStockItem(ItemsIds.WHITE_MUSHROOM);
        shop.addStockItem(ItemsIds.BROWN_MUSHROOM);

        // Other Foods
        shop.addStockItem(ItemsIds.NUTS);

        // Books
        shop.addStockItem(ItemsIds.THE_COOK_BOOK);

        shop.itemsTypes.add(Enums.ItemType.FOOD);
        return shop;
    }
}

