package com.cnx.endlesstalestwo.data.npcs.esperand;

import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.npcs.esperand.barbarianSettlement.Cradul;
import com.cnx.endlesstalestwo.data.npcs.esperand.church.PriestAlec;
import com.cnx.endlesstalestwo.data.npcs.esperand.church.Valanya;
import com.cnx.endlesstalestwo.data.npcs.esperand.cityHall.LordMukasWintar;
import com.cnx.endlesstalestwo.data.npcs.esperand.harbor.CaptainLukasAtEsperand;
import com.cnx.endlesstalestwo.data.npcs.esperand.harbor.CaptainPhilipson;
import com.cnx.endlesstalestwo.data.npcs.esperand.inn.Lauisy;
import com.cnx.endlesstalestwo.data.npcs.esperand.monastery.BrotherMordius;
import com.cnx.endlesstalestwo.data.npcs.esperand.monastery.Godman;
import com.cnx.endlesstalestwo.data.npcs.esperand.monastery.PriestSariseus;
import com.cnx.endlesstalestwo.data.npcs.esperand.watchTower.Vinny;

public class NpcsEsperand extends DataHelper {

    @Override
    public void generate() {
        new Vinny().generate();//
        new Lauisy().generate();//
        new LordMukasWintar().generate();//
        new PriestAlec().generate();//
        new Godman().generate();//
        new CaptainPhilipson().generate();//
        new ASpirit().generate();//
        new PriestSariseus().generate();//
        new Malina().generate();//
        new Valanya().generate(); //at church//
        new com.cnx.endlesstalestwo.data.npcs.esperand.Valanya().generate(); //at esperand//
        new CaptainLukasAtEsperand().generate();//harbor
        new BrotherMordius().generate();//monastery
        new FatherBarnabas().generate();//frozen west trail
        new Cradul().generate();//barbarian settlement
    }
}
