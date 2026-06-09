package com.cnx.endlesstalestwo.data.npcs.wazel;

import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.npcs.wazel.deepCrater.MysticRock;
import com.cnx.endlesstalestwo.data.npcs.wazel.harbor.CaptainBradoch;
import com.cnx.endlesstalestwo.data.npcs.wazel.harbor.Raduc;
import com.cnx.endlesstalestwo.data.npcs.wazel.kitchen.Teradoch;
import com.cnx.endlesstalestwo.data.npcs.wazel.kitchen.Whalika;
import com.cnx.endlesstalestwo.data.npcs.wazel.oasis.Zanica;
import com.cnx.endlesstalestwo.data.npcs.wazel.towerWarriors.Danjor;
import com.cnx.endlesstalestwo.data.npcs.wazel.towerWarriors.Eridan;
import com.cnx.endlesstalestwo.data.npcs.wazel.towerWarriors.Janoch;
import com.cnx.endlesstalestwo.data.npcs.wazel.watchTower.Katiusca;
import com.cnx.endlesstalestwo.data.npcs.wazel.orcVillage.Korzk;

public class NpcsWazel extends DataHelper {

    @Override
    public void generate() {
        new Puca().generate();//
        new Teradoch().generate();//
        new Whalika().generate();//
        new Eridan().generate();//
        new Danjor().generate();//
        new CaptainBradoch().generate();//
        new Raduc().generate();//
        new Katiusca().generate();//
        new Zanica().generate();//
        new MysticRock().generate();
        new Janoch().generate();//
        new Korzk().generate();//
    }
}
