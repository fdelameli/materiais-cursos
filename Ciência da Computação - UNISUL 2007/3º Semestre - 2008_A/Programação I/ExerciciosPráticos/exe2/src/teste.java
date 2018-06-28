import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class teste extends JFrame {

	
	public teste() {
		this.setSize(600, 400);
		this.setBackground(Color.GREEN);
	}
	
	public static void main(String[] args){
	
		String strings[] = {"Operação 1", "Operação 2, Operação 3"};
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 50, 300, 400);
		panel.setVisible(true);
		panel.setBackground(Color.blue);
		
		teste t = new teste();
		t.getContentPane().add(panel);
		t.setVisible(true);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JButton botao = new JButton("Botão");
		botao.setBounds(110, 70, 100, 50);
		t.add(botao);

		
		JComboBox combo = new JComboBox(strings);
		panel.add(combo);
		combo.setBounds(150, 10, 100, 80);
		
	
		t.setLayout(null);
		
	}
}
