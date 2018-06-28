package br.unisul.grafos.classes;

/**
 * Classe Java para representar uma aresta.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 */
public class Aresta {

	// Atributos
	
	/**
	 * Rótulo da aresta (nome/descrição).
	 */
	private String descricao;

	/**
	 * Vértice de onde parte a aresta.
	 */
	private Vertice verticeOrigem;
	
	/**
	 * Vértice de destino da aresta.
	 */
	private Vertice verticeDestino;
	
	/**
	 * Descreve o peso da aresta.
	 */
	private String peso; 
	
	
	// Construtores
	
	/**
	 * Construtor default.
	 */
	public Aresta() {
		super();
	}


	/**
	 * Construtor com parâmetros.
	 * @param descricao Rótulo da aresta (nome/descrição).
	 * @param verticeOrigem Vértice de onde parte a aresta (origem).
	 * @param verticeDestino Vértice de destino da aresta.
	 * @param peso Peso da aresta.
	 */
	public Aresta(String descricao, Vertice verticeOrigem, Vertice verticeDestino, String peso) {
		super();
		this.descricao = descricao;
		this.verticeOrigem = verticeOrigem;
		this.verticeDestino = verticeDestino;
		this.peso = peso;
	}

	
	// Método equals e toString
	
	/**
	 * Sobrescrita do método equals.
	 * @param obj Objeto a ser comparado.
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Aresta) {
			Aresta aresta = (Aresta)obj;
			return (this.getDescricao().equals( aresta.getDescricao() ))
			|| ((this.getVerticeOrigem().equals( aresta.getVerticeOrigem() )
			&& this.getVerticeDestino().equals( aresta.getVerticeDestino()) )
			|| ((this.getVerticeOrigem().equals( aresta.getVerticeDestino()) )
			&& (this.getVerticeDestino().equals( aresta.getVerticeOrigem() ))));
		} 
		return false;
	}
	
	/**
	 * Sobrescrita do método equals().
	 */
	public String toString() {
		return this.getDescricao();
	}
	

	// Getters e Setters

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

	/**
	 * @return the verticeOrigem
	 */
	public Vertice getVerticeOrigem() {
		return verticeOrigem;
	}

	/**
	 * @param verticeOrigem the verticeOrigem to set
	 */
	public void setVerticeOrigem(Vertice verticeOrigem) {
		this.verticeOrigem = verticeOrigem;
	}

	/**
	 * @return the verticeDestino
	 */
	public Vertice getVerticeDestino() {
		return verticeDestino;
	}

	/**
	 * @param verticeDestino the verticeDestino to set
	 */
	public void setVerticeDestino(Vertice verticeDestino) {
		this.verticeDestino = verticeDestino;
	}

	/**
	 * @return the peso
	 */
	public String getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(String peso) {
		this.peso = peso;
	}
	
	
}
