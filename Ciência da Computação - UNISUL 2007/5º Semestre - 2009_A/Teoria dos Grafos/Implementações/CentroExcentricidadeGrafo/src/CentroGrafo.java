import javax.swing.JOptionPane;


public class CentroGrafo  {
	
	private Grafo grafo;
	private double[][] matriz;

	
	
	public CentroGrafo() {
		this.grafo = new Grafo();
		int tamanho = grafo.getVertices().size();
		this.matriz = new double[tamanho][tamanho];
	}

	public CentroGrafo(Grafo grafo) {
		super();
		this.grafo = grafo;
		int tamanho = grafo.getVertices().size();
		this.matriz = new double[tamanho][tamanho];
	}
	
	
	
	/**
	 * Método que efetua a análise de adjacência
	 * e monta a matriz de adjacência.
	 */
	public double[][] grafoValorado() {
		
		for (int i = 0; i < matriz.length; i++) {
			
			Vertice verticeEmQuestao = grafo.getVertices().get(i);
			
			for (int j = 0; j < matriz.length; j++) {
				
				Vertice verticeTemp = grafo.getVertices().get(j);
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
					matriz[j][i] = 0;
				}
			}
		}
		return matriz;
	}

	/**
	 * Método que retorna um vertor com as excentricidades.
	 */
	private double[] getExcentricidade() {
		
		this.matriz = grafoValorado();
		
		double[] excentricidades = new double[this.grafo.getVertices().size()];
		double aux = 0.0;
		
		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz.length; j++) {
			
				if (matriz[j][i] > aux) {
					aux = matriz[j][i];
				}
				
			}
			
			excentricidades[i] = aux;
			aux = 0.0;
			
		}
		return excentricidades;
	}
	
	
	/**
	 * Método que retorna o centro do grafo.
	 */
	public void calculaCentroRaioGrafo() {
		System.out.println("Excentricidades");
		double[] excentricidades = getExcentricidade();
		double centro = excentricidades[0];
		int auxCentro = 0;
		System.err.print(excentricidades[0] + "\t");
		
		for (int i = 1; i < excentricidades.length; i++) {
			System.err.print(excentricidades[i] + "\t");
			if (excentricidades[i] < centro) {
				centro = excentricidades[i];
				auxCentro = i;
			}
			
		}
		JOptionPane.showMessageDialog(null, "Centro: " + grafo.getVertices().get(auxCentro));
		JOptionPane.showMessageDialog(null, "Raio: " + centro);
	}
	
	
	
	/**
	 * Retorna a matriz de adjacência.
	 */
	public double[][] getMatrizAdjacencia() {
		return grafoValorado();
	}
	
	
	
}

