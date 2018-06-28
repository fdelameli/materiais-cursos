package aula01.exercicios.exe01;

import javax.swing.JOptionPane;

public class DivideInteiros {


	public static void main(String[] args) {

		int n1 = Integer.parseInt(JOptionPane.showInputDialog("N1"));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("N2"));

		JOptionPane.showMessageDialog(null, "Soma: " + (n1 / n2));
		
		System.exit(0);
	}

}
