package aula02.array.exercicios.exe01;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QDecoderStream;

public class Principal {


	public static void main(String[] args) {
		
		double salario = 0;
		
		String nome = JOptionPane.showInputDialog("Nome do Funcionário:");
		char sexo = JOptionPane.showInputDialog("Sexo (M/F):").toUpperCase().charAt(0);
		byte idade = Byte.parseByte(JOptionPane.showInputDialog("Idade do Funcionário:"));
		short qtdPecas = Short.parseShort(JOptionPane.showInputDialog("Quantidade de Peças:"));
		
		
		if ((sexo != 'M') && (sexo != 'F')){
			JOptionPane.showMessageDialog(null, "Este não é um valor válido para SEXO");
		}else{
			if(sexo == 'M'){
				salario += 500 + (qtdPecas * 20);
				if(idade >= 50){
					salario += 200;
				}	
			}else{
				salario += 400 + (qtdPecas * 25);
				if(idade >= 40){
					salario += 100;
				}
			}
		}
		
		String result = "Nome:\t" + nome +
					"\nSexo:\t" + sexo +
					"\nIdade:\t" + idade +
					"\nNº Peças:\t" + qtdPecas +
					"\nSalário:\tR$ " + salario;
		
		JTextArea texto = new JTextArea(result);
		JOptionPane.showMessageDialog(null, texto);
		
	}
	
	

}
