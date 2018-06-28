package br.unisul.grafos.classes;
import java.util.ArrayList;


/**
 * Classe Java que implementa uma lista de adjacência.
 * Esta forma de representação é válida para grafos
 * valorados, dirigidos, valorado e dirigido ou normal.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 */
public class ListaAdjacencia implements ITiposDeGrafos {

	// Atributos
	
	/**
	 * Objeto do tipo Grafo.
	 */
	private Grafo grafo;
	
	
	// Construtores
	
	/**
	 * Construtor default.
	 */
	public ListaAdjacencia() {
		this.grafo = new Grafo();
	}
	
	/**
	 * Construtor que recebe um objeto do tipo Grafo por parâmetro.
	 * @param grafo Objeto do tipo Grafo.
	 */
	public ListaAdjacencia(Grafo grafo) {
		this.grafo = grafo;
	}
	
	
	// Métodos
	
	@Override
	public String grafoNormal() {
		String resultado = "";
		
		for (int i = 0; i < grafo.getVertices().size(); i++) {
			
			Vertice verticeEmQuestao = grafo.getVertices().get(i);
			resultado += "\n\t" + grafo.getVertices().get(i).getDescricao() + " :\t";
			
			for (int j = 0; j < grafo.getVertices().get(i).getArestas().size(); j++) {
	
				Vertice verticeTemp;
				
				if (grafo.getVertices().get(i).getArestas().get(j).getVerticeOrigem().equals( verticeEmQuestao )) {
					verticeTemp = grafo.getVertices().get(i).getArestas().get(j).getVerticeDestino();
				} else {
					verticeTemp = grafo.getVertices().get(i).getArestas().get(j).getVerticeOrigem();
				}
				
				// monta o resultado.
				if (j == grafo.getVertices().get(i).getArestas().size() - 1) {
					resultado += verticeTemp.getDescricao() + "";					
				} else {
					resultado += verticeTemp.getDescricao() + "\t";
				}
			}
		}
		String result = ".:: LISTA DE ADJACÊNCIA ::.\n\nGrafo Normal:\n\n";
		return result.concat(resultado);
	}
	
	
	@Override
	public String grafoDirigido() {
		String resultado = "";
		
		for (int i = 0; i < grafo.getVertices().size(); i++) {
			
			Vertice verticeEmQuestao = grafo.getVertices().get(i);
			resultado += "\n\t" + verticeEmQuestao.getDescricao() + " :\t";
			ArrayList<Vertice> verticesAdjacentes = new ArrayList<Vertice>();
			
			for (int j = 0; j < verticeEmQuestao.getArestas().size(); j++) {
				
				if (!verticeEmQuestao.getArestas().get(j).getVerticeDestino().equals( verticeEmQuestao )) {
					if (!verticesAdjacentes.contains(verticeEmQuestao.getArestas().get(j).getVerticeDestino())) {
						verticesAdjacentes.add(verticeEmQuestao.getArestas().get(j).getVerticeDestino());
					}
				}				
			}
			
			for (int j2 = 0; j2 < verticesAdjacentes.size(); j2++) {
				if (j2 == verticesAdjacentes.size() - 1) {
					resultado += verticesAdjacentes.get(j2).getDescricao() + "";
				} else {
					resultado += verticesAdjacentes.get(j2).getDescricao() + "\t";
				}
			}
			verticesAdjacentes.clear();
		}
		String result = ".:: LISTA DE ADJACÊNCIA ::.\n\nGrafo Dirigido:\n\n";
		return result.concat(resultado);
	}
	
	
	@Override
	public String grafoValorado() {
		String resultado = "";
		
		for (int i = 0; i < grafo.getVertices().size(); i++) {
			
			Vertice verticeEmQuestao = grafo.getVertices().get(i);
			resultado += "\n\t" + grafo.getVertices().get(i).getDescricao() + " :\t";
			
			for (int j = 0; j < grafo.getVertices().get(i).getArestas().size(); j++) {
	
				Vertice verticeTemp;
				
				if (grafo.getVertices().get(i).getArestas().get(j).getVerticeOrigem().equals( verticeEmQuestao )) {
					verticeTemp = grafo.getVertices().get(i).getArestas().get(j).getVerticeDestino();
				} else {
					verticeTemp = grafo.getVertices().get(i).getArestas().get(j).getVerticeOrigem();
				}
				
				if (j == grafo.getVertices().get(i).getArestas().size() - 1) {
					resultado += verticeTemp.getDescricao() + "/" +
					grafo.getVertices().get(i).getArestas().get(j).getPeso();
				} else {
					resultado += verticeTemp.getDescricao() + "/" +
					grafo.getVertices().get(i).getArestas().get(j).getPeso() + "\t";
				}
			}
		}
		String result = ".:: LISTA DE ADJACÊNCIA ::.\n\nGrafo Valorado:\n\n";
		return result.concat(resultado);
	}
	
	
	@Override
	public String grafoDirigidoValorado() {
		String resultado = "";
		
		for (int i = 0; i < grafo.getVertices().size(); i++) {
			
			Vertice verticeEmQuestao = grafo.getVertices().get(i);
			resultado += "\n\t" + verticeEmQuestao.getDescricao() + " :\t";
			ArrayList<Vertice> verticesAdjacentes = new ArrayList<Vertice>();
			
			for (int j = 0; j < verticeEmQuestao.getArestas().size(); j++) {
				
				if (!verticeEmQuestao.getArestas().get(j).getVerticeDestino().equals( verticeEmQuestao )) {
					if (!verticesAdjacentes.contains(verticeEmQuestao.getArestas().get(j).getVerticeDestino())) {
						verticesAdjacentes.add(verticeEmQuestao.getArestas().get(j).getVerticeDestino());
					}
				}				
			}
			
			for (int k = 0; k < verticesAdjacentes.size(); k++) {
				if (k == verticesAdjacentes.size() - 1) {
					resultado += verticesAdjacentes.get(k).getDescricao() + "/";
			
					for (int y = 0; y < verticesAdjacentes.get(k).getArestas().size(); y++) {
						Aresta arestaEmQuestao = verticesAdjacentes.get(k).getArestas().get(y);
						
						if ((arestaEmQuestao.getVerticeOrigem().equals(verticeEmQuestao))
							&& arestaEmQuestao.getVerticeDestino().equals(verticesAdjacentes.get(k))) {
							resultado += verticesAdjacentes.get(k).getArestas().get(y).getPeso();
						}
					}
					
				} else {
					resultado += verticesAdjacentes.get(k).getDescricao() + "/";
					
					for (int y = 0; y < verticesAdjacentes.get(k).getArestas().size(); y++) {
						Aresta arestaEmQuestao = verticesAdjacentes.get(k).getArestas().get(y);
						
						if ((arestaEmQuestao.getVerticeOrigem().equals(verticeEmQuestao))
							&& arestaEmQuestao.getVerticeDestino().equals(verticesAdjacentes.get(k))) {
							resultado += verticesAdjacentes.get(k).getArestas().get(y).getPeso() + "\t";
						}
					}
				}
			}
			verticesAdjacentes.clear();
		}
		String result = ".:: LISTA DE ADJACÊNCIA ::.\n\nGrafo Dirigido e Valorado:\n\n";
		return result.concat(resultado);
	}

	
}
