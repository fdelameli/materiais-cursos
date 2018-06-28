/**
 * Classe Principal para testar se a implementação de LinkedQueue está correta.
 * @author Fabio Dela Bruna, Marcio Ozório.
 * @since 28/03/2008.
 */
public class PrincipalNode {


	public static void main(String[] args) {

		LinkedQueue a = new LinkedQueue();
		System.out.println("_______________________________");
		System.out.println();
		System.out.println("Elementos Inseridos:");
		a.enqueue("A");
		a.enqueue("B");
		a.enqueue("C");
		a.showElements();
		System.out.println();
		System.out.println("Tamanho da Fila:");
		System.out.println(a.getSize());
		System.out.println("_______________________________");
		System.out.println();
		
		Object temp = a.dequeue();
		System.out.println("Primeiro Elemento Removido:");
		System.out.println(temp);
		System.out.println();
		System.out.println("Elementos que Sobraram:");
		a.showElements();
		System.out.println();
		System.out.println("Tamanho da Fila:");
		System.out.println(a.size());
		System.out.println("_______________________________");
		System.out.println();
		
		Object PrimeiroFila = a.front();
		System.out.println("Primeiro Elemento da Fila:");
		System.out.println(PrimeiroFila);
		System.out.println("_______________________________");
		
		System.exit(0);

	}

}
