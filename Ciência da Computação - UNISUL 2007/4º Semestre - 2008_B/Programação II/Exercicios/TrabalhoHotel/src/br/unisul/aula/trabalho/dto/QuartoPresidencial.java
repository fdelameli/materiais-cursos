package br.unisul.aula.trabalho.dto;

public class QuartoPresidencial extends Quarto {
	
	private static final String TIPO = "PRESIDENCIAL";

	/**
	 * 
	 */
	public QuartoPresidencial() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param qtdPessoas
	 * @param valorDiaria
	 */
	public QuartoPresidencial(int qtdPessoas, double valorDiaria) {
		super(qtdPessoas, valorDiaria);
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return String.format("Tipo Quarto: %s\n%s\n", TIPO, super.toString());
	}

}
