package com.br.lhmanager.view.principal;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class Menus {

	public MenuItem createMenuItem(Menu pai, String text, String image) {
		MenuItem menuItem = new MenuItem(pai, SWT.CASCADE);
		menuItem.setText(text);
		if (image != null)
			menuItem.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/" + image)));
		return menuItem;
	}

}
