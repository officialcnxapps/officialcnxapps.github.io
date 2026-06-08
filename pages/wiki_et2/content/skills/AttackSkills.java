package com.cnx.endlesstalestwo.data.skills;

import com.cnx.cnxgameengine.utils.CoreEnums;
import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.classes.ClassesIds;
import com.cnx.endlesstalestwo.entities.AttributeModifierValue;
import com.cnx.endlesstalestwo.entities.Skill;
import com.cnx.endlesstalestwo.entities.StatusModifier;
import com.cnx.endlesstalestwo.enums.Enums;

public class AttackSkills extends DataHelper {
    @Override
    public void generate() {
        App.DataManager.add(Enums.DataTypes.SKILL, quicksand());//
        App.DataManager.add(Enums.DataTypes.SKILL, fireTouch());//
        App.DataManager.add(Enums.DataTypes.SKILL, waterbend());//
        App.DataManager.add(Enums.DataTypes.SKILL, hardHit());//
        App.DataManager.add(Enums.DataTypes.SKILL, fireBomb());//
        App.DataManager.add(Enums.DataTypes.SKILL, airSpikes());
        App.DataManager.add(Enums.DataTypes.SKILL, poisonBite());//
        App.DataManager.add(Enums.DataTypes.SKILL, cyclone());//
        App.DataManager.add(Enums.DataTypes.SKILL, spinningBlades());
        App.DataManager.add(Enums.DataTypes.SKILL, magicMissile());//
        App.DataManager.add(Enums.DataTypes.SKILL, bloodRain());//
        App.DataManager.add(Enums.DataTypes.SKILL, fireRain());//
        App.DataManager.add(Enums.DataTypes.SKILL, waterStrike());//
        App.DataManager.add(Enums.DataTypes.SKILL, rockRain());//
        App.DataManager.add(Enums.DataTypes.SKILL, earthVines());//
        App.DataManager.add(Enums.DataTypes.SKILL, darkMissile());//
        App.DataManager.add(Enums.DataTypes.SKILL, iceRay());//
        App.DataManager.add(Enums.DataTypes.SKILL, furyStrike());//
        App.DataManager.add(Enums.DataTypes.SKILL, fireTorment());//
        App.DataManager.add(Enums.DataTypes.SKILL, rootsOfJustice());//
        App.DataManager.add(Enums.DataTypes.SKILL, poisonSting());//
        App.DataManager.add(Enums.DataTypes.SKILL, poisonousPolen());//
        App.DataManager.add(Enums.DataTypes.SKILL, arrowRain());//
        App.DataManager.add(Enums.DataTypes.SKILL, weakSpot());
        App.DataManager.add(Enums.DataTypes.SKILL, headshot());//
        App.DataManager.add(Enums.DataTypes.SKILL, surpriseStrike());//
        App.DataManager.add(Enums.DataTypes.SKILL, flamingDarts());//
        App.DataManager.add(Enums.DataTypes.SKILL, deathPortal());//
        App.DataManager.add(Enums.DataTypes.SKILL, avalanche());//
        App.DataManager.add(Enums.DataTypes.SKILL, thunderRay());//
        App.DataManager.add(Enums.DataTypes.SKILL, natureCompanionHit());//
        App.DataManager.add(Enums.DataTypes.SKILL, skyTorment());//
        App.DataManager.add(Enums.DataTypes.SKILL, godOfChaos());//
        App.DataManager.add(Enums.DataTypes.SKILL, supremeMissile());//
        App.DataManager.add(Enums.DataTypes.SKILL, mysticalStun());//
        App.DataManager.add(Enums.DataTypes.SKILL, tsunami());//
        App.DataManager.add(Enums.DataTypes.SKILL, shadowScam());//
        App.DataManager.add(Enums.DataTypes.SKILL, ultimateHit());//
        App.DataManager.add(Enums.DataTypes.SKILL, poisonousRain());//
        App.DataManager.add(Enums.DataTypes.SKILL, disable());//
    }

