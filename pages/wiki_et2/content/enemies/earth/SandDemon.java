package com.cnx.endlesstalestwo.data.enemies.earth;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class SandDemon {

    public static Enemy get() {
        Enemy enemy = new Enemy("Sand Demon");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Demônio da Areia");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Demonio de Arena");

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Sand demon from desert depths, side view facing right, muscular humanoid body made of compacted sand
        // and black volcanic rock, cracked skin revealing glowing red-orange energy inside like magma, curved
        // obsidian horns, burning red eyes, sharp black stone claws, small sand storms swirling around,
        // intimidating supernatural appearance, dark medieval fantasy desert darkness theme, attack pose, 2D RPG sprite, white background.

        enemy.givenExperience = 16;
        enemy.givenGold = 3;
        enemy.setVitalities(26, 45);
        enemy.setDefense(2);
        enemy.setAgility(15);
        enemy.setStrength(12);

        enemy.resistances.put(Enums.Elements.EARTH, 75);
        enemy.resistances.put(Enums.Elements.FIRE, 25);

        enemy.weaknesses.put(Enums.Elements.WIND, 25);
        enemy.weaknesses.put(Enums.Elements.WATER, 25);

        enemy.minDamage = 3;
        enemy.maxDamage = 6;
        enemy.damageModifier = 2;
        enemy.levelToDynamicBalance = 13;

        enemy.skills.put(SkillsIds.QUICKSAND, 38);
        enemy.skills.put(SkillsIds.EARTH_VINES, 38);

        enemy.givenLoot.add(new ItemReference(ItemsIds.SAPPHIRE, 1, 38));

        return enemy;
    }
}

