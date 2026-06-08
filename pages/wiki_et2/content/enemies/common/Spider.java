package com.cnx.endlesstalestwo.data.enemies.common;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class Spider {

    public static Enemy get() {
        Enemy enemy = new Enemy("Spider");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aranha");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Araña");

        enemy.minDamage = 0;
        enemy.maxDamage = 2;
        enemy.damageModifier = 1;
        enemy.weaknesses.put(Enums.Elements.FIRE, 25);
        enemy.resistances.put(Enums.Elements.EARTH, 25);
        enemy.setVitalities(10, 4);
        enemy.setDefense(0);
        enemy.setAgility(7);
        enemy.setStrength(6);
        enemy.givenExperience = 4;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 3;

        enemy.givenLoot.add(new ItemReference(ItemsIds.SPIDER_WEB, 1, 39));

        return enemy;
    }
}

