package com.cnx.endlesstalestwo.data.enemies.fire;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class SpiritOfFire {

    public static Enemy get() {
        Enemy enemy = new Enemy("Spirit of Fire");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Espírito do Fogo");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Espirito de Fuego");

        enemy.givenExperience = 15;
        enemy.givenGold = 0;
        enemy.setVitalities(28, 120);
        enemy.setDefense(6);
        enemy.setAgility(20);
        enemy.setStrength(12);

        enemy.resistances.put(Enums.Elements.FIRE, 100);
        enemy.resistances.put(Enums.Elements.PHYSICAL, 25);

        enemy.weaknesses.put(Enums.Elements.WATER, 50);
        enemy.weaknesses.put(Enums.Elements.EARTH, 25);

        enemy.minDamage = 2;
        enemy.maxDamage = 5;
        enemy.damageModifier = 1;
        enemy.levelToDynamicBalance = 10;

        enemy.skills.put(SkillsIds.FIRE_TOUCH, 48);
        enemy.skills.put(SkillsIds.FIRE_BOMB, 50);
        enemy.skills.put(SkillsIds.FIRE_RAIN, 35);
        enemy.skills.put(SkillsIds.FIRE_TORMENT, 25);

        enemy.givenLoot.add(new ItemReference(ItemsIds.FIRE_SWORD, 1, 2));
        enemy.givenLoot.add(new ItemReference(ItemsIds.RUBY, 1, 6));
        enemy.givenLoot.add(new ItemReference(ItemsIds.HP_POTION, 1, 26));
        enemy.givenLoot.add(new ItemReference(ItemsIds.ASH, 1, 75));

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Spirit of Fire blazing fire elemental, full figure visible from head to base, fully inside frame, side view facing right,
        // transparent flaming body with intense glowing core, deep crimson and blazing orange flames, hollow burning eyes, embers floating around,
        // hovering aggressive posture, no cropped figure, fire elemental medieval fantasy, 2D RPG sprite, white background.

        return enemy;
    }
}

