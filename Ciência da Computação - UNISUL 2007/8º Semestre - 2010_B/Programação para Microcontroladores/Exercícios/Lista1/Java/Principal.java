
import gnu.io.CommPortIdentifier;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.Border;

import java.util.Enumeration;



/**
 * Classe principal do programa que implementa a interface gr�fica.
 * @author Fabio Dela Bruna.
 */
public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton btLed1;
	private JButton btLed2;
	private JButton btLed3;
	private JButton btLed4;
	private JButton btLed5;
	private JButton btLed6;
	private JButton btLed7;
	private JButton btLed8;
	private boolean booleanLed1;
	private boolean booleanLed2;
	private boolean booleanLed3;
	private boolean booleanLed4;
	
	private boolean booleanLed5;
	private boolean booleanLed6;
	private boolean booleanLed7;
	private boolean booleanLed8;

	private final int TAM_X = 75;
	private final int TAM_Y = 50;

	public static final int DELAY = 500;
	public static PortaSerial porta = null;

	/**
	 * Construtor padr�o da aplica��o.
	 * Chama o m�todo que monta a intef�ce gr�fica.
	 */
	public Principal() {
		createGui();
	}


	/**
	 * M�todo que inicializa a aplica��o.
	 */
	public static void main( String[] a ) {

		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		porta = new PortaSerial();
		listaPortas();
				
		try {
			porta.abre( "COM1", 1000 );
		} catch ( Exception e ) {
			
		}
		
		
		Principal app = new Principal();
		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		app.setVisible( true );
	}


	/**
	 * Lista as portas seriais dispon�veis.
	 */
	private static void listaPortas() {
		Enumeration pList = porta.getListaPorta();
		while ( pList.hasMoreElements() ) {
			CommPortIdentifier cpi = ( CommPortIdentifier ) pList.nextElement();
			if ( cpi.getPortType() == CommPortIdentifier.PORT_SERIAL ) {
				System.out.println( cpi.getName() );
			}
		}
	}


	/**
	 * Envia uma mensagem para a porta serial.
	 * @param msg Mensagem a ser enviada a porta serial.
	 */
	private void escreveSerial( String msg ) {
		try {

			System.out.println( msg );

			porta.envia( msg );
			// porta.envia( "L" );
			//Thread.sleep( DELAY );
			// porta.envia( "D" );
			// Thread.sleep( DELAY );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}


	/**
	 * Le uma mensagem que est� na porta serial e retorna em uma String.
	 */
	// public static String leSerial() {
	// try {
	// return porta.recebe();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }


	/**
	 * Cria a interface gr�fica da aplica��o.
	 */
	private void createGui() {
		setTitle( "Comunica��o Serial com Microcontrolador PIC16F877A" );
		setResizable( false );
		setLayout( null );
		setSize( 830, 125 );

		// cria a borda usada por todos os bot�es
		Border border = BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.BLACK );

		// configura o bot�o que acendo o LED 1
		btLed1 = new JButton( "<html><center>LED 1<br>Desligado</center></html>" );
		btLed1.setBorder( border );
		btLed1.setBackground( Color.RED );
		btLed1.setSize( TAM_X, TAM_Y );
		btLed1.setLocation( 725, 25 );
		btLed1.setAutoscrolls( true );
		btLed1.setToolTipText( "Acende o LED 1" );
		btLed1.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {
				if ( booleanLed1 ) {
					escreveSerial( Constants.LED1_OFF );
					btLed1.setText( "<html><center>LED 1<br>Desligado</center></html>" );
					btLed1.setBackground( Color.RED );
					booleanLed1 = false;
				} else {
					escreveSerial( Constants.LED1_ON );
					btLed1.setText( "<html><center>LED 1<br>Ligado</center></html>" );
					btLed1.setBackground( Color.GREEN );
					booleanLed1 = true;
				}
			}
		} );

		// configura o bot�o que acendo o LED 2
		btLed2 = new JButton( "<html><center>LED 2<br>Desligado</center></html>" );
		btLed2.setBorder( border );
		btLed2.setBackground( Color.RED );
		btLed2.setSize( TAM_X, TAM_Y );
		btLed2.setLocation( 625, 25 );
		btLed2.setToolTipText( "Acende o LED 2" );
		btLed2.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {
				if ( booleanLed2 ) {
					escreveSerial( Constants.LED2_OFF );
					btLed2.setText( "<html><center>LED 2<br>Desligado</center></html>" );
					btLed2.setBackground( Color.RED );
					booleanLed2 = false;
				} else {
					escreveSerial( Constants.LED2_ON );
					btLed2.setText( "<html><center>LED 2<br>Ligado</center></html>" );
					btLed2.setBackground( Color.GREEN );
					booleanLed2 = true;
				}
			}
		} );

		// configura o bot�o que acendo o LED 3
		btLed3 = new JButton( "<html><center>LED 3<br>Desligado</center></html>" );
		btLed3.setBorder( border );
		btLed3.setBackground( Color.RED );
		btLed3.setSize( TAM_X, TAM_Y );
		btLed3.setLocation( 525, 25 );
		btLed3.setToolTipText( "Acende o LED 3" );
		btLed3.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {
				if ( booleanLed3 ) {
					escreveSerial( Constants.LED3_OFF );
					btLed3.setText( "<html><center>LED 3<br>Desligado</center></html>" );
					btLed3.setBackground( Color.RED );
					booleanLed3 = false;
				} else {
					escreveSerial( Constants.LED3_ON );
					btLed3.setText( "<html><center>LED 3<br>Ligado</center></html>" );
					btLed3.setBackground( Color.GREEN );
					booleanLed3 = true;
				}
			}
		} );

		// configura o bot�o que acendo o LED 4
		btLed4 = new JButton( "<html><center>LED 4<br>Desligado</center></html>" );
		btLed4.setBorder( border );
		btLed4.setBackground( Color.RED );
		btLed4.setSize( TAM_X, TAM_Y );
		btLed4.setLocation( 425, 25 );
		btLed4.setToolTipText( "Acende o LED 4" );
		btLed4.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {
				if ( booleanLed4 ) {
					escreveSerial( Constants.LED4_OFF );
					btLed4.setText( "<html><center>LED 4<br>Desligado</center></html>" );
					btLed4.setBackground( Color.RED );
					booleanLed4 = false;
				} else {
					escreveSerial( Constants.LED4_ON );
					btLed4.setText( "<html><center>LED 4<br>Ligado</center></html>" );
					btLed4.setBackground( Color.GREEN );
					booleanLed4 = true;
				}
			}
		} );

		// configura o bot�o que acendo o LED 5
		btLed5 = new JButton( "<html><center>LED 5<br>Desligado</center></html>" );
		btLed5.setBorder( border );
		btLed5.setBackground( Color.RED );
		btLed5.setSize( TAM_X, TAM_Y );
		btLed5.setLocation( 325, 25 );
		btLed5.setToolTipText( "Acende o LED 5" );
		btLed5.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {
				if ( booleanLed5 ) {
					escreveSerial( Constants.LED5_OFF );
					btLed5.setText( "<html><center>LED 5<br>Desligado</center></html>" );
					btLed5.setBackground( Color.RED );
					booleanLed5 = false;
				} else {
					escreveSerial( Constants.LED5_ON );
					btLed5.setText( "<html><center>LED 5<br>Ligado</center></html>" );
					btLed5.setBackground( Color.GREEN );
					booleanLed5 = true;
				}
			}
		} );

		// configura o bot�o que acendo o LED 6
		btLed6 = new JButton( "<html><center>LED 6<br>Desligado</center></html>" );
		btLed6.setBorder( border );
		btLed6.setBackground( Color.RED );
		btLed6.setSize( TAM_X, TAM_Y );
		btLed6.setLocation( 225, 25 );
		btLed6.setToolTipText( "Acende o LED 6" );
		btLed6.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {
				if ( booleanLed6 ) {
					escreveSerial( Constants.LED6_OFF );
					btLed6.setText( "<html><center>LED 6<br>Desligado</center></html>" );
					btLed6.setBackground( Color.RED );
					booleanLed6 = false;
				} else {
					escreveSerial( Constants.LED6_ON );
					btLed6.setText( "<html><center>LED 6<br>Ligado</center></html>" );
					btLed6.setBackground( Color.GREEN );
					booleanLed6 = true;
				}
			}
		} );

		// configura o bot�o que acendo o LED 7
		btLed7 = new JButton( "<html><center>LED 7<br>Desligado</center></html>" );
		btLed7.setBorder( border );
		btLed7.setBackground( Color.RED );
		btLed7.setSize( TAM_X, TAM_Y );
		btLed7.setLocation( 125, 25 );
		btLed7.setToolTipText( "Acende o LED 7" );
		btLed7.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {
				if ( booleanLed7 ) {
					escreveSerial( Constants.LED7_OFF );
					btLed7.setText( "<html><center>LED 7<br>Desligado</center></html>" );
					btLed7.setBackground( Color.RED );
					booleanLed7 = false;
				} else {
					escreveSerial( Constants.LED7_ON );
					btLed7.setText( "<html><center>LED 7<br>Ligado</center></html>" );
					btLed7.setBackground( Color.GREEN );
					booleanLed7 = true;
				}
			}
		} );

		// configura o bot�o que acendo o LED 8
		btLed8 = new JButton( "<html><center>LED 8<br>Desligado</center></html>" );
		btLed8.setBorder( border );
		btLed8.setBackground( Color.RED );
		btLed8.setSize( TAM_X, TAM_Y );
		btLed8.setLocation( 25, 25 );
		btLed8.setToolTipText( "Acende o LED 8" );
		btLed8.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent arg0 ) {
				if ( booleanLed8 ) {
					escreveSerial( Constants.LED8_OFF );
					btLed8.setText( "<html><center>LED 8<br>Desligado</center></html>" );
					btLed8.setBackground( Color.RED );
					booleanLed8 = false;
				} else {
					escreveSerial( Constants.LED8_ON );
					btLed8.setText( "<html><center>LED 8<br>Ligado</center></html>" );
					btLed8.setBackground( Color.GREEN );
					booleanLed8 = true;
				}
			}
		} );

		Container c = getContentPane();
		c.add( btLed8 );
		c.add( btLed7 );
		c.add( btLed6 );
		c.add( btLed5 );
		c.add( btLed4 );
		c.add( btLed3 );
		c.add( btLed2 );
		c.add( btLed1 );

		// centraliza a janela
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = ( int ) ( dim.getWidth() / 2 ) - ( getWidth() / 2 );
		int y = ( int ) ( dim.getHeight() / 2 ) - ( getHeight() / 2 );
		setLocation( x, y );
		//
	}


}
