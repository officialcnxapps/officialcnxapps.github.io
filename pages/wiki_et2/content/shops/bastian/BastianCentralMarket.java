package com.cnx.endlesstalestwo.data.shops.bastian;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class BastianCentralMarket {
    public Shop create() {
        Shop shop = new Shop("Bastian Central Market", 8, 20);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mercado Central de Bastian");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mercado Central de Bastian");
        shop.type = Enums.ShopType.GENERAL;

        // Magical Armor
        shop.addStockItem(ItemsIds.ORNATE_CLOAK);
        shop.addStockItem(ItemsIds.HAT_OF_WISE);
        shop.addStockItem(ItemsIds.HOOD_OF_MAGICIAN);

        // Copper Armor Set
        shop.addStockItem(ItemsIds.COPPER_ARMOR);
        shop.addStockItem(ItemsIds.COPPER_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.COPPER_SHIELD);
        shop.addStockItem(ItemsIds.COPPER_BOOTS);
        shop.addStockItem(ItemsIds.COPPER_HELMET);

        // Iron Armor Set
        shop.addStockItem(ItemsIds.IRON_ARMOR);
        shop.addStockItem(ItemsIds.IRON_BOOTS);
        shop.addStockItem(ItemsIds.IRON_HELMET);
        shop.addStockItem(ItemsIds.IRON_CHEST_PLATE);
        shop.addStockItem(ItemsIds.IRON_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.IRON_SHIELD);

        // Weapons
        shop.addStockItem(ItemsIds.IRON_SWORD);
        shop.addStockItem(ItemsIds.MAGIC_ROD);
        shop.addStockItem(ItemsIds.THROWING_KNIVES);
        shop.addStockItem(ItemsIds.HEAVY_MACE);
        shop.addStockItem(ItemsIds.LONG_DAGGER);
        shop.addStockItem(ItemsIds.SPELLWAND_OF_SORCERY);
        shop.addStockItem(ItemsIds.LONG_OAK_BOW);
        shop.addStockItem(ItemsIds.STEEL_BATTLE_AXE);
        shop.addStockItem(ItemsIds.GIANT_SWORD);
        shop.addStockItem(ItemsIds.SHADOW_DAGGER);
        shop.addStockItem(ItemsIds.STEEL_SPEAR);
        shop.addStockItem(ItemsIds.SHADOW_DAGGER);
        shop.addStockItem(ItemsIds.WAND_OF_FORTITUDE);

        // Bags
        shop.addStockItem(ItemsIds.LEATHER_BAG);
        shop.addStockItem(ItemsIds.GREAT_LEATHER_BAG);

        // Materials & Ingredients
        shop.addStockItem(ItemsIds.IRON_INGOT);
        shop.addStockItem(ItemsIds.COPPER_INGOT);
        shop.addStockItem(ItemsIds.COAL);
        shop.addStockItem(ItemsIds.PLANK);
        shop.addStockItem(ItemsIds.TISSUE);
        shop.addStockItem(ItemsIds.WOOL);
        shop.addStockItem(ItemsIds.STRING);
        shop.addStockItem(ItemsIds.ARMOR_MOLD);
        shop.addStockItem(ItemsIds.HELMET_MOLD);
        shop.addStockItem(ItemsIds.COTTON);
        shop.addStockItem(ItemsIds.HUNTING_TRAP);

        // Misc & Maps
        shop.addStockItem(ItemsIds.TORCH);
        shop.addStockItem(ItemsIds.HAVARUS_SOUTH_MAP);

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

