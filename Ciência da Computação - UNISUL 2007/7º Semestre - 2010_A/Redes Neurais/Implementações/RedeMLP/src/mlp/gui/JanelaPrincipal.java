package mlp.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import mlp.Backpropagation;
import mlp.util.Constants;


/**
 * Classe que implementa a janela principal da aplicação.
 * @author Fabio Dela Bruna.
 */
public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private TreinarRedeGUI treinarGui;
	private TestarRedeGUI testarGui;
	private JDesktopPane desktopPane;


	public JanelaPrincipal() {
		super( "MLP Backpropagation - Reconhecimento de letras" );
		setSize( Toolkit.getDefaultToolkit().getScreenSize() );
		setResizable( false );

		JMenuBar menuBar = new JMenuBar();

		// ///////////////////////////////////////////////////

		JMenu menuArquivo = new JMenu();
		menuArquivo.setText( "Arquivo" );

		JMenuItem menuItemSair = new JMenuItem();
		menuItemSair.setText( "Sair" );
		menuItemSair.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {
				exit();
			}
		} );

		menuArquivo.add( menuItemSair );

		// ///////////////////////////////////////////////////

		JMenu menuRede = new JMenu();
		menuRede.setText( "Rede" );

		JMenuItem menuItemTreinar = new JMenuItem();
		menuItemTreinar.setText( "Treinar Rede" );
		menuItemTreinar.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {
				treinaRede();
			}
		} );

		JMenuItem menuItemTestar = new JMenuItem();
		menuItemTestar.setText( "TestarRede" );
		menuItemTestar.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {
				testarRede();
			}
		} );

		menuRede.add( menuItemTreinar );
		menuRede.add( menuItemTestar );

		menuBar.add( menuArquivo );
		menuBar.add( menuRede );
		setJMenuBar( menuBar );

		getContentPane().add( desktopPane = new JDesktopPane(), BorderLayout.CENTER );

		// Exibe enquanto carrega pesos.
		JDialog loadingDialog = new JDialog();
		JLabel loadingLabel = new JLabel( "   Aguarde, carregando pesos..." );
		loadingLabel.setLocation( 10, 10 );
		loadingLabel.setSize( 160, 70 );
		loadingDialog.add( loadingLabel );
		loadingDialog.setTitle( "Carregando pesos..." );
		loadingDialog.setSize( 200, 100 );
		loadingDialog.setLocation(
				Toolkit.getDefaultToolkit().getScreenSize().width / 2 - ( loadingDialog.getBounds().width / 2 ),
				Toolkit.getDefaultToolkit().getScreenSize().height / 2 - ( loadingDialog.getBounds().height / 2 ) );
		loadingDialog.setVisible( true );
		setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
		Constants.backp = new Backpropagation( Constants.filePVDefault, Constants.filePWDefault,
				Constants.qtdNeurEntrada, Constants.qtdNeurOculta, Constants.qtdNeurSaida );
		loadingDialog.dispose();
		setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );

	}

	/**
	 * Chama a tela onde será possível desenhar uma
	 * letra e fazer o teste da rede.
	 */
	private void testarRede() {
		if ( testarGui != null )
			testarGui.dispose();
		testarGui = new TestarRedeGUI();
		testarGui.setVisible( true );
		desktopPane.add( testarGui );
	}

	/**
	 * Chama o uma tela onde é possível especificar os parâmetros
	 * necessários para efetuar o treinamento da rede.
	 */
	private void treinaRede() {
		if ( treinarGui == null ) {
			treinarGui = new TreinarRedeGUI();
		} else {
			testarGui.toFront();
		}
	}

	/**
	 * Fecha o sistema.
	 */
	private void exit() {
		System.exit( 0 );
	}

}
