package br.unisul.aula.interfacegrafica.view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.unisul.aula.interfacegrafica.dao.DAOException;
import br.unisul.aula.interfacegrafica.dto.ClienteDTO;
import br.unisul.aula.interfacegrafica.model.ClienteModel;

public class BuscarCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane = null;
	private JLabel jLabelBuscar = null;
	private JTextField jTextFieldParametroBusca = null;
	private JButton jButtonBuscar = null;
	private JScrollPane jScrollPaneTabela = null;
	private JTable jTableCliente = null;
	private JButton jButtonSelecionar = null;
	private ClienteModel clienteModel = null;
	private ManterCliente mc = null;
	private List<ClienteDTO> lista = null;

	private JButton jButtonCancelar = null;
	
	
	/**
	 * Construtor default.
	 */
	public BuscarCliente() {
		super();
		this.clienteModel = new ClienteModel();
		initialize();
	}
	
	/**
	 * Construtor com parâmetros.
	 * @param mc
	 */
	public BuscarCliente(ManterCliente mc) {
		super();
		this.clienteModel = new ClienteModel();
		initialize();
		this.mc = mc;
	}
	
	

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(599, 342);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(false);
		this.setResizable(false);
		this.setTitle("Buscar Clientes");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelBuscar = new JLabel();
			jLabelBuscar.setText("Buscar:");
			jLabelBuscar.setSize(new Dimension(44, 20));
			jLabelBuscar.setLocation(new Point(31, 34));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelBuscar, null);
			jContentPane.add(getJTextFieldParametroBusca(), null);
			jContentPane.add(getJButtonBuscar(), null);
			jContentPane.add(getJScrollPaneTabela(), null);
			jContentPane.add(getJButtonSelecionar(), null);
			jContentPane.add(getJButtonCancelar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextFieldParametroBusca	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldParametroBusca() {
		if (jTextFieldParametroBusca == null) {
			jTextFieldParametroBusca = new JTextField();
			jTextFieldParametroBusca.setLocation(new Point(82, 34));
			jTextFieldParametroBusca.setSize(new Dimension(200, 20));
			jTextFieldParametroBusca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		return jTextFieldParametroBusca;
	}

	/**
	 * This method initializes jButtonBuscar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBuscar() {
		if (jButtonBuscar == null) {
			jButtonBuscar = new JButton();
			jButtonBuscar.setLocation(new Point(299, 34));
			jButtonBuscar.setText("Buscar");
			jButtonBuscar.setMnemonic(KeyEvent.VK_B);
			jButtonBuscar.setSize(new Dimension(75, 20));
			jButtonBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					efetuarPesquisa();
				}
			});
		}
		return jButtonBuscar;
	}

	/**
	 * This method initializes jScrollPaneTabela	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneTabela() {
		if (jScrollPaneTabela == null) {
			jScrollPaneTabela = new JScrollPane();
			jScrollPaneTabela.setBounds(new Rectangle(6, 70, 578, 202));
			jScrollPaneTabela.setViewportView(getJTableCliente());
		}
		return jScrollPaneTabela;
	}

	/**
	 * This method initializes jTableCliente	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableCliente() {
		if (jTableCliente == null) {
			jTableCliente = new JTable();
			jTableCliente.setModel(new DefaultTableModel (
				new Object [][]{},
				new String[] {"Código", "Nome", "CPF"}
			));
			jTableCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return jTableCliente;
	}

	/**
	 * This method initializes jButtonSelecionar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSelecionar() {
		if (jButtonSelecionar == null) {
			jButtonSelecionar = new JButton();
			jButtonSelecionar.setMnemonic(KeyEvent.VK_S);
			jButtonSelecionar.setLocation(new Point(379, 282));
			jButtonSelecionar.setSize(new Dimension(100, 20));
			jButtonSelecionar.setText("Selecionar");
			jButtonSelecionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int linha = jTableCliente.getSelectedRow();
										
					setarValores(linha);
				}
			});
		}
		return jButtonSelecionar;
	}
	
	
	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setLocation(new Point(490, 282));
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setSize(new Dimension(85, 20));
			jButtonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return jButtonCancelar;
	}
	
	
	/**
	 * Método que efetua uma busca quando o usuário
	 * clicar no botão buscar.
	 */
	public void efetuarPesquisa() {
		String nome = jTextFieldParametroBusca.getText();
		
		try {
			
			lista = clienteModel.find(nome);
			DefaultTableModel dtm = (DefaultTableModel) jTableCliente.getModel();
			
			
			//limpa a tabela.
			
			while (dtm.getRowCount() != 0) {
				dtm.removeRow(0);
			}
			
			//adiciona os elementos na tabela.
			for (ClienteDTO clienteDTO : lista) {
				dtm.addRow(new Object[] {
						clienteDTO.getCodigo(),
						clienteDTO.getNome(),
						clienteDTO.getCpf() }
				);
			}
			
		} catch (DAOException daoe) {
			JOptionPane.showMessageDialog(null, "Erro ao efetuar a busca:\n" + 
					daoe.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	/**
	 * Retorna dados para a tela de manter clientes.
	 */
	public void setarValores(int linha) {
		mc.populaTela(lista.get(linha));
		dispose();
	}

}  
