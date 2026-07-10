package com.cnx.endlesstalestwo.data.items;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.AttributeModifierValue;
import com.cnx.endlesstalestwo.entities.ConsumableItem;
import com.cnx.endlesstalestwo.entities.StatusModifier;
import com.cnx.endlesstalestwo.enums.Enums;

public class Potions extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.ITEM, simpleHpPotion());//
        App.DataManager.add(Enums.DataTypes.ITEM, hpPotion());//
        App.DataManager.add(Enums.DataTypes.ITEM, specialHpPotion());//
        App.DataManager.add(Enums.DataTypes.ITEM, simpleMpPotion());//
        App.DataManager.add(Enums.DataTypes.ITEM, mpPotion());//
        App.DataManager.add(Enums.DataTypes.ITEM, specialMpPotion());//
        App.DataManager.add(Enums.DataTypes.ITEM, meadPotion());//
        App.DataManager.add(Enums.DataTypes.ITEM, elixirPotion());//
        App.DataManager.add(Enums.DataTypes.ITEM, antidote());//
        App.DataManager.add(Enums.DataTypes.ITEM, expertisePotion());//
    }

    ConsumableItem simpleHpPotion() {
        ConsumableItem consumable = new ConsumableItem("Simple HP Potion");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Poção PV Simples");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Poción HP Simple");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Restores between 7 and 11 HP.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Recupera entre 7 e 11 PV.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Recupera entre 7 y 11 HP.");

        consumable.type = Enums.ItemType.POTION;
        consumable.weight = .1f;
        consumable.marketValue = 4;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 7, 11, 0));
        consumable.inBattleUsage = true;
        consumable.usageSound = "potion_usage";

        return consumable;
    }

    ConsumableItem hpPotion() {
        ConsumableItem consumable = new ConsumableItem("HP Potion");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Poção PV");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Poción HP");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Restores between 14 and 21 HP.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Recupera entre 14 e 21 PV.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Recupera entre 14 y 21 HP.");

        consumable.type = Enums.ItemType.POTION;
        consumable.weight = .3f;
        consumable.marketValue = 8;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 14, 21, 0));
        consumable.inBattleUsage = true;
        consumable.usageSound = "potion_usage";

        return consumable;
    }

    ConsumableItem specialHpPotion() {
        ConsumableItem consumable = new ConsumableItem("Special HP Potion");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Poção PV Especial");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Poción HP Especial");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Restores between 36 and 45 HP.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Recupera entre 36 e 45 PV.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Recupera entre 36 y 45 HP.");

        consumable.type = Enums.ItemType.POTION;
        consumable.weight = .5f;
        consumable.marketValue = 18;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 36, 45, 0));
        consumable.inBattleUsage = true;
        consumable.usageSound = "potion_usage";

        return consumable;
    }

    ConsumableItem simpleMpPotion() {
        ConsumableItem consumable = new ConsumableItem("Simple MP Potion");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Poção PM Simples");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Poción MP Simple");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Restores between 7 and 11 MP.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Recupera entre 7 e 11 PM.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Recupera entre 7 y 11 MP.");

        consumable.type = Enums.ItemType.POTION;
        consumable.weight = .1f;
        consumable.marketValue = 4;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 7, 11, 0));
        consumable.inBattleUsage = true;
        consumable.usageSound = "potion_usage";

        return consumable;
    }

    ConsumableItem mpPotion() {
        ConsumableItem consumable = new ConsumableItem("MP Potion");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Poção PM");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Poción MP");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Restores between 14 and 21 MP.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Recupera entre 14 e 21 PM.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Recupera entre 14 y 21 MP.");

        consumable.type = Enums.ItemType.POTION;
        consumable.weight = .3f;
        consumable.marketValue = 8;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 14, 21, 0));
        consumable.inBattleUsage = true;
        consumable.usageSound = "potion_usage";

        return consumable;
    }

    ConsumableItem specialMpPotion() {
        ConsumableItem consumable = new ConsumableItem("Special MP Potion");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Poção PM Especial");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Poción MP Especial");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Restores between 36 and 45 MP.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Recupera entre 36 e 45 PM.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Recupera entre 36 y 45 MP.");

        consumable.type = Enums.ItemType.POTION;
        consumable.weight = .5f;
        consumable.marketValue = 18;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 36, 45, 0));
        consumable.inBattleUsage = true;
        consumable.usageSound = "potion_usage";

        return consumable;
    }

    ConsumableItem meadPotion() {
        ConsumableItem consumable = new ConsumableItem("Mead Potion");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Poção Hidromel");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Poción de Hidromel");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Restores between 6 and 9 HP and MP.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Recupera entre 6 e 9 PV e PM.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Recupera entre 6 y 9 HP y MP.");

        consumable.type = Enums.ItemType.POTION;
        consumable.weight = .2f;
        consumable.marketValue = 7;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 6, 9, 0));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 6, 9, 0));
        consumable.inBattleUsage = true;
        consumable.usageSound = "potion_usage";

        return consumable;
    }

    ConsumableItem elixirPotion() {
        ConsumableItem consumable = new ConsumableItem("Elixir Potion");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Poção Elixir");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Poción de Elixir");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Restores between 18 and 25 HP and MP.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Recupera entre 18 e 25 PV e PM.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Recupera entre 18 y 25 HP y MP.");

        consumable.type = Enums.ItemType.POTION;
        consumable.weight = .2f;
        consumable.marketValue = 14;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 18, 25, 0));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 18, 25, 0));
        consumable.inBattleUsage = true;
        consumable.usageSound = "potion_usage";

        return consumable;
    }

    ConsumableItem antidote() {
        ConsumableItem consumable = new ConsumableItem("Antidote");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Antídoto");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Antídoto");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Removes poison status");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Remove o status de envenenamento");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Elimina el estado de envenenamiento");

        consumable.statusModifiers.add(new StatusModifier(Enums.StatusModifier.REMOVE, Enums.Status.POISONED,100,0));

        consumable.type = Enums.ItemType.POTION;
        consumable.weight = .1f;
        consumable.marketValue = 4;
        consumable.inBattleUsage = true;
        consumable.outBattleUsage = true;
        consumable.usageSound = "potion_usage";

        return consumable;
    }

    ConsumableItem expertisePotion() {
        ConsumableItem consumable = new ConsumableItem("Expertise Potion");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Poção da Expertise");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Poción de Experiencia");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Grants you wisdom. Adds 15 experience.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lhe garante sabedoria. Adiciona 15 de experiência.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Te otorga sabiduría. Añade 15 puntos de experiencia.");

        consumable.type = Enums.ItemType.POTION;
        consumable.weight = .6f;
        consumable.marketValue = 5;
        consumable.gemCost = 3;
        consumable.inBattleUsage = false;
        consumable.outBattleUsage = true;
        consumable.usageSound = "potion_usage";

        consumable.listener = () -> App.getPlayerChar().addExperience(15);

        return consumable;
    }
}