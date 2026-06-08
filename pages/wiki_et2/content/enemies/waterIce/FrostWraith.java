package com.cnx.endlesstalestwo.data.enemies.waterIce;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class FrostWraith {

    public static Enemy get() {
        Enemy enemy = new Enemy("Frost Wraith");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aparição Gélida");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Espectro Helado");

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
          Frost Wraith frozen spectral spirit, full figure visible from head to trailing robes, fully inside frame, side view facing right,
          floating ghostly body made of icy mist, pale blue translucent form, hollow glowing eyes, long clawed hands of frost,
          torn frozen robes, snowflakes and cold vapor around body, no cropped lower figure, medieval fantasy undead, 2D RPG sprite, white background. */

        enemy.minDamage = 2;
        enemy.maxDamage = 4;
        enemy.damageModifier = 2;

        enemy.weaknesses.put(Enums.Elements.FIRE, 50);
        enemy.resistances.put(Enums.Elements.WATER, 50);
        enemy.resistances.put(Enums.Elements.WIND, 25);
        enemy.resistances.put(Enums.Elements.PHYSICAL, 25);

        enemy.setVitalities(26, 12);
        enemy.setDefense(1);
        enemy.setAgility(13);
        enemy.setStrength(7);
        enemy.givenExperience = 10;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 8;
        enemy.skills.put(SkillsIds.ICE_RAY, 40);
        enemy.givenLoot.add(new ItemReference(ItemsIds.SAPPHIRE, 1, 8));
        enemy.givenLoot.add(new ItemReference(ItemsIds.WHITE_MUSHROOM, 1, 25));

        return enemy;
    }
}
