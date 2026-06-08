package com.cnx.endlesstalestwo.data.locations.gybralar;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.battles.BattlesIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.regions.RegionsIds;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.enums.Enums;

public class Others extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, gybralarForestNorth());
        App.DataManager.add(Enums.DataTypes.LOCALE, gybralarForestSouth());
        App.DataManager.add(Enums.DataTypes.LOCALE, gybralarForestEast());
        App.DataManager.add(Enums.DataTypes.LOCALE, gybralarForestWest());
        App.DataManager.add(Enums.DataTypes.LOCALE, gybralarForestInner());
    }

    Locale gybralarForestNorth() {
        Locale locale = new Locale("Gybralar Forest - North", RegionsIds.GYBRALAR_FOREST);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Floresta de Gybralar - Norte");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bosque de Gybralar - Norte");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The northern part of Gybralar Forest is dense and filled with tall trees. The air is fresh, and the sound of birds chirping is constant.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A parte norte da Floresta de Gybralar é densa e cheia de árvores altas. O ar é fresco, e o som dos pássaros cantando é constante.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La parte norte del Bosque de Gybralar es densa y está llena de árboles altos. El aire es fresco y el sonido de los pájaros cantando es constante.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.actions.add(ActionsIds.HUNT_BASIC);
        locale.actions.add(ActionsIds.WOODCUTTING);

        locale.possibleBattles.put(BattlesIds.FOREST_PREDATOR_1, 5);
        locale.possibleBattles.put(BattlesIds.FOREST_WOLF_1, 14);
        locale.possibleBattles.put(BattlesIds.WILD_BOAR_1, 14);

        locale.type = Enums.LocationTypes.FOREST;
        return locale;
    }

    Locale gybralarForestSouth() {
        Locale locale = new Locale("Gybralar Forest - South", RegionsIds.GYBRALAR_FOREST);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Floresta de Gybralar - Sul");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bosque de Gybralar - Sur");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The southern part of Gybralar Forest is slightly less dense, with more open spaces. The ground is covered with soft moss and sparse grass.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A parte sul da Floresta de Gybralar é um pouco menos densa, com mais espaços abertos. O chão é coberto por musgo macio e grama rala.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La parte sur del Bosque de Gybralar es un poco menos densa, con más espacios abiertos. El suelo está cubierto de musgo suave y hierba rala.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.actions.add(ActionsIds.WOODCUTTING);
        locale.actions.add(ActionsIds.HUNT_BASIC);

        locale.possibleBattles.put(BattlesIds.FOREST_PREDATOR_1, 5);
        locale.possibleBattles.put(BattlesIds.FOREST_WOLF_1, 14);
        locale.possibleBattles.put(BattlesIds.WILD_BOAR_1, 16);
        locale.possibleBattles.put(BattlesIds.FOREST_GOLEM_1, 10);

        locale.type = Enums.LocationTypes.FOREST;
        return locale;
    }

    Locale gybralarForestEast() {
        Locale locale = new Locale("Gybralar Forest - East", RegionsIds.GYBRALAR_FOREST);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Floresta de Gybralar - Leste");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bosque de Gybralar - Este");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The eastern part of Gybralar Forest is known for its vibrant flora. The trees here are shorter, and the area is filled with colorful flowers and herbs.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A parte leste da Floresta de Gybralar é conhecida por sua flora vibrante. As árvores aqui são mais baixas, e a área é repleta de flores e ervas coloridas.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La parte este del Bosque de Gybralar es conocida por su flora vibrante. Los árboles aquí son más bajos y la zona está llena de flores y hierbas coloridas.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.actions.add(ActionsIds.WOODCUTTING);
        locale.actions.add(ActionsIds.HUNT_BASIC);

        locale.possibleBattles.put(BattlesIds.FOREST_PREDATOR_1, 5);
        locale.possibleBattles.put(BattlesIds.FOREST_WOLF_1, 14);
        locale.possibleBattles.put(BattlesIds.WILD_BOAR_1, 16);

        locale.type = Enums.LocationTypes.FOREST;
        return locale;
    }

    Locale gybralarForestWest() {
        Locale locale = new Locale("Gybralar Forest - West", RegionsIds.GYBRALAR_FOREST);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Floresta de Gybralar - Oeste");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bosque de Gybralar - Oeste");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The western part of Gybralar Forest is darker and more mysterious. The trees are taller, and the canopy blocks most of the sunlight, creating a shadowy atmosphere. There is a small lake among the trees.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A parte oeste da Floresta de Gybralar é mais escura e misteriosa. As árvores são mais altas, e a copa bloqueia a maior parte da luz do sol, criando uma atmosfera sombria. Há um pequeno lago em meio as árvores.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La parte oeste del Bosque de Gybralar es más oscura y misteriosa. Los árboles son más altos y el dosel bloquea la mayor parte de la luz del sol, creando una atmósfera sombría. Hay un pequeño lago entre los árboles.");

        locale.actions.add(ActionsIds.GATHERING_EXTRA);
        locale.actions.add(ActionsIds.WOODCUTTING);
        locale.actions.add(ActionsIds.HUNT_BASIC);
        locale.actions.add(ActionsIds.FISHING_BASIC);

        locale.possibleBattles.put(BattlesIds.FOREST_GOLEM_1, 16);
        locale.possibleBattles.put(BattlesIds.FOREST_PREDATOR_1, 15);
        locale.possibleBattles.put(BattlesIds.FOREST_WOLF_1, 11);
        locale.possibleBattles.put(BattlesIds.VENOM_SPIDER_1, 10);
        locale.possibleBattles.put(BattlesIds.WILD_BOAR_1, 10);
        locale.possibleBattles.put(BattlesIds.MEDUSA_1, 7);

        locale.type = Enums.LocationTypes.FOREST;
        return locale;
    }

    Locale gybralarForestInner() {
        Locale locale = new Locale("Gybralar Forest - Inner", RegionsIds.GYBRALAR_FOREST);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Floresta de Gybralar - Interior");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bosque de Gybralar - Interior");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The inner part of Gybralar Forest is the heart of the woods. It is dense, quiet, and filled with ancient trees. Few have ventured this deep into the forest.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A parte interior da Floresta de Gybralar é o coração da floresta. É densa, silenciosa e repleta de árvores antigas. Poucos se aventuraram tão fundo na floresta.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La parte interior del Bosque de Gybralar es el corazón del bosque. Es denso, silencioso y está lleno de árboles antiguos. Pocos se han aventurado tan adentro del bosque.");

        locale.actions.add(ActionsIds.GATHERING_EXTRA);
        locale.actions.add(ActionsIds.HUNT_TRAP);

        locale.possibleBattles.put(BattlesIds.FOREST_GOLEM_1, 20);
        locale.possibleBattles.put(BattlesIds.FOREST_PREDATOR_1, 22);

        locale.places.add(LocationsIds.FOREST_MYSTERIOUS_DUG_HOLE);

        locale.type = Enums.LocationTypes.FOREST;
        return locale;
    }
}
