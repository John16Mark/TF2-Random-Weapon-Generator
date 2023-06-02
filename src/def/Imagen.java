package def;

import javax.swing.JLabel;

public class Imagen extends JLabel{
	
	private int x, y, largo, ancho;
	
	public Imagen(int x, int y, int l, int a)
	{
		this.x = x;
		this.y = y;
		this.largo = l;
		this.ancho = a;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
}
