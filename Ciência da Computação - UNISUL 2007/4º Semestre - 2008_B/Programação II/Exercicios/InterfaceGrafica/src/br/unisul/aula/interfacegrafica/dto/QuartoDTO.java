package br.unisul.aula.interfacegrafica.dto;

public class QuartoDTO {

	private long codigo;
	private int numero;
	private String descricao;
	private double valorDiaria;
	private char ocupado;
	
	
	/**
	 * Construtor default.
	 */
	public QuartoDTO() {
		this.ocupado = 'N';
	}


	// getters e setters
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public char getOcupado() {
		return ocupado;
	}

	public void setOcupado(char ocupado) {
		this.ocupado = ocupado;
	}

	
}
