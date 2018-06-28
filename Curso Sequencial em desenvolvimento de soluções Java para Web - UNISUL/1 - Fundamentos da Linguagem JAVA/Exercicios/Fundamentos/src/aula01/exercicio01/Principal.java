package aula01.exercicio01;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		int numero1 = Integer.parseInt(JOptionPane.showInputDialog("N1"));
		int numero2 = Integer.parseInt(JOptionPane.showInputDialog("N2"));
		double result = 0;
		int oper = 0;
	
		do{
			oper = Integer.parseInt(JOptionPane.showInputDialog("Operação: " +
					"\n1 - Somar" +
					"\n2 - Subtrair" +
					"\n3 - Multiplicar" +
					"\n4 - Dividir" +
					"\n\n0 - Sair"));
			
		
			switch(oper){
			
			case 1:{
				result = Operacoes.somarInteiros(numero1, numero2);
				JOptionPane.showMessageDialog(null, "Resultado: "+result);
				break;
			}
			case 2:{
				result = Operacoes.subtrairInteiros(numero1, numero2);
				JOptionPane.showMessageDialog(null, "Resultado: "+result);
				break;
			}
			case 3:{
				result = Operacoes.multiplicarInteiros(numero1, numero2);
				JOptionPane.showMessageDialog(null, "Resultado: "+result);
				break;
			}
			case 4:{
				result = Operacoes.dividirNumeros(numero1, numero2);
				JOptionPane.showMessageDialog(null, "Resultado: "+result);
				break;
			}
			}
		}
		while(oper!=0);

	}
}
