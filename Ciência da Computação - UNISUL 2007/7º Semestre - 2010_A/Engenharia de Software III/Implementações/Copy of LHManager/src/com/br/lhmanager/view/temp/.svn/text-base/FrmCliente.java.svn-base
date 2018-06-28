package com.br.lhmanager.view.temp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.ScrolledComposite;
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

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private Composite frmDespesa2 = null;
	private Table tblDespesa = null;
	private Label label5 = null;
	private Text edtFiltroDespesa = null;
	private Label label6 = null;
	private CCombo cbFiltro = null;
	private Button btNovo = null;
	private Group group = null;
	private Label label7 = null;
	private Text edtCpfCliente = null;
	private Label label11 = null;
	private Label label21 = null;
	private Label label31 = null;
	private Label label41 = null;
	private Text edtNmCliente = null;
	private Text edtDtNascimento = null;
	private Button btGravar = null;
	private Button btExcluir = null;
	private Label label = null;
	private Text edtFoneCliente = null;
	private Text edtEmailCliente = null;
	private Label label1 = null;
	private Text edtTotCreditos = null;
	private Text edtEnderecoCliente = null;
	private Composite frmDespesa = null;
	private ScrolledComposite scrolledComposite = null;
	/**
	 * This method initializes sShell
	 */
	public Shell createSShell() {
		sShell = new Shell();
		sShell.setText("Shell");
		createFrmDespesa();
		sShell.setSize(new Point(902, 697));
		sShell.setLayout(null);
		return sShell;
	}

	/**
	 * This method initializes frmDespesa2	
	 *
	 */
	private void createFrmDespesa2() {
		frmDespesa2 = new Composite(scrolledComposite, SWT.NONE);
		frmDespesa2.setLayout(null);
		frmDespesa2.setBounds(new Rectangle(0, -476, 762, 600));
		tblDespesa = new Table(frmDespesa2, SWT.FULL_SELECTION | SWT.BORDER);
		tblDespesa.setHeaderVisible(true);
		tblDespesa.setLinesVisible(true);
		tblDespesa.setBounds(new Rectangle(10, 75, 688, 280));
		label5 = new Label(frmDespesa2, SWT.NONE);
		label5.setBounds(new Rectangle(10, 23, 35, 15));
		label5.setText("Filtro:");
		edtFiltroDespesa = new Text(frmDespesa2, SWT.BORDER);
		edtFiltroDespesa.setBounds(new Rectangle(10, 43, 509, 21));
		label6 = new Label(frmDespesa2, SWT.NONE);
		label6.setBounds(new Rectangle(548, 23, 58, 15));
		label6.setText("Filtrar por:");
		cbFiltro = new CCombo(frmDespesa2, SWT.BORDER);
		cbFiltro.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		cbFiltro.setBounds(new Rectangle(548, 43, 150, 21));
		btNovo = new Button(frmDespesa2, SWT.NONE);
		btNovo.setBounds(new Rectangle(10, 375, 75, 32));
		btNovo.setText("Novo");
		createGroup();
		btExcluir = new Button(frmDespesa2, SWT.NONE);
		btExcluir.setText("Excluir");
		btExcluir.setBounds(new Rectangle(110, 375, 75, 32));
		TableColumn tableColumn = new TableColumn(tblDespesa, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("CPF");
		TableColumn tableColumn2 = new TableColumn(tblDespesa, SWT.NONE);
		TableColumn tableColumn1 = new TableColumn(tblDespesa, SWT.NONE);
		tableColumn1.setWidth(75);
		tableColumn1.setText("Telefone");
		tableColumn2.setWidth(275);
		tableColumn2.setText("Nome");
		TableColumn tableColumn3 = new TableColumn(tblDespesa, SWT.NONE);
		tableColumn3.setWidth(75);
		tableColumn3.setText("Créditos");
		TableColumn tableColumn4 = new TableColumn(tblDespesa, SWT.NONE);
		tableColumn4.setWidth(159);
		tableColumn4.setText("Email");
	}

	/**
	 * This method initializes group	
	 *
	 */
	private void createGroup() {
		group = new Group(frmDespesa2, SWT.NONE);
		group.setLayout(null);
		group.setText("");
		group.setBounds(new Rectangle(10, 420, 688, 211));
		label7 = new Label(group, SWT.NONE);
		label7.setBounds(new Rectangle(10, 23, 30, 15));
		label7.setText("CPF:");
		edtCpfCliente = new Text(group, SWT.BORDER);
		edtCpfCliente.setEditable(true);
		edtCpfCliente.setSize(new Point(100, 21));
		edtCpfCliente.setLocation(new Point(10, 43));
		label11 = new Label(group, SWT.NONE);
		label11.setText("Nome:");
		label11.setLocation(new Point(150, 23));
		label11.setSize(new Point(41, 15));
		label21 = new Label(group, SWT.NONE);
		label21.setBounds(new Rectangle(150, 73, 36, 15));
		label21.setText("Email:");
		label31 = new Label(group, SWT.NONE);
		label31.setBounds(new Rectangle(440, 23, 108, 15));
		label31.setText("Data de nascimento:");
		label41 = new Label(group, SWT.NONE);
		label41.setBounds(new Rectangle(10, 73, 54, 15));
		label41.setText("Telefone:");
		edtNmCliente = new Text(group, SWT.BORDER);
		edtNmCliente.setBounds(new Rectangle(150, 43, 250, 21));
		edtDtNascimento = new Text(group, SWT.BORDER);
		edtDtNascimento.setBounds(new Rectangle(440, 43, 70, 21));
		btGravar = new Button(group, SWT.NONE);
		btGravar.setText("Gravar");
		btGravar.setBounds(new Rectangle(597, 23, 75, 32));
		label = new Label(group, SWT.NONE);
		label.setBounds(new Rectangle(10, 123, 55, 15));
		label.setText("Endereço:");
		edtFoneCliente = new Text(group, SWT.BORDER);
		edtFoneCliente.setBounds(new Rectangle(10, 93, 100, 21));
		edtFoneCliente.setEditable(true);
		edtEmailCliente = new Text(group, SWT.BORDER);
		edtEmailCliente.setBounds(new Rectangle(150, 93, 250, 21));
		label1 = new Label(group, SWT.NONE);
		label1.setBounds(new Rectangle(440, 73, 96, 15));
		label1.setText("Total de créditos:");
		edtTotCreditos = new Text(group, SWT.BORDER);
		edtTotCreditos.setBounds(new Rectangle(440, 93, 70, 21));
		edtEnderecoCliente = new Text(group, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		edtEnderecoCliente.setBounds(new Rectangle(10, 143, 661, 52));
	}

	/**
	 * This method initializes frmDespesa	
	 *
	 */
	private void createFrmDespesa() {
		frmDespesa = new Composite(sShell, SWT.NONE);
		frmDespesa.setLayout(null);
		createScrolledComposite();
		frmDespesa.setBounds(new Rectangle(3, 4, 837, 563));
		frmDespesa.setBounds(new Rectangle(12, 653, 10, 26));
	}

	/**
	 * This method initializes scrolledComposite	
	 *
	 */
	private void createScrolledComposite() {
		scrolledComposite = new ScrolledComposite(frmDespesa, SWT.V_SCROLL);
		scrolledComposite.setLayout(null);
		scrolledComposite.setExpandVertical(false);
		scrolledComposite.setAlwaysShowScrollBars(false);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setLocation(new Point(2, 4));
		scrolledComposite.setSize(new Point(779, 525));
		createFrmDespesa2();
		scrolledComposite.setContent(frmDespesa2);
	}
	
	
		public static void main(String[] args) {
//			conn = Conexao.getConexao();
			Display display = Display.getDefault();
			FrmCliente tela = new FrmCliente();
			Shell sShell = tela.createSShell();
			sShell.open();
			while (!sShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
				
			}
			display.dispose();
		
	}

}
