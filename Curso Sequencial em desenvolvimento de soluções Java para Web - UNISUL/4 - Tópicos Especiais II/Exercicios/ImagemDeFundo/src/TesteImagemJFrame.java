package src;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class TesteImagemJFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Image image;

	public TesteImagemJFrame() {
		super("Teste de imagem como fundo do JFrame");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		image = Toolkit.getDefaultToolkit().getImage("javaone.jpg");
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	public static void main(String[] args) {
		TesteImagemJFrame app = new TesteImagemJFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}
