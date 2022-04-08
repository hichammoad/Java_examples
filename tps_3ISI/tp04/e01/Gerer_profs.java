package tps_3ISI.tp04.e01;

public class Gerer_profs {
	Professeur lesProfs[];

	public Gerer_profs(int taille) {
		lesProfs = new Professeur[taille];
	}

	public boolean ajouterProf(Professeur p) {
		for (int i = 0; i < lesProfs.length; i++) {
			if (lesProfs[i] == null) {
				lesProfs[i] = p;
				return true;
			}
		}
		return false;
	}

	public Professeur getProfs(int code) {
		for (Professeur p : lesProfs) {
			if (p.getNum() == code) {
				return p;
			}
		}
		return null;
	}

	public boolean supprimerProf(int code) {
		for (int i = 0; i < lesProfs.length; i++) {
			if (lesProfs[i].getNum() == code) {
				lesProfs[i] = null;
				return true;
			}
		}
		return false;
	}

	public int getRealSize() {
		int nombre = 0;
		for (Professeur p : lesProfs) {
			if (p != null) {
				nombre++;
			}
		}
		return nombre;
	}

	public Professeur[] listeProfs() {
		Professeur listeProfs[] = new Professeur[getRealSize()];
		int k = 0;
		for (Professeur p : lesProfs) {
			if (p != null) {
				listeProfs[k++] = p;
			}
		}
		return listeProfs;
	}

	public void modifierProf(Professeur newProf) {
		for (int i = 0; i < lesProfs.length; i++) {
			if (lesProfs[i].getNum() == newProf.getNum()) {
				lesProfs[i] = newProf;
				break;
			}
		}
	}

	public void afficherProfs() {
		System.out.println("**************");
		for (Professeur p : listeProfs()) {
			System.out.println(p);
		}
		System.out.println("**************");
	}

	public Professeur plusDeCours() {
		Professeur maxCharge = lesProfs[0];
		for (Professeur p : listeProfs()) {
			maxCharge = maxCharge.compareTo(p);
		}
		return maxCharge;
	}

	public Professeur plusDeCharge() {
		Professeur maxCharge = lesProfs[0];
		for (Professeur p : listeProfs()) {
			maxCharge = maxCharge.compareToCharge(p);
		}
		return maxCharge;
	}

	public static void main(String[] args) {
		Gerer_profs gestionProfs = new Gerer_profs(5);

		Cours liste1[] = { new Cours("1", "Java", "ISI", 3, 24), new Cours("2", "BD", "ISI", 4, 24),
				new Cours("3", "AI", "ISI", 5, 24) };

		Professeur p1 = new Professeur(1, "Safhi", "moad.safhi@isga.ma", liste1);
		gestionProfs.ajouterProf(p1);

		Cours liste2[] = { new Cours("4", "Réseaux", "ISI", 3, 48), new Cours("5", "BD", "SE", 4, 48) };

		Professeur p2 = new Professeur(1, "Moad", "moad@isga.ma", liste2);
		gestionProfs.ajouterProf(p2);

		System.out.println(gestionProfs.getRealSize());

		gestionProfs.afficherProfs();

		Professeur aPlusDeCours = gestionProfs.plusDeCours();
		System.out.println(aPlusDeCours);

		Professeur aPlusDeCharge = gestionProfs.plusDeCharge();
		System.out.println(aPlusDeCharge);

	}

}
