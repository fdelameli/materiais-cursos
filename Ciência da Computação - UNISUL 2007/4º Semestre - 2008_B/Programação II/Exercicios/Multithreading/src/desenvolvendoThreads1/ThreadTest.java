package desenvolvendoThreads1;

/**
 * Classe principal para testar o funcionamento da Thread.
 * @author Fabio Dela Bruna
 */
public class ThreadTest {

	
	public static void main(String[] args) {
		
		PrintThread thread1, thread2, thread3, thread4;
		
		thread1 = new PrintThread("Thread1");
		thread2 = new PrintThread("Thread2");
		thread3 = new PrintThread("Thread3");
		thread4 = new PrintThread("Thread4");
		
		System.out.println("Iniciando as threads...");
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		
		System.out.println("Threads iniciadas.");
	}
}
