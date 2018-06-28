
import java.util.ArrayList;

public class Grafo {

	private ArrayList<Vertice> vertices;
	
	
	public Grafo() {
		this.vertices = new ArrayList<Vertice>();
	}

	
	public void adicionaVertice(Vertice vertice) {
			this.vertices.add(vertice);
	}
	

	public void adicionaAresta(String descricao, double peso, Vertice vertice1,
			Vertice vertice2) {

		Aresta aresta = new Aresta(descricao, peso, vertice1, vertice2); // cria uma nova aresta com os devidos atributos.

		vertice1.getArestas().add(aresta); // adiciona no array de arestas do vertice1, a aresta criada.
		vertice2.getArestas().add(aresta); // adiciona no array de arestas do vertice2, a aresta criada.

	}


	
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}
	
}
