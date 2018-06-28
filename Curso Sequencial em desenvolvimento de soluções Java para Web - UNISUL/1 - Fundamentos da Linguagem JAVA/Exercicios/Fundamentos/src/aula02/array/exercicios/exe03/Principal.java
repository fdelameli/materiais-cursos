package aula02.array.exercicios.exe03;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Principal {
	
	static DecimalFormat df = new DecimalFormat("###,###,##0.00");
	
	public static void main(String[] args) {
		
		double n1, n2;
		
		int op = Integer.parseInt(JOptionPane.showInputDialog("Que operação desejas fazer?" + 
				"\n|1|  -  Somar" +
				"\n|2|  -  Subtrair" +
				"\n|3|  -  Dividir" +
				"\n|4|  -  Multiplicar" +
				"\n\n|0|  -  SAIR"));
		
		do{
			if(op == 0){
				JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso sistema!", "Bye!", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			
			switch (op) {

			case 1:
				n1 = Double.parseDouble(JOptionPane.showInputDialog("1º Número:"));
				n2 = Double.parseDouble(JOptionPane.showInputDialog("2º Número:"));
				JOptionPane.showMessageDialog(null, "Resultado: " + df.format(Operacoes.somar(n1, n2)));
				break;
				
			case 2:
				n1 = Double.parseDouble(JOptionPane.showInputDialog("1º Número:"));
				n2 = Double.parseDouble(JOptionPane.showInputDialog("2º Número:"));
				JOptionPane.showMessageDialog(null, "Resultado: " + df.format(Operacoes.subtrair(n1, n2)));
				break;
	
			case 3:
				n1 = Double.parseDouble(JOptionPane.showInputDialog("1º Número:"));
				do{
					n2 = Double.parseDouble(JOptionPane.showInputDialog("2º Número:"));
					if(n2 == 0)
						JOptionPane.showMessageDialog(null, "Você não pode dividir um número por 0(zero)", "Burro!", JOptionPane.ERROR_MESSAGE);
				}while(n2 == 0);
				JOptionPane.showMessageDialog(null, "Resultado: " + df.format(Operacoes.dividir(n1, n2)));
				break;
	
			case 4:
				n1 = Double.parseDouble(JOptionPane.showInputDialog("1º Número:"));
				n2 = Double.parseDouble(JOptionPane.showInputDialog("2º Número:"));
				JOptionPane.showMessageDialog(null, "Resultado: " + df.format(Operacoes.multiplicar(n1, n2)));
				break;

			default:
				JOptionPane.showMessageDialog(null, "Operação inválida!", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			op = Integer.parseInt(JOptionPane.showInputDialog("Que operação desejas fazer?" + 
					"\n|1|  -  Somar" +
					"\n|2|  -  Subtrair" +
					"\n|3|  -  Dividir" +
					"\n|4|  -  Multiplicar" +
					"\n\n|0|  -  SAIR"));
		}
		while(op != 0);

		JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso sistema!", "Bye!", JOptionPane.PLAIN_MESSAGE);
	}

}
