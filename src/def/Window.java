package def;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

public class Window extends JFrame {

	private JPanel contentPane;
	private ArrayList<String> classes;
	private ArrayList<String> powers;
	private InputStream is;
	
	private int botonSeleccionado = 0;
	private JButton item1;
	private JButton item2;
	private JButton item3;
	private JButton item4;
	
	private ArrayList<String> PrimaryScout = new ArrayList<String>(Arrays.asList("Scattergun"));
	private ArrayList<String> SecondaryScout = new ArrayList<String>(Arrays.asList("Pistol"));
	private ArrayList<String> MeleeScout = new ArrayList<String>(Arrays.asList("Bat", "Bat with baseball"));
	
	private ArrayList<String> PrimarySoldier = new ArrayList<String>(Arrays.asList("Rocket Launcher"));
	private ArrayList<String> SecondarySoldier = new ArrayList<String>(Arrays.asList("Shotgun", "Banner", "SoldierBoots"));
	private ArrayList<String> MeleeSoldier = new ArrayList<String>(Arrays.asList("Shovel"));
	
	private ArrayList<String> PrimaryPyro = new ArrayList<String>(Arrays.asList("Flame Thrower"));
	private ArrayList<String> SecondaryPyro = new ArrayList<String>(Arrays.asList("Shotgun"));
	private ArrayList<String> MeleePyro = new ArrayList<String>(Arrays.asList("Fire Axe"));
	
	private ArrayList<String> PrimaryDemoman = new ArrayList<String>(Arrays.asList("Grenade Launcher", "DemoBoots"));
	private ArrayList<String> SecondaryDemoman = new ArrayList<String>(Arrays.asList("Stickybomb Launcher", "Shield"));
	private ArrayList<String> MeleeDemoman = new ArrayList<String>(Arrays.asList("Bottle", "Sword"));
	
	private ArrayList<String> PrimaryHeavy = new ArrayList<String>(Arrays.asList("Minigun"));
	private ArrayList<String> SecondaryHeavy = new ArrayList<String>(Arrays.asList("Shotgun","Lunchbox"));
	private ArrayList<String> MeleeHeavy = new ArrayList<String>(Arrays.asList("Fists"));
	
	private ArrayList<String> PrimaryEngineer = new ArrayList<String>(Arrays.asList("Shotgun"));
	private ArrayList<String> SecondaryEngineer = new ArrayList<String>(Arrays.asList("Pistol"));
	private ArrayList<String> MeleeEngineer = new ArrayList<String>(Arrays.asList("Wrench"));
	
	private ArrayList<String> PrimaryMedic = new ArrayList<String>(Arrays.asList("Syringe Gun"));
	private ArrayList<String> SecondaryMedic = new ArrayList<String>(Arrays.asList("Medigun"));
	private ArrayList<String> MeleeMedic = new ArrayList<String>(Arrays.asList("Bonesaw"));
	
	private ArrayList<String> PrimarySniper = new ArrayList<String>(Arrays.asList("Sniper Rifle"));
	private ArrayList<String> SecondarySniper = new ArrayList<String>(Arrays.asList("SMG", "Backpack"));
	private ArrayList<String> MeleeSniper = new ArrayList<String>(Arrays.asList("Kukri"));
	
	private ArrayList<String> PrimarySpy = new ArrayList<String>(Arrays.asList("Revolver"));
	private ArrayList<String> SecondarySpy = new ArrayList<String>(Arrays.asList("Sapper"));
	private ArrayList<String> MeleeSpy = new ArrayList<String>(Arrays.asList("Knife"));
	private ArrayList<String> SpecialSpy = new ArrayList<String>(Arrays.asList("Invis Watch"));
	
