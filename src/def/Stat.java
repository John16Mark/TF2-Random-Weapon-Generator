package def;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Stat implements Comparable<Stat>{
	
	// Nombre clave que tendrá el stat
	private String nombreStat;
	// Valor que tiene el stat respecto a otros
	private float weight;
	// Puntaje que aporta el stat al arma
	private float puntaje;
	private String textoPositivo1;
	private String textoPositivo2;
	
	private String textoNegativo1;
	private String textoNegativo2;
	// Valor máximo que puede tener la variable aleatoria
	private int maxPositivo;
	private int maxNegativo;

	// Valor de tamaño de paso de la variable aleatoria
	private int paso;
	// Valor aleatorio que tendrá el stat
	private int valor1;
	// Define si la variable aleatoria está definida porcentualmente
	private boolean esPorcentual = false;
	private boolean soloTexto = false;
	private enum tipos {POSITIVO, NEGATIVO};
	private tipos tipo;
	private int type;
	// Lista de stats con los que se relaciona
	private ArrayList<Stat> relacionados = new ArrayList<Stat>();
	// Para ammo pool:
	private int max;
	
	// PARA LOS QUE TIENEN RANGO
	// Valor mínimo que puede tener la variable aleatoria
	private int minPositivo;
	private int minNegativo;
	private boolean esDeRango;
	private boolean isInverted;
	
	private boolean esTiempo = false;
	
	private boolean esBuff = false;
	private boolean esDebuff = false;
	private int maxPeso = 0;
	private int minPeso = 0;
	private ArrayList<Buff> buffs;
	private ArrayList<Debuff> debuffs;
	
	private Buff megaHeal = new Buff("Megaheal");
	private Buff crit = new Buff("Crit");
	private Buff miniCrit = new Buff("Minicrit");
	private Buff heal = new Buff("Heal");
	private Buff speedBoost = new Buff("Speedboost");
	private Buff fireSpeed = new Buff("FireSpeed");
	private Buff damageRes = new Buff("DamageRes");
	private Buff fireRes = new Buff("FireRes");
	private Buff expRes = new Buff("ExpRes");
	private Buff bullRes = new Buff("BullRes");
	private Buff meleeRes = new Buff("MeleeRes");
	
	private Debuff markedForDeath = new Debuff("MarkedForDeath");
	private Debuff jarate = new Debuff("Jarate");
	private Debuff madMilk = new Debuff("Mad Milk");
	private Debuff fire = new Debuff("Fire");
	private Debuff bleed = new Debuff("Bleed");
	private Debuff slow = new Debuff("Slow");
	private Debuff gasPasser = new Debuff("Gas");
	private Debuff scare = new Debuff("Scare");
	
	private int minTime;
	
	/*******************************************************************
	 * 				 PUEDE SER AMBOS: POSITIVO O NEGATIVO
	*******************************************************************/
	// Constructor de stat que puede ser tanto positivo y negativo con número aleatorio
	public Stat(int m, int p, String t1, String t2, int w, String tt1, String tt2, int m2) {
		type = 2;
		maxPositivo = m;
		paso = p;
		textoPositivo1 = t1;
		textoPositivo2 = t2;
		weight = w;
		textoNegativo1 = tt1;
		textoNegativo2 = tt2;
		maxNegativo = m2;
	}
	
	// Constructor de stat de tiempo
	public Stat(int maxPos, int p,  int maxNeg, String t1, String t2, int w, String tt1, String tt2) {
		type = 2;
		maxPositivo = maxPos;
		paso = p;
		textoPositivo1 = t1;
		textoPositivo2 = t2;
		weight = w;
		textoNegativo1 = tt1;
		textoNegativo2 = tt2;
		maxNegativo = maxNeg;
		esTiempo = true;
	}
	
	// Constructor de stat clip size
	public Stat(int clip, String t1, String t2, int w, String tt1, String tt2) {
		type = 2;
		maxPositivo = clip;
		maxNegativo = clip;
		esPorcentual = true;
		textoPositivo1 = t1;
		textoPositivo2 = t2;
		weight = w;
		textoNegativo1 = tt1;
		textoNegativo2 = tt2;
	}
	
	// constructor de stat ammo pool
	public Stat(String t1, String t2, int w, String tt1, String tt2, int maxAmmo) {
		type = 2;
		textoPositivo1 = t1;
		textoPositivo2 = t2;
		weight = w;
		textoNegativo1 = tt1;
		textoNegativo2 = tt2;
		max = maxAmmo;
		maxPositivo = maxAmmo;
		maxNegativo = maxAmmo;
		esPorcentual = true;
		definirDivisorAmmo();
	}
	
	// Constructor de stat positivo o negativo que solo contiene texto
	public Stat(String t1, String t2, int w) {
		type = 2;
		soloTexto = true;
		weight = w;
		textoPositivo1 = t1;
		textoNegativo1 = t2;
	}
	
	/*******************************************************************
	 * 							 SOLO UNO A LA VEZ
	*******************************************************************/
	
	// Constructor de stat con número aleatorio que solamente es positivo o negativo.
	public Stat(int maxValor, int salto, String txt1, String txt2, int valor, boolean esPositivo) {
		paso = salto;
		if(esPositivo) {
			type = 1;
			maxPositivo = maxValor;
			textoPositivo1 = txt1;
			textoPositivo2 = txt2;
		} else {
			type = 3;
			maxNegativo = maxValor;
			textoNegativo1 = txt1;
			textoNegativo2 = txt2;
		}
		weight = valor;
	}
	
	// Constructor de stat que solo contiene texto
	public Stat(String t, int w, boolean esPositivo) {
		soloTexto = true;
		weight = w;
		if(esPositivo) {
			type = 1;
			textoPositivo1 = t;
		} else {
			type = 3;
			textoNegativo1 = t;
		}
	}
	
	// Constructor de rango 
	public Stat(int maxRango, int minRango, int salto, String txt1, String txt2, int valor, boolean esPositivo, boolean esInverso) {
		weight = valor;
		paso = salto;
		if(esPositivo) {
			type = 1;
			maxPositivo = maxRango;
			minPositivo = minRango;
			textoPositivo1 = txt1;
			textoPositivo2 = txt2;
		} else {
			type = 3;
			maxNegativo = maxRango;
			minPositivo = minRango;
			textoNegativo1 = txt1;
			textoNegativo2 = txt2;
		}
		isInverted = esInverso;
		esDeRango = true;
	}
	
	/**************************************************************
	 * 					CONSTRUCTORES ESPECÍFICOS
	**************************************************************/
	
	// Constructor buff
	public Stat(int maxTiempo, int minTiempo, String DET) {
		type = 1;
		maxPositivo = maxTiempo;
		minTime = minTiempo;
		System.out.print("\nCreación MaxPositivo = "+maxPositivo);
		System.out.print("\nCreación minTime = "+minTime);
		esBuff = true;
		definirBuffs(DET);
	}
	
	// Constructor debuff
	public Stat(String DET, int maxTiempo, int minTiempo) {
		esDebuff = true;
		type = 1;
		maxPositivo = maxTiempo;
		minTime = minTiempo;
		definirDebuffs(DET);
	}
	
	/**************************************************************
	 * 							MÉTODOS
	**************************************************************/
	
	private void definirBuffs(String DET) {
		if(DET == "SapperApplied") {
			megaHeal.setPeso(40);		crit.setPeso(90);		miniCrit.setPeso(70);	heal.setPeso(50);
			speedBoost.setPeso(40);		fireSpeed.setPeso(40);	damageRes.setPeso(40);	fireRes.setPeso(35);
			expRes.setPeso(25);			bullRes.setPeso(30);	meleeRes.setPeso(15);
			
			buffs = new ArrayList<>(Arrays.asList(
					megaHeal, speedBoost, fireSpeed, damageRes,
					fireRes, expRes, bullRes, meleeRes));
			
		} else if(DET == "SapperComplete") {
			megaHeal.setPeso(40);		crit.setPeso(90);		miniCrit.setPeso(70);	heal.setPeso(50);
			speedBoost.setPeso(40);		fireSpeed.setPeso(40);	damageRes.setPeso(40);	fireRes.setPeso(35);
			expRes.setPeso(25);			bullRes.setPeso(30);	meleeRes.setPeso(15);
			
			buffs = new ArrayList<>(Arrays.asList(
					megaHeal, miniCrit, speedBoost, fireSpeed, damageRes,
					fireRes, expRes, bullRes, meleeRes));
			
		} else if(DET == "SapperRemoved") {
			megaHeal.setPeso(40);		crit.setPeso(75);		miniCrit.setPeso(50);	heal.setPeso(45);
			speedBoost.setPeso(40);		fireSpeed.setPeso(35);	damageRes.setPeso(40);	fireRes.setPeso(35);
			expRes.setPeso(25);			bullRes.setPeso(30);	meleeRes.setPeso(15);
			
			buffs = new ArrayList<>(Arrays.asList(
					speedBoost, fireSpeed, damageRes,
					fireRes, expRes, bullRes, meleeRes));
		}
		
		for(Buff b : buffs) {
			b.setStat(DET);
		}
		
		int menor = buffs.get(0).getPeso();
		int mayor = buffs.get(0).getPeso();
		for(Buff b : buffs) {
			if(b.getPeso() < menor) {
				menor = b.getPeso();
			}
			if(b.getPeso() > mayor) {
				mayor = b.getPeso();
			}
		}
		minPeso = menor;
		maxPeso = mayor;
	}
	
	private void definirDebuffs(String DET) {
		if(DET == "SniperRifle") {
			markedForDeath.setPeso(30);		jarate.setPeso(30);		madMilk.setPeso(25);
			fire.setPeso(15);				bleed.setPeso(20);		slow.setPeso(20);
			gasPasser.setPeso(10);			scare.setPeso(50);
			
			debuffs = new ArrayList<>(Arrays.asList(markedForDeath, jarate, madMilk, fire, bleed, slow, gasPasser, scare));
		} else if(DET == "RevolverHeadshot") {
			markedForDeath.setPeso(35);		jarate.setPeso(35);		madMilk.setPeso(30);
			fire.setPeso(20);				bleed.setPeso(25);		slow.setPeso(25);
			gasPasser.setPeso(15);			scare.setPeso(55);
			
			debuffs = new ArrayList<>(Arrays.asList(markedForDeath, jarate, madMilk, fire, bleed, slow, gasPasser, scare));
		} else if(DET == "ScattergunAllShot") {
			markedForDeath.setPeso(25);		jarate.setPeso(30);		madMilk.setPeso(25);
			fire.setPeso(15);				bleed.setPeso(20);		slow.setPeso(20);
			gasPasser.setPeso(10);			scare.setPeso(55);
			
			debuffs = new ArrayList<>(Arrays.asList(markedForDeath, jarate, madMilk, fire, bleed, slow, gasPasser, scare));
		}
		
		 else if(DET == "Sandman") {
			markedForDeath.setPeso(30);		jarate.setPeso(30);		madMilk.setPeso(30);
			fire.setPeso(15);				bleed.setPeso(20);		slow.setPeso(20);
			gasPasser.setPeso(10);			scare.setPeso(45);
			
			debuffs = new ArrayList<>(Arrays.asList(markedForDeath, jarate, madMilk, fire, bleed, slow, gasPasser, scare));
		}
		
		for(Debuff b : debuffs) {
			b.setStat(DET);
		}
		
		int menor = debuffs.get(0).getPeso();
		int mayor = debuffs.get(0).getPeso();
		for(Debuff b : debuffs) {
			if(b.getPeso() < menor) {
				menor = b.getPeso();
			}
			if(b.getPeso() > mayor) {
				mayor = b.getPeso();
			}
		}
		minPeso = menor;
		maxPeso = mayor;
	}
	
	private void definirPuntaje(){
		
		Random rand = new Random();
		int r, r2;
		
		if(esBuff) {
			// Número aleatorio para elegir el buff
			r = rand.nextInt(buffs.size());
			Buff buffAux = buffs.get(r);
			weight = buffAux.getPeso();
			
			// Número aleatorio para el tiempo máximo
			r = rand.nextInt(maxPositivo-minTime);
			if(buffAux.getTexto2() == "") {
				textoPositivo1 = buffAux.getTexto1();
				puntaje = Float.valueOf(weight)*(Float.valueOf(r+1+minTime)/Float.valueOf(maxPositivo));
			} else {
				// Segundo número aleatorio para el porcentaje
				r2 = (rand.nextInt(5)+1)*5;
				textoPositivo1 = buffAux.getTexto1()+r2+buffAux.getTexto2();
				puntaje = Float.valueOf(weight)*( ( ((Float.valueOf(r2))/25) + (Float.valueOf(r+1+minTime)/Float.valueOf(maxPositivo)) )/ 2 );
			}
			/*System.out.print("\ndentro de Es Buff MaxPositivo = "+maxPositivo);
			System.out.print("\ndentro de Es Buff minTime = "+minTime);*/			
			valor1 = r+1+minTime;
			textoPositivo2 = " seconds.";
			
			return;
		}
		
		if(esDebuff) {
			// Número aleatorio para elegir el debuff
			r = rand.nextInt(debuffs.size());
			Debuff debuffAux = debuffs.get(r);
			weight = debuffAux.getPeso();
			
			// Número aleatorio para el tiempo máximo
			r = rand.nextInt(maxPositivo-minTime);
			textoPositivo2 = " seconds.";
			if(debuffAux.getTexto2() == "") {
				textoPositivo1 = debuffAux.getTexto1();
				puntaje = Float.valueOf(weight)*(Float.valueOf(r+1+minTime)/Float.valueOf(maxPositivo));
			} else if(debuffAux.getTexto2() == " to ") {
				textoPositivo1 = debuffAux.getTexto1()+minTime+debuffAux.getTexto2();
				puntaje = Float.valueOf(weight)*(Float.valueOf(r+1+minTime)/Float.valueOf(maxPositivo));
				textoPositivo2 = " seconds based on charge level.";
			} else {/*
				// Segundo número aleatorio para el porcentaje
				r2 = (rand.nextInt(5)+1)*5;
				textoPositivo1 = debuffAux.getTexto1()+r2+debuffAux.getTexto2();
				///System.out.print("\nPuntaje = w:"+weight+"* ("+r2+"/25) + ("+(r+1+minTime)+"/"+maxPositivo+"/2");
				puntaje = Float.valueOf(weight)*( ( ((Float.valueOf(r2))/25) + (Float.valueOf(r+1+minTime)/Float.valueOf(maxPositivo)) )/ 2 );*/
			}
			valor1 = r+1+minTime;
			
			return;
		}
		
		if(soloTexto) {
			puntaje = weight;
			return;
		}
		
		if(esDeRango) {
			int totalOpciones;
			if(tipo == tipos.POSITIVO) {
				r = rand.nextInt((maxPositivo-minPositivo)/paso + 1);
				totalOpciones = (maxPositivo-minPositivo)/paso + 1;
				valor1 = r*paso + minPositivo;
				if(isInverted) {
					puntaje = Float.valueOf(weight)*(Float.valueOf(totalOpciones-r)/Float.valueOf(totalOpciones));
				} else {
					puntaje = Float.valueOf(weight)*(Float.valueOf(r+1)/Float.valueOf(totalOpciones));
				}
				
			} else {
				// TODO
			}
			
			return;
		}
		
		if(!esPorcentual) {
			if(tipo == tipos.POSITIVO) {
				r = rand.nextInt((maxPositivo)/paso)+1;
				valor1 = r*paso;
				puntaje = Float.valueOf(weight)*(Float.valueOf(valor1)/Float.valueOf(maxPositivo));
				if(esTiempo) {
					if(valor1 >= 20) {
						textoPositivo1 = "2.";
					} else if(valor1 >= 10) {
						textoPositivo1 = "1.";
					}
					valor1 %= 10;
				}
				if(valor1 == 1 && textoPositivo1 == "On Hit: Victim can't cloak for ") {
					textoPositivo2 = " second";
				} else if(valor1 != 1 && textoPositivo1 == "On Hit: Victim can't cloak for ") {
					textoPositivo2 = " seconds";
				} else if(textoPositivo2 == " extra projectile" || textoPositivo2 == " extra projectiles") {
					if(valor1 == 1) {
						textoPositivo2 = " extra projectile";
					} else if(valor1 == 2) {
						textoPositivo2 = " extra projectiles";
					}
				}
				
			} else {
				r = rand.nextInt((maxNegativo)/paso)+1;
				valor1 = r*paso;
				puntaje = Float.valueOf(weight)*(Float.valueOf(valor1)/Float.valueOf(maxNegativo));
				if(esTiempo) {
					if(valor1 >= 20) {
						textoPositivo1 = "2.";
					} else if(valor1 >= 10) {
						textoPositivo1 = "1.";
					}
					valor1 %= 10;
				}
			}
		} else {
			if(tipo == tipos.POSITIVO) {
				//System.out.print("\n\n\033[92m"+textoPositivo1+textoPositivo2+"\n\n\033[0m");
				r = rand.nextInt(maxPositivo)+1;
				valor1 = r;
				valor1 *= 100;
				valor1 /= maxPositivo;
				puntaje = Float.valueOf(weight)*(r/Float.valueOf(maxPositivo));
			} else {
				//System.out.print("\n\n\033[92m"+textoNegativo1+textoNegativo2+"\n\n\033[0m");
				//System.out.print("\n\n\033[92m"+maxNegativo+"\n\n\033[0m");
				r = rand.nextInt(maxNegativo - 1)+1;
				valor1 = r;
				valor1 *= 100;
				valor1 /= maxNegativo;
				if(textoNegativo2 == "% max Overheal") {
					puntaje = (Float.valueOf(weight)*((10-r)/Float.valueOf(maxNegativo-1)));
				} else {
					puntaje = (Float.valueOf(weight)*(r/Float.valueOf(maxNegativo-1)));
				}
				
			}
		}
		
	}
	
	public float getPuntajeMenor(boolean b) {
		if(esDebuff) {
			return minPeso*((1+minTime)/Float.valueOf(maxPositivo));
		}
		if(soloTexto) {
			return weight;
		}
		if(esBuff) {
			return minPeso*(1/Float.valueOf(maxPositivo-minTime));
		}
		if(esDeRango) {
			int totalOpciones;
			if(b) {
				totalOpciones = (maxPositivo-minPositivo)/paso + 1;
				return Float.valueOf(weight)*(1/Float.valueOf(totalOpciones));
			} else {
				totalOpciones = (maxNegativo-minNegativo)/paso + 1;
				return Float.valueOf(weight)*(1/Float.valueOf(totalOpciones));
			}
		}
		if(!esPorcentual) {
			if(b) {
				return Float.valueOf(weight)*(Float.valueOf(paso)/Float.valueOf(maxPositivo));
			} else {
				return Float.valueOf(weight)*(Float.valueOf(paso)/Float.valueOf(maxNegativo));
			}
		} else {
			if(b) {
				return Float.valueOf(weight)*(1/Float.valueOf(maxPositivo));
			} else {
				if(textoNegativo2 == "% max Overheal") {
					return (Float.valueOf(weight)*(9/Float.valueOf(maxNegativo-1)));
				} else {
					return (Float.valueOf(weight)*(1/Float.valueOf(maxNegativo-1)));
				}
			}
		}
		//return 999999;
	}
	
	private void definirDivisorAmmo() {
		int n;
		Random rand = new Random();
		ArrayList<Integer> divisores = new ArrayList<>();
		divisores.add(4);
		switch(max)
		{
			case 36:
				divisores.add(6);
				divisores.add(9);
				break;
			case 20:
				divisores.add(5);
				break;
			case 24:
				divisores.add(6);
				break;
			case 25:
				divisores.remove(divisores.indexOf(4));
				divisores.add(5);
				break;
			case 32:
				divisores.add(8);
				break;
			case 75:
				divisores.remove(divisores.indexOf(4));
				divisores.add(25);
				break;
			case 100:
				divisores.remove(divisores.indexOf(4));
				divisores.add(10);
				break;
			case 150:
				divisores.remove(divisores.indexOf(4));
				divisores.add(25);
				break;
			case 200:
				divisores.remove(divisores.indexOf(4));
				divisores.add(50);
		}
		n = rand.nextInt(divisores.size());
		maxPositivo = max/divisores.get(n);
		maxNegativo = max/divisores.get(n);
		System.out.print("\n\n Max negativo: "+maxNegativo+"\n\n\n");
	}
	
	public float getPuntaje() {
		return puntaje;
	}
	
	public float getPeso() {
		
		if(esDebuff || esBuff) {
			return maxPeso;
		}
		return weight;
	}
	
	public int getType() {
		return type;
	}
	
	public String getNombre() {
		return nombreStat;
	}
	
	public ArrayList<Stat> getLista() {
		return relacionados;
	}
	
	public String getTexto() {
		if(soloTexto) {
			if (tipo == tipos.POSITIVO) {
				return textoPositivo1;
			} else {
				return textoNegativo1;
			}
		}
		if (tipo == tipos.POSITIVO) {
			return textoPositivo1 + valor1 + textoPositivo2;
		} else {
			return textoNegativo1 + valor1 + textoNegativo2;
		}
	}
	
	public void setNombre(String s) {
		nombreStat = s;
	}
	
	public void setPositivo() {
		tipo = tipos.POSITIVO;
		definirPuntaje();
	}
	
	public void setNegativo() {
		tipo = tipos.NEGATIVO;
		definirPuntaje();
	}
	
	public void setLista(List<Stat> rel) {
		relacionados = new ArrayList<>(rel);
	}
	
	@Override
    public int compareTo(Stat otro) {
        return Integer.compare(this.type, otro.getType());
    }
}