import javax.swing.JOptionPane;
class lista05_exercicio10 {
	static double S_fixo, T_vendas, S_total;
	public static void main(String[] args) {
		S_fixo = Double.parseDouble(JOptionPane.showInputDialog("Seu salario fixo"));
		T_vendas = Double.parseDouble(JOptionPane.showInputDialog("Total de vendas"));
		if (T_vendas > 20000.00){
			S_total = S_fixo + (T_vendas * (20/100));
		}
		else{
			S_total = S_fixo + (T_vendas * (10/100));
		}
		JOptionPane.showMessageDialog(null, "Seu sálario é de " + S_total + " reais");
	}


}
