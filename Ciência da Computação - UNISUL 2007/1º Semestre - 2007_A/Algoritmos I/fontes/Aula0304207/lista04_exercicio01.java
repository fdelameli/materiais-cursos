import javax.swing.JOptionPane;
class lista04_exercicio01 {
static String nome;
static double S_bruto, P_desconto, S_liquido;
	public static void main(String[] args) {
	nome = JOptionPane.showInputDialog("digite nome");
		S_bruto = Double.parseDouble(JOptionPane.showInputDialog("digite salario bruto"));
		P_desconto = Double.parseDouble(JOptionPane.showInputDialog("digite percentual de desconto"));
		S_liquido = S_bruto - (S_bruto*(P_desconto/100));
		JOptionPane.showMessageDialog(null,nome);
		JOptionPane.showMessageDialog(null,S_bruto + " reais");
		JOptionPane.showMessageDialog(null, S_liquido + " reais");
	

	}

}
