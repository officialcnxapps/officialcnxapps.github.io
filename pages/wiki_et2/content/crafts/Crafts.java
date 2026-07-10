package com.cnx.endlesstalestwo.data.crafts;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.CraftRecipe;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

import java.util.Comparator;
import java.util.List;

public class Crafts extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, flour());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, coal());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, cookedMeat());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, soup());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, specialSoup());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, meatWithSpices());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, string());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, string2());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, cookedTuna());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, cookedSardine());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, cookedCrab());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, pickaxe());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, steelPickaxe());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, woodcuttersAxe());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, bread());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, ironIngot());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, copperIngot());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, goldIngot());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, steelIngot());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, caltraniumIngot());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, fishingRod());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, reinforcedFishingRod());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, tissueWool());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, tissueCotton());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, plank());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, rope());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, torch());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, simpleHpPotion());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, simpleMpPotion());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, hpPotion());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, mpPotion());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, specialHpPotion());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, specialMpPotion());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, mead());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, elixir());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, antidote());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, emeraldPowder());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, woodenSpear());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, rubyRing());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, goldRing());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, reinforcedLeatherJacket());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, reinforcedLeatherLegs());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, leatherBag());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, leatherCap());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, leatherBoots());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, hoodOfMagician());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, agileShoes());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, ironArmor());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, ironHelmet());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, ironBoots());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, copperArmor());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, copperHelmet());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, copperBoots());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, goldenArmor());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, goldenHelmet());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, caltraniumArmor());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, caltraniumLegs());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, caltraniumHelmet());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, caltraniumBoots());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, caltraniumShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, steelArmor());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, steelHelmet());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, ornateCloak());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, spellCrafterTunic());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, ironSword());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, copperSword());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, heavyMace());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, longOakBow());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, skillsfulsStaff());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, goldDagger());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, giantSword());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, plankShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, ironShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, steelShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, blazeShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, glacierShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, darknessShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, celestialShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, natureShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, beer());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, wine());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, ash());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, glacierMace());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, fireSword());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, steelSpear());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, knivesOfBreeze());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, miniCrossbow());

        if (App.getPlayerChar() != null
                && (
                LibQuest.isQuestComplete(App.getPlayerChar(), QuestsIds.THE_DWARVEN_CITY)
                        || LibQuest.isCharacterAtQuestPart(App.getPlayerChar(), QuestsIds.THE_DWARVEN_CITY, 8)
                        || LibQuest.isCharacterAtQuestPart(App.getPlayerChar(), QuestsIds.THE_DWARVEN_CITY, 9))) {
            App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, dwarvenPickaxe());
        }
    }

    CraftRecipe flour() {
        CraftRecipe recipe = new CraftRecipe(8, ItemsIds.FLOUR, ItemsIds.WHEAT, ItemsIds.WHEAT);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 90;

        return recipe;
    }

    CraftRecipe coal() {
        CraftRecipe recipe = new CraftRecipe(15, ItemsIds.COAL, ItemsIds.BRANCH, ItemsIds.LOG);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 85;

        return recipe;
    }

    CraftRecipe cookedMeat() {
        CraftRecipe recipe = new CraftRecipe(15, ItemsIds.COOKED_MEAT, ItemsIds.RAW_MEAT);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 99;

        return recipe;
    }

    CraftRecipe soup() {
        CraftRecipe recipe = new CraftRecipe(15, ItemsIds.SOUP, ItemsIds.CARROT, ItemsIds.WATER, ItemsIds.EGG);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 90;

        return recipe;
    }

    CraftRecipe specialSoup() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.SPECIAL_SOUP, ItemsIds.WHITE_MUSHROOM, ItemsIds.BROWN_MUSHROOM, ItemsIds.CARROT);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 70;

        return recipe;
    }

    CraftRecipe meatWithSpices() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.SEASONED_MEAT, ItemsIds.COOKED_MEAT, ItemsIds.GREEN_HERB, ItemsIds.CARROT);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 85;

        return recipe;
    }

    CraftRecipe string() {
        CraftRecipe recipe = new CraftRecipe(8, ItemsIds.STRING, ItemsIds.WOOL);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 95;

        return recipe;
    }

    CraftRecipe string2() {
        CraftRecipe recipe = new CraftRecipe(10, ItemsIds.STRING, ItemsIds.SPIDER_WEB, ItemsIds.SPIDER_WEB, ItemsIds.SPIDER_WEB);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 95;

        return recipe;
    }

    CraftRecipe cookedTuna() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.COOKED_TUNA, ItemsIds.TUNA);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 86;

        return recipe;
    }

    CraftRecipe cookedSardine() {
        CraftRecipe recipe = new CraftRecipe(12, ItemsIds.COOKED_SARDINE, ItemsIds.SARDINE);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 99;

        return recipe;
    }

    CraftRecipe cookedCrab() {
        CraftRecipe recipe = new CraftRecipe(15, ItemsIds.COOKED_CRAB, ItemsIds.CRAB);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 98;

        return recipe;
    }

    CraftRecipe pickaxe() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.PICKAXE, ItemsIds.ROCK, ItemsIds.STRING, ItemsIds.BRANCH);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 75;

        return recipe;
    }

    CraftRecipe steelPickaxe() {
        CraftRecipe recipe = new CraftRecipe(45, ItemsIds.STEEL_PICKAXE, ItemsIds.PICKAXE, ItemsIds.STEEL_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 55;

        return recipe;
    }

    CraftRecipe woodcuttersAxe() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.WOODCUTTERS_AXE, ItemsIds.ROCK, ItemsIds.STRING, ItemsIds.LOG);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 78;

        return recipe;
    }

    CraftRecipe bread() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.BREAD, ItemsIds.FLOUR, ItemsIds.WATER);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 85;

        return recipe;
    }

    CraftRecipe ironIngot() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.IRON_INGOT, ItemsIds.IRON_ORE, ItemsIds.IRON_ORE);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 80;

        return recipe;
    }

    CraftRecipe copperIngot() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.COPPER_INGOT, ItemsIds.COPPER_ORE, ItemsIds.COPPER_ORE);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 76;

        return recipe;
    }

    CraftRecipe goldIngot() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.GOLD_INGOT, ItemsIds.GOLD_ORE, ItemsIds.GOLD_ORE);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 72;

        return recipe;
    }

    CraftRecipe steelIngot() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.STEEL_INGOT, ItemsIds.IRON_INGOT, ItemsIds.COAL, ItemsIds.COAL);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 72;

        return recipe;
    }

    CraftRecipe caltraniumIngot() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.CALTRANIUM_INGOT, ItemsIds.CALTRANIUM_ORE, ItemsIds.CALTRANIUM_ORE);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 50;

        return recipe;
    }

    CraftRecipe fishingRod() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.FISHING_ROD, ItemsIds.BRANCH, ItemsIds.STRING);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 60;

        return recipe;
    }

    CraftRecipe reinforcedFishingRod() {
        CraftRecipe recipe = new CraftRecipe(35, ItemsIds.REINFORCED_FISHING_ROD, ItemsIds.FISHING_ROD, ItemsIds.STRING, ItemsIds.IRON_ORE);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 65;

        return recipe;
    }

    CraftRecipe tissueWool() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.TISSUE, ItemsIds.WOOL, ItemsIds.WOOL);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 75;

        return recipe;
    }

    CraftRecipe tissueCotton() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.TISSUE, ItemsIds.COTTON, ItemsIds.COTTON);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 75;

        return recipe;
    }

    CraftRecipe plank() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.PLANK, ItemsIds.LOG);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 88;

        return recipe;
    }

    CraftRecipe rope() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.ROPE, ItemsIds.STRING, ItemsIds.STRING, ItemsIds.STRING);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 60;

        return recipe;
    }

    CraftRecipe torch() {
        CraftRecipe recipe = new CraftRecipe(5, ItemsIds.TORCH, ItemsIds.COAL, ItemsIds.BRANCH);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 80;

        return recipe;
    }

    CraftRecipe simpleHpPotion() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.SIMPLE_HP_POTION, ItemsIds.RED_HERB, ItemsIds.RED_HERB, ItemsIds.WATER);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 45;

        return recipe;
    }

    CraftRecipe hpPotion() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.HP_POTION, ItemsIds.RED_HERB, ItemsIds.YELLOW_HERB, ItemsIds.WATER);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 32;

        return recipe;
    }

    CraftRecipe simpleMpPotion() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.SIMPLE_MP_POTION, ItemsIds.GREEN_HERB, ItemsIds.GREEN_HERB, ItemsIds.WATER);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 45;

        return recipe;
    }

    CraftRecipe mpPotion() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.MP_POTION, ItemsIds.GREEN_HERB, ItemsIds.YELLOW_HERB, ItemsIds.WATER);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 32;

        return recipe;
    }

    CraftRecipe specialHpPotion() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.SPECIAL_HP_POTION, ItemsIds.YELLOW_HERB, ItemsIds.YELLOW_HERB, ItemsIds.SIMPLE_HP_POTION);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 14;

        return recipe;
    }

    CraftRecipe specialMpPotion() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.SPECIAL_MP_POTION, ItemsIds.YELLOW_HERB, ItemsIds.YELLOW_HERB, ItemsIds.SIMPLE_MP_POTION);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 14;

        return recipe;
    }

    CraftRecipe mead() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.MEAD_POTION, ItemsIds.GREEN_HERB, ItemsIds.RED_HERB, ItemsIds.WATER);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 30;

        return recipe;
    }

    CraftRecipe elixir() {
        CraftRecipe recipe = new CraftRecipe(40, ItemsIds.ELIXIR_POTION, ItemsIds.YELLOW_HERB, ItemsIds.YELLOW_HERB, ItemsIds.MEAD_POTION);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 20;

        return recipe;
    }

    CraftRecipe antidote() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.ANTIDOTE, ItemsIds.GREEN_HERB, ItemsIds.WINE);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 85;

        return recipe;
    }

    CraftRecipe emeraldPowder() {
        CraftRecipe recipe = new CraftRecipe(12, ItemsIds.EMERALD_POWDER, ItemsIds.EMERALD, ItemsIds.ASH, ItemsIds.COAL);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 35;

        return recipe;
    }

    CraftRecipe woodenSpear() {
        CraftRecipe recipe = new CraftRecipe(18, ItemsIds.WOODEN_SPEAR, ItemsIds.PLANK, ItemsIds.BRANCH, ItemsIds.ROCK);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 58;

        return recipe;
    }

    CraftRecipe rubyRing() {
        CraftRecipe recipe = new CraftRecipe(18, ItemsIds.RUBY_RING, ItemsIds.GOLD_RING, ItemsIds.RUBY);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 40;

        return recipe;
    }

    CraftRecipe goldRing() {
        CraftRecipe recipe = new CraftRecipe(12, ItemsIds.GOLD_RING, ItemsIds.GOLD_INGOT, ItemsIds.STEEL_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 38;

        return recipe;
    }

    public CraftRecipe dwarvenPickaxe() {
        CraftRecipe recipe = new CraftRecipe(90, ItemsIds.DWARVENS_PICKAXE, ItemsIds.STEEL_INGOT, ItemsIds.GOLD_INGOT, ItemsIds.LOG);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 16;

        return recipe;
    }

    public CraftRecipe reinforcedLeatherJacket() {
        CraftRecipe recipe = new CraftRecipe(45, ItemsIds.REINFORCED_LEATHER_JACKET, ItemsIds.LEATHER, ItemsIds.LEATHER, ItemsIds.TISSUE);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 42;

        return recipe;
    }

    public CraftRecipe reinforcedLeatherLegs() {
        CraftRecipe recipe = new CraftRecipe(45, ItemsIds.REINFORCED_TROUSERS, ItemsIds.LEATHER, ItemsIds.WOOL, ItemsIds.STRING);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 42;

        return recipe;
    }

    public CraftRecipe leatherCap() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.LEATHER_CAP, ItemsIds.LEATHER, ItemsIds.STRING);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 42;

        return recipe;
    }

    public CraftRecipe leatherBoots() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.LEATHER_BOOTS, ItemsIds.LEATHER, ItemsIds.LEATHER);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 42;

        return recipe;
    }

    public CraftRecipe leatherBag() {
        CraftRecipe recipe = new CraftRecipe(45, ItemsIds.LEATHER_BAG, ItemsIds.LEATHER, ItemsIds.ROPE);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 45;

        return recipe;
    }

    public CraftRecipe agileShoes() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.SHOES_OF_AGILE, ItemsIds.WOOL, ItemsIds.WOOL, ItemsIds.STRING);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 9;

        return recipe;
    }

    public CraftRecipe ironArmor() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.IRON_ARMOR, ItemsIds.ARMOR_MOLD, ItemsIds.IRON_INGOT, ItemsIds.IRON_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 45;

        return recipe;
    }

    public CraftRecipe copperArmor() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.COPPER_ARMOR, ItemsIds.ARMOR_MOLD, ItemsIds.COPPER_INGOT, ItemsIds.COPPER_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 37;

        return recipe;
    }

    public CraftRecipe goldenArmor() {
        CraftRecipe recipe = new CraftRecipe(90, ItemsIds.GOLDEN_ARMOR, ItemsIds.ARMOR_MOLD, ItemsIds.GOLD_INGOT, ItemsIds.GOLD_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 19;

        return recipe;
    }

    public CraftRecipe steelArmor() {
        CraftRecipe recipe = new CraftRecipe(80, ItemsIds.STEEL_ARMOR, ItemsIds.ARMOR_MOLD, ItemsIds.STEEL_INGOT, ItemsIds.STEEL_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 23;

        return recipe;
    }

    public CraftRecipe ironHelmet() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.IRON_HELMET, ItemsIds.HELMET_MOLD, ItemsIds.IRON_INGOT, ItemsIds.IRON_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 50;

        return recipe;
    }

    public CraftRecipe ironBoots() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.IRON_BOOTS, ItemsIds.WOOL, ItemsIds.IRON_INGOT, ItemsIds.IRON_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 35;

        return recipe;
    }

    public CraftRecipe copperHelmet() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.COPPER_HELMET, ItemsIds.HELMET_MOLD, ItemsIds.COPPER_INGOT, ItemsIds.COPPER_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 40;

        return recipe;
    }

    public CraftRecipe copperBoots() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.COPPER_BOOTS, ItemsIds.WOOL, ItemsIds.COPPER_INGOT, ItemsIds.COPPER_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 30;

        return recipe;
    }

    public CraftRecipe goldenHelmet() {
        CraftRecipe recipe = new CraftRecipe(90, ItemsIds.GOLDEN_HELMET, ItemsIds.HELMET_MOLD, ItemsIds.GOLD_INGOT, ItemsIds.GOLD_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 22;

        return recipe;
    }

    public CraftRecipe caltraniumArmor() {
        CraftRecipe recipe = new CraftRecipe(120, ItemsIds.CALTRANIUM_ARMOR, ItemsIds.ARMOR_MOLD, ItemsIds.CALTRANIUM_INGOT, ItemsIds.CALTRANIUM_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 11;

        return recipe;
    }

    public CraftRecipe caltraniumHelmet() {
        CraftRecipe recipe = new CraftRecipe(100, ItemsIds.CALTRANIUM_HELMET, ItemsIds.HELMET_MOLD, ItemsIds.CALTRANIUM_INGOT, ItemsIds.CALTRANIUM_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 11;

        return recipe;
    }

    public CraftRecipe caltraniumLegs() {
        CraftRecipe recipe = new CraftRecipe(110, ItemsIds.CALTRANIUM_LEGS, ItemsIds.STEEL_INGOT, ItemsIds.CALTRANIUM_INGOT, ItemsIds.CALTRANIUM_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 12;

        return recipe;
    }

    public CraftRecipe caltraniumShield() {
        CraftRecipe recipe = new CraftRecipe(120, ItemsIds.CALTRANIUM_SHIELD, ItemsIds.GOLD_INGOT, ItemsIds.CALTRANIUM_INGOT, ItemsIds.CALTRANIUM_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 10;

        return recipe;
    }

    public CraftRecipe caltraniumBoots() {
        CraftRecipe recipe = new CraftRecipe(110, ItemsIds.CALTRANIUM_BOOTS, ItemsIds.WOOL, ItemsIds.CALTRANIUM_INGOT, ItemsIds.CALTRANIUM_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 11;

        return recipe;
    }

    public CraftRecipe steelHelmet() {
        CraftRecipe recipe = new CraftRecipe(80, ItemsIds.STEEL_HELMET, ItemsIds.HELMET_MOLD, ItemsIds.STEEL_INGOT, ItemsIds.STEEL_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 26;

        return recipe;
    }

    public CraftRecipe hoodOfMagician() {
        CraftRecipe recipe = new CraftRecipe(50, ItemsIds.HOOD_OF_MAGICIAN, ItemsIds.WOOL, ItemsIds.TISSUE, ItemsIds.EMERALD_POWDER);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 35;

        return recipe;
    }

    public CraftRecipe ornateCloak() {
        CraftRecipe recipe = new CraftRecipe(50, ItemsIds.ORNATE_CLOAK, ItemsIds.TISSUE, ItemsIds.EMERALD, ItemsIds.DIAMOND);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 20;

        return recipe;
    }

    public CraftRecipe spellCrafterTunic() {
        CraftRecipe recipe = new CraftRecipe(45, ItemsIds.SPELLCRAFTER_TUNIC, ItemsIds.TISSUE, ItemsIds.SPIDER_WEB, ItemsIds.EMERALD_POWDER);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 32;

        return recipe;
    }

    public CraftRecipe ironSword() {
        CraftRecipe recipe = new CraftRecipe(45, ItemsIds.IRON_SWORD, ItemsIds.BRANCH, ItemsIds.IRON_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 36;

        return recipe;
    }

    public CraftRecipe copperSword() {
        CraftRecipe recipe = new CraftRecipe(52, ItemsIds.COPPER_SWORD, ItemsIds.BRANCH, ItemsIds.COPPER_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 23;

        return recipe;
    }

    public CraftRecipe heavyMace() {
        CraftRecipe recipe = new CraftRecipe(65, ItemsIds.HEAVY_MACE, ItemsIds.LOG, ItemsIds.IRON_INGOT, ItemsIds.STEEL_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 19;

        return recipe;
    }

    public CraftRecipe longOakBow() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.LONG_OAK_BOW, ItemsIds.BRANCH, ItemsIds.STRING, ItemsIds.ORC_TOOTH);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 12;

        return recipe;
    }

    public CraftRecipe skillsfulsStaff() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.SKILLFULS_STAFF, ItemsIds.LOG, ItemsIds.LIVING_MOSSWOOD, ItemsIds.ORC_TOOTH);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 3;

        return recipe;
    }

    public CraftRecipe goldDagger() {
        CraftRecipe recipe = new CraftRecipe(70, ItemsIds.GOLD_DAGGER, ItemsIds.GOLD_INGOT, ItemsIds.GOLD_INGOT, ItemsIds.STEEL_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 4;

        return recipe;
    }

    public CraftRecipe giantSword() {
        CraftRecipe recipe = new CraftRecipe(65, ItemsIds.GIANT_SWORD, ItemsIds.STEEL_INGOT, ItemsIds.IRON_INGOT, ItemsIds.PLANK);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 8;

        return recipe;
    }

    public CraftRecipe plankShield() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.PLANK_SHIELD, ItemsIds.PLANK, ItemsIds.PLANK, ItemsIds.STRING);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 52;

        return recipe;
    }

    public CraftRecipe ironShield() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.IRON_SHIELD, ItemsIds.IRON_INGOT, ItemsIds.PLANK_SHIELD, ItemsIds.PLANK);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 26;

        return recipe;
    }

    public CraftRecipe steelShield() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.STEEL_SHIELD, ItemsIds.STEEL_INGOT, ItemsIds.PLANK_SHIELD, ItemsIds.PLANK);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 18;

        return recipe;
    }

    public CraftRecipe blazeShield() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.BLAZE_SHIELD, ItemsIds.IRON_SHIELD, ItemsIds.ASH, ItemsIds.WINE);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 25;

        return recipe;
    }

    public CraftRecipe glacierShield() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.GLACIER_SHIELD, ItemsIds.IRON_SHIELD, ItemsIds.ETERNAL_ICE_CRYSTAL, ItemsIds.WINE);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 27;

        return recipe;
    }

    public CraftRecipe darknessShield() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.DARKNESS_SHIELD, ItemsIds.IRON_SHIELD, ItemsIds.DARK_MUSHROOM, ItemsIds.WINE);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 21;

        return recipe;
    }

    public CraftRecipe celestialShield() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.CELESTIAL_SHIELD, ItemsIds.IRON_SHIELD, ItemsIds.RUNIC_STONE_FRAGMENT, ItemsIds.WINE);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 28;

        return recipe;
    }

    public CraftRecipe natureShield() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.NATURE_SHIELD, ItemsIds.IRON_SHIELD, ItemsIds.LIVING_MOSSWOOD, ItemsIds.WINE);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 30;

        return recipe;
    }

    public CraftRecipe beer() {
        CraftRecipe recipe = new CraftRecipe(35, ItemsIds.BEER, ItemsIds.WATER, ItemsIds.WATER, ItemsIds.WHEAT);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 85;

        return recipe;
    }

    public CraftRecipe wine() {
        CraftRecipe recipe = new CraftRecipe(40, ItemsIds.WINE, ItemsIds.WATER, ItemsIds.POMEGRANATE, ItemsIds.POMEGRANATE);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 82;

        return recipe;
    }

    public CraftRecipe ash() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.ASH, ItemsIds.COAL, ItemsIds.LOG);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 100;

        return recipe;
    }

    public CraftRecipe fireSword() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.FIRE_SWORD, ItemsIds.COPPER_SWORD, ItemsIds.COAL, ItemsIds.ASH);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 24;

        return recipe;
    }

    public CraftRecipe glacierMace() {
        CraftRecipe recipe = new CraftRecipe(65, ItemsIds.GLACIER_MACE, ItemsIds.HEAVY_MACE, ItemsIds.ETERNAL_ICE_CRYSTAL);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 16;

        return recipe;
    }

    public CraftRecipe steelSpear() {
        CraftRecipe recipe = new CraftRecipe(50, ItemsIds.STEEL_SPEAR, ItemsIds.STEEL_INGOT, ItemsIds.PLANK, ItemsIds.PLANK);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 22;

        return recipe;
    }

    public CraftRecipe knivesOfBreeze() {
        CraftRecipe recipe = new CraftRecipe(50, ItemsIds.KNIVES_OF_BREEZE, ItemsIds.THROWING_KNIVES, ItemsIds.ASH, ItemsIds.WHITE_HERB);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 16;

        return recipe;
    }

    public CraftRecipe miniCrossbow() {
        CraftRecipe recipe = new CraftRecipe(50, ItemsIds.MINI_CROSSBOW, ItemsIds.BRANCH, ItemsIds.IRON_INGOT, ItemsIds.STRING);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 35;

        return recipe;
    }

    /// UTILITY METHODS TO DISPLAY CRAFTS AS LIST TO GAME BOOKS
    public static String getCraftsToDisplay(CoreEnums.AvailableLanguages lang, Enums.CraftTypes craftType) {
        StringBuilder listString = new StringBuilder();

        List<CraftRecipe> allCrafts = App.DataManager.getCrafts();
        allCrafts.sort(Comparator.comparing(c -> c.getProducedItemName(lang)));
        int validCrafts = 0;
        for (CraftRecipe craft : allCrafts) {
            if (craft.type == craftType) {
                validCrafts++;
                listString.append("\n\n --- [").append(craft.getProducedItemName(lang)).append("] --- ");
                listString.append("\n   ").append(craft.getIngredientsItemsNames(lang));
            }
        }

        return validCrafts + "" + listString;
    }
}
