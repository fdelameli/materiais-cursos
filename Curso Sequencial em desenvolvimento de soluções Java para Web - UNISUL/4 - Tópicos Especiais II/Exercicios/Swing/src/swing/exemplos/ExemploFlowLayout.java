package swing.exemplos;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * Classe de exemplo para aprendizagem sobre os eventos do mouse.
 * @author Fabio Dela Bruna.
 * @since 18/10/2008.
 */
public class ExemploFlowLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	
	
	/**
	 * Construtor default.
	 */
	public ExemploFlowLayout() {
		super ("Exemplo de FlowLayout");
		setSize(400, 200);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		button1 = new JButton("Botão 1");
		
		button2 = new JButton("Botão 2");
		
		button3 = new JButton("Botão 3");
		
		button4 = new JButton("Botão 4");
		
		button5 = new JButton("Botão 5");
		
		
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
		ExemploFlowLayout app = new ExemploFlowLayout();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
