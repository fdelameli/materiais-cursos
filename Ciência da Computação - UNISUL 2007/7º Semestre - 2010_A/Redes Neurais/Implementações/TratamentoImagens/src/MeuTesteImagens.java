import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MeuTesteImagens extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JButton btTeste;

	public MeuTesteImagens() {
		super( "Teste Graphics" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLayout( null );
		setSize( 400, 400 );

		painel = new DrawPanel();
		painel.setLocation( 15, 15 );
		painel.setSize( 125, 145 );
		painel.setBackground( Color.WHITE );

		btTeste = new JButton( "Testar" );
		btTeste.setBounds( 175, 20, 100, 25 );
		btTeste.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {
				saveJPanel( new File( "teste.png" ), painel );
			}
		} );

		getContentPane().add( painel );
		getContentPane().add( btTeste );
		setVisible( true );

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

}

/**
 * Classe que implementa o painel de desenho onde o
 * usuário poderá desenha uma letra com o mouse.
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
