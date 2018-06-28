package com.br.lhmanager.view.temp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

public class FrmDespesa {

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private Composite frmDespesa = null;
	private Table tblDespesa = null;
	private Label label5 = null;
	private Text edtFiltroDespesa = null;
	private Label label6 = null;
	private CCombo cbFiltro = null;
	private Button btNovo = null;
	private Group group = null;
	private Label label7 = null;
	private Text edtCdDespesa = null;
	private Label label11 = null;
	private Label label21 = null;
	private Label label31 = null;
	private Label label41 = null;
	private CCombo cbTpDespesa = null;
	private Text edtVlDespesa = null;
	private Text edtDtPagamento = null;
	private Text edtDsDespesa = null;
	private Button btGravar = null;
	private Button btExcluir = null;
	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		sShell = new Shell();
		sShell.setText("Shell");
		createFrmDespesa();
		sShell.setSize(new Point(750, 651));
		sShell.setLayout(null);
	}

	/**
	 * This method initializes frmDespesa	
	 *
	 */
	private void createFrmDespesa() {
		frmDespesa = new Composite(sShell, SWT.NONE);
		frmDespesa.setLayout(null);
		frmDespesa.setBounds(new Rectangle(0, 0, 738, 613));
		tblDespesa = new Table(frmDespesa, SWT.FULL_SELECTION | SWT.BORDER);
		tblDespesa.setHeaderVisible(true);
		tblDespesa.setLinesVisible(true);
		tblDespesa.setBounds(new Rectangle(10, 75, 689, 280));
		label5 = new Label(frmDespesa, SWT.NONE);
		label5.setBounds(new Rectangle(10, 23, 35, 15));
		label5.setText("Filtro:");
		edtFiltroDespesa = new Text(frmDespesa, SWT.BORDER);
		edtFiltroDespesa.setBounds(new Rectangle(10, 43, 509, 21));
		label6 = new Label(frmDespesa, SWT.NONE);
		label6.setBounds(new Rectangle(548, 23, 58, 15));
		label6.setText("Filtrar por:");
		cbFiltro = new CCombo(frmDespesa, SWT.BORDER);
		cbFiltro.setBounds(new Rectangle(548, 43, 150, 21));
		btNovo = new Button(frmDespesa, SWT.NONE);
		btNovo.setBounds(new Rectangle(10, 375, 75, 32));
		btNovo.setText("Novo");
		createGroup();
		btExcluir = new Button(frmDespesa, SWT.NONE);
		btExcluir.setText("Excluir");
		btExcluir.setBounds(new Rectangle(110, 375, 75, 32));
		TableColumn tableColumn = new TableColumn(tblDespesa, SWT.NONE);
		tableColumn.setWidth(60);
		tableColumn.setText("Código");
		TableColumn tableColumn1 = new TableColumn(tblDespesa, SWT.NONE);
		tableColumn1.setWidth(75);
		tableColumn1.setText("Valor");
		TableColumn tableColumn2 = new TableColumn(tblDespesa, SWT.NONE);
		tableColumn2.setWidth(275);
		tableColumn2.setText("Descrição");
		TableColumn tableColumn3 = new TableColumn(tblDespesa, SWT.NONE);
		tableColumn3.setWidth(150);
		tableColumn3.setText("Tipo da despesa");
		TableColumn tableColumn4 = new TableColumn(tblDespesa, SWT.NONE);
		tableColumn4.setWidth(125);
		tableColumn4.setText("Data do pagamento");
	}

	/**
	 * This method initializes group	
	 *
	 */
	private void createGroup() {
		group = new Group(frmDespesa, SWT.NONE);
		group.setLayout(null);
		group.setText("");
		group.setBounds(new Rectangle(10, 420, 688, 162));
		label7 = new Label(group, SWT.NONE);
		label7.setBounds(new Rectangle(10, 23, 42, 15));
		label7.setText("Código:");
		edtCdDespesa = new Text(group, SWT.BORDER);
		edtCdDespesa.setBounds(new Rectangle(10, 43, 75, 21));
		edtCdDespesa.setEditable(false);
		label11 = new Label(group, SWT.NONE);
		label11.setBounds(new Rectangle(125, 23, 88, 15));
		label11.setText("Tipo da despesa:");
		label21 = new Label(group, SWT.NONE);
		label21.setBounds(new Rectangle(315, 23, 30, 15));
		label21.setText("Valor:");
		label31 = new Label(group, SWT.NONE);
		label31.setBounds(new Rectangle(430, 23, 108, 15));
		label31.setText("Data do pagamento:");
		label41 = new Label(group, SWT.NONE);
		label41.setBounds(new Rectangle(10, 73, 54, 15));
		label41.setText("Descrição:");
		cbTpDespesa = new CCombo(group, SWT.NONE);
		cbTpDespesa.setEditable(true);
		cbTpDespesa.setBounds(new Rectangle(125, 43, 150, 21));
		edtVlDespesa = new Text(group, SWT.BORDER);
		edtVlDespesa.setBounds(new Rectangle(315, 43, 75, 21));
		edtDtPagamento = new Text(group, SWT.BORDER);
		edtDtPagamento.setBounds(new Rectangle(430, 43, 70, 21));
		edtDsDespesa = new Text(group, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		edtDsDespesa.setBounds(new Rectangle(10, 93, 661, 52));
		btGravar = new Button(group, SWT.NONE);
		btGravar.setText("Gravar");
		btGravar.setBounds(new Rectangle(597, 23, 75, 32));
	}

}
