package swing.exemplos;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * Classe de exemplo para aprendizagem sobre os eventos do mouse.
 * @author Fabio Dela Bruna.
 * @since 18/10/2008.
 */
public class ExemploBorderLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	
	
	/**
	 * Construtor default.
	 */
	public ExemploBorderLayout() {
		super ("Exemplo de BorderLayout");
		setSize(400, 200);
		setLayout(new BorderLayout(5, 5));
		
		button1 = new JButton("Botão 1");
		
		button2 = new JButton("Botão 2");
		
		button3 = new JButton("Botão 3");
		
		button4 = new JButton("Botão 4");
		
		button5 = new JButton("Botão 5");
		
		
		Container c = getContentPane();
		c.add(button1, BorderLayout.NORTH);
		c.add(button2, BorderLayout.SOUTH);
		c.add(button3, BorderLayout.EAST);
		c.add(button4, BorderLayout.WEST);
		c.add(button5, BorderLayout.CENTER);
	}
	
	
	/**
	 * Método principal para efetuar os devidos testes do programas.
	 * @param args
	 */
	public static void main(String[] args) {
		ExemploBorderLayout app = new ExemploBorderLayout();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
