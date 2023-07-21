package def;

public class Buff {
	private int weight;
	
	private String buff;
	private String stat;
	
	private String texto1;
	private String txtBuff;
	private String txtBuff2 = "";
	
	public Buff(String DET) {
		buff = DET;
		setBuff();
	}
	
	private void setBuff() {
		switch(buff) {
		case "Megaheal":
			txtBuff = "User gains health regeneration for ";
			break;
		case "Crit":
			txtBuff = "User becomes crit boosted for ";
			break;
		case "Minicrit":
			txtBuff = "User becomes Mini-crit boosted for ";
			break;
		case "Heal":
			txtBuff = "User gains +";
			txtBuff2 = " health";
			break;
		case "Speedboost":
			txtBuff = "User gains a speed boost for ";
			break;
		case "FireSpeed":
			txtBuff = "User gains a firing speed boost for ";
			break;
		case "DamageRes":
			txtBuff = "User gains +";
			txtBuff2 = "% damage resistance for ";
			break;
		case "FireRes":
			txtBuff = "User gains +";
			txtBuff2 = "% fire damage resistance for ";
			break;
		case "ExpRes":
			txtBuff = "User gains +";
			txtBuff2 = "% explosive damage resistance for ";
			break;
		case "BullRes":
			txtBuff = "User gains +";
			txtBuff2 = "% bullet damage resistance for ";
			break;
		case "MeleeRes":
			txtBuff = "User gains +";
			txtBuff2 = "% melee damage resistance for ";
			break;
		}
	}
	
	private void setAction() {
		switch(stat) {
		case "SapperApplied":
			texto1 = "On Sapper placed: ";
			break;
		case "SapperComplete":
			texto1 = "On building destroyed: ";
			break;
		case "SapperRemoved":
			texto1 = "On sapper removed: ";
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
