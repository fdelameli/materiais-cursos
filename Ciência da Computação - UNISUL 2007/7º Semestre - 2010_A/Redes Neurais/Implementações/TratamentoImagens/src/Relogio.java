import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Relogio extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private javax.swing.Timer timer;
	private JLabel label;

	@SuppressWarnings( "deprecation" )
	public Relogio() {

		super( "Relógio" );
		label = new JLabel();
		label.setFont( new Font( "Arial", Font.BOLD, 22 ) );
		JPanel panel = new JPanel();
		panel.add( label );
		Container c = getContentPane();
		FlowLayout layout = new FlowLayout();
		layout.setAlignment( FlowLayout.CENTER );
		c.setLayout( layout );
		c.add( panel );

		setResizable( false );
		setBounds( 250, 200, 150, 80 );
		show();
		disparaRelogio();
	}

	public void disparaRelogio() {
		if ( timer == null ) {
			timer = new javax.swing.Timer( 1000, this );
			timer.setInitialDelay( 0 );
			timer.start();
		} else if ( !timer.isRunning() ) {
			timer.restart();
		}
	}

	public void actionPerformed( ActionEvent ae ) {
		GregorianCalendar calendario = new GregorianCalendar();
		int h = calendario.get( GregorianCalendar.HOUR_OF_DAY );
		int m = calendario.get( GregorianCalendar.MINUTE );
		int s = calendario.get( GregorianCalendar.SECOND );

		String hora =
				( ( h < 10 ) ? "0" : "" )
						+ h
						+ ":"
						+ ( ( m < 10 ) ? "0" : "" )
						+ m
						+ ":"
						+ ( ( s < 10 ) ? "0" : "" )
						+ s;

		label.setText( hora );
	}

	public static void main( String args[] ) {
		new Relogio();
	}
}