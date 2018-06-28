import javax.swing.JOptionPane;
class lista05_exercicio04 {
	static String Nome;
	static double N1, N2, N3, Media;

	public static void main(String[] args) {
		Nome = JOptionPane.showInputDialog("Digite seu nome");
		N1 = Double.parseDouble(JOptionPane.showInputDialog("Digite sua primeira nota"));
		N2 = Double.parseDouble(JOptionPane.showInputDialog("Digite sua segunda nota"));
		N3 = Double.parseDouble(JOptionPane.showInputDialog("Digite sua terceira nota"));
		Media = (N1 + N2 + N3)/3;
		JOptionPane.showMessageDialog(null,"Nome " + Nome);
		JOptionPane.showMessageDialog(null, "Sua média é " + Media);
		if (Media>=8){
			JOptionPane.showMessageDialog(null, "Você está aprovado");
		}
		else{
			JOptionPane.showMessageDialog(null, "Você está reprovado");
		}
	}

}
