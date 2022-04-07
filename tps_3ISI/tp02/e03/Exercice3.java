package tps_3ISI.tp02.e03;

public class Exercice3 {
	public static void main(String[] args) {
		Tasse[] tasses = new Tasse[3];
		tasses[0] = new Tasse();
		tasses[0].ajouterLiquide(new Liquide());

		tasses[1] = new Tasse();
		tasses[1].ajouterLiquide(new Cafe());

		tasses[2] = new Tasse();
		tasses[2].ajouterLiquide(new Lait());

		for (int i = 0; i < 3; i++) {
			tasses[i].imprimer();
		}

	}
}
