
import java.util.ArrayList;

public class Vertice {
	
	private String descricao;
	private ArrayList<Aresta> arestas;

	
	public Vertice() {
		super();
		this.arestas = new ArrayList<Aresta>();
	}

	public Vertice(String descricao) {
		super();
		this.descricao = descricao;
		this.arestas = new ArrayList<Aresta>();
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

	public ArrayList<Aresta> getArestas() {
		return arestas;
	}

	public void setAresta(ArrayList<Aresta> arestas) {
		this.arestas = arestas;
	}
	

}
