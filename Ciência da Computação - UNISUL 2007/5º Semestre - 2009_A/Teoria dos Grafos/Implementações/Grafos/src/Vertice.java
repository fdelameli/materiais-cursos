import java.util.ArrayList;


public class Vertice {
	/**
	 * Constructor
	 * @param label indice do vértice (de 1 a n)
	 */
	public Vertice(Integer label){
		this.label = label;
	}
	
	/**
	 * Relacionamentos
	 */
	private ArrayList<Aresta> arestas = new ArrayList<Aresta>();
	/**
	 * Retorna relacionamentos
	 * @return relacionamentos
	 */
	public ArrayList<Aresta> getArestas(){
		return this.arestas;
	}
	/**
	 * Adiciona referencia a uma aresta
	 * @param aresta
	 */
	public void AdicionaAresta(Aresta aresta){
		this.arestas.add(aresta);
	}
	
	/**
	 * Label do vértice
	 */
	private Integer label;
	public Integer getLabel(){
		return this.label;
	}
	
	public String toString(){
		return this.label.toString();
	}
}
