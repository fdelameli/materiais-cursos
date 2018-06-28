package swing.exemplos;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


/**
 * Classe de exemplo para aprendizagem sobre o componente JList.
 * @author Fabio Dela Bruna.
 * @since 26/10/2008.
 */
public class ExemploJList extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private String[] regioes = {"Centro-Oeste", "Norte", "Nordeste", "Sul", "Sudeste"};
	private JLabel labelRegioes;
	private JList listRegioes;
	private JButton buttonExibir;
	
	
	/**
	 * Construtor.
	 */
	public ExemploJList() {
		super("Exemplo JList");
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		labelRegioes = new JLabel("Lista de regiões:");
		
		buttonExibir = new JButton("Exibir");
		buttonExibir.addActionListener(this);
		
		listRegioes = new JList(regioes);
		listRegioes.setVisibleRowCount(3);
		listRegioes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane scrollPane = new JScrollPane(listRegioes);
		
		Container c = getContentPane();
		c.add(labelRegioes);
		c.add(scrollPane);
		c.add(buttonExibir);
		
		pack();
	}
	
	
	
	public static void main(String[] args) {
		ExemploJList app = new ExemploJList();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}



	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonExibir) {
			JOptionPane.showMessageDialog(null, listRegioes.getSelectedValues());
		}
		
	}
}
