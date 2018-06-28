package messenger.test;

import javax.swing.JFrame;
import javax.swing.UIManager;

import messenger.server.Servidor;

/**
 * Classe para testar o aplicativo servidor.
 * @author Fabio Dela Bruna
 */
public class ServidorTeste {

	/**
	 * Método principal da classe SevidorTeste.
	 */
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			// UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");
		} catch (Exception e) {
			
		}
		
		Servidor app = new Servidor(); // cria o servidor.
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.runServer(); // executa o aplicativo servidor.
		
	}
}
