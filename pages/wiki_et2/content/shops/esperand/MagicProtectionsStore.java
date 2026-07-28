package com.cnx.endlesstalestwo.data.shops.esperand;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class MagicProtectionsStore {
    public Shop create() {
        Shop shop = new Shop("Magic Protections Store", 7, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Loja das Proteções Mágicas");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tienda de Protecciones Mágicas");
        shop.type = Enums.ShopType.ARMORS;

        // Magical Helmets
        shop.addStockItem(ItemsIds.HAT_OF_WISE);
        shop.addStockItem(ItemsIds.HOOD_OF_MAGICIAN);
        shop.addStockItem(ItemsIds.HELM_OF_FOCUS);

        // Magical Chest Armor
        shop.addStockItem(ItemsIds.BREASTPLATE_OF_SHADOWS);
        shop.addStockItem(ItemsIds.BREASTPLATE_OF_FIRE);
        shop.addStockItem(ItemsIds.CLOAK_OF_ALCHEMISTS);

        // Magical Shields
        shop.addStockItem(ItemsIds.BLAZE_SHIELD);
        shop.addStockItem(ItemsIds.GLACIER_SHIELD);
        shop.addStockItem(ItemsIds.NATURE_SHIELD);
        shop.addStockItem(ItemsIds.CELESTIAL_SHIELD);
        shop.addStockItem(ItemsIds.DARKNESS_SHIELD);

        // Endless Armor
        shop.addStockItem(ItemsIds.ENDLESS_ARMOR);
        shop.addStockItem(ItemsIds.ENDLESS_LEGS_ARMOR);
        shop.addStockItem(ItemsIds.ENDLESS_SHIELD);
        shop.addStockItem(ItemsIds.ENDLESS_HELMET);
        shop.addStockItem(ItemsIds.ENDLESS_BOOTS);

        shop.itemsTypes.add(Enums.ItemType.ARMOR);
        shop.itemsTypes.add(Enums.ItemType.LEGS);
        shop.itemsTypes.add(Enums.ItemType.SHIELD);
        shop.itemsTypes.add(Enums.ItemType.BOOTS);
        shop.itemsTypes.add(Enums.ItemType.HELMET);
        return shop;
    }
}

