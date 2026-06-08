package com.cnx.endlesstalestwo.data.enemies.dark;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class DarkSpecter {

    public static Enemy get() {
        Enemy enemy = new Enemy("Dark Specter");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Espectro Sombrio");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Espectro Oscuro");

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Dark Specter powerful humanoid, side view facing right, tall imposing form partially solid partially ethereal,
        // body wreathed in billowing shadows and dark magic, ragged remnants of ancient armor or robes floating and swirling,
        // skull-like face obscured by shadow with piercing eyes burning dark purple or crimson light, arcane runes and dark
        // energy spiraling around body, air crackling with malevolent power, powerful boss-like presence commanding pose,
        // dark medieval fantasy sorcery theme, 2D RPG sprite, white background.

        enemy.givenExperience = 35;
        enemy.givenGold = 6;
        enemy.setVitalities(38, 58);
        enemy.setDefense(2);
        enemy.setAgility(18);
        enemy.setStrength(12);
        enemy.minDamage = 4;
        enemy.maxDamage = 7;
        enemy.damageModifier = 2;
        enemy.levelToDynamicBalance = 12;

        enemy.resistances.put(Enums.Elements.DARK, 50);
        enemy.weaknesses.put(Enums.Elements.LIGHT, 25);

        enemy.skills.put(SkillsIds.OBSCURE_AID, 42);
        enemy.skills.put(SkillsIds.SURPRISE_STRIKE, 50);
        enemy.givenLoot.add(new ItemReference(ItemsIds.DARKNESS_AMULET, 1, 42));

        return enemy;
    }
}

