package com.cnx.endlesstalestwo.data.skills;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.classes.ClassesIds;
import com.cnx.endlesstalestwo.entities.AttributeModifierValue;
import com.cnx.endlesstalestwo.entities.Skill;
import com.cnx.endlesstalestwo.entities.StatusModifier;
import com.cnx.endlesstalestwo.enums.Enums;

public class HealingSkills extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.SKILL, cureWounds());//
        App.DataManager.add(Enums.DataTypes.SKILL, treatWounds());//
        App.DataManager.add(Enums.DataTypes.SKILL, natureHealing());//
        App.DataManager.add(Enums.DataTypes.SKILL, magicHealing());//
        App.DataManager.add(Enums.DataTypes.SKILL, intensiveTreatment());//
        App.DataManager.add(Enums.DataTypes.SKILL, divineCure());//
        App.DataManager.add(Enums.DataTypes.SKILL, obscureAid());//
        App.DataManager.add(Enums.DataTypes.SKILL, natureCure());//
    }

    Skill cureWounds() {
        Skill skill = new Skill("Cure Wounds", 5, 1, Enums.Elements.LIGHT);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cura Ferimentos");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cura Heridas");

        skill.inMenuUsable = true;
        skill.type = Enums.SkillTypes.HEALING;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, 4, 7, 0, Enums.StatusModifier.INCREASE));
        skill.classes.add(ClassesIds.SORCERER);
        skill.classes.add(ClassesIds.DRUID);
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_healing";

        return skill;
    }

    Skill treatWounds() {
        Skill skill = new Skill("Treat Wounds", 7, 2, Enums.Elements.LIGHT);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Tratar Ferimentos");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tratar Heridas");

        skill.inMenuUsable = true;
        skill.type = Enums.SkillTypes.HEALING;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, 4, 7, 1, Enums.StatusModifier.INCREASE));
        skill.classes.add(ClassesIds.ARCHER);
        skill.classes.add(ClassesIds.THIEF);
        skill.classes.add(ClassesIds.WARRIOR);
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_healing";

        return skill;
    }

    Skill natureHealing() {
        Skill skill = new Skill("Nature Healing", 7, 3, Enums.Elements.EARTH);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cura Natural");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cura Natural");

        skill.inMenuUsable = true;
        skill.type = Enums.SkillTypes.HEALING;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, 5, 8, 2, Enums.StatusModifier.INCREASE));
        skill.classes.add(ClassesIds.DRUID);
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_healing";

        return skill;
    }

    Skill magicHealing() {
        Skill skill = new Skill("Magic Healing", 9, 5, Enums.Elements.LIGHT);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cura Mágica");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cura Magica");

        skill.inMenuUsable = true;
        skill.type = Enums.SkillTypes.HEALING;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, 10, 14, 2, Enums.StatusModifier.INCREASE));
        skill.classes.add(ClassesIds.SORCERER);
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_healing";

        return skill;
    }

    Skill intensiveTreatment() {
        Skill skill = new Skill("Intensive Treatment", 4, 6, Enums.Elements.LIGHT);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Tratamento Intensivo");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tratamiento Intensivo");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Cure a little bit and clear bad status.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cura um pouco e limpa os status ruins.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cura un poco y limpia los estados malos.");

        skill.inMenuUsable = true;
        skill.type = Enums.SkillTypes.HEALING;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, 3, 3, 1, Enums.StatusModifier.INCREASE));
        skill.statusModifiers.add(new StatusModifier(Enums.StatusModifier.CURE_ALL));
        skill.classes.add(ClassesIds.SORCERER);
        skill.classes.add(ClassesIds.DRUID);
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_healing";

        return skill;
    }

    Skill divineCure() {
        Skill skill = new Skill("Divine Cure", 22, 20, Enums.Elements.LIGHT);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Cura Divina");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cura Divina");

        skill.inMenuUsable = true;
        skill.type = Enums.SkillTypes.HEALING;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, 30, 38, 4, Enums.StatusModifier.INCREASE));
        skill.classes.add(ClassesIds.SORCERER);
        skill.classes.add(ClassesIds.DRUID);
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_healing";

        return skill;
    }

    Skill obscureAid() {
        Skill skill = new Skill("Obscure Aid", 17, 10, Enums.Elements.DARK);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ajuda Obscura");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Ayuda Oscura");

        skill.inMenuUsable = true;
        skill.type = Enums.SkillTypes.HEALING;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, 14, 21, 4, Enums.StatusModifier.INCREASE));
        skill.classes.add(ClassesIds.THIEF);
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_healing";

        return skill;
    }

    Skill natureCure() {
        Skill skill = new Skill("Nature Cleansing", 12, 10, Enums.Elements.EARTH);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Limpeza da Natureza");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Limpieza de la Naturaleza");

        skill.inMenuUsable = true;
        skill.type = Enums.SkillTypes.HEALING;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, 7, 12, 0, Enums.StatusModifier.INCREASE));
        skill.statusModifiers.add(new StatusModifier(Enums.StatusModifier.CURE_ALL,100,0));
        skill.classes.add(ClassesIds.ARCHER);
        skill.classes.add(ClassesIds.DRUID);
        skill.targets = Enums.TargetOptions.SELF_USAGE;
        skill.soundEffectFile = "skill_healing";

        return skill;
    }
}
