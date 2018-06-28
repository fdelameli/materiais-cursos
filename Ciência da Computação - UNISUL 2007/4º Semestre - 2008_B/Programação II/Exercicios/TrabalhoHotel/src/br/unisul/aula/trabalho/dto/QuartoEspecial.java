package br.unisul.aula.trabalho.dto;

public class QuartoEspecial extends Quarto {
	
	private static final String TIPO = "ESPECIAL";

	/**
	 * Construtor default.
	 */
	public QuartoEspecial() {
		super();
	}

	/**
	 * @param qtdPessoas
	 * @param valorDiaria
	 */
	public QuartoEspecial(int qtdPessoas, double valorDiaria) {
		super(qtdPessoas, valorDiaria);
	}

	
	public String toString(){
		return String.format("Tipo Quarto: %s\n%s\n", TIPO, super.toString());
	}
	
}
