package swing.exemplos;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * Classe de exemplo para aprendizagem sobre os eventos do mouse.
 * @author Fabio Dela Bruna.
 * @since 18/10/2008.
 */
public class ExemploGridBagLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	
	
	/**
	 * Construtor default.
	 */
	public ExemploGridBagLayout() {
		super ("Exemplo de GridBagLayout");
		setSize(400, 200);
		
		GridBagLayout bagLayout = new GridBagLayout();
		GridBagConstraints bagConstraints = new GridBagConstraints();
		setLayout(bagLayout);
		
		button1 = new JButton("Botão 1");
		button2 = new JButton("Botão 2");
		button3 = new JButton("Botão 3");
		button4 = new JButton("Botão 4");
		button5 = new JButton("Botão 5");
		
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagLayout.setConstraints(button1, bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagLayout.setConstraints(button2, bagConstraints);
		
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 2;
		bagLayout.setConstraints(button3, bagConstraints);
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 3;
		bagConstraints.gridwidth = 3;
		bagConstraints.fill = GridBagConstraints.BOTH;
		bagLayout.setConstraints(button4, bagConstraints);
		
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 0;
		bagLayout.setConstraints(button5, bagConstraints);
		
		Container c = getContentPane();
		c.add(button1);
		c.add(button2);
		c.add(button3);
		c.add(button4);
		c.add(button5);
	}
	
	
	/**
	 * Método principal para efetuar os devidos testes do programas.
	 * @param args
	 */
	public static void main(String[] args) {
		ExemploGridBagLayout app = new ExemploGridBagLayout();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
