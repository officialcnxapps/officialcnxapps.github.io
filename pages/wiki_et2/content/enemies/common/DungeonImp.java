package com.cnx.endlesstalestwo.data.enemies.common;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class DungeonImp {

    public static Enemy get() {
        Enemy enemy = new Enemy("Dungeon Imp");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Imp das Cavernas");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Imp de Masmorras");

        enemy.minDamage = 1;
        enemy.maxDamage = 2;
        enemy.damageModifier = 1;
        enemy.setVitalities(14, 3);
        enemy.setDefense(1);
        enemy.setAgility(11);
        enemy.setStrength(7);
        enemy.givenExperience = 6;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 3;
        enemy.skills.put(SkillsIds.FIRE_TOUCH, 35);
        enemy.givenLoot.add(new ItemReference(ItemsIds.COAL, 1, 35));
        enemy.givenLoot.add(new ItemReference(ItemsIds.BROWN_MUSHROOM, 1, 28));

        return enemy;
    }
}

