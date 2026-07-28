package com.cnx.endlesstalestwo.data.enemies.earth;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class Wyvern {
    public static Enemy get() {
        Enemy e = new Enemy("Wyvern");
        e.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Wyvern");
        e.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Wyvern");

        e.setVitalities(32, 60);
        e.setStrength(18);
        e.setMagic(16);
        e.setAgility(22);
        e.setDefense(5);
        e.attributesManager.set(Enums.AttributeName.CRITICAL_CHANCE, 9);
        e.levelToDynamicBalance = 15;

        e.minDamage = 3;
        e.maxDamage = 7;

        e.resistances.put(Enums.Elements.EARTH, 75);
        e.resistances.put(Enums.Elements.WIND, 25);
        e.weaknesses.put(Enums.Elements.LIGHT, 25);

        e.givenExperience = 20;
        e.givenLoot.add(new ItemReference(ItemsIds.DRAGON_SCALE, 1, 100));
        e.givenLoot.add(new ItemReference(ItemsIds.ACID_BLOOD, 1, 100));
        e.givenLoot.add(new ItemReference(ItemsIds.EMERALD, 1, 3));

        e.skills.put(SkillsIds.POISONOUS_RAIN, 40);
        e.skills.put(SkillsIds.ROCK_RAIN, 40);

        return e;
    }
}
