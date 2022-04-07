package tps_3ISI.tp01.e01;

public class Compte_Bancaire {
	private String numero;
	private String nom;
	private double sold;
	private double minSold;
	private double maxSold;

	public Compte_Bancaire(String numero, String nom) {
		this(numero, nom, 0, -800, 1000);
	}

	public Compte_Bancaire(String numero, String nom, double sold) {
		this(numero, nom, sold, 0, 0);
	}

	public Compte_Bancaire(String numero, String nom, double sold, double minSold, double maxSold) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.sold = sold;
		this.minSold = minSold;
		this.maxSold = maxSold;
	}

	public void afficherCompte() {
		System.out.println("Numero: " + numero + " Nom: " + nom + " solde: " + sold);
	}

	public boolean crediter(double valeur) {
		if (sold < 0)
			return false;
		if (sold + valeur > minSold) {
			return false;
		} else {
			sold += valeur;
			return true;
		}
	}

	public boolean debiter(double valeur) {
		if (sold < 0)
			return false;
		if (sold - valeur < maxSold) {
			return false;
		} else {
			sold -= valeur;
			return true;
		}
	}

}
