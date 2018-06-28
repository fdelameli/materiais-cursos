package art.main;


import javax.swing.JFrame;
import javax.swing.UIManager;

import art.gui.MainWindow;


/**
 * Inicializa a aplicação.
 * @author Fabio Dela Bruna.
 */
public class StartApplication {

	public static void main( String[] args ) {

		try {

			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );

		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
			e.printStackTrace();
		}

		MainWindow app = new MainWindow();
		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		app.setVisible( true );

	}

}
