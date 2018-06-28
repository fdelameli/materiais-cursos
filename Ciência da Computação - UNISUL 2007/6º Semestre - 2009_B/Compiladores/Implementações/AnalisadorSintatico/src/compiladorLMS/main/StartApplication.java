package compiladorLMS.main;

import javax.swing.JFrame;
import javax.swing.UIManager;

import compiladorLMS.gui.FramePrincipal;

/**
 * Classe principal que inicializa a aplicação.
 * @author Fabio Dela Bruna - mailto:fabiodelabruna@hotmail.com
 * @author Márcio Ozório Teixeira - mailto:marcio_jagua@hotmail.com
 */
public class StartApplication {

	public static void main( String[] args ) {
			
		 
		try {
		
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		
		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}
		
		FramePrincipal app = new FramePrincipal();
		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		app.setVisible( true );
		app.setFocusTextArea();
	
	}
	
}
