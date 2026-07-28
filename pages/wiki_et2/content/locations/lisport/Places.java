package com.cnx.endlesstalestwo.data.locations.lisport;

import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_INN_DESCRIPTION_ENGLISH;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_INN_DESCRIPTION_PORTUGUESE;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_INN_DESCRIPTION_SPANISH;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_TAVERN_DESCRIPTION_ENGLISH;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_TAVERN_DESCRIPTION_PORTUGUESE;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_TAVERN_DESCRIPTION_SPANISH;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.battles.BattlesIds;
import com.cnx.endlesstalestwo.data.events.EventsIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.entities.Place;
import com.cnx.endlesstalestwo.entities.Quest;
import com.cnx.endlesstalestwo.enums.Enums;

public class Places extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.PLACE, forge());
        App.DataManager.add(Enums.DataTypes.PLACE, breedersUnion());//
        App.DataManager.add(Enums.DataTypes.PLACE, castle());//
        App.DataManager.add(Enums.DataTypes.PLACE, castleThroneRoom());//
        App.DataManager.add(Enums.DataTypes.PLACE, tavern());
        App.DataManager.add(Enums.DataTypes.PLACE, inn());
        App.DataManager.add(Enums.DataTypes.PLACE, klausCabin());//
        App.DataManager.add(Enums.DataTypes.PLACE, dungeonOfSilence());//
        App.DataManager.add(Enums.DataTypes.PLACE, lisportBarracks());//
        App.DataManager.add(Enums.DataTypes.PLACE, johnHouse());//
        App.DataManager.add(Enums.DataTypes.PLACE, lisportChurch());//
    }

    Place forge() {
        Place place = new Place("Forge", LocationsIds.LISPORT, "LISPORT_FORGE");
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forja");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Fragua");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "There is a smell of melted iron and chemical liquids. Tools and workbenches make this place ideal for crafting and creating items.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Há cheiro de ferro derretido e líquidos químicos. Ferramentas e bancadas de trabalho fazem deste local o ideal para produzir e criar artigos.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hay olor a hierro derretido y líquidos químicos. Las herramientas y los bancos de trabajo hacen que este lugar sea ideal para producir y crear artículos.");

        place.actions.add(ActionsIds.CRAFT_GENERAL);

        place.type = Enums.LocationTypes.FORGE;
        place.setLocale(LocationsIds.LISPORT);

        place.npcs.add(NpcsIds.NUBIA);

        return place;
    }

    Place breedersUnion() {
        Place place = new Place("Potion Breeders Union", LocationsIds.LISPORT);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "União dos Criadores de Poções");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Unión de Criadores de Pociones");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "In this association, the regulars are experts in potions. There is everything needed to perform alchemy: ingredients, spirits, glassware and herbs hanging on the walls and cauldrons.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Nesta associação, os frequentadores são especialistas em poções. Há de tudo para a realização da alquimia: ingredientes, aguardentes, vidraria e ervas penduradas nas paredes e nos caldeirões.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En esta asociación, los habituales son expertos en pociones. Hay todo lo necesario para realizar alquimia: ingredientes, licores, cristalería y hierbas colgadas en las paredes y calderos.");

        place.actions.add(ActionsIds.CRAFT_ALCHEMY);

        place.resetId("LISPORT_POTION_BREEDERS_UNION");
        place.setLocale(LocationsIds.LISPORT);

        place.npcs.add(NpcsIds.ALDEN);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place castle() {
        Place place = new Place("Lisport Castle", LocationsIds.LISPORT);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Castelo de Lisport");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Castillo de Lisport");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Despite not being a large castle, it is very well decorated. Pennants and candlesticks are everywhere. The blue tapestry is present in every room.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Apesar de não ser um castelo grande, é muito bem decorado. As flâmulas e castiçais estão por todo lado. A tapeçaria azul se faz presente em todas salas.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "A pesar de no ser un castillo grande, está muy bien decorado. Banderines y candelabros están por todas partes. El tapiz azul está presente en todas las habitaciones.");

        place.places.add(LocationsIds.LISPORT_CASTLE_THRONE_ROOM);

        place.resetId("LISPORT_CASTLE");
        place.setLocale(LocationsIds.LISPORT);

        place.npcs.add(NpcsIds.MURDAG);

        place.type = Enums.LocationTypes.CASTLE;
        return place;
    }

    Place castleThroneRoom() {
        Place place = new Place("Throne Room", LocationsIds.LISPORT_CASTLE, true);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sala do Trono");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Salón del Trono");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A small room with a vaulted ceiling. A large throne is in the center in the background, between two colored stained glass windows. This is where the king meets her people.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um sala pequena com teto abobadado. Um trono grande está no centro ao fundo, entre dois vitrais coloridos. É aqui que o rei atende a seu povo.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una pequeña habitación con techo abovedado. Al fondo, en el centro, entre dos vidrieras de colores, se encuentra un gran trono. Aquí es donde el rey sirve a su pueblo.");

        place.returnToPlace = LocationsIds.LISPORT_CASTLE;

        place.resetId("LISPORT_CASTLE_THRONE_ROOM");
        place.imgFile = "locale_lisport_castle_throne_room";
        place.setLocale(LocationsIds.LISPORT_CASTLE, true);

        place.npcs.add(NpcsIds.KING_OLIVER);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place tavern() {
        Place place = new Place("Tavern", LocationsIds.LISPORT);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Taberna");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Taberna");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_TAVERN_DESCRIPTION_ENGLISH);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_TAVERN_DESCRIPTION_PORTUGUESE);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_TAVERN_DESCRIPTION_SPANISH);

        place.actions.add(ActionsIds.COOKING);

        place.resetId("LISPORT_TAVERN");
        place.setLocale(LocationsIds.LISPORT);

        place.npcs.add(NpcsIds.FRILY);
        place.npcs.add(NpcsIds.GARETH);

        place.type = Enums.LocationTypes.TAVERN;
        return place;
    }

    Place inn() {
        Place place = new Place("Inn", LocationsIds.LISPORT);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pousada");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Posada");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_INN_DESCRIPTION_ENGLISH);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_INN_DESCRIPTION_PORTUGUESE);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_INN_DESCRIPTION_SPANISH);

        place.actions.add(ActionsIds.REST);

        place.resetId("LISPORT_INN");
        place.setLocale(LocationsIds.LISPORT);
        place.imgFile = "locale_lisport_inn";

        place.type = Enums.LocationTypes.INN;
        return place;
    }

    Place klausCabin() {
        Place place = new Place("Klaus Cabin", LocationsIds.LISPORT_SHORES);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cabana do Klaus");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cabaña de Klaus");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A small house made of logs and planks. It is humble but also comfortable. The owner probably build everything with his own hands.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma pequena casa feita de troncos e tábuas. É humilde, mas também confortável. O dono provavelmente construiu tudo com suas próprias mãos.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una casita hecha de troncos y tablones. Es humilde pero también cómoda. El propietario probablemente construyó todo con sus propias manos.");

        place.npcs.add(NpcsIds.KLAUS);

        place.type = Enums.LocationTypes.HOUSE;
        return place;
    }

    Place dungeonOfSilence() {
        Place place = new Place("Dungeon of Silence", LocationsIds.LISPORT_NORTH_GROVE);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna do Silêncio");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva del Silencio");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "After a few steps inside you can understand the dungeon name, the rock walls block the sounds from exterior and in the interior has no sounds, not even a water dripping. It is a really dark environment.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Depois de alguns passos para dentro você consegue entender o nome do calabouço, as paredes de pedra bloqueiam os sons do exterior e no interior não tem sons, nem mesmo água pingando. É um ambiente realmente escuro.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Después de unos pasos dentro se puede entender el nombre de la mazmorra, las paredes de roca bloquean los sonidos del exterior y en el interior no hay sonidos, ni siquiera el goteo del agua. Es un ambiente realmente oscuro.");

        place.actions.add(ActionsIds.MINING_BASIC);

        place.possibleBattles.put(BattlesIds.SPIDER_1_VENOM_SPIDER_1, 12);
        place.possibleBattles.put(BattlesIds.VENOM_SPIDER_1, 22);
        place.possibleBattles.put(BattlesIds.DUNGEON_IMP_1, 26);

        place.type = Enums.LocationTypes.DUNGEON;
        return place;
    }

    Place lisportBarracks() {
        Place place = new Place("Lisport Barracks", LocationsIds.LISPORT);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Quartel de Lisport");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cuartel de Lisport");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A wooden longhouse with thatched roofing, housing soldiers' bunks, weapon racks, and a communal area for meals and gatherings. The structure is fortified with minimal defenses.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma casa longa de madeira com telhado de palha, abrigando beliches de soldados, prateleiras para armas e uma área comum para refeições e reuniões. A estrutura é fortificada com defesas mínimas");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una casa comunal de madera con techo de paja que alberga literas para soldados, estantes para armas y un área común para comidas y reuniones. La estructura está fortificada con defensas mínimas.");

        place.npcs.add(NpcsIds.LENNY);
        place.npcs.add(NpcsIds.JOHN);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place lisportChurch() {
        Place place = new Place("Church", LocationsIds.LISPORT);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Igreja");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Iglesia");

        place.resetId("LISPORT_CHURCH");
        place.imgFile = "locale_lisport_church";
        place.setLocale(LocationsIds.LISPORT);

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The place where the believers pray and exercise their faith. Built with stones and decorated with figures of angels and saints. The windows are painted stained glass.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O lugar onde os fiéis rezam e exercem sua fé. Construída com pedras e decorado com figuras de anjos e santos. As janelas são de vitrais pintados.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lugar donde los creyentes rezan y ejercen su fe. Construida con piedras y decorado con figuras de ángeles y santos. Las ventanas son de vitrales pintados.");

        place.npcs.add(NpcsIds.PRIEST_EDWARD);
        place.npcs.add(NpcsIds.ELENA);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place johnHouse() {
        Place place = new Place("John House", LocationsIds.LISPORT);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Casa de John");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Casa de John");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A humble but very organized house. Walls are made of logs and the furniture is old but very preserved and well decorated.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma casa humilde, mas muito organizada. As paredes são feitas de troncos e os móveis são antigos, mas muito bem conservados e decorados.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una casa humilde pero muy organizada. Las paredes son de troncos y los muebles son antiguos pero muy bien conservados y decorados.");

        place.type = Enums.LocationTypes.BUILDING;
        place.alwaysShow = false;

        place.requirementValidations = (chara, ctx) -> {
            Quest requiredQuest = App.getPlayerChar().getQuest(QuestsIds.A_SHINNING_DECISION);
            if (requiredQuest != null && requiredQuest.getCurrentPartOrder() == 1) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        place.possibleEvents.add(EventsIds.A_SHINNING_DECISION_PART_1);

        return place;
    }
}
