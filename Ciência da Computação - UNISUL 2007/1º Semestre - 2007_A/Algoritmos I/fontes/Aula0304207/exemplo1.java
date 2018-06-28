import javax.swing.JOptionPane;
class exemplo1 {

	static String nome;
	static int idade;
	static double altura;
	static char sexo;
	
	public static void main(String[] args) {
		nome= JOptionPane.showInputDialog("digite seu nome");
		idade= Integer.parseInt(JOptionPane.showInputDialog("digite sua idade"));
		altura= Double.parseDouble(JOptionPane.showInputDialog("digite sua altura"));
		sexo= JOptionPane.showInputDialog("digite seu sexo").charAt(0);
		
		JOptionPane.showMessageDialog(null,"Seu nome é " + nome);
		JOptionPane.showMessageDialog(null,"Sua idade é " + idade);
		JOptionPane.showMessageDialog(null,"Sua altura é " + altura);
		JOptionPane.showMessageDialog(null,"Seu sexo é " + sexo);
	}

}
