import java.io.*;

public class ArquivoTextoCaracterSaida {
	
	public static void main(String[] args) {
		
		File file = new File("arquivo.txt");
		System.out.println("Tamanho Inicial: " + file.length());
		try {
			FileWriter writer = new FileWriter(file);
			writer.write('S');
			writer.write('e');
			writer.write('q');
			writer.write('u');
			writer.write(101);
			writer.write(110);
			writer.write('\n');
			writer.write('c');
			writer.write('i');
			writer.write('a');
			writer.write('l');
			writer.flush();
			writer.close();
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.println("Tamanho Final: " + file.length());
	}
}