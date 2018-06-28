import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe utilizada para mostrar o desenho do autômato.
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira.
 */
public class DesenhoAutomato extends JFrame {

	private static final long serialVersionUID = 1L;
	private ImageIcon image;
	private JLabel labelImage;
	private JPanel mainPanel;
	private ScrollPane scroll;
	
	
	
	/**
	 * Construtor da classe.
	 * Chama o método que inicializa os componentes.
	 */
	public DesenhoAutomato() {
		initComponents();
	}
	
	
	
	/**
	 * Método privado que inicializa os componentes da tela.
	 */
	private void initComponents() {
		
		setTitle("Desenho do autômato");
		
		image = new ImageIcon("img/desenho.jpg");
		labelImage = new JLabel(image);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(labelImage, BorderLayout.CENTER);
		
		scroll = new ScrollPane();
		scroll.setSize(500, 500);
		scroll.add(mainPanel);
		
		
		getContentPane().add(scroll, BorderLayout.CENTER);
		
		pack();
		
		// Centraliza o JFrame na tela.
		int screenX = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenY = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		int frameX = (int)getSize().getWidth();
		int frameY = (int)getSize().getHeight();

		setLocation(
				(int)(screenX/2)-(frameX/2),
				(int)(screenY/2)-(frameY/2)
		);
	}

}
