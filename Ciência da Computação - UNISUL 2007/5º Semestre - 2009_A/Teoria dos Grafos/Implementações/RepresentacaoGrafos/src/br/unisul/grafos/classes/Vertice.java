package br.unisul.grafos.classes;
import java.util.ArrayList;

/**
 * Classe Java para representar um Vértice.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 */
public class Vertice {
	
	// Atributos
	
	/**
	 * Rótulo do vértice (nome/descrição). 
	 */
	private String descricao;

	/**
	 * Array de vértices que são adjacentes.
	 */
	private ArrayList<Aresta> arestas;
	
	
	// Construtores
	
	/**
	 * Construtor default.
	 */
	public Vertice() {
		super();
		this.arestas = new ArrayList<Aresta>();
	}

	/**
	 * Construtor com parâmetros.
	 * @param descricao
	 * @param vertices
	 */
	public Vertice(String descricao) {
		super();
		this.descricao = descricao;
		this.arestas = new ArrayList<Aresta>();
	}
	
	
	// Métodos equals e toString
	
	/**
	 * Sobrescrita do método equals.
	 * @param obj Objeto a ser comparado.
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Vertice) {
			Vertice vertice = (Vertice)obj;
			return this.getDescricao().equals( vertice.getDescricao() );
		}
		return false;
	}
	
	/**
	 * Sobrescrita do método toString.
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
	 * @return the vertices
	 */
	public ArrayList<Aresta> getArestas() {
		return arestas;
	}

	/**
	 * @param vertices the vertices to set
	 */
	public void setAresta(ArrayList<Aresta> arestas) {
		this.arestas = arestas;
	}
	

}
