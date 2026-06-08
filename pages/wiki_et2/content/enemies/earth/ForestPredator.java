package com.cnx.endlesstalestwo.data.enemies.earth;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class ForestPredator {

    public static Enemy get() {
        Enemy enemy = new Enemy("Forest Predator");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Predador da Floresta");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Predador de la Floresta");

        enemy.minDamage = 2;
        enemy.maxDamage = 4;
        enemy.damageModifier = 1;

        enemy.weaknesses.put(Enums.Elements.FIRE, 50);

        enemy.resistances.put(Enums.Elements.EARTH, 50);
        enemy.resistances.put(Enums.Elements.WATER, 25);
        enemy.resistances.put(Enums.Elements.DARK, 25);

        enemy.setVitalities(25, 24);
        enemy.setDefense(2);
        enemy.setAgility(12);
        enemy.setStrength(9);
        enemy.givenExperience = 12;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 6;
        enemy.skills.put(SkillsIds.POISON_BITE, 45);
        enemy.givenLoot.add(new ItemReference(ItemsIds.BRANCH, 1, 37));
        enemy.givenLoot.add(new ItemReference(ItemsIds.GREEN_HERB, 1, 37));
        enemy.givenLoot.add(new ItemReference(ItemsIds.YELLOW_HERB, 1, 22));

        return enemy;
    }
}

