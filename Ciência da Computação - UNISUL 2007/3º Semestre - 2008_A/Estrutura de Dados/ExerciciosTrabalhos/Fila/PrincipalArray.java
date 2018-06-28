/**
 * Classe Principal para testar se a implementação de LinkedQueue está correta.
 * 
 * @author Fabio Dela Bruna, Marcio Ozório.
 * @since 28/03/2008.
 */
public class PrincipalArray {

	
	public static void main(String[] args) {	
		
		ArrayQueue a = new ArrayQueue();
		
		
		a.enqueue("A");
		a.enqueue("B");
		a.enqueue("C");
		a.enqueue("D");
		a.enqueue("E");
		System.out.println("elementos inseridos");
		a.showElements();
		
		System.out.println();
		
		Object temp = a.dequeue();
		System.out.println("Elemento removido " + temp);
		System.out.println("Elementos que restaram");
		a.showElements();
		
		
		a.enqueue("F");
		
		System.out.println();
		System.out.println("inserido F");
		System.out.println("elementos:");
		a.showElements();
		Object aux = a.front();
		System.out.println("Primeiro elemento: " + aux);
		
		a.dequeue();
		a.dequeue();
		
		System.out.println();
		System.out.println("removido os dois primeiros elementos");
		a.showElements();
		
		a.enqueue("G");
		System.out.println();
		System.out.println("inserido G");
		System.out.println("elementos:");
		a.showElements();
		
		aux = a.front();
		System.out.println();
		System.out.println("Primeiro elemento: " + aux);

	}

}
