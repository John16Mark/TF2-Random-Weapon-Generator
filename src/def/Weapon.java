package def;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Weapon {
	
	// Clase seleccionada
	private int clase;
	
	private int clipsize;
	private boolean isPrimary = false;
	private boolean isWeapon = true;
	private boolean isMelee = false;
	private boolean isSword = false;
	
	// Lista de stats posibles
	private ArrayList<Stat> stats = new ArrayList<>();
	
	// Cantidad de stats de cada tipo
	private int statsPositivosDisponibles = 0;
	private int statsNegativosDisponibles = 0;
	
	// Listas de stats seleccionados
	private ArrayList<Stat> neutralesAntes = new ArrayList<>();
	private ArrayList<Stat> positivos = new ArrayList<>();
	private ArrayList<Stat> neutralesMedio = new ArrayList<>();
	private ArrayList<Stat> negativos = new ArrayList<>();
	private ArrayList<Stat> neutralesDespues = new ArrayList<>();
	
	// Límites de los stats
	private int maxStatsPositivos = 0;
	private int maxStatsNegativos = 3;
	private int lim = 25;
	private float maxPuntuacionPositivos = 0;
	private float minPuntuacionPositivos = 0;
	private int maxPuntuacionNegativos = 10;
	
	// Puntajes
	private float puntuacionPositiva = 0;
	private float puntuacionNegativa = 0;
	//private float puntuacionBanner = 0;
	
	private int primaryAmmo;
	private int secondaryAmmo;
	
	/* GENERIC */
	Stat maxPrimaryAmmo;
	Stat maxSecondaryAmmo;
	Stat maxHp;
	Stat passiveDmgResistance;
	Stat passiveFireResistance;
	Stat passiveExpResistance;
	Stat passiveBulletResistance;
	Stat passiveMeleeResistance;
	/* PASSIVE */
	Stat passiveHpRegen;
	Stat passiveSpeed;
	Stat passiveJumpHeight;
	Stat passiveKnockbackRes;
	Stat passiveFallDmg;
	Stat passiveNoFall;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* ARMA ataque */
	Stat damage;
	Stat damagePlayers;
	Stat damageBuildings;
	Stat clipSize;
	Stat firingSpeed;
	Stat hpOnHit;
	/* ARMA velocidad */
	Stat deploySpeed;
	Stat holsterSpeed;
	Stat reloadSpeed;
	/* ARMA utilidad */
	Stat speedActive;
	Stat jumpActive;
	/* ARMA extra */
	Stat noAmmoNeed;
	Stat noAmmoDispensers;
	/* ARMA buffs */
	Stat minicritsExplosion;
	Stat minicritsWhenCrit;
	Stat noRandomCrits;
	Stat dmgResitanceWhileActive;
	Stat fireResitanceWhileActive;
	Stat expResitanceWhileActive;
	Stat bulletResitanceWhileActive;
	Stat meleeResitanceWhileActive;
	Stat healFromMedic;
	Stat healFromKits;
	//////////////////////////////////////
	/* BULLETS */
	Stat accuracy;
	Stat minicritsFromBack;
	Stat mediumRangeBulletsPass;
	/* SHOTGUN */
	Stat morePellets;
	Stat fixedPattern;
	/* PROJECTILE */
	Stat projectileSpeed;
	Stat projectileSpread;
	Stat reflectedTurnsCrit;
	Stat cannotReflect;
	/* EXPLOSION */
	Stat explosionRadius;
	Stat destroysStickies;
	Stat fireExplosion;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Scattergun */
	Stat reloadOnKill;
	Stat ifAllConnectDebuff;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Rocket Launcher */
	Stat rocketSelfDamage;
	Stat RocketDamageWhileRJ;
	Stat firingSpeedWhileRJ;
	Stat projectileSpeedWhileRJ;
	Stat radiusWhileRJ;
	/* Shotgun */
	Stat explosiveBullets;
	Stat ShotgunDmgWhileRJ;
	/* Boots */
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Flame Thrower */
	Stat flameRange;
	Stat afterburnDmg;
	Stat airblastCost;
	Stat airblastPush;
	Stat airblastSpeed;
	Stat noAirblast;
	Stat flameSpeed;
	/* Shotgun */
	Stat fireBullets;
	Stat minicritsOnFire;
	Stat minicritsAirblast;
	Stat damageWhileExpJump;
	/* Flare Gun */
	/* Fireaxe */
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Grenade Launcher */
	Stat pipeSelfDamage;
	Stat fuseTime;
	Stat bombsRollLess;
	Stat bombsShatter;
	/* Stickybomb Launcher */
	Stat stickySelfDamage;
	Stat moreStickies;
	Stat stickyArmTime;
	Stat stickyChargTime;
	Stat StickyDmgCharge;
	/* Shield */
	Stat chargeImpactDmg;
	Stat chargeRechargeRate;
	Stat fullTurnControlCharge;
	Stat meleeKillsRefillcharge;
	/* Sword */
	Stat chargeDuration;
	Stat killsFillCharge;
	Stat killsHealHP;
	Stat honorbound;
	Stat ammoRefillsCharge;
	Stat medkitsRefillCharge;
	Stat hitsRefillCharge;
	/* Bottle */
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Minigun */
	Stat dmgReswhileSpun;
	Stat spinUpTime;
	Stat spinDownTime;
	Stat moveSpeedSpun;
	Stat silentSpun;
	/* Shotgun */
	Stat shotgunKnockback;
	Stat dmgIfRecentSpun;
	Stat knockbackResActive;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Shotgun */
	Stat shotgunDmgToSentryTarget;
	Stat revengeCrits;
	Stat revengeMinicrits;
	Stat shotgunMetalOnHit;
	Stat shotgunMetalLossShooting;
	Stat shotgunSentryVuln;
	/* Pistol */
	Stat pistolDmgToSentryTarget;
	Stat iconOverTarget;
	Stat pistolMetalOnHit;
	Stat pistolMetalLossShooting;
	Stat pistolSentryVuln;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Syringe Gun */
	Stat passiveHealing;
	Stat syringeUberOnHit;
	Stat syringeHealOnHit;
	Stat speedBasedUber;
	Stat dmgBasedUber;
	Stat fireSpdBasedUber;
	/* Medigun */
	Stat healRate;
	Stat uberRate;
	Stat overhealRate;
	Stat overhealMax;
	Stat mimicsRJ;
	Stat buffsOnClass;
	Stat healBuildings;
	Stat drainsHealth;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Sniper Rifle */
	Stat chargeRate;
	Stat chargeOnKills;
	Stat hsMinicrit;
	Stat hsonlyFull;
	Stat hsonlyFull2;
	Stat noNoscope;
	Stat lessDmgMulti;
	Stat debuffOnCharge;
	Stat dmgOnBodyS;
	/* SMG */
	Stat smgDmgPierce;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Revolver */
	Stat canHeadshot;
	Stat cloakHit;
	Stat cloakDuration;
	Stat revolverDmgPierce;
	Stat dmgWhileDisg;
	Stat dmgNoDisg;
	Stat critsStabSap;
	Stat critsStab;
	Stat critsSap;
	Stat minicritsStabSap;
	Stat minicritsStab;
	Stat minicritsSap;
	Stat critsFallOff;
	Stat debuffHeadshot;
	Stat dmgOnSappedBuildings;
	/* Sapper */
	Stat sapperHP;
	Stat sapperDmg;
	Stat sapperExplodes;
	Stat doesntDeactBuild;
	Stat drainsAmmoBuild;
	Stat drainsBuildRate;
	Stat vulnOnSappedBuilds;
	Stat sapperAppliedBuff;
	Stat SapperDestroyedBuff;
	Stat sapperCompletedBuff;
	/* Knife */
	/* Invis Watch */
	
	public Weapon(String c, String t, int pos, int neg, int pow) {
		
		maxStatsPositivos = pos;
		maxStatsNegativos = neg;
		
		switch(pow) {
		case 0:
			minPuntuacionPositivos = 0;
			maxPuntuacionPositivos = 23;
			break;
		case 1:
			minPuntuacionPositivos = 15;
			maxPuntuacionPositivos = 35;
			break;
		case 2:
			minPuntuacionPositivos = 25;
			maxPuntuacionPositivos = 45;
			break;
		case 3:
			minPuntuacionPositivos = 37;
			maxPuntuacionPositivos = 70;
			break;
		case 4:
			minPuntuacionPositivos = 46;
			maxPuntuacionPositivos = 140;
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
				
				if(clase == 1){
					//setTipoPistolScout();
				} else if(clase == 6) {
					setTipoPistolEngineer();
				}

				relacionadasArma();
				break;
				/*
			case "bat":
				setTipoArma();
				SetType_Melee();
				
				relacionadasArma();
				break;
				*/
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
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				//Set_BannerBuffs();
				
				relacionadasPasivo();
				break;
				/*
			case "shovel":
				setTipoArma();
				SetType_Melee();
				
				relacionadasArma();
				break;
				*/
				
			case "Flame Thrower":
				isPrimary = true;
				setTipoArma();
				setTipoFlameThrower();
				stats.remove(stats.indexOf(firingSpeed));
				stats.remove(stats.indexOf(clipSize));
				stats.remove(stats.indexOf(reloadSpeed));
				stats.remove(stats.indexOf(hpOnHit));
				
				relacionadasArma();
				relacionadasFlameThrower();
				break;
				/*
			case "fireaxe":
				setTipoArma();
				SetType_Melee();
				
				relacionadasArma();
				break;
				*/
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
				//Set_BannerBuffs();
				
				relacionadasPasivo();
				break;
				
			case "Bottle":
				isMelee = true;
				setTipoArma();
				stats.remove(stats.indexOf(hpOnHit));
				setTipoMelee();
				
				relacionadasArma();
				break;
				
			case "Sword":
				isMelee = true;
				isSword = true;
				setTipoArma();
				stats.remove(stats.indexOf(hpOnHit));
				setTipoMelee();
				setTipoSword();
				stats.remove(stats.indexOf(deploySpeed));
				stats.remove(stats.indexOf(holsterSpeed));
				stats.remove(stats.indexOf(noRandomCrits));
				
				relacionadasArma();
				break;
				
			case "Minigun":
				isPrimary = true;
				setTipoArma();
				setTipoBalas();
				stats.remove(stats.indexOf(clipSize));
				stats.remove(stats.indexOf(reloadSpeed));
				stats.remove(stats.indexOf(hpOnHit));
				setTipoMinigun();
				
				relacionadasArma();
				relacionadasBalas();
				break;
				/*
			case "fists":
				setTipoArma();
				SetType_Melee();
				
				relacionadasArma();
				break;
				*/
			case "Syringe Gun":
				clipsize = 8;
				isPrimary = true;
				setTipoArma();
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				
				relacionadasArma();
				break;
				
			case "Medigun":
				stats.remove(stats.indexOf(maxSecondaryAmmo));
				setTipoMedigun();
				break;
				/*
			case "bonesaw":
				setTipoArma();
				SetType_Melee();
				
				relacionadasArma();
				break;
			*/
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
			/*
			case "smg":
				setTipoArma();
				setTipoBalas();
				SetClipSize(25);
				SetType_SMG();
				
				relacionadasArma();
				break;
				
			case "kukri":
				setTipoArma();
				SetType_Melee();
				
				relacionadasArma();
				break;
				*/
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
		}
		relacionadasGenerico();
	}
	
	private void setTipoGenerico() {
		maxPrimaryAmmo = new Stat("+", "% max primary ammo on wearer", 20, "-", "% max primary ammo on wearer", primaryAmmo);			stats.add(maxPrimaryAmmo);		maxPrimaryAmmo.setNombre("\033[33mmaxPrimaryAmmo\033[0m");
		maxSecondaryAmmo = new Stat("+", "% max secondary ammo on wearer", 20, "-", "% max secondary ammo on wearer", secondaryAmmo);	stats.add(maxSecondaryAmmo);	maxSecondaryAmmo.setNombre("\033[33mmaxSecondaryAmmo\033[0m");
		
		maxHp = new Stat(40, 5, "-", " max health on wearer", 80, false);											stats.add(maxHp);					maxHp.setNombre("\033[91mmaxHp\033[0m");
		passiveDmgResistance = new Stat(30, 5, "-", "% damage vulnerability on wearer", 45, false);					stats.add(passiveDmgResistance);	passiveDmgResistance.setNombre("\033[91mpassiveDmgResistance\033[0m");
		passiveFireResistance = new Stat(50, 5, "-", "% fire damage vulnerability on wearer", 30, false);			stats.add(passiveFireResistance);	passiveFireResistance.setNombre("\033[91mpassiveFireResistance\033[0m");
		passiveExpResistance = new Stat(40, 5, "-", "% explosive damage vulnerability on wearer", 35, false);		stats.add(passiveExpResistance);	passiveExpResistance.setNombre("\033[91mpassiveExpResistance\033[0m");
		passiveBulletResistance = new Stat(30, 5, "-", "% bullet damage vulnerability on wearer", 40, false);		stats.add(passiveBulletResistance);	passiveBulletResistance.setNombre("\033[91mpassiveBulletResistance\033[0m");
		passiveMeleeResistance = new Stat(20, 5, "-", "% melee damage vulnerability on wearer", 25, false);			stats.add(passiveMeleeResistance);	passiveMeleeResistance.setNombre("\033[91mpassiveMeleeResistance\033[0m");
	}
	
	private void relacionadasGenerico() {
		if(isPrimary) {
			maxPrimaryAmmo.setLista(Arrays.asList(noAmmoNeed));
		} else {
			maxSecondaryAmmo.setLista(Arrays.asList(noAmmoNeed));
		}
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
		passiveExpResistance = new Stat(40, 5, "+", "% explosive damage resistance on wearer", 35, "-", "% explosive damage vulnerability on wearer", 40);	stats.add(passiveExpResistance);	passiveExpResistance.setNombre("\033[33mpassiveExpResistance\033[0m");
		passiveBulletResistance = new Stat(30, 5, "+", "% bullet damage resistance on wearer", 40, "-", "% bullet damage vulnerability on wearer", 30);		stats.add(passiveBulletResistance);	passiveBulletResistance.setNombre("\033[33mpassiveBulletResistance\033[0m");
		passiveMeleeResistance = new Stat(20, 5, "+", "% melee damage resistance on wearer", 25, "-", "% melee damage vulnerability on wearer", 20);		stats.add(passiveMeleeResistance);	passiveMeleeResistance.setNombre("\033[33mpassiveMeleeResistance\033[0m");
		passiveHpRegen = new Stat(5, 1, "+", " health regenerated per second on wearer", 35, true);															stats.add(passiveHpRegen);			passiveHpRegen.setNombre("\033[36mpassiveHpRegen\033[0m");
		passiveSpeed = new Stat(20, 5, "+", "% faster move speed on wearer", 40, "-", "% slower move speed on wearer", 20);									stats.add(passiveSpeed);			passiveSpeed.setNombre("\033[33mpassiveSpeed\033[0m");
		passiveJumpHeight = new Stat(25, 5, "+", "% greater jump height on wearer",20, true);																stats.add(passiveJumpHeight);		passiveJumpHeight.setNombre("\033[36mpassiveJumpHeight\033[0m");
		passiveKnockbackRes = new Stat(75, 5, "-", "% reduction in push force taken from damage", 50, true);												stats.add(passiveKnockbackRes);		passiveKnockbackRes.setNombre("\033[36mpassiveKnockbackRes\033[0m");
		passiveFallDmg = new Stat(75, 5, "-", "% fall damage taken", 25, true);																				stats.add(passiveFallDmg);			passiveFallDmg.setNombre("\033[36mpassiveFallDmg\033[0m");
		passiveNoFall = new Stat("wearer takes no fall damage", 25, true);																					stats.add(passiveNoFall);			passiveNoFall.setNombre("\033[36mpassiveNoFall\033[0m");
		healFromMedic = new Stat(100, 5, "+", "% health from packs on wearer", 40, "-", "% health from packs on wearer", 75);								stats.add(healFromMedic);			healFromMedic.setNombre("\033[33mhealFromMedic\033[0m");
		healFromKits = new Stat(50, 5, "+", "% health from healers on wearer", 45, "-", "% health from healers on wearer", 75);							stats.add(healFromKits);			healFromKits.setNombre("\033[33mhealFromKits\033[0m");
	}
	
	private void relacionadasPasivo() {
		/*
		dmgResitanceWhileActive.setLista(Arrays.asList(fireResitanceWhileActive, expResitanceWhileActive, bulletResitanceWhileActive, meleeResitanceWhileActive));
		fireResitanceWhileActive.setLista(Arrays.asList(dmgResitanceWhileActive));
		expResitanceWhileActive.setLista(Arrays.asList(dmgResitanceWhileActive));
		bulletResitanceWhileActive.setLista(Arrays.asList(dmgResitanceWhileActive));
		meleeResitanceWhileActive.setLista(Arrays.asList(dmgResitanceWhileActive));
		*/
		passiveDmgResistance.setLista(Arrays.asList(
				passiveFireResistance, passiveExpResistance, passiveBulletResistance, passiveMeleeResistance,
				dmgResitanceWhileActive, fireResitanceWhileActive, expResitanceWhileActive, bulletResitanceWhileActive, meleeResitanceWhileActive));
		passiveFireResistance.setLista(Arrays.asList(passiveDmgResistance, dmgResitanceWhileActive, fireResitanceWhileActive));
		passiveExpResistance.setLista(Arrays.asList(passiveDmgResistance, dmgResitanceWhileActive, expResitanceWhileActive));
		passiveBulletResistance.setLista(Arrays.asList(passiveDmgResistance, dmgResitanceWhileActive, bulletResitanceWhileActive));
		passiveMeleeResistance.setLista(Arrays.asList(passiveDmgResistance, dmgResitanceWhileActive, meleeResitanceWhileActive));
		passiveFallDmg.setLista(Arrays.asList(passiveNoFall));
		passiveNoFall.setLista(Arrays.asList(passiveFallDmg));
		
	}
	
	private void setTipoArma() {
		// new Stat(maxPostivo, paso, "", "", puntuacion, "", "", maxNegativo);
		
			// Attack //------------------------------------------------------------------------------------------------
		damage = new Stat(30, 5, "+", "% damage bonus", 60, "-", "% damage penalty", 30);												stats.add(damage);				damage.setNombre("\033[33mdamage\033[0m");
		damagePlayers = new Stat(25, 5, "+", "% damage vs players", 40, "-", "% damage penalty vs players", 40);						stats.add(damagePlayers);		damagePlayers.setNombre("\033[33mdamagePlayers\033[0m");
		damageBuildings = new Stat(25, 5, "+", "% damage vs buildings", 15, "-", "% damage penalty vs buildings", 80);					stats.add(damageBuildings);		damageBuildings.setNombre("\033[33mdamageBuildings\033[0m");
		clipSize = new Stat(clipsize, "+", "% clip size", 50, "-" , "% clip size");														stats.add(clipSize);			clipSize.setNombre("\033[33mclipSize\033[0m");
		firingSpeed = new Stat(60, 5, "+", "% faster firing speed", 50, "-", "% slower firing speed", 60);								stats.add(firingSpeed);			firingSpeed.setNombre("\033[33mfiringSpeed\033[0m");
		hpOnHit = new Stat(20, 5, "On Hit: Gain up to +", " health per attack", 35, true);												stats.add(hpOnHit);				hpOnHit.setNombre("\033[36mhpOnHit\033[0m");
			// Speed //------------------------------------------------------------------------------------------------
		deploySpeed = new Stat(75, 5, "This weapon deploys ", "% faster", 25, "This weapon deploys ", "% slower", 75);					stats.add(deploySpeed);			deploySpeed.setNombre("\033[33mdeploySpeed\033[0m");
		holsterSpeed = new Stat(30, 5, "This weapon holsters ", "% faster", 20, "This weapon holsters ", "% slower", 75);				stats.add(holsterSpeed);		holsterSpeed.setNombre("\033[33mholsterSpeed\033[0m");
		reloadSpeed = new Stat(25, 5, "+", "% faster reload speed", 30, "-", "% slower reload speed", 25);								stats.add(reloadSpeed);			reloadSpeed.setNombre("\033[33mreloadSpeed\033[0m");
			// Utility //------------------------------------------------------------------------------------------------
		speedActive = new Stat(10, 5, "+", "% faster moving speed while active", 45, "-", "% slower moving speed while active",10);		stats.add(speedActive);			speedActive.setNombre("\033[33mspeedActive\033[0m");
		jumpActive = new Stat(25, 5, "+", "% greater jump height when active", 15, "-", "% jump height while active",25);				stats.add(jumpActive);			jumpActive.setNombre("\033[33mjumpActive\033[0m");
			// Extra //------------------------------------------------------------------------------------------------
		noAmmoNeed = new Stat("Does not require ammo", 8, true);																		stats.add(noAmmoNeed);			noAmmoNeed.setNombre("\033[36mnoAmmoNeed\033[0m");
		noAmmoDispensers = new Stat("No ammo from dispensers when active", 8,false);													stats.add(noAmmoDispensers);	noAmmoDispensers.setNombre("\033[91mnoAmmoDispensers\033[0m");
			// Buffs //------------------------------------------------------------------------------------------------
		minicritsExplosion = new Stat("Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs", 10, true);	stats.add(minicritsExplosion);	minicritsExplosion.setNombre("\033[36mminicritsExplosion\033[0m");
		minicritsWhenCrit = new Stat("Minicrits whenever it would normally crit", 20, false);											stats.add(minicritsWhenCrit);	minicritsWhenCrit.setNombre("\033[91mminicritsWhenCrit\033[0m");
		noRandomCrits = new Stat("No random critical hits", 5, false);																	stats.add(noRandomCrits);		noRandomCrits.setNombre("\033[91mnoRandomCrits\033[0m");
		dmgResitanceWhileActive = new Stat(35, 5, "+", "% damage resistance while active", 50, "-", "% damage vulnerability while active", 35);						stats.add(dmgResitanceWhileActive);			dmgResitanceWhileActive.setNombre("\033[33mdmgResitanceWhileActive\033[0m");
		fireResitanceWhileActive = new Stat(35, 5, "+", "% fire damage resistance while active", 20, "-", "% fire damage vulnerability while active", 35);			stats.add(fireResitanceWhileActive);		fireResitanceWhileActive.setNombre("\033[33mfireResitanceWhileActive\033[0m");
		expResitanceWhileActive = new Stat(35, 5, "+", "% explosive damage resistance while active", 25, "-", "% explosive damage vulnerability while active", 35);	stats.add(expResitanceWhileActive);			expResitanceWhileActive.setNombre("\033[33mexpResitanceWhileActive\033[0m");
		bulletResitanceWhileActive = new Stat(35, 5, "+", "% bullet damage resistance while active", 30, "-", "% bullet damage vulnerability while active", 35);	stats.add(bulletResitanceWhileActive);		bulletResitanceWhileActive.setNombre("\033[33mbulletResitanceWhileActive\033[0m");
		meleeResitanceWhileActive = new Stat(35, 5, "+", "% melee damage resistance while active", 15, "-", "% melee damage vulnerability while active", 35);		stats.add(meleeResitanceWhileActive);		meleeResitanceWhileActive.setNombre("\033[33mmeleeResitanceWhileActive\033[0m");
		healFromMedic = new Stat(75, 5, "+", "% health from packs on wearer", 35, "-", "% health from packs on wearer", 50);			stats.add(healFromMedic);		healFromMedic.setNombre("\033[33mhealFromMedic\033[0m");
		healFromKits = new Stat(100, 5, "+", "% health from healers on wearer", 40, "-", "% health from healers on wearer", 75);		stats.add(healFromKits);		healFromKits.setNombre("\033[33mhealFromKits\033[0m");
	}
	
	private void relacionadasArma() {
		damage.setLista(Arrays.asList(damagePlayers, damageBuildings));
		damagePlayers.setLista(Arrays.asList(damage));
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
	}
	
	private void setTipoMelee() {
		stats.remove(stats.indexOf(clipSize));
		stats.remove(stats.indexOf(reloadSpeed));
		stats.remove(stats.indexOf(noAmmoNeed));
		hpOnHit = new Stat(25, 5, "On Hit: Gain +", " health per attack", 35, true);				stats.add(hpOnHit);				hpOnHit.setNombre("\033[36mhpOnHit\033[0m");
	}
	
	private void setTipoBalas() {
		accuracy = new Stat(25, 5, "+", "% more accurate", 35, "-", "% less accurate", 20);							stats.add(accuracy);				accuracy.setNombre("\033[33maccuracy\033[0m");
		minicritsFromBack = new Stat("Mini-crits targets when fired at their back from close range", 20, true);		stats.add(minicritsFromBack);		minicritsFromBack.setNombre("\033[36mminicritsFromBack\033[0m");
		mediumRangeBulletsPass = new Stat("On medium and short range hits: Bullets pass thorugh enemies", 10, true);stats.add(mediumRangeBulletsPass);	mediumRangeBulletsPass.setNombre("\033[36mmediumRangeBulletsPass\033[0m");
	}
	
	private void relacionadasBalas() {
		accuracy.setLista(Arrays.asList(fixedPattern));
	}
	
	private void setTipoEscopeta() {
		// morePellets, fixedPattern;
		morePellets = new Stat(50, 10, "+", "% bullets per shot", 40, "-", "% bullets per shot", 60);		stats.add(morePellets);		morePellets.setNombre("\033[33mmorePellets\033[0m");
		fixedPattern = new Stat("Fires a wide, fixed shot pattern", 15, true);								stats.add(fixedPattern);	fixedPattern.setNombre("\033[36mfixedPattern\033[0m");
	}
	
	private void relacionadasEscopeta() {
		fixedPattern.setLista(Arrays.asList(accuracy));
	}
	
	private void setTipoProyectil() {
		projectileSpeed = new Stat(80, 5,"+", "% projectile speed", 35, "-", "% projectile speed", 20);		stats.add(projectileSpeed);		projectileSpeed.setNombre("\033[33mprojectileSpeed\033[0m");
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
	}
	
	/**************************************************************************************************
	 * 											   SCOUT											 *
	**************************************************************************************************/
	private void setTipoScattergun() {
		reloadOnKill = new Stat("On kill: Automatically reloads one shot", 35, true);					stats.add(reloadOnKill);			reloadOnKill.setNombre("\033[36mreloadOnKill\033[0m");
		ifAllConnectDebuff = new Stat(6, 1, "", "");													stats.add(ifAllConnectDebuff);		ifAllConnectDebuff.setNombre("\033[36mifAllConnectDebuff\033[0m");
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
	
	/**************************************************************************************************
	 * 											  DEMOMAN											 *
	**************************************************************************************************/
	private void setTipoGrenadeLauncher() {
		pipeSelfDamage = new Stat(25, 5, "-", "% damage to self", 25, "+", "% damage to self", 25);				stats.add(pipeSelfDamage);		pipeSelfDamage.setNombre("\033[33mpipeSelfDamage\033[0m");
		fuseTime = new Stat(30, 5, "-", "% fuse time on grenades", 20, "+", "% fuse time on grenades", 20);		stats.add(fuseTime);			fuseTime.setNombre("\033[33mfuseTime\033[0m");
		bombsRollLess = new Stat("Grenades have very little bounce and roll", 15, true);						stats.add(bombsRollLess);		bombsRollLess.setNombre("\033[36mbombsRollLess\033[0m");
		bombsShatter = new Stat("Launched bombs shatter on surfaces", 20, false);								stats.add(bombsShatter);		bombsShatter.setNombre("\033[91mbombsShatter\033[0m");
	}
	
	private void relacionadasGrenadeLauncher() {
		bombsRollLess.setLista(Arrays.asList(bombsShatter));
		fuseTime.setLista(Arrays.asList(bombsShatter));
		bombsShatter.setLista(Arrays.asList(fuseTime, bombsRollLess));
	}
	
	private void setTipoStickybombLauncher() {
		stickySelfDamage = new Stat(25, 5, "-", "% blast damage from stickybomb jumps", 25, "+", "% blast damage from stickybomb jumps", 25);	stats.add(stickySelfDamage);	stickySelfDamage.setNombre("\033[33mstickySelfDamage\033[0m");
		moreStickies = new Stat(8, 1, "+", " max stickybombs out", 40, "-", " max stickybombs out", 6);											stats.add(moreStickies);		moreStickies.setNombre("\033[33mmoreStickies\033[0m");
		stickyArmTime = new Stat(4, 1, 10, "0.", " sec faster bomb arm time", 40, "0.", " sec slower bomb arm time");							stats.add(stickyArmTime);		stickyArmTime.setNombre("\033[33mstickyArmTime\033[0m");
		stickyChargTime = new Stat(70, 5, "Max charge time decreased by ", "%", 25, "Max charge time increased by ", "%", 30);					stats.add(stickyChargTime);		stickyChargTime.setNombre("\033[33mstickyChargTime\033[0m");
		StickyDmgCharge = new Stat(35, 5, "Up to +", "% damage based on charge", 30, "Up to -", "% damage based on charge", 35);				stats.add(StickyDmgCharge);		StickyDmgCharge.setNombre("\033[33mStickyDmgCharge\033[0m");
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
	
	/**************************************************************************************************
	 * 											   HEAVY											 *
	**************************************************************************************************/
	private void setTipoMinigun() {
		dmgReswhileSpun = new Stat(20, 5, "+","% damage resistance when below 50% health and spun up", 20, true);						stats.add(dmgReswhileSpun);		dmgReswhileSpun.setNombre("\033[36mdmgReswhileSpun\033[0m");
		spinUpTime = new Stat(20, 5, "", "% slower spin up time", 35, "", "% slower spin up time", 50);									stats.add(spinUpTime);			spinUpTime.setNombre("\033[33mspinUpTime\033[0m");
		spinDownTime = new Stat(30, 5, "", "% faster spin down time", 15, "", "% slower spin down time", 50);							stats.add(spinDownTime);		spinDownTime.setNombre("\033[33mspinDownTime\033[0m");
		moveSpeedSpun = new Stat(20, 5, "+", "% faster move speed while spun up", 25, "-", "% slower move speed while spun up", 60);	stats.add(moveSpeedSpun);		moveSpeedSpun.setNombre("\033[33mmoveSpeedSpun\033[0m");
		silentSpun = new Stat("Silent Killer: Silent spin sound", "Screaming Killer: Louder spin sound", 20);							stats.add(silentSpun);			silentSpun.setNombre("\033[33msilentSpun\033[0m");
	}
	
	private void setTipoShotgunHeavy() {
		shotgunKnockback = new Stat(30, 5, "+", "% knockback force", 20, true);																				stats.add(shotgunKnockback);	shotgunKnockback.setNombre("\033[36mshotgunKnockback\033[0m");
		dmgIfRecentSpun = new Stat(20, 5, "+", "% damage if minigun has recently been spun", 20, "-", "% damage if minigun has recently been spun", 20);	stats.add(dmgIfRecentSpun);		dmgIfRecentSpun.setNombre("\033[33mdmgIfRecentSpun\033[0m");
		knockbackResActive = new Stat(20, 5, "+", "% knockback resistance while active", 20, true);															stats.add(knockbackResActive);	knockbackResActive.setNombre("\033[36mknockbackResActive\033[0m");
	}
	
	/**************************************************************************************************
	 * 											 ENGINEER											 *
	**************************************************************************************************/
	private void setTipoShotgunEngineer() {
		shotgunDmgToSentryTarget = new Stat(25, 5, "", "% increased damage to your sentry's target", 30, "", "% decreased damage to your sentry's target", 25);						stats.add(shotgunDmgToSentryTarget);	shotgunDmgToSentryTarget.setNombre("\033[33mshotgunDmgToSentryTarget\033[0m");
		revengeCrits = new Stat("Gain 2 revenge crits for each sentry kill and\r\n1 for each sentry assist when your sentry is destroyed", 40, true);								stats.add(revengeCrits);				revengeCrits.setNombre("\033[36mrevengeCrits\033[0m");
		revengeMinicrits = new Stat("Gain 2 revenge mini-crits for each sentry kill and\r\n1 for each sentry assist when your sentry is destroyed", 15, true);						stats.add(revengeMinicrits);			revengeMinicrits.setNombre("\033[36mrevengeMinicrits\033[0m");
		shotgunMetalOnHit = new Stat(60, 5, "On Hit: Gain up to +", " metal per attack", 40, true);																					stats.add(shotgunMetalOnHit);			shotgunMetalOnHit.setNombre("\033[36mshotgunMetalOnHit\033[0m");
		shotgunMetalLossShooting = new Stat(40, 5, "Per Shot: Lose -", " metal", 35, false);																						stats.add(shotgunMetalLossShooting);	shotgunMetalLossShooting.setNombre("\033[91mshotgunMetalLossShooting\033[0m");
		shotgunSentryVuln = new Stat(30, 5, "+", "% damage resistance for your Sentry Gun while active", 35, "-", "% damage vulnerabilty for your Sentry Gun while active", 30);	stats.add(shotgunSentryVuln);			shotgunSentryVuln.setNombre("\033[33mshotgunSentryVuln\033[0m");
	}
	
	private void setTipoPistolEngineer() {
		pistolDmgToSentryTarget = new Stat(25, 5, "", "% increased damage to your sentry's target", 20, "", "% decreased damage to your sentry's target", 25);					stats.add(pistolDmgToSentryTarget);		pistolDmgToSentryTarget.setNombre("\033[33mpistolDmgToSentryTarget\033[0m");
		iconOverTarget = new Stat("Displays an icon over the current target of your Sentry Gun", 15, true);																		stats.add(iconOverTarget);				iconOverTarget.setNombre("\033[36miconOverTarget\033[0m");
		pistolMetalOnHit = new Stat(10, 1, "On Hit: Gain up to +", " metal per attack", 20, true);																				stats.add(pistolMetalOnHit);			pistolMetalOnHit.setNombre("\033[36mpistolMetalOnHit\033[0m");
		pistolMetalLossShooting = new Stat(5, 1, "Per Shot: Lose -", " metal", 25, false);																						stats.add(pistolMetalLossShooting);		pistolMetalLossShooting.setNombre("\033[91mpistolMetalLossShooting\033[0m");
		pistolSentryVuln = new Stat(25, 5, "+", "% damage resistance for your Sentry Gun while active", 30, "-", "% damage vulnerabilty for your Sentry Gun while active", 25);	stats.add(pistolSentryVuln);			pistolSentryVuln.setNombre("\033[33mpistolSentryVuln\033[0m");
	}
	
	/**************************************************************************************************
	 * 											   MEDIC											 *
	**************************************************************************************************/
	private void setTipoSyringeGun() {
		
	}
	
	private void setTipoMedigun() {
		healRate = new Stat(40, 5, "+", "% heal rate", 30, "-", "% heal rate", 10);							stats.add(healRate);			healRate.setNombre("\033[33mhealRate\033[0m");
		uberRate = new Stat(65, 5, "+", "% Übercharge rate", 30, "-", "% Übercharge rate", 20);				stats.add(uberRate);			uberRate.setNombre("\033[33muberRate\033[0m");
		overhealRate = new Stat(25, 5, "+", "% Overheal rate", 25, "-", "% Overheal rate", 65);				stats.add(overhealRate);		overhealRate.setNombre("\033[33moverhealRate\033[0m");
		overhealMax = new Stat("+", "% max Overheal", 25, "", "% max Overheal", 100);						stats.add(overhealMax);			overhealMax.setNombre("\033[33moverhealMax\033[0m");
		//mimicsRJ = new Stat("Mirror the blast jumps and shield charges of patients.", 30, true);			stats.add(mimicsRJ);			mimicsRJ.setNombre("\033[36mmimicsRJ\033[0m");
		buffsOnClass = new Stat("Gains small buffs depending on what class you are healing", 30, true);		stats.add(buffsOnClass);		buffsOnClass.setNombre("\033[36mbuffsOnClass\033[0m");
		healBuildings = new Stat("Able to slowly heal friendly buildings", 40, true);						stats.add(healBuildings);		healBuildings.setNombre("\033[36mhealBuildings\033[0m");
		drainsHealth = new Stat("Able to drain health from enemies", 45, true);								stats.add(drainsHealth);		drainsHealth.setNombre("\033[36mdrainsHealth\033[0m");
		
		deploySpeed = new Stat(75, 5, "This weapon deploys ", "% faster", 25, "This weapon deploys ", "% slower", 75);					stats.add(deploySpeed);			deploySpeed.setNombre("\033[33mdeploySpeed\033[0m");
		holsterSpeed = new Stat(30, 5, "This weapon holsters ", "% faster", 20, "This weapon holsters ", "% slower", 75);				stats.add(holsterSpeed);		holsterSpeed.setNombre("\033[33mholsterSpeed\033[0m");
		speedActive = new Stat(10, 5, "+", "% faster moving speed while active", 45, "-", "% slower moving speed while active",10);		stats.add(speedActive);			speedActive.setNombre("\033[33mspeedActive\033[0m");
		jumpActive = new Stat(25, 5, "+", "% greater jump height when active", 15, "-", "% jump height while active",25);				stats.add(jumpActive);			jumpActive.setNombre("\033[33mjumpActive\033[0m");
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
		debuffOnCharge = new Stat(6, 2);																									stats.add(debuffOnCharge);		debuffOnCharge.setNombre("\033[36mdebuffOnCharge\033[0m");
		dmgOnBodyS = new Stat(25,5, "-", "% damage on body shot", 25, false);																stats.add(dmgOnBodyS);			dmgOnBodyS.setNombre("\033[91mdmgOnBodyS\033[0m");
	}
	
	private void relacionadasSniperRifle() {
		hsonlyFull.setLista(Arrays.asList(hsonlyFull2));
		hsonlyFull2.setLista(Arrays.asList(hsonlyFull));
	}
	
	/**************************************************************************************************
	 * 											     SPY											 *
	**************************************************************************************************/
	private void setTipoRevolver() {
		canHeadshot = new Stat("Crits on headshot", 50, true);																								stats.add(canHeadshot);			canHeadshot.setNombre("\033[36mcanHeadshot\033[0m");
		cloakHit = new Stat(20, 5, "+", "% cloak on hit", 20, true);																						stats.add(cloakHit);			cloakHit.setNombre("\033[36mcloakHit\033[0m");
		cloakDuration = new Stat(50, 5, "+", "% cloak duration", 35, "-", "% cloack duration", 15);															stats.add(cloakDuration);		cloakDuration.setNombre("\033[33mcloakDuration\033[0m");
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
		debuffHeadshot = new Stat(6, 1, 00000);																												stats.add(debuffHeadshot);		debuffHeadshot.setNombre("\033[36mdebuffHeadshot\033[0m");
		dmgOnSappedBuildings = new Stat(20, 5, "+", "% damage bonus on sapped buildings", 30, "-", "% damage penalty on sapped buildings", 20);				stats.add(dmgOnSappedBuildings);dmgOnSappedBuildings.setNombre("\033[33mdmgOnSappedBuildings\033[0m");
	}
	
	private void relacionadasRevolver() {
		canHeadshot.setLista(Arrays.asList(debuffHeadshot));
		debuffHeadshot.setLista(Arrays.asList(canHeadshot));
		dmgWhileDisg.setLista(Arrays.asList(dmgNoDisg));
		dmgNoDisg.setLista(Arrays.asList(dmgWhileDisg));
		critsStabSap.setLista(Arrays.asList(critsStab, critsSap, minicritsStabSap, minicritsStab, minicritsSap));
		critsStab.setLista(Arrays.asList(critsStabSap, critsSap, minicritsStabSap, minicritsStab));
		critsSap.setLista(Arrays.asList(critsStabSap, critsStab, minicritsStabSap, minicritsSap));
		minicritsStabSap.setLista(Arrays.asList(critsStab, critsSap, critsStabSap, minicritsStab, minicritsSap));
		minicritsStab.setLista(Arrays.asList(minicritsStabSap, minicritsSap, critsStab, critsStabSap));
		minicritsSap.setLista(Arrays.asList(minicritsStabSap, critsSap, minicritsStab, critsStabSap));
	}
	
	private void setTipoSapper() {
		// Stat sapperHP, sapperDmg, sapperExplodes, doesntDeactBuild, drainsAmmoBuild, drainsBuildRate, vulnOnSappedBuilds, sapperAppliedBuff, SapperDestroyedBuff, sapperCompletedBuff;
		sapperHP = new Stat(35,35, "+", " max Sapper health", 40, "-", " max Sapper health", 35);															stats.add(sapperHP);			sapperHP.setNombre("\033[33msapperHP\033[0m");
		sapperDmg = new Stat(40, 10, "+", "% Sapper damage bonus", 60, "-", "% Sapper damage penalty", 100);												stats.add(sapperDmg);			sapperDmg.setNombre("\033[33msapperDmg\033[0m");
		sapperExplodes = new Stat("Sapper explodes if it destroys the building", 30, true);																	stats.add(sapperExplodes);		sapperExplodes.setNombre("\033[36msapperExplodes\033[0m");
		doesntDeactBuild = new Stat("Doesn't deactivate buildings while sapping", 35, false);																stats.add(doesntDeactBuild);	doesntDeactBuild.setNombre("\033[91mdoesntDeactBuild\033[0m");
		drainsAmmoBuild = new Stat("Drains ammo from Sentry Guns and metal from Dispensers", 10, true);														stats.add(drainsAmmoBuild);		drainsAmmoBuild.setNombre("\033[36mdrainsAmmoBuild\033[0m");
		drainsBuildRate = new Stat("Drains upgrade progress from buildings that are not completly upgraded", 5, true);										stats.add(drainsBuildRate);		drainsBuildRate.setNombre("\033[36mdrainsBuildRate\033[0m");
		vulnOnSappedBuilds = new Stat(25, 5, "-", "% damage vulnerability on sapped buildings", 30, "+", "% damage resistance on sapped buildings", 25);	stats.add(vulnOnSappedBuilds);	vulnOnSappedBuilds.setNombre("\033[33mvulnOnSappedBuilds\033[0m");
		//sapperAppliedBuff = new Stat();
		//SapperDestroyedBuff = new Stat();
		//sapperCompletedBuff = new Stat();
		
		deploySpeed = new Stat(75, 5, "This weapon deploys ", "% faster", 25, "This weapon deploys ", "% slower", 75);					stats.add(deploySpeed);			deploySpeed.setNombre("\033[33mdeploySpeed\033[0m");
		holsterSpeed = new Stat(30, 5, "This weapon holsters ", "% faster", 20, "This weapon holsters ", "% slower", 75);				stats.add(holsterSpeed);		holsterSpeed.setNombre("\033[33mholsterSpeed\033[0m");
		speedActive = new Stat(10, 5, "+", "% faster moving speed while active", 45, "-", "% slower moving speed while active",10);		stats.add(speedActive);			speedActive.setNombre("\033[33mspeedActive\033[0m");
		jumpActive = new Stat(25, 5, "+", "% greater jump height when active", 15, "-", "% jump height while active",25);				stats.add(jumpActive);			jumpActive.setNombre("\033[33mjumpActive\033[0m");
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
		
		// Generar los stats positivos
		/*
		if(maxStatsPositivos != 0) {
			for(i = 0; i < maxStatsPositivos; i++) {
				getStatPositivo();
			}
		} else {
			Random rand = new Random();
			maxStatsPositivos = rand.nextInt(5)+1;
			for(i = 0; i < maxStatsPositivos; i++) {
				getStatPositivo();
			}
		}
		*/
		if(maxStatsPositivos == 0) {
			while(positivos.size() < 5 && puntuacionPositiva < maxPuntuacionPositivos) {
				int cabe = 2; 
				Random rand = new Random();
				int r = rand.nextInt(statsPositivosDisponibles);
				int aux = r;
				int cont = 0;
				Stat statAux;
				int indexOfMin = aux;
				
				// Si la puntuación ya superó el promedio, puede seguir o no de manera aleatoria
				if(puntuacionPositiva >= (maxPuntuacionPositivos+minPuntuacionPositivos)/2) {
					Random rand2 = new Random();
					int r2;
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
				
				// Analiza todos los stats y si cabe dentro de la puntuación
				do {
					statAux = stats.get(aux);
					System.out.print("\n Analizando: "+statAux.getNombre()+"\tmin = "+statAux.getPuntajeMenor(true)+"\tmax = "+ statAux.getPeso()+"\tpun = "+puntuacionPositiva);
					if(statAux.getPuntajeMenor(true) < stats.get(indexOfMin).getPuntajeMenor(true)) {
						indexOfMin = aux;
					}
					if(	(positivos.size() == 4 && statAux.getPeso() < ((minPuntuacionPositivos - puntuacionPositiva)/(5-positivos.size()) - 10))
						|| statAux.getPuntajeMenor(true) > (maxPuntuacionPositivos - puntuacionPositiva)) {
						aux++;
					} else {
						break;
					}
					if(stats.size() == aux || stats.get(aux).getType() == 3) {
						aux = 0;
					}
				} while(aux != r);
				if(puntuacionPositiva+stats.get(indexOfMin).getPuntajeMenor(true) > maxPuntuacionPositivos) {
					break;
					//statAux = stats.get(indexOfMin);
				}
				if(	statAux.getPeso() < ((minPuntuacionPositivos - puntuacionPositiva)/(5-positivos.size()) - 10) ) {
					cabe = 1;
				} else if(statAux.getPuntajeMenor(true) > (maxPuntuacionPositivos - puntuacionPositiva)) {
					cabe = 3;
				}
				if(cabe == 1) {
					do {
						statAux.setPositivo();
					} while(statAux.getPuntaje() != statAux.getPeso());
				} else if(cabe == 3) {
					do {
						statAux.setPositivo();
					} while(statAux.getPuntaje() != statAux.getPuntajeMenor(true));
				} else {
					do {
						statAux.setPositivo();
						cont++;
						if(cont == 60) {
							break;
						}
						System.out.print("\n Puntaje = "+statAux.getPuntaje());
					} while((positivos.size() == 4 && statAux.getPeso() < ((minPuntuacionPositivos - puntuacionPositiva)/(5-positivos.size()) - 10))
							|| statAux.getPuntaje() > (maxPuntuacionPositivos - puntuacionPositiva));
				}
				System.out.print("\n\n   "+statAux.getTexto()+"\n");
				positivos.add(statAux);
				puntuacionPositiva += statAux.getPuntaje();
				eliminarStats(statAux);
			}
		} else {
			Random rand = new Random();
			maxStatsPositivos = rand.nextInt(5)+1;
			for(i = 0; i < maxStatsPositivos; i++) {
				getStatPositivo();
			}
		}
		
		// Generar los stats negativos
		i = 0;
		while(i < maxStatsNegativos && puntuacionNegativa < (puntuacionPositiva - lim)) {
			getStatNegativo();
			i++;
		}
		
		System.out.print("\n "+puntuacionPositiva+" - "+puntuacionNegativa+" = "+(puntuacionPositiva - puntuacionNegativa)+" < "+((lim+5)/2));
		if(puntuacionPositiva - puntuacionNegativa < (lim+5)/2 && !negativos.isEmpty()) {
			negativos.remove(negativos.size()-1);
		}
		
		
		System.out.print("\n ");
		for(Stat s: stats) {
			System.out.print("\n "+ s.getNombre());
		}
		System.out.print("\n ");
		
		for(Stat s : positivos) {
			System.out.print("\n \033[36m" + s.getTexto() + "\033[0m");
		}
		for(Stat s : negativos) {
			System.out.print("\n \033[91m" + s.getTexto() + "\033[0m");
		}
		
		System.out.print("\n\n PUNTUACIÓN POSITIVA: "+ puntuacionPositiva);
		System.out.print("\n PUNTUACIÓN NEGATIVA: "+ puntuacionNegativa);
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

}