public class LinkedStack implements Stack {
    
    private Node top;
    private int size;
    
    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }
    
    
    
    public int size() {
        return size;
    }
    
    
    public boolean isEmpty() {
    	return size == 0;
    }
    
    
    public void push(Object element) throws FullStackException {
        Node newNode = new Node(element, this.top);
        this.top = newNode;
        this.size++;
    }
    
    
    public Object top() throws EmptyStackException {
    	if(isEmpty())
    		throw new EmptyStackException("A PILHA ESTÁ VAZIA!");
    	return this.top.getElement();
    }
    
    
    public Object pop() throws EmptyStackException {
    	if(isEmpty())
    		throw new EmptyStackException("A PILHA ESTÁ VAZIA!");
    	Object temp = this.top.getElement();
    	this.size--;
        return temp;
    }
}