/**
 * Classe que representa uma aresta E de um grafo G.
 * @author Lucas Nunes, Jakson Gonçalves.
 * @since 06/07/2009.
 */
public class Aresta {

	private String rotulo;
	private double valor;
	private Vertice verticeA, verticeB;

	/**
	 * Construtor default.
	 */
	public Aresta() {
		super();
	}

	/**
	 * Construtor com parâmetros.
	 * @param rotulo
	 * @param valor
	 * @param verticeA
	 * @param verticeB
	 */
	public Aresta(String rotulo, double valor, Vertice verticeA,
			Vertice verticeB) {
		super();
		this.rotulo = rotulo;
		this.valor = valor;
		this.verticeA = verticeA;
		this.verticeB = verticeB;
	}

	/**
	 * Getters & Setters.
	 */
	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Vertice getVerticeA() {
		return verticeA;
	}

	public void setVerticeA(Vertice verticeA) {
		this.verticeA = verticeA;
	}

	public Vertice getVerticeB() {
		return verticeB;
	}

	public void setVerticeB(Vertice verticeB) {
		this.verticeB = verticeB;
	}
}