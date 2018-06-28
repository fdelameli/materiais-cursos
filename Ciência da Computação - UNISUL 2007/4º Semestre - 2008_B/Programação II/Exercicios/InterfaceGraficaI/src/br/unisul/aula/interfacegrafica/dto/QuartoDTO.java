package br.unisul.aula.interfacegrafica.dto;

public class QuartoDTO {

	private long codigo;
	private int numero;
	private String descricao;
	private double valorDiaria;
	private boolean ocupado;
	
	
	/**
	 * Construtor default.
	 */
	public QuartoDTO() {
		this.ocupado = false;
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

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
}
