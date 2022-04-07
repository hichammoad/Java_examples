package tps_3ISI.tp04.e01;

public class Etudiant extends Personne {
	String filiere;
	int niveau;

	public Etudiant(int num, String nom, String email) {
		super(num, nom, email);
		// TODO Auto-generated constructor stub
	}

	public Etudiant() {
		// TODO Auto-generated constructor stub
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
}
