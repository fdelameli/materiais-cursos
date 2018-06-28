package com.br.lhmanager.view.principal;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.br.lhmanager.view.cadastros.FrmCliente;
//import com.br.lhmanager.view.cadastros.FrmDespesas;
import com.br.lhmanager.view.cadastros.FrmDespesas;


public class FrmPrincipal {

	private Shell sShell = null;  
	private CTabFolder cTabFolder = null; 
	private Menus menus = new Menus();
	private FrmCliente frmCliente;
	private CTabItem cTabItemCliente;
	private FrmDespesas frmDespesa;
	private CTabItem cTabItemDespesa;
	
	private void createToolBar() {
		ToolBar toolBar = new ToolBar(sShell, SWT.BORDER | SWT.VERTICAL);
		toolBar.setBounds(new Rectangle(1, 1, 43, 300));
		//Cliente
		ToolItem toolItemCliente = new ToolItem(toolBar, SWT.PUSH);
		toolItemCliente.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/user.png")));
		toolItemCliente.setToolTipText("Cadastrar cliente");
		toolItemCliente.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				createFrmCliente();
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		//Despesa
		ToolItem toolItem = new ToolItem(toolBar, SWT.PUSH);
		toolItem.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/notepad2.png")));
		toolItem.setToolTipText("Cadastrar despesa");
		toolItem.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				createFrmDespesa();
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
	}

	private void createCTabFolder() {
		cTabFolder = new CTabFolder(sShell, SWT.BORDER);
		cTabFolder.setSimple(false);
		cTabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_SELECTION));
		cTabFolder.setBounds(new Rectangle(45, 1, //47 
				sShell.getDisplay().getClientArea().width-50,
				sShell.getDisplay().getClientArea().height-50));

	}
	
	private void createFrmCliente(){
		if(cTabItemCliente == null ||cTabItemCliente.isDisposed()){
			frmCliente = new FrmCliente(cTabFolder, sShell);
			Composite compositeCliente = frmCliente.createFrmCliente();
			cTabItemCliente = new CTabItem(cTabFolder, SWT.CLOSE);
			cTabItemCliente.setText("Cadastro de Clientes");
			cTabItemCliente.setFont(new Font(Display.getDefault(), "@Arial Unicode MS", 10, SWT.NORMAL));
			cTabItemCliente.setControl(compositeCliente);
			cTabItemCliente.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/user.png")));
			cTabFolder.setSelection(cTabItemCliente);
		}else {
			MessageBox msg = new MessageBox(sShell, SWT.ICON_WARNING | SWT.OK);
			msg.setMessage("O cadastro de clientes j� est� aberto.");
			msg.setText("Aten��o!");
			msg.open();
		}
	}
	
	private void createFrmDespesa(){
		if(cTabItemDespesa == null || cTabItemDespesa.isDisposed()){
			frmDespesa = new FrmDespesas(cTabFolder, sShell);
			Composite compositeDespesa = frmDespesa.createFrmDespesa();
			cTabItemDespesa = new CTabItem(cTabFolder, SWT.CLOSE);
			cTabItemDespesa.setText("Cadastro de Despesas");
			cTabItemDespesa.setFont(new Font(Display.getDefault(), "@Arial Unicode MS", 10, SWT.NORMAL));
			cTabItemDespesa.setControl(compositeDespesa);
			cTabItemDespesa.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/notepad2.png")));
			cTabFolder.setSelection(cTabItemDespesa);
		} else {
			MessageBox msg = new MessageBox(sShell, SWT.ICON_WARNING | SWT.OK);
			msg.setMessage("O cadastro de despesas j� est� aberto.");
			msg.setText("Aten��o!");
			msg.open();
		}
	}

	public Shell createSShell() {
		sShell = new Shell();
		sShell.setText("LH Manager");
		sShell.setLayout(null);
	    sShell.setSize(sShell.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	    sShell.setLocation(0, 0);
		sShell.setMaximized(true);
		createToolBar();
		createCTabFolder();
		createMenu();
		return sShell;
	}
	
	private void createMenu(){
		Menu menuBar = new Menu(sShell, SWT.BAR);
		
		MenuItem submenuCad = menus.createMenuItem(menuBar, "&Cadastros", null);
		Menu ItensCad = new Menu(submenuCad);
		
		MenuItem cliente = menus.createMenuItem(ItensCad, "Clientes", "user.png");
		cliente.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				createFrmCliente();
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		
		MenuItem despesa = menus.createMenuItem(ItensCad, "Despesas", "notepad2.png");
		despesa.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				createFrmDespesa();
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		
		submenuCad.setMenu(ItensCad);
		sShell.setMenuBar(menuBar);
	}

}
