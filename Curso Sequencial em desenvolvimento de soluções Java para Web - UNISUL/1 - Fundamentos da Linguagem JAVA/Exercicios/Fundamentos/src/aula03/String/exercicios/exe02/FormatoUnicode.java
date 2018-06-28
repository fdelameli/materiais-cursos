package aula03.String.exercicios.exe02;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class FormatoUnicode {

	static DecimalFormat df = new DecimalFormat("###,##0.00");

	public static void main(String[] args) {
		
		String entrada = "";
		String codigoMecadoria = "";
		short quantidadePedida = 0;
		Double percentDesconto = 0.0;
		double valorProduto = 0;
		
		
		do{
			entrada = JOptionPane.showInputDialog("Digite as informaçãoes:");
			
			if (entrada.length() == 18){
				codigoMecadoria = entrada.substring(0, 4);
				quantidadePedida = Short.parseShort(entrada.substring(4, 8));
				percentDesconto = Double.parseDouble(entrada.substring(8, 12)) / 100;
				//percentDesconto = entrada.substring(8, 10) + '.' + entrada.substring(10, 12);
				valorProduto = Double.parseDouble(entrada.substring(12, 18)) / 100;
				//valorDesconto = entrada.substring(12, 16) + '.' + entrada.substring(16);
				
				JOptionPane.showMessageDialog(null, "Código: " + codigoMecadoria);
				JOptionPane.showMessageDialog(null, "Quantidade: " + quantidadePedida);
				JOptionPane.showMessageDialog(null, "Valor Bruto: " + df.format(valorProduto));
				JOptionPane.showMessageDialog(null, "Percentual de desconto: " + df.format(percentDesconto) + "%");
				valorProduto -= (valorProduto*percentDesconto / 100);
				JOptionPane.showMessageDialog(null, "Valor Líquido: " + df.format(valorProduto));
				
			}else{
				JOptionPane.showMessageDialog(null, "Você precisa digitar 18 números", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}while(entrada.length() != 18);

	}

}
