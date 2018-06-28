package swing.exemplos;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 * Classe de exemplo para aprendizagem sobre o componente JFrame.
 * @author Fabio Dela Bruna.
 * @since 18/10/2008.
 */
public class ExemploJFrame extends JFrame {

	private static final long serialVersionUID = 1L;


	/**
	 * Construtor default.
	 */
	public ExemploJFrame() {
		super ("Exemplo JFrame");
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Dimension screamSize = Toolkit.getDefaultToolkit().getScreenSize(); // --> pega o tamanho da tela.
		this.setSize( (int)screamSize.getWidth(), (int)screamSize.getHeight() );
		this.setResizable(false);
		this.setIconImage( new ImageIcon("images/windows.gif").getImage());
	}
	
	
	/**
	 * Método principal para testar o exemplo.
	 * @param args
	 */
	public static void main(String[] args) {
		
		ExemploJFrame app = new ExemploJFrame();
		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
