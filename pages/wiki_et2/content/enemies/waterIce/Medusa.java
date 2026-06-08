package com.cnx.endlesstalestwo.data.enemies.waterIce;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class Medusa {

    /* IMAGE GENERATION PROMPT (Bing Image Creator):
     * Medusa mythical serpentine sea creature, full figure visible from head to tail, fully inside frame, side view facing right,
     * woman upper body with writhing snake hair, scaled lower serpent body, piercing glowing eyes, greenish skin with aquatic markings,
     * threatening coiled posture, no cropped figure, sea creature medieval fantasy, 2D RPG sprite, white background.
     */
    public static Enemy get() {
        Enemy enemy = new Enemy("Medusa");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Medusa");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Medusa");

        enemy.minDamage = 4;
        enemy.maxDamage = 7;
        enemy.damageModifier = 1;
        enemy.setVitalities(32, 50);
        enemy.setDefense(6);
        enemy.setAgility(17);
        enemy.setStrength(9);
        enemy.givenExperience = 18;
        enemy.givenGold = 6;
        enemy.levelToDynamicBalance = 14;

        enemy.resistances.put(Enums.Elements.WATER, 50);
        enemy.resistances.put(Enums.Elements.EARTH, 25);
        enemy.weaknesses.put(Enums.Elements.EARTH, 50);
        enemy.weaknesses.put(Enums.Elements.LIGHT, 25);

        enemy.skills.put(SkillsIds.WATER_STRIKE, 40);
        enemy.skills.put(SkillsIds.EARTH_VINES, 38);

        enemy.givenLoot.add(new ItemReference(ItemsIds.WATER, 1, 65));
        enemy.givenLoot.add(new ItemReference(ItemsIds.EMERALD_POWDER, 1, 20));

        return enemy;
    }
}

