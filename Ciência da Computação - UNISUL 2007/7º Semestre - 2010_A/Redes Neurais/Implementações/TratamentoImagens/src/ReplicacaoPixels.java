import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Ampliando uma imagem através da replicação de pixels.
 * @author Fabio Dela Bruna
 */
public class ReplicacaoPixels {

	public static void main( String[] args ) {

		BufferedImage image = null;
		
		try {
			image = ImageIO.read( new File( "img/imgpb1.png" ) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Antes: %dx%d\n", image.getWidth(), image.getHeight() );
		image = enlarge( image, 2 );
		System.out.printf("Depois: %dx%d\n", image.getWidth(), image.getHeight() );
		
	}
	

	/**
	 * O método Java apresentado abaixo, recebe como parâmetro um objeto BufferedImage object e retorna essa imagem ampliada n vezes.
	 * Para ampliar uma imagem através de um inteiro (n), nós tornamos um pixel de entrada em um bloco n x n deste mesmo pixel na imagem de saída.
	 */
	public static BufferedImage enlarge( BufferedImage image, int n ) {

		int w = n * image.getWidth();
		int h = n * image.getHeight();

		BufferedImage enlargedImage =
				new BufferedImage( w, h, image.getType() );

		for ( int y = 0; y < h; ++y )
			for ( int x = 0; x < w; ++x )
				enlargedImage.setRGB( x, y, image.getRGB( x / n, y / n ) );

		return enlargedImage;
	}

}
