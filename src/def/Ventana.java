package def;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ventana extends JFrame{
	
	// JPanel
	JPanel panel;
	// Bot�n para generar el arma
	JButton b_generar;
	// Combo boxes
	JComboBox<String> ComboClasses;
	JComboBox<String> ComboSlot;
	// Labels
	JLabel nombreArma;
	JLabel desClase;
	JLabel desSlot;
	// Image icon
	ImageIcon icono;
	// Im�genes
	Imagen imagenArma;
	Imagen imagenEmblema;
	// Tipos de letra y colores
	Font TF2Font;
	Color calidadUnica, cafeOscuro, cafeClaro, statsPositivos, statsNegativos;
	
	public Ventana()
	{
		this.pack();
		this.setSize(800,750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		CargarVentana();
		this.repaint();
		this.setVisible(true);
	}
	
	private void CargarVentana() {
		
		//This Code for custom fonts was stolen from someone on YouTube
		try {
			// load a custom font in your project folder
			TF2Font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/tf2build.ttf")).deriveFont(15f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/tf2build.ttf")));			
		} catch(IOException | FontFormatException e) {}
		
		// Definir colores a usar
		calidadUnica = new Color(255,215,0);
		cafeOscuro = new Color(36,32,27);
		cafeClaro = new Color(60,54,47);
		statsPositivos = new Color(153,204,255);
		statsNegativos = new Color(255,64,64);
		
		// Definir el panel, tama�o y color de fondo
		panel = new JPanel();
		panel.setBounds(0,0,800,750);
		panel.setBackground(cafeOscuro);
		panel.repaint();
		
		// Definir el bot�n para generar
		b_generar = new JButton("GENERATE");
		b_generar.setBounds(30+30, 550, 200, 60);
		
		// Definir label que dice "Clase"
		desClase = new JLabel("Select the class:");
		desClase.setBounds(50, 50, 150, 25);
		desClase.setForeground(Color.WHITE);
		desClase.setFont(new Font("Arial", Font.PLAIN, 17));
		
		// Definir el combo box de las clases
		ComboClasses = new JComboBox<String>();
		ComboClasses.setBounds(50, 80, 100, 25);
		ComboClasses.addItem("ANY");
		ComboClasses.addItem("Scout");
		ComboClasses.addItem("Soldier");
		ComboClasses.addItem("Pyro");
		ComboClasses.addItem("Demoman");
		ComboClasses.addItem("Heavy");
		ComboClasses.addItem("Engineer");
		ComboClasses.addItem("Medic");
		ComboClasses.addItem("Sniper");
		ComboClasses.addItem("Spy");
		
		// Definir label que dice "Clase"
		desSlot = new JLabel("Select the slot of the weapon:");
		desSlot.setBounds(50, 130, 250, 25);
		desSlot.setForeground(Color.WHITE);
		desSlot.setFont(new Font("Arial", Font.PLAIN, 17));
		
		// Definir el combo box de los slots
		ComboSlot = new JComboBox<String>();
		ComboSlot.setBounds(50, 160, 100, 25);
		ComboSlot.addItem("ANY");
		ComboSlot.addItem("Primary");
		ComboSlot.addItem("Secondary");
		ComboSlot.addItem("Melee");
		ComboSlot.addItem("Special");
		
		// Definir el label que muestra el nombre del arma
		nombreArma = new JLabel();
		nombreArma.setBackground(Color.getColor(null, 0));
		nombreArma.setFont(TF2Font);
		nombreArma.setBounds(305, 270, 450, 35);
		nombreArma.setForeground(calidadUnica);
		nombreArma.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Definir la imagen del arma de muestra
		icono = new ImageIcon("img/Backpack_Bat.png");
		imagenArma = new Imagen(402, 20,256,128);
		imagenArma.setBounds(402, 20,256,256);
		imagenArma.setIcon(icono);
		imagenArma.setVisible(true);
		imagenArma.setOpaque(true);
		
		// Definir label con el t�tulo del arma
		nombreArma = new JLabel("New weapon for the");
		nombreArma.setBackground(Color.getColor(null, 0));
		nombreArma.setFont(TF2Font);
		nombreArma.setBounds(305, 290, 450, 35);
		nombreArma.setForeground(calidadUnica);
		nombreArma.setHorizontalAlignment(SwingConstants.CENTER);
		
		// A�adir los elementos a la ventana
		this.add(b_generar);
		this.add(desClase);
		this.add(ComboClasses);
		this.add(desSlot);
		this.add(ComboSlot);
		this.add(nombreArma);
		this.add(imagenArma);
		this.add(nombreArma);
		this.add(panel);
	}
}
