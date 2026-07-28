package com.cnx.endlesstalestwo.data.enemies.bosses;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class CasielDeathKing {

    public static Enemy get() {
        Enemy enemy = new Enemy("Casiel Death King");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Casiel Rei da Morte");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Casiel Rey de la Muerte");

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
          Casiel Death King supreme undead elf ruler, full body visible from crown to boots, fully inside frame, side view facing right,
          floating tall pale elf with long silver hair, glowing white-violet eyes, black crown of thorns, dark royal robes,
          skeletal magic aura, shadow wings made of souls, one hand commanding purple death energy, no cropped legs or feet, dark medieval fantasy boss, 2D RPG sprite, white background. */

        // 25% stronger than Targon
        enemy.givenExperience = 60;
        enemy.givenGold = 20;
        enemy.setVitalities(90, 150);
        enemy.setDefense(9);
        enemy.setAgility(25);
        enemy.setStrength(23);
        enemy.minDamage = 7;
        enemy.maxDamage = 11;
        enemy.damageModifier = 5;
        enemy.levelToDynamicBalance = 25;
        enemy.attributesManager.set(Enums.AttributeName.CRITICAL_CHANCE, 14);

        // Resistances fitting Death King
        enemy.resistances.put(Enums.Elements.DARK, 50);
        enemy.resistances.put(Enums.Elements.EARTH, 25);
        enemy.weaknesses.put(Enums.Elements.LIGHT, 25);

        // Powerful skills befitting Death King
        enemy.skills.put(SkillsIds.DEATH_PORTAL, 42);
        enemy.skills.put(SkillsIds.GOD_OF_CHAOS, 35);
        enemy.skills.put(SkillsIds.OBSCURE_AID, 38);
        enemy.skills.put(SkillsIds.FIRE_TORMENT, 40);

        // Epic final boss loot
        enemy.givenLoot.add(new ItemReference(ItemsIds.GOLDEN_BOOTS, 1, 60));
        enemy.givenLoot.add(new ItemReference(ItemsIds.WAND_OF_FORTITUDE, 1, 67));
        enemy.givenLoot.add(new ItemReference(ItemsIds.ELIXIR_POTION, 2, 75));

        return enemy;
    }
}
