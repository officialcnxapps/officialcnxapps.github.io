package com.cnx.endlesstalestwo.data.shops.umera;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class EldrinShop {
    public Shop create() {
        Shop shop = new Shop("Eldrin's Forge", 7, 19);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forja do Eldrin");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Forja de Eldrin");
        shop.type = Enums.ShopType.WEAPONS;

        shop.addStockItem(ItemsIds.GYBRALAR_FOREST_MAP);

        // Iron Weapons
        shop.addStockItem(ItemsIds.IRON_SWORD);
        shop.addStockItem(ItemsIds.HEAVY_MACE);

        // Steel Weapons
        shop.addStockItem(ItemsIds.STEEL_BATTLE_AXE);
        shop.addStockItem(ItemsIds.GIANT_SWORD);
        shop.addStockItem(ItemsIds.COPPER_HAMMER);

        // Gold Weapons
        shop.addStockItem(ItemsIds.GOLD_DAGGER);

        shop.addStockItem(ItemsIds.HEAVY_CROSSBOW);
        shop.addStockItem(ItemsIds.OAK_STAFF);

        // Iron Armor
        shop.addStockItem(ItemsIds.IRON_CHEST_PLATE);
        shop.addStockItem(ItemsIds.IRON_ARMOR);
        shop.addStockItem(ItemsIds.IRON_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.IRON_HELMET);
        shop.addStockItem(ItemsIds.IRON_BOOTS);
        shop.addStockItem(ItemsIds.IRON_SHIELD);

        // Steel Armor
        shop.addStockItem(ItemsIds.STEEL_ARMOR);
        shop.addStockItem(ItemsIds.STEEL_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.STEEL_HELMET);
        shop.addStockItem(ItemsIds.STEEL_BOOTS);
        shop.addStockItem(ItemsIds.STEEL_SHIELD);

        // Gold Armor
        shop.addStockItem(ItemsIds.GOLDEN_ARMOR);
        shop.addStockItem(ItemsIds.GOLDEN_TROUSERS);
        shop.addStockItem(ItemsIds.GOLDEN_HELMET);
        shop.addStockItem(ItemsIds.GOLDEN_BOOTS);
        shop.addStockItem(ItemsIds.GOLD_SHIELD);

        shop.itemsTypes.add(Enums.ItemType.WEAPON);
        shop.itemsTypes.add(Enums.ItemType.ARMOR);
        shop.itemsTypes.add(Enums.ItemType.LEGS);
        shop.itemsTypes.add(Enums.ItemType.SHIELD);
        shop.itemsTypes.add(Enums.ItemType.HELMET);
        shop.itemsTypes.add(Enums.ItemType.BOOTS);

        return shop;
    }
}

