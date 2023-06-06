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
	
	// Lista de stats posibles
	private ArrayList<Stat> stats = new ArrayList<>();
	
	// Cantidad de stats de cada tipo
	private int statsPositivosDisponibles = 0;
	private int statsNegativosDisponibles = 0;
	
	// Listas de stats seleccionados
	private ArrayList<Stat> positivos = new ArrayList<>();
	private ArrayList<Stat> negativos = new ArrayList<>();
	private ArrayList<Stat> neutrales = new ArrayList<>();
	
	// Puntajes
	private float puntuacionPositiva = 0;
	private float puntuacionNegativa = 0;
	private float puntuacionBanner = 0;
	
	private int primaryAmmo;
	private int secondaryAmmo;
	
	/* GENERIC */			Stat maxPrimaryAmmo, maxSecondaryAmmo;
	/* PASSIVE */			Stat maxHp, passiveFireResistance, passiveExpResistance, passiveBulletResistance, passiveHpRegen, passiveSpeed, passiveKb, passiveFallDmg, passiveNoFall;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* ARMA ataque */		Stat damage, damagePlayers, damageBuildings, clipSize, firingSpeed, hpOnHit;
	/* ARMA velocidad */	Stat deploySpeed, holsterSpeed, reloadSpeed;
	/* ARMA utilidad */		Stat speedActive, jumpActive;
	/* ARMA extra */		Stat noAmmoNeed, noAmmoDispensers;
	/* ARMA buffs */		Stat minicritsExplosion, minicritsWhenCrit, noRandomCrits;
	
	/* BULLETS */			Stat accuracy, minicritsFromBack;
	/* SHOTGUN */			Stat morePellets, fixedPattern;
	/* PROJECTILE */		Stat projectileSpeed, projectileSpread;
	/* EXPLOSION */			Stat explosionRadius, destroysStickies, fireExplosion;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Rocket Launcher */	Stat rocketSelfDamage, RocketDamageWhileRJ, firingSpeedWhileRJ, projectileSpeedWhileRJ, radiusWhileRJ;
	/* Shotgun */			Stat explosiveBullets, ShotgunDmgWhileRJ;
	/* Boots */
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Flame Thrower */		Stat flameRange, afterburnDmg, airblastCost, airblastPush, airblastSpeed, noAirblast, flameSpeed;
	/* Shotgun */			Stat fireBullets, minicritsOnFire, minicritsAirblast, damageWhileExpJump;
	/* Flare Gun */
	/* Fireaxe */
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Grenade Launcher */		Stat pipeSelfDamage, fuseTime, bombsRollLess, bombsShatter;
	/* Stickybomb Launcher */	Stat stickySelfDamage, moreStickies, stickyArmTime, stickyChargTime, StickyDmgCharge;
	/* Sword */
	/* Bottle */
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Minigun */			
	/* Shotgun */
	
	public Weapon(String c, String t) {
		
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
				setTipoArma();
				setTipoBalas();
				setTipoEscopeta();
				isPrimary = true;
				
				relacionadasArma();
				relacionadasBalas();
				relacionadasEscopeta();
				break;
				/*
			case "pistol":
				setTipoArma();
				setTipoBalas();
				SetClipSize(12);
				
				relacionadasArma();
				break;
				
			case "bat":
				setTipoArma();
				SetType_Melee();
				
				relacionadasArma();
				break;
				*/
			case "Rocket Launcher":
				clipsize = 4;
				setTipoArma();
				setTipoProyectil();
				setTipoExplosion();
				setTipoRocketLauncher();
				isPrimary = true;
				
				relacionadasArma();
				break;
				
			case "Shotgun":
				clipsize = 6;
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
						//SetType_ShotgunHeavy();
						break;
					case 6:
						//SetType_ShotgunEngineer();
						break;
				}

				relacionadasArma();
				relacionadasBalas();
				relacionadasEscopeta();
				break;
				/*
			case "banner":
				SetType_Passive();
				DeleteStatPositive("maxsecondaryammo");
				DeleteStatNegative("maxsecondaryammo");
				Set_BannerBuffs();
				IsWeapon = false;
				break;
				
			case "shovel":
				setTipoArma();
				SetType_Melee();
				
				relacionadasArma();
				break;
				*/
				
			case "Flame Thrower":
				setTipoArma();
				setTipoFlameThrower();
				stats.remove(stats.indexOf(firingSpeed));
				stats.remove(stats.indexOf(clipSize));
				stats.remove(stats.indexOf(reloadSpeed));
				stats.remove(stats.indexOf(hpOnHit));
				isPrimary = true;
				
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
				setTipoArma();
				setTipoProyectil();
				setTipoExplosion();
				setTipoGrenadeLauncher();
				isPrimary = true;
				
				relacionadasArma();
				relacionadasGrenadeLauncher();
				break;
				
			case "Stickybomb Launcher":
				clipsize = 8;
				setTipoArma();
				setTipoProyectil();
				setTipoExplosion();
				setTipoStickybombLauncher();
				
				relacionadasArma();
				break;
				/*
			case "bottle":
				setTipoArma();
				SetType_Melee();
				
				relacionadasArma();
				break;
				
			case "sword":
				setTipoArma();
				stats.remove(stats.indexOf(clipSize));
				stats.remove(stats.indexOf(reloadSpeed));
				DeleteStatPositive("deploy");
				DeleteStatNegative("deploy");
				DeleteStatPositive("holster");
				DeleteStatNegative("holster");
				stats.remove(stats.indexOf(hpOnHit));
				DeleteStatPositive("noammoneed");
				DeleteStatNegative("randomcrits");
				SetType_Melee();
				SetType_Sword();
				IsMelee = true;
				
				relacionadasArma();
				break;
				
			case "minigun":
				setTipoArma();
				setTipoBalas();
				DeleteStatPositive("clip");
				DeleteStatNegative("clip");
				DeleteStatPositive("fastreload");
				DeleteStatNegative("fastreload");
				DeleteStatPositive("hithp");
				SetType_Minigun();
				
				relacionadasArma();
				break;
				
			case "fists":
				setTipoArma();
				SetType_Melee();
				
				relacionadasArma();
				break;
				
			case "syringe gun":
				setTipoArma();
				SetClipSize(40);
				SetType_SyringeGun();
				IsPrimary = true;
				
				relacionadasArma();
				break;
				
			case "medigun":
				SetType_Medigun();
				break;
				
			case "bonesaw":
				setTipoArma();
				SetType_Melee();
				
				relacionadasArma();
				break;
				
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
				
			case "revolver":
				setTipoArma();
				setTipoBalas();
				SetClipSize(6);
				SetType_Revolver();
				IsPrimary = true;
				
				relacionadasArma();
				break;*/
		}
		relacionadasGenerico();
	}
	
	private void setTipoGenerico() {
		maxPrimaryAmmo = new Stat("+", "% max primary ammo on wearer", 20, "-", "% max primary ammo on wearer", primaryAmmo);			stats.add(maxPrimaryAmmo);		maxPrimaryAmmo.setNombre("\033[33mmaxPrimaryAmmo\033[0m");
		maxSecondaryAmmo = new Stat("+", "% max secondary ammo on wearer", 20, "-", "% max secondary ammo on wearer", secondaryAmmo);	stats.add(maxSecondaryAmmo);	maxSecondaryAmmo.setNombre("\033[33mmaxSecondaryAmmo\033[0m");
	}
	
	private void relacionadasGenerico() {
		if(isPrimary) {
			maxPrimaryAmmo.setLista(Arrays.asList(noAmmoNeed));
		} else {
			maxSecondaryAmmo.setLista(Arrays.asList(noAmmoNeed));
		}
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
	}
	
	private void setTipoBalas() {
		accuracy = new Stat(25, 5, "+", "% more accurate", 35, "-", "% less accurate", 20);							stats.add(accuracy);			accuracy.setNombre("\033[33maccuracy\033[0m");
		minicritsFromBack = new Stat("Mini-crits targets when fired at their back from close range", 20, true);		stats.add(minicritsFromBack);	minicritsFromBack.setNombre("\033[36mminicritsFromBack\033[0m");
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
	}
	
	private void setTipoExplosion() {
		explosionRadius = new Stat(25, 5, "+", "% explosion radius", 50, "-", "% explosion radius", 70);	stats.add(explosionRadius);		explosionRadius.setNombre("\033[33mexplosionRadius\033[0m");
		destroysStickies = new Stat("Able to destroy enemy stickybombs", 25, true);							stats.add(destroysStickies);	destroysStickies.setNombre("\033[36mdestroysStickies\033[0m");
		fireExplosion = new Stat("Explosions ignite enemies for up to 2 seconds", 30, true);				stats.add(fireExplosion);		fireExplosion.setNombre("\033[36mfireExplosion\033[0m");
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
		// fireBullets, minicritsOnFire, minicritsAirblast, damageWhileExpJump;
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
		bombsShatter = new Stat("Launched bombs shatter on surfaces", 20, false);								stats.add(bombsShatter);		fuseTime.setNombre("\033[91mbombsShatter\033[0m");
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
	
	/**************************************************************************************************
	 * 											   HEAVY											 *
	**************************************************************************************************/
	private void setTipoMinigun() {
		
	}
	
	public void generarArma() {
		
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
		for(int i = 0; i < 3; i++) {
			getStatPositivo();
		}
		
		// Generar los stats positivos
		for(int i = 0; i < 3; i++) {
			getStatNegativo();
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
		//Stat statAux = stats.get(stats.indexOf(maxPrimaryAmmo));
		statAux.setNegativo();
		System.out.print("\n\n   "+statAux.getTexto()+"\n");
		negativos.add(statAux);
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