package com.cnx.endlesstalestwo.data.enemies.humanoids;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class LetowGuard {

    public static Enemy get() {
        Enemy enemy = new Enemy("Letow Guard");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Guarda de Letow");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Guardia de Letow");

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
          Letow Guard weary village soldier, full body visible from helmet to boots, fully inside frame, side view facing right,
          human guard with worn leather armor, dark green rustic tunic, spear and small wooden shield, stern tired face,
          modest defensive stance, no cropped legs or feet, poor medieval frontier guard, 2D RPG sprite, white background. */

        enemy.minDamage = 2;
        enemy.maxDamage = 4;
        enemy.damageModifier = 2;
        enemy.setVitalities(18, 10);
        enemy.setDefense(2);
        enemy.setAgility(9);
        enemy.setStrength(8);
        enemy.givenExperience = 6;
        enemy.givenGold = 1;
        enemy.levelToDynamicBalance = 3;
        enemy.givenLoot.add(new ItemReference(ItemsIds.PLANK_SHIELD, 1, 18));

        return enemy;
    }
}
