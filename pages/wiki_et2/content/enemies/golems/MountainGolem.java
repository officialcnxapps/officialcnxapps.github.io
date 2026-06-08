package com.cnx.endlesstalestwo.data.enemies.golems;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class MountainGolem {

    public static Enemy get() {
        Enemy enemy = new Enemy("Mountain Golem");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Golem da Montanha");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Gólem de la Montaña");

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Colossal mountain golem titan, side view facing right, humanoid giant made of ancient stone and rock,
        // massive boulder-like body with mysterious glowing runes carved deep into surface,
        // incredibly thick stone armor, cracks radiating earth magic power,
        // powerful rocky fists capable of crushing mountains, legs like stone pillars,
        // dark gray and brown stone colors, orange-red runes pulsing with magic,
        // mountain guardian colossus theme, earth elemental creature of immense power,
        // 2D RPG sprite style, white background

        enemy.minDamage = 3;
        enemy.maxDamage = 7;
        enemy.damageModifier = 2;
        enemy.weaknesses.put(Enums.Elements.WIND, 50);
        enemy.resistances.put(Enums.Elements.EARTH, 50);
        enemy.setVitalities(43, 35);
        enemy.setDefense(4);
        enemy.setAgility(5);
        enemy.setStrength(16);
        enemy.givenExperience = 22;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 8;
        enemy.skills.put(SkillsIds.ROCK_RAIN, 40);

        // Conditional loot - only drops if player has The Golem Tale quest active
        enemy.listeners = () -> {
            if (LibQuest.charHasQuest(QuestsIds.THE_GOLEM_TALE, App.getPlayerChar())) {
                enemy.givenLoot.add(new ItemReference(ItemsIds.RUNIC_STONE_FRAGMENT, 1, 70));
            }
        };

        enemy.givenLoot.add(new ItemReference(ItemsIds.ROCK, 2, 60));
        enemy.givenLoot.add(new ItemReference(ItemsIds.IRON_ORE, 1, 40));

        return enemy;
    }
}

