package aula01.exercicios.exe03;

import javax.swing.JOptionPane;


/**
 * Classe que calcula o produto de três inteiros
 * @author Fabio Dela Bruna
 */
public class Principal {

	public static void main(String[] args) {
		
		int x = 0, y = 0, z = 0;
		String xVal = "", yVal = "", zVal = "";	
		
		xVal = JOptionPane.showInputDialog("1º valor:");
		yVal = JOptionPane.showInputDialog("2º valor:");
		zVal = JOptionPane.showInputDialog("3º valor:");
		
		x = Integer.parseInt(xVal);
		y = Integer.parseInt(yVal);
		z = Integer.parseInt(zVal);
		
		int resultado = x * y * z;
		
		JOptionPane.showMessageDialog(null, "Produto é: " + resultado);
		
		System.exit(0);
	}
}
