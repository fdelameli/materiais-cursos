import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;


public class ExemploLeitura {

	public static void main(String[] args) {
		
		File file = new File( "/Users/Public/TXTs/Luk.txt" );
		
		try {
			
			FileReader reader = new FileReader(file);
			BufferedReader input = new BufferedReader(reader);
			String line = "";
			long qtdCaracteres = 0;
			int qtdLinhas = 0;
			int qtdPalavras = 0;
			
			while ((line = input.readLine()) != null) {
				qtdLinhas ++;
				qtdCaracteres += line.length();
				StringTokenizer tokens = new StringTokenizer(line);
				qtdPalavras += tokens.countTokens();
			}

			System.out.println("Linhas: " + qtdLinhas);
			System.out.println("Palavras: " + qtdPalavras);
			System.out.println("Caracteres: " + qtdCaracteres);
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("Arquivo não encontrado!");
			System.out.println(fnfe);
		} catch (IOException ioe) {
			System.out.println("Erro de leitura!");
			System.out.println(ioe);
		}
		
	}
	
	
		private static File getFile() {
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
