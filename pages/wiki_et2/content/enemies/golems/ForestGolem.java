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

public class ForestGolem {

    public static Enemy get() {
        Enemy enemy = new Enemy("Forest Golem");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Golem da Floresta");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Gólem del Bosque");

        // IMAGE GENERATION PROMPT (Bing Image Creator):
        // Ancient forest golem guardian, side view facing right, humanoid figure made of living wood and moss,
        // thick bark armor covering body, vines and leaves growing from limbs, small branches sprouting continuously,
        // deep green moss and brown bark colors, glowing emerald eyes filled with nature magic,
        // powerful tree-like legs rooted in earth, massive wooden arms,
        // forest protector theme, nature elemental creature,
        // 2D RPG sprite style, white background

        enemy.minDamage = 2;
        enemy.maxDamage = 5;
        enemy.damageModifier = 3;
        enemy.weaknesses.put(Enums.Elements.FIRE, 50);
        enemy.resistances.put(Enums.Elements.EARTH, 50);
        enemy.resistances.put(Enums.Elements.WATER, 25);
        enemy.setVitalities(38, 28);
        enemy.setDefense(4);
        enemy.setAgility(7);
        enemy.setStrength(14);
        enemy.givenExperience = 18;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 8;

        // Conditional loot - only drops if player has The Golem Tale quest active
        enemy.listeners = () -> {
            if (LibQuest.charHasQuest(QuestsIds.THE_GOLEM_TALE, App.getPlayerChar())) {
                enemy.givenLoot.add(new ItemReference(ItemsIds.LIVING_MOSSWOOD, 1, 70));
            }
        };

        enemy.givenLoot.add(new ItemReference(ItemsIds.LOG, 2, 41));
        enemy.givenLoot.add(new ItemReference(ItemsIds.GREEN_HERB, 2, 45));

        return enemy;
    }
}

