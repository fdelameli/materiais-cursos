package br.unisul.aula.interfacegrafica.view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unisul.aula.interfacegrafica.dao.DAOException;
import br.unisul.aula.interfacegrafica.dto.EstadoDTO;
import br.unisul.aula.interfacegrafica.dto.FuncionarioDTO;
import br.unisul.aula.interfacegrafica.model.EstadoModel;
import br.unisul.aula.interfacegrafica.model.FuncionarioModel;

public class ManterFuncionarios extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelCodigo = null;
	private JTextField jTextFieldCodigo = null;
	private JTextField jTextFieldNome = null;
	private JLabel jLabelNome = null;
	private JTextField jTextFieldCPF = null;
	private JLabel jLabelCPF = null;
	private JTextField jTextFieldPIS = null;
	private JLabel jLabelPIS = null;
	private JTextField jTextFieldDataAdmissao = null;
	private JLabel jLabelDataAdmissao = null;
	private JLabel jLabelEndereco = null;
	private JTextField jTextFieldEndereco = null;
	private JTextField jTextFieldNumero = null;
	private JLabel jLabelNumero = null;
	private JTextField jTextFieldCidade = null;
	private JLabel jLabelCidade = null;
	private JComboBox jComboBoxUF = null;
	private JLabel jLabelUF = null;
	private JTextField jTextFieldFone = null;
	private JTextField jTextFieldEmail = null;
	private JLabel jLabelEmail = null;
	private JLabel jLabelFone = null;
	private JButton jButtonSalvar = null;
	private JButton jButtonExcluir = null;
	private JButton jButtonBuscar = null;
	private FuncionarioModel funcionarioModel = null;
	private JanelaPrincipal jp = null;
	private JButton jButtonCancelar = null;
	
	
	/**
	 * This is the xxx default constructor
	 */
	public ManterFuncionarios() {
		super();
		initialize();
		this.funcionarioModel = new FuncionarioModel();
	}
	
	/**
	 * Construtor com parâmetros.
	 * @param jp
	 */
	public ManterFuncionarios(JanelaPrincipal jp) {
		super();
		initialize();
		this.funcionarioModel = new FuncionarioModel();
		this.jp = jp;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(475, 366);
		this.setTitle("Manter Funcionários");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(false);
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelFone = new JLabel();
			jLabelFone.setText("Telefone:");
			jLabelFone.setSize(new Dimension(52, 20));
			jLabelFone.setLocation(new Point(26, 175));
			jLabelEmail = new JLabel();
			jLabelEmail.setText("Email:");
			jLabelEmail.setSize(new Dimension(34, 20));
			jLabelEmail.setLocation(new Point(214, 175));
			jLabelUF = new JLabel();
			jLabelUF.setText("UF:");
			jLabelUF.setSize(new Dimension(17, 20));
			jLabelUF.setLocation(new Point(275, 150));
			jLabelCidade = new JLabel();
			jLabelCidade.setText("Cidade:");
			jLabelCidade.setSize(new Dimension(42, 20));
			jLabelCidade.setLocation(new Point(35, 150));
			jLabelNumero = new JLabel();
			jLabelNumero.setText("Número:");
			jLabelNumero.setSize(new Dimension(48, 20));
			jLabelNumero.setLocation(new Point(360, 125));
			jLabelEndereco = new JLabel();
			jLabelEndereco.setText("Endereço:");
			jLabelEndereco.setSize(new Dimension(57, 20));
			jLabelEndereco.setLocation(new Point(23, 125));
			jLabelDataAdmissao = new JLabel();
			jLabelDataAdmissao.setText("Data Adm.:");
			jLabelDataAdmissao.setSize(new Dimension(61, 20));
			jLabelDataAdmissao.setLocation(new Point(15, 100));
			jLabelPIS = new JLabel();
			jLabelPIS.setText("Pis:");
			jLabelPIS.setSize(new Dimension(21, 20));
			jLabelPIS.setLocation(new Point(275, 75));
			jLabelCPF = new JLabel();
			jLabelCPF.setText("Cpf:");
			jLabelCPF.setSize(new Dimension(22, 20));
			jLabelCPF.setLocation(new Point(51, 75));
			jLabelNome = new JLabel();
			jLabelNome.setText("Nome:");
			jLabelNome.setSize(new Dimension(36, 20));
			jLabelNome.setLocation(new Point(41, 50));
			jLabelCodigo = new JLabel();
			jLabelCodigo.setText("Código:");
			jLabelCodigo.setSize(new Dimension(42, 20));
			jLabelCodigo.setLocation(new Point(35, 25));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelCodigo, null);
			jContentPane.add(getJTextFieldCodigo(), null);
			jContentPane.add(getJTextFieldNome(), null);
			jContentPane.add(jLabelNome, null);
			jContentPane.add(getJTextFieldCPF(), null);
			jContentPane.add(jLabelCPF, null);
			jContentPane.add(getJTextFieldPIS(), null);
			jContentPane.add(jLabelPIS, null);
			jContentPane.add(getJTextFieldDataAdmissao(), null);
			jContentPane.add(jLabelDataAdmissao, null);
			jContentPane.add(jLabelEndereco, null);
			jContentPane.add(getJTextFieldEndereco(), null);
			jContentPane.add(getJTextFieldNumero(), null);
			jContentPane.add(jLabelNumero, null);
			jContentPane.add(getJTextFieldCidade(), null);
			jContentPane.add(jLabelCidade, null);
			jContentPane.add(getJComboBoxUF(), null);
			jContentPane.add(jLabelUF, null);
			jContentPane.add(getJTextFieldFone(), null);
			jContentPane.add(getJTextFieldEmail(), null);
			jContentPane.add(jLabelEmail, null);
			jContentPane.add(jLabelFone, null);
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
			jTextFieldCodigo.setLocation(new Point(80, 25));
			jTextFieldCodigo.setSize(new Dimension(50, 20));
			jTextFieldCodigo.setEditable(false);
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
			jTextFieldNome.setLocation(new Point(80, 50));
			jTextFieldNome.setSize(new Dimension(200, 20));
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
			jTextFieldCPF.setLocation(new Point(80, 75));
			jTextFieldCPF.setSize(new Dimension(100, 20));
		}
		return jTextFieldCPF;
	}

	/**
	 * This method initializes jTextFieldPIS	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldPIS() {
		if (jTextFieldPIS == null) {
			jTextFieldPIS = new JTextField();
			jTextFieldPIS.setLocation(new Point(300, 75));
			jTextFieldPIS.setSize(new Dimension(100, 20));
		}
		return jTextFieldPIS;
	}

	/**
	 * This method initializes jTextFieldDataAdmissao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDataAdmissao() {
		if (jTextFieldDataAdmissao == null) {
			jTextFieldDataAdmissao = new JTextField();
			jTextFieldDataAdmissao.setSize(new Dimension(100, 20));
			jTextFieldDataAdmissao.setLocation(new Point(80, 100));
			jTextFieldDataAdmissao.setEditable(false);
		}
		return jTextFieldDataAdmissao;
	}

	/**
	 * This method initializes jTextFieldEndereco	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldEndereco() {
		if (jTextFieldEndereco == null) {
			jTextFieldEndereco = new JTextField();
			jTextFieldEndereco.setLocation(new Point(80, 125));
			jTextFieldEndereco.setSize(new Dimension(250, 20));
		}
		return jTextFieldEndereco;
	}

	/**
	 * This method initializes jTextFieldNumero	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNumero() {
		if (jTextFieldNumero == null) {
			jTextFieldNumero = new JTextField();
			jTextFieldNumero.setLocation(new Point(410, 125));
			jTextFieldNumero.setSize(new Dimension(40, 20));
		}
		return jTextFieldNumero;
	}

	/**
	 * This method initializes jTextFieldCidade	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCidade() {
		if (jTextFieldCidade == null) {
			jTextFieldCidade = new JTextField();
			jTextFieldCidade.setLocation(new Point(80, 150));
			jTextFieldCidade.setSize(new Dimension(100, 20));
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
			jComboBoxUF.setLocation(new Point(300, 150));
			jComboBoxUF.setSize(new Dimension(50, 20));
			
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
			
		}
		return jComboBoxUF;
	}

	/**
	 * This method initializes jTextFieldFone	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldFone() {
		if (jTextFieldFone == null) {
			jTextFieldFone = new JTextField();
			jTextFieldFone.setLocation(new Point(80, 175));
			jTextFieldFone.setSize(new Dimension(100, 20));
		}
		return jTextFieldFone;
	}

	/**
	 * This method initializes jTextFieldEmail	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldEmail() {
		if (jTextFieldEmail == null) {
			jTextFieldEmail = new JTextField();
			jTextFieldEmail.setLocation(new Point(250, 175));
			jTextFieldEmail.setSize(new Dimension(200, 20));
		}
		return jTextFieldEmail;
	}

	/**
	 * This method initializes jButtonSalvar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalvar() {
		if (jButtonSalvar == null) {
			jButtonSalvar = new JButton();
			jButtonSalvar.setText("Salvar");
			jButtonSalvar.setLocation(new Point(15, 250));
			jButtonSalvar.setSize(new Dimension(100, 30));
			jButtonSalvar.setMnemonic(KeyEvent.VK_S);
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
			jButtonExcluir.setLocation(new Point(123, 251));
			jButtonExcluir.setText("Excluir");
			jButtonExcluir.setMnemonic(KeyEvent.VK_E);
			jButtonExcluir.setSize(new Dimension(100, 30));
			jButtonExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					excluir();
				}
			});
		}
		return jButtonExcluir;
	}

	/**
	 * This method initializes jButtonBuscar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBuscar() {
		if (jButtonBuscar == null) {
			jButtonBuscar = new JButton();
			jButtonBuscar.setText("Buscar");
			jButtonBuscar.setSize(new Dimension(100, 30));
			jButtonBuscar.setMnemonic(KeyEvent.VK_B);
			jButtonBuscar.setLocation(new Point(234, 251));
			jButtonBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					abrirFrameBuscarFuncionario();	
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
			jButtonCancelar.setLocation(new Point(343, 251));
			jButtonCancelar.setSize(new Dimension(100, 30));
			jButtonCancelar.setMnemonic(KeyEvent.VK_B);
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
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
		FuncionarioDTO funcionario = new FuncionarioDTO();

		funcionario.setNome(jTextFieldNome.getText().toUpperCase());
		funcionario.setCpf(jTextFieldCPF.getText());
		funcionario.setPis(jTextFieldPIS.getText());
		funcionario.setDataCadastro(new Date());
		funcionario.setEndereco(jTextFieldEndereco.getText().toUpperCase());
		funcionario.setNumero(Integer.parseInt(jTextFieldNumero.getText()));
		funcionario.setCidade(jTextFieldCidade.getText().toUpperCase());
		funcionario.setUf(jComboBoxUF.getSelectedIndex());
		funcionario.setEmail(jTextFieldEmail.getText().toUpperCase());
		funcionario.setFone(jTextFieldFone.getText());
	
		try {
			
			funcionarioModel.insert(funcionario);
			
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Método responsável por enviar os dados para a camada moodel
	 * quando o usuário clicar no botão excluir.
	 */
	private void excluir(){
		
		FuncionarioDTO funcionario = new FuncionarioDTO();
		
		funcionario.setCidade(jTextFieldCidade.getText().toUpperCase());
		funcionario.setCpf(jTextFieldCPF.getText());
		funcionario.setDataCadastro(new Date());
		funcionario.setEmail(jTextFieldEmail.getText().toUpperCase());
		funcionario.setEndereco(jTextFieldEndereco.getText().toUpperCase());
		funcionario.setFone(jTextFieldFone.getText());
		funcionario.setNome(jTextFieldNome.getText().toUpperCase());
		funcionario.setNumero(Integer.parseInt(jTextFieldNumero.getText()));
		funcionario.setPis(jTextFieldPIS.getText());
		funcionario.setUf(jComboBoxUF.getSelectedIndex());
		
		
		
		try {
			
			funcionarioModel.delete(funcionario);
			
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	
	
	/**
	 * Abre a Janela de busca de funcionarios.
	 */
	public void abrirFrameBuscarFuncionario() {
		BuscarFuncionario bf = new BuscarFuncionario(this);
		jp.getDesktopPane().add(bf);
		bf.setVisible(true);
	}
	
	
	/**
	 * Método que monta na tela os dados do objeto selecionao;
	 * @param func
	 */
	public void populaTela(FuncionarioDTO func) {
		jTextFieldCodigo.setText(String.valueOf(func.getCodigo()));
		jTextFieldNome.setText(func.getNome());
		jTextFieldCPF.setText(func.getCpf());
		jTextFieldPIS.setText(func.getPis());
		jTextFieldDataAdmissao.setText(String.valueOf(func.getDataCadastro()));
		jTextFieldEndereco.setText(func.getEndereco());
		jTextFieldNumero.setText(String.valueOf(func.getNumero()));
		jTextFieldCidade.setText(func.getCidade());
		jComboBoxUF.setSelectedIndex(func.getUf());
		jTextFieldFone.setText(func.getFone());
		jTextFieldEmail.setText(func.getEmail());
	}


} 
