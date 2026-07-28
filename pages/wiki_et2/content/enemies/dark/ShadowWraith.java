package com.cnx.endlesstalestwo.data.enemies.dark;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class ShadowWraith {

    public static Enemy get() {
        Enemy enemy = new Enemy("Shadow Wraith");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Espectro das Sombras");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Espectro Sombra");

        enemy.givenExperience = 16;
        enemy.givenGold = 0;
        enemy.setVitalities(38, 30);
        enemy.setDefense(2);
        enemy.setAgility(18);
        enemy.setStrength(11);
        enemy.setMagic(12);
        enemy.minDamage = 3;
        enemy.maxDamage = 6;
        enemy.damageModifier = 2;
        enemy.levelToDynamicBalance = 9;
        enemy.skills.put(SkillsIds.DARK_MISSILE, 38);
        enemy.givenLoot.add(new ItemReference(ItemsIds.DARK_MUSHROOM, 1, 42));
        enemy.givenLoot.add(new ItemReference(ItemsIds.ELIXIR_POTION, 1, 46));
        enemy.givenLoot.add(new ItemReference(ItemsIds.HP_POTION, 1, 62));

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Ghostly ethereal shadow wraith, side view facing right, semi-transparent humanoid made of dark shadows and mist,
        // flowing wispy form, hollow glowing white or pale blue eyes piercing darkness, body dissipating at edges like smoke,
        // tattered wisps of shadow trailing behind like cloak, absorbing light around it, supernatural lighting,
        // dark medieval fantasy atmosphere, 2D RPG sprite, white background.

        return enemy;
    }
}

