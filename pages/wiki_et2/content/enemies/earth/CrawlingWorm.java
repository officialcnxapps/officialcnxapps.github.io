package com.cnx.endlesstalestwo.data.enemies.earth;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class CrawlingWorm {

    public static Enemy get() {
        Enemy enemy = new Enemy("Crawling Worm");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Verme Rastejante");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Verme Rastrero");

        enemy.minDamage = 2;
        enemy.maxDamage = 4;
        enemy.damageModifier = 1;

        enemy.setVitalities(22, 4);
        enemy.setDefense(4);
        enemy.setAgility(10);
        enemy.setStrength(14);

        enemy.weaknesses.put(Enums.Elements.FIRE, 25);
        enemy.weaknesses.put(Enums.Elements.WATER, 25);
        enemy.resistances.put(Enums.Elements.EARTH, 50);

        enemy.givenExperience = 8;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 5;
        enemy.givenLoot.add(new ItemReference(ItemsIds.CARROT, 1, 30));

        return enemy;
    }
}

