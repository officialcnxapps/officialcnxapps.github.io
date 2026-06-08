package com.cnx.endlesstalestwo.data.enemies.common;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class WildBoar {

    public static Enemy get() {
        Enemy enemy = new Enemy("Wild Boar");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Javali Selvagem");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Jabalí Salvaje");

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
          Wild Boar aggressive forest beast, side view facing right, large dark brown boar with thick bristles,
          curved white tusks, muscular compact body, angry small eyes, muddy snout and strong legs,
          charging attack posture, rugged medieval fantasy animal, 2D RPG sprite, white background. */

        enemy.minDamage = 1;
        enemy.maxDamage = 3;
        enemy.damageModifier = 1;
        enemy.setVitalities(16, 5);
        enemy.setDefense(2);
        enemy.setAgility(7);
        enemy.setStrength(9);
        enemy.givenExperience = 6;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 4;
        enemy.givenLoot.add(new ItemReference(ItemsIds.RAW_MEAT, 1, 65));
        enemy.givenLoot.add(new ItemReference(ItemsIds.LEATHER, 1, 40));

        return enemy;
    }
}
