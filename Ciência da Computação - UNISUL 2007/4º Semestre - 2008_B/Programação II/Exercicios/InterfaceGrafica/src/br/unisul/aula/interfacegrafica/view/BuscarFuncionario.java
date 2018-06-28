package br.unisul.aula.interfacegrafica.view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import br.unisul.aula.interfacegrafica.dto.FuncionarioDTO;
import br.unisul.aula.interfacegrafica.model.FuncionarioModel;

public class BuscarFuncionario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelNome = null;
	private JTextField jTextFieldParametroBusca = null;
	private JButton jButtonBuscar = null;
	private JScrollPane jScrollPaneFuncionario = null;
	private JTable jTableFuncionario = null;
	private JButton jButtonCancelar = null;
	private JButton jButtonSelecionar = null;
	private FuncionarioModel funcionarioModel = null;
	private ManterFuncionarios mf = null;
	private List<FuncionarioDTO> lista = null;
	
	
	/**
	 * Construtor default.
	 */
	public BuscarFuncionario() {
		super();
		funcionarioModel = new FuncionarioModel();
		initialize();
	}
	
	/**
	 * Construtor com parâmetros.
	 * @param mf
	 */
	public BuscarFuncionario(ManterFuncionarios mf) {
		super();
		this.mf = mf;
		funcionarioModel = new FuncionarioModel();
		initialize();
	}
	
	

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(585, 330);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setTitle("Buscar Funcionários");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelNome = new JLabel();
			jLabelNome.setText("Nome:");
			jLabelNome.setSize(new Dimension(36, 20));
			jLabelNome.setLocation(new Point(25, 25));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelNome, null);
			jContentPane.add(getJTextFieldParametroBusca(), null);
			jContentPane.add(getJButtonBuscar(), null);
			jContentPane.add(getJScrollPaneFuncionario(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(getJButtonSelecionar(), null);
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
			jTextFieldParametroBusca.setLocation(new Point(64, 25));
			jTextFieldParametroBusca.setSize(new Dimension(200, 20));
			jTextFieldParametroBusca.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
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
			jButtonBuscar.setText("Buscar");
			jButtonBuscar.setSize(new Dimension(75, 20));
			jButtonBuscar.setLocation(new Point(284, 25));
			jButtonBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buscar();
				}
			});
		}
		return jButtonBuscar;
	}

	/**
	 * This method initializes jScrollPaneFuncionario	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneFuncionario() {
		if (jScrollPaneFuncionario == null) {
			jScrollPaneFuncionario = new JScrollPane();
			jScrollPaneFuncionario.setBounds(new Rectangle(5, 60, 563, 202));
			jScrollPaneFuncionario.setViewportView(getJTableFuncionario());
		}
		return jScrollPaneFuncionario;
	}

	/**
	 * This method initializes jTableFuncionario	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableFuncionario() {
		if (jTableFuncionario == null) {
			jTableFuncionario = new JTable();
			jTableFuncionario.setModel(new DefaultTableModel(
				new Object[][]{},
				new String[] {"Código", "Nome", "CPF"} 
			));
			jTableFuncionario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return jTableFuncionario;
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
			jButtonCancelar.setSize(new Dimension(100, 20));
			jButtonCancelar.setLocation(new Point(457, 270));
			jButtonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonCancelar;
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
			jButtonSelecionar.setLocation(new Point(346, 270));
			jButtonSelecionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int linha = jTableFuncionario.getSelectedRow();
					setarValores(linha);
				}
			});
		}
		return jButtonSelecionar;
	}
	
	
	
	/**
	 * Método responsável pela ação do botão buscar,
	 * ou quando o cursor estiver no campo de texto
	 * onde digita-se o nome, e o usuário teclar 'Enter'.
	 *
	 */
	public void buscar () {
		String nome = jTextFieldParametroBusca.getText();
		
		try {
			
			lista = funcionarioModel.find(nome);
			DefaultTableModel dtm = (DefaultTableModel) jTableFuncionario.getModel();
			
			
			while (dtm.getRowCount() != 0) {
				dtm.removeRow(0);
			}
			
			for (FuncionarioDTO funcionarioDTO : lista) {
				dtm.addRow(new Object[] {
					funcionarioDTO.getCodigo(),
					funcionarioDTO.getNome(),
					funcionarioDTO.getCpf()
				});
			}

			} catch (DAOException daoe) {
				JOptionPane.showMessageDialog(null, "Erro ao efetuar a busca:\n" + 
					daoe.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	
	public void setarValores(int linha) {
		mf.populaTela(lista.get(linha));
		dispose();
	}
	
	
} 
