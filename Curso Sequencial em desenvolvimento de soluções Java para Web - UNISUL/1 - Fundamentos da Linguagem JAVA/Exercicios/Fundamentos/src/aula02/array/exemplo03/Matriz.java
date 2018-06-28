package aula02.array.exemplo03;

import javax.swing.JOptionPane;

public class Matriz {

	public static void main(String[] args) {
		
		String matriz[][]=new String[3][2];
		
		for(int i = 0;i < matriz.length; i++){
			for(int j = 0; j < matriz[i].length; j++){
				matriz[i][j] = JOptionPane.showInputDialog("Nome");
			}
		}
		
		String nomes = "";
		for(int i = 0; i < matriz.length; i++){
			for(int j = 0; j < matriz[i].length; j++){
				nomes += "\nLinha: " + i + " - Coluna: " + j + " ==> Valor: " + matriz[i][j];
			} 
		}
		
		JOptionPane.showMessageDialog(null, nomes);
		System.exit(0);
		
	}
}
