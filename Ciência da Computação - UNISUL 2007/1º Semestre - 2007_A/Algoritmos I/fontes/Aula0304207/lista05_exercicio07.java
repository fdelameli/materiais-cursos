import javax.swing.JOptionPane;
class lista05_exercicio07 {
	static String A1, A2;
	static double M1, M2;
	public static void main(String[] args) {
		A1 = JOptionPane.showInputDialog("Nome do aluno");
		M1 = Double.parseDouble(JOptionPane.showInputDialog("Escreva a média do aluno"));
		A2 = JOptionPane.showInputDialog("Nome do aluno");
		M2 = Double.parseDouble(JOptionPane.showInputDialog("Escreva a média do aluno"));
		if (M1 > M2){
			JOptionPane.showMessageDialog(null, "aluno: " + A1);
			JOptionPane.showMessageDialog(null, "Média: " + M1);
		}
		else {
			JOptionPane.showMessageDialog(null, "aluno: " + A2);
			JOptionPane.showMessageDialog(null, "Média: " + M2);
		}
	}

}
