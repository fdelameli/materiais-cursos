package aula02.array.exemplo02;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Principal {

	public static void main(String[] args) {
		
		Pessoa[] a = new Pessoa[5];
		
		for (int i = 0; i < a.length; i++) {
			String nome = JOptionPane.showInputDialog("Nome " + (i+1) + ":");
			byte idade = Byte.parseByte(JOptionPane.showInputDialog("Idade " + (i+1) + ":"));
			Pessoa p = new Pessoa (nome, idade);
			a[i] = p;
		}
		
		String retorno = "";
		for (int i = 0; i < a.length; i++) {

			retorno += a[i].getNome() + "\t" + a[i].getIdade() + "\n";
		}
		
		JTextArea texto = new JTextArea(retorno);
		JOptionPane.showMessageDialog(null, texto);
		
		System.exit(0);

	}

}
