package desenvolvendoThreads2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Impressão de múltiplas threads em diferentes intervalos.
 * @author Fabio Dela Bruna
 */
public class RunnableTester {

	public static void main(String[] args) {
		
		// cria e nomeia cada executável
		PrintTask task1 = new PrintTask("thread1");
		PrintTask task2 = new PrintTask("thread2");
		PrintTask task3 = new PrintTask("thread3");
		
		System.out.println("Starting threads");
		
		
		// cria ExecutorService para gerenciar threads.
		ExecutorService threadExecutor = Executors.newFixedThreadPool(3);
		
		// inicia threads e as coloca no estado executável.
		threadExecutor.execute(task1); // inicia task1.
		threadExecutor.execute(task2); // inicia task2.
		threadExecutor.execute(task3); // inicia task3.
		
		
		threadExecutor.shutdown(); // encerra as threads trabalhadoras.
		
		System.out.println("Threads started, main ends\n");
	}
}
