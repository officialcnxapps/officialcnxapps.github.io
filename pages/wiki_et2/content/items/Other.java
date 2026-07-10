package com.cnx.endlesstalestwo.data.items;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.ConsumableItem;
import com.cnx.endlesstalestwo.entities.Item;
import com.cnx.endlesstalestwo.enums.Enums;

public final class Other extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.ITEM, wheat());//
        App.DataManager.add(Enums.DataTypes.ITEM, flour());//
        App.DataManager.add(Enums.DataTypes.ITEM, crab());//
        App.DataManager.add(Enums.DataTypes.ITEM, branch());//
        App.DataManager.add(Enums.DataTypes.ITEM, log());//
        App.DataManager.add(Enums.DataTypes.ITEM, rock());//
        App.DataManager.add(Enums.DataTypes.ITEM, wool());//
        App.DataManager.add(Enums.DataTypes.ITEM, cotton());//
        App.DataManager.add(Enums.DataTypes.ITEM, tissue());//
        App.DataManager.add(Enums.DataTypes.ITEM, string());//
        App.DataManager.add(Enums.DataTypes.ITEM, greenHerb());//
        App.DataManager.add(Enums.DataTypes.ITEM, redHerb());//
        App.DataManager.add(Enums.DataTypes.ITEM, yellowHerb());//
        App.DataManager.add(Enums.DataTypes.ITEM, ironOre());//
        App.DataManager.add(Enums.DataTypes.ITEM, copperOre());//
        App.DataManager.add(Enums.DataTypes.ITEM, goldOre());//
        App.DataManager.add(Enums.DataTypes.ITEM, caltraniumOre());//
        App.DataManager.add(Enums.DataTypes.ITEM, ironIngot());//
        App.DataManager.add(Enums.DataTypes.ITEM, copperIngot());//
        App.DataManager.add(Enums.DataTypes.ITEM, goldIngot());//
        App.DataManager.add(Enums.DataTypes.ITEM, steelIngot());//
        App.DataManager.add(Enums.DataTypes.ITEM, caltraniumIngot());//
        App.DataManager.add(Enums.DataTypes.ITEM, sapphire());//
        App.DataManager.add(Enums.DataTypes.ITEM, ruby());//
        App.DataManager.add(Enums.DataTypes.ITEM, emerald());//
        App.DataManager.add(Enums.DataTypes.ITEM, emeraldPowder());
        App.DataManager.add(Enums.DataTypes.ITEM, diamond());//
        App.DataManager.add(Enums.DataTypes.ITEM, fishingRod());//
        App.DataManager.add(Enums.DataTypes.ITEM, reinforcedFishingRod());//
        App.DataManager.add(Enums.DataTypes.ITEM, pickaxe());//
        App.DataManager.add(Enums.DataTypes.ITEM, steelPickaxe());//
        App.DataManager.add(Enums.DataTypes.ITEM, dwarvensPickaxe());//
        App.DataManager.add(Enums.DataTypes.ITEM, huntingTrap());//
        App.DataManager.add(Enums.DataTypes.ITEM, ash());//
        App.DataManager.add(Enums.DataTypes.ITEM, algae());//
        App.DataManager.add(Enums.DataTypes.ITEM, leather());//
        App.DataManager.add(Enums.DataTypes.ITEM, coal());//
        App.DataManager.add(Enums.DataTypes.ITEM, armorMold());//
        App.DataManager.add(Enums.DataTypes.ITEM, helmetMold());//
        App.DataManager.add(Enums.DataTypes.ITEM, plank());//
        App.DataManager.add(Enums.DataTypes.ITEM, rope());//
        App.DataManager.add(Enums.DataTypes.ITEM, lisportMap());//
        App.DataManager.add(Enums.DataTypes.ITEM, havarusNorthMap());//
        App.DataManager.add(Enums.DataTypes.ITEM, havarusSouthMap());//
        App.DataManager.add(Enums.DataTypes.ITEM, esperandMap());//
        App.DataManager.add(Enums.DataTypes.ITEM, wazelMap());//
        App.DataManager.add(Enums.DataTypes.ITEM, ayalonMap());//
        App.DataManager.add(Enums.DataTypes.ITEM, growrocksMap());//
        App.DataManager.add(Enums.DataTypes.ITEM, gybralarMap());//
        App.DataManager.add(Enums.DataTypes.ITEM, orcTooth());//
        App.DataManager.add(Enums.DataTypes.ITEM, goldRing());//
        App.DataManager.add(Enums.DataTypes.ITEM, rubyRing());//
        App.DataManager.add(Enums.DataTypes.ITEM, silverRing());//
        App.DataManager.add(Enums.DataTypes.ITEM, repairSupplies());//
        App.DataManager.add(Enums.DataTypes.ITEM, spyglass());//
        App.DataManager.add(Enums.DataTypes.ITEM, donationGoods());//
        App.DataManager.add(Enums.DataTypes.ITEM, potionOfWaterBreathing());//
        App.DataManager.add(Enums.DataTypes.ITEM, bagOfSwampHerbs());//
        App.DataManager.add(Enums.DataTypes.ITEM, bombCrate());//
        App.DataManager.add(Enums.DataTypes.ITEM, spiderWeb());//
        App.DataManager.add(Enums.DataTypes.ITEM, whiteHerb());//
        App.DataManager.add(Enums.DataTypes.ITEM, blackOakSeeds());//
        App.DataManager.add(Enums.DataTypes.ITEM, darkBlood());//
        App.DataManager.add(Enums.DataTypes.ITEM, heleraProvisions());//
        App.DataManager.add(Enums.DataTypes.ITEM, charityPackage());//
        App.DataManager.add(Enums.DataTypes.ITEM, contrabandPackage());//
        App.DataManager.add(Enums.DataTypes.ITEM, enchantedDesertSand());//
        App.DataManager.add(Enums.DataTypes.ITEM, livingMosswood());//
        App.DataManager.add(Enums.DataTypes.ITEM, runicStoneFragment());//
        App.DataManager.add(Enums.DataTypes.ITEM, eternalIceCrystal());//
        App.DataManager.add(Enums.DataTypes.ITEM, insecticide());//
        App.DataManager.add(Enums.DataTypes.ITEM, goldbag());//
        App.DataManager.add(Enums.DataTypes.ITEM, crateOfTools());
        App.DataManager.add(Enums.DataTypes.ITEM, unidentifiedPotion());
        App.DataManager.add(Enums.DataTypes.ITEM, bucketOfFishes());
        App.DataManager.add(Enums.DataTypes.ITEM, monasteryShipmentReport());
        App.DataManager.add(Enums.DataTypes.ITEM, crateOfWeapons());
        App.DataManager.add(Enums.DataTypes.ITEM, bronzeGoblet());
        App.DataManager.add(Enums.DataTypes.ITEM, goldenGoblet());
        App.DataManager.add(Enums.DataTypes.ITEM, rubyGoblet());
        App.DataManager.add(Enums.DataTypes.ITEM, contractOfCattleNegotiation());
    }

    Item wheat() {
        Item item = new Item("Wheat", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Trigo");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Trigo");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A versatile cereal that can be ground into flour.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um cereal versátil que pode ser moído até virar farinha.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un cereal versátil que se puede moler hasta convertirlo en harina.");

        item.weight = .1f;
        item.marketValue = 1;

        return item;
    }

    Item flour() {
        Item item = new Item("Flour", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Farinha");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Harina");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Mix with water or milk to make dough.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Misture com água ou leite para fazer a massa.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mezclar con agua o leche para hacer la masa.");

        item.weight = .1f;
        item.marketValue = 1;

        return item;
    }

    Item crab() {
        Item item = new Item("Crab", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caranguejo");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cangrejo");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Hard shell, large claws and walks sideways. A crustacean. Needs cooking.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Casca dura, grandes pinças e caminha para os lados. Um crustáceo. Precisa ser cozido.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Caparazón duro, garras grandes y camina de lado. Un crustáceo. Necesita cocinarse.");

        item.type = Enums.ItemType.FOOD;
        item.weight = .2f;
        item.marketValue = 3;

        return item;
    }

    Item branch() {
        Item item = new Item("Branch", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Galho");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Rama");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A simple tree branch.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um simples galho de árvore.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una simple rama de árbol.");

        item.weight = .5f;
        item.marketValue = 1;
        item.sellable = false;

        return item;
    }

    Item log() {
        Item item = new Item("Log", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Tora");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tronco");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A thick piece of wood extracted from the tree trunk.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um grosso pedaço de madeira extraído do tronco da árvore.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un trozo grueso de madera extraída del tronco del árbol.");

        item.weight = 5f;
        item.marketValue = 2;

        return item;
    }

    Item rock() {
        Item item = new Item("Rock", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pedra");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Piedra");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A simple stone. Can be carved.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma simples pedra. Pode ser esculpida.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una piedra sencilla. Se puede tallar.");

        item.weight = .2f;
        item.marketValue = 1;
        item.sellable = false;

        return item;
    }

    Item wool() {
        Item item = new Item("Wool", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lã");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lana");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A soft piece of sheep's wool. Useful for textile production.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um pedaço macio de lã de ovelha. Útil para produção têxtil.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un suave trozo de lana de oveja. Útil para la produção textil.");

        item.weight = .1f;
        item.marketValue = 2;

        return item;
    }

    Item cotton() {
        Item item = new Item("Cotton", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Algodão");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Algodón");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A soft piece of vegetable cotton. Useful for textile production.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um pedaço macio de algodão vegetal. Útil para produção têxtil.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un suave trozo de algodón vegetal. Útil para la produção textil.");

        item.weight = .1f;
        item.marketValue = 2;

        return item;
    }

    Item tissue() {
        Item item = new Item("Tissue", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Tecido");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tejido");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Made from cotton or wool, it is great for clothing production.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Feito de algodão ou lã, é ótimo para produção de roupas.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hecho de algodón o lana, es ideal para la producción de ropa.");

        item.weight = .1f;
        item.marketValue = 3;

        return item;
    }

    Item string() {
        Item item = new Item("String", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cordão");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cordón");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A string line that can be used for different purposes.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um fio que pode ser usado para diversos fins.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un hilo que se puede utilizar para diferentes propósitos.");

        item.weight = .1f;
        item.marketValue = 1;

        return item;
    }

    Item greenHerb() {
        Item item = new Item("Green Herb", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Erva Verde");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hierba Verde");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Easily found in nature. It could be a seasoning or ingredient.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Facilmente encontrada na natureza. Pode ser um tempero ou ingrediente.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Se encuentra fácilmente en la naturaleza. Podría ser um condimento o un ingrediente.");

        item.weight = .1f;
        item.marketValue = 1;

        return item;
    }

    Item redHerb() {
        Item item = new Item("Red Herb", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Erva Vermelha");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hierba Roja");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Found in nature. It could be a seasoning or ingredient.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Encontrada na natureza. Pode ser um tempero ou ingrediente.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Encontrada en la naturaleza. Podría ser um condimento o un ingrediente.");

        item.weight = .1f;
        item.marketValue = 3;

        return item;
    }

    Item yellowHerb() {
        Item item = new Item("Yellow Herb", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Erva Amarela");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hierba Amarilla");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A rare herb that is found in nature. It could be a seasoning or ingredient.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma erva mais rara que é encontrada na natureza. Pode ser um tempero ou ingrediente.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una hierba más rara que se encuentra en la naturaleza. Podría ser un condimento o un ingrediente.");

        item.weight = .1f;
        item.marketValue = 6;
        item.rarity = Enums.Rarity.UNCOMMON;

        return item;
    }

    Item ironOre() {
        Item item = new Item("Iron Ore", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Minério de Ferro");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mineral de Hierro");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Iron in its raw form. Can be cast.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ferro em sua forma crua. Pode ser fundido.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hierro en su forma cruda. Se puede lanzar.");

        item.weight = .6f;
        item.marketValue = 2;

        return item;
    }

    Item copperOre() {
        Item item = new Item("Copper Ore", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Minério de Cobre");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mineral de Cobre");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Copper in its raw form. Can be cast.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cobre em sua forma crua. Pode ser fundido.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cobre en su forma cruda. Se puede lanzar.");

        item.weight = .6f;
        item.marketValue = 3;

        return item;
    }

    Item goldOre() {
        Item item = new Item("Gold Ore", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Minério de Ouro");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mineral de Oro");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Gold in its raw form. Can be cast.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ouro em sua forma crua. Pode ser fundido.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Oro en su forma cruda. Se puede lanzar.");

        item.weight = .5f;
        item.marketValue = 7;

        return item;
    }

    Item caltraniumOre() {
        Item item = new Item("Caltranium Ore", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Minério de Caltranio");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mineral de Caltranio");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Caltranium in its raw form. Can be cast.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caltranio em sua forma crua. Pode ser fundido.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Caltranio en su forma cruda. Se puede lanzar.");

        item.weight = .8f;
        item.marketValue = 14;
        item.rarity = Enums.Rarity.UNCOMMON;

        return item;
    }

    Item ironIngot() {
        Item item = new Item("Iron Ingot", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lingote de Ferro");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lingote de Hierro");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Casted iron ready to be shaped into a tool, weapon, etc...");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ferro fundido pronto para ser moldado como uma ferramenta, arma, etc...");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hierro fundido listo para ser moldeado en herramienta, arma, etc...");

        item.weight = 1f;
        item.marketValue = 4;

        return item;
    }

    Item copperIngot() {
        Item item = new Item("Copper Ingot", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lingote de Cobre");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lingote de Cobre");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Casted copper ready to be shaped into a tool, weapon, etc...");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cobre fundido pronto para ser moldado como uma ferramenta, arma, etc...");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cobre fundido listo para ser moldeado en herramienta, arma, etc...");

        item.weight = 1f;
        item.marketValue = 7;

        return item;
    }

    Item steelIngot() {
        Item item = new Item("Steel Ingot", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lingote de Aço");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lingote de Acero");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Casted iron with coal ready to be shaped into a tool, weapon, etc...");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ferro fundido com carvão prontos para serem transformados em ferramentas, armas, etc...");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hierro fundido con carbón listos para ser moldeados en herramientas, armas, etc.");

        item.weight = 1f;
        item.marketValue = 8;

        return item;
    }

    Item goldIngot() {
        Item item = new Item("Gold Ingot", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lingote de Ouro");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lingote de Oro");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Casted gold ready to be shaped into a jewel, weapon, etc...");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ouro fundido pronto para ser moldado como uma jóia, arma, etc...");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Oro fundido listo para ser moldeado en joya, arma, etc...");

        item.weight = .8f;
        item.marketValue = 12;

        return item;
    }

    Item caltraniumIngot() {
        Item item = new Item("Caltranium Ingot", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lingote de Caltranio");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lingote de Caltranio");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Caltranium gold ready to be shaped into an armor, weapon, etc...");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caltranio fundido pronto para ser moldado como uma armadura, arma, etc...");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Caltranio fundido listo para ser moldeado en armadura, arma, etc...");

        item.weight = 1.2f;
        item.marketValue = 21;
        item.rarity = Enums.Rarity.UNCOMMON;

        return item;
    }

    Item sapphire() {
        Item item = new Item("Sapphire", Enums.ItemType.VALUABLE);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Safira");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Zafiro");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A bluish colored gemstone.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma pedra preciosa de cor azulada.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una piedra preciosa de color azulado.");

        item.weight = .1f;
        item.marketValue = 10;
        item.rarity = Enums.Rarity.UNCOMMON;

        return item;
    }

    Item ruby() {
        Item item = new Item("Ruby", Enums.ItemType.VALUABLE);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Rubi");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Rubí");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A reddish colored gemstone.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma pedra preciosa de cor avermelhada.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una piedra preciosa de color rojizo.");

        item.weight = .1f;
        item.marketValue = 11;
        item.rarity = Enums.Rarity.UNCOMMON;

        return item;
    }

    Item goldbag() {
        ConsumableItem item = new ConsumableItem("Gold Bag");
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Saco de Ouro");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bolsa de Oro");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A purse with gold coins inside, open it to become wealthier.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma bolsa com moedas de ouro dentro; abra-a para ficar mais rico.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un monedero con monedas de oro dentro; ábrelo para volverte más rico.");

        item.type = Enums.ItemType.VALUABLE;
        item.weight = .5f;
        item.marketValue = 0;
        item.gemCost = 5;
        item.inBattleUsage = false;
        item.outBattleUsage = true;
        item.rarity = Enums.Rarity.RARE;
        item.imgFile = "item_gold_bag";
        item.canBeIngredient = false;

        item.listener = () -> App.getPlayerChar().addGold(25);

        return item;
    }

    Item emerald() {
        Item item = new Item("Emerald", Enums.ItemType.VALUABLE);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Esmeralda");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Esmeralda");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A greenish colored gemstone.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma pedra preciosa de cor esverdeada.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una piedra preciosa de color verdoso.");

        item.weight = .1f;
        item.marketValue = 18;
        item.rarity = Enums.Rarity.RARE;

        return item;
    }

    Item emeraldPowder() {
        Item item = new Item("Emerald Powder", Enums.ItemType.VALUABLE);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pó de Esmeralda");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Polvo de Esmeralda");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A greenish colored gemstone smashed until it be just powder.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma pedra preciosa de cor esverdeada esmagada até virar pó.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una piedra preciosa de color verdoso machacada hasta convertirse en polvo.");

        item.weight = .1f;
        item.marketValue = 13;
        item.rarity = Enums.Rarity.RARE;

        return item;
    }

    Item diamond() {
        Item item = new Item("Diamond", Enums.ItemType.VALUABLE);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Diamante");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Diamante");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The most beautiful and coveted gemstone.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A pedra preciosa mais linda e cobiçada.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La piedra preciosa más bella y codiciada.");

        item.weight = .1f;
        item.marketValue = 30;
        item.rarity = Enums.Rarity.RARE;

        return item;
    }

    Item fishingRod() {
        Item item = new Item("Fishing Rod", Enums.ItemType.TOOL);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Vara de Pesca");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Caña de Pescar");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A tool that makes catching fish easier.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma ferramenta que facilita a pega de peixes.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una herramienta que facilita la captura de peces.");

        item.weight = .2f;
        item.marketValue = 5;

        return item;
    }

    Item reinforcedFishingRod() {
        Item item = new Item("Reinforced Fishing Rod", Enums.ItemType.TOOL);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Vara de Pesca Reforçada");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Caña de Pescar Reforzada");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The same rod, but thicker and with a double line to catch big fish. It is needed some knowledge to use a rod like that.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A mesma vara, porém mais grossa e com uma linha dupla para fisgar peixes grandes. É preciso algum conhecimento para usar uma vara assim.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La misma caña, pero más gruesa y con doble hilo para pescar peces grandes. Se necesitan algunos conhecimentos para utilizar una caña como ésta.");

        item.weight = .4f;
        item.marketValue = 16;
        item.canBeIngredient = false;

        return item;
    }

    Item pickaxe() {
        Item item = new Item("Pickaxe", Enums.ItemType.TOOL);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Picareta");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pico");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The correct tool for extracting ores and stones.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A ferramenta correta para extrair minérios e pedras.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La herramienta correcta para extraer minerales y piedras.");

        item.weight = 1.5f;
        item.marketValue = 7;

        return item;
    }

    Item steelPickaxe() {
        Item item = new Item("Steel Pickaxe", Enums.ItemType.TOOL);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Picareta de Aço");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pico de Acero");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A better pickaxe that makes the ore extract easier.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma picareta melhor que facilita a extração do minério.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un pico mejor que facilita la extracción del mineral.");

        item.weight = 1.7f;
        item.marketValue = 16;

        return item;
    }

    Item dwarvensPickaxe() {
        Item item = new Item("Dwarven's Pickaxe", Enums.ItemType.TOOL);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Picareta dos Anões");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pico de Enanos");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The most efficient pickaxe. Made by dwarves.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A picareta mais eficiente. Feita pelos anões.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El pico más eficiente. Hecho por enanos.");

        item.weight = 2.2f;
        item.marketValue = 42;
        item.rarity = Enums.Rarity.RARE;
        item.canBeIngredient = false;

        return item;
    }

    Item huntingTrap() {
        Item item = new Item("Hunting Trap", Enums.ItemType.TOOL);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Armadilha de Caça");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Trampa de Caza");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Great for hunting animals more efficiently.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ótima para caçar animais com mais eficiência.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Ideal para cazar animales de forma más eficiente.");

        item.weight = 1.6f;
        item.marketValue = 3;
        item.canBeIngredient = false;

        return item;
    }

    Item algae() {
        Item item = new Item("Algae", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Algas");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Algas");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Aquatic plants that can be used as an ingredient.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Plantas aquáticas que podem ser usadas como ingrediente.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Plantas acuáticas que se pueden utilizar como ingrediente.");

        item.weight = .1f;
        item.marketValue = 1;
        item.sellable = false;

        return item;
    }

    Item coal() {
        Item item = new Item("Coal", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Carvão");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carbón");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Coal can be mineral or vegetable, obtained from stones or charred wood.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O carvão pode ser mineral ou vegetal, obtido de pedras ou carbonização de madeira.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El carbón puede ser mineral o vegetal, obtenido de piedras o madera carbonizada.");

        item.weight = .3f;
        item.marketValue = 2;

        return item;
    }

    Item leather() {
        Item item = new Item("Leather", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Couro");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cuero");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The clean skin of an animal.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A pele limpa de um animal.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La piel limpia de un animal.");

        item.weight = .8f;
        item.marketValue = 3;

        return item;
    }

    Item armorMold() {
        Item item = new Item("Armor Mold", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Molde de Armadura");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Molde de Armadura");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "To make your own armor you need to have a specific mold like this one.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Para fazer armaduras próprias é preciso ter um molde específico como este.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Para fabricar tu propia armadura necesitas tener un molde específico como este.");

        item.weight = .8f;
        item.marketValue = 8;

        return item;
    }

    Item helmetMold() {
        Item item = new Item("Helmet Mold", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Molde de Elmo");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Molde de Casco");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "To make your own helmet you need to have a specific mold like this one.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Para fazer elmos próprios é preciso ter um molde específico como este.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Para fabricar tu propio casco necesitas tener un molde específico como este.");

        item.weight = .8f;
        item.marketValue = 8;

        return item;
    }

    Item plank() {
        Item item = new Item("Plank", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Tábua");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tabla");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A piece of laminated wood, ideal for furniture and joinery.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um pedaço de madeira laminado, ideal para móveis e marcenaria.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pieza de madera laminada, ideal para muebles y ebanistería.");

        item.weight = 2f;
        item.marketValue = 3;

        return item;
    }

    Item rope() {
        Item item = new Item("Rope", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Corda");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cuerda");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Braided strings. Used to tie, hold and even make things.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Fios trançados. Usada para amarrar, segurar e até confeccionar coisas.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Alambres trenzados. Se utiliza para atar, sujetar e incluso hacer cosas.");

        item.weight = 1f;
        item.marketValue = 6;

        return item;
    }

    Item lisportMap() {
        Item item = new Item("Lisport Map", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mapa de Lisport");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mapa de Lisport");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A map of Lisport region.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um mapa da região de Lisport.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un mapa de la región de Lisport.");

        item.weight = 0.1f;
        item.marketValue = 8;
        item.sellable = false;
        item.discardable = false;
        item.imgFile = "item_map";
        item.canBeIngredient = false;

        return item;
    }

    Item havarusNorthMap() {
        Item item = new Item("Havarus North Map", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mapa de Havarus Norte");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mapa de Havarus Norte");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A map of Havarus north region.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um mapa da região norte de Havarus.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un mapa de la región norte de Havarus.");

        item.weight = 0.1f;
        item.marketValue = 8;
        item.sellable = false;
        item.discardable = false;
        item.imgFile = "item_map";
        item.canBeIngredient = false;

        return item;
    }

    Item havarusSouthMap() {
        Item item = new Item("Havarus South Map", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mapa de Havarus Sul");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mapa de Havarus Sur");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A map of Havarus south region.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um mapa da região sul de Havarus.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un mapa de la región sur de Havarus.");

        item.weight = 0.1f;
        item.marketValue = 8;
        item.sellable = false;
        item.discardable = false;
        item.imgFile = "item_map";
        item.canBeIngredient = false;

        return item;
    }

    Item esperandMap() {
        Item item = new Item("Esperand Map", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mapa de Esperand");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mapa de Esperand");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A map of Esperand region.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um mapa da região de Esperand.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un mapa de la región de Esperand.");

        item.weight = 0.1f;
        item.marketValue = 8;
        item.sellable = true;
        item.discardable = true;
        item.imgFile = "item_map";
        item.canBeIngredient = false;

        return item;
    }

    Item wazelMap() {
        Item item = new Item("Wazel Map", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mapa Wazel");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mapa Wazel");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, ".A map of Wazel region");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um mapa da região de Wazel");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un mapa de la región de Wazel");

        item.weight = 0.1f;
        item.marketValue = 8;
        item.sellable = true;
        item.discardable = true;
        item.imgFile = "item_map";
        item.canBeIngredient = false;

        return item;
    }

    Item ayalonMap() {
        Item item = new Item("Ayalon Map", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mapa de Ayalon");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mapa de Ayalon");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A map of Ayalon region.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um mapa da região de Ayalon.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un mapa de la región de Ayalón.");

        item.weight = 0.1f;
        item.marketValue = 8;
        item.sellable = false;
        item.discardable = false;
        item.imgFile = "item_map";
        item.canBeIngredient = false;

        return item;
    }

    Item growrocksMap() {
        Item item = new Item("Growrocks Map", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mapa Growrocks");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mapa Growrocks");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A map of Growrocks region.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um mapa da região de Growrocks.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un mapa de la región de Growrocks.");

        item.weight = 0.1f;
        item.marketValue = 8;
        item.imgFile = "item_map";
        item.canBeIngredient = false;

        return item;
    }

    Item gybralarMap() {
        Item item = new Item("Gybralar Forest Map", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mapa da Floresta Gybralar");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Mapa da Floresta Gybralar");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A map of Gybralar forest region.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um mapa da região florestal de Gybralar.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un mapa de la región forestal de Gybralar.");

        item.weight = 0.1f;
        item.marketValue = 8;
        item.imgFile = "item_map";
        item.canBeIngredient = false;

        return item;
    }

    Item orcTooth() {
        Item item = new Item("Orc Tooth", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Dente de Orc");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Diente de orco");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A tooth of an Orc.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um dente de um Orc.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un diente de orco.");

        item.weight = 0.1f;
        item.marketValue = 3;
        return item;
    }

    Item rubyRing() {
        Item item = new Item("Ruby Ring", Enums.ItemType.VALUABLE);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Anel de Rubi");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Anillo de Rubí");

        item.type = Enums.ItemType.JEWEL;
        item.marketValue = 45;
        item.weight = .1f;
        item.rarity = Enums.Rarity.RARE;

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A magnificent ring adorned with a brilliant ruby gem.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um magnífico anel adornado com uma brilhante gema de rubi.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un magnífico anillo adornado con una brillante gema de rubí.");

        return item;
    }

    Item goldRing() {
        Item item = new Item("Gold Ring", Enums.ItemType.VALUABLE);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Anel de ouro");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Anillo de oro");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A gold ring usually used by married ones.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um anel de ouro geralmente usado por pessoas casadas.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un anillo de oro generalmente usado por los casados.");

        item.weight = 0.1f;
        item.marketValue = 25;
        return item;
    }

    Item silverRing() {
        Item item = new Item("Silver Ring", Enums.ItemType.VALUABLE);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Anel de Prata");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Anillo de Plata");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A silver ring usually used by brides and grooms");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um anel de prata geralmente usado por pessoas noivas.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un anillo de plata generalmente usado por los novios.");

        item.weight = 0.1f;
        item.marketValue = 14;

        return item;
    }

    Item repairSupplies() {
        Item item = new Item("Repair Supplies", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Suprimentos de reparo");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Suministros de reparación");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A crate with hammers, nails, etc...");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma caixa com martelos, pregos, etc...");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una caja con martillos, clavos, etc...");

        item.weight = 3.5f;
        item.marketValue = 20;
        item.sellable = false;
        item.discardable = false;
        item.canBeIngredient = false;

        return item;
    }

    Item spyglass() {
        Item item = new Item("Spyglass", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Luneta");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Catalejo");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Can be useful for long distance observation.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pode ser útil para observação de longa distância.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Puede ser útil para la observación a larga distancia.");

        item.weight = 0.3f;
        item.marketValue = 10;
        item.canBeIngredient = false;

        return item;
    }

    Item donationGoods() {
        Item item = new Item("Donation Goods", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Bens de Doação");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bienes de donación");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Crates containing goods that church is donating to the poors.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caixas contendo bens que a igreja está doando aos pobres.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cajas que contienen bienes que la iglesia está donando a los pobres.");

        item.weight = 6f;
        item.marketValue = 25;
        item.sellable = false;
        item.discardable = false;
        item.canBeIngredient = false;
        return item;
    }

    Item potionOfWaterBreathing() {
        Item item = new Item("Potion of Water Breathing", Enums.ItemType.POTION);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Poção de Respiração Aquática");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Poción de Respiración Acuática");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A potion made by Griwalsh that allows underwater breathing for a few minutes.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma poção feita por Griwalsh que permite respiração embaixo da água por alguns minutos.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una poción hecha por Griwalsh que permite respirar bajo el agua durante unos minutos.");

        item.weight = .1f;
        item.marketValue = 18;
        item.sellable = false;
        item.discardable = false;
        item.canBeIngredient = false;

        return item;
    }

    Item bagOfSwampHerbs() {
        Item item = new Item("Bag of Swamp Herbs", Enums.ItemType.POTION);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Saco de Ervas do Pântano");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bolsa de Hierbas del Pantano");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A cloth bag full of slimy and weird herbs taken from a swamp.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um saco de pano cheio de ervas gosmentas e esquisitas retiradas de um pântano.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una bolsa de tela llena de hierbas viscosas e raras extraídas de um pantano.");

        item.weight = .9f;
        item.marketValue = 25;
        item.sellable = false;
        item.discardable = false;
        item.canBeIngredient = false;

        return item;
    }

    Item bombCrate() {
        Item item = new Item("Bomb Crate", Enums.ItemType.POTION);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caixa Bomba");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Caja Bomba");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A strange box-shaped artifact containing explosive and flammable ingredients.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um artefato estranho em forma de caixa que contem ingredientes explosivos e inflamáveis.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un extraño artefacto en forma de caja que contiene ingredientes explosivos e inflamables.");

        item.weight = 1.8f;
        item.marketValue = 20;
        item.sellable = false;
        item.discardable = false;
        item.canBeIngredient = false;

        return item;
    }

    Item spiderWeb() {
        Item item = new Item("Spider Web", Enums.ItemType.POTION);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Teia de Aranha");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Telaraña");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An incredible web with one of the strongest threads in existence.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma incrível trama com um dos fios mais resistentes que existe.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una increíble telaraña con uno de los hilos más resistentes que existen.");

        item.weight = 0.1f;
        item.marketValue = 1;

        return item;
    }

    Item whiteHerb() {
        Item item = new Item("White Herb", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Erva Branca");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hierba Blanca");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A rare sacred herb that grows in icy caves. Highly valued by elves for rituals.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma erva sagrada rara que cresce em cavernas geladas. Altamente valorizada pelos elfos para rituais.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una hierba sagrada rara que crece en cuevas heladas. Muy valorada por los elfos para rituales.");

        item.weight = 0.1f;
        item.marketValue = 8;
        item.rarity = Enums.Rarity.RARE;

        return item;
    }

    Item blackOakSeeds() {
        Item item = new Item("Black Oak Seeds", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sementes de Carvalho Negro");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Semillas de Roble Negro");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A bag of black oak seeds. These trees are useful to elves and grow mostly in Havarus.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um saco de sementes de carvalho negro. Essas árvores são úteis para os elfos e crescem principalmente em Havarus.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una bolsa de semillas de roble negro. Estos árboles son útiles para los elfos y crecen principalmente en Havarus.");

        item.weight = 0.5f;
        item.marketValue = 0;
        item.sellable = false;
        item.discardable = false;
        item.canBeIngredient = false;

        return item;
    }

    Item darkBlood() {
        Item item = new Item("Dark Blood", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sangue Negro");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sangre Oscura");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Blood from a dark cultist. It emanates a sinister aura and will be used in the counter-portal ritual against Targon.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sangue de um cultista das trevas. Emana uma aura sinistra e será usado no ritual do contra-portal contra Targon.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sangre de un cultista oscuro. Emana un aura siniestra y será utilizada en el ritual del contraportal contra Targon.");

        item.weight = 0.3f;
        item.marketValue = 0;
        item.sellable = false;
        item.discardable = false;
        item.canBeIngredient = false;

        return item;
    }

    Item heleraProvisions() {
        Item item = new Item("Helera Provisions", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mantimentos de Helera");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Provisiones de Helera");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A large crate filled with provisions from Farmland. Contains grain, dried vegetables, and preserved meat to sustain Helera's defenders during the siege.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma grande caixa cheia de mantimentos de Farmland. Contém grãos, vegetais secos e carne preservada para sustentar os defensores de Helera durante o cerco.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un gran cajón lleno de provisiones de Farmland. Contiene grano, verduras secas y carne conservada para mantener a los defensores de Helera durante el asedio.");

        item.weight = 15.0f;
        item.marketValue = 0;
        item.sellable = false;
        item.discardable = false;
        item.canBeIngredient = false;
        item.imgFile = "item_donation_goods";

        return item;
    }

    Item charityPackage() {
        Item item = new Item("Charity Package", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pacote de Caridade");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Paquete de Caridad");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A carefully wrapped package of supplies for those in need. Father Barnabas entrusted this to me.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um pacote cuidadosamente embrulhado com suprimentos para os necessitados. Padre Barnabás confiou isto a mim.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un paquete cuidadosamente envuelto con suministros para los necesitados. El Padre Bernabé me confió esto.");

        item.weight = 5.0f;
        item.marketValue = 0;
        item.sellable = false;
        item.discardable = false;
        item.canBeIngredient = false;
        item.imgFile = "item_donation_goods";

        return item;
    }

    Item contrabandPackage() {
        Item item = new Item("Contraband Package", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pacote de Contrabando");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Paquete de Contrabando");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A heavy package wrapped in dark cloth. Better not to know what's inside.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um pacote pesado embrulhado em pano escuro. Melhor não saber o que há dentro.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un paquete pesado envuelto en tela oscura. Mejor no saber qué hay dentro.");

        item.weight = 9.0f;
        item.marketValue = 0;
        item.sellable = false;
        item.discardable = false;
        item.canBeIngredient = false;
        item.imgFile = "item_donation_goods";
        item.type = Enums.ItemType.MISC;

        return item;
    }

    Item enchantedDesertSand() {
        Item item = new Item("Enchanted Desert Sand", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Areia do Deserto Encantada");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Arena del Desierto Encantada");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Enchanted sand that constantly shifts with ancient magic. Warm to the touch.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Areia encantada que muda constantemente com magia antiga. Quente ao toque.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Arena encantada que cambia constantemente con magia antigua. Cálido al tacto.");

        item.weight = 1.0f;
        item.marketValue = 8;
        item.sellable = true;
        item.type = Enums.ItemType.MISC;
        item.discardable = true;
        item.canBeIngredient = true;
        item.imgFile = "item_sand_golem_sample";

        return item;
    }

    Item livingMosswood() {
        Item item = new Item("Living Mosswood", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Madeira Viva Musgosa");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Madera Viva Musgosa");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Living wood covered in moss. Small leaves sprout from it continuously.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Madeira viva coberta de musgo. Pequenas folhas brotam dela continuamente.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Madera viva cubierta de musgo. Pequeñas hojas brotan de ella continuamente.");

        item.weight = 1.0f;
        item.marketValue = 7;
        item.sellable = true;
        item.type = Enums.ItemType.MISC;
        item.discardable = true;
        item.canBeIngredient = true;
        item.imgFile = "item_forest_golem_sample";

        return item;
    }

    Item ash() {
        Item item = new Item("Ash", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cinzas");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Ceniza");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The remains of a fire that has been extinguished.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Os restos de um fogo apagado.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Los restos de un incendio que ha sido extinguido.");

        item.weight = .1f;
        item.marketValue = 1;
        item.sellable = true;
        item.discardable = true;
        item.canBeIngredient = true;

        return item;
    }

    Item runicStoneFragment() {
        Item item = new Item("Runic Stone Fragment", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Fragmento de Pedra Rúnica");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Fragmento de Piedra Rúnica");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Heavy stone fragment pulsing with earth magic. Covered in mysterious runes.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Fragmento de pedra pesado pulsando com magia da terra. Coberto de runas misteriosas.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Fragmento de piedra pesado que pulsa con magia de la tierra. Cubierto de runas misteriosas.");

        item.weight = 2.0f;
        item.marketValue = 9;
        item.sellable = true;
        item.discardable = true;
        item.canBeIngredient = true;
        item.imgFile = "item_mountain_golem_sample";
        item.type = Enums.ItemType.MISC;

        return item;
    }

    Item eternalIceCrystal() {
        Item item = new Item("Eternal Ice Crystal", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cristal de Gelo Eterno");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cristal de Hielo Eterno");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Eternal ice that never melts, radiating cold. Frost patterns on its surface.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Gelo eterno que nunca derrete, irradiando frio. Padrões de gelo em sua superfície.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hielo eterno que nunca se derrite, irradiando frío. Patrones de hielo en su superficie.");

        item.weight = 1.0f;
        item.marketValue = 6;
        item.sellable = true;
        item.discardable = true;
        item.canBeIngredient = true;
        item.imgFile = "item_ice_golem_sample";
        item.type = Enums.ItemType.MISC;

        return item;
    }

    Item insecticide() {
        Item item = new Item("Insecticide", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Inseticida");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Insecticida");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A powerful chemical mixture to eliminate insect plagues. Handle with care.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma poderosa mistura química para eliminar pragas de insetos. Manuseie com cuidado.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una poderosa mezcla química para eliminar plagas de insectos. Manejar con cuidado.");

        item.weight = 0.5f;
        item.marketValue = 15;
        item.sellable = false;
        item.discardable = false;
        item.canBeIngredient = false;
        item.imgFile = "item_potion_of_water_breathing";

        return item;
    }

    Item crateOfTools() {
        Item item = new Item("Crate of Tools", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caixote de Ferramentas");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cajón de Herramientas");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A wooden crate filled with tools used in the kingdom's prison. Heavy but necessary.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma caixa de madeira cheia de ferramentas usadas na prisão do reino. Pesado mas necessário.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un cajón de madera lleno de herramientas usadas en la prisión del reino. Pesado pero necesario.");

        item.weight = 8.0f;
        item.marketValue = 0;
        item.sellable = false;
        item.buyable = false;
        item.discardable = false;
        item.canBeIngredient = false;

        return item;
    }

    Item unidentifiedPotion() {
        Item item = new Item("Unidentified Potion", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Poção não Identificada");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Poción sin Identificar");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A mysterious potion whose contents are unknown. An alchemist could identify it.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma poção misteriosa cujo conteúdo é desconhecido. Um alquimista poderia identificá-la.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una poción misteriosa cuyo contenido es desconocido. Un alquimista podría identificarla.");

        item.weight = 0.3f;
        item.marketValue = 0;
        item.sellable = false;
        item.buyable = false;
        item.discardable = false;
        item.canBeIngredient = false;

        return item;
    }

    Item bucketOfFishes() {
        Item item = new Item("Bucket of Fishes", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Balde de Peixes");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cubo de Peces");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A bucket filled with fresh fish, ready to be delivered. Keep it fresh!");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um balde cheio de peixes frescos prontos para entrega. Mantenha fresco!");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un cubo lleno de pescado fresco listo para entregar. ¡Mantenlo fresco!");

        item.weight = 2.5f;
        item.marketValue = 0;
        item.sellable = false;
        item.buyable = false;
        item.discardable = false;
        item.canBeIngredient = false;

        return item;
    }

    Item monasteryShipmentReport() {
        Item item = new Item("Monastery Shipment Report", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Relatório de Remessas do Monastério");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Reporte de Envíos del Monasterio");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An official document listing the monastery's shipments. Something looks tampered with inside.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um documento oficial listando as remessas do monastério. Algo parece adulterado no interior.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un documento oficial que enumera los envíos del monasterio. Algo parece alterado en el interior.");

        item.weight = 0.1f;
        item.marketValue = 0;
        item.sellable = false;
        item.buyable = false;
        item.discardable = false;
        item.imgFile = "item_generic_letter";
        item.canBeIngredient = false;

        return item;
    }

    Item crateOfWeapons() {
        Item item = new Item("Crate of Weapons", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caixote de Armas");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cajón de Armas");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A heavy crate packed with weapons destined for the Watch Tower. Careful with this one.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um caixote pesado com armas destinadas à Torre de Guarda. Cuidado com este.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un cajón pesado lleno de armas destinadas a la Torre de Guardia. Cuidado con este.");

        item.weight = 12.0f;
        item.marketValue = 0;
        item.sellable = false;
        item.buyable = false;
        item.discardable = false;
        item.imgFile = "item_donation_goods";
        item.canBeIngredient = false;

        return item;
    }

    Item goldenGoblet() {
        Item item = new Item("Golden Goblet", Enums.ItemType.VALUABLE);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Taça de Ouro");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Taza de Oro");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A golden trophy earned from winning a contest.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um troféu de ouro ganho ao vencer um torneio.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un troféu de oro ganho al vencer un torneo.");

        item.weight = 0.3f;
        item.marketValue = 32;
        item.canBeIngredient = false;
        item.rarity = Enums.Rarity.UNCOMMON;
        return item;
    }

    Item silverGoblet() {
        Item item = new Item("Silver Goblet", Enums.ItemType.VALUABLE);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Taça de Prata");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Taza de Plata");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A silver trophy earned from winning a contest.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um troféu de prata ganho ao vencer um torneio.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un troféu de plata ganho al vencer un torneo.");

        item.weight = 0.3f;
        item.marketValue = 24;
        item.canBeIngredient = false;
        return item;
    }

    Item bronzeGoblet() {
        Item item = new Item("Bronze Goblet", Enums.ItemType.VALUABLE);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Taça de Bronze");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Taza de Bronce");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A bronze trophy earned from winning a contest.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um troféu de bronze ganho ao vencer um torneio.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un troféu de bronce ganho al vencer un torneo.");

        item.weight = 0.3f;
        item.marketValue = 16;
        item.canBeIngredient = false;
        return item;
    }

    Item rubyGoblet() {
        Item item = new Item("Ruby Goblet", Enums.ItemType.VALUABLE);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Taça de Rubi");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Copa de Rubí");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A magnificent goblet carved from a giant ruby, awarded only to the champions of the Frozen Arena.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma magnífica taça esculpida em um rubi gigante, concedida apenas aos campeões da Arena Congelada.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una magnífica copa tallada en un rubí gigante, otorgada únicamente a los campeones de la Arena Helada.");

        item.weight = 0.5f;
        item.marketValue = 48;
        item.rarity = Enums.Rarity.SPECIAL;
        item.canBeIngredient = false;
        return item;
    }

    Item contractOfCattleNegotiation() {
        Item item = new Item("Contract of Cattle Negotiation", Enums.ItemType.MISC);
        item.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Contrato de Negociação de Gado");
        item.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Contrato de Negociación de Ganado");

        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An official document for cattle trade between Lisport and Havarus.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um documento oficial para o comércio de gado entre Lisport e Havarus.");
        item.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un documento oficial para el comercio de ganado entre Lisport y Havarus.");

        item.weight = 0.1f;
        item.marketValue = 0;
        item.sellable = false;
        item.buyable = false;
        item.discardable = false;
        item.imgFile = "item_generic_letter";
        item.canBeIngredient = false;

        return item;
    }
}




