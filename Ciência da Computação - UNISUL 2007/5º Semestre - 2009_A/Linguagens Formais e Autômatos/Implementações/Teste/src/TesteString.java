import javax.swing.JLabel;
import javax.swing.JTextField;



public class TesteString {

	
	public static void main(String[] args) {
		
		
		String teste = "@a@o";
		teste = teste.replaceAll("@", "");
		System.out.println(teste);
		JLabel label = new JLabel();
		label.setVisible(true);
		
		JTextField field = new JTextField("Fabio");
	}
}
