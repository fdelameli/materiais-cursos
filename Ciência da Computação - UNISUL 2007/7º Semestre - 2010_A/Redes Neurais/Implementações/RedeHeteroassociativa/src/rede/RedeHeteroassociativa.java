package rede;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Classe que representa uma rede heteroassociativa para reconhecimento de caracteres.
 * @author Fabio Dela Bruna.
 */
public class RedeHeteroassociativa {


	// Declaração de variáveis.

	/**
	 * Matriz de pesos.
	 */
	private int[][] matrizPesos;

	/**
	 * Representa uma matriz de entrada.
	 */
	private int[][] S;

	/**
	 * Representa uma matriz de saída.
	 */
	private int[][] T;

	/**
	 * Representa os arquivos de entrada.
	 */
	private File[] entradas;

	/**
	 * Representa os arquivos de saída.
	 */
	private File[] saidas;

	// Fim da declaração de variáveis.


	/**
	 * Construtor da classe.
	 * Inicializa matriz de pesos, seu tamanho é calculado de acordo
	 * com as matrizes de entradas e saídas.
	 */
	public RedeHeteroassociativa() {
		entradas = new File( "arquivos/treinamento/entradas" ).listFiles(); // pega os arquivos de entrada.
		saidas = new File( "arquivos/treinamento/saidas" ).listFiles(); //pega os arquivos de saida.
		matrizPesos = new int[ 63 ][ 15 ]; // inicializa a matriz de pesos (63x15)
		
		// preenche as posições da matriz de pesos com 0(zero).
		for ( int i = 0; i < matrizPesos.length; i++ ) {
			for ( int j = 0; j < matrizPesos[i].length; j++ ) {
				matrizPesos[ i ][ j ] = 0;
			}
		}
		
	}


	/**
	 * Treina a rede.
	 */
	public void treinarRede() throws IOException {
		
		int[][] matrizAux = null;
		
		for ( int i = 0; i < Constants.QTD_ARQUIVOS; i++ ) {

			S = leArquivo( entradas[ i ], Constants.QTD_BITS_ENTRADA );
			T = leArquivo( saidas[ i ], Constants.QTD_BITS_SAIDA );
					
			S = matrizTransposta( S );
			matrizAux = multiplicaMatriz( S, T );
			matrizPesos = somaMatriz( matrizPesos, matrizAux );

		}

	}
	

	/**
	 * Testa se a rede está reconhecendo os caracteres de saída de acordo
	 * com o caracter de entrada passado por parâmetro pelo usuário.
	 * @param arquivo Arquivo de entrada informado pelo usuário.
	 */
	public int[][] testarRede( File arquivo ) throws IOException {
		int[][] matrizAux = null;
		
		S = leArquivo( arquivo, Constants.QTD_BITS_ENTRADA ); // lê o arquivo informado pelo usuário.
		matrizAux = multiplicaMatriz( S, matrizPesos ); // multiplia a matriz do arquivo com a matriz de pesos.
		
		funcaoAtivacao( matrizAux ); // aplica a função de ativação na matriz.
		
		return matrizAux;
	}
	
	/**
	 * Aplica a função de ativação.
	 * Se > 0 então = 1.
	 * Senão = -1;
	 * @param matriz Matriz a qual será aplicada a função de ativação.
	 */
	private int[][] funcaoAtivacao( int[][] matriz ) {
		
		for ( int i = 0; i < matriz.length; i++ ) {
			for ( int j = 0; j < matriz[ i ].length; j++ ) {
				
				if ( matriz[ i ][ j] > 0 ) {
					matriz[ i ] [ j ] = 1;
				} else {
					matriz[ i ] [ j ] = -1;
				}
				
			}
		}
		return matriz;
	}


	/**
	 * Lê o conteúdo de um determinado arquivo, utilizando a classe java.io.FileReader.
	 * Retorna uma matriz de inteiros contendo os dados lidos do arquivo.
	 * @param arquivo Arquivo a ser lido.
	 * @param qtd Quantidade de bits que serão lidos de um arquivo.
	 */
	private int[][] leArquivo( File arquivo, int qtd ) throws IOException {
		Vector<Integer> matriz = new Vector<Integer>();
		FileReader reader = null;
		int[][] retorno = null;
		int count = 0;
		char c;

		reader = new FileReader( arquivo ); // cria FileReader passando o arquivo por parâmetro

		while ( count != qtd ) {

			c = ( char )reader.read();

			if ( c == '\n' || c == '\r' ) { // ignora caracter de nova linha e retorno
				// não faz nada;
			} else {

				if ( c == '.' ) {			// se for ponto
					matriz.add( -1 );			// então atribui -1
				} else if ( c == '#' ) {	// se for cerquilha
					matriz.add( 1 );			// então atribui 1
				} else {					// senão...
					matriz.add( 0 );			// atribui 0
				}
				count++;
			}
		}
		reader.close(); // fecha o arquivo
		retorno = new int[ 1 ][ matriz.size() ];

		for (int i = 0; i < matriz.size(); i++) {
			retorno[ 0 ][ i ] = matriz.get( i );
		}
		
		return retorno;
	}


	/**
	 * Faz a multiplicação entre duas matrizes, A e B.
	 * Considera-se que as matrizes sejam compatíveis.
	 * Retorna o o produto dessa multiplicação.
	 */
	private int[][] multiplicaMatriz( int matrizA[][], int matrizB[][] ) {
		int matrizResultante[][] = new int[ matrizA.length ][ matrizB[0].length ];
		int count;

		for ( int linhaA = 0; linhaA < matrizA.length; linhaA++ ) {
			for ( int colunaB = 0; colunaB < matrizB[0].length; colunaB++ ) {
				count = 0;
				for ( int soma = 0; soma < matrizB.length; soma++ ) {
					count = count + matrizA[ linhaA ][ soma ] * matrizB[ soma ][ colunaB ];
				}
				matrizResultante[ linhaA ][ colunaB ] = count;
			}
		}
		return matrizResultante;
	}
	
	
	/**
	 * Faz a soma entre duas matrizes, A e B.
	 * Considera-se que as matrizes sejam compatíveis.
	 */
	private int[][] somaMatriz( int matrizA[][], int matrizB[][] ) {
		int matrizResultante[][] = new int[ matrizA.length ][ matrizA[0].length ];
		
		for ( int i = 0; i < matrizResultante.length; i++ ) {
			for ( int j = 0; j < matrizResultante[i].length; j++ ) {
				matrizResultante[ i ][ j ] = matrizA[ i ][ j ] + matrizB[ i ][ j ];
			}
		}
		return matrizResultante;
	}

	
	/**
	 * Efetua a operação de matriz transposta sobre uma determinada matriz passada por parâmetro.
	 * @param matriz Matriz a ser manipulada.
	 */
	private int[][] matrizTransposta( int matriz[][] ) {
		int transposta[][] = new int[ matriz[0].length ][ matriz.length ];

		for ( int i = 0; i < matriz.length; i++ ) {
			for ( int j = 0; j < matriz[0].length; j++ ) {
				transposta[ j ][ i ] = matriz[ i ][ j ];
			}
		}
		return transposta;
	}
	
	
	/**
	 * Retorna a matriz de Pesos.
	 */
	public int[][] getMatrizPesos() {
		return matrizPesos;
	}



}
