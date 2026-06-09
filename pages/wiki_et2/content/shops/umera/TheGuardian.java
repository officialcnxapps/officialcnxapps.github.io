package com.cnx.endlesstalestwo.data.shops.umera;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class TheGuardian {
    public Shop create() {
        Shop shop = new Shop("The Guardian", 8, 20);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O Guardião");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "");
        shop.type = Enums.ShopType.ARMORS;

        // Leather Armor
        shop.addStockItem(ItemsIds.LEATHER_JACKET);
        shop.addStockItem(ItemsIds.LEATHER_BOOTS);
        shop.addStockItem(ItemsIds.LEATHER_CAP);
        shop.addStockItem(ItemsIds.REINFORCED_LEATHER_JACKET);
        shop.addStockItem(ItemsIds.REINFORCED_TROUSERS);

        // Wooden Shields
        shop.addStockItem(ItemsIds.PLANK_SHIELD);
        shop.addStockItem(ItemsIds.WOODEN_SHIELD);

        // Iron Armor
        shop.addStockItem(ItemsIds.IRON_CHEST_PLATE);
        shop.addStockItem(ItemsIds.IRON_ARMOR);
        shop.addStockItem(ItemsIds.IRON_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.IRON_SHIELD);
        shop.addStockItem(ItemsIds.IRON_BOOTS);
        shop.addStockItem(ItemsIds.IRON_HELMET);

        // Copper Armor
        shop.addStockItem(ItemsIds.COPPER_ARMOR);
        shop.addStockItem(ItemsIds.COPPER_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.COPPER_SHIELD);
        shop.addStockItem(ItemsIds.COPPER_BOOTS);
        shop.addStockItem(ItemsIds.COPPER_HELMET);

        // Steel Armor
        shop.addStockItem(ItemsIds.STEEL_ARMOR);
        shop.addStockItem(ItemsIds.STEEL_SHIELD);
        shop.addStockItem(ItemsIds.STEEL_BOOTS);
        shop.addStockItem(ItemsIds.STEEL_HELMET);
        shop.addStockItem(ItemsIds.STEEL_LEGS_ARMOR);

        // Magical Armor
        shop.addStockItem(ItemsIds.SPELLCRAFTER_TUNIC);
        shop.addStockItem(ItemsIds.HEAVY_ROBE);
        shop.addStockItem(ItemsIds.ORNATE_CLOAK);

        // Magical Helmets
        shop.addStockItem(ItemsIds.HOOD_OF_MAGICIAN);
        shop.addStockItem(ItemsIds.HAT_OF_WISE);
        shop.addStockItem(ItemsIds.HELM_OF_FOCUS);

        shop.itemsTypes.add(Enums.ItemType.ARMOR);
        shop.itemsTypes.add(Enums.ItemType.LEGS);
        shop.itemsTypes.add(Enums.ItemType.SHIELD);
        shop.itemsTypes.add(Enums.ItemType.BOOTS);
        shop.itemsTypes.add(Enums.ItemType.HELMET);
        return shop;
    }
}

