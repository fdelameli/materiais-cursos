import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Pixels {

/*	public static void main( String[] args ) throws IOException {

		BufferedImage image = ImageIO.read( new File( "img/imgpb1.png" ) );

		int width = image.getWidth();
		int height = image.getHeight();
		int nbands = image.getSampleModel().getNumBands();

		Raster inputRaster = image.getData();
		int[] pixels = new int[ nbands * width * height ];
		inputRaster.getPixels( 0, 0, width, height, pixels );

		for ( int h = 0; h < height; h++ )

			for ( int w = 0; w < width; w++ ) {

				int offset = h * width * nbands + w * nbands;

				System.out.print( "at (" + w + "," + h + "): " );

				for ( int band = 0; band < nbands; band++ )

					System.out.print( pixels[ offset + band ] + " " );

			}

	}*/
	

	public static void main( String[] args ) throws IOException {

		BufferedImage image = ImageIO.read( new File( "teste.png" ) );
		String myImageTest = "";
		
		int width = image.getWidth();
		int height = image.getHeight();
		int nbands = image.getSampleModel().getNumBands();

		Raster inputRaster = image.getData();
		int[] pixels = new int[ nbands * width * height ];
		inputRaster.getPixels( 0, 0, width, height, pixels );


		for ( int h = 0; h < height; h++ ) {

			for ( int w = 0; w < width; w++ ) {

				int rgb = image.getRGB( w, h );

				int r = (int ) ( ( rgb & 0x00FF0000 ) >>> 16 ); // Red level
				int g = (int ) ( ( rgb & 0x0000FF00 ) >>> 8 ); // Green level
				int b = (int ) ( rgb & 0x000000FF ); // Blue level

//				System.out.print( "at (" + w + "," + h + "): " );
//				System.out.println( r + "," + g + "," + b );

				if ( r == 255 && g == 255 && b == 255 )
					myImageTest += "#";

				else /*( r == 0 && g == 0 && b == 0 )*/
					myImageTest += "*";

			}
			
			myImageTest += "\n";
		}
		
		System.out.println(myImageTest);

	}

}
