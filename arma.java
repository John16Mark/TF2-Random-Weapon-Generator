package def;
import java.util.*;

public class arma {
	
	private String tipo;
	private String clase;
	private String texto = "";
	private String statsmodificados = "";
	private Random rand;
	private int random, random2, random3, numeropositivos, i;
	private float puntuacionpositiva = 0;
	private float puntuacionnegativa = 0;
	private float puntuacionbanner = 0;
	private boolean primary = false;
	private boolean esarma = true;
	List<String> statpos = new ArrayList<String>();
	List<String> statneg = new ArrayList<String>();
	List<Integer> numeropos = new ArrayList<Integer>();
	List<Integer> numeroneg = new ArrayList<Integer>();
	
	public arma(String t, String c)
	{
		tipo = t;
		clase = c;
		
		generico();
		definir(tipo);
		
	}
	
	public float getpuntuacionpositiva()
	{
		return puntuacionpositiva;
	}
	
	public float getpuntuacionnegativa()
	{
		return puntuacionnegativa;
	}
	
	public String regresarpositivos()
	{
		rand = new Random();
		if (esarma == true)
		{
			random = rand.nextInt(20);
			if(random <= 3){
				numeropositivos = 1;}
			else if(random >= 4 && random <=10){
				numeropositivos = 2;}
			else if(random >= 11 && random <=16){
				numeropositivos = 3;}
			else if(random >= 17 && random <=18){
				numeropositivos = 4;}
			else if(random == 19){
				numeropositivos = 5;}
		}
		else
		{
			random = rand.nextInt(7);
			if (random <= 1){
				numeropositivos = 0;}
			else if(random >=2 && random <=5){
				numeropositivos = 1;}
			else if(random == 6){
				numeropositivos = 2;}
		}
		
		//numeropositivos = 1;
		statsmodificados = "<html><font color=rgb(153,204,255); size=3><center><p style=margin-bottom:3.5>";
		
		for(i=0; i<numeropositivos; i++){
			statsmodificados += getstatpositivo()+"</p></center>";
			if(i<numeropositivos-1)
			{
				statsmodificados += "<center><p style=margin-bottom:3.5>";
			}
		}
		
		if(tipo == "flame thrower")
		{
			statsmodificados += "<center><p style=margin-bottom:3.5>Extinguishing teammates restores 20 health</p></center>";
		}
		
		statsmodificados += "<center><p style=margin-bottom:3.5> P POSITIVA="+Float.toString(getpuntuacionpositiva())+"</p></center>";
		
		int intentos = 0;
		int maximonegativos = 5;
		int minimonegativos = 1;
		if (esarma == false)
		{
			maximonegativos = 2;
			minimonegativos = 0;
		}
		
		//OBTENER STATS NEGATIVOS
		
		statsmodificados += "<font color=rgb(255,64,64)><center><p style=margin-bottom:3.5>";
		while ((intentos < minimonegativos ||puntuacionnegativa<puntuacionpositiva-16) && intentos < maximonegativos)
		{
			statsmodificados += getstatnegativo()+"</p></center>";
			intentos++;
			if((intentos < minimonegativos ||puntuacionnegativa<puntuacionpositiva-16) && intentos < maximonegativos)
			{
				statsmodificados += "<center><p style=margin-bottom:3.5>";
			}
		}
		
		statsmodificados += "<center><p style=margin-bottom:3.5> P NEGATIVA="+Float.toString(getpuntuacionnegativa())+"</p></center>";
		
		if (tipo == "banner")
		{
			statsmodificados += "<font color=rgb(250,250,250)><center><p style=margin-bottom:3.5>";
			statsmodificados += "Rage increases through damage done.";
			statsmodificados += "</p></center>";
		}
		
		
		//OBTENER TODOS LOS STATS POSITIVOS
		/*
		for(i=0; i<statpos.size(); i++){
			statsmodificados += "· "+statpos.get(i)+"   ";}*/
		
		statsmodificados += "</font></html>";
		return statsmodificados;
	}
	
	private void escopeta()
	{
		statpos.add("morepellets");
		numeropos.add(50);
		statneg.add("morepellets");
		numeroneg.add(60);
		
		statpos.add("fixedpattern");
		numeropos.add(0);
	}
	
	private void projectile()
	{
		statpos.add("projspeed");
		numeropos.add(80);
		statneg.add("projspeed");
		numeroneg.add(20);
		
		statneg.add("projspread");
		numeroneg.add(3);
	}
	
	private void explosion()
	{
		statpos.add("radius");
		numeropos.add(25);
		statneg.add("radius");
		numeroneg.add(70);
		
		statpos.add("destroysstickies");
		numeropos.add(0);
	}
	
