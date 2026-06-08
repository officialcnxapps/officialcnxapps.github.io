package com.cnx.endlesstalestwo.data.locations.growrocks;

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
        App.DataManager.add(Enums.DataTypes.PLACE, dwarvenTavern());//
        App.DataManager.add(Enums.DataTypes.PLACE, dwarvenForge());//
        App.DataManager.add(Enums.DataTypes.PLACE, dwarvenBarracks());//
        App.DataManager.add(Enums.DataTypes.PLACE, growrocksTemple());//
        App.DataManager.add(Enums.DataTypes.PLACE, dwarvenMinersAssociation());//
        App.DataManager.add(Enums.DataTypes.PLACE, vegetablesGardens());//
    }

    Place dwarvenTavern() {
        Place place = new Place("Tavern", LocationsIds.DWARVEN_CITY);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Taberna");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Taberna");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The atmosphere seems fun and cozy, except for the loud voices of the dwarves talking, singing and shouting.\nEverything is made of stone, from the bar counter to the round tables and benches in this tavern. There are only two colored stained glass windows, one on each side of the large entrance door.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O ambiente parece divertido e aconchegante, exceto pelas vozes altas dos anões a falar, cantar e gritar.\nTudo é feito de pedras, desde o balcão do bar até as mesas redondas e bancos desta taberna. Há apenas dois vitrôs coloridos, um em cada lado da porta grande da entrada.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El ambiente parece divertido y acogedor, excepto por las voces altas de los enanos hablando, cantando y gritando.\nTodo está hecho de piedras, desde la barra hasta las mesas redondas y bancos de esta taberna. Solo hay dos vitrales de colores, uno a cada lado de la gran puerta de entrada.");

        place.type = Enums.LocationTypes.TAVERN;

        place.resetId("DWARVEN_TAVERN");
        place.imgFile = "locale_dwarven_tavern";

        place.npcs.add(NpcsIds.ERIN_BARKSKIN);
        place.npcs.add(NpcsIds.POURIN_BARKSKIN);

        place.actions.add(ActionsIds.COOKING);

        return place;
    }

    Place dwarvenForge() {
        Place place = new Place("Dwarven Forge", LocationsIds.DWARVEN_CITY);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forja dos Anões");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Forja de los Enanos");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It's probably the largest forge you've ever been to. The space is large, with 2 large workbenches in the center and 3 ore-melting furnaces in the back. All sorts of tools are hung on the walls. Chests and boxes store ores in an organized manner.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É provavelmente a maior forja que você já esteve. O espaço é amplo, há 2 grandes bancadas de trabalho no centro e 3 fornos de derretimento de minério ao fundo. Nas paredes há todos tipos de ferramentas penduradas. Baús e caixas guardam minérios de forma organizada.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es probablemente la forja más grande en la que has estado. El espacio es amplio, con 2 grandes mesas de trabajo en el centro y 3 hornos para fundir minerales al fondo. En las paredes hay todo tipo de herramientas colgadas. Cofres y cajas almacenan minerales de forma organizada.");

        place.npcs.add(NpcsIds.LUGAG_IRONHAND);

        place.actions.add(ActionsIds.CRAFT_GENERAL);

        place.type = Enums.LocationTypes.FORGE;
        return place;
    }

    Place dwarvenBarracks() {
        Place place = new Place("Dwarven Barracks", LocationsIds.DWARVEN_CITY);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Quartel dos Anões");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cuartel de los Enanos");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A barracks not very large but with enough space for several beds and a large central table. There are few and small windows. At the back there are supports for shields and axes. There are lanterns to maintain basic lighting.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um quartel não muito grande mas com espaço suficiente para diversas camas e uma grande mesa central. Há poucas e pequenas janelas. Ao fundo há suportes para escudos e machados. Há lampiões para manter uma iluminação básica.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un cuartel no muy grande pero con espacio suficiente para varias camas y una gran mesa central. Hay pocas y pequeñas ventanas. Al fondo hay soportes para escudos y hachas. Hay lámparas para mantener una iluminación básica.");

        place.npcs.add(NpcsIds.XAVIER_STRONGARM);

        place.type = Enums.LocationTypes.BUILDING;

        return place;
    }

    Place growrocksTemple() {
        Place place = new Place("Dwarven Temple", LocationsIds.GROWROCKS_TEMPLE_ENTRANCE);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Templo dos Anões");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Templo del Enanos");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "After the stone door, the temple opens into a tall, rectangular building. There are square pillars to support the structure. The benches are made of stone and the decorative tapestry is divided between white and red. The environment is very quiet and lit with hanging torches.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Após a porta de pedra, o templo se abre numa construção alta e retangular. Há pilares quadrados para sustentar a estrutura. Os bancos são feitos com pedras e a tapeçaria de decoração se divide entre branco e vermelho. O ambiente é bem silencioso e iluminado com tochas suspensas.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Después de la puerta de piedra, el templo se abre en un edificio alto y rectangular. Hay pilares cuadrados para sostener la estructura. Los bancos están hechos con piedras y la tapicería decorativa se divide entre blanco y rojo. El ambiente es muy silencioso e iluminado con antorchas colgantes.");

        place.actions.add(ActionsIds.HELP_PEOPLE);

        place.npcs.add(NpcsIds.JANUSA_GODHEAD);
        place.npcs.add(NpcsIds.TRAUS_AT_TEMPLE);

        place.type = Enums.LocationTypes.BUILDING;

        return place;
    }

    Place dwarvenMinersAssociation() {
        Place place = new Place("Dwarven Miners Association", LocationsIds.DWARVEN_CITY);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Associação dos Mineradores Anões");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Asociación de Mineros Enanos");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A large rectangular hall. A large white flag with a red pickaxe hangs in the center just above the large stone table. Important meetings concerning the administration of various aspects of the dwarven city are held here. There are no windows, and lighting is provided by torches on the walls.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um grande salão retangular. Uma grande bandeira branca com uma picareta vermelha está pedurada ao centro logo acima da grande mesa de pedra. Aqui ocorrem reuniões importantes sobre a administração de diversos aspectos da cidade dos anões. Não há janelas e a iluminação é feita por tochas nas paredes.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un gran salón rectangular. Una gran bandera blanca con un pico rojo cuelga en el centro justo encima de la gran mesa de piedra. Aquí se celebran reuniones importantes sobre la administración de varios aspectos de la ciudad de los enanos. No hay ventanas y la iluminación la proporcionan antorchas en las paredes.");

        place.npcs.add(NpcsIds.RICHARD_IRONHAND);

        place.type = Enums.LocationTypes.BUILDING;

        return place;
    }

    Place vegetablesGardens() {
        Place place = new Place("Vegetables Gardens", LocationsIds.DWARVEN_CITY);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Jardins de Vegetais");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Jardines de Vegetales");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Due to the complications of planting inside a cave, the dwarves use a structure made of stones with wooden supports where water constantly runs with the help of a small mill. There are hundreds of cavities where various vegetables are planted. There are also some shelves with pots with edible mushrooms planted.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Devido as complicações para plantar dentro de uma caverna, os anões utilizam uma estrutura feita de pedras com suportes de madeira onde a água corre constantemente com a ajuda de um pequeno moinho. Há centenas de cavidades onde estão vários vegetais plantados.Há também algumas prateleiras com vasos com cogumelos comestíveis plantados.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Debido a las complicaciones de plantar dentro de una cueva, los enanos utilizan una estructura hecha de piedras con soportes de madera donde el agua corre constantemente con la ayuda de un pequeño molino. Hay cientos de cavidades donde se plantan varios vegetales. También hay algunos estantes con macetas con hongos comestibles plantados.");

        place.type = Enums.LocationTypes.BUILDING;

        place.npcs.add(NpcsIds.FIOLA_BROWNHAND);
        place.npcs.add(NpcsIds.LOKI_BROWNHAND);

        return place;
    }

}
