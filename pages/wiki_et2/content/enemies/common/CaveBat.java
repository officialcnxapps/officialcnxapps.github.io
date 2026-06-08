package com.cnx.endlesstalestwo.data.enemies.common;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.entities.Enemy;

public class CaveBat {

    public static Enemy get() {
        Enemy enemy = new Enemy("Cave Bat");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Morcego de Caverna");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Murciélago de Cueva");

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
          Cave Bat giant cavern bat, side view facing right, dark gray furry body with broad leathery wings,
          large pointed ears, bright red eyes, open mouth with sharp fangs, hooked claws on wings and feet,
          low flight attack pose, medieval fantasy cave creature, 2D RPG sprite, white background. */

        enemy.minDamage = 0;
        enemy.maxDamage = 2;
        enemy.damageModifier = 1;
        enemy.setVitalities(9, 3);
        enemy.setDefense(0);
        enemy.setAgility(12);
        enemy.setStrength(5);
        enemy.givenExperience = 3;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 2;

        return enemy;
    }
}
