package def;

import java.util.ArrayList;
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
	private String textoPositivo3;
	
	private String textoNegativo1;
	private String textoNegativo2;
	private String textoNegativo3;
	// Valor máximo que puede tener la variable aleatoria
	private int maxPositivo;
	private int maxNegativo;
	// Valor de tamaño de paso de la variable aleatoria
	private int paso;
	// Valor aleatorio que tendrá el stat
	private int valor1;
	private int valor2;
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
	
	// Constructor de stat con número aleatorio que solamente es positivo o negativo.
	public Stat(int m, int p, String t1, String t2, int w, boolean esPositivo) {
		paso = p;
		if(esPositivo) {
			type = 1;
			maxPositivo = m;
			textoPositivo1 = t1;
			textoPositivo2 = t2;
		} else {
			type = 3;
			maxNegativo = m;
			textoNegativo1 = t1;
			textoNegativo2 = t2;
		}
		weight = w;
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
	
	public void setLista(List<Stat> rel) {
		relacionados = new ArrayList<>(rel);
	}
	
	private void definirPuntaje(){
		
		Random rand = new Random();
		int r;
		if(soloTexto) {
			puntaje = weight;
		} else {
			if(!esPorcentual) {
				if(tipo == tipos.POSITIVO) {
					r = rand.nextInt((maxPositivo)/paso)+1;
					valor1 = r*paso;
					puntaje = Float.valueOf(weight)*(Float.valueOf(valor1)/Float.valueOf(maxPositivo));
				} else {
					r = rand.nextInt((maxNegativo)/paso)+1;
					valor1 = r*paso;
					puntaje = Float.valueOf(weight)*(Float.valueOf(valor1)/Float.valueOf(maxNegativo));
				}
			} else {
				if(tipo == tipos.POSITIVO) {
					r = rand.nextInt(maxPositivo)+1;
					valor1 = r;
					valor1 *= 100;
					valor1 /= maxPositivo;
					puntaje = Float.valueOf(weight)*(r/Float.valueOf(maxPositivo));
				} else {
					r = rand.nextInt(maxNegativo - 1)+1;
					valor1 = r;
					valor1 *= 100;
					valor1 /= maxNegativo;
					puntaje = Float.valueOf(weight)*(r/Float.valueOf(maxNegativo-1));
				}
			}
		}
	}
	
	private void definirDivisorAmmo() {
		int n;
		Random rand = new Random();
		ArrayList<Integer> divisores = new ArrayList();
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
			case 32:
				divisores.add(8);
				break;
			case 75:
				divisores.remove(divisores.indexOf(4));
				divisores.add(25);
				break;
		}
		n = rand.nextInt(divisores.size());
		maxPositivo = max/divisores.get(n);
		maxNegativo = max/divisores.get(n);
		System.out.print("\n\n Max negativo: "+maxNegativo+"\n\n\n");
	}
	
	public float getPuntaje() {
		return puntaje;
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
	
	@Override
    public int compareTo(Stat otro) {
        return Integer.compare(this.type, otro.getType());
    }
}