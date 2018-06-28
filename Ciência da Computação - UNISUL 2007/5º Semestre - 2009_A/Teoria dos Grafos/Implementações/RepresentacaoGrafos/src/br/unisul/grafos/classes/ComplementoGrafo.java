package br.unisul.grafos.classes;


/**
 * Classe Java que implementa um método que gera o complemento
 * de um grafo, utilizando matriz de adjacência.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 */
public class ComplementoGrafo {

	// Atributos

	/**
	 * Objeto do tipo Grafo.
	 */
	private Grafo grafo;

	/**
	 * Matriz onde será montado os dados.
	 */
	private String[][] matriz;


	// Construtores

	/**
	 * Construtor default.
	 */
	public ComplementoGrafo() {
		this.grafo = new Grafo();
		int tamanho = grafo.getVertices().size() + 1;
		this.matriz = new String[tamanho][tamanho];
	}

	/**
	 * Construtor que recebe um objeto do tipo Grafo por parâmetro.
	 * @param grafo Objeto do tipo Grafo.
	 */
	public ComplementoGrafo(Grafo grafo) {
		super();
		this.grafo = grafo;
		int tamanho = grafo.getVertices().size() + 1;
		this.matriz = new String[tamanho][tamanho];
	}


	//Métodos


	/**
	 * Este método gera o complemento de um grafo.
	 * Ele faz o contrário da matriz de adjacencia,
	 * ou seja, se um vértice for adjacente ao outro,
	 * é adicionado o valor "0", senao, o valor "1".
	 */
	public String gerarComplemento() {
		montaMatrizBase();

		for (int i = 1; i < matriz.length; i++) {

			Vertice verticeEmQuestao = grafo.getVertices().get(i-1);

			for (int j = 1; j < matriz.length; j++) {

				Vertice verticeTemp = grafo.getVertices().get(j-1);
				boolean isAdjacent = false;

				if (verticeEmQuestao.getArestas().size() != 0) {

					// inicia a verificação de adjacência.
					for (int k = 0; k < verticeEmQuestao.getArestas().size(); k++) {

						if ((verticeEmQuestao.getArestas().get(k).getVerticeOrigem().equals(verticeEmQuestao)
								&& verticeEmQuestao.getArestas().get(k).getVerticeDestino().equals(verticeTemp)) ||
								verticeEmQuestao.getArestas().get(k).getVerticeOrigem().equals(verticeTemp) &&
								verticeEmQuestao.getArestas().get(k).getVerticeDestino().equals(verticeEmQuestao)) {

							isAdjacent = false;
							break; // interrompe o laço assim que encontrar a adjacência entre os vértices.
							
						}else{

							// verificacao para saber se o vertice e um auto laco
							if(verticeEmQuestao.equals(verticeTemp)){
								isAdjacent = false;
								break;	
							} else{
								isAdjacent = true;
							}
						}
					} // fim da verificação de adjacência.

				} else {
					if (verticeEmQuestao.equals(verticeTemp)) {
						isAdjacent = false;
					} else {
						isAdjacent = true;
					}
				}

				if (isAdjacent) {
					matriz[j][i] = "1";
				} else {
					matriz[j][i] = "0";
				}
			}
		}
		String result = ".:: MATRIZ DE ADJACÊNCIA ::.\n\nGrafo Complementar:\n\n";
		return result.concat(montaResultado());
	}


	// Métodos privados

	/**
	 * Monta a base da matriz de adjacência,
	 * que são os vértices na horizontal e na vertical.
	 */
	private void montaMatrizBase() {
		matriz[0][0] = "#";
		for (int i = 0; i < grafo.getVertices().size(); i++) {
			matriz[i+1][0] = grafo.getVertices().get(i).getDescricao();
		}
		for (int i = 0; i < grafo.getVertices().size(); i++) {
			matriz[0][i+1] = grafo.getVertices().get(i).getDescricao();
		}
	}

	/**
	 * Monta o resultado da matriz de adjacência
	 * em variável do tipo literal.
	 * @return Resultado em uma literal.
	 */
	private String montaResultado() {
		String result = "";
		
		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < matriz.length; j++) {
				result += "\t";
				result += matriz[j][i];
			}
			result +="\t\n";
		}
		return result += "\n";
	}

}
