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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.unisul.aula.interfacegrafica.dto.QuartoDTO;
import br.unisul.aula.interfacegrafica.model.QuartoModel;

public class BuscarQuarto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneBuscar = null;
	private JTable jTableBuscar = null;
	private JButton jButtonSelecionar = null;
	private QuartoModel quartoModel = null;
	private ManterQuarto mq = null;
	private List<QuartoDTO> listaQuarto = null;  //  @jve:decl-index=0:
	private JButton jButtonCancelar = null;

	private JButton jButtonBuscar = null;

	
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
		this.setBounds(new Rectangle(0, 0, 599, 300));
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
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPaneBuscar(), null);
			jContentPane.add(getJButtonSelecionar(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(getJButtonBuscar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneBuscar	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneBuscar() {
		if (jScrollPaneBuscar == null) {
			jScrollPaneBuscar = new JScrollPane();
			jScrollPaneBuscar.setBounds(new Rectangle(13, 15, 569, 181));
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
			jButtonSelecionar.setLocation(new Point(377, 225));
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
	 * This method initializes jButtonBuscar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBuscar() {
		if (jButtonBuscar == null) {
			jButtonBuscar = new JButton();
			jButtonBuscar.setText("Buscar");
			jButtonBuscar.setSize(new Dimension(75, 20));
			jButtonBuscar.setLocation(new Point(295, 225));
			jButtonBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					efetuarPesquisaQuarto();
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
			jButtonCancelar.setSize(new Dimension(85, 20));
			jButtonCancelar.setLocation(new Point(484, 225));
			jButtonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return jButtonCancelar;
	}
	
	
	/**
	 * Método para efetuar a pesquisa no banco.
	 */
	public void efetuarPesquisaQuarto(){
		
		try{
			
			listaQuarto = quartoModel.find();
			DefaultTableModel dtm = (DefaultTableModel) jTableBuscar.getModel();
			
			while(dtm.getRowCount() != 0) {
				dtm.removeRow(0);
			}
			
			for (QuartoDTO quarto : listaQuarto) {
				dtm.addRow(new Object[] {
						quarto.getCodigo(),
						quarto.getNumero(), 
						quarto.getDescricao(),
						quarto.getValorDiaria(),
						quarto.getOcupado()
				});
	        }
			
			JOptionPane.showMessageDialog(null, jTableBuscar.getValueAt(1, 1));
			
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao efetuar a busca:\n" + 
					e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	/**
	 * Método para setar os valores na tela.
	 * @param linha Linha seleciona.
	 */
	public void setarValores(int linha) {
		mq.populaTela(listaQuarto.get(linha));
		dispose();
	}

	
	
} 
