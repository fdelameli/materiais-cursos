package mlp.util;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;


public class FileIO {


	/**
	 * Método utilizado para gravar os pesos das matrizes em arquivos.
	 * @param fileV Arquivo onde será gravado os pesos da matriz V.
	 * @param fileW Arquivos onde será gravado os pesos da matriz W.
	 * @param v Matriz de pesos V.
	 * @param w Matriz de pesos W.
	 * @param I Quantidade de neurônios da camada de entrada.
	 * @param J Quantidade de neurônios da camada intermediária.
	 * @param K Quantidade de neurônios da camada de saída.
	 */
	public static void gravaPesos( String fileV, String fileW, double[][] v, double[][] w, int I, int J, int K ) {
		try {
			PrintWriter pw = new PrintWriter( new FileWriter( new File( fileV ) ) );
			for ( int i = 0; i < I; i++ ) {
				for ( int j = 0; j < J; j++ ) {
					pw.print( " " + v[ i ][ j ] );
				}
				pw.print( "\n" );
				pw.flush();
			}
			pw.close();
			pw = new PrintWriter( new FileWriter( new File( fileW ) ) );
			for ( int j = 0; j < J; j++ ) {
				for ( int k = 0; k < K; k++ ) {
					pw.print( " " + w[ j ][ k ] );
				}
				pw.print( "\n" );
				pw.flush();
			}
			pw.close();
		} catch ( IOException ioe ) {
			System.out.println( "Erro: " + ioe );
			ioe.printStackTrace();
		}
	}


	/**
	 * Método utilizado para ler os pesos das matrizes que estão gravados em arquivos.
	 * @param fileV Arquivo onde será gravado os pesos da matriz V.
	 * @param fileW Arquivos onde será gravado os pesos da matriz W.
	 * @param v Matriz de pesos V.
	 * @param w Matriz de pesos W.
	 * @param I Quantidade de neurônios da camada de entrada.
	 * @param J Quantidade de neurônios da camada intermediária.
	 * @param K Quantidade de neurônios da camada de saída.
	 */
	public static void readWeights( String fileV, String fileW, double[][] v, double[][] w, int I, int J, int K ) {
		try {
			BufferedReader br = new BufferedReader( new FileReader( new File( fileV ) ) );
			StringTokenizer tokens;
			for ( int i = 0; i < I; i++ ) {
				tokens = new StringTokenizer( br.readLine() );
				for ( int j = 0; j < J; j++ ) {
					v[ i ][ j ] = Double.parseDouble( tokens.nextToken() );
				}
			}
			br.close();
			br = new BufferedReader( new FileReader( new File( fileW ) ) );
			for ( int j = 0; j < J; j++ ) {
				tokens = new StringTokenizer( br.readLine() );
				for ( int k = 0; k < K; k++ ) {
					w[ j ][ k ] = Double.parseDouble( tokens.nextToken() );
				}
			}
			br.close();
		} catch ( IOException ioe ) {
			System.out.println( "Erro: " + ioe );
			ioe.printStackTrace();
		}
	}

	/**
	 * Grava o log em um arquivo txt.
	 * @param log Log a ser gravado no arquivo.
	 */
	public static void writeLog( String log ) {
		try {
			File file = new File( "log.txt" );
			if ( !file.exists() ) {
				file.createNewFile();
				System.out.println( "Arquivo nao existe!" );
			}
			PrintWriter pw = new PrintWriter( file );
			pw.write( log );
			pw.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}


	/**
	 * Transforma os pixel de uma imagem em preto e branco em uma
	 * combinação binária, para ser usada no treinamento.
	 * @param file Imagem a ser lida.
	 * @return Vetor binário da imagem.
	 * @throws IOException Poderá dispara uma exceção ao ler o arquivo.
	 */
	public static double[] getPixels( File file ) throws IOException {
		BufferedImage image = ImageIO.read( file );
		double[] retorno = new double[ image.getWidth() * image.getHeight() ];

		int width = image.getWidth();
		int height = image.getHeight();
		int nbands = image.getSampleModel().getNumBands();

		Raster inputRaster = image.getData();
		int[] pixels = new int[ nbands * width * height ];
		inputRaster.getPixels( 0, 0, width, height, pixels );

		int count = 0;
		for ( int h = 0; h < height; h++ ) {
			for ( int w = 0; w < width; w++ ) {
				int rgb = image.getRGB( w, h );
				int r = ( int ) ( ( rgb & 0x00FF0000 ) >>> 16 ); // Red level
				int g = ( int ) ( ( rgb & 0x0000FF00 ) >>> 8 ); // Green level
				int b = ( int ) ( rgb & 0x000000FF ); // Blue level

				// ser o pixel for da cor branca...
				if ( r == 255 && g == 255 && b == 255 )
					retorno[ count ] = 0;
				else
					// senão...
					retorno[ count ] = 1;

				count++;
			}
		}
		return retorno;
	}


	/**
	 * Lê o conteúdo de um determinado arquivo, utilizando a classe java.io.FileReader.
	 * @param arquivo Arquivo a ser lido.
	 */
	public static void leArquivoTxt( File arquivo, int qtdNeur, double[] X ) throws IOException {
		FileReader reader = null;
		int count = 0;
		char c;

		reader = new FileReader( arquivo ); // cria FileReader passando o arquivo por parâmetro

		while ( count != qtdNeur ) {

			c = ( char ) reader.read();

			if ( c == '\n' || c == '\r' ) { // ignora caracter de retorno e nova linha
				// não faz nada;
			} else {

				if ( c == '.' ) { // se for ponto
					X[ count ] = 0; // então atribui -1
					count++;
				} else if ( c == '#' ) { // se for cerquilha
					X[ count ] = 1; // então atribui 1
					count++;
				}

			}
		}
		reader.close(); // fecha o arquivo
	}


}
