package com.cnx.endlesstalestwo.data.locations.gybralar;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.battles.BattlesIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.entities.Place;
import com.cnx.endlesstalestwo.enums.Enums;

public class Places extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.PLACE, mysteriousDugHole());//
        App.DataManager.add(Enums.DataTypes.PLACE, brownRoomOfElfGoddess());//
    }

    Place mysteriousDugHole() {
        Place place = new Place("Mysterious Dug Hole", LocationsIds.GYBRALAR_FOREST_INNER);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Buraco Misterioso");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Agujero Misterioso");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Upon entering the hole, you soon realize it's a narrow tunnel with no lighting, except for a bluish fire torch at the very end. There's nothing but earth, some stones, and a few plant roots.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ao entrar no buraco, logo percebe-se que é um túnel estreito sem iluminação, exceto por uma tocha de fogo azulado bem ao fundo. Não há nada além de terra, umas pedras e algumas raízes de plantas.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Al entrar en el agujero, pronto te das cuenta de que es un túnel estrecho sin iluminación, excepto por una antorcha de fuego azulado al fondo. No hay nada más que tierra, algunas piedras y algunas raíces de plantas.");

        place.resetId("FOREST_MYSTERIOUS_DUG_HOLE");
        place.type = Enums.LocationTypes.CAVERN;
        place.places.add(LocationsIds.BROWN_ROOM_OF_ELF_GODDESS);

        place.possibleBattles.put(BattlesIds.MEDUSA_1, 8);

        return place;
    }

    Place brownRoomOfElfGoddess() {
        Place place = new Place("Brown Room of Elf Goddess", LocationsIds.FOREST_MYSTERIOUS_DUG_HOLE, true);
        place.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sala Marrom da Deusa Elfa");
        place.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sala Marrón de la Diosa Elfa");

        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A small room with oval-shaped stone walls. In the center at the back is a statue of an elf goddess and beside it are two torches with blue magical fire.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma salinha com paredes de pedra em formato oval. No centro ao fundo está uma estátua de uma deusa elfa e do seu lado estão duas tochas com fogo mágico azul.");
        place.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una pequeña habitación con paredes de piedra de forma ovalada. En el centro, al fondo, hay una estatua de una diosa elfa y a su lado hay dos antorchas con fuego mágico azul.");

        place.type = Enums.LocationTypes.DUNGEON;

        place.npcs.add(NpcsIds.ELF_GODDESS_STATUE);

        return place;
    }
}
