package br.unisul.aula.interfacegrafica.testes;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TesteJTextArea extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel lbDestinatairos;
	private JTextArea destinatarios;
	
	
	public TesteJTextArea() {
		super("Exemplo de JTextArea");
		setSize(400, 150);
		setLayout(new FlowLayout());
		lbDestinatairos = new JLabel("Destinatários:");
		destinatarios = new JTextArea(4, 30);
		destinatarios.setLineWrap(true);
		destinatarios.setWrapStyleWord(true);
		JScrollPane barraDeRolagem = new JScrollPane(destinatarios);
		add(lbDestinatairos);
		add(barraDeRolagem);
		setVisible(true);
	}

	public static void main(String[] args) {
		TesteJTextArea app = new TesteJTextArea();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
			