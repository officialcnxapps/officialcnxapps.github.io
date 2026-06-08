package com.cnx.endlesstalestwo.data.enemies.fire;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class InfernalHound {

    public static Enemy get() {
        Enemy enemy = new Enemy("Infernal Hound");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cão Infernal");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sabueso Infernal");

        enemy.givenExperience = 20;
        enemy.givenGold = 6;
        enemy.setVitalities(30, 24);
        enemy.setDefense(2);
        enemy.setAgility(20);
        enemy.setStrength(12);

        enemy.resistances.put(Enums.Elements.FIRE, 50);
        enemy.resistances.put(Enums.Elements.DARK, 25);

        enemy.weaknesses.put(Enums.Elements.WATER, 50);
        enemy.weaknesses.put(Enums.Elements.LIGHT, 25);

        enemy.minDamage = 4;
        enemy.maxDamage = 6;
        enemy.damageModifier = 2;
        enemy.levelToDynamicBalance = 10;

        enemy.skills.put(SkillsIds.HARD_HIT, 50);
        enemy.skills.put(SkillsIds.FIRE_RAIN, 35);

        enemy.givenLoot.add(new ItemReference(ItemsIds.LEATHER, 1, 51));
        enemy.givenLoot.add(new ItemReference(ItemsIds.ASH, 1, 65));

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Infernal Hound demonic canine, side view facing right, massive beast wreathed in flames and hellfire,
        // muscular animalistic body covered in scales and burning fur, charred and cracked skin with molten lava
        // glowing from cracks, flames dancing across body in orange red and blue fire, horns or jagged bone protrusions,
        // eyes glowing like burning coals, smoke and embers trailing from mouth and nostrils, demonic aggressive expression,
        // hellish atmosphere fire and brimstone theme, standing on rocky terrain with heat distortion, 2D RPG sprite, white background.

        return enemy;
    }
}

