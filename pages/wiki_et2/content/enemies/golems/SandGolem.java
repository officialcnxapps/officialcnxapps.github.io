package com.cnx.endlesstalestwo.data.enemies.golems;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class SandGolem {

    public static Enemy get() {
        Enemy enemy = new Enemy("Sand Golem");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Golem de Areia");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Gólem de Arena");

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Massive sand golem creature, side view facing right, humanoid figure made entirely of swirling desert sand,
        // ancient glowing runes carved into sandy body, particles constantly shifting and falling,
        // powerful arms and legs formed from compacted sand, mysterious amber eyes glowing with magic,
        // desert guardian theme, enchanted elemental creature of the dunes,
        // warm golden and orange sand colors, magical essence radiating from core,
        // 2D RPG sprite style, white background

        enemy.minDamage = 3;
        enemy.maxDamage = 5;
        enemy.damageModifier = 4;
        enemy.weaknesses.put(Enums.Elements.WIND, 25);
        enemy.weaknesses.put(Enums.Elements.WATER, 50);
        enemy.resistances.put(Enums.Elements.FIRE, 50);
        enemy.resistances.put(Enums.Elements.EARTH, 25);
        enemy.setVitalities(48, 22);
        enemy.setDefense(4);
        enemy.setAgility(8);
        enemy.setStrength(16);
        enemy.givenExperience = 24;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 10;

        // Conditional loot - only drops if player has The Golem Tale quest active
        enemy.listeners = () -> {
            if (LibQuest.charHasQuest(QuestsIds.THE_GOLEM_TALE, App.getPlayerChar())) {
                enemy.givenLoot.add(new ItemReference(ItemsIds.ENCHANTED_DESERT_SAND, 1, 70));
            }
        };

        enemy.givenLoot.add(new ItemReference(ItemsIds.ROCK, 2, 40));
        enemy.givenLoot.add(new ItemReference(ItemsIds.YELLOW_HERB, 1, 25));
        enemy.givenLoot.add(new ItemReference(ItemsIds.GOLD_ORE, 1, 29));

        return enemy;
    }
}

