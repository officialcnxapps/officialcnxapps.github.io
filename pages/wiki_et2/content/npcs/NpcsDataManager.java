package com.cnx.endlesstalestwo.data.npcs;

import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.npcs.ayalon.NpcsAyalon;
import com.cnx.endlesstalestwo.data.npcs.esperand.NpcsEsperand;
import com.cnx.endlesstalestwo.data.npcs.growrocks.NpcsGrowrocks;
import com.cnx.endlesstalestwo.data.npcs.gybralar.NpcsGybralar;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.NpcsHavarusNorth;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.NpcsHavarusSouth;
import com.cnx.endlesstalestwo.data.npcs.lisport.NpcsLisport;
import com.cnx.endlesstalestwo.data.npcs.wazel.NpcsWazel;

public class NpcsDataManager extends DataHelper {
    @Override
    public void generate() {
        new NpcsLisport().generate();
        new NpcsHavarusNorth().generate();
        new NpcsHavarusSouth().generate();
        new NpcsEsperand().generate();
        new NpcsAyalon().generate();
        new NpcsGrowrocks().generate();
        new NpcsGybralar().generate();
        new NpcsWazel().generate();
        new com.cnx.endlesstalestwo.data.npcs.dragonland.Affronis().generate();
        new com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.docks.Messenger().generate();
    }
}
