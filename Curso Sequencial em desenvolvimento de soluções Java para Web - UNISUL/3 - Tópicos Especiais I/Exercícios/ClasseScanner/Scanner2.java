import java.util.Scanner;
import java.io.*;

public class Scanner2 {

	public static void main(String[] args) {
		
		FileInputStream input = null;
		PrintStream output = null;
		
		try {
			input = new FileInputStream (new File("arquivo.dat"));
			output = new PrintStream (new File("arquivoSaida.dat"));
		} catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		
		System.setIn(input);
		System.setOut(output);
		
		Scanner scanner = new Scanner(System.in);
		String nome = scanner.next();
		int idade = scanner.nextInt();
		double altura = scanner.nextDouble();
		
		System.out.println(nome + " - " + idade + " - " + altura); 
	}
}