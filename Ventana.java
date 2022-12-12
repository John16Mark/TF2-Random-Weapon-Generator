package def;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
/*
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;*/
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Ventana extends JFrame
{
	//PANEL
	JPanel panel;
	//BOTÓN
	JButton b_generar;
	//COMBOBOX
	JComboBox combo;
	//TEXTOS
	JLabel texto1;
	JLabel texto3;
	JLabel texto2;
	//IMÁGENES
	Icon icono;
	Imagen imagen1, imagen2;
	//ESTILOS DE LETRA
	Font TF2Font;
	Color unique, fondooscuro, fondoclaro,statsplus,statsminus;
	
	String clase = new String();

	public Ventana()
	{
		this.pack();
		this.setSize(800,750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		Carga();
		this.repaint();
		this.setVisible(true);
	}

	public void Carga()
	{
		try{
            // load a custom font in your project folder
			TF2Font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/tf2build.ttf")).deriveFont(15f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/tf2build.ttf")));			
		}
		catch(IOException | FontFormatException e){
		}
		
		unique = new Color(255,215,0);
		fondooscuro = new Color(36,32,27);
		fondoclaro = new Color(60,54,47);
		statsplus = new Color(153,204,255);
		statsminus = new Color(255,64,64);
		
		panel = new JPanel();
		panel.setBackground(fondooscuro);
		panel.repaint();
		
		b_generar = new JButton("GENERATE");
		b_generar.setBounds(30, 550, 200, 60);
		
		combo = new JComboBox();
		combo.setBounds(50, 50, 100, 25);
		combo.addItem("ANY");
		combo.addItem("Scout");
		combo.addItem("Soldier");
		combo.addItem("Pyro");
		combo.addItem("Demoman");
		
		texto1 = new JLabel();
		texto1.setBackground(Color.getColor(null, 0));
		texto1.setFont(TF2Font);
		texto1.setBounds(305, 270, 450, 35);
		
		texto2 = new JLabel();
		texto2.setBackground(fondoclaro);
		//texto2.setLineWrap(true);
		//texto2.setWrapStyleWord(true);
		texto2.setBounds(370, 300, 320, 160);
		
		texto3 = new JLabel();
		texto3.setBounds(100, 550, 300, 30);
		
		icono = new ImageIcon(getClass().getResource("../img/Leaderboard_class_soldier.png"));
		imagen2 = new Imagen(602,160,64,32);
		imagen2.setBounds(602,160,64,64);
		imagen2.setIcon(icono);
		imagen2.setBackground(Color.blue);
		imagen2.setVisible(false);
		
		icono = new ImageIcon(getClass().getResource("../img/Backpack_Rocket_Launcher.png"));
		imagen1 = new Imagen(402,0,256,128);
		imagen1.setBounds(402,0,256,256);
		imagen1.setIcon(icono);
		imagen1.setBackground(Color.blue);
		imagen1.setVisible(false);
		
		panel.setBounds(0,0,800,750);
		panel.setLayout(null);
		panel.setBackground(Color.white);
		panel.setBackground(fondooscuro);
		panel.repaint();
		
		this.setBackground(fondooscuro);
		this.add(imagen1);
		this.add(imagen2);
		this.add(texto1);
		this.add(texto2);
		this.add(texto3);
		this.add(combo);
		this.add(b_generar);
		this.add(panel);
		
		List<String> clases = new ArrayList<String>();
		List<String> tipoarma = new ArrayList<String>();
		
		clases.add("Scout");
		clases.add("Soldier");
		clases.add("Pyro");
		clases.add("Demoman");
		//clases.add("Heavy");
		//clases.add("Engineer");
		//clases.add("Medic");
		//clases.add("Sniper");
		//clases.add("Spy");
		
		/*tipoarma.add("scattergun");
		tipoarma.add("pistol");*/
		//tipoarma.add("flare gun");

		b_generar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				tipoarma.clear();
				Random rand;
				int random;
				if(combo.getSelectedItem() == "ANY")
				{
					rand = new Random();
					random = rand.nextInt(clases.size());
				}
				else
				{
					random = clases.indexOf(combo.getSelectedItem());
				}
				
				
				
				
				switch (clases.get(random))
				{
					case "Scout":
						icono = new ImageIcon(getClass().getResource("../img/Leaderboard_class_scout.png"));
						imagen2.setIcon(icono);
						tipoarma.add("scattergun");
						tipoarma.add("pistol");
						clase = "Scout";
						break;
					case "Soldier":
						icono = new ImageIcon(getClass().getResource("../img/Leaderboard_class_soldier.png"));
						imagen2.setIcon(icono);
						tipoarma.add("rocket launcher");
						tipoarma.add("shotgun");
						tipoarma.add("banner");
						clase = "Soldier";
						break;
					case "Pyro":
						icono = new ImageIcon(getClass().getResource("../img/Leaderboard_class_pyro.png"));
						imagen2.setIcon(icono);
						tipoarma.add("flame thrower");
						tipoarma.add("shotgun");
						clase = "Pyro";
						break;
					case "Demoman":
						icono = new ImageIcon(getClass().getResource("../img/Leaderboard_class_demoman.png"));
						imagen2.setIcon(icono);
						tipoarma.add("grenade launcher");
						tipoarma.add("stickybomb launcher");
						clase = "Demoman";
						break;
				}
				rand = new Random();
				int randomarma = rand.nextInt(tipoarma.size());
				
				//randomarma = 4;
				
				switch (tipoarma.get(randomarma))
				{
					case "scattergun":
						icono = new ImageIcon(getClass().getResource("../img/Backpack_Scattergun.png"));
						imagen1.setIcon(icono);
						break;
					case "pistol":
						icono = new ImageIcon(getClass().getResource("../img/Backpack_Pistol.png"));
						imagen1.setIcon(icono);
						break;
					case "rocket launcher":
						icono = new ImageIcon(getClass().getResource("../img/Backpack_Rocket_Launcher.png"));
						imagen1.setIcon(icono);
						break;
					case "shotgun":
						icono = new ImageIcon(getClass().getResource("../img/Backpack_Shotgun.png"));
						imagen1.setIcon(icono);
						break;
					case "banner":
						icono = new ImageIcon(getClass().getResource("../img/Backpack_Buff_Banner.png"));
						imagen1.setIcon(icono);
						break;
					case "boots":
						icono = new ImageIcon(getClass().getResource("../img/Backpack_Gunboats.png"));
						imagen1.setIcon(icono);
						break;
					case "flame thrower":
						icono = new ImageIcon(getClass().getResource("../img/Backpack_Flame_Thrower.png"));
						imagen1.setIcon(icono);
						break;
					case "flare gun":
						icono = new ImageIcon(getClass().getResource("../img/Backpack_Flare_Gun.png"));
						imagen1.setIcon(icono);
						break;
					case "grenade launcher":
						icono = new ImageIcon(getClass().getResource("../img/Backpack_Grenade_Launcher.png"));
						imagen1.setIcon(icono);
						break;
					case "stickybomb launcher":
						icono = new ImageIcon(getClass().getResource("../img/Backpack_Stickybomb_Launcher.png"));
						imagen1.setIcon(icono);
						break;
						
				}
				

				arma generado = new arma(tipoarma.get(randomarma),clase);
				
				imagen1.setVisible(true);
				imagen2.setVisible(true);
				
				texto1.setForeground(unique);
				texto1.setHorizontalAlignment(SwingConstants.CENTER);
				texto1.setText("<html>New "+tipoarma.get(randomarma)+" for The "+clase+"</html>");
				texto2.setForeground(statsplus);
				texto2.setBackground(fondoclaro);
				texto2.setHorizontalAlignment(SwingConstants.CENTER);
				texto2.setVerticalAlignment(SwingConstants.TOP);
				//texto2.setHorizontalAlignment(SwingConstants.CENTER);
				//texto2.setText("<html><FONT COLOR=RED>Red</FONT> and <FONT COLOR=BLUE>Blue</FONT> Text</html>");
				texto2.setText(generado.regresarpositivos());
				//texto2.setText("asdfasdfasdfasdfasdfasdfasdjinsibncvibsdifjsdoif\njs iosdfio gjsdofigjsdoifgjsdiof gsodifjg sodfigjsopid gfopsdf");
				//texto2.setBackground(fondoclaro);
				//texto2.repaint();
				//texto2.font
				//texto3.setText(Float.toString(generado.getpuntuacionpositiva()));
			}
		});
	}
}
