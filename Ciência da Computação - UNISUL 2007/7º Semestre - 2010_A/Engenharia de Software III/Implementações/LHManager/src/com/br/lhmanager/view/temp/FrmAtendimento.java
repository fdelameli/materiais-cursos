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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class FrmAtendimento {

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private Composite frmDespesa = null;
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
	private Group group1 = null;
	private Button btPC1 = null;
	private Button btPC2 = null;
	private Button btPC3 = null;
	private Button btPC4 = null;
	private Button btPC5 = null;
	private Button btPC6 = null;
	private Button btPC7 = null;
	private Button btPC8 = null;
	private Button btPC9 = null;
	private Button btPC10 = null;
	private Button btPC11 = null;
	private Button btPC12 = null;
	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		sShell = new Shell();
		sShell.setText("Shell");
		createFrmDespesa();
		sShell.setSize(new Point(980, 651));
		sShell.setLayout(null);
	}

	/**
	 * This method initializes frmDespesa	
	 *
	 */
	private void createFrmDespesa() {
		frmDespesa = new Composite(sShell, SWT.NONE);
		frmDespesa.setLayout(null);
		frmDespesa.setBounds(new Rectangle(0, 0, 919, 613));
		createGroup();
		createGroup1();
	}

	/**
	 * This method initializes group	
	 *
	 */
	private void createGroup() {
		group = new Group(frmDespesa, SWT.NONE);
		group.setLayout(null);
		group.setText("");
		group.setBounds(new Rectangle(10, 331, 688, 162));
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

	/**
	 * This method initializes group1	
	 *
	 */
	private void createGroup1() {
		group1 = new Group(frmDespesa, SWT.NONE);
		group1.setLayout(null);
		group1.setBounds(new Rectangle(10, 10, 787, 300));
		btPC1 = new Button(group1, SWT.NONE);
		btPC1.setBounds(new Rectangle(25, 35, 110, 110));
		btPC1.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/pc_off.png")));
		btPC2 = new Button(group1, SWT.NONE);
		btPC2.setBounds(new Rectangle(150, 35, 110, 110));
		btPC2.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/pc_off.png")));
		btPC3 = new Button(group1, SWT.NONE);
		btPC3.setLocation(new Point(275, 35));
		btPC3.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/pc_off.png")));
		btPC3.setSize(new Point(110, 110));
		btPC4 = new Button(group1, SWT.NONE);
		btPC4.setLocation(new Point(400, 35));
		btPC4.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/pc_off.png")));
		btPC4.setSize(new Point(110, 110));
		btPC5 = new Button(group1, SWT.NONE);
		btPC5.setLocation(new Point(525, 35));
		btPC5.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/pc_off.png")));
		btPC5.setSize(new Point(110, 110));
		btPC6 = new Button(group1, SWT.NONE);
		btPC6.setLocation(new Point(650, 35));
		btPC6.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/pc_off.png")));
		btPC6.setSize(new Point(110, 110));
		btPC7 = new Button(group1, SWT.NONE);
		btPC7.setBounds(new Rectangle(25, 165, 110, 110));
		btPC7.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/pc_off.png")));
		btPC8 = new Button(group1, SWT.NONE);
		btPC8.setBounds(new Rectangle(150, 165, 110, 110));
		btPC8.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/pc_off.png")));
		btPC9 = new Button(group1, SWT.NONE);
		btPC9.setBounds(new Rectangle(275, 165, 110, 110));
		btPC9.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/pc_off.png")));
		btPC10 = new Button(group1, SWT.NONE);
		btPC10.setBounds(new Rectangle(400, 165, 110, 110));
		btPC10.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/pc_off.png")));
		btPC11 = new Button(group1, SWT.NONE);
		btPC11.setBounds(new Rectangle(525, 165, 110, 110));
		btPC11.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/pc_off.png")));
		btPC12 = new Button(group1, SWT.NONE);
		btPC12.setBounds(new Rectangle(650, 165, 110, 110));
		btPC12.setImage(new Image(Display.getCurrent(), getClass().getResourceAsStream("/img/pc_off.png")));
	}

}
