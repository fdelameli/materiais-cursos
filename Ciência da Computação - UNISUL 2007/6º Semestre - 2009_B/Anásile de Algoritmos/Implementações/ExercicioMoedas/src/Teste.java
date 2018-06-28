
public class Teste {



	public static void main(String[] args) {

		int valor = 37;
		int moedas[] = { 25, 10, 5, 1 };

		int n = moedas.length;

		for (int i = 0; i < n; i++) {

			if ( valor > moedas[ i ] ) {
				System.out.printf( "Moeda: %d\t-\tqtd: %d\n", moedas[ i ], valor/moedas[i] );
				valor = valor % moedas[ i ];
			}

		}


	}

}
