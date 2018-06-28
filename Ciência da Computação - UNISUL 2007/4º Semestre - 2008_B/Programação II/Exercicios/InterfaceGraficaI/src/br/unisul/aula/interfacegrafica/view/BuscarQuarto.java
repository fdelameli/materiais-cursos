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
import br.unisul.aula.interfacegrafica.dto.QuartoDTO;
import br.unisul.aula.interfacegrafica.model.QuartoModel;

public class BuscarQuarto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane = null;
	private JLabel jLabelBuscar = null;
	private JTextField jTextFieldParametroBusca = null;
	private JButton jButtonBuscar = null;
	private JScrollPane jScrollPaneBuscar = null;
	private JTable jTableBuscar = null;
	private JButton jButtonSelecionar = null;
	private QuartoModel quartoModel = null;
	private ManterQuarto mq = null;
	private List<QuartoDTO> lista = null;

	private JButton jButtonCancelar = null;

	/**
	 * This is the xxx default constructor
	 */
	public BuscarQuarto() {
		super();
		this.quartoModel = new QuartoModel();
		initialize();
	}
	
	public BuscarQuarto(ManterQuarto mq) {
		super();
		this.quartoModel = new QuartoModel();
		initialize();
		this.mq = mq;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setBounds(new Rectangle(0, 0, 599, 359));
		this.setTitle("Buscar Quarto");
		this.setPreferredSize(new Dimension(101, 34));
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
			jLabelBuscar = new JLabel();
			jLabelBuscar.setBounds(new Rectangle(31, 34, 48, 20));
			jLabelBuscar.setName("");
			jLabelBuscar.setPreferredSize(new Dimension(44, 16));
			jLabelBuscar.setText("Buscar:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelBuscar, null);
			jContentPane.add(getJTextFieldParametroBusca(), null);
			jContentPane.add(getJButtonBuscar(), null);
			jContentPane.add(getJScrollPaneBuscar(), null);
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
			jButtonBuscar.setMnemonic(KeyEvent.VK_B);
			jButtonBuscar.setPreferredSize(new Dimension(75, 26));
			jButtonBuscar.setText("Buscar");
			jButtonBuscar.setActionCommand("Buscar");
			
		}
		return jButtonBuscar;
	}

	/**
	 * This method initializes jScrollPaneBuscar	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneBuscar() {
		if (jScrollPaneBuscar == null) {
			jScrollPaneBuscar = new JScrollPane();
			jScrollPaneBuscar.setBounds(new Rectangle(13, 113, 569, 181));
			jScrollPaneBuscar.setViewportView(getJTableBuscar());
		}
		return jScrollPaneBuscar;
	}

	/**
	 * This method initializes jTableBuscar	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableBuscar() {
		if (jTableBuscar == null) {
			jTableBuscar = new JTable();
			jTableBuscar.setModel(new DefaultTableModel(
					new Object[][]{},
					new String[] {"Código", "Número", "Descrição", "Valor Diária", "Ocupado"}));
			jTableBuscar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jTableBuscar.setLocation(new Point(0, 0));
			jTableBuscar.setSize(new Dimension(575, 0));
			jTableBuscar.setPreferredSize(new Dimension(225, 00));
		}
		return jTableBuscar;
	}

	/**
	 * This method initializes jButtonSelecionar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSelecionar() {
		if (jButtonSelecionar == null) {
			jButtonSelecionar = new JButton();
			jButtonSelecionar.setText("Selecionar");
			jButtonSelecionar.setSize(new Dimension(100, 20));
			jButtonSelecionar.setMnemonic(KeyEvent.VK_S);
			jButtonSelecionar.setLocation(new Point(377, 300));
			jButtonSelecionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int linha = jTableBuscar.getSelectedRow();
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
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setSize(new Dimension(85, 20));
			jButtonCancelar.setLocation(new Point(484, 300));
			jButtonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return jButtonCancelar;
	}
	
	
	
	public void efetuarPesquisaQuarto(){
		
		try{
			List<QuartoDTO> listaQuarto = quartoModel.find();
			DefaultTableModel dtm = (DefaultTableModel) jTableBuscar.getModel();
			
			int qtdLinhas = dtm.getRowCount();
			for (int i = 0; i < qtdLinhas; i++) {
				dtm.removeRow(i);
			}
			
			for (QuartoDTO quarto : listaQuarto) {
				dtm.addRow(new Object[] {
						quarto.getCodigo(),
						quarto.getNumero(), 
						quarto.getDescricao(),
						quarto.getValorDiaria(),
						quarto.isOcupado()
						});
	        }
			
		}catch (DAOException daoe) {
			JOptionPane.showMessageDialog(null, "Erro ao efetuar a busca:\n" + 
					daoe.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public void setarValores(int linha) {
		mq.populaTela(lista.get(linha));
		dispose();
	}
	
	
} 
