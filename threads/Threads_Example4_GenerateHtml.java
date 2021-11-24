package threads;

// in other projects, we add the "synchronized" keyword to the function 
// but we don't always have access to functions source code
// In this case, we can use a synchronized block when calling this function

class AfficheStyle {
	void addH1(String msg) {
		System.out.print("<h1>" + msg);
		// simulate a task that takes time:
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("</h1>");
	}
}

class GenerateHTML implements Runnable {
	String text;
	AfficheStyle afficheStyle;

	public GenerateHTML(String text, AfficheStyle afficheStyle) {
		this.text = text;
		this.afficheStyle = afficheStyle;
	}

	@Override
	public void run() {

		synchronized ("") {
			afficheStyle.addH1(text);
		}

		System.err.println("Thread " + text + " is doing other task..");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("Thread " + text + " ended");

	}

}

public class Threads_Example4_GenerateHtml {

	public static void main(String[] args) {

		AfficheStyle afficheStyle = new AfficheStyle();

		GenerateHTML titre1 = new GenerateHTML("Titre 1", afficheStyle);
		GenerateHTML titre2 = new GenerateHTML("Titre 2", afficheStyle);
		GenerateHTML titre3 = new GenerateHTML("Titre 3", afficheStyle);

		new Thread(titre1).start();
		new Thread(titre2).start();
		new Thread(titre3).start();

	}

}
