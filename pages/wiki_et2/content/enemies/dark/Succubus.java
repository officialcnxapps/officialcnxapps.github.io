package com.cnx.endlesstalestwo.data.enemies.dark;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class Succubus {

    public static Enemy get() {
        Enemy enemy = new Enemy("Succubus");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Súcubo");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Súcubo");


        enemy.givenExperience = 18;
        enemy.givenGold = 4;
        enemy.setVitalities(32, 58);
        enemy.setDefense(3);
        enemy.setAgility(20);
        enemy.setStrength(12);
        enemy.minDamage = 3;
        enemy.maxDamage = 5;
        enemy.damageModifier = 2;
        enemy.levelToDynamicBalance = 9;

        enemy.weaknesses.put(Enums.Elements.LIGHT, 25);
        enemy.resistances.put(Enums.Elements.DARK, 25);
        enemy.resistances.put(Enums.Elements.FIRE, 25);

        enemy.skills.put(SkillsIds.DISABLE, 30);
        enemy.skills.put(SkillsIds.DARK_MISSILE, 32);

        enemy.givenLoot.add(new ItemReference(ItemsIds.LEATHER_BOOTS, 1, 22));
        enemy.givenLoot.add(new ItemReference(ItemsIds.HP_POTION, 1, 20));
        enemy.givenLoot.add(new ItemReference(ItemsIds.WINE, 1, 48));

        return enemy;
    }
}

