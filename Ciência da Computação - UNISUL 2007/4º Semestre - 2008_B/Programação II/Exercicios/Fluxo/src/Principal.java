import java.io.*;


public class Principal {

	public static void main(String[] args) {
		
		File file = new File("arquivo.dat");
		
		try {
			
			FileOutputStream output = new FileOutputStream(file);
			String nome = "Fabio";
			
			output.write(15);
			output.write(18);
			output.write(28);
			output.write(25);
			
			output.write(nome.getBytes());
			
			output.close();
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("Arquivo não encontrado!");
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("Erro de de gravação!");
			ioe.printStackTrace();
		} finally {
			
		}
		
		
		
		try {
			FileInputStream input = new FileInputStream(file);
			
			int b = input.read();
			
			while (b != -1) {
				System.out.println(b);
				b = input.read();
			}
			
			input.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("Erro de leitura!");
			ioe.printStackTrace();
		} finally {

		}
	}
}
