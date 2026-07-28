package com.cnx.endlesstalestwo.data.enemies.waterIce;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class IceDragon {
    public static Enemy get() {
        Enemy e = new Enemy("Ice Dragon");
        e.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Dragão de Gelo");
        e.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Dragón de Hielo");

        e.setVitalities(30, 52);
        e.setStrength(18);
        e.setMagic(14);
        e.setAgility(18);
        e.setDefense(4);
        e.levelToDynamicBalance = 14;

        e.minDamage = 3;
        e.maxDamage = 6;

        e.resistances.put(Enums.Elements.WATER, 100);
        e.resistances.put(Enums.Elements.PHYSICAL, 25);
        e.weaknesses.put(Enums.Elements.FIRE, 50);

        e.givenExperience = 17;
        e.givenLoot.add(new ItemReference(ItemsIds.DRAGON_SCALE, 1, 100));
        e.givenLoot.add(new ItemReference(ItemsIds.ICE_BLOOD, 1, 100));
        e.givenLoot.add(new ItemReference(ItemsIds.SAPPHIRE, 1, 3));

        e.skills.put(SkillsIds.ICE_RAY, 45);
        e.skills.put(SkillsIds.MAGIC_HEALING, 25);

        return e;
    }
}
