package br.unisul.aula.interfacegrafica.view;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unisul.aula.interfacegrafica.dto.ClienteDTO;
import br.unisul.aula.interfacegrafica.dto.QuartoDTO;
import br.unisul.aula.interfacegrafica.dto.ReservaDTO;
import br.unisul.aula.interfacegrafica.model.ClienteModel;
import br.unisul.aula.interfacegrafica.model.QuartoModel;
import br.unisul.aula.interfacegrafica.model.ReservaModel;

public class ManterReserva extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField jTextFieldCodigo = null;
	private JLabel jLabelCodigo = null;
	private JComboBox jComboBoxCliente = null;
	private JLabel jLabelCliente = null;
	private JComboBox jComboBoxQuarto = null;
	private JLabel jLabelQuarto = null;
	private JLabel jLabelDataEntrada = null;
	private JTextField jTextFieldDataEntrada = null;
	private JLabel jLabelDataSaida = null;
	private JTextField jTextFieldDataSaida = null;
	private JButton jButtonSalvar = null;
	private JButton jButtonExcluir = null;
	private JButton jButtonBuscar = null;
	private JButton jButtonCancelar = null;
	private ReservaModel reservaModel = null;
	private JanelaPrincipal jp = null;
	
	/**
	 * This is the xxx default constructor
	 */
	public ManterReserva() {
		super("Manter Reserva");
		initialize();
		reservaModel = new ReservaModel();
	}
	
	public ManterReserva(JanelaPrincipal jp) {
		super();
		initialize();
		reservaModel = new ReservaModel();
		this.jp = jp;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(489, 300);
		this.setTitle("Manter Reservas");
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
			jLabelDataSaida = new JLabel();
			jLabelDataSaida.setText("Data Saída:");
			jLabelDataSaida.setSize(new Dimension(64, 20));
			jLabelDataSaida.setLocation(new Point(26, 125));
			jLabelDataEntrada = new JLabel();
			jLabelDataEntrada.setText("Data Entrada:");
			jLabelDataEntrada.setSize(new Dimension(76, 20));
			jLabelDataEntrada.setLocation(new Point(14, 100));
			jLabelQuarto = new JLabel();
			jLabelQuarto.setText("Quarto:");
			jLabelQuarto.setSize(new Dimension(42, 20));
			jLabelQuarto.setLocation(new Point(44, 75));
			jLabelCliente = new JLabel();
			jLabelCliente.setText("Cliente:");
			jLabelCliente.setSize(new Dimension(42, 20));
			jLabelCliente.setLocation(new Point(45, 50));
			jLabelCodigo = new JLabel();
			jLabelCodigo.setText("Código:");
			jLabelCodigo.setSize(new Dimension(42, 20));
			jLabelCodigo.setLocation(new Point(45, 25));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextFieldCodigo(), null);
			jContentPane.add(jLabelCodigo, null);
			jContentPane.add(getJComboBoxCliente(), null);
			jContentPane.add(jLabelCliente, null);
			jContentPane.add(getJComboBoxQuarto(), null);
			jContentPane.add(jLabelQuarto, null);
			jContentPane.add(jLabelDataEntrada, null);
			jContentPane.add(getJTextFieldDataEntrada(), null);
			jContentPane.add(jLabelDataSaida, null);
			jContentPane.add(getJTextFieldDataSaida(), null);
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
			jTextFieldCodigo.setLocation(new Point(90, 25));
			jTextFieldCodigo.setSize(new Dimension(50, 20));
		}
		return jTextFieldCodigo;
	}

	/**
	 * This method initializes jComboBoxCliente	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxCliente() {
		if (jComboBoxCliente == null) {
			jComboBoxCliente = new JComboBox();
			jComboBoxCliente.setLocation(new Point(90, 50));
			jComboBoxCliente.setSize(new Dimension(175, 20));
			
			ClienteModel cm = new ClienteModel();
			List<ClienteDTO> lista = null;
			int tamanho = 0;
			
			try {
				lista = cm.listAll();
				tamanho = cm.listAll().size();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
			for (int i = 0; i < tamanho; i++) {
				jComboBoxCliente.addItem(lista.get(i).getNome());
			}
			
		}
		return jComboBoxCliente;
	}

	/**
	 * This method initializes jComboBoxQuarto	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxQuarto() {
		if (jComboBoxQuarto == null) {
			jComboBoxQuarto = new JComboBox();
			jComboBoxQuarto.setLocation(new Point(90, 75));
			jComboBoxQuarto.setSize(new Dimension(75, 20));
			
			QuartoModel qm = new QuartoModel();
			List<QuartoDTO> lista = null;
			int tamanho = 0;
			
			try {
				lista = qm.find();
				tamanho = qm.find().size();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
			for (int i = 0; i < tamanho; i++) {
				jComboBoxQuarto.addItem(lista.get(i).getNumero());
			}
			
		}
		return jComboBoxQuarto;
	}

	/**
	 * This method initializes jTextFieldDataEntrada	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDataEntrada() {
		if (jTextFieldDataEntrada == null) {
			jTextFieldDataEntrada = new JTextField();
			jTextFieldDataEntrada.setSize(new Dimension(100, 20));
			jTextFieldDataEntrada.setLocation(new Point(90, 100));
		}
		return jTextFieldDataEntrada;
	}

	/**
	 * This method initializes jTextFieldDataSaida	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDataSaida() {
		if (jTextFieldDataSaida == null) {
			jTextFieldDataSaida = new JTextField();
			jTextFieldDataSaida.setSize(new Dimension(100, 20));
			jTextFieldDataSaida.setLocation(new Point(90, 125));
		}
		return jTextFieldDataSaida;
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
			jButtonSalvar.setSize(new Dimension(100, 30));
			jButtonSalvar.setLocation(new Point(25, 200));
			jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
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
			jButtonExcluir.setLocation(new Point(250, 200));
			jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
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
			jButtonBuscar.setLocation(new Point(137, 200));
			jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					buscar();
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
			jButtonCancelar.setSize(new Dimension(100, 30));
			jButtonCancelar.setLocation(new Point(363, 201));
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
	public void salvar(){
		
		ReservaDTO reserva = new ReservaDTO();
		
		reserva.setCliente(jComboBoxCliente.getSelectedIndex());
		reserva.setDataEntrada(new Date());
		reserva.setDataSaida(new Date());
		reserva.setQuarto(jComboBoxQuarto.getSelectedIndex());
		
		try {
			reservaModel.insert(reserva);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	/**
	 * Método responsável por enviar os dados para a camada model
	 * quando o usuário clicar no botão Excluir.
	 */
	public void excluir(){
		
		ReservaDTO reserva = new ReservaDTO();
		
		reserva.setCliente(jComboBoxCliente.getSelectedIndex());
		reserva.setDataEntrada(new Date());
		reserva.setDataSaida(new Date());
		reserva.setQuarto(jComboBoxQuarto.getSelectedIndex());
		
		try {
			reservaModel.delete(reserva);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	/**
	 * Método responsável por enviar os dados para a camada model
	 * quando o usuário clicar no botão Buscar.
	 */
	public void buscar(){
	
		BuscarReserva br = new BuscarReserva(this);
		jp.getDesktopPane().add(br);
		br.setVisible(true);
	}
	
	
	public void populaTela(ReservaDTO reserva) {
		jTextFieldCodigo.setText(String.valueOf(reserva.getCodigo()));
		jTextFieldDataEntrada.setText(String.valueOf(reserva.getDataEntrada()));
		jTextFieldDataSaida.setText(String.valueOf(reserva.getDataSaida()));
		jComboBoxCliente.setSelectedIndex(reserva.getCliente());
		jComboBoxQuarto.setSelectedIndex(reserva.getQuarto());
	}
}  
