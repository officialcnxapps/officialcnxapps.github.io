package com.cnx.endlesstalestwo.data.enemies.dark;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;

public class VoidStalker {

    public static Enemy get() {
        Enemy enemy = new Enemy("Void Stalker");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caçador do Vazio");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cazador del Vacío");

        enemy.givenExperience = 16;
        enemy.givenGold = 0;
        enemy.setVitalities(32, 30);
        enemy.setDefense(2);
        enemy.setAgility(15);
        enemy.setStrength(11);
        enemy.minDamage = 3;
        enemy.maxDamage = 7;
        enemy.damageModifier = 3;
        enemy.levelToDynamicBalance = 9;
        enemy.skills.put(SkillsIds.BLOOD_RAIN, 38);
        enemy.givenLoot.add(new ItemReference(ItemsIds.DARK_MUSHROOM, 1, 55));
        enemy.givenLoot.add(new ItemReference(ItemsIds.JEWEL_OF_UNJUST, 1, 16));
        enemy.givenLoot.add(new ItemReference(ItemsIds.HP_POTION, 1, 62));

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
         Void Stalker predatory creature, side view facing right, sleek feline or reptilian body made of pitch-black material
         absorbing all light, multiple limbs or tentacle-like appendages fading into nothingness at edges, glowing purple
         or crimson runes flowing across body like veins, large predatory eyes glowing otherworldly light, air distorts
         and warps around it, sharp angular features, medieval fantasy with cosmic horror influences, 2D RPG sprite, white background. */

        return enemy;
    }
}

