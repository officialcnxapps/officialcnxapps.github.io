package com.cnx.endlesstalestwo.data.enemies.bosses;

import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class Targon {

    public static Enemy get() {
        Enemy enemy = new Enemy("Targon");

        /* IMAGE GENERATION PROMPT (Bing Image Creator):
         powerful demon from underworld, side view facing right, imposing humanoid
         demon 3 meters tall, dark red skin with black veins, large semi-open draconic black wings,
         single glowing red horn projecting from forehead, completely black eyes,
         aura of purple and black flames around, dominant threatening posture,
         dark medieval fantasy, 2D RPG sprite, white background. */

        enemy.givenExperience = 50;
        enemy.givenGold = 0;
        enemy.setVitalities(70, 70);
        enemy.setDefense(4);
        enemy.setAgility(20);
        enemy.setStrength(18);
        enemy.minDamage = 5;
        enemy.maxDamage = 9;
        enemy.damageModifier = 3;
        enemy.levelToDynamicBalance = 25;
        enemy.attributesManager.set(Enums.AttributeName.CRITICAL_CHANCE, 11);

        enemy.resistances.put(Enums.Elements.FIRE, 25);
        enemy.resistances.put(Enums.Elements.DARK, 75);
        enemy.weaknesses.put(Enums.Elements.LIGHT, 25);
        enemy.resistances.put(Enums.Elements.WATER, 25);

        enemy.skills.put(SkillsIds.FIRE_TORMENT, 35);
        enemy.skills.put(SkillsIds.DEATH_PORTAL, 16);
        enemy.skills.put(SkillsIds.OBSCURE_AID, 30);
        enemy.skills.put(SkillsIds.GOD_OF_CHAOS, 15);

        enemy.givenLoot.add(new ItemReference(ItemsIds.DARKNESS_SHIELD, 1, 40));
        enemy.givenLoot.add(new ItemReference(ItemsIds.CALTRANIUM_INGOT, 1, 90));
        enemy.givenLoot.add(new ItemReference(ItemsIds.SPECIAL_HP_POTION, 1, 52));
        enemy.givenLoot.add(new ItemReference(ItemsIds.ELIXIR_POTION, 1, 60));
        enemy.givenLoot.add(new ItemReference(ItemsIds.GOLD_ORE, 1, 65));
        enemy.givenLoot.add(new ItemReference(ItemsIds.RING_OF_POWER, 1, 48));

        return enemy;
    }
}

