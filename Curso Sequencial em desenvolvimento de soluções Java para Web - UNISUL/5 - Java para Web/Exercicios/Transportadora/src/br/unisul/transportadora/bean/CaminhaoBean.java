package br.unisul.transportadora.bean;

/**
 * Classe Java que representa um caminhão e seus atributos.
 * @author Fabio Dela Bruna
 *
 */
public class CaminhaoBean {

	// Atributos
	
	/**
	 * Código do caminhão.
	 */
	private Integer codigo;
	
	/**
	 * Nome/Descrilção do caminhão.
	 */
	private String descricao;
	
	
	// Construtores
	
	/**
	 * Construtor default.
	 */
	public CaminhaoBean() {
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
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