	ArrayList<ArrayList<String>> Scout = new ArrayList<>(Arrays.asList(PrimaryScout, SecondaryScout, MeleeScout));
	ArrayList<ArrayList<String>> Soldier = new ArrayList<>(Arrays.asList(PrimarySoldier, SecondarySoldier, MeleeSoldier));
	ArrayList<ArrayList<String>> Pyro = new ArrayList<>(Arrays.asList(PrimaryPyro, SecondaryPyro, MeleePyro));
	ArrayList<ArrayList<String>> Demoman = new ArrayList<>(Arrays.asList(PrimaryDemoman, SecondaryDemoman, MeleeDemoman));
	ArrayList<ArrayList<String>> Heavy = new ArrayList<>(Arrays.asList(PrimaryHeavy, SecondaryHeavy, MeleeHeavy));
	ArrayList<ArrayList<String>> Engineer = new ArrayList<>(Arrays.asList(PrimaryEngineer, SecondaryEngineer, MeleeEngineer));
	ArrayList<ArrayList<String>> Medic = new ArrayList<>(Arrays.asList(PrimaryMedic, SecondaryMedic, MeleeMedic));
	ArrayList<ArrayList<String>> Sniper = new ArrayList<>(Arrays.asList(PrimarySniper, SecondarySniper, MeleeSniper));
	ArrayList<ArrayList<String>> Spy = new ArrayList<>(Arrays.asList(PrimarySpy, SecondarySpy, MeleeSpy, SpecialSpy));
	
	ArrayList<ArrayList<ArrayList<String>>> CLASS = new ArrayList<>(Arrays.asList(Scout,Soldier,Pyro,Demoman,Heavy,Engineer,Medic,Sniper,Spy));
	
	ArrayList<String> lista = PrimarySoldier;
	
	JComboBox<String> comboClasses;
	JComboBox<String> comboSlot;
	
	private static String resources = "";
    private static ClassLoader loader;
	public static Font loadFont(String filename, float size)
            throws Exception {
        InputStream stream = loader.getResource(resources + filename)
                .openStream();
        Font font = Font.createFont(Font.TRUETYPE_FONT, stream);
        return font.deriveFont(size);
    }
	
