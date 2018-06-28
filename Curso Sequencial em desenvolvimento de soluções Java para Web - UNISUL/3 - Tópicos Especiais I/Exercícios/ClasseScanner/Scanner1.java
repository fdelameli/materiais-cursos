import java.util.Scanner;

public class Scanner1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Idade: ");
		int idade = scanner.nextInt();
		System.out.print("Altura: ");
		double altura = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Rua: ");
		String rua = scanner.nextLine();
		
		System.out.println(nome + " - " + idade + " - " + altura + "\n" + rua);
	}
}
