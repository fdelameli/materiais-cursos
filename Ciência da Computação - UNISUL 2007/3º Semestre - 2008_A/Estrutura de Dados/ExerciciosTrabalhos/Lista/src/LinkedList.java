public class LinkedList implements List {

	private Node head; // Primeiro elemento da lista
	private Node tail; // Ultimo elemento da lista
	private int size; // Tamanho da lista

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public Object elementAt(int position) throws InvalidPositionException {
		Node temp = this.head;
		for (int i = 0; i <= position; i++) {
			temp = temp.getNext();
		}
		return temp;
	}

	public int findElement(Object element) {
		Node temp = this.head;
		int position = 0;
		while (temp != null) {
			if (temp.getElement().equals(element))
				return position;
			temp = temp.getNext();
			position++;
		}
		return -1;
	}

	public Object first() throws EmptyListException { // constante
		if (isEmpty())
			throw new EmptyListException("A lista está vazia");
		return this.head.getElement();
	}

	public void insertAt(Object element, int position) //linear
			throws InvalidPositionException, FullListException {
		if(position < 0 || position > (size))
			throw new InvalidPositionException("Posição inválida.");
		if(position == 0){
			insertFirst(element);
		}
		else{
			Node newNode = new Node(element,null);
			Node temp = head;
			int count = 0;
			while(count < position - 1){
				count++;
				temp = temp.getNext();				
			}
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
			size++;
		}

	}

	public void insertFirst(Object element) throws FullListException { // constante
		Node newNode = new Node(element, this.head);
		this.head = newNode;
		if (size == 0)
			this.tail = newNode;
		this.size++;
	}

	public void insertLast(Object element) throws FullListException { // constante
		Node newNode = new Node(element, null);
		if (tail != null)
			this.tail.setNext(newNode);
		else
			this.head = newNode;
		this.tail = newNode;
		this.size++;
	}

	public boolean isEmpty() { // constante
		return this.head == null;
	}

	public Object last() throws EmptyListException { //constante
		if (isEmpty())
			throw new EmptyListException("A lista está vazia!");
		return this.tail.getElement();
	}

	public void remove(Object element) {

	}

	public void removeAt(int position) throws InvalidPositionException {

	}

	public void removeFirst() throws EmptyListException { // constante
		if (isEmpty())
			throw new EmptyListException("A lista está vazia");
		this.head = this.head.getNext();
		size--;
		if (size == 0)
			tail = null;
	}

	public void removeLast() throws EmptyListException { // linear
		if (isEmpty())
			throw new EmptyListException("A lista está vazia");
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			Node temp1 = head;
			Node temp2 = head.getNext();
			while (temp2.getNext() != null) {
				temp1 = temp2;
				temp2 = temp2.getNext();
			}
			temp1.setNext(null);
			tail = temp1;
		}
		size--;
	}

	public int size() { // constante
		return this.size;
	}

}
