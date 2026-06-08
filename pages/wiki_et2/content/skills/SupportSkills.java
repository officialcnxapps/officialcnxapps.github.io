package com.cnx.endlesstalestwo.data.skills;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.classes.ClassesIds;
import com.cnx.endlesstalestwo.data.items.ItemsIds;
import com.cnx.endlesstalestwo.entities.AttributesModifier;
import com.cnx.endlesstalestwo.entities.Skill;
import com.cnx.endlesstalestwo.entities.StatusModifier;
import com.cnx.endlesstalestwo.enums.Enums;
import com.cnx.endlesstalestwo.libs.LibInventory;

public class SupportSkills extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.SKILL, rage());//
        App.DataManager.add(Enums.DataTypes.SKILL, focus());//
        App.DataManager.add(Enums.DataTypes.SKILL, barkSkin());//
        App.DataManager.add(Enums.DataTypes.SKILL, shadowBarrier());//
        App.DataManager.add(Enums.DataTypes.SKILL, frozenShield());//
        App.DataManager.add(Enums.DataTypes.SKILL, leafLightness());//
        App.DataManager.add(Enums.DataTypes.SKILL, totalPrecision());//
        App.DataManager.add(Enums.DataTypes.SKILL, natureAbsorption());//
        App.DataManager.add(Enums.DataTypes.SKILL, supremeBulk());//
        App.DataManager.add(Enums.DataTypes.SKILL, arrowOfGods());//
        App.DataManager.add(Enums.DataTypes.SKILL, teleportation());//
        App.DataManager.add(Enums.DataTypes.SKILL, luckyBlood());//
        App.DataManager.add(Enums.DataTypes.SKILL, foodConjuration());//
    }

    Skill rage() {
        Skill skill = new Skill("Rage", 10, 3, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Furor");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Rabia");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Increase STRENGTH by 6 during 3 turns.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aumenta a FORÇA em 6 por 3 turnos.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aumenta la FUERZA en 6 durante 3 turnos.");

        skill.type = Enums.SkillTypes.SUPPORT;
        skill.targets = Enums.TargetOptions.SELF_USAGE;

        StatusModifier strengthStatus = new StatusModifier(Enums.StatusModifier.INCREASE);
        strengthStatus.durationTurns = 4;
        strengthStatus.attributesModifier.add(new AttributesModifier(Enums.AttributeName.STRENGTH, 6));
        strengthStatus.isSelfUsage = true;
        skill.statusModifiers.add(strengthStatus);

        skill.classes.add(ClassesIds.WARRIOR);
        skill.soundEffectFile = "skill_support";
        return skill;
    }

    Skill focus() {
        Skill skill = new Skill("Focus", 8, 4, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Foco");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Foco");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Increase CRITICAL CHANCE by 30% during 2 turns.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aumenta a CHANCE CRÍTICA em 30% por 2 turnos.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aumenta la PROBABILIDAD CRÍTICA en un 30% durante 2 turnos.");

        skill.type = Enums.SkillTypes.SUPPORT;
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_support";

        StatusModifier status = new StatusModifier(Enums.StatusModifier.INCREASE);
        status.durationTurns = 4;
        status.attributesModifier.add(new AttributesModifier(Enums.AttributeName.CRITICAL_CHANCE, 30, Enums.ValueType.PERCENTAGE));
        status.isSelfUsage = true;
        skill.statusModifiers.add(status);

        skill.classes.add(ClassesIds.ARCHER);
        skill.classes.add(ClassesIds.THIEF);
        return skill;
    }

    Skill barkSkin() {
        Skill skill = new Skill("Bark Skin", 7, 3, Enums.Elements.EARTH);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pele de Casca");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Piel de Corteza");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Increase DEFENSE by 6 during 3 turns.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aumenta a DEFESA em 6 por 3 turnos.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aumenta la DEFENSA en 6 durante 3 turnos.");

        skill.type = Enums.SkillTypes.SUPPORT;
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_support";

        StatusModifier status = new StatusModifier(Enums.StatusModifier.INCREASE);
        status.durationTurns = 4;
        status.attributesModifier.add(new AttributesModifier(Enums.AttributeName.DEFENSE, 6));
        status.isSelfUsage = true;
        skill.statusModifiers.add(status);

        skill.classes.add(ClassesIds.DRUID);
        return skill;
    }

    Skill shadowBarrier() {
        Skill skill = new Skill("Shadow Barrier", 16, 8, Enums.Elements.DARK);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Barreira de Sombras");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Barrera de Sombras");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Increase DEFENSE by 6 during 3 turns.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aumenta a DEFESA em 6 por 3 turnos.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aumenta la DEFENSA en 6 durante 3 turnos.");

        skill.type = Enums.SkillTypes.SUPPORT;
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_support";

        StatusModifier status = new StatusModifier(Enums.StatusModifier.INCREASE);
        status.durationTurns = 4;
        status.attributesModifier.add(new AttributesModifier(Enums.AttributeName.DEFENSE, 6));
        status.isSelfUsage = true;
        skill.statusModifiers.add(status);

        skill.classes.add(ClassesIds.THIEF);
        return skill;
    }

    Skill frozenShield() {
        Skill skill = new Skill("Frozen Shield", 13, 6, Enums.Elements.DARK);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Escudo de Gelo");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Escudo de Hielo");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Increase DEFENSE by 5 during 3 turns.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aumenta a DEFESA em 5 por 3 turnos.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aumenta la DEFENSA en 5 durante 3 turnos.");

        skill.type = Enums.SkillTypes.SUPPORT;
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_support";

        StatusModifier status = new StatusModifier(Enums.StatusModifier.INCREASE);
        status.durationTurns = 4;
        status.attributesModifier.add(new AttributesModifier(Enums.AttributeName.DEFENSE, 5));
        status.isSelfUsage = true;

        skill.classes.add(ClassesIds.SORCERER);
        skill.statusModifiers.add(status);
        return skill;
    }

    Skill leafLightness() {
        Skill skill = new Skill("Leaf Lightness", 17, 11, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Leveza das Folhas");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Ligereza de Hojas");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Increase AGILITY by 10 during 4 turns.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aumenta a AGILIDADE em 10 por 4 turnos.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aumenta la AGILIDAD en 10 durante 4 turnos.");

        skill.type = Enums.SkillTypes.SUPPORT;
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_support";

        StatusModifier status = new StatusModifier(Enums.StatusModifier.INCREASE);
        status.durationTurns = 5;
        status.attributesModifier.add(new AttributesModifier(Enums.AttributeName.AGILITY, 10));
        status.isSelfUsage = true;
        skill.statusModifiers.add(status);

        skill.classes.add(ClassesIds.ARCHER);
        skill.classes.add(ClassesIds.THIEF);
        return skill;
    }

    Skill totalPrecision() {
        Skill skill = new Skill("Total Precision", 14, 6, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Precisão Total");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Precisión Total");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Increase CRITICAL CHANCE by 100% during 1 turn.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aumenta a CHANCE CRÍTICA em 100% por 1 turno.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aumenta la PROBABILIDAD CRÍTICA en un 100% durante 1 turno.");

        skill.type = Enums.SkillTypes.SUPPORT;
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_support";

        StatusModifier status = new StatusModifier(Enums.StatusModifier.INCREASE);
        status.durationTurns = 3;
        status.attributesModifier.add(new AttributesModifier(Enums.AttributeName.CRITICAL_CHANCE, 100));
        status.isSelfUsage = true;
        skill.statusModifiers.add(status);

        skill.classes.add(ClassesIds.ARCHER);
        skill.classes.add(ClassesIds.WARRIOR);
        return skill;
    }

    Skill natureAbsorption() {
        Skill skill = new Skill("Nature Absorption", 15, 10, Enums.Elements.EARTH);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Absorção da Natureza");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Absorción Natural");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Increase MAGIC by 100% during 3 turns.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aumenta a MAGIA em 100% por 3 turnos.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aumenta la MAGIA en un 100% durante 3 turnos.");

        skill.type = Enums.SkillTypes.SUPPORT;
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_support";

        StatusModifier status = new StatusModifier(Enums.StatusModifier.INCREASE);
        status.durationTurns = 4;
        status.attributesModifier.add(new AttributesModifier(Enums.AttributeName.MAGIC, 100, Enums.ValueType.PERCENTAGE));
        status.isSelfUsage = true;

        skill.classes.add(ClassesIds.ARCHER);
        skill.classes.add(ClassesIds.DRUID);
        skill.statusModifiers.add(status);
        return skill;
    }

    Skill supremeBulk() {
        Skill skill = new Skill("Supreme Bulk", 28, 16, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Inchaço Supremo");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bulto Supremo");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Increase STRENGTH by 100% during 2 turns.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aumenta a FORÇA em 100% por 2 turnos.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aumenta la FUERZA en un 100% durante 2 turnos.");
        skill.soundEffectFile = "skill_support";

        skill.type = Enums.SkillTypes.SUPPORT;
        skill.targets = Enums.TargetOptions.SELF_USAGE;

        StatusModifier status = new StatusModifier(Enums.StatusModifier.INCREASE);
        status.durationTurns = 3;
        status.attributesModifier.add(new AttributesModifier(Enums.AttributeName.STRENGTH, 100, Enums.ValueType.PERCENTAGE));
        status.attributesModifier.add(new AttributesModifier(Enums.AttributeName.DEFENSE, 4));
        status.isSelfUsage = true;

        skill.classes.add(ClassesIds.WARRIOR);
        skill.statusModifiers.add(status);
        return skill;
    }

    Skill arrowOfGods() {
        Skill skill = new Skill("Arrow of Gods", 28, 23, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Flecha dos Deuses");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Flecha de los Dioses");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Increase STRENGTH by 9 and CRITICAL CHANCE by 100% during 1 turn.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aumenta a FORÇA em 9 e CHANCE CRÍTICA em 100% por 1 turno.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aumenta la FUERZA en 9 y la PROBABILIDAD CRÍTICA en un 100% durante 1 turno.");

        skill.type = Enums.SkillTypes.SUPPORT;
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_support";

        StatusModifier status = new StatusModifier(Enums.StatusModifier.INCREASE);
        status.durationTurns = 3;
        status.attributesModifier.add(new AttributesModifier(Enums.AttributeName.STRENGTH, 9, Enums.ValueType.NUMERIC));
        status.attributesModifier.add(new AttributesModifier(Enums.AttributeName.CRITICAL_CHANCE, 100));
        status.isSelfUsage = true;

        skill.classes.add(ClassesIds.ARCHER);
        skill.statusModifiers.add(status);
        return skill;
    }

    Skill teleportation() {
        Skill skill = new Skill("Teleportation", 20, 11, Enums.Elements.LIGHT);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Teletransporte");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Teletransportación");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Increase AGILITY by 50 during 90 minutes.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aumenta a AGILIDADE em 50 por 90 minutos.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aumenta la AGILIDAD en 50 durante 90 minutos.");

        skill.type = Enums.SkillTypes.SUPPORT;
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_support";

        StatusModifier status = new StatusModifier(Enums.StatusModifier.INCREASE);
        status.durationMinutes = 90;
        status.attributesModifier.add(new AttributesModifier(Enums.AttributeName.AGILITY, 50, Enums.ValueType.NUMERIC));
        status.isSelfUsage = true;

        skill.inBattleUsable = false;
        skill.inMenuUsable = true;
        skill.classes.add(ClassesIds.SORCERER);
        skill.statusModifiers.add(status);
        return skill;
    }

    Skill luckyBlood() {
        //TODO - Major - TEST
        Skill skill = new Skill("Lucky Blood", 15, 25, Enums.Elements.DARK);
        skill.hpCost = 8;
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Sangue de Sorte");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Sangre Afortunada");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Increase LUCK by 50 during 60 minutes.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Aumenta a SORTE em 50 por 60 minutos.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aumenta la SUERTE en 50 durante 60 minutos.");

        skill.type = Enums.SkillTypes.SUPPORT;
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_support";

        StatusModifier status = new StatusModifier(Enums.StatusModifier.INCREASE);
        status.durationMinutes = 60;
        status.attributesModifier.add(new AttributesModifier(Enums.AttributeName.LUCK, 50, Enums.ValueType.NUMERIC));
        status.isSelfUsage = true;

        skill.inBattleUsable = false;
        skill.inMenuUsable = true;
        skill.classes.add(ClassesIds.WARRIOR);
        skill.classes.add(ClassesIds.ARCHER);
        skill.classes.add(ClassesIds.THIEF);
        skill.statusModifiers.add(status);
        return skill;
    }

    Skill foodConjuration() {
        Skill skill = new Skill("Food Conjuration", 10, 4, Enums.Elements.EARTH);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Conjuração Alimentar");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Conjuro de Comida");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Magically generates some food.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Magicamente cria um pouco de comida.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Crea mágicamente algo de comida.");
        skill.soundEffectFile = "skill_support";

        skill.type = Enums.SkillTypes.SUPPORT;
        skill.targets = Enums.TargetOptions.SELF_USAGE;

        skill.listeners = new Skill.SkillListeners() {
            @Override
            public void onMenuCast() {
                LibInventory.addToInventory(ItemsIds.POMEGRANATE, 2, App.getPlayerChar());
            }

            @Override
            public void onBattleCast() {

            }

            @Override
            public void onLearn() {

            }
        };

        skill.inBattleUsable = false;
        skill.inMenuUsable = true;
        skill.classes.add(ClassesIds.DRUID);
        skill.classes.add(ClassesIds.ARCHER);
        return skill;
    }
}
