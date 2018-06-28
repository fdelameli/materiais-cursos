package framework.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import framework.gui.components.BotaoBase;
import framework.gui.components.InternalFrameBase;
import framework.gui.components.LabelBase;
import framework.gui.components.ListBase;
import framework.gui.components.PanelBase;
import framework.gui.components.TextFieldBase;
import framework.gui.util.Messages;
import framework.service.ServiceBase;

public abstract class ListFrameBase extends InternalFrameBase implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private ServiceBase serviceBase;
	
	private LabelBase labelCodigo;
	private LabelBase labelDescricao;
	private TextFieldBase textFieldCodigo;
	private TextFieldBase textFieldDescricao;
	private ListBase listDomainBase;
	private PanelBase panelBotoes;
	private PanelBase panelLabels;
	private PanelBase panelTextFields;
	private PanelBase panelButtonBuscar;
	private PanelBase panelBusca;
	private BotaoBase buttonBuscar;
	private BotaoBase buttonExcluir;
	private BotaoBase buttonNovo;
	private BotaoBase buttonEditar;
	private BotaoBase buttonCancelar;
	
	
	
	/**
	 * Construtor default.
	 */
	public ListFrameBase(String dsTitulo) {
		super(dsTitulo);
		setSize(600, 400);
		setLayout(new BorderLayout());
		
		try {
			
			setServiceBase( createServiceBase() );
	
		} catch (Exception e) {
			Messages.showError(e);
		}
	}
	
	
	/**
	 * Método que cria um ServiceBase de acordo com a necessidade.
	 * @return ServiceBase criado.
	 * @throws Exception
	 */
	protected abstract ServiceBase createServiceBase() throws Exception;

	/**
	 * Este método cria uma janela de Cadastro ou edição.
	 * @return
	 * @throws Exception
	 */
	protected abstract CadastrarEditarBase criaJanelaCadastrarEditar(Object obj) throws Exception;
	
	
	/**
	 * Método que monta a janela a ser exibida.
	 *
	 */
	private void montaJanela() {
		
		try {
			
			labelCodigo = new LabelBase("Código:");
			labelDescricao = new LabelBase("Descrição:");
			panelLabels = new PanelBase();
			panelLabels.setLayout(new GridLayout(2,1));
			panelLabels.add(labelCodigo);
			panelLabels.add(labelDescricao);
			
			textFieldCodigo = new TextFieldBase(20);
			textFieldDescricao = new TextFieldBase(20);
			panelTextFields = new PanelBase();
			panelTextFields.setLayout(new GridLayout(2,1));
			panelTextFields.add(textFieldCodigo);
			panelTextFields.add(textFieldDescricao);
			
			buttonBuscar = new BotaoBase("Buscar");
			buttonBuscar.setMnemonic(KeyEvent.VK_B);
			buttonBuscar.addActionListener(this);
			panelButtonBuscar = new PanelBase();
			panelButtonBuscar.add(buttonBuscar);
			
			panelBusca = new PanelBase();
			panelBusca.setLayout(new BorderLayout());
			panelBusca.add(panelLabels, BorderLayout.WEST);
			panelBusca.add(panelTextFields, BorderLayout.CENTER);
			panelBusca.add(panelButtonBuscar, BorderLayout.EAST);
			
			listDomainBase = new ListBase();
			listDomainBase.setVisibleRowCount(5);
			listDomainBase.setAutoscrolls(true);
			listDomainBase.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			//ScrollPaneBase scrollPane = new ScrollPaneBase(listDomainBase);
			atualizaLista();
			
			
			buttonNovo = new BotaoBase("Novo");
			buttonNovo.setMnemonic(KeyEvent.VK_N);
			buttonNovo.addActionListener(this);
			
			buttonEditar = new BotaoBase("Editar");
			buttonEditar.setMnemonic(KeyEvent.VK_E);
			buttonEditar.addActionListener(this);
			
			buttonExcluir = new BotaoBase("Exclui");
			buttonExcluir.setMnemonic(KeyEvent.VK_X);
			buttonExcluir.addActionListener(this);
			
			buttonCancelar = new BotaoBase("Cancelar");
			buttonCancelar.setMnemonic(KeyEvent.VK_C);
			buttonCancelar.addActionListener(this);
			
			
			panelBotoes = new PanelBase();
			panelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
			panelBotoes.add(buttonNovo);
			panelBotoes.add(buttonEditar);
			panelBotoes.add(buttonExcluir);
			panelBotoes.add(buttonCancelar);
			
			Container c = getContentPane();
			c.add(panelBusca, BorderLayout.NORTH);
			c.add(listDomainBase, BorderLayout.CENTER);
			c.add(panelBotoes, BorderLayout.SOUTH);
			
			pack();
			
		} catch (Exception e) {
			Messages.showError(e);
		}

	}
	
	
	/**
	 * Chama o método que monta a janela e depois a mostra na tela.
	 */
	public void showList() {
		montaJanela();
		setVisible(true);
	}
	
	
	/**
	 * Método para atualizar a lista de pessoas.
	 * @throws Exception
	 */
	public void atualizaLista() throws Exception {
		listDomainBase.setListData(getServiceBase().findAll().toArray());
		
	}

	
	/**
	 * Método que define as ações dos componentes da janela.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonNovo) {
			try {
				CadastrarEditarBase ceb = criaJanelaCadastrarEditar(null);
				ceb.mostraJanela();
				atualizaLista();
			} catch (Exception ex) {
				Messages.showError(ex);
				ex.printStackTrace();
			}
		}
		if (e.getSource() == buttonEditar) {
			try {
				CadastrarEditarBase ceb = criaJanelaCadastrarEditar(listDomainBase.getSelectedValue());
				ceb.mostraJanela();
				atualizaLista();
			} catch (Exception ex) {
				Messages.showError(ex);
				ex.printStackTrace();
			}
		}
		if (e.getSource() == buttonExcluir) {
			if (listDomainBase.getSelectedValue() != null) {
				try {
					boolean b = getServiceBase().delete(listDomainBase.getSelectedValue());
					if (b == true)
						JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!",
								"Sucesso", JOptionPane.PLAIN_MESSAGE);
					atualizaLista();
				} catch (Exception ex) {
					Messages.showError(ex);
					ex.printStackTrace();
				}
			} else {
				Messages.showError("Selecione um ítem para excluir!");
			}
		}
		if (e.getSource() == buttonBuscar) {
			if (textFieldCodigo.getText().trim().length() == 0 && textFieldDescricao.getText().trim().length() == 0) {
				try {
					atualizaLista();
				} catch (Exception e1) {
					Messages.showError(e1);
				}
			} else {
				int cd = 0;
				String ds = "";
				if (textFieldCodigo.getText().trim().length() != 0)
					cd = Integer.parseInt(textFieldCodigo.getText());
				if (textFieldDescricao.getText().trim().length() != 0)
					ds = textFieldDescricao.getText();
				
				try {
					listDomainBase.setListData(getServiceBase().findAllByExample(cd, ds).toArray());
				} catch (Exception e1) {
					Messages.showError(e1);
					e1.printStackTrace();
				}
			}
		}
		if (e.getSource() == buttonCancelar) {
			dispose();
		}
	}


	// GETTERS E SETTERS

	public ServiceBase getServiceBase() {
		return serviceBase;
	}

	public void setServiceBase(ServiceBase serviceBase) {
		this.serviceBase = serviceBase;
	}	


}
