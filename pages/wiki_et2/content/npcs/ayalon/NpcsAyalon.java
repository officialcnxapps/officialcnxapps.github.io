package com.cnx.endlesstalestwo.data.npcs.ayalon;

import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.npcs.ayalon.bridge.Haluren;
import com.cnx.endlesstalestwo.data.npcs.ayalon.castle.EmperorArilas;
import com.cnx.endlesstalestwo.data.npcs.ayalon.citySquare.Casiel;
import com.cnx.endlesstalestwo.data.npcs.ayalon.citySquare.Nariv;
import com.cnx.endlesstalestwo.data.npcs.ayalon.docks.Aslatan;
import com.cnx.endlesstalestwo.data.npcs.ayalon.elvenGarden.Flaviea;
import com.cnx.endlesstalestwo.data.npcs.ayalon.glorienWaterfall.Laurias;
import com.cnx.endlesstalestwo.data.npcs.ayalon.herbalistsGarden.Salilas;
import com.cnx.endlesstalestwo.data.npcs.ayalon.library.Barolas;
import com.cnx.endlesstalestwo.data.npcs.ayalon.library.NeleraLibrary;
import com.cnx.endlesstalestwo.data.npcs.ayalon.temple.Gisela;

public class NpcsAyalon extends DataHelper {

    @Override
    public void generate() {
        new Casiel().generate();//
        new Nariv().generate();//
        new EmperorArilas().generate();//
        new Gisela().generate();//
        new Salilas().generate();//
        new Barolas().generate();//
        new NeleraLibrary().generate();//
        new Laurias().generate();//
        new Aslatan().generate();//
        new Flaviea().generate();//
        new ElvenCitadelGuard().generate();//
        new Haluren().generate();//
        new StatueOfAelindra().generate();//
    }
}
