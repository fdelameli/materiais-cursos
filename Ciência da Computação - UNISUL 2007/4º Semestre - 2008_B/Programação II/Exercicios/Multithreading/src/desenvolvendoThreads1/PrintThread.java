package desenvolvendoThreads1;

/**
 * Classe exemplo para aprendizagem sobre Threads.
 * @author Fabio Dela Bruna
 */
public class PrintThread extends Thread {

	private int sleepTime;
	
	
	/**
	 * Construtor da Classe.
	 * @param name Nome que será atribuído à Thread.
	 */
	public PrintThread(String name) {
		super(name);
		
		// Define o tempo de adormecimento entre 0 e 5 segundos.
		sleepTime = (int) (Math.random() * 15000);
		
		System.out.println("Name: " + getName() +
				"\tSleep: " + sleepTime + "\n");
	}
	
	
	@Override
	public void run() {

		try {
			System.out.println(getName() + " está indo dormir.");
			Thread.sleep(sleepTime);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		System.out.println(getName() + " foi dormir.");
	}
	
	
	
	
}
