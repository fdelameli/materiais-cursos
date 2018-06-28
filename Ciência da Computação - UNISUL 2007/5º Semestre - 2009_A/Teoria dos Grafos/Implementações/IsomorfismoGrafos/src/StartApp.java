
//
// Application Startup entry point
//
public class StartApp {

	public static void main(String[] args) {

		// Matriz de adjacência do grafo A.
		int[][] matrizA = {{0,1,1,0,0},
				           {1,0,1,0,1},
				           {1,1,0,1,1},
				           {0,0,1,0,1},
				           {0,1,1,1,0}};

		// Matriz de adjacência do grafo B.
		int[][] matrizB = {{0,1,1,0,1},
				           {1,0,0,0,1},
				           {1,0,0,1,1},
				           {0,0,1,0,1},
				           {1,1,1,1,0}};
		
		// Matriz de adjacência do grafo A.
		int[][] matrizC = {{0,1,1,0,0},
				           {1,0,1,0,1},
				           {1,0,0,1,0},
				           {1,1,1,0,1},
				           {0,1,0,1,0}};

		// Matriz de adjacência do grafo B.
		int[][] matrizD = {{0,1,0,1,0},
				           {1,0,1,1,1},
				           {0,1,0,0,1},
				           {1,1,0,0,1},
				           {0,1,1,1,0}};

		// Compara o grafo A com B
		IsomorphAnalysis analysis1 = new IsomorphAnalysis(matrizA, matrizB);
		System.out.println("Matriz A com Matriz B " + (analysis1.getResult()?"são": "não são") + " isomórfos");
		
		System.out.println();
		
		
		// Compara o grafo A com C
		IsomorphAnalysis analysis2 = new IsomorphAnalysis(matrizA, matrizC);
		System.out.println("Matriz A com Matriz C " + (analysis2.getResult()?"são": "não são") + " isomórfos");
		
		System.out.println();
		

		// Compara o grafo A com D
		IsomorphAnalysis analysis3 = new IsomorphAnalysis(matrizA, matrizD);
		System.out.println("Matriz A com Matriz D " + (analysis3.getResult()?"são": "não são") + " isomórfos");
		
		System.out.println();
		

		// Compara o grafo B com C
		IsomorphAnalysis analysis4 = new IsomorphAnalysis(matrizB, matrizC);
		System.out.println("Matriz B com Matriz C " + (analysis4.getResult()?"são": "não são") + " isomórfos");
		
		System.out.println();
		
		// Compara o grafo B com D
		IsomorphAnalysis analysis5 = new IsomorphAnalysis(matrizB, matrizD);
		System.out.println("Matriz B com Matriz D " + (analysis5.getResult()?"são": "não são") + " isomórfos");
		
		System.out.println();
		
		
		// Compara o grafo C com D
		IsomorphAnalysis analysis6 = new IsomorphAnalysis(matrizC, matrizD);
		System.out.println("Matriz C com Matriz D " + (analysis6.getResult()?"são": "não são") + " isomórfos");
		
		System.out.println();
	
		
	}
}
