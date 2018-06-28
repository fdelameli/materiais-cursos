import java.io.*;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;


public class ExemploEscrita {
	
	public static void main(String[] args) {
		

		leTXT();

		
		
//		escreveTXT();
		
	}
	
	
	
	
	/**
	 * Método para escrever em arquivo.
	 */
	private static void escreveTXT( String line ) {
		File file = new File ("/txt/arquivoTESTE.txt");
		
		try {
			
			FileWriter writer = new FileWriter(file, true);
			BufferedWriter output = new BufferedWriter(writer);
			
//			for (int i = 0; i < 5; i++) {
//				output.write("Teste " + i+1);
//				output.newLine();
//			}
			
			output.write(line);
			output.newLine();
			
			output.flush();
			output.close();
			
		} catch (IOException ioe) {
			System.out.println("Erro de gravação!");
		}
	}


	/**
	 * Método para ler um arquivo.
	 */
	private static void leTXT() {
		
		File file = getFile();

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
				escreveTXT(line);
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
		System.out.println("Executado com Secesso!");
	}

	
	/**
	 * Método para escolher um arquivo específico.
	 * @return Arquivo escolhido.
	 */
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
