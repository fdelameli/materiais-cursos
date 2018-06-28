package src;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class TesteImagemJDesktopPane extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Image image;
	
	public TesteImagemJDesktopPane() {
		super("Teste de imagem com JDesktopPane");
		setLayout(new BorderLayout());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		image = Toolkit.getDefaultToolkit().getImage("javaone.jpg");
		add(new JDesktopPanePerson(), BorderLayout.CENTER);
	}

	private class JDesktopPanePerson extends JDesktopPane {
		private static final long serialVersionUID = 1L;

		@Override
		public void paint(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
	
	public static void main(String[] args) {
		TesteImagemJDesktopPane app = new TesteImagemJDesktopPane();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
