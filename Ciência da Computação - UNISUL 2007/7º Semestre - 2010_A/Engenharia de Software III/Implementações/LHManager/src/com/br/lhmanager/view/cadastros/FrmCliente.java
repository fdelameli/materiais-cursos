package com.br.lhmanager.view.cadastros;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

public class FrmCliente {
	
	private CTabFolder tabFolder = null;
	private Shell shell = null;  
	private Table tblCliente = null;
	private Text edtFiltroCliente = null;
	private CCombo cbFiltro = null;
	private Button btNovo = null;
	private Button btCancelar = null;
	private Text edtCpfCliente = null;
	private Text edtNmCliente = null;
	private Text edtDtNascimento = null;
	private Button btGravar = null;
	private Button btExcluir = null;
	private Text edtFoneCliente = null;
	private Text edtEmailCliente = null;
	private Text edtTotCreditos = null;
	private Text edtEnderecoCliente = null;
	private ScrolledComposite scrolledComposite = null;
	private Composite frmCliente = null;
	private Composite frmCliente2 = null;
	private String[] itensFiltro = {"CPF", "Nome", "Telefone", "Créditos", "Email"};

	
	public FrmCliente(CTabFolder tabFolder, Shell shell) {
		this.tabFolder = tabFolder;
		this.shell = shell;
	}
	
	
	private void createFrmCliente2() {
		frmCliente2 = new Composite(scrolledComposite, SWT.NONE);
		frmCliente2.setLayout(null);
		frmCliente2.setBounds(new Rectangle(0, 0, 762, 660));
		tblCliente = new Table(frmCliente2, SWT.FULL_SELECTION | SWT.BORDER);
		tblCliente.setHeaderVisible(true);
		tblCliente.setLinesVisible(true);
		tblCliente.setBounds(new Rectangle(10, 75, 688, 280));
		Label label5 = new Label(frmCliente2, SWT.NONE);
		label5.setBounds(new Rectangle(10, 23, 35, 15));
		label5.setText("Filtro:");
		edtFiltroCliente = new Text(frmCliente2, SWT.BORDER);
		edtFiltroCliente.setBounds(new Rectangle(10, 43, 509, 21));
		Label label6 = new Label(frmCliente2, SWT.NONE);
		label6.setBounds(new Rectangle(548, 23, 58, 15));
		label6.setText("Filtrar por:");
		cbFiltro = new CCombo(frmCliente2, SWT.BORDER);
		cbFiltro.setBounds(new Rectangle(548, 43, 150, 21));
		cbFiltro.setItems(itensFiltro);
		cbFiltro.setEditable(false);
		cbFiltro.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		btNovo = new Button(frmCliente2, SWT.NONE);
		btNovo.setBounds(new Rectangle(10, 372, 100, 38));
		btNovo.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/new.png")));
		btNovo.setText("Novo");
		btNovo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {
				unlockFields();
			}
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		btCancelar = new Button(frmCliente2, SWT.NONE);
		btCancelar.setBounds(new Rectangle(120, 372, 100, 38));
		btCancelar.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/restricted.png")));
		btCancelar.setText("Cancelar");
		btCancelar.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				lockFields();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		createGroup();
		btExcluir = new Button(frmCliente2, SWT.NONE);
		btExcluir.setText("Excluir");
		btExcluir.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/trash.png")));
		btExcluir.setBounds(new Rectangle(230, 372, 100, 38));
		btExcluir.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {

			}
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		TableColumn tableColumn = new TableColumn(tblCliente, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("CPF");
		TableColumn tableColumn2 = new TableColumn(tblCliente, SWT.NONE);
		TableColumn tableColumn1 = new TableColumn(tblCliente, SWT.NONE);
		tableColumn1.setWidth(75);
		tableColumn1.setText("Telefone");
		tableColumn2.setWidth(275);
		tableColumn2.setText("Nome");
		TableColumn tableColumn3 = new TableColumn(tblCliente, SWT.NONE);
		tableColumn3.setWidth(75);
		tableColumn3.setText("Créditos");
		TableColumn tableColumn4 = new TableColumn(tblCliente, SWT.NONE);
		tableColumn4.setWidth(159);
		tableColumn4.setText("Email");
	}

	/**
	 * This method initializes group	
	 *
	 */
	private void createGroup() {
		Group group = new Group(frmCliente2, SWT.NONE);
		group.setLayout(null);
		group.setText("");
		group.setBounds(new Rectangle(10, 420, 688, 211));
		Label label7 = new Label(group, SWT.NONE);
		label7.setBounds(new Rectangle(10, 23, 30, 15));
		label7.setText("CPF:");
		edtCpfCliente = new Text(group, SWT.BORDER);
		edtCpfCliente.setSize(new Point(100, 21));
		edtCpfCliente.setLocation(new Point(10, 43));
		Label label11 = new Label(group, SWT.NONE);
		label11.setText("Nome:");
		label11.setLocation(new Point(150, 23));
		label11.setSize(new Point(41, 15));
		Label label21 = new Label(group, SWT.NONE);
		label21.setBounds(new Rectangle(150, 73, 36, 15));
		label21.setText("Email:");
		Label label31 = new Label(group, SWT.NONE);
		label31.setBounds(new Rectangle(440, 23, 108, 15));
		label31.setText("Data de nascimento:");
		Label label41 = new Label(group, SWT.NONE);
		label41.setBounds(new Rectangle(10, 73, 54, 15));
		label41.setText("Telefone:");
		edtNmCliente = new Text(group, SWT.BORDER);
		edtNmCliente.setBounds(new Rectangle(150, 43, 250, 21));
		edtDtNascimento = new Text(group, SWT.BORDER);
		edtDtNascimento.setBounds(new Rectangle(440, 43, 70, 21));
		btGravar = new Button(group, SWT.NONE);
		btGravar.setText("Gravar");
		btGravar.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/valide.png")));
		btGravar.setBounds(new Rectangle(575, 23, 100, 38));
		btGravar.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {

			}
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		Label label = new Label(group, SWT.NONE);
		label.setBounds(new Rectangle(10, 123, 55, 15));
		label.setText("Endereço:");
		edtFoneCliente = new Text(group, SWT.BORDER);
		edtFoneCliente.setBounds(new Rectangle(10, 93, 100, 21));
		edtEmailCliente = new Text(group, SWT.BORDER);
		edtEmailCliente.setBounds(new Rectangle(150, 93, 250, 21));
		Label label1 = new Label(group, SWT.NONE);
		label1.setBounds(new Rectangle(440, 73, 96, 15));
		label1.setText("Total de créditos:");
		edtTotCreditos = new Text(group, SWT.BORDER);
		edtTotCreditos.setBounds(new Rectangle(440, 93, 70, 21));
		edtEnderecoCliente = new Text(group, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
		edtEnderecoCliente.setBounds(new Rectangle(10, 143, 661, 52));
		lockFields();
	}


		
	public Composite createFrmCliente() {
		frmCliente = new Composite(tabFolder, SWT.NONE);
		frmCliente.setLayout(null);
		frmCliente.setBounds(new Rectangle(0, 0, 762, 660));
		createScrolledComposite();
		return frmCliente;
	}


	private void createScrolledComposite() {
		scrolledComposite = new ScrolledComposite(frmCliente, SWT.V_SCROLL);
		scrolledComposite.setLayout(null);
		scrolledComposite.setAlwaysShowScrollBars(true);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setLocation(new Point(0, 0));
		scrolledComposite.setSize(new Point(tabFolder.getBounds().width-7, tabFolder.getBounds().height-42));
		createFrmCliente2();
		scrolledComposite.setContent(frmCliente2);
	}

	private void lockFields() {
		edtCpfCliente.setEnabled(false);
		edtDtNascimento.setEnabled(false);
		edtEmailCliente.setEnabled(false);
		edtEnderecoCliente.setEnabled(false);
		edtFoneCliente.setEnabled(false);
		edtNmCliente.setEnabled(false);
		edtTotCreditos.setEnabled(false);
		btGravar.setEnabled(false);
	}
	
	private void unlockFields() {
		edtCpfCliente.setEnabled(true);
		edtDtNascimento.setEnabled(true);
		edtEmailCliente.setEnabled(true);
		edtEnderecoCliente.setEnabled(true);
		edtFoneCliente.setEnabled(true);
		edtNmCliente.setEnabled(true);
		edtTotCreditos.setEnabled(true);
		btGravar.setEnabled(true);
	}

}
