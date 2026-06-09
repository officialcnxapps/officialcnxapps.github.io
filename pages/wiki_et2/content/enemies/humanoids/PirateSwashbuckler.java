package com.cnx.endlesstalestwo.data.enemies.humanoids;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class PirateSwashbuckler {

    public static Enemy get() {
        Enemy enemy = new Enemy("Swashbuckler Pirate");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pirata Espadachim");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pirata Espadachín");

        enemy.minDamage = 2;
        enemy.maxDamage = 3;
        enemy.damageModifier = 3;
        enemy.setVitalities(22, 10);
        enemy.setDefense(2);
        enemy.setAgility(12);
        enemy.setStrength(9);
        enemy.givenExperience = 7;
        enemy.givenGold = 5;
        enemy.levelToDynamicBalance = 6;
        enemy.skills.put(SkillsIds.HARD_HIT, 32);
        enemy.givenLoot.add(new ItemReference(ItemsIds.IRON_SWORD, 1, 7));

        return enemy;
    }
}