	private void balas()
	{
		statpos.add("accuracy");
		numeropos.add(25);
		statneg.add("accuracy");
		numeroneg.add(20);
		
		statpos.add("minicritsatback");
		numeropos.add(0);
	}
	
	private void generico()
	{
		statpos.add("maxprimaryammo");
		numeropos.add(32);
		statneg.add("maxprimaryammo");
		numeroneg.add(32);
		
		statpos.add("maxsecondaryammo");
		numeropos.add(32);
		statneg.add("maxsecondaryammo");
		numeroneg.add(32);
	}
	
	//STATS PASIVOS
	private void pasivo()
	{
		statpos.add("maxhp");
		numeropos.add(25);
		statneg.add("maxhp");
		numeroneg.add(25);
		
		statpos.add("pasivefireresistance");
		numeropos.add(50);
		statneg.add("pasivefireresistance");
		numeroneg.add(25);
		
		statpos.add("pasiveexpresistance");
		numeropos.add(30);
		statneg.add("pasiveexpresistance");
		numeroneg.add(25);
		
		statpos.add("pasivebulletresistance");
		numeropos.add(20);
		statneg.add("pasivebulletresistance");
		numeroneg.add(20);
		
		statpos.add("pasivehealthregen");
		numeropos.add(20);
		
		statpos.add("pasivespeed");
		numeropos.add(10);
		statneg.add("pasivespeed");
		numeroneg.add(10);
		
	}

	//STATS DE ARMAS
	private void weapon()
	{
		statpos.add("damage");
		numeropos.add(40);
		statneg.add("damage");
		numeroneg.add(40);
		
		statpos.add("dmgplayers");
		numeropos.add(25);
		statneg.add("dmgplayers");
		numeroneg.add(40);
		
		statpos.add("dmgbuildings");
		numeropos.add(25);
		statneg.add("dmgbuildings");
		numeroneg.add(80);
		
		statpos.add("fastreload");
		numeropos.add(25);
		statneg.add("fastreload");
		numeroneg.add(25);
		
		statpos.add("clip");
		numeropos.add(20);
		statneg.add("clip");
		numeroneg.add(20);
		
		statpos.add("speed");
		numeropos.add(60);
		statneg.add("speed");
		numeroneg.add(60);
		
		statpos.add("minicritsexposion");
		numeropos.add(0);
		
		statpos.add("hithp");
		numeropos.add(20);
		
		statneg.add("randomcrits");
		numeroneg.add(0);
		
		statpos.add("noammoneed");
		numeropos.add(0);
		
		statneg.add("minicritswhencrit");
		numeroneg.add(0);
		
		statneg.add("noammodispensers");
		numeroneg.add(0);
		
		statpos.add("deploy");
		numeropos.add(75);
		statneg.add("deploy");
		numeroneg.add(75);
		
		statpos.add("holster");
		numeropos.add(30);
		statneg.add("holster");
		numeroneg.add(75);
		
		statpos.add("jumpheight");
		numeropos.add(25);
		statneg.add("jumpheight");
		numeroneg.add(25);
		
		statpos.add("speedactive");
		numeropos.add(10);
		statneg.add("speedactive");
		numeroneg.add(10);
	}
	
