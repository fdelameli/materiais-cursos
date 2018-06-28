import java.io.*;

public class ArquivoTextoSaida {
    
    public static void main(String[] args) {
        
        File file = new File("arquivo2.txt");
		System.out.println("Tamanho Inicial: " + file.length());
    	try {
            FileWriter writer = new FileWriter(file);
            PrintWriter output = new PrintWriter(writer);
            output.println("Unisul");
            output.println("Curso Sequencial");
            output.println("Tópicos Especiais I");
            output.println(10);
            output.flush();
            writer.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        System.out.println("Tamanho Final: " + file.length());
    }
}