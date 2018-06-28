package br.unisul.aula.exemplorevenda.entidade;

/**
 * Entidade Cidade
 * @author Fabio Dela Bruna
 * @since 22/04/2008
 */
public class Cidade {
	
	// atributos
	
	private String nome;// Nome da cidade
	private String estado;
		
	
	// construtores
	
	/**
	 * Construtor default.
	 */
	public Cidade() {
		super();		
	}

	/**
	 * Construtor com parâmetros (com dados da cidade).
	 * @param nome - Nome da Cidade.
	 * @param estado - Estado onde a cidade se localiza.
	 */
	public Cidade(String nome, String estado) {
		super();
		this.nome = nome;
		this.estado = estado;
	}


	// getters e setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	// toString
	
	public String toString(){
		return String.format("Nome: %s\nEstado: %s\n\n", this.nome, this.estado);
	}

}
