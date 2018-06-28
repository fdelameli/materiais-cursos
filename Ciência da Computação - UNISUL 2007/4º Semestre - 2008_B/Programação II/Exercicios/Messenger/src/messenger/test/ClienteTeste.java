package messenger.test;

import javax.swing.JFrame;
import javax.swing.UIManager;

import messenger.client.Cliente;

/**
 * Classe para testar a aplicação Cliente.
 * @author Fabio Dela Bruna
 */
public class ClienteTeste {

	/**
	 * Método principal da classe.
	 */
	public static void main( String[] args ) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			// UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");
		} catch (Exception e) {
			
		}
		
		Cliente app = new Cliente();
		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		app.runClient();

		
	}
}
