package com.cnx.endlesstalestwo.data.locations.ayalon;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.entities.Place;
import com.cnx.endlesstalestwo.enums.Enums;

public class Places extends DataHelper {
    //TRADUZIR
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.PLACE, elvenCitySquare());//
        App.DataManager.add(Enums.DataTypes.PLACE, castleOfAyalon());//
        App.DataManager.add(Enums.DataTypes.PLACE, elvenTemple());//
        App.DataManager.add(Enums.DataTypes.PLACE, herbalistsGarden());//
        App.DataManager.add(Enums.DataTypes.PLACE, wiseElfsLibrary());//
    }

    Place elvenCitySquare() {
        Place place = new Place("Elven City Square", LocationsIds.ELVEN_CITADEL);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Praça da Cidade Élfica");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Plaza de la Ciudad Elfa");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "In the middle of the citadel, there is a spacious park surrounded by a low wall and entrances on all 4 sides. Some small trees and flowers are in the flowerbeds. There are some stone benches and decorated lighting torches. The elves also use this square to hold their parties.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Em meio há cidadela, há um espaçoso parque cercado por um muro baixo e entradas pelos 4 lados. Algumas pequenas árvores e flores estão nos canteiros. Há alguns bancos de pedra e tochas de iluminação decorados. Os elfos também usam esta praça para realizar suas festas.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En medio de la ciudadela, hay un espacioso parque rodeado por un muro bajo y entradas por los 4 lados. Algunos pequeños árboles y flores están en los macizos de flores. Hay algunos bancos de piedra y antorchas de iluminación decoradas. Los elfos también usan esta plaza para realizar sus fiestas.");

        place.actions.add(ActionsIds.HELP_PEOPLE);

        place.npcs.add(NpcsIds.CASIEL);
        place.npcs.add(NpcsIds.NARIV);

        place.type = Enums.LocationTypes.ROAD;
        return place;
    }

    Place castleOfAyalon() {
        Place place = new Place("Castle of Ayalon", LocationsIds.ELVEN_CITADEL);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Castelo de Ayalon");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Castillo de Ayalon");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A Beautiful castle. The interior is spacious and well decorated. There are light green and blue tapestries, plants in white pots. The pillars in the castle corridors are decorated with small gold details. The throne room is at the back and is open.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma bela cidade precisa de um belo castelo. O interior é amplo e bem decorado. Há tapeçarias verdes e azuis claras, plantas em vasos brancos. Os pilares dos corredores do castelo são ornamentados com pequenos detalhes dourados. A sala do trono fica ao fundo e é aberta.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un hermoso castillo. El interior es espacioso y está bien decorado. Hay tapices de color verde claro y azul, plantas en macetas blancas. Los pilares de los pasillos del castillo están decorados con pequeños detalles dorados. La sala del trono está al fondo y está abierta.");

        place.npcs.add(NpcsIds.EMPEROR_ARILAS);

        place.type = Enums.LocationTypes.CASTLE;

        return place;
    }

    Place elvenTemple() {
        Place place = new Place("Elven Temple", LocationsIds.ELVEN_CITADEL);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Templo Élfico");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Templo Élfico");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The interior of this temple has a few white wooden benches positioned around a central altar. The subtle gold and green decorations make the place even more beautiful. On the wall at the back there is a sculpture of the goddess of the elves. The temple is well lit by small torches on the walls.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O interior deste templo conta com alguns bancos de madeira branca posicionados em volta de um altar que está centralizado. As sutis decorações douradas e verdes deixam o local mais belo. Na parede ao fundo há uma escultura da deusa dos elfos. O templo é bem iluminado por pequenas tochas nas paredes.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El interior de este templo tiene algunos bancos de madera blanca colocados alrededor de un altar central. Las sutiles decoraciones doradas y verdes hacen que el lugar sea aún más hermoso. En la pared del fondo hay una escultura de la diosa de los elfos. El templo está bien iluminado por pequeñas antorchas en las paredes.");

        place.npcs.add(NpcsIds.GISELA);

        place.type = Enums.LocationTypes.BUILDING;

        return place;
    }

    Place herbalistsGarden() {
        Place place = new Place("Herbalists Garden", LocationsIds.ELVEN_CITADEL);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Jardim dos Herboristas");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Jardín de los Herbolarios");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Outside, which is surrounded by a small stone wall, there are small vegetable gardens with herbs and plants. Inside the house there are shelves with pots of flowers and herbs. The roof is one of the few in the city that is not made of stone but of straw. Inside, on the left side there is a large work table for mixing potions and in a small room at the back there is also a rustic kitchen for preparing banquets.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Do lado externo, que é cercado por um pequeno muro de pedras, há pequenas hortas com ervas e plantas. Dentro da casa há prateleiras com vasos de flores e ervas. O telhado é um dos poucos da cidade que não é de pedras e sim de palha. Internamente, do lado esquerdo há uma grande mesa de trabalho para mistura de poções e numa pequena sala ao fundo há também uma cozinha rústica para preparos de banquetes.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En el exterior, que está rodeado por un pequeño muro de piedra, hay pequeños huertos con hierbas y plantas. Dentro de la casa hay estantes con macetas de flores y hierbas. El techo es uno de los pocos de la ciudad que no es de piedra sino de paja. En el interior, en el lado izquierdo, hay una gran mesa de trabajo para mezclar pociones y en una pequeña habitación al fondo también hay una cocina rústica para preparar banquetes.");

        place.actions.add(ActionsIds.CRAFT_ALCHEMY);
        place.actions.add(ActionsIds.COOKING);

        place.npcs.add(NpcsIds.SALILAS);

        place.type = Enums.LocationTypes.BUILDING;
        return place;
    }

    Place wiseElfsLibrary() {
        Place place = new Place("Wise Elfs Library", LocationsIds.ELVEN_CITADEL);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Biblioteca dos Elfos Sábios");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Biblioteca de los Elfos Sabios");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The place is impressive and quiet. The building with its clear color walls is neither long nor wide, but rather tall, with several floors. Each floor is accessible by a wide wooden staircase and has decorated shelves that separate the books by category. The lighting of the place is not done by torchlight but by some magic that provides light.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O local é impressionante e silencioso. O prédio de paredes claras não é comprido nem largo, mas sim alto, possui diversos andares. Cada andar é acessível por uma ampla escada de madeira e possui prateleiras decoradas que separam os livros por categoria. A iluminação do local não é feita com fogo de tochas mas sim com alguma magia que fornece claridade.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El lugar es impresionante y tranquilo. El edificio, con sus paredes de colores claros, no es largo ni ancho, sino alto, con varios pisos. Se puede acceder a cada piso por una amplia escalera de madera y tiene estanterías decoradas que separan los libros por categoría. La iluminación del lugar no se realiza con luz de antorchas, sino con algún tipo de magia que proporciona luz.");

        place.npcs.add(NpcsIds.BAROLAS);
        place.npcs.add(NpcsIds.NELERA_LIBRARY);

        place.type = Enums.LocationTypes.BUILDING;

        return place;
    }
}
