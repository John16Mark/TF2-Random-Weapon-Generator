package def;

import java.util.ArrayList;
import java.util.Random;

public class Stat {
	
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
	private enum tipos {POSITIVO, NEGATIVO, DOBLE};
	private tipos tipo;
	// Lista de stats con los que se relaciona
	private ArrayList<Stat> relacionados;
	
	public Stat(int m, int p, String t1, String t2, int w, boolean esPositivo) {
		
		paso = p;
		if(esPositivo) {
			maxPositivo = m;
			textoPositivo1 = t1;
			textoPositivo2 = t2;
		} else {
			maxNegativo = m;
			textoNegativo1 = t1;
			textoNegativo2 = t2;
		}
		
		weight = w;
	}
	
	public Stat(int m, int p, String t1, String t2, int w, String tt1, String tt2, int m2) {
		maxPositivo = m;
		paso = p;
		textoPositivo1 = t1;
		textoPositivo2 = t2;
		weight = w;
		textoNegativo1 = tt1;
		textoNegativo2 = tt2;
		maxNegativo = m2;
	}
	
	public Stat(int clip, String t1, String t2, int w, String tt1, String tt2) {
		maxPositivo = clip;
		esPorcentual = true;
		textoPositivo1 = t1;
		textoPositivo2 = t2;
		weight = w;
		textoNegativo1 = tt1;
		textoNegativo2 = tt2;
	}
	
	private void definirPuntaje(){
		
		Random rand = new Random();
		int r;
		
		if(!esPorcentual) {
			if(tipo == tipos.POSITIVO) {
				r = rand.nextInt((maxPositivo)/paso)+1;
				valor1 = r*paso;
				puntaje = Float.valueOf(weight)*(Float.valueOf(valor1)/Float.valueOf(maxPositivo));
			}
		} else {
			if(tipo == tipos.POSITIVO) {
				r = rand.nextInt(maxPositivo)+1;
				valor1 = r;
				valor1 *= 100;
				valor1 /= maxPositivo;
				puntaje = Float.valueOf(weight)*(r/Float.valueOf(maxPositivo));
			}
		}
	}
	
	private void definirDivisorClip() {
		int n;
		Random rand = new Random();
		ArrayList<Integer> divisores = new ArrayList();
		divisores.add(4);
		switch(maxPositivo)
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
		paso = divisores.get(n);
	}
	
	public float getPuntaje() {
		return puntaje;
	}
	
	public void setPositivo() {
		tipo = tipos.POSITIVO;
		definirPuntaje();
	}
	
	public String getTexto() {
		if (tipo == tipos.POSITIVO) {
			return textoPositivo1 + valor1 + textoPositivo2 + puntaje; 
		} else {
			return textoNegativo1 + valor1 + textoNegativo2 + puntaje; 
		}
	}
}