package com.br.lhmanager.util;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

/**
 * Classe que implementa métodos para mostrar mensagens diversas na tela.
 * @author Fabio Dela Bruna.
 * @since 14/06/2010.
 */
public class Messages {

	/**
	 * Mostra uma mensagem na tela.
	 * @param shell Componente pai da aplicação, onde o programa se baseará para exibir a mensagem.
	 * @param title Título da mensagem.
	 * @param msg Mensagem a ser exibida.
	 * @param parameter Parâmetros da mensagem como por exemplo: tipo do ícone, botões a serem exibidos...
	 */
	public static int showMessage( Shell shell, String title, String msg, int parameter ) {
		MessageBox alert = new MessageBox( shell, parameter );
		alert.setMessage( msg );
		alert.setText( title );
		return alert.open();
	}

}
