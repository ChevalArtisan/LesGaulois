package personnages;

public class Romain {
	
	
	private String nom;
	private int force;
	private Equipement[] equipements= new Equipement[2];
	private int nbEquipement=0;
	
	public Romain(String nom, int force) {
	this.nom = nom;
	this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
	System.out.println(prendreParole() + "� " + texte + "�");
	}
	
	private String prendreParole() {
	return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
	force -= forceCoup;
	if (force > 0) {
		parler("A�e");
		}
	else {
		parler("J'abandonne...");
		}
	}
	
	public void sEquiper(Equipement equipement) {
		if (nbEquipement<2){
			switch (equipement) 
			{		
				case CASQUE :
					if (equipements[0].toString()=="casque" || equipements[1].toString()=="casque")
					{
						System.out.println("Le soldat"+nom+" possède dejà un");
					}
					else {
						equipements[nbEquipement]= equipement;;
						nbEquipement+=1;
						System.out.println("Le soldat"+nom+"s'equipe d'un casque");
					}
					break;
				case BOUCLIER:
					if (equipements[0].toString()=="bouclier" || equipements[1].toString()=="bouclier")
					{
						System.out.println("Le soldat"+nom+" possède dejà un");
					}
					else {
						equipements[nbEquipement]= equipement;;
						nbEquipement+=1;
						System.out.println("Le soldat"+nom+"s'equipe d'un bouclier");
					}
					break;
					
				default:
					break;
			}
		}
		else 
			{ 
			System.out.println("Le soldat"+nom+" est déjà bien protégé !");}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		
		//Test prendreParole
		System.out.println(minus.prendreParole());
		
		//Test parler
		minus.parler("Bonjour");
		
		//Test frapper
		minus.recevoirCoup(2);
		minus.recevoirCoup(1000);
		
		//Test sEquiper
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
