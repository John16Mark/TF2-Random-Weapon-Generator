package def;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ventana Generator = new Ventana();
		Weapon w = new Weapon("Heavy", "Minigun");
		w.generarArma();
		w.setPoder(4);
		Ventana v = new Ventana();
	}

}
