import java.util.Scanner;

public class lerNumeros {
	public static void main(String[] args) {
		
		int n1, n2, n3;

		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite numero: ");
		n1 = entrada.nextInt();
		System.out.println("Digite numero: ");
		n2 = entrada.nextInt();
		System.out.println("Digite numero: ");
		n3 = entrada.nextInt();

		System.out.println("Os números digitados foram: ");
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
	}

}
