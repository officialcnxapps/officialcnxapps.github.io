package com.cnx.endlesstalestwo.data.shops.dragonland;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class AffronisProductions {
    public Shop create() {
        Shop shop = new Shop("Affronis Productions", 1, 23);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Produtos do Affronis");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Productos de Affronis");
        shop.type = Enums.ShopType.POTIONS;

        // Regular Potions
        shop.addStockItem(ItemsIds.HP_POTION);
        shop.addStockItem(ItemsIds.MP_POTION);

        // Special Potions
        shop.addStockItem(ItemsIds.SPECIAL_HP_POTION);
        shop.addStockItem(ItemsIds.SPECIAL_MP_POTION);

        // Advanced Potions
        shop.addStockItem(ItemsIds.ELIXIR_POTION);

        shop.addStockItem(ItemsIds.ANTIDOTE);

        shop.addStockItem(ItemsIds.DRAGONLAND_MAP);
        shop.addStockItem(ItemsIds.DRAGON_SCALE);
        shop.addStockItem(ItemsIds.STRING);
        shop.addStockItem(ItemsIds.WOODCUTTERS_AXE);

        shop.itemsTypes.add(Enums.ItemType.POTION);
        shop.itemsTypes.add(Enums.ItemType.MISC);
        return shop;
    }
}

