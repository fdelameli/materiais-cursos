package swing.exemplos;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 * Classe de exemplo para aprendizagem sobre o componente JList.
 * @author Fabio Dela Bruna.
 * @since 26/10/2008.
 */
public class ExemploJComboBox extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private String[] regioes = {"Centro-Oeste", "Norte", "Nordeste", "Sul", "Sudeste"};
	private JLabel labelRegioes;
	private JComboBox comboBoxRegioes;
	private JButton buttonExibir;
	
	
	/**
	 * Construtor.
	 */
	public ExemploJComboBox() {
		super("Exemplo JComboBox");
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		labelRegioes = new JLabel("Lista de regiões:");
		
		buttonExibir = new JButton("Exibir");
		buttonExibir.addActionListener(this);
		
		comboBoxRegioes = new JComboBox(regioes);
		comboBoxRegioes.setMaximumRowCount(3);
		
		Container c = getContentPane();
		c.add(labelRegioes);
		c.add(comboBoxRegioes);
		c.add(buttonExibir);
		
		pack();
	}
	
	
	
	public static void main(String[] args) {
		ExemploJComboBox app = new ExemploJComboBox();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}



	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonExibir) {
			JOptionPane.showMessageDialog(null, comboBoxRegioes.getSelectedItem());
		}
		
	}
}
