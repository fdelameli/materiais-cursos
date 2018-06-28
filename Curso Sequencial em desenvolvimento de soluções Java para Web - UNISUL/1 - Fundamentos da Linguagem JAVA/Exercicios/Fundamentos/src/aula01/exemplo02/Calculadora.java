package aula01.exemplo02;

import javax.swing.JOptionPane;

public class Calculadora {


	public static void main(String[] args) {

		int n1 = Integer.parseInt(JOptionPane.showInputDialog("N1"));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("N2"));

		JOptionPane.showMessageDialog(null, "Soma: "+(n1+n2));
		
		System.exit(0);
	}

}
