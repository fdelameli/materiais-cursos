import javax.swing.JOptionPane;


public class ExemploExcecao2 {

	public static void main(String[] args) {
		String dividendoS = JOptionPane.showInputDialog(null, "Digite o dividendo");
		int dividendo = Integer.parseInt(dividendoS);
		
		String divisorS = JOptionPane.showInputDialog(null, "Digite o divisor");
		int divisor = Integer.parseInt(divisorS);
	
		int resultado = dividendo / divisor;
		JOptionPane.showMessageDialog(null, "O resultado é: " + resultado);
		
	}
}
