package com.cnx.endlesstalestwo.data.enemies;

import com.cnx.endlesstalestwo.App;
import com.cnx.endlesstalestwo.data.DataHelper;
import com.cnx.endlesstalestwo.data.enemies.air.SpiritOfAir;
import com.cnx.endlesstalestwo.data.enemies.bosses.CasielCorrupted;
import com.cnx.endlesstalestwo.data.enemies.bosses.CasielDeathKing;
import com.cnx.endlesstalestwo.data.enemies.bosses.Targon;
import com.cnx.endlesstalestwo.data.enemies.common.CaveBat;
import com.cnx.endlesstalestwo.data.enemies.earth.CrawlingWorm;
import com.cnx.endlesstalestwo.data.enemies.common.Crocodile;
import com.cnx.endlesstalestwo.data.enemies.earth.ForestPredator;
import com.cnx.endlesstalestwo.data.enemies.earth.DesertScorpion;
import com.cnx.endlesstalestwo.data.enemies.common.DungeonImp;
import com.cnx.endlesstalestwo.data.enemies.common.ForestWolf;
import com.cnx.endlesstalestwo.data.enemies.fire.SpiritOfFire;
import com.cnx.endlesstalestwo.data.enemies.humanoids.TormentPirate;
import com.cnx.endlesstalestwo.data.enemies.light.CorruptedWizard;
import com.cnx.endlesstalestwo.data.enemies.light.SpiritOfLight;
import com.cnx.endlesstalestwo.data.enemies.waterIce.FrostWraith;
import com.cnx.endlesstalestwo.data.enemies.common.GroveGoblin;
import com.cnx.endlesstalestwo.data.enemies.common.Lion;
import com.cnx.endlesstalestwo.data.enemies.common.MountainTroll;
import com.cnx.endlesstalestwo.data.enemies.bosses.Octuman;
import com.cnx.endlesstalestwo.data.enemies.humanoids.PirateSwashbuckler;
import com.cnx.endlesstalestwo.data.enemies.common.Spider;
import com.cnx.endlesstalestwo.data.enemies.waterIce.Medusa;
import com.cnx.endlesstalestwo.data.enemies.waterIce.SwampToad;
import com.cnx.endlesstalestwo.data.enemies.common.VenomSpider;
import com.cnx.endlesstalestwo.data.enemies.common.WildBoar;
import com.cnx.endlesstalestwo.data.enemies.dark.DarkCultist;
import com.cnx.endlesstalestwo.data.enemies.dark.DarkSpecter;
import com.cnx.endlesstalestwo.data.enemies.dark.DesertGhoul;
import com.cnx.endlesstalestwo.data.enemies.fire.FireDragon;
import com.cnx.endlesstalestwo.data.enemies.waterIce.IceDragon;
import com.cnx.endlesstalestwo.data.enemies.earth.Wyvern;
import com.cnx.endlesstalestwo.data.enemies.bosses.DragonKing;
import com.cnx.endlesstalestwo.data.enemies.fire.InfernalHound;
import com.cnx.endlesstalestwo.data.enemies.earth.SandDemon;
import com.cnx.endlesstalestwo.data.enemies.dark.ShadowWraith;
import com.cnx.endlesstalestwo.data.enemies.dark.SkeletonGuardian;
import com.cnx.endlesstalestwo.data.enemies.dark.Succubus;
import com.cnx.endlesstalestwo.data.enemies.dark.VoidStalker;
import com.cnx.endlesstalestwo.data.enemies.golems.ForestGolem;
import com.cnx.endlesstalestwo.data.enemies.golems.IceGolem;
import com.cnx.endlesstalestwo.data.enemies.golems.MountainGolem;
import com.cnx.endlesstalestwo.data.enemies.golems.SandGolem;
import com.cnx.endlesstalestwo.data.enemies.humanoids.ArmyGuard;
import com.cnx.endlesstalestwo.data.enemies.humanoids.Bandit;
import com.cnx.endlesstalestwo.data.enemies.humanoids.Barbarian;
import com.cnx.endlesstalestwo.data.enemies.humanoids.LetowGuard;
import com.cnx.endlesstalestwo.data.enemies.humanoids.MalignantElf;
import com.cnx.endlesstalestwo.data.enemies.humanoids.MonelixGuard;
import com.cnx.endlesstalestwo.data.enemies.humanoids.Pickpocketer;
import com.cnx.endlesstalestwo.data.enemies.humanoids.PirateGhost;
import com.cnx.endlesstalestwo.data.enemies.orcs.OrcBattler;
import com.cnx.endlesstalestwo.data.enemies.orcs.OrcMaster;
import com.cnx.endlesstalestwo.data.enemies.orcs.OrcPeasant;
import com.cnx.endlesstalestwo.enums.Enums;

public class EnemiesDataManager extends DataHelper {
    @Override
    public void generate() {
        // ===== ORCS =====
        App.DataManager.add(Enums.DataTypes.ENEMY, OrcPeasant.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, OrcBattler.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, OrcMaster.get());

        // ===== COMMON CREATURES =====
        App.DataManager.add(Enums.DataTypes.ENEMY, Spider.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, VenomSpider.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, GroveGoblin.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, DungeonImp.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, PirateSwashbuckler.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, Octuman.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, CaveBat.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, ForestWolf.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, SwampToad.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, Crocodile.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, ForestPredator.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, MountainTroll.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, FrostWraith.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, DesertScorpion.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, WildBoar.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, MutantInsectSwarm.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, Lion.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, CrawlingWorm.get());

        // ===== HUMANOIDS =====
        App.DataManager.add(Enums.DataTypes.ENEMY, Bandit.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, Pickpocketer.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, ArmyGuard.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, PirateGhost.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, MonelixGuard.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, LetowGuard.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, MalignantElf.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, Barbarian.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, SpiritOfFire.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, SpiritOfAir.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, SpiritOfLight.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, Medusa.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, TormentPirate.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, CorruptedWizard.get());

        // ===== DARK CREATURES =====
        App.DataManager.add(Enums.DataTypes.ENEMY, ShadowWraith.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, VoidStalker.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, InfernalHound.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, DarkSpecter.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, SandDemon.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, DesertGhoul.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, DarkCultist.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, Succubus.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, SkeletonGuardian.get());

        // ===== GOLEMS =====
        App.DataManager.add(Enums.DataTypes.ENEMY, SandGolem.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, ForestGolem.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, MountainGolem.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, IceGolem.get());

        // ===== BOSSES =====
        App.DataManager.add(Enums.DataTypes.ENEMY, Targon.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, CasielCorrupted.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, CasielDeathKing.get());

        // ===== DRAGONS =====
        App.DataManager.add(Enums.DataTypes.ENEMY, FireDragon.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, IceDragon.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, Wyvern.get());
        App.DataManager.add(Enums.DataTypes.ENEMY, DragonKing.get());
    }
}



