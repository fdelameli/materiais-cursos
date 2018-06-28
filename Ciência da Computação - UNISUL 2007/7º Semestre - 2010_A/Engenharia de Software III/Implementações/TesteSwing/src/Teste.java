import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import java.awt.Rectangle;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;


public class Teste extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollBar jScrollBar = null;
	private JTextArea jTextArea = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JProgressBar jProgressBar = null;
	private JPasswordField jPasswordField = null;
	private JRadioButton jRadioButton = null;
	private JCheckBox jCheckBox = null;

	/**
	 * This method initializes jScrollBar	
	 * 	
	 * @return javax.swing.JScrollBar	
	 */
	private JScrollBar getJScrollBar() {
		if ( jScrollBar == null ) {
			jScrollBar = new JScrollBar();
			jScrollBar.setBounds(new Rectangle(165, 57, 39, 147));
		}
		return jScrollBar;
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if ( jTextArea == null ) {
			jTextArea = new JTextArea();
			jTextArea.setBounds(new Rectangle(287, 42, 381, 133));
		}
		return jTextArea;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if ( jScrollPane == null ) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(289, 207, 291, 158));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if ( jTable == null ) {
			jTable = new JTable();
		}
		return jTable;
	}

	/**
	 * This method initializes jProgressBar	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getJProgressBar() {
		if ( jProgressBar == null ) {
			jProgressBar = new JProgressBar();
			jProgressBar.setBounds(new Rectangle(80, 244, 148, 14));
		}
		return jProgressBar;
	}

	/**
	 * This method initializes jPasswordField	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordField() {
		if ( jPasswordField == null ) {
			jPasswordField = new JPasswordField();
			jPasswordField.setBounds(new Rectangle(46, 301, 167, 23));
		}
		return jPasswordField;
	}

	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton() {
		if ( jRadioButton == null ) {
			jRadioButton = new JRadioButton();
			jRadioButton.setBounds(new Rectangle(627, 210, 21, 21));
		}
		return jRadioButton;
	}

	/**
	 * This method initializes jCheckBox	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox() {
		if ( jCheckBox == null ) {
			jCheckBox = new JCheckBox();
			jCheckBox.setBounds(new Rectangle(639, 260, 21, 21));
		}
		return jCheckBox;
	}

	/**
	 * @param args
	 */
	public static void main( String[] args ) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater( new Runnable() {

			public void run() {
				Teste thisClass = new Teste();
				thisClass.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				thisClass.setVisible( true );
			}
		} );
	}

	/**
	 * This is the default constructor
	 */
	public Teste() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(755, 434);
		this.setContentPane( getJContentPane() );
		this.setTitle( "JFrame" );
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if ( jContentPane == null ) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollBar(), null);
			jContentPane.add(getJTextArea(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJProgressBar(), null);
			jContentPane.add(getJPasswordField(), null);
			jContentPane.add(getJRadioButton(), null);
			jContentPane.add(getJCheckBox(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
