package com.cnx.endlesstalestwo.data.items;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.classes.ClassesIds;
import com.cnx.endlesstalestwo.entities.AttributeModifierValue;
import com.cnx.endlesstalestwo.entities.EquippableItem;
import com.cnx.endlesstalestwo.entities.Item;
import com.cnx.endlesstalestwo.enums.Enums;

public class EquippableWeaponsAndShields extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.ITEM, harvestingScythe());//
        App.DataManager.add(Enums.DataTypes.ITEM, woodcuttersAxe());//
        App.DataManager.add(Enums.DataTypes.ITEM, ironSword());//
        App.DataManager.add(Enums.DataTypes.ITEM, oakStaff());//
        App.DataManager.add(Enums.DataTypes.ITEM, woodenSpear());//
        App.DataManager.add(Enums.DataTypes.ITEM, copperSword());//
        App.DataManager.add(Enums.DataTypes.ITEM, magicRod());//
        App.DataManager.add(Enums.DataTypes.ITEM, throwingKnives());//
        App.DataManager.add(Enums.DataTypes.ITEM, heavyMace());//
        App.DataManager.add(Enums.DataTypes.ITEM, longDagger());//
        App.DataManager.add(Enums.DataTypes.ITEM, spellwandOfSorcery());//
        App.DataManager.add(Enums.DataTypes.ITEM, longOakBow());//
        App.DataManager.add(Enums.DataTypes.ITEM, steelBattleAxe());//
        App.DataManager.add(Enums.DataTypes.ITEM, giantSword());//
        App.DataManager.add(Enums.DataTypes.ITEM, copperHammer());//
        App.DataManager.add(Enums.DataTypes.ITEM, shadowDagger());//
        App.DataManager.add(Enums.DataTypes.ITEM, wandOfFortitude());//
        App.DataManager.add(Enums.DataTypes.ITEM, heavyCrossbow());//
        App.DataManager.add(Enums.DataTypes.ITEM, caltraniumSword());//
        App.DataManager.add(Enums.DataTypes.ITEM, goldDagger());//
        App.DataManager.add(Enums.DataTypes.ITEM, skillfulsStaff());//
        App.DataManager.add(Enums.DataTypes.ITEM, rodOfmasters());//
        App.DataManager.add(Enums.DataTypes.ITEM, elvenBow());//
        App.DataManager.add(Enums.DataTypes.ITEM, maceOfOrdenance());//
        App.DataManager.add(Enums.DataTypes.ITEM, rodOfRighteous());//
        App.DataManager.add(Enums.DataTypes.ITEM, rodOfUnjust());//
        App.DataManager.add(Enums.DataTypes.ITEM, automaticCrossbow());//
        App.DataManager.add(Enums.DataTypes.ITEM, endlessSword());//
        App.DataManager.add(Enums.DataTypes.ITEM, endlessBow());//
        App.DataManager.add(Enums.DataTypes.ITEM, endlessWand());//
        App.DataManager.add(Enums.DataTypes.ITEM, torch());//

        App.DataManager.add(Enums.DataTypes.ITEM, plankShield());//
        App.DataManager.add(Enums.DataTypes.ITEM, woodenShield());//
        App.DataManager.add(Enums.DataTypes.ITEM, ironShield());//
        App.DataManager.add(Enums.DataTypes.ITEM, copperShield());//
        App.DataManager.add(Enums.DataTypes.ITEM, goldShield());//
        App.DataManager.add(Enums.DataTypes.ITEM, steelShield());//
        App.DataManager.add(Enums.DataTypes.ITEM, largeShield());//
        App.DataManager.add(Enums.DataTypes.ITEM, caltraniumShield());//
        App.DataManager.add(Enums.DataTypes.ITEM, endlessShield());//
        App.DataManager.add(Enums.DataTypes.ITEM, blazeShield());//
        App.DataManager.add(Enums.DataTypes.ITEM, glacierShield());//
        App.DataManager.add(Enums.DataTypes.ITEM, darknessShield());//
        App.DataManager.add(Enums.DataTypes.ITEM, celestialShield());//
        App.DataManager.add(Enums.DataTypes.ITEM, natureShield());//

    }

    // ------------------ WEAPONS ----------------- \\

    EquippableItem harvestingScythe() {
        EquippableItem equipItem = new EquippableItem("Harvest Scythe");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Foice de Colheita");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Guadaña de Cosecha");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 1;
        equipItem.maxDamage = 3;
        equipItem.criticalChanceIncrease = 1;
        equipItem.marketValue = 2;
        equipItem.weight = 1;
        equipItem.type = Enums.ItemType.WEAPON;
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A simple scythe used by peasants on their farms.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma simples foice usada por camponeses em suas fazendas.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una simple guadaña utilizada por los campesinos en sus granjas.");

        return equipItem;
    }

    EquippableItem woodcuttersAxe() {
        EquippableItem equipItem = new EquippableItem("Woodcutter's Axe");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Machado de Lenhador");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hacha de Leñador");
        equipItem.imgFile = "item_woodcutters_axe";

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 1;
        equipItem.maxDamage = 3;
        equipItem.criticalChanceIncrease = 7;
        equipItem.marketValue = 4;
        equipItem.weight = 2f;
        equipItem.type = Enums.ItemType.WEAPON;
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A heavy simple axe used by woodcutters to chop down trees.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um machado simples e pesado usado por lenhadores para derrubar árvores.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un hacha simple y pesada utilizada por los leñadores para talar árboles.");

        return equipItem;
    }

    EquippableItem ironSword() {
        EquippableItem equipItem = new EquippableItem("Iron Sword");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Espada de Ferro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Espada de Hierro");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 2;
        equipItem.maxDamage = 4;
        equipItem.criticalChanceIncrease = 4;
        equipItem.marketValue = 9;
        equipItem.weight = .7f;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "If you are a beginner soldier, this simple iron sword is for you.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Se você é um soldado iniciante, essa espada simples de ferro é para você.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Si eres un soldado principiante, esta sencilla espada de hierro es para ti.");

        return equipItem;
    }

    EquippableItem oakStaff() {
        EquippableItem equipItem = new EquippableItem("Oak Staff");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cajado de Carvalho");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bastón de Roble");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 1;
        equipItem.maxDamage = 4;
        equipItem.criticalChanceIncrease = 3;
        equipItem.marketValue = 7;
        equipItem.weight = .5f;
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.type = Enums.ItemType.MAGICAL_WEAPON;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Crafted with aged oak by experienced wizards for novice wizards.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Feito com carvalho envelhecido por feiticeiros experientes para feiticeiros novatos.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Elaborado con roble envejecido por magos experimentados para magos novatos.");

        return equipItem;
    }

    EquippableItem woodenSpear() {
        EquippableItem equipItem = new EquippableItem("Wooden Spear");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lança de Madeira");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lanza de Madera");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 1;
        equipItem.maxDamage = 4;
        equipItem.criticalChanceIncrease = 9;
        equipItem.marketValue = 8;
        equipItem.weight = .4f;
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.type = Enums.ItemType.WEAPON;
        equipItem.canBeIngredient = false;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A long wooden stick with a carved tip.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma vara longa de madeira com a ponta esculpida.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un palo largo de madera con punta tallada.");

        return equipItem;
    }

    EquippableItem copperSword() {
        EquippableItem equipItem = new EquippableItem("Copper Sword");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Espada de Cobre");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Espada de Cobre");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 2;
        equipItem.maxDamage = 6;
        equipItem.criticalChanceIncrease = 6;
        equipItem.marketValue = 20;
        equipItem.weight = .8f;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A cutting weapon with good resistance and sharpness. All copper, except the handle.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma arma de corte com boa resistência e afiamento. Toda em cobre, exceto a empunhadura.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un arma cortante con buena resistencia y filo. Todo cobre, excepto el mango.");

        return equipItem;
    }

    EquippableItem magicRod() {
        EquippableItem equipItem = new EquippableItem("Magic Rod");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Bastão Mágico");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Varita Mágica");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 2;
        equipItem.maxDamage = 3;
        equipItem.criticalChanceIncrease = 3;
        equipItem.marketValue = 18;
        equipItem.weight = .5f;
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP_MODIFIER, 2));
        equipItem.type = Enums.ItemType.MAGICAL_WEAPON;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An advanced magical rod for wizards that are not novices anymore.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma vara mágica avançada para bruxos que não são mais novatos.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una varita mágica avanzada para magos que ya no son novatos.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem throwingKnives() {
        EquippableItem equipItem = new EquippableItem("Throwing Knives");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Facas de Arremesso");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cuchillos para Lanzar");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 1;
        equipItem.maxDamage = 5;
        equipItem.criticalChanceIncrease = 10;
        equipItem.marketValue = 19;
        equipItem.weight = .4f;
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Knives with a specific handle and size to be thrown.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Facas com cabo e tamanho específicos para serem arremessadas.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cuchillos con mango y tamaño específico para ser lanzados.");

        return equipItem;
    }

    EquippableItem heavyMace() {
        EquippableItem equipItem = new EquippableItem("Heavy Mace");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Maça Pesada");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Maza Pesada");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 3;
        equipItem.maxDamage = 7;
        equipItem.criticalChanceIncrease = 11;
        equipItem.marketValue = 55;
        equipItem.weight = 2.5f;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 4) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An iron cable and a steel ball at the end, ideal for crushing and breaking.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um cabo de ferro e uma bola de aço na ponta, ideal para esmagar e quebrar.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un cable de hierro y una bola de acero al final, ideal para aplastar y romper.");

        return equipItem;
    }

    EquippableItem longDagger() {
        EquippableItem equipItem = new EquippableItem("Long Dagger");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Adaga Longa");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Daga Larga");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 3;
        equipItem.maxDamage = 5;
        equipItem.criticalChanceIncrease = 13;
        equipItem.marketValue = 55;
        equipItem.weight = .8f;
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 4) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A longer and thinner dagger, easy to handle and stab at the enemy.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma adaga mais longa e fina, fácil de manusear e estocar no inimigo.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una daga más larga y delgada, fácil de manejar y apuñalar al enemigo.");

        return equipItem;
    }

    EquippableItem spellwandOfSorcery() {
        EquippableItem equipItem = new EquippableItem("Spellwand of Sorcery");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cajado da Feitiçaria");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Varita Mágica de Hechicería");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 3;
        equipItem.maxDamage = 5;
        equipItem.criticalChanceIncrease = 5;
        equipItem.marketValue = 50;
        equipItem.weight = .9f;
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP_MODIFIER, 2));
        equipItem.type = Enums.ItemType.MAGICAL_WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 4) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The magical effect applied to this wand made it a great option for magicians.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O efeito mágico aplicado a esta varinha a tornou uma ótima opção para mágicos.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El efecto mágico aplicado a esta varita la convirtió en una gran opción para los magos.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem longOakBow() {
        EquippableItem equipItem = new EquippableItem("Long Oak Bow");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Arco Longo de Carvalho");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Arco Largo de Roble");

        equipItem.slotPart = Enums.SlotPart.TWO_HANDS;
        equipItem.minDamage = 4;
        equipItem.maxDamage = 7;
        equipItem.criticalChanceIncrease = 7;
        equipItem.marketValue = 50;
        equipItem.weight = .7f;
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 4) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The oak branch used here is perfect to increase the unleash power of arrows.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O galho de carvalho usado aqui é perfeito para aumentar o poder de disparo das flechas.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La rama de roble utilizada aquí es perfecta para aumentar el poder de lanzamiento de las flechas.");

        return equipItem;
    }

    EquippableItem steelBattleAxe() {
        EquippableItem equipItem = new EquippableItem("Steel Battle Axe");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Machado de Batalha de Aço");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hacha de batalla de acero");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 6;
        equipItem.maxDamage = 11;
        equipItem.criticalChanceIncrease = 12;
        equipItem.marketValue = 90;
        equipItem.weight = 2.5f;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 6) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is heavy, with dual bladed sides, perfect for powerful warriors.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É pesado, com lados de lâmina dupla, perfeito para guerreiros poderosos.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es pesado, con lados de doble hoja, perfecto para guerreros poderosos.");

        return equipItem;
    }

    EquippableItem giantSword() {
        EquippableItem equipItem = new EquippableItem("Giant Sword");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Espada Gigante");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Espada Gigante");

        equipItem.slotPart = Enums.SlotPart.TWO_HANDS;
        equipItem.minDamage = 7;
        equipItem.maxDamage = 11;
        equipItem.criticalChanceIncrease = 18;
        equipItem.marketValue = 90;
        equipItem.weight = 3.2f;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 6) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A big large blade that requires skill and strength to handle.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma lâmina grande e grande que requer habilidade e força para manusear.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una hoja de gran tamaño que requiere habilidad y fuerza para manejarla.");

        return equipItem;
    }

    EquippableItem copperHammer() {
        EquippableItem equipItem = new EquippableItem("Copper Hammer");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Martelo de Cobre");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Martillo de Cobre");

        equipItem.slotPart = Enums.SlotPart.TWO_HANDS;
        equipItem.minDamage = 6;
        equipItem.maxDamage = 10;
        equipItem.criticalChanceIncrease = 16;
        equipItem.marketValue = 78;
        equipItem.weight = 2.7f;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 5) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A heavy weapon that can smash almost anything with its copper head.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma arma pesada que pode destruir quase tudo com sua cabeça de cobre.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un arma pesada que puede destruir casi cualquier cosa con su cabeza de cobre.");

        return equipItem;
    }

    EquippableItem shadowDagger() {
        EquippableItem equipItem = new EquippableItem("Shadow Dagger");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Adaga Sombria");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Daga Oscura");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 4;
        equipItem.maxDamage = 9;
        equipItem.criticalChanceIncrease = 9;
        equipItem.marketValue = 80;
        equipItem.element = Enums.Elements.DARK;
        equipItem.weight = .5f;
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.ALIGNMENT, 2, Enums.StatusModifier.DECREASE));
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 6) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An small dark blade. Easy to handle and hide. Just for bad kinds.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma pequena lâmina escura. Fácil de manusear e esconder. Só para tipos ruins.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una pequeña cuchilla oscura. Fácil de manejar y ocultar. Solo para tipos malos.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem wandOfFortitude() {
        EquippableItem equipItem = new EquippableItem("Wand of Fortitude");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Bastão da Vitalidade");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Vara de Vitalidad");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 3;
        equipItem.maxDamage = 6;
        equipItem.criticalChanceIncrease = 9;
        equipItem.marketValue = 90;
        equipItem.weight = .9f;
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP_MODIFIER, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP_MODIFIER, 3));
        equipItem.type = Enums.ItemType.MAGICAL_WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 6) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Mages that look for more vitality should use this mystic wand.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Magos que buscam mais vitalidade devem usar esta varinha mística.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Los magos que buscan más vitalidad deberían usar esta varita mística.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem heavyCrossbow() {
        EquippableItem equipItem = new EquippableItem("Heavy Crossbow");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Besta Pesada");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Ballesta Pesada");

        equipItem.slotPart = Enums.SlotPart.TWO_HANDS;
        equipItem.minDamage = 7;
        equipItem.maxDamage = 10;
        equipItem.criticalChanceIncrease = 20;
        equipItem.marketValue = 90;
        equipItem.weight = 2.4f;
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 6) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Very well crafted crossbow that can shoot a bolt with lots of power.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Besta muito bem feita que pode disparar um dardo com muita potência.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Ballesta muy bien elaborada que puede disparar un perno con mucha potencia.");

        return equipItem;
    }

    EquippableItem caltraniumSword() {
        EquippableItem equipItem = new EquippableItem("Caltranium Sword");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Espada de Caltranio");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Espada de Caltranio");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 16;
        equipItem.maxDamage = 22;
        equipItem.criticalChanceIncrease = 15;
        equipItem.marketValue = 220;
        equipItem.weight = 2.5f;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.type = Enums.ItemType.WEAPON;
        equipItem.rarity = Enums.Rarity.RARE;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 12) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Caltranium is easy to sharpen making this sword an incredible tool for battling.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O caltranium é fácil de afiar, o que torna esta espada uma ferramenta incrível para batalhas.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El caltranium es fácil de afilar, lo que convierte a esta espada en una herramienta increíble para el combate.");

        return equipItem;
    }

    EquippableItem goldDagger() {
        EquippableItem equipItem = new EquippableItem("Gold Dagger");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Adaga de Ouro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Daga de Oro");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 10;
        equipItem.maxDamage = 14;
        equipItem.criticalChanceIncrease = 8;
        equipItem.marketValue = 175;
        equipItem.weight = .5f;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.CHARISMA, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.LUCK, 1));
        equipItem.type = Enums.ItemType.WEAPON;
        equipItem.rarity = Enums.Rarity.RARE;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 6) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A hand made long knive with gold details and a very sharp blade.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma faca longa feita à mão com detalhes dourados e uma lâmina muito afiada.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un cuchillo largo hecho a mano con detalles dorados y una hoja muy afilada.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem skillfulsStaff() {
        EquippableItem equipItem = new EquippableItem("Skillful's Staff");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Bastão do Habilidoso");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bastón de Hábil");

        equipItem.slotPart = Enums.SlotPart.TWO_HANDS;
        equipItem.minDamage = 9;
        equipItem.maxDamage = 13;
        equipItem.criticalChanceIncrease = 16;
        equipItem.marketValue = 155;
        equipItem.weight = .8f;
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 1));
        equipItem.type = Enums.ItemType.MAGICAL_WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 8) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Besides its magical power it is also perfect for handling and agile movements.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Além do seu poder mágico, ele também é perfeito para manobras e movimentos ágeis.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Además de su poder mágico también es perfecto para el manejo y movimientos ágiles.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem rodOfmasters() {
        EquippableItem equipItem = new EquippableItem("Rod of Masters");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cajado dos Mestres");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Personal de los Maestros");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 8;
        equipItem.maxDamage = 12;
        equipItem.criticalChanceIncrease = 9;
        equipItem.marketValue = 175;
        equipItem.weight = .8f;
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP_MODIFIER, 5));
        equipItem.type = Enums.ItemType.MAGICAL_WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 12) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Made by master magicians to master magicians. Powerful.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Feito por mestres mágicos para mestres mágicos. Poderoso.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hecho por magos expertos para magos expertos. Poderoso.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem elvenBow() {
        EquippableItem equipItem = new EquippableItem("Elven Bow");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Arco Élfico");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Arco Élfico");

        equipItem.slotPart = Enums.SlotPart.TWO_HANDS;
        equipItem.minDamage = 15;
        equipItem.maxDamage = 20;
        equipItem.criticalChanceIncrease = 14;
        equipItem.marketValue = 195;
        equipItem.weight = 1.2f;
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 11) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Probably the more precise bow ever. Crafted by elder elves.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Provavelmente o arco mais preciso de todos. Feito por elfos anciões.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Probablemente el arco más preciso jamás creado. Fabricado por elfos ancianos.");

        return equipItem;
    }

    EquippableItem knivesOfBreeze() {
        EquippableItem equipItem = new EquippableItem("Knives of Breeze");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Facas da Brisa");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Fajas de Brillo");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 5;
        equipItem.maxDamage = 8;
        equipItem.criticalChanceIncrease = 8;
        equipItem.marketValue = 55;
        equipItem.weight = 1.1f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 1));
        equipItem.element = Enums.Elements.WIND;
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.type = Enums.ItemType.MAGICAL_WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 4) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };
        return equipItem;
    }

    EquippableItem fireSword() {
        EquippableItem equipItem = new EquippableItem("Fire Sword");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Espada de Fogo");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Espada de Fuego");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 4;
        equipItem.maxDamage = 7;
        equipItem.extraDamage = 1;
        equipItem.criticalChanceIncrease = 10;
        equipItem.marketValue = 58;
        equipItem.weight = 1.6f;
        equipItem.element = Enums.Elements.FIRE;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.type = Enums.ItemType.MAGICAL_WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 4) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };
        return equipItem;
    }

    EquippableItem BladeOfFlames() {
        EquippableItem equipItem = new EquippableItem("Blade of Flames");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lâmina de Fogo");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hoja de Fuego");

        equipItem.slotPart = Enums.SlotPart.TWO_HANDS;
        equipItem.minDamage = 10;
        equipItem.maxDamage = 14;
        equipItem.criticalChanceIncrease = 15;
        equipItem.marketValue = 140;
        equipItem.gemCost = 8;
        equipItem.weight = 3.6f;
        equipItem.element = Enums.Elements.FIRE;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.type = Enums.ItemType.MAGICAL_WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 12) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };
        return equipItem;
    }

    EquippableItem GlacierMace() {
        EquippableItem equipItem = new EquippableItem("Glacier Mace");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Maça Glacial");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Maza Glaciar");

        equipItem.slotPart = Enums.SlotPart.TWO_HANDS;
        equipItem.minDamage = 7;
        equipItem.maxDamage = 11;
        equipItem.criticalChanceIncrease = 18;
        equipItem.marketValue = 82;
        equipItem.weight = 2.7f;
        equipItem.element = Enums.Elements.WATER;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.type = Enums.ItemType.MAGICAL_WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 5) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };
        return equipItem;
    }

    EquippableItem steelSpear() {
        EquippableItem equipItem = new EquippableItem("Steel Spear");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lança de Aço");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lanza de Acero");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 4;
        equipItem.maxDamage = 8;
        equipItem.criticalChanceIncrease = 11;
        equipItem.marketValue = 60;
        equipItem.weight = 1.5f;
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };
        return equipItem;
    }

    EquippableItem maceOfOrdenance() {
        EquippableItem equipItem = new EquippableItem("Mace of Ordenance");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Maça da Ordenança");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Maza de Ordenanza");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 9;
        equipItem.maxDamage = 12;
        equipItem.criticalChanceIncrease = 25;
        equipItem.marketValue = 50;
        equipItem.gemCost = 15;
        equipItem.weight = 1.8f;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.STRENGTH, 2));
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Made to gladiators, but soldiers are now using since it is powerful and scary.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Feito para gladiadores, mas agora é usado por soldados porque é poderoso e assustador.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hecho para gladiadores, pero ahora lo usan los soldados porque es poderoso y aterrador.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem rodOfRighteous() {
        EquippableItem equipItem = new EquippableItem("Rod of Righteous");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cajado dos Justos");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bastón de los Justos");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 5;
        equipItem.maxDamage = 8;
        equipItem.criticalChanceIncrease = 10;
        equipItem.marketValue = 50;
        equipItem.gemCost = 15;
        equipItem.weight = 1.5f;
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.LUCK, 3));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.ALIGNMENT, 3));
        equipItem.type = Enums.ItemType.MAGICAL_WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The wizards that look for justice and magical power should wield this.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Os magos que buscam justiça e poder mágico devem usar isso.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Los magos que buscan justicia y poder mágico deberían manejar esto.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem rodOfUnjust() {
        EquippableItem equipItem = new EquippableItem("Rod of Unjust");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cajado dos Injustos");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bastón de los Injustos");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 5;
        equipItem.maxDamage = 8;
        equipItem.criticalChanceIncrease = 10;
        equipItem.marketValue = 50;
        equipItem.gemCost = 15;
        equipItem.weight = 1.5f;
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.CHARISMA, 1, Enums.StatusModifier.DECREASE));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.LUCK, 3));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.ALIGNMENT, 3, Enums.StatusModifier.DECREASE));
        equipItem.type = Enums.ItemType.MAGICAL_WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The wizards that are on the dark side and looking for power should wield this.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Os magos que estão no lado negro e buscam poder devem usar isso.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Los magos que están en el lado oscuro y buscan poder deberían manejar esto.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem automaticCrossbow() {
        EquippableItem equipItem = new EquippableItem("Automatic Crossbow");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Besta Automática");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Ballesta Automática");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 7;
        equipItem.maxDamage = 12;
        equipItem.criticalChanceIncrease = 24;
        equipItem.marketValue = 50;
        equipItem.gemCost = 15;
        equipItem.weight = 1.8f;
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 2));
        equipItem.type = Enums.ItemType.WEAPON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A great piece of engineering that can shoot be easily handled.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma grande peça de engenharia que pode ser facilmente manuseada.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una gran pieza de ingeniería que se puede disparar y manipular con facilidad.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem endlessSword() {
        EquippableItem equipItem = new EquippableItem("Endless Sword");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Espada Endless");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Espada Endless");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 20;
        equipItem.maxDamage = 25;
        equipItem.criticalChanceIncrease = 21;
        equipItem.marketValue = 60;
        equipItem.gemCost = 25;
        equipItem.weight = 1.5f;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.STRENGTH, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP_MODIFIER, 3));
        equipItem.type = Enums.ItemType.WEAPON;
        equipItem.rarity = Enums.Rarity.SPECIAL;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 5) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is so unique that its price is priceless. It is mystical and very powerful.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É tão único que seu preço é quase inestimável. É místico e muito poderoso.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es tan único que su precio no tiene precio. Es místico y muy poderoso.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem endlessWand() {
        EquippableItem equipItem = new EquippableItem("Endless Wand");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cajado Endless");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bastón Endless");

        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.minDamage = 10;
        equipItem.maxDamage = 13;
        equipItem.criticalChanceIncrease = 12;
        equipItem.marketValue = 60;
        equipItem.gemCost = 25;
        equipItem.weight = .8f;
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 3));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP_MODIFIER, 3));
        equipItem.type = Enums.ItemType.MAGICAL_WEAPON;
        equipItem.rarity = Enums.Rarity.SPECIAL;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 5) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is so unique that its price is priceless. It is mystical and very powerful.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É tão único que seu preço é quase inestimável. É místico e muito poderoso.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es tan único que su precio no tiene precio. Es místico y muy poderoso.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem endlessBow() {
        EquippableItem equipItem = new EquippableItem("Endless Bow");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Arco Endless");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Arco Endless");

        equipItem.slotPart = Enums.SlotPart.TWO_HANDS;
        equipItem.minDamage = 18;
        equipItem.maxDamage = 23;
        equipItem.criticalChanceIncrease = 18;
        equipItem.marketValue = 65;
        equipItem.gemCost = 25;
        equipItem.weight = 1f;
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 3));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.CHARISMA, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.LUCK, 1));
        equipItem.type = Enums.ItemType.WEAPON;
        equipItem.rarity = Enums.Rarity.SPECIAL;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 5) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is so unique that its price is priceless. It is mystical and very powerful.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É tão único que seu preço é quase inestimável. É místico e muito poderoso.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es tan único que su precio no tiene precio. Es místico y muy poderoso.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    Item torch() {
        EquippableItem equipItem = new EquippableItem("Torch");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Tocha");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Antorcha");
        equipItem.slotPart = Enums.SlotPart.HAND_1;
        equipItem.type = Enums.ItemType.WEAPON;
        equipItem.minDamage = 1;
        equipItem.maxDamage = 2;
        equipItem.criticalChanceIncrease = 1;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A small piece of wood with a tissue soaked in a combustible liquid. Used to generate light and some heat.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um pequeno pedaço de madeira com um lenço embebido em líquido combustível. Usado para gerar luz e algum calor.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un pequeño trozo de madera con un pañuelo empapado en un líquido combustible. Se utiliza para generar luz y algo de calor.");

        equipItem.weight = .4f;
        equipItem.marketValue = 3;
        equipItem.canBeIngredient = false;

        return equipItem;
    }

    // ------------------ SHIELDS ----------------- \\

    EquippableItem plankShield() {
        EquippableItem equipItem = new EquippableItem("Plank Shield");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo de Tábua");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo de Tablero");

        equipItem.slotPart = Enums.SlotPart.HAND_2;
        equipItem.marketValue = 7;
        equipItem.defense = 1;
        equipItem.weight = .8f;
        equipItem.type = Enums.ItemType.SHIELD;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "If you are poor, you can use some small planks as shield.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Se você for pobre, pode usar algumas tábuas pequenas como escudo.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Si eres pobre, puedes usar algunas tablas pequeñas como escudo.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem woodenShield() {
        EquippableItem equipItem = new EquippableItem("Wooden Shield");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo de Madeira");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo de Madera");

        equipItem.slotPart = Enums.SlotPart.HAND_2;
        equipItem.marketValue = 18;
        equipItem.defense = 2;
        equipItem.weight = 1f;
        equipItem.type = Enums.ItemType.SHIELD;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A good simple shield made of wood with an iron hoop around.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um escudo simples e bom feito de madeira com um arco de ferro ao redor.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un buen escudo sencillo hecho de madera con un aro de hierro alrededor.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem ironShield() {
        EquippableItem equipItem = new EquippableItem("Iron Shield");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo de Ferro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo de Hierro");

        equipItem.slotPart = Enums.SlotPart.HAND_2;
        equipItem.marketValue = 40;
        equipItem.defense = 3;
        equipItem.weight = 1.6f;
        equipItem.type = Enums.ItemType.SHIELD;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Made with pure iron, heavy but efficient.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Feito de ferro puro, pesado, mas eficiente.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Fabricado con hierro puro, pesado pero eficiente.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem copperShield() {
        EquippableItem equipItem = new EquippableItem("Copper Shield");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo de Cobre");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo de Cobre");

        equipItem.slotPart = Enums.SlotPart.HAND_2;
        equipItem.marketValue = 95;
        equipItem.defense = 4;
        equipItem.weight = 1.6f;
        equipItem.type = Enums.ItemType.SHIELD;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A thick plate of copper shaped as a good shield.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma placa grossa de cobre moldada como um bom escudo.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una placa gruesa de cobre con forma de buen escudo.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem goldShield() {
        EquippableItem equipItem = new EquippableItem("Gold Shield");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo de Ouro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo de Oro");

        equipItem.slotPart = Enums.SlotPart.HAND_2;
        equipItem.marketValue = 90;
        equipItem.defense = 3;
        equipItem.weight = 1.3f;
        equipItem.type = Enums.ItemType.SHIELD;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.CHARISMA, 2));
        equipItem.rarity = Enums.Rarity.UNCOMMON;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It seems ridiculous to use gold to protect against dangerous hits.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Parece ridículo usar ouro para se proteger contra ataques perigosos.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Parece ridículo utilizar oro para protegerse de golpes peligrosos.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem steelShield() {
        EquippableItem equipItem = new EquippableItem("Steel Shield");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo de Aço");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo de Acero");

        equipItem.slotPart = Enums.SlotPart.HAND_2;
        equipItem.marketValue = 125;
        equipItem.defense = 5;
        equipItem.weight = 2f;
        equipItem.type = Enums.ItemType.SHIELD;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 6) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Perfect balance between weight and protection efficiency.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Equilíbrio perfeito entre peso e eficiência de proteção.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Equilibrio perfecto entre peso y eficacia de protección.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem largeShield() {
        EquippableItem equipItem = new EquippableItem("Large Shield");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo Longo");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo Largo");

        equipItem.slotPart = Enums.SlotPart.HAND_2;
        equipItem.marketValue = 75;
        equipItem.defense = 4;
        equipItem.weight = 3.5f;
        equipItem.type = Enums.ItemType.SHIELD;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 1, Enums.StatusModifier.DECREASE));
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.THIEF);

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is really heavy and hard to handle, but protects almost the entire body.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É muito pesado e difícil de manusear, mas protege quase todo o corpo.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es realmente pesado y difícil de manejar, pero protege casi todo el cuerpo.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem caltraniumShield() {
        EquippableItem equipItem = new EquippableItem("Caltranium Shield");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo de Caltranio");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo de Caltranio");

        equipItem.slotPart = Enums.SlotPart.HAND_2;
        equipItem.marketValue = 180;
        equipItem.defense = 6;
        equipItem.weight = 1.8f;
        equipItem.type = Enums.ItemType.SHIELD;
        equipItem.rarity = Enums.Rarity.RARE;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 10) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Caltranium is moldable and resistant enough to make a great shield.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O Caltranio é moldável e resistente o suficiente para formar um ótimo escudo.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Caltranio es moldeable y lo suficientemente resistente como para formar un gran escudo.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem endlessShield() {
        EquippableItem equipItem = new EquippableItem("Endless Shield");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo Endless");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo Endless");

        equipItem.slotPart = Enums.SlotPart.HAND_2;
        equipItem.marketValue = 50;
        equipItem.gemCost = 20;
        equipItem.defense = 7;
        equipItem.weight = 1.5f;
        equipItem.type = Enums.ItemType.SHIELD;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.STRENGTH, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 2));
        equipItem.rarity = Enums.Rarity.SPECIAL;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is so unique that its price is priceless. It is mystical and very resistant.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É tão único que seu preço é quase inestimável. É místico e muito resistente.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es tan único que su precio no tiene precio. Es místico y muy resistente.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem blazeShield() {
        EquippableItem equipItem = new EquippableItem("Blaze Shield");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo das Chamas");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo de Fuego");

        equipItem.slotPart = Enums.SlotPart.HAND_2;
        equipItem.marketValue = 60;
        equipItem.defense = 3;
        equipItem.weight = 1.5f;
        equipItem.type = Enums.ItemType.SHIELD;
        equipItem.resistancesModifiers.put(Enums.Elements.FIRE, 25);
        equipItem.weaknessesModifiers.put(Enums.Elements.WATER, 25);
        equipItem.rarity = Enums.Rarity.UNCOMMON;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Forged by the gods of fire. (25% Fire resistance) (25% Water weakness)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forjado pelos deuses do fogo. (25% de resistência ao fogo) (25% de fraqueza à água)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Forjado por los dioses del fuego. (25% Resistencia al fuego) (25% Debilidad al agua)");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem glacierShield() {
        EquippableItem equipItem = new EquippableItem("Glacier Shield");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo Glacial");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo Glaciar");

        equipItem.slotPart = Enums.SlotPart.HAND_2;
        equipItem.marketValue = 60;
        equipItem.defense = 3;
        equipItem.weight = 1.5f;
        equipItem.type = Enums.ItemType.SHIELD;
        equipItem.weaknessesModifiers.put(Enums.Elements.FIRE, 25);
        equipItem.resistancesModifiers.put(Enums.Elements.WATER, 25);
        equipItem.rarity = Enums.Rarity.UNCOMMON;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Forged by the gods of waters. (25% Water resistance) (25% Fire weakness)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forjado pelos deuses das águas. (25% de resistência à água) (25% de fraqueza ao fogo)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Forjado por los dioses de las aguas. (25% Resistencia al agua) (25% Debilidad al fuego)");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem darknessShield() {
        EquippableItem equipItem = new EquippableItem("Darkness Shield");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo da Escuridão");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo de Oscuridad");

        equipItem.slotPart = Enums.SlotPart.HAND_2;
        equipItem.marketValue = 60;
        equipItem.defense = 3;
        equipItem.weight = 1.5f;
        equipItem.type = Enums.ItemType.SHIELD;
        equipItem.weaknessesModifiers.put(Enums.Elements.DARK, 25);
        equipItem.resistancesModifiers.put(Enums.Elements.LIGHT, 25);
        equipItem.rarity = Enums.Rarity.RARE;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Forged by the devils. (25% Light resistance) (25% Dark weakness)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forjado pelos demônios. (25% de resistência à luz) (25% de fraqueza à escuridão)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Forjado por los demonios. (25% Resistencia a la luz) (25% Debilidad a la oscuridad)");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem celestialShield() {
        EquippableItem equipItem = new EquippableItem("Celestial Shield");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo Celestial");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo Celestial");

        equipItem.slotPart = Enums.SlotPart.HAND_2;
        equipItem.marketValue = 60;
        equipItem.defense = 3;
        equipItem.weight = 1.5f;
        equipItem.type = Enums.ItemType.SHIELD;
        equipItem.resistancesModifiers.put(Enums.Elements.DARK, 25);
        equipItem.weaknessesModifiers.put(Enums.Elements.LIGHT, 25);
        equipItem.rarity = Enums.Rarity.RARE;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Forged by the angels. (25% Dark resistance) (25% Light weakness)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forjado pelos anjos. (25% de resistência à escuridão) (25% de fraqueza à luz)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Forjado por los ángeles. (25% Resistencia a la oscuridad) (25% Debilidad a la luz)");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem natureShield() {
        EquippableItem equipItem = new EquippableItem("Nature Shield");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo da Natureza");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo de la Naturaleza");

        equipItem.slotPart = Enums.SlotPart.HAND_2;
        equipItem.marketValue = 72;
        equipItem.defense = 3;
        equipItem.weight = 1.5f;
        equipItem.type = Enums.ItemType.SHIELD;
        equipItem.resistancesModifiers.put(Enums.Elements.EARTH, 25);
        equipItem.resistancesModifiers.put(Enums.Elements.WIND, 25);
        equipItem.rarity = Enums.Rarity.UNCOMMON;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Forged by the ancient druids. (25% Earth resistance) (25% Wind resistance)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forjado pelos antigos druidas. (25% de resistência à Terra) (25% de resistência ao Vento)");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Forjado por los antiguos druidas. (25% de resistencia a la tierra) (25% de resistencia al viento)");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

}
