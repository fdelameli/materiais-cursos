package aula02.array.exercicios.exe05;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Principal {

	public static void main(String[] args) {
		
		
		String result = "";
		result += "N\t10*N\t100*N\t1000*N\n\n";
		byte n = Byte.parseByte(JOptionPane.showInputDialog("N:"));
		
		for(int i = 1; i <= n; i++){
			result += i + "\t" + i*10 + "\t" + i*100 + "\t" + i*1000 + "\n";
		}
		
		JTextArea texto = new JTextArea();
		texto.setText(result);
		JOptionPane.showMessageDialog(null, texto, "Resultado Final", JOptionPane.PLAIN_MESSAGE);
		System.exit(0);
	}
}
