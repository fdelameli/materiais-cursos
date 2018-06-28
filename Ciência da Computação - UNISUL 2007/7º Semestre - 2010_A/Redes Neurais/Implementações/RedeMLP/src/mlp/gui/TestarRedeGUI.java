package mlp.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import mlp.util.Constants;


/**
 * Classe que implementa a janela principal da aplicação.
 * @author Fabio Dela Bruna.
 */
public class TestarRedeGUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel label;
	private JTextArea textArea;
	private JButton btTestar;

	public TestarRedeGUI() {
		super( "MLP Backpropagation - TESTE DA REDE" );
		setLayout( null );
		setSize( 350, 400 );
		setClosable( true );

		painel = new DrawPanel();
		painel.setLocation( 10, 20 );
		painel.setSize( 125, 145 );

		// Painel com borda que contém o painel de desenho e o botão para testar.
		JPanel borderPanelDes = new JPanel();
		borderPanelDes.setLayout( null );
		borderPanelDes.setBorder( BorderFactory.createTitledBorder( "Desenho da letra" ) );
		borderPanelDes.setSize( 145, 215 );
		borderPanelDes.setLocation( 15, 15 );

		borderPanelDes.add( painel );

		btTestar = new JButton( "Testar Imagem" );
		btTestar.setBounds( 10, 175, 125, 25 );
		btTestar.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {
				saveJPanel( new File( "teste.png" ), painel );
				try {
					double[] result = Constants.backp.testar( new File( Constants.fileTestName ) );
					double[] temp = new double[ result.length ];
					String resultLabel = "";
					String resultFormatedLabel = "";
					for ( int i = 0; i < result.length; i++ ) {
						resultLabel += String.format( "%.4f\t", result[ i ] );
						if ( result[ i ] >= Constants.limiar ) {
							resultFormatedLabel += String.format( "%d\t", 1 );
							temp[ i ] = 1;
						} else {
							resultFormatedLabel += String.format( "%d\t", 0 );
							temp[ i ] = 0;
						}

					}
					for ( int i = 0; i < Constants.t.length; i++ ) {
						if ( Arrays.equals( temp, Constants.t[ i ] ) ) {
							verificaLetraReconhecida( i );
							break;
						}

					}
					textArea.setText( String.format( "%s\n%s\n\n%s\n%s", "Resultado da rede: ", resultLabel, "Resultado formatado: ", resultFormatedLabel ) );

				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
		borderPanelDes.add( btTestar );

		// //////////////////////////////////////////////////

		// Painel de resultado do teste.
		JPanel painelResult = new JPanel();
		painelResult.setLayout( null );
		painelResult.setLocation( 10, 20 );
		painelResult.setSize( 125, 145 );
		painelResult.setBackground( Color.WHITE );

		label = new JLabel( "", SwingConstants.CENTER );
		label.setFont( new Font( "Calibri", Font.PLAIN, 185 ) );
		label.setLocation( 0, 15 );
		label.setSize( 125, 145 );
		painelResult.add( label );
		

		// Painel com borda que contém o painel onde será mostrada a letra reconhecida.
		JPanel borderPanelRes = new JPanel();
		borderPanelRes.setLayout( null );
		borderPanelRes.setBorder( BorderFactory.createTitledBorder( "Resultado" ) );
		borderPanelRes.setSize( 145, 215 );
		borderPanelRes.setLocation( 175, 15 );

		borderPanelRes.add( painelResult );

		// //////////////////////////////////////////////////

		Font f2 = new Font( Font.MONOSPACED, Font.BOLD, 14 );

		textArea = new JTextArea();
		textArea.setOpaque( false );
		textArea.setFont( f2 );
		textArea.setLocation( 15, 250 );
		textArea.setSize( 310, 100 );


		getContentPane().add( borderPanelDes );
		getContentPane().add( borderPanelRes );
		getContentPane().add( textArea );


	}

	/**
	 * Método para gravar em uma imagem o conteudo de um painel.
	 * @param f Arquivo onde a imagem será gravada.
	 * @param panel Painel contendo a imagem a ser gravada.
	 */
	private void saveJPanel( File f, JPanel panel ) {
		try {
			BufferedImage img = new
					BufferedImage( panel.getWidth(),
							panel.getHeight(),
							BufferedImage.TYPE_INT_RGB );

			Graphics g = img.getGraphics();
			panel.paint( g );

			ImageIO.write( img, "png", f );

		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}


	/**
	 * Método que verifica qual a letra reconhecida para apresentar na tela.
	 */
	private void verificaLetraReconhecida( int i ) {
		switch ( i ) {
			case 0:
				label.setText( "A" );
				break;
			case 1:
				label.setText( "B" );
				break;
			case 2:
				label.setText( "C" );
				break;
			case 3:
				label.setText( "D" );
				break;
			case 4:
				label.setText( "E" );
				break;
			case 5:
				label.setText( "F" );
				break;
			case 6:
				label.setText( "G" );
				break;
			case 7:
				label.setText( "H" );
				break;
			case 8:
				label.setText( "I" );
				break;
			case 9:
				label.setText( "J" );
				break;
			case 10:
				label.setText( "K" );
				break;
			case 11:
				label.setText( "L" );
				break;
			case 12:
				label.setText( "M" );
				break;
			case 13:
				label.setText( "N" );
				break;
			case 14:
				label.setText( "O" );
				break;
			case 15:
				label.setText( "P" );
				break;
			case 16:
				label.setText( "Q" );
				break;
			case 17:
				label.setText( "R" );
				break;
			case 18:
				label.setText( "S" );
				break;
			case 19:
				label.setText( "T" );
				break;
			case 20:
				label.setText( "U" );
				break;
			case 21:
				label.setText( "V" );
				break;
			case 22:
				label.setText( "W" );
				break;
			case 23:
				label.setText( "X" );
				break;
			case 24:
				label.setText( "Y" );
				break;
			case 25:
				label.setText( "Z" );
				break;
			default:
				break;
		}
	}

}


/**
 * Classe que implementa o painel de desenho onde o
 * usuário poderá desenhar uma letra com o mouse.
 * @author Fabio Dela Bruna.
 */
class DrawPanel extends JPanel implements MouseMotionListener {

	private static final long serialVersionUID = 1L;
	private int quantPontos = 0;
	private Point pontos[] = new Point[ 10000 ];

	public DrawPanel() {
		this.setBackground( Color.WHITE );
		this.addMouseMotionListener( new MouseMotionAdapter() {

			public void mouseDragged( MouseEvent e ) {
				if ( quantPontos < pontos.length ) {
					pontos[ quantPontos ] = e.getPoint();
					quantPontos++;
					repaint();
				}
			}
		} );
	}

	/**
	 * É chamado por uma ação do mouse para pintar na tela.
	 */
	public void paintComponent( Graphics g ) {
		super.paintComponent( g );
		for ( int i = 0; i < quantPontos; i++ )
			g.fillOval( pontos[ i ].x, pontos[ i ].y, 15, 15 );
	}

	@Override
	public void mouseDragged( MouseEvent arg0 ) {
	}

	@Override
	public void mouseMoved( MouseEvent arg0 ) {
	}

}
