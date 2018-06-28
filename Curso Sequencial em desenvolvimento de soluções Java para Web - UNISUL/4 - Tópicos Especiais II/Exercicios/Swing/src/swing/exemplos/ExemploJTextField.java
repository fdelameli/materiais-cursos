package swing.exemplos;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 * Classe de exemplo para aprendizagem sobre o componente JTextField.
 * @author Fabio Dela Bruna.
 * @since 18/10/2008.
 */
public class ExemploJTextField extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel labelNome;
	private JLabel labelEmail;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	
	
	
	/**
	 * Construtor default.
	 */
	public ExemploJTextField() {
		super ("Exemplo JTextField");
		setSize(400, 150);
		setLayout(null);
		
		
		labelNome = new JLabel("Nome:");
		labelNome.setBounds(25, 25, 40, 20);
		
		
		labelEmail = new JLabel("Email:");
		labelEmail.setBounds(25, 50, 40, 20);
		
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(65, 25, 150, 20);
		
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(65, 50, 250, 20);
		textFieldEmail.setText("email@email.com.br");
//		textFieldEmail.setEnabled(false);
		
		
		Container c = getContentPane();
		c.add(labelNome);
		c.add(labelEmail);
		c.add(textFieldEmail);
		c.add(textFieldNome);
	
	}
	
	
	
	
	/**
	 * Método principal para efetuar os devidos testes.
	 * @param args
	 */
	public static void main(String[] args) {
		ExemploJTextField app = new ExemploJTextField();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
//		app.textFieldEmail.requestFocus();
		
	}
}
