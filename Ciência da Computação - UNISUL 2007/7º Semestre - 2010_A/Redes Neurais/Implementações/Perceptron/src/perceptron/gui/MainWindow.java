package perceptron.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import perceptron.Perceptron;


/**
 * Classe que representa a interface gráfica do usuário (GUI).
 * @author Fabio Dela Bruna
 */
public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton buttonIniciarAprendizado;
	private JButton buttonTestarRede;
	private JTextArea textArea;
	private Perceptron perceptron;
	
	
	/**
	 * Construtor da classe.
	 */
	public MainWindow() {
	
		perceptron = new Perceptron();
		initComponents();
		
	}
	
	
	/**
	 * Monta todos os componentes da interface gráfica.
	 */
	private void initComponents() {
		
		setTitle( "Redes Neurais - Perceptron" );
		setSize(365, 400);
		
		Font f = new Font( Font.SANS_SERIF, Font.BOLD+Font.ITALIC, 16 );
		
		
		buttonIniciarAprendizado = new JButton( "Iniciar Aprendizado" );
		buttonIniciarAprendizado.setFont( f );
		buttonIniciarAprendizado.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						iniciaAprendizado();
						textArea.setText( atualizaTextArea() );
						textArea.setSelectionStart(0);  // pequena gambiarra para o scroll panel 
						textArea.setSelectionEnd(1);    // não ir pro final. 
						buttonTestarRede.requestFocus();
					}
				}
		);
		
		
		buttonTestarRede = new JButton( "Testar Rede" );
		buttonTestarRede.setFont( f );
		buttonTestarRede.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						testarRede();
					}
				}
		);

		
		textArea = new JTextArea( atualizaTextArea() );
		textArea.setEditable( false );
		textArea.setOpaque( false );
		textArea.setTabSize( 6 );

		JScrollPane scroll = new JScrollPane( textArea );
		scroll.setBorder( BorderFactory.createTitledBorder( " Matriz de Pesos " ) );
		
		JPanel centerPanel = new JPanel();
		centerPanel.add( buttonIniciarAprendizado );
		centerPanel.add( buttonTestarRede );
		
		
		getContentPane().add( centerPanel, BorderLayout.NORTH );
		getContentPane().add( scroll, BorderLayout.CENTER );
		
    	
		// Posiciona a janela no centro da tela.
		int screenX = ( int ) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenY = ( int ) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		int frameX = ( int ) getSize().getWidth();
		int frameY = ( int ) getSize().getHeight();

		setLocation(
				( int )( screenX / 2 ) - ( frameX / 2 ),
				( int )( screenY / 2 ) - ( frameY / 2 )
		);
		//.
		
		
	}
	
	
	/**
	 * Chama o método da classe perceptron.Perceptron
	 * para iniciar o aprendizado da rede neural.
	 */
	private void iniciaAprendizado() {
		
		try {
			perceptron.iniciaAprendizado();
			JOptionPane.showMessageDialog( this , new JLabel( "Aprendizado da rede concluído com sucesso.", SwingConstants.CENTER ),
					"Sucesso!", JOptionPane.PLAIN_MESSAGE );
		} catch ( IOException e ) {
			JOptionPane.showMessageDialog( this , e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE );
		}
		
	}
	
	
	/**
	 * Chama o método da classe perceptron.Perceptron
	 * para testar a rede neural com um arquivo de teste.
	 */
	private void testarRede() {
		
		File arquivo = null;
		
		JFileChooser chooser = new JFileChooser( "arquivos/testes" );
		chooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
		
		int chooserResult = chooser.showOpenDialog( this );

		if ( chooserResult == JFileChooser.CANCEL_OPTION ) {
			return;
		} else {
			arquivo = chooser.getSelectedFile();	
		}
		
		try {
			
			int testResult = perceptron.testarRede( arquivo );
			
			if ( testResult != -1 ) {
				String letraReconhecida = verificaLetraReconhecida( testResult );
				JOptionPane.showMessageDialog( this , new JLabel( String.format( "Letra  \"%s\"  foi reconhecida com sucesso.", letraReconhecida ),
						SwingConstants.CENTER ), "Sucesso!", JOptionPane.PLAIN_MESSAGE );
			} else {
				JOptionPane.showMessageDialog( this , "Letra não reconhecida.", "Erro!", JOptionPane.ERROR_MESSAGE );
			}
			
		} catch ( IOException e ) {
			JOptionPane.showMessageDialog( this , e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE );
		}
			
		
	}
	
	

	/**
	 * Verifica qual letra foi reconhecida de acordo
	 * com o resultado do teste da rede.
	 */
	private String verificaLetraReconhecida( int i ) {
		if ( i == 0 ) {
			return "A";
		} else if ( i == 1 ) {
			return "B";
		} else if ( i == 2 ) {
			return "C";
		} else if ( i == 3 ) {
			return "D";
		} else if ( i == 4 ) {
			return "E";
		} else if ( i == 5 ) {
			return "J";
		} else {
			return "K";
		}
	}
	
	
	/**
	 * Atualiza a matriz de pesos.
	 */
	private String atualizaTextArea() {
		int[][] W = perceptron.getMatrizPesos();
		String pesos = "";
		for (int i = 0; i < W.length; i++) {
			for (int j = 0; j < W[i].length; j++) {
				String aux = "";
				if ( W[i][j] >= 0 ) aux = " " + W[i][j];
				else aux = W[i][j]+"";
				
				if ( j != W[i].length-1 ) pesos += ( aux + "\t" );
				else pesos += ( aux + "\n");
			}
		}
		return pesos;
	}
	
	
}
