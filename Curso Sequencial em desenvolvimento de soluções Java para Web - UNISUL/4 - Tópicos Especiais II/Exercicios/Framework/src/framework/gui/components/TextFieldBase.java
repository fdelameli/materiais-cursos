package framework.gui.components;

import javax.swing.JTextField;

public class TextFieldBase extends JTextField {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor.
	 */
	public TextFieldBase(int altura, int largura) {
		setSize(altura, largura);
	}
	
	public TextFieldBase(int colunas) {
		setColumns(colunas);
	}

}
