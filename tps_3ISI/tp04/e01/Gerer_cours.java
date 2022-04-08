package tps_3ISI.tp04.e01;

public class Gerer_cours {
	Cours cours[];

	public Gerer_cours(int taille) {
		cours = new Cours[taille];
	}

	public boolean ajouterCorus(Cours c) {
		for (int i = 0; i < cours.length; i++) {
			if (cours[i] == null) {
				cours[i] = c;
				return true;
			}
		}
		return false;
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
		for (int i = 0; i < cours.length; i++) {
			if (cours[i].getId().contentEquals(code)) {
				cours[i] = null;
				return true;
			}
		}
		return false;
	}

	public int getRealSize() {
		int nombre = 0;
		for (Cours c : cours) {
			if (c != null) {
				nombre++;
			}
		}
		return nombre;
	}

	public Cours[] listeCours() {
		Cours lesCours[] = new Cours[getRealSize()];
		int k = 0;
		for (Cours c : cours) {
			if (c != null) {
				lesCours[k++] = c;
			}
		}
		return lesCours;
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
		Gerer_cours gestionCours = new Gerer_cours(5);
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
