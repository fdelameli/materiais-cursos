import javax.swing.JOptionPane;
class Exemplo2 {
	static double nota1, nota2, media;

	public static void main(String[] args) {
		nota1 = Double.parseDouble(JOptionPane.showInputDialog("Primeira nota"));
		nota2 = Double.parseDouble(JOptionPane.showInputDialog("Segunda nota"));

		media = (nota1 + nota2)/2;

		if (media >= 7.0){
			JOptionPane.showMessageDialog(null,"Aprovado");
		}else{
			JOptionPane.showMessageDialog(null, "Reprovado");
		}
	}

}
