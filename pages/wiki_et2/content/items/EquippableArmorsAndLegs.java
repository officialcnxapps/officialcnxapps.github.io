package com.cnx.endlesstalestwo.data.items;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.classes.ClassesIds;
import com.cnx.endlesstalestwo.entities.AttributeModifierValue;
import com.cnx.endlesstalestwo.entities.EquippableItem;
import com.cnx.endlesstalestwo.enums.Enums;

public class EquippableArmorsAndLegs extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.ITEM, peasantShirt()); //
        App.DataManager.add(Enums.DataTypes.ITEM, leatherJacket()); //
        App.DataManager.add(Enums.DataTypes.ITEM, reinforcedLeatherJacket()); //
        App.DataManager.add(Enums.DataTypes.ITEM, ironChestPlate());//
        App.DataManager.add(Enums.DataTypes.ITEM, ironArmor());//
        App.DataManager.add(Enums.DataTypes.ITEM, copperArmor());//
        App.DataManager.add(Enums.DataTypes.ITEM, steelArmor());//
        App.DataManager.add(Enums.DataTypes.ITEM, goldenArmor());//
        App.DataManager.add(Enums.DataTypes.ITEM, caltraniumArmor());//
        App.DataManager.add(Enums.DataTypes.ITEM, supremeChestPlate());//
        App.DataManager.add(Enums.DataTypes.ITEM, endlessArmor());//
        App.DataManager.add(Enums.DataTypes.ITEM, spellcrafterTunic());//
        App.DataManager.add(Enums.DataTypes.ITEM, heavyRobe());//
        App.DataManager.add(Enums.DataTypes.ITEM, ornateCloak());//
        App.DataManager.add(Enums.DataTypes.ITEM, capeOfFortitude());//
        App.DataManager.add(Enums.DataTypes.ITEM, magicalLightPlate());//
        App.DataManager.add(Enums.DataTypes.ITEM, endlessCloak());//
        App.DataManager.add(Enums.DataTypes.ITEM, shadowCloak());//
        App.DataManager.add(Enums.DataTypes.ITEM, robeOfDivinity());//
        App.DataManager.add(Enums.DataTypes.ITEM, breastplateOfFire());//
        App.DataManager.add(Enums.DataTypes.ITEM, breastplateOfShadows());//

        App.DataManager.add(Enums.DataTypes.ITEM, peasantTrousers());//
        App.DataManager.add(Enums.DataTypes.ITEM, reinforcedTrousers());//
        App.DataManager.add(Enums.DataTypes.ITEM, ironLegsArmor());//
        App.DataManager.add(Enums.DataTypes.ITEM, copperLegsArmor());//
        App.DataManager.add(Enums.DataTypes.ITEM, steelLegsArmor());//
        App.DataManager.add(Enums.DataTypes.ITEM, goldenTrousers());//
        App.DataManager.add(Enums.DataTypes.ITEM, caltraniumLegs());//
        App.DataManager.add(Enums.DataTypes.ITEM, endlessLegsArmor());//
        App.DataManager.add(Enums.DataTypes.ITEM, trousersOfAgile());//
    }

    // ------------------ ARMORS ----------------- \\

    EquippableItem peasantShirt() {
        EquippableItem equipItem = new EquippableItem("Peasant Shirt");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Camisa Camponesa");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Camisa campesina");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.defense = 0;
        equipItem.marketValue = 1;
        equipItem.weight = .2f;
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "For everyday use, made with the simplest fabric.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Para uso no dia a dia, feita com o tecido mais simples.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Para uso diario, confeccionado con el tejido más sencillo.");

        return equipItem;
    }

    EquippableItem leatherJacket() {
        EquippableItem equipItem = new EquippableItem("Leather Jacket");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Jaqueta de Couro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Chaqueta de Cuero");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.defense = 1;
        equipItem.marketValue = 4;
        equipItem.weight = .3f;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Good against the cold, but not very good against hits.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Boa contra o frio, mas não muito boa contra golpes.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Buena contra el frío, pero no muy buena contra los golpes.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem reinforcedLeatherJacket() {
        EquippableItem equipItem = new EquippableItem("Reinforced Leather Jacket");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Jaqueta de Couro Reforçada");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Chaqueta de Cuero Reforzada");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.defense = 2;
        equipItem.marketValue = 12;
        equipItem.weight = .6f;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An extra tier of wool and tissue makes this a good beginner armor.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma camada extra de lã e tecido torna esta armadura uma boa armadura para iniciantes.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una capa adicional de lana y tejido la convierte en una buena armadura para principiantes.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem ironChestPlate() {
        EquippableItem equipItem = new EquippableItem("Iron Chest Plate");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Peitoral de Ferro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Coraza de Hierro");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.defense = 2;
        equipItem.marketValue = 10;
        equipItem.weight = 1.5f;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Good armor despite not protecting the arms. It's heavier than it looks.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma boa armadura apesar de não proteger os braços. É mais pesada do que parece.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Buen blindaje a pesar de no proteger los brazos. Es más pesado de lo que parece.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem ironArmor() {
        EquippableItem equipItem = new EquippableItem("Iron Armor");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Armadura de Ferro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Armadura de Hierro");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.defense = 3;
        equipItem.marketValue = 25;
        equipItem.weight = 3.5f;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The best value for money armor for soldiers. Molded with iron.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A armadura de melhor custo benefício para soldados. Moldada com ferro.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La mejor armadura relación calidad-precio para soldados. Moldeado con hierro.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem copperArmor() {
        EquippableItem equipItem = new EquippableItem("Copper Armor");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Armadura de Cobre");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Armadura de Cobre");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.defense = 4;
        equipItem.marketValue = 55;
        equipItem.weight = 3.2f;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Looks a bit fancy to wear a copper armor, but it is efficient and protective.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Parece um pouco extravagante usar uma armadura de cobre, mas é eficiente e protetora.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Parece un poco elegante usar una armadura de cobre, pero es eficiente y protectora.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem steelArmor() {
        EquippableItem equipItem = new EquippableItem("Steel Armor");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Armadura de Aço");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Armadura de Acero");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.defense = 5;
        equipItem.marketValue = 90;
        equipItem.weight = 5.3f;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Robust, heavy and very protective.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Robusta, pesada e muito protetora.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Robusto, pesada y muy protectora.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem goldenArmor() {
        EquippableItem equipItem = new EquippableItem("Golden Armor");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Armadura de Ouro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Armadura de Oro");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.defense = 4;
        equipItem.marketValue = 80;
        equipItem.weight = 2.8f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.CHARISMA, 1));
        equipItem.rarity = Enums.Rarity.UNCOMMON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 7) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is extremely extravagant to use gold on battle armor and will certainly attract everyone's attention.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Extremamente extravagante usar ouro em uma armadura de batalha e certamente atrirá a atenção de todos.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es extremadamente extravagante usar oro en una armadura de batalla y ciertamente atraerá la atención de todos.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem caltraniumArmor() {
        EquippableItem equipItem = new EquippableItem("Caltranium Armor");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Armadura de Caltranio");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Armadura de Caltranio");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.defense = 6;
        equipItem.marketValue = 150;
        equipItem.weight = 4.2f;
        equipItem.rarity = Enums.Rarity.RARE;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 10) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The rarest and most resistant metal makes this armor one of the best in the world.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O metal mais raro e resistente faz desta armadura uma das melhores do mundo.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El metal más raro y resistente hace de esta armadura una de las mejores del mundo.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem supremeChestPlate() {
        EquippableItem equipItem = new EquippableItem("Supreme Chest Plate");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Peitoral Supremo");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Coraza Suprema");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.defense = 4;
        equipItem.marketValue = 150;
        equipItem.gemCost = 10;
        equipItem.weight = 2.5f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.STRENGTH, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 1));

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is said that only the oldest blacksmiths knew how to make this perfection of armor that mixes the best metals.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É dito que somente os mais antigos ferreiros sabiam como fazer esta perfeição de armadura que mistura os melhores metais.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Se dice que sólo los herreros más antiguos sabían realizar esta perfección de armadura que mezcla los mejores metales.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem endlessArmor() {
        EquippableItem equipItem = new EquippableItem("Endless Armor");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Armadura Endless");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Armadura Endless");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.defense = 6;
        equipItem.marketValue = 200;
        equipItem.gemCost = 25;
        equipItem.weight = 4f;
        equipItem.rarity = Enums.Rarity.SPECIAL;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP_MODIFIER, 4));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP_MODIFIER, 4));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 3));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.LUCK, 3));

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 5) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is so unique that its price is priceless. It is mystical and very resistant.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É tão única que seu preço é quase inestimável. É mística e muito resistente.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es tan único que su precio no tiene precio. Es mística y muy resistente.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem spellcrafterTunic() {
        EquippableItem equipItem = new EquippableItem("Spellcrafter Tunic");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Túnica do Feiticeiro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Túnica de Hechicero");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.defense = 2;
        equipItem.marketValue = 48;
        equipItem.weight = .8f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 1));

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A self-respecting sorcerer will wear this silk tunic in his days as a beginner.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um feiticeiro que se preze irá usar esta túnica de seda nos seus dias como iniciante.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un hechicero que se precie usará esta túnica de seda en sus días de principiante.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem heavyRobe() {
        EquippableItem equipItem = new EquippableItem("Heavy Robe");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Manto Pesado");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Manto Pesado");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.defense = 3;
        equipItem.marketValue = 45;
        equipItem.weight = 2.2f;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A cloak with several layers that help protect.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um manto com diversas camadas que ajudam a proteger.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un manto con varias capas que ayudan a proteger.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem ornateCloak() {
        EquippableItem equipItem = new EquippableItem("Ornate Cloak");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Manto Ornamentado");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Manto Adornado");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.defense = 3;
        equipItem.marketValue = 80;
        equipItem.weight = 1f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.CHARISMA, 1));


        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The fabric and jewels of this robe seem to have a mystical aura.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O tecido e as jóias deste manto parecem ter uma aura mística.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La tela y las joyas de esta túnica parecen tener un aura mística.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem capeOfFortitude() {
        EquippableItem equipItem = new EquippableItem("Cape of Fortitude");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Capa da Resistência");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Capa de la Resistencia");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.defense = 3;
        equipItem.marketValue = 110;
        equipItem.weight = 1f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP_MODIFIER, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP_MODIFIER, 1));

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 5) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Made with special and magical fabrics. Provides mystical protection.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Elaborada com tecidos especiais e mágicos. Fornece uma proteção mística.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Confeccionada con tejidos especiales y mágicos. Proporciona protección mística.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem magicalLightPlate() {
        EquippableItem equipItem = new EquippableItem("Magical Light Plate");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Peitoral Leve Mágico");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Coraza de Luz Mágica");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.defense = 4;
        equipItem.marketValue = 150;
        equipItem.gemCost = 10;
        equipItem.weight = 1.5f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP_MODIFIER, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 3));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 2));

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 8) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Light armor with a magical aura. Made with Caltranium and jewels.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma armadura leve com aura mágica. Feita com Caltranio e jóias.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Armadura ligera con aura mágica. Realizado con Caltranio y joyas.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem endlessCloak() {
        EquippableItem equipItem = new EquippableItem("Endless Cloak");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Túnica Endless");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Túnica Endless");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.defense = 5;
        equipItem.marketValue = 200;
        equipItem.gemCost = 25;
        equipItem.weight = 1.8f;
        equipItem.rarity = Enums.Rarity.SPECIAL;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP_MODIFIER, 3));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP_MODIFIER, 5));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.CHARISMA, 5));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.LUCK, 3));

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is so unique that its price is priceless. It is mystical and very resistant.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É tão única que seu preço é quase inestimável. É mística e muito resistente.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es tan único que su precio no tiene precio. Es mística y muy resistente.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem shadowCloak() {
        EquippableItem equipItem = new EquippableItem("Shadow Cloak");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Manto Sombrio");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Manto Oscuro");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.defense = 2;
        equipItem.marketValue = 45;
        equipItem.weight = .8f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.ALIGNMENT, 3, 3, Enums.StatusModifier.DECREASE));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 2));

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "dark and mysterious cloak. It emanates an obscure magic.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Manto negro e misterioso. Emana uma magia sombria.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Manto negro y misterioso. Emana una magia oscura.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem robeOfDivinity() {
        EquippableItem equipItem = new EquippableItem("Robe of Divinity");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Manto da Divindade");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Túnica de la Divinidad");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.defense = 2;
        equipItem.marketValue = 50;
        equipItem.weight = .6f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.ALIGNMENT, 3));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.CHARISMA, 1));

        equipItem.resistancesModifiers.put(Enums.Elements.LIGHT, 25);

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Clear and shiny mantle. Emanates pure and clean magic. (25% Light resistance)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Manto claro e brilhoso. Emana uma magia pura e limpa. (25% resistência à Luz)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Manto claro y brillante. Emana magia pura y limpia. (25% Resistencia a la luz)");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem breastplateOfFire() {
        EquippableItem equipItem = new EquippableItem("Breastplate of Fire");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Peitoral do Fogo");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Coraza del Fuego");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.defense = 2;
        equipItem.marketValue = 55;
        equipItem.weight = 1.5f;

        equipItem.resistancesModifiers.put(Enums.Elements.FIRE, 30);

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Magically produced to protect against fire. (30% Fire resistance)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Produzida magicamente para proteger contra o fogo. (30% resistência ao Fogo)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Producido mágicamente para proteger contra el fuego. (30% resistencia al Fuego)");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem breastplateOfShadows() {
        EquippableItem equipItem = new EquippableItem("Breastplate of Shadows");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Peitoral das Sombras");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Coraza de las Sombras");

        equipItem.slotPart = Enums.SlotPart.CHEST;
        equipItem.type = Enums.ItemType.ARMOR;
        equipItem.defense = 2;
        equipItem.marketValue = 55;
        equipItem.weight = 1.5f;

        equipItem.resistancesModifiers.put(Enums.Elements.DARK, 30);

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Magically produced to protect against dark. (30% Dark resistance)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Produzida magicamente para proteger contra escuro. (30% resistência a Escuridão)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Producido mágicamente para proteger contra el oscuro. (30% resistencia al Oscuro)");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    // ------------------ LEGS ----------------- \\

    EquippableItem peasantTrousers() {
        EquippableItem equipItem = new EquippableItem("Peasant Trousers");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Calça Camponesa");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pantalones campesinos");

        equipItem.slotPart = Enums.SlotPart.LEGS;
        equipItem.type = Enums.ItemType.LEGS;
        equipItem.defense = 0;
        equipItem.marketValue = 1;
        equipItem.weight = .2f;
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "For everyday use, made with the simplest fabric.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Para uso no dia a dia, feita com o tecido mais simples.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Para uso diario, confeccionado con el tejido más sencillo.");

        return equipItem;
    }

    EquippableItem reinforcedTrousers() {
        EquippableItem equipItem = new EquippableItem("Reinforced Trousers");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Calça Reforçada");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pantalones Reforzados");

        equipItem.slotPart = Enums.SlotPart.LEGS;
        equipItem.type = Enums.ItemType.LEGS;
        equipItem.defense = 1;
        equipItem.marketValue = 4;
        equipItem.weight = .4f;
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A simple pair of pants with leather reinforcements.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma calça simples com reforços de couro.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un pantalón sencillo con refuerzos de cuero.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem ironLegsArmor() {
        EquippableItem equipItem = new EquippableItem("Iron Legs Armor");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Calças de Ferro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pantalones de hierro");

        equipItem.slotPart = Enums.SlotPart.LEGS;
        equipItem.type = Enums.ItemType.LEGS;
        equipItem.defense = 2;
        equipItem.marketValue = 16;
        equipItem.weight = 1.3f;
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Made of leather and reinforced with iron plates, ideal for soldiers.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Fabricada com couro e reforçada com chapas de ferro, ideal para soldados.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Fabricada con cuero y reforzada con chapas de ferro, ideal para soldados.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem copperLegsArmor() {
        EquippableItem equipItem = new EquippableItem("Copper Legs Armor");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Calças de Cobre");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pantalones de Cobre");

        equipItem.slotPart = Enums.SlotPart.LEGS;
        equipItem.type = Enums.ItemType.LEGS;
        equipItem.defense = 3;
        equipItem.marketValue = 45;
        equipItem.weight = 1.5f;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.classes.add(ClassesIds.THIEF);

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Copper plates are more efficient than iron and protect these pants well.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "As chapas de cobre são mais eficientes que o ferro e protegem bem nestas calças.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Las láminas de cobre son más eficaces que el hierro y protegen bien estos pantalones.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem steelLegsArmor() {
        EquippableItem equipItem = new EquippableItem("Steel Legs Armor");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Armadura de Pernas de Aço");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Armadura de Pierna de Acero");

        equipItem.slotPart = Enums.SlotPart.LEGS;
        equipItem.type = Enums.ItemType.LEGS;
        equipItem.defense = 4;
        equipItem.marketValue = 70;
        equipItem.weight = 2f;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.classes.add(ClassesIds.THIEF);

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Heavy leg armor made from strong steel plates.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma pesada armadura para as pernas feita com placas de aço resistentes.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Armadura pesada para las piernas hecha de resistentes placas de acero.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem goldenTrousers() {
        EquippableItem equipItem = new EquippableItem("Golden Trousers");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Calças de Ouro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pantalones de Oro");

        equipItem.slotPart = Enums.SlotPart.LEGS;
        equipItem.type = Enums.ItemType.LEGS;
        equipItem.defense = 3;
        equipItem.marketValue = 68;
        equipItem.weight = 1.8f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.CHARISMA, 1));
        equipItem.rarity = Enums.Rarity.UNCOMMON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 5) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Really brilliant and extravagant to wear pants like this. Protects and attracts attention.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Realmente brilhante e extravagante usar calças como esta. Protege e chama atenção.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Realmente brillante y extravagante usar pantalones como este. Protege y llama la atención.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem caltraniumLegs() {
        EquippableItem equipItem = new EquippableItem("Caltranium Legs");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Calças de Caltranio");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pantalones de Caltranio");

        equipItem.slotPart = Enums.SlotPart.LEGS;
        equipItem.type = Enums.ItemType.LEGS;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.defense = 5;
        equipItem.marketValue = 150;
        equipItem.weight = 2.8f;
        equipItem.rarity = Enums.Rarity.RARE;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 10) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The rarest and most resistant metal makes this protection one of the best in the world.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O metal mais raro e resistente faz desta proteção uma das melhores do mundo.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El metal más raro y resistente hace de esta proteción una de las mejores del mundo.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem endlessLegsArmor() {
        EquippableItem equipItem = new EquippableItem("Endless Legs Armor");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Armadura Pernas Endless");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Armadura Piernas Endless");

        equipItem.slotPart = Enums.SlotPart.LEGS;
        equipItem.type = Enums.ItemType.LEGS;
        equipItem.defense = 6;
        equipItem.marketValue = 150;
        equipItem.gemCost = 15;
        equipItem.weight = 2f;
        equipItem.rarity = Enums.Rarity.SPECIAL;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.STRENGTH, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.LUCK, 2));

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is so unique that it is priceless. It is mystical and very resistant.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É tão única que seu preço é quase inestimável. É mística e muito resistente.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es tan única que su precio no tiene precio. Es mística y muy resistente.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem trousersOfAgile() {
        EquippableItem equipItem = new EquippableItem("Trousers of Agile");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Calças da Agilidade");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pantalones de Ágil");

        equipItem.slotPart = Enums.SlotPart.LEGS;
        equipItem.type = Enums.ItemType.LEGS;
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.defense = 3;
        equipItem.marketValue = 90;
        equipItem.weight = .5f;

        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 3));

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Very light and smooth. Perfectly well crafted to protect and allow for supple movement.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Muito leve e suave. Perfeitamente bem elaborada para proteger e permitir movimentos maleáveis.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Muy ligero y suave. Perfectamente bien elaborado para proteger y permitir un movimiento flexible.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }
}
