package com.cnx.endlesstalestwo.data.locations.lisport;

import android.content.Context;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.battles.BattlesIds;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.knowledges.KnowledgesIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.regions.RegionsIds;
import com.cnx.endlesstalestwo.entities.Character;
import com.cnx.endlesstalestwo.entities.GameplayCoreEntity;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Other extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, lisportFarms());//
        App.DataManager.add(Enums.DataTypes.LOCALE, lisportShores());//
        App.DataManager.add(Enums.DataTypes.LOCALE, lisportRoad());//
        App.DataManager.add(Enums.DataTypes.LOCALE, lisportHarbor());//
        App.DataManager.add(Enums.DataTypes.LOCALE, lisportPlains());//
        App.DataManager.add(Enums.DataTypes.LOCALE, lisportNorthGrove());//
        App.DataManager.add(Enums.DataTypes.LOCALE, lisportWestGrove());//
        App.DataManager.add(Enums.DataTypes.LOCALE, orcHamlet());//
        App.DataManager.add(Enums.DataTypes.LOCALE, lisportMountains());//
        App.DataManager.add(Enums.DataTypes.LOCALE, lisportMountainPeak());
    }

    Locale lisportFarms() {
        Locale locale = new Locale("Lisport Farms", RegionsIds.LISPORT);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Fazendas de Lisport");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Haciendas de Lisport");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The surroundings of the Lisport town is where the villagers plant, grow and harvest the kingdom food.\nA mill is located behind three big crop fields.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Os arredores da cidade de Lisport são onde os aldeões plantam, cultivam e colhem os alimentos do reino.\nUm moinho está localizado atrás de três grandes campos de cultivo.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Los alrededores de la ciudad de Lisport son donde los aldeanos plantan, cultivan y cosechan los alimentos del reino.\nDetrás de tres grandes campos de cultivo hay un molino.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.type = Enums.LocationTypes.FARM;

        locale.npcs.add(NpcsIds.HERALD);
        locale.npcs.add(NpcsIds.MADELAINE);

        return locale;
    }

    Locale lisportShores() {
        Locale locale = new Locale("Lisport Shores", RegionsIds.LISPORT);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Litoral de Lisport");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Costas de Lisport");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The west coast of Lisport Island presents a beautiful horizon. The waves are not high and the shore is more like very small stones than sand. There is a wooden pier to fish.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A costa oeste da Ilha Lisport apresenta um horizonte lindo. As ondas não são altas e a costa é mais como pedras muito pequenas do que areia. Há um píer de madeira para pescar.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La costa oeste de la isla de Lisport presenta un hermoso horizonte. Las olas no son altas y la orilla es más bien de piedritas muy pequeñas que de arena. Hay un muelle de madera para pescar.");

        locale.actions.add(ActionsIds.FISHING_BASIC);
        locale.type = Enums.LocationTypes.SEA;

        locale.places.add(LocationsIds.KLAUS_CABIN);

        locale.possibleBattles.put(BattlesIds.SWASHBUCKLER_PIRATE_1, 10);

        return locale;
    }

    Locale lisportRoad() {
        Locale locale = new Locale("Lisport Road", RegionsIds.LISPORT);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Estrada de Lisport");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carretera Lisport");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A long road that connects south and north of the Lisport Island. The vegetation is scarce, but the surroundings plains are green and give you a feeling of peace.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma longa estrada que conecta Lisport a várias localidades próximas.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un largo camino que conecta Lisport con varias localidades cercanas.");

        locale.alwaysShow = false;

        locale.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.UNDER_ATTACK);
            if (requiredQuest == null || requiredQuest.getCurrentPartOrder() == 1) {
                return Enums.RequirementVerification.NOT_OK;
            }

            return Enums.RequirementVerification.OK;
        };

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);

        locale.possibleBattles.put(BattlesIds.BANDIT_1, 26);
        locale.possibleBattles.put(BattlesIds.BANDIT_2, 18);

        locale.type = Enums.LocationTypes.ROAD;

        return locale;
    }

    Locale lisportHarbor() {
        Locale locale = new Locale("Lisport Harbor", RegionsIds.LISPORT);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Porto de Lisport");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Puerto de Lisport");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Not the biggest harbor, but well structured. Piers and buildings are made of wood. Crates of fishes and goods are everywhere.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Não é o maior porto, mas é bem estruturado. Os píeres e prédios são feitos de madeira. Caixas de peixes e mercadorias estão por todo lugar.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "No es el puerto más grande, pero está bien estructurado. Los muelles y los edificios están hechos de madera. Hay cajas de pescado y mercancías por todas partes.");

        locale.actions.add(ActionsIds.FISHING_BASIC);

        locale.type = Enums.LocationTypes.HARBOR;

        locale.npcs.add(NpcsIds.JOGGARD);
        locale.npcs.add(NpcsIds.OLGA);
        locale.npcs.add(NpcsIds.CAPTAIN_PALMER);

        return locale;
    }

    Locale lisportPlains() {
        Locale locale = new Locale("Lisport Plains", RegionsIds.LISPORT);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Planícies de Lisport");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Llanuras de Lisport");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Green grass, small hills, some wild animals and low vegetation. This is the definition of these plains.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Grama verde, pequenas colinas, alguns animais selvagens e vegetação baixa. Essa é a definição dessas planícies.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pasto verde, pequeñas colinas, algunos animales salvajes y vegetación baja. Esa es la definición de estas llanuras.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.actions.add(ActionsIds.HUNT_BASIC);

        locale.type = Enums.LocationTypes.PLAINS;

        return locale;
    }

    Locale lisportNorthGrove() {
        Locale locale = new Locale("Lisport North Grove", RegionsIds.LISPORT);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Bosque do Norte de Lisport");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bosque del Norte de Lisport");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A beautiful woods with trees that are not small nor big. A breeze coming from the nearby coast shakes the leaves. There is wild life from the ground to the tree tops.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma bela floresta com árvores que não são pequenas nem grandes. Uma brisa vinda da costa próxima balança as folhas. Há vida selvagem do chão até o topo das árvores.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un hermoso bosque con árboles que no son pequeños ni grandes. Una brisa proveniente de la costa cercana agita las hojas. Hay vida salvaje desde el suelo hasta las copas de los árboles.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.actions.add(ActionsIds.WOODCUTTING);
        locale.actions.add(ActionsIds.HUNT_BASIC);

        locale.type = Enums.LocationTypes.FOREST;

        locale.possibleBattles.put(BattlesIds.SPIDER_1, 30);
        locale.possibleBattles.put(BattlesIds.VENOM_SPIDER_1, 19);
        locale.possibleBattles.put(BattlesIds.GROVE_GOBLIN_1, 26);
        locale.possibleBattles.put(BattlesIds.GROVE_GOBLIN_2, 20);
        locale.possibleBattles.put(BattlesIds.SPIDER_1_VENOM_SPIDER_1, 7);

        return locale;
    }

    Locale lisportWestGrove() {
        Locale locale = new Locale("Lisport West Grove", RegionsIds.LISPORT);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Bosque do Oeste de Lisport");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bosque del Oeste de Lisport");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The biggest forest in Lisport Island. There is many different types and colors of trees and bushes. Animals run scared with every step you take.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma bela floresta com árvores que não são pequenas nem grandes. Uma brisa vinda da costa próxima agita as folhas. Há vida selvagem desde o solo até as copas das árvores.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un hermoso bosque con árboles que no son pequeños ni grandes. Una brisa proveniente de la costa cercana agita las hojas. Hay vida salvaje desde el suelo hasta las copas de los árboles.");

        locale.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.UNDER_ATTACK);
            if (requiredQuest == null || requiredQuest.getCurrentPartOrder() == 1) {
                return Enums.RequirementVerification.NOT_OK;
            }

            return Enums.RequirementVerification.OK;
        };

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.actions.add(ActionsIds.WOODCUTTING);
        locale.actions.add(ActionsIds.HUNT_BASIC);

        locale.type = Enums.LocationTypes.FOREST;

        locale.possibleBattles.put(BattlesIds.SPIDER_1, 26);
        locale.possibleBattles.put(BattlesIds.VENOM_SPIDER_1, 19);
        locale.possibleBattles.put(BattlesIds.GROVE_GOBLIN_1, 26);
        locale.possibleBattles.put(BattlesIds.SPIDER_1_VENOM_SPIDER_1, 6);
        locale.possibleBattles.put(BattlesIds.ORC_PEASANT_1, 23);
        locale.possibleBattles.put(BattlesIds.ORC_BATTLER_1, 11);

        locale.npcs.add(NpcsIds.PAULSON);

        return locale;
    }

    Locale orcHamlet() {
        Locale locale = new Locale("Orc Hamlet", RegionsIds.LISPORT);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aldeia Orc");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aldea Orc");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Rounded by spiked wood walls, red flags with orc badges are hanging on every corner. The huts are made with logs and straw. You can feel a dangerous aura here.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cercado por paredes de madeira com espinhos, bandeiras vermelhas com emblemas de orcs estão penduradas em cada esquina. As cabanas são feitas de troncos e palha. Você pode sentir uma aura perigosa aqui.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Rodeado de muros de madera con púas, en cada esquina cuelgan banderas rojas con insignias de orcos. Las cabañas están hechas de troncos y paja. Aquí se respira un aura peligrosa.");

        locale.type = Enums.LocationTypes.VILLAGE;

        locale.possibleBattles.put(BattlesIds.ORC_PEASANT_1, 18);
        locale.possibleBattles.put(BattlesIds.ORC_BATTLER_1, 15);
        locale.possibleBattles.put(BattlesIds.ORC_BATTLER_2, 12);
        locale.possibleBattles.put(BattlesIds.ORC_MASTER_1, 10);

        locale.requirementValidations = new GameplayCoreEntity.RequirementsValidations() {
            @Override
            public Enums.RequirementVerification check(Character chara, Context ctx) {
                if (LibQuest.isQuestComplete(chara, QuestsIds.COUNTER_ATTACK) || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.COUNTER_ATTACK, 4)) {
                    return Enums.RequirementVerification.NOT_OK;
                }
                return Enums.RequirementVerification.OK;
            }
        };

        return locale;
    }

    Locale lisportMountains() {
        Locale locale = new Locale("Lisport Mountains", RegionsIds.LISPORT);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Montanhas de Lisport");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Montañas de Lisport");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The highest points of Lisport. This mountain, that is not giant, is covered by dirt and rocks. You can't achieve the peak without the corect equipment.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Os pontos mais altos de Lisport. Esta montanha, que não é gigante, é coberta por terra e pedras. Você não pode atingir o pico sem o equipamento correto.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Los puntos más altos de Lisport. Esta montaña, que no es gigante, está cubierta de tierra y rocas. No se puede llegar a la cima sin el equipo adecuado.");

        locale.possibleBattles.put(BattlesIds.MOUNTAIN_GOLEM_1, 4);
        locale.possibleBattles.put(BattlesIds.MOUNTAIN_TROLL_1, 9);
        locale.possibleBattles.put(BattlesIds.VENOM_SPIDER_1, 19);

        locale.requirementValidations = (chara, ctx) -> {
            if (LibInventory.checkHasItemAmount(ItemsIds.ROPE, 1, chara)
                    && chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.OK;
            } else if (!chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.NEED_KNOWLEDGES;
            }

            return Enums.RequirementVerification.NEED_ITEMS;
        };

        locale.actions.add(ActionsIds.MINING_EXTRA);
        locale.type = Enums.LocationTypes.MOUNTAIN;

        return locale;
    }

    Locale lisportMountainPeak() {
        Locale locale = new Locale("Lisport Mountains Peak", RegionsIds.LISPORT);
        locale.resetId(LocationsIds.LISPORT_MOUNTAIN_PEAK.name());
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Montanhas de Lisport - Pico");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pico de la Montañas de Lisport");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The absolute summit of the Lisport mountains. The air is thin and the wind carries the screeching of winged predators.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O cume absoluto das montanhas de Lisport. O ar é rarefeito e o vento carrega o guincho de predadores alados.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La cima absoluta de las montañas de Lisport. El aire es ralo y el viento trae el chillido de depredadores alados.");

        locale.requirementValidations = (chara, ctx) -> {
            if (LibInventory.checkHasItemAmount(ItemsIds.ROPE, 1, chara)
                    && chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.OK;
            } else if (!chara.hasKnowledge(KnowledgesIds.CLIMBING)) {
                return Enums.RequirementVerification.NEED_KNOWLEDGES;
            }

            return Enums.RequirementVerification.NEED_ITEMS;
        };

        locale.possibleBattles.put(BattlesIds.MOUNTAIN_GOLEM_1, 12);
        locale.possibleBattles.put(BattlesIds.MOUNTAIN_TROLL_1, 14);

        if ((LibQuest.charHasQuest(QuestsIds.BLOOD_WITH_BLOOD, App.getPlayerChar())
                || LibQuest.charHasQuest(QuestsIds.DRAGON_FEAR, App.getPlayerChar()))
                && !LibQuest.isQuestComplete(App.getPlayerChar(), QuestsIds.DRAGON_FEAR)) {
            locale.possibleBattles.put(BattlesIds.WYVERN_1, 20);
        }

        locale.type = Enums.LocationTypes.MOUNTAIN;

        return locale;
    }
}
