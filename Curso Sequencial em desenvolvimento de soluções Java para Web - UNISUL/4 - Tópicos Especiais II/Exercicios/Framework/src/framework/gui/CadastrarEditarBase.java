 package framework.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import framework.gui.components.BotaoBase;
import framework.gui.components.DialogBase;
import framework.gui.components.LabelBase;
import framework.gui.components.PanelBase;
import framework.gui.components.TextFieldBase;
import framework.gui.util.Messages;
import framework.service.ServiceBase;

public abstract class CadastrarEditarBase extends DialogBase implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private ServiceBase serviceBase;
	private BotaoBase salvar;
	private BotaoBase cancelar;
	private PanelBase panelLabels;
	private PanelBase panelTextFields;
	private PanelBase panelGeralSuperior;
	private PanelBase panelBotoes;
	
	private TextFieldBase[] textFieldVector;
	private String[] labels;
	private Object objeto = null;
	private String title = "";
	


	/**
	 * Copnstrutor com parâmetros.
	 * @param obj Objeto a ser editado.
	 */
	public CadastrarEditarBase(Object obj, String title) {
		setTitle(title);
		this.title = title;
		setLayout(new BorderLayout());
		setSize(700, 300);
		setResizable(false);
		setModal(true);
		this.objeto = obj;
		try {
			setServiceBase( createServiceBase() );
		} catch (Exception e) {
			Messages.showError(e);
		}
	}
	
	/**
	 * Construtor default.
	 */
	public CadastrarEditarBase(String title) {
		setTitle(title);
		this.title = title;
		setLayout(new BorderLayout());
		setSize(700, 300);
		setResizable(false);
		setModal(true);
		try {
			setServiceBase( createServiceBase() );
		} catch (Exception e) {
			Messages.showError(e);
		}
	}
	
	
	/**
	 * Este método chama o método que monta a janela
	 * de cadastro e depois a torna visível.
	 */
	public void mostraJanela() {
		montaJanela();
		setVisible(true);
	}
	
	
	/**
	 * Este método monta a janela de cadastro.
	 */
	private void montaJanela() {
		
		panelLabels = new PanelBase();
		int countLabels = getLabels().split(",").length;
		panelLabels.setLayout(new GridLayout(countLabels, 1));
		
		labels = getLabels().split(",");
		for (int i = 0; i < countLabels; i++) {
			panelLabels.add(new LabelBase(labels[i]));
		}
		
		
		panelTextFields = new PanelBase();
		panelTextFields.setLayout(new GridLayout(countLabels, 1));
		textFieldVector = new TextFieldBase[countLabels];
		for (int i = 0; i < countLabels; i++) {
			TextFieldBase tfb = new TextFieldBase(25);
			
			if (objeto != null)
				tfb.setText(setaAtributosTextFields(objeto, labels[i]));
			
			panelTextFields.add( tfb );
			textFieldVector[i] = tfb;
			
		}
		
		
		panelGeralSuperior = new PanelBase();
		panelGeralSuperior.setLayout(new BorderLayout());
		panelGeralSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 5));
		panelGeralSuperior.add(panelLabels, BorderLayout.WEST);
		panelGeralSuperior.add(panelTextFields, BorderLayout.CENTER);
		
		
		
		salvar = new BotaoBase("Salvar");
		salvar.setMnemonic(KeyEvent.VK_S);
		salvar.addActionListener(this);
		
		cancelar = new BotaoBase("Cancelar");
		cancelar.setMnemonic(KeyEvent.VK_C);
		cancelar.addActionListener(this);
		
		panelBotoes = new PanelBase();
		panelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBotoes.add(salvar);
		panelBotoes.add(cancelar);
		
		
		Container c = getContentPane();
		c.add(panelGeralSuperior, BorderLayout.NORTH);
		c.add(panelBotoes, BorderLayout.SOUTH);
		
		pack();
	}
	
	
	

	/**
	 * Método para pegar os labels para cadastro.
	 * @return String contendo os labels.
	 */
	protected abstract String getLabels();
	
	/**
	 * Método que retorna um objeto com os atributos dos textFields.
	 */
	protected abstract Object getAtributosTextFields(TextFieldBase[] textFieldVector, String[] labels);
	
	/**
	 * Método que seta determinado atributo em determinado textField.
	 */
	protected abstract String setaAtributosTextFields(Object obj, String label);
	
	/**
	 * Método que cria um ServiceBase de acordo com a necessidade.
	 * @return ServiceBase criado.
	 * @throws Exception
	 */
	protected abstract ServiceBase createServiceBase() throws Exception;

	
	
	/**
	 * Método responsável por tratar os eventos dos
	 * componentes da tela de cadastro.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvar) {
			if (title.equalsIgnoreCase("Cadastrar")) {
				try {
					boolean b = getServiceBase().insert( getAtributosTextFields(textFieldVector, labels) );
					if (b == true) {
						Messages.showPlainMessage("Cadastro efetuado com sucesso!", "Sucesso!", this);
						dispose();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					Messages.showError(ex);
					
				}
			}
			if (title.equalsIgnoreCase("Editar")) {
				try {
					boolean b = getServiceBase().update( getAtributosTextFields(textFieldVector, labels) );
					if (b == true) {
						Messages.showPlainMessage("Cadastro editado com sucesso!", "Sucesso!", this);
					
					}
				} catch (Exception ex) {
					Messages.showError(ex);
					ex.printStackTrace();
				}
			}
		}
		if (e.getSource() == cancelar) {
			dispose();
		}
	}
	
	
	// GETTERS E SETTERS \\

	public ServiceBase getServiceBase() {
		return serviceBase;
	}

	public void setServiceBase(ServiceBase serviceBase) {
		this.serviceBase = serviceBase;
	}
	
}
