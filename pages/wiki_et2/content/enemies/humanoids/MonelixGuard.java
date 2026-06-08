package com.cnx.endlesstalestwo.data.enemies.humanoids;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class MonelixGuard {

    public static Enemy get() {
        Enemy enemy = new Enemy("Monelix City Guard");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Guarda de Monelix");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Guardia de Monelix");

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
          Monelix Guard elite city soldier, full body visible from helmet to boots, fully inside frame, side view facing right,
          human warrior in polished steel armor, blue plume helmet, royal blue and silver surcoat, sword and heater shield,
          disciplined vigilant posture, no cropped legs or feet, capital city medieval fantasy guard, 2D RPG sprite, white background. */

        enemy.minDamage = 3;
        enemy.maxDamage = 5;
        enemy.damageModifier = 2;
        enemy.setVitalities(27, 16);
        enemy.setDefense(3);
        enemy.setAgility(12);
        enemy.setStrength(10);
        enemy.givenExperience = 10;
        enemy.givenGold = 1;
        enemy.levelToDynamicBalance = 9;
        enemy.givenLoot.add(new ItemReference(ItemsIds.IRON_SWORD, 1, 8));
        enemy.givenLoot.add(new ItemReference(ItemsIds.BREAD, 1, 30));

        enemy.imgFile = "enemy_army_guard";

        return enemy;
    }
}
