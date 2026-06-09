package com.cnx.endlesstalestwo.data.shops.monelix;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class TheGreatMarket {
    public Shop create() {
        Shop shop = new Shop("The Great Market", 6, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O Grande Mercado");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "El Gran Mercado");
        shop.type = Enums.ShopType.GENERAL;

        // Magical Armor - Chest & Helmets
        shop.addStockItem(ItemsIds.ORNATE_CLOAK);
        shop.addStockItem(ItemsIds.HAT_OF_WISE);
        shop.addStockItem(ItemsIds.HOOD_OF_MAGICIAN);
        shop.addStockItem(ItemsIds.HELM_OF_FOCUS);

        // Copper Armor Set
        shop.addStockItem(ItemsIds.COPPER_ARMOR);
        shop.addStockItem(ItemsIds.COPPER_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.COPPER_SHIELD);
        shop.addStockItem(ItemsIds.COPPER_BOOTS);
        shop.addStockItem(ItemsIds.COPPER_HELMET);

        // Steel Armor Set
        shop.addStockItem(ItemsIds.STEEL_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.STEEL_SHIELD);
        shop.addStockItem(ItemsIds.STEEL_HELMET);
        shop.addStockItem(ItemsIds.STEEL_ARMOR);
        shop.addStockItem(ItemsIds.STEEL_BOOTS);

        // Gold Armor Set
        shop.addStockItem(ItemsIds.GOLDEN_TROUSERS);
        shop.addStockItem(ItemsIds.GOLD_SHIELD);
        shop.addStockItem(ItemsIds.GOLDEN_HELMET);
        shop.addStockItem(ItemsIds.GOLDEN_ARMOR);
        shop.addStockItem(ItemsIds.GOLDEN_BOOTS);

        // Special Shields
        shop.addStockItem(ItemsIds.LARGE_SHIELD);

        // Caltranium Armor Set
        shop.addStockItem(ItemsIds.CALTRANIUM_ARMOR);
        shop.addStockItem(ItemsIds.CALTRANIUM_LEGS);
        shop.addStockItem(ItemsIds.CALTRANIUM_SHIELD);
        shop.addStockItem(ItemsIds.CALTRANIUM_BOOTS);
        shop.addStockItem(ItemsIds.CALTRANIUM_HELMET);

        // Endless Armor Set
        shop.addStockItem(ItemsIds.ENDLESS_ARMOR);
        shop.addStockItem(ItemsIds.ENDLESS_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.ENDLESS_SHIELD);
        shop.addStockItem(ItemsIds.ENDLESS_HELMET);
        shop.addStockItem(ItemsIds.ENDLESS_BOOTS);

        // Weapons - Basic & Medium
        shop.addStockItem(ItemsIds.COPPER_SWORD);
        shop.addStockItem(ItemsIds.MAGIC_ROD);
        shop.addStockItem(ItemsIds.THROWING_KNIVES);
        shop.addStockItem(ItemsIds.HEAVY_MACE);
        shop.addStockItem(ItemsIds.LONG_DAGGER);
        shop.addStockItem(ItemsIds.SPELLWAND_OF_SORCERY);
        shop.addStockItem(ItemsIds.LONG_OAK_BOW);
        shop.addStockItem(ItemsIds.STEEL_BATTLE_AXE);
        shop.addStockItem(ItemsIds.COPPER_HAMMER);
        shop.addStockItem(ItemsIds.GIANT_SWORD);
        shop.addStockItem(ItemsIds.SHADOW_DAGGER);
        shop.addStockItem(ItemsIds.WAND_OF_FORTITUDE);
        shop.addStockItem(ItemsIds.HEAVY_CROSSBOW);
        shop.addStockItem(ItemsIds.KNIVES_OF_BREEZE);
        shop.addStockItem(ItemsIds.STEEL_SPEAR);
        shop.addStockItem(ItemsIds.FIRE_SWORD);

        // Weapons - Advanced
        shop.addStockItem(ItemsIds.CALTRANIUM_SWORD);
        shop.addStockItem(ItemsIds.GOLD_DAGGER);
        shop.addStockItem(ItemsIds.SKILLFULS_STAFF);
        shop.addStockItem(ItemsIds.ROD_OF_MASTERS);
        shop.addStockItem(ItemsIds.MACE_OF_ORDENANCE);
        shop.addStockItem(ItemsIds.ROD_OF_RIGHTEOUS);
        shop.addStockItem(ItemsIds.ROD_OF_UNJUST);

        // Endless Weapons
        shop.addStockItem(ItemsIds.ENDLESS_SWORD);
        shop.addStockItem(ItemsIds.ENDLESS_WAND);
        shop.addStockItem(ItemsIds.ENDLESS_BOW);
        shop.addStockItem(ItemsIds.AUTOMATIC_CROSSBOW);

        // Supreme Equipment
        shop.addStockItem(ItemsIds.SUPREME_BOOTS);
        shop.addStockItem(ItemsIds.SUPREME_CHEST_PLATE);
        shop.addStockItem(ItemsIds.SUPREME_HELM);

        // Bags
        shop.addStockItem(ItemsIds.LEATHER_BAG);
        shop.addStockItem(ItemsIds.GREAT_LEATHER_BAG);
        shop.addStockItem(ItemsIds.MAGICAL_BACKPACK);
        shop.addStockItem(ItemsIds.ENDLESS_BACKPACK);

        // Misc
        shop.addStockItem(ItemsIds.TORCH);

        shop.itemsTypes.add(Enums.ItemType.WEAPON);
        shop.itemsTypes.add(Enums.ItemType.MAGICAL_WEAPON);
        shop.itemsTypes.add(Enums.ItemType.ARMOR);
        shop.itemsTypes.add(Enums.ItemType.LEGS);
        shop.itemsTypes.add(Enums.ItemType.SHIELD);
        shop.itemsTypes.add(Enums.ItemType.BOOTS);
        shop.itemsTypes.add(Enums.ItemType.HELMET);
        shop.itemsTypes.add(Enums.ItemType.BAG);
        return shop;
    }
}

