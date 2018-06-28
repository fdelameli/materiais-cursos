package swing.exemplos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExemploEventosMouse extends JFrame implements MouseListener, MouseMotionListener {

	public ExemploEventosMouse() {
		super("Exemplo de eventos do Mouse");
		setSize(400, 300);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public static void main(String[] args) {
		ExemploEventosMouse app = new ExemploEventosMouse();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			JOptionPane.showMessageDialog(null, "Clique realizado com o botão esquerdo do mouse");
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			JOptionPane.showMessageDialog(null, "Clique realizado com o botão direito do mouse");
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
		JFrame f = (JFrame)e.getSource();
		f.getGraphics().drawLine(e.getX(), e.getY(), e.getX() + 4, e.getY() + 4);
	}

}








