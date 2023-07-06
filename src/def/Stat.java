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
	
	private boolean esTiempo = false;
	
	private boolean esDebuffSniper = false;
	private boolean esDebuffRevolver = false;
	private boolean esDebuffScattergun = false;
	private ArrayList<String> debuffs = new ArrayList<String>(Arrays.asList("MarkedForDeath", "Jarate", "Mad Milk", "Fire", "Bleed", "Slow", "Gas", "Scare"));
	private int minTime;
	
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
	
	// Constructor de stat positivo o negativo que solo contiene texto
	public Stat(String t1, String t2, int w) {
		type = 2;
		soloTexto = true;
		weight = w;
		textoPositivo1 = t1;
		textoNegativo1 = t2;
	}
	
	// Constructor de debuff Sniper Rifle
	public Stat(int maxTiempo, int minTiempo) {
		esDebuffSniper = true;
		type = 1;
		maxPositivo = maxTiempo;
		minTime = minTiempo;
	}
	
	// Constructor de debuff Revolver
	public Stat(int maxTiempo, int minTiempo, int dummy) {
		esDebuffRevolver = true;
		type = 1;
		maxPositivo = maxTiempo;
		minTime = minTiempo;
	}
	
	// Constructor de debuff Revolver
	public Stat(int maxTiempo, int minTiempo, String dummy, String dummy2) {
		esDebuffScattergun = true;
		type = 1;
		maxPositivo = maxTiempo;
		minTime = minTiempo;
	}
	
	public void setLista(List<Stat> rel) {
		relacionados = new ArrayList<>(rel);
	}
	
	private void definirPuntaje(){
		
		Random rand = new Random();
		int r;
		
		if(esDebuffSniper) {
			r = rand.nextInt(debuffs.size());
			String debuffSeleccionado = debuffs.get(r);
			switch(debuffSeleccionado) {
			case "MarkedForDeath":
				weight = 30;
				textoPositivo1 = "On Scoped Hit: Enemies are Marked-For-Death for "+minTime+" to ";
				break;
			case "Jarate":
				weight = 30;
				textoPositivo1 = "On Scoped Hit: Apply Jarate for "+minTime+" to ";
				break;
			case "Mad Milk":
				weight = 25;
				textoPositivo1 = "On Scoped Hit: Apply Mad Milk for "+minTime+" to ";
				break;
			case "Fire":
				weight = 15;
				textoPositivo1 = "On Scoped Hit: Ignites enemies for "+minTime+" to ";
				break;
			case "Bleed":
				weight = 20;
				textoPositivo1 = "On Scoped Hit: Causes bleed for "+minTime+" to ";
				break;
			case "Slow":
				weight = 20;
				textoPositivo1 = "On Scoped Hit: Slows the enemy for "+minTime+" to ";
				break;
			case "Gas":
				weight = 10;
				textoPositivo1 = "On Scoped Hit: Apply Gas Passer for "+minTime+" to ";
				break;
			case "Scare":
				weight = 40;
				textoPositivo1 = "On Scoped Hit: Scares enemies for "+minTime+" to ";
				break;
			}
			textoPositivo2 = " seconds based on charge level.";
			r = rand.nextInt(maxPositivo-minTime);
			//System.out.print("\n\n"+(r+1)+" / "+(maxPositivo-minTime)+"\n\n");
			puntaje = Float.valueOf(weight)*(Float.valueOf(r+1)/Float.valueOf(maxPositivo-minTime));
			valor1 = r+1+minTime;
			
			return;
		}
		
		if(esDebuffRevolver) {
			r = rand.nextInt(debuffs.size());
			String debuffSeleccionado = debuffs.get(r);
			switch(debuffSeleccionado) {
			case "MarkedForDeath":
				weight = 25;
				textoPositivo1 = "On headshot: Enemy is Marked-For-Death for ";
				break;
			case "Jarate":
				weight = 30;
				textoPositivo1 = "On headshot: Apply Jarate for ";
				break;
			case "Mad Milk":
				weight = 25;
				textoPositivo1 = "On headshot: Apply Mad Milk for ";
				break;
			case "Fire":
				weight = 15;
				textoPositivo1 = "On headshot: Ignites enemies for ";
				break;
			case "Bleed":
				weight = 20;
				textoPositivo1 = "On headshot: Causes bleed for ";
				break;
			case "Slow":
				weight = 20;
				textoPositivo1 = "On headshot: Slows the enemy for ";
				break;
			case "Gas":
				weight = 10;
				textoPositivo1 = "On headshot: Apply Gas Passer for ";
				break;
			case "Scare":
				weight = 40;
				textoPositivo1 = "On headshot: Scares enemies for ";
				break;
			}
			textoPositivo2 = " seconds.";
			r = rand.nextInt(maxPositivo-minTime);
			//System.out.print("\n\n"+(r+1)+" / "+(maxPositivo-minTime)+"\n\n");
			puntaje = Float.valueOf(weight)*(Float.valueOf(r+1)/Float.valueOf(maxPositivo-minTime));
			valor1 = r+1+minTime;
			
			return;
		}
		
		if(esDebuffScattergun) {
			r = rand.nextInt(debuffs.size());
			String debuffSeleccionado = debuffs.get(r);
			switch(debuffSeleccionado) {
			case "MarkedForDeath":
				weight = 25;
				textoPositivo1 = "If all bullets connect, deals Marks-For-Death the target for ";
				break;
			case "Jarate":
				weight = 30;
				textoPositivo1 = "If all bullets connect, applies Jarate to the target for ";
				break;
			case "Mad Milk":
				weight = 25;
				textoPositivo1 = "If all bullets connect, applies Mad Milk to the target for ";
				break;
			case "Fire":
				weight = 15;
				textoPositivo1 = "If all bullets connect, ignites the target for ";
				break;
			case "Bleed":
				weight = 20;
				textoPositivo1 = "If all bullets connect, causes bleed to the target for ";
				break;
			case "Slow":
				weight = 20;
				textoPositivo1 = "If all bullets connect, slows the target for ";
				break;
			case "Gas":
				weight = 10;
				textoPositivo1 = "If all bullets connect, applies Gas Passer to the target for ";
				break;
			case "Scare":
				weight = 40;
				textoPositivo1 = "If all bullets connect, scare the target for ";
				break;
			}
			textoPositivo2 = " seconds.";
			r = rand.nextInt(maxPositivo-minTime);
			//System.out.print("\n\n"+(r+1)+" / "+(maxPositivo-minTime)+"\n\n");
			puntaje = Float.valueOf(weight)*(Float.valueOf(r+1)/Float.valueOf(maxPositivo-minTime));
			valor1 = r+1+minTime;
			
			return;
		}
		
		if(soloTexto) {
			puntaje = weight;
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
		if(soloTexto) {
			return weight;
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
					puntaje = (Float.valueOf(weight)*(9/Float.valueOf(maxNegativo-1)));
				} else {
					puntaje = (Float.valueOf(weight)*(1/Float.valueOf(maxNegativo-1)));
				}
			}
		}
		return 999999;
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
				return textoPositivo1 + "     " + puntaje;
			} else {
				return textoNegativo1 + "     " + puntaje;
			}
		}
		if (tipo == tipos.POSITIVO) {
			return textoPositivo1 + valor1 + textoPositivo2 + "     " + puntaje;
		} else {
			return textoNegativo1 + valor1 + textoNegativo2 + "     " + puntaje;
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
	
	@Override
    public int compareTo(Stat otro) {
        return Integer.compare(this.type, otro.getType());
    }
}