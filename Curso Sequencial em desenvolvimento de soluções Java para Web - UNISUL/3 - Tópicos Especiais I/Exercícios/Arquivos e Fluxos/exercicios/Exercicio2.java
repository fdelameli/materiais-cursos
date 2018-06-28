package exercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;

public class Exercicio2 {

	public static void main(String[] args) {

		File file = getArquivo();

		try {
			
			FileReader reader = new FileReader(file);
			BufferedReader input = new BufferedReader(reader);

			int qtdLinhas = 0;
			int qtdPalavras = 0;
			int qtdCaracteres = 0;
			String line = "";

			while ((line = input.readLine()) != null) {
				
				qtdLinhas ++;
				StringTokenizer tokens = new StringTokenizer(line);
				qtdPalavras += tokens.countTokens();
				
				while(tokens.hasMoreTokens()) {
					String temp = tokens.nextToken();
					qtdCaracteres += temp.length();
				}
			}
			
			input.close();
			
			System.out.println("Linhas: " + qtdLinhas);
			System.out.println("Palavras: " + qtdPalavras);
			System.out.println("Caracteres: " + qtdCaracteres);
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("Arquivo não encontrado!");
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

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
