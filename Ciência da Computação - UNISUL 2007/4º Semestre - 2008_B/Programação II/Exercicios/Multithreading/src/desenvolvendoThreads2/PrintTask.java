package desenvolvendoThreads2;
import java.util.Random;


/**
 * Classe PrintTask dorme por um tempo aleatório de 0 a 5 segundos.
 * @author Fabio Dela Bruna
 */
public class PrintTask implements Runnable {
	
	private int sleepTime; // tempo de adormecimento aleatório para a thread.
	private String threadName; // nome da thread.
	private static Random generator = new Random();
	
	
	// construtor da classe PrintTask.
	public PrintTask(String name) {
		threadName = name; // configura o nome da thread.
		sleepTime = generator.nextInt(5000); // seleciona tempo de adormecimento aleatório entre 0 a 5 segundos.
	}
	
	
	// mpetodo run é o código a ser executado pela nova thread.
	public void run() {
		
		try {
			
			System.out.printf("%s going to sleep for %d milliseconds.\n",
					threadName, sleepTime);
			
			Thread.sleep(sleepTime); // coloca a thread para dormir.
			
		} catch (InterruptedException ie) {
			ie.printStackTrace(); // se a threa for interrompida enquanto dormia, imprime o rastreamento da pilha.
		}
		
		
		System.out.printf("%s done sleeping\n", threadName); // imprime o nome da thread.

	}

}
