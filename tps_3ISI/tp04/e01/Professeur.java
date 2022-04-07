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

}
