package com.cnx.endlesstalestwo.data.npcs.lisport;

import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.npcs.lisport.Barracks.John;
import com.cnx.endlesstalestwo.data.npcs.lisport.Barracks.Lenny;
import com.cnx.endlesstalestwo.data.npcs.lisport.BreedersUnion.Alden;
import com.cnx.endlesstalestwo.data.npcs.lisport.Castle.KingOliver;
import com.cnx.endlesstalestwo.data.npcs.lisport.Castle.Murdag;
import com.cnx.endlesstalestwo.data.npcs.lisport.Church.Edward;
import com.cnx.endlesstalestwo.data.npcs.lisport.Church.Elena;
import com.cnx.endlesstalestwo.data.npcs.lisport.Farms.Herald;
import com.cnx.endlesstalestwo.data.npcs.lisport.Farms.Madelaine;
import com.cnx.endlesstalestwo.data.npcs.lisport.Forge.Nubia;
import com.cnx.endlesstalestwo.data.npcs.lisport.Harbor.CptPalmer;
import com.cnx.endlesstalestwo.data.npcs.lisport.Harbor.Joggard;
import com.cnx.endlesstalestwo.data.npcs.lisport.Harbor.Olga;
import com.cnx.endlesstalestwo.data.npcs.lisport.Shores.Klaus;
import com.cnx.endlesstalestwo.data.npcs.lisport.Tavern.Frily;
import com.cnx.endlesstalestwo.data.npcs.lisport.Tavern.Gareth;
import com.cnx.endlesstalestwo.data.npcs.lisport.WestGrove.Paulson;

public class NpcsLisport extends DataHelper {

    @Override
    public void generate() {
        new Erino().generate();
        new Herald().generate();
        new KingOliver().generate();
        new Murdag().generate();
        new Klaus().generate();
        new Lenny().generate();
        new Madelaine().generate();
        new Nubia().generate();
        new John().generate();
        new Joggard().generate();
        new Olga().generate();
        new CptPalmer().generate();
        new Paulson().generate();
        new Edward().generate();
        new Rawer().generate();
        new Alden().generate();
        new Frily().generate();
        new Gareth().generate();
        new Elena().generate();
    }

}
