package com.cnx.endlesstalestwo.data.locations;


public class LocationsDataManager {

    public void generate() {
        //Lisport
        new com.cnx.endlesstalestwo.data.locations.lisport.Cities().generate();
        new com.cnx.endlesstalestwo.data.locations.lisport.Other().generate();
        new com.cnx.endlesstalestwo.data.locations.lisport.Places().generate();
        //Havarus North
        new com.cnx.endlesstalestwo.data.locations.havarusNorth.Cities().generate();
        new com.cnx.endlesstalestwo.data.locations.havarusNorth.Others().generate();
        new com.cnx.endlesstalestwo.data.locations.havarusNorth.Places().generate();
        //Havarus South
        new com.cnx.endlesstalestwo.data.locations.havarusSouth.Cities().generate();
        new com.cnx.endlesstalestwo.data.locations.havarusSouth.Others().generate();
        new com.cnx.endlesstalestwo.data.locations.havarusSouth.Places().generate();
        //Gybralar
        new com.cnx.endlesstalestwo.data.locations.gybralar.Others().generate();
        new com.cnx.endlesstalestwo.data.locations.gybralar.Places().generate();
        //Esperand
        new com.cnx.endlesstalestwo.data.locations.esperand.Cities().generate();
        new com.cnx.endlesstalestwo.data.locations.esperand.Others().generate();
        new com.cnx.endlesstalestwo.data.locations.esperand.Places().generate();
        //Wazel
        new com.cnx.endlesstalestwo.data.locations.wazel.Cities().generate();
        new com.cnx.endlesstalestwo.data.locations.wazel.Others().generate();
        new com.cnx.endlesstalestwo.data.locations.wazel.Places().generate();
        //Ayalon
        new com.cnx.endlesstalestwo.data.locations.ayalon.Cities().generate();
        new com.cnx.endlesstalestwo.data.locations.ayalon.Others().generate();
        new com.cnx.endlesstalestwo.data.locations.ayalon.Places().generate();
        //Growrocks
        new com.cnx.endlesstalestwo.data.locations.growrocks.Cities().generate();
        new com.cnx.endlesstalestwo.data.locations.growrocks.Others().generate();
        new com.cnx.endlesstalestwo.data.locations.growrocks.Places().generate();
        //Underworld
        new com.cnx.endlesstalestwo.data.locations.underworld.Others().generate();
        //Dragonland
        new com.cnx.endlesstalestwo.data.locations.dragonland.Other().generate();
        new com.cnx.endlesstalestwo.data.locations.dragonland.Places().generate();
    }
}
