package com.cnx.endlesstalestwo.data.enemies.dark;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class SkeletonGuardian {

    public static Enemy get() {
        Enemy enemy = new Enemy("Skeleton Guardian");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Esqueleto Guardião");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Esqueleto Guardián");

        enemy.givenExperience = 16;
        enemy.givenGold = 3;
        enemy.setVitalities(36, 20);
        enemy.setDefense(0);
        enemy.setAgility(15);
        enemy.setStrength(16);
        enemy.minDamage = 3;
        enemy.maxDamage = 5;
        enemy.damageModifier = 1;
        enemy.levelToDynamicBalance = 8;
        enemy.skills.put(SkillsIds.RAGE, 36);
        enemy.givenLoot.add(new ItemReference(ItemsIds.TISSUE, 1, 35));
        enemy.givenLoot.add(new ItemReference(ItemsIds.STRING, 1, 31));

        return enemy;
    }
}

