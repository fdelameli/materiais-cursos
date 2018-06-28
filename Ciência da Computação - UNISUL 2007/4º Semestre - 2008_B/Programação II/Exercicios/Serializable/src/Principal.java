import java.io.*;



public class Principal {

	public static void main(String[] args) {
		
		Carteira carteira = new Carteira();
		
		Moeda moeda10 = new Moeda(0.10, "Dez centavos");
		Moeda moeda25 = new Moeda(0.25, "Vinte e cinco centavos");
		Moeda moeda50 = new Moeda(0.50, "Cinqüenta centavos");
		
		carteira.getMoedas().add(moeda10);
		carteira.getMoedas().add(moeda25);
		carteira.getMoedas().add(moeda50);
		
		
		File file = new File("arquivo.dat");
		ObjectOutputStream output = null;
		
		try {
			
			output = new ObjectOutputStream( new FileOutputStream(file));
			
			output.writeObject(carteira);
			output.flush();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro na gravação dos objetos");
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				System.out.println("Erro ao fechar arquivo");
				e.printStackTrace();
			}
		}
		
		
		
		
		ObjectInputStream input = null;
		
		try {
			
			input = new ObjectInputStream( new FileInputStream(file));
			
			Carteira aux = (Carteira) input.readObject();
			
			System.out.println("Saldo da carteira: " + aux.saldoCarteira());
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
			e.printStackTrace();		
		} catch (IOException e) {
			System.out.println("Erro na leitura dos objetos");
			e.printStackTrace();			
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada");
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				System.out.println("Erro ao fechar arquivo");
				e.printStackTrace();
			}
			
		}
		
		
	}
}
