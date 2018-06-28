import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoTextoCaracterEntrada {
	
	public static void main (String[] agrs) {
		
		File file = new File("arquivo.txt");
		try {
			FileReader reader = new FileReader(file);
			int next = reader.read();
			while (next != -1) {
				char c = (char) next;
				System.out.println(next + ": " + c);
				next = reader.read();
			}
			reader.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		
		System.out.println( "\nTamanho do Arquivo: " + file.length() );
	}
}