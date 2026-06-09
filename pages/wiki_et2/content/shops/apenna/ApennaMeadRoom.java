package com.cnx.endlesstalestwo.data.shops.apenna;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class ApennaMeadRoom {
    public Shop create() {
        Shop shop = new Shop("Apenna Mead Room", 6, 22);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Salão do Hidromel de Apenna");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Salón del Hidromiel de Apenna");
        shop.type = Enums.ShopType.GENERAL;

        // Foods
        shop.addStockItem(ItemsIds.BREAD);
        shop.addStockItem(ItemsIds.SOUP);
        shop.addStockItem(ItemsIds.COOKED_MEAT);
        shop.addStockItem(ItemsIds.NUTS);

        // Beverages
        shop.addStockItem(ItemsIds.WATER);
        shop.addStockItem(ItemsIds.BEER);
        shop.addStockItem(ItemsIds.WINE);
        shop.addStockItem(ItemsIds.MEAD_POTION);

        // Simple Potions
        shop.addStockItem(ItemsIds.SIMPLE_HP_POTION);
        shop.addStockItem(ItemsIds.SIMPLE_MP_POTION);
        shop.addStockItem(ItemsIds.ANTIDOTE);

        shop.itemsTypes.add(Enums.ItemType.FOOD);
        shop.itemsTypes.add(Enums.ItemType.POTION);
        return shop;
    }
}

