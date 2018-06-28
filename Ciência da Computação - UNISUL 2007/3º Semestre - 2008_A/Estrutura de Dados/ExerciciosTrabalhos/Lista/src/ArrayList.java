public class ArrayList implements List {

	private Object[] elements; // vector that will contains the elements
	private int last; // Position of the last element
	private final int RESIZE_VALUE = 5; // Number of additional indexes to add
										// in the vector

	public ArrayList() {
		this.elements = new Object[5];
		this.last = -1;
	}
	
	public ArrayList(int initialSize) {
		this.elements = new Object[initialSize];
		this.last = -1;
	}

	public Object elementAt(int position) throws InvalidPositionException { // Constante
		checkInvalidPositionException(position);
		return this.elements[position];
	}

	public int findElement(Object element) { // Linear
		for (int i = 0; i < size(); i++) {
			if (this.elements[i].equals(element))
				return i;
		}
		return -1;
	}

	public Object first() throws EmptyListException { // Constante
		checkEmptyListException();
		return this.elements[0];
	}

	public void insertAt(Object element, int position)
			throws InvalidPositionException, FullListException { // Linear
		tryIncreaseVector();
		checkInvalidPositionException(position);
		for (int i = 0; i < this.last - position + 1; i++) {
			this.elements[this.last - i + 1] = this.elements[this.last - i];
		}
		this.elements[position] = element;
		this.last++;
	}

	public void insertFirst(Object element) throws FullListException {
		tryIncreaseVector();
		for (int i = 0; i < this.last + 1; i++) {
			this.elements[this.last - i + 1] = this.elements[this.last - i];
		}
		this.elements[0] = element;
		this.last++;
	}

	public void insertLast(Object element) throws FullListException { // Constante
		tryIncreaseVector();
		this.last++;
		this.elements[this.last] = element;
	}

	public boolean isEmpty() {
		return this.last == -1;
	}

	public boolean isFull() {
		return this.elements.length - 1 == this.last;
	}

	public Object last() throws EmptyListException { // Constante
		checkEmptyListException();
		return this.elements[this.last];
	}

	public void remove(Object element) { // Linear
		for (int i = 0; i < size(); i++) {
			if (this.elements[i].equals(element))
				removeAt(i);
		}
	}

	public void removeAt(int position) throws InvalidPositionException { // Linear
		checkInvalidPositionException(position);
		for (int i = 0; i < this.last - position; i++) {
			this.elements[position + i] = this.elements[position + i + 1];
		}
		this.elements[this.last] = null;
		this.last--;
	}

	public void removeFirst() throws EmptyListException { // Linear
		checkEmptyListException();
		for (int i = 0; i < this.last; i++) {
			this.elements[i] = this.elements[i + 1];
		}

	}

	public void removeLast() throws EmptyListException { // Constante
		checkEmptyListException();
		this.elements[this.last] = null;
	}

	public int size() { // Constante
		return this.last + 1;
	}

	public String toString() {
		String msg = "";
		for (int i = 0; i < this.elements.length; i++) {
			msg += "[" + (this.elements[i] == null ? " " : this.elements[i])
					+ "]";
		}
		return msg;
	}

	private void checkEmptyListException() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("List is empty!");
	}

	@SuppressWarnings("unused")
	private void checkFullListException() throws EmptyListException {
		if (isFull())
			throw new FullListException("List is full!");
	}

	private void checkInvalidPositionException(int position)
			throws EmptyListException {
		if (position < 0 || position > this.last)
			throw new InvalidPositionException("Invalid position!");
	}
	
	private void tryIncreaseVector(){
		if(isFull()){
			Object[] aux = new Object[this.elements.length + this.RESIZE_VALUE];
			for(int i = 0; i < this.elements.length; i++){
				aux[i] = this.elements[i];
			}
			this.elements = aux;
		}
	}
}
