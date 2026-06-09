package com.cnx.endlesstalestwo.data.shops.ayalon;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class ElvishMarket {
    public Shop create() {
        Shop shop = new Shop("Elvish Market", 6, 17);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mercado Élfico");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mercado Élfico");
        shop.type = Enums.ShopType.GENERAL;

        // Weapons
        shop.addStockItem(ItemsIds.ELVEN_BOW);
        shop.addStockItem(ItemsIds.KNIVES_OF_BREEZE);

        // Potions
        shop.addStockItem(ItemsIds.ELIXIR_POTION);
        shop.addStockItem(ItemsIds.HP_POTION);
        shop.addStockItem(ItemsIds.MP_POTION);
        shop.addStockItem(ItemsIds.EXPERTISE_POTION);

        // Food - Mushrooms
        shop.addStockItem(ItemsIds.WHITE_MUSHROOM);
        shop.addStockItem(ItemsIds.BROWN_MUSHROOM);
        shop.addStockItem(ItemsIds.DARK_MUSHROOM);
        shop.addStockItem(ItemsIds.NUTS);

        // Equipment
        shop.addStockItem(ItemsIds.NATURE_SHIELD);
        shop.addStockItem(ItemsIds.NATURE_NECKLACE);

        // Magical Items
        shop.addStockItem(ItemsIds.ROD_OF_RIGHTEOUS);
        shop.addStockItem(ItemsIds.JEWEL_OF_RIGHTEOUS);
        shop.addStockItem(ItemsIds.RING_OF_ALCHEMIST);

        shop.addStockItem(ItemsIds.AYALON_MAP);

        shop.itemsTypes.add(Enums.ItemType.ARMOR);
        shop.itemsTypes.add(Enums.ItemType.LEGS);
        shop.itemsTypes.add(Enums.ItemType.SHIELD);
        shop.itemsTypes.add(Enums.ItemType.BOOTS);
        shop.itemsTypes.add(Enums.ItemType.HELMET);

        return shop;
    }
}

