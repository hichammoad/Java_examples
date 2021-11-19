package threads;
import java.util.Scanner;

public class Threads_Example2 {
	
	public static void main(String[] args) {
		
		// Simple thread that waits for the user to type in their name and then print it.
		Thread askForName = new Thread() {
			public void run() {
				Scanner scanner = new Scanner(System.in);
				System.out.println("What's your name?");
				String nom = scanner.nextLine();
				scanner.close();
				System.out.println("Your name is "+nom);
				System.out.println("Well done! quitting the app...");
				System.exit(0);
			};
		};
		
	
		// countdown thread:
		Thread counter = new Thread() {
			public void run() {
				try {
					int i = 20;
					while( i != 0) {
						Thread.sleep(1000);
						i--;
						System.out.println("Il vous reste: "+i+" seconds!");
					}
					System.out.println("Time's up!");
					System.out.println("Quitting the app...");
					System.exit(1);
				} catch (InterruptedException e) { e.printStackTrace();}
			};
		};
		
		
		askForName.start();
		counter.start();
		
	}
	
	
}
