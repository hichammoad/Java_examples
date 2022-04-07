package tps_3ISI.tp04.e01;

public class Cours {
	String id;
	String intitule;
	String filiere;
	int niveau;
	int nbHeures;

	public Cours() {
		// TODO Auto-generated constructor stub
	}

	public Cours(String id, String intitule, String filiere, int niveau, int nbHeures) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.filiere = filiere;
		this.niveau = niveau;
		this.nbHeures = nbHeures;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
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

	public int getNbHeures() {
		return nbHeures;
	}

	public void setNbHeures(int nbHeures) {
		this.nbHeures = nbHeures;
	}

}
