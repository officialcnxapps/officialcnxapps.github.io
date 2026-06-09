package com.cnx.endlesstalestwo.data.shops.wazel;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class WazelArsenal {
    public Shop create() {
        Shop shop = new Shop("Wazel Arsenal", 8, 20);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Arsenal de Wazel");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Arsenal de Wazel");
        shop.type = Enums.ShopType.WEAPONS;

        // Copper Weapons
        shop.addStockItem(ItemsIds.COPPER_SWORD);
        shop.addStockItem(ItemsIds.COPPER_HAMMER);

        // Steel Weapons
        shop.addStockItem(ItemsIds.STEEL_BATTLE_AXE);

        // Gold Weapons
        shop.addStockItem(ItemsIds.GOLD_DAGGER);

        // Other Weapons
        shop.addStockItem(ItemsIds.GIANT_SWORD);
        shop.addStockItem(ItemsIds.HEAVY_MACE);
        shop.addStockItem(ItemsIds.LONG_DAGGER);
        shop.addStockItem(ItemsIds.THROWING_KNIVES);
        shop.addStockItem(ItemsIds.BLADE_OF_FLAMES);

        // Bows & Crossbows
        shop.addStockItem(ItemsIds.LONG_OAK_BOW);
        shop.addStockItem(ItemsIds.HEAVY_CROSSBOW);

        // Magical Weapons
        shop.addStockItem(ItemsIds.MAGIC_ROD);
        shop.addStockItem(ItemsIds.SPELLWAND_OF_SORCERY);
        shop.addStockItem(ItemsIds.WAND_OF_FORTITUDE);
        shop.addStockItem(ItemsIds.SHADOW_DAGGER);

        // Shields
        shop.addStockItem(ItemsIds.WOODEN_SHIELD);
        shop.addStockItem(ItemsIds.COPPER_SHIELD);
        shop.addStockItem(ItemsIds.STEEL_SHIELD);

        // Armors
        shop.addStockItem(ItemsIds.COPPER_ARMOR);
        shop.addStockItem(ItemsIds.STEEL_ARMOR);

        // Legs
        shop.addStockItem(ItemsIds.COPPER_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.STEEL_LEGS_ARMOR);

        // Boots
        shop.addStockItem(ItemsIds.LEATHER_BOOTS);
        shop.addStockItem(ItemsIds.COPPER_BOOTS);
        shop.addStockItem(ItemsIds.STEEL_BOOTS);

        // Helmets
        shop.addStockItem(ItemsIds.LEATHER_CAP);
        shop.addStockItem(ItemsIds.COPPER_HELMET);
        shop.addStockItem(ItemsIds.STEEL_HELMET);

        shop.itemsTypes.add(Enums.ItemType.WEAPON);
        shop.itemsTypes.add(Enums.ItemType.MAGICAL_WEAPON);
        shop.itemsTypes.add(Enums.ItemType.ARMOR);
        shop.itemsTypes.add(Enums.ItemType.LEGS);
        shop.itemsTypes.add(Enums.ItemType.SHIELD);
        shop.itemsTypes.add(Enums.ItemType.BOOTS);
        shop.itemsTypes.add(Enums.ItemType.HELMET);
        return shop;
    }
}

