import javax.swing.UIManager;


/**
 * Classe Principal do Prograama.
 * @author Fabio Dela Bruna, Marcio Ozorio Teixeira.
 */
public class Main {

    /**
     * Método Principal, utilizado para inicializar o sistema.
     */
    public static void main(String[] args) {
    	
    	try {
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	} catch (Exception e) {	}
    	
    	JFramePrincipal janelaPricipal = new JFramePrincipal();
        janelaPricipal.setVisible(true);
    
    }
    
}
