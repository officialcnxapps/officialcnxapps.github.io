package com.cnx.endlesstalestwo.data.enemies.humanoids;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class TormentPirate {

    /* IMAGE GENERATION PROMPT (Bing Image Creator):
     * Torment Pirate weathered sea warrior, full body visible from head to boots, fully inside frame, side view facing right,
     * human in tattered sea-worn leather armor, dark bandana and rough beard, curved cutlass in hand, rope belt and worn boots,
     * battle-ready aggressive stance, no cropped legs or feet, dark seas medieval fantasy, 2D RPG sprite, white background.
     */
    public static Enemy get() {
        Enemy enemy = new Enemy("Torment Pirate");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pirata da Tormenta");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pirata de la Tormenta");

        enemy.minDamage = 2;
        enemy.maxDamage = 4;
        enemy.damageModifier = 1;
        enemy.setVitalities(27, 35);
        enemy.setDefense(4);
        enemy.setAgility(15);
        enemy.setMagic(12);
        enemy.setStrength(9);
        enemy.givenExperience = 13;
        enemy.givenGold = 3;
        enemy.levelToDynamicBalance = 8;

        enemy.resistances.put(Enums.Elements.WATER, 50);
        enemy.resistances.put(Enums.Elements.WIND, 25);
        enemy.weaknesses.put(Enums.Elements.EARTH, 50);
        enemy.weaknesses.put(Enums.Elements.LIGHT, 25);

        enemy.skills.put(SkillsIds.WATER_STRIKE, 40);
        enemy.skills.put(SkillsIds.FROZEN_SHIELD, 38);

        enemy.givenLoot.add(new ItemReference(ItemsIds.ALGAE, 1, 37));
        enemy.givenLoot.add(new ItemReference(ItemsIds.BEER, 1, 47));
        enemy.givenLoot.add(new ItemReference(ItemsIds.WINE, 1, 35));
        enemy.givenLoot.add(new ItemReference(ItemsIds.MEAD_POTION, 1, 57));
        enemy.givenLoot.add(new ItemReference(ItemsIds.TUNA, 1, 35));

        return enemy;
    }
}

