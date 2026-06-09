package com.cnx.endlesstalestwo.data.npcs.havarusSouth;

import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.apenna.Terry;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.apenna.woodcuttersWarehouse.RenneHardwood;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian.Freddy;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian.LordMarkusWintar;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian.Nelera;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian.lake.July;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian.market.Ronan;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian.market.Wella;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.bastian.market.Zilays;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.fishermanVille.Dalia;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.fishermanVille.Jack;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.griwalshFarmhouse.Griwalsh;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.castle.LordMathewWintar;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.gardens.LadyLara;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.gardens.Verona;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.harbor.CaptainLukas;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.harbor.GuzarAtHeleraHarbor;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.smithersClan.Perseus;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.tavern.Felicia;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.helera.walls.Yandov;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.umera.Eldrin;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.umera.minersLodge.Gruwald;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.umera.tavern.Korina;
import com.cnx.endlesstalestwo.data.npcs.havarusSouth.woodcuttersGrove.Drigo;

public class NpcsHavarusSouth extends DataHelper {

    @Override
    public void generate() {
        new Yandov().generate();//
        new Griwalsh().generate();//
        new Wella().generate();//
        new Ronan().generate();//
        new Zilays().generate();//
        new RenneHardwood().generate();//
        new LordMathewWintar().generate();//
        new LordMarkusWintar().generate();//
        new Verona().generate();//
        new Felicia().generate();//
        new Perseus().generate();//
        new Korina().generate();//
        new Gruwald().generate();//
        new Drigo().generate();//
        new July().generate();//
        new LadyLara().generate();//
        new Jack().generate();//
        new Dalia().generate();//
        new Nelera().generate();//
        new Freddy().generate();//
        new Terry().generate();//
        new Eldrin().generate();//
        new CaptainLukas().generate();//
        new GuzarAtHeleraHarbor().generate();//
    }
}
