package tps_3ISI.tp04.e01;

public class Gerer_cours_method2 {
	Cours cours[] = new Cours[0];
	private Cours[] copy = new Cours[0];

	/*
	 * public Gerer_cours_method2() { }
	 */
	public void ajouterCorus(Cours c) {
		copy = new Cours[cours.length + 1];
		for (int i = 0; i < cours.length; i++) {
			copy[i] = cours[i];
		}
		copy[cours.length] = c;
		cours = copy;
	}

	public Cours getCours(String code) {
		for (Cours c : cours) {
			if (c.getId().equals(code)) {
				return c;
			}
		}
		return null;
	}

	public boolean supprimerCours(String code) {
		// on suppose que le cours existe toujours dans la liste!
		copy = new Cours[cours.length - 1];
		int k = 0;
		for (int i = 0; i < cours.length; i++) {
			if (!cours[i].getId().equals(code)) {
				copy[k++] = cours[i];
			}
		}
		cours = copy;
		return true;
	}

	public int getRealSize() {
		/*int nombre = 0;
		for (Cours c : cours) {
			if (c != null) {
				nombre++;
			}
		}
		return nombre;*/
		return cours.length;
	}

	public Cours[] listeCours() {
		/*Cours lesCours[] = new Cours[getRealSize()];
		int k = 0;
		for (Cours c : cours) {
			if (c != null) {
				lesCours[k++] = c;
			}
		}
		return lesCours;
		*/
		return cours;
	}

	public void modifierCours(Cours newCours) {
		for (int i = 0; i < cours.length; i++) {
			if (cours[i].getId().equals(newCours.getId())) {
				cours[i] = newCours;
				break;
			}
		}
	}

	public void afficherCours() {
		System.out.println("**************");
		for (Cours c : listeCours()) {
			System.out.println(c);
		}
		System.out.println("**************");
	}

	public Cours plusDeCharge() {
		Cours maxCharge = cours[0];
		for (Cours c : listeCours()) {
			maxCharge = maxCharge.compareTo(c);
		}
		return maxCharge;
	}

	public static void main(String[] args) {
		Gerer_cours_method2 gestionCours = new Gerer_cours_method2();
		gestionCours.ajouterCorus(new Cours("1", "Réseaux", "ISI", 3, 36));
		gestionCours.ajouterCorus(new Cours("2", "SE", "ISI", 3, 36));
		gestionCours.ajouterCorus(new Cours("3", "Anglais", "ISI", 3, 24));
		gestionCours.ajouterCorus(new Cours("4", "Java", "ISI", 3, 48));
		gestionCours.ajouterCorus(new Cours("5", "Francais", "ISI", 3, 36));
		gestionCours.ajouterCorus(new Cours("6", "C++", "ISI", 3, 36));

		System.out.println(gestionCours.getRealSize());

		gestionCours.afficherCours();

		Cours aCours = new Cours("4", "Programmation Java", "ISI", 3, 48);

		gestionCours.modifierCours(aCours);

		gestionCours.afficherCours();

		gestionCours.supprimerCours("3");

		gestionCours.afficherCours();

		Cours aPlusDeCharge = gestionCours.plusDeCharge();
		System.out.println(aPlusDeCharge);

	}

}
