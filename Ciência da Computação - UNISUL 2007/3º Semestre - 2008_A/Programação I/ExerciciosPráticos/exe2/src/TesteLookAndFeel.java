//Mudando a aparencia da GUI
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TesteLookAndFeel extends JFrame {


	private String strings[] = { "Metal", "Motif", "Windows" };
	private UIManager.LookAndFeelInfo aparencia[];
	private JRadioButton radio[];
	private ButtonGroup grupo;
	private JButton botao;
	private JLabel rotulo;
	private JComboBox comboBox;
	private JTextField campo;
	private JTextArea texto;

	// configura a GUI
	public TesteLookAndFeel()
	{
		super( "Testando a Apar^encia e Comportamento" );

		Container container = getContentPane();

		// configura painel para a regi~ao NORTH de BorderLayout
		JPanel painelNorte = new JPanel();
		painelNorte.setLayout( new GridLayout( 2, 2, 5, 5 ));

		// configura o r´otulo para o painel NORTH
		rotulo = new JLabel( "Esta ´e a apar^encia Metal" );
		rotulo.setVerticalTextPosition(SwingConstants.CENTER);
		container.add( rotulo );

		// configura o bot~ao para o painel NORTH
		botao = new JButton( "Eu sou um Bot~ao" );
		painelNorte.add( botao );

		campo = new JTextField( "Qualquer texto" );
		painelNorte.add( campo );

		// configura caixa de combina¸c~ao para o painel NORTH
		comboBox = new JComboBox( strings );
		painelNorte.add( comboBox );

		// anexa o painelNorte `a regi~ao NORTH do painel de conte´udo
		container.add( painelNorte, BorderLayout.NORTH );

		// cria array para os bot~oes de op¸c~ao
		radio = new JRadioButton[ 3 ];

		// configura painel para a regi~ao SOUTH de BorderLayout
		JPanel painelSul = new JPanel();
		painelSul.setLayout( new GridLayout( 1, 3 ) );

		// configura bot~oes de op¸c~ao para o painelSul
		radio = new JRadioButton[ 3 ];
		radio[ 0 ] = new JRadioButton( "Metal" );
		radio[ 1 ] = new JRadioButton( "Motif" );
		radio[ 2 ] = new JRadioButton( "Windows" );

		grupo = new ButtonGroup(); //implementa exclus~ao m´utua
		TratadorDeItens trat = new TratadorDeItens();

		for ( int count = 0; count < radio.length; count++ ) {
			radio[ count ].addItemListener( trat );
			grupo.add( radio[ count ] );

			painelSul.add( radio[ count ] );
		}

		// anexa o painelSul `a regi~ao SOUTH do painel de conte´udo
		container.add( painelSul, BorderLayout.SOUTH );

		// obt´em inform¸c~oes sobre a apar^encia e
		// comportamento instalado
		aparencia = UIManager.getInstalledLookAndFeels();

		setSize( 400, 300 );
		setVisible( true );
		radio[ 0 ].setSelected( true );
	}

	// usa UIManager para mudar a apar^encia e comportamento da GUI
	private void mudeTheLookAndFeel( int valor )
	{
		// muda apar^encia e comportamento
		try {
			UIManager.setLookAndFeel(
					aparencia[ valor ].getClassName() );
			SwingUtilities.updateComponentTreeUI( this );
		}
		// processa problemas com a mudan¸ca da apar^encia e
		// do comportamento
		catch ( Exception exception ) {
			exception.printStackTrace();
		}
	}

	// executa a aplica¸c~ao
	public static void main( String args[] )
	{
		TesteLookAndFeel aplicacao = new TesteLookAndFeel();
		aplicacao.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE );
	}

	// classe interna privativa para tratar eventos dos bot~oes de op¸c~ao
	private class TratadorDeItens implements ItemListener {

		// processa a sele¸c~ao de apar^encia e comportamento
		// feita pelo usu´ario
		public void itemStateChanged( ItemEvent evento )
		{
			for ( int count = 0; count < radio.length; count++ )
			{
				if ( radio[ count ].isSelected() ) {
					rotulo.setText( "Esta ´e a apar^encia " +
							strings[ count ] );
					comboBox.setSelectedIndex( count );
					mudeTheLookAndFeel( count );
				}
			}
		}
	}
}