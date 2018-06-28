import javax.swing.JOptionPane;
class lista05_exercicio07 {
	static String a1, a2;
	static double m1, m2;
	public static void main(String[] args) {
		a1 = JOptionPane.showInputDialog("Digite o nome do primeiro aluno");
		a2 = JOptionPane.showInputDialog("Digite o nome do segundo aluno");
		m1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a média do primeiro aluno"));
		m2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a média do segundo aluno"));
		if (m1>m2){
			JOptionPane.showMessageDialog(null, "Média maior " + m1);
			JOptionPane.showMessageDialog(null, "Aluno: " + a1);
		}
		else {
			JOptionPane.showMessageDialog(null, "Média maior " + m2);
			JOptionPane.showMessageDialog(null, "Aluno: " + a2);
		}
	}

}



