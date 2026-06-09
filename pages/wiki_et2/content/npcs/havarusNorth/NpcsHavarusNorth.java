package com.cnx.endlesstalestwo.data.npcs.havarusNorth;

import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.cemetery.Brianne;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.farmland.Helinda;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.farmland.HingusAtFarmland;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.farmland.Larien;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.greatRock.CasielPeak;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.greatRock.Martin;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.letow.Elisa;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.letow.Johanna;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.letow.LordDenFalker;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.letow.inn.Mirjana;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.Falasy;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.SirJardBrant;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.barracks.Guzar;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.castle.LadyJade;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.castle.Priany;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.castle.QueenEnola;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.clockTower.Hingus;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.docks.CaptainNorman;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.docks.Hildo;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.forge.Morkus;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.gates.James;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.lake.William;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.library.Hafanne;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.library.Maximilian;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.library.NeleraMonelixLibrary;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.monelix.tavern.Turwald;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.plainsOfNorth.Phil;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.prison.Brinn;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.prison.Jerome;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.swampIsland.fortress.Galdor;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.swampIsland.fortress.Fargus;
import com.cnx.endlesstalestwo.data.npcs.havarusNorth.swampIsland.GhostDmitri;

public class NpcsHavarusNorth extends DataHelper {

    @Override
    public void generate() {
        new Johanna().generate();//
        new Guzar().generate();//
        new QueenEnola().generate();//
        new Elisa().generate();//
        new Turwald().generate();//
        new Priany().generate();//
        new Morkus().generate();//
        new SirJardBrant().generate();//
        new Galdor().generate();//
        new Fargus().generate();//
        new GhostDmitri().generate();//
        new Mirjana().generate();//
        new LordDenFalker().generate();//
        new Brinn().generate();//
        new Jerome().generate();//
        new Larien().generate();//
        new Helinda().generate();//
        new HingusAtFarmland().generate();//
        new Falasy().generate();//
        new CaptainNorman().generate();//
        new Brianne().generate();//
        new James().generate();//
        new William().generate();//
        new Phil().generate();//
        new LadyJade().generate();//
        new Hildo().generate();//
        new Martin().generate();//
        new CasielPeak().generate();//
        new Hafanne().generate();//
        new NeleraMonelixLibrary().generate();//
        new Maximilian().generate();//
        new Hingus().generate();//
    }
}
