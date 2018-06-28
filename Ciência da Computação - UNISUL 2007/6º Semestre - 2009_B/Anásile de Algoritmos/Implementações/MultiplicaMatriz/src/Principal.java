
public class Principal {

	public static void main(String[] args) {

		int matrizA[][] = {{1, 2, 3},
	           			   {4, 5, 6}};
		
		int matrizB[][] = {{1, 2},
				           {3, 4},
				           {5, 6}};
		
		int matrizResultante[][] = new int[matrizA.length][matrizB[0].length];
		int count;
		
		
		for (int linhaA = 0; linhaA < matrizA.length; linhaA++) {
			
			for (int colunaB = 0; colunaB < matrizB[0].length; colunaB++) {

				count = 0;
				
				for (int soma = 0; soma < matrizB.length; soma++) {
					
					count = count + matrizA[linhaA][soma] * matrizB[soma][colunaB];
					
				}
				
				matrizResultante[linhaA][colunaB] = count;
				System.out.print(matrizResultante[linhaA][colunaB] + "\t");
				
			}
			
			System.out.println();
		
		}
		
	}






}
