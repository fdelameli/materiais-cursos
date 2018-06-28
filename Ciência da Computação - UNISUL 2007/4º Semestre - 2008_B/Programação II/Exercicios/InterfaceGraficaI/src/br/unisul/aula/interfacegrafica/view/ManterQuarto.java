package br.unisul.aula.interfacegrafica.view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.unisul.aula.interfacegrafica.dto.QuartoDTO;
import br.unisul.aula.interfacegrafica.model.QuartoModel;

public class ManterQuarto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField jTextFieldCodigo = null;
	private JLabel jLabelCodigo = null;
	private JTextField jTextFieldNumero = null;
	private JLabel jLabelNumero = null;
	private JTextArea jTextAreaDescricao = null;
	private JLabel jLabelDescricao = null;
	private JTextField jTextFieldValorDiaria = null;
	private JLabel jLabelValorDiaria = null;
	private JButton jButtonSalvar = null;
	private JButton jButtonExcluir = null;
	private JButton jButtonBuscar = null;
	private JButton jButtonCancelar = null;
	private QuartoModel quartoModel = null;
	private JanelaPrincipal jp = null;
	private JTextArea jTextAreaDescricao1 = null;
	
	/**
	 * This is the xxx default constructor
	 */
	public ManterQuarto() {
		super();
		initialize();
		quartoModel = new QuartoModel();
	}
	
	/**
	 * Construtor com parâmetros.
	 * @param jp
	 */
	public ManterQuarto(JanelaPrincipal jp) {
		super();
		initialize();
		quartoModel = new QuartoModel();
		this.jp = jp;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(492, 300);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setTitle("Manter Quartos");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelValorDiaria = new JLabel();
			jLabelValorDiaria.setText("Valor Diária:");
			jLabelValorDiaria.setSize(new Dimension(69, 20));
			jLabelValorDiaria.setLocation(new Point(14, 125));
			jLabelDescricao = new JLabel();
			jLabelDescricao.setText("Descrição:");
			jLabelDescricao.setSize(new Dimension(61, 20));
			jLabelDescricao.setLocation(new Point(22, 60));
			jLabelNumero = new JLabel();
			jLabelNumero.setText("Nº Quarto:");
			jLabelNumero.setSize(new Dimension(57, 20));
			jLabelNumero.setLocation(new Point(199, 25));
			jLabelCodigo = new JLabel();
			jLabelCodigo.setText("Código:");
			jLabelCodigo.setSize(new Dimension(42, 20));
			jLabelCodigo.setLocation(new Point(35, 25));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextFieldCodigo(), null);
			jContentPane.add(jLabelCodigo, null);
			jContentPane.add(getJTextFieldNumero(), null);
			jContentPane.add(jLabelNumero, null);
			jContentPane.add(jLabelDescricao, null);
			jContentPane.add(getJTextFieldValorDiaria(), null);
			jContentPane.add(jLabelValorDiaria, null);
			jContentPane.add(getJButtonSalvar(), null);
			jContentPane.add(getJButtonExcluir(), null);
			jContentPane.add(getJButtonBuscar(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(getJTextAreaDescricao(), null);
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
			jTextFieldCodigo.setSize(new Dimension(50, 20));
			jTextFieldCodigo.setLocation(new Point(80, 25));
		}
		return jTextFieldCodigo;
	}

	/**
	 * This method initializes jTextFieldNumero	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNumero() {
		if (jTextFieldNumero == null) {
			jTextFieldNumero = new JTextField();
			jTextFieldNumero.setText("");
			jTextFieldNumero.setSize(new Dimension(50, 20));
			jTextFieldNumero.setLocation(new Point(260, 25));
		}
		return jTextFieldNumero;
	}


	/**
	 * This method initializes jTextFieldValorDiaria	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldValorDiaria() {
		if (jTextFieldValorDiaria == null) {
			jTextFieldValorDiaria = new JTextField();
			jTextFieldValorDiaria.setLocation(new Point(80, 125));
			jTextFieldValorDiaria.setSize(new Dimension(50, 20));
		}
		return jTextFieldValorDiaria;
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
			jButtonSalvar.setLocation(new Point(15, 194));
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
			jButtonExcluir.setLocation(new Point(125, 194));
			jButtonExcluir.setText("Excluir");
			jButtonExcluir.setSize(new Dimension(100, 30));
			jButtonExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
			jButtonBuscar.setLocation(new Point(240, 193));
			jButtonBuscar.setText("Buscar");
			jButtonBuscar.setSize(new Dimension(100, 30));
			jButtonBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirFrameBuscarQuarto();
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
			jButtonCancelar.setLocation(new Point(355, 194));
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
	public void salvar(){
	
		QuartoDTO quarto = new QuartoDTO();
		
		quarto.setDescricao(jTextAreaDescricao.getText());
		int numero = Integer.parseInt(jTextFieldNumero.getText());
		quarto.setNumero(numero);
		double valorDiaria = Double.parseDouble(jTextFieldValorDiaria.getText());
		quarto.setValorDiaria(valorDiaria);
		
		try {
			
			quartoModel.insert(quarto);
			
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	/**
	 * Método responsável por enviar os dados para a camada model
	 * quando o usuário clicar no botão Excluir.
	 */
	public void excluir(){
		
        QuartoDTO quarto = new QuartoDTO();
		
		quarto.setDescricao(jTextAreaDescricao.getText());
		int numero = Integer.parseInt(jTextFieldNumero.getText());
		quarto.setNumero(numero);
		double valorDiaria = Double.parseDouble(jTextFieldValorDiaria.getText());
		quarto.setValorDiaria(valorDiaria);
		
		try {
			
			quartoModel.delete(quarto);
			
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	/**
	 * Método responsável por enviar os dados para a camada model
	 * quando o usuário clicar no botão Buscar.
	 */
	public void abrirFrameBuscarQuarto(){
		
		BuscarQuarto bq = new BuscarQuarto(this);
		jp.getDesktopPane().add(bq);
		bq.setVisible(true);
		
	}

	/**
	 * This method initializes jTextAreaDescricao1	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaDescricao () {
		if (jTextAreaDescricao1 == null) {
			jTextAreaDescricao1 = new JTextArea();
			jTextAreaDescricao1.setBounds(new Rectangle(87, 61, 357, 60));
		}
		return jTextAreaDescricao1;
	}
	
	
	public void populaTela(QuartoDTO quarto) {
		jTextFieldCodigo.setText(String.valueOf(quarto.getCodigo()));
		jTextFieldNumero.setText(String.valueOf(quarto.getNumero()));
		jTextAreaDescricao.setText(quarto.getDescricao());
		jTextFieldValorDiaria.setText(String.valueOf(quarto.getValorDiaria()));
	}

} 
