package com.cnx.endlesstalestwo.data.enemies.golems;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class IceGolem {

    public static Enemy get() {
        Enemy enemy = new Enemy("Ice Golem");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Golem de Gelo");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Gólem de Hielo");

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Eternal ice golem sentinel, side view facing right, humanoid figure made of crystalline eternal ice,
        // transparent frozen body with frost patterns forming continuously on surface,
        // sharp ice crystals protruding from shoulders and back, frozen mist emanating constantly,
        // glowing pale blue eyes radiating cold magic, powerful icy arms and legs,
        // ice blue and white crystalline colors, sparkling frozen surfaces,
        // frozen north guardian theme, ice elemental creature that never melts,
        // 2D RPG sprite style, white background

        enemy.minDamage = 4;
        enemy.maxDamage = 7;
        enemy.damageModifier = 5;
        enemy.weaknesses.put(Enums.Elements.FIRE, 50);
        enemy.resistances.put(Enums.Elements.WATER, 50);
        enemy.resistances.put(Enums.Elements.WIND, 25);
        enemy.setVitalities(43, 25);
        enemy.setDefense(6);
        enemy.setAgility(9);
        enemy.setStrength(15);
        enemy.givenExperience = 27;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 13;
        enemy.skills.put(SkillsIds.ICE_RAY, 50);

        // Conditional loot - only drops if player has The Golem Tale quest active
        enemy.listeners = () -> {
            if (LibQuest.charHasQuest(QuestsIds.THE_GOLEM_TALE, App.getPlayerChar())) {
                enemy.givenLoot.add(new ItemReference(ItemsIds.ETERNAL_ICE_CRYSTAL, 1, 70));
            }
        };

        enemy.givenLoot.add(new ItemReference(ItemsIds.WHITE_HERB, 1, 35));
        enemy.givenLoot.add(new ItemReference(ItemsIds.SAPPHIRE, 1, 11));
        enemy.givenLoot.add(new ItemReference(ItemsIds.MP_POTION, 1, 20));

        return enemy;
    }
}

