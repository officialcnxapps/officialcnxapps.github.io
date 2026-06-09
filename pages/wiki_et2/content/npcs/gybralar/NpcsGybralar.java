package com.cnx.endlesstalestwo.data.npcs.gybralar;

import com.cnx.endlesstalestwo.data.DataHelper;

public class NpcsGybralar extends DataHelper {

    @Override
    public void generate() {
        new ElfGoddessStatue().generate();
    }
}
