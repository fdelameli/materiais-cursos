import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TesteGraphics extends JFrame implements MouseMotionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	Graphics g;

	public TesteGraphics() {
		super( "TEste Graphics" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLayout( null );
		setSize( 400, 400 );

		painel = new JPanel();
		painel.setLocation( 15, 15 );
		painel.setSize( 150, 175 );
		painel.setBackground( Color.WHITE );
		painel.addMouseMotionListener( this );


		JButton btTeste = new JButton( "Testar" );
		btTeste.setBounds( 300, 20, 50, 25 );
		btTeste.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {
				saveJPanel( new File( "teste.png" ) );
				g = painel.getGraphics();
				painel.repaint();
			}
		} );

		getContentPane().add( painel, BorderLayout.CENTER );
		getContentPane().add( btTeste, BorderLayout.NORTH );
		setVisible( true );
		// saveJPanel( new File( "teste.png" ), painel );

	}


	/**
	 * Método para gravar em uma imagem o conteudo de um painel.
	 */

	private void saveJPanel( File f ) {
		try {
			BufferedImage img = new

			BufferedImage( painel.getWidth(),
					painel.getHeight(),
					BufferedImage.TYPE_INT_RGB );

			Graphics g = img.getGraphics();
			painel.paint( g );

			ImageIO.write( img, "png", f );

		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}


	// ////////////////////
	// EVENTOS DO MOUSE //
	// ////////////////////

	@Override
	public void paintComponents( Graphics g ) {
		super.paintComponents( g );
	}
	
	
	/**
	 * Quando move-se o mouse com o botão pressionado.
	 */
	public void mouseDragged( MouseEvent e ) {
		painel = ( JPanel ) e.getSource();
		painel.getGraphics().drawOval( e.getX(), e.getY(), e.getX(), e.getY() );
		g = painel.getGraphics();
	}

	/**
	 * Quando simplesmente move-se o mouse.
	 */
	public void mouseMoved( MouseEvent e ) {

	}

	// ////////////////////

	public static void main( String[] args ) {
		new TesteGraphics();
	}


}
