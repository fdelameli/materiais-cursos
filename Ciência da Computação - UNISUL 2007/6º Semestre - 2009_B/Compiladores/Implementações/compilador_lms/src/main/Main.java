package main;

import javax.swing.JFrame;

import br.unisul.view.FramePrincipal;

public class Main {
	
	/**
	 * Método principal que inicializa a aplicação.
	 */
	public static void main(String[] args) {
		FramePrincipal app = new FramePrincipal();
		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		app.setVisible( true );
	}
}

