package framework.gui.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class BotaoBase extends JButton {

	private static final long serialVersionUID = 1L;

	public BotaoBase(String label) {
		super (label);
		setForeground(new Color(255, 140, 200));
		setBackground(Color.BLACK);
		Font f = getFont();
		f.deriveFont(20);
		f.deriveFont(Font.BOLD);
	}
}
