package com.cnx.endlesstalestwo.data.enemies.dark;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class DarkCultist {

    public static Enemy get() {
        Enemy enemy = new Enemy("Dark Cultist");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cultista das Trevas");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cultista Oscuro");

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Human dark cultist in black hooded robes, side view facing right, long tattered black robe
        // with glowing red runic symbols, deep hood concealing face revealing only glowing red eyes,
        // holding curved ritual dagger with black blade, purple and red shadow energy aura around body,
        // threatening posture with hand raised channeling dark magic, demonic cult theme, 2D RPG sprite, white background.

        enemy.givenExperience = 28;
        enemy.givenGold = 10;
        enemy.setVitalities(55, 75);
        enemy.setDefense(4);
        enemy.setAgility(18);
        enemy.setStrength(15);
        enemy.minDamage = 5;
        enemy.maxDamage = 9;
        enemy.damageModifier = 3;

        enemy.resistances.put(Enums.Elements.DARK, 50);
        enemy.weaknesses.put(Enums.Elements.LIGHT, 25);

        enemy.levelToDynamicBalance = 15;
        enemy.skills.put(SkillsIds.DARK_MISSILE, 42);
        enemy.skills.put(SkillsIds.OBSCURE_AID, 25);

        enemy.givenLoot.add(new ItemReference(ItemsIds.DARK_BLOOD, 1, 100));
        enemy.givenLoot.add(new ItemReference(ItemsIds.DARK_MUSHROOM, 1, 40));
        enemy.givenLoot.add(new ItemReference(ItemsIds.MP_POTION, 1, 30));

        return enemy;
    }
}

