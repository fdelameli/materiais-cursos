package kohonen;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Classe que implementa uma rede de Kohonen sem estrutura topológica.
 * @author Fabio Dela Bruna.
 */
public class RedeKohonen1 {

	/**
	 * Matriz de pesos da rede.
	 */
	private double[][] matrizPesos;

	/**
	 * Representa cada vetor de entrada.
	 */
	private int[] entradas;

	/**
	 * Vetor utlizado para guardar os valores do cálculo da Distância Euclidiana.
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
	 * Define a quantidade de bits que serão lidos de cada arquivo de entrada.
	 * Ou seja, é o tamanho de cada vetor de entrada.
	 */
	private final int QTD_BITS = 63;

	/**
	 * Define a quantidade de clusters.
	 */
	private final int QTD_CLUSTERS = 25;
	
	/**
	 * Define a quantidade de épocas.
	 */
	private final int QTD_EPOCAS = 200;





	/**
	 * Construtor da classe que inicializa os dados necessários,
	 * como carregamento dos arquivos de treinamento, inicialização
	 * da matriz de pesos e atribuição de valor inicial para alpha.
	 */
	public RedeKohonen1() {
		// pega os arquivos de entrada.
		arquivos = new File( "arquivos/treinamento" ).listFiles(); 

		// inicializa matriz de pesos.
		matrizPesos = new double[ QTD_BITS ][ QTD_CLUSTERS ]; 
		randomValuesMatrizPesos(); // seta valores aleatórios.

		alpha = 0.6; // seta valor da taxa de aprendizado.
	}


	
	/**
	 * Inicializa o treinamento da rede.
	 */
	public void treinaRede() throws IOException {

		// condição de parada: será executada 200 épocas.
		for (int epoca = 0; epoca < QTD_EPOCAS; epoca++) {

			// para cada vetor de treinamento faça...
			for ( int count = 0; count < arquivos.length; count++ ) {

				entradas = leArquivo( arquivos[ count ] ); // lê cada bit do arquivo de treinamento.
				D = new double[ QTD_CLUSTERS ]; // zera o vetor.

				// para cada cluster...
				for (int j = 0; j < QTD_CLUSTERS; j++) {

					// para cada bit do arquivo de entrada...
					for ( int i = 0; i < entradas.length; i++ ) {
						
						// calcula a distância euclidiana para cada j.
						D[ j ] += Math.pow( ( entradas[i] - matrizPesos[i][j] ) , 2 );
					
					}
				}
				int indiceMin = encontraIndiceMin( D ); // encontra o cluster vencedor (winner-takes-all).
				atualizaPesos( indiceMin ); // atualiza pesos.
			}
		}
	}
	
	
	/**
	 * Efetua o teste da rede, recebendo por parâmetro um vetor de arquivos de teste.
	 */
	public String testaRede( File[] files ) throws IOException {
		
		String[] arquivosPorCluster = new String[ QTD_CLUSTERS ];
		for (int i = 0; i < arquivosPorCluster.length; i++) {
			arquivosPorCluster[ i ] = "";
		}
		
		String resultadoDoTeste = "..: RESULTADO DO TESTE :..\n\n";
		
		// AQUI COMEÇA O TESTE...
		
		// para cada arquivo de teste...
		for ( int count = 0; count < files.length; count++ ) {

			entradas = leArquivo( files[ count ] ); // lê cada bit do arquivo de teste.
			D = new double[ QTD_CLUSTERS ]; // zera o vetor.

			// para cada cluster...
			for (int j = 0; j < QTD_CLUSTERS; j++) {

				// para cada bit do arquivo de teste...
				for ( int i = 0; i < entradas.length; i++ ) { 
					
					// calcula a distância euclidiana para cada j.
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
	 * Seta valores aleatório entre 0 e 1 para cada posição da matriz.
	 */
	private void randomValuesMatrizPesos() {
		Random r = new Random();
		for ( int i = 0; i < matrizPesos.length; i++ ) {
			for ( int j = 0; j < matrizPesos[0].length; j++ ) {
				matrizPesos[ i ][ j ] = r.nextDouble();
			}
		}
	}


	/**
	 * Atualiza os pesos ma matriz de pesos.
	 * @param j Índice da coluna a ser atualizada.
	 */
	private void atualizaPesos( int j ) {
		for ( int i = 0; i < QTD_BITS; i++ ) {
			matrizPesos[ i ][ j ] = matrizPesos[ i ][ j ] + alpha * ( entradas[ i ] - matrizPesos[ i ][ j ] );
		}
	}


	/**
	 * Procura pelo índice do menor valor num vetor.
	 * Retorna o índice do menor elemento encontrado.
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
	 * Lê o conteúdo de um determinado arquivo, utilizando a classe java.io.FileReader.
	 * Retorna uma matriz de inteiros contendo os dados lidos do arquivo.
	 * @param arquivo Arquivo a ser lido.
	 * @param qtd Quantidade de bits que serão lidos de um arquivo.
	 */
	private int[] leArquivo( File arquivo ) throws IOException {
		FileReader reader = null;
		int[] retorno = new int[ QTD_BITS ];
		int count = 0;
		char c;

		reader = new FileReader( arquivo ); // cria FileReader passando o arquivo por parâmetro

		while ( count != QTD_BITS ) {

			c = ( char )reader.read();

			if ( c == '\n' || c == '\r' ) { // ignora caracter de nova linha e retorno
				; // não faz nada;
			} else {

				if ( c == '.' ) {			// se for ponto
					retorno[ count] = -1;		// então atribui -1
				} else if ( c == '#' ) {	// se for cerquilha
					retorno[ count] = 1;		// então atribui 1
				} else {					// senão...
					retorno[ count] = 0;		// atribui 0
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
