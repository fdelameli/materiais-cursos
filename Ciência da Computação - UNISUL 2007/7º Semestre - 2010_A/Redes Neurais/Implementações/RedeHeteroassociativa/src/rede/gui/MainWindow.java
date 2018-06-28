package rede.gui;

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

import rede.Constants;
import rede.RedeHeteroassociativa;


/**
 * Classe que representa a interface gráfica do usuário (GUI).
 * @author Fabio Dela Bruna
 */
public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton buttonIniciarAprendizado;
	private JButton buttonTestarRede;
	private JTextArea textArea;
	private RedeHeteroassociativa rede;
	private EntradaGUI entr;
	private SaidaGUI saida;
	
	
	/**
	 * Construtor da classe.
	 */
	public MainWindow() {
	
		rede = new RedeHeteroassociativa();
		initComponents();
		
	}
	
	
	/**
	 * Monta todos os componentes da interface gráfica.
	 */
	private void initComponents() {
		
		setTitle( "Redes Neurais - Rede Heteroassociativa" );
		setSize(520, 400);
		
		Font f = new Font( Font.SANS_SERIF, Font.BOLD+Font.ITALIC, 16 );
		Font f2 = new Font( Font.MONOSPACED, Font.BOLD, 14 );
		
		
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
		textArea.setTabSize( 4 );
		textArea.setFont( f2 );

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
	 * Chama o método da classe rede.RedeHeteroassociativa
	 * para iniciar o aprendizado da rede.
	 */
	private void iniciaAprendizado() {
		
		try {
			rede.treinarRede();
			JOptionPane.showMessageDialog( this , new JLabel( "Treinamento da rede concluído com sucesso.", SwingConstants.CENTER ),
					"Sucesso!", JOptionPane.PLAIN_MESSAGE );
		} catch ( IOException e ) {
			JOptionPane.showMessageDialog( this , e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE );
		}
		
	}
	
	
	/**
	 * Chama o método da classe rede.RedeHeteroassociativa
	 * para testar a rede neural com um arquivo de teste.
	 */
	private void testarRede() {
		
		if ( entr != null ) { entr.dispose(); }
		if ( saida != null ) { saida.dispose(); }
		
		File arquivo = null;
		
		JFileChooser chooser = new JFileChooser( "arquivos/testes" );
		chooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
		chooser.setApproveButtonText("Abrir");
		chooser.setDialogTitle("Abrir arquivo");
		
		int chooserResult = chooser.showOpenDialog( this );

		if ( chooserResult == JFileChooser.CANCEL_OPTION ) {
			return;
		} else {
			arquivo = chooser.getSelectedFile();	
		}
		
		try {
			
			// exibe Diálogo com a letra escolhida.
			entr = new EntradaGUI( arquivo, this );
			entr.setVisible( true );
			
			int[][] testResult = rede.testarRede( arquivo );
			String letraReconhecida = verificaLetraReconhecida( testResult );
			
			if ( letraReconhecida == null ) {
			
				JOptionPane.showMessageDialog( this , "Letra não reconhecida.", "Erro!", JOptionPane.ERROR_MESSAGE );
				
			} else if ( testResult != null ) {

				saida = new SaidaGUI( letraReconhecida, this );
				saida.setVisible( true );
						
				JOptionPane.showMessageDialog( this , new JLabel( 
						String.format( "Letra  \"%s\"  foi reconhecida com sucesso.", letraReconhecida ),
						SwingConstants.CENTER ), "Sucesso!", JOptionPane.PLAIN_MESSAGE );
				
			} else {
				JOptionPane.showMessageDialog( this , "Letra não reconhecida.", "Erro!", JOptionPane.ERROR_MESSAGE );
			}
			
		} catch ( IOException e ) {
			System.out.println("Entrou na exception");
			JOptionPane.showMessageDialog( this , e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE );
		}
			
		
	}
	
	

	/**
	 * Verifica qual letra foi reconhecida de acordo
	 * com o resultado do teste da rede.
	 */
	private String verificaLetraReconhecida( int[][] matriz  ) {
		if ( getStringFromMatriz( matriz ).equals( Constants.A ) ) {
			return "A";
		} else if ( getStringFromMatriz( matriz ).equals( Constants.B ) ) {
			return "B";
		} else if ( getStringFromMatriz( matriz ).equals( Constants.C ) ) {
			return "C";
		} else {
			return null;
		}
	}
	
	
	/**
	 * Transforma uma matriz de inteiros em uma sequencio numa String.
	 */
	private String getStringFromMatriz( int[][] matriz ) {
		String retorno = "";
		for ( int i = 0; i < matriz.length; i++ ) {
			for ( int j = 0; j < matriz[i].length; j++ ) {
				retorno += matriz[ i ][ j ];
			}
		}
		return retorno;
	}
	
	
	
	/**
	 * Atualiza a matriz de pesos.
	 */
	private String atualizaTextArea() {
		int[][] W = rede.getMatrizPesos();
		String pesos = "";
		for ( int i = 0; i < W.length; i++ ) {
			for ( int j = 0; j < W[i].length; j++ ) {
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
