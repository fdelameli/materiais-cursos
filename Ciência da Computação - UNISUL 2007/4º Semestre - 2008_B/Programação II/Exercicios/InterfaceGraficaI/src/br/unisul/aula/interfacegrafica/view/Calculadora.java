package br.unisul.aula.interfacegrafica.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/**
 * Classe que simula uma calculadora.
 * @author Fabio Dela Bruna.
 *
 */
public class Calculadora extends JInternalFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;

	private JTextField visor;
	
	private String valor;
	
	private String valorAnterior;
	
	private String operacao;
	
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9,
				bPonto, bMais, bMenos, bMultiplica, bDivide, bCalcula, bLimpa;
	
	
	
	/**
	 * Construtor default.
	 */
	public Calculadora() {
		
		super ("Calculadora");
		
	
		
		Container c = getContentPane();
		
		this.setIconifiable(true);
		this.setMaximizable(true);
		this.setClosable(true);
		
		this.valor = "0";
		this.visor = new JTextField(valor, 12);
		this.visor.setHorizontalAlignment(JTextField.RIGHT);
		this.visor.setFont( new Font("Dialog", Font.PLAIN, 20));
		this.visor.setEditable(false);
		
		c.add(this.visor, BorderLayout.NORTH);
		
		c.add(criaPainel1(), BorderLayout.CENTER);
		
		c.add(criaPainel2(), BorderLayout.EAST);
		
		pack();
		this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
	}
	
	
	/**
	 * Método que cria o painel com os botões de 0 a 9.
	 */
	private JPanel criaPainel1() {
		JPanel painel = new JPanel (new GridLayout(4, 3));
		
		this.b7 = new JButton("7");
		painel.add(this.b7);
		this.b7.addActionListener(this);
		
		this.b8 = new JButton("8");
		painel.add(this.b8);
		this.b8.addActionListener(this);
		
		this.b9 = new JButton("9");
		painel.add(this.b9);
		this.b9.addActionListener(this);
		
		this.b4 = new JButton("4");
		painel.add(this.b4);
		this.b4.addActionListener(this);
		
		this.b5 = new JButton("5");
		painel.add(this.b5);
		this.b5.addActionListener(this);
		
		this.b6 = new JButton("6");
		painel.add(this.b6);
		this.b6.addActionListener(this);
		
		this.b1 = new JButton("1");
		painel.add(this.b1);
		this.b1.addActionListener(this);
		
		this.b2 = new JButton("2");
		painel.add(this.b2);
		this.b2.addActionListener(this);
		
		this.b3 = new JButton("3");
		painel.add(this.b3);
		this.b3.addActionListener(this);
		
		this.b0 = new JButton("0");
		painel.add(this.b0);
		this.b0.addActionListener(this);
		
		this.bPonto = new JButton(".");
		painel.add(this.bPonto);
		this.bPonto.addActionListener(this);
		
		this.bLimpa = new JButton("C");
		painel.add(this.bLimpa);
		this.bLimpa.addActionListener(this);
			
		return painel;
	}
	


	/**
	 * Método que cria o painel com os botoes de operações ( +, -, *, x, =, ...)
	 */
	private JPanel criaPainel2() {
		JPanel painel = new JPanel( new GridLayout(5, 1));
		
		this.bMais = new JButton("+");
		painel.add(this.bMais);
		this.bMais.addActionListener(this);
		
		this.bMenos = new JButton("-");
		painel.add(this.bMenos);
		this.bMenos.addActionListener(this);
		
		this.bMultiplica = new JButton("*");
		painel.add(this.bMultiplica);
		this.bMultiplica.addActionListener(this);
		
		this.bDivide = new JButton("/");
		painel.add(this.bDivide);
		this.bDivide.addActionListener(this);
		
		this.bCalcula = new JButton("=");
		painel.add(this.bCalcula);
		this.bCalcula.addActionListener(this);
		
		return painel;
	}
	
	
	/**
	 * Método que adiciona eventos aos botões.
	 */
	public void actionPerformed(ActionEvent e) {
		
		if ((e.getSource() == this.b0) || (e.getSource() == this.b1) || (e.getSource() == this.b2) ||
				(e.getSource() == this.b3) || (e.getSource() == this.b4) || (e.getSource() == this.b5) ||
				(e.getSource() == this.b6) || (e.getSource() == this.b7) || (e.getSource() == this.b8) ||
				(e.getSource() == this.b9)) {
			
			JButton apertado = (JButton) e.getSource();
			
			if ((this.valor.length() == 1 && this.valor.equals("0"))) {
				this.valor = apertado.getText();
			} else {
				if (this.valor.length() <= 9)
					this.valor += apertado.getText();
			}
			visor.setText(this.valor);
			
		} else {
			
			if (e.getSource() == this.bPonto) {
				if (this.valor.indexOf(".") < 0) {
					this.valor += ".";
					this.visor.setText(this.valor);
				}
				
			} else {
				
				if ((e.getSource() == this.bMais) || (e.getSource() == this.bMenos) ||
						(e.getSource() == this.bMultiplica) || (e.getSource() == this.bDivide)) {
					
					this.valorAnterior = this.valor;
					JButton apertado = (JButton) e.getSource();
					this.operacao = apertado.getText();
					this.valor = "0";
					this.visor.setText(this.valor);
					
				} else {
					
					if (e.getSource() == this.bCalcula) {
						
						double v1 = Double.parseDouble(this.valorAnterior);
						double v2 = Double.parseDouble(this.valor);
						System.out.println(v2);
						double resultado = 0;
						
						if (this.operacao.equals("+"))
							resultado = v1 + v2;
						
						if (this.operacao.equals("-"))
							resultado = v1 - v2;
						
						if (this.operacao.equals("*"))
							resultado = v1 * v2;
						
						if (this.operacao.equals("/")) {
							if (v2 == 0.0) {
								this.valor = "ERRO!!!";
								this.visor.setText(this.valor);
							} else {
								resultado = v1 / v2;
							}
						}
						
						this.valor = "" + resultado;
						this.visor.setText(this.valor);
						
					} else {
						
						if (e.getSource() == this.bLimpa) {
							this.valorAnterior = "";
							this.valor = "0";
							this.visor.setText(this.valor);
						}
					}
				}
			}
		}
	}

}
