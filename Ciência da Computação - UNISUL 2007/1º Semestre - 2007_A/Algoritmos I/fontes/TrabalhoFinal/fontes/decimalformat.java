package Decimalformat;
//comando import
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class decimalformat {

	public static void main(String[] args) {

		/* a classe DecimalFormat serve para formatar as casas decimais apos a virgula*/

		DecimalFormat df = new DecimalFormat("###,##0.00");

		double n1 = Double.parseDouble(JOptionPane.showInputDialog("Digite um numero"));
		double n2 = Double.parseDouble(JOptionPane.showInputDialog("Digite um numero"));

		double res = n1/n2;

		JOptionPane.showMessageDialog(null, "Resposta: " + df.format(res));
	}

}
