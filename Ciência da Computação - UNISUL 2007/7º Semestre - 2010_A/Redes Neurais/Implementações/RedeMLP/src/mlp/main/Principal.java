package mlp.main;

import javax.swing.JFrame;
import javax.swing.UIManager;

import mlp.gui.JanelaPrincipal;

/**
 * Classe principal do sistema.
 * @author Fabio Dela Bruna
 */
public class Principal {

	public static void main( String[] args ) {


		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		JanelaPrincipal app = new JanelaPrincipal();
		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		app.setVisible( true );

		
		// try {
		//
		// Backpropagation backp = new Backpropagation(
		// "pv.mlp", // arquivo de pesos V
		// "pw.mlp", // arquivo de pesos W
		// 0.6, // taxa de aprendizado
		// 18125, // neurôn ios da camada de entrada
		// 215, // nerônios da camada intermediária
		// 5, // neurônios da camanda de saída
		// Constants.t, // target
		// 500, // número de épocas
		// "arquivos/treinamento" // pasta contendo os arquivos de treinamento
		// );
		// backp.treinar();
		//
		// Backpropagation backp = new Backpropagation( "pv.mlp", "pw.mlp", 18125, 200, 5 );
		// backp.testar( new File( "arquivos/testes/A_TESTE.png" ) );
		// backp.testar( new File( "arquivos/testes/H_TESTE.png" ) );
		// backp.testar( new File( "arquivos/testes/L_TESTE.png" ) );
		// backp.testar( new File( "arquivos/testes/M_TESTE.png" ) );
		// backp.testar( new File( "arquivos/testes/S_TESTE.png" ) );
		// backp.testar( new File( "arquivos/testes/T_TESTE.png" ) );
		// backp.testar( new File( "arquivos/testes/V_TESTE.png" ) );
		// backp.testar( new File( "arquivos/testes/W_TESTE.png" ) );
		// backp.testar( new File( "arquivos/testes/X_TESTE.png" ) );
		// backp.testar( new File( "arquivos/testes/teste.png" ) );
		//
		// } catch ( IOException e ) {
		// e.printStackTrace();
		// }

	}
}
