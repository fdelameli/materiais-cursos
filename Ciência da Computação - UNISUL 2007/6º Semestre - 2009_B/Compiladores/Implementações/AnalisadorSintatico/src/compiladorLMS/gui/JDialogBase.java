package compiladorLMS.gui;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Classe que extends de javax.swing.JDialog.
 * Utilizada como base para todos os jDialogs da aplicação.
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira.
 */
public class JDialogBase extends JDialog {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor default da classe.
	 */
	public JDialogBase() {
		setIconImage( new ImageIcon( "icons/icon1.gif" ).getImage() ); // seta ícone para jDialog
		setResizable( false ); // não permite aumentar ou diminuir o tamanho do jDialog 
	}
	
	
	/**
	 * Construtor com parâmetros da classe.
	 */
	public JDialogBase( JFrame parent ) {
		setIconImage( new ImageIcon( "icons/icon1.gif" ).getImage() ); // seta ícone para jDialog
		setResizable( false ); // não permite aumentar ou diminuir o tamanho do jDialog

		// centraliza o objeto na tela
    	setLocation(
            	(int)parent.getX() + (parent.getWidth()/2) - (getWidth()/2), 
            	(int)parent.getY() + (parent.getHeight()/2) - (getHeight()/2)
            );
	}

}