    Skill quicksand() {
        Skill skill = new Skill("Quicksand", 5, 2, Enums.Elements.EARTH);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Areia Movediça");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Arena Movediza");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -4, -7, -1, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.DRUID);

        return skill;
    }

    Skill fireTouch() {
        Skill skill = new Skill("Fire Touch", 3, 1, Enums.Elements.FIRE);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Toque de Fogo");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Toque de Fuego");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -3, -6, -2, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);

        return skill;
    }

    Skill waterbend() {
        Skill skill = new Skill("Waterbend", 3, 3, Enums.Elements.WATER);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Curva de Água");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Control de Agua");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -5, -9, -2, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);
        skill.classes.add(ClassesIds.DRUID);

        return skill;
    }

    Skill hardHit() {
        Skill skill = new Skill("Hard Hit", 8, 2, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Golpe Forte");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Golpe Duro");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -6, -9, 0, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.WARRIOR);

        return skill;
    }

    Skill fireBomb() {
        Skill skill = new Skill("Fire Bomb", 8, 4, Enums.Elements.FIRE);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Bomba de Fogo");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Bomba de Fuego");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -6, -10, -3, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);

        return skill;
    }

    Skill airSpikes() {
        Skill skill = new Skill("Air Spikes", 7, 4, Enums.Elements.WIND);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pontas de Ar");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Picos de Aire");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -5, -9, -3, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.DRUID);

        return skill;
    }

    Skill spinningBlades() {
        Skill skill = new Skill("Spinning Blades", 11, 4, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Lâminas Giratórias");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Cuchillas Giratorias");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -6, -9, -4, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.WARRIOR);
        skill.classes.add(ClassesIds.THIEF);

        return skill;
    }

    Skill magicMissile() {
        Skill skill = new Skill("Magic Missile", 10, 4, Enums.Elements.LIGHT);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Míssil Mágico");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Misil Mágico");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -3, -11, -4, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);

        return skill;
    }

    Skill bloodRain() {
        Skill skill = new Skill("Blood Rain", 18, 6, Enums.Elements.DARK);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Chuva de Sangue");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lluvia de Sangre");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.targets = Enums.TargetOptions.MULTI_TARGET;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -5, -9, -3, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.THIEF);

        return skill;
    }

    Skill poisonBite() {
        Skill skill = new Skill("Poison Bite", 5, 1, Enums.Elements.EARTH);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Mordida Venenosa");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Picadura de Veneno");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -1, -3, 0, Enums.StatusModifier.DECREASE));
        skill.statusModifiers.add(new StatusModifier(Enums.StatusModifier.ADD, Enums.Status.POISONED, 55, 9999));

        return skill;
    }

    Skill fireRain() {
        Skill skill = new Skill("Fire Rain", 20, 6, Enums.Elements.FIRE);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Chuva de Fogo");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lluvia de Fuego");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.targets = Enums.TargetOptions.MULTI_TARGET;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -6, -10, -3, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);

        return skill;
    }

    Skill waterStrike() {
        Skill skill = new Skill("Water Strike", 9, 5, Enums.Elements.WATER);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pancada de Água");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Huelga de Agua");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -6, -10, -3, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);
        skill.classes.add(ClassesIds.DRUID);

        return skill;
    }

    Skill rockRain() {
        Skill skill = new Skill("Rock Rain", 9, 3, Enums.Elements.EARTH);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Chuva de Rochas");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lluvia de Roca");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.targets = Enums.TargetOptions.MULTI_TARGET;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -5, -9, 0, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.DRUID);

        return skill;
    }

    Skill earthVines() {
        Skill skill = new Skill("Earth Vines", 24, 8, Enums.Elements.EARTH);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Videiras da Terra");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Vides de Tierra");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.targets = Enums.TargetOptions.MULTI_TARGET;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -4, -7, -1, Enums.StatusModifier.DECREASE));
        skill.statusModifiers.add(new StatusModifier(Enums.StatusModifier.ADD, Enums.Status.PARALYZED, 50, 2));
        skill.classes.add(ClassesIds.DRUID);

        return skill;
    }

    Skill cyclone() {
        Skill skill = new Skill("Cyclone", 11, 7, Enums.Elements.WIND);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ciclone");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Ciclón");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.targets = Enums.TargetOptions.MULTI_TARGET;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -8, -13, -2, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);

        return skill;
    }

    Skill darkMissile() {
        Skill skill = new Skill("Dark Missile", 15, 7, Enums.Elements.DARK);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Míssil Negro");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Misil Oscuro");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -8, -13, -2, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.THIEF);

        return skill;
    }

    Skill iceRay() {
        Skill skill = new Skill("Ice Ray", 15, 9, Enums.Elements.WATER);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Raio Gelado");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Rayo de Hielo");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -9, -15, -4, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);

        return skill;
    }

    Skill furyStrike() {
        Skill skill = new Skill("Fury Strike", 21, 7, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Golpe de Fúria");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Golpe de Furia");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -13, -18, 0, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.WARRIOR);

        return skill;
    }

    Skill fireTorment() {
        Skill skill = new Skill("Fire Torment", 20, 12, Enums.Elements.FIRE);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Tormenta de Fogo");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tormenta de Fuego");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -12, -16, -2, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);
        skill.soundEffectFile = "skill_fire_2";

        return skill;
    }

    Skill rootsOfJustice() {
        Skill skill = new Skill("Roots of Justice", 23, 12, Enums.Elements.EARTH);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Raízes da Justiça");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Raíces de la Justicia");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -11, -16, 0, Enums.StatusModifier.DECREASE));
        skill.statusModifiers.add(new StatusModifier(Enums.StatusModifier.ADD, Enums.Status.PARALYZED, 40, 2));
        skill.classes.add(ClassesIds.DRUID);

        return skill;
    }

    Skill poisonSting() {
        Skill skill = new Skill("Poison Sting", 16, 7, Enums.Elements.DARK);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Agulhas Venenosas");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aguijón Venenoso");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -5, -8, -1, Enums.StatusModifier.DECREASE));
        skill.statusModifiers.add(new StatusModifier(Enums.StatusModifier.ADD, Enums.Status.POISONED, 55, 4));
        skill.classes.add(ClassesIds.THIEF);

        return skill;
    }

    Skill poisonousPolen() {
        Skill skill = new Skill("Poisonous Polen", 30, 14, Enums.Elements.EARTH);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pólen Venenoso");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Polen Venenoso");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.targets = Enums.TargetOptions.MULTI_TARGET;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -5, -8, -3, Enums.StatusModifier.DECREASE));
        skill.statusModifiers.add(new StatusModifier(Enums.StatusModifier.ADD, Enums.Status.POISONED, 75, 4));
        skill.classes.add(ClassesIds.DRUID);

        return skill;
    }

    Skill arrowRain() {
        Skill skill = new Skill("Arrow Rain", 12, 3, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Chuva de Flechas");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lluvia de Flechas");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.targets = Enums.TargetOptions.MULTI_TARGET;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -4, -6, -1, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.ARCHER);

        return skill;
    }

    Skill weakSpot() {
        Skill skill = new Skill("Weak Spot", 10, 6, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ponto Fraco");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Punto Débil");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -7, -11, -2, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.ARCHER);
        skill.classes.add(ClassesIds.WARRIOR);
        skill.classes.add(ClassesIds.THIEF);

        return skill;
    }

    Skill headshot() {
        Skill skill = new Skill("Headshot", 25, 13, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Flechada Mortal");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Disparo a la Cabeza");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -14, -19, -4, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.ARCHER);

        return skill;
    }

    Skill surpriseStrike() {
        Skill skill = new Skill("Surprise Strike", 17, 8, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Ataque Surpresa");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Golpe Sorpresa");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -8, -13, -4, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.THIEF);
        skill.classes.add(ClassesIds.ARCHER);

        return skill;
    }

    Skill flamingDarts() {
        Skill skill = new Skill("Flaming Darts", 28, 15, Enums.Elements.FIRE);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Dardos de Fogo");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Dardos Llameantes");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -15, -20, -5, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.ARCHER);

        return skill;
    }

    Skill deathPortal() {
        Skill skill = new Skill("Death Portal", 36, 21, Enums.Elements.DARK);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Portal da Morte");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Portal de la Muerte");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -28, -35, -2, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);
        skill.classes.add(ClassesIds.THIEF);

        return skill;
    }

    Skill avalanche() {
        Skill skill = new Skill("Avalanche", 36, 21, Enums.Elements.EARTH);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Avalanche");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Avalancha");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.targets = Enums.TargetOptions.MULTI_TARGET;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -15, -22, -2, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.DRUID);

        return skill;
    }

    Skill thunderRay() {
        Skill skill = new Skill("Thunder Ray", 26, 17, Enums.Elements.LIGHT);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Raio Trovão");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Rayo de Trueno");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -15, -22, -3, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);

        return skill;
    }

    Skill natureCompanionHit() {
        Skill skill = new Skill("Nature Companion Hit", 23, 16, Enums.Elements.EARTH);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Companheiro da Natureza");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Compañero de la Naturaleza");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -13, -20, -2, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.DRUID);

        return skill;
    }

    Skill skyTorment() {
        Skill skill = new Skill("Sky Torment", 40, 28, Enums.Elements.LIGHT);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Tormenta Celestial");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tormenta Celestial");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -35, -42, -5, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);

        return skill;
    }

    Skill godOfChaos() {
        Skill skill = new Skill("God of Chaos", 38, 24, Enums.Elements.DARK);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Deus do Caos");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Dios del Caos");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -30, -38, -4, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.THIEF);

        return skill;
    }

    Skill supremeMissile() {
        Skill skill = new Skill("Supreme Missile", 60, 38, Enums.Elements.LIGHT);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Míssil Supremo");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Misil Supremo");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -50, -60, -7, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);

        return skill;
    }

    Skill mysticalStun() {
        Skill skill = new Skill("Mystical Stun", 20, 16, Enums.Elements.LIGHT);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Atordoamento Místico");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Aturdimiento Místico");


        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "May paralyze the enemy during 1 turn.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Pode paralizar o inimigo por 1 turno.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Puede paralizar al enemigo durante 1 turno.");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.statusModifiers.add(new StatusModifier(Enums.StatusModifier.ADD, Enums.Status.PARALYZED, 75, 2));
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -3, -6, 0, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);

        return skill;
    }

    Skill tsunami() {
        Skill skill = new Skill("Tsunami", 22, 16, Enums.Elements.WATER);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Tsunami");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Tsunami");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -23, -27, -2, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.SORCERER);
        skill.classes.add(ClassesIds.DRUID);

        return skill;
    }

    Skill shadowScam() {
        Skill skill = new Skill("Shadow Scam", 27, 18, Enums.Elements.DARK);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Golpe das Sombras");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Estafa en la Sombra");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -23, -27, -3, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.ARCHER);
        skill.classes.add(ClassesIds.THIEF);
        skill.soundEffectFile = "skill_dark_2";

        return skill;
    }

    Skill ultimateHit() {
        Skill skill = new Skill("Ultimate Hit", 32, 22, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Golpe Mortal");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Golpe Mortal");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -26, -30, -4, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.WARRIOR);
        skill.classes.add(ClassesIds.ARCHER);

        return skill;
    }

    Skill poisonousRain() {
        Skill skill = new Skill("Poisonous Rain", 38, 27, Enums.Elements.DARK);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Chuva Venenosa");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Lluvia Venenosa");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.targets = Enums.TargetOptions.MULTI_TARGET;
        skill.statusModifiers.add(new StatusModifier(Enums.StatusModifier.ADD, Enums.Status.POISONED, 85, 3));
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -8, -12, -3, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.THIEF);
        skill.classes.add(ClassesIds.SORCERER);
        skill.classes.add(ClassesIds.DRUID);
        skill.soundEffectFile = "skill_dark_2";

        return skill;
    }

    Skill disable() {
        Skill skill = new Skill("Disable", 12, 9, Enums.Elements.PHYSICAL);
        skill.addNameTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Desabilitar");
        skill.addNameTranslation(CoreEnums.AvailableLanguages.SPANISH, "Inhabilitar");

        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.ENGLISH, "Let the enemy defenseless during 3 turns.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.PORTUGUESE, "Deixa o inimigo sem defesa por 3 turnos.");
        skill.addDescriptionTranslation(CoreEnums.AvailableLanguages.SPANISH, "Deja al enemigo sin protección durante 3 turnos.");

        skill.type = Enums.SkillTypes.ATTACK;
        skill.statusModifiers.add(new StatusModifier(Enums.StatusModifier.ADD, Enums.Status.DEFENSELESS, 95, 4));
        skill.inflictValues.add(new AttributeModifierValue(Enums.AttributeName.HP, -2, -4, -1, Enums.StatusModifier.DECREASE));
        skill.classes.add(ClassesIds.WARRIOR);
        skill.classes.add(ClassesIds.ARCHER);
        skill.classes.add(ClassesIds.THIEF);

        return skill;
    }
}
