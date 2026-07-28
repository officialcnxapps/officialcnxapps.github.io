package com.cnx.endlesstalestwo.data.shops;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.shops.apenna.ApennaMeadRoom;
import com.cnx.endlesstalestwo.data.shops.apenna.WoodcuttersWarehouse;
import com.cnx.endlesstalestwo.data.shops.ayalon.ElvishMarket;
import com.cnx.endlesstalestwo.data.shops.bastian.BastianCentralMarket;
import com.cnx.endlesstalestwo.data.shops.bastian.Jewelry;
import com.cnx.endlesstalestwo.data.shops.dragonland.AffronisProductions;
import com.cnx.endlesstalestwo.data.shops.esperand.ColdBattler;
import com.cnx.endlesstalestwo.data.shops.esperand.MagicProtectionsStore;
import com.cnx.endlesstalestwo.data.shops.esperand.NotFrozenFoods;
import com.cnx.endlesstalestwo.data.shops.fishermanVille.FishermanStore;
import com.cnx.endlesstalestwo.data.shops.global.ArsenalStore;
import com.cnx.endlesstalestwo.data.shops.global.BasicFoodShop;
import com.cnx.endlesstalestwo.data.shops.global.CommonStable;
import com.cnx.endlesstalestwo.data.shops.global.CrafterPoint;
import com.cnx.endlesstalestwo.data.shops.global.FarmProductions;
import com.cnx.endlesstalestwo.data.shops.global.GriwalshProducts;
import com.cnx.endlesstalestwo.data.shops.global.PotionsMarket;
import com.cnx.endlesstalestwo.data.shops.global.ProtectionShop;
import com.cnx.endlesstalestwo.data.shops.global.TheHumanFortress;
import com.cnx.endlesstalestwo.data.shops.global.ToolsStore;
import com.cnx.endlesstalestwo.data.shops.global.WeaponMarket;
import com.cnx.endlesstalestwo.data.shops.growrocks.DwarvenMarket;
import com.cnx.endlesstalestwo.data.shops.growrocks.KamalaJewelry;
import com.cnx.endlesstalestwo.data.shops.helera.HeleraGardenTents;
import com.cnx.endlesstalestwo.data.shops.letow.JohannaGoods;
import com.cnx.endlesstalestwo.data.shops.lisport.BattlersTent;
import com.cnx.endlesstalestwo.data.shops.lisport.KlausThings;
import com.cnx.endlesstalestwo.data.shops.lisport.LisportStable;
import com.cnx.endlesstalestwo.data.shops.lisport.PotionBreedersUnion;
import com.cnx.endlesstalestwo.data.shops.monelix.TheFoodTent;
import com.cnx.endlesstalestwo.data.shops.monelix.TheGreatMarket;
import com.cnx.endlesstalestwo.data.shops.monelix.TheJeweler;
import com.cnx.endlesstalestwo.data.shops.monelix.TheMajesticSteed;
import com.cnx.endlesstalestwo.data.shops.umera.EldrinShop;
import com.cnx.endlesstalestwo.data.shops.umera.MinersWarehouse;
import com.cnx.endlesstalestwo.data.shops.umera.TheGuardian;
import com.cnx.endlesstalestwo.data.shops.wazel.ShineGems;
import com.cnx.endlesstalestwo.data.shops.wazel.WazelArsenal;
import com.cnx.endlesstalestwo.data.shops.wazel.WazelStable;
import com.cnx.endlesstalestwo.enums.Enums;

public class ShopsManager extends DataHelper {
    @Override
    public void generate() {
        // Food Shops
        App.DataManager.add(Enums.DataTypes.SHOP, new BasicFoodShop().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new TheFoodTent().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new FarmProductions().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new NotFrozenFoods().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new ApennaMeadRoom().create());

        // General Shops
        App.DataManager.add(Enums.DataTypes.SHOP, new ToolsStore().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new MinersWarehouse().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new KlausThings().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new FishermanStore().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new JohannaGoods().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new AffronisProductions().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new WoodcuttersWarehouse().create());

        // Potions Shops
        App.DataManager.add(Enums.DataTypes.SHOP, new CrafterPoint().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new PotionBreedersUnion().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new PotionsMarket().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new GriwalshProducts().create());

        // Weapon Shops
        App.DataManager.add(Enums.DataTypes.SHOP, new ArsenalStore().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new WeaponMarket().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new ColdBattler().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new WazelArsenal().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new EldrinShop().create());

        // Armor Shops
        App.DataManager.add(Enums.DataTypes.SHOP, new BattlersTent().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new ProtectionShop().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new TheGuardian().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new TheHumanFortress().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new MagicProtectionsStore().create());

        // Jewelry Shops
        App.DataManager.add(Enums.DataTypes.SHOP, new TheJeweler().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new Jewelry().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new ShineGems().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new KamalaJewelry().create());

        // Market Shops
        App.DataManager.add(Enums.DataTypes.SHOP, new ElvishMarket().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new DwarvenMarket().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new TheGreatMarket().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new HeleraGardenTents().create());
        App.DataManager.add(Enums.DataTypes.SHOP, new BastianCentralMarket().create());

        // Stables
        App.DataManager.add(Enums.DataTypes.STABLE, new LisportStable().create());
        App.DataManager.add(Enums.DataTypes.STABLE, new CommonStable().create());
        App.DataManager.add(Enums.DataTypes.STABLE, new TheMajesticSteed().create());
        App.DataManager.add(Enums.DataTypes.STABLE, new WazelStable().create());
    }
}
