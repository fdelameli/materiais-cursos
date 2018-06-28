package revenda.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.Window;

public class Splash extends Window {

	private static final long serialVersionUID = 1L;

	private String msg;
	private Image image;
	Toolkit toolkit;
	private static Splash instance;
	
	public static Splash getInstance() {
		if (instance == null) {
			instance = new Splash();
		}
		return instance;
	}
	
	private Splash() {
		super(new Frame());
		setVisible(false);
		toolkit = Toolkit.getDefaultToolkit();
	}
	
	public void inicia(String nomeImagem, String msg) {
		this.msg = msg;
		setCursor(new Cursor(Cursor.WAIT_CURSOR));
		//Carrega a imagem em memória
		image = toolkit.getImage(nomeImagem);
		MediaTracker media = new MediaTracker(this);
		media.addImage(image, 0);
		try {
			media.waitForID(0);
		} catch (InterruptedException e) {
		}
		//--
		setSize(image.getWidth(this), image.getHeight(this));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension size = getSize();
		
		if (size.width > screenSize.width)
			size.width = screenSize.width;
		
		if (size.height > screenSize.height)
			size.height = screenSize.height;
			
		setLocation((screenSize.width - size.width) / 2, (screenSize.height - size.height) / 2);
		setVisible(true);		
	}
	
	public void finaliza() {
		setVisible(false);
		dispose();
	}
	
	@Override
	public void paint(Graphics g) {
		// Apenas desenha a nossa mensagem em cima da imagem
		g.drawImage(image, 0, 0, getBackground(), this);
		g.setFont(new Font("Arial", Font.BOLD, 26));
		g.setColor(Color.BLACK);
		g.drawString(msg, (int)(image.getWidth(this) / 2) - 80, 20);
	}
}
