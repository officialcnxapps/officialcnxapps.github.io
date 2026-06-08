package com.cnx.endlesstalestwo.data.enemies.common;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class MountainTroll {

    public static Enemy get() {
        Enemy enemy = new Enemy("Mountain Troll");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Troll da Montanha");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Trol de Montaña");

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
          Mountain Troll brutish mountain giant, full body visible from head to feet, fully inside frame, side view facing right,
          huge muscular troll with stone-gray skin, heavy arms, crude face with tusks, messy hair, animal pelts and rags,
          holding a rough club or boulder, hunched savage stance, no cropped legs or feet, medieval fantasy, 2D RPG sprite, white background. */

        enemy.minDamage = 3;
        enemy.maxDamage = 5;
        enemy.damageModifier = 2;

        enemy.weaknesses.put(Enums.Elements.FIRE, 25);
        enemy.resistances.put(Enums.Elements.EARTH, 25);

        enemy.setVitalities(28, 8);
        enemy.setDefense(3);
        enemy.setAgility(6);
        enemy.setStrength(12);
        enemy.givenExperience = 12;
        enemy.givenGold = 1;
        enemy.levelToDynamicBalance = 7;
        enemy.givenLoot.add(new ItemReference(ItemsIds.ROCK, 1, 50));
        enemy.givenLoot.add(new ItemReference(ItemsIds.COPPER_HAMMER, 1, 3));

        return enemy;
    }
}
