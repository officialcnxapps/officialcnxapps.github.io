package com.cnx.endlesstalestwo.data.shops.global;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class FarmProductions {
    public Shop create() {
        Shop shop = new Shop("Farm Productions", 5, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Produções da Fazenda");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Producciones Agrícolas");
        shop.type = Enums.ShopType.GENERAL;

        // Fruits & Vegetables
        shop.addStockItem(ItemsIds.POMEGRANATE);
        shop.addStockItem(ItemsIds.CARROT);

        // Ingredients
        shop.addStockItem(ItemsIds.FLOUR);
        shop.addStockItem(ItemsIds.EGG);

        // Prepared Food
        shop.addStockItem(ItemsIds.BREAD);
        shop.addStockItem(ItemsIds.SOUP);
        shop.addStockItem(ItemsIds.SPECIAL_SOUP);

        // Beverages
        shop.addStockItem(ItemsIds.BEER);

        // Materials
        shop.addStockItem(ItemsIds.WOOL);
        shop.addStockItem(ItemsIds.COTTON);

        shop.itemsTypes.add(Enums.ItemType.FOOD);
        return shop;
    }
}

