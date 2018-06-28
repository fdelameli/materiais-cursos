import javax.swing.UIManager;
import javax.swing.WindowConstants;


/**
 * Classe principal do programa. Contém o método Main que inicializa o sistema.
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira
 */
public class Main {
	
	
	/**
	 * Método inicializador do sistema. Apenas cria uma 
	 * instância da Classe ... onde está a interface.
	 */
	public static void main(String[] args) {
		
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		JanelaPrincipal gui = new JanelaPrincipal();
		gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		gui.setVisible(true);

		
	}
	

}
