package com.cnx.endlesstalestwo.data.enemies.bosses;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class DragonKing {
    public static Enemy get() {
        Enemy e = new Enemy("Dragon King");
        e.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Rei Dragão");
        e.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Rey Dragón");

        e.setVitalities(70, 110);
        e.setStrength(28);
        e.setMagic(20);
        e.setAgility(28);
        e.setDefense(7);

        e.minDamage = 6;
        e.maxDamage = 11;
        e.attributesManager.set(Enums.AttributeName.CRITICAL_CHANCE, 16);
        e.levelToDynamicBalance = 23;

        e.resistances.put(Enums.Elements.FIRE, 50);
        e.resistances.put(Enums.Elements.WATER, 25);
        e.resistances.put(Enums.Elements.EARTH, 25);
        e.resistances.put(Enums.Elements.WIND, 25);
        e.resistances.put(Enums.Elements.DARK, 25);

        e.givenExperience = 35;
        e.givenGold = 9;
        e.givenLoot.add(new ItemReference(ItemsIds.DRAGON_SCALE, 1, 100));
        e.givenLoot.add(new ItemReference(ItemsIds.RUBY, 1, 40));
        e.givenLoot.add(new ItemReference(ItemsIds.ASH, 2, 45));
        e.givenLoot.add(new ItemReference(ItemsIds.COAL, 1, 60));

        e.skills.put(SkillsIds.FIRE_BOMB, 47);
        e.skills.put(SkillsIds.ICE_RAY, 36);
        e.skills.put(SkillsIds.AVALANCHE, 44);

        return e;
    }
}
