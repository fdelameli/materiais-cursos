
public class Node {

	private Object element; //Elemento a ser armazenado
	private Node next; //Ponteiro para o próximo elemento
	
	public Node(){
		this(null,null);
	}
	
	public Node(Object element, Node next){
		this.element = element;
		this.next = next;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
}
