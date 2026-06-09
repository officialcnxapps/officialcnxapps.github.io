package com.cnx.endlesstalestwo.data.shops.global;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class BasicFoodShop {
    public Shop create() {
        Shop shop = new Shop("Food Store", 6, 21);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Loja de Comida");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tienda de Alimentación");
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

        // Beverages
        shop.addStockItem(ItemsIds.WATER);

        // Mushrooms
        shop.addStockItem(ItemsIds.WHITE_MUSHROOM);
        shop.addStockItem(ItemsIds.BROWN_MUSHROOM);

        // Other Foods
        shop.addStockItem(ItemsIds.NUTS);

        shop.itemsTypes.add(Enums.ItemType.FOOD);
        return shop;
    }
}

