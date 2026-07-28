package com.cnx.endlesstalestwo.data.items;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.AttributeModifierValue;
import com.cnx.endlesstalestwo.entities.EquippableItem;
import com.cnx.endlesstalestwo.enums.Enums;

public class EquippableJewelsAndBags extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.ITEM, necklaceOfFocus());//
        App.DataManager.add(Enums.DataTypes.ITEM, necklaceOfFlames());//
        App.DataManager.add(Enums.DataTypes.ITEM, necklaceOfOcean());//
        App.DataManager.add(Enums.DataTypes.ITEM, natureNecklace());//
        App.DataManager.add(Enums.DataTypes.ITEM, celestialAmulet());//
        App.DataManager.add(Enums.DataTypes.ITEM, darknessAmulet());//
        App.DataManager.add(Enums.DataTypes.ITEM, amuletOfFortitude());//
        App.DataManager.add(Enums.DataTypes.ITEM, ringOfPower());//
        App.DataManager.add(Enums.DataTypes.ITEM, ringOfSpellcrafters());//
        App.DataManager.add(Enums.DataTypes.ITEM, endlessRing());//
        App.DataManager.add(Enums.DataTypes.ITEM, supremeNecklace());//
        App.DataManager.add(Enums.DataTypes.ITEM, ringOfAlchemist());//
        App.DataManager.add(Enums.DataTypes.ITEM, ringOfCrafter());//
        App.DataManager.add(Enums.DataTypes.ITEM, jewelOfRighteous());//
        App.DataManager.add(Enums.DataTypes.ITEM, jewelOfUnjust());//
        App.DataManager.add(Enums.DataTypes.ITEM, cursedAmulet());//

        App.DataManager.add(Enums.DataTypes.ITEM, leatherBag());//
        App.DataManager.add(Enums.DataTypes.ITEM, greatleatherBag());//
        App.DataManager.add(Enums.DataTypes.ITEM, magicalBackpack());//
        App.DataManager.add(Enums.DataTypes.ITEM, endlessBackpack());//

    }

    // ------------------ JEWELS ----------------- \\
    EquippableItem necklaceOfFocus() {
        EquippableItem equipItem = new EquippableItem("Necklace of Focus");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Colar do Foco");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Collar de Enfoque");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 18;
        equipItem.weight = .1f;
        equipItem.criticalChanceIncrease = 4;
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A necklace that emits a calm aura to the mind.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um colar que emite uma aura calma para a mente.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un collar que emite un aura tranquila a la mente.");

        equipItem.setupDefaultListeners();

        return equipItem;
    }

    EquippableItem necklaceOfFlames() {
        EquippableItem equipItem = new EquippableItem("Necklace of Flames");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Colar das Chamas");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Collar de Fuego");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 20;
        equipItem.weight = .1f;
        equipItem.resistancesModifiers.put(Enums.Elements.FIRE, 25);
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A piece of jewelry that emits an orange light. (25% Fire resistance)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma peça de joalheria que emite uma luz laranja. (25% de resistência ao fogo)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una pieza de joyería que emite una luz naranja. (25% de resistencia al fuego)");

        return equipItem;
    }

    EquippableItem necklaceOfOcean() {
        EquippableItem equipItem = new EquippableItem("Necklace of Ocean");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Colar do Oceano");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Collar de Océano");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 20;
        equipItem.weight = .1f;
        equipItem.resistancesModifiers.put(Enums.Elements.WATER, 25);
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A piece of jewelry that emits a cyan light. (25% Water resistance)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma peça de joalheria que emite uma luz ciana. (25% de resistência à água)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una pieza de joyería que emite una luz cian. (25% de resistencia al agua)");

        return equipItem;
    }

    EquippableItem natureNecklace() {
        EquippableItem equipItem = new EquippableItem("Nature Necklace");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Colar da Natureza");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Collar de la Naturaleza");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 25;
        equipItem.weight = .1f;
        equipItem.resistancesModifiers.put(Enums.Elements.WIND, 25);
        equipItem.resistancesModifiers.put(Enums.Elements.EARTH, 25);
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A piece of jewelry that emits a green light. (25% Wind resistance) (25% Earth resistance)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma peça de joalheria que emite uma luz verde. (25% de resistência ao vento) (25% de resistência à terra)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una pieza de joyería que emite una luz verde. (25% Resistencia al viento) (25% Resistencia a la tierra)");

        return equipItem;
    }

    EquippableItem celestialAmulet() {
        EquippableItem equipItem = new EquippableItem("Celestial Amulet");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Amuleto Celestial");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Amuleto Celestial");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 20;
        equipItem.weight = .1f;
        equipItem.weaknessesModifiers.put(Enums.Elements.LIGHT, 25);
        equipItem.resistancesModifiers.put(Enums.Elements.DARK, 25);
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Amulet of angels. (25% Dark resistance) (25% Light weakness)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Amuleto dos anjos. (25% de resistência à escuridão) (25% de fraqueza à luz)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Amuleto de ángeles. (25% Resistencia a la oscuridad) (25% Debilidad a la luz)");

        return equipItem;
    }

    EquippableItem darknessAmulet() {
        EquippableItem equipItem = new EquippableItem("Darkness Amulet");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Amuleto Sombrio");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Amuleto Oscuro");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 20;
        equipItem.weight = .1f;
        equipItem.resistancesModifiers.put(Enums.Elements.LIGHT, 25);
        equipItem.weaknessesModifiers.put(Enums.Elements.DARK, 25);
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Amulet of devils. (25% Light resistance) (25% Dark weakness)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Amuleto dos demônios. (25% de resistência à luz) (25% de fraqueza à escuridão)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Amuleto de los demonios. (25% Resistencia a la luz) (25% Debilidad a la oscuridad)");

        return equipItem;
    }

    EquippableItem amuletOfFortitude() {
        EquippableItem equipItem = new EquippableItem("Amulet of Fortitude");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Amuleto da Resistência");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Amuleto de Resistencia");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 50;
        equipItem.weight = .1f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP_MODIFIER, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP_MODIFIER, 2));
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A mystic piece of jewelry that emits vitality.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma joia mística que emite vitalidade.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una pieza de joyería mística que emite vitalidad.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem ringOfPower() {
        EquippableItem equipItem = new EquippableItem("Ring of Power");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Anel da Força");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Anillo de Fuerza");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 50;
        equipItem.weight = .1f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.STRENGTH, 2));
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Forge by ancient blacksmiths to provide power.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forjada por antigos ferreiros para fornecer energia.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Forja por antiguos herreros para proporcionar poder.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem ringOfSpellcrafters() {
        EquippableItem equipItem = new EquippableItem("Ring of Spellcrafters");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Anel dos Feiticeiros");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Anillo de Hechiero");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 70;
        equipItem.weight = .1f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP_MODIFIER, 2));
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Forge by ancient sorcerers to provide magical power.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forjada por antigos feiticeiros para fornecer poder mágico.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Forjado por antiguos hechiceros para proporcionar poder mágico.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem endlessRing() {
        EquippableItem equipItem = new EquippableItem("Endless Ring");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Anel Endless");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Anillo Endless");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 25;
        equipItem.gemCost = 10;
        equipItem.weight = .1f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP_MODIFIER, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP_MODIFIER, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.LUCK, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.STRENGTH, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 1));
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is so unique that its price is priceless. It is mystical and very powerful.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É tão único que seu preço é quase inestimável. É místico e muito poderoso.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es tan único que su precio no tiene precio. Es místico y muy poderoso.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem supremeNecklace() {
        EquippableItem equipItem = new EquippableItem("Supreme Necklace");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Jóia Suprema");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Joya Suprema");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 20;
        equipItem.defense = 1;
        equipItem.gemCost = 5;
        equipItem.weight = .1f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.LUCK, 3));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 1));
        equipItem.canBeIngredient = false;
        equipItem.rarity = Enums.Rarity.RARE;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The most noble gems mixed with magical powers made this a special piece of jewelry.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "As pedras preciosas mais nobres misturadas com poderes mágicos fizeram desta uma joia especial.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Las gemas más nobles mezcladas con poderes mágicos hicieron de esta una pieza de joyería especial.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem ringOfCrafter() {
        EquippableItem equipItem = new EquippableItem("Ring of Crafter");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Anel do Artesão");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Joya Suprema");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 35;
        equipItem.weight = .1f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.CRAFT, 100));
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Notable crafters wear this special ring. Increase 10 levels of Craft.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Artesãos notáveis usam este anel especial. Aumenta 10 níveis de Artesão.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Los artesanos notables usan este anillo especial. Aumenta 10 niveles de Artesión.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem ringOfAlchemist() {
        EquippableItem equipItem = new EquippableItem("Ring of Alchemist");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Anel do Alquimista");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Anillo de Alquimista");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 35;
        equipItem.weight = .1f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.ALCHEMY, 100));
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Notable alchemists wear this special ring. Increase 10 levels of alchemy.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Alquimistas notáveis usam este anel especial. Aumenta 10 níveis de Alquimia.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Los alquimistas notables usan este anillo especial. Aumenta 10 niveles de alquimia.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem jewelOfRighteous() {
        EquippableItem equipItem = new EquippableItem("Jewel of Righteous");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Jóia dos Justos");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Joya de los Justos");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 28;
        equipItem.weight = .1f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.ALIGNMENT, 10));
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Only the honored people have this jewel.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Somente pessoas honradas possuem esta joia.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sólo las personas honradas tienen esta joya.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem jewelOfUnjust() {
        EquippableItem equipItem = new EquippableItem("Jewel of Unjust");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Jóia dos Injustos");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Joya de los Injustos");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 28;
        equipItem.weight = .1f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.ALIGNMENT, 10, Enums.StatusModifier.DECREASE));
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Only the bad character people have this jewel.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Somente pessoas de mau caráter possuem esta joia.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sólo la gente de mal carácter tiene esta joya.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    // ------------------ BAGS ----------------- \\
    EquippableItem leatherBag() {
        EquippableItem equipItem = new EquippableItem("Leather Bag");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Saco de Couro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bolso de Cuero");

        equipItem.slotPart = Enums.SlotPart.BAG;
        equipItem.type = Enums.ItemType.BAG;
        equipItem.marketValue = 8;
        equipItem.weight = .1f;
        equipItem.weightIncrease = 3;
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Allows you to carry 3kg (6.6lbs) more.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Permite carregar 3kg a mais.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Permite llevar 3kg más.");

        return equipItem;
    }

    EquippableItem greatleatherBag() {
        EquippableItem equipItem = new EquippableItem("Great Leather Bag");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Bolsa de Couro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bolso de Cuero Grande");

        equipItem.slotPart = Enums.SlotPart.BAG;
        equipItem.type = Enums.ItemType.BAG;
        equipItem.marketValue = 18;
        equipItem.weight = .3f;
        equipItem.weightIncrease = 6;
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Allows you to carry 6kg (13.2lbs) more.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Permite carregar 6kg a mais.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Permite llevar 6kg más.");

        return equipItem;
    }

    EquippableItem magicalBackpack() {
        EquippableItem equipItem = new EquippableItem("Magical Backpack");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mochila Mágica");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mochila Mágica");

        equipItem.slotPart = Enums.SlotPart.BAG;
        equipItem.type = Enums.ItemType.BAG;
        equipItem.marketValue = 30;
        equipItem.weight = .3f;
        equipItem.weightIncrease = 12;
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Allows you to carry 12kg (26.4lbs) more.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Permite carregar 12kg a mais.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Permite llevar 12kg más.");

        return equipItem;
    }

    EquippableItem endlessBackpack() {
        EquippableItem equipItem = new EquippableItem("Endless Backpack");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mochila Endless");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mochila Endless");

        equipItem.slotPart = Enums.SlotPart.BAG;
        equipItem.type = Enums.ItemType.BAG;
        equipItem.marketValue = 15;
        equipItem.gemCost = 5;
        equipItem.weight = .3f;
        equipItem.weightIncrease = 20;
        equipItem.canBeIngredient = false;
        equipItem.rarity = Enums.Rarity.SPECIAL;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Allows you to carry 20kg (44lbs) more.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Permite carregar 20kg a mais.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Permite llevar 20kg más.");

        return equipItem;
    }

    EquippableItem cursedAmulet() {
        EquippableItem equipItem = new EquippableItem("Cursed Amulet");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Amuleto Amaldiçoado");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Amuleto Maldito");

        equipItem.slotPart = Enums.SlotPart.JEWEL;
        equipItem.type = Enums.ItemType.JEWEL;
        equipItem.marketValue = 55;
        equipItem.weight = 0.3f;
        equipItem.canBeIngredient = false;

        equipItem.resistancesModifiers.put(Enums.Elements.DARK, 25);

        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.LUCK, -1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.STRENGTH, 1));

        equipItem.rarity = Enums.Rarity.RARE;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A cursed amulet glowing with dark energy. (25% Dark resistance)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um amuleto amaldiçoado brilhando com energia sombria. (25% resistência Escuridão)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un amuleto maldito brillando con energía oscura. (25% resistencia Oscuridad)");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

}
