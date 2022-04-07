package tps_3ISI.tp04.e01;

public class Personne {
	int num;
	String nom;
	String email;

	public Personne() {
		// TODO Auto-generated constructor stub
	}

	public Personne(int num, String nom, String email) {
		this.num = num;
		this.nom = nom;
		this.email = email;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
