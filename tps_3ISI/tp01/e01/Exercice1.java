package tps_3ISI.tp01.e01;

public class Exercice1 {
	public static void main(String[] args) {
		boolean resultat;
		Compte_Bancaire c1 = new Compte_Bancaire("10", "Alaoui", 1000);
		c1.afficherCompte();
		
		resultat = c1.crediter(300);
		
		if (resultat) {
			System.out.println("Opération bien effectuée!");
		} else {
			System.err.println("Opération échouée!");
		}

		c1.debiter(500);
		
		if (resultat) {
			System.out.println("Opération bien effectuée!");
		} else {
			System.err.println("Opération échouée!");
		}
		c1.afficherCompte();
	}
}
