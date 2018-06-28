public class StackTest {
    
    public static void main(String[] args) {

    	ArrayStack as = new ArrayStack();
    	
    	System.out.println(".:UTILIZANDO ARRAY:.");
    	System.out.println();
    	
    	as.push("A");
    	as.push("B");
    	as.push("C");
    	as.push("D");
    	as.push("E");
    	System.out.println(".:Depois de inserir:.");
    	as.showElements();
    	System.out.println("Tamanho da pilha: " + as.size());
    	System.out.println("Elemento 'top': " + as.top());
    	System.out.println("______________________________________");
    	System.out.println();
    	
    	as.pop();
    	System.out.println(".:Depois de remover:.");
    	as.showElements();
    	System.out.println("Tamanho da pilha: " + as.size());
    	System.out.println("Elemento 'top': " + as.top());
    	System.out.println();
    	
    	System.out.println("______________________________________");
    	System.out.println();
    	System.out.println();
   	
    	System.out.println(".:UTILIZANDO NODE:.");
    	System.out.println();
    	
    	
    	ArrayStack ls = new ArrayStack();
    	
    	ls.push("A");
    	ls.push("B");
    	ls.push("C");
    	ls.push("D");
    	ls.push("E");
    	System.out.println(".:Depois de inserir:.");
    	ls.showElements();
    	System.out.println("Tamanho da pilha: " + ls.size());
    	System.out.println("Elemento 'top': " + ls.top());
    	System.out.println("______________________________________");
    	System.out.println();
    	
    	ls.pop();
    	System.out.println(".:Depois de remover:.");
    	ls.showElements();
    	System.out.println("Tamanho da pilha: " + ls.size());
    	System.out.println("Elemento 'top': " + ls.top());
    	System.out.println("______________________________________");
    	System.out.println();
    	
    	System.exit(0);
    }
}