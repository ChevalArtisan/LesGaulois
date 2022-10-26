package personnages;

public class Musee {
	private Trophee[] tableau=new Trophee[200];
	private int nbTrophee=0;
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		tableau[nbTrophee]=new Trophee(gaulois, equipement);
		nbTrophee+=1;
	}
	public String extraireInstructionsCaml() {
		
		String ral =System.getProperty("line.separator" );
		String texte= "let musee= ["+ral;
		for(int i=0;i<nbTrophee;i++) {
			texte+=tableau[i].donnerNom()+", "+tableau[i].getEquipement().toString()+ral;
		}
		
		return texte+ral+"]";
	}
	
}
