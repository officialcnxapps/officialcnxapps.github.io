package com.cnx.endlesstalestwo.data.shops.helera;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class HeleraGardenTents {
    public Shop create() {
        Shop shop = new Shop("Helera Garden Tents", 8, 20);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Tendas do Jardim de Helera");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tentas de jardín de Helera");
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

        // Steel Armor Set
        shop.addStockItem(ItemsIds.STEEL_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.STEEL_SHIELD);
        shop.addStockItem(ItemsIds.STEEL_HELMET);
        shop.addStockItem(ItemsIds.STEEL_ARMOR);
        shop.addStockItem(ItemsIds.STEEL_BOOTS);

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

        // Weapons - Advanced
        shop.addStockItem(ItemsIds.SKILLFULS_STAFF);
        shop.addStockItem(ItemsIds.MACE_OF_ORDENANCE);
        shop.addStockItem(ItemsIds.ROD_OF_RIGHTEOUS);
        shop.addStockItem(ItemsIds.ROD_OF_UNJUST);

        // Bags
        shop.addStockItem(ItemsIds.GREAT_LEATHER_BAG);
        shop.addStockItem(ItemsIds.MAGICAL_BACKPACK);
        shop.addStockItem(ItemsIds.ENDLESS_BACKPACK);

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

