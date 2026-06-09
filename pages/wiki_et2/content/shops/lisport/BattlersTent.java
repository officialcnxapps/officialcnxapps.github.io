package com.cnx.endlesstalestwo.data.shops.lisport;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class BattlersTent {
    public Shop create() {
        Shop shop = new Shop("Battlers Tent", 7, 17);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Tenda dos Batalhadores");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tienda de los Luchadores");
        shop.type = Enums.ShopType.GENERAL;

        // Armor - Chest
        shop.addStockItem(ItemsIds.LEATHER_JACKET);
        shop.addStockItem(ItemsIds.REINFORCED_LEATHER_JACKET);
        shop.addStockItem(ItemsIds.IRON_CHEST_PLATE);
        shop.addStockItem(ItemsIds.IRON_ARMOR);
        shop.addStockItem(ItemsIds.SPELLCRAFTER_TUNIC);
        shop.addStockItem(ItemsIds.HEAVY_ROBE);

        // Armor - Legs
        shop.addStockItem(ItemsIds.REINFORCED_TROUSERS);
        shop.addStockItem(ItemsIds.IRON_LEGS_ARMOR);

        // Shields
        shop.addStockItem(ItemsIds.PLANK_SHIELD);
        shop.addStockItem(ItemsIds.WOODEN_SHIELD);
        shop.addStockItem(ItemsIds.IRON_SHIELD);

        // Boots
        shop.addStockItem(ItemsIds.LEATHER_BOOTS);
        shop.addStockItem(ItemsIds.IRON_BOOTS);
        shop.addStockItem(ItemsIds.COPPER_BOOTS);

        // Helmets
        shop.addStockItem(ItemsIds.LEATHER_CAP);
        shop.addStockItem(ItemsIds.IRON_HELMET);
        shop.addStockItem(ItemsIds.HOOD_OF_MAGICIAN);

        // Weapons
        shop.addStockItem(ItemsIds.WOODCUTTERS_AXE);
        shop.addStockItem(ItemsIds.IRON_SWORD);
        shop.addStockItem(ItemsIds.OAK_STAFF);
        shop.addStockItem(ItemsIds.WOODEN_SPEAR);
        shop.addStockItem(ItemsIds.COPPER_SWORD);
        shop.addStockItem(ItemsIds.MAGIC_ROD);
        shop.addStockItem(ItemsIds.THROWING_KNIVES);
        shop.addStockItem(ItemsIds.HEAVY_MACE);

        // Bags
        shop.addStockItem(ItemsIds.LEATHER_BAG);

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

