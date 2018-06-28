import javax.swing.JOptionPane;


public class desafio3 {
	public static void main(String[] args) {


		double valor = Double.parseDouble(JOptionPane.showInputDialog("Quantas bolinhas na caixa"));
		double valor2 = Double.parseDouble(JOptionPane.showInputDialog("Quantidade bolinhas a ser retiradas"));
		System.out.println(valor);
		System.out.println(valor2);

		//double total = fatorial(valor)/(fatorial(valor -valor2) * fatorial(valor2));
		System.out.println(fatorial(valor)/(fatorial(valor -valor2) * fatorial(valor2)));


	}

	public static double fatorial(double valor ){
		double temp = 1;
		for (int i = 1; i <= valor; i++) {
			temp *= i;
		}
		return temp;

	}
}
