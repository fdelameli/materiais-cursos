import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ExcecaoVerificada1 {

	public static void main(String[] args) {
		try {
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Digite uma palavra: ");
			String palavra = console.readLine();
			System.out.println("Você digitou " + palavra);
		} catch (IOException ioe) {
			//aqui deve ser feito o tratamento
		}
	}
}
