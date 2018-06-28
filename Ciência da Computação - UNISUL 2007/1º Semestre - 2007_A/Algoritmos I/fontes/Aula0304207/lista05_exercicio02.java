import javax.swing.JOptionPane;
class lista05_exercicio02 {
static double Salario, N_salario;
	public static void main(String[] args) {
	Salario = Double.parseDouble(JOptionPane.showInputDialog("Seu salário"));
	if (Salario < 5000){
		N_salario = Salario - (Salario * (30/100));
	}
JOptionPane.showMessageDialog(null, "Seu novo sálario é de " + Salario + " reais");
	}

}
