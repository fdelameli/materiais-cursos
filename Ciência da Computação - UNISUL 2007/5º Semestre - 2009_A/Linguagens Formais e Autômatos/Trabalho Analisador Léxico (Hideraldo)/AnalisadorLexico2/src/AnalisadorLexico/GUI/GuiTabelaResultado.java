package AnalisadorLexico.GUI;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Classe de interface com o usuário que mostra o resultado da Análise.
 * @author 	Hideraldo Luís Simon Júnior
 * 			Marco Aurélio Lima Fernandes
 * 			Rodrigo Paschoal Jeremias
 * @since setembro de 2008
 *
 */
public class GuiTabelaResultado extends JFrame{

	public static JPanel painel;
	public static JTable tabela;
	
	public GuiTabelaResultado(String titulo){
		super(titulo);
		
		painel= new JPanel();
		GridBagLayout gbl= new GridBagLayout();
		painel.setLayout(gbl);
		
		String[] dadosColuna= {"Código","Token","Descrição"};
		DefaultTableModel dfm= new DefaultTableModel(null, dadosColuna);
		tabela= new JTable(dfm);
		JScrollPane scroll= new JScrollPane(tabela);
		painel.add(scroll);
		
		setContentPane(painel);
		setSize(800, 600);
		setVisible(true);
	}
}
