package com.cnx.endlesstalestwo.data.shops.lisport;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class PotionBreedersUnion {
    public Shop create() {
        Shop shop = new Shop("Potion Breeders Union", 7, 17);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "União dos Criadores de Poções");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Unión de Criadores de Pociones");
        shop.type = Enums.ShopType.POTIONS;

        // Herbs & Ingredients
        shop.addStockItem(ItemsIds.GREEN_HERB);
        shop.addStockItem(ItemsIds.RED_HERB);
        shop.addStockItem(ItemsIds.YELLOW_HERB);
        shop.addStockItem(ItemsIds.ALGAE);
        shop.addStockItem(ItemsIds.COAL);
        shop.addStockItem(ItemsIds.WATER);

        // Simple Potions
        shop.addStockItem(ItemsIds.SIMPLE_HP_POTION);
        shop.addStockItem(ItemsIds.SIMPLE_MP_POTION);

        // Other Potions
        shop.addStockItem(ItemsIds.MEAD_POTION);
        shop.addStockItem(ItemsIds.ANTIDOTE);

        shop.addStockItem(ItemsIds.ALCHEMY_ANNOTATIONS);

        shop.itemsTypes.add(Enums.ItemType.POTION);
        return shop;
    }
}

