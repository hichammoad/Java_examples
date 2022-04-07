package tps_3ISI.tp02.e03;

public class Tasse {
	Liquide liquide;

	public void ajouterLiquide(Liquide li) {
		this.liquide = li;
	}

	public void imprimer() {
		this.liquide.imprimer();
	}
}
