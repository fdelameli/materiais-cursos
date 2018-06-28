package br.unisul.aula.classes;

/**
 * Classe que representa uma pessoa.
 * 
 * @author Fabio Dela Bruna
 * @since 19/04/2008
 */
public class Pessoa {

	
	// Atributos
	
	private String nome;
	private byte idade;
	private char sexo;
	private String estado;
	private boolean embriagado; // 0-NAO  e  1-SIM
	
	
	// Construtores
	
	/**
	 * 
	 */
	public Pessoa() {
		super();
	}
	
	/**
	 * @param nome
	 * @param idade
	 * @param sexo
	 * @param estado
	 * @param grauEmbriagues
	 */
	public Pessoa(String nome, byte idade, char sexo, String estado, boolean embriagado) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.estado = estado;
		this.embriagado = embriagado;
	}
	
	
	// Getters e Setters
	
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/**
	 * @return the idade
	 */
	public byte getIdade() {
		return idade;
	}
	
	/**
	 * @param idade the idade to set
	 */
	public void setIdade(byte idade) {
		this.idade = idade;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}
	
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	/**
	 * @return the embriagado
	 */
	public boolean isEmbriagado() {
		return embriagado;
	}
	
	/**
	 * @param embriagado the embriagado to set
	 */
	public void setEmbriagado(boolean embriagado) {
		this.embriagado = embriagado;
	}
	
}
