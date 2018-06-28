
public class Main {	
	public static void main(String[] args) {		
		Grafo grafo = new Grafo();
		
		// L� o total de vértices do grafo
		Integer totalVertices = IO.LerInteiro();
		Integer totalArestas = IO.LerInteiro();
		
		Integer numTestes = 1;
		
		while ((totalVertices != 0) && (totalArestas != 0)){
			grafo.LimparVertices();
			
			// Cria vértices
			Vertice[] vertices = new Vertice[totalVertices];
			for (int i = 0; i < totalVertices; i++)
				vertices[i] = new Vertice(i + 1);
			
			// Cria arestas
			for (int i = 0; i < totalArestas; i++){
				// Parametros
				Vertice verticeOrigem = vertices[IO.LerInteiro() - 1], verticeDestino = vertices[IO.LerInteiro() - 1];
				Integer peso = IO.LerInteiro();
				
				grafo.AdicionaAresta(verticeOrigem, verticeDestino, peso);
			}			
			
			IO.ImprimirLinha("Teste " + numTestes++);
			// Executa o algoritmo e imprime resultados
			grafo.GrafoMinimo();
			
			IO.ImprimirLinha();
			
			totalVertices = IO.LerInteiro();
			totalArestas = IO.LerInteiro();
		}
	}
}
