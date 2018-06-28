package serializacao;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ArquivoObjetoEntrada {

	public static void main(String[] args) {
		
		File file = new File ("arquivo.ser");
		
		try {
			
			ObjectInputStream input = new ObjectInputStream( new FileInputStream(file));
			
			Atleta atleta1 = (Atleta) input.readObject();
			System.out.println(atleta1);
			
			Atleta atleta2 = (Atleta) input.readObject();
			System.out.println(atleta2);
			
			String curso = (String) input.readObject();
			System.out.println(curso);
			
			Atleta[] atletas = (Atleta[]) input.readObject();
			System.out.println(atletas[0]);
			System.out.println(atletas[1]);
			
			System.out.println(atleta1 == atletas[0]);
			
			input.close();
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Arquivo não encontrado");
		} catch (EOFException eofe) {
			System.out.println("Final do arquivo");
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
}
