package com.cnx.endlesstalestwo.data.enemies.common;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.enums.Enums;

public class GroveGoblin {

    public static Enemy get() {
        Enemy enemy = new Enemy("Grove Goblin");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Goblin do Bosque");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Duende del Bosque");

        enemy.minDamage = 1;
        enemy.maxDamage = 2;
        enemy.damageModifier = 1;
        enemy.setVitalities(14, 5);
        enemy.setDefense(1);
        enemy.setAgility(9);
        enemy.setStrength(7);
        enemy.givenExperience = 4;
        enemy.givenGold = 2;
        enemy.levelToDynamicBalance = 3;

        return enemy;
    }
}

