package def;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Weapon {
	
	// enum Clases/*
	/*
	private enum Clase {
		SCOUT(1),
		SOLDIER(2),
		PYRO(3),
		DEMOMAN(4),
		HEAVY(5),
		ENGINEER(6),
		MEDIC(7),
		SNIPER(8),
		SPY(9);
		
		private int num;
		
		Clase(int n){
			this.num = n;
		}
		
		public int getNum( ) {
			return num;
		}
		
		public static Clase obtenerClase(int n) {
			for(Clase cl : values()) {
				if(cl.getNum() == n) {
					return cl;
				}
			}
			throw new IllegalArgumentException("n inválido");
		}
	}
	
	// Clase seleccionada
	private Clase clase;*/
	private int clase;
	
	private int clipsize;
	private boolean isPrimary = false;
	
	// Lista de stats posibles
	ArrayList<Stat> stats = new ArrayList<>();
	
	// Cantidad de stats de cada tipo
	int statsPositivosDisponibles = 0;
	int statsNegativosDisponibles = 0;
	
	// Listas de stats seleccionados
	ArrayList<Stat> positivos = new ArrayList<>();
	ArrayList<Stat> negativos = new ArrayList<>();
	ArrayList<Stat> neutrales = new ArrayList<>();
	
	// Puntajes
	private float puntuacionPositiva = 0;
	private float puntuacionNegativa = 0;
	private float puntuacionBanner = 0;
	
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
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Flame Thrower */		Stat flameRange, afterburnDmg, airblastCost, airblastPush, airblastSpeed, noAirblast, flameSpeed;
	/* Shotgun */			Stat fireBullets, minicritsOnFire, minicritsAirblast;
	
	public Weapon(String c, String t) {
		
		switch(c) {
		case "Scout":
			clase = 1;
			break;
		case "Soldier":
			clase = 2;
			break;
		case "Pyro":
			clase = 3;
			break;
		case "Demoman":
			clase = 4;
			break;
		case "Heavy":
			clase = 5;
			break;
		case "Engineer":
			clase = 6;
			break;
		case "Medic":
			clase = 7;
			break;
		case "Sniper":
			clase = 8;
			break;
		case "Spy":
			clase = 9;
			break;
		}
		
		definir(t);
	}
	
	void definir(String t) {
		switch(t)
		{/*
			case "scattergun":
				setTipoArma();
				SetType_Bullets();
				SetType_Shotgun();
				SetClipSize(6);
				IsPrimary = true;
				break;
				
			case "pistol":
				setTipoArma();
				SetType_Bullets();
				SetClipSize(12);
				break;
				
			case "bat":
				setTipoArma();
				SetType_Melee();
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
				/*
			case "shotgun":
				setTipoArma();
				SetType_Bullets();
				SetType_Shotgun();
				SetClipSize(6);
				switch(clase){
					case "Soldier":
						SetType_ShotgunSoldier();
						break;
					case "Pyro":
						SetType_ShotgunPyro();
						break;
					case "Heavy":
						SetType_ShotgunHeavy();
						break;
					case "Engineer":
						SetType_ShotgunEngineer();
						break;}
				break;
				
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
				break;
				
			case "grenade launcher":
				setTipoArma();
				SetType_Projectile();
				setTipoExplosion();
				SetClipSize(4);
				SetType_GrenadeLauncher();
				IsPrimary = true;
				break;
				
			case "stickybomb launcher":
				setTipoArma();
				SetType_Projectile();
				setTipoExplosion();
				SetClipSize(8);
				SetType_StickybombLauncher();
				break;
				
			case "bottle":
				setTipoArma();
				SetType_Melee();
				break;
				
			case "sword":
				setTipoArma();
				DeleteStatPositive("clip");
				DeleteStatNegative("clip");
				DeleteStatPositive("fastreload");
				DeleteStatNegative("fastreload");
				DeleteStatPositive("deploy");
				DeleteStatNegative("deploy");
				DeleteStatPositive("holster");
				DeleteStatNegative("holster");
				DeleteStatPositive("hithp");
				DeleteStatPositive("noammoneed");
				DeleteStatNegative("randomcrits");
				SetType_Melee();
				SetType_Sword();
				IsMelee = true;
				break;
				
			case "minigun":
				setTipoArma();
				SetType_Bullets();
				DeleteStatPositive("clip");
				DeleteStatNegative("clip");
				DeleteStatPositive("fastreload");
				DeleteStatNegative("fastreload");
				DeleteStatPositive("hithp");
				SetType_Minigun();
				break;
				
			case "fists":
				setTipoArma();
				SetType_Melee();
				break;
				
			case "syringe gun":
				setTipoArma();
				SetClipSize(40);
				SetType_SyringeGun();
				IsPrimary = true;
				break;
				
			case "medigun":
				SetType_Medigun();
				break;
				
			case "bonesaw":
				setTipoArma();
				SetType_Melee();
				break;
				
			case "smg":
				setTipoArma();
				SetType_Bullets();
				SetClipSize(25);
				SetType_SMG();
				break;
				
			case "kukri":
				setTipoArma();
				SetType_Melee();
				break;
				
			case "revolver":
				setTipoArma();
				SetType_Bullets();
				SetClipSize(6);
				SetType_Revolver();
				IsPrimary = true;
				break;*/
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
		/*
		if(isPrimary) {
			noAmmoNeed.setLista(Arrays.asList(maxPrimaryAmmo, noAmmoDispensers, airblastCost));
		} else {
			noAmmoNeed.setLista(Arrays.asList(maxSecondaryAmmo, noAmmoDispensers, airblastCost));
		}
		*/
		noAmmoDispensers.setLista(Arrays.asList(noAmmoNeed));
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
	
	private void setTipoRocketLauncher() {
		rocketSelfDamage = new Stat(25, 5, "-", "% blast damage from rocket jumps", 20, "+", "% blast damage from rocket jumps", 25);						stats.add(rocketSelfDamage);		rocketSelfDamage.setNombre("\033[33mrocketSelfDamage\033[0m");
		RocketDamageWhileRJ = new Stat(20, 5, "+", "% damage bonus while rocket jumping", 35, "-", "% damage penalty while rocket jumping", 20);			stats.add(RocketDamageWhileRJ);		RocketDamageWhileRJ.setNombre("\033[33mRocketDamageWhileRJ\033[0m");
		firingSpeedWhileRJ = new Stat(30, 5, "+", "% firing speed while rocket jumping", 30, "-", "% firing speed while rocket jumping", 30);				stats.add(firingSpeedWhileRJ);		firingSpeedWhileRJ.setNombre("\033[33mfiringSpeedWhileRJ\033[0m");
		projectileSpeedWhileRJ = new Stat(30, 5, "+", "% projectile speed while rocket jumping", 35, "-", "% projectile speed while rocket jumping", 30);	stats.add(projectileSpeedWhileRJ);	projectileSpeedWhileRJ.setNombre("\033[33mprojectileSpeedWhileRJ\033[0m");
		radiusWhileRJ = new Stat(20, 5, "+", "% explosion radius while rocket jumping", 30, "-", "% explosion radius while rocket jumping", 20);			stats.add(radiusWhileRJ);			radiusWhileRJ.setNombre("\033[33mradiusWhileRJ\033[0m");
	}
	
	private void setTipoFlameThrower() {
		flameRange = new Stat(10, 5, "+", "% flame thrower range", 35, "-", "% flame thrower range", 10);									stats.add(flameRange);		flameRange.setNombre("flameRange");
		afterburnDmg = new Stat(100, 25, "+", "% afterburn damage bonus", 25, "-", "% afterburn damage penalty", 75);						stats.add(afterburnDmg);	afterburnDmg.setNombre("afterburnDmg");
		airblastCost = new Stat(50, 25, "-", "% airblast cost", 30, "+", "% airblast cost", 150);											stats.add(airblastCost);	airblastCost.setNombre("airblastCost");
		airblastPush = new Stat(20, 5, "+", "% airblast push force", 20, "-", "% airblast push force", 20);									stats.add(airblastPush);	airblastPush.setNombre("airblastPush");
		airblastSpeed = new Stat(50, 25, "+", "% repressurization rate on Alt-Fire", 40, "-", "% repressurization rate on Alt-Fire", 50);	stats.add(airblastSpeed);	airblastSpeed.setNombre("airblastSpeed");
		noAirblast = new Stat("No airblast", 50, false);																					stats.add(noAirblast);		noAirblast.setNombre("noAirblast");
		flameSpeed = new Stat(50, 10, "+", "% flame travel speed", 35, "-", "% flame travel speed", 30);									stats.add(flameSpeed);		flameSpeed.setNombre("flameSpeed");
	}
	
	private void relacionadasFlameThrower() {
		airblastCost.setLista(Arrays.asList(noAirblast, noAmmoNeed));
		airblastPush.setLista(Arrays.asList(noAirblast));
		airblastSpeed.setLista(Arrays.asList(noAirblast));
		noAirblast.setLista(Arrays.asList(airblastSpeed, airblastPush, airblastCost));
	}
	
	public void generarArma() {
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
		for(int i = 0; i < 3; i++) {
			getStatPositivo();
		}
	}
	
	public void getStatPositivo() {
		
		Random rand = new Random();
		int r = rand.nextInt(statsPositivosDisponibles);
		Stat statAux = stats.get(r);
		statAux.setPositivo();
		System.out.print("\n\n   "+statAux.getTexto()+"\n");
		positivos.add(statAux);
		eliminarStats(statAux);
		
		for(Stat s: stats) {
			System.out.print("\n "+ s.getNombre());
		}
		System.out.print("\n\n POSITIVOS: "+ statsPositivosDisponibles);
		System.out.print("\n NEGATIVOS: "+ statsNegativosDisponibles);
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