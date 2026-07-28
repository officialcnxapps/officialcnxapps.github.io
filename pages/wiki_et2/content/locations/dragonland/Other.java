package com.cnx.endlesstalestwo.data.locations.dragonland;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.battles.BattlesIds;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.knowledges.KnowledgesIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.regions.RegionsIds;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;

public class Other extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, dragonlandPlains());
        App.DataManager.add(Enums.DataTypes.LOCALE, dragonsMountain());
        App.DataManager.add(Enums.DataTypes.LOCALE, dragonMountainLevel1());
        App.DataManager.add(Enums.DataTypes.LOCALE, dragonMountainPeak());
        App.DataManager.add(Enums.DataTypes.LOCALE, groveOfDeadTrees());
    }

    Locale dragonlandPlains() {
        Locale locale = new Locale("Plains of Dragonland", RegionsIds.DRAGONLAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Planícies de Dragonland");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Planicies de Dragonland");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A vast expanse of cracked, dark earth stretches toward the horizon. The heat here is dry and oppressive, and the only sounds are the whistling wind and the distant, guttural roars of creatures that rule these skies.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma vasta extensão de terra escura e rachada se estende até o horizonte. O calor aqui é seco e opressor, e os únicos sons são o assobio do vento e os rugidos guturais distantes das criaturas que governam estes céus.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una vasta extensión de tierra oscura y agrietada se extiende hasta el horizonte. El calor aquí es seco y opresivo, y los únicos sonidos son el silbido del viento y los rugidos guturales distantes de las criaturas que gobiernan estos cielos.");

        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_1, 12);
        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_2, 8);

        locale.actions.add(ActionsIds.NAVIGATE_TO_HAVARUS);
        locale.type = Enums.LocationTypes.PLAINS;
        return locale;
    }

    Locale dragonsMountain() {
        Locale locale = new Locale("Dragons Mountain", RegionsIds.DRAGONLAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Montanha dos Dragões");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Montaña del Dragóns");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "At the base of the colossal peak, the air grows even thinner and warmer. Massive jagged rocks form natural stairways leading upward, many of them scorched by ancient dragon fire.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Na base do pico colossal, o ar torna-se ainda mais rarefeito e quente. Rochas irregulares maciças formam escadarias naturais que levam para cima, muitas delas chamuscadas pelo fogo de dragões ancestrais.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En la base del pico colosal, el aire se vuelve aún más enrarecido y cálido. Macizas rocas dentadas forman escaleras naturales que conducen hacia arriba, muchas de ellas chamuscadas por el fuego de dragones ancestrales.");

        locale.possibleBattles.put(BattlesIds.WYVERN_1, 20);
        locale.type = Enums.LocationTypes.MOUNTAIN;
        return locale;
    }

    Locale dragonMountainLevel1() {
        Locale locale = new Locale("Dragons Mountain - Level 1", RegionsIds.DRAGONLAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Montanha dos Dragões - Nível 1");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Montaña del Dragóns - Nivel 1");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Midway up the mountain, the paths become treacherous. Sulfurous vapors seep from cracks in the ground, and the view of the desolate plains below is both magnificent and terrifying.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "No meio do caminho montanha acima, as trilhas tornam-se traiçoeiras. Vapores sulfurosos escapam de fendas no solo, e a vista das planícies desoladas abaixo é ao mesmo tempo magnífica e aterrorizante.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "A mitad de camino montaña arriba, los senderos se vuelven traicioneros. Vapores sulfurosos se filtran por grietas en el suelo, y la vista de las llanuras desoladas de abajo es a la vez magnífica y aterradora.");

        locale.possibleBattles.put(BattlesIds.FIRE_DRAGON_1, 30);
        locale.possibleBattles.put(BattlesIds.WYVERN_1, 30);
        locale.actions.add(ActionsIds.MINING_EXTRA);

        locale.requirementValidations = (chara, ctx) -> {
            if (chara.hasKnowledge(KnowledgesIds.CLIMBING) && LibInventory.checkHasItem(ItemsIds.ROPE, chara)) {
                return Enums.RequirementVerification.OK;
            } else if (!chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.NEED_KNOWLEDGES;
            } else {
                return Enums.RequirementVerification.NEED_ITEMS;
            }
        };

        locale.type = Enums.LocationTypes.MOUNTAIN;
        return locale;
    }

    Locale dragonMountainPeak() {
        Locale locale = new Locale("Dragons Mountain - Peak", RegionsIds.DRAGONLAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Montanha dos Dragões - Pico");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pico de la Montaña del Dragóns");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "You stand upon the highest point of the island, where the wind howls like a wounded beast. The ground is literally covered in old bones and dragon scales, a silent testament to the many battles fought here.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Você está no ponto mais alto da ilha, onde o vento uiva como uma fera ferida. O chão está literalmente coberto de ossos velhos e escamas de dragão, um testemunho silencioso das muitas batalhas travadas aqui.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Te encuentras en el punto más alto de la isla, donde el viento aúlla como una fiera herida. El suelo está literalmente cubierto de huesos viejos y escamas de dragón, un testimonio silencioso de las muchas batallas libradas aquí.");

        locale.possibleBattles.put(BattlesIds.WYVERN_1, 40);
        locale.possibleBattles.put(BattlesIds.ICE_DRAGON_1, 40);
        locale.actions.add(ActionsIds.MINING_EXTRA);

        locale.requirementValidations = (chara, ctx) -> {
            if (chara.hasKnowledge(KnowledgesIds.CLIMBING) && LibInventory.checkHasItem(ItemsIds.ROPE, chara)) {
                return Enums.RequirementVerification.OK;
            } else if (!chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.NEED_KNOWLEDGES;
            } else {
                return Enums.RequirementVerification.NEED_ITEMS;
            }
        };

        locale.type = Enums.LocationTypes.MOUNTAIN;
        return locale;
    }

    Locale groveOfDeadTrees() {
        Locale locale = new Locale("Grove of Dead Trees", RegionsIds.DRAGONLAND);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Bosque das Árvores Mortas");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Arboleda de Árboles Muertos");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Twisted, leafless trunks rise from the dry earth like skeletal hands reaching for a sun obscured by ash. The silence here is unnatural, broken only by the occasional snap of a brittle branch.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Troncos retorcidos e sem folhas surgem da terra seca como mãos esqueléticas alcançando um sol obscurecido pelas cinzas. O silêncio aqui é não natural, quebrado apenas pelo estalo ocasional de um galho quebradiço.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Troncos retorcidos y sin hojas surgen de la tierra seca como manos esqueléticas que alcanzan un sol oscurecido por la ceniza. El silencio aquí es antinatural, roto sólo por el crujido ocasional de una rama quebradiza.");

        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_FIRE_1, 15);
        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_2, 15);
        locale.possibleBattles.put(BattlesIds.VENOM_SPIDER_2, 13);

        locale.places.add(LocationsIds.WOODEN_HUT);

        locale.actions.add(ActionsIds.WOODCUTTING);
        locale.actions.add(ActionsIds.GATHERING_EXTRA);

        locale.type = Enums.LocationTypes.FOREST;
        return locale;
    }
}
