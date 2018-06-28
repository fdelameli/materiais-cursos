package swing.exemplos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * Classe de exemplo para aprendizagem sobre o componente JDialog.
 * @author Fabio Dela Bruna.
 * @since 26/10/2008.
 */
public class ExemploJDialog extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JButton buttonDialog;
	
	
	/**
	 * Construtor.
	 */
	public ExemploJDialog() {
		super("Exemplo JDialog");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new FlowLayout());
		
		buttonDialog = new JButton("JDialog");
		buttonDialog.addActionListener(this);
		
		getContentPane().add(buttonDialog);
	}

	
	
	
	
	/**
	 * Método para efetuar os testes
	 * @param args
	 */
	public static void main(String[] args) {
		ExemploJDialog app = new ExemploJDialog();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		JDialog dialog = new JDialog(this, "JDialog");
		dialog.add(new JLabel("Teste de texto no JDialog"));
		dialog.setModal(true); //não permite cliques atrás do JFrame;
		dialog.pack();
		dialog.setVisible(true);
	}

}
