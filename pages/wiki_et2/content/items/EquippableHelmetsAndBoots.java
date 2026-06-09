package com.cnx.endlesstalestwo.data.items;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.classes.ClassesIds;
import com.cnx.endlesstalestwo.entities.AttributeModifierValue;
import com.cnx.endlesstalestwo.entities.EquippableItem;
import com.cnx.endlesstalestwo.enums.Enums;

public class EquippableHelmetsAndBoots extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.ITEM, leatherCap());//
        App.DataManager.add(Enums.DataTypes.ITEM, ironHelmet()); //
        App.DataManager.add(Enums.DataTypes.ITEM, copperHelmet());//
        App.DataManager.add(Enums.DataTypes.ITEM, steelHelmet());//
        App.DataManager.add(Enums.DataTypes.ITEM, goldenHelmet());//
        App.DataManager.add(Enums.DataTypes.ITEM, caltraniumHelmet());//
        App.DataManager.add(Enums.DataTypes.ITEM, endlessHelmet());//
        App.DataManager.add(Enums.DataTypes.ITEM, helmOfFocus());//
        App.DataManager.add(Enums.DataTypes.ITEM, hatOfWise());//
        App.DataManager.add(Enums.DataTypes.ITEM, hoodOfMagician());//
        App.DataManager.add(Enums.DataTypes.ITEM, supremeHelm()); //
        App.DataManager.add(Enums.DataTypes.ITEM, hoodOfFortitude());//

        App.DataManager.add(Enums.DataTypes.ITEM, leatherBoots());//
        App.DataManager.add(Enums.DataTypes.ITEM, ironBoots());//
        App.DataManager.add(Enums.DataTypes.ITEM, copperBoots());//
        App.DataManager.add(Enums.DataTypes.ITEM, steelBoots());//
        App.DataManager.add(Enums.DataTypes.ITEM, goldenBoots());//
        App.DataManager.add(Enums.DataTypes.ITEM, caltraniumBoots());//
        App.DataManager.add(Enums.DataTypes.ITEM, endlessBoots());//
        App.DataManager.add(Enums.DataTypes.ITEM, supremeBoots());//
        App.DataManager.add(Enums.DataTypes.ITEM, shoesOfAgile());//
    }

    // ------------------ HELMETS ----------------- \\

    EquippableItem leatherCap() {
        EquippableItem equipItem = new EquippableItem("Leather Cap");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Boina de Couro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Boina de Cuero");

        equipItem.slotPart = Enums.SlotPart.HEAD;
        equipItem.defense = 1;
        equipItem.marketValue = 5;
        equipItem.weight = .2f;
        equipItem.type = Enums.ItemType.HELMET;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A simple piece of clothing made of leather to wear in the head.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma peça simples de roupa feita de couro para usar na cabeça.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una sencilla pieza de ropa hecha de cuero para llevar en la cabeza.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem ironHelmet() {
        EquippableItem equipItem = new EquippableItem("Iron Helmet");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Elmo de Ferro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Yelmo de Hierro");

        equipItem.slotPart = Enums.SlotPart.HEAD;
        equipItem.defense = 2;
        equipItem.marketValue = 18;
        equipItem.weight = .6f;
        equipItem.type = Enums.ItemType.HELMET;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "If you want a cheap and efficient head protection, this is the helmet for you.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Se você quer uma proteção de cabeça barata e eficiente, este é o capacete para você.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Si buscas una protección para la cabeza barata y eficaz, este es tu casco.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem copperHelmet() {
        EquippableItem equipItem = new EquippableItem("Copper Helmet");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Elmo de Cobre");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Yelmo de Cobre");

        equipItem.slotPart = Enums.SlotPart.HEAD;
        equipItem.defense = 3;
        equipItem.marketValue = 45;
        equipItem.weight = .5f;
        equipItem.type = Enums.ItemType.HELMET;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The copper color give to this well shaped helmet a nice appearance.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A cor cobre dá a este capacete bem moldado uma aparência agradável.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El color cobre le da a este casco bien formado una apariencia agradable.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem steelHelmet() {
        EquippableItem equipItem = new EquippableItem("Steel Helmet");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Elmo de Aço");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Yelmo de Acero");

        equipItem.slotPart = Enums.SlotPart.HEAD;
        equipItem.defense = 4;
        equipItem.marketValue = 95;
        equipItem.weight = 1.1f;
        equipItem.type = Enums.ItemType.HELMET;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 6) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Not comfortable to put this in your head, it is heavy and limit a little bit the movement, but for sure it protects well.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Não é confortável colocar isso na cabeça, é pesado e limita um pouco os movimentos, mas com certeza protege bem.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "No es cómodo ponérselo en la cabeza, es pesado y limita un poco el movimiento, pero seguro que protege bien.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem goldenHelmet() {
        EquippableItem equipItem = new EquippableItem("Golden Helmet");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Elmo de Oro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Yelmo de Oro");

        equipItem.slotPart = Enums.SlotPart.HEAD;
        equipItem.defense = 3;
        equipItem.marketValue = 50;
        equipItem.weight = .4f;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.CHARISMA, 1));
        equipItem.type = Enums.ItemType.HELMET;
        equipItem.rarity = Enums.Rarity.UNCOMMON;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 5) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Who is fancy enough to wear a helmet made of gold? Well, it protects but gets all the attention.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Quem é chique o suficiente para usar um capacete feito de ouro? Bem, ele protege, mas recebe toda a atenção.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "¿Quién es lo suficientemente elegante como para llevar un casco de oro? Bueno, protege, pero atrae toda la atención.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem caltraniumHelmet() {
        EquippableItem equipItem = new EquippableItem("Caltranium Helmet");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Elmo de Caltranio");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Yelmo de Caltranio");

        equipItem.slotPart = Enums.SlotPart.HEAD;
        equipItem.defense = 5;
        equipItem.marketValue = 150;
        equipItem.weight = .7f;
        equipItem.type = Enums.ItemType.HELMET;
        equipItem.rarity = Enums.Rarity.RARE;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 10) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Hard enough to save your head from a direct cut or smash. Very well shaped.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Duro o bastante para salvar sua cabeça de um corte direto ou esmagamento. Muito bem moldado.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Suficientemente duro para proteger la cabeza de un corte directo o un golpe. Muy bien formado.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem endlessHelmet() {
        EquippableItem equipItem = new EquippableItem("Endless Helmet");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Elmo Endless");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Yelmo Endless");

        equipItem.slotPart = Enums.SlotPart.HEAD;
        equipItem.defense = 6;
        equipItem.marketValue = 40;
        equipItem.gemCost = 15;
        equipItem.weight = .5f;
        equipItem.type = Enums.ItemType.HELMET;
        equipItem.rarity = Enums.Rarity.SPECIAL;

        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.CHARISMA, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.LUCK, 2));

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is so unique that its price is priceless. It is mystical and very resistant.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É tão único que seu preço é quase inestimável. É místico e muito resistente.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es tan único que su precio no tiene precio. Es místico y muy resistente.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem helmOfFocus() {
        EquippableItem equipItem = new EquippableItem("Helm of Focus");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Capacete do Foco");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Casco de Enfoque");

        equipItem.slotPart = Enums.SlotPart.HEAD;
        equipItem.defense = 2;
        equipItem.marketValue = 38;
        equipItem.weight = .5f;
        equipItem.criticalChanceIncrease = 6;
        equipItem.type = Enums.ItemType.HELMET;
        equipItem.rarity = Enums.Rarity.UNCOMMON;
        //equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.CRITICAL_CHANCE, 6, Enums.StatusModifier.INCREASE));

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The shape is perfect for the head and its mystical power grants a mental bonus.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O formato é perfeito para a cabeça e seu poder místico concede um bônus mental.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La forma es perfecta para la cabeza y su poder místico otorga un bono mental.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem hoodOfMagician() {
        EquippableItem equipItem = new EquippableItem("Hood of Magician");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Capuz dos Magos");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Capucha de Hechiero");

        equipItem.slotPart = Enums.SlotPart.HEAD;
        equipItem.defense = 2;
        equipItem.marketValue = 28;
        equipItem.weight = .2f;
        equipItem.type = Enums.ItemType.HELMET;
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 1));

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Sewn with good threads and thick fabrics. It has some magical force.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Costurado com bons fios e tecidos grossos. Tem alguma força mágica.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cosido con buenos hilos y telas gruesas, tiene cierta fuerza mágica.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem hatOfWise() {
        EquippableItem equipItem = new EquippableItem("Hat of Wise");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Chapéu do Sábio");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sombrero de lo Sabio");

        equipItem.slotPart = Enums.SlotPart.HEAD;
        equipItem.defense = 1;
        equipItem.marketValue = 25;
        equipItem.weight = .2f;
        equipItem.type = Enums.ItemType.HELMET;
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 2));

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Made by experienced magicians of the wizards guild. It has its charm and magic.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Feito por mágicos experientes da guilda dos bruxos. Tem seu charme e magia.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hecho por magos experimentados del gremio de magos. Tiene su encanto y magia.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem supremeHelm() {
        EquippableItem equipItem = new EquippableItem("Supreme Helm");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Capacete Supremo");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Casco Supremo");

        equipItem.slotPart = Enums.SlotPart.HEAD;
        equipItem.defense = 4;
        equipItem.marketValue = 75;
        equipItem.gemCost = 5;
        equipItem.weight = .4f;
        equipItem.type = Enums.ItemType.HELMET;
        equipItem.rarity = Enums.Rarity.RARE;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.STRENGTH, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 2));

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 7) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The majority of the people can't say what was used to forge this helmet. It is special and unique.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A maioria das pessoas não sabem dizer o que foi usado para forjar este capacete. Ele é especial e único.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La mayoría de la gente no sabe decir con qué se forjó este casco. Es especial y único.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem hoodOfFortitude() {
        EquippableItem equipItem = new EquippableItem("Hood of Fortitude");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Capuz da Resistência");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Capucha de la Resistencia");

        equipItem.slotPart = Enums.SlotPart.HEAD;
        equipItem.defense = 2;
        equipItem.marketValue = 40;
        equipItem.weight = .2f;
        equipItem.type = Enums.ItemType.HELMET;
        equipItem.classes.add(ClassesIds.SORCERER);
        equipItem.classes.add(ClassesIds.DRUID);
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.classes.add(ClassesIds.THIEF);
        equipItem.rarity = Enums.Rarity.UNCOMMON;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP_MODIFIER, 3));

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A special and mystic aura can be felt around this very well sewn hood.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma aura especial e mística pode ser sentida em torno deste capuz muito bem costurado.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Alrededor de esta capucha muy bien cosida se puede sentir un aura especial y mística.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    // ------------------ BOOTS ----------------- \\

    EquippableItem leatherBoots() {
        EquippableItem equipItem = new EquippableItem("Leather Boots");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Botas de Couro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Botas de Cuero");

        equipItem.slotPart = Enums.SlotPart.FEET;
        equipItem.defense = 1;
        equipItem.marketValue = 6;
        equipItem.weight = .3f;
        equipItem.type = Enums.ItemType.BOOTS;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Simple. Protects, but probably causes stinky feet.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Simples. Protege, mas provavelmente causa chulé.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sencillo. Protege, pero probablemente provoque mal olor en los pies.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem ironBoots() {
        EquippableItem equipItem = new EquippableItem("Iron Boots");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Botas de Ferro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Botas de Hierro");

        equipItem.slotPart = Enums.SlotPart.FEET;
        equipItem.defense = 2;
        equipItem.marketValue = 18;
        equipItem.weight = .7f;
        equipItem.type = Enums.ItemType.BOOTS;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "You can't imagine walking everywhere wearing these heavy iron boots.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Você não consegue imaginar andar por aí usando essas pesadas botas de ferro.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "No puedes imaginarte caminando por todas partes usando estas pesadas botas de hierro.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem copperBoots() {
        EquippableItem equipItem = new EquippableItem("Copper Boots");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Botas de Cobre");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Botas de Cobre");

        equipItem.slotPart = Enums.SlotPart.FEET;
        equipItem.defense = 3;
        equipItem.marketValue = 45;
        equipItem.weight = .7f;
        equipItem.type = Enums.ItemType.BOOTS;

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Its interior is filled with cloth and the exterior made of copper to reinforce the protection.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Seu interior é preenchido com tecido e o exterior feito de cobre para reforçar a proteção.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Su interior está relleno de tela y el exterior de cobre para reforzar la protección.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem steelBoots() {
        EquippableItem equipItem = new EquippableItem("Steel Boots");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Botas de Aço");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Botas de Acero");

        equipItem.slotPart = Enums.SlotPart.FEET;
        equipItem.defense = 4;
        equipItem.marketValue = 100;
        equipItem.weight = 1f;
        equipItem.type = Enums.ItemType.BOOTS;
        equipItem.classes.add(ClassesIds.WARRIOR);
        equipItem.classes.add(ClassesIds.ARCHER);
        equipItem.classes.add(ClassesIds.THIEF);

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 5) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Heavy and very efficient protection for your feet.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Proteção pesada e muito eficiente para seus pés.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Protección pesada y muy eficaz para tus pies.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem goldenBoots() {
        EquippableItem equipItem = new EquippableItem("Golden Boots");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Botas de Ouro");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Botas de Oro");

        equipItem.slotPart = Enums.SlotPart.FEET;
        equipItem.defense = 3;
        equipItem.marketValue = 55;
        equipItem.weight = .5f;
        equipItem.type = Enums.ItemType.BOOTS;
        equipItem.rarity = Enums.Rarity.UNCOMMON;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.CHARISMA, 1));

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 5) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Really, who wears gold in the feet?");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sério, quem usa ouro nos pés?");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "En realidad ¿quién lleva oro en los pies?");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem caltraniumBoots() {
        EquippableItem equipItem = new EquippableItem("Caltranium Boots");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Botas de Caltranio");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Botas de Caltranio");

        equipItem.slotPart = Enums.SlotPart.FEET;
        equipItem.defense = 5;
        equipItem.marketValue = 160;
        equipItem.weight = .9f;
        equipItem.type = Enums.ItemType.BOOTS;
        equipItem.rarity = Enums.Rarity.RARE;

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 10) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The perfect metal for your protection. Best shape for feet protection.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O metal perfeito para sua proteção. Melhor formato para proteção dos pés.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El metal perfecto para tu protección. La mejor forma para proteger los pies.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem endlessBoots() {
        EquippableItem equipItem = new EquippableItem("Endless Boots");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Botas Endless");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Botas Endless");

        equipItem.slotPart = Enums.SlotPart.FEET;
        equipItem.defense = 6;
        equipItem.marketValue = 50;
        equipItem.gemCost = 15;
        equipItem.weight = .9f;
        equipItem.type = Enums.ItemType.BOOTS;
        equipItem.rarity = Enums.Rarity.SPECIAL;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 2));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.LUCK, 3));

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is so unique that its price is priceless. It is mystical and very resistant.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É tão único que seu preço é quase inestimável. É místico e muito resistente.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es tan único que su precio no tiene precio. Es místico y muy resistente.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem supremeBoots() {
        EquippableItem equipItem = new EquippableItem("Supreme Boots");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Botas Supremas");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Botas Supremas");

        equipItem.slotPart = Enums.SlotPart.FEET;
        equipItem.defense = 4;
        equipItem.marketValue = 50;
        equipItem.gemCost = 5;
        equipItem.weight = .9f;
        equipItem.type = Enums.ItemType.BOOTS;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.STRENGTH, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MAGIC, 1));
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 1));

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 5) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It is soft to wear and its magical force will grant defense and power.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "É macio de usar e sua força mágica concederá defesa e poder.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Es suave de llevar y su fuerza mágica otorgará defensa y poder.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }

    EquippableItem shoesOfAgile() {
        EquippableItem equipItem = new EquippableItem("Shoes of Agile");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sapatos da Agilidade");
        equipItem.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Botas de Ágil");

        equipItem.slotPart = Enums.SlotPart.FEET;
        equipItem.defense = 2;
        equipItem.marketValue = 40;
        equipItem.weight = .2f;
        equipItem.type = Enums.ItemType.BOOTS;
        equipItem.modifiers.add(new AttributeModifierValue(Enums.AttributeName.AGILITY, 2));

        equipItem.requirementValidations = (chara, ctx) -> {
            if (chara.level >= 3) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NEED_LEVEL;
        };

        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Magical leather and really light materials make this shoes the perfect for easy motion.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Couro mágico e materiais realmente leves fazem deste calçado o calçado perfeito para movimentos fáceis.");
        equipItem.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cuero mágico y materiales realmente ligeros hacen que estos zapatos sean perfectos para moverse con facilidad.");

        equipItem.setupDefaultListeners();
        return equipItem;
    }
}
