package art.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import art.RedeART1;
import art.RedeART2;

/**
 * Classe que representa a interface gráfica do usuário (GUI).
 * @author Fabio Dela Bruna
 */
public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton buttonIniciarAprendizadoRede1;
	private JButton buttonIniciarAprendizadoRede2;
	private JButton buttonTestarRedeART1;
	private JButton buttonTestarRedeART2;
	private RedeART1 art1;
	private RedeART2 art2;

	/**
	 * Construtor da classe.
	 */
	public MainWindow() {
		initComponents();
	}

	/**
	 * Monta todos os componentes da interface gráfica.
	 */
	private void initComponents() {

		setTitle( "Redes Neurais - Redes ART" );
		setSize( 555, 400 );

		Font f = new Font( Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 16 );

		buttonIniciarAprendizadoRede1 = new JButton( "Treinar Rede ART 1" );
		buttonIniciarAprendizadoRede1.setToolTipText( "Rede ART com 10 clusters e parâmetro de vigilângia 0.3" );
		buttonIniciarAprendizadoRede1.setFont( f );
		buttonIniciarAprendizadoRede1.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				art1 = new RedeART1();
				iniciaAprendizadoART1();
				buttonTestarRedeART1.requestFocus();
			}
		} );

		buttonIniciarAprendizadoRede2 = new JButton( "Treinar Rede ART 2" );
		buttonIniciarAprendizadoRede2.setToolTipText( "Rede ART com 15 clusters e parâmetro de vigilância 0.7" );
		buttonIniciarAprendizadoRede2.setFont( f );
		buttonIniciarAprendizadoRede2.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				art2 = new RedeART2();
				iniciaAprendizadoART2();
				buttonTestarRedeART2.requestFocus();
			}
		} );


		buttonTestarRedeART1 = new JButton( "Testar Rede ART 1" );
		buttonTestarRedeART1.setToolTipText( "Testa a rede ART 1" );
		buttonTestarRedeART1.setFont( f );
		buttonTestarRedeART1.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				testarRede( e );
			}
		} );

		buttonTestarRedeART2 = new JButton( "Testar Rede ART 2" );
		buttonTestarRedeART2.setToolTipText( "Testa a rede ART 2" );
		buttonTestarRedeART2.setFont( f );
		buttonTestarRedeART2.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				testarRede( e );
			}
		} );

		JPanel leftPanel = new JPanel( new BorderLayout() );
		leftPanel.add( buttonIniciarAprendizadoRede1, BorderLayout.NORTH );
		leftPanel.add( buttonTestarRedeART1, BorderLayout.SOUTH );


		JPanel rightPanel = new JPanel( new BorderLayout() );
		rightPanel.add( buttonIniciarAprendizadoRede2, BorderLayout.NORTH );
		rightPanel.add( buttonTestarRedeART2, BorderLayout.SOUTH );


		JPanel centerPanel = new JPanel();
		centerPanel.add( leftPanel, BorderLayout.EAST );
		centerPanel.add( rightPanel, BorderLayout.WEST );

		getContentPane().add( centerPanel, BorderLayout.CENTER );

		// Posiciona a janela no centro da tela.
		int screenX = (int ) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenY = (int ) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		int frameX = (int ) getSize().getWidth();
		int frameY = (int ) getSize().getHeight();

		setLocation( (int ) ( screenX / 2 ) - ( frameX / 2 ), (int ) ( screenY / 2 ) - ( frameY / 2 ) );
		// .

		pack();
	}

	/**
	 * Chama o método da classe art.RedeART1 para iniciar o
	 * aprendizado da rede.
	 */
	private void iniciaAprendizadoART1() {
		try {
			art1.treinaRede();
			JOptionPane.showMessageDialog( this, new JLabel(
					"Treinamento da rede concluído com sucesso.",
					SwingConstants.CENTER ), "Sucesso!",
					JOptionPane.PLAIN_MESSAGE );
		} catch ( IOException e ) {
			JOptionPane.showMessageDialog( this, e.getMessage(), "Erro!",
					JOptionPane.ERROR_MESSAGE );
		}
	}

	/**
	 * Chama o método da classe art.RedeART2 para iniciar o
	 * aprendizado da rede.
	 */
	private void iniciaAprendizadoART2() {
		try {
			art2.treinaRede();
			JOptionPane.showMessageDialog( this, new JLabel(
					"Treinamento da rede concluído com sucesso.",
					SwingConstants.CENTER ), "Sucesso!",
					JOptionPane.PLAIN_MESSAGE );
		} catch ( IOException e ) {
			JOptionPane.showMessageDialog( this, e.getMessage(), "Erro!",
					JOptionPane.ERROR_MESSAGE );
		}
	}


	/**
	 * Método para testar a rede com os arquivos de teste.
	 */
	private void testarRede( ActionEvent e ) {

		File[] arquivos = new File( "arquivos/testes" ).listFiles();
		String result = "";

		try {

			if ( e.getSource() == buttonTestarRedeART1 ) {
				result = art1.testaRede( arquivos );
			} else if ( e.getSource() == buttonTestarRedeART2 ) {
				result = art2.testaRede( arquivos );
			}

		} catch ( IOException ioe ) {
			JOptionPane.showMessageDialog( this, ioe.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE );
		}

		JOptionPane.showMessageDialog( this, result, "Resultado", JOptionPane.PLAIN_MESSAGE );

	}

}
