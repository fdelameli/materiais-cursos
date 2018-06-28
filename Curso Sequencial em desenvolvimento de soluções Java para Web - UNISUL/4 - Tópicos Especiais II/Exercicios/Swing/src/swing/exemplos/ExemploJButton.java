package swing.exemplos;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 * Classe de exemplo para aprendizagem sobre o componente JTextField.
 * @author Fabio Dela Bruna.
 * @since 18/10/2008.
 */
public class ExemploJButton extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel labelNome;
	private JLabel labelEmail;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	
	private JButton buttonExibirNome;
	private JButton buttonEditarEmail;
	private JButton buttonSair;
	
	
	
	/**
	 * Construtor default.
	 */
	public ExemploJButton() {
		super ("Exemplo JButton");
		setSize(400,200);
		setLayout(null);
		setResizable(false);
		
		
		labelNome = new JLabel("Nome:");
		labelNome.setBounds(25, 25, 40, 20);
		
		
		labelEmail = new JLabel("Email:");
		labelEmail.setBounds(25, 50, 40, 20);
		
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(65, 25, 150, 20);
		
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(65, 50, 250, 20);
		textFieldEmail.setText("email@email.com.br");
		textFieldEmail.setEnabled(false);
	
	
/////////////////////////////////////////////////////////////////////////////////////		
		
		//Exemplo 1:
		
//		buttonExibirNome = new JButton("Exibir nome");
//		buttonExibirNome.setBounds(50, 90, 125, 25);
//		buttonExibirNome.addActionListener( new BotaoExibirNomeListener() );
//		
//		
//		buttonEditarEmail = new JButton("Editar email");
//		buttonEditarEmail.setBounds(210, 90, 125, 25);
//		buttonEditarEmail.addActionListener( new BotaoEditarEmailListener() );
		
///////////////////////////////////////////////////////////////////////////////////
		
		//Exemplo 2:
		
//		buttonExibirNome = new JButton("Exibir nome");
//		buttonExibirNome.setBounds(50, 90, 125, 25);
//		buttonExibirNome.addActionListener( new ButtonListener() );
//		
//		
//		buttonEditarEmail = new JButton("Editar email");
//		buttonEditarEmail.setBounds(210, 90, 125, 25);
//		buttonEditarEmail.addActionListener( new ButtonListener() );
		
///////////////////////////////////////////////////////////////////////////////////
		
		//Exemplo 3:
		
		buttonExibirNome = new JButton("Exibir nome");
		buttonExibirNome.setBounds(50, 90, 125, 25);
		buttonExibirNome.addActionListener(this);
		
		
		buttonEditarEmail = new JButton("Editar email");
		buttonEditarEmail.setBounds(210, 90, 125, 25);
		buttonEditarEmail.setMnemonic(KeyEvent.VK_E);
		buttonEditarEmail.addActionListener(this);
		
		
		buttonSair = new JButton("Sair");
		buttonSair.setBounds(150, 125, 85, 25);
		buttonSair.setMnemonic(KeyEvent.VK_F4);
		buttonSair.addActionListener(this);
		
///////////////////////////////////////////////////////////////////////////////////		
		
		
		Container c = getContentPane();
		c.add(labelNome);
		c.add(labelEmail);
		c.add(textFieldEmail);
		c.add(textFieldNome);
		c.add(buttonExibirNome);
		c.add(buttonEditarEmail);
		c.add(buttonSair);
		
		getRootPane().setDefaultButton(buttonExibirNome);
	
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////	
	
	
	//Exemplo 1
	//Tratamento de eventos usando uma classe para cada ação.
	
	/**
	 * Classe private que define a ação ao botão Exibir Nome.
	 * @author Fabio Dela Bruna.
	 * @since 18/10/2008.
	 */
//	private class BotaoExibirNomeListener implements ActionListener {
//
//		public void actionPerformed(ActionEvent e) {
//			JOptionPane.showMessageDialog(null, textFieldNome.getText());			
//		}
//		
//	}
	
	/**
	 * Classe privada que define a ação ao botão Editar email.
	 * @author Fabio Dela Bruna
	 * @since 18/10/2008.
	 */
//	private class BotaoEditarEmailListener implements ActionListener {
//
//		public void actionPerformed(ActionEvent e) {
//			textFieldEmail.setEnabled(true);
//			textFieldEmail.setText("");
//			textFieldEmail.requestFocus();
//		}
//		
//	}
	
///////////////////////////////////////////////////////////////////////////////////////////	
	
	
	//Exemplo 2:
	//Tratamento usando apenas uma classe.
	
//	private class ButtonListener implements ActionListener {
//
//		public void actionPerformed(ActionEvent e) {
//			if (e.getSource() == buttonExibirNome) {
//				JOptionPane.showMessageDialog(null, textFieldNome.getText());
//			} else {
//				textFieldEmail.setEnabled(true);
//				textFieldEmail.setText("");
//				textFieldEmail.requestFocus();
//			}			
//		}
//	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////		
	
	
	//Exemplo 3:
	//Tratamento realizado na própria classe.
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonExibirNome) {
			JOptionPane.showMessageDialog(null, textFieldNome.getText());
		} else {
			if (e.getSource() == buttonEditarEmail) {
				textFieldEmail.setEnabled(true);
				textFieldEmail.setText("");
				textFieldEmail.requestFocus();
			} else {
				if (e.getSource() == buttonSair) {
					System.exit(0);
				}
			}
			
		}			
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * Método principal para efetuar os devidos testes.
	 * @param args
	 */
	public static void main(String[] args) {
		ExemploJButton app = new ExemploJButton();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
	
}
