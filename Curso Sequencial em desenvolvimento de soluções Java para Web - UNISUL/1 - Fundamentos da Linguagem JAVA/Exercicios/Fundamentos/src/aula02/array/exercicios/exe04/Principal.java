package aula02.array.exercicios.exe04;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		byte n = Byte.parseByte(JOptionPane.showInputDialog("Valor de 'n':"));
		double result = 0.0;
		
		for (double i = 1; i <= n; i++) {
			result += (3*i /(i+1));
		}
		
		JOptionPane.showMessageDialog(null, "Resultado: " + result);
	}
}
