package swing.exemplos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Classe de exemplo para aprendizagem sobre os eventos do mouse.
 * @author Fabio Dela Bruna.
 * @since 18/10/2008.
 */
public class ExemploJPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	
	private JPanel panel1;
	private JPanel panel2;
	
	
	/**
	 * Construtor default.
	 */
	public ExemploJPanel() {
		super ("Exemplo de ExemploJPanel");
//		setSize(400, 200);
		setLocation(300, 300);
		setLayout(new BorderLayout());
		
		button1 = new JButton("Botão 1");
		
		button2 = new JButton("Botão 2");
		
		button3 = new JButton("Botão 3");
		
		button4 = new JButton("Botão 4");
		
		button5 = new JButton("Botão 5");

		panel1 = new JPanel(new GridLayout(2,1));
		panel1.add(button1);
		panel1.add(button2);
		
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel2.add(button3);
		panel2.add(button4);
		
		Container c = getContentPane();

		c.add(button5);
		c.add(panel1, BorderLayout.CENTER);
		c.add(panel2, BorderLayout.SOUTH);
		
		pack();
		
		//localiza a janela no ponto central da tela.
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int)(dimension.getWidth() / 2) - (getWidth() / 2);
		int y = (int)(dimension.getHeight() / 2) - (getHeight() / 2);
		setLocation(x, y);
	}
	

	
	/**
	 * Método principal para efetuar os devidos testes do programas.
	 * @param args
	 */
	public static void main(String[] args) {
		ExemploJPanel app = new ExemploJPanel();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
