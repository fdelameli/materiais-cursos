package br.unisul.aula.interfacegrafica.view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.unisul.aula.interfacegrafica.dao.DAOException;
import br.unisul.aula.interfacegrafica.dto.ClienteDTO;
import br.unisul.aula.interfacegrafica.dto.ErroValidacao;
import br.unisul.aula.interfacegrafica.dto.EstadoDTO;
import br.unisul.aula.interfacegrafica.dto.StatusDTO;
import br.unisul.aula.interfacegrafica.model.ClienteModel;
import br.unisul.aula.interfacegrafica.model.EstadoModel;
import br.unisul.aula.interfacegrafica.model.StatusModel;


public class ManterCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane;
	private JLabel jLabelCodigo = null;
	private JLabel jLabelNome = null;
	private JLabel jLabelCPF = null;
	private JLabel jLabelRG = null;
	private JLabel jLabelEmail = null;
	private JLabel jLabelSexo = null;
	private JLabel jLabelFone = null;
	private JLabel jLabelCelular = null;
	private JLabel jLabelEndereco = null;
	private JLabel jLabelCidade = null;
	private JLabel jLabelUF = null;
	private JLabel jLabelStatus = null;
	private JTextField jTextFieldCodigo = null;
	private JTextField jTextFieldNome = null;
	private JTextField jTextFieldCPF = null;
	private JTextField jTextFieldRG = null;
	private JTextField jTextFieldEmail = null;
	private JTextField jTextFieldFone = null;
	private JTextField jTextFieldCelular = null;
	private JTextField jTextFieldEndereco = null;
	private JTextField jTextFieldCidade = null;
	private JComboBox jComboBoxUF = null;
	private JComboBox jComboBoxStatus = null;
	private JRadioButton jRadioButtonMasc = null;
	private JRadioButton jRadioButtonFem = null;
	private ButtonGroup buttonGroupSexo = null;
	private JButton jButtonSalvar = null;
	private JButton jButtonExcluir = null;
	private JButton jButtonBuscar = null;
	private ClienteModel clienteModel = null;
	private JButton jButtonCancelar = null;
	private JanelaPrincipal jp = null;
	
	
	/**
	 * Construtor default
	 */
	public ManterCliente() {
		super();
		initialize();
		this.clienteModel = new ClienteModel();
	}
	
	/**
	 * Construtor com parâmetros.
	 * @param jp
	 */
	public ManterCliente(JanelaPrincipal jp) {
		super();
		initialize();
		clienteModel = new ClienteModel();
		this.jp = jp;
	}
	
	

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(475, 425);
		this.setName("c");
		this.setTitle("Manter Clientes");
		this.setIconifiable(true);
		this.setClosable(true);
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelStatus = new JLabel();
			jLabelStatus.setText("Status:");
			jLabelStatus.setSize(new Dimension(40, 20));
			jLabelStatus.setLocation(new Point(264, 250));
			jLabelUF = new JLabel();
			jLabelUF.setText("UF:");
			jLabelUF.setSize(new Dimension(17, 20));
			jLabelUF.setLocation(new Point(250, 200));
			jLabelCidade = new JLabel();
			jLabelCidade.setText("Cidade:");
			jLabelCidade.setSize(new Dimension(42, 20));
			jLabelCidade.setLocation(new Point(25, 200));
			jLabelEndereco = new JLabel();
			jLabelEndereco.setText("Endereço:");
			jLabelEndereco.setSize(new Dimension(57, 20));
			jLabelEndereco.setLocation(new Point(13, 175));
			jLabelCelular = new JLabel();
			jLabelCelular.setText("Celular:");
			jLabelCelular.setLocation(new Point(230, 150));
			jLabelCelular.setSize(new Dimension(43, 20));
			jLabelFone = new JLabel();
			jLabelFone.setText("Telefone:");
			jLabelFone.setSize(new Dimension(52, 20));
			jLabelFone.setLocation(new Point(16, 150));
			jLabelSexo = new JLabel();
			jLabelSexo.setText("Sexo:");
			jLabelSexo.setSize(new Dimension(32, 20));
			jLabelSexo.setLocation(new Point(35, 100));
			jLabelEmail = new JLabel();
			jLabelEmail.setText("Email:");
			jLabelEmail.setSize(new Dimension(34, 20));
			jLabelEmail.setLocation(new Point(34, 125));
			jLabelRG = new JLabel();
			jLabelRG.setText("RG:");
			jLabelRG.setSize(new Dimension(19, 20));
			jLabelRG.setLocation(new Point(250, 75));
			jLabelCPF = new JLabel();
			jLabelCPF.setText("Cpf:");
			jLabelCPF.setSize(new Dimension(22, 20));
			jLabelCPF.setLocation(new Point(41, 75));
			jLabelNome = new JLabel();
			jLabelNome.setText("Nome:");
			jLabelNome.setSize(new Dimension(36, 20));
			jLabelNome.setLocation(new Point(31, 50));
			jLabelCodigo = new JLabel();
			jLabelCodigo.setText("Código:");
			jLabelCodigo.setSize(new Dimension(42, 20));
			jLabelCodigo.setLocation(new Point(25, 25));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jContentPane.add(jLabelCodigo, null);
			jContentPane.add(jLabelNome, null);
			jContentPane.add(jLabelCPF, null);
			jContentPane.add(jLabelRG, null);
			jContentPane.add(jLabelEmail, null);
			jContentPane.add(jLabelSexo, null);
			jContentPane.add(jLabelFone, null);
			jContentPane.add(jLabelCelular, null);
			jContentPane.add(jLabelEndereco, null);
			jContentPane.add(jLabelCidade, null);
			jContentPane.add(jLabelUF, null);
			jContentPane.add(jLabelStatus, null);
			jContentPane.add(getJTextFieldCodigo(), null);
			jContentPane.add(getJTextFieldNome(), null);
			jContentPane.add(getJTextFieldCPF(), null);
			jContentPane.add(getJTextFieldRG(), null);
			
			buttonGroupSexo = new ButtonGroup();
			buttonGroupSexo.add(getJRadioButtonMasc());
			buttonGroupSexo.add(getJRadioButtonFem());
			
			jContentPane.add(getJRadioButtonMasc(), null);
			jContentPane.add(getJRadioButtonFem(), null);
			jContentPane.add(getJTextFieldEmail(), null);
			jContentPane.add(getJTextFieldFone(), null);
			jContentPane.add(getJTextFieldCelular(), null);
			jContentPane.add(getJTextFieldEndereco(), null);
			jContentPane.add(getJTextFieldCidade(), null);
			jContentPane.add(getJComboBoxUF(), null);
			jContentPane.add(getJComboBoxStatus(), null);
			jContentPane.add(getJButtonSalvar(), null);
			jContentPane.add(getJButtonExcluir(), null);
			jContentPane.add(getJButtonBuscar(), null);
			jContentPane.add(getJButtonCancelar(), null);
		}
		return jContentPane;
	}
	

	/**
	 * This method initializes jTextFieldCodigo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCodigo() {
		if (jTextFieldCodigo == null) {
			jTextFieldCodigo = new JTextField();
			jTextFieldCodigo.setEditable(false);
			jTextFieldCodigo.setLocation(new Point(70, 25));
			jTextFieldCodigo.setSize(new Dimension(50, 20));
		}
		return jTextFieldCodigo;
	}

	
	/**
	 * This method initializes jTextFieldNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNome() {
		if (jTextFieldNome == null) {
			jTextFieldNome = new JTextField();
			jTextFieldNome.setSize(new Dimension(200, 20));
			jTextFieldNome.setLocation(new Point(70, 50));
		}
		return jTextFieldNome;
	}

	
	/**
	 * This method initializes jTextFieldCPF	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCPF() {
		if (jTextFieldCPF == null) {
			jTextFieldCPF = new JTextField();
			jTextFieldCPF.setSize(new Dimension(100, 20));
			jTextFieldCPF.setLocation(new Point(70, 75));
		}
		return jTextFieldCPF;
	}

	
	/**
	 * This method initializes jTextFieldRG	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldRG() {
		if (jTextFieldRG == null) {
			jTextFieldRG = new JTextField();
			jTextFieldRG.setSize(new Dimension(100, 20));
			jTextFieldRG.setLocation(new Point(275, 75));
		}
		return jTextFieldRG;
	}

	
	/**
	 * This method initializes jRadioButtonMasc	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonMasc() {
		if (jRadioButtonMasc == null) {
			jRadioButtonMasc = new JRadioButton();
			jRadioButtonMasc.setText("Masculino");
			jRadioButtonMasc.setSize(new Dimension(83, 20));
			jRadioButtonMasc.setLocation(new Point(70, 100));
		}
		return jRadioButtonMasc;
	}

	
	/**
	 * This method initializes jRadioButtonFem	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonFem() {
		if (jRadioButtonFem == null) {
			jRadioButtonFem = new JRadioButton();
			jRadioButtonFem.setText("Feminino");
			jRadioButtonFem.setSize(new Dimension(76, 20));
			jRadioButtonFem.setLocation(new Point(160, 100));
		}
		return jRadioButtonFem;
	}

	
	/**
	 * This method initializes jTextFieldEmail	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldEmail() {
		if (jTextFieldEmail == null) {
			jTextFieldEmail = new JTextField();
			jTextFieldEmail.setSize(new Dimension(374, 20));
			jTextFieldEmail.setLocation(new Point(70, 125));
		}
		return jTextFieldEmail;
	}

	
	/**
	 * This method initializes jTextFieldFone	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldFone() {
		if (jTextFieldFone == null) {
			jTextFieldFone = new JTextField();
			jTextFieldFone.setSize(new Dimension(100, 20));
			jTextFieldFone.setLocation(new Point(70, 150));
		}
		return jTextFieldFone;
	}

	
	/**
	 * This method initializes jTextFieldCelular	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCelular() {
		if (jTextFieldCelular == null) {
			jTextFieldCelular = new JTextField();
			jTextFieldCelular.setSize(new Dimension(100, 20));
			jTextFieldCelular.setLocation(new Point(275, 150));
		}
		return jTextFieldCelular;
	}

	
	/**
	 * This method initializes jTextFieldEndereco	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldEndereco() {
		if (jTextFieldEndereco == null) {
			jTextFieldEndereco = new JTextField();
			jTextFieldEndereco.setLocation(new Point(70, 175));
			jTextFieldEndereco.setSize(new Dimension(374, 20));
		}
		return jTextFieldEndereco;
	}

	
	/**
	 * This method initializes jTextFieldCidade	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCidade() {
		if (jTextFieldCidade == null) {
			jTextFieldCidade = new JTextField();
			jTextFieldCidade.setSize(new Dimension(150, 20));
			jTextFieldCidade.setLocation(new Point(70, 200));
		}
		return jTextFieldCidade;
	}

	
	/**
	 * This method initializes jComboBoxUF	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxUF() {
		if (jComboBoxUF == null) {
			jComboBoxUF = new JComboBox();

			EstadoModel em = new EstadoModel();
			List<EstadoDTO> lista = null;
			int tamanho = 0;
			
			try {
				lista = em.listAll();
				tamanho = em.listAll().size();
			} catch (DAOException daoe) {
				JOptionPane.showMessageDialog(null, daoe.getMessage());
			}
			
			for (int i = 0; i < tamanho; i++) {
				jComboBoxUF.addItem(lista.get(i).getSigla());
			}
			
			jComboBoxUF.setLocation(new Point(275, 200));
			jComboBoxUF.setSize(new Dimension(50, 20));
		}
		return jComboBoxUF;
	}
	
	/**
	 * This method initializes jComboBoxStatus	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxStatus() {
		if (jComboBoxStatus == null) {
			jComboBoxStatus = new JComboBox();
			
			StatusModel sm = new StatusModel();
			List<StatusDTO> lista = null;
			int tamanhoLista = 0;
			
			
			try {
				lista = sm.listAll();
				tamanhoLista = sm.listAll().size();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
			for (int i = 0; i < tamanhoLista; i++) {
				jComboBoxStatus.addItem(lista.get(i).getDescricao());
			}			
			
			jComboBoxStatus.setLocation(new Point(307, 250));
			jComboBoxStatus.setSize(new Dimension(114, 20));
		}
		return jComboBoxStatus;
	}

	
	/**
	 * This method initializes jButtonSalvar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalvar() {
		if (jButtonSalvar == null) {
			jButtonSalvar = new JButton();
			jButtonSalvar.setLocation(new Point(8, 306));
			jButtonSalvar.setText("Salvar");
			jButtonSalvar.setMnemonic(KeyEvent.VK_S);
			jButtonSalvar.setSize(new Dimension(100, 30));
			jButtonSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salvar();
				}
			});
		}
		return jButtonSalvar;
	}

	
	/**
	 * This method initializes jButtonExcluir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonExcluir() {
		if (jButtonExcluir == null) {
			jButtonExcluir = new JButton();
			jButtonExcluir.setText("Excluir");
			jButtonExcluir.setSize(new Dimension(100, 30));
			jButtonExcluir.setMnemonic(KeyEvent.VK_E);
			jButtonExcluir.setLocation(new Point(227, 306));
			jButtonExcluir.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					excluir();
				}
			});
		}
		return jButtonExcluir;
	}

	
	/**
	 * Este método inicializa o jButtonBuscar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBuscar() {
		if (jButtonBuscar == null) {
			jButtonBuscar = new JButton();
			jButtonBuscar.setText("Buscar");
			jButtonBuscar.setSize(new Dimension(100, 30));
			jButtonBuscar.setMnemonic(KeyEvent.VK_B);
			jButtonBuscar.setLocation(new Point(116, 307));
			jButtonBuscar.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					abrirFrameBuscarCliente();
				}
			});
		}
		return jButtonBuscar;
	}
	
	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setLocation(new Point(340, 307));
			jButtonCancelar.setSize(new Dimension(100, 30));
			jButtonCancelar.setMnemonic(KeyEvent.VK_C);
			jButtonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonCancelar;
	}
	
	
	/**
	 * Método responsável por enviar os dados para a camada model
	 * quando o usuário clicar no botão Salvar.
	 */
	private void salvar() {
		
		ClienteDTO cliente = new ClienteDTO();

		cliente.setNome(jTextFieldNome.getText().toUpperCase());
		cliente.setCpf(jTextFieldCPF.getText());
		cliente.setRg(jTextFieldRG.getText());
		cliente.setFone(jTextFieldFone.getText());
		cliente.setCelular(jTextFieldCelular.getText());
		cliente.setEmail(jTextFieldEmail.getText().toUpperCase());
		cliente.setEndereco(jTextFieldEndereco.getText().toUpperCase());
		cliente.setCidade(jTextFieldCidade.getText().toUpperCase());
		cliente.setUf(jComboBoxUF.getSelectedIndex());
		cliente.setStatus(jComboBoxStatus.getSelectedIndex());
		
		if (jRadioButtonMasc.isSelected()) {
			cliente.setSexo('M');
		} else if (jRadioButtonFem.isSelected()) {
			cliente.setSexo('F');
		} else {
			cliente.setSexo(' ');
		}
		
		if (jTextFieldCodigo.getText() != null &&
				jTextFieldCodigo.getText().length() > 0);
		
		try {
			int codigo = Integer.parseInt(jTextFieldCodigo.getText());
			cliente.setCodigo(codigo);
			
			try {
				clienteModel.update(cliente);
			} catch (ErroValidacao ev) {
				JOptionPane.showMessageDialog(null, ev.getMessage());
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "O campo código contém um valor inválido");
		}
		
		try {
			
			clienteModel.insert(cliente);
			
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	
	/**
	 * Método responsável por enviar os dados para a camada model
	 * quando o usuário clicar no botão Excluir.
	 */
	private void excluir () {
		
		ClienteDTO cliente = new ClienteDTO();
		
		cliente.setNome(jTextFieldNome.getText().toUpperCase());
		cliente.setCpf(jTextFieldCPF.getText());
		cliente.setRg(jTextFieldRG.getText());
		cliente.setFone(jTextFieldFone.getText());
		cliente.setCelular(jTextFieldCelular.getText());
		cliente.setEmail(jTextFieldEmail.getText().toUpperCase());
		cliente.setEndereco(jTextFieldEndereco.getText().toUpperCase());
		cliente.setCidade(jTextFieldCidade.getText().toUpperCase());
		cliente.setUf(jComboBoxUF.getSelectedIndex());
		cliente.setStatus(jComboBoxStatus.getSelectedIndex());
		
		if (jRadioButtonMasc.isSelected()) {
			cliente.setSexo('M');
		} else if (jRadioButtonFem.isSelected()) {
			cliente.setSexo('F');
		} else {
			cliente.setSexo(' ');
		}
		
		try {
			
			clienteModel.delete(cliente);
			
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	/**
	 * Monta os dados de um cliente na com campos da tela.
	 * @param cliente Cliente anteriormente selecionado.
	 */
	public void populaTela(ClienteDTO cliente) {
		jTextFieldCodigo.setText(String.valueOf(cliente.getCodigo()));
		jTextFieldNome.setText(cliente.getNome());
		jTextFieldCPF.setText(cliente.getCpf());
		jTextFieldRG.setText(cliente.getRg());
		jTextFieldEmail.setText(cliente.getEmail());
		jTextFieldEndereco.setText(cliente.getEndereco());
		jTextFieldCidade.setText(cliente.getCidade());
		jTextFieldFone.setText(cliente.getFone());
		jTextFieldCelular.setText(cliente.getCelular());
		
		if (cliente.getSexo() == 'F') {
			jRadioButtonFem.setSelected(true);
		} else if (cliente.getSexo() == 'M') {
			jRadioButtonMasc.setSelected(true);
		}
		
		jComboBoxUF.setSelectedIndex(cliente.getUf());
		JOptionPane.showMessageDialog(null, cliente.getUf());
		jComboBoxStatus.setSelectedIndex(cliente.getStatus());
	}
	
	
	/**
	 * Método responsável por enviar os dados para a camada model
	 * quando o usuário clicar no botão Buscar.
	 */
	public void abrirFrameBuscarCliente () {
		BuscarCliente bc = new BuscarCliente(this);
		jp.getDesktopPane().add(bc);
		bc.setVisible(true);
	}

}