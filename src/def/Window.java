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

	/**
	 * Create the frame.
	 */
	public Window() {
		@SuppressWarnings("unused")
		Font TF2Font;
		// This Code for custom fonts was stolen from someone on YouTube
		try {
			// load a custom font in your project folder
			TF2Font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/tf2build.ttf")).deriveFont(17f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/tf2build.ttf")));			
		} catch(IOException | FontFormatException e) {
			TF2Font = new Font("Arial", Font.PLAIN, 17);
		}
		
		classes = new ArrayList<String>(Arrays.asList("Scout", "Soldier", "Pyro", "Demoman", "Heavy", "Engineer", "Medic", "Sniper", "Spy"));
		powers = new ArrayList<String>(Arrays.asList("Trash", "Bad", "Normal", "Good", "Broken"));
		
		setTitle("TF2 Weapon Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(36, 32, 27));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 0, 286, 741);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblClass = new JLabel("Select the class:");
		lblClass.setForeground(new Color(240, 240, 240));
		//lblClass.setFont(new Font("TF2 Build", Font.PLAIN, 17));
		lblClass.setFont(new Font("TF2 Build", Font.PLAIN, 17));
		lblClass.setBounds(34, 37, 166, 22);
		panel.add(lblClass);
		
		JLabel lblSlot = new JLabel("Select the slot:");
		lblSlot.setForeground(new Color(240, 240, 240));
		lblSlot.setFont(new Font("TF2 Build", Font.PLAIN, 17));
		lblSlot.setBounds(34, 131, 166, 22);
		panel.add(lblSlot);
		
		JComboBox<String> comboClasses = new JComboBox<>();
		comboClasses.setBounds(42, 62, 156, 22);
		comboClasses.addItem("ANY");
		for(String s : classes) {
			comboClasses.addItem(s);
		}
		panel.add(comboClasses);
		
		JComboBox<String> comboSlot = new JComboBox<>();
		comboSlot.setBounds(42, 156, 156, 22);
		comboSlot.addItem("ANY");
		comboSlot.addItem("Primary");
		comboSlot.addItem("Secondary");
		comboSlot.addItem("Melee");
		comboSlot.addItem("Special");
		panel.add(comboSlot);
		
		JButton bttnGenerate = new JButton("Generate");
		bttnGenerate.setFont(new Font("TF2 Build", Font.PLAIN, 22));
		bttnGenerate.setBounds(46, 650, 194, 49);
		panel.add(bttnGenerate);
		
		JLabel lblNStats = new JLabel("<html>Select how many stats you want</html>");
		lblNStats.setHorizontalAlignment(SwingConstants.LEFT);
		lblNStats.setVerticalAlignment(SwingConstants.TOP);
		lblNStats.setForeground(new Color(240, 240, 240));
		lblNStats.setFont(new Font("TF2 Build", Font.PLAIN, 15));
		lblNStats.setBounds(34, 365, 216, 49);
		panel.add(lblNStats);
		
		JLabel lblPositive = new JLabel("Positive");
		lblPositive.setForeground(new Color(153, 204, 255));
		lblPositive.setFont(new Font("TF2 Build", Font.PLAIN, 17));
		lblPositive.setBounds(34, 409, 96, 22);
		panel.add(lblPositive);
		
		JLabel lblNegative = new JLabel("Negative");
		lblNegative.setForeground(new Color(255, 64, 64));
		lblNegative.setFont(new Font("TF2 Build", Font.PLAIN, 17));
		lblNegative.setBounds(170, 409, 96, 22);
		panel.add(lblNegative);
		
		JComboBox<String> comboPositive = new JComboBox<>();
		comboPositive.setBounds(34, 435, 82, 22);
		comboPositive.addItem("ANY");
		for(int i = 1; i <= 5; i++) {
			comboPositive.addItem(Integer.valueOf(i).toString());
		}
		panel.add(comboPositive);
		
		JComboBox<String> comboNegative = new JComboBox<>();
		comboNegative.setBounds(170, 435, 82, 22);
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
		lblSelectThePower.setBounds(35, 520, 216, 22);
		panel.add(lblSelectThePower);
		
		JComboBox<String> comboPower = new JComboBox<String>();
		comboPower.setBounds(65, 544, 156, 22);
		for(String s : powers) {
			comboPower.addItem(s);
		}
		comboPower.setSelectedIndex(2);
		panel.add(comboPower);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(296, 0, 438, 741);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel imgEmblem = new JLabel("");
		imgEmblem.setIcon(new ImageIcon(Window.class.getResource("/img/Pyro.png")));
		imgEmblem.setBounds(313, 234, 64, 64);
		panel_1.add(imgEmblem);
		
		JLabel imgWeapon = new JLabel("");
		imgWeapon.setIcon(new ImageIcon(Window.class.getResource("/img/Sword.png")));
		imgWeapon.setBounds(91, 21, 256, 256);
		panel_1.add(imgWeapon);
		
		JLabel lblWeaponTitle = new JLabel("<html><center>New rocket launcher for the soldier</center></html>");
		lblWeaponTitle.setVerticalAlignment(SwingConstants.TOP);
		lblWeaponTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeaponTitle.setForeground(new Color(255, 215, 0));
		lblWeaponTitle.setFont(new Font("TF2 Build", Font.PLAIN, 17));
		lblWeaponTitle.setBounds(74, 309, 290, 36);
		panel_1.add(lblWeaponTitle);
		
		JLabel imgWeapon_1 = new JLabel("");
		imgWeapon_1.setIcon(new ImageIcon(Window.class.getResource("/img/fondo.png")));
		imgWeapon_1.setBounds(86, 16, 266, 266);
		panel_1.add(imgWeapon_1);
		
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
				imgEmblem.setIcon(new ImageIcon(Window.class.getResource("/img/"+claseSel+".png")));
				lblWeaponTitle.setText("<html><center>New "+wep+" for the "+claseSel+"</center></html>");
			}
		});

	}
	
	String armaEnSlot(String clase, String slot) {
		ArrayList<String> armasPosibles = new ArrayList<>();
		
		switch (clase) {
		case "Scout":
			if(slot == "ANY" || slot == "Primary"){
				armasPosibles.add("Scattergun");
			}
			if(slot == "ANY" || slot == "Secondary"){
				armasPosibles.add("Pistol");
			}
			if(slot == "ANY" || slot == "Melee"){
				armasPosibles.add("Bat");
			}
			break;
		case "Soldier":
			if(slot == "ANY" || slot == "Primary"){
				armasPosibles.add("Rocket Launcher");
			}
			if(slot == "ANY" || slot == "Secondary"){
				armasPosibles.add("Shotgun");
				armasPosibles.add("Banner");
			}
			if(slot == "ANY" || slot == "Melee"){
				armasPosibles.add("Shovel");
			}
			break;
		case "Pyro":
			if(slot == "ANY" || slot == "Primary"){
				armasPosibles.add("Flame Thrower");
			}
			if(slot == "ANY" || slot == "Secondary"){
				armasPosibles.add("Shotgun");
			}
			if(slot == "ANY" || slot == "Melee"){
				armasPosibles.add("Fire Axe");
			}
			break;
		case "Demoman":
			if(slot == "ANY" || slot == "Primary"){
				armasPosibles.add("Grenade Launcher");
			}
			if(slot == "ANY" || slot == "Secondary"){
				armasPosibles.add("Stickybomb Launcher");
				armasPosibles.add("Shield");
			}
			if(slot == "ANY" || slot == "Melee"){
				armasPosibles.add("Bottle");
				armasPosibles.add("Sword");
			}
			break;
		case "Heavy":
			if(slot == "ANY" || slot == "Primary"){
				armasPosibles.add("Minigun");
			}
			if(slot == "ANY" || slot == "Secondary"){
				armasPosibles.add("Shotgun");
			}
			break;
		case "Engineer":
			if(slot == "ANY" || slot == "Primary"){
				armasPosibles.add("Shotgun");
			}
			if(slot == "ANY" || slot == "Secondary"){
				armasPosibles.add("Pistol");
			}
			break;
		case "Medic":
			if(slot == "ANY" || slot == "Primary"){
				armasPosibles.add("Syringe Gun");
			}
			if(slot == "ANY" || slot == "Secondary"){
				armasPosibles.add("Medigun");
			}
			if(slot == "ANY" || slot == "Melee"){
				armasPosibles.add("Bonesaw");
			}
			break;
		case "Sniper":
			if(slot == "ANY" || slot == "Primary"){
				armasPosibles.add("Sniper Rifle");
			}
			if(slot == "ANY" || slot == "Secondary"){
				armasPosibles.add("SMG");
			}
			if(slot == "ANY" || slot == "Melee"){
				armasPosibles.add("Kukri");
			}
			break;
		case "Spy":
			if(slot == "ANY" || slot == "Primary") {
				armasPosibles.add("Revolver");
			}
			if(slot == "ANY" || slot == "Secondary") {
				armasPosibles.add("Sapper");
			}
			if(slot == "ANY" || slot == "Melee") {
				armasPosibles.add("Knife");
			}
			break;
		}
		
		Random rand = new Random();
		System.out.print(armasPosibles.size()+"\n\n");
		int randomIndex = rand.nextInt(armasPosibles.size());
		
		return armasPosibles.get(randomIndex);
	}
}
