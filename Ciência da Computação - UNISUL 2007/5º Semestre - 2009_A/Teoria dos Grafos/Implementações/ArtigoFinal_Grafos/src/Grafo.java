import java.util.ArrayList;
/**
 * Classe que representa um Grafo em um contexto.
 * @author Lucas Nunes, Jakson Gonçalves.
 * @since 06/04/2009.
 */
public class Grafo {

	private ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	private ArrayList<Aresta> arestas = new ArrayList<Aresta>();
	public double[][] matrizTemp;
	
	/**
	 * Insere vértices na ArrayList de vértices.
	 * @param v
	 */
	public void inserirVertice(Vertice v) {
		vertices.add(v);
	}

	/**
	 * Insere arestas na ArrayList de arestas.
	 * @param a
	 */
	public void inserirArestas(Aresta a) {
		arestas.add(a);
	}

	/**
	 * Mostra a lista de arestas de um grafo G.
	 */
	public void mostrarListaArestas() {
		String origem = "";
		String destino = "";
		String valor = "";
		for (int i = 0; i < arestas.size(); i++) {
			origem = origem + arestas.get(i).getVerticeA().toString() + "    ";
			destino = destino + arestas.get(i).getVerticeB().toString() + "    ";
			valor = valor + arestas.get(i).getValor() + "  ";
		}
		System.out.println("I: {" + origem + " }");
		System.out.println("F: {" + destino + " }");
		if(valor != "")
			System.out.println("V: {" + valor + " }");
	}

	/**
	 * Mostra a lista de adjacência de um grafo G.
	 */
	public void mostrarListaAdjacencia(Vertice v) {
		String inicio = "";
		for (int i = 0; i <= vertices.size(); i++) {
			if (v.toString().equals(arestas.get(i).getVerticeA().toString())) 
				inicio = inicio + " -> " + arestas.get(i).getVerticeB().toString();
			if (v.toString().equals(arestas.get(i).getVerticeB().toString())) 
				inicio = inicio + " -> " + arestas.get(i).getVerticeA().toString();
		}
		System.out.println("Início: " + v.toString() + inicio);
	}

	/**
	 * Mostra a matriz de adjacência de um grafo G.
	 */
	public void mostrarMatrizAdjacencia() {
		double[][] matriz = new double [vertices.size()][vertices.size()];
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				boolean achou = false;
				for (int k = 0; k < arestas.size(); k++) {
					if ((arestas.get(k).getVerticeA().equals(vertices.get(i))
						&& arestas.get(k).getVerticeB().equals(vertices.get(j))) ||
						(arestas.get(k).getVerticeA().equals(vertices.get(j))
						&& arestas.get(k).getVerticeB().equals(vertices.get(i)))) {
						achou = true;
						break;
					}
				}
				if (achou) {
					matriz[j][i] = arestas.get(j).getValor();
//					matriz[j][i] = 1;
				}else{ 
					matriz[j][i] = 0;
				}
			}
		}
		matrizTemp = new double[matriz.length][matriz.length];
		matrizTemp = matriz;
		// MOSTRANDO A MATRIZ...
		String temp = "@";
		for (int i = 0; i < vertices.size(); i++){
			temp += " " + vertices.get(i).toString() + "   ";
		}
		System.out.println(temp);
		for (int i = 0; i < matriz.length; i++) {
			temp = vertices.get(i).toString();
			for (int j = 0; j < matriz.length; j++) {
				temp = temp + " " + matriz[j][i] + " ";
			}
			System.out.println(temp);
		}
	}
	/**
	 * Mostra a matriz de incidência de um grafo G.
	 */
	public void mostrarMatrizIncidencia() {
		double[][] matriz = new double [arestas.size()][vertices.size()];
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < arestas.size(); j++) {
				if (arestas.get(j).getVerticeA().equals(vertices.get(i)) ||
						arestas.get(j).getVerticeB().equals(vertices.get(i))) {
//					matriz[j][i] = 1;
					matriz[j][i] = arestas.get(j).getValor();
				} else {
					matriz[j][i] = 0;
				}
			}
		}
		// MOSTRANDO A MATRIZ...
		String temp = "@";
		for (int i = 0; i < arestas.size(); i++){
			temp += " " + arestas.get(i).getRotulo() + "   ";
		}
		System.out.println(temp);
		for (int i = 0; i < matriz[0].length; i++) {
			temp = vertices.get(i).toString();
			for (int j = 0; j < matriz.length; j++) {
				temp = temp + " " + matriz[j][i] + "  ";
			}
			System.out.println(temp);
		}
	}
	
	/**
	 * Método que mostra o complemento para um grafo G.
	 */
	public void complementarMatriz() {
		for (int i = 0; i < matrizTemp.length; i++) {
			for (int j = 0; j < matrizTemp.length; j++) {
				if (matrizTemp[j][i] == 1)
					matrizTemp[j][i] = 0;
				else
					matrizTemp[j][i] = 1;
			}
		}
		// MOSTRANDO A MATRIZ...
		String temp = "@";
		for (int i = 0; i < vertices.size(); i++){
			temp += " " + vertices.get(i).toString() + " ";
		}
		System.out.println(temp);
		for (int i = 0; i < matrizTemp.length; i++) {
			temp = vertices.get(i).toString();
			for (int j = 0; j < matrizTemp.length; j++) {
				temp = temp + " " + matrizTemp[j][i] + " ";
			}
			System.out.println(temp);
		}
	}
}