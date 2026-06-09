package com.cnx.endlesstalestwo.data.npcs.growrocks;

import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.npcs.growrocks.barracks.XavierStrongarm;
import com.cnx.endlesstalestwo.data.npcs.growrocks.forge.LugagIronhand;
import com.cnx.endlesstalestwo.data.npcs.growrocks.gates.DwarfSoldier;
import com.cnx.endlesstalestwo.data.npcs.growrocks.minersAssociation.RichardIronhand;
import com.cnx.endlesstalestwo.data.npcs.growrocks.oreFortress.ElliotShinefingers;
import com.cnx.endlesstalestwo.data.npcs.growrocks.oreFortress.TrausShinefingers;
import com.cnx.endlesstalestwo.data.npcs.growrocks.tavern.ErinBarkskin;
import com.cnx.endlesstalestwo.data.npcs.growrocks.tavern.PourinBarkskin;
import com.cnx.endlesstalestwo.data.npcs.growrocks.temple.JanusaGodhead;
import com.cnx.endlesstalestwo.data.npcs.growrocks.vegetablesGardens.FiolaBrownhand;
import com.cnx.endlesstalestwo.data.npcs.growrocks.vegetablesGardens.LokiBrownhand;

public class NpcsGrowrocks extends DataHelper {

    @Override
    public void generate() {
        new LugagIronhand().generate();//
        new ErinBarkskin().generate();//
        new PourinBarkskin().generate();//
        new XavierStrongarm().generate();//
        new RichardIronhand().generate();//
        new JanusaGodhead().generate();//
        new FiolaBrownhand().generate();//
        new LokiBrownhand().generate();//
        new ElliotShinefingers().generate();//
        new TrausShinefingers().generate();//
        new com.cnx.endlesstalestwo.data.npcs.growrocks.temple.TrausShinefingers().generate();//
        new KamalaShinefingers().generate();//
        new OlimanWisehead().generate();//
        new DwarfSoldier().generate();//
        new MysticRock().generate();//
    }
}
