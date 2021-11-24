package threads;

/*
 * 
 * Nous souhaitons écrire un programme calculant la somme des entiers de 1 à N à l’aide de M threads.  
 * Chaque thread calculera la somme d’un sous-ensemble de ces entiers et la somme globale sera obtenue
 *  en calculant la somme des résultats intermédiaires de chaque thread.
 * Les entiers sont répartis uniformément entre les threads comme suit (exemple avec 3 threads) :
 * Thread 1 : 1, 4, 7, . . .
 * Thread 2 : 2, 5, 8, . . .
 * Thread 3 : 3, 6, 9, . . .
 * Le programme doit lancer M threads, attendre qu’ils se terminent, faire la somme des résultats intermédiaires et afficher le résultat. 
 */

class sumIntegers extends Thread {

	private int N;
	private int M; // nombre des threads == saut
	private int start;
	private int somme;

	public sumIntegers(int start, int N, int M) {
		this.start = start;
		this.M = M;
		this.N = N;
	}

	public int getSomme() {
		return somme;
	}

	public void afficherNombresATraiter() {
		System.out.print("Hello, I am thread " + start + " I am going to sum: ");
		for (int i = start; i <= N; i += M) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	@Override
	public void run() {
		// System.err.println("Starting thread "+start);
		for (int i = start; i <= N; i += M) {
			somme += i;
		}
		/*
		 * try { sleep(3000); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		// System.out.println("End of thread "+start);
	}
}

public class Threads_Example6_sumIntegers {

	public static void main(String[] args) throws InterruptedException {

		int N = 100;
		int M = 10; // 10 threads
		int sommeGlobale = 0;

		// table of threads:
		sumIntegers[] myThreads = new sumIntegers[M];

		for (int i = 0; i < M; i++) {
			myThreads[i] = new sumIntegers(i, N, M);
			myThreads[i].afficherNombresATraiter();
			myThreads[i].start();
		}

		for (int i = 0; i < M; i++) {
			myThreads[i].join();
		}

		for (int i = 0; i < M; i++) {
			sommeGlobale += myThreads[i].getSomme();
		}

		System.out.println("La somme est: " + sommeGlobale);

	}

}
