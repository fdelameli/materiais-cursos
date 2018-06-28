import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Draw2 extends JComponent {

	private BufferedImage image_;

	public Draw2( int width, int height ) {
		this.image_ = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB );

		this.setCursor( Cursor.getPredefinedCursor( Cursor.CROSSHAIR_CURSOR ) );

		Controller controller = new Controller();
		addMouseListener( controller );
		addMouseMotionListener( controller );

		Graphics2D g = ( Graphics2D ) Draw2.this.image_.getGraphics();
		g.setColor( Color.WHITE );
		g.fillRect( 0, 0, width, height );
		g.setColor( Color.BLACK );
		g.drawRect( 0, 0, this.image_.getWidth() - 1, this.image_.getHeight() - 1 );
	}

	protected void paintComponent( Graphics g ) {
		super.paintComponent( g );
		BufferedImage img = this.image_;
		g.drawImage( img, 0, 0, img.getWidth(), img.getHeight(), this );
	}

	public Dimension getPreferredSize() {
		return new Dimension( this.image_.getWidth(), this.image_.getHeight() );
	}

	public Dimension getMaximumSize() {
		return new Dimension( this.image_.getWidth(), this.image_.getHeight() );
	}

	public Dimension getMinimumSize() {
		return new Dimension( this.image_.getWidth(), this.image_.getHeight() );
	}

	private class Controller extends MouseAdapter implements MouseMotionListener {

		private int x = -1, y = -1;

		public void mousePressed( MouseEvent evt ) {
			updateState( evt );
		}

		public void mouseReleased( MouseEvent evt ) {
			this.x = -1;
			this.y = -1;
		}

		public void mouseDragged( MouseEvent evt ) {
			if ( this.x != -1 && this.y != -1 ) {
				Graphics2D g = ( Graphics2D ) Draw2.this.image_.getGraphics();
				g.setColor( Color.BLUE );
				g.drawLine( this.x, this.y, evt.getX(), evt.getY() );
				updateState( evt );
				repaint();
			}
		}

		/**
		 * @param evt
		 */
		private void updateState( MouseEvent evt ) {
			this.x = evt.getX();
			this.y = evt.getY();
		}

		public void mouseMoved( MouseEvent evt ) {
			//  
		}
	}

	public static void main( String[] args ) throws BadLocationException {

		JTextPane t = new JTextPane();
		StyledDocument d = ( StyledDocument ) t.getDocument();
		Style style = d.addStyle( "StyleName", null );
		StyleConstants.setComponent( style, new Draw2( 100, 100 ) );

		d.insertString( d.getLength(), "antes", null );
		d.insertString( d.getLength(), "ignored text", style );
		d.insertString( d.getLength(), "depois", null );

		JFrame f = new JFrame();
		Container c = f.getContentPane();

		c.setLayout( new BorderLayout() );
		c.add( new JScrollPane( t ), BorderLayout.CENTER );

		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.setSize( 640, 480 );
		f.setVisible( true );
	}
}