	//DEFINIR ARMAS
	private void definir(String tipo)
	{
		if(tipo == "shotgun")
		{
			weapon();
			balas();
			escopeta();
			numeropos.set(statpos.indexOf("clip"), 6);
			numeroneg.set(statneg.indexOf("clip"), 6);
			if(clase == "Pyro")
			{
				statpos.add("firebullets");
				numeropos.add(0);
				
				statpos.add("minicritsairblast");
				numeropos.add(0);
			}
		}
		
		if(tipo == "rocket launcher")
		{
			weapon();
			projectile();
			explosion();
			numeropos.set(statpos.indexOf("clip"), 4);
			numeroneg.set(statneg.indexOf("clip"), 4);
			numeropos.set(statpos.indexOf("maxprimaryammo"), 20);
			numeroneg.set(statneg.indexOf("maxprimaryammo"), 20);
			
			statpos.add("rocketdmg");
			numeropos.add(25);
			statneg.add("rocketdmg");
			numeroneg.add(25);
			
			primary = true;
		}
		
		if(tipo == "banner")
		{
			pasivo();
			numeropos.remove(statpos.indexOf("maxsecondaryammo"));
			statpos.remove(statpos.indexOf("maxsecondaryammo"));
			numeroneg.remove(statneg.indexOf("maxsecondaryammo"));
			statneg.remove(statneg.indexOf("maxsecondaryammo"));
			esarma = false;
		}
		
		if(tipo == "flame thrower")
		{
			weapon();
			numeropos.remove(statpos.indexOf("speed"));
			statpos.remove(statpos.indexOf("speed"));
			numeroneg.remove(statneg.indexOf("speed"));
			statneg.remove(statneg.indexOf("speed"));
			
			numeroneg.remove(statneg.indexOf("clip"));
			statneg.remove(statneg.indexOf("clip"));
			numeropos.remove(statpos.indexOf("clip"));
			statpos.remove(statpos.indexOf("clip"));
			
			numeropos.remove(statpos.indexOf("hithp"));
			statpos.remove(statpos.indexOf("hithp"));
			
			statpos.add("airblastcost");
			numeropos.add(50);
			statneg.add("airblastcost");
			numeroneg.add(150);
			
			statpos.add("repressurization");
			numeropos.add(50);
			statneg.add("repressurization");
			numeroneg.add(50);
			
			statpos.add("airblastpush");
			numeropos.add(20);
			statneg.add("airblastpush");
			numeroneg.add(20);
			
			statneg.add("noairblast");
			numeroneg.add(0);
			
			statpos.add("flamerange");
			numeropos.add(10);
			statneg.add("flamerange");
			numeroneg.add(10);
			
			statpos.add("afterburndmg");
			numeropos.add(4);
			statneg.add("afterburndmg");
			numeroneg.add(4);
			
			primary = true;
		}
		
		if(tipo == "pistol")
		{
			weapon();
			balas();
			numeropos.set(statpos.indexOf("clip"), 12);
			numeroneg.set(statneg.indexOf("clip"), 12);
			numeropos.set(statpos.indexOf("maxsecondaryammo"), 36);
			numeroneg.set(statneg.indexOf("maxsecondaryammo"), 36);
		}
		
		if(tipo == "scattergun")
		{
			weapon();
			balas();
			escopeta();
			numeropos.set(statpos.indexOf("clip"), 6);
			numeroneg.set(statneg.indexOf("clip"), 6);
			primary = true;
		}
		
		if(tipo == "grenade launcher")
		{
			weapon();
			projectile();
			explosion();
			numeropos.set(statpos.indexOf("clip"), 4);
			numeroneg.set(statneg.indexOf("clip"), 4);
			numeropos.set(statpos.indexOf("maxprimaryammo"), 16);
			numeroneg.set(statneg.indexOf("maxprimaryammo"), 16);
			
			statpos.add("selfdmg");
			numeropos.add(25);
			statneg.add("selfdmg");
			numeroneg.add(25);
			
			statneg.add("bombsshatter");
			numeroneg.add(0);
			
			statneg.add("bombsroll");
			numeroneg.add(0);
			
			statpos.add("fusetime");
			numeropos.add(30);
			statneg.add("fusetime");
			numeroneg.add(20);
			
			primary = true;
		}
		
		if(tipo == "stickybomb launcher")
		{
			weapon();
			projectile();
			explosion();
			numeropos.set(statpos.indexOf("clip"), 8);
			numeroneg.set(statneg.indexOf("clip"), 8);
			numeropos.set(statpos.indexOf("maxsecondaryammo"), 24);
			numeroneg.set(statneg.indexOf("maxsecondaryammo"), 24);
			
			statpos.add("selfdmg");
			numeropos.add(25);
			statneg.add("selfdmg");
			numeroneg.add(25);
		}
		
		if(tipo == "syringe gun")
		{
			weapon();
			numeropos.set(statpos.indexOf("clip"), 40);
			numeroneg.set(statneg.indexOf("clip"), 40);
			numeropos.set(statpos.indexOf("maxprimaryammo"), 150);
			numeroneg.set(statneg.indexOf("maxprimaryammo"), 150);
			primary = true;
		}
		
		if(tipo == "smg")
		{
			weapon();
			balas();
			numeropos.set(statpos.indexOf("clip"), 25);
			numeroneg.set(statneg.indexOf("clip"), 25);
			numeropos.set(statpos.indexOf("maxsecondaryammo"), 75);
			numeroneg.set(statneg.indexOf("maxsecondaryammo"), 75);
		}
		
		if(tipo == "revolver")
		{
			weapon();
			balas();
			numeropos.set(statpos.indexOf("clip"), 6);
			numeroneg.set(statneg.indexOf("clip"), 6);
			numeropos.set(statpos.indexOf("maxprimaryammo"), 24);
			numeroneg.set(statneg.indexOf("maxprimaryammo"), 24);
			primary = true;
		}
	}
	