	/**
	 * Create the frame.
	 */
	public Window() {
		@SuppressWarnings("unused")
		Font TF2Font;
		Font TF2Secondary;
		// This Code for custom fonts was stolen from someone on YouTube
		try {
			// load a custom font in your project folder
			TF2Font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("fonts/tf2build.ttf")).deriveFont(17f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(TF2Font);	
		} catch(IOException | FontFormatException e) {
			TF2Font = new Font("Times New Roman", Font.PLAIN, 17);
		}
		
		try {
			// load a custom font in your project folder
			
			TF2Secondary = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("fonts/tf2secondary.ttf")).deriveFont(16f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(TF2Secondary);	
		} catch(IOException | FontFormatException e) {
			TF2Secondary = new Font("Times New Roman", Font.PLAIN, 17);
		}
		
		classes = new ArrayList<String>(Arrays.asList("Scout", "Soldier", "Pyro", "Demoman", "Heavy", "Engineer", "Medic", "Sniper", "Spy"));
		powers = new ArrayList<String>(Arrays.asList("Trash", "Bad", "Normal", "Good", "Broken", "--RANDOM--"));
		
		setTitle("TF2 Weapon Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 840);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(36, 32, 27));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 0, 286, 802);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblClass = new JLabel("Select the class:");
		lblClass.setForeground(new Color(240, 240, 240));
		//lblClass.setFont(new Font("TF2 Build", Font.PLAIN, 17));
		lblClass.setFont(TF2Font);
		lblClass.setBounds(34, 37, 166, 22);
		panel.add(lblClass);
		
		JLabel lblSlot = new JLabel("Select the slot:");
		lblSlot.setForeground(new Color(240, 240, 240));
		lblSlot.setFont(new Font("TF2 Build", Font.PLAIN, 17));
		lblSlot.setBounds(34, 131, 166, 22);
		panel.add(lblSlot);
		
		comboClasses = new JComboBox<>();
		comboClasses.setBounds(42, 62, 156, 22);
		comboClasses.addItem("ANY");
		for(String s : classes) {
			comboClasses.addItem(s);
		}
		panel.add(comboClasses);
		
		comboSlot = new JComboBox<>();
		comboSlot.setBounds(42, 156, 156, 22);
		comboSlot.addItem("ANY");
		comboSlot.addItem("Primary");
		comboSlot.addItem("Secondary");
		comboSlot.addItem("Melee");
		//comboSlot.addItem("Special");
		panel.add(comboSlot);
		
		JButton bttnGenerate = new JButton("Generate");
		bttnGenerate.setFont(new Font("TF2 Build", Font.PLAIN, 22));
		bttnGenerate.setBounds(46, 670, 194, 49);
		panel.add(bttnGenerate);
		
		JLabel lblNStats = new JLabel("<html>Select how many stats you want</html>");
		lblNStats.setHorizontalAlignment(SwingConstants.LEFT);
		lblNStats.setVerticalAlignment(SwingConstants.TOP);
		lblNStats.setForeground(new Color(240, 240, 240));
		lblNStats.setFont(new Font("TF2 Build", Font.PLAIN, 15));
		lblNStats.setBounds(34, 385, 216, 49);
		panel.add(lblNStats);
		
		JLabel lblPositive = new JLabel("Positive");
		lblPositive.setForeground(new Color(153, 204, 255));
		lblPositive.setFont(new Font("TF2 Build", Font.PLAIN, 17));
		lblPositive.setBounds(34, 429, 96, 22);
		panel.add(lblPositive);
		
		JLabel lblNegative = new JLabel("Negative");
		lblNegative.setForeground(new Color(255, 64, 64));
		lblNegative.setFont(new Font("TF2 Build", Font.PLAIN, 17));
		lblNegative.setBounds(170, 429, 96, 22);
		panel.add(lblNegative);
		
		JComboBox<String> comboPositive = new JComboBox<>();
		comboPositive.setBounds(34, 455, 82, 22);
		comboPositive.addItem("ANY");
		for(int i = 1; i <= 5; i++) {
			comboPositive.addItem(Integer.valueOf(i).toString());
		}
		panel.add(comboPositive);
		
		JComboBox<String> comboNegative = new JComboBox<>();
		comboNegative.setBounds(170, 455, 82, 22);
		comboNegative.addItem("ANY");
		for(int i = 1; i <= 5; i++) {
			comboNegative.addItem(Integer.valueOf(i).toString());
		}
		panel.add(comboNegative);
		
		JLabel lblSelectThePower = new JLabel("Select the power level");
		lblSelectThePower.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectThePower.setVerticalAlignment(SwingConstants.TOP);
		lblSelectThePower.setForeground(new Color(134, 80, 172));
		lblSelectThePower.setFont(new Font("TF2 Build", Font.PLAIN, 15));
		lblSelectThePower.setBounds(35, 540, 216, 22);
		panel.add(lblSelectThePower);
		
		JComboBox<String> comboPower = new JComboBox<String>();
		comboPower.setBounds(65, 564, 156, 22);
		for(String s : powers) {
			comboPower.addItem(s);
		}
		comboPower.setSelectedIndex(2);
		panel.add(comboPower);
		
		item1 = new JButton("");
		item1.setSelectedIcon(new ImageIcon(Window.class.getResource("/img/mini/Bat with baseballYES.png")));
		item1.setContentAreaFilled(false);
		item1.setBackground(new Color(0, 0, 255));
		//item1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
		item1.setBorder(null);
		//item1.setBorderPainted(false);
		item1.setIcon(new ImageIcon(Window.class.getResource("/img/mini/Bat with baseballNO.png")));
		item1.setBounds(34, 226, 64, 64);
		item1.setVisible(false);
		panel.add(item1);
		
		item2 = new JButton("");
		item2.setContentAreaFilled(false);
		//item2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
		item2.setBorder(null);
		item2.setBounds(108, 226, 64, 64);
		item2.setVisible(false);
		panel.add(item2);
		
		item3 = new JButton("");
		item3.setContentAreaFilled(false);
		item3.setBorder(null);
		item3.setBounds(182, 226, 64, 64);
		item3.setVisible(false);
		panel.add(item3);
		
		item4 = new JButton("");
		item4.setContentAreaFilled(false);
		item4.setBorder(null);
		item4.setBounds(34, 300, 64, 64);
		item4.setVisible(false);
		panel.add(item4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(296, 0, 438, 802);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel imgEmblem = new JLabel("");
		imgEmblem.setIcon(new ImageIcon(Window.class.getResource("/img/Pyro.png")));
		imgEmblem.setBounds(313, 234, 64, 64);
		imgEmblem.setVisible(false);
		panel_1.add(imgEmblem);
		
		JLabel imgWeapon = new JLabel("");
		imgWeapon.setIcon(new ImageIcon(Window.class.getResource("/img/logo.png")));
		imgWeapon.setBounds(91, 21, 256, 256);
		//imgWeapon.setVisible(false);
		panel_1.add(imgWeapon);
		
		JLabel lblWeaponTitle = new JLabel("<html><center>Welcome to the Weapon Generator!</center></html>");
		lblWeaponTitle.setVerticalAlignment(SwingConstants.TOP);
		lblWeaponTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeaponTitle.setForeground(new Color(255, 215, 0));
		lblWeaponTitle.setFont(new Font("TF2 Build", Font.PLAIN, 17));
		lblWeaponTitle.setBounds(74, 309, 290, 36);
		//lblWeaponTitle.setVisible(false);
		panel_1.add(lblWeaponTitle);
		
		JLabel imgWeapon_1 = new JLabel("");
		imgWeapon_1.setIcon(new ImageIcon(Window.class.getResource("/img/fondo.png")));
		imgWeapon_1.setBounds(86, 16, 266, 266);
		panel_1.add(imgWeapon_1);
		
		JLabel lblStats = new JLabel("<html>Select the class and slot for the weapon.<br>"
				+ "You can also select how many stats you want and how strong you want the weapon to be.<br>"
				+ "When you are done, press the button to generate a weapon with random stats.<br>"
				+ "Try different options and you may find interesting results!<br><br><font color=\"#FFD700\">Pro-Tip:</font> Select "
				+ "<font color=\"#8650AC\">ANY</font> on how many positive and negative stats you want and "
				+ "<font color=\"#8650AC\">--RANDOM--</font> on the power level for true randomness on your weapon.</html>");
		lblStats.setVerticalAlignment(SwingConstants.TOP);
		lblStats.setHorizontalAlignment(SwingConstants.CENTER);
		lblStats.setForeground(new Color(240, 240, 240));
		lblStats.setFont(TF2Secondary);
		lblStats.setBounds(61, 366, 316, 425);
		panel_1.add(lblStats);
		
		JLabel lblNewLabel = new JLabel("John16Mark's TF2 Weapon Generator. v 1.0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(87, 87, 87));
		lblNewLabel.setBounds(117, 777, 311, 14);
		panel_1.add(lblNewLabel);
		
		bttnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String claseSel = comboClasses.getSelectedItem().toString();
				int nPositivos = comboPositive.getSelectedIndex();
				int nNegativos = comboNegative.getSelectedIndex();
				
				if(claseSel == "ANY") {
					Random rand = new Random();
					int r = rand.nextInt(9);
					claseSel = classes.get(r);
				}
				
				String slotSeleccionado = comboSlot.getSelectedItem().toString();
				String wep = armaEnSlot(claseSel, slotSeleccionado);
				
				Weapon w = new Weapon(claseSel, wep, nPositivos, nNegativos, comboPower.getSelectedIndex());
				w.generarArma();
				imgWeapon.setIcon(new ImageIcon(Window.class.getResource("/img/"+wep+".png")));
				imgWeapon.setVisible(true);
				imgEmblem.setIcon(new ImageIcon(Window.class.getResource("/img/"+claseSel+".png")));
				imgEmblem.setVisible(true);
				if(wep == "DemoBoots" || wep == "SoldierBoots") {
					wep = "Boots";
				}
				lblWeaponTitle.setText("<html><center>New "+wep+" for the "+claseSel+"</center></html>");
				lblWeaponTitle.setVisible(true);
				String stats = "<html>";
				ArrayList<ArrayList<Stat>> listas = w.getStats();
				for(Stat s : listas.get(0)) {
					stats += "<center><font color=\"#F0F0F0\">� "+s.getTexto()+"</font></center>";
				}
				for(Stat s : listas.get(1)) {
					stats += "<center><font color=\"#99CCFF\">� "+s.getTexto()+"</font></center>";
				}
				for(Stat s : listas.get(2)) {
					stats += "<center><font color=\"#F0F0F0\">� "+s.getTexto()+"</font></center>";
				}
				for(Stat s : listas.get(3)) {
					stats += "<center><font color=\"#FF4040\">� "+s.getTexto()+"</font></center>";
				}
				for(Stat s : listas.get(4)) {
					stats += "<center><font color=\"#F0F0F0\">� "+s.getTexto()+"</font></center>";
				}
				stats += "</html>";
				lblStats.setText(stats);
			}
		});
		
		comboClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboClasses.getSelectedItem() != "Spy" && comboSlot.getSelectedItem() == "Special") {
					comboSlot.setSelectedIndex(3);
					comboSlot.removeItem("Special");
				}
				if(comboClasses.getSelectedItem() == "Spy") {
					comboSlot.addItem("Special");
				}
				DesactivarBotones();
				//ActivarBotones(comboClasses,comboSlot);
			}
		});
		
		comboSlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DesactivarBotones();
				//ActivarBotones(comboClasses,comboSlot);
			}
		});
		
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonSeleccionado = 1;
				if(lista.size() == 1) {
					item1.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(0)+"YES.png")));
				} else {
					item1.setIcon(new ImageIcon(Window.class.getResource("/img/mini/logoYES.png")));
					item2.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(0)+"NO.png")));
					item3.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(1)+"NO.png")));
					if(lista.size() >= 3) {
						item4.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(2)+"NO.png")));
					}
				}
			}
		});
		
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonSeleccionado = 2;
				item1.setIcon(new ImageIcon(Window.class.getResource("/img/mini/logoNO.png")));
				item2.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(0)+"YES.png")));
				item3.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(1)+"NO.png")));
				if(lista.size() >= 3) {
					item4.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(2)+"NO.png")));
				}
			}
		});
		
		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonSeleccionado = 3;
				item1.setIcon(new ImageIcon(Window.class.getResource("/img/mini/logoNO.png")));
				item2.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(0)+"NO.png")));
				item3.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(1)+"YES.png")));
				if(lista.size() >= 3) {
					item4.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(2)+"NO.png")));
				}
			}
		});
		
		item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonSeleccionado = 4;
				item1.setIcon(new ImageIcon(Window.class.getResource("/img/mini/logoNO.png")));
				item2.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(0)+"NO.png")));
				item3.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(1)+"NO.png")));
				item4.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(2)+"YES.png")));
			}
		});
	}
	
	private void DesactivarBotones() {
		botonSeleccionado = 1;
		item1.setVisible(false);
		item2.setVisible(false);
		item3.setVisible(false);
		item4.setVisible(false);
		
		if(comboClasses.getSelectedItem() != "ANY" && comboSlot.getSelectedItem() != "ANY") {
			
			lista = CLASS.get(comboClasses.getSelectedIndex()-1).get(comboSlot.getSelectedIndex()-1);
			
			if(lista.size() == 1) {
				item1.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(0)+"YES.png")));
				item1.setVisible(true);
			} else {
				item1.setIcon(new ImageIcon(Window.class.getResource("/img/mini/logoYES.png")));
				item1.setVisible(true);
				item2.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(0)+"NO.png")));
				item2.setVisible(true);
				item3.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(1)+"NO.png")));
				item3.setVisible(true);
				if(lista.size() == 3) {
					item4.setIcon(new ImageIcon(Window.class.getResource("/img/mini/"+lista.get(2)+"NO.png")));
					item4.setVisible(true);
				}
			}
			
		}
		
		
	}
	
	String armaEnSlot(String clase, String slot) {
		ArrayList<String> armasPosibles = new ArrayList<>();
		int indice = classes.indexOf(clase);
		int maxIndice = 3;
		
		if(slot == "ANY") {
			if(indice == 8) {
				maxIndice = 4;
			}
			for(int i = 0; i < maxIndice; i++) {
				for(String s : CLASS.get(indice).get(i)) {
					armasPosibles.add(s);
				}
			}
		}
		
		if(slot == "Primary") {
			for(String s : CLASS.get(indice).get(0)) {
				if(botonSeleccionado == 1 || (botonSeleccionado != 1 && s == CLASS.get(indice).get(0).get(botonSeleccionado-2)) ) {
					armasPosibles.add(s);
				}
			}
		}
		
		if(slot == "Secondary") {
			for(String s : CLASS.get(indice).get(1)) {
				if(botonSeleccionado == 1 || (botonSeleccionado != 1 && s == CLASS.get(indice).get(1).get(botonSeleccionado-2)) ) {
					armasPosibles.add(s);
				}
			}
		}
		
		if(slot == "Melee") {
			for(String s : CLASS.get(indice).get(2)) {
				if(botonSeleccionado == 1 || (botonSeleccionado != 1 && s == CLASS.get(indice).get(2).get(botonSeleccionado-2)) ) {
					armasPosibles.add(s);
				}
			}
		}
		
		if(slot == "Special") {
			for(String s : CLASS.get(indice).get(3)) {
				if(botonSeleccionado == 1 || (botonSeleccionado != 1 && s == CLASS.get(indice).get(3).get(botonSeleccionado-2)) ) {
					armasPosibles.add(s);
				}
			}
		}
		
		Random rand = new Random();
		System.out.print(armasPosibles.size()+"\n\n");
		int randomIndex = rand.nextInt(armasPosibles.size());
		
		return armasPosibles.get(randomIndex);
	}
}
