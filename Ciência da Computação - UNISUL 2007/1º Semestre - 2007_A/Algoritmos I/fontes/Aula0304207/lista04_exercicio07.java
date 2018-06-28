import javax.swing.JOptionPane;
class lista04_exercicio07 {
	static String Nome;
	static int Dependentes;
	static double NH, S_bruto, S_liquido, INSS, IR;

	public static void main(String[] args) {
		Nome = JOptionPane.showInputDialog("Seu nome");
		NH = Double.parseDouble(JOptionPane.showInputDialog("Número de horas trabalhadas"));
		Dependentes = Integer.parseInt(JOptionPane.showInputDialog("Números de dependentes"));
		S_bruto = NH*12 + Dependentes*40;
		S_liquido = S_bruto - (S_bruto*(8.5/100));
		INSS = S_bruto*(8.5/100);
		IR = S_bruto*(5/100);
		JOptionPane.showMessageDialog(null, Nome);
		JOptionPane.showMessageDialog(null, "Seu salário bruto é de " + S_bruto + " reais");
		JOptionPane.showMessageDialog(null, "O desconto de INSS é de " + INSS + " reais");
		JOptionPane.showMessageDialog(null, "O desconto de IR é de " + IR + " reais");
		JOptionPane.showMessageDialog(null, " Seu salário líquido é de " + S_liquido + " reais");

	}

}
