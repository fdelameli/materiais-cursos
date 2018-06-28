
public class Aresta {	
	private Integer peso;	
	public Integer getPeso(){
		return this.peso;
	}
	
	private Vertice verticeDestino;
	public Vertice getVerticeDestino(){
		return this.verticeDestino;
	}
	
	private Vertice verticeOrigem;
	public Vertice getVerticeOrigem(){
		return this.verticeOrigem;
	}
	
	/**
	 * Constructor
	 * 
	 * Cria aresta e adiciona referencia no vértice
	 * @param vertice1
	 * @param vertice2
	 * @param peso
	 */
	public Aresta(Vertice vertice1, Vertice vertice2, Integer peso){		
		// Ajusta para saída
		if (vertice1.getLabel() < vertice2.getLabel()){
			this.verticeOrigem = vertice1;
			this.verticeDestino = vertice2;
		} else {
			this.verticeOrigem = vertice2;
			this.verticeDestino = vertice1;
		}
		this.peso = peso;
	}
	
	public String toString(){
		return this.verticeOrigem + " " + this.verticeDestino;
	}
}
