package com.cnx.endlesstalestwo.data.locations.underworld;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.quests.QuestsIds;
import com.cnx.endlesstalestwo.data.regions.RegionsIds;
import com.cnx.endlesstalestwo.entities.Locale;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibQuest;

public class Others extends DataHelper {

    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.LOCALE, underworld());
    }

    Locale underworld() {
        Locale locale = new Locale("Underworld", RegionsIds.UNDERWORLD);
        locale.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Submundo");
        locale.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Inframundo");

        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH,
            "You've crossed into the underworld - a realm of absolute darkness. The air is thick with malevolent energy, " +
            "and the ground beneath your feet pulses with dark power. Strange whispers echo from unseen depths. " +
            "This is the domain of death itself, where the barrier between life and oblivion is paper-thin. " +
            "You can feel a terrible presence nearby - the Death King awaits.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE,
            "Você atravessou para o submundo - um reino de escuridão absoluta. O ar está denso com energia maligna, " +
            "e o chão sob seus pés pulsa com poder sombrio. Sussurros estranhos ecoam de profundezas invisíveis. " +
            "Este é o domínio da própria morte, onde a barreira entre vida e esquecimento é fina como papel. " +
            "Você pode sentir uma presença terrível por perto - o Rei da Morte aguarda.");
        locale.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH,
            "Has cruzado al inframundo - un reino de oscuridad absoluta. El aire está cargado de energía maligna, " +
            "y el suelo bajo tus pies pulsa con poder oscuro. Extraños susurros resuenan desde profundidades invisibles. " +
            "Este es el dominio de la muerte misma, donde la barrera entre vida y olvido es delgada como el papel. " +
            "Puedes sentir una presencia terrible cerca - el Rey de la Muerte aguarda.");

        locale.type = Enums.LocationTypes.DESERT;
        locale.alwaysShow = false;

        // Acessível na Part 2 (entrar e batalhar) e Part 3 (sair após vitória)
        locale.requirementValidations = (chara, ctx) -> {
            if (LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_FINAL_BATTLE, 2)
                    || LibQuest.isCharacterAtQuestPart(chara, QuestsIds.THE_FINAL_BATTLE, 3)) {
                return Enums.RequirementVerification.OK;
            }
            return Enums.RequirementVerification.NOT_OK;
        };

        return locale;
    }
}



