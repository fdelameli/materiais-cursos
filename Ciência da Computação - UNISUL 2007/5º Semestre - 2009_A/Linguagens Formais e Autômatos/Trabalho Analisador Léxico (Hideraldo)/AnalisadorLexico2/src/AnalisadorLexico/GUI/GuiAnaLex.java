package AnalisadorLexico.GUI;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import AnalisadorLexico.EVT.EvtGuiAnaLex;


/**
 * Classe de interface com o usuário para que ele insira a cadeia a ser analisada.
 * @author 	Hideraldo Luís Simon Júnior
 * 			Marco Aurélio Lima Fernandes
 * 			Rodrigo Paschoal Jeremias
 * @since setembro de 2008
 *
 */
public class GuiAnaLex extends JFrame{

	public static JPanel painel;
	public static JButton btAnalisar, btTabela;
	public static JTextArea txCadeia;
	
	public GuiAnaLex(){
		super("Analisador Léxico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		EvtGuiAnaLex evt= new EvtGuiAnaLex();
		
		painel= new JPanel();
		GridBagLayout gbl= new GridBagLayout();
		painel.setLayout(gbl);
		
		txCadeia= new JTextArea(10,40);
		txCadeia.setLineWrap(true);
		txCadeia.setWrapStyleWord(true);
		JScrollPane scroll= new JScrollPane(txCadeia);
		scroll.setPreferredSize(new Dimension(615, 250));
		painel.add(scroll, Pos.add(0, 0, 3, 3, "BOTH"));
		
		btAnalisar= new JButton("Iniciar Análise");
		painel.add(btAnalisar, Pos.add(1, 10, 2, 1, "HORIZONTAL"));
		btAnalisar.addActionListener(evt);
		
		btTabela= new JButton("Tabela de Tokens");
		painel.add(btTabela, Pos.add(0, 10, 1, 1, "HORIZONTAL"));
		btTabela.addActionListener(evt);
		
		setContentPane(painel);
		pack();
		setVisible(true);
	}
}
