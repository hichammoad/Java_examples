package collections.personnes;

import java.util.HashMap;
import java.util.Map;

class Personne {
	private int num;
	private String nom;
	private String prenom;

	public Personne() {
	}

	public Personne(int num, String nom, String prenom) {
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNomPrenom() {
		return (nom + "-" + prenom);
	}

	@Override
	public String toString() {
		return nom.toUpperCase() + " " + prenom.toUpperCase();
	}
}

public class GestionPersonnes {

	public static void main(String[] args) {

		Personne p1 = new Personne(1, "Safhi", "Moad Hicham");
		Personne p2 = new Personne(1, "Alami", "Zakaria");
		Personne p3 = new Personne(1, "Ben", "Rachid");
		Personne p4 = new Personne(1, "Ben", "Bilal");

		Map<String, Personne> personnes = new HashMap<>();
		personnes.put(p1.getNomPrenom(), p1);
		personnes.put(p2.getNomPrenom(), p2);
		personnes.put(p3.getNomPrenom(), p3);
		personnes.put(p4.getNomPrenom(), p4);

		for (String key : personnes.keySet()) {
			System.out.println("key= " + key + " value= " + personnes.get(key));
		}

	}

}
