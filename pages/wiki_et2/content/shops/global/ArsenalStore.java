package com.cnx.endlesstalestwo.data.shops.global;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class ArsenalStore {
    public Shop create() {
        Shop shop = new Shop("Arsenal Store", 7, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Loja de Arsenal");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tienda de Arsenal");
        shop.type = Enums.ShopType.WEAPONS;

        // Basic Weapons
        shop.addStockItem(ItemsIds.WOODCUTTERS_AXE);
        shop.addStockItem(ItemsIds.WOODEN_SPEAR);
        shop.addStockItem(ItemsIds.OAK_STAFF);

        // Iron & Copper Weapons
        shop.addStockItem(ItemsIds.IRON_SWORD);
        shop.addStockItem(ItemsIds.COPPER_SWORD);
        shop.addStockItem(ItemsIds.COPPER_HAMMER);

        // Steel & Gold Weapons
        shop.addStockItem(ItemsIds.STEEL_BATTLE_AXE);
        shop.addStockItem(ItemsIds.GOLD_DAGGER);
        shop.addStockItem(ItemsIds.GIANT_SWORD);

        // Daggers & Knives
        shop.addStockItem(ItemsIds.LONG_DAGGER);
        shop.addStockItem(ItemsIds.THROWING_KNIVES);
        shop.addStockItem(ItemsIds.SHADOW_DAGGER);

        // Maces
        shop.addStockItem(ItemsIds.HEAVY_MACE);

        // Bows & Crossbows
        shop.addStockItem(ItemsIds.LONG_OAK_BOW);
        shop.addStockItem(ItemsIds.HEAVY_CROSSBOW);

        // Magical Weapons
        shop.addStockItem(ItemsIds.MAGIC_ROD);
        shop.addStockItem(ItemsIds.SPELLWAND_OF_SORCERY);
        shop.addStockItem(ItemsIds.WAND_OF_FORTITUDE);

        shop.itemsTypes.add(Enums.ItemType.WEAPON);
        shop.itemsTypes.add(Enums.ItemType.MAGICAL_WEAPON);
        return shop;
    }
}

