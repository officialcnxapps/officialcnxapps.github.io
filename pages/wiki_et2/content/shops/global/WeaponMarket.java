package com.cnx.endlesstalestwo.data.shops.global;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class WeaponMarket {
    public Shop create() {
        Shop shop = new Shop("Weapon Market", 7, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mercado das Armas");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mercado de Armas");
        shop.type = Enums.ShopType.WEAPONS;

        // Copper & Steel Weapons
        shop.addStockItem(ItemsIds.COPPER_SWORD);
        shop.addStockItem(ItemsIds.COPPER_HAMMER);
        shop.addStockItem(ItemsIds.STEEL_BATTLE_AXE);

        // Gold & Advanced Weapons
        shop.addStockItem(ItemsIds.GOLD_DAGGER);
        shop.addStockItem(ItemsIds.GIANT_SWORD);
        shop.addStockItem(ItemsIds.CALTRANIUM_SWORD);

        // Daggers & Knives
        shop.addStockItem(ItemsIds.LONG_DAGGER);
        shop.addStockItem(ItemsIds.THROWING_KNIVES);
        shop.addStockItem(ItemsIds.SHADOW_DAGGER);

        // Maces
        shop.addStockItem(ItemsIds.HEAVY_MACE);
        shop.addStockItem(ItemsIds.MACE_OF_ORDENANCE);

        // Bows & Crossbows
        shop.addStockItem(ItemsIds.LONG_OAK_BOW);
        shop.addStockItem(ItemsIds.HEAVY_CROSSBOW);
        shop.addStockItem(ItemsIds.AUTOMATIC_CROSSBOW);

        // Magical Weapons - Basic
        shop.addStockItem(ItemsIds.MAGIC_ROD);
        shop.addStockItem(ItemsIds.SPELLWAND_OF_SORCERY);
        shop.addStockItem(ItemsIds.WAND_OF_FORTITUDE);

        // Magical Weapons - Advanced
        shop.addStockItem(ItemsIds.SKILLFULS_STAFF);
        shop.addStockItem(ItemsIds.ROD_OF_MASTERS);
        shop.addStockItem(ItemsIds.ROD_OF_RIGHTEOUS);
        shop.addStockItem(ItemsIds.ROD_OF_UNJUST);

        // Endless Weapons
        shop.addStockItem(ItemsIds.ENDLESS_SWORD);
        shop.addStockItem(ItemsIds.ENDLESS_WAND);
        shop.addStockItem(ItemsIds.ENDLESS_BOW);

        shop.itemsTypes.add(Enums.ItemType.WEAPON);
        shop.itemsTypes.add(Enums.ItemType.MAGICAL_WEAPON);
        return shop;
    }
}

