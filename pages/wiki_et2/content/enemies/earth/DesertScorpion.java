package com.cnx.endlesstalestwo.data.enemies.earth;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class DesertScorpion {

    public static Enemy get() {
        Enemy enemy = new Enemy("Desert Scorpion");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escorpião do Deserto");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escorpión del Desierto");

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
          Desert Scorpion giant desert predator, side view facing right, large sand-yellow scorpion with dark brown plates,
          massive pincers raised, segmented tail curled high with black venom stinger, sharp legs digging into sand,
          fierce survival pose, arid medieval fantasy creature, 2D RPG sprite, white background. */

        enemy.minDamage = 2;
        enemy.maxDamage = 3;
        enemy.damageModifier = 1;

        enemy.weaknesses.put(Enums.Elements.WATER, 25);
        enemy.resistances.put(Enums.Elements.EARTH, 25);

        enemy.setVitalities(22, 6);
        enemy.setDefense(3);
        enemy.setAgility(8);
        enemy.setStrength(9);
        enemy.givenExperience = 8;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 5;
        enemy.skills.put(SkillsIds.POISON_STING, 35);
        enemy.givenLoot.add(new ItemReference(ItemsIds.YELLOW_HERB, 1, 20));
        enemy.givenLoot.add(new ItemReference(ItemsIds.ANTIDOTE, 1, 15));

        return enemy;
    }
}
