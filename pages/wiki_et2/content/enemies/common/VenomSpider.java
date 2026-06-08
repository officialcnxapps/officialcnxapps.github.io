package com.cnx.endlesstalestwo.data.enemies.common;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class VenomSpider {

    public static Enemy get() {
        Enemy enemy = new Enemy("Venom Spider");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aranha Venenosa");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Araña venenosa");

        enemy.minDamage = 1;
        enemy.maxDamage = 2;
        enemy.damageModifier = 1;

        enemy.weaknesses.put(Enums.Elements.FIRE, 25);
        enemy.resistances.put(Enums.Elements.EARTH, 50);

        enemy.setVitalities(12, 5);
        enemy.setDefense(1);
        enemy.setAgility(7);
        enemy.setStrength(7);
        enemy.givenExperience = 6;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 3;

        enemy.skills.put(SkillsIds.POISON_BITE, 45);

        enemy.givenLoot.add(new ItemReference(ItemsIds.SPIDER_WEB, 1, 51));

        return enemy;
    }
}

