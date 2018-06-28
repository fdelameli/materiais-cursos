package exercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;

public class Exercicio1 {

	public static void main(String[] args) {

		File arquivoOrigem = getArquivo();
		File arquivoDestino = new File( "ArquivoDestino_Exercicio1" );
	
		try {
			FileReader reader = new FileReader( arquivoOrigem );
			BufferedReader input = new BufferedReader( reader );

			FileWriter writer = new FileWriter( arquivoDestino );
			PrintWriter output = new PrintWriter(writer);

			String line = "";

			while ( ( line = input.readLine() ) != null ) {
				output.println( line );
			}
			
			output.flush();
			writer.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		
		System.out.println("Arquivo Copiado!");
	}


	public static File getArquivo() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
		File file = null;

		if (chooser.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
			file = chooser.getSelectedFile();
			return file;
		}
		return null;
	}
}
