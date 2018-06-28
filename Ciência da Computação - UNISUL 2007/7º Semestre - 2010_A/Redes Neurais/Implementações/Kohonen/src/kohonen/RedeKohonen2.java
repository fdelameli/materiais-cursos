package kohonen;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Classe que implementa uma rede de Kohonen utilizando estrutura linear.
 * @author Fabio Dela Bruna.
 */
public class RedeKohonen2 {

	/**
	 * Matriz de pesos da rede.
	 */
	private double[][] matrizPesos;

	/**
	 * Representa cada vetor de entrada.
	 */
	private int[] entradas;

	/**
	 * Vetor utlizado para guardar os valores do c�lculo da Dist�ncia Euclidiana.
	 */
	private double[] D;

	/**
	 * Armazena os arquivos de entrada.
	 */
	private File[] arquivos;

	/**
	 * Taxa de aprendizado da rede.
	 */
	private double alpha;

	/**
	 * Define o raio da vizinhan�a.
	 */
	private int raio;

	/**
	 * Define a quantidade de bits que ser�o lidos de cada arquivo de entrada.
	 * Ou seja, � o tamanho de cada vetor de entrada.
	 */
	private final int QTD_BITS = 63;

	/**
	 * Define a quantidade de clusters.
	 */
	private final int QTD_CLUSTERS = 25;
	
	/**
	 * Define a quantidade de �pocas.
	 */
	private final int QTD_EPOCAS = 500;





	/**
	 * Construtor da classe que inicializa os dados necess�rios.
	 */
	public RedeKohonen2() {
		arquivos = new File( "arquivos/treinamento" ).listFiles(); // pega os arquivos de entrada.

		matrizPesos = new double[ QTD_BITS ][ QTD_CLUSTERS ]; // seta tamanho da matriz de pesos.
		inicializaMatrizPesos();

		raio = 1; // seta valor do raio da vizinha�a.
		alpha = 0.6; // seta valor da taxa de aprendizado.
	}


	
	/**
	 * Inicializa o treinamento da rede.
	 */
	public void treinaRede() throws IOException {

		// condi��o de parada: ser� executada 200 �pocas.
		for (int epoca = 0; epoca < QTD_EPOCAS; epoca++) {

			// para cada vetor de treinamento fa�a...
			for ( int count = 0; count < arquivos.length; count++ ) {

				entradas = leArquivo( arquivos[ count ] );
				D = new double[ QTD_CLUSTERS ]; // zera o vetor.

				for (int j = 0; j < QTD_CLUSTERS; j++) {

					for ( int i = 0; i < entradas.length; i++ ) { // calcula a dist�ncia euclidiana para cada j.
						D[ j ] += Math.pow( ( entradas[i] - matrizPesos[i][j] ) , 2 );
					}
				}
				
				int indiceMin = encontraIndiceMin( D ); // encontra o cluster vencedor (winner-takes-all)
				atualizaPesos( indiceMin ); // atualiza pesos
				
			}
		}
	}
	
	
	/**
	 * Efetua o teste da rede, recebendo por par�metro um vetor de arquivos de teste.
	 */
	public String testaRede( File[] files ) throws IOException {
		
		String[] arquivosPorCluster = new String[ QTD_CLUSTERS ];
		for (int i = 0; i < arquivosPorCluster.length; i++) {
			arquivosPorCluster[ i ] = "";
		}
		
		String resultadoDoTeste = "..: RESULTADO DO TESTE :..\n\n";
		
		// AQUI COME�A O TESTE...
		
		// para cada arquivo de teste...
		for ( int count = 0; count < files.length; count++ ) {

			entradas = leArquivo( files[ count ] ); // l� cada bit do arquivo de teste.
			D = new double[ QTD_CLUSTERS ]; // zera o vetor.

			// para cada cluster...
			for (int j = 0; j < QTD_CLUSTERS; j++) {

				// para cada bit do arquivo de teste...
				for ( int i = 0; i < entradas.length; i++ ) { 
					
					// calcula a dist�ncia euclidiana para cada j.
					D[ j ] += Math.pow( ( entradas[i] - matrizPesos[i][j] ) , 2 );
				
				}
			}
			int indiceMin = encontraIndiceMin( D ); // encontra o cluster vencedor (winner-takes-all)
			// AQUI TERMINA O TESTE...
			
			arquivosPorCluster[ indiceMin ] += files[count].getName() + "   "; // adiciona o arquivo ao cluster vencedor.
		}
		
		// termina de formular um resultado para ser impresso na tela
		for ( int i = 0; i < arquivosPorCluster.length; i++ ) {
			if ( arquivosPorCluster[ i ].equals("") )
				resultadoDoTeste += "CLUSTER " + i + ":   NENHUM ARQUIVO\n";
			else
				resultadoDoTeste += "CLUSTER " + i + ":   " + arquivosPorCluster[ i ] + "\n";
		}
		return resultadoDoTeste;
	}


