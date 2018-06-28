package br.unisul.grafos.classes;
/**
 * Interface que define os métodos que comum das
 * classes de representação de grafos. Essas classes
 * terão obrigatoriamente que implementar esses métodos.
 * @author Fabio Dela Bruna, Márcio Ozório Teixeira.
 */
public interface ITiposDeGrafos {

	/**
	 * Método que monta a representação para grafos normais,
	 * ou seja, para grafos não-dirigidos e não-valorados.
	 * @return String contendo a representação do grafo.
	 */
	public String grafoNormal();

	/**
	 * Método que monta a representação para grafos dirigidos.
	 * @return String contendo a representação do grafo.
	 */
	public String grafoDirigido();
	
	/**
	 * Método que monta a representação para grafos valorados.
	 * @return String contendo a representação do grafo.
	 */
	public String grafoValorado();
	
	/**
	 * Método que monta a representação para grafos dirigidos e valorados.
	 * @return String contendo a representação do grafo.
	 */
	public String grafoDirigidoValorado();
}
