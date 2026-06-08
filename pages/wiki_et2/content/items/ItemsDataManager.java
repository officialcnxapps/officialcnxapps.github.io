package com.cnx.endlesstalestwo.data.items;

public class ItemsDataManager {

    public void generate() {
        new Other().generate();
        new EquippableWeaponsAndShields().generate();
        new EquippableArmorsAndLegs().generate();
        new EquippableHelmetsAndBoots().generate();
        new EquippableJewelsAndBags().generate();
        new Potions().generate();
        new Consumables().generate();
        new Books().generate();
    }
}
