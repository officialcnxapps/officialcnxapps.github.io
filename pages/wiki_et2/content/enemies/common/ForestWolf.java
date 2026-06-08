package com.cnx.endlesstalestwo.data.enemies.common;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class ForestWolf {

    public static Enemy get() {
        Enemy enemy = new Enemy("Forest Wolf");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lobo da Floresta");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lobo del Bosque");

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
          Forest Wolf fierce woodland predator, side view facing right, lean wolf with thick gray-brown fur,
          glowing yellow eyes, raised hackles, bared fangs, tense muscles and long bushy tail,
          stalking attack posture, wild medieval fantasy forest animal, 2D RPG sprite, white background. */

        enemy.minDamage = 1;
        enemy.maxDamage = 3;
        enemy.damageModifier = 1;
        enemy.setVitalities(13, 4);
        enemy.setDefense(1);
        enemy.setAgility(10);
        enemy.setStrength(8);
        enemy.givenExperience = 5;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 4;
        enemy.givenLoot.add(new ItemReference(ItemsIds.LEATHER, 1, 55));
        enemy.givenLoot.add(new ItemReference(ItemsIds.RAW_MEAT, 1, 45));

        return enemy;
    }
}
