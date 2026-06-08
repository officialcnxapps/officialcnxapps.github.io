package com.cnx.endlesstalestwo.data.locations.wazel;

import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_INN_DESCRIPTION_ENGLISH;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_INN_DESCRIPTION_PORTUGUESE;
import static com.cnx.endlesstalestwo.entities.Constants.DEFAULT_INN_DESCRIPTION_SPANISH;
import static com.cnx.endlesstalestwo.enums.Enums.RequirementVerification.NEED_ITEMS;
import static com.cnx.endlesstalestwo.enums.Enums.RequirementVerification.OK;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.battles.BattlesIds;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.entities.Place;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;

public class Places extends DataHelper {

    //TRADUZIR
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.PLACE, wazelCommunityKitchen());//
        App.DataManager.add(Enums.DataTypes.PLACE, wazelCommunityKitchenRuins());//
        App.DataManager.add(Enums.DataTypes.PLACE, wazelInn());//
        App.DataManager.add(Enums.DataTypes.PLACE, towerOfWarriors());//
        App.DataManager.add(Enums.DataTypes.PLACE, towerOfWarriorsTop());//
        App.DataManager.add(Enums.DataTypes.PLACE, deepCraterCave());//
    }

    Place wazelCommunityKitchen() {
        Place place = new Place("Community Kitchen", LocationsIds.WAZEL);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cozinha Comunitária");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cocina Comunitaria");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The atmosphere is reminiscent of a tavern, but it is wider and open at the front like a veranda. The tables are wide and long, always with a decorative tablecloth. The pillars that support the dining room and the kitchen, which is at the back, are surrounded by a green climbing plant.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O ambiente lembra uma taberna, mas é mais amplo e aberto na frente como uma varanda. As mesas são largas e compridas, sempre com uma toalha decorativa. Os pilares que sustentam o salão e a cozinha, que fica no fundo, estão rodeados por uma planta verde tipo trepadeira.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El ambiente recuerda a una taberna, pero es más amplio y abierto al frente como una veranda. Las mesas son anchas y largas, siempre con un mantel decorativo. Los pilares que sostienen el salón y la cocina, que está al fondo, están rodeados por una planta verde trepadora.");

        place.actions.add(ActionsIds.COOKING);
        place.resetId("WAZEL_COMMUNITY_KITCHEN");

        place.npcs.add(NpcsIds.TERADOCH);
        place.npcs.add(NpcsIds.WHALIKA);

        place.type = Enums.LocationTypes.TAVERN;
        place.musicFile = "tavern_2";

        return place;
    }

    Place wazelCommunityKitchenRuins() {
        Place place = new Place("Community Kitchen", LocationsIds.WAZEL_RUINS);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cozinha Comunitária");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cocina Comunitaria");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The atmosphere is reminiscent of a tavern, but it is wider and open at the front like a veranda. The tables are wide and long, always with a decorative tablecloth. The pillars that support the dining room and the kitchen, which is at the back, are surrounded by a green climbing plant.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O ambiente lembra uma taberna, mas é mais amplo e aberto na frente como uma varanda. As mesas são largas e compridas, sempre com uma toalha decorativa. Os pilares que sustentam o salão e a cozinha, que fica no fundo, estão rodeados por uma planta verde tipo trepadeira.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El ambiente recuerda a una taberna, pero es más amplio y abierto al frente como una veranda. Las mesas son anchas y largas, siempre con un mantel decorativo. Los pilares que sostienen el salón y la cocina, que está al fondo, están rodeados por una planta verde trepadora.");

        place.actions.add(ActionsIds.COOKING);
        place.resetId("WAZEL_RUINS_COMMUNITY_KITCHEN");

        place.npcs.add(NpcsIds.TERADOCH);
        place.npcs.add(NpcsIds.WHALIKA);

        place.type = Enums.LocationTypes.TAVERN;
        place.musicFile = "tavern_2";

        return place;
    }

    Place wazelInn() {
        Place place = new Place("Inn", LocationsIds.WAZEL);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pousada");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Posada");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_INN_DESCRIPTION_ENGLISH);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_INN_DESCRIPTION_PORTUGUESE);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_INN_DESCRIPTION_SPANISH);

        place.actions.add(ActionsIds.REST);

        place.resetId("WAZEL_INN");
        place.imgFile = "locale_wazel_inn";

        place.type = Enums.LocationTypes.INN;

        return place;
    }

    Place towerOfWarriors() {
        Place place = new Place("Tower of Warriors", LocationsIds.TOWER_OF_WARRIORS_ENTRANCE);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Torre dos Guerreiros");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Torre de los Guerreros");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "As soon as you enter the tower, you notice a large space with decorations that refer to battles and warriors. There are no windows on this floor. Some benches and tables are on the rounded sides of the tower. At the back is the circular wooden staircase that leads to the top.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Logo ao entrar na torre você já nota um amplo espaço com decorações que remetem a batalhas e guerreiros. Não há nenhuma janela neste andar. Alguns bancos e mesas estão nas laterais arredondadas da torre. Ao fundo está a escada circular de madeira que leva ao topo.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Nada más entrar en la torre, notas un gran espacio con decoraciones que aluden a batallas y guerreros. No hay ventanas en este piso. Algunos bancos y mesas están en los laterales redondeados de la torre. Al fondo está la escalera circular de madera que conduce a la parte superior.");

        place.places.add(LocationsIds.TOWER_OF_WARRIORS_TOP);

        place.npcs.add(NpcsIds.ERIDAN);
        place.npcs.add(NpcsIds.JANOCH);

        place.type = Enums.LocationTypes.TOWER;
        return place;
    }

    Place towerOfWarriorsTop() {
        Place place = new Place("Tower Of Warriors - Top", LocationsIds.TOWER_OF_WARRIORS, true);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Topo da Torre dos Guerreiros");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cima de la Torre de los Guerreros");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "At the top of the tower, which must be about 40 meters high, the structure is no longer made of stone, but of wood. There are several windows that allow observation of the entire desert and much of the ocean that surrounds it. Here there are some work tables and chairs, and this is where the warrior leaders meet.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "No topo da torre, que deve ter cerca de 40 metros de altura, a estrutura não é mais de pedra, mas sim de madeira. Há várias janelas que permitem a observação de todo o deserto e boa parte do oceano que o cerca. Aqui há algumas mesas de trabalho e cadeiras, sendo o local onde os líderes guerreiros se reúnem.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En la cima de la torre, que debe tener unos 40 metros de altura, la estructura ya no es de piedra, sino de madera. Hay varias ventanas que permiten observar todo el desierto y gran parte del océano que lo rodea. Aquí hay algunas mesas de trabajo y sillas, siendo el lugar donde se reúnen los líderes guerreros.");

        place.npcs.add(NpcsIds.DANJOR);

        place.type = Enums.LocationTypes.TOWER;

        return place;
    }

    Place deepCraterCave() {
        Place place = new Place("Deep Crater Cave", LocationsIds.DEEP_CRATER);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna da Cratera Profunda");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva de la Cratera Profunda");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "As you pass through the crack in the back wall of the crater, you find yourself in a huge cave chamber made up of dark, irregular rocks. There is no silt here because the desert air is dry. A few cacti grow in the cracks in the rocks. At the back of the cave is a particularly unusually shaped rock.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ao cruzar a fenda na parede do fundo da cratera, você se vê em uma enorme câmara de caverna formada por pedras irregulares e escuras. Não há limo aqui pois o ar do deserto é seco. Alguns cactus se desenvolvem pelas brechas das rochas. Ao fundo da gruta há uma pedra com formato especialmente diferente.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cuando cruzas la grieta en la pared trasera del cráter, te encuentras en una enorme cámara de cueva formada por rocas oscuras e irregulares. No hay limo aquí porque el aire del desierto es seco. Algunos cactus crecen en las grietas de las rocas. Al fondo de la cueva hay una piedra con una forma especialmente diferente.");

        place.actions.add(ActionsIds.MINING_RARE);

        place.type = Enums.LocationTypes.CAVERN;

        place.requirementValidations = (chara, ctx) -> {
            if (!LibInventory.checkHasItem(ItemsIds.TORCH, chara)) {
                return NEED_ITEMS;
            }
            return OK;
        };

        place.possibleBattles.put(BattlesIds.SAND_GOLEM_1, 19);
        place.possibleBattles.put(BattlesIds.CRAWLING_WORM_2, 16);

        place.npcs.add(NpcsIds.MYSTIC_ROCK);

        return place;
    }
}
