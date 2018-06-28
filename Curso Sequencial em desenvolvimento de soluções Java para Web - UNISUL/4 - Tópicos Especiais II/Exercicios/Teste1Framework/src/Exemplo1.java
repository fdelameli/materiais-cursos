import java.awt.FlowLayout;

import javax.swing.JFrame;

import framework.gui.components.BotaoBase;


public class Exemplo1 extends JFrame {

	private static final long serialVersionUID = 1L;

	
	/**
	 * Construtor default.
	 */
	public Exemplo1() {
		super ("Exemplo 1 - Framework - LEGAL");
		setLayout(new FlowLayout());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new BotaoBase("Botão 1"));
		
	}
	
	
	public static void main(String[] args) {
		Exemplo1 app = new Exemplo1();
		app.setVisible(true);
	}
	
	
}
