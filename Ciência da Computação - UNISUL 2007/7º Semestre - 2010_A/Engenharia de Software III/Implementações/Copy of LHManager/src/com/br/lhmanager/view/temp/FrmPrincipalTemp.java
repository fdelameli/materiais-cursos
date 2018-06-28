package com.br.lhmanager.view.temp;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;

public class FrmPrincipalTemp {

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private Menu menuBar = null;
	private Composite compositeExterno = null;
	private Composite compositeToolBar = null;
	private ToolBar toolBar = null;
	private ScrolledComposite scrolledComposite = null;
	private CTabFolder cTabFolder = null;
	private Menu submenu = null;
	private Menu submenu1 = null;
	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		sShell = new Shell();
		sShell.setMaximized(true);
		sShell.setText("LH Manager");
		sShell.setLocation(new Point(0, 0));
		createCompositeExterno();
		sShell.setSize(new Point(500, 500));
		menuBar = new Menu(sShell, SWT.BAR);
		MenuItem submenuItem = new MenuItem(menuBar, SWT.CASCADE);
		submenuItem.setText("Arquivo");
		MenuItem submenuItem1 = new MenuItem(menuBar, SWT.CASCADE);
		submenuItem1.setText("Cadastros");
		submenu1 = new Menu(submenuItem1);
		MenuItem menuCadClientes = new MenuItem(submenu1, SWT.PUSH);
		menuCadClientes.setText("Clientes");
		submenuItem1.setMenu(submenu1);
		submenu = new Menu(submenuItem);
		submenuItem.setMenu(submenu);
		sShell.setMenuBar(menuBar);
		sShell.setText("Shell");
		sShell.setMaximized(true);
		sShell.setSize(new Point(721, 470));
		sShell.setLayout(null);
	}

	/**
	 * This method initializes compositeExterno	
	 *
	 */
	private void createCompositeExterno() {
		compositeExterno = new Composite(sShell, SWT.NONE);
		compositeExterno.setLayout(null);
		createCompositeToolBar();
		createScrolledComposite();
		compositeExterno.setBounds(new Rectangle(0, 0, 1278, 717));
	}

	/**
	 * This method initializes compositeToolBar	
	 *
	 */
	private void createCompositeToolBar() {
		compositeToolBar = new Composite(compositeExterno, SWT.NONE);
		compositeToolBar.setLayout(null);
		createToolBar();
		compositeToolBar.setBounds(new Rectangle(0, 0, 1278, 32));
	}

	/**
	 * This method initializes toolBar	
	 *
	 */
	private void createToolBar() {
		toolBar = new ToolBar(compositeToolBar, SWT.NONE);
		toolBar.setLayout(null);
		toolBar.setBounds(new Rectangle(0, 0, 1278, 32));
	}

	/**
	 * This method initializes scrolledComposite	
	 *
	 */
	private void createScrolledComposite() {
		scrolledComposite = new ScrolledComposite(compositeExterno, SWT.NONE);
		scrolledComposite.setLayout(null);
		createCTabFolder();
		scrolledComposite.setContent(cTabFolder);
		scrolledComposite.setBounds(new Rectangle(0, 32, 1278, 683));
	}

	/**
	 * This method initializes cTabFolder	
	 *
	 */
	private void createCTabFolder() {
		cTabFolder = new CTabFolder(scrolledComposite, SWT.NONE);
		cTabFolder.setLayout(null);
		cTabFolder.setTabHeight(25);
		cTabFolder.setBounds(new Rectangle(0, 0, 1278, 683));
	}

}
