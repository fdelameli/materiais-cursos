import javax.swing.JOptionPane;
class lista3_exercicio10 {
	static int valor, N1, N10, N100;

	public static void main(String[] args) {
		valor = Integer.parseInt(JOptionPane.showInputDialog("digite valor"));
		N100 = valor/100;
		N10 = (valor%100)/10;
		N1 = ((valor%100)%10)/1;
		JOptionPane.showMessageDialog(null,N100 + "notas de 100");
		JOptionPane.showMessageDialog(null, N10 + "notas de 10");
		JOptionPane.showMessageDialog(null, N1 + "notasde 1");



	}

}
