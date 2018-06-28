//package com.br.lhmanager.view.cadastros;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//import org.eclipse.swt.SWT;
//import org.eclipse.swt.custom.CCombo;
//import org.eclipse.swt.custom.CTabFolder;
//import org.eclipse.swt.custom.ScrolledComposite;
//import org.eclipse.swt.events.FocusEvent;
//import org.eclipse.swt.events.FocusListener;
//import org.eclipse.swt.events.ModifyEvent;
//import org.eclipse.swt.events.ModifyListener;
//import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.swt.events.SelectionListener;
//import org.eclipse.swt.graphics.Image;
//import org.eclipse.swt.graphics.Point;
//import org.eclipse.swt.graphics.Rectangle;
//import org.eclipse.swt.widgets.Button;
//import org.eclipse.swt.widgets.Composite;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Group;
//import org.eclipse.swt.widgets.Label;
//import org.eclipse.swt.widgets.Shell;
//import org.eclipse.swt.widgets.Table;
//import org.eclipse.swt.widgets.TableColumn;
//import org.eclipse.swt.widgets.TableItem;
//import org.eclipse.swt.widgets.Text;
//
//import com.br.lhmanager.controller.entitys.Despesa;
//import com.br.lhmanager.controller.entitys.TipoDespesa;
//import com.br.lhmanager.model.bo.DespesaBo;
//import com.br.lhmanager.model.bo.TipoDespesaBo;
//import com.br.lhmanager.util.DataCalendar;
//import com.br.lhmanager.util.Messages;
//
//public class FrmDespesas {
//
//	private CTabFolder tabFolder = null;
//	private Shell shell = null;
//	private Table tblDespesa = null;
//	private CCombo cbFiltro = null;
//	private Button btNovo = null;
//	private Button btCancelar = null;
//	private Button btGravar = null;
//	private Button btExcluir = null;
//	private ScrolledComposite scrolledComposite = null;
//	private Composite frmDespesa2 = null;
//	private Composite frmDespesa = null;
//	private Text edtFiltroDespesa = null;
//	private Text edtCdDespesa = null;
//	private CCombo cbTpDespesa = null;
//	private Text edtVlDespesa = null;
//	private Text edtDtPagamento = null;
//	private Text edtDsDespesa = null;
//	private Label label145 = null;
//	private String[] itensFiltro = { "Valor", "Descrição", "Tipo da despesa", "Data do pagamento" };
//	private ArrayList<Despesa> despesas = null;
//	private ArrayList<TipoDespesa> tiposDespesas = null;
//	private DespesaBo bo;
//	private final int TAM_MAX = 200;
//
//
//	public FrmDespesas( CTabFolder tabFolder, Shell shell ) {
//		this.tabFolder = tabFolder;
//		this.shell = shell;
//		this.bo = new DespesaBo();
//	}
//
//	private void createFrmDespesa2() {
//		frmDespesa2 = new Composite( scrolledComposite, SWT.NONE );
//		frmDespesa2.setLayout( null );
//		frmDespesa2.setBounds( new Rectangle( 0, 0, 762, 620 ) );
//		tblDespesa = new Table( frmDespesa2, SWT.FULL_SELECTION | SWT.BORDER );
//		tblDespesa.setHeaderVisible( true );
//		tblDespesa.setLinesVisible( true );
//		tblDespesa.setBounds( new Rectangle( 10, 75, 688, 280 ) );
//		tblDespesa.addMouseListener( new org.eclipse.swt.events.MouseAdapter() {
//
//			public void mouseDoubleClick( org.eclipse.swt.events.MouseEvent e ) {
//				edtCdDespesa.setText( despesas.get( tblDespesa.getSelectionIndex() ).getCodigo() + "" );
//				edtDsDespesa.setText( despesas.get( tblDespesa.getSelectionIndex() ).getDescricao() );
//				edtDtPagamento.setText( despesas.get( tblDespesa.getSelectionIndex() ).getDataPagameto() );
//				edtVlDespesa.setText( despesas.get( tblDespesa.getSelectionIndex() ).getValor() + "" );
//				cbTpDespesa.setText( despesas.get( tblDespesa.getSelectionIndex() ).getTipoDespesa().getDescricao() );
//				unlockFields();
//			}
//		} );
//		Label label5 = new Label( frmDespesa2, SWT.NONE );
//		label5.setBounds( new Rectangle( 10, 23, 35, 15 ) );
//		label5.setText( "Filtro:" );
//		edtFiltroDespesa = new Text( frmDespesa2, SWT.BORDER );
//		edtFiltroDespesa.setBounds( new Rectangle( 10, 43, 509, 21 ) );
//		Label label6 = new Label( frmDespesa2, SWT.NONE );
//		label6.setBounds( new Rectangle( 548, 23, 58, 15 ) );
//		label6.setText( "Filtrar por:" );
//		cbFiltro = new CCombo( frmDespesa2, SWT.BORDER );
//		cbFiltro.setBounds( new Rectangle( 548, 43, 150, 21 ) );
//		cbFiltro.setItems( itensFiltro );
//		cbFiltro.setEditable( false );
//		cbFiltro.setBackground( Display.getCurrent().getSystemColor( SWT.COLOR_WHITE ) );
//		btNovo = new Button( frmDespesa2, SWT.NONE );
//		btNovo.setBounds( new Rectangle( 10, 372, 100, 38 ) );
//		btNovo.setImage( new Image( Display.getCurrent(), getClass().getResourceAsStream( "/img/new.png" ) ) );
//		btNovo.setText( "Novo" );
//		btNovo.addSelectionListener( new SelectionListener() {
//
//			public void widgetSelected( SelectionEvent arg0 ) {
//				unlockFields();
//				limpaTela();
//			}
//
//			public void widgetDefaultSelected( SelectionEvent arg0 ) {
//			}
//		} );
//		btCancelar = new Button( frmDespesa2, SWT.NONE );
//		btCancelar.setBounds( new Rectangle( 120, 372, 100, 38 ) );
//		btCancelar.setImage( new Image( Display.getCurrent(), getClass().getResourceAsStream( "/img/restricted.png" ) ) );
//		btCancelar.setText( "Cancelar" );
//		btCancelar.addSelectionListener( new SelectionListener() {
//
//			public void widgetSelected( SelectionEvent arg0 ) {
//				limpaTela();
//				lockFields();
//			}
//
//			public void widgetDefaultSelected( SelectionEvent arg0 ) {
//			}
//		} );
//		btExcluir = new Button( frmDespesa2, SWT.NONE );
//		btExcluir.setText( "Excluir" );
//		btExcluir.setImage( new Image( Display.getCurrent(), getClass().getResourceAsStream( "/img/trash.png" ) ) );
//		btExcluir.setBounds( new Rectangle( 230, 372, 100, 38 ) );
//		btExcluir.addSelectionListener( new SelectionListener() {
//
//			public void widgetSelected( SelectionEvent arg0 ) {
//
//			}
//
//			public void widgetDefaultSelected( SelectionEvent arg0 ) {
//			}
//		} );
//		TableColumn tableColumn = new TableColumn( tblDespesa, SWT.NONE );
//		tableColumn.setWidth( 60 );
//		tableColumn.setText( "Código" );
//		TableColumn tableColumn1 = new TableColumn( tblDespesa, SWT.NONE );
//		tableColumn1.setWidth( 75 );
//		tableColumn1.setText( "Valor" );
//		TableColumn tableColumn2 = new TableColumn( tblDespesa, SWT.NONE );
//		tableColumn2.setWidth( 275 );
//		tableColumn2.setText( "Descrição" );
//		TableColumn tableColumn3 = new TableColumn( tblDespesa, SWT.NONE );
//		tableColumn3.setWidth( 150 );
//		tableColumn3.setText( "Tipo da despesa" );
//		TableColumn tableColumn4 = new TableColumn( tblDespesa, SWT.NONE );
//		tableColumn4.setWidth( 124 );
//		tableColumn4.setText( "Data do pagamento" );
//		createGroup();
//		preencheTabela();
//		preencheComboBox();
//	}
//
//	private void createGroup() {
//		Group group = new Group( frmDespesa2, SWT.NONE );
//		group.setLayout( null );
//		group.setText( "" );
//		group.setBounds( new Rectangle( 10, 420, 688, 162 ) );
//		Label label7 = new Label( group, SWT.NONE );
//		label7.setBounds( new Rectangle( 10, 23, 42, 15 ) );
//		label7.setText( "Código:" );
//		edtCdDespesa = new Text( group, SWT.BORDER );
//		edtCdDespesa.setBounds( new Rectangle( 10, 43, 75, 21 ) );
//		Label label11 = new Label( group, SWT.NONE );
//		label11.setBounds( new Rectangle( 125, 23, 88, 15 ) );
//		label11.setText( "Tipo da despesa:" );
//		Label label21 = new Label( group, SWT.NONE );
//		label21.setBounds( new Rectangle( 315, 23, 30, 15 ) );
//		label21.setText( "Valor:" );
//		Label label31 = new Label( group, SWT.NONE );
//		label31.setBounds( new Rectangle( 430, 23, 108, 15 ) );
//		label31.setText( "Data do pagamento:" );
//		Label label41 = new Label( group, SWT.NONE );
//		label41.setBounds( new Rectangle( 10, 73, 54, 15 ) );
//		label41.setText( "Descrição:" );
//		label145 = new Label( group, SWT.NONE );
//		label145.setBounds( new Rectangle( 70, 73, 100, 15 ) );
//		label145.setText( "(restante: 200)" );
//		label145.setToolTipText( "Máximo 200 caracteres" );
//		cbTpDespesa = new CCombo( group, SWT.NONE | SWT.BORDER );
//		cbTpDespesa.setEditable( true );
//		cbTpDespesa.setBounds( new Rectangle( 125, 43, 150, 21 ) );
//		cbTpDespesa.setEditable( false );
//		edtVlDespesa = new Text( group, SWT.BORDER );
//		edtVlDespesa.setBounds( new Rectangle( 315, 43, 75, 21 ) );
//		edtDtPagamento = new Text( group, SWT.BORDER );
//		edtDtPagamento.setBounds( new Rectangle( 430, 43, 70, 21 ) );
//		edtDtPagamento.addFocusListener( new FocusListener() {
//
//			@Override
//			public void focusLost( FocusEvent arg0 ) {
//			}
//
//			@Override
//			public void focusGained( FocusEvent arg0 ) {
//				DataCalendar.calendarioData( tabFolder.getShell(), edtDtPagamento );
//				edtDsDespesa.setFocus();
//			}
//
//		} );
//		edtDsDespesa = new Text( group, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER );
//		edtDsDespesa.setBounds( new Rectangle( 10, 93, 661, 52 ) );
//		edtDsDespesa.addModifyListener( new ModifyListener() {
//			
//			@Override
//			public void modifyText( ModifyEvent arg0 ) {
//				label145.setText( String.format( "(restante: %d)", TAM_MAX - edtDsDespesa.getText().length() ) );
//			}
//			
//		});
//		btGravar = new Button( group, SWT.NONE );
//		btGravar.setText( "Gravar" );
//		btGravar.setImage( new Image( Display.getCurrent(), getClass().getResourceAsStream( "/img/valide.png" ) ) );
//		btGravar.setBounds( new Rectangle( 575, 23, 100, 38 ) );
//		btGravar.addSelectionListener( new SelectionListener() {
//
//			public void widgetSelected( SelectionEvent arg0 ) {
//				inserir();
//			}
//
//			public void widgetDefaultSelected( SelectionEvent arg0 ) {
//			}
//		} );
//		lockFields();
//	}
//
//	public Composite createFrmDespesa() {
//		frmDespesa = new Composite( tabFolder, SWT.NONE );
//		frmDespesa.setLayout( null );
//		frmDespesa.setBounds( new Rectangle( 0, 0, 762, 620 ) );
//		createScrolledComposite();
//		return frmDespesa;
//	}
//
//	private void createScrolledComposite() {
//		scrolledComposite = new ScrolledComposite( frmDespesa, SWT.V_SCROLL );
//		scrolledComposite.setLayout( null );
//		scrolledComposite.setExpandHorizontal( true );
//		scrolledComposite.setLocation( new Point( 0, 0 ) );
//		scrolledComposite.setSize( new Point( 750, shell.getDisplay().getClientArea().height - 137 ) );
//		createFrmDespesa2();
//		scrolledComposite.setContent( frmDespesa2 );
//	}
//
//
//	/**
//	 * Bloqueia todos os campos.
//	 */
//	private void lockFields() {
//		edtCdDespesa.setEnabled( false );
//		edtDsDespesa.setEnabled( false );
//		edtDtPagamento.setEnabled( false );
//		edtVlDespesa.setEnabled( false );
//		cbTpDespesa.setEnabled( false );
//		cbTpDespesa.setBackground( Display.getCurrent().getSystemColor( SWT.COLOR_WIDGET_BACKGROUND ) );
//		btGravar.setEnabled( false );
//	}
//
//	/**
//	 * Libera os campos necessários.
//	 */
//	private void unlockFields() {
//		edtDsDespesa.setEnabled( true );
//		edtDtPagamento.setEnabled( true );
//		edtVlDespesa.setEnabled( true );
//		cbTpDespesa.setEnabled( true );
//		cbTpDespesa.setBackground( Display.getCurrent().getSystemColor( SWT.COLOR_WHITE ) );
//		btGravar.setEnabled( true );
//	}
//
//	/**
//	 * Limpa os campos do cadastro.
//	 */
//	private void limpaTela() {
//		edtCdDespesa.setText( "" );
//		edtDsDespesa.setText( "" );
//		edtDtPagamento.setText( "" );
//		edtVlDespesa.setText( "" );
//		cbTpDespesa.setText( "" );
//		edtFiltroDespesa.setText( "" );
//		cbTpDespesa.setText( "" );
//	}
//
//	/**
//	 * Efetua um cadastro no banco de dados.
//	 */
//	private void inserir() {
//		if ( edtCdDespesa.getText().equals( "" ) ) {
//
//			try {
//
//				Despesa d = new Despesa();
//				d.setDescricao( edtDsDespesa.getText() );
//
//				String aux = edtVlDespesa.getText();
//				aux.replace( ',', '.' );
//				System.out.println(aux);
//				System.out.println("\n\n");
//				d.setValor( Double.parseDouble( aux ) );
//
//				d.setDataPagameto( convertDate( edtDtPagamento.getText() ) );
//				d.setTipoDespesa( tiposDespesas.get( cbTpDespesa.getSelectionIndex() ) );
//
//				try {
//					String msg = bo.inserir( d );
//					Messages.showMessage( shell, "Cadastro de Despesas", msg, SWT.ICON_INFORMATION | SWT.OK );
//					limpaTela();
//					lockFields();
//					preencheTabela();
//				} catch ( SQLException e ) {
//					Messages.showMessage( shell, "Erro de SQL",
//							"Erro ao inserir cadastro no banco de dados." + e.getMessage(), SWT.ICON_ERROR | SWT.OK );
//				} catch ( Exception e ) {
//					Messages.showMessage( shell, "Erro",
//							"Erro no sistema.\n" + e.getMessage(), SWT.ICON_ERROR | SWT.OK );
//				}
//
//			} catch ( NumberFormatException e ) {
//				edtVlDespesa.setFocus();
//				Messages.showMessage( shell, "Erro",
//						"Digite apenas números.", SWT.ICON_ERROR | SWT.OK );
//			}
//		}
//	}
//
//
//	/**
//	 * Preenche a tabela de despesas.
//	 */
//	private void preencheTabela() {
//		try {
//			tblDespesa.setItemCount( 0 );
//			despesas = bo.consultar();
//
//			for ( Despesa despesa : despesas ) {
//				TipoDespesa tp = new TipoDespesaBo().findById( despesa.getTipoDespesa() );
//				TableItem item = new TableItem( tblDespesa, SWT.NONE );
//				item.setText( new String[] { despesa.getCodigo() + "", despesa.getValor() + "", despesa.getDescricao(), tp.getDescricao(), despesa.getDataPagameto() } );
//			}
//		} catch ( SQLException e ) {
//			Messages.showMessage( shell, "Erro de SQL",
//					"Erro ao preencher tabela de despesas.\n" + e.getMessage(), SWT.ICON_ERROR | SWT.OK );
//			e.printStackTrace();
//		} catch ( Exception e ) {
//			Messages.showMessage( shell, "Erro",
//					"Erro no sistema.\n" + e.getMessage(), SWT.ICON_ERROR | SWT.OK );
//		}
//	}
//
//	/**
//	 * Prenche o combo box de tipos de despesas.
//	 */
//	private void preencheComboBox() {
//		try {
//			tiposDespesas = new TipoDespesaBo().consultar();
//		} catch ( SQLException e ) {
//			Messages.showMessage( shell, "Erro de SQL",
//					"Erro ao preencher os tipos de despesas.\n" + e.getMessage(), SWT.ICON_ERROR | SWT.OK );
//		} catch ( Exception e ) {
//			Messages.showMessage( shell, "Erro",
//					"Erro no sistema.\n" + e.getMessage(), SWT.ICON_ERROR | SWT.OK );
//		}
//
//		for ( int i = 0; i < tiposDespesas.size(); i++ ) {
//			cbTpDespesa.add( tiposDespesas.get( i ).getDescricao() );
//		}
//
//		// String[] items = new String[ tiposDespesas.size() ];
//		// for ( int i = 0; i < tiposDespesas.size(); i++ )
//		// items[ i ] = ( tiposDespesas.get( i ).getDescricao() );
//		//
//		// cbTpDespesa.setItems( items );
//	}
//
//	/**
//	 * Converte a data de brasil para americano de dia/mes/ano
//	 * para ano/mes/dia que é o tipo aceito pelo banco de dados.
//	 * @return a Data modificada.
//	 */
//	private String convertDate( String date ) {
//		String dataGrava = "";
//		String dia = "", mes = "", ano = "";
//		StringTokenizer st = new StringTokenizer( date, "/" );
//
//		int tamanho = st.countTokens();
//
//		for ( int i = 0; i < tamanho; i++ ) {
//			if ( i == 0 )
//				dia = st.nextToken();
//			if ( i == 1 )
//				mes = st.nextToken() + "-";
//			if ( i == 2 )
//				ano = st.nextToken() + "-";
//		}
//		dataGrava = ano + mes + dia;
//		return dataGrava;
//	}
//
//}
