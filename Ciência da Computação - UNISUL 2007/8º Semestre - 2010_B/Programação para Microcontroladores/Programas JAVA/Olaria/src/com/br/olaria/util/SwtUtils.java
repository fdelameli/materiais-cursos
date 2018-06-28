package com.br.olaria.util;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Classe que cont�m m�todos importantes.
 * @author Fabio Dela Bruna.
 */
public class SwtUtils {

	/**
	 * M�todo que centraliza a classe na tela do usu�rio.
	 */
	public static synchronized void centralize( Shell shell ) {
		try {
			if ( !shell.isDisposed() ) {
				Rectangle r = Display.getCurrent().getClientArea();
				int sW = r.width; // largura da tela
				int sH = r.height; // altura da tela

				r = shell.getBounds();
				int w = r.width; // largura da janela
				int h = r.height; // altura da janela

				int x = ( sW - w ) / 2; // novo ponto x
				int y = ( sH - h ) / 2; // novo ponto y

				shell.setLocation( x, y );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

}
