import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;


public class Principal {

	public static void main(String[] args) {
		
		File arquivo = new File("executando.dat");
		
		if (arquivo.exists()) {
			
			menssagemProgramaExecutando();
			System.exit(0);
			
		} else {
			
			try {
				
				arquivo.createNewFile();
				
			} catch (IOException e) {
				menssagemArquivoNaoCriado();
			}
			
			int op = 0;
			
			Banco b = new Banco();
			
			do {
				
				op = menu();
				
				switch (op) {
				
					case 0 : {
						
						arquivo.delete();
						
						JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso sistema!",
								"Saindo...", JOptionPane.PLAIN_MESSAGE);
						
						System.exit(0);
						
						break;
					}
				
					case 1 : {
						
						double saldo = b.verificaSaldo();
						
						JOptionPane.showMessageDialog(null, "Atualmente seu saldo é:  R$ " + saldo,
								"Consulta de saldo...", JOptionPane.PLAIN_MESSAGE);
						
						break;
					}
					
					case 2 : {
						
						double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor..."));
						
						if (b.deposito(valor)) {
							JOptionPane.showMessageDialog(null, "Depósito efetuado com sucesso!",
									"Depósito...", JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Não foi possível efetuar o seu depósito!",
									"Depósito...", JOptionPane.PLAIN_MESSAGE);
						}
						
						break;
					}
					
					case 3 : {

						double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor..."));
						
						if (b.saque(valor)) {
							JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso!",
									"Saque...", JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Não foi possível efetuar o seu saque!",
									"Saque...", JOptionPane.PLAIN_MESSAGE);
						}
						
						break;
					}
						
					default : {
						JOptionPane.showMessageDialog(null, "Opção inválida!!!",
								"Erro...", JOptionPane.ERROR_MESSAGE);
						
						break;
					}
				
				}
				
			} while (op != 0);
			
		}
		
	}
	
	
	/**
	 * Método que mostra uma menssagem de erro quando,
	 * tentarmos executar duas vezes o mesmo programa.
	 */
	private static void menssagemProgramaExecutando() {
		JOptionPane.showMessageDialog(null, "Este programa já esta sendo executado por outra pessoa..." +
				"Por favor, tente mais tarde!", "Erro!!!", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Método que mostra uma menssagem de erro quando,
	 * por qualquer motivo, não seja possível criar
	 * o arquivo usado para verificar se o programa
	 * já está sendo executado.
	 */
	private static void menssagemArquivoNaoCriado() {
		JOptionPane.showMessageDialog(null, "Não foi possível criar o arquivo...",
				"Erro!!!", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Método que exibe o Menu do programa.
	 */
	private static int menu() {
		return Integer.parseInt(JOptionPane.showInputDialog(". . : MENU : . ." +
				"\n| 1 |  -  VERIFICAR SALDO" +
				"\n| 2 |  -  EFETUAR DEPÓSITO" +
				"\n| 3 |  -  EFETUAR SAQUE\n" +
				"\n| 0 |  -  SAIR"));
	}
	
}

