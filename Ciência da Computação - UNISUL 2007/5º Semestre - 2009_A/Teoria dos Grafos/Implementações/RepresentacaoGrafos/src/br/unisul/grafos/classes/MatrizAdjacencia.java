package br.unisul.grafos.classes;

/**
 * Classe Java que implementa uma matriz de adjacência.
 * Esta forma de representação é válida para grafos
 * valorados, dirigidos, valorado e dirigido ou normal.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 */
public class MatrizAdjacencia implements ITiposDeGrafos {

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
	public MatrizAdjacencia() {
		this.grafo = new Grafo();
		int tamanho = grafo.getVertices().size() + 1;
		this.matriz = new String[tamanho][tamanho];
	}

	/**
	 * Construtor que recebe um objeto do tipo Grafo por parâmetro.
	 * @param grafo Objeto do tipo Grafo.
	 */
	public MatrizAdjacencia(Grafo grafo) {
		super();
		this.grafo = grafo;
		int tamanho = grafo.getVertices().size() + 1;
		this.matriz = new String[tamanho][tamanho];
	}
	
	
	
	// Métodos
	
	
	@Override
	public String grafoNormal() {
		montaMatrizBase();
		
		for (int i = 1; i < matriz.length; i++) {
			
			Vertice verticeEmQuestao = grafo.getVertices().get(i-1);
			
			for (int j = 1; j < matriz.length; j++) {
				
				Vertice verticeTemp = grafo.getVertices().get(j-1);
				boolean isAdjacent = false;
				
				// inicia a verificação de adjacência.
				for (int k = 0; k < verticeEmQuestao.getArestas().size(); k++) {
					
					if ((verticeEmQuestao.getArestas().get(k).getVerticeOrigem().equals(verticeEmQuestao)
							&& verticeEmQuestao.getArestas().get(k).getVerticeDestino().equals(verticeTemp)) ||
							
							verticeEmQuestao.getArestas().get(k).getVerticeOrigem().equals(verticeTemp) &&
							verticeEmQuestao.getArestas().get(k).getVerticeDestino().equals(verticeEmQuestao)) {
						
						isAdjacent = true;
						break; // interrompe o laço assim que encontrar a adjacência entre os vértices.
					} else {
						isAdjacent = false;
					}
				} // fim da verificação de adjacência.
				
				if (isAdjacent) {
					matriz[j][i] = "1";
				} else {
					matriz[j][i] = "0";
				}
			}
		}
		String result = ".:: MATRIZ DE ADJACÊNCIA ::.\n\nGrafo Normal:\n\n";
		return result.concat(montaResultado());
	}
	
	
	@Override
	public String grafoDirigido() {
		montaMatrizBase();
		
		for (int i = 1; i < matriz.length; i++) {
			
			Vertice verticeEmQuestao = grafo.getVertices().get(i-1);
			
			for (int j = 1; j < matriz.length; j++) {
				
				Vertice verticeTemp = grafo.getVertices().get(j-1);
				boolean isAdjacent = false;
				
				// inicia a verificação de adjacência.
				for (int k = 0; k < verticeEmQuestao.getArestas().size(); k++) {
					
					if ((verticeEmQuestao.getArestas().get(k).getVerticeOrigem().equals(verticeEmQuestao)
							&& verticeEmQuestao.getArestas().get(k).getVerticeDestino().equals(verticeTemp))) {
						
						isAdjacent = true;
						break; // interrompe o laço assim que encontrar a adjacência entre os vértices.
					} else {
						isAdjacent = false;
					}
				} // fim da verificação de adjacência.
				
				if (isAdjacent) {
					matriz[j][i] = "1";
				} else {
					matriz[j][i] = "0";
				}
			}
		}
		String result = ".:: MATRIZ DE ADJACÊNCIA ::.\n\nGrafo Dirigido:\n\n";
		return result.concat(montaResultado());
	}	
	
	
	@Override
	public String grafoValorado() {
		montaMatrizBase();
		
		for (int i = 1; i < matriz.length; i++) {
			
			Vertice verticeEmQuestao = grafo.getVertices().get(i-1);
			
			for (int j = 1; j < matriz.length; j++) {
				
				Vertice verticeTemp = grafo.getVertices().get(j-1);
				boolean isAdjacent = false;
				Aresta arestaTemp = null;
				
				// inicia a verificação de adjacência.
				for (int k = 0; k < verticeEmQuestao.getArestas().size(); k++) {
					
					if ((verticeEmQuestao.getArestas().get(k).getVerticeOrigem().equals(verticeEmQuestao)
							&& verticeEmQuestao.getArestas().get(k).getVerticeDestino().equals(verticeTemp)) ||
							
							verticeEmQuestao.getArestas().get(k).getVerticeOrigem().equals(verticeTemp) &&
							verticeEmQuestao.getArestas().get(k).getVerticeDestino().equals(verticeEmQuestao)) {
						
						arestaTemp = verticeEmQuestao.getArestas().get(k);
						isAdjacent = true;
						break; // interrompe o laço assim que encontrar a adjacência entre os vértices.
					} else {
						isAdjacent = false;
					}
				} // fim da verificação de adjacência.
				
				if (isAdjacent) {
					matriz[j][i] = arestaTemp.getPeso();
				} else {
					matriz[j][i] = "*";
				}
			}
		}
		String result = ".:: MATRIZ DE ADJACÊNCIA ::.\n\nGrafo Valorado:\n\n";
		return result.concat(montaResultado());
	}
	
	
	@Override
	public String grafoDirigidoValorado() {
		montaMatrizBase();
		
		for (int i = 1; i < matriz.length; i++) {
			
			Vertice verticeEmQuestao = grafo.getVertices().get(i-1);
			
			for (int j = 1; j < matriz.length; j++) {
				
				Vertice verticeTemp = grafo.getVertices().get(j-1);
				boolean isAdjacent = false;
				Aresta arestaTemp = null;
				
				// inicia a verificação de adjacência.
				for (int k = 0; k < verticeEmQuestao.getArestas().size(); k++) {
					
					if ((verticeEmQuestao.getArestas().get(k).getVerticeOrigem().equals(verticeEmQuestao)
							&& verticeEmQuestao.getArestas().get(k).getVerticeDestino().equals(verticeTemp))) {
						
						arestaTemp = verticeEmQuestao.getArestas().get(k);
						isAdjacent = true;
						break; // interrompe o laço assim que encontrar a adjacência entre os vértices.
					} else {
						isAdjacent = false;
					}
				} // fim da verificação de adjacência.
				
				if (isAdjacent) {
					matriz[j][i] = arestaTemp.getPeso();
				} else {
					matriz[j][i] = "*";
				}
			}
		}
		String result = ".:: MATRIZ DE ADJACÊNCIA ::.\n\nGrafo Dirigido e Valorado:\n\n";
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
