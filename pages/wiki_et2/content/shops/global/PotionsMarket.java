package com.cnx.endlesstalestwo.data.shops.global;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class PotionsMarket {
    public Shop create() {
        Shop shop = new Shop("Potions Market", 6, 19);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mercado de Poções");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mercado de Pociones");
        shop.type = Enums.ShopType.POTIONS;

        // Simple Potions
        shop.addStockItem(ItemsIds.SIMPLE_MP_POTION);
        shop.addStockItem(ItemsIds.SIMPLE_HP_POTION);

        // Regular Potions
        shop.addStockItem(ItemsIds.HP_POTION);
        shop.addStockItem(ItemsIds.MP_POTION);

        // Special Potions
        shop.addStockItem(ItemsIds.SPECIAL_HP_POTION);
        shop.addStockItem(ItemsIds.SPECIAL_MP_POTION);

        // Advanced Potions
        shop.addStockItem(ItemsIds.ELIXIR_POTION);
        shop.addStockItem(ItemsIds.MEAD_POTION);

        // Antidote
        shop.addStockItem(ItemsIds.ANTIDOTE);

        shop.itemsTypes.add(Enums.ItemType.POTION);
        return shop;
    }
}

