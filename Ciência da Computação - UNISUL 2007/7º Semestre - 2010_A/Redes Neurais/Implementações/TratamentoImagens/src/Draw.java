/*
  Este é um código completo para um programa de
  desenho usando os eventos os mouse. Veja que o
  único evento que tivemos que implementar foi
  mouseDragged. Observe também a criação de uma
  classe JPanel personalizada que servirá como
  painel de desenho.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw extends JFrame {

	public Draw() {
		super( "Eventos do Mouse e Teclado" );

		Container c = getContentPane();
		PainelDesenho painel = new PainelDesenho();
		c.add( painel, BorderLayout.CENTER );

		setSize( 125, 145 );
		setVisible( true );
		
		
//		pack();
	}

	public static void main( String args[] ) {
		Draw app = new Draw();
		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}


/**
 * Classe que cria um painel onde será desenhado a letra.
 * @author Fabio Dela Bruna
 *
 */
class PainelDesenho extends JPanel {
	private static final long serialVersionUID = 1L;
	private int quantPontos = 0;
	private Point pontos[] = new Point[ 10000 ];

	public PainelDesenho() {
		this.setBackground( Color.WHITE );
		setSize( 125, 145 );

		this.addMouseMotionListener(
				new MouseMotionAdapter() {

					public void mouseDragged( MouseEvent e ) {
						if ( quantPontos < pontos.length ) {
							pontos[ quantPontos ] = e.getPoint();
							quantPontos++;
							repaint();
						}
					}
				}
				);
	}

	public void paintComponent( Graphics g ) {
		super.paintComponent( g );
		for ( int i = 0; i < quantPontos; i++ )
			g.fillOval( pontos[ i ].x, pontos[ i ].y, 10, 10 );
	}
}
