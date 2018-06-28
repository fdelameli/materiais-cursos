package revenda.gui.util;

import javax.swing.JOptionPane;

/**
 * Classe que contém as menságens de erro a
 * serem exibidas, caso seja necessário.
 * 
 * @author Fabio Dela Bruna
 *
 */
public class Mensagens {

	
	/**
	 * Método que recebe a causa do erro por parâmetro.
	 * @param msg Mensagem de erro.
	 */
	public static void showError (String msg) {
		JOptionPane.showMessageDialog(null, msg, "Erro",
				JOptionPane.ERROR_MESSAGE);
	}
	
	
	/**
	 * Método que recebe a exceção por parâmetros
	 * e exibe a causa usando o método getMessage().
	 * @param e Exceção ocorrida.
	 */
	public static void showError (Exception e) {
		showError(e.getMessage());
	}
	
	
	/**
	 * Método que exibe uma menssagem na tela.
	 * É possível passa por parâmetro o titulo e a mensságem.
	 * @param title Título da JOptionPane.
	 * @param msg Mensságem a ser exibida.
	 */
	public static void showMessage(String title, String msg) {
		JOptionPane.showMessageDialog(null, msg, title,
				JOptionPane.PLAIN_MESSAGE);
	}
}
