package def;
import javax.swing.JLabel;

public class Imagen extends JLabel
{
private int x,y,largo,ancho;
	
	public Imagen(int x4, int y4, int la4, int an4)
	{
		x=x4;
		y=y4;
		largo=la4;
		ancho=an4;
		cargarComponentes();
	}
	
	public void setX(int nuevox4)
	{
		x=nuevox4;
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setY(int nuevoy4)
	{
		y=nuevoy4;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setL(int nuevol4)
	{
		largo=nuevol4;
	}
	
	public int getL()
	{
		return largo;
	}
	
	public void setA(int nuevoa4)
	{
		ancho=nuevoa4;
	}
	
	public int getA()
	{
		return ancho;

	}
	
	public void cargarComponentes()
	{
		
	}
}
