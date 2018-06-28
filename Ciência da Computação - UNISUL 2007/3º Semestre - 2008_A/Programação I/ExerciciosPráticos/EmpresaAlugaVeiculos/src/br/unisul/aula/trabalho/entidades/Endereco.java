package br.unisul.aula.trabalho.entidades;


/**
 * Entidade Endereço.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 * @since 12/05/2008
 */
public class Endereco {
	
	// Atributos
	
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private int numero;
	private String cep;

	
	// Construtores

	/**
	 * Construtor default.
	 */
	public Endereco() {
		this("", "", "", "", 0, "");
	}
	
	/**
	 * Construtor com parâmetros.
	 * @param estado - Estado.
	 * @param cidade - Cidade.
	 * @param bairro - Bairro.
	 * @param rua - Rua.
	 * @param numero - Número.
	 * @param cep - CEP.
	 */
	public Endereco(String estado, String cidade, String bairro, String rua, int numero, String cep) {
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
	}

	
	// Getters and Setters

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	
	//toString

	public String toString() {
		return String.format("Rua: %s   --> nº: %s   --> CEP: %s\nBairro: %s   --> Cidade: %s   --> Estado: %s\n",
				this.rua, this.numero, this.cep, this.bairro, this.cidade, this.estado);
		}
}