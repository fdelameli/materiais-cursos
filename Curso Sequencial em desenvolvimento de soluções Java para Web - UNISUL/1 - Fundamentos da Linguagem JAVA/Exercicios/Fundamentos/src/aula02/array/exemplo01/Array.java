package aula02.array.exemplo01;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Array {


	public static void main(String[] args) {
	
		String[] nomes = new String[5];
		byte[] idades = new byte[5];
		
		
		for(int i = 0; i < nomes.length; i++) {
			nomes[i] = JOptionPane.showInputDialog("Nome " + (i+1) + ":");
			idades[i] = Byte.parseByte(JOptionPane.showInputDialog("Idade " + (i+1) + ":"));
		}
		
		String retorno = "Nome:\tIdade:\n\n";
		for(int i = 0; i < nomes.length; i++) {
			retorno += nomes[i] + "\t" + idades[i] + "\n";
		}
		
		JTextArea texto = new JTextArea(retorno);
		JOptionPane.showMessageDialog(null, texto);
		
		System.exit(0);
	}

}
