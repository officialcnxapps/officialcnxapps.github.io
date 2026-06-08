package com.cnx.endlesstalestwo.data.locations.wazel;

import static com.cnx.endlesstalestwo.enums.Enums.RequirementVerification.NEED_VARIABLES;
import static com.cnx.endlesstalestwo.enums.Enums.RequirementVerification.OK;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.actions.ActionsIds;
import com.cnx.endlesstalestwo.data.locations.LocationsIds;
import com.cnx.endlesstalestwo.data.npcs.NpcsIds;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.regions.RegionsIds;
import com.cnx.endlesstalestwo.data.shops.ShopsIds;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Cities extends DataHelper {

    //TRADUZIR
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, wazel());//
        App.DataManager.add(Enums.DataTypes.LOCALE, wazelRuins());//
    }

    Locale wazel() {
        Locale locale = new Locale("Wazel", RegionsIds.WAZEL);

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The city is surrounded by high walls made of light-colored stones and clay. The houses have rounded roofs and the tents are all very colorful. There is sand everywhere but the streets are made of small stones. Tapestries are present in almost all decorations, both external and internal.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A cidade é cercada por altos muros feitos com pedras claras e argila. As casas tem telhados arredondados e as tendas são todas muito coloridas. Há areia para todo lado mas as ruas são feitas com pequenas pedras. A tapeçaria é presente em quase todas decorações, externas e internas.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "");

        locale.actions.add(ActionsIds.HELP_PEOPLE);

        locale.places.add(LocationsIds.WAZEL_INN);
        locale.places.add(LocationsIds.WAZEL_COMMUNITY_KITCHEN);

        locale.shops.add(ShopsIds.WAZEL_STABLE);
        locale.shops.add(ShopsIds.TOOLS_STORE);
        locale.shops.add(ShopsIds.WAZEL_ARSENAL);
        locale.shops.add(ShopsIds.SHINE_GEMS);

        locale.npcs.add(NpcsIds.PUCA);

        locale.type = Enums.LocationTypes.CITY;
        locale.musicFile = "medieval_city_wazel";

        locale.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.WAZEL_BATTLE, 6)
                    || LibQuest.isQuestComplete(chara, QuestsIds.WAZEL_BATTLE)) {
                return NEED_VARIABLES;
            }
            return OK;
        };

        locale.alwaysShow = false;
        return locale;
    }

    Locale wazelRuins() {
        Locale locale = new Locale("Wazel Ruins", RegionsIds.WAZEL);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ruínas de Wazel");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Ruinas de Wazel");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "The city now lies in ruin. Its once-bright stone walls are cracked and scorched, with sections collapsed under the force of a dark assault. The streets, once paved with small stones, are buried in sand and ash. Rounded rooftops lie broken, and colorful tents hang in faded shreds where the citizesn try to rebuild their lifes.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "A cidade agora jaz em ruínas. Seus muros de pedra, antes claros e brilhantes, estão rachados e queimados, com trechos desmoronados pela força de um ataque sombrio. As ruas, antes calçadas com pequenas pedras, estão cobertas de areia e cinzas. Os telhados arredondados estão quebrados, e as tendas coloridas pendem em tiras desbotadas, onde os cidadãos tentam reconstruir suas vidas.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "La ciudad yace ahora en ruinas. Sus muros de piedra, antes brillantes, están agrietados y chamuscados, con secciones colapsadas por la fuerza de un oscuro asalto. Las calles, antes empedradas, están sepultadas bajo arena y ceniza. Los techos redondeados están rotos, y las coloridas tiendas cuelgan en jirones descoloridos, donde los ciudadanos intentan reconstruir sus vidas.");

        locale.actions.add(ActionsIds.HELP_PEOPLE);

        locale.shops.add(ShopsIds.WAZEL_STABLE);
        locale.shops.add(ShopsIds.TOOLS_STORE);
        locale.shops.add(ShopsIds.WAZEL_ARSENAL);
        locale.shops.add(ShopsIds.SHINE_GEMS);

        locale.places.add(LocationsIds.WAZEL_RUINS_COMMUNITY_KITCHEN);

        locale.npcs.add(NpcsIds.PUCA);

        locale.type = Enums.LocationTypes.CITY;
        locale.musicFile = "medieval_city_wazel";

        locale.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.WAZEL_BATTLE, 6)
                    || LibQuest.isQuestComplete(chara, QuestsIds.WAZEL_BATTLE)) {
                return OK;
            }
            return NEED_VARIABLES;
        };
        locale.alwaysShow = false;

        return locale;
    }
}
