import javax.swing.JOptionPane;

class lista06_exercicio04 {
	
	static double s_atual, s_novo;
	
	public static void main(String[] args) {
		s_atual = Double.parseDouble(JOptionPane.showInputDialog("Digite seu salario atual"));
		if (s_atual < 3000.00){
			s_novo = s_atual + (s_atual*(30.0/100));
		}
		else{
			if (s_atual<=10000.00){
				s_novo = s_atual+(s_atual*(20.0/100));
			}
			else{
				s_novo = s_atual+(s_atual*(15.0/100));
			}
		}
		JOptionPane.showMessageDialog(null, "Seu novo salário é de: " + s_novo);	
	}

}
