package aula01.exercicios.exe02;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JOptionPane;

public class Media {

	public static void main(String[] args) {

		double prova1 = Double.parseDouble(JOptionPane.showInputDialog("Nota da 1ª prova:"));
		double prova2 = Double.parseDouble(JOptionPane.showInputDialog("Nota da 2ª prova:"));

		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		DecimalFormatSymbols ds = new DecimalFormatSymbols();
		ds.setGroupingSeparator('.');
		ds.setDecimalSeparator(',');
		df.setDecimalFormatSymbols(ds);

		double media = calcularMedia(prova1, prova2);
		JOptionPane.showMessageDialog(null, "Média: " + df.format(media));
		}
	
	
	private static double calcularMedia(double prova1, double prova2){
		return (prova1 + prova2) /2;
	}
}
