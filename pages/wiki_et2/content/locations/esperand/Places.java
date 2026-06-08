package com.cnx.endlesstalestwo.data.locations.esperand;

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
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.entities.Place;
import com.cnx.endlesstalestwo.enums.Enums;

public class Places extends DataHelper {

    //TRADUZIR
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.PLACE, esperandWatchTower());//
        App.DataManager.add(Enums.DataTypes.PLACE, watchTowerTop());//
        App.DataManager.add(Enums.DataTypes.PLACE, icyCaveRitualPlace());//
        App.DataManager.add(Enums.DataTypes.PLACE, esperandTavern());//
        App.DataManager.add(Enums.DataTypes.PLACE, esperandCityHall());//
        App.DataManager.add(Enums.DataTypes.PLACE, esperandInn());
        App.DataManager.add(Enums.DataTypes.PLACE, churchOfHope());//
        App.DataManager.add(Enums.DataTypes.PLACE, monasteryRooms());//
    }

    Place esperandWatchTower() {
        Place place = new Place("Esperand Watch Tower", LocationsIds.ESPERAND_WATCH_TOWER_ENTRANCE);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Torre de Vigia de Esperand");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Torre de Vigilancia de Esperand");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Internally, the base of the tower is simple. Two torches on each side illuminate the room, which has a table with 4 chairs, some crates, a stone sink with water and a small fireplace.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Internamente, a base da torre é simples. Duas tochas em cada lado iluminam a sala, que possui uma mesa com 4 cadeiras, alguns caixotes, uma pia de pedra com água e uma lareira pequena.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Internamente, la base de la torre es simple. Dos antorchas en cada lado iluminan la habitación, que tiene una mesa con 4 sillas, algunas cajas, un fregadero de piedra con agua y una pequeña chimenea.");

        place.places.add(LocationsIds.ESPERAND_WATCH_TOWER_TOP);

        place.type = Enums.LocationTypes.TOWER;
        return place;
    }

    Place watchTowerTop() {
        Place place = new Place("Watch Tower - Top", LocationsIds.ESPERAND_WATCH_TOWER, true);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Torre de Vigia - Topo");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Torre de Vigía - Cima");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "After climbing a few flights of stairs, you reach the top. There are large openings for observing the outside environment. There is a small firepit in the center and two benches on the sides. The ceiling made of planks is painted blue and forms a kind of peak.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Após subir alguns lances de escada você chega no topo. Há aberturas grandes para observação do ambiente externo. Há uma pequena pira no centro e dois bancos nas laterais. O teto feito de tábuas é pintado de azul e forma uma espécie de ponta.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Después de subir unos tramos de escaleras, se llega a la cima. Hay grandes aberturas para observar el entorno exterior. Hay un pequeño brasero en el centro y dos bancos en los laterales. El techo hecho de tablones está pintado de azul y forma una especie de pico.");

        place.imgFile = "locale_esperand_watch_tower_top";

        place.resetId("ESPERAND_WATCH_TOWER_TOP");

        place.npcs.add(NpcsIds.VINNY);

        place.type = Enums.LocationTypes.TOWER;
        return place;
    }

    Place icyCaveRitualPlace() {
        Place place = new Place("Icy Cave - Ritual Place", LocationsIds.ICY_CAVE_FLOOR_2);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caverna Congelada - Local Ritual");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cueva Helada - Lugar Ritual");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A small chamber at the end of a dark cave corridor. Inside is a stone altar with candles and vessels on top. There is also a small stool and an empty chest. On the wall opposite the altar are several paintings and strange markings.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma pequena câmara ao fundo de um corredor escuro da caverna. Dentro há um altar de pedra com velas e vasilhas em cima. Há também um banquinho e um báu vazio. Na parede em frente ao altar há diversas pinturas e marcas estranhas.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una pequeña cámara al final de un oscuro corredor de la cueva. En el interior hay un altar de piedra con velas y vasijas encima. También hay un pequeño taburete y un cofre vacío. En la pared opuesta al altar hay varias pinturas y extrañas marcas.");

        place.possibleBattles.put(BattlesIds.CORRUPTED_WIZARD_1, 19);

        place.type = Enums.LocationTypes.DUNGEON;

        return place;
    }

    Place esperandTavern() {
        Place place = new Place("Tavern", LocationsIds.ESPERAND);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Taberna");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Taberna");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_TAVERN_DESCRIPTION_ENGLISH + " A fireplace helps to keep the warm inside.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_TAVERN_DESCRIPTION_PORTUGUESE + " Uma lareira ajuda a manter o calor interno..");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_TAVERN_DESCRIPTION_SPANISH + " Una chimenea ayuda a mantener el calor adentro.");

        place.actions.add(ActionsIds.COOKING);

        place.resetId("ESPERAND_TAVERN");
        place.imgFile = "locale_esperand_tavern";

        place.type = Enums.LocationTypes.TAVERN;
        return place;
    }

    Place esperandInn() {
        Place place = new Place("Inn", LocationsIds.ESPERAND);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pousada");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Posada");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, DEFAULT_INN_DESCRIPTION_ENGLISH);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, DEFAULT_INN_DESCRIPTION_PORTUGUESE);
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, DEFAULT_INN_DESCRIPTION_SPANISH);

        place.actions.add(ActionsIds.REST);

        place.resetId("ESPERAND_INN");

        place.npcs.add(NpcsIds.LAUISY);

        place.type = Enums.LocationTypes.INN;
        return place;
    }

    Place esperandCityHall() {
        Place place = new Place("Esperand City Hall", LocationsIds.ESPERAND);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Prefeitura de Esperand");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Ayuntamiento de Esperand");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A long building made of beautiful stone, with a large entrance hall. Some suits of armor are on display. There are a few smaller rooms where the people who run Esperand work. This is not a city ruled by a king, but by a representative chosen by the people.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um prédio longo feito com belas pedras, com um grande salão de entrada. Algumas armaduras estão a mostra. Há algumas salas menores onde trabalham as pessoas que administram Esperand. Esta não é uma cidade regida por um rei, mas por um representante escolhido pelo povo.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un edificio largo hecho de hermosa piedra, con un gran hall de entrada. Se exhiben algunas armaduras. Hay algunas habitaciones más pequeñas donde trabajan las personas que dirigen Esperand. Esta no es una ciudad gobernada por un rey, sino por un representante elegido por el pueblo.");

        place.npcs.add(NpcsIds.LORD_MUKAS_WINTAR);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place churchOfHope() {
        Place place = new Place("Church of Hope", LocationsIds.ESPERAND);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Igreja da Esperança");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Iglesia de la Esperanza");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The church is built with large stones and the roof is made of logs. There are several pillars to support the structure. The windows feature saints and candles illuminate the sacred decoration. There are about 10 pairs of wooden benches and some tapestries that make the church very beautiful.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A igreja é construída com pedras largas e o telhado é feito com toras. Há diversos pilares para sustentar a estrutura. Os vidros estampam santos e as velas iluminam a decoração sagrada. Há cerca de 10 pares de bancos de madeira e alguma tapeçaria que deixa a igreja muito bela.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La iglesia está construida con grandes piedras y el techo está hecho de troncos. Hay varios pilares para sostener la estructura. Las ventanas representan santos y las velas iluminan la decoración sagrada. Hay alrededor de 10 pares de bancos de madera y algunos tapices que hacen que la iglesia sea muy hermosa.");

        place.type = Enums.LocationTypes.BUILDING;

        place.npcs.add(NpcsIds.PRIEST_ALEC);
        place.npcs.add(NpcsIds.VALANYA_CHURCH);

        place.actions.add(ActionsIds.HELP_PEOPLE);
        return place;
    }

    Place monasteryRooms() {
        Place place = new Place("Monastery Rooms", LocationsIds.MONASTERY_GARDEN);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Quartos do Monastério");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Habitaciones del Monasterio");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The corridors are not very wide, but they have several doors leading to the rooms of the inmates and the priests. Most of the rooms are the same, a bed, a chair, a shelf and a desk, the only difference is the decoration that each person adds to their room.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Os corredores não são muito largos, mas possuem diversas portas para os quartos dos internos e dos sacerdotes. A maioria dos quartos é igual, uma cama, uma cadeira, uma prateleira e uma escrivaninha, o que difere é a decoração que cada um adiciona ao seu quarto.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Los pasillos no son muy anchos, pero tienen varias puertas que dan a las habitaciones de los internos y los sacerdotes. La mayoría de las habitaciones son iguales, una cama, una silla, una estantería y un escritorio, la única diferencia es la decoración que cada persona añade a su habitación.");

        place.npcs.add(NpcsIds.PRIEST_SARISEUS);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

}
