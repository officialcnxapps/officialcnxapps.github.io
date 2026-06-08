package com.cnx.endlesstalestwo.data.enemies.humanoids;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.enums.Enums;

public class PirateGhost {

    public static Enemy get() {
        Enemy enemy = new Enemy("Pirate Ghost");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pirata Fantasma");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pirata Fantasma");

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
          Pirate Ghost undead spectral corsair, full body visible from hat to boots, fully inside frame, side view facing right,
          translucent pirate with torn tricorn hat, ghostly blue-green glow, skeletal face, ragged coat, cursed cutlass in hand,
          mist and seawater aura around body, no cropped legs or feet, haunted medieval fantasy seafarer, 2D RPG sprite, white background. */

        enemy.minDamage = 3;
        enemy.maxDamage = 4;
        enemy.damageModifier = 2;

        enemy.element = Enums.Elements.DARK;

        enemy.weaknesses.put(Enums.Elements.LIGHT, 50);
        enemy.weaknesses.put(Enums.Elements.WIND, 25);
        enemy.resistances.put(Enums.Elements.DARK, 50);
        enemy.resistances.put(Enums.Elements.PHYSICAL, 50);
        enemy.resistances.put(Enums.Elements.EARTH, 25);

        enemy.setVitalities(30, 0);
        enemy.setDefense(3);
        enemy.setAgility(15);
        enemy.setStrength(11);

        enemy.givenExperience = 12;
        enemy.givenGold = 3;
        enemy.levelToDynamicBalance = 8;

        // No regular loot - only special drops via event

        return enemy;
    }
}
