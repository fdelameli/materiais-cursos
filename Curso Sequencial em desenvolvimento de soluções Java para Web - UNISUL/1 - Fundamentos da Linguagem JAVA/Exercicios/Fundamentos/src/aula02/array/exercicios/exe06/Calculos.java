package aula02.array.exercicios.exe06;

/**
 * Classe que contém vários métodos de cálculos referentes à Pessoa
 * @author Fabio Dela Bruna
 * @since 12/04/2008
 */
public class Calculos {
	
	/**
	 * Calcula e retorna a Media Geral de Idade
	 * de todas as pessoas cadastradas
	 */
	public static double mediaGeralIdades(Pessoa[] pessoas){
		int soma = 0;
		for (int i = 0; i < pessoas.length; i++) {
			soma += pessoas[i].getIdade();
		}
		return (soma / pessoas.length);
	}
	
	/**
	 * Calcula e retorna o percentual de
	 * homens que estão cadastrados
	 */
	public static double percentualHomem(Pessoa[] pessoas){
		short qtdHomen = 0;
		for (int i = 0; i < pessoas.length; i++) {
			if(pessoas[i].getSexo() == 'M')
				qtdHomen++;
		}
		return ((qtdHomen * 100) / pessoas.length);
	}

	/**
	 * Calcula e retorna o percentual de
	 * mulheres que estão cadastradas
	 */
	public static double percentualMulher(Pessoa[] pessoas){
		short qtdMulher = 0;
		for (int i = 0; i < pessoas.length; i++) {
			if(pessoas[i].getSexo() == 'F')
				qtdMulher++;	
		}
		return ((qtdMulher * 100) / pessoas.length);
	}
	
	/**
	 * Calcula retorna a Media de Idade
	 * dos homens cadastrados
	 */
	public static double mediaIdadeHomens(Pessoa[] pessoas){
		short qtd = 0;
		int somaIdade = 0;
		for (int i = 0; i < pessoas.length; i++) {
			if(pessoas[i].getSexo() == 'M'){
				somaIdade += pessoas[i].getIdade();
				qtd++;
			}
		}
		return (somaIdade / qtd);
	}
	
	/**
	 * Calcula retorna a Media de Idade
	 * das mulheres cadastradas
	 */
	public static double mediaIdadeMulheres(Pessoa[] pessoas){
		short qtd = 0;
		int somaIdade = 0;
		for (int i = 0; i < pessoas.length; i++) {
			if(pessoas[i].getSexo() == 'F'){
				somaIdade += pessoas[i].getIdade();
				qtd++;
			}
		}
		return (somaIdade / qtd);
	}
	
	/**
	 * Verifica e retorna o nome do homem
	 * mais velho que esta cadastrado
	 */
	public static String homenMaisVelho(Pessoa[] pessoas){
		byte idadeVelho = 0;
		String maisVelho = "";
		for (int i = 0; i < pessoas.length; i++) {
			if (pessoas[i].getSexo() == 'M') {
				if(pessoas[i].getIdade() > idadeVelho){
					maisVelho = pessoas[i].getNome();
					idadeVelho = pessoas[i].getIdade();
				}
				
			}
		}
		return maisVelho;
	}
	
	/**
	 * Verifica e retorna o nome da mulher
	 * mais velha que esta cadastrada
	 */
	public static String mulherMaisNova(Pessoa[] pessoas){
		byte idadeNova = 126;
		String maisNova = "";
		for (int i = 0; i < pessoas.length; i++) {
			if (pessoas[i].getSexo() == 'F') {
				if(pessoas[i].getIdade() < idadeNova){
					maisNova = pessoas[i].getNome();
					idadeNova = pessoas[i].getIdade();
				}
				
			}
		}
		return maisNova;
	}
}
