import javax.swing.UIManager;


public class TestandoTeste {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			
		}
		
		Teste teste = new Teste();
		teste.mostraTela();
	}
}
