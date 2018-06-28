package br.unisul.grafos.classes;
import java.util.ArrayList;


/**
 * Classe Java que implementa uma matriz de incidência.
 * Esta forma de representação é válida para grafos
 * valorados, dirigidos, valorado e dirigido ou normal.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 */
public class MatrizIncidencia implements ITiposDeGrafos {

	// Atributos
	
	/**
	 * Objeto do tipo Grafo.
	 */
	private Grafo grafo;
	
	/**
	 * Matriz onde será montado os dados.
	 */
	private String[][] matriz;
	
	/**
	 * ArrayList das arestas do grafo.
	 */
	private ArrayList<Aresta> arestas;

	
	// Construtores
	
	/**
	 * Construtor default.
	 */
	public MatrizIncidencia() {
		this.grafo = new Grafo();
		this.arestas = new ArrayList<Aresta>();
		int tamanhoArestas = arestas.size()+1;
		int tamanhoVertices = grafo.getVertices().size() + 1;
		this.matriz = new String[tamanhoArestas][tamanhoVertices];
	}
	
	/**
	 * Construtor que recebe um objeto do tipo Grafo por parâmetro.
	 * @param grafo Objeto do tipo Grafo.
	 */
	public MatrizIncidencia(Grafo grafo) {
		this.grafo = grafo;
		this.arestas = montaArrayArestas();
		int tamanhoVertices = grafo.getVertices().size() + 1;
		int tamanhoArestas = arestas.size()+1;
		this.matriz = new String[tamanhoArestas][tamanhoVertices];
	}
	
	
	
	// Métodos
	
	
//	@Override
	public String grafoNormal() {
		montaMatrizBase();
		
		for (int i = 0; i < grafo.getVertices().size(); i++) {
			
			Vertice verticeEmQuestao = grafo.getVertices().get(i);
			boolean isIncidente = false;
			
			for (int j = 0; j < arestas.size(); j++) {
				
				Aresta arestaEmQuestao = arestas.get(j);
				
				if (arestaEmQuestao.getVerticeDestino().equals(verticeEmQuestao)||
						arestaEmQuestao.getVerticeOrigem().equals(verticeEmQuestao)) {
					isIncidente = true;
				} else {
					isIncidente = false;
				}
				
				if (isIncidente) {
					matriz[j+1][i+1] = "1";
				} else {
					matriz[j+1][i+1] = "0";
				}
				
			}
		}
		String result = ".:: MATRIZ DE INCIDÊNCIA ::.\n\nGrafo Normal:\n\n";
		return result.concat(montaResultado());
	}

	
//	@Override
	public String grafoDirigido() {
		montaMatrizBase();
		
		for (int i = 0; i < grafo.getVertices().size(); i++) {
			
			Vertice verticeEmQuestao = grafo.getVertices().get(i);
			boolean isIncidente = false;
			String temp = "";
			
			
			for (int j = 0; j < arestas.size(); j++) {
				
				Aresta arestaEmQuestao = arestas.get(j);
				
				if (arestaEmQuestao.getVerticeOrigem().equals(verticeEmQuestao)) {
					isIncidente = true;
					temp = "1";
				} else if (arestaEmQuestao.getVerticeDestino().equals(verticeEmQuestao)) {
					isIncidente = true;
					temp = "-1";
				} else {
					isIncidente = false;
					temp = "0";
				}
				
				if (isIncidente) {
					matriz[j+1][i+1] = temp;
				} else {
					matriz[j+1][i+1] = temp;
				}
				
			}
		}
		String result = ".:: MATRIZ DE INCIDÊNCIA ::.\n\nGrafo Dirigido:\n\n";
		return result.concat(montaResultado());
	}

	
//	@Override
	public String grafoValorado() {
	montaMatrizBase();
		
		for (int i = 0; i < grafo.getVertices().size(); i++) {
			
			Vertice verticeEmQuestao = grafo.getVertices().get(i);
			boolean isIncidente = false;
			
			for (int j = 0; j < arestas.size(); j++) {
				
				Aresta arestaEmQuestao = arestas.get(j);
				
				if (arestaEmQuestao.getVerticeDestino().equals(verticeEmQuestao)||
						arestaEmQuestao.getVerticeOrigem().equals(verticeEmQuestao)) {
					isIncidente = true;
				} else {
					isIncidente = false;
				}
				
				if (isIncidente) {
					matriz[j+1][i+1] = arestaEmQuestao.getPeso();
				} else {
					matriz[j+1][i+1] = "*";
				}
				
			}
		}
		String result = ".:: MATRIZ DE INCIDÊNCIA ::.\n\nGrafo Valorado:\n\n";
		return result.concat(montaResultado());
	}
	
	
//	@Override
	public String grafoDirigidoValorado() {
	montaMatrizBase();
		
		for (int i = 0; i < grafo.getVertices().size(); i++) {
			
			Vertice verticeEmQuestao = grafo.getVertices().get(i);
			boolean isIncidente = false;
			
			for (int j = 0; j < arestas.size(); j++) {
				
				Aresta arestaEmQuestao = arestas.get(j);
				
				if (arestaEmQuestao.getVerticeOrigem().equals(verticeEmQuestao)) {
					isIncidente = true;
				} else {
					isIncidente = false;
				}
				
				if (isIncidente) {
					matriz[j+1][i+1] = arestaEmQuestao.getPeso();
				} else {
					matriz[j+1][i+1] = "*";
				}
				
			}
		}
		String result = ".:: MATRIZ DE INCIDÊNCIA ::.\n\nGrafo Dirigido e Valorado:\n\n";
		return result.concat(montaResultado());
	}


	// Métodos privados
	
	/**
	 * Monta a base da matriz de adjacência,
	 * que são os vértices na horizontal e na vertical.
	 */
	private void montaMatrizBase() {
		matriz[0][0] = "#";
		for (int i = 0; i < arestas.size(); i++) {
			matriz[i+1][0] = arestas.get(i).getDescricao();
		}
		for (int i = 0; i < grafo.getVertices().size(); i++) {
			matriz[0][i+1] = grafo.getVertices().get(i).getDescricao();
		}
		
	}
	
	/**
	 * Monta o resultado da matriz de incidência
	 * em uma variável do tipo literal.
	 * @return Resultado em uma literal.
	 */
	private String montaResultado() {
		String result = "";
		
		for (int i = 0; i < grafo.getVertices().size()+1; i++) {
			
			for (int j = 0; j < arestas.size()+1; j++) {
				result += "\t";
				result += matriz[j][i];
			}
			result +="\t\n";
		}
		
		return result += "\n";
	}
	
	/**
	 * Monta o ArrayList das arestas contidas no grafo.
	 * @return ArrayList de arestas.
	 */
	private ArrayList<Aresta> montaArrayArestas() {
		ArrayList<Aresta> arestas = new ArrayList<Aresta>();
		
		for (int i = 0; i < grafo.getVertices().size(); i++) {
			
			for (int j = 0; j < grafo.getVertices().get(i).getArestas().size(); j++) {
				
				if (!arestas.contains(grafo.getVertices().get(i).getArestas().get(j))) {
					arestas.add(grafo.getVertices().get(i).getArestas().get(j));
				}
			}
		}
		return arestas;
	}

}
