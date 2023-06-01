package def;

import java.util.ArrayList;

public class Stat {
	
	// Nombre clave que tendrá el stat
	private String nombreStat;
	// Valor que tiene el stat respecto a otros
	private float peso;
	// Puntaje que aporta el stat al arma
	private float puntaje;
	private String texto1;
	private String texto2;
	private String texto3;
	// Valor máximo que puede tener la variable aleatoria
	private int cap;
	// Valor de tamaño de paso de la variable aleatoria
	private int paso;
	// Valor aleatorio que tendrá el stat
	private int valor1;
	private int valor2;
	// Define si la variable aleatoria está definida porcentualmente
	private boolean esPorcentual;
	private enum tipos {POSITIVO, NEGATIVO, DOBLE};
	private tipos tipo;
	// Lista de stats con los que se relaciona
	private ArrayList<Stat> relacionados;
	
	public Stat() {
		
	}
	
	private void definirPuntaje(){
		if(!esPorcentual) {
			if(tipo == tipos.POSITIVO) {
				puntaje = Float.valueOf(valor1)*(Float.valueOf(valor1)/Float.valueOf(cap)/Float.valueOf(paso));
			}
		} else {
			
		}
	}
	
	public float getPuntaje() {
		return puntaje;
	}
	
}
