package aula01.exercicio02;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso:"));
		double altura = Double.parseDouble(JOptionPane.showInputDialog("Altura:"));
		
		String result = IMC.getIMC(peso, altura);
		
		JOptionPane.showMessageDialog(null, "Seu IMC: " + result + " kg/m²");
		
	}
}
