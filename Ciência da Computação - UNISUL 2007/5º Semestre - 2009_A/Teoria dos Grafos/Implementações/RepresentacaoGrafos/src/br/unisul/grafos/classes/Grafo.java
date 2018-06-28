package br.unisul.grafos.classes;
import java.util.ArrayList;

import br.unisul.grafos.exceptions.ArestaRepetidaException;
import br.unisul.grafos.exceptions.VerticeRepetidoException;

/**
 * Classe Java para representar um grafo como um todo.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 */
public class Grafo {

	// Atributos
	
	/**
	 * ArrayList de vertices que formam o grafo.
	 */
	private ArrayList<Vertice> vertices;
	
	
	// Construtores
	
	/**
	 * Construtor default.
	 * Apenas inicializa o ArrayList.
	 */
	public Grafo() {
		this.vertices = new ArrayList<Vertice>();
	}

	
	// Métodos

	/**
	 * Método utilizado para inserir um vértice ao grafo.
	 * 
	 * @param vertice Vértice a ser inserido no grafo.
	 * @throws VerticeRepetidoException.
	 */
	public void adicionaVertice(Vertice vertice) throws VerticeRepetidoException {
		if (!this.vertices.contains(vertice)) {
			this.vertices.add(vertice);
		} else {
			throw new VerticeRepetidoException("Este vértice já foi inserido no grafo!");
		}
	}
	

	/**
	 * Método utilizado para inserir uma aresta.
	 * Cada vértice possui um array de arestas que incidem a ele.
	 * A aresta não é inserida diretamento no grafo,
	 * mas sim no array de cada vértice em que ela é incide.
	 * 
	 * @param descricao Rótulo da aresta (descrição/nome).
	 * @param vertice1 Vértice de onde parte a aresta (origem).
	 * @param vertice2 Vértice de destino da aresta.
	 * @param peso Peso de cada aresta.
	 */
	public void adicionaAresta(String descricao, Vertice vertice1,
			Vertice vertice2, String peso) throws ArestaRepetidaException {
		
		Aresta aresta = new Aresta(descricao, vertice1, vertice2, peso); // cria uma nova aresta com os devidos atributos.
	
		if (!(vertice1.getArestas().contains(aresta) && (vertice2.getArestas().contains(aresta)))) {
			vertice1.getArestas().add(aresta); // adiciona no array de arestas do vertice1, a aresta criada.
			vertice2.getArestas().add(aresta); // adiciona no array de arestas do vertice2, a aresta criada.
		} else {
			throw new ArestaRepetidaException("Esta aresta já foi inseida no grafo.\nNão é possível adicionar múltiplas arestas!");
		}
		
	}
	
	
	
	// Getters e Setters
	
	/**
	 * @return the vertices
	 */
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}

	/**
	 * @param vertices the vertices to set
	 */
	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}
	
}
