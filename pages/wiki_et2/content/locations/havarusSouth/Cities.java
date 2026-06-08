package com.cnx.endlesstalestwo.data.locations.havarusSouth;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.data.regions.RegionsIds;
import com.cnx.endlesstalestwo.data.shops.ShopsIds;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.enums.Enums;

// TRADUZIR
public class Cities extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, bastian());//
        App.DataManager.add(Enums.DataTypes.LOCALE, fishermanVille());//
        App.DataManager.add(Enums.DataTypes.LOCALE, apenna());//
        App.DataManager.add(Enums.DataTypes.LOCALE, helera());//
        App.DataManager.add(Enums.DataTypes.LOCALE, umera());//
    }

    Locale bastian() {
        Locale locale = new Locale("Bastian", RegionsIds.HAVARUS_SOUTH);

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A very well structured city with stone houses and buildings and narrow streets. Almost all roofs are made with planks and there is no much trees or plantes around. The people walks frenetically from the central market to other buildings. The people here seem very hard-working.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma cidade muito bem estruturada, com casas e edifícios de pedra e ruas estreitas. Quase todos os telhados são feitos com tábuas e não há muitas árvores ou plantas ao redor. As pessoas caminham freneticamente do mercado central para outros edifícios. As pessoas aqui parecem muito trabalhadoras.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una ciudad muy bien estructurada con casas y edificios de piedra y calles estrechas. Casi todos los tejados están hechos con tablones y no hay muchos árboles o plantas alrededor. La gente camina frenéticamente desde el mercado central hacia otros edificios. La gente aquí parece muy trabajadora.");

        locale.actions.add(ActionsIds.HELP_PEOPLE);
        locale.actions.add(ActionsIds.LOOK_FOR_TROUBLE);

        locale.places.add(LocationsIds.BASTIAN_TAVERN);
        locale.places.add(LocationsIds.BASTIAN_FORGE);
        locale.places.add(LocationsIds.BASTIAN_INN);

        locale.shops.add(ShopsIds.TOOLS_STORE);
        locale.shops.add(ShopsIds.JEWELERY);
        locale.shops.add(ShopsIds.POTIONS_MARKET);

        locale.npcs.add(NpcsIds.NELERA);
        locale.npcs.add(NpcsIds.FREDDY);
        locale.npcs.add(NpcsIds.LORD_MARKUS_WINTAR);

        locale.type = Enums.LocationTypes.CITY;
        return locale;
    }

    Locale apenna() {
        Locale locale = new Locale("Apenna", RegionsIds.HAVARUS_SOUTH);

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "This small village is the lair of the woodcutters. The houses are simple but well built, all made of wood. You can count 11 buildings including houses and some commerces. The trees at north creates a cozy scene on this place.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Esta pequena vila é o covil dos lenhadores. As casas são simples, mas bem construídas, todas feitas de madeira. Você pode contar 11 edifícios, incluindo casas e alguns comércios. As árvores ao norte criam uma cena aconchegante neste lugar.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Este pequeño pueblo es la guarida de los leñadores. Las casas son sencillas pero bien construidas, todas de madera. Puedes contar 11 edificios incluyendo casas y algunos comercios. Los árboles al norte crean una escena acogedora en este lugar.");

        locale.places.add(LocationsIds.WOODCUTTERS_WAREHOUSE);

        locale.shops.add(ShopsIds.APENNA_MEAD_ROOM);
        locale.shops.add(ShopsIds.TOOLS_STORE);

        locale.npcs.add(NpcsIds.TERRY);

        locale.type = Enums.LocationTypes.CITY;
        return locale;
    }

    Locale fishermanVille() {
        Locale locale = new Locale("Fisherman Ville", RegionsIds.HAVARUS_SOUTH);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Vila Fisherman");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Villa Fisherman");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A long dock, two warehouses and a few houses built with logs. All those buildings are located very close to the ocean shores. The smell of fish is strong and the seagulls fly around.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um longo cais, dois armazéns e algumas casas construídas com troncos. Todos esses edifícios estão localizados muito perto da costa do oceano. O cheiro de peixe é forte e as gaivotas voam ao redor.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un muelle largo, dos almacenes y algunas casas construidas con troncos. Todos esos edificios están ubicados muy cerca de las costas del océano. El olor a pescado es fuerte y las gaviotas vuelan alrededor.");

        locale.actions.add(ActionsIds.FISHING_EXTRA);

        locale.shops.add(ShopsIds.FISHERMAN_STORE);

        locale.npcs.add(NpcsIds.JACK);
        locale.npcs.add(NpcsIds.DALIA);

        locale.type = Enums.LocationTypes.VILLAGE;
        return locale;
    }

    Locale helera() {
        Locale locale = new Locale("Helera", RegionsIds.HAVARUS_SOUTH);

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "This city is very large, being the largest in the kingdom after Monelix. The city walls are made of brown stone and the houses are made of wood and stone. Most of the streets are covered with cobblestones and at the back near the southern exit there is a very large space where there are several tents for trade.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Essa cidade é muito ampla, sendo a maior do reino depois de Monelix. Os muros da cidade são feitos com pedras marrons e as casas de madeira e pedra. A maioria das ruas é coberta com pequenas pedras e ao fundo perto da saída sul há um espaço muito amplo onde há varias tendas para o comércio.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Esta ciudad es muy grande, siendo la más grande del reino después de Monelix. Las murallas de la ciudad están hechas de piedra marrón y las casas son de madera y piedra. La mayoría de las calles están cubiertas con adoquines y en la parte de atrás, cerca de la salida sur, hay un espacio muy grande donde hay varias tiendas para el comercio.");

        locale.actions.add(ActionsIds.HELP_PEOPLE);

        locale.places.add(LocationsIds.HELERA_CASTLE);
        locale.places.add(LocationsIds.HELERA_GARDENS);
        locale.places.add(LocationsIds.HELERA_INN);
        locale.places.add(LocationsIds.HELERA_TAVERN);
        locale.places.add(LocationsIds.HELERA_HARBOR);
        locale.places.add(LocationsIds.SMITHERS_CLAN);

        locale.shops.add(ShopsIds.FOOD_STORE);
        locale.shops.add(ShopsIds.CRAFTER_POINT);
        locale.shops.add(ShopsIds.POTIONS_MARKET);
        locale.shops.add(ShopsIds.HELERA_GARDEN_TENTS);
        locale.shops.add(ShopsIds.COMMON_STABLE);

        locale.type = Enums.LocationTypes.CITY;
        locale.musicFile = "helera_music";
        return locale;
    }

    Locale umera() {
        Locale locale = new Locale("Umera", RegionsIds.HAVARUS_SOUTH);

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "This village has a comfortable aura. The houses made of rocks and stones and the forest nearby creates a cozy environment even this being a village of miners.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Esta vila tem uma aura confortável. As casas feitas de rochas e pedras e a floresta próxima criam um ambiente aconchegante, mesmo sendo esta uma vila de mineiros.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Este pueblo tiene un aura confortable. Las casas hechas de rocas y piedras y el bosque cercano crean un ambiente acogedor incluso siendo este un pueblo de mineros.");

        locale.places.add(LocationsIds.UMERA_TAVERN);
        locale.places.add(LocationsIds.MINERS_LODGE);

        locale.shops.add(ShopsIds.MINERS_WAREHOUSE);
        locale.shops.add(ShopsIds.THE_GUARDIAN);
        locale.shops.add(ShopsIds.COMMON_STABLE);

        locale.npcs.add(NpcsIds.ELDRIN);

        locale.type = Enums.LocationTypes.VILLAGE;
        return locale;
    }
}
