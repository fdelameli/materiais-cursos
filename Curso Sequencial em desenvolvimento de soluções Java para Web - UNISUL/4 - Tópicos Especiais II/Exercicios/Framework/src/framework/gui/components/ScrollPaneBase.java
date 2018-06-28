package framework.gui.components;

import javax.swing.JScrollPane;

public class ScrollPaneBase extends JScrollPane {

	private static final long serialVersionUID = 1L;

	
	public ScrollPaneBase(ListBase lista) {
		add(lista);
	}
}
