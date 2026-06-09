package com.cnx.endlesstalestwo.data.shops.global;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class TheHumanFortress {
    public Shop create() {
        Shop shop = new Shop("The Human Fortress", 7, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A Fortaleza Humana");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "La fortaleza Humana");
        shop.type = Enums.ShopType.ARMORS;

        // Iron Armor
        shop.addStockItem(ItemsIds.IRON_ARMOR);
        shop.addStockItem(ItemsIds.IRON_SHIELD);
        shop.addStockItem(ItemsIds.IRON_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.IRON_BOOTS);
        shop.addStockItem(ItemsIds.IRON_HELMET);

        // Magical Armor
        shop.addStockItem(ItemsIds.SPELLCRAFTER_TUNIC);
        shop.addStockItem(ItemsIds.HEAVY_ROBE);
        shop.addStockItem(ItemsIds.ORNATE_CLOAK);

        // Magical Helmets
        shop.addStockItem(ItemsIds.HAT_OF_WISE);
        shop.addStockItem(ItemsIds.HOOD_OF_MAGICIAN);
        shop.addStockItem(ItemsIds.HELM_OF_FOCUS);

        // Copper Armor
        shop.addStockItem(ItemsIds.COPPER_ARMOR);
        shop.addStockItem(ItemsIds.COPPER_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.COPPER_SHIELD);
        shop.addStockItem(ItemsIds.COPPER_BOOTS);
        shop.addStockItem(ItemsIds.COPPER_HELMET);

        // Steel Armor
        shop.addStockItem(ItemsIds.STEEL_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.STEEL_SHIELD);
        shop.addStockItem(ItemsIds.STEEL_HELMET);
        shop.addStockItem(ItemsIds.STEEL_ARMOR);
        shop.addStockItem(ItemsIds.STEEL_BOOTS);

        // Gold Armor
        shop.addStockItem(ItemsIds.GOLDEN_TROUSERS);
        shop.addStockItem(ItemsIds.GOLD_SHIELD);
        shop.addStockItem(ItemsIds.GOLDEN_HELMET);
        shop.addStockItem(ItemsIds.GOLDEN_ARMOR);
        shop.addStockItem(ItemsIds.GOLDEN_BOOTS);

        // Special Shields
        shop.addStockItem(ItemsIds.LARGE_SHIELD);

        // Caltranium Armor
        shop.addStockItem(ItemsIds.CALTRANIUM_ARMOR);
        shop.addStockItem(ItemsIds.CALTRANIUM_LEGS);
        shop.addStockItem(ItemsIds.CALTRANIUM_SHIELD);
        shop.addStockItem(ItemsIds.CALTRANIUM_BOOTS);
        shop.addStockItem(ItemsIds.CALTRANIUM_HELMET);

        // Endless Armor
        shop.addStockItem(ItemsIds.ENDLESS_ARMOR);
        shop.addStockItem(ItemsIds.ENDLESS_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.ENDLESS_SHIELD);
        shop.addStockItem(ItemsIds.ENDLESS_HELMET);
        shop.addStockItem(ItemsIds.ENDLESS_BOOTS);

        // Supreme Armor
        shop.addStockItem(ItemsIds.SUPREME_BOOTS);
        shop.addStockItem(ItemsIds.SUPREME_CHEST_PLATE);
        shop.addStockItem(ItemsIds.SUPREME_HELM);

        shop.itemsTypes.add(Enums.ItemType.ARMOR);
        shop.itemsTypes.add(Enums.ItemType.LEGS);
        shop.itemsTypes.add(Enums.ItemType.SHIELD);
        shop.itemsTypes.add(Enums.ItemType.BOOTS);
        shop.itemsTypes.add(Enums.ItemType.HELMET);
        return shop;
    }
}

