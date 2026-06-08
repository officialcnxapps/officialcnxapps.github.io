package com.cnx.endlesstalestwo.data.enemies.orcs;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class OrcMaster {

    public static Enemy get() {
        Enemy enemy = new Enemy("Orc Master");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Orc Mestre");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Orc Maestro");

        enemy.minDamage = 2;
        enemy.maxDamage = 4;
        enemy.damageModifier = 2;

        enemy.resistances.put(Enums.Elements.EARTH, 25);
        enemy.resistances.put(Enums.Elements.WIND, 25);
        enemy.resistances.put(Enums.Elements.DARK, 25);

        enemy.setVitalities(21, 45);
        enemy.setDefense(5);
        enemy.setAgility(11);
        enemy.setStrength(12);

        enemy.givenExperience = 10;
        enemy.givenGold = 5;

        enemy.skills.put(SkillsIds.DISABLE, 42);

        enemy.levelToDynamicBalance = 6;
        enemy.givenLoot.add(new ItemReference(ItemsIds.ORC_TOOTH, 1, 75));
        enemy.givenLoot.add(new ItemReference(ItemsIds.MEAD_POTION, 1, 50));

        return enemy;
    }
}

