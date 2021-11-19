package threads;

/*
 * This example is very similar to the AfficheStyle & GenerateHtml example...
 * 
 */


class Orateur implements Runnable {

	String nomOrateur;
	String discours;
	Megaphone megaphone;

	public Orateur(String nomOrateur, String discours, Megaphone megaphone) {
		this.nomOrateur = nomOrateur;
		this.discours = discours;
		this.megaphone = megaphone;
	}

	@Override
	public void run() {
		megaphone.parler(this);
	}

	public String getNomOrateur() {
		return nomOrateur;
	}

	public String getDiscours() {
		return discours;
	}
}

class Megaphone {

	synchronized void parler(Orateur o) {
		System.err.println("Le mégaphone est actuellement utilisé par: " + o.getNomOrateur());
		System.out.println(o.getNomOrateur() + " dit: " + o.getDiscours());
		System.err.println(o.getNomOrateur() + " a terminé son discours!");
	}
}

public class Threads_Example5 {

	public static void main(String[] args) {

		Megaphone megaphone = new Megaphone();

		Orateur orateur1 = new Orateur("Hicham", "Hello world, I'm Hicham!", megaphone);
		Orateur orateur2 = new Orateur("Mohamed", "Hello world I'm Mohamed!", megaphone);
		Orateur orateur3 = new Orateur("Mehdi", "Hello world from Mehdi!", megaphone);
		Orateur orateur4 = new Orateur("Amine", "Hello world, Amine!", megaphone);

		new Thread(orateur1).start();
		new Thread(orateur2).start();
		new Thread(orateur3).start();
		new Thread(orateur4).start();

	}

}
