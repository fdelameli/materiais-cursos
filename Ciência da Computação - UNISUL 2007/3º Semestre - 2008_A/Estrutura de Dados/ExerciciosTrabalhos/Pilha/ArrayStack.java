public class ArrayStack implements Stack {

	public static final int CAPACITY = 5;
	private int capacity;
	private Object elements[];
	private int top;

	public ArrayStack() {
		this(CAPACITY);
	}

	public ArrayStack(int cap) {
		this.capacity = cap;
		this.elements = new Object[capacity];
		this.top = -1;
	}

	public int size() {
		return (top + 1);
	}

	public boolean isEmpty() {
		return (top < 0);
	}

	
	public void push(Object obj) throws FullStackException {
		if(size() == this.elements.length)
			throw new FullStackException("A PILHA ESTÁ CHEIA!");
//		if(isEmpty())
//			this.elements[0] = obj;
		this.elements[this.top + 1] = obj;
		this.top++;
	}

	
	public Object top() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException("A PILHA ESTÁ VAZIA!");
		
		return this.elements[this.top];
	}
	

	public Object pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException("A PILHA ESTÁ VAZIA!");
		
		Object temp = this.elements[this.top];
		this.top--;
		return temp;
	}
	
	
	public void showElements(){
		for (int i = 0; i < size(); i++){
			System.out.println("\t" + this.elements[i]);
		}
	}
}