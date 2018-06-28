package br.unisul.aula.trabalho.dto;

/**
 * Classe que representa um quarto. 
 * @author Fabio Dela Bruna / Marcio Teixeira Ozório.
 * @since 13/05/2008.
 */
public class Quarto {
	
	private int qtdPessoas;
	private double valorDiaria;
	
	
	/**
	 * 
	 */
	public Quarto() {
		super();
	}


	/**
	 * @param qtdPessoas
	 * @param valorDiaria
	 */
	public Quarto(int qtdPessoas, double valorDiaria) {
		super();
		this.qtdPessoas = qtdPessoas;
		this.valorDiaria = valorDiaria;
	}


	
	
	public int getQtdPessoas() {
		return qtdPessoas;
	}


	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}


	public double getValorDiaria() {
		return valorDiaria;
	}


	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	
	public String toString(){
		return String.format("Qtd Pessoas: %s\nValor Diária: %s", this.qtdPessoas, this.valorDiaria );
	}
	

}