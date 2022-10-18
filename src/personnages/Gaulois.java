package personnages;

public class Gaulois {
	
	private String nom;
	private int effetPotion=1;
	private int force, nb_trophees;
	private Equipement trophees[] = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}


	public void parler(String texte) {
		System.out.println(prendreParole()+"<<"+ texte+">>");
	}
	
//	public String prendreParole() {
//		return "Le Gaulois"+nom+":";
//	}
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
		}

	
//	public void frapper(Romain romain) {
//		System.out.println(nom+ "envoie un grand coup dans la mâchoire de " 
//				+ romain.getNom());
//		romain.recevoirCoup((force/3)*effetPotion);
//	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) *
		effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
		return;
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
		parler("Merci Druide, je sens que ma force est "+forcePotion+ " fois décuplée." );
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
	Gaulois asterix = new Gaulois("Astérix",8);
	System.out.println(asterix);
	
	//Test prendreParole
	System.out.println(asterix.prendreParole());
	
	//Test parler
	asterix.parler("Bonjour");
	
	//Test frapper
	Romain testRomain = new Romain("Test",6);
	asterix.frapper(testRomain);
	
	//Test boirePotion
	Romain testRomain2 = new Romain("Test",6);
	asterix.boirePotion(10);
	asterix.frapper(testRomain2);
	}
}
