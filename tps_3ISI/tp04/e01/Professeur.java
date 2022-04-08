package tps_3ISI.tp04.e01;

public class Professeur extends Personne {

	Cours[] listeCoures;

	public Professeur() {
		// TODO Auto-generated constructor stub
	}

	public Professeur(int num, String nom, String email, Cours[] listeCoures) {
		super(num, nom, email);
		// TODO Auto-generated constructor stub
		this.listeCoures = listeCoures;
	}

	public Cours[] getListeCoures() {
		return listeCoures;
	}

	public void setListeCoures(Cours[] listeCoures) {
		this.listeCoures = listeCoures;
	}

	// professeur qui a plus de modules:
	public Professeur compareTo(Professeur p) {
		int nombreCours1 = 0;
		int nombreCours2 = 0;

		for (Cours c : this.listeCoures) {
			if (c != null) {
				nombreCours1++;
			}
		}

		for (Cours c : p.listeCoures) {
			if (c != null) {
				nombreCours2++;
			}
		}

		if (nombreCours1 > nombreCours2) {
			return this;
		} else {
			return p;
		}

	}

	// professeur qui a plus de nombre d'heures:
	public Professeur compareToCharge(Professeur p) {
		int nombreHeures1 = 0;
		int nombreHeures2 = 0;

		for (Cours c : this.listeCoures) {
			if (c != null) {
				nombreHeures1 += c.nbHeures;
			}
		}

		for (Cours c : p.listeCoures) {
			if (c != null) {
				nombreHeures2 += c.nbHeures;
			}
		}

		if (nombreHeures1 > nombreHeures2) {
			return this;
		} else {
			return p;
		}

	}

	@Override
	public String toString() {
		return num + " " + nom;
	}

}