	public int randomammo(int num)
	{
		int numerito = 0;
		int pot;
		rand = new Random();
		List<Integer> divisores = new ArrayList<Integer>();
		divisores.add(4);
		if (num == 36)
		{
			divisores.add(6);
			divisores.add(9);
		}
		if (num == 20)
		{
			divisores.add(5);
		}
		if (num == 24)
		{
			divisores.add(6);
		}
		random3 = rand.nextInt(divisores.size());
		numerito = divisores.get(random3);
		return numerito;
	}
	
	private void bpos (String propiedad)
	{
		numeropos.remove(statpos.indexOf(propiedad));
		statpos.remove(statpos.indexOf(propiedad));
	}
	private void bneg (String propiedad)
	{
		numeroneg.remove(statneg.indexOf(propiedad));
		statneg.remove(statneg.indexOf(propiedad));
	}
	
	private String statrandomgenericopos(String propiedad, int divisor2)
	{
		rand = new Random();
		random2 = rand.nextInt(numeropos.get(statpos.indexOf(propiedad))/divisor2)+1;
		return Integer.toString(random2*divisor2);
	}
	
	private String statrandomgenericoneg(String propiedad, int divisor2, boolean porcentaje)
	{
		rand = new Random();
		if(porcentaje == false)
		{
			random2 = rand.nextInt(numeroneg.get(statneg.indexOf(propiedad))/divisor2)+1;
		}
		else
		{
			random2 = rand.nextInt(numeropos.get(statpos.indexOf("propiedad"))-1)+1;
		}
		return Integer.toString(random2*divisor2);
	}
	
