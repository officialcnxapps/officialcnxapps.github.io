package com.cnx.endlesstalestwo.data.shops.global;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Shop;
import com.cnx.endlesstalestwo.enums.Enums;

public class CrafterPoint {
    public Shop create() {
        Shop shop = new Shop("Crafter Point", 6, 18);
        shop.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ponto dos Produtores");
        shop.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Punto de Productores");
        shop.type = Enums.ShopType.INGREDIENTS;

        // Herbs & Plants
        shop.addStockItem(ItemsIds.GREEN_HERB);
        shop.addStockItem(ItemsIds.RED_HERB);
        shop.addStockItem(ItemsIds.ALGAE);

        // Wood Materials
        shop.addStockItem(ItemsIds.LOG);
        shop.addStockItem(ItemsIds.PLANK);
        shop.addStockItem(ItemsIds.BRANCH);

        // Textile Materials
        shop.addStockItem(ItemsIds.STRING);
        shop.addStockItem(ItemsIds.TISSUE);
        shop.addStockItem(ItemsIds.LEATHER);
        shop.addStockItem(ItemsIds.WOOL);
        shop.addStockItem(ItemsIds.COTTON);

        // Other Materials
        shop.addStockItem(ItemsIds.COAL);
        shop.addStockItem(ItemsIds.ROCK);
        shop.addStockItem(ItemsIds.WATER);

        shop.itemsTypes.add(Enums.ItemType.MISC);
        return shop;
    }
}

