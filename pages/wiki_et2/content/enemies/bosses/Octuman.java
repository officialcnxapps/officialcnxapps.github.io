package com.cnx.endlesstalestwo.data.enemies.bosses;

import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class Octuman {

    public static Enemy get() {
        Enemy enemy = new Enemy("Octuman");

        enemy.minDamage = 4;
        enemy.maxDamage = 8;
        enemy.damageModifier = 3;
        enemy.setVitalities(35, 20);
        enemy.setDefense(3);
        enemy.setAgility(15);
        enemy.setStrength(11);
        enemy.setMagic(9);
        enemy.attributesManager.set(Enums.AttributeName.CRITICAL_CHANCE, 10);

        enemy.givenExperience = 16;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 8;
        enemy.skills.put(SkillsIds.WATER_STRIKE, 38);
        enemy.givenLoot.add(new ItemReference(ItemsIds.TUNA, 1, 67));
        enemy.givenLoot.add(new ItemReference(ItemsIds.CRAB, 2, 55));
        enemy.givenLoot.add(new ItemReference(ItemsIds.ALGAE, 4, 50));

        return enemy;
    }
}

