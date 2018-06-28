package mlp.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Classe utilizada para limpar bordas brancas nas imagens
 * 
 */
public class AjustaImg {


	// le imagem retorna uma matrix binaria 0,1
	public int[][] lerEntrada( String nomeArquivo ) throws IOException {

		// Carrega a imagem em imagem e atribui o tamanho da imagem as vari√°veis a e l
		BufferedImage imagem = ImageIO.read( new File( nomeArquivo ) );

		int a = imagem.getWidth();
		int l = imagem.getHeight();

		// cria uma matriz com o tamanho da image
		int img[][] = new int[ l ][ a ];

		// inicia a variavel cor

		int cor = 0;

		// gravando imagem em matriz
		for ( int col = 0; col < a; col++ ) {
			for ( int lin = 0; lin < l; lin++ ) {

				int pixel = imagem.getRGB( col, lin );

				// seta valores onde 1=branco e 0=preto
				if ( pixel < -1 ) {
					cor = 1;
				}

				else {
					cor = 0;
				}

				// atribui os valores a matriz
				img[ lin ][ col ] = cor;
			}
		}
		
		for ( int i = 0; i < img.length; i++ ) {
			for ( int j = 0; j < img[i].length; j++ ) {
				System.out.printf("%d ", img[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Linhas: " + img.length);
		System.out.println("Colunas: " + img[0].length);
		
		return img;
	}


	// metodo utilizado para verificar se existe contorno branco em volta da imagem
	public int AjustaImagem( int img[][] ) {

		int soma = 0;
		int lin = 0;
		int col = 0;
		int diminui = 1;

		while ( soma == 0 ) {

			// verifica as colunas
			for ( int l = lin; l <= ( img.length - diminui ); l++ ) {
				soma += img[ l ][ lin ] + img[ l ][ ( img.length - 1 ) ];
			}

			// verifica as linhas
			for ( int c = col; c <= ( img[ 0 ].length - diminui ); c++ ) {
				soma += img[ col ][ c ] + img[ ( img.length - diminui ) ][ c ];
			}

			lin += 1;
			col += 1;
			diminui += 1;
		}
		lin = lin - 1;

		return lin;
	}

	// limpa borda vazia da imagem e altera o ajusta ao tamanho anterior
	public void AjusteFinal( int valor, String nomeArquivo ) throws IOException {

		if ( valor > 0 ) {
			BufferedImage imagem = ImageIO.read( new File( nomeArquivo ) );
			int a = imagem.getWidth();
			int l = imagem.getHeight();


			// ajusta a area de corte
			int inicio = valor;
			int Final = a - ( valor * 2 );
			BufferedImage imag = imagem.getSubimage( inicio, inicio, Final, Final );

			Image menor = imag.getScaledInstance( l, a, 10 );

			byte[] pngbytes;

			PngEncoder png = new PngEncoder( menor );
			try {
				FileOutputStream outfile = new FileOutputStream( nomeArquivo );
				pngbytes = png.pngEncode();
				outfile.write( pngbytes );
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		} else {
			// se nao existe nenhuma linha em branco em torno da imagem n„o altera nada
		}
	}


	public static void Ajusta( String caminho ) throws IOException {
		AjustaImg a = new AjustaImg();
		a.AjusteFinal( a.AjustaImagem( a.lerEntrada( caminho ) ), caminho );
	}


	public static void main( String args[] ) throws IOException {
		String caminho = "teste.png";
		AjustaImg.Ajusta( caminho );
	}
}
