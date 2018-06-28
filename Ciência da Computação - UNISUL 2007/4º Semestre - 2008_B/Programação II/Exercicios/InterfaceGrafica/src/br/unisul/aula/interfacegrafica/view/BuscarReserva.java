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
import br.unisul.aula.interfacegrafica.dto.QuartoDTO;
import br.unisul.aula.interfacegrafica.dto.ReservaDTO;
import br.unisul.aula.interfacegrafica.model.ClienteModel;
import br.unisul.aula.interfacegrafica.model.QuartoModel;
import br.unisul.aula.interfacegrafica.model.ReservaModel;

public class BuscarReserva extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelBuscar = null;
	private JTextField jTextFieldParametroBusca = null;
	private JButton jButtonBuscar = null;
	private JScrollPane jScrollPane = null;
	private JTable jTableReserva = null;
	private JButton jButtonSelecionar = null;
	private ReservaModel reservaModel = null;
	private ManterReserva mr = null;
	private JButton jButtonCancelar = null;
	private String manterReservaNomeCliente = "";
	
	private List<ClienteDTO> listaClientes = null;
	private List<QuartoDTO> listaQuartos = null;
	
	

	/**
	 * This is the xxx default constructor
	 */
	public BuscarReserva() {
		super();
		initialize();
		reservaModel = new ReservaModel();
	}
	
	public BuscarReserva(ManterReserva mr, String nome) {
		super();
		this.reservaModel = new ReservaModel();
		this.manterReservaNomeCliente = nome;
		initialize();
		this.mr = mr;
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setBounds(new Rectangle(0, 0, 599, 342));
		this.setTitle("Buscar Reserva");
		this.setIconifiable(true);
		this.setClosable(true);
		this.setContentPane(getJContentPane());
		JOptionPane.showMessageDialog(null, manterReservaNomeCliente);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelBuscar = new JLabel();
			jLabelBuscar.setBounds(new Rectangle(31, 34, 44, 20));
			jLabelBuscar.setPreferredSize(new Dimension(44, 16));
			jLabelBuscar.setText("Buscar:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelBuscar, null);
			jContentPane.add(getJTextFieldParametroBusca(), null);
			jContentPane.add(getJButtonBuscar(), null);
			jContentPane.add(getJScrollPane(), null);
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
			jTextFieldParametroBusca.setBounds(new Rectangle(82, 34, 200, 20));
			jTextFieldParametroBusca.setText(manterReservaNomeCliente);
			jTextFieldParametroBusca.setEditable(false);
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
			jButtonBuscar.setBounds(new Rectangle(299, 34, 75, 20));
			jButtonBuscar.setPreferredSize(new Dimension(75, 26));
			jButtonBuscar.setMnemonic(KeyEvent.VK_B);
			jButtonBuscar.setText("Buscar");
			jButtonBuscar.setActionCommand("Buscar");
			jButtonBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					efetuarPesquisa();
				}
			});
		}
		return jButtonBuscar;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(34, 108, 542, 153));
			jScrollPane.setViewportView(getJTableReserva());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTableReserva	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableReserva() {
		if (jTableReserva == null) {
			jTableReserva = new JTable();
			jTableReserva.setModel(new DefaultTableModel (
					new Object[][]{},
					new String[] {"Código", "Cliente", "Nº Quarto", "Data Entrada", "DataSaída"}));
			jTableReserva.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTableReserva.setLocation(new Point(0, 0));
			jTableReserva.setSize(new Dimension(575, 0));
			jTableReserva.setPreferredSize(new Dimension(225, 0));
		}
		return jTableReserva;
	}

	/**
	 * This method initializes jButtonSelecionar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSelecionar() {
		if (jButtonSelecionar == null) {
			jButtonSelecionar = new JButton();
			jButtonSelecionar.setBounds(new Rectangle(381, 275, 100, 20));
			jButtonSelecionar.setMnemonic(KeyEvent.VK_S);
			jButtonSelecionar.setPreferredSize(new Dimension(95, 26));
			jButtonSelecionar.setText("Selecionar");
			jButtonSelecionar.setActionCommand("Selecionar");
			jButtonSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = jTableReserva.getSelectedRow();
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
			jButtonCancelar.setLocation(new Point(492, 275));
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
	
	
	
	public void efetuarPesquisa() {
		String nome = jTextFieldParametroBusca.getText();
		
		try {
			
			List<ReservaDTO> lista = reservaModel.find(nome);
			DefaultTableModel dtm = (DefaultTableModel) jTableReserva.getModel();
			
			//limpa a tabela.
			
			while (dtm.getRowCount() != 0) {
				dtm.removeRow(0);
			}
			
			ClienteModel cm = new ClienteModel();
			listaClientes = cm.listAll();
			
			QuartoModel qm = new QuartoModel();
			listaQuartos = qm.find();
			 
			
			String nomeCliente = "";
			int numeroQuarto = -1;
			//adiciona os elementos na tabela.
			for (int i = 0; i < lista.size(); i++) {
				
				
				System.out.println(lista.get(i).getCodigo());
				
//				for (int j = 0; i < listaClientes.size(); i++) {
//					if (lista.get(i).getCliente() == listaClientes.get(j).getCodigo()) {
//						nomeCliente = listaClientes.get(j).getNome();
//					}
//				}
//				
//				for (int k = 0; i < listaClientes.size(); i++) {
//					if (lista.get(i).getQuarto() == listaQuartos.get(k).getCodigo()) {
//						numeroQuarto = listaQuartos.get(k).getNumero();
//					}
//				}
				
				dtm.addRow(new Object[] {
						lista.get(i).getCodigo(),
						lista.get(i).getCliente(),
						lista.get(i).getQuarto(),
						lista.get(i).getDataEntrada(),
						lista.get(i).getDataSaida()}
				);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao efetuar a busca:\n" + 
					e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	public void setarValores(int linha) {
		
	}


}
