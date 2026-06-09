package com.cnx.endlesstalestwo.data.shops.esperand;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class NotFrozenFoods {
    public Shop create() {
        Shop shop = new Shop("Not Frozen Foods", 6, 19);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Comidas não Congeladas");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "");
        shop.type = Enums.ShopType.GENERAL;

        // Fruits & Vegetables
        shop.addStockItem(ItemsIds.POMEGRANATE);
        shop.addStockItem(ItemsIds.CARROT);

        // Ingredients
        shop.addStockItem(ItemsIds.EGG);

        // Prepared Food
        shop.addStockItem(ItemsIds.BREAD);
        shop.addStockItem(ItemsIds.SOUP);
        shop.addStockItem(ItemsIds.SPECIAL_SOUP);
        shop.addStockItem(ItemsIds.COOKED_CRAB);
        shop.addStockItem(ItemsIds.COOKED_MEAT);

        // Beverages
        shop.addStockItem(ItemsIds.BEER);
        shop.addStockItem(ItemsIds.WATER);
        shop.addStockItem(ItemsIds.WINE);

        shop.itemsTypes.add(Enums.ItemType.FOOD);
        return shop;
    }
}

