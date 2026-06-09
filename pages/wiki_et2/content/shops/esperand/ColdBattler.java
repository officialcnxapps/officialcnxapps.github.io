package com.cnx.endlesstalestwo.data.shops.esperand;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class ColdBattler {
    public Shop create() {
        Shop shop = new Shop("Cold Battler", 7, 19);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Guerreiro Invernal");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "");
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
        shop.addStockItem(ItemsIds.GLACIER_MACE);
        shop.addStockItem(ItemsIds.KNIVES_OF_BREEZE);

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

        // Armor - Boots
        shop.addStockItem(ItemsIds.LEATHER_BOOTS);
        shop.addStockItem(ItemsIds.IRON_BOOTS);

        // Armor - Legs
        shop.addStockItem(ItemsIds.IRON_LEGS_ARMOR);

        // Armor - Chest
        shop.addStockItem(ItemsIds.IRON_CHEST_PLATE);
        shop.addStockItem(ItemsIds.IRON_ARMOR);

        // Armor - Helmet
        shop.addStockItem(ItemsIds.IRON_HELMET);
        shop.addStockItem(ItemsIds.LEATHER_CAP);

        // Shields
        shop.addStockItem(ItemsIds.IRON_SHIELD);

        // Maps
        shop.addStockItem(ItemsIds.ESPERAND_MAP);

        shop.itemsTypes.add(Enums.ItemType.WEAPON);
        shop.itemsTypes.add(Enums.ItemType.MAGICAL_WEAPON);
        shop.itemsTypes.add(Enums.ItemType.SHIELD);
        return shop;
    }
}

