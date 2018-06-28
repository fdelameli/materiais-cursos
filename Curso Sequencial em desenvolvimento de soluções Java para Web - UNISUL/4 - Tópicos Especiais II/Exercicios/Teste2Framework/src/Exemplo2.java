import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Exemplo2 extends JFrame {

private static final long serialVersionUID = 1L;

	
	/**
	 * Construtor default.
	 */
	public Exemplo2() {
		super ("Exemplo 2 - SEM Framework - CHATO");
		setLayout(new FlowLayout());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new JButton("Botão 2"));
		
	}
	
	
	public static void main(String[] args) {
		Exemplo2 app = new Exemplo2();
		app.setVisible(true);
	}
	
}
