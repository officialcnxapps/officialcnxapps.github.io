package com.cnx.endlesstalestwo.data.enemies.humanoids;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class Pickpocketer {

    public static Enemy get() {
        Enemy enemy = new Enemy("Pickpocketer");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Salteador");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bandolero");

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Armed plains brigand outlaw, side view facing right, rough human in worn brown leather clothes,
        // torn fabric, tattered hood covering face, armed with short sword or axe, visible scars,
        // hostile desperate expression, aggressive combat stance, medieval fantasy, 2D RPG sprite, white background.

        enemy.minDamage = 2;
        enemy.maxDamage = 4;
        enemy.damageModifier = 1;
        enemy.setVitalities(18, 6);
        enemy.setDefense(2);
        enemy.setAgility(10);
        enemy.setStrength(8);
        enemy.givenExperience = 7;
        enemy.givenGold = 2;
        enemy.levelToDynamicBalance = 6;
        enemy.givenLoot.add(new ItemReference(ItemsIds.THROWING_KNIVES, 1, 13));
        enemy.givenLoot.add(new ItemReference(ItemsIds.SIMPLE_HP_POTION, 1, 15));

        return enemy;
    }
}

