package com.cnx.endlesstalestwo.data.enemies.humanoids;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class ArmyGuard {

    public static Enemy get() {
        Enemy enemy = new Enemy("Army Guard");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Guarda do Exército");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Guardia del Ejército");

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
          Army Guard disciplined kingdom soldier, full body visible from helmet to boots, fully inside frame, side view facing right,
          human warrior in chainmail and plate armor, red and blue surcoat, iron sword in one hand and sturdy shield in the other,
          ready combat stance, no cropped legs or feet, loyal medieval fantasy military guard, 2D RPG sprite, white background. */

        enemy.minDamage = 2;
        enemy.maxDamage = 3;
        enemy.damageModifier = 3;
        enemy.setVitalities(22, 16);
        enemy.setDefense(3);
        enemy.setAgility(11);
        enemy.setStrength(10);
        enemy.givenExperience = 8;
        enemy.givenGold = 2;
        enemy.levelToDynamicBalance = 5;
        enemy.skills.put(SkillsIds.HARD_HIT, 38);
        enemy.givenLoot.add(new ItemReference(ItemsIds.IRON_SWORD, 1, 6));
        enemy.givenLoot.add(new ItemReference(ItemsIds.BREAD, 1, 32));

        return enemy;
    }
}
