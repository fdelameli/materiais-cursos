package swing.exemplos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 * Classe de exemplo para aprendizagem sobre o componente JTable.
 * @author Fabio Dela Bruna.
 * @since 26/10/2008.
 */
public class ExemploJTable extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private Object[][] populacao = { {"São Paulo", 10.8},
									 {"Rio de Janeiro", 9.0},
									 {"Salvador", 2.8},
									 {"Belo Horizonte", 2.4},
									 {"Fortaleza", 2.4}	};
	
	private String[] colunas = {"Cidade", "População (milhões)"};
	
	private JLabel labelPopulacao;
	private JTable tablePopulacao;
	private JButton buttonExibir;
	
	
	/**
	 * Construtor.
	 */
	public ExemploJTable() {
		super("Exemplo Jtable");
		setLayout(new BorderLayout());
		
		labelPopulacao = new JLabel("Principais capitais");
		
		buttonExibir = new JButton("Exibir");
		buttonExibir.addActionListener(this);
		
		tablePopulacao = new JTable(populacao, colunas);
		//Definindo a altura da tabela
		tablePopulacao.setPreferredScrollableViewportSize(
				new Dimension((int) tablePopulacao.getPreferredScrollableViewportSize().getWidth(),
							  (int) tablePopulacao.getRowHeight() * 3));
		//Definindo a largura da tabela
		tablePopulacao.getColumnModel().getColumn(1).setMaxWidth(150);
		
		JScrollPane scrollPane = new JScrollPane(tablePopulacao);
		
		Container c = getContentPane();
		c.add(labelPopulacao, BorderLayout.NORTH);
		c.add(scrollPane, BorderLayout.CENTER);
		c.add(buttonExibir, BorderLayout.SOUTH);
		
		pack();
	}
	
	
	
	
	/**
	 * Método para efetuar os testes.
	 * @param args
	 */
	public static void main(String[] args) {
		ExemploJTable app = new ExemploJTable();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}




	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, tablePopulacao.getValueAt(tablePopulacao.getSelectedRow(),
											tablePopulacao.getSelectedColumn()));
		
	}

}

