package serializacao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class ArquivoObjetoSaida {

	public static void main(String[] args) {
		
		File file = new File("arquivo.ser");
		
		System.out.println("Tamanho Inicial: " + file.length());
		
		try {
			
			ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream( file));
			
			Atleta atleta1 = new Atleta (1, "Pedro", 1.58);
			Atleta atleta2 = new Atleta (2, "ANA", 1.36);
			
			output.writeObject(atleta1);
			output.writeObject(atleta2);
			
			output.writeObject( new String("Sequencial JAVA"));
			
			Atleta[] atletas = new Atleta[2];
			atletas[0] = atleta1;
			atletas[1] = atleta2;
			
			output.writeObject(atletas);
			
			output.flush();
			output.close();
			
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		
		System.out.println("Tamanho Final: " + file.length());
	}
}
