package threads;

public class Threads_Example3_sumTable {

	// find the sum of elements of an array:
	public static int sumTable(int tab[]) {
		int s = 0;
		for (int i = 0; i < tab.length; i++) {
			s += tab[i];
		}
		return s;
	}

	// class thread that call's the sumTable function
	static class SumTableThread extends Thread {
		private int[] tab;
		private int sum;

		@Override
		public void run() {
			this.sum = sumTable(tab);
		}

		public SumTableThread(int[] tab) {
			this.tab = tab;
			/*
			 * this.tab= new int[tab.length]; for(int i=0; i<tab.length; i++) {
			 * this.tab[i]=tab[i]; }
			 */
		}

		public int getSum() {
			return sum;
		}

	}

	public static void main(String[] args) throws InterruptedException {

		// Sum of array elements:
		// int[] tab = {1,2,3,4,5,6,7,8,9,10};
		int[] largeTable = new int[100000000];
		// initialize largeTable values:
		for (int i = 0; i < largeTable.length; i++) {
			largeTable[i] = ((int) Math.round(Math.random() * 100));
		}

		// to get elapsed time:
		long start = System.currentTimeMillis();

		int sum = sumTable(largeTable);
		System.out.println("Somme element is: " + sum);

		long end = System.currentTimeMillis();
		System.out.println("elapsedTime = " + (end - start));

		// dividing the array in half: (we can also divide it into multiple parts)
		int[] part1 = new int[largeTable.length / 2];
		int[] part2 = new int[largeTable.length / 2];

		System.arraycopy(largeTable, 0, part1, 0, part1.length);
		System.arraycopy(largeTable, part1.length, part2, 0, part2.length);

//		int sum1 = sumTable(part1);
//		int sum2 = sumTable(part2);
//		System.out.println("Somme element is: "+(sum1+sum2));

		start = System.currentTimeMillis();

		// using threads:
		SumTableThread thread1 = new SumTableThread(part1);
		SumTableThread thread2 = new SumTableThread(part2);

		thread1.start();
		thread2.start();

		// Current thread (main) should wait for the other threads.
		// ensures that thread1 and thread2 are finished before the program does print
		// the final sum
		thread1.join();
		thread2.join();

		System.out.println("Threads sum is : " + (thread1.getSum() + thread2.getSum()));

		end = System.currentTimeMillis();
		System.out.println("elapsedTime = " + (end - start));

	}

}
