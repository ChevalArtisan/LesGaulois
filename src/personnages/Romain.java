package personnages;

public class Romain {
	
	
	private String nom;
	private int force;
	private Equipement[] equipements= new Equipement[2];
	private int nbEquipement=0;
	private String texte;
	
	public Romain(String nom, int force) {
	this.nom = nom;
	this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
	System.out.println(prendreParole() + "ï¿½ " + texte + "ï¿½");
	}
	
	private String prendreParole() {
	return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//	force -= forceCoup;
//	if (force > 0) {
//		parler("Aï¿½e");
//		}
//	else {
//		parler("J'abandonne...");
//		}
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
			case 0:
				parler("Aïe");
			default:
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
				break;
				}
			// post condition la force à diminuer
		assert force < oldForce;
		return equipementEjecte;
		}
	
	
	
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null &&
					equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
					}
					i++;
				}
				texte =+ resistanceEquipement + "!";
			}
			parler(texte);
			forceCoup -= resistanceEquipement;
			return forceCoup;
		}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "s envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] =equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				}
			}
			return equipementEjecte;
		}

	public void sEquiper(Equipement equipement) {
			switch (nbEquipement) 
			{		
				case 0 :
					equipements[0]=equipement;
					System.out.println("Le soldat "+nom+" s'equipe d'un "+equipement.toString());
					nbEquipement=1;
					break;
				case 1:
					if (equipements[0].toString()==equipement.toString())
					{
						System.out.println("Le soldat "+nom+" possede deja  un "+equipement.toString());
					}
					else {
						equipements[1]= equipement;;
						nbEquipement=2;
						System.out.println("Le soldat "+nom+" s'equipe d'un "+equipement.toString());
					}
					break;
					
				default:
					System.out.println("Le soldat "+nom+" est déjà bien protégé");
					break;
			}		
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
