package com.cnx.endlesstalestwo.data.enemies.humanoids;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class MalignantElf {

    public static Enemy get() {
        Enemy enemy = new Enemy("Malignant Elf");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Elfo Maligno");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Elfo Maligno");

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Professional army guard soldier, side view facing right, human warrior in metal armor,
        // steel helmet with face protection, chainmail and plate armor covering torso, red and blue
        // kingdom colors on surcoat, armed with iron sword and wooden shield with kingdom emblem,
        // disciplined military stance, vigilant expression, medieval fantasy kingdom guard theme,
        // well-trained soldier protecting city and resources, 2D RPG sprite, white background.

        enemy.minDamage = 2;
        enemy.maxDamage = 3;
        enemy.damageModifier = 3;
        enemy.setVitalities(23, 25);
        enemy.setDefense(3);
        enemy.setAgility(16);
        enemy.setStrength(10);
        enemy.givenExperience = 9;
        enemy.givenGold = 1;
        enemy.levelToDynamicBalance = 7;
        enemy.skills.put(SkillsIds.ARROW_RAIN, 42);
        enemy.givenLoot.add(new ItemReference(ItemsIds.LONG_OAK_BOW, 1, 3));
        enemy.givenLoot.add(new ItemReference(ItemsIds.POMEGRANATE, 1, 21));
        enemy.givenLoot.add(new ItemReference(ItemsIds.SIMPLE_MP_POTION, 1, 23));

        return enemy;
    }
}

