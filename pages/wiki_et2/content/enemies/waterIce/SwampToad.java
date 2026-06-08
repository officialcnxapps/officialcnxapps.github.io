package com.cnx.endlesstalestwo.data.enemies.waterIce;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class SwampToad {

    public static Enemy get() {
        Enemy enemy = new Enemy("Swamp Toad");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sapo do Pântano");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sapo del Pantano");

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Giant venomous swamp toad, side view facing right, bloated body, dark green warty skin,
        // purple-yellow poison spots, large bulging yellow-green eyes, wide mouth with tongue visible,
        // webbed toes, grotesque appearance, medieval fantasy swamp, crouched ready to leap, 2D RPG sprite, white background.

        enemy.minDamage = 1;
        enemy.maxDamage = 2;
        enemy.damageModifier = 1;
        enemy.weaknesses.put(Enums.Elements.FIRE, 25);
        enemy.resistances.put(Enums.Elements.WATER, 50);
        enemy.setVitalities(17, 4);
        enemy.setDefense(2);
        enemy.setAgility(6);
        enemy.setStrength(7);
        enemy.givenExperience = 5;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 4;
        enemy.skills.put(SkillsIds.POISON_BITE, 30);
        enemy.givenLoot.add(new ItemReference(ItemsIds.ALGAE, 1, 40));
        enemy.givenLoot.add(new ItemReference(ItemsIds.GREEN_HERB, 1, 35));

        return enemy;
    }
}

