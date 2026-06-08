package com.cnx.endlesstalestwo.data.enemies.orcs;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class OrcPeasant {

    public static Enemy get() {
        Enemy enemy = new Enemy("Peasant Orc");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Orc Aldeão");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Orc Campesino");

        enemy.minDamage = 0;
        enemy.maxDamage = 2;
        enemy.damageModifier = 1;
        enemy.weaknesses.put(Enums.Elements.FIRE, 25);
        enemy.resistances.put(Enums.Elements.EARTH, 25);
        enemy.setVitalities(11, 4);
        enemy.setDefense(0);
        enemy.setAgility(6);
        enemy.setStrength(6);
        enemy.givenExperience = 4;
        enemy.givenGold = 1;
        enemy.levelToDynamicBalance = 3;
        enemy.givenLoot.add(new ItemReference(ItemsIds.ORC_TOOTH, 1, 60));

        return enemy;
    }
}

