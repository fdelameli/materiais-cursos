import javax.swing.JOptionPane;
class lista06_exercicio06 {

	static double nh, vh, sb, sl;
	static String n;
	static int ts;

	public static void main(String[] args) {

		n = JOptionPane.showInputDialog("Digite seu nome");
		nh = Double.parseDouble(JOptionPane.showInputDialog("Digite o numero de horas trabalhadas"));
		vh = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor por hora trabalhada"));
		ts = Integer.parseInt(JOptionPane.showInputDialog("Digite o seu tempo de serviço"));
		sb = nh * vh;
		if (ts < 5){
			sl = sb + (sb*(5.0/100));
		}
		else{
			if (ts <= 10){
				sl = sb + (sb * (10.0/100));
			}
			else{
				sl = sb + (sb * (15.0/100));
			}
		}
		JOptionPane.showMessageDialog(null, "Nome: " + n);
		JOptionPane.showMessageDialog(null, "seu salario bruto é de " + sb + " reais");
		JOptionPane.showMessageDialog(null, "Voce trabalha " + ts + " Nesta empresa");
		JOptionPane.showMessageDialog(null, "Seu salario com abono é de " + sl + " reais");
	}

}
