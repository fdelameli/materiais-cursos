import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ExececaoVerificada2 {

	public static void main(String[] args) {
		System.out.println("O programa inicia aqui...");
		String filename = null;
		try {
			filename = "C:/fonte/arquivo.txt";
			BufferedReader console = new BufferedReader(new FileReader(filename));
			String input = console.readLine();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Aqui a captura de uma execução...");
			System.out.println("O arquivo <" + filename + "> não foi encontrado");
		} catch (IOException ioe) {
			System.out.println("Erro de entrada e saída");
		}
		System.out.println("O programa continua aqui...");
	}
}	