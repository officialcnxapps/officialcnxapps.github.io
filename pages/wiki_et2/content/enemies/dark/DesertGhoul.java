package com.cnx.endlesstalestwo.data.enemies.dark;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class DesertGhoul {

    public static Enemy get() {
        Enemy enemy = new Enemy("Desert Ghoul");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Carniçal do Deserto");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Necrófago del Desierto");

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Undead desert ghoul, side view facing right, skeletal humanoid with mummified skin,
        // tattered rags and clinging sand, glowing green eyes, long sharp claws, ancient bandages,
        // rusty chains, black sand aura, hunched predatory posture, medieval fantasy, 2D RPG sprite, white background.

        enemy.givenExperience = 24;
        enemy.givenGold = 5;

        enemy.setVitalities(48, 58);
        enemy.setDefense(3);
        enemy.setAgility(10);
        enemy.setStrength(17);
        enemy.minDamage = 4;
        enemy.maxDamage = 7;
        enemy.damageModifier = 2;
        enemy.levelToDynamicBalance = 10;
        enemy.skills.put(SkillsIds.WEAK_SPOT, 42);

        enemy.givenLoot.add(new ItemReference(ItemsIds.DARK_MUSHROOM, 1, 35));
        enemy.givenLoot.add(new ItemReference(ItemsIds.BROWN_MUSHROOM, 1, 45));
        enemy.givenLoot.add(new ItemReference(ItemsIds.RAW_MEAT, 1, 48));

        return enemy;
    }
}

