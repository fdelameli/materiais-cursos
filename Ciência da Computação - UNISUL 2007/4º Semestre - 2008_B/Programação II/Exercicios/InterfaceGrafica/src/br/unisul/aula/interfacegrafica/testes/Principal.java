package br.unisul.aula.interfacegrafica.testes;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

import br.unisul.aula.interfacegrafica.view.JanelaPrincipal;


/**
 * Classe principal do programa.
 * @author Fabio Dela Bruna
 */
public class Principal {

	
	/**
	 * Construtor default.
	 */
	public Principal() {
		
		try {

			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		
			JanelaPrincipal jp = new JanelaPrincipal();
			Dimension screamSize = Toolkit.getDefaultToolkit().getScreenSize();
			jp.setSize( (int)screamSize.getWidth(), (int)screamSize.getHeight() );
			
			jp.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Método principal do programa.
	 */
	public static void main(String[] args) {
		new Principal();
	}
}
