package com.cnx.endlesstalestwo.data.enemies.light;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class CorruptedWizard {

    public static Enemy get() {
        Enemy enemy = new Enemy("Corrupted Wizard");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mago Corrompido");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mago Corrompido");

        /* IMAGE GENERATION PROMPT (Bing Image Creator):
         * Corrupted Wizard corrupted light sorcerer, full body visible from hood to boots, fully inside frame, side view facing right,
         * hooded robes torn and crackling with unstable golden light energy, arcane runes glowing across body, staff with chaotic aura,
         * pale corrupted skin, unsettling gaze, no cropped legs or feet, corrupted mage medieval fantasy, 2D RPG sprite, white background.
         */

        enemy.minDamage = 2;
        enemy.maxDamage = 5;
        enemy.damageModifier = 2;

        enemy.weaknesses.put(Enums.Elements.DARK, 25);
        enemy.resistances.put(Enums.Elements.LIGHT, 50);
        enemy.resistances.put(Enums.Elements.FIRE, 25);

        enemy.setVitalities(27, 58);
        enemy.setDefense(4);
        enemy.setAgility(12);
        enemy.setStrength(6);
        enemy.setMagic(20);
        enemy.givenExperience = 16;
        enemy.givenGold = 3;
        enemy.levelToDynamicBalance = 8;

        enemy.skills.put(SkillsIds.MYSTICAL_STUN, 47);
        enemy.skills.put(SkillsIds.THUNDER_RAY, 47);

        enemy.givenLoot.add(new ItemReference(ItemsIds.CAPE_OF_FORTITUDE, 1, 1));
        enemy.givenLoot.add(new ItemReference(ItemsIds.HEAVY_ROBE, 1, 20));
        enemy.givenLoot.add(new ItemReference(ItemsIds.SIMPLE_HP_POTION, 1, 50));

        return enemy;
    }
}
