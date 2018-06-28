package mlp.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Classe utilizada para ajustar os caracteres que n„o estejam centralizados.
 * 
 */
public class AjustaCaract {

	/**
	 * LÍ imagem e retorna uma matriz binaria 0,1
	 */
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
		return img;
	}


	/**
	 * MÈtodo utilizado para verificar se existe contorno branco em volta da imagem.
	 * @param img Matriz bin·ria da imagem.
	 */
	public int[] AjustaImagem( int img[][] ) {

		int somalados[] = { 0, 0, 0, 0 };
		int contalados[] = { 0, 0, 0, 0 };
		int cont = 0;
		int diminui = 1;
		int contin = 0;

		while ( contin == 0 ) {

			// verifica a coluna da esquerda
			for ( int ce = 0; ce <= ( img.length - 1 ); ce++ ) {
				somalados[ 0 ] += img[ ce ][ cont ];
			}
			if ( somalados[ 0 ] == 0 ) {
				contalados[ 0 ] += 1;
			}

			// verifica a linha superior
			for ( int ls = 0; ls <= ( img[ 0 ].length - 1 ); ls++ ) {
				somalados[ 1 ] += img[ cont ][ ls ];
			}
			if ( somalados[ 1 ] == 0 ) {
				contalados[ 1 ] += 1;
			}

			// verifica a coluna da direita
			for ( int cl = 0; cl <= ( img.length - 1 ); cl++ ) {
				somalados[ 2 ] += img[ cl ][ ( img.length - diminui ) ];
			}
			if ( somalados[ 2 ] == 0 ) {
				contalados[ 2 ] += 1;
			}

			// verifica a linha inferior
			for ( int li = 0; li <= ( img[ 0 ].length - 1 ); li++ ) {
				somalados[ 3 ] += img[ ( img[ 0 ].length - diminui ) ][ li ];
			}
			if ( somalados[ 3 ] == 0 ) {
				contalados[ 3 ] += 1;
			}

			if ( somalados[ 0 ] > 0 && somalados[ 1 ] > 0 && somalados[ 2 ] > 0 && somalados[ 3 ] > 0 ) {
				contin = 1;
			}

			cont += 1;
			diminui += 1;
		}

		return contalados;
	}


	/**
	 * Limpa borda vazia da imagem e altera e ajusta ao tamanho anterior.
	 * @param contalados
	 * @param nomeArquivo
	 * @throws IOException
	 */
	public void AjusteFinal( int contalados[], String nomeArquivo ) throws IOException {


		BufferedImage imagem = ImageIO.read( new File( nomeArquivo ) );
		int a = imagem.getWidth();
		int l = imagem.getHeight();

		int cordenadas[] = { 0, 0, 0, 0 };

		// ajusta a area de corte
		cordenadas[ 0 ] = contalados[ 0 ];
		cordenadas[ 1 ] = contalados[ 1 ];
		cordenadas[ 2 ] = ( a - contalados[ 2 ] ) - contalados[ 0 ];
		cordenadas[ 3 ] = ( l - contalados[ 3 ] ) - contalados[ 1 ];

		for ( int i = 2; i < 4; i++ ) {
			if ( cordenadas[ i ] == imagem.getHeight() ) {
				cordenadas[ i ]--;
			}
		}

		BufferedImage imag = imagem.getSubimage( cordenadas[ 0 ], cordenadas[ 1 ], cordenadas[ 2 ], cordenadas[ 3 ] );
		BufferedImage C = new BufferedImage( l, a, BufferedImage.TYPE_BYTE_BINARY );


		// encontra cordenadas para centralizas a imagem cortada acima
		int a2 = ( a - imag.getHeight() ) / 2;
		int l2 = ( l - imag.getWidth() ) / 2;

		Graphics g = C.createGraphics();
		g.setColor( Color.white );
		g.fillRect( 0, 0, l, a );
		g.drawImage( imag, l2, a2, null );
		g.dispose();

		Image menor = C.getScaledInstance( l, a, 10 );

		byte[] pngbytes;
		PngEncoder png = new PngEncoder( menor );
		try {
			FileOutputStream outfile = new FileOutputStream( nomeArquivo );
			pngbytes = png.pngEncode();
			outfile.write( pngbytes );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public static void Ajusta( String caminho ) throws IOException {
		AjustaCaract c = new AjustaCaract();
		c.AjusteFinal( c.AjustaImagem( c.lerEntrada( caminho ) ), caminho );
	}

	
	
	public static void main( String args[] ) throws IOException {
		AjustaCaract u = new AjustaCaract();
		String caminho = "teste.png";
		u.AjusteFinal( u.AjustaImagem( u.lerEntrada( caminho ) ), caminho );
		u.AjustaImagem( u.lerEntrada( caminho ) );
	}

}
