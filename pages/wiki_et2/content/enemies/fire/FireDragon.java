package com.cnx.endlesstalestwo.data.enemies.fire;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class FireDragon {
    public static Enemy get() {
        Enemy e = new Enemy("Fire Dragon");
        e.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Dragão de Fogo");
        e.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Dragón de Fuego");

        e.setVitalities(36, 60);
        e.setStrength(22);
        e.setMagic(15);
        e.setAgility(23);
        e.setDefense(5);
        e.attributesManager.set(Enums.AttributeName.CRITICAL_CHANCE, 8);
        e.levelToDynamicBalance = 16;

        e.minDamage = 3;
        e.maxDamage = 8;

        e.resistances.put(Enums.Elements.FIRE, 100);
        e.resistances.put(Enums.Elements.PHYSICAL, 25);
        e.weaknesses.put(Enums.Elements.WATER, 50);

        e.givenExperience = 22;
        e.givenLoot.add(new ItemReference(ItemsIds.DRAGON_SCALE, 1, 100));
        e.givenLoot.add(new ItemReference(ItemsIds.FIRE_BLOOD, 1, 100));
        e.givenLoot.add(new ItemReference(ItemsIds.RUBY, 1, 3));

        e.skills.put(SkillsIds.FIRE_TOUCH, 40);
        e.skills.put(SkillsIds.FIRE_BOMB, 25);

        return e;
    }
}
