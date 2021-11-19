package threads;

class MyThread extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread " + getName() + " : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Threads_Example1 {

	public static void main(String[] args) {
		MyThread thread_A = new MyThread();
		thread_A.setName("A");

		MyThread thread_B = new MyThread();
		thread_B.setName("B");

		/*
		 * Yes we override the run() method, but we don't call it, we call the start
		 * function. This doesn't start the thread: 
		 * thread_A.run(); 
		 * thread_B.run();
		 */
		thread_A.start();
		thread_B.start();
	}

}
