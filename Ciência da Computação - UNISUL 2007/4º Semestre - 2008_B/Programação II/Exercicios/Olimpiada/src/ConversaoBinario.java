import javax.swing.JOptionPane;


public class ConversaoBinario {

	public static void main(String[] args) {
		try {
			int inteiro = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero"));
			String binario = "";
			
			while(inteiro > 0){
				binario = inteiro % 2 + binario ;
				inteiro /= 2;
			}
			JOptionPane.showMessageDialog(null, "Numero binario\n"+binario);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro na entra do inteiro");
		}
		
		
		
	}
}
