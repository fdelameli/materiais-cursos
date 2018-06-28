package swing.exercicios;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Exercicio extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel labelCodigo, labelDescricao, labelValor;
	private JTextField textFieldCodigo, textFieldDescricao, textFieldValor;
	private JButton buttonSalvar, buttonCancelar;
	
	
	/**
	 * Construtor default.
	 */
	public Exercicio() {
		super ("Cadastro!");
		setSize(300, 175);
		
		GridBagLayout bagLayout = new GridBagLayout();
		GridBagConstraints bagConstraints = new GridBagConstraints();
		setLayout(bagLayout);
		
		labelCodigo = new JLabel("Código: ");
		labelCodigo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		labelDescricao = new JLabel("Descrição: ");
		labelDescricao.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		labelValor = new JLabel("Valor: ");
		labelValor.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		textFieldCodigo = new JTextField(10);
		textFieldDescricao = new JTextField(15);
		textFieldValor = new JTextField(5);
		
		buttonSalvar = new JButton("Salvar");
		buttonCancelar = new JButton("Cancelar");
		
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		bagConstraints.anchor = GridBagConstraints.EAST;
		bagLayout.setConstraints(labelCodigo, bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.anchor = GridBagConstraints.WEST;
		bagLayout.setConstraints(textFieldCodigo, bagConstraints);
		
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		bagLayout.setConstraints(labelDescricao, bagConstraints);
		
		bagConstraints.gridx = 1;
		bagLayout.setConstraints(textFieldDescricao, bagConstraints);
		
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 2;
		bagConstraints.anchor = GridBagConstraints.EAST;
		bagLayout.setConstraints(labelValor, bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.anchor = GridBagConstraints.WEST;
		bagLayout.setConstraints(textFieldValor, bagConstraints);
		
		
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 3;
		bagConstraints.anchor = GridBagConstraints.WEST;
		bagLayout.setConstraints(buttonSalvar, bagConstraints);
		
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 3;
		bagConstraints.anchor = GridBagConstraints.WEST;
		bagLayout.setConstraints(buttonCancelar, bagConstraints);
		
		Container c = getContentPane();

		c.add(labelCodigo);
		c.add(textFieldCodigo);
		c.add(labelDescricao);
		c.add(textFieldDescricao);
		c.add(labelValor);
		c.add(textFieldValor);
		c.add(buttonSalvar);
		c.add(buttonCancelar);
		
	}
	
	
	public static void main(String[] args) {
		Exercicio ex = new Exercicio();
		ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ex.setVisible(true);
	}
}
