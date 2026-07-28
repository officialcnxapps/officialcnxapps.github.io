package com.cnx.endlesstalestwo.data.enemies.bosses;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.enums.Enums;

public class CasielCorrupted {

    public static Enemy get() {
        Enemy enemy = new Enemy("Casiel Corrupted");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Casiel Corrompido");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Casiel Corrompido");

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
          Casiel Corrupted fallen elven archmage, full body visible from head to boots, fully inside frame, side view facing right,
          tall pale elf with long silver hair, glowing violet eyes, black corruption veins, torn noble green elven robes,
          one hand casting purple and sickly green magic, dark tendrils around body, no cropped legs or feet, medieval fantasy, 2D RPG sprite, white background. */

        enemy.givenExperience = 35;
        enemy.givenGold = 0;
        enemy.setVitalities(60, 75);
        enemy.setDefense(5);
        enemy.setAgility(17);
        enemy.setStrength(12);
        enemy.setMagic(24);
        enemy.minDamage = 4;
        enemy.maxDamage = 8;
        enemy.damageModifier = 2;
        enemy.levelToDynamicBalance = 20;
        enemy.attributesManager.set(Enums.AttributeName.CRITICAL_CHANCE, 9);

        enemy.resistances.put(Enums.Elements.DARK, 25);
        enemy.resistances.put(Enums.Elements.EARTH, 25);
        enemy.resistances.put(Enums.Elements.LIGHT, 25);

        enemy.skills.put(SkillsIds.EARTH_VINES, 35);
        enemy.skills.put(SkillsIds.DARK_MISSILE, 40);
        enemy.skills.put(SkillsIds.MAGIC_HEALING, 37);
        enemy.skills.put(SkillsIds.BARK_SKIN, 37);
        enemy.skills.put(SkillsIds.SHADOW_SCAM, 30);
        // No loot - battle is about stopping the ritual, not rewards

        return enemy;
    }
}
