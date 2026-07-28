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
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftFlour());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCoal());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCookedMeat());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftSoup());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftSpecialSoup());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftMeatWithSpices());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftString());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftString2());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCookedTuna());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCookedSardine());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCookedCrab());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftPickaxe());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftSteelPickaxe());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftWoodcuttersAxe());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftBread());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftIronIngot());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCopperIngot());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftGoldIngot());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftSteelIngot());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCaltraniumIngot());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftFishingRod());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftReinforcedFishingRod());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftTissueWool());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftTissueCotton());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftPlank());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftRope());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftTorch());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftSimpleHpPotion());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftSimpleMpPotion());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftHpPotion());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftMpPotion());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftSpecialHpPotion());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftSpecialMpPotion());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftMead());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftElixir());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftAntidote());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftEmeraldPowder());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftWoodenSpear());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftRubyRing());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftGoldRing());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftReinforcedLeatherJacket());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftReinforcedLeatherLegs());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftLeatherBag());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftLeatherCap());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftLeatherBoots());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftHoodOfMagician());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftAgileShoes());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftIronArmor());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftIronHelmet());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftIronBoots());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCopperArmor());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCopperHelmet());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCopperBoots());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftGoldenArmor());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftGoldenHelmet());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCaltraniumArmor());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCaltraniumLegs());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCaltraniumHelmet());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCaltraniumBoots());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCaltraniumShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftSteelArmor());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftSteelHelmet());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftOrnateCloak());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftSpellCrafterTunic());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftIronSword());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCopperSword());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftHeavyMace());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftLongOakBow());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftSkillsfulsStaff());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftGoldDagger());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftGiantSword());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftPlankShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftIronShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftSteelShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftBlazeShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftGlacierShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftDarknessShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftCelestialShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftNatureShield());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftBeer());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftWine());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftAsh());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftGlacierMace());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftFireSword());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftSteelSpear());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftKnivesOfBreeze());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftMiniCrossbow());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftDragonMail());
        App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftDragonShield());

        if (App.getPlayerChar() != null
                && (
                LibQuest.isQuestComplete(App.getPlayerChar(), QuestsIds.THE_DWARVEN_CITY)
| LibQuest.isCharacterAtQuestPart(App.getPlayerChar(), QuestsIds.THE_DWARVEN_CITY, 8)
| LibQuest.isCharacterAtQuestPart(App.getPlayerChar(), QuestsIds.THE_DWARVEN_CITY, 9))) {
            App.DataManager.add(Enums.DataTypes.CRAFT_RECIPE, craftDwarvenPickaxe());
        }
    }

    CraftRecipe craftFlour() {
        CraftRecipe recipe = new CraftRecipe(8, ItemsIds.FLOUR, ItemsIds.WHEAT, ItemsIds.WHEAT);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 90;

        return recipe;
    }

    CraftRecipe craftCoal() {
        CraftRecipe recipe = new CraftRecipe(15, ItemsIds.COAL, ItemsIds.BRANCH, ItemsIds.LOG);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 85;

        return recipe;
    }

    CraftRecipe craftCookedMeat() {
        CraftRecipe recipe = new CraftRecipe(15, ItemsIds.COOKED_MEAT, ItemsIds.RAW_MEAT);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 99;

        return recipe;
    }

    CraftRecipe craftSoup() {
        CraftRecipe recipe = new CraftRecipe(15, ItemsIds.SOUP, ItemsIds.CARROT, ItemsIds.WATER, ItemsIds.EGG);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 90;

        return recipe;
    }

    CraftRecipe craftSpecialSoup() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.SPECIAL_SOUP, ItemsIds.WHITE_MUSHROOM, ItemsIds.BROWN_MUSHROOM, ItemsIds.CARROT);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 70;

        return recipe;
    }

    CraftRecipe craftMeatWithSpices() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.SEASONED_MEAT, ItemsIds.COOKED_MEAT, ItemsIds.GREEN_HERB, ItemsIds.CARROT);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 85;

        return recipe;
    }

    CraftRecipe craftString() {
        CraftRecipe recipe = new CraftRecipe(8, ItemsIds.STRING, ItemsIds.WOOL);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 95;

        return recipe;
    }

    CraftRecipe craftString2() {
        CraftRecipe recipe = new CraftRecipe(10, ItemsIds.STRING, ItemsIds.SPIDER_WEB, ItemsIds.SPIDER_WEB, ItemsIds.SPIDER_WEB);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 95;

        return recipe;
    }

    CraftRecipe craftCookedTuna() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.COOKED_TUNA, ItemsIds.TUNA);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 86;

        return recipe;
    }

    CraftRecipe craftCookedSardine() {
        CraftRecipe recipe = new CraftRecipe(12, ItemsIds.COOKED_SARDINE, ItemsIds.SARDINE);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 99;

        return recipe;
    }

    CraftRecipe craftCookedCrab() {
        CraftRecipe recipe = new CraftRecipe(15, ItemsIds.COOKED_CRAB, ItemsIds.CRAB);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 98;

        return recipe;
    }

    CraftRecipe craftPickaxe() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.PICKAXE, ItemsIds.ROCK, ItemsIds.STRING, ItemsIds.BRANCH);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 75;

        return recipe;
    }

    CraftRecipe craftSteelPickaxe() {
        CraftRecipe recipe = new CraftRecipe(45, ItemsIds.STEEL_PICKAXE, ItemsIds.PICKAXE, ItemsIds.STEEL_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 55;

        return recipe;
    }

    CraftRecipe craftWoodcuttersAxe() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.WOODCUTTERS_AXE, ItemsIds.ROCK, ItemsIds.STRING, ItemsIds.LOG);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 78;

        return recipe;
    }

    CraftRecipe craftBread() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.BREAD, ItemsIds.FLOUR, ItemsIds.WATER);
        recipe.type = Enums.CraftTypes.COOKING;
        recipe.successRate = 85;

        return recipe;
    }

    CraftRecipe craftIronIngot() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.IRON_INGOT, ItemsIds.IRON_ORE, ItemsIds.IRON_ORE);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 80;

        return recipe;
    }

    CraftRecipe craftCopperIngot() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.COPPER_INGOT, ItemsIds.COPPER_ORE, ItemsIds.COPPER_ORE);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 76;

        return recipe;
    }

    CraftRecipe craftGoldIngot() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.GOLD_INGOT, ItemsIds.GOLD_ORE, ItemsIds.GOLD_ORE);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 72;

        return recipe;
    }

    CraftRecipe craftSteelIngot() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.STEEL_INGOT, ItemsIds.IRON_INGOT, ItemsIds.COAL, ItemsIds.COAL);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 72;

        return recipe;
    }

    CraftRecipe craftCaltraniumIngot() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.CALTRANIUM_INGOT, ItemsIds.CALTRANIUM_ORE, ItemsIds.CALTRANIUM_ORE);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 50;

        return recipe;
    }

    CraftRecipe craftFishingRod() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.FISHING_ROD, ItemsIds.BRANCH, ItemsIds.STRING);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 60;

        return recipe;
    }

    CraftRecipe craftReinforcedFishingRod() {
        CraftRecipe recipe = new CraftRecipe(35, ItemsIds.REINFORCED_FISHING_ROD, ItemsIds.FISHING_ROD, ItemsIds.STRING, ItemsIds.IRON_ORE);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 65;

        return recipe;
    }

    CraftRecipe craftTissueWool() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.TISSUE, ItemsIds.WOOL, ItemsIds.WOOL);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 75;

        return recipe;
    }

    CraftRecipe craftTissueCotton() {
        CraftRecipe recipe = new CraftRecipe(20, ItemsIds.TISSUE, ItemsIds.COTTON, ItemsIds.COTTON);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 75;

        return recipe;
    }

    CraftRecipe craftPlank() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.PLANK, ItemsIds.LOG);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 88;

        return recipe;
    }

    CraftRecipe craftRope() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.ROPE, ItemsIds.STRING, ItemsIds.STRING, ItemsIds.STRING);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 60;

        return recipe;
    }

    CraftRecipe craftTorch() {
        CraftRecipe recipe = new CraftRecipe(5, ItemsIds.TORCH, ItemsIds.COAL, ItemsIds.BRANCH);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 80;

        return recipe;
    }

    CraftRecipe craftSimpleHpPotion() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.SIMPLE_HP_POTION, ItemsIds.RED_HERB, ItemsIds.RED_HERB, ItemsIds.WATER);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 45;

        return recipe;
    }

    CraftRecipe craftHpPotion() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.HP_POTION, ItemsIds.RED_HERB, ItemsIds.YELLOW_HERB, ItemsIds.WATER);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 32;

        return recipe;
    }

    CraftRecipe craftSimpleMpPotion() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.SIMPLE_MP_POTION, ItemsIds.GREEN_HERB, ItemsIds.GREEN_HERB, ItemsIds.WATER);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 45;

        return recipe;
    }

    CraftRecipe craftMpPotion() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.MP_POTION, ItemsIds.GREEN_HERB, ItemsIds.YELLOW_HERB, ItemsIds.WATER);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 32;

        return recipe;
    }

    CraftRecipe craftSpecialHpPotion() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.SPECIAL_HP_POTION, ItemsIds.YELLOW_HERB, ItemsIds.YELLOW_HERB, ItemsIds.SIMPLE_HP_POTION);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 14;

        return recipe;
    }

    CraftRecipe craftSpecialMpPotion() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.SPECIAL_MP_POTION, ItemsIds.YELLOW_HERB, ItemsIds.YELLOW_HERB, ItemsIds.SIMPLE_MP_POTION);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 14;

        return recipe;
    }

    CraftRecipe craftMead() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.MEAD_POTION, ItemsIds.GREEN_HERB, ItemsIds.RED_HERB, ItemsIds.WATER);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 30;

        return recipe;
    }

    CraftRecipe craftElixir() {
        CraftRecipe recipe = new CraftRecipe(40, ItemsIds.ELIXIR_POTION, ItemsIds.YELLOW_HERB, ItemsIds.YELLOW_HERB, ItemsIds.MEAD_POTION);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 20;

        return recipe;
    }

    CraftRecipe craftAntidote() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.ANTIDOTE, ItemsIds.GREEN_HERB, ItemsIds.WINE);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 85;

        return recipe;
    }

    CraftRecipe craftEmeraldPowder() {
        CraftRecipe recipe = new CraftRecipe(12, ItemsIds.EMERALD_POWDER, ItemsIds.EMERALD, ItemsIds.ASH, ItemsIds.COAL);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 35;

        return recipe;
    }

    CraftRecipe craftWoodenSpear() {
        CraftRecipe recipe = new CraftRecipe(18, ItemsIds.WOODEN_SPEAR, ItemsIds.PLANK, ItemsIds.BRANCH, ItemsIds.ROCK);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 58;

        return recipe;
    }

    CraftRecipe craftRubyRing() {
        CraftRecipe recipe = new CraftRecipe(18, ItemsIds.RUBY_RING, ItemsIds.GOLD_RING, ItemsIds.RUBY);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 40;

        return recipe;
    }

    CraftRecipe craftGoldRing() {
        CraftRecipe recipe = new CraftRecipe(12, ItemsIds.GOLD_RING, ItemsIds.GOLD_INGOT, ItemsIds.STEEL_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 38;

        return recipe;
    }

    public CraftRecipe craftDwarvenPickaxe() {
        CraftRecipe recipe = new CraftRecipe(90, ItemsIds.DWARVENS_PICKAXE, ItemsIds.STEEL_INGOT, ItemsIds.GOLD_INGOT, ItemsIds.LOG);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 16;

        return recipe;
    }

    public CraftRecipe craftReinforcedLeatherJacket() {
        CraftRecipe recipe = new CraftRecipe(45, ItemsIds.REINFORCED_LEATHER_JACKET, ItemsIds.LEATHER, ItemsIds.LEATHER, ItemsIds.TISSUE);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 42;

        return recipe;
    }

    public CraftRecipe craftReinforcedLeatherLegs() {
        CraftRecipe recipe = new CraftRecipe(45, ItemsIds.REINFORCED_TROUSERS, ItemsIds.LEATHER, ItemsIds.WOOL, ItemsIds.STRING);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 42;

        return recipe;
    }

    public CraftRecipe craftLeatherCap() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.LEATHER_CAP, ItemsIds.LEATHER, ItemsIds.STRING);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 42;

        return recipe;
    }

    public CraftRecipe craftLeatherBoots() {
        CraftRecipe recipe = new CraftRecipe(30, ItemsIds.LEATHER_BOOTS, ItemsIds.LEATHER, ItemsIds.LEATHER);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 42;

        return recipe;
    }

    public CraftRecipe craftLeatherBag() {
        CraftRecipe recipe = new CraftRecipe(45, ItemsIds.LEATHER_BAG, ItemsIds.LEATHER, ItemsIds.ROPE);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 45;

        return recipe;
    }

    public CraftRecipe craftAgileShoes() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.SHOES_OF_AGILE, ItemsIds.WOOL, ItemsIds.WOOL, ItemsIds.STRING);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 9;

        return recipe;
    }

    public CraftRecipe craftIronArmor() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.IRON_ARMOR, ItemsIds.ARMOR_MOLD, ItemsIds.IRON_INGOT, ItemsIds.IRON_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 45;

        return recipe;
    }

    public CraftRecipe craftCopperArmor() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.COPPER_ARMOR, ItemsIds.ARMOR_MOLD, ItemsIds.COPPER_INGOT, ItemsIds.COPPER_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 37;

        return recipe;
    }

    public CraftRecipe craftGoldenArmor() {
        CraftRecipe recipe = new CraftRecipe(90, ItemsIds.GOLDEN_ARMOR, ItemsIds.ARMOR_MOLD, ItemsIds.GOLD_INGOT, ItemsIds.GOLD_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 19;

        return recipe;
    }

    public CraftRecipe craftSteelArmor() {
        CraftRecipe recipe = new CraftRecipe(80, ItemsIds.STEEL_ARMOR, ItemsIds.ARMOR_MOLD, ItemsIds.STEEL_INGOT, ItemsIds.STEEL_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 23;

        return recipe;
    }

    public CraftRecipe craftIronHelmet() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.IRON_HELMET, ItemsIds.HELMET_MOLD, ItemsIds.IRON_INGOT, ItemsIds.IRON_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 50;

        return recipe;
    }

    public CraftRecipe craftIronBoots() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.IRON_BOOTS, ItemsIds.WOOL, ItemsIds.IRON_INGOT, ItemsIds.IRON_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 35;

        return recipe;
    }

    public CraftRecipe craftCopperHelmet() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.COPPER_HELMET, ItemsIds.HELMET_MOLD, ItemsIds.COPPER_INGOT, ItemsIds.COPPER_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 40;

        return recipe;
    }

    public CraftRecipe craftCopperBoots() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.COPPER_BOOTS, ItemsIds.WOOL, ItemsIds.COPPER_INGOT, ItemsIds.COPPER_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 30;

        return recipe;
    }

    public CraftRecipe craftGoldenHelmet() {
        CraftRecipe recipe = new CraftRecipe(90, ItemsIds.GOLDEN_HELMET, ItemsIds.HELMET_MOLD, ItemsIds.GOLD_INGOT, ItemsIds.GOLD_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 22;

        return recipe;
    }

    public CraftRecipe craftCaltraniumArmor() {
        CraftRecipe recipe = new CraftRecipe(120, ItemsIds.CALTRANIUM_ARMOR, ItemsIds.ARMOR_MOLD, ItemsIds.CALTRANIUM_INGOT, ItemsIds.CALTRANIUM_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 11;

        return recipe;
    }

    public CraftRecipe craftCaltraniumHelmet() {
        CraftRecipe recipe = new CraftRecipe(100, ItemsIds.CALTRANIUM_HELMET, ItemsIds.HELMET_MOLD, ItemsIds.CALTRANIUM_INGOT, ItemsIds.CALTRANIUM_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 11;

        return recipe;
    }

    public CraftRecipe craftCaltraniumLegs() {
        CraftRecipe recipe = new CraftRecipe(110, ItemsIds.CALTRANIUM_LEGS, ItemsIds.STEEL_INGOT, ItemsIds.CALTRANIUM_INGOT, ItemsIds.CALTRANIUM_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 12;

        return recipe;
    }

    public CraftRecipe craftCaltraniumShield() {
        CraftRecipe recipe = new CraftRecipe(120, ItemsIds.CALTRANIUM_SHIELD, ItemsIds.GOLD_INGOT, ItemsIds.CALTRANIUM_INGOT, ItemsIds.CALTRANIUM_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 10;

        return recipe;
    }

    public CraftRecipe craftCaltraniumBoots() {
        CraftRecipe recipe = new CraftRecipe(110, ItemsIds.CALTRANIUM_BOOTS, ItemsIds.WOOL, ItemsIds.CALTRANIUM_INGOT, ItemsIds.CALTRANIUM_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 11;

        return recipe;
    }

    public CraftRecipe craftSteelHelmet() {
        CraftRecipe recipe = new CraftRecipe(80, ItemsIds.STEEL_HELMET, ItemsIds.HELMET_MOLD, ItemsIds.STEEL_INGOT, ItemsIds.STEEL_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 26;

        return recipe;
    }

    public CraftRecipe craftHoodOfMagician() {
        CraftRecipe recipe = new CraftRecipe(50, ItemsIds.HOOD_OF_MAGICIAN, ItemsIds.WOOL, ItemsIds.TISSUE, ItemsIds.EMERALD_POWDER);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 35;

        return recipe;
    }

    public CraftRecipe craftOrnateCloak() {
        CraftRecipe recipe = new CraftRecipe(50, ItemsIds.ORNATE_CLOAK, ItemsIds.TISSUE, ItemsIds.EMERALD, ItemsIds.DIAMOND);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 20;

        return recipe;
    }

    public CraftRecipe craftSpellCrafterTunic() {
        CraftRecipe recipe = new CraftRecipe(45, ItemsIds.SPELLCRAFTER_TUNIC, ItemsIds.TISSUE, ItemsIds.SPIDER_WEB, ItemsIds.EMERALD_POWDER);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 32;

        return recipe;
    }

    public CraftRecipe craftIronSword() {
        CraftRecipe recipe = new CraftRecipe(45, ItemsIds.IRON_SWORD, ItemsIds.BRANCH, ItemsIds.IRON_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 36;

        return recipe;
    }

    public CraftRecipe craftCopperSword() {
        CraftRecipe recipe = new CraftRecipe(52, ItemsIds.COPPER_SWORD, ItemsIds.BRANCH, ItemsIds.COPPER_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 23;

        return recipe;
    }

    public CraftRecipe craftHeavyMace() {
        CraftRecipe recipe = new CraftRecipe(65, ItemsIds.HEAVY_MACE, ItemsIds.LOG, ItemsIds.IRON_INGOT, ItemsIds.STEEL_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 19;

        return recipe;
    }

    public CraftRecipe craftLongOakBow() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.LONG_OAK_BOW, ItemsIds.BRANCH, ItemsIds.STRING, ItemsIds.ORC_TOOTH);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 12;

        return recipe;
    }

    public CraftRecipe craftSkillsfulsStaff() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.SKILLFULS_STAFF, ItemsIds.LOG, ItemsIds.LIVING_MOSSWOOD, ItemsIds.ORC_TOOTH);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 3;

        return recipe;
    }

    public CraftRecipe craftGoldDagger() {
        CraftRecipe recipe = new CraftRecipe(70, ItemsIds.GOLD_DAGGER, ItemsIds.GOLD_INGOT, ItemsIds.GOLD_INGOT, ItemsIds.STEEL_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 4;

        return recipe;
    }

    public CraftRecipe craftGiantSword() {
        CraftRecipe recipe = new CraftRecipe(65, ItemsIds.GIANT_SWORD, ItemsIds.STEEL_INGOT, ItemsIds.IRON_INGOT, ItemsIds.PLANK);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 8;

        return recipe;
    }

    public CraftRecipe craftPlankShield() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.PLANK_SHIELD, ItemsIds.PLANK, ItemsIds.PLANK, ItemsIds.STRING);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 52;

        return recipe;
    }

    public CraftRecipe craftIronShield() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.IRON_SHIELD, ItemsIds.IRON_INGOT, ItemsIds.PLANK_SHIELD, ItemsIds.PLANK);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 26;

        return recipe;
    }

    public CraftRecipe craftSteelShield() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.STEEL_SHIELD, ItemsIds.STEEL_INGOT, ItemsIds.PLANK_SHIELD, ItemsIds.PLANK);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 18;

        return recipe;
    }

    public CraftRecipe craftBlazeShield() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.BLAZE_SHIELD, ItemsIds.IRON_SHIELD, ItemsIds.ASH, ItemsIds.WINE);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 25;

        return recipe;
    }

    public CraftRecipe craftGlacierShield() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.GLACIER_SHIELD, ItemsIds.IRON_SHIELD, ItemsIds.ETERNAL_ICE_CRYSTAL, ItemsIds.WINE);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 27;

        return recipe;
    }

    public CraftRecipe craftDarknessShield() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.DARKNESS_SHIELD, ItemsIds.IRON_SHIELD, ItemsIds.DARK_MUSHROOM, ItemsIds.WINE);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 21;

        return recipe;
    }

    public CraftRecipe craftCelestialShield() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.CELESTIAL_SHIELD, ItemsIds.IRON_SHIELD, ItemsIds.RUNIC_STONE_FRAGMENT, ItemsIds.WINE);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 28;

        return recipe;
    }

    public CraftRecipe craftNatureShield() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.NATURE_SHIELD, ItemsIds.IRON_SHIELD, ItemsIds.LIVING_MOSSWOOD, ItemsIds.WINE);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 30;

        return recipe;
    }

    public CraftRecipe craftBeer() {
        CraftRecipe recipe = new CraftRecipe(35, ItemsIds.BEER, ItemsIds.WATER, ItemsIds.WATER, ItemsIds.WHEAT);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 85;

        return recipe;
    }

    public CraftRecipe craftWine() {
        CraftRecipe recipe = new CraftRecipe(40, ItemsIds.WINE, ItemsIds.WATER, ItemsIds.POMEGRANATE, ItemsIds.POMEGRANATE);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 82;

        return recipe;
    }

    public CraftRecipe craftAsh() {
        CraftRecipe recipe = new CraftRecipe(25, ItemsIds.ASH, ItemsIds.COAL, ItemsIds.LOG);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 100;

        return recipe;
    }

    public CraftRecipe craftFireSword() {
        CraftRecipe recipe = new CraftRecipe(60, ItemsIds.FIRE_SWORD, ItemsIds.COPPER_SWORD, ItemsIds.COAL, ItemsIds.ASH);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 24;

        return recipe;
    }

    public CraftRecipe craftGlacierMace() {
        CraftRecipe recipe = new CraftRecipe(65, ItemsIds.GLACIER_MACE, ItemsIds.HEAVY_MACE, ItemsIds.ETERNAL_ICE_CRYSTAL);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 16;

        return recipe;
    }

    public CraftRecipe craftSteelSpear() {
        CraftRecipe recipe = new CraftRecipe(50, ItemsIds.STEEL_SPEAR, ItemsIds.STEEL_INGOT, ItemsIds.PLANK, ItemsIds.PLANK);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 22;

        return recipe;
    }

    public CraftRecipe craftKnivesOfBreeze() {
        CraftRecipe recipe = new CraftRecipe(50, ItemsIds.KNIVES_OF_BREEZE, ItemsIds.THROWING_KNIVES, ItemsIds.ASH, ItemsIds.WHITE_HERB);
        recipe.type = Enums.CraftTypes.ALCHEMY;
        recipe.successRate = 16;

        return recipe;
    }

    public CraftRecipe craftMiniCrossbow() {
        CraftRecipe recipe = new CraftRecipe(50, ItemsIds.MINI_CROSSBOW, ItemsIds.BRANCH, ItemsIds.IRON_INGOT, ItemsIds.STRING);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 35;

        return recipe;
    }

    public CraftRecipe craftDragonMail() {
        CraftRecipe recipe = new CraftRecipe(120, ItemsIds.DRAGON_MAIL, ItemsIds.ARMOR_MOLD, ItemsIds.DRAGON_SCALE, ItemsIds.DIAMOND);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 3;

        return recipe;
    }

    public CraftRecipe craftDragonShield() {
        CraftRecipe recipe = new CraftRecipe(100, ItemsIds.DRAGON_SHIELD, ItemsIds.DRAGON_SCALE, ItemsIds.ACID_BLOOD, ItemsIds.STEEL_INGOT);
        recipe.type = Enums.CraftTypes.GENERAL;
        recipe.successRate = 4;

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
