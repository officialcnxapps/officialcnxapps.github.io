package com.cnx.endlesstalestwo.data.enemies.common;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class Crocodile {

    public static Enemy get() {
        Enemy enemy = new Enemy("Crocodile");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Crocodilo");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Crocodilo");

        enemy.minDamage = 1;
        enemy.maxDamage = 3;
        enemy.damageModifier = 2;
        enemy.setVitalities(19, 4);
        enemy.setDefense(6);
        enemy.setAgility(15);
        enemy.setStrength(11);
        enemy.givenExperience = 7;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 5;
        enemy.givenLoot.add(new ItemReference(ItemsIds.LEATHER, 1, 55));
        enemy.givenLoot.add(new ItemReference(ItemsIds.RAW_MEAT, 1, 45));
        enemy.givenLoot.add(new ItemReference(ItemsIds.ALGAE, 1, 36));

        return enemy;
    }
}

