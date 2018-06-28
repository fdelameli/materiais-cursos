import javax.swing.JOptionPane;

import br.unisul.aula.prog.Exemplo;


public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	Exemplo exe1 = new Exemplo();
	exe1.qualquerCoisa = "A";
	exe1.outraCoisa = "B";

	Exemplo exe2 = new Exemplo();
		
	System.out.println(exe1.qualquerCoisa);
	System.out.println(exe2.qualquerCoisa);
	
	System.out.println(exe1.outraCoisa);
	System.out.println(exe2.outraCoisa);
	
/*		Exemplo.qualquerCoisa = "A";
		System.out.println(Exemplo.qualquerCoisa);
		
		Exemplo.qualquerCoisa = "B";
		System.out.println(Exemplo.qualquerCoisa);
*/	
	}

}
