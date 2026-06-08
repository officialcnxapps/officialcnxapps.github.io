package com.cnx.endlesstalestwo.data.enemies.humanoids;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class Bandit {

    public static Enemy get() {
        Enemy enemy = new Enemy("Bandit");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Bandido");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bandido");

        enemy.minDamage = 1;
        enemy.maxDamage = 4;
        enemy.damageModifier = 1;
        enemy.setVitalities(15, 5);
        enemy.setDefense(1);
        enemy.setAgility(9);
        enemy.setStrength(7);
        enemy.givenExperience = 6;
        enemy.givenGold = 2;
        enemy.levelToDynamicBalance = 3;
        enemy.givenLoot.add(new ItemReference(ItemsIds.THROWING_KNIVES, 1, 7));

        return enemy;
    }
}

