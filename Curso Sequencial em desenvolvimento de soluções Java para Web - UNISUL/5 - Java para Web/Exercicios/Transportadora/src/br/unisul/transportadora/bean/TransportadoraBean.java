package br.unisul.transportadora.bean;

/**
 * Classe Java que representa uma transportadora e seus atributos.
 * @author Fabio Dela Bruna
 */
public class TransportadoraBean {

	// Atributos
	
	/**
	 * Código da transportadora.
	 */
	private Integer codigo;
	
	/**
	 * Nome da transportadora.
	 */
	private String nome;

	
	// Construtores
	
	/**
	 * Construtor default.
	 */
	public TransportadoraBean() {
		super();
	}

	
	// Getters e Setters
	
	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	
}
