package def;

import java.util.ArrayList;

public class Weapon {
	
	// enum Clases
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
	private Clase clase;
	
	// Listas de stats
	ArrayList<Stat> Positivos;
	ArrayList<Stat> Negativos;
	ArrayList<Stat> Neutrales;
	
	// Puntajes
	private float puntuacionPositiva = 0;
	private float puntuacionNegativa = 0;
	private float puntuacionBanner = 0;
	
	// Stats ARMA ataque
	Stat damage, damagePlayers, damageBuildings, clipSize, firingSpeed, hpOnHit;
	// Stats ARMA velocidad
	Stat deploySpeed, holsterSpeed, reloadSpeed;
	
	public Weapon(int c, int t) {
		/*
		if(clase == Clase.SNIPER) {
			System.out.print("Sniper");
		} else {
			System.out.print("Otro");
		}*/
	}
	
	private void setTipoArma() {
		damage = new Stat(30, 5, "+", "% damage bonus", 60, "-", "% damage penalty", 30);
		damagePlayers = new Stat(25, 5, "+", "% damage vs players", 40, "-", "% damage penalty vs players", 40);
		damageBuildings = new Stat(25, 5, "+", "% damage vs buildings", 15, "-", "% damage penalty vs buildings", 80);
		clipSize = new Stat(4, "+", "% clip size", 50, "-" , "% clip size");
		firingSpeed = new Stat(60, 5, "+", "% faster firing speed", 50, "-", "% slower firing speed", 60);
		hpOnHit = new Stat(20, 5, "On Hit: Gain up to +", " health per attack", 35, true);
	}
	
	public void getStatPositivo() {
		setTipoArma();
		clipSize.setPositivo();
		System.out.print(clipSize.getTexto());
	}
	
}