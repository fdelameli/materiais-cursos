package br.unisul.grafos.classes;
import java.util.ArrayList;


/**
 * Classe Java que implementa uma lista de arestas.
 * Esta forma de representação é válida para grafos
 * valorados, dirigidos, valorado e dirigido ou normal.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 */
public class ListaArestas implements ITiposDeGrafos {

	// Atributos
	
	/**
	 * Objeto do tipo grafo.
	 */
	private Grafo grafo;
	
	/**
	 * ArrayList de arestas contidas no grafo.
	 */
	private ArrayList<Aresta> arestas;
	
	private ArrayList<Vertice> verticesI;
	private ArrayList<Vertice> verticesF;


	// Construtores
	
	/**
	 * Construtor default.
	 */
	public ListaArestas() {
		this.grafo = new Grafo();
		this.arestas = new ArrayList<Aresta>();
		this.verticesI = new ArrayList<Vertice>();
		this.verticesF = new ArrayList<Vertice>();
	}
	
	/**
	 * Contrutor que recebe um objeto do tipo Grafo por parâmetro.
	 * @param grafo Objeto do tipo Grafo.
	 */
	public ListaArestas(Grafo grafo) {
		this.grafo = grafo;
		this.arestas = montaArrayArestas();
		this.verticesI = new ArrayList<Vertice>();
		this.verticesF = new ArrayList<Vertice>();
	}
	
	
	// Métodos
	
	
	@Override
	public String grafoNormal() {
		montaArrayArestas();
		
		for (int i = 0; i < arestas.size(); i++) {
			verticesI.add(arestas.get(i).getVerticeOrigem());
			verticesF.add(arestas.get(i).getVerticeDestino());
		}
		String result = ".:: LISTA DE ARESTAS ::.\n\nGrafo Normal:\n\n";
		return result.concat(montaResultado());
	}
	
	@Override
	public String grafoDirigido() {
		montaArrayArestas();
		
		for (int i = 0; i < arestas.size(); i++) {
			verticesI.add(arestas.get(i).getVerticeOrigem());
			verticesF.add(arestas.get(i).getVerticeDestino());
		}
		String result = ".:: LISTA DE ARESTAS ::.\n\nGrafo Dirigido:\n\n";
		return result.concat(montaResultado());
	}

	@Override
	public String grafoValorado() {
		montaArrayArestas();
		String pesos = "\tv  =  {";
		
		for (int i = 0; i < arestas.size(); i++) {
			verticesI.add(arestas.get(i).getVerticeOrigem());
			verticesF.add(arestas.get(i).getVerticeDestino());
			pesos += "\t" + arestas.get(i).getPeso();
		}
		pesos += "  }\n";
		String result = ".:: LISTA DE ARESTAS ::.\n\nGrafo Valorado:\n\n";
		return result.concat(montaResultado().concat(pesos));
	}
	
	@Override
	public String grafoDirigidoValorado() {
		montaArrayArestas();
		String pesos = "\tv  =  {";
		
		for (int i = 0; i < arestas.size(); i++) {
			verticesI.add(arestas.get(i).getVerticeOrigem());
			verticesF.add(arestas.get(i).getVerticeDestino());
			pesos += "\t" + arestas.get(i).getPeso();
		}
		pesos += "  }\n";
		String result = ".:: LISTA DE ARESTAS ::.\n\nGrafo Dirigido e Valorado:\n\n";
		return result.concat(montaResultado().concat(pesos));
	}
	
	
	// Métodos privados
	
	
	/**
	 * Monta o resultado da lista de arestas
	 * em uma variável do tipo literal.
	 * @return Resultado em uma literal.
	 */
	private String montaResultado() {
		String result = "\n\ti  =  {";
		
		for (int i = 0; i < verticesI.size(); i++) {
			result += "\t" + verticesI.get(i).getDescricao();
		}
		
		result += "  }\t\n\tf  =  {";
		
		for (int i = 0; i < verticesF.size(); i++) {
			result += "\t" + verticesF.get(i).getDescricao();
		}
		
		result += "  }\t\n";
		
		return result;
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
