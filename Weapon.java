package def;

import java.util.ArrayList;

public class Weapon {
	
	// enum Clases
	private enum Clase {SCOUT(1), SOLDIER(2), PYRO(3), DEMOMAN(4), HEAVY(5), ENGINEER(6), MEDIC(7), SNIPER(8), SPY(9);
		
		int num;
		
		Clase(int n){
			num = n;
		}
	}
	// Clase seleccionada
	private Clase clase;
	
	// Listas de stats
	ArrayList<Stat> Positivos;
	ArrayList<Stat> Negativos;
	ArrayList<Stat> Neutrales;
	
	// Puntajes
	private float puntuacionPositiva = 0;
	private float puntuacionNegativa = 0;
	private float puntuacionBanner = 0;
	
	// 
	
	public Weapon(int c, int t) {
		
		if(clase == Clase.SNIPER) {
			System.out.print("Sniper");
		} else {
			System.out.print("Otro");
		}
	}
}
