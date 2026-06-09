package com.cnx.endlesstalestwo.data.items;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.entities.AttributeModifierValue;
import com.cnx.endlesstalestwo.entities.ConsumableItem;
import com.cnx.endlesstalestwo.entities.StatusModifier;
import com.cnx.endlesstalestwo.enums.Enums;

public class Consumables extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.ITEM, pomegranate());//
        App.DataManager.add(Enums.DataTypes.ITEM, carrot());//
        App.DataManager.add(Enums.DataTypes.ITEM, whiteMushroom());//
        App.DataManager.add(Enums.DataTypes.ITEM, brownMushroom());//
        App.DataManager.add(Enums.DataTypes.ITEM, darkMushroom());//
        App.DataManager.add(Enums.DataTypes.ITEM, rawMeat());//
        App.DataManager.add(Enums.DataTypes.ITEM, cookedMeat());//
        App.DataManager.add(Enums.DataTypes.ITEM, soup());//
        App.DataManager.add(Enums.DataTypes.ITEM, specialSoup());//
        App.DataManager.add(Enums.DataTypes.ITEM, meatWithSpices());//
        App.DataManager.add(Enums.DataTypes.ITEM, egg());//
        App.DataManager.add(Enums.DataTypes.ITEM, tuna());//
        App.DataManager.add(Enums.DataTypes.ITEM, cookedTuna());//
        App.DataManager.add(Enums.DataTypes.ITEM, cookedCrab());//
        App.DataManager.add(Enums.DataTypes.ITEM, sardine());//
        App.DataManager.add(Enums.DataTypes.ITEM, cookedSardine());//
        App.DataManager.add(Enums.DataTypes.ITEM, bread());//
        App.DataManager.add(Enums.DataTypes.ITEM, beer());//
        App.DataManager.add(Enums.DataTypes.ITEM, wine());//
        App.DataManager.add(Enums.DataTypes.ITEM, water());//
        App.DataManager.add(Enums.DataTypes.ITEM, nuts());//
    }

    ConsumableItem pomegranate() {
        ConsumableItem consumable = new ConsumableItem("Pomegranate");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Romã");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Granada");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Its interior is filled with thin transparent arils of reddish, juicy pulp.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Seu interior é preenchido com finos arilos transparentes de polpa avermelhada e suculenta.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Su interior está lleno de finos arilos transparentes de pulpa rojiza y jugosa.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 60;
        consumable.weight = .1f;
        consumable.marketValue = 1;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 2));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 1));
        consumable.usageSound = "consumable_usage";

        return consumable;
    }

    ConsumableItem carrot() {
        ConsumableItem consumable = new ConsumableItem("Carrot");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cenoura");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Zanahoria");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An edible, orange colored root.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma raíz comestível de cor alaranjada.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una raíz de color naranja comestible.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 45;
        consumable.weight = .1f;
        consumable.marketValue = 1;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 1));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 1));
        consumable.usageSound = "consumable_usage";

        return consumable;
    }

    ConsumableItem whiteMushroom() {
        ConsumableItem consumable = new ConsumableItem("White Mushroom");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cogumelo Branco");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hongo Blanco");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An edible, white nature mushroom.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um cogumelo natural comestível e branco.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un hongo natural comestible y blanco.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 20;
        consumable.weight = .1f;
        consumable.marketValue = 2;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 3));

        return consumable;
    }

    ConsumableItem brownMushroom() {
        ConsumableItem consumable = new ConsumableItem("Brown Mushroom");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cogumelo Marrom");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hongo Marrón");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "An edible, brown nature mushroom.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um cogumelo natural comestível e marrom.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un hongo natural comestible y marrón.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 20;
        consumable.weight = .1f;
        consumable.marketValue = 2;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 3));
        consumable.usageSound = "consumable_usage";

        return consumable;
    }

    ConsumableItem darkMushroom() {
        ConsumableItem consumable = new ConsumableItem("Dark Mushroom");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cogumelo Negro");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Hongo Oscuro");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A poisonous dark nature mushroom.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "um cogumelo escuro e venenoso.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un hongo venenoso de naturaleza oscura.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 120;
        consumable.weight = .1f;
        consumable.marketValue = 8;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 2, Enums.StatusModifier.DECREASE));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 1, Enums.StatusModifier.DECREASE));
        consumable.usageSound = "consumable_usage";

        consumable.listener = () -> {
            StatusModifier poisonStatus = new StatusModifier(Enums.StatusModifier.ADD, Enums.Status.POISONED, 100, 9999);
            poisonStatus.addToPlayer(App.getPlayerChar());
        };

        return consumable;
    }

    ConsumableItem egg() {
        ConsumableItem consumable = new ConsumableItem("Egg");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ovo");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Huevo");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Very nutritive and easy to obtain from chickens and ducks.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Muito nutritivo e fácil de obter em galinhas e patos.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Muy nutritivo y fácil de obtener de pollos y patos.");

        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 1, Enums.StatusModifier.INCREASE));

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 120;
        consumable.weight = .1f;
        consumable.marketValue = 1;
        consumable.usageSound = "consumable_usage";

        return consumable;
    }

    ConsumableItem rawMeat() {
        ConsumableItem consumable = new ConsumableItem("Raw Meat");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Carne Crua");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carne Cruda");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A piece of animal flesh. Can be cooked.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um pedaço de carne animal. Pode ser cozido.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un trozo de carne de animal. Se puede cocinar.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 60;
        consumable.weight = .2f;
        consumable.marketValue = 1;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 1));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 1));
        consumable.usageSound = "consumable_usage";

        return consumable;
    }

    ConsumableItem cookedMeat() {
        ConsumableItem consumable = new ConsumableItem("Cooked Meat");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Carne Assada");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carne Rostizada");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A piece of cooked animal flesh. Very Appetizing.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um pedaço de carne animal assada. Muito apetitosa.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un trozo de carne de animal asado. muy apetecible.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 240;
        consumable.weight = .2f;
        consumable.marketValue = 2;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 3));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 2));
        consumable.usageSound = "consumable_usage";

        return consumable;
    }

    ConsumableItem soup() {
        ConsumableItem consumable = new ConsumableItem("Soup");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sopa");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sopa");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A broth of water, seasonings and vegetables");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um caldo de água temperos e legumes.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un caldo de agua, condimentos y verduras.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 180;
        consumable.weight = .1f;
        consumable.marketValue = 2;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 1));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 3));
        consumable.usageSound = "consumable_usage";

        return consumable;
    }

    ConsumableItem specialSoup() {
        ConsumableItem consumable = new ConsumableItem("Special Soup");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sopa Especial");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sopa Especial");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A broth of water and a mix of mushrooms. Delicious.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um caldo de água e uma mistura de cogumelos. Delicioso.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un caldo de agua y una mezcla de champiñones. Deliciosa.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 420;
        consumable.weight = .1f;
        consumable.marketValue = 6;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 4));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 5));
        consumable.canBeIngredient = false;
        consumable.usageSound = "consumable_usage";

        return consumable;
    }

    ConsumableItem meatWithSpices() {
        ConsumableItem consumable = new ConsumableItem("Seasoned Meat");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Carne Temperada");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carne Sazonada");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Roast meat with herbs. It has a great smell and taste.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Carne assada com ervas. Tem um ótimo cheiro e sabor.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Carne asada con hierbas. Tiene un gran olor y sabor.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 540;
        consumable.weight = .2f;
        consumable.marketValue = 4;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 4));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 3));
        consumable.canBeIngredient = false;
        consumable.usageSound = "consumable_usage";

        return consumable;
    }

    ConsumableItem tuna() {
        ConsumableItem consumable = new ConsumableItem("Tuna");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Atum");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Atún");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "It has an elongated body and a large elongated mouth. Generally bluish in color. A big fish.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "possui um corpo alongado, e uma grande boca alongada. Geralmente de cor azulada. Um grande peixe.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tiene un cuerpo alargado y una boca grande y alargada. Generalmente de color azulado. Un gran pez.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 360;
        consumable.weight = 2.4f;
        consumable.marketValue = 6;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 3));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 3));
        consumable.usageSound = "consumable_usage";

        return consumable;
    }

    ConsumableItem cookedTuna() {
        ConsumableItem consumable = new ConsumableItem("Cooked Tuna");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Atum Assado");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Atún Rostizado");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A large, meaty fish, now roasted.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um peixe grande e carnudo, agora assado.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un pescado grande y carnoso, ahora asado.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 600;
        consumable.weight = 2.2f;
        consumable.marketValue = 8;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 6));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 4));
        consumable.usageSound = "consumable_usage";
        consumable.canBeIngredient = false;

        return consumable;
    }

    ConsumableItem sardine() {
        ConsumableItem consumable = new ConsumableItem("Sardine");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sardinha");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sardina");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A small fish, found in large schools.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Um pequeno peixe, encontrado em grandes cardumes.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Un pez pequeño que se encuentra en grandes cardúmenes.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 120;
        consumable.weight = .2f;
        consumable.marketValue = 2;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 1));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 2));
        consumable.usageSound = "consumable_usage";

        return consumable;
    }

    ConsumableItem cookedSardine() {
        ConsumableItem consumable = new ConsumableItem("Cooked Sardine");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sardinha Assada");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sardina Rostizada");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "This small fish is delicious when roasted.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Este pequeno peixe fica saboroso quando assado.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Este pequeño pescado queda delicioso asado.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 240;
        consumable.weight = .2f;
        consumable.marketValue = 3;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 2));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 3));
        consumable.usageSound = "consumable_usage";
        consumable.canBeIngredient = false;

        return consumable;
    }

    ConsumableItem cookedCrab() {
        ConsumableItem consumable = new ConsumableItem("Cooked Crab");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Caranguejo Cozido");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cangrejo Cocido");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Despite its hard shell, the inner meat is soft and appetizing.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Apesar da sua casca dura, a carne interior é suave e apetitosa.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "A pesar de su cáscara dura, la carne interior es suave y apetitosa.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 240;
        consumable.weight = .3f;
        consumable.marketValue = 5;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 3));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 3));
        consumable.usageSound = "consumable_usage";

        return consumable;
    }

    ConsumableItem bread() {
        ConsumableItem consumable = new ConsumableItem("Bread");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pão");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Pan");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Flour bread is one of the easiest foods to produce and the most consumed.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "O pão de farinha é um dos alimentos mais fáceis de produzir e o mais consumido.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "El pan de harina es uno de los alimentos más fáciles de producir y de los más consumidos.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 180;
        consumable.weight = .1f;
        consumable.marketValue = 2;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 2));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 2));
        consumable.usageSound = "consumable_usage";

        return consumable;
    }

    ConsumableItem beer() {
        ConsumableItem consumable = new ConsumableItem("Beer");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cerveja");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cerveza");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The favorite alcoholic drink of tavern goers.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A bebida álcoolica preferida dos frequentadores de tavernas.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La bebida alcohólica favorita de los tabernadores.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 15;
        consumable.weight = .2f;
        consumable.marketValue = 2;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 1, Enums.StatusModifier.DECREASE));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 2));
        consumable.usageSound = "liquid_usage";

        return consumable;
    }

    ConsumableItem wine() {
        ConsumableItem consumable = new ConsumableItem("Wine");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Vinho");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Viño");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Smashed and fermented grapes that results in an alcoholic beverage.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uvas esmagadas e fermentadas que resultam em uma bebida alcoólica.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Uvas machacadas y fermentadas que dan como resultado una bebida alcohólica.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 18;
        consumable.weight = .2f;
        consumable.marketValue = 2;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 1, Enums.StatusModifier.DECREASE));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 1));
        consumable.usageSound = "liquid_usage";

        return consumable;
    }

    ConsumableItem water() {
        ConsumableItem consumable = new ConsumableItem("Water");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Água");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Agua");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Everybody needs water.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Todo mundo precisa de água.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Todos necesitan agua.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 10;
        consumable.weight = .3f;
        consumable.marketValue = 1;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 1));
        consumable.usageSound = "liquid_usage";

        return consumable;
    }

    ConsumableItem nuts() {
        ConsumableItem consumable = new ConsumableItem("Nuts");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Nozes");
        consumable.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Nueces");

        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "A kind of seed, oily and tasty.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Uma espécie de semente, oleaginosa e saborosa.");
        consumable.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Una especie de semilla, aceitosa y sabrosa.");

        consumable.type = Enums.ItemType.FOOD;
        consumable.hungryTimeRecover = 25;
        consumable.weight = .1f;
        consumable.marketValue = 1;
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.MP, 1));
        consumable.modifiers.add(new AttributeModifierValue(Enums.AttributeName.HP, 1));
        consumable.usageSound = "consumable_usage";

        return consumable;
    }
}
