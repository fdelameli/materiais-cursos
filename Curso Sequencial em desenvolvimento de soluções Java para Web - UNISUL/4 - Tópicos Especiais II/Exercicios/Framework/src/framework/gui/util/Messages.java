package framework.gui.util;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Messages {
	
	
	/**
	 * Este método mostra uma mensagem de erro de acordo
	 * com o parâmetro que lhe é passado.
	 * @param msg Menssagem a ser mostrada.
	 */
	public static void showError (String msg) {
		JOptionPane.showMessageDialog(null, msg, "Erro",
				JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Este método mostra uma mensagem de erro de
	 * acordo com a exceção ocorrida.
	 * @param e Exceção ocorrida.
	 */
	public static void showError (Exception e) {
		showError(e.getMessage());
	}
	
	/**
	 * Este método mostra uma mensagem simples,
	 * onde a mensagem e o titulo são passados por parâmetro.
	 * @param msg Mensagem a ser exibida.
	 * @param title Título da mensagem.
	 * @param component Componente pai que chamou esse método.
	 */
	public static void showPlainMessage (String msg, String title, Component component) {
		JOptionPane.showMessageDialog(component, msg, title,
				JOptionPane.PLAIN_MESSAGE);
	}

}
