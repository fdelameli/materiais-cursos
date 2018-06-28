package splash;

import javax.swing.JFrame;

public class TestaSplash extends JFrame {

	private static final long serialVersionUID = 1L;

	public TestaSplash() {
		super("Testa Splash");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public static void main(String[] args) {
		Splash.getInstance().inicia("javaone.jpg", "James Gosling");
		//--
		TestaSplash app = new TestaSplash();
		//Simulando um processamento
		for (int i = 0; i < 200000; i++) {
			System.out.println("I = " + i);
		}
		//--
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		//--
		Splash.getInstance().finaliza();
	}
}
