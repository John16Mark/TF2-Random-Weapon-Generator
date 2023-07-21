package def;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Weapon {
	
	// Clase seleccionada
	private int clase;
	
	private int clipsize;
	private boolean isPrimary = false;
	private boolean isWeapon = true;
	private boolean isMelee = false;
	private boolean isSword = false;
	private boolean isBanner = false;
	private boolean isFlameThrower = false;
	private boolean isBatWithBaseball = false;
	
	// Lista de stats posibles
	private ArrayList<Stat> stats = new ArrayList<>();
	
	// Cantidad de stats de cada tipo
	private int statsPositivosDisponibles = 0;
	private int statsNegativosDisponibles = 0;
	
	// Listas de stats seleccionados
	private ArrayList<Stat> neutralesAntes = new ArrayList<>();
	private ArrayList<Stat> banner = new ArrayList<>();
	private ArrayList<Stat> positivos = new ArrayList<>();
	private ArrayList<Stat> neutralesMedio = new ArrayList<>();
	private ArrayList<Stat> negativos = new ArrayList<>();
	private ArrayList<Stat> neutralesDespues = new ArrayList<>();
	
	// Límites de los stats
	private int maxStatsPositivos = 0;
	private int maxStatsNegativos = 3;
	private float maxPuntuacionPositivos = 0;
	private float minPuntuacionPositivos = 0;
	private float maxPuntuacionNegativos = 10;
	private float minPuntuacionNegativos = 10;
	private float maxPuntuacionBanner = 25;
	private float minPuntuacionBanner = 0;
	
	// Puntajes
	private float puntuacionPositiva = 0;
	private float puntuacionNegativa = 0;
	private float puntuacionBanner = 0;
	private int power;
	
	private int primaryAmmo;
	private int secondaryAmmo;
	/*
	private BannerBuff minicrits = new BannerBuff("deal mini-crits", 50);
	private BannerBuff healDmg = new BannerBuff("heal from dealing damage", 25);
	private BannerBuff regenHP = new BannerBuff("gain health regeneration", 15);
	private BannerBuff tankCrits = new BannerBuff("negate critical damage", 25);
	private BannerBuff dmgRes = new BannerBuff("gain ", 25);
	private BannerBuff fireRes = new BannerBuff("gain ", 25);
	private BannerBuff expRes = new BannerBuff("gain ", 25);
	private BannerBuff bullRes = new BannerBuff("gain ", 25);
	private BannerBuff meleeRes = new BannerBuff("gain ", 25);
	private BannerBuff meleeDmg = new BannerBuff("gain ", 25);
	private BannerBuff moreDmg;
	private BannerBuff moreBullDmg;
	private BannerBuff moreExpDmg;
	private BannerBuff moreFireDmg;
	private BannerBuff moreMeleeDmg;
	private BannerBuff sentryDmg;
	private BannerBuff moveSpeed;
	private BannerBuff moreJump;
	private BannerBuff midairJump;
	private BannerBuff regenAmmo;
	private BannerBuff scareEnemy;*/
	
	private Stat minicrits = new Stat("deal mini-crits", 50, true);
	private Stat healDmg = new Stat("heal from dealing damage", 25, true);
	private Stat regenHP = new Stat("gain health regeneration", 15, true);
	private Stat tankCrits = new Stat("negate critical damage", 25, true);
	private Stat dmgRes = new Stat(40, 5, "gain +", "% damage resistance", 40, true);
	private Stat fireRes = new Stat(40, 5, "gain +", "% fire damage resistance", 30, true);
	private Stat expRes = new Stat(40, 5, "gain +", "% explosive damage resistance", 35, true);				
	private Stat bullRes = new Stat(40, 5, "gain +", "% bullet damage resistance", 35, true);
	private Stat meleeRes = new Stat(40, 5, "gain +", "% melee damage resistance", 15, true);
	private Stat moreDmg = new Stat(30, 5, "gain +", "% damage bonus", 40, true);
	private Stat moreBullDmg = new Stat(30, 5, "gain +", "% bullet damage bonus", 35, true);
	private Stat moreExpDmg = new Stat(30, 5, "gain +", "% explosive damage bonus", 30, true);
	private Stat moreFireDmg = new Stat(30, 5, "gain +", "% fire damage bonus", 25, true);
	private Stat moreMeleeDmg = new Stat(30, 5, "gain +", "% melee damage bonus", 25, true);
	private Stat sentryDmg = new Stat(40, 5, "gain +", "% sentry damage resistance", 30, true);
	private Stat moveSpeed = new Stat(40, 5, "gain +", "% faster movement speed", 35, true);
	private Stat moreJump = new Stat(40, 5, "gain +", "% higher jump height", 20, true);
	private Stat midairJump = new Stat("gain one extra mid-air jump", 30, true);
	private Stat regenAmmo = new Stat("regenerate ammo", 10, true);
	private Stat scareEnemy = new Stat("scare enemies when they recieve high damage attacks", 45, true);
	private Stat crits = new Stat("deal critical hits", 70, true);
	
	ArrayList<Stat> bannerBuffs = new ArrayList<>(Arrays.asList(
			minicrits, healDmg, regenHP, tankCrits, dmgRes, fireRes, expRes, bullRes, meleeRes,
			moreDmg, moreBullDmg, moreExpDmg, moreFireDmg, moreMeleeDmg, sentryDmg, moveSpeed,
			moreJump, midairJump, regenAmmo, scareEnemy, crits));
	
	/* GENERIC */
	private Stat maxPrimaryAmmo;
	private Stat maxSecondaryAmmo;
	private Stat maxHp;
	private Stat passiveDmgResistance;
	private Stat passiveFireResistance;
	private Stat passiveExpResistance;
	private Stat passiveBulletResistance;
	private Stat passiveMeleeResistance;
	private Stat healFromKits;
	private Stat healFromHealers;
	/* PASSIVE */
	private Stat passiveHpRegen;
	private Stat passiveSpeed;
	private Stat passiveJumpHeight;
	private Stat passiveKnockbackRes;
	private Stat passiveFallDmg;
	private Stat passiveNoFall;
	private Stat overhealPenalty;
	private Stat noOverheal;
	private Stat fasterDecay;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* ARMA ataque */
	private Stat damage;
	private Stat damagePlayers;
	private Stat damageBuildings;
	private Stat clipSize;
	private Stat firingSpeed;
	private Stat hpOnHit;
	/* ARMA velocidad */
	private Stat deploySpeed;
	private Stat holsterSpeed;
	private Stat reloadSpeed;
	/* ARMA utilidad */
	private Stat speedActive;
	private Stat jumpActive;
	/* ARMA extra */
	private Stat noAmmoNeed;
	private Stat noAmmoDispensers;
	/* ARMA buffs */
	private Stat minicritsExplosion;
	private Stat minicritsWhenCrit;
	private Stat noRandomCrits;
	/* ARMA defence */
	private Stat dmgResitanceWhileActive;
	private Stat fireResitanceWhileActive;
	private Stat expResitanceWhileActive;
	private Stat bulletResitanceWhileActive;
	private Stat meleeResitanceWhileActive;
	private Stat healFromHealersWA;
	/* MELEE *////////////////////////////////////////////////////////////////////////////////////////////////
	private Stat moreDmgLessHP;
	private Stat lessDmgMoreHP;
	private Stat moreRangeMelee;
	private Stat threeHitCrit;
	private Stat meleeKillHP;
	//////////////////////////////////////
	/* BULLETS */
	private Stat accuracy;
	private Stat minicritsFromBack;
	private Stat mediumRangeBulletsPass;
	/* SHOTGUN */
	private Stat morePellets;
	private Stat fixedPattern;
	/* PROJECTILE */
	private Stat projectileSpeed;
	private Stat projectileSpread;
	private Stat reflectedTurnsCrit;
	private Stat cannotReflect;
	/* EXPLOSION */
	private Stat explosionRadius;
	private Stat destroysStickies;
	private Stat fireExplosion;
	private Stat explosionKB;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Scattergun */
	private Stat reloadOnKill;
	private Stat ifAllConnectDebuff;
	/* Pistol */
	private Stat seeTargetHPAndBar;
	/* Bat */
	private Stat tripeJump;
	private Stat midairCrit;
	private Stat midairMinicrit;
	/* Bat with baseball */
	private Stat ballRecharge;
	private Stat longRangeBallCrit;
	private Stat longRangeBallMini;
	private Stat ball;
	private Stat extraBall;
	private Stat moreDmgToBall;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Rocket Launcher */
	private Stat rocketSelfDamage;
	private Stat RocketDamageWhileRJ;
	private Stat firingSpeedWhileRJ;
	private Stat projectileSpeedWhileRJ;
	private Stat radiusWhileRJ;
	/* Shotgun */
	private Stat explosiveBullets;
	private Stat ShotgunDmgWhileRJ;
	/* Banner */
	private Stat bannerActivation;
	private Stat bannerRange;
	/* Boots */
	private Stat blastDmgRockets;
	private Stat stompingSoldier;
	private Stat airControl;
	/* Shovel */
	private Stat critsWhileRJ;
	private Stat minicritsWhileRJ;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Flame Thrower */
	private Stat flameRange;
	private Stat afterburnDmg;
	private Stat airblastCost;
	private Stat airblastPush;
	private Stat airblastSpeed;
	private Stat noAirblast;
	private Stat flameSpeed;
	/* Shotgun */
	private Stat fireBullets;
	private Stat minicritsOnFire;
	private Stat minicritsAirblast;
	private Stat damageWhileExpJump;
	/* Flare Gun */
	/* Fireaxe */
	private Stat destroysSappers;
	private Stat boostsEngieBuilds;
	private Stat meleeCritBurning;
	private Stat meleeMiniBurning;
	private Stat extinguishesOnHit;
	private Stat hitsMedicAndPatient;
	private Stat hitsDispenserAndPatient;
	private Stat critsWetPlayers;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Grenade Launcher */
	private Stat pipeSelfDamage;
	private Stat fuseTime;
	private Stat bombsRollLess;
	private Stat bombsShatter;
	private Stat pipeDmgWhileSJ;
	private Stat pipeFireSpeedWhileSJ;
	private Stat pipeProjSpeedWhileSJ;
	/* Boots */
	private Stat turnControl;
	private Stat bootsSpeed;
	/* Stickybomb Launcher */
	private Stat stickySelfDamage;
	private Stat moreStickies;
	private Stat stickyArmTime;
	private Stat stickyChargTime;
	private Stat StickyDmgCharge;
	private Stat stickyDmgWhileSJ;
	private Stat stickyFireSpeedWhileSJ;
	private Stat stickyProjSpeedWhileSJ;
	/* Shield */
	private Stat chargeImpactDmg;
	private Stat chargeRechargeRate;
	private Stat fullTurnControlCharge;
	private Stat meleeKillsRefillcharge;
	/* Sword */
	private Stat chargeDuration;
	//private Stat killsFillCharge;
	private Stat killsHealHP;
	private Stat honorbound;
	private Stat ammoRefillsCharge;
	private Stat medkitsRefillCharge;
	private Stat hitsRefillCharge;
	/* Bottle */
	private Stat critsWhileSJ;
	private Stat minisWhileSJ;
	private Stat healOnDrinking;
	private Stat ifBrokenMoreDmg;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Minigun */
	private Stat dmgReswhileSpun;
	private Stat spinUpTime;
	private Stat spinDownTime;
	private Stat moveSpeedSpun;
	private Stat silentSpun;
	/* Shotgun */
	private Stat shotgunKnockback;
	private Stat dmgIfRecentSpun;
	private Stat knockbackResActive;
	/* Lunchbox */
	private Stat fastEat;
	private Stat refillLunch;
	private Stat smallKitNoRef;
	//private Stat eatingBuff;
	private Stat eatingHeal;
	private Stat refillOnKills;
	private Stat smallKitThrow;
	private Stat bigKitThrow;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Shotgun */
	private Stat shotgunDmgToSentryTarget;
	private Stat revengeCrits;
	private Stat revengeMinicrits;
	private Stat shotgunMetalOnHit;
	private Stat shotgunMetalLossShooting;
	private Stat shotgunSentryVuln;
	/* Pistol */
	private Stat pistolDmgToSentryTarget;
	private Stat iconOverTarget;
	private Stat pistolMetalOnHit;
	private Stat pistolMetalLossShooting;
	private Stat pistolSentryVuln;
	/* Wrench */
	private Stat repairRate;
	private Stat sentryBuildSpeed;
	private Stat dispenserBuildSpeed;
	private Stat teleporterBuildSpeed;
	private Stat hitSpeedBuilding;
	private Stat sentryCost;
	private Stat dispenserCost;
	private Stat teleporterCost;
	private Stat lessMetalDispensers;
	private Stat wrenchDmgToSentryTarget;
	private Stat wrenchMetalOnHit;
	private Stat stealMetalFromEngineers;
	private Stat boostOtherEngies;
	private Stat dispenserRange;
	private Stat lessSentryRange;
	private Stat telesGiveSpeedBoost;
	private Stat destroysSappedBuilds;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Syringe Gun */
	private Stat syringeUberOnHit;
	private Stat speedBasedUber;
	private Stat dmgBasedUber;
	private Stat fireSpdBasedUber;
	/* Medigun */
	private Stat healRate;
	private Stat uberRate;
	private Stat overhealRate;
	private Stat overhealMax;
	private Stat mimicsRJ;
	private Stat buffsOnClass;
	private Stat healBuildings;
	private Stat drainsHealth;
	/* Bonesaw */
	private Stat onHitUber;
	//private Stat harvestOrgan;
	private Stat areaHealTaunt;
	private Stat medRegenActive;
	private Stat medRegenPassive;
	private Stat seeHP;
	private Stat seeUPatientHP;
	private Stat seeCharges;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Sniper Rifle */
	private Stat chargeRate;
	//private Stat chargeOnKills;
	private Stat hsMinicrit;
	private Stat hsonlyFull;
	private Stat hsonlyFull2;
	private Stat noNoscope;
	private Stat lessDmgMulti;
	private Stat debuffOnCharge;
	private Stat dmgOnBodyS;
	/* SMG */
	private Stat smgDmgPierce;
	/* Backpack */
	private Stat noFlinching;
	private Stat knobackWhenAim;
	private Stat backstabDamage;
	private Stat dmgRecievedFromBack;
	/* Kukri */
	private Stat critsWhenMini;
	private Stat onHitRemoveCloak;
	private Stat onHitNoCloak;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Revolver */
	private Stat canHeadshot;
	private Stat cloakHit;
	private Stat cloakDuration;
	private Stat revolverDmgPierce;
	private Stat dmgWhileDisg;
	private Stat dmgNoDisg;
	private Stat critsStabSap;
	private Stat critsStab;
	private Stat critsSap;
	private Stat minicritsStabSap;
	private Stat minicritsStab;
	private Stat minicritsSap;
	private Stat debuffHeadshot;
	private Stat dmgOnSappedBuildings;
	/* Sapper */
	private Stat sapperHP;
	private Stat sapperDmg;
	private Stat sapperExplodes;
	private Stat doesntDeactBuild;
	private Stat drainsAmmoBuild;
	private Stat drainsBuildRate;
	private Stat vulnOnSappedBuilds;
	private Stat sapperAppliedBuff;
	private Stat SapperDestroyedBuff;
	private Stat sapperCompletedBuff;
	/* Knife */
	private Stat onBSDrainHP;
	private Stat onBSStealDis;
	private Stat onBSSilent;
	private Stat onKillCloak;
	private Stat onBSCloak;
	private Stat onBSHurtPatient;
	private Stat onBSBuffOnClass;
	private Stat disgTakesCloak;
	private Stat knifeCloakDrain;
	/* Invis Watch */
	private Stat HPstandStill;
	private Stat noAmmoCloaked;
	private Stat lessAmmoCloaked;
	private Stat moreAmmoUncloaked;
	private Stat cloakRecharge;
	private Stat speedWhileCloak;
	private Stat dmgResOnCloak;
	private Stat cloakSpeed;
	private Stat uncloakSpeed;
	private Stat visibFlash;
	private Stat noFlickerDmg;
	private Stat cloakSound;
	private Stat uncloakSound;
	private Stat uncloakStill;
	private Stat bumpDrainsCloak;
	
	private ArrayList<Stat> ordenDeStats;
	
	public Weapon(String c, String t, int pos, int neg, int pow) {
		
		maxStatsPositivos = pos;
		maxStatsNegativos = neg;
		
		power = pow;
		
		switch(pow) {
		case 0:
			minPuntuacionPositivos = 0;
			maxPuntuacionPositivos = 20;
			
			minPuntuacionNegativos = 35;
			maxPuntuacionNegativos = 80;
			
			maxPuntuacionBanner = 25;
			minPuntuacionBanner = 0;
			break;
		case 1:
			minPuntuacionPositivos = 8;
			maxPuntuacionPositivos = 25;
			
			minPuntuacionNegativos = 28;
			maxPuntuacionNegativos = 55;
			
			maxPuntuacionBanner = 40;
			minPuntuacionBanner = 18;
			break;
		case 2:
			minPuntuacionPositivos = 25;
			maxPuntuacionPositivos = 40;
			
			minPuntuacionNegativos = 18;
			maxPuntuacionNegativos = 32;

			maxPuntuacionBanner = 50;
			minPuntuacionBanner = 25;
			break;
		case 3:
			minPuntuacionPositivos = 37;
			maxPuntuacionPositivos = 52;
			
			minPuntuacionNegativos = 10;
			maxPuntuacionNegativos = 27;

			maxPuntuacionBanner = 60;
			minPuntuacionBanner = 32;
			break;
		case 4:
			minPuntuacionPositivos = 46;
			maxPuntuacionPositivos = 140;
			
			minPuntuacionNegativos = 0;
			maxPuntuacionNegativos = 20;

			maxPuntuacionBanner = 80;
			minPuntuacionBanner = 35;
			break;
		}
		
		
		switch(c) {
		case "Scout":
			clase = 1;
			primaryAmmo = 32;
			secondaryAmmo = 36;
			break;
		case "Soldier":
			clase = 2;
			primaryAmmo = 20;
			secondaryAmmo = 32;
			break;
		case "Pyro":
			clase = 3;
			primaryAmmo = 200;
			secondaryAmmo = 32;
			break;
		case "Demoman":
			clase = 4;
			primaryAmmo = 16;
			secondaryAmmo = 24;
			break;
		case "Heavy":
			clase = 5;
			primaryAmmo = 200;
			secondaryAmmo = 32;
			break;
		case "Engineer":
			clase = 6;
			primaryAmmo = 32;
			secondaryAmmo = 200;
			break;
		case "Medic":
			clase = 7;
			primaryAmmo = 150;
			break;
		case "Sniper":
			clase = 8;
			primaryAmmo = 25;
			secondaryAmmo = 75;
			break;
		case "Spy":
			clase = 9;
			primaryAmmo = 24;
			break;
		}
		setTipoGenerico();
		
		definir(t);
	}
	
	void definir(String t) {
		switch(t)
		{
			case "Scattergun":
				clipsize = 6;
				isPrimary = true;
				setTipoArma();
				setTipoBalas();
				setTipoEscopeta();
				setTipoScattergun();
				
				relacionadasArma();
				relacionadasBalas();
				relacionadasEscopeta();
				break;
				
			case "Pistol":
				clipsize = 12;
				setTipoArma();
				setTipoBalas();
				setTipoRapidFire();
				
				if(clase == 1){
					setTipoPistolScout();
				} else if(clase == 6) {
					setTipoPistolEngineer();
				}
				
				relacionadasArma();
				break;
				
			case "Bat":
				isMelee = true;
				setTipoArma();
				setTipoMelee();
				setTipoBat();
				
				relacionadasArma();
				relacionadasBat();
				relacionadasMelee();
				break;
				
			case "Bat with baseball":
				isMelee = true;
				isBatWithBaseball = true;
				setTipoArma();
				setTipoProyectil();
				relacionadasProyectil();
				setTipoMelee();
				setTipoBat();
				setTipoBatWithBaseball();
				
				relacionadasArma();
				relacionadasMelee();
				relacionadasBat();
				relacionadasBatWithBaseball();
				break;
				
			case "Rocket Launcher":
				clipsize = 4;
				isPrimary = true;
				setTipoArma();
				setTipoProyectil();
				setTipoExplosion();
				setTipoRocketLauncher();
				
				
				relacionadasArma();
				relacionadasProyectil();
				break;
				
			case "Shotgun":
				clipsize = 6;
				if(clase == 6) {
					isPrimary = true;
				}
				setTipoArma();
				setTipoBalas();
				setTipoEscopeta();
				switch(clase){
					case 2:
						setTipoShotgunSoldier();
						break;
					case 3:
						setTipoShotgunPyro();
						break;
					case 5:
						setTipoShotgunHeavy();
						break;
					case 6:
						setTipoShotgunEngineer();
						break;
				}

				relacionadasArma();
				relacionadasBalas();
				relacionadasEscopeta();
				break;
				
			case "Banner":
				isWeapon = false;
				setTipoPasivo();
				setTipoBanner();
				isBanner = true;
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				//bannerBuffs.remove(bannerBuffs.indexOf(crits));
				setBuffs();
				
				minicrits.setNombre("minicrits");
				healDmg.setNombre("healDmg");
				regenHP.setNombre("regenHP");
				tankCrits.setNombre("tankCrits");
				dmgRes.setNombre("dmgRes");
				fireRes.setNombre("fireRes");
				expRes.setNombre("expRes");			
				bullRes.setNombre("bullRes");
				meleeRes.setNombre("meleeRes");
				moreDmg.setNombre("moreDmg");
				moreBullDmg.setNombre("moreBullDmg");
				moreExpDmg.setNombre("moreExpDmg");
				moreFireDmg.setNombre("moreFireDmg");
				moreMeleeDmg.setNombre("moreMeleeDmg");
				sentryDmg.setNombre("sentryDmg");
				moveSpeed.setNombre("moveSpeed");
				moreJump.setNombre("moreJump");
				midairJump.setNombre("midairJump");
				regenAmmo.setNombre("regenAmmo");
				scareEnemy.setNombre("scareEnemy");
				crits.setNombre("crits");
				
				relacionadasPasivo();
				break;
			
			case "SoldierBoots":
				isWeapon = false;
				setTipoPasivo();
				setTipoBootsSoldier();
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				
				relacionadasPasivo();
				break;
				
			case "Shovel":
				isMelee = true;
				setTipoArma();
				setTipoMelee();
				setTipoShovel();
				
				relacionadasArma();
				relacionadasShovel();
				relacionadasMelee();
				break;
				
			case "Flame Thrower":
				isPrimary = true;
				isFlameThrower = true;
				setTipoArma();
				setTipoFlameThrower();
				stats.remove(stats.indexOf(firingSpeed));
				stats.remove(stats.indexOf(clipSize));
				stats.remove(stats.indexOf(reloadSpeed));
				stats.remove(stats.indexOf(hpOnHit));
				
				relacionadasArma();
				relacionadasFlameThrower();
				break;
				
			case "Fire Axe":
				isMelee = true;
				setTipoArma();
				setTipoMelee();
				setTipoFireAxe();
				
				relacionadasArma();
				relacionadasMelee();
				break;
				
			case "Grenade Launcher":
				clipsize = 4;
				isPrimary = true;
				setTipoArma();
				setTipoProyectil();
				setTipoExplosion();
				setTipoGrenadeLauncher();
				
				relacionadasArma();
				relacionadasProyectil();
				relacionadasGrenadeLauncher();
				break;
				
			case "DemoBoots":
				isWeapon = false;
				setTipoPasivo();
				setTipoBootsSoldier();
				setTipoBootsDemo();
				stats.remove(stats.indexOf(maxPrimaryAmmo));
				
				relacionadasPasivo();
				relacionadasBootsDemo();
				break;
				
			case "Stickybomb Launcher":
				clipsize = 8;
				isPrimary = true;
				setTipoArma();
				setTipoProyectil();
				setTipoExplosion();
				setTipoStickybombLauncher();
				
				relacionadasArma();
				relacionadasProyectil();
				break;
				
			case "Shield":
				isWeapon = false;
				setTipoPasivo();
				setTipoShield();
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				
				relacionadasPasivo();
				break;
				
			case "Bottle":
				isMelee = true;
				setTipoArma();
				setTipoMelee();
				setTipoBottle();
				
				relacionadasArma();
				relacionadasMelee();
				break;
				
			case "Sword":
				isMelee = true;
				isSword = true;
				setTipoArma();
				setTipoMelee();
				setTipoSword();
				stats.remove(stats.indexOf(deploySpeed));
				stats.remove(stats.indexOf(holsterSpeed));
				stats.remove(stats.indexOf(noRandomCrits));
				
				relacionadasArma();
				relacionadasMelee();
				break;
				
			case "Minigun":
				isPrimary = true;
				setTipoArma();
				setTipoBalas();
				setTipoRapidFire();
				stats.remove(stats.indexOf(clipSize));
				stats.remove(stats.indexOf(reloadSpeed));
				setTipoMinigun();
				
				relacionadasArma();
				relacionadasBalas();
				break;
				
			case "Lunchbox":
				setTipoLunchbox();
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				
				relacionadasLunchbox();
				break;
				
			case "Fists":
				isMelee = true;
				setTipoArma();
				setTipoMelee();
				
				relacionadasArma();
				relacionadasMelee();
				break;
				
			case "Wrench":
				isMelee = true;
				setTipoArma();
				setTipoMelee();
				setTipoWrench();
				
				relacionadasArma();
				relacionadasMelee();
				break;
				
			case "Syringe Gun":
				clipsize = 8;
				isPrimary = true;
				setTipoArma();
				setTipoRapidFire();
				setTipoSyringeGun();
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				
				relacionadasArma();
				relacionadasSyringeGun();
				break;
				
			case "Medigun":
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				setTipoMedigun();
				break;
				
			case "Bonesaw":
				isMelee = true;
				setTipoArma();
				setTipoMelee();
				setTipoBonesaw();
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				
				relacionadasArma();
				relacionadasMelee();
				break;
			
			case "Sniper Rifle":
				isPrimary = true;
				setTipoArma();
				setTipoBalas();
				setSniperRifle();
				stats.remove(stats.indexOf(clipSize));
				stats.remove(stats.indexOf(mediumRangeBulletsPass));
				stats.remove(stats.indexOf(reloadSpeed));
				stats.remove(stats.indexOf(accuracy));
				stats.remove(stats.indexOf(minicritsWhenCrit));
				
				relacionadasArma();
				relacionadasBalas();
				relacionadasSniperRifle();
				break;
			
			case "Backpack":
				setTipoPasivo();
				setTipoBackpackSniper();
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				
				relacionadasPasivo();
				break;
				
			case "SMG":
				clipsize = 5;
				setTipoArma();
				setTipoBalas();
				setTipoRapidFire();
				setTipoSMG();
				
				relacionadasArma();
				relacionadasBalas();
				break;
				
			case "Kukri":
				isMelee = true;
				setTipoArma();
				setTipoMelee();
				setTipoKukri();
				
				relacionadasArma();
				relacionadasMelee();
				break;
				
			case "Revolver":
				clipsize = 6;
				isPrimary = true;
				setTipoArma();
				setTipoBalas();
				setTipoRevolver();
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				
				relacionadasArma();
				relacionadasRevolver();
				break;
				
			case "Sapper":
				setTipoSapper();
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				
				break;
				
			case "Knife":
				isMelee = true;
				setTipoArma();
				setTipoMelee();
				setTipoKnife();
				stats.remove(stats.indexOf(moreRangeMelee));
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				
				relacionadasArma();
				relacionadasMelee();
				relacionadasKnife();
				break;
				
			case "Invis Watch":
				//isWeapon = false;
				setTipoPasivo();
				setTipoInvisWatch();
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				
				relacionadasPasivo();
				relacionadasInvisWatch();
				break;
		}
		relacionadasGenerico();
	}
	
	private void setTipoGenerico() {
		maxPrimaryAmmo = new Stat("+", "% max primary ammo on wearer", 20, "-", "% max primary ammo on wearer", primaryAmmo);			stats.add(maxPrimaryAmmo);		maxPrimaryAmmo.setNombre("\033[33mmaxPrimaryAmmo\033[0m");
		maxSecondaryAmmo = new Stat("+", "% max secondary ammo on wearer", 20, "-", "% max secondary ammo on wearer", secondaryAmmo);	stats.add(maxSecondaryAmmo);	maxSecondaryAmmo.setNombre("\033[33mmaxSecondaryAmmo\033[0m");
		
		maxHp = new Stat(40, 5, "-", " max health on wearer", 80, false);											stats.add(maxHp);					maxHp.setNombre("\033[91mmaxHp\033[0m");
		passiveDmgResistance = new Stat(30, 5, "-", "% damage vulnerability on wearer", 45, false);					stats.add(passiveDmgResistance);	passiveDmgResistance.setNombre("\033[91mpassiveDmgResistance\033[0m");
		passiveFireResistance = new Stat(35, 5, "-", "% fire damage vulnerability on wearer", 30, false);			stats.add(passiveFireResistance);	passiveFireResistance.setNombre("\033[91mpassiveFireResistance\033[0m");
		passiveExpResistance = new Stat(25, 5, "-", "% explosive damage vulnerability on wearer", 35, false);		stats.add(passiveExpResistance);	passiveExpResistance.setNombre("\033[91mpassiveExpResistance\033[0m");
		passiveBulletResistance = new Stat(25, 5, "-", "% bullet damage vulnerability on wearer", 40, false);		stats.add(passiveBulletResistance);	passiveBulletResistance.setNombre("\033[91mpassiveBulletResistance\033[0m");
		passiveMeleeResistance = new Stat(20, 5, "-", "% melee damage vulnerability on wearer", 20, false);			stats.add(passiveMeleeResistance);	passiveMeleeResistance.setNombre("\033[91mpassiveMeleeResistance\033[0m");
		
		healFromKits = new Stat(100, 5, "+", "% health from packs on wearer", 55, "-", "% health from packs on wearer", 75);					stats.add(healFromKits);			healFromKits.setNombre("\033[33mhealFromKits\033[0m");
		healFromHealers = new Stat(75, 5, "+", "% health from healers on wearer", 35, "-", "% health from healers on wearer", 50);				stats.add(healFromHealers);			healFromHealers.setNombre("\033[33mhealFromHealers\033[0m");
		overhealPenalty = new Stat(90, 10, "-", "% maxium overheal on wearer", 60, false);														stats.add(overhealPenalty);			overhealPenalty.setNombre("\033[91moverhealPenalty\033[0m");
		noOverheal = new Stat("-100% maxium overheal on wearer", 65, false);																	stats.add(noOverheal);				noOverheal.setNombre("\033[91mnoOverheal\033[0m");
		fasterDecay = new Stat(25,5, "+", "% faster overheal decay", 30, false);																stats.add(fasterDecay);				fasterDecay.setNombre("\033[91mfasterDecay\033[0m");
	}
	
	private void relacionadasGenerico() {
		if(isPrimary) {
			maxPrimaryAmmo.setLista(Arrays.asList(noAmmoNeed));
		} else {
			maxSecondaryAmmo.setLista(Arrays.asList(noAmmoNeed));
		}
		passiveDmgResistance.setLista(Arrays.asList(
				passiveFireResistance, passiveExpResistance, passiveBulletResistance, passiveMeleeResistance,
				dmgResitanceWhileActive, fireResitanceWhileActive, expResitanceWhileActive, bulletResitanceWhileActive, meleeResitanceWhileActive));
		passiveFireResistance.setLista(Arrays.asList(passiveDmgResistance, dmgResitanceWhileActive, fireResitanceWhileActive));
		passiveExpResistance.setLista(Arrays.asList(passiveDmgResistance, dmgResitanceWhileActive, expResitanceWhileActive));
		passiveBulletResistance.setLista(Arrays.asList(passiveDmgResistance, dmgResitanceWhileActive, bulletResitanceWhileActive));
		passiveMeleeResistance.setLista(Arrays.asList(passiveDmgResistance, dmgResitanceWhileActive, meleeResitanceWhileActive));
		
		healFromHealers.setLista(Arrays.asList(healFromHealersWA));
		noOverheal.setLista(Arrays.asList(overhealPenalty));
		overhealPenalty.setLista(Arrays.asList(noOverheal));
	}
	
	private void setTipoPasivo() {
		stats.remove(stats.indexOf(maxHp));
		stats.remove(stats.indexOf(passiveDmgResistance));
		stats.remove(stats.indexOf(passiveFireResistance));
		stats.remove(stats.indexOf(passiveExpResistance));
		stats.remove(stats.indexOf(passiveBulletResistance));
		stats.remove(stats.indexOf(passiveMeleeResistance));
		maxHp = new Stat(40, 5, "+", " max health on wearer", 80, "-", " max health on wearer", 40);														stats.add(maxHp);					maxHp.setNombre("\033[33mmaxHp\033[0m");
		passiveDmgResistance = new Stat(30, 5, "+", "% damage resistance on wearer", 45, "-", "% damage vulnerability on wearer", 30);						stats.add(passiveDmgResistance);	passiveDmgResistance.setNombre("\033[33mpassiveDmgResistance\033[0m");
		passiveFireResistance = new Stat(50, 5, "+", "% fire damage resistance on wearer", 30, "-", "% fire damage vulnerability on wearer", 50);			stats.add(passiveFireResistance);	passiveFireResistance.setNombre("\033[33mpassiveFireResistance\033[0m");
		passiveExpResistance = new Stat(30, 5, "+", "% explosive damage resistance on wearer", 35, "-", "% explosive damage vulnerability on wearer", 30);	stats.add(passiveExpResistance);	passiveExpResistance.setNombre("\033[33mpassiveExpResistance\033[0m");
		passiveBulletResistance = new Stat(30, 5, "+", "% bullet damage resistance on wearer", 40, "-", "% bullet damage vulnerability on wearer", 30);		stats.add(passiveBulletResistance);	passiveBulletResistance.setNombre("\033[33mpassiveBulletResistance\033[0m");
		passiveMeleeResistance = new Stat(20, 5, "+", "% melee damage resistance on wearer", 25, "-", "% melee damage vulnerability on wearer", 20);		stats.add(passiveMeleeResistance);	passiveMeleeResistance.setNombre("\033[33mpassiveMeleeResistance\033[0m");
		passiveHpRegen = new Stat(5, 1, "+", " health regenerated per second on wearer", 35, true);															stats.add(passiveHpRegen);			passiveHpRegen.setNombre("\033[36mpassiveHpRegen\033[0m");
		passiveSpeed = new Stat(20, 5, "+", "% faster move speed on wearer", 40, "-", "% slower move speed on wearer", 20);									stats.add(passiveSpeed);			passiveSpeed.setNombre("\033[33mpassiveSpeed\033[0m");
		passiveJumpHeight = new Stat(25, 5, "+", "% greater jump height on wearer",20, true);																stats.add(passiveJumpHeight);		passiveJumpHeight.setNombre("\033[36mpassiveJumpHeight\033[0m");
		passiveKnockbackRes = new Stat(75, 5, "-", "% reduction in push force taken from damage", 50, true);												stats.add(passiveKnockbackRes);		passiveKnockbackRes.setNombre("\033[36mpassiveKnockbackRes\033[0m");
		passiveFallDmg = new Stat(75, 5, "-", "% fall damage taken", 15, true);																				stats.add(passiveFallDmg);			passiveFallDmg.setNombre("\033[36mpassiveFallDmg\033[0m");
		passiveNoFall = new Stat("Wearer takes no fall damage", 18, true);																					stats.add(passiveNoFall);			passiveNoFall.setNombre("\033[36mpassiveNoFall\033[0m");
	}
	
	private void relacionadasPasivo() {
		passiveDmgResistance.setLista(Arrays.asList(
				passiveFireResistance, passiveExpResistance, passiveBulletResistance, passiveMeleeResistance,
				dmgResitanceWhileActive, fireResitanceWhileActive, expResitanceWhileActive, bulletResitanceWhileActive, meleeResitanceWhileActive));
		passiveFireResistance.setLista(Arrays.asList(passiveDmgResistance, dmgResitanceWhileActive, fireResitanceWhileActive));
		passiveExpResistance.setLista(Arrays.asList(passiveDmgResistance, dmgResitanceWhileActive, expResitanceWhileActive));
		passiveBulletResistance.setLista(Arrays.asList(passiveDmgResistance, dmgResitanceWhileActive, bulletResitanceWhileActive));
		passiveMeleeResistance.setLista(Arrays.asList(passiveDmgResistance, dmgResitanceWhileActive, meleeResitanceWhileActive));
		passiveFallDmg.setLista(Arrays.asList(passiveNoFall));
		passiveNoFall.setLista(Arrays.asList(passiveFallDmg));
		passiveSpeed.setLista(Arrays.asList(bootsSpeed));
		
	}
	
	private void setTipoArma() {
		// new Stat(maxPostivo, paso, "", "", puntuacion, "", "", maxNegativo);
		
			// Attack //------------------------------------------------------------------------------------------------
		damage = new Stat(30, 5, "+", "% damage bonus", 60, "-", "% damage penalty", 30);												stats.add(damage);				damage.setNombre("\033[33mdamage\033[0m");
		damagePlayers = new Stat(25, 5, "+", "% damage vs players", 40, "-", "% damage penalty vs players", 40);						stats.add(damagePlayers);		damagePlayers.setNombre("\033[33mdamagePlayers\033[0m");
		damageBuildings = new Stat(25, 5, "+", "% damage vs buildings", 15, "-", "% damage penalty vs buildings", 80);					stats.add(damageBuildings);		damageBuildings.setNombre("\033[33mdamageBuildings\033[0m");
		clipSize = new Stat(clipsize, "+", "% clip size", 50, "-" , "% clip size");														stats.add(clipSize);			clipSize.setNombre("\033[33mclipSize\033[0m");
		firingSpeed = new Stat(60, 5, "+", "% faster firing speed", 65, "-", "% slower firing speed", 60);								stats.add(firingSpeed);			firingSpeed.setNombre("\033[33mfiringSpeed\033[0m");
		hpOnHit = new Stat(20, 5, "On Hit: Gain up to +", " health per attack", 35, true);												stats.add(hpOnHit);				hpOnHit.setNombre("\033[36mhpOnHit\033[0m");
			// Speed //------------------------------------------------------------------------------------------------
		deploySpeed = new Stat(75, 5, "This weapon deploys ", "% faster", 25, "This weapon deploys ", "% slower", 75);					stats.add(deploySpeed);			deploySpeed.setNombre("\033[33mdeploySpeed\033[0m");
		holsterSpeed = new Stat(30, 5, "This weapon holsters ", "% faster", 20, "This weapon holsters ", "% slower", 75);				stats.add(holsterSpeed);		holsterSpeed.setNombre("\033[33mholsterSpeed\033[0m");
		reloadSpeed = new Stat(25, 5, "+", "% faster reload speed", 30, "-", "% slower reload speed", 25);								stats.add(reloadSpeed);			reloadSpeed.setNombre("\033[33mreloadSpeed\033[0m");
			// Utility //------------------------------------------------------------------------------------------------
		speedActive = new Stat(15, 5, "+", "% faster moving speed when active", 45, "-", "% slower moving speed when active",10);		stats.add(speedActive);			speedActive.setNombre("\033[33mspeedActive\033[0m");
		jumpActive = new Stat(25, 5, "+", "% greater jump height when active", 15, "-", "% jump height when active",25);				stats.add(jumpActive);			jumpActive.setNombre("\033[33mjumpActive\033[0m");
			// Extra //------------------------------------------------------------------------------------------------
		noAmmoNeed = new Stat("Does not require ammo", 8, true);																		stats.add(noAmmoNeed);			noAmmoNeed.setNombre("\033[36mnoAmmoNeed\033[0m");
		noAmmoDispensers = new Stat("No ammo from dispensers when active", 8,false);													stats.add(noAmmoDispensers);	noAmmoDispensers.setNombre("\033[91mnoAmmoDispensers\033[0m");
			// Power and buffs //------------------------------------------------------------------------------------------------
		minicritsExplosion = new Stat("Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs", 10, true);	stats.add(minicritsExplosion);	minicritsExplosion.setNombre("\033[36mminicritsExplosion\033[0m");
		minicritsWhenCrit = new Stat("Minicrits whenever it would normally crit", 20, false);											stats.add(minicritsWhenCrit);	minicritsWhenCrit.setNombre("\033[91mminicritsWhenCrit\033[0m");
		noRandomCrits = new Stat("No random critical hits", 5, false);																	stats.add(noRandomCrits);		noRandomCrits.setNombre("\033[91mnoRandomCrits\033[0m");
			// Defence //------------------------------------------------------------------------------------------------
		dmgResitanceWhileActive = new Stat(35, 5, "+", "% damage resistance when active", 50, "-", "% damage vulnerability when active", 35);						stats.add(dmgResitanceWhileActive);			dmgResitanceWhileActive.setNombre("\033[33mdmgResitanceWhileActive\033[0m");
		fireResitanceWhileActive = new Stat(35, 5, "+", "% fire damage resistance when active", 25, "-", "% fire damage vulnerability when active", 35);			stats.add(fireResitanceWhileActive);		fireResitanceWhileActive.setNombre("\033[33mfireResitanceWhileActive\033[0m");
		expResitanceWhileActive = new Stat(35, 5, "+", "% explosive damage resistance when active", 30, "-", "% explosive damage vulnerability when active", 35);	stats.add(expResitanceWhileActive);			expResitanceWhileActive.setNombre("\033[33mexpResitanceWhileActive\033[0m");
		bulletResitanceWhileActive = new Stat(35, 5, "+", "% bullet damage resistance when active", 35, "-", "% bullet damage vulnerability when active", 35);	stats.add(bulletResitanceWhileActive);		bulletResitanceWhileActive.setNombre("\033[33mbulletResitanceWhileActive\033[0m");
		meleeResitanceWhileActive = new Stat(35, 5, "+", "% melee damage resistance when active", 15, "-", "% melee damage vulnerability when active", 35);		stats.add(meleeResitanceWhileActive);		meleeResitanceWhileActive.setNombre("\033[33mmeleeResitanceWhileActive\033[0m");
		healFromHealersWA = new Stat(50, 5, "+", "% health from healers when active", 50, "-", "% health from healers when active", 90);			stats.add(healFromHealersWA);		healFromHealersWA.setNombre("\033[33mhealFromHealersWA\033[0m");
	}
	
	private void relacionadasArma() {
		damage.setLista(Arrays.asList(damagePlayers, damageBuildings, dmgBasedUber));
		damagePlayers.setLista(Arrays.asList(damage, dmgBasedUber));
		damageBuildings.setLista(Arrays.asList(damage));
		if(isPrimary) {
			noAmmoNeed.setLista(Arrays.asList(maxPrimaryAmmo, noAmmoDispensers, airblastCost));
		} else {
			noAmmoNeed.setLista(Arrays.asList(maxSecondaryAmmo, noAmmoDispensers, airblastCost));
		}
		noAmmoDispensers.setLista(Arrays.asList(noAmmoNeed));
		dmgResitanceWhileActive.setLista(Arrays.asList(
				fireResitanceWhileActive, expResitanceWhileActive, bulletResitanceWhileActive, meleeResitanceWhileActive,
				passiveDmgResistance, passiveFireResistance, passiveExpResistance, passiveBulletResistance, passiveMeleeResistance));
		fireResitanceWhileActive.setLista(Arrays.asList(dmgResitanceWhileActive, passiveDmgResistance, passiveFireResistance));
		expResitanceWhileActive.setLista(Arrays.asList(dmgResitanceWhileActive, passiveDmgResistance, passiveExpResistance));
		bulletResitanceWhileActive.setLista(Arrays.asList(dmgResitanceWhileActive, passiveDmgResistance, passiveBulletResistance));
		meleeResitanceWhileActive.setLista(Arrays.asList(dmgResitanceWhileActive, passiveDmgResistance, passiveMeleeResistance));
		healFromHealersWA.setLista(Arrays.asList(healFromHealers));
		speedActive.setLista(Arrays.asList(speedBasedUber));
		firingSpeed.setLista(Arrays.asList(fireSpdBasedUber));
	}
	
	private void setTipoRapidFire() {
		int val = 25;
		if(clase == 5) {
			val = 40;
		}
		stats.remove(stats.indexOf(hpOnHit));
		hpOnHit = new Stat(5, 1, "On Hit: Gain up to +", " health", val, true);				stats.add(hpOnHit);				hpOnHit.setNombre("\033[36mhpOnHit\033[0m");
	}
	
	private void setTipoMelee() {
		stats.remove(stats.indexOf(hpOnHit));
		stats.remove(stats.indexOf(clipSize));
		stats.remove(stats.indexOf(reloadSpeed));
		stats.remove(stats.indexOf(noAmmoNeed));
		stats.remove(stats.indexOf(damageBuildings));
		stats.remove(stats.indexOf(holsterSpeed));
		
		hpOnHit = new Stat(15, 5, "On Hit: Gain +", " health", 35, true);														stats.add(hpOnHit);				hpOnHit.setNombre("\033[36mhpOnHit\033[0m");
		damageBuildings = new Stat(100, 5, "+", "% damage vs buildings", 25, "-", "% damage penalty vs buildings", 80);			stats.add(damageBuildings);		damageBuildings.setNombre("\033[33mdamageBuildings\033[0m");
		holsterSpeed = new Stat(45, 5, "This weapon holsters ", "% faster", 30, "This weapon holsters ", "% slower", 100);		stats.add(holsterSpeed);		holsterSpeed.setNombre("\033[33mholsterSpeed\033[0m");
		moreDmgLessHP = new Stat(35, 5, "+", "% increase in damage when health &lt;50% of max", 25, true);						stats.add(moreDmgLessHP);		moreDmgLessHP.setNombre("\033[36mmoreDmgLessHP\033[0m");
		lessDmgMoreHP = new Stat(35, 5, "-", "% decrease in damage when health &gt;50% of max", 25, false);						stats.add(lessDmgMoreHP);		lessDmgMoreHP.setNombre("\033[91mlessDmgMoreHP\033[0m");
		moreRangeMelee = new Stat(70, 10, "+", "% longer range", 75, true);														stats.add(moreRangeMelee);		moreRangeMelee.setNombre("\033[36mmoreRangeMelee\033[0m");
		threeHitCrit = new Stat("Third successful hit in a row always crits.", 25, true);										stats.add(threeHitCrit);		threeHitCrit.setNombre("\033[36mthreeHitCrit\033[0m");
		meleeKillHP = new Stat(50, 5, "+", " health restored on kill", 35, true);												stats.add(meleeKillHP);			meleeKillHP.setNombre("\033[36mmeleeKillHP\033[0m");
	}
	
	private void relacionadasMelee() {
		meleeKillHP.setLista(Arrays.asList(onBSDrainHP));
	}
	
	private void setTipoBalas() {
		accuracy = new Stat(25, 5, "+", "% more accurate", 35, "-", "% less accurate", 20);							stats.add(accuracy);				accuracy.setNombre("\033[33maccuracy\033[0m");
		minicritsFromBack = new Stat("Mini-crits targets when fired at their back from close range", 20, true);		stats.add(minicritsFromBack);		minicritsFromBack.setNombre("\033[36mminicritsFromBack\033[0m");
		mediumRangeBulletsPass = new Stat("On medium and short range hits: Bullets pass through enemies", 10, true);stats.add(mediumRangeBulletsPass);	mediumRangeBulletsPass.setNombre("\033[36mmediumRangeBulletsPass\033[0m");
	}
	
	private void relacionadasBalas() {
		accuracy.setLista(Arrays.asList(fixedPattern));
	}
	
	private void setTipoEscopeta() {
		morePellets = new Stat(50, 10, "+", "% bullets per shot", 40, "-", "% bullets per shot", 60);		stats.add(morePellets);		morePellets.setNombre("\033[33mmorePellets\033[0m");
		fixedPattern = new Stat("Fires a wide, fixed shot pattern", 15, true);								stats.add(fixedPattern);	fixedPattern.setNombre("\033[36mfixedPattern\033[0m");
	}
	
	private void relacionadasEscopeta() {
		fixedPattern.setLista(Arrays.asList(accuracy));
	}
	
	private void setTipoProyectil() {
		projectileSpeed = new Stat(80, 5,"+", "% projectile speed", 50, "-", "% projectile speed", 20);		stats.add(projectileSpeed);		projectileSpeed.setNombre("\033[33mprojectileSpeed\033[0m");
		projectileSpread = new Stat(3, 1, "+", " degrees random projectile deviation", 40, false);			stats.add(projectileSpread);	projectileSpread.setNombre("\033[91mprojectileSpread\033[0m");
		reflectedTurnsCrit = new Stat("Reflected projectiles become crit boosted", 30, false);				stats.add(reflectedTurnsCrit);	reflectedTurnsCrit.setNombre("\033[91mreflectedTurnsCrit\033[0m");
		cannotReflect = new Stat("Projectile cannot be deflected", 30, true);								stats.add(cannotReflect);		cannotReflect.setNombre("\033[36mcannotReflect\033[0m");
	}
	
	private void relacionadasProyectil() {
		reflectedTurnsCrit.setLista(Arrays.asList(cannotReflect));
		cannotReflect.setLista(Arrays.asList(reflectedTurnsCrit));
	}
	
	private void setTipoExplosion() {
		explosionRadius = new Stat(25, 5, "+", "% explosion radius", 50, "-", "% explosion radius", 70);	stats.add(explosionRadius);		explosionRadius.setNombre("\033[33mexplosionRadius\033[0m");
		destroysStickies = new Stat("Able to destroy enemy stickybombs", 25, true);							stats.add(destroysStickies);	destroysStickies.setNombre("\033[36mdestroysStickies\033[0m");
		fireExplosion = new Stat("Explosions ignite enemies for up to 2 seconds", 30, true);				stats.add(fireExplosion);		fireExplosion.setNombre("\033[36mfireExplosion\033[0m");
		explosionKB = new Stat(20,5,"+","% explosion knockback", 20,true);									stats.add(explosionKB);			explosionKB.setNombre("\033[36mexplosionKB\033[0m");
	}
	
	/**************************************************************************************************
	 * 											   SCOUT											 *
	**************************************************************************************************/
	private void setTipoScattergun() {
		reloadOnKill = new Stat("On kill: Automatically reloads one shot", 35, true);					stats.add(reloadOnKill);			reloadOnKill.setNombre("\033[36mreloadOnKill\033[0m");
		ifAllConnectDebuff = new Stat("ScattergunAllShot", 6, 1);										stats.add(ifAllConnectDebuff);		ifAllConnectDebuff.setNombre("\033[36mifAllConnectDebuff\033[0m");
	}
	
	private void setTipoBat() {
		tripeJump = new Stat("Grants Triple Jump while deployed", 30, true);									stats.add(tripeJump);		tripeJump.setNombre("\033[36mtripeJump\033[0m");
		midairMinicrit = new Stat("Melee attacks mini-crit while airborne.", 20, true);							stats.add(midairMinicrit);	midairMinicrit.setNombre("\033[36mmidairMinicrit\033[0m");
		midairCrit = new Stat("Guaranteed critical hits if an explosion propelled you mid-air", 25, true);		stats.add(midairCrit);		midairCrit.setNombre("\033[36mmidairCrit\033[0m");
	}
	
	private void setTipoPistolScout() {
		seeTargetHPAndBar = new Stat("On Hit: You and all teamates close to you can see your target's health and charge meters", 30, true);			stats.add(seeTargetHPAndBar);		seeTargetHPAndBar.setNombre("\033[36mseeTargetHPAndBar\033[0m");
	}
	
	private void relacionadasBat() {
		midairMinicrit.setLista(Arrays.asList(midairCrit));
		midairCrit.setLista(Arrays.asList(midairMinicrit));
	}
	
	private void setTipoBatWithBaseball() {
		ballRecharge = new Stat(35, 5, "+","% increase in recharge rate", 25, "-", "% decrease in recharge rate", 15); 					stats.add(ballRecharge);		ballRecharge.setNombre("\033[33mballRecharge\033[0m");
		longRangeBallCrit = new Stat("Guaranteed critical hits on long distance hits", 30, true);										stats.add(longRangeBallCrit);	longRangeBallCrit.setNombre("\033[36mlongRangeBallCrit\033[0m");
		longRangeBallMini = new Stat("Guaranteed Mini-crits on long distance hits", 15, true);											stats.add(longRangeBallMini);	longRangeBallMini.setNombre("\033[36mlongRangeBallMini\033[0m");
		ball = new Stat("Sandman", 8, 1);																						stats.add(ball);				ball.setNombre("\033[36mball\033[0m");
		extraBall = new Stat(2, 1, "+", " extra projectile", 50, true);																	stats.add(extraBall);			extraBall.setNombre("\033[36mextraBall\033[0m");
		moreDmgToBall = new Stat(15, 5, "Your projectiles deal +", " more damage", 40, "Your projectiles deal -", " less damage", 10);	stats.add(moreDmgToBall);		moreDmgToBall.setNombre("\033[91mmoreDmgToBall\033[0m");
	}
	
	private void relacionadasBatWithBaseball() {
		longRangeBallCrit.setLista(Arrays.asList(longRangeBallMini));
		longRangeBallMini.setLista(Arrays.asList(longRangeBallCrit));
	}
	
	/**************************************************************************************************
	 * 											  SOLDIER											 *
	**************************************************************************************************/
	private void setTipoRocketLauncher() {
		rocketSelfDamage = new Stat(25, 5, "-", "% blast damage from rocket jumps", 20, "+", "% blast damage from rocket jumps", 25);						stats.add(rocketSelfDamage);		rocketSelfDamage.setNombre("\033[33mrocketSelfDamage\033[0m");
		RocketDamageWhileRJ = new Stat(20, 5, "+", "% damage bonus while rocket jumping", 35, "-", "% damage penalty while rocket jumping", 20);			stats.add(RocketDamageWhileRJ);		RocketDamageWhileRJ.setNombre("\033[33mRocketDamageWhileRJ\033[0m");
		firingSpeedWhileRJ = new Stat(30, 5, "+", "% firing speed while rocket jumping", 30, "-", "% firing speed while rocket jumping", 30);				stats.add(firingSpeedWhileRJ);		firingSpeedWhileRJ.setNombre("\033[33mfiringSpeedWhileRJ\033[0m");
		projectileSpeedWhileRJ = new Stat(30, 5, "+", "% projectile speed while rocket jumping", 35, "-", "% projectile speed while rocket jumping", 30);	stats.add(projectileSpeedWhileRJ);	projectileSpeedWhileRJ.setNombre("\033[33mprojectileSpeedWhileRJ\033[0m");
		radiusWhileRJ = new Stat(20, 5, "+", "% explosion radius while rocket jumping", 30, "-", "% explosion radius while rocket jumping", 20);			stats.add(radiusWhileRJ);			radiusWhileRJ.setNombre("\033[33mradiusWhileRJ\033[0m");
	}
	
	private void setTipoShotgunSoldier() {
		explosiveBullets = new Stat("Bullets create small explosions when hitting an enemy", 25, true);												stats.add(explosiveBullets);		explosiveBullets.setNombre("\033[36mexplosiveBullets\033[0m");
		ShotgunDmgWhileRJ = new Stat(20, 5, "+", "% damage bonus while rocket jumping", 20, "-", "% damage penalty while rocket jumping" ,20);		stats.add(ShotgunDmgWhileRJ);		ShotgunDmgWhileRJ.setNombre("\033[33mShotgunDmgWhileRJ\033[0m");
	}
	
	private void setTipoBanner() {
		bannerActivation = new Stat(50, 10,"+","% faster banner activation", 35, "-", "% slower banner activation", 30);		stats.add(bannerActivation);		bannerActivation.setNombre("\033[33mbannerActivation\033[0m");
		bannerRange = new Stat(25, 5, "+", "% longer banner range", 30, "-", "% shorter banner range",15);						stats.add(bannerRange);				bannerRange.setNombre("\033[33mbannerRange\033[0m");
	}
	
	private void setBuffs() {
		
		minicrits.setLista(Arrays.asList(crits));
		crits.setLista(Arrays.asList(minicrits));
		dmgRes.setLista(Arrays.asList(fireRes, expRes, bullRes, meleeRes));
		fireRes.setLista(Arrays.asList(dmgRes));
		expRes.setLista(Arrays.asList(dmgRes));
		bullRes.setLista(Arrays.asList(dmgRes));
		meleeRes.setLista(Arrays.asList(dmgRes));
		moreDmg.setLista(Arrays.asList(moreFireDmg, moreExpDmg, moreBullDmg, moreMeleeDmg));
		moreFireDmg.setLista(Arrays.asList(moreDmg));
		moreExpDmg.setLista(Arrays.asList(moreDmg));
		moreBullDmg.setLista(Arrays.asList(moreDmg));
		moreMeleeDmg.setLista(Arrays.asList(moreDmg));
	}
	
	private void setTipoBootsSoldier() {
		blastDmgRockets = new Stat(70, 5, "-","% blast damage from rocket jumps", 50, true);				stats.add(blastDmgRockets);				blastDmgRockets.setNombre("\033[36mblastDmgRockets\033[0m");
		stompingSoldier = new Stat(4,1,"Deals ","x falling damage to the player you land on",32,true);		stats.add(stompingSoldier);				stompingSoldier.setNombre("\033[36mstompingSoldier\033[0m");
		airControl = new Stat(200,50,"","% increased air control when blast jumping", 45, true);			stats.add(airControl);					airControl.setNombre("\033[36mairControl\033[0m");
	}
	
	private void setTipoShovel() {
		critsWhileRJ = new Stat("Deals crits while the wielder is rocket jumping", 30, true);							stats.add(critsWhileRJ);		critsWhileRJ.setNombre("\033[36mcritsWhileRJ\033[0m");
		minicritsWhileRJ = new Stat("Deals Mini-crits while the wielder is rocket jumping", 30, true);					stats.add(minicritsWhileRJ);	minicritsWhileRJ.setNombre("\033[36mminicritsWhileRJ\033[0m");
	}
	
	private void relacionadasShovel() {
		critsWhileRJ.setLista(Arrays.asList(minicritsWhileRJ));
		minicritsWhileRJ.setLista(Arrays.asList(critsWhileRJ));
	}
	
	/**************************************************************************************************
	 * 												PYRO											 *
	**************************************************************************************************/
	private void setTipoFlameThrower() {
		flameRange = new Stat(10, 5, "+", "% flame thrower range", 35, "-", "% flame thrower range", 10);									stats.add(flameRange);		flameRange.setNombre("\033[33mflameRange\033[0m");
		afterburnDmg = new Stat(100, 25, "+", "% afterburn damage bonus", 25, "-", "% afterburn damage penalty", 75);						stats.add(afterburnDmg);	afterburnDmg.setNombre("\033[33mafterburnDmg\033[0m");
		airblastCost = new Stat(50, 25, "-", "% airblast cost", 30, "+", "% airblast cost", 150);											stats.add(airblastCost);	airblastCost.setNombre("\033[33mairblastCost\033[0m");
		airblastPush = new Stat(20, 5, "+", "% airblast push force", 20, "-", "% airblast push force", 20);									stats.add(airblastPush);	airblastPush.setNombre("\033[33mairblastPush\033[0m");
		airblastSpeed = new Stat(50, 25, "+", "% repressurization rate on Alt-Fire", 40, "-", "% repressurization rate on Alt-Fire", 50);	stats.add(airblastSpeed);	airblastSpeed.setNombre("\033[33mairblastSpeed\033[0m");
		noAirblast = new Stat("No airblast", 50, false);																					stats.add(noAirblast);		noAirblast.setNombre("\033[91mnoAirblast\033[0m");
		flameSpeed = new Stat(50, 10, "+", "% flame travel speed", 35, "-", "% flame travel speed", 30);									stats.add(flameSpeed);		flameSpeed.setNombre("\033[33mflameSpeed\033[0m");
	}
	
	private void relacionadasFlameThrower() {
		airblastCost.setLista(Arrays.asList(noAirblast, noAmmoNeed));
		airblastPush.setLista(Arrays.asList(noAirblast));
		airblastSpeed.setLista(Arrays.asList(noAirblast));
		noAirblast.setLista(Arrays.asList(airblastSpeed, airblastPush, airblastCost));
	}
	
	private void setTipoShotgunPyro() {
		fireBullets = new Stat("On Hit: Ignites players up to 2 seconds", 20, true);																	stats.add(fireBullets);				fireBullets.setNombre("\033[36mfireBullets\033[0m");
		minicritsOnFire = new Stat("100% mini-crits vs burning players", 35, true);																		stats.add(minicritsOnFire);			minicritsOnFire.setNombre("\033[36mminicritsOnFire\033[0m");
		minicritsAirblast = new Stat("Mini-crits targets launched airborne by airblast", 40, true);														stats.add(minicritsAirblast);		minicritsAirblast.setNombre("\033[36mminicritsAirblast\033[0m");
		damageWhileExpJump = new Stat(20, 5, "+", "% damage bonus while explosive jumping", 15, "-", "% damage penalty while explosive jumping" ,20);	stats.add(damageWhileExpJump);		damageWhileExpJump.setNombre("\033[33mdamageWhileExpJump\033[0m");
	}
	
	private void setTipoFireAxe() {
		destroysSappers = new Stat("Damage removes sappers", 25, true);															stats.add(destroysSappers);			destroysSappers.setNombre("\033[36mdestroysSappers\033[0m");
		boostsEngieBuilds = new Stat("On Hit: Boosts engineer buildings for 1.5 seconds ", 37, true);							stats.add(boostsEngieBuilds);			boostsEngieBuilds.setNombre("\033[36mboostsEngieBuilds\033[0m");
		meleeCritBurning = new Stat("Guaranteed critical hits on burning targets", 40, true);									stats.add(meleeCritBurning);			meleeCritBurning.setNombre("\033[36mmeleeCritBurning\033[0m");
		meleeMiniBurning = new Stat("Mini-crits burning targets", 35, true);													stats.add(meleeMiniBurning);			meleeMiniBurning.setNombre("\033[36mmeleeMiniBurning\033[0m");
		extinguishesOnHit = new Stat("Extinguishes enemies on hit", 20, false);													stats.add(extinguishesOnHit);			extinguishesOnHit.setNombre("\033[91mextinguishesOnHit\033[0m");
		hitsMedicAndPatient = new Stat("All players connected via Medigun beams are hit", 15, true);							stats.add(hitsMedicAndPatient);			hitsMedicAndPatient.setNombre("\033[36mhitsMedicAndPatient\033[0m");
		hitsDispenserAndPatient = new Stat("All players connected via Medigun and dispenser beams are hit", 25, true);			stats.add(hitsDispenserAndPatient);		hitsDispenserAndPatient.setNombre("\033[36mhitsDispenserAndPatient\033[0m");
		critsWetPlayers = new Stat("100% critical hit vs wet players", 15, true);												stats.add(critsWetPlayers);				critsWetPlayers.setNombre("\033[36mcritsWetPlayers\033[0m");
	}
	
	/**************************************************************************************************
	 * 											  DEMOMAN											 *
	**************************************************************************************************/
	private void setTipoGrenadeLauncher() {
		pipeSelfDamage = new Stat(25, 5, "-", "% damage to self", 25, "+", "% damage to self", 25);				stats.add(pipeSelfDamage);		pipeSelfDamage.setNombre("\033[33mpipeSelfDamage\033[0m");
		fuseTime = new Stat(30, 5, "-", "% fuse time on grenades", 20, "+", "% fuse time on grenades", 20);		stats.add(fuseTime);			fuseTime.setNombre("\033[33mfuseTime\033[0m");
		bombsRollLess = new Stat("Grenades have very little bounce and roll", 15, true);						stats.add(bombsRollLess);		bombsRollLess.setNombre("\033[36mbombsRollLess\033[0m");
		bombsShatter = new Stat("Launched bombs shatter on surfaces", 20, false);								stats.add(bombsShatter);		bombsShatter.setNombre("\033[91mbombsShatter\033[0m");
		pipeDmgWhileSJ = new Stat(20, 5, "+", "% damage bonus while stickybomb jumping", 25, "-", "% damage penalty while stickybomb jumping", 20);					stats.add(pipeDmgWhileSJ);				pipeDmgWhileSJ.setNombre("\033[33mpipeDmgWhileSJ\033[0m");
		pipeFireSpeedWhileSJ = new Stat(25, 5, "+", "% firing speed while stickybomb jumping", 25, "-", "% firing speed while stickybomb jumping", 25);				stats.add(pipeFireSpeedWhileSJ);		pipeFireSpeedWhileSJ.setNombre("\033[33mpipeFireSpeedWhileSJ\033[0m");
		pipeProjSpeedWhileSJ = new Stat(15, 5, "+", "% projectile speed while stickybomb jumping", 25, "-", "% projectile speed while stickybomb jumping", 10);		stats.add(pipeProjSpeedWhileSJ);		pipeProjSpeedWhileSJ.setNombre("\033[33mpipeProjSpeedWhileSJ\033[0m");
	}
	
	private void relacionadasGrenadeLauncher() {
		bombsRollLess.setLista(Arrays.asList(bombsShatter));
		fuseTime.setLista(Arrays.asList(bombsShatter));
		bombsShatter.setLista(Arrays.asList(fuseTime, bombsRollLess));
	}
	
	private void setTipoBootsDemo() {
		turnControl = new Stat(200,50,"","% increased in turning control while charging", 45, true);			stats.add(turnControl);					turnControl.setNombre("\033[36mturnControl\033[0m");
		meleeKillsRefillcharge = new Stat(75, 5, "Melee kills refill ", "% of your charge meter", 45, true);	stats.add(meleeKillsRefillcharge);		meleeKillsRefillcharge.setNombre("\033[36mmeleeKillsRefillcharge\033[0m");
		bootsSpeed = new Stat(10,5,"+", "% faster move speed on wearer (shield required)", 20,true);			stats.add(bootsSpeed);					bootsSpeed.setNombre("\033[36mbootsSpeed\033[0m");
	}
	
	private void relacionadasBootsDemo() {
		bootsSpeed.setLista(Arrays.asList(passiveSpeed));
	}
	
	private void setTipoStickybombLauncher() {
		stats.remove(stats.indexOf(reflectedTurnsCrit));
		stickySelfDamage = new Stat(25, 5, "-", "% blast damage from stickybomb jumps", 25, "+", "% blast damage from stickybomb jumps", 25);	stats.add(stickySelfDamage);	stickySelfDamage.setNombre("\033[33mstickySelfDamage\033[0m");
		moreStickies = new Stat(8, 1, "+", " max stickybombs out", 40, "-", " max stickybombs out", 6);											stats.add(moreStickies);		moreStickies.setNombre("\033[33mmoreStickies\033[0m");
		stickyArmTime = new Stat(4, 1, 10, "0.", " sec faster bomb arm time", 40, "0.", " sec slower bomb arm time");							stats.add(stickyArmTime);		stickyArmTime.setNombre("\033[33mstickyArmTime\033[0m");
		stickyChargTime = new Stat(70, 5, "Max charge time decreased by ", "%", 25, "Max charge time increased by ", "%", 30);					stats.add(stickyChargTime);		stickyChargTime.setNombre("\033[33mstickyChargTime\033[0m");
		StickyDmgCharge = new Stat(35, 5, "Up to +", "% damage based on charge", 30, "Up to -", "% damage based on charge", 35);				stats.add(StickyDmgCharge);		StickyDmgCharge.setNombre("\033[33mStickyDmgCharge\033[0m");
		stickyDmgWhileSJ = new Stat(20, 5, "+", "% damage bonus while stickybomb jumping", 25, "-", "% damage penalty while stickybomb jumping", 20);					stats.add(stickyDmgWhileSJ);			stickyDmgWhileSJ.setNombre("\033[33mstickyDmgWhileSJ\033[0m");
		stickyFireSpeedWhileSJ = new Stat(25, 5, "+", "% firing speed while stickybomb jumping", 25, "-", "% firing speed while stickybomb jumping", 25);				stats.add(stickyFireSpeedWhileSJ);		stickyFireSpeedWhileSJ.setNombre("\033[33mstickyFireSpeedWhileSJ\033[0m");
		stickyProjSpeedWhileSJ = new Stat(15, 5, "+", "% projectile speed while stickybomb jumping", 25, "-", "% projectile speed while stickybomb jumping", 10);		stats.add(stickyProjSpeedWhileSJ);		stickyProjSpeedWhileSJ.setNombre("\033[33mstickyProjSpeedWhileSJ\033[0m");
	}
	
	private void setTipoShield() {
		chargeImpactDmg = new Stat(70, 10, "+", "% increase in charge impact damage", 30, true);												stats.add(chargeImpactDmg);				chargeImpactDmg.setNombre("\033[36mchargeImpactDmg\033[0m");
		chargeRechargeRate = new Stat(60, 10, "+", "% increase in charge recharge rate", 30, "-", "% decrease in charge recharge rate", 30);	stats.add(chargeRechargeRate);			chargeRechargeRate.setNombre("\033[33mchargeRechargeRate\033[0m");
		fullTurnControlCharge = new Stat("Full turning control while charging", 45, true);														stats.add(fullTurnControlCharge);		fullTurnControlCharge.setNombre("\033[36mfullTurnControlCharge\033[0m");
		meleeKillsRefillcharge = new Stat(75, 5, "Melee kills refill ", "% of your charge meter", 45, true);									stats.add(meleeKillsRefillcharge);		meleeKillsRefillcharge.setNombre("\033[36mmeleeKillsRefillcharge\033[0m");
	}
	
	private void setTipoSword() {
		chargeDuration = new Stat(10, 1, 4, "0."," sec increase in charge duration", 45, "0.", " sec decrease in charge duration");		stats.add(chargeDuration);			chargeDuration.setNombre("\033[33mchargeDuration\033[0m");
		meleeKillsRefillcharge = new Stat(40, 5, "Melee kills refill ", "% of your charge meter", 35, true);							stats.add(meleeKillsRefillcharge);	meleeKillsRefillcharge.setNombre("\033[36mmeleeKillsRefillcharge\033[0m");
		killsHealHP = new Stat(60, 5, "Gain ","% of base health on kill", 35, true);													stats.add(killsHealHP);				killsHealHP.setNombre("\033[36mkillsHealHP\033[0m");
		honorbound = new Stat("Honorbound: Once drawn sheathing deals 50 damage to yourself unless it kills", 35, false);				stats.add(honorbound);				honorbound.setNombre("\033[91mhonorbound\033[0m");
		ammoRefillsCharge = new Stat("Ammo boxes collected also refill your charge meter", 20, true);									stats.add(ammoRefillsCharge);		ammoRefillsCharge.setNombre("\033[36mammoRefillsCharge\033[0m");
		medkitsRefillCharge = new Stat("Health packs collected also refill your charge meter", 25, true);								stats.add(medkitsRefillCharge);		medkitsRefillCharge.setNombre("\033[36mmedkitsRefillCharge\033[0m");
		hitsRefillCharge = new Stat(30, 5, "Melee hits refill ", "% of your charge meter", 25, true);									stats.add(hitsRefillCharge);		hitsRefillCharge.setNombre("\033[36mhitsRefillCharge\033[0m");
	}
	
	private void setTipoBottle() {
		/*private Stat critsWhileSJ;
		private Stat minisWhileSJ;
		private Stat healOnDrinking;
		private Stat healOnDrinking;*/
		critsWhileSJ = new Stat("Deals crits while the wielder is stickybomb jumping", 30, true);					stats.add(critsWhileSJ);		critsWhileSJ.setNombre("\033[36mcritsWhileSJ\033[0m");
		minisWhileSJ = new Stat("Deals Mini-crits while the wielder is stickybomb jumping", 15, true);				stats.add(minisWhileSJ);		minisWhileSJ.setNombre("\033[36mminisWhileSJ\033[0m");
		healOnDrinking = new Stat(15, 5, "If bottle isn't broken, taunting heals +", " health", 20, true);			stats.add(healOnDrinking);		healOnDrinking.setNombre("\033[36mhealOnDrinking\033[0m");
		ifBrokenMoreDmg = new Stat(15, 5, "+", "% damage bonus if bottle is broken", 25, true);						stats.add(ifBrokenMoreDmg);		ifBrokenMoreDmg.setNombre("\033[36mifBrokenMoreDmg\033[0m");
	}
	
	/**************************************************************************************************
	 * 											   HEAVY											 *
	**************************************************************************************************/
	private void setTipoMinigun() {
		dmgReswhileSpun = new Stat(20, 5, "+","% damage resistance when below 50% health and spun up", 20, true);						stats.add(dmgReswhileSpun);		dmgReswhileSpun.setNombre("\033[36mdmgReswhileSpun\033[0m");
		spinUpTime = new Stat(20, 5, "", "% faster spin up time", 35, "", "% slower spin up time", 50);									stats.add(spinUpTime);			spinUpTime.setNombre("\033[33mspinUpTime\033[0m");
		spinDownTime = new Stat(30, 5, "", "% faster spin down time", 15, "", "% slower spin down time", 50);							stats.add(spinDownTime);		spinDownTime.setNombre("\033[33mspinDownTime\033[0m");
		moveSpeedSpun = new Stat(20, 5, "+", "% faster move speed when deployed", 25, "-", "% slower move speed when deployed", 60);	stats.add(moveSpeedSpun);		moveSpeedSpun.setNombre("\033[33mmoveSpeedSpun\033[0m");
		silentSpun = new Stat("Silent Killer: Silent spin sound", "Screaming Killer: Louder spin sound", 12);							stats.add(silentSpun);			silentSpun.setNombre("\033[33msilentSpun\033[0m");
	}
	
	private void setTipoShotgunHeavy() {
		shotgunKnockback = new Stat(30, 5, "+", "% knockback force", 20, true);																				stats.add(shotgunKnockback);	shotgunKnockback.setNombre("\033[36mshotgunKnockback\033[0m");
		dmgIfRecentSpun = new Stat(20, 5, "+", "% damage if minigun has recently been deployed", 20, "-", "% damage if minigun has recently been deployed", 20);	stats.add(dmgIfRecentSpun);		dmgIfRecentSpun.setNombre("\033[33mdmgIfRecentSpun\033[0m");
		knockbackResActive = new Stat(20, 5, "+", "% knockback resistance when active", 20, true);															stats.add(knockbackResActive);	knockbackResActive.setNombre("\033[36mknockbackResActive\033[0m");
	}
	
	private void setTipoLunchbox() {
		/*
		private Stat eatingBuff;
		 */
		fastEat = new Stat(50,10,"+","% faster eating speed", 50, true);											stats.add(fastEat);			fastEat.setNombre("\033[36mfastEat\033[0m");
		refillLunch = new Stat(25,5,"+","% faster lunch recharge rate",40, "-","% slower lunch recharge rate", 25); stats.add(refillLunch);		refillLunch.setNombre("\033[33mrefillLunch\033[0m");
		smallKitNoRef = new Stat("Small health packs don't refill your lunch when full health", 15, false);			stats.add(smallKitNoRef);	smallKitNoRef.setNombre("\033[91msmallKitNoRef\033[0m");
		eatingHeal = new Stat(350, 100, 25, "Eating it restores +", " health", 50, true, false);					stats.add(eatingHeal);		eatingHeal.setNombre("\033[36meatingHeal\033[0m");
		refillOnKills = new Stat(20, 5, "Killing fills +", "% of lunch meter", 20, true);							stats.add(refillOnKills);	refillOnKills.setNombre("\033[36mrefillOnKills\033[0m");
		smallKitThrow = new Stat("It becomes a small health pack when thrown", 15, false);							stats.add(smallKitThrow);	smallKitThrow.setNombre("\033[91msmallKitThrow\033[0m");
		bigKitThrow = new Stat("It becomes a large health pack when thrown", 20, true);								stats.add(bigKitThrow);		bigKitThrow.setNombre("\033[36mbigKitThrow\033[0m");
	}
	
	private void relacionadasLunchbox() {
		bigKitThrow.setLista(Arrays.asList(smallKitThrow));
		smallKitThrow.setLista(Arrays.asList(bigKitThrow));
	}
	
	/**************************************************************************************************
	 * 											 ENGINEER											 *
	**************************************************************************************************/
	private void setTipoShotgunEngineer() {
		shotgunDmgToSentryTarget = new Stat(25, 5, "", "% increased damage to your Sentry's target", 30, "", "% decreased damage to your Sentry's target", 25);						stats.add(shotgunDmgToSentryTarget);	shotgunDmgToSentryTarget.setNombre("\033[33mshotgunDmgToSentryTarget\033[0m");
		revengeCrits = new Stat("Gain 2 revenge crits for each sentry kill and\r\n1 for each sentry assist when your sentry is destroyed", 40, true);								stats.add(revengeCrits);				revengeCrits.setNombre("\033[36mrevengeCrits\033[0m");
		revengeMinicrits = new Stat("Gain 2 revenge mini-crits for each sentry kill and\r\n1 for each sentry assist when your sentry is destroyed", 15, true);						stats.add(revengeMinicrits);			revengeMinicrits.setNombre("\033[36mrevengeMinicrits\033[0m");
		shotgunMetalOnHit = new Stat(60, 5, "On Hit: Gain up to +", " metal per attack", 40, true);																					stats.add(shotgunMetalOnHit);			shotgunMetalOnHit.setNombre("\033[36mshotgunMetalOnHit\033[0m");
		shotgunMetalLossShooting = new Stat(40, 5, "Per Shot: Lose -", " metal", 35, false);																						stats.add(shotgunMetalLossShooting);	shotgunMetalLossShooting.setNombre("\033[91mshotgunMetalLossShooting\033[0m");
		shotgunSentryVuln = new Stat(30, 5, "+", "% damage resistance for your Sentry Gun when active", 35, "-", "% damage vulnerabilty for your Sentry Gun when active", 30);	stats.add(shotgunSentryVuln);			shotgunSentryVuln.setNombre("\033[33mshotgunSentryVuln\033[0m");
	}
	
	private void setTipoPistolEngineer() {
		pistolDmgToSentryTarget = new Stat(25, 5, "", "% increased damage to your Sentry's target", 20, "", "% decreased damage to your Sentry's target", 25);					stats.add(pistolDmgToSentryTarget);		pistolDmgToSentryTarget.setNombre("\033[33mpistolDmgToSentryTarget\033[0m");
		iconOverTarget = new Stat("Displays an icon over the current target of your Sentry Gun", 15, true);																		stats.add(iconOverTarget);				iconOverTarget.setNombre("\033[36miconOverTarget\033[0m");
		pistolMetalOnHit = new Stat(10, 1, "On Hit: Gain up to +", " metal per attack", 20, true);																				stats.add(pistolMetalOnHit);			pistolMetalOnHit.setNombre("\033[36mpistolMetalOnHit\033[0m");
		pistolMetalLossShooting = new Stat(5, 1, "Per Shot: Lose -", " metal", 25, false);																						stats.add(pistolMetalLossShooting);		pistolMetalLossShooting.setNombre("\033[91mpistolMetalLossShooting\033[0m");
		pistolSentryVuln = new Stat(25, 5, "+", "% damage resistance for your Sentry Gun when active", 30, "-", "% damage vulnerabilty for your Sentry Gun when active", 25);	stats.add(pistolSentryVuln);			pistolSentryVuln.setNombre("\033[33mpistolSentryVuln\033[0m");
	}
	
	private void setTipoWrench() {
		repairRate = new Stat(25, 5, "", "% faster repair rate", 35, "", "% slower repair rate", 25);																					stats.add(repairRate);						repairRate.setNombre("\033[33mrepairRate\033[0m");
		sentryBuildSpeed = new Stat(75, 5, "Sentry build speed increased by ", "%", 60, "Sentry build speed decreased by ", "%", 50);													stats.add(sentryBuildSpeed);				sentryBuildSpeed.setNombre("\033[33msentryBuildSpeed\033[0m");
		dispenserBuildSpeed = new Stat(100, 5, "Dispenser build speed increased by ", "%", 40, "Dispenser build speed decreased by ", "%", 50);											stats.add(dispenserBuildSpeed);				dispenserBuildSpeed.setNombre("\033[33mdispenserBuildSpeed\033[0m");
		teleporterBuildSpeed = new Stat(100, 5, "Teleporter build speed increased by ", "%", 35, "Teleporter build speed decreased by ", "%", 50);										stats.add(teleporterBuildSpeed);			teleporterBuildSpeed.setNombre("\033[33mteleporterBuildSpeed\033[0m");
		hitSpeedBuilding = new Stat(30, 5, "Construction hit speed boost increased by ", "%", 40, true);																				stats.add(hitSpeedBuilding);				hitSpeedBuilding.setNombre("\033[36mhitSpeedBuilding\033[0m");
		sentryCost = new Stat(30, 10, "-", "% metal cost when constructing Sentry Guns", 45, "+", "% metal cost when constructing Sentry Guns", 20);									stats.add(sentryCost);						sentryCost.setNombre("\033[33msentryCost\033[0m");
		dispenserCost = new Stat(40, 10, "-", "% metal cost when constructing or upgrading dispensers", 45, "+", "% metal cost when constructing or upgrading dispensers", 30);			stats.add(dispenserCost);					dispenserCost.setNombre("\033[33mdispenserCost\033[0m");
		teleporterCost = new Stat(50, 10, "-", "% metal cost when constructing or upgrading teleporters", 35, "+", "% metal cost when constructing or upgrading teleporters", 40);		stats.add(teleporterCost);					teleporterCost.setNombre("\033[33mteleporterCost\033[0m");
		lessMetalDispensers = new Stat(20, 10, "+", "% more metal from pickups and dispensers", 25, "-", "% less metal from pickups and dispensers", 30);									stats.add(lessMetalDispensers);				lessMetalDispensers.setNombre("\033[33mlessMetalDispensers\033[0m");
		wrenchDmgToSentryTarget = new Stat(40, 10, "+", "% increased damage to your Sentry's target", 20, "-", "% decreased damage to your Sentry's target", 30);							stats.add(wrenchDmgToSentryTarget);			wrenchDmgToSentryTarget.setNombre("\033[33mwrenchDmgToSentryTarget\033[0m");
		wrenchMetalOnHit = new Stat(10, 1, "On Hit: Gain +", " metal per attack", 20, true);																							stats.add(wrenchMetalOnHit);				wrenchMetalOnHit.setNombre("\033[36mwrenchMetalOnHit\033[0m");
		stealMetalFromEngineers = new Stat(50, 10, "On Hit: Steals +", " metal from enemy Engineers", 40, true);																		stats.add(stealMetalFromEngineers);			stealMetalFromEngineers.setNombre("\033[36mstealMetalFromEngineers\033[0m");
		boostOtherEngies = new Stat("On hit: Give a power boost to other engineers' friendly buildings", 40, true);																		stats.add(boostOtherEngies);				boostOtherEngies.setNombre("\033[36mboostOtherEngies\033[0m");
		dispenserRange = new Stat(25, 5, "+", "% dispenser range", 30, true);																											stats.add(dispenserRange);					dispenserRange.setNombre("\033[36mdispenserRange\033[0m");
		lessSentryRange = new Stat(15, 5, "-", "% Sentry Gun range", 30, false);																										stats.add(lessSentryRange);					lessSentryRange.setNombre("\033[91mlessSentryRange\033[0m");
		telesGiveSpeedBoost = new Stat("Telporters give a speed boost when used", 15, true);																							stats.add(telesGiveSpeedBoost);				telesGiveSpeedBoost.setNombre("\033[36mtelesGiveSpeedBoost\033[0m");
		destroysSappedBuilds = new Stat("On Hit: Destroys sapped enemy buildings", 25, true);																							stats.add(destroysSappedBuilds);			destroysSappedBuilds.setNombre("\033[36mdestroysSappedBuilds\033[0m");
	}
	
	/**************************************************************************************************
	 * 											   MEDIC											 *
	**************************************************************************************************/
	private void setTipoSyringeGun() {
		medRegenPassive = new Stat(3,1,"+"," health regenerated per second on wearer", 25, "-", " health regenerated per second on wearer", 2);		stats.add(medRegenPassive);		medRegenPassive.setNombre("\033[33mmedRegenPassive\033[0m");
		syringeUberOnHit = new Stat(3,1,"On Hit: Up to +","% ÜberCharge added",42,true);															stats.add(syringeUberOnHit);	syringeUberOnHit.setNombre("\033[36msyringeUberOnHit\033[0m");
		speedBasedUber = new Stat(20, 5,"Up to +", "% faster movement speed based on ÜberCharge percentage when active", 25,
				"Up to +", "% slower movement speed based on ÜberCharge percentage when active", 15);												stats.add(speedBasedUber);		speedBasedUber.setNombre("\033[33mspeedBasedUber\033[0m");
		dmgBasedUber = new Stat(20, 5,"Up to +", "% damage bonus based on ÜberCharge percentage when active", 25,
				"Up to -", "% damage penalty based on ÜberCharge percentage when active",20);														stats.add(dmgBasedUber);		dmgBasedUber.setNombre("\033[33mdmgBasedUber\033[0m");
		fireSpdBasedUber = new Stat(20, 5,"Up to +", "% faster firing speed based on ÜberCharge percentage when active", 25,
				"Up to -", "% slower firing speed based on ÜberCharge percentage when active",20);													stats.add(fireSpdBasedUber);	fireSpdBasedUber.setNombre("\033[33mfireSpdBasedUber\033[0m");
	}
	
	private void relacionadasSyringeGun() {
		fireSpdBasedUber.setLista(Arrays.asList(firingSpeed));
		dmgBasedUber.setLista(Arrays.asList(damage, damagePlayers));
		speedBasedUber.setLista(Arrays.asList(speedActive));
	}
	
	private void setTipoMedigun() {
		healRate = new Stat(40, 5, "+", "% heal rate", 50, "-", "% heal rate", 10);							stats.add(healRate);			healRate.setNombre("\033[33mhealRate\033[0m");
		uberRate = new Stat(65, 5, "+", "% Übercharge rate", 30, "-", "% Übercharge rate", 20);				stats.add(uberRate);			uberRate.setNombre("\033[33muberRate\033[0m");
		overhealRate = new Stat(25, 5, "+", "% Overheal rate", 25, "-", "% Overheal rate", 65);				stats.add(overhealRate);		overhealRate.setNombre("\033[33moverhealRate\033[0m");
		overhealMax = new Stat("+", "% max Overheal", 75, "", "% max Overheal", 100);						stats.add(overhealMax);			overhealMax.setNombre("\033[33moverhealMax\033[0m");
		mimicsRJ = new Stat("Mirror the blast jumps and shield charges of patients.", 15, true);			stats.add(mimicsRJ);			mimicsRJ.setNombre("\033[36mmimicsRJ\033[0m");
		buffsOnClass = new Stat("Gains small buffs depending on what class you are healing", 30, true);		stats.add(buffsOnClass);		buffsOnClass.setNombre("\033[36mbuffsOnClass\033[0m");
		healBuildings = new Stat("Able to slowly heal friendly buildings", 40, true);						stats.add(healBuildings);		healBuildings.setNombre("\033[36mhealBuildings\033[0m");
		drainsHealth = new Stat("Able to drain health from enemies", 45, true);								stats.add(drainsHealth);		drainsHealth.setNombre("\033[36mdrainsHealth\033[0m");
		
		deploySpeed = new Stat(75, 5, "This weapon deploys ", "% faster", 25, "This weapon deploys ", "% slower", 75);					stats.add(deploySpeed);			deploySpeed.setNombre("\033[33mdeploySpeed\033[0m");
		holsterSpeed = new Stat(30, 5, "This weapon holsters ", "% faster", 20, "This weapon holsters ", "% slower", 75);				stats.add(holsterSpeed);		holsterSpeed.setNombre("\033[33mholsterSpeed\033[0m");
		speedActive = new Stat(10, 5, "+", "% faster moving speed when active", 45, "-", "% slower moving speed when active",10);		stats.add(speedActive);			speedActive.setNombre("\033[33mspeedActive\033[0m");
		jumpActive = new Stat(25, 5, "+", "% greater jump height when active", 15, "-", "% jump height when active",25);				stats.add(jumpActive);			jumpActive.setNombre("\033[33mjumpActive\033[0m");
	}
	
	private void setTipoBonesaw() {
		onHitUber = new Stat(45, 5, "On Hit: +" ,"% ÜberCharge added", 60, true);																	stats.add(onHitUber);			onHitUber.setNombre("\033[33monHitUber\033[0m");
		//harvestOrgan = new Stat																													stats.add(harvestOrgan);		harvestOrgan.setNombre("\033[33mharvestOrgan\033[0m");
		areaHealTaunt = new Stat("Alt-Fire: Applies a healing effect to all nearby teammates", 15, true);											stats.add(areaHealTaunt);		areaHealTaunt.setNombre("\033[36mareaHealTaunt\033[0m");
		medRegenActive = new Stat(4,1,"+"," health regenerated per second when active", 25, true);													stats.add(medRegenActive);		medRegenActive.setNombre("\033[36mmedRegenActive\033[0m");
		medRegenPassive = new Stat(3,1,"+"," health regenerated per second on wearer", 25, "-", " health regenerated per second on wearer", 2);		stats.add(medRegenPassive);		medRegenPassive.setNombre("\033[33mmedRegenPassive\033[0m");
		seeHP = new Stat("Allows you to see enemy health", 10, true);																				stats.add(seeHP);				seeHP.setNombre("\033[36mseeHP\033[0m");
		seeUPatientHP = new Stat("Allows you and your patient to see enemy health", 20, true);														stats.add(seeUPatientHP);		seeUPatientHP.setNombre("\033[36mseeUPatientHP\033[0m");
		seeCharges = new Stat("Allows you to see enemy health and charge bars of all kind", 15, true);												stats.add(seeCharges);			seeCharges.setNombre("\033[36mseeCharges\033[0m");
	}
	
	/**************************************************************************************************
	 * 											   SNIPER											 *
	**************************************************************************************************/
	private void setSniperRifle() {
		chargeRate = new Stat(30, 5, "+", "% charge rate", 40, "-", "% charge rate", 30);													stats.add(chargeRate);			chargeRate.setNombre("\033[33mchargeRate\033[0m");
		//chargeOnKills = new Stat(6, 2, true);																								stats.add(chargeOnKills);		chargeOnKills.setNombre("\033[36mchargeOnKills\033[0m");
		hsMinicrit = new Stat("Headshots Mini-crit instead of crit", 50, false);															stats.add(hsMinicrit);			hsMinicrit.setNombre("\033[91mhsMinicrit\033[0m");
		hsonlyFull = new Stat(90, 10, "Headshots only when charge is ", "% or more", 40, false);											stats.add(hsonlyFull);			hsonlyFull.setNombre("\033[91mhsonlyFull\033[0m");
		hsonlyFull2 = new Stat("No headshots when not fully charged", 50, false);															stats.add(hsonlyFull2);			hsonlyFull2.setNombre("\033[91mhsonlyFull2\033[0m");
		noNoscope = new Stat("Cannot fire unless zoomed", 25, false);																		stats.add(noNoscope);			noNoscope.setNombre("\033[91mnoNoscope\033[0m");
		lessDmgMulti = new Stat(20, 10, "+", "% damage multiplier based on charge", 30, "-", "% damage multiplier based on charge", 30);	stats.add(lessDmgMulti);		lessDmgMulti.setNombre("\033[91mlessDmgMulti\033[0m");
		debuffOnCharge = new Stat("SniperRifle", 6, 2);																						stats.add(debuffOnCharge);		debuffOnCharge.setNombre("\033[36mdebuffOnCharge\033[0m");
		dmgOnBodyS = new Stat(25,5, "-", "% damage on body shot", 25, false);																stats.add(dmgOnBodyS);			dmgOnBodyS.setNombre("\033[91mdmgOnBodyS\033[0m");
	}
	
	private void relacionadasSniperRifle() {
		hsonlyFull.setLista(Arrays.asList(hsonlyFull2));
		hsonlyFull2.setLista(Arrays.asList(hsonlyFull));
	}
	
	private void setTipoSMG() {
		smgDmgPierce = new Stat("Attacks pierce damage resistance effects and bonuses", 25, true);						stats.add(smgDmgPierce);	smgDmgPierce.setNombre("\033[36msmgDmgPierce\033[0m");
	}
	
	private void setTipoBackpackSniper() {
		noFlinching = new Stat("No flinching when aiming and fully charged", 30, true); 															stats.add(noFlinching);				noFlinching.setNombre("\033[36mnoFlinching\033[0m");
		knobackWhenAim = new Stat(25, 5, "Knockback reduced by ", "% when aiming", 30, true);														stats.add(knobackWhenAim);			knobackWhenAim.setNombre("\033[36mknobackWhenAim\033[0m");
		backstabDamage = new Stat(85, 50, 5, "Blocks a single backstab attempt, blocked backstab deals ", " damage to wearer", 55, true, true);		stats.add(backstabDamage);			backstabDamage.setNombre("\033[36mbackstabDamage\033[0m");
		dmgRecievedFromBack = new Stat(50, 10, "Blocks ", "% of damage recieved from the back", 45, true);											stats.add(dmgRecievedFromBack);		dmgRecievedFromBack.setNombre("\033[36mdmgRecievedFromBack\033[0m");
	}
	
	private void setTipoKukri() {
		critsWhenMini = new Stat("Crits whenever it would normally mini-crit", 25, true);											stats.add(critsWhenMini);		critsWhenMini.setNombre("\033[36mcritsWhenMini\033[0m");
		onHitRemoveCloak = new Stat(25, 5, "On Hit: Victim loses ", "% cloak", 35, "On Hit: Victim gains ", "% cloak", 25);			stats.add(onHitRemoveCloak);	onHitRemoveCloak.setNombre("\033[33monHitRemoveCloak\033[0m");
		onHitNoCloak = new Stat(5, 1,"On Hit: Victim can't cloak for ","", 45, true);												stats.add(onHitNoCloak);		onHitNoCloak.setNombre("\033[33monHitNoCloak\033[0m");
	}
	
	/**************************************************************************************************
	 * 											     SPY											 *
	**************************************************************************************************/
	private void setTipoRevolver() {
		canHeadshot = new Stat("Crits on headshot", 50, true);																								stats.add(canHeadshot);			canHeadshot.setNombre("\033[36mcanHeadshot\033[0m");
		cloakHit = new Stat(20, 5, "+", "% cloak on hit", 20, true);																						stats.add(cloakHit);			cloakHit.setNombre("\033[36mcloakHit\033[0m");
		cloakDuration = new Stat(50, 5, "+", "% cloak duration", 35, "-", "% cloak duration", 15);															stats.add(cloakDuration);		cloakDuration.setNombre("\033[33mcloakDuration\033[0m");
		revolverDmgPierce = new Stat("Attacks pierce damage resistance effects and bonuses", 25, true);														stats.add(revolverDmgPierce);	revolverDmgPierce.setNombre("\033[36mrevolverDmgPierce\033[0m");
		dmgWhileDisg = new Stat(25, 5, "+", "% damage bonus while disguised", 15, "-", "% damage penalty while disguised", 25);								stats.add(dmgWhileDisg);		dmgWhileDisg.setNombre("\033[33mdmgWhileDisg\033[0m");
		dmgNoDisg = new Stat(20, 5, "+", "% damage bonus while undisguised", 20, "-", "% damage penalty while undisguised", 20);							stats.add(dmgNoDisg);			dmgNoDisg.setNombre("\033[33mdmgNoDisg\033[0m");
		critsStabSap = new Stat("Gives one guaranteed critical hit for each building destroyed with your sapper attached or backstab kill", 50, true);		stats.add(critsStabSap);		critsStabSap.setNombre("\033[36mcritsStabSap\033[0m");
		critsStab = new Stat("Gives one guaranteed critical hit for each backstab kill", 25, true);															stats.add(critsStab);			critsStab.setNombre("\033[36mcritsStab\033[0m");
		critsSap = new Stat("Gives one guaranteed critical hit for each building destroyed with your sapper attached", 25, true);							stats.add(critsSap);			critsSap.setNombre("\033[36mcritsSap\033[0m");
		minicritsStabSap = new Stat("Gives one guaranteed Mini-crit for each building destroyed with your sapper attached or backstab kill", 30, true);		stats.add(minicritsStabSap);	minicritsStabSap.setNombre("\033[36mminicritsStabSap\033[0m");
		minicritsStab = new Stat("Gives one guaranteed Mini-crit for each backstab kill", 15, true);														stats.add(minicritsStab);		minicritsStab.setNombre("\033[36mminicritsStab\033[0m");
		minicritsSap = new Stat("Gives one guaranteed Mini-crit for each building destroyed with your sapper attached", 15, true);							stats.add(minicritsSap);		minicritsSap.setNombre("\033[36mminicritsSap\033[0m");
		//critsFallOff = new Stat("Critical damage is affected by range", 25, false);																		stats.add(critsFallOff);		critsFallOff.setNombre("\033[91mcritsFallOff\033[0m");
		debuffHeadshot = new Stat("RevolverHeadshot", 6, 1);																												stats.add(debuffHeadshot);		debuffHeadshot.setNombre("\033[36mdebuffHeadshot\033[0m");
		dmgOnSappedBuildings = new Stat(20, 5, "+", "% damage bonus on sapped buildings", 30, "-", "% damage penalty on sapped buildings", 20);				stats.add(dmgOnSappedBuildings);dmgOnSappedBuildings.setNombre("\033[33mdmgOnSappedBuildings\033[0m");
	}
	
	private void relacionadasRevolver() {
		canHeadshot.setLista(Arrays.asList(debuffHeadshot));
		debuffHeadshot.setLista(Arrays.asList(canHeadshot));
		dmgWhileDisg.setLista(Arrays.asList(dmgNoDisg));
		dmgNoDisg.setLista(Arrays.asList(dmgWhileDisg));
		critsStabSap.setLista(Arrays.asList(critsStab, critsSap, minicritsStabSap, minicritsStab, minicritsSap, minicritsWhenCrit));
		critsStab.setLista(Arrays.asList(critsStabSap, critsSap, minicritsStabSap, minicritsStab, minicritsWhenCrit));
		critsSap.setLista(Arrays.asList(critsStabSap, critsStab, minicritsStabSap, minicritsSap, minicritsWhenCrit));
		minicritsStabSap.setLista(Arrays.asList(critsStab, critsSap, critsStabSap, minicritsStab, minicritsSap));
		minicritsStab.setLista(Arrays.asList(minicritsStabSap, minicritsSap, critsStab, critsStabSap));
		minicritsSap.setLista(Arrays.asList(minicritsStabSap, critsSap, minicritsStab, critsStabSap));
	}
	
	private void setTipoSapper() {
		// Stat sapperHP, sapperDmg, sapperExplodes, doesntDeactBuild, drainsAmmoBuild, drainsBuildRate, vulnOnSappedBuilds, sapperAppliedBuff, SapperDestroyedBuff, sapperCompletedBuff;
		sapperHP = new Stat(35,35, "+", " max Sapper health", 40, "-", " max Sapper health", 35);															stats.add(sapperHP);			sapperHP.setNombre("\033[33msapperHP\033[0m");
		sapperDmg = new Stat(40, 10, "+", "% Sapper damage bonus", 60, "-", "% Sapper damage penalty", 100);												stats.add(sapperDmg);			sapperDmg.setNombre("\033[33msapperDmg\033[0m");
		sapperExplodes = new Stat("Sapper causes an explosion if it destroys the building", 30, true);														stats.add(sapperExplodes);		sapperExplodes.setNombre("\033[36msapperExplodes\033[0m");
		doesntDeactBuild = new Stat("Doesn't deactivate buildings when sapping", 35, false);																stats.add(doesntDeactBuild);	doesntDeactBuild.setNombre("\033[91mdoesntDeactBuild\033[0m");
		drainsAmmoBuild = new Stat("Drains ammo from Sentry Guns and metal from Dispensers and gives you primary ammo", 20, true);														stats.add(drainsAmmoBuild);		drainsAmmoBuild.setNombre("\033[36mdrainsAmmoBuild\033[0m");
		drainsBuildRate = new Stat("Drains upgrade progress from buildings that are not completly upgraded and gives you cloak meter", 15, true);										stats.add(drainsBuildRate);		drainsBuildRate.setNombre("\033[36mdrainsBuildRate\033[0m");
		vulnOnSappedBuilds = new Stat(25, 5, "-", "% damage vulnerability on sapped buildings", 30, "+", "% damage resistance on sapped buildings", 25);	stats.add(vulnOnSappedBuilds);	vulnOnSappedBuilds.setNombre("\033[33mvulnOnSappedBuilds\033[0m");
		sapperAppliedBuff = new Stat(5,1,"SapperApplied");																									stats.add(sapperAppliedBuff);	sapperAppliedBuff.setNombre("\033[36msapperAppliedBuff\033[0m");
		SapperDestroyedBuff = new Stat(5,1,"SapperRemoved");																								stats.add(SapperDestroyedBuff);	SapperDestroyedBuff.setNombre("\033[36mSapperDestroyedBuff\033[0m");
		sapperCompletedBuff = new Stat(6,1,"SapperComplete");																								stats.add(sapperCompletedBuff);	sapperCompletedBuff.setNombre("\033[36msapperCompletedBuff\033[0m");
		
		deploySpeed = new Stat(75, 5, "This weapon deploys ", "% faster", 25, "This weapon deploys ", "% slower", 75);					stats.add(deploySpeed);			deploySpeed.setNombre("\033[33mdeploySpeed\033[0m");
		holsterSpeed = new Stat(30, 5, "This weapon holsters ", "% faster", 20, "This weapon holsters ", "% slower", 75);				stats.add(holsterSpeed);		holsterSpeed.setNombre("\033[33mholsterSpeed\033[0m");
		speedActive = new Stat(10, 5, "+", "% faster moving speed when active", 45, "-", "% slower moving speed when active",10);		stats.add(speedActive);			speedActive.setNombre("\033[33mspeedActive\033[0m");
		jumpActive = new Stat(25, 5, "+", "% greater jump height when active", 15, "-", "% jump height when active",25);				stats.add(jumpActive);			jumpActive.setNombre("\033[33mjumpActive\033[0m");
	}
	
	private void setTipoKnife() {
		stats.remove(stats.indexOf(damage));
		damage = new Stat(50, 5, "+", "% damage bonus", 35, "-", "% damage penalty", 20);												stats.add(damage);				damage.setNombre("\033[33mdamage\033[0m");
		
		onBSDrainHP = new Stat(210, 130, 5, "On Backstab: Absorbs the health of your victim, max Overheal from stolen health: ", " health", 65,true, false);		stats.add(onBSDrainHP);			onBSDrainHP.setNombre("\033[36monBSDrainHP\033[0m");
		onBSStealDis = new Stat("Upon a successful backstab against a human target, you rapidly disguise as your victim", 22, true);				stats.add(onBSStealDis);		onBSStealDis.setNombre("\033[36monBSStealDis\033[0m");
		onBSSilent = new Stat("Silent Killer: No attack noise from backstabs", 15, true);															stats.add(onBSSilent);			onBSSilent.setNombre("\033[36monBSSilent\033[0m");
		onKillCloak = new Stat(30,5,"On Kill: +", "% cloak",20, true);																				stats.add(onKillCloak);			onKillCloak.setNombre("\033[36monKillCloak\033[0m");
		onBSCloak = new Stat(35,5,"On Backstab: +", "% cloak",15, true);																			stats.add(onBSCloak);			onBSCloak.setNombre("\033[36monBSCloak\033[0m");
		onBSHurtPatient = new Stat(80,40,5,"When backstabbing a Medic, his patient recieves "," damage", 50, true, false);							stats.add(onBSHurtPatient);		onBSHurtPatient.setNombre("\033[36monBSHurtPatient\033[0m");
		onBSBuffOnClass = new Stat(8,3,1,"Gain a buff depending on which class you backstabbed for "," seconds", 35, true, false);					stats.add(onBSBuffOnClass);		onBSBuffOnClass.setNombre("\033[36monBSBuffOnClass\033[0m");
		disgTakesCloak = new Stat(100,10,"Normal disguises require (and consume) ","% of your cloak meter", 45, false);								stats.add(disgTakesCloak);		disgTakesCloak.setNombre("\033[91mdisgTakesCloak\033[0m");
		knifeCloakDrain = new Stat(35,5,"+","% cloak drain rate", 45, false);																		stats.add(knifeCloakDrain);		knifeCloakDrain.setNombre("\033[91mknifeCloakDrain\033[0m");
	}
	
	private void relacionadasKnife() {
		onBSDrainHP.setLista(Arrays.asList(meleeKillHP));
	}
	
	private void setTipoInvisWatch() {
		/*
	private Stat cloakSound;
	private Stat uncloakSound;
	private Stat uncloakStill;
	private Stat bumpDrainsCloak;
		 */
		HPstandStill = new Stat("Slowly regenerates health when cloaked and standing still", 12, true);					stats.add(HPstandStill);			HPstandStill.setNombre("\033[36mHPstandStill\033[0m");
		noAmmoCloaked = new Stat("No cloak meter from ammo boxes when invisible", 20, false);							stats.add(noAmmoCloaked);			noAmmoCloaked.setNombre("\033[91mnoAmmoCloaked\033[0m");
		lessAmmoCloaked = new Stat(40, 5,"-", "% less cloak from ammo boxes when invisible", 15, false);				stats.add(lessAmmoCloaked);			lessAmmoCloaked.setNombre("\033[91mlessAmmoCloaked\033[0m");
		moreAmmoUncloaked = new Stat(25, 5,"+", "% cloak from ammo boxes when visible", 15, true);						stats.add(moreAmmoUncloaked);		moreAmmoUncloaked.setNombre("\033[36mmoreAmmoUncloaked\033[0m");
		cloakRecharge = new Stat(100, 10,"+", "% cloak regen rate",50,"-","% cloak regen rate",50);						stats.add(cloakRecharge);			cloakRecharge.setNombre("\033[33mcloakRecharge\033[0m");
		cloakDuration = new Stat(50, 5, "+", "% cloak duration", 35, "-", "% cloak duration", 15);						stats.add(cloakDuration);			cloakDuration.setNombre("\033[33mcloakDuration\033[0m");
		speedWhileCloak = new Stat(25,5,"+","% faster movement speed while invisible",35, true);						stats.add(speedWhileCloak);			speedWhileCloak.setNombre("\033[36mspeedWhileCloak\033[0m");
		dmgResOnCloak = new Stat(10,5,"+","% extra damage resistance while invisible", 25,"-","% less damage resistance while invisible",15);			stats.add(dmgResOnCloak);			dmgResOnCloak.setNombre("\033[33mdmgResOnCloak\033[0m");
		cloakSpeed = new Stat(50,25, "+","% faster cloak speed", 26, "-","% slower cloak speed",25);					stats.add(cloakSpeed);				cloakSpeed.setNombre("\033[33mcloakSpeed\033[0m");
		uncloakSpeed = new Stat(50,25, "+","% faster decloak speed", 26, "-","% slower decloak speed",25);				stats.add(uncloakSpeed);			uncloakSpeed.setNombre("\033[33muncloakSpeed\033[0m");
		visibFlash = new Stat(20,20,"","% shorter cloak flicker when recieving damage",15,"","% longer cloak flicker when recieving damage",20);		stats.add(visibFlash);				visibFlash.setNombre("\033[33mvisibFlash\033[0m");
		noFlickerDmg = new Stat(35,10,5,"No cloak flicker when attacks recieved deal less than "," damage",45,true,false);								stats.add(noFlickerDmg);			noFlickerDmg.setNombre("\033[36mnoFlickerDmg\033[0m");
		cloakSound = new Stat(40,20,"+", "% quieter cloak sound", 15,"+","% louder cloak sound", 20);					stats.add(cloakSound);				cloakSound.setNombre("\033[33mcloakSound\033[0m");
		uncloakSound = new Stat(40,20,"+", "% quieter decloak sound", 25,"+","% louder decloak sound", 20);				stats.add(uncloakSound);			uncloakSound.setNombre("\033[33muncloakSound\033[0m");
		uncloakStill = new Stat("Decloak is completely silent when stading still.",40, true);							stats.add(uncloakStill);			uncloakStill.setNombre("\033[33muncloakStill\033[0m");
		bumpDrainsCloak = new Stat(20,5,"You lose -","% cloak when bumping into enemies while invisible",40, false);	stats.add(bumpDrainsCloak);			bumpDrainsCloak.setNombre("\033[91mbumpDrainsCloak\033[0m");
	}
	
	private void relacionadasInvisWatch() {
		noAmmoCloaked.setLista(Arrays.asList(lessAmmoCloaked, moreAmmoUncloaked));
		lessAmmoCloaked.setLista(Arrays.asList(noAmmoCloaked, moreAmmoUncloaked));
		moreAmmoUncloaked.setLista(Arrays.asList(noAmmoCloaked, lessAmmoCloaked));
		uncloakSound.setLista(Arrays.asList(uncloakStill));
		uncloakStill.setLista(Arrays.asList(uncloakSound));
	}
	
	public void generarArma() {
		
		int i;
		
		// Ordenar la lista de stats y obtener cantidad de positivos y negativos
		Collections.sort(stats);
		for(Stat s: stats) {
			if(s.getType() == 1 || s.getType() == 2) {
				statsPositivosDisponibles += 1;
			}
			if(s.getType() == 3 || s.getType() == 2) {
				statsNegativosDisponibles += 1;
			}
			System.out.print("\n "+ s.getNombre());
			
		}
		System.out.print("\n\n POSITIVOS: "+ statsPositivosDisponibles);
		System.out.print("\n NEGATIVOS: "+ statsNegativosDisponibles);
		
		if(isBanner) {
			while(banner.size() < 4 && puntuacionBanner <= maxPuntuacionBanner) {
				Random rand = new Random();
				Random rand2 = new Random();
				int r = rand.nextInt(bannerBuffs.size());
				int aux = r;
				int indexOfMin = aux;
				int indexOfMax = aux;
				int r2;
				Stat statAux;
				boolean correcto = false;
				
				// Si la puntuación ya superó el promedio, puede seguir o no de manera aleatoria
				if(puntuacionBanner >= minPuntuacionBanner) {
					if(banner.size() >= 2) {
						r2 = rand2.nextInt(banner.size());
					} else if(banner.size() == 1) {
						r2 = rand2.nextInt(2);
					} else {
						r2 = 0;
					}
					if(r2 != 0) {
						break;
					}
				}
				
				// Analiza todos los stats y si cabe dentro de la puntuación, lo toma
				do {
					statAux = bannerBuffs.get(aux);
					System.out.print("\n Analizando: "+statAux.getNombre()+"\tmin = "+statAux.getPuntajeMenor(true)+"\tmax = "+ statAux.getPeso()+"\tpun = "+puntuacionBanner);
					// Buscar el stat que tiene la puntuación menor e ir acumulando su índice
					if(statAux.getPuntajeMenor(true) < bannerBuffs.get(indexOfMin).getPuntajeMenor(true)) {
						indexOfMin = aux;
					}
					// Buscar el stat que tiene la puntuación mayor e ir acumulando su índice
					if(statAux.getPeso() > bannerBuffs.get(indexOfMax).getPeso()) {
						indexOfMax = aux;
					}
					// Si el stat es el último y es muy chico, buscar otro. Si es muy grande buscar otro
					if(	(banner.size() == 4 && (statAux.getPeso() + puntuacionBanner) < minPuntuacionBanner)
						||
						statAux.getPuntajeMenor(true) > (maxPuntuacionBanner - puntuacionBanner))
					{
						aux++;
					} else {
						correcto = true;
						break;
					}
					// Si se sobrepasa de la lista, regresar al comienzo
					if(bannerBuffs.size() == aux || bannerBuffs.get(aux).getType() == 3) {
						aux = 0;
					}
				} while(aux != r);
				// Si el stat de menor peso sobrepasa el máximo, ya no añade más stats
				if(puntuacionBanner + bannerBuffs.get(indexOfMin).getPuntajeMenor(true) > maxPuntuacionBanner) {
					break;
				}
				if(correcto == false) {
					statAux = bannerBuffs.get(indexOfMin);
				}
				if(banner.size() == 4 && correcto == false) {
					if(bannerBuffs.get(indexOfMax).getPeso() + puntuacionBanner < minPuntuacionBanner) {
						statAux = bannerBuffs.get(indexOfMax);
						do {
							statAux.setPositivo();
						} while(statAux.getPuntaje() != statAux.getPeso());
					}
				} else {
					System.out.print("\nEntra: "+statAux.getNombre());
					int cont = 0;
					do {
						statAux.setPositivo();
						cont++;
					} while(statAux.getPuntaje() > (maxPuntuacionBanner - puntuacionBanner) && cont < 100);
				}
				// Añadir el stat a la lista de stats
				System.out.print("\n\n   "+statAux.getTexto()+"\n");
				banner.add(statAux);
				puntuacionBanner += statAux.getPuntaje();
				eliminarStatsBuffs(statAux);
				
				
			}
		}
		
		for(Stat s : banner) {
			System.out.print("\n"+s.getNombre());
		}
		System.out.print("\nPuntuación banner = "+puntuacionBanner);
		
		puntuacionPositiva += puntuacionBanner/2;
		
		if(power != 5) {
			
			/**********************************************************************************************************************************
			 * 														STATS POSITIVOS ALEATORIOS
			 **********************************************************************************************************************************/
			if(maxStatsPositivos == 0) {
				while(positivos.size() < 5 && puntuacionPositiva < maxPuntuacionPositivos) {
					Random rand = new Random();
					int r = rand.nextInt(statsPositivosDisponibles);
					int aux = r;
					Stat statAux;
					int indexOfMin = aux;
					int indexOfMax = aux;
					boolean correcto = false;
					
					Random rand2 = new Random();
					int r2;
					
					if(puntuacionPositiva >= maxPuntuacionPositivos) {
						break;
					}
					
					if(power == 0 && !isBatWithBaseball) {
						rand2 = new Random();
						r2 = rand2.nextInt(3);
						if(r2 == 0) {
							break;
						}
	 				}
					
					// Si la puntuación ya superó el promedio, puede seguir o no de manera aleatoria
					if(puntuacionPositiva >= minPuntuacionPositivos) {
						rand2 = new Random();
						if(positivos.size() >= 2) {
							r2 = rand2.nextInt(positivos.size());
						} else if(positivos.size() == 1) {
							r2 = rand2.nextInt(2);
						} else {
							r2 = 0;
						}
						if(r2 != 0) {
							break;
						}
					}
					
					// Analiza todos los stats y si cabe dentro de la puntuación, lo toma
					do {
						statAux = stats.get(aux);
						System.out.print("\n Analizando: "+statAux.getNombre()+"\tmin = "+statAux.getPuntajeMenor(true)+"\tmax = "+ statAux.getPeso()+"\tpun = "+puntuacionPositiva);
						// Buscar el stat que tiene la puntuación menor e ir acumulando su índice
						if(statAux.getPuntajeMenor(true) < stats.get(indexOfMin).getPuntajeMenor(true)) {
							indexOfMin = aux;
						}
						// Buscar el stat que tiene la puntuación mayor e ir acumulando su índice
						if(statAux.getPeso() > stats.get(indexOfMax).getPeso()) {
							indexOfMax = aux;
						}
						// Si el stat es el último y es muy chico, buscar otro. Si es muy grande buscar otro
						if(	(positivos.size() == 3 && (statAux.getPeso() + puntuacionPositiva) < minPuntuacionPositivos)
							||
							statAux.getPuntajeMenor(true) > (maxPuntuacionPositivos - puntuacionPositiva))
						{
							aux++;
						} else {
							correcto = true;
							break;
						}
						// Si se sobrepasa de la lista, regresar al comienzo
						if(stats.size() == aux || stats.get(aux).getType() == 3) {
							aux = 0;
						}
					} while(aux != r);
					// Si el stat de menor peso sobrepasa el máximo, ya no añade más stats
					if(puntuacionPositiva + stats.get(indexOfMin).getPuntajeMenor(true) > maxPuntuacionPositivos) {
						break;
					}
					if(correcto == false) {
						statAux = stats.get(indexOfMin);
					}
					if(positivos.size() == 3 && correcto == false) {
						if(stats.get(indexOfMax).getPeso() + puntuacionPositiva < minPuntuacionPositivos) {
							statAux = stats.get(indexOfMax);
							do {
								statAux.setPositivo();
							} while(statAux.getPuntaje() != statAux.getPeso());
						}
					} else {
						if(isBatWithBaseball && positivos.size() == 0) {
							statAux = stats.get(stats.indexOf(ball));
						}
						System.out.print("\nEntra: "+statAux.getNombre());
						int cont = 0;
						do {
							statAux.setPositivo();
							cont++;
						} while(statAux.getPuntaje() > (maxPuntuacionPositivos - puntuacionPositiva) && cont < 100);
					}
					// Añadir el stat a la lista de stats
					System.out.print("\n\n   "+statAux.getTexto()+"\n");
					if(statAux == mimicsRJ) {
						neutralesDespues.add(statAux);
					} else {
						positivos.add(statAux);
						puntuacionPositiva += statAux.getPuntaje();
					}
					eliminarStats(statAux);
				}
			/**********************************************************************************************************************************
			 * 														STATS POSITIVOS FIJOS
			 **********************************************************************************************************************************/
			} else {
				while(positivos.size() < maxStatsPositivos && statsPositivosDisponibles != 0) {
					Random rand = new Random();
					int r = rand.nextInt(statsPositivosDisponibles);
					int aux = r;
					Stat statAux;
					int indexOfMin = aux;
					int indexOfMax = aux;
					boolean correcto = false;
					
					// Analiza todos los stats y si cabe dentro de la puntuación, lo toma
					do {
						statAux = stats.get(aux);
						System.out.print("\n Analizando: "+statAux.getNombre()+"\tmin = "+statAux.getPuntajeMenor(true)+"\tmax = "+ statAux.getPeso()+"\tpun = "+puntuacionPositiva);
						// Buscar el stat que tiene la puntuación menor e ir acumulando su índice
						if(statAux.getPuntajeMenor(true) < stats.get(indexOfMin).getPuntajeMenor(true)) {
							indexOfMin = aux;
						}
						// Buscar el stat que tiene la puntuación mayor e ir acumulando su índice
						if(statAux.getPeso() > stats.get(indexOfMax).getPeso()) {
							indexOfMax = aux;
						}
						// Si el stat es el último y es muy chico, buscar otro. Si es muy grande buscar otro
						if(		// Si el stat es el último y es muy chico, buscar otro
							(positivos.size() == maxStatsPositivos-1 && (statAux.getPeso() + puntuacionPositiva) < minPuntuacionPositivos)
							||	// Si el stat es el último y es muy grande, buscar otro
							(positivos.size() == maxStatsPositivos-1 && statAux.getPuntajeMenor(true) > (maxPuntuacionPositivos - puntuacionPositiva))
							|| 	// Si el stat no es el último y no deja espacio para más stats, busca otro 
							(positivos.size() != maxStatsPositivos-1 && (statAux.getPuntajeMenor(true) + puntuacionPositiva > maxPuntuacionPositivos - 2.8*(maxStatsPositivos - positivos.size()) ) ) ) 
						{
							aux++;
						} else {
							correcto = true;
							break;
						}
						// Si se sobrepasa de la lista, regresar al comienzo
						if(stats.size() == aux || stats.get(aux).getType() == 3) {
							aux = 0;
						}
					} while(aux != r);
					// Si no se encontró un buen stat
					if(correcto == false) {
						// Si el más chico es muy grande
						if(
							(positivos.size() == maxStatsPositivos-1 &&
							stats.get(indexOfMin).getPuntajeMenor(true) > maxPuntuacionPositivos - puntuacionPositiva)
							||
							(positivos.size() != maxStatsPositivos-1 &&
							(stats.get(indexOfMin).getPuntajeMenor(true) + puntuacionPositiva > maxPuntuacionPositivos - 2.8*(maxStatsPositivos - positivos.size() ) )
							)
						) {
							System.out.print("\nEntra: "+statAux.getNombre());
							statAux = stats.get(indexOfMin);
							System.out.print("\nSe cambia por: "+statAux.getNombre());
							do {
								statAux.setPositivo();
							} while(statAux.getPuntaje() != statAux.getPuntajeMenor(true));
						}
						// Si el más grande es muy chico
						else if(positivos.size() == maxStatsPositivos-1 &&
								(stats.get(indexOfMax).getPeso() + puntuacionPositiva) < minPuntuacionPositivos) {
							System.out.print("\nEntra: "+statAux.getNombre());
							statAux = stats.get(indexOfMax);
							System.out.print("\nSe cambia por: "+statAux.getNombre());
							do {
								statAux.setPositivo();
							} while(statAux.getPuntaje() != statAux.getPeso());
						}
					} else {
						if(isBatWithBaseball && positivos.size() == 0) {
							statAux = stats.get(stats.indexOf(ball));
						}
						System.out.print("\nEntra: "+statAux.getNombre());
						int cont = 0;
						do {
							statAux.setPositivo();
							System.out.print("\nScore: "+statAux.getPuntaje());
							cont++;
						} while(statAux.getPuntaje() > (maxPuntuacionPositivos - puntuacionPositiva)
								||
								(positivos.size() == maxStatsPositivos-1 && statAux.getPuntaje() + puntuacionPositiva < minPuntuacionPositivos)
								&& cont < 100);
					}
					// Añadir el stat a la lista de stats
					System.out.print("\n\n   "+statAux.getTexto()+"\n");
					if(statAux == mimicsRJ) {
						neutralesDespues.add(statAux);
					} else {
						positivos.add(statAux);
						puntuacionPositiva += statAux.getPuntaje();
					}
					eliminarStats(statAux);
				}
			}
			
			/**********************************************************************************************************************************
			 * 														STATS NEGATIVOS ALEATORIOS
			 **********************************************************************************************************************************/
			if(maxStatsNegativos == 0) {
				while(negativos.size() < 5 && puntuacionNegativa < maxPuntuacionNegativos) {
					Random rand = new Random();
					int r = rand.nextInt(statsNegativosDisponibles);
					int aux = r + stats.size() - statsNegativosDisponibles;
					Stat statAux;
					int indexOfMin = aux;
					int indexOfMax = aux;
					boolean correcto = false;
					
					Random rand2 = new Random();
					int r2;
					
					if(puntuacionNegativa >= maxPuntuacionNegativos || (puntuacionNegativa >= puntuacionPositiva+8 && power >= 2)) {
						break;
					}
					
					if(power == 4 || (!isWeapon && power >= 2)) {
						rand2 = new Random();
						r2 = rand2.nextInt(3);
						if(r2 == 0) {
							break;
						}
	 				}
					
					// Si la puntuación ya superó el promedio, puede seguir o no de manera aleatoria
					if(puntuacionNegativa >= minPuntuacionNegativos || (puntuacionNegativa >= puntuacionPositiva+8 && power >= 2) || !isWeapon) {
						rand2 = new Random();
						if(negativos.size() >= 2) {
							r2 = rand2.nextInt(negativos.size()+1);
							if(!isWeapon && power >= 2) {
								r2 = rand2.nextInt(negativos.size()+4);
							} else if(!isWeapon) {
								r2 = rand2.nextInt(negativos.size()+1);
							}
						} else if(negativos.size() == 1) {
							r2 = rand2.nextInt(2);
							if(!isWeapon && power >= 2) {
								r2 = rand2.nextInt(3);
							} else if(!isWeapon) {
								r2 = rand2.nextInt(2);
							}
						} else {
							r2 = 0;
							if(!isWeapon && power >= 2) {
								r2 = rand2.nextInt(2);
							}
						}
						if(r2 != 0) {
							break;
						}
					}
					
					// Analiza todos los stats y si cabe dentro de la puntuación, lo toma
					do {
						statAux = stats.get(aux);
						System.out.print("\n Analizando: "+statAux.getNombre()+"\tmin = "+statAux.getPuntajeMenor(false)+"\tmax = "+ statAux.getPeso()+"\tpun = "+puntuacionNegativa);
						// Buscar el stat que tiene la puntuación menor e ir acumulando su índice
						if(statAux.getPuntajeMenor(false) < stats.get(indexOfMin).getPuntajeMenor(false)) {
							indexOfMin = aux;
						}
						// Buscar el stat que tiene la puntuación mayor e ir acumulando su índice
						if(statAux.getPeso() > stats.get(indexOfMax).getPeso()) {
							indexOfMax = aux;
						}
						// Si el stat es el último y es muy chico, buscar otro. Si es muy grande buscar otro
						if(	(negativos.size() == 4 && (statAux.getPeso() + puntuacionNegativa) < minPuntuacionNegativos)
							||
							statAux.getPuntajeMenor(false) > (maxPuntuacionNegativos - puntuacionNegativa))
						{
							aux++;
						} else {
							correcto = true;
							break;
						}
						// Si se sobrepasa de la lista, regresar al comienzo
						if(stats.size() == aux) {
							aux = stats.size() - statsNegativosDisponibles;
						}
					} while(aux != r + stats.size() - statsNegativosDisponibles);
					// Si el stat de menor peso sobrepasa el máximo, ya no añade más stats
					if(puntuacionNegativa + stats.get(indexOfMin).getPuntajeMenor(false) > maxPuntuacionNegativos) {
						break;
					}
					if(correcto == false) {
						statAux = stats.get(indexOfMin);
					}
					if(negativos.size() == 4 && correcto == false) {
						if(stats.get(indexOfMax).getPeso() + puntuacionNegativa < minPuntuacionNegativos) {
							statAux = stats.get(indexOfMax);
							do {
								statAux.setNegativo();
							} while(statAux.getPuntaje() != statAux.getPeso());
						}
					} else {
						System.out.print("\nEntra: "+statAux.getNombre());
						int cont = 0;
						do {
							statAux.setNegativo();
							cont++;
						} while(statAux.getPuntaje() > (maxPuntuacionNegativos - puntuacionNegativa) && cont < 100);
					}
					System.out.print("\n\n   "+statAux.getTexto()+"\n");
					negativos.add(statAux);
					puntuacionNegativa += statAux.getPuntaje();
					eliminarStats(statAux);
					
				}
			/**********************************************************************************************************************************
			 * 														STATS NEGATIVOS FIJOS
			 **********************************************************************************************************************************/
			} else {
				while(negativos.size() < maxStatsNegativos && statsNegativosDisponibles != 0) {
					Random rand = new Random();
					int r = rand.nextInt(statsNegativosDisponibles);
					int aux = r + stats.size() - statsNegativosDisponibles;
					Stat statAux;
					int indexOfMin = aux;
					int indexOfMax = aux;
					boolean correcto = false;
					
					// Analiza todos los stats y si cabe dentro de la puntuación, lo toma
					do {
						statAux = stats.get(aux);
						System.out.print("\n Analizando: "+statAux.getNombre()+"\tmin = "+statAux.getPuntajeMenor(false)+"\tmax = "+ statAux.getPeso()+"\tpun = "+puntuacionNegativa);
						// Buscar el stat que tiene la puntuación menor e ir acumulando su índice
						if(statAux.getPuntajeMenor(false) < stats.get(indexOfMin).getPuntajeMenor(false)) {
							indexOfMin = aux;
						}
						// Buscar el stat que tiene la puntuación mayor e ir acumulando su índice
						if(statAux.getPeso() > stats.get(indexOfMax).getPeso()) {
							indexOfMax = aux;
						}
						// Si el stat es el último y es muy chico, buscar otro. Si es muy grande buscar otro
						if(		// Si el stat es el último y es muy chico, buscar otro
							(negativos.size() == maxStatsNegativos-1 && (statAux.getPeso() + puntuacionNegativa) < minPuntuacionNegativos)
							||	// Si el stat es el último y es muy grande, buscar otro
							(negativos.size() == maxStatsNegativos-1 && statAux.getPuntajeMenor(false) > (maxPuntuacionNegativos - puntuacionNegativa))
							|| 	// Si el stat no es el último y no deja espacio para más stats, busca otro 
							(negativos.size() != maxStatsNegativos-1 && (statAux.getPuntajeMenor(false) + puntuacionNegativa > maxPuntuacionNegativos - 2.8*(maxStatsNegativos - negativos.size()) ) ) ) 
						{
							aux++;
						} else {
							correcto = true;
							break;
						}
						// Si se sobrepasa de la lista, regresar al comienzo
						if(stats.size() == aux) {
							aux = stats.size() - statsNegativosDisponibles;
						}
					} while(aux != r + stats.size() - statsNegativosDisponibles);
					// Si no se encontró un buen stat
					if(correcto == false) {
						// Si el más chico es muy grande
						if(
							(negativos.size() == maxStatsNegativos-1 &&
							stats.get(indexOfMin).getPuntajeMenor(false) > maxPuntuacionNegativos - puntuacionNegativa)
							||
							(negativos.size() != maxStatsNegativos-1 &&
							(stats.get(indexOfMin).getPuntajeMenor(false) + puntuacionNegativa > maxPuntuacionNegativos - 2.8*(maxStatsNegativos - negativos.size() ) )
							)
						) {
							int cont = 0;
							System.out.print("\nEntra: "+statAux.getNombre());
							statAux = stats.get(indexOfMin);
							System.out.print("\nEra muy grande, se cambia por: "+statAux.getNombre());
							do {
								statAux.setNegativo();
								//cont++;
							} while(statAux.getPuntaje() != statAux.getPuntajeMenor(false) && cont < 100);
						}
						// Si el más grande es muy chico
						else if(negativos.size() == maxStatsNegativos-1 &&
								(stats.get(indexOfMax).getPeso() + puntuacionNegativa) < minPuntuacionNegativos) {
							int cont = 0;
							System.out.print("\nEntra: "+statAux.getNombre());
							statAux = stats.get(indexOfMax);
							System.out.print("\nEra muy chico, se cambia por: "+statAux.getNombre());
							do {
								statAux.setNegativo();
								//cont++;
							} while(statAux.getPuntaje() != statAux.getPeso() && cont < 100);
						}
					} else {
						System.out.print("\nEntra: "+statAux.getNombre());
						int cont = 0;
						do {
							statAux.setNegativo();
							System.out.print("\nScore: "+statAux.getPuntaje());
							cont++;
						} while(statAux.getPuntaje() > (maxPuntuacionNegativos - puntuacionNegativa)
								||
								(negativos.size() == maxStatsNegativos-1 && statAux.getPuntaje() + puntuacionNegativa < minPuntuacionNegativos)
								&& cont < 100);
					}
					// Añadir el stat a la lista de stats
					System.out.print("\n\n   "+statAux.getTexto()+"\n");
					negativos.add(statAux);
					puntuacionNegativa += statAux.getPuntaje();
					eliminarStats(statAux);
				}
			}
			
		} else {
			Random rand = new Random();
			int r = 0;
			if(maxStatsPositivos != 0) {
				r = maxStatsPositivos;
			} else {
				r = rand.nextInt(6);
			}
			for(i = 0; i < r; i++) {
				getStatPositivo();
			}
			if(maxStatsNegativos != 0) {
				r = maxStatsNegativos;
			} else {
				if(r == 0) {
					r = rand.nextInt(5)+1;
				} else {
					r = rand.nextInt(6);
				}
			}
			for(i = 0; i < r; i++) {
				getStatNegativo();
			}
		}
		
		
		System.out.print("\n ");
		for(Stat s: stats) {
			System.out.print("\n "+ s.getNombre());
		}
		System.out.print("\n ");
		
		for(Stat s : positivos) {
			System.out.print("\n \033[36m" + s.getTexto() + "     " + s.getPuntaje() + "\033[0m");
		}
		for(Stat s : negativos) {
			System.out.print("\n \033[91m" + s.getTexto() + "     " + s.getPuntaje() + "\033[0m");
		}
		
		System.out.print("\n\n PUNTUACIÓN POSITIVA: "+ puntuacionPositiva);
		System.out.print("\n PUNTUACIÓN NEGATIVA: "+ puntuacionNegativa);
		System.out.print("\n PUNTUACIÓN BANNER: "+ puntuacionBanner);
	}
	
	
	/* 		public void getStatPositivo()
	 * Fija un stat de la lista como positivo y elimina sus stats relacionados de la lista
	*/
	public void getStatPositivo() {
		
		// Seleccionar un stat positivo aleatorio de la lista
		Random rand = new Random();
		int r = rand.nextInt(statsPositivosDisponibles);
		Stat statAux = stats.get(r);
		statAux.setPositivo();
		System.out.print("\n\n   "+statAux.getTexto()+"\n");
		positivos.add(statAux);
		puntuacionPositiva += statAux.getPuntaje();
		eliminarStats(statAux);
		/*
		for(Stat s: stats) {
			System.out.print("\n "+ s.getNombre());
		}*/
		System.out.print("\n\n  POSITIVOS: "+ statsPositivosDisponibles);
		System.out.print("\n  NEGATIVOS: "+ statsNegativosDisponibles);
	}
	
	/* 		public void getStatNegativo()
	 * Fija un stat de la lista como negativo y elimina sus stats relacionados de la lista
	*/
	public void getStatNegativo() {
		
		// Seleccionar un stat negativo aleatorio de la lista
		Random rand = new Random();
		int r = rand.nextInt(statsNegativosDisponibles);
		Stat statAux = stats.get(r+stats.size()-statsNegativosDisponibles);
		statAux.setNegativo();
		System.out.print("\n\n   "+statAux.getTexto()+"\n");
		negativos.add(statAux);
		puntuacionNegativa += statAux.getPuntaje();
		eliminarStats(statAux);
		/*
		for(Stat s: stats) {
			System.out.print("\n "+ s.getNombre());
		}*/
		System.out.print("\n\n  POSITIVOS: "+ statsPositivosDisponibles);
		System.out.print("\n  NEGATIVOS: "+ statsNegativosDisponibles);
	}
	
	public void eliminarStats(Stat s) {
		if(s.getType() == 1 || s.getType() == 2) {
			statsPositivosDisponibles -= 1;
		}
		if(s.getType() == 3 || s.getType() == 2) {
			statsNegativosDisponibles -= 1;
		}
		for(Stat relacionado : s.getLista()) {
			if(stats.indexOf(relacionado) != -1) {
				if(relacionado.getType() == 1 || relacionado.getType() == 2) {
					statsPositivosDisponibles -= 1;
				}
				if(relacionado.getType() == 3 || relacionado.getType() == 2) {
					statsNegativosDisponibles -= 1;
				}
				stats.remove(stats.indexOf(relacionado));
				System.out.print("\n Eliminado: "+ relacionado.getNombre());
			}
		}
		System.out.print("\n Eliminado: "+ s.getNombre());
		System.out.print("\n ");
		stats.remove(stats.indexOf(s));
	}
	
	public void eliminarStatsBuffs(Stat s) {
		for(Stat relacionado : s.getLista()) {
			if(bannerBuffs.indexOf(relacionado) != -1) {
				bannerBuffs.remove(bannerBuffs.indexOf(relacionado));
				System.out.print("\n Eliminado: "+ relacionado.getNombre());
			}
		}
		System.out.print("\n Eliminado: "+ s.getNombre());
		System.out.print("\n ");
		bannerBuffs.remove(bannerBuffs.indexOf(s));
	}

	public ArrayList<ArrayList<Stat>> getStats() {

		ordenDeStats = new ArrayList<>(Arrays.asList(
		maxHp, damage, clipSize, damagePlayers, damageBuildings, firingSpeed, reloadSpeed, hpOnHit, passiveSpeed, passiveJumpHeight, speedActive, jumpActive,
		overhealPenalty, minicritsExplosion, minicritsWhenCrit,
		passiveDmgResistance, passiveBulletResistance, passiveFireResistance,passiveExpResistance, passiveMeleeResistance, passiveKnockbackRes,
		healFromHealers, healFromKits, healFromHealersWA, passiveHpRegen,
		dmgResitanceWhileActive, bulletResitanceWhileActive, fireResitanceWhileActive, expResitanceWhileActive, meleeResitanceWhileActive,
		passiveNoFall, passiveFallDmg, deploySpeed, holsterSpeed,
		maxPrimaryAmmo, maxSecondaryAmmo, noAmmoDispensers, noAmmoNeed, noRandomCrits
		));
		
		ArrayList<Stat> ordenDeBuffs = new ArrayList<>(Arrays.asList(
				crits, minicrits, scareEnemy, tankCrits, moreDmg, dmgRes,
				moveSpeed, midairJump, healDmg, regenHP,
				moreBullDmg, moreExpDmg, moreFireDmg, moreMeleeDmg,
				sentryDmg, bullRes, expRes, fireRes , meleeRes,
				moreJump, regenAmmo ));
		
		ArrayList<ArrayList<Stat>> s = new ArrayList<>();
		
		// Yes, I used bubble sort, sue me
		for(int i = 0; i < negativos.size(); i++) {
			for(int j = 0; j < negativos.size() - i - 1; j++) {
				System.out.print(ordenDeStats.indexOf(negativos.get(j))+" > "+ordenDeStats.indexOf(negativos.get(j+1)));
				if(ordenDeStats.indexOf(negativos.get(j)) > ordenDeStats.indexOf(negativos.get(j+1))) {
					Stat statAux = negativos.get(j);
					negativos.set(j, negativos.get(j+1));
					negativos.set(j+1, statAux);
				}
			}
		}
		
		for(int i = 0; i < positivos.size(); i++) {
			for(int j = 0; j < positivos.size() - i - 1; j++) {
				System.out.print(ordenDeStats.indexOf(positivos.get(j))+" > "+ordenDeStats.indexOf(positivos.get(j+1)));
				if(ordenDeStats.indexOf(positivos.get(j)) > ordenDeStats.indexOf(positivos.get(j+1))) {
					Stat statAux = positivos.get(j);
					positivos.set(j, positivos.get(j+1));
					positivos.set(j+1, statAux);
				}
			}
		}
		
		for(int i = 0; i < banner.size(); i++) {
			for(int j = 0; j < banner.size() - i - 1; j++) {
				System.out.print(ordenDeBuffs.indexOf(banner.get(j))+" > "+ordenDeBuffs.indexOf(banner.get(j+1)));
				if(ordenDeBuffs.indexOf(banner.get(j)) > ordenDeBuffs.indexOf(banner.get(j+1))) {
					Stat statAux = banner.get(j);
					banner.set(j, banner.get(j+1));
					banner.set(j+1, statAux);
				}
			}
		}
		
		if(positivos.contains(backstabDamage) || positivos.contains(dmgRecievedFromBack)) {
			Stat fl = new Stat("While not broken:", 1, true);
			fl.setPositivo();
			neutralesAntes.add(0,fl);
			Random ra = new Random();
			int r = ra.nextInt(16);
			if(positivos.contains(backstabDamage) && positivos.contains(dmgRecievedFromBack)) {
				fl = new Stat("This shield breaks after getting backstabbed or absorbing "+(r*15+75)+" damage", 1, true);
			} else if(positivos.contains(backstabDamage)) {
				fl = new Stat("This shield breaks after getting backstabbed", 1, true);
			} else if(positivos.contains(dmgRecievedFromBack)) {
				fl = new Stat("This shield breaks after absorbing "+(r*15+75)+" damage", 1, true);
			}
			fl.setPositivo();
			neutralesDespues.add(0,fl);
		}
		if(isFlameThrower && negativos.indexOf(noAirblast) == -1) {
			Stat fl = new Stat("Extinguishing teammates restores 20 health", 1, true);
			fl.setPositivo();
			positivos.add(0,fl);
		} else if(isSword) {
			Stat fl = new Stat("This weapon has a large melee range and deploys and holsters slower", 1, true);
			fl.setPositivo();
			neutralesAntes.add(0,fl);
		} else if(isBanner) {
			String saux = "Provides a buff that allows nearby team members to ";
			if(banner.size() == 1) {
				saux += banner.get(0).getTexto();
			} else {
				for(Stat st : banner) {
					if(banner.indexOf(st) == banner.size() -1) {
						saux += ", and ";
					}else if (banner.indexOf(st) != banner.size()-1 && banner.indexOf(st) != 0){
						saux += ", ";
					}
					saux += st.getTexto();
				}
			}
			saux += "<br>Rage increases through damage done.";
			Stat fl = new Stat(saux, 1, true);
			fl.setPositivo();
			neutralesDespues.add(0,fl);
		}
		s.add(neutralesAntes);
		s.add(positivos);
		s.add(neutralesMedio);
		s.add(negativos);
		s.add(neutralesDespues);
		return s;
	}
}
