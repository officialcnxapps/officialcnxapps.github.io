package com.cnx.endlesstalestwo.data.enemies;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.skills.SkillsIds;
import com.cnx.endlesstalestwo.entities.Enemy;
import com.cnx.endlesstalestwo.entities.ItemReference;
import com.cnx.endlesstalestwo.enums.Enums;

public class MutantInsectSwarm {

    public static Enemy get() {
        Enemy enemy = new Enemy("Mutant Insect Swarm");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Enxame de Insetos Mutantes");
        enemy.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Enjambre de Insectos Mutantes");

        enemy.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A horrifying cloud of mutated crickets that merged into a single massive swarm. Their chittering fills the air as they attack in coordinated waves.");
        enemy.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma nuvem horripilante de grilos mutantes que se fundiram em um único enxame massivo. Seu som ensurdecedor preenche o ar enquanto atacam em ondas coordenadas.");
        enemy.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una nube horripilante de grillos mutantes que se fusionaron en un solo enjambre masivo. Su chirrido llena el aire mientras atacan en ondas coordinadas.");

        enemy.minDamage = 3;
        enemy.maxDamage = 6;
        enemy.damageModifier = 3;
        enemy.setVitalities(39, 48);
        enemy.setDefense(2);
        enemy.setAgility(18);
        enemy.setStrength(8);
        enemy.givenExperience = 17;
        enemy.givenGold = 0;
        enemy.levelToDynamicBalance = 8;

        enemy.skills.put(SkillsIds.POISONOUS_POLEN, 45);
        enemy.skills.put(SkillsIds.POISON_STING, 48);

        // Elemental affinities
        enemy.weaknesses.put(Enums.Elements.FIRE, 50);
        enemy.resistances.put(Enums.Elements.EARTH, 50);
        enemy.resistances.put(Enums.Elements.PHYSICAL, 25);

        enemy.givenLoot.add(new ItemReference(ItemsIds.NUTS, 2, 51));
        enemy.givenLoot.add(new ItemReference(ItemsIds.WHEAT, 3, 67));

         /* IMAGE GENERATION PROMPT (Bing Image Creator):
          Mutant Insect Swarm massive cloud of mutant crickets, full swarm fully inside frame, side view facing right,
          dense dark cluster of insects with glowing red eyes, sharp legs and wings, toxic green hints between chitin shells,
          chaotic attack formation, no cropped outer swarm edges, medieval fantasy horror, 2D RPG sprite, white background. */

        enemy.imgFile = "enemy_insect_swarm";

        return enemy;
    }
}
