package br.unisul.aula.interfacegrafica.dto;

public class EstadoDTO {

	// ATRIBUTOS \\
	private int codigo;
	private String sigla;
	private String nome;
	
	
	
	/**
	 * Construtor default
	 */
	public EstadoDTO() {
		super();
	}
	
	/**
	 * Construtor com parâmetros.
	 */
	public EstadoDTO (int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	
	
	// GETTERS E SETTERS \\
	
	public String toString() {
		return getSigla();
	}
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	

}
