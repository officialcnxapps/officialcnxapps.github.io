package com.cnx.endlesstalestwo.data.enemies.orcs;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class OrcBattler {

    public static Enemy get() {
        Enemy enemy = new Enemy("Orc Battler");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Orc Guerreiro");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Orc Guerrero");

        enemy.minDamage = 2;
        enemy.maxDamage = 4;
        enemy.damageModifier = 1;
        enemy.weaknesses.put(Enums.Elements.FIRE, 25);
        enemy.resistances.put(Enums.Elements.EARTH, 25);
        enemy.setVitalities(16, 4);
        enemy.setDefense(2);
        enemy.setAgility(8);
        enemy.setStrength(9);
        enemy.givenExperience = 8;
        enemy.givenGold = 2;
        enemy.levelToDynamicBalance = 5;
        enemy.givenLoot.add(new ItemReference(ItemsIds.ORC_TOOTH, 1, 65));
        enemy.givenLoot.add(new ItemReference(ItemsIds.WOODEN_SPEAR, 1, 35));

        return enemy;
    }
}

