package collections.etudiants;

public class Etudiant {
	String code;
	String nom;
	String prenom;
	String adresse;
	String classe;
	String dateNaissance;

	public Etudiant() {
	}

	public Etudiant(String code, String nom, String prenom, String adresse, String classe, String dateNaissance) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.classe = classe;
		this.dateNaissance = dateNaissance;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return (code + " " + nom + " " + prenom + " habite à " + adresse + " étudie à " + classe);
	}

}
