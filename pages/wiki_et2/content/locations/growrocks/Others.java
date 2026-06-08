package com.cnx.endlesstalestwo.data.locations.growrocks;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.battles.BattlesIds;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.regions.RegionsIds;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Others extends DataHelper {

    //TRADUZIR
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, longCaveTrail());//
        App.DataManager.add(Enums.DataTypes.LOCALE, gatesOfGrowrocks());//
        App.DataManager.add(Enums.DataTypes.LOCALE, growrocksInterior());//
        App.DataManager.add(Enums.DataTypes.LOCALE, growrocksTempleEntrance());//
        App.DataManager.add(Enums.DataTypes.LOCALE, templeRoad());//
        App.DataManager.add(Enums.DataTypes.LOCALE, oreWay());//
        App.DataManager.add(Enums.DataTypes.LOCALE, oreFortressEntrance());//
        App.DataManager.add(Enums.DataTypes.LOCALE, oreFortress());//
        App.DataManager.add(Enums.DataTypes.LOCALE, oreFortressFloor1());//
        App.DataManager.add(Enums.DataTypes.LOCALE, oreFortressFloor2());//
    }

    Locale longCaveTrail() {
        Locale locale = new Locale("Long Cave Trail", RegionsIds.GROWROCKS);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Trilho Longo da Caverna");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sendero Largo de la Cueva");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A long stretch of path inside a wide cave corridor. The side walls are made of earth and stones. A few stalagmites and few creeping plants complete the environment. Sounds easily echo along the cave path and there is some torches along the way.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um longo trecho de caminho dentro de um amplo corredor de caverna. Os muros das laterais são feitos de terra e pedras. Poucas estalagmites e poucas plantas rasteiras completam o ambiente. O som ecoa facilmente pelo trilho da caverna e há algumas tochas pelo caminho.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un largo tramo de sendero dentro de un amplio corredor de cueva. Las paredes laterales son de tierra y piedras. Unas estalagmitas y algunas plantas bajas completan el paisaje. El sonido resuena con facilidad a lo largo del sendero de la cueva, y hay algunas antorchas a lo largo del camino.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.actions.add(ActionsIds.MINING_BASIC);

        locale.npcs.add(NpcsIds.MYSTIC_ROCK_AT_TRAIL);

        locale.possibleBattles.put(BattlesIds.CORRUPTED_WIZARD_1, 14);
        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_2, 13);

        locale.type = Enums.LocationTypes.ROAD;
        locale.musicFile = "growrocks_ambient";

        return locale;
    }

    Locale gatesOfGrowrocks() {
        Locale locale = new Locale("Gates of Growrocks", RegionsIds.GROWROCKS);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Portões de Growrocks");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Puertas de Growrocks");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A long iron fence runs from one side of the wide cave corridor to the other. On one side is a small stone watchtower. Centered in the middle of the grate is a large, simple gate, also made of iron. To the southeast, beyond the gate, is a gigantic, spacious cave chamber.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma longa grade de ferro que vai de um lado a outro do amplo corredor da caverna. Em uma das laterais há uma pequena torre de vigia de pedra. Centralizado ao meio das grades está um portão grande e simples, também de ferro. A sudeste, após o portão, há uma câmara de caverna gigantesca e espaçosa.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una larga reja de hierro que va de un lado al otro del amplio corredor de la cueva. En uno de los lados hay una pequeña torre de vigilancia de piedra. Centrado en medio de las rejas hay un portón grande y simple, también de hierro. Al sureste, más allá del portón, hay una cámara de cueva gigantesca y espaciosa.");

        locale.npcs.add(NpcsIds.DWARF_SOLDIER);

        locale.type = Enums.LocationTypes.ROAD;
        locale.musicFile = "growrocks_ambient";

        return locale;
    }

    Locale growrocksInterior() {
        Locale locale = new Locale("Growrocks Interior", RegionsIds.GROWROCKS);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Interior de Growrocks");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Interior de Growrocks");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A large space within the endless cavern of Growrocks. There are several rocks on the floor, but most of the floor is smooth. In the distance, a citadel with red roofs can be seen. A few stalagmites, dry trees, small plants and even some rodents are present.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um espaço amplo dentro da interminável caverna de Growrocks. Há diversas pedras pelo chão, mas a maioria do piso é liso. A distância é possível ver uma cidadela com telhados vermelhos. Algumas poucas estalagmites, árvores secas, pequenas plantas e até alguns roedores estão presentes.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un espacio amplio dentro de la interminable caverna de Growrocks. Hay varias rocas en el suelo, pero la mayoría del piso es liso. A lo lejos se puede ver una ciudadela con techos rojos. Algunas estalagmitas, árboles secos, pequeñas plantas e incluso algunos roedores están presentes.");

        locale.actions.add(ActionsIds.GATHERING_BASIC);
        locale.actions.add(ActionsIds.HUNT_BASIC);

        locale.type = Enums.LocationTypes.CAVERN;
        locale.musicFile = "growrocks_ambient";

        // Access only granted after Dwarf Soldier permits entry (Part 7 of People of The Depths quest)
        locale.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS, 6) ||
                    LibQuest.isQuestComplete(chara, QuestsIds.PEOPLE_OF_THE_DEPTHS)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        return locale;
    }

    Locale growrocksTempleEntrance() {
        Locale locale = new Locale("Growrocks Temple - Entrance", RegionsIds.GROWROCKS);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Templo de Growrocks - Entrada");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Templo de Growrocks - Entrada");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Before entering the temple there is a sort of elevated courtyard. A staircase with few steps leads up to a rise made of smooth stones. A corridor with pillars leads to the stone door of the great temple, which is made of darker stones and has a reddish roof.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Antes de entrar no templo há uma espécie de pátio elevado. Uma escada com poucos degraus leva até uma elevação feita com pedras lisas. um corredor com pilares guia até a porta de pedra do grande templo, que é feito com pedras mais escuras e telhado avermelhado.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Antes de entrar al templo hay una especie de patio elevado. Una escalera con pocos escalones lleva hasta una elevación hecha con piedras lisas. Un corredor con pilares guía hasta la puerta de piedra del gran templo, que está hecho con piedras más oscuras y techo rojizo.");

        locale.type = Enums.LocationTypes.ROAD;
        locale.musicFile = "growrocks_ambient";

        return locale;
    }

    Locale templeRoad() {
        Locale locale = new Locale("Temple Road", RegionsIds.GROWROCKS);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Rua do Templo");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Calle del Templo");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Amidst the vast expanse of the cave, you can notice a trail marked on the floor by the wear and tear caused by years and years of people walking the same path. This deserted path connects the dwarven city to their temple.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Em meio a grande amplitude da caverna, você pode notar um trilho marcado no chão pelo desgaste causado por anos e anos de pessoas a caminhar pelo mesmo trajeto. Esse caminho ermo liga a cidade dos anões ao templo deles.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En medio de la gran amplitud de la cueva, puedes notar un sendero marcado en el suelo por el desgaste causado por años y años de personas caminando por el mismo trayecto. Este camino desolado conecta la ciudad de los enanos con su templo.");

        locale.type = Enums.LocationTypes.ROAD;
        locale.musicFile = "growrocks_ambient";

        return locale;
    }

    Locale oreWay() {
        Locale locale = new Locale("Ore Way", RegionsIds.GROWROCKS);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caminho do Minério");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Camino del Mineral");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "As you exit the city to the north, you find yourself on a long road made for people and ore carts. There are a few large rocks and a few dry trees amidst the smooth, reddish-brown floor of the cave. At the end of the track is the large entrance to the dwarven mining cave.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ao sair pelo norte da cidade você se vê em uma longa estrada feita para pessoas e carrinhos de minério. Existem algumas pedras grandes e poucas árvores secas em meio ao chão marrom avermelhado e liso da caverna. Ao fim do trilho está a grande entrada para a caverna de mineração dos anões.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Al salir por el norte de la ciudad te encuentras en una larga carretera hecha para personas y carretas de mineral. Hay algunas rocas grandes y pocos árboles secos en medio del suelo marrón rojizo y liso de la cueva. Al final del sendero está la gran entrada a la cueva de minería de los enanos.");

        locale.type = Enums.LocationTypes.ROAD;
        locale.musicFile = "growrocks_ambient";

        locale.possibleBattles.put(BattlesIds.CORRUPTED_WIZARD_1, 14);
        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_2, 13);

        return locale;
    }

    Locale oreFortressEntrance() {
        Locale locale = new Locale("Ore Fortress - Entrance", RegionsIds.GROWROCKS);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forte do Minério - Entrada");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Fortaleza del Mineral - Entrada");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "You are in front of a reddish-brown earth wall that has a large entrance in its center with a kind of dark stone frame. Two large torches illuminate this entrance that is lined with wheelbarrows, piles of stones and mining tools.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Está em frente a um paredão de terra marrom avermelhada que em seu centro possui uma grande entrada com uma espécie de moldura de pedra escura. Duas grandes tochas iluminam essa entrada que é roadeada com carrinhos de mão, pilhas de pedras e ferramentas de mineração.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Estás frente a una pared de tierra marrón rojizo que en su centro tiene una gran entrada con una especie de marco de piedra oscura. Dos grandes antorchas iluminan esta entrada que está rodeada de carretillas, pilas de piedras y herramientas de minería.");

        locale.type = Enums.LocationTypes.ROAD;
        locale.musicFile = "growrocks_ambient";

        return locale;
    }

    Locale oreFortress() {
        Locale locale = new Locale("Ore Fortress", RegionsIds.GROWROCKS);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forte do Minério");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Fortaleza del Mineral");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "After a relatively long corridor, you arrive at a large, tall chamber with brown and gray stone walls. The room is organized, with boxes and mining tools neatly stacked and stored. There are narrow tracks for mining carts that lead into corridors. Some dwarves work and others stand guard.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Depois de um corredor relativamente comprido, você chega a uma câmara ampla e alta com paredes de pedras marrom e cinzentas. O ambiente é organizado, com caixas e ferramentas de mineração bem empilhadas e guardadas. Há trilhos estreitos para carrinhos de mineração que seguem para dentro de corredores. Alguns anões trabalham e outros fazem guarda.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Después de un corredor relativamente largo, llegas a una cámara amplia y alta con paredes de piedras marrones y grises. El ambiente está organizado, con cajas y herramientas de minería bien apiladas y guardadas. Hay rieles estrechos para carretas de minería que van hacia corredores. Algunos enanos trabajan y otros hacen guardia.");

        locale.actions.add(ActionsIds.MINING_BASIC);

        locale.possibleBattles.put(BattlesIds.CAVE_BAT_2, 30);
        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_1, 16);

        locale.npcs.add(NpcsIds.ELLIOT_SHINEFINGERS);

        locale.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isQuestComplete(chara, QuestsIds.THE_DWARVEN_CITY)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_VARIABLES;
        };

        locale.type = Enums.LocationTypes.CAVERN;
        locale.alwaysShow = true;

        return locale;
    }

    Locale oreFortressFloor1() {
        Locale locale = new Locale("Ore Fortress - Floor -1", RegionsIds.GROWROCKS);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forte do Minério - Andar -1");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Fortaleza del Mineral - Piso -1");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Following one of the tracks, you reached a long wooden staircase that took you to the lower floor. Here there are still some dwarves working and keeping watch, but it is noticeable that the environment is more closed, dark and dangerous. Only a small ore track runs from one side to the other of the enormous chamber that forms this floor.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Seguindo um dos trilhos, você chegou a uma escada longa de madeira que lhe levou ao piso inferior. Aqui ainda há alguns anões trabalhando e fazendo guarda, mas é perceptível que o ambiente é mais fechado, escuro e perigoso. Somente um pequeno trilho de minério corre de um lado a outro da enorme câmara que forma este andar.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Siguiendo uno de los rieles, llegaste a una larga escalera de madera que te llevó al piso inferior. Aquí todavía hay algunos enanos trabajando y haciendo guardia, pero es perceptible que el ambiente es más cerrado, oscuro y peligroso. Solo un pequeño riel de mineral corre de un lado a otro de la enorme cámara que forma este piso.");

        locale.actions.add(ActionsIds.MINING_EXTRA);

        locale.possibleBattles.put(BattlesIds.CAVE_BAT_2, 22);
        locale.possibleBattles.put(BattlesIds.CRAWLING_WORM_2, 20);
        locale.possibleBattles.put(BattlesIds.SKELETON_GUARDIAN_1, 25);
        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_FIRE_1, 18);

        locale.type = Enums.LocationTypes.CAVERN;

        return locale;
    }

    Locale oreFortressFloor2() {
        Locale locale = new Locale("Ore Fortress - Floor -2", RegionsIds.GROWROCKS);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Forte do Minério - Andar -2");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The ore cart track leads down a narrow corridor and into this very dark, damp floor. The ceiling is low, but the room is long and wide. Only a few lanterns illuminate this part of the cavern. The dwarves only mine here on special occasions, for the creatures that lurk in the crevices of the rocks are fearsome.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O trilho de carrinhos de minério desce por um corredor estreito e chega neste andar muito escuro e úmido. O teto é mais baixo mas a sala é comprida e larga. Somente algumas poucos lampiões iluminam esta parte da caverna. Aqui os anões só mineram em ocasiões específicas, pois as criaturas que se espreitam nas brechas das rochas são terríveis.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El riel de carretas de mineral desciende por un corredor estrecho y llega a este piso muy oscuro y húmedo. El techo es más bajo pero la sala es larga y ancha. Solo algunas lámparas iluminan esta parte de la cueva. Aquí los enanos solo extraen en ocasiones especiales, pues las criaturas que acechan en las grietas de las rocas son temibles.");

        locale.actions.add(ActionsIds.MINING_RARE);

        locale.npcs.add(NpcsIds.TRAUS_SHINEFINGERS);

        locale.possibleBattles.put(BattlesIds.SUCCUBUS_1, 30);
        locale.possibleBattles.put(BattlesIds.SKELETON_GUARDIAN_1, 25);
        locale.possibleBattles.put(BattlesIds.SPIRIT_OF_FIRE_1, 28);

        locale.type = Enums.LocationTypes.CAVERN;
        locale.alwaysShow = true;

        locale.requirementValidations = (chara, ctx) -> {
            if (LibInventory.checkHasItem(ItemsIds.TORCH, chara)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_ITEMS;
        };

        return locale;
    }
}

