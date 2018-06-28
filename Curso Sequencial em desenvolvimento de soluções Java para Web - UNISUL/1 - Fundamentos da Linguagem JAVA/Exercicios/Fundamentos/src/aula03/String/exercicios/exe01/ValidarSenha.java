package aula03.String.exercicios.exe01;

import javax.swing.JOptionPane;

public class ValidarSenha {


	public static void main(String[] args) {

		String senha1 = JOptionPane.showInputDialog(null, "Digite sua senha:");
		String senha2 = JOptionPane.showInputDialog(null, "Redigite sua senha:");
		
		if(senha1.equals(senha2)){
			if(senha1.length() >= 8){
				if((senha1.charAt(2) != 'C') && (senha1.charAt(2) != 'a')){
					if((senha1.indexOf('y') >= 0) || (senha1.indexOf('Y') >= 0)){
						System.out.println("Sua senha foi validada com sucesso!");
					}else{
						System.out.println("Sua senha não possui os caracteres Y ou y");
					}
				}else{
					System.out.println("A terceira letra de sua senha não pode ser os caracteres C ou a");
				}
			}else{
				System.out.println("Sua senha precisa conter no mínimo 8 caracteres válidos");
			}
		}else{
			System.out.println("Você não redigitou sua senha corretamente");
		}

	}

}