	/**
	 * Inicializa a matriz de pesos com valores entre 0 e 1.
	 */
	private void inicializaMatrizPesos() {
		Random r = new Random();

		for ( int i = 0; i < matrizPesos.length; i++ ) {
			for ( int j = 0; j < matrizPesos[0].length; j++ ) {
				matrizPesos[ i ][ j ] = r.nextDouble();
			}
		}


	}


	/**
	 * Atualiza os pesos ma matriz de para o cluster vencedor e seus vizinhos.
	 * @param j �ndice da coluna.
	 */
	private void atualizaPesos( int j ) {
		for ( int i = 0; i < QTD_BITS; i++ ) {
			if ( j == 0 ) {
				matrizPesos[ i ][ j ] = matrizPesos[ i ][ j ] + alpha * ( entradas[ i ] - matrizPesos[ i ][ j ] );
				matrizPesos[ i ][ j+raio ] = matrizPesos[ i ][ j+raio ] + alpha * ( entradas[ i ] - matrizPesos[ i ][ j+raio ] );
			} else if ( j == QTD_CLUSTERS-1) {
				matrizPesos[ i ][ j-raio ] = matrizPesos[ i ][ j-raio ] + alpha * ( entradas[ i ] - matrizPesos[ i ][ j-raio ] );
				matrizPesos[ i ][ j ] = matrizPesos[ i ][ j ] + alpha * ( entradas[ i ] - matrizPesos[ i ][ j ] );
			} else {
				matrizPesos[ i ][ j-raio ] = matrizPesos[ i ][ j-raio ] + alpha * ( entradas[ i ] - matrizPesos[ i ][ j-raio ] );
				matrizPesos[ i ][ j ] = matrizPesos[ i ][ j ] + alpha * ( entradas[ i ] - matrizPesos[ i ][ j ] );
				matrizPesos[ i ][ j+raio ] = matrizPesos[ i ][ j+raio ] + alpha * ( entradas[ i ] - matrizPesos[ i ][ j+raio ] );
			}
		}
	}


	/**
	 * Procura pelo �ndice do menor valor num vetor.
	 * Retorna o �ndice do menor elemento encontrado.
	 */
	private int encontraIndiceMin( double[] vetor ) {
		double min = vetor[ 0 ];
		int indice = 0;
		for ( int i = 1; i < vetor.length; i++ ) {
			if ( vetor[ i ] < min ) {
				min = vetor[ i ];
				indice = i;
			}
		}
		return indice;
	}


	/**
	 * L� o conte�do de um determinado arquivo, utilizando a classe java.io.FileReader.
	 * Retorna uma matriz de inteiros contendo os dados lidos do arquivo.
	 * @param arquivo Arquivo a ser lido.
	 * @param qtd Quantidade de bits que ser�o lidos de um arquivo.
	 */
	private int[] leArquivo( File arquivo ) throws IOException {
		FileReader reader = null;
		int[] retorno = new int[ QTD_BITS ];
		int count = 0;
		char c;

		reader = new FileReader( arquivo ); // cria FileReader passando o arquivo por par�metro

		while ( count != QTD_BITS ) {

			c = ( char )reader.read();

			if ( c == '\n' || c == '\r' ) { // ignora caracter de nova linha e retorno
				// n�o faz nada;
			} else {

				if ( c == '.' ) {			// se for ponto
					retorno[ count] = -1;		// ent�o atribui -1
				} else if ( c == '#' ) {	// se for cerquilha
					retorno[ count] = 1;		// ent�o atribui 1
				} else {					// sen�o...
					retorno[ count] = 0;			// atribui 0
				}
				count++;
			}
		}
		reader.close(); // fecha o arquivo

		return retorno;
	}


	/**
	 * Retorna a matriz de pesos.
	 */
	public double[][] getMatrizPesos() {
		return this.matrizPesos;
	}


}
