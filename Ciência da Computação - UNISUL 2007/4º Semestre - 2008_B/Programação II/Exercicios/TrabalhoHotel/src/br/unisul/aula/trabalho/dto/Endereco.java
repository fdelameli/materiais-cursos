package br.unisul.aula.trabalho.dto;


/**
 * Classe que representa um endereço.
 * @author Fabio Dela Bruna / Marcio Teixeira Ozório.
 * @sice 13/05/2008.
 */
public class Endereco {
	
	//atributos
	
	private int numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	
	
	//construtores
	
	/**
	 * Construtor default.
	 */
	public Endereco() {
		this(0, "", "", "", "");
	}
	
	/**
	 * Construtor com parâmetros.
	 * @param numero - Número da casa.
	 * @param rua - Rua.
	 * @param bairro - Bairro.
	 * @param cidade - Cidade.
	 * @param estado - Estado.
	 */
	public Endereco(int numero, String rua, String bairro, String cidade, String estado) {
		super();
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	
	//getters e setters
	
	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

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
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * @param rua the rua to set
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	
	//to String
	
	public String toString(){
		return String.format("Estado: %\nCidade: %s\nBairro: %s\n",
				this.estado, this.cidade, this.bairro);
	}
	
}