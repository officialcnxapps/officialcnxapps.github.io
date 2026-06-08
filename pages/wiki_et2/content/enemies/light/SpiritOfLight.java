package com.cnx.endlesstalestwo.data.enemies.light;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class SpiritOfLight {

    public static Enemy get() {
        Enemy enemy = new Enemy("Spirit of Light");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Espírito de Luz");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Espiritu de Luz");

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Spirit of Light radiant holy spirit, full figure visible from head to base, fully inside frame, side view facing right,
        // translucent glowing angelic form, brilliant white and warm golden aura, hollow bright divine eyes, light rays emanating from body,
        // floating serene yet powerful posture, no cropped figure, holy light spirit medieval fantasy, 2D RPG sprite, white background.

        enemy.minDamage = 1;
        enemy.maxDamage = 4;
        enemy.damageModifier = 2;
        enemy.setVitalities(33, 85);
        enemy.setDefense(4);
        enemy.setAgility(24);
        enemy.setStrength(8);
        enemy.givenExperience = 15;
        enemy.levelToDynamicBalance = 7;

        enemy.weaknesses.put(Enums.Elements.DARK, 25);
        enemy.resistances.put(Enums.Elements.LIGHT, 50);

        enemy.skills.put(SkillsIds.MAGIC_HEALING, 52);
        enemy.skills.put(SkillsIds.MAGIC_MISSILE, 50);

        enemy.givenLoot.add(new ItemReference(ItemsIds.ELIXIR_POTION, 1, 20));
        enemy.givenLoot.add(new ItemReference(ItemsIds.HAT_OF_WISE, 1, 6));

        return enemy;
    }
}

