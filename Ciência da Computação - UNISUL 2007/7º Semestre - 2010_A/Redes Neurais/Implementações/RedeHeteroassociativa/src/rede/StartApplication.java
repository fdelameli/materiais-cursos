package rede;
import javax.swing.JFrame;
import javax.swing.UIManager;

import rede.gui.MainWindow;

/**
 * Classe principal. Contém o método main utilizado para inicializar a aplicação.
 * @author Fabio Dela Bruna
 */
public class StartApplication {

	
	public static void main( String[] args ) {
		
		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		} catch ( Exception e) {
			System.err.println( e.getMessage() );
		}
		
		MainWindow app = new MainWindow();
		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		app.setVisible( true );
		
	}
	
	
}
