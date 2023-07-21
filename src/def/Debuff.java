package def;

public class Debuff {
	private int weight;
	
	private String debuff;
	private String stat;
	
	private String texto1;
	private String txtBuff;
	private String txtBuff2 = "";
	
	public Debuff(String DET) {
		debuff = DET;
		setDebuff();
	}
	
	private void setDebuff() {
		switch(debuff) {
		case "MarkedForDeath":
			txtBuff = "Marks-For-Death the enemy for ";
			break;
		case "Jarate":
			txtBuff = "Apply Jarate for ";
			break;
		case "Mad Milk":
			txtBuff = "Apply Mad Milk for ";
			break;
		case "Fire":
			txtBuff = "Ignites the target for ";
			break;
		case "Bleed":
			txtBuff = "Causes bleed for ";
			break;
		case "Slow":
			txtBuff = "Slows the target for ";
			break;
		case "Gas":
			txtBuff = "Apply Gas Passer for ";
			break;
		case "Scare":
			txtBuff = "Scares the enemy for ";
			break;
		}
	}
	
	private void setAction() {
		switch(stat) {
		case "SniperRifle":
			texto1 = "On Scoped Hit: ";
			txtBuff2 = " to ";
			break;
		case "RevolverHeadshot":
			texto1 = "On Headshot: ";
			break;
		case "ScattergunAllShot":
			texto1 = "If All Bullets Connect: ";
			break;
		case "Sandman":
			texto1 = "Alt-Fire: Launches a ball that ";
			sandmanText();
			break;
		}
	}
	
	private void sandmanText() {
		switch(debuff) {
		case "MarkedForDeath":
			txtBuff = "Marks-For-Death opponents for up to ";
			break;
		case "Jarate":
			txtBuff = "applies Jarate to opponents for up to ";
			break;
		case "Mad Milk":
			txtBuff = "applies Mad Milk to opponents for up to ";
			break;
		case "Fire":
			txtBuff = "ignites opponents for up to ";
			break;
		case "Bleed":
			txtBuff = "causes bleed to opponents for up to ";
			break;
		case "Slow":
			txtBuff = "slows opponents for up to ";
			break;
		case "Gas":
			txtBuff = "applies Gas Passer to opponents for up to ";
			break;
		case "Scare":
			txtBuff = "slows opponents on short and medium range shots, and stuns them on long shots for up to ";
			break;
		}
	}
	
	public void setPeso(int w) {
		weight = w;
	}
	
	public void setStat(String s) {
		stat = s;
		setAction();
	}
	
	public int getPeso() {
		return weight;
	}
	
	public String getTexto1() {
		return texto1 + txtBuff;
	}
	
	public String getTexto2() {
		return txtBuff2;
	}
}
