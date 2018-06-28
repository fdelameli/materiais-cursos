package com.amazinMaze.exception;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class DevagarDemaisException extends RuntimeException {
	public DevagarDemaisException(String event) {
		JOptionPane.showMessageDialog(null, "O tempo acabou e a pirâmide explodiu!\n" +
				"Da próxima tente ser mais rápido\n" +
				"Agora você vai ter que começar tudo denovo!","GAME OVER!!",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("imagens\\gameover.jpg"));
		System.exit(0);
	}
}
