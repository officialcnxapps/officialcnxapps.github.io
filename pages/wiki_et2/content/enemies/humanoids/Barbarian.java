package com.cnx.endlesstalestwo.data.enemies.humanoids;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class Barbarian {

    public static Enemy get() {
        Enemy enemy = new Enemy("Barbarian");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Bárbaro");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bárbaro");

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
          Barbarian rugged northern warrior, full body visible from head to boots, fully inside frame, side view facing right,
          muscular human with long messy hair and beard, fur cloak over leather armor, tribal ornaments, heavy mace in hand,
          battle scars, aggressive raider stance, no cropped legs or feet, cold medieval fantasy style, 2D RPG sprite, white background. */

        enemy.minDamage = 2;
        enemy.maxDamage = 3;
        enemy.damageModifier = 2;
        enemy.setVitalities(22, 25);
        enemy.setDefense(3);
        enemy.setAgility(16);
        enemy.setStrength(10);
        enemy.givenExperience = 8;
        enemy.givenGold = 1;
        enemy.levelToDynamicBalance = 6;
        enemy.skills.put(SkillsIds.WEAK_SPOT, 42);
        enemy.givenLoot.add(new ItemReference(ItemsIds.HEAVY_MACE, 1, 1));
        enemy.givenLoot.add(new ItemReference(ItemsIds.COOKED_MEAT, 1, 21));

        return enemy;
    }
}
