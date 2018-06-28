

public class Aresta {

	private String descricao;
	private Vertice verticeOrigem;
	private Vertice verticeDestino;
	private double peso; 
	
	
	public Aresta() {
		super();
	}

	public Aresta(String descricao, double peso, Vertice verticeOrigem, Vertice verticeDestino) {
		super();
		this.descricao = descricao;
		this.verticeOrigem = verticeOrigem;
		this.verticeDestino = verticeDestino;
		this.peso = peso;
	}

	public String toString() {
		return this.getDescricao();
	}

	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Vertice getVerticeOrigem() {
		return verticeOrigem;
	}

	public void setVerticeOrigem(Vertice verticeOrigem) {
		this.verticeOrigem = verticeOrigem;
	}

	public Vertice getVerticeDestino() {
		return verticeDestino;
	}

	public void setVerticeDestino(Vertice verticeDestino) {
		this.verticeDestino = verticeDestino;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}
