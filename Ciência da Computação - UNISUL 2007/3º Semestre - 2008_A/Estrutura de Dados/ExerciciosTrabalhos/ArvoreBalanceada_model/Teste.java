import java.util.Scanner;


public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x = 0;
		AvlTree tree = new AvlTree();
		System.out.println("Para terminar a execução digite -1");
		System.out.print("Informe um numero: ");
		x = input.nextInt();
		do{
			tree.insert(new Inteiro(x));
			System.out.print("Informe um numero: ");
			x = input.nextInt();
		}while(x != -1);
		tree.printTree();
		System.out.println("FindMin: "+tree.findMin());
		System.out.println("FindMax: "+tree.findMax());

		
	}

}
