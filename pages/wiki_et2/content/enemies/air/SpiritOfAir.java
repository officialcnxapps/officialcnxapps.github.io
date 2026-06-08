package com.cnx.endlesstalestwo.data.enemies.air;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class SpiritOfAir {

    public static Enemy get() {
        Enemy enemy = new Enemy("Spirit of Air");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Espírito de Ar");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Espiritu de Aire");

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Spirit of Air wind elemental, full figure visible from head to base, fully inside frame, side view facing right,
        // translucent swirling body made of clouds and gusts, pale blue ethereal form, hollow bright eyes, leaves and dust spiraling around it,
        // floating hovering posture, no cropped figure, air elemental medieval fantasy, 2D RPG sprite, white background.

        enemy.minDamage = 2;
        enemy.maxDamage = 4;
        enemy.damageModifier = 2;
        enemy.setVitalities(33, 30);
        enemy.setDefense(3);
        enemy.setAgility(24);
        enemy.setStrength(10);
        enemy.givenExperience = 15;
        enemy.levelToDynamicBalance = 7;

        enemy.weaknesses.put(Enums.Elements.EARTH, 50);
        enemy.resistances.put(Enums.Elements.WIND, 75);

        enemy.skills.put(SkillsIds.AIR_SPIKES, 42);
        enemy.skills.put(SkillsIds.CYCLONE, 37);

        enemy.givenLoot.add(new ItemReference(ItemsIds.MAGIC_ROD, 1, 38));
        enemy.givenLoot.add(new ItemReference(ItemsIds.SIMPLE_MP_POTION, 1, 72));

        return enemy;
    }
}