	//OBTENER STAT POSITIVO
	public String getstatpositivo()
	{
		int int_random = 0; 
		int divisor = 1;
		String GENERADA;
		
		rand = new Random();
		texto = "";
		
		int_random = rand.nextInt(numeropos.size()); 
		
		GENERADA = statpos.get(int_random);
		
		s_generico_pos(GENERADA, int_random, divisor);
		s_pasivo_pos(GENERADA, int_random, divisor);
		s_pyro_pos(GENERADA, int_random, divisor);
		s_demo_pos(GENERADA, int_random, divisor);
		
		switch(GENERADA)
		{
			case "damage":
				texto = "+"+statrandomgenericopos(statpos.get(int_random),5)+"% damage bonus";
				puntuacionpositiva += 60*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(GENERADA);
				bpos(GENERADA);
				bneg("dmgbuildings");
				bpos("dmgbuildings");
				bneg("dmgplayers");
				bpos("dmgplayers");
				break;
				
			case "dmgbuildings":
				texto = "+"+statrandomgenericopos(statpos.get(int_random),5)+"% damage vs buildings";
				puntuacionpositiva += 15*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(GENERADA);
				bpos(GENERADA);
				if(statneg.indexOf("damage") != -1)
				{
					bneg("damage");
					bpos("damage");
				}
				break;
				
			case "dmgplayers":
				texto = "+"+statrandomgenericopos(statpos.get(int_random),5)+"% damage vs players";
				puntuacionpositiva += 40*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(GENERADA);
				bpos(GENERADA);
				if(statneg.indexOf("damage") != -1)
				{
					bneg("damage");
					bpos("damage");
				}
				break;
				
			case "clip":
				rand = new Random();
				random2 = rand.nextInt(numeropos.get(statpos.indexOf("clip")))+1;
				texto = "+"+Integer.toString((100*random2)/numeropos.get(statpos.indexOf("clip")))+"% clip size";
				puntuacionpositiva += 50*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)));
				
				bneg(GENERADA);
				bpos(GENERADA);
				break;
				
			case "speed":
				texto = "+"+statrandomgenericopos(statpos.get(int_random),5)+"% faster firing speed";
				puntuacionpositiva += 50*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				break;
				
			case "projspeed":
				texto = "+"+statrandomgenericopos(statpos.get(int_random),5)+"% projectile speed";
				puntuacionpositiva += 40*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				break;
				
			case "minicritsexposion":
				texto = "Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs";
				puntuacionpositiva += 10;
				bpos(statpos.get(int_random));
				break;
				
			case "radius":
				texto = "+"+statrandomgenericopos(statpos.get(int_random),5)+"% explosion radius";
				puntuacionpositiva += 30*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				break;
				
			case "hithp":
				texto = "On Hit: Gain up to +"+statrandomgenericopos(statpos.get(int_random),5)+" health per attack";
				puntuacionpositiva += 30*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bpos(statpos.get(int_random));
				break;
				
			case "noammoneed":
				texto = "Does not require ammo";
				puntuacionpositiva += 8;
				
				bpos(statpos.get(int_random));
				if(primary == true)
				{
					bneg("maxprimaryammo");
					bpos("maxprimaryammo");
				}
				else
				{
					bneg("maxsecondaryammo");
					bpos("maxsecondaryammo");
				}
				if(statpos.indexOf("airblastcost") != -1)
				{
					bpos("airblastcost");
				}
				if(statneg.indexOf("airblastcost") != -1)
				{
					bneg("airblastcost");
				}
				bneg("noammodispensers");
				break;
				
			case "morepellets":
				texto = "+"+statrandomgenericopos(statpos.get(int_random),10)+"% bullets per shot";
				puntuacionpositiva += 40*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/10));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				break;
				
			case "deploy":
				texto = "This weapon deploys "+statrandomgenericopos(statpos.get(int_random),5)+"% faster";
				puntuacionpositiva += 25*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				break;
				
			case "holster":
				texto = "This weapon holsters "+statrandomgenericopos(statpos.get(int_random),5)+"% faster";
				puntuacionpositiva += 25*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				break;
				
			case "pasivehealthregen":
				texto = "+4 health regenerated per second on wearer";
				puntuacionpositiva += 25;
				
				bpos(statpos.get(int_random));
				break;
				
			case "jumpheight":
				texto = "+"+statrandomgenericopos(statpos.get(int_random),5)+"% greater jump height when active";
				puntuacionpositiva += 15*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				break;

			case "destroysstickies":
				texto = "Able to destroy enemy stickybombs";
				puntuacionpositiva += 25;
				
				bpos(statpos.get(int_random));
				break;
				
			case "speedactive":
				texto = "+"+statrandomgenericopos(statpos.get(int_random),5)+"% faster moving speed while active";
				puntuacionpositiva += 45*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				break;
				
			case "fixedpattern":
				texto = "Fires a wide, fixed shot pattern";
				puntuacionpositiva += 15;
				bpos(statpos.get(int_random));
				bneg("accuracy");
				bpos("accuracy");
				break;
				
			case "accuracy":
				texto = "+"+statrandomgenericopos(statpos.get(int_random),5)+"% more accurate";
				puntuacionpositiva += 35*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				if(statpos.indexOf("fixedpattern") != -1)
				{
					bpos("fixedpattern");
				}
				break;
				
			case "minicritsatback":
				texto = "Mini-crits targets when fired at their back from close range";
				puntuacionpositiva += 20;
				bpos(statpos.get(int_random));
				break;
				
			case "selfdmg":
				texto = "-"+statrandomgenericopos(statpos.get(int_random),5)+"% damage to self";
				puntuacionpositiva += 25*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				break;
				
			case "rocketdmg":
				texto = "-"+statrandomgenericopos(statpos.get(int_random),5)+"% blast damage from rocket jumps";
				puntuacionpositiva += 25*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				break;
	
			case "minicritsairblast":
				texto = "mini-crits targets launched airborne by airblast";
				puntuacionpositiva += 40;
				bpos(statpos.get(int_random));
				break;
				
			case "fastreload":
				texto = "+"+statrandomgenericopos(statpos.get(int_random),5)+"% faster reload time";
				puntuacionpositiva += 25*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				break;

		}

		if (texto == "")
		{
			texto = statpos.get(int_random);
		}
		
		return texto;
	}
	
	//OBTENER STAT NEGATIVO
	public String getstatnegativo()
	{
		int int_random = 0; 
		int divisor = 1;
		String GENERADA;
		
		rand = new Random();
		texto = "";

		int_random = rand.nextInt(numeroneg.size());
		GENERADA = statneg.get(int_random);
		
		switch(statneg.get(int_random))
		{
			case "maxhp":
				texto = "-"+statrandomgenericoneg(statneg.get(int_random),5,false)+" max health on wearer";
				puntuacionnegativa += 60*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				break;
			case "damage":
				texto = "-"+statrandomgenericoneg(statneg.get(int_random),5,false)+"% damage penalty";
				puntuacionnegativa += 60*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				bpos("dmgbuildings");
				bneg("dmgbuildings");
				bpos("dmgplayers");
				bneg("dmgplayers");
				break;
				
			case "dmgbuildings":
				texto = "-"+statrandomgenericoneg(statneg.get(int_random),5,false)+"% damage penalty vs buildings";
				puntuacionnegativa += 15*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				if(statneg.indexOf("damage") != -1)
				{
					bpos("damage");
					bneg("damage");
				}
				break;
				
			case "dmgplayers":
				texto = "-"+statrandomgenericoneg(statpos.get(int_random),5,false)+"% damage penalty vs players";
				puntuacionnegativa += 40*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bneg(GENERADA);
				bpos(GENERADA);
				if(statneg.indexOf("damage") != -1)
				{
					bpos("damage");
					bneg("damage");
				}
				break;
				
			case "clip":
				rand = new Random();
				random2 = rand.nextInt(numeroneg.get(statneg.indexOf("clip"))-1)+1;
				texto = "-"+Integer.toString((100*random2)/numeroneg.get(statneg.indexOf("clip")))+"% clip size";
				puntuacionnegativa += 50*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)));
				
				bpos(statneg.get(int_random));
				bneg(statneg.get(int_random));
				break;
				
			case "speed":
				texto = "-"+statrandomgenericoneg(statneg.get(int_random),5,false)+"% slower firing speed";
				puntuacionnegativa += 50*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos("speed");
				bneg(statneg.get(int_random));
				break;
			case "projspeed":
				texto = "-"+statrandomgenericoneg(statneg.get(int_random),5,false)+"% projectile speed";
				puntuacionnegativa += 40*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos("projspeed");
				bneg(statneg.get(int_random));
				break;
			case "radius":
				texto = "-"+statrandomgenericoneg(statneg.get(int_random),5,false)+"% explosion radius";
				puntuacionnegativa += 30*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(statneg.get(int_random));
				bneg(statneg.get(int_random));
				break;
			case "randomcrits":
				texto = "No random critical hits";
				puntuacionnegativa += 5;
				
				bneg(statneg.get(int_random));
				break;
			
			case "minicritswhencrit":
				texto = "Minicrits whenever it would normally crit";
				puntuacionnegativa += 25;

				bneg(statneg.get(int_random));
				break;
			case "projspread":
				texto = "+"+statrandomgenericoneg(statneg.get(int_random),1,false)+" degrees random projectile deviation";
				puntuacionnegativa += 24*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)));

				bneg(statneg.get(int_random));
				break;
			case "noammodispensers":
				texto = "No ammo from dispensers when active";
				puntuacionnegativa += 5;
				
				bneg(statneg.get(int_random));
				if(statpos.indexOf("noammoneed") != -1)
				{
					bpos("noammoneed");
				}
				break;
				
			case "maxprimaryammo":
				rand = new Random();
				divisor = randomammo(numeroneg.get(int_random));
				random2 = rand.nextInt(divisor-1)+1;
				texto = "-"+Integer.toString(100*random2/divisor)+"% max primary ammo on wearer";
				puntuacionnegativa += 20*(Float.valueOf(random2)/Float.valueOf(divisor));
				
				bpos(statneg.get(int_random));
				bneg(statneg.get(int_random));
				if(primary == true)
				{
					if(statpos.indexOf("noammoneed") != -1)
					{
						bpos("noammoneed");
					}
				}
				
				break;
			
			case "maxsecondaryammo":
				rand = new Random();
				divisor = randomammo(numeroneg.get(int_random));
				random2 = rand.nextInt(divisor-1)+1;
				texto = "-"+Integer.toString(100*random2/divisor)+"% max secondary ammo on wearer";
				puntuacionnegativa += 20*(Float.valueOf(random2)/Float.valueOf(divisor));
				
				bpos(GENERADA);
				bneg(GENERADA);
				if(primary == false)
				{
					if(statpos.indexOf("noammoneed") != -1)
					{
						bpos("noammoneed");
					}
				}
				
				break;
				
			case "pasivefireresistance":
				texto = statrandomgenericoneg(statneg.get(int_random),5,false)+"% fire damage vulnerability on wearer";
				puntuacionnegativa += 40*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				break;
			case "pasiveexpresistance":
				texto = statrandomgenericoneg(statneg.get(int_random),5,false)+"% explosive damage vulnerability on wearer";
				puntuacionnegativa += 30*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				break;
			case "pasivebulletresistance":
				texto = statrandomgenericoneg(statneg.get(int_random),5,false)+"% bullet damage vulnerability on wearer";
				puntuacionnegativa += 30*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				break;
				
			case "pasivespeed":
				texto = statrandomgenericoneg(statneg.get(int_random),5,false)+"% slower move speed on wearer";
				puntuacionnegativa += 30*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				break;
				
			case "morepellets":
				texto = "-"+statrandomgenericoneg(statneg.get(int_random),10,false)+"% bullets per shot";
				puntuacionnegativa += 40*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/10));
				
				bpos(GENERADA);
				bneg(GENERADA);
				break;
			case "deploy":
				texto = "This weapon deploys "+statrandomgenericoneg(statneg.get(int_random),5,false)+"% slower";
				puntuacionnegativa += 25*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				break;
			case "holster":
				texto = "This weapon holsters "+statrandomgenericoneg(statneg.get(int_random),5,false)+"% slower";
				puntuacionnegativa += 25*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				break;
			case "jumpheight":
				texto = "-"+statrandomgenericoneg(statneg.get(int_random),5,false)+"% jump height while active";
				puntuacionnegativa += 15*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				break;
			case "airblastcost":
				texto = "+"+statrandomgenericoneg(statneg.get(int_random),25,false)+"% airblast cost";
				puntuacionnegativa += 30*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/25));
				
				bpos(GENERADA);
				bneg(GENERADA);
				if(statneg.indexOf("noairblast") != -1)
				{
					bneg("noairblast");
				}
				if(statpos.indexOf("noammoneed") != -1)
				{
					bpos("noammoneed");
				}
				break;
				
			case "airblastpush":
				texto = "-"+statrandomgenericoneg(statneg.get(int_random),5,false)+"% airblast push force";
				puntuacionnegativa += 20*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				if(statneg.indexOf("noairblast") != -1)
				{
					bneg("noairblast");
				}
				break;
				
			case "repressurization":
				texto = "-"+statrandomgenericoneg(statneg.get(int_random),25,false)+"% repressurization rate on Alt-Fire";
				puntuacionnegativa += 40*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/25));
				
				bpos(GENERADA);
				bneg(GENERADA);
				if(statneg.indexOf("noairblast") != -1)
				{
					bneg("noairblast");
				}
				break;
			case "noairblast":
				texto = "No airblast";
				puntuacionnegativa +=50;
				
				bneg(GENERADA);
				if(statneg.indexOf("airblastcost") != -1)
				{
					bpos("airblastcost");
					bneg("airblastcost");
				}
				bpos("repressurization");
				bneg("repressurization");
			case "speedactive":
				texto = "-"+statrandomgenericoneg(statneg.get(int_random),5,false)+"% slower move speed while active";
				puntuacionnegativa += 45*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				break;
				
			case "flamerange":
				texto = "-"+statrandomgenericoneg(statneg.get(int_random),5,false)+"% Flame Thrower range";
				puntuacionnegativa += 35*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(statneg.get(int_random));
				bneg(statneg.get(int_random));
				break;
				
			case "afterburndmg":
				rand = new Random();
				random2 = rand.nextInt(numeroneg.get(statneg.indexOf("afterburndmg"))-1)+1;
				texto = "-"+Integer.toString((100*random2)/numeroneg.get(statneg.indexOf("afterburndmg")))+"% afterburn damage penalty";
				puntuacionnegativa += 25*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)));
				
				bpos(GENERADA);
				bneg(GENERADA);
				break;
				
			case "accuracy":
				texto = "-"+statrandomgenericoneg(statneg.get(int_random),5,false)+"% less accurate";
				puntuacionnegativa += 35*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				if(statpos.indexOf("fixedpattern") != -1)
				{
					bpos("fixedpattern");
				}
				break;
				
			case "selfdmg":
				texto = "+"+statrandomgenericoneg(statneg.get(int_random),5,false)+"% damage to self";
				puntuacionnegativa += 25*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				break;
				
			case "rocketdmg":
				texto = "+"+statrandomgenericoneg(statneg.get(int_random),5,false)+"% blast damage from rocket jumps";
				puntuacionnegativa += 20*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				break;
				
			case "bombsshatter":
				texto = "Launched bombs shatter on surfaces";
				puntuacionnegativa += 20;
				
				bneg(GENERADA);
				bneg("bombsroll");
				bneg("fusetime");
				break;
				
			case "fusetime":
				texto = "+"+statrandomgenericoneg(statneg.get(int_random),5,false)+"% fuse time on grenades";
				puntuacionnegativa += 20*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				if(statneg.indexOf("bombsshatter") != -1)
				{
					bneg("bombsshatter");
				}
				break;
				
			case "fastreload":
				texto = "-"+statrandomgenericoneg(statneg.get(int_random),5,false)+"% slower reload time";
				puntuacionnegativa += 20*(Float.valueOf(random2)/Float.valueOf(numeroneg.get(int_random)/5));
				
				bpos(GENERADA);
				bneg(GENERADA);
				break;
		}
		
		if (texto == "")
		{
			texto = statneg.get(int_random);
		}
		
		
		return texto;
	}
	
	
	
	//STATS GENERICOS POSITIVOS
	private void s_generico_pos(String strgenerado, int int_random, int div)
	{
		switch(strgenerado)
		{
			case "maxprimaryammo":
				rand = new Random();
				div = randomammo(numeropos.get(int_random));
				random2 = rand.nextInt(div)+1;
				texto = "+"+Integer.toString(100*random2/div)+"% max primary ammo on wearer";
				puntuacionpositiva += 20*(Float.valueOf(random2)/Float.valueOf(div));
				
				bneg(strgenerado);
				bpos(strgenerado);
				if(primary == true)
				{
					if(statpos.indexOf("noammoneed") != -1)
					{
						bpos("noammoneed");
					}
				}
				break;
				
			case "maxsecondaryammo":
				rand = new Random();
				div = randomammo(numeropos.get(int_random));
				random2 = rand.nextInt(div)+1;
				texto = "+"+Integer.toString(100*random2/div)+"% max secondary ammo on wearer";
				puntuacionpositiva += 20*(Float.valueOf(random2)/Float.valueOf(div));
				
				bneg(strgenerado);
				bpos(strgenerado);
				if(primary == false)
				{
					if(statpos.indexOf("noammoneed") != -1)
					{
						bpos("noammoneed");
					}
				}
				break;
		}
	}
	
	//STATS PASIVOS POSITIVOS
	private void s_pasivo_pos(String strgenerado, int int_random, int div)
	{
		switch(strgenerado)
		{
			case "maxhp":
				texto = "+"+statrandomgenericopos(strgenerado,5)+" max health on wearer";
				puntuacionpositiva += 60*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(strgenerado);
				bpos(strgenerado);
				break;
				
			case "pasivefireresistance":
				texto = "+"+statrandomgenericopos(strgenerado,5)+"% fire damage resistance on wearer";
				puntuacionpositiva += 40*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(strgenerado);
				bpos(strgenerado);
				break;
				
			case "pasiveexpresistance":
				texto = "+"+statrandomgenericopos(strgenerado,5)+"% explosive damage resistance on wearer";
				puntuacionpositiva += 30*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(strgenerado);
				bpos(strgenerado);
				break;
				
			case "pasivebulletresistance":
				texto = "+"+statrandomgenericopos(strgenerado,5)+"% bullet damage resistance on wearer";
				puntuacionpositiva += 30*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(strgenerado);
				bpos(strgenerado);
				break;
				
			case "pasivespeed":
				texto = "+"+statrandomgenericopos(strgenerado,5)+"% faster move speed on wearer";
				puntuacionpositiva += 30*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(strgenerado);
				bpos(strgenerado);
				break;
		}
	}
	
	//STATS PYRO POSITIVOS
	private void s_pyro_pos(String strgenerado, int int_random, int div)
	{
		switch(strgenerado)
		{
			case "flamerange":
				texto = "+"+statrandomgenericopos(statpos.get(int_random),5)+"% Flame Thrower range";
				puntuacionpositiva += 35*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				break;
				
			case "afterburndmg":
				rand = new Random();
				random2 = rand.nextInt(numeropos.get(statpos.indexOf("afterburndmg")))+1;
				texto = "+"+Integer.toString((100*random2)/numeropos.get(statpos.indexOf("afterburndmg")))+"% afterburn damage bonus";
				puntuacionpositiva += 25*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				break;
				
			case "airblastcost":
				texto = "-"+statrandomgenericopos(statpos.get(int_random),25)+"% airblast cost";
				puntuacionpositiva += 30*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/25));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				if(statneg.indexOf("noairblast")!= -1)
				{
					bneg("noairblast");
				}
				if(statpos.indexOf("noammoneed") != -1)
				{
					bpos("noammoneed");
				}
				break;
			
			case "airblastpush":
				texto = "+"+statrandomgenericopos(statpos.get(int_random),5)+"% airblast push force";
				puntuacionpositiva += 20*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				if(statneg.indexOf("noairblast")!= -1)
				{
					bneg("noairblast");
				}
				break;
				
			case "repressurization":
				texto = "+"+statrandomgenericopos(statpos.get(int_random),25)+"% repressurization rate on Alt-Fire";
				puntuacionpositiva += 40*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/25));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				if(statneg.indexOf("noairblast")!= -1)
				{
					bneg("noairblast");
				}
				break;
				
			case "firebullets":
				texto = "On Hit: Ignites players for 2 seconds";
				puntuacionpositiva += 20;
				bpos(statpos.get(int_random));
				break;
				
		}
	}
	
	//STATS DEMOMAN POSITIVOS
	private void s_demo_pos(String strgenerado, int int_random, int div)
	{
		switch(strgenerado)
		{
			case "bombsroll":
				texto = "Grenades have very little bounce and roll";
				puntuacionpositiva += 15;
				
				bneg(statpos.get(int_random));
				if(statneg.indexOf("bombsshatter") != -1)
				{
					bneg("bombsshatter");
				}
				break;
				
			case "fusetime":
				texto = "-"+statrandomgenericopos(statpos.get(int_random),5)+"% fuse time on grenades";
				puntuacionpositiva += 20*(Float.valueOf(random2)/Float.valueOf(numeropos.get(int_random)/5));
				
				bneg(statpos.get(int_random));
				bpos(statpos.get(int_random));
				break;
				
		}
	}
	
}
