//package framework.gui;
//
//import java.awt.BorderLayout;
//import java.awt.Container;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.util.List;
//
//import javax.swing.BorderFactory;
//import javax.swing.ListSelectionModel;
//import javax.swing.table.DefaultTableModel;
//
//import framework.gui.components.BotaoBase;
//import framework.gui.components.InternalFrameBase;
//import framework.gui.components.LabelBase;
//import framework.gui.components.PanelBase;
//import framework.gui.components.ScrollPaneBase;
//import framework.gui.components.TableBase;
//import framework.gui.components.TextFieldBase;
//import framework.gui.util.Messages;
//import framework.service.ServiceBase;
//
//public abstract class TableFrameBase extends InternalFrameBase implements ActionListener {
//	
//	private static final long serialVersionUID = 1L;
//
//	private TextFieldBase textFieldCodigo;
//	private TextFieldBase textFieldDescricao;
//	private LabelBase labelCodigo;
//	private LabelBase labelDescricao;
//	private BotaoBase botaoBuscar;
//	private BotaoBase botaoNovo;
//	private BotaoBase botaoEditar;
//	private BotaoBase botaoExcluir;
//	private BotaoBase botaoCancelar;
//	private PanelBase panelBotoes;
//	private PanelBase panelBusca;
//	private PanelBase panelLabels;
//	private PanelBase panelTextFields;
//	private PanelBase panelBotaoBuscar;
//	private TableBase tabela;
//	private List lista;
//	private Object[][] linhasTabela;
//	private String[] colunasTabela;
//	private ServiceBase serviceBase;
//	
//	
//
//
//	/**
//	 * Construto da classe.
//	 * @param dsTitulo Título da classe.
//	 */
//	public TableFrameBase(String dsTitulo) {
//		super(dsTitulo);
//		setLayout(new BorderLayout());
//		setSize(350, 400);
//		
//		try {
//			
//			setServiceBase( createServiceBase() );
//			
//		} catch (Exception e) {
//			Messages.showError(e);
//		}
//	}
//	
//	
//	/**
//	 * Este método monta a gui da janela.
//	 *
//	 */
//	private void montaJanela() {
//		
//		labelCodigo = new LabelBase("Código:");
//		labelDescricao = new LabelBase("Descrição:");
//		
//		panelLabels = new PanelBase();
//		panelLabels.setLayout(new GridLayout(2,1));
//		panelLabels.add(labelCodigo);
//		panelLabels.add(labelDescricao);
//		
//		
//		textFieldCodigo = new TextFieldBase();
//		textFieldCodigo.setSize(20, 50);
//		
//		textFieldDescricao = new TextFieldBase();
//		textFieldDescricao.setSize(20, 200);
//		
//		panelTextFields = new PanelBase();
//		panelTextFields.setLayout(new BorderLayout());
//		panelTextFields.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 10));
//		panelTextFields.add(textFieldCodigo, BorderLayout.NORTH);
//		panelTextFields.add(textFieldDescricao, BorderLayout.SOUTH);
//		
//		
//		botaoBuscar = new BotaoBase("Buscar");
//		botaoBuscar.setMnemonic(KeyEvent.VK_B);
//		botaoBuscar.setToolTipText("Efetua uma busca");
//		botaoBuscar.addActionListener(this);
//		
//		panelBotaoBuscar = new PanelBase();
//		panelBotaoBuscar.add(botaoBuscar);
//		
//		
//		panelBusca = new PanelBase();
//		panelBusca.setLayout(new BorderLayout());
//		panelBusca.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
//		panelBusca.add(panelLabels, BorderLayout.WEST);
//		panelBusca.add(panelTextFields, BorderLayout.CENTER);
//		panelBusca.add(panelBotaoBuscar, BorderLayout.EAST);
//		
//		
//		botaoNovo = new BotaoBase("Novo");
//		botaoNovo.setMnemonic(KeyEvent.VK_N);
//		botaoNovo.setToolTipText("Novo Cadastro");
//		botaoNovo.addActionListener(this);
//		
//		botaoEditar = new BotaoBase("Editar");
//		botaoEditar.setMnemonic(KeyEvent.VK_D);
//		botaoEditar.setToolTipText("Editar cadastro");
//		botaoEditar.addActionListener(this);
//		
//		botaoExcluir = new BotaoBase("Excluir");
//		botaoExcluir.setMnemonic(KeyEvent.VK_E);
//		botaoExcluir.setToolTipText("Excluir cadastro");
//		botaoExcluir.addActionListener(this);
//		
//		botaoCancelar = new BotaoBase("Cancelar");
//		botaoCancelar.setMnemonic(KeyEvent.VK_C);
//		botaoCancelar.setToolTipText("Cancelar operação");
//		botaoCancelar.addActionListener(this);
//		
//		panelBotoes = new PanelBase();
//		panelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
//		panelBotoes.add(botaoNovo);
//		panelBotoes.add(botaoEditar);
//		panelBotoes.add(botaoExcluir);
//		panelBotoes.add(botaoCancelar);
//		
//		
//		
//		montaTabela();
//		ScrollPaneBase scrollPane = new ScrollPaneBase(tabela);
//		
//		Container c = getContentPane();
//		c.add(panelBusca, BorderLayout.NORTH);
//		c.add(scrollPane, BorderLayout.CENTER);
//		c.add(panelBotoes, BorderLayout.SOUTH);
//		
//		
//	}
//	
//	
//	/**
//	 * Este método monta a tabela.
//	 */
//	private void montaTabela() {
//		tabela = new TableBase();
//		tabela.setModel(new DefaultTableModel(
//				linhasTabela, colunasTabela));
//		
//		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		tabela.getColumnModel().getColumn(0).setMaxWidth(100);
//		tabela.getColumnModel().getColumn(0).setMinWidth(75);
//		
//	}
//	
//	
//	/**
//	 * Este método efetua a busca no Banco de dados.
//	 * Se o usuário não digitar nada em nenhum dos campos, a busca é feita atravéz
//	 * Do método findAll(), que retorna todos os elementos cadastrados no banco.
//	 * Caso seja digita algo, o método responsável pela busca será o findAllByExample,
//	 * Que efetua uma busca personalizada de acordo com os parâmetros esficificados.
//	 */
//	private List efetuaBuscaNoBanco() {
//		List lista = null;
//		int codigo = -1;
//		String descricao = "";
//		
//		try {
//			
//			if (textFieldCodigo.getText().trim().length() == 0
//				&& textFieldDescricao.getText().trim().length() == 0) {
//				
//				lista = getServiceBase().findAll();
//				
//				
//			} else {
//				if (textFieldCodigo.getText().trim().length() != 0)
//					codigo = (Integer.parseInt(textFieldCodigo.getText()));
//				if (textFieldDescricao.getText().trim().length() != 0)
//					descricao = (textFieldDescricao.getText());
//				lista = getServiceBase().findAllByExample(codigo, descricao);
//			}
//			
//		} catch (NumberFormatException nfe) {
//			Messages.showError("Digite apenas números no campo 'Código'!");
//		} catch (Exception e) {
//			Messages.showError("Erro indefinido ao montar a tabela");
//		}
//		
//		return lista;
//		
//	}
//	
//	
//	
//	private void atualizaTabela() {
//		lista = efetuaBuscaNoBanco();
//		DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
//		
//		//limpa a tabela.
//		while (dtm.getRowCount() != 0) {
//			dtm.removeRow(0);
//		}
//		
//		if (tipoDadoTabela().toUpperCase().equals("MONTADORA")) {
//			for (int i = 0; i < lista.size(); i++) {
//				dtm.addRow(new Object[] {
//						)
//				}
//			}
//			
//		} else if (tipoDadoTabela().toUpperCase().equals("DESCRICAO")) {
//			
//		} else if (tipoDadoTabela().toUpperCase().equals("VEICULO")) {
//			
//		}
//		
//	}
//	
//	
//	
//	/**
//	 * Método que cria um ServiceBase de acordo com a necessidade.
//	 * @return ServiceBase criado.
//	 * @throws Exception
//	 */
//	protected abstract ServiceBase createServiceBase() throws Exception;
//	
//	
//	/**
//	 * Método que pega o tipo de dado que será inserido na tabela.
//	 * @return
//	 * @throws Exception
//	 */
//	protected abstract String tipoDadoTabela() throws Exception;
//	
//	
//	
//	
//	/**
//	 * Método responsável pelaa ações dos componentes da tela.
//	 */
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//
//	
//	// GETTERS E SETTERS \\
//	
//	public ServiceBase getServiceBase() {
//		return serviceBase;
//	}
//
//	public void setServiceBase(ServiceBase serviceBase) {
//		this.serviceBase = serviceBase;
//	}
//	
//}
