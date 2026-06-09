package com.cnx.endlesstalestwo.data.shops.global;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class GriwalshProducts {
    public Shop create() {
        Shop shop = new Shop("Griwalsh Products", 6, 20);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Produtos do Griwalsh");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Productos del Griwalsh");
        shop.type = Enums.ShopType.POTIONS;

        // Regular Potions
        shop.addStockItem(ItemsIds.HP_POTION);
        shop.addStockItem(ItemsIds.MP_POTION);

        // Special Potions
        shop.addStockItem(ItemsIds.SPECIAL_HP_POTION);
        shop.addStockItem(ItemsIds.SPECIAL_MP_POTION);

        // Advanced Potions
        shop.addStockItem(ItemsIds.ELIXIR_POTION);
        shop.addStockItem(ItemsIds.EXPERTISE_POTION);

        // Antidote
        shop.addStockItem(ItemsIds.ANTIDOTE);

        shop.addStockItem(ItemsIds.GREEN_HERB);
        shop.addStockItem(ItemsIds.YELLOW_HERB);
        shop.addStockItem(ItemsIds.RED_HERB);
        shop.addStockItem(ItemsIds.WATER);
        shop.addStockItem(ItemsIds.CARROT);


        shop.itemsTypes.add(Enums.ItemType.POTION);
        shop.itemsTypes.add(Enums.ItemType.MISC);
        return shop;
    }
}